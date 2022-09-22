package com.upe.dce.api.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Slf4j
public class FilterAuthorization extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    if(request.getServletPath().equals("/api/login") || request.getServletPath().equals("/token/refresh/**")) {
      filterChain.doFilter(request, response);
    } else {
      String authorizationHeader = request.getHeader("Authorization");
      if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
        try{
          String token = authorizationHeader.substring(7);
          Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
          JWTVerifier verifier = JWT.require(algorithm).build();
          DecodedJWT decodedJWT = verifier.verify(token);
          String username = decodedJWT.getSubject();
          String tipo = decodedJWT.getClaim("tipo").asString();
          Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
          authorities.add(new SimpleGrantedAuthority(tipo));
          UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
          SecurityContextHolder.getContext().setAuthentication(authenticationToken);
          filterChain.doFilter(request, response);
        } catch(Exception e) {
          log.error("Error loging in: {}", e.getMessage());
          response.setHeader("WWW-Authenticate", "Bearer realm=\"DCE\"");
          response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }

      }
    }
  }
}
