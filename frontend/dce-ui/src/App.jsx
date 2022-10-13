import './css/styleIndex.css';
import Login from './componentes/login/login'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Cadastrar from './componentes/cadastro/cadastro';

function App() {
  return <BrowserRouter>
    <Routes>
    <Route exact path="/"  element={<Login/>} />
    <Route exact path="/Cadastro"  element= {<Cadastrar/>} />
    </Routes>
    </BrowserRouter>   
}


export default App;