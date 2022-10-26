import './styleCadastro.css';
import {Link} from 'react-router-dom';
import homee from '../imagens/homee.png';

function Cadastrar() {
    return (
        <div>
        <div className="principal">
                <div className="header_container">

               <div className = "navegacao">
                <ul >
                    <li>
                    <Link to="/" ><img src={homee} width="30px" margin-right="50px"></img>Inicio</Link>                                   
                    </li>
                </ul>
                </div>
                </div>
            

            <div className="cadastro_container">
        	    <h1>Cadastrar Usuário</h1>
        	    <div className="dataInputs"> 
        		    <input type="text" name="nome"  placeholder="Nome de Usuário" className="name"/>
                    
        		    <input type="text" name="email" className="cadastro" placeholder="Cadastrar Email" />
                    
        		    <input type="text" name="password" className="cadastro" placeholder="Nova Senha" />
                    
                    <input type="text" name="password_confirm" className="cadastro" placeholder="Confirmar Senha"/>
    
                    <div className="login-links_mt-3">
                    <Link to="/" className="mx-3">Já tenho uma conta.</Link>
                    </div>

        		    <button className="btnLogin">Cadastrar</button>
        		
        	    </div>

            </div>
            <script src="script/scriptCadastro.js"></script>
        </div>
        </div>
        );
}

export default Cadastrar;