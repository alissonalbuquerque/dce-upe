import './styleLogin.css';
import './scriptLogin';
import userLogin from '../imagens/userlogin.png'
import homee from '../imagens/homee.png'
import mostrarSenha from '../imagens/mostrarsenha.png'

function Login() {
  return (
    <div>
    <div className="principal">
        <div className="header_container">
               <a className="logo"><img src="" width="100px"></img></a>

               <div className = "navegacao">
                <ul >
                    <li>
                    <a href="/" ><img src={homee} width="30px" margin-right="50px"/> Inicio
                        </a>
                    </li>
                    <li>
                        <a href="Cadastro"><img src={userLogin} width="30px" margin-right="50px"/> Registro
                        </a>
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
                <div className="login-links mt-5">
                    <a href="#" className="mx-3">Esqueceu a senha?</a>
                </div>
        		<button className="btnLogin" value="Enviar">Entrar</button>      		
        	</div>
            
        </div>
        <script src="./scriptLogin.js"></script>
    </div>
    </div>
    
  );
}

export default Login;