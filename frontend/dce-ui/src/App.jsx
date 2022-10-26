import './css/styleIndex.css';
import Login from './componentes/login/login'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Cadastrar from './componentes/cadastro/cadastro';
import ResetSenha from './componentes/resetSenha/resetSenha';
import Inicio from './componentes/home/home';
import Perfil from './componentes/perfil/perfil';

function App() {
  return <BrowserRouter>
    <Routes>
    <Route exact path="/"  element={<Login/>} />
    <Route exact path="/Cadastro"  element= {<Cadastrar/>} />
    <Route exact path="/Recuperar"  element= {<ResetSenha/>} />
    <Route exact path="/Inicio"  element= {<Inicio/>} />
    <Route exact path="/Perfil"  element= {<Perfil/>} />

    </Routes>
    </BrowserRouter>   
}


export default App;