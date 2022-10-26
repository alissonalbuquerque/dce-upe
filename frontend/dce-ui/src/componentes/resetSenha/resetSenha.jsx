import React from 'react';
import userLogin from '../imagens/userlogin.png';
import {Link} from 'react-router-dom';
import homee from '../imagens/homee.png';
import '../resetSenha/resetSenha.css';

function ResetSenha(){
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
    </div>
    return <div className="login_container">
        <form className="dataInputs">
            <h1 className="h3 mb-3 fw-normal">Recuperar Senha</h1>

            <div className="form-floating">
                <input type="email" className="form-control" id="floatingInput" placeholder="Email"/>
            </div>

            <button className="btnLogin" type="submit">Enviar</button>

            <div className="login-links mt-5">
                <Link to="/" className="mx-3" style={{marginLeft: "120px"}}>Voltar</Link>
            </div>
        </form>
    </div>
}

export default ResetSenha;