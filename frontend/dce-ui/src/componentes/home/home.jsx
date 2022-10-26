import './home.css';
import userLogin from '../imagens/userlogin.png';
import {Link} from 'react-router-dom';
import logout from '../imagens/logout.png';

function Inicio() {
  return (
    <div>
    <div className="principal">
        <div className="header_container">

               <div className = "navegacao">
                <ul >     
                    <li>
                        <Link to="/Perfil"><img src={userLogin} width="30px" margin-right="50px"></img>Perfil</Link>
                    </li>
                </ul>
            </div>
        </div>
        

        <div className="login_container">	
        <h1>Listagem de ocorrências</h1>	
        	</div>
            
        </div>
        <script src="./scriptLogin.js"></script>
    </div>  
  );
}

export default Inicio;