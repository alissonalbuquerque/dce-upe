import './perfil.css';
import userLogin from '../imagens/userlogin.png';
import {Link} from 'react-router-dom';
import logout from '../imagens/logout.png';
import homee from '../imagens/homee.png';

function Perfil() {
  return (
    <div>
    <div className="principal">
        <div className="header_container">

               <div className = "navegacao">
                <ul >   
                    <li>
                        <Link to="/Inicio" ><img src={homee} width="30px" margin-right="50px"></img>Inicio</Link>  
                    </li>
                    <li>
                        <Link to="/"><img src={logout} width="30px" margin-right="50px" className = "imgLogout"></img>Sair</Link>
                    </li>
                </ul>
            </div>
        </div>
        

        <div className="cadastro_container">
        	    <h1>Perfil</h1>
        	    <div className="dataInputs"> 
                    <label for="name">Nome: </label>
        		    <input type="text" name="nome"  placeholder="" className="name"/>
                    
        		    <input type="text" name="email" className="cadastro" placeholder="Cadastrar Email" />
                    
        		    <input type="text" name="password" className="cadastro" placeholder="Nova Senha" />
                    
                    <input type="text" name="password_confirm" className="cadastro" placeholder="Confirmar Senha"/>
           
        		    <button className="btnLogin">Editar</button>
        		
        	    </div>

            </div>
            <script src="script/scriptCadastro.js"></script>
        </div>
        </div>
        );}

export default Perfil;