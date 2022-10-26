import './styleLogin.css';
import './scriptLogin';
import userLogin from '../imagens/userlogin.png';
import {Link} from 'react-router-dom';
import homee from '../imagens/homee.png';
import mostrarSenha from '../imagens/mostrarsenha.png';

function Login() {
  return (
    <div>
    <div className="principal">
        <div className="header_container">

               <div className = "navegacao">
                <ul >
                    <li>
                    <Link to="/" ><img src={homee} width="30px" margin-right="50px"></img>Inicio</Link>              
                    </li>
                    <li>
                        <Link to="Cadastro"><img src={userLogin} width="30px" margin-right="50px"></img>Registro</Link>
                    </li>
                </ul>
            </div>
        </div>
        

        <div className="login_container">
        	<h1>Login</h1>
        	<div className="dataInputs"> 
        		<input type="text" name="email"  placeholder="Email" className="email"></input>
                <div className="row">
        		<input type="password" name="password"  placeholder="Senha" className="senha"></input>
                <img src={mostrarSenha} alt= "" className="btn" type="button" width="20px"/>            
                </div>
                <div className="login-links_mt-3">
                    <Link to="Recuperar" className="mx-1">Esqueceu a senha?</Link>
                    <Link to="Cadastro" style={{marginLeft: "100px"}} className="mx-2">Criar conta</Link>
                </div>
                <Link to="/Inicio">
        		<button className="btnLogin" value="Enviar">Entrar</button>
                </Link>      		
        	</div>
            
        </div>
        <script src="./scriptLogin.js"></script>
    </div>
    </div>
    
  );
}

export default Login;