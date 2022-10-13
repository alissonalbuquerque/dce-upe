import './styleCadastro.css'
import homee from '../imagens/homee.png'

function Cadastrar() {
    return (
        <div>
        <div className="principal">
                <div className="header_container">
               <a className="logo"><img src="imagens/upe-logo.png" width="100px"/></a>

               <div className = "navegacao">
                <ul >
                    <li>
                    <a href="/"> <img src={homee} width="30px" margin-right="50px"/> Inicio
                        </a>
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
    
        		    <button className="btnCadastrar">Cadastrar</button>
        		
        	    </div>

            </div>
            <script src="script/scriptCadastro.js"></script>
        </div>
        </div>
        );
}

export default Cadastrar;