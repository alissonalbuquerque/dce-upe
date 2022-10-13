import mostrar from '../imagens/mostrar.png'
import mostrarSenha from '../imagens/mostrarsenha.png'

const senha = document.getElementsByClassName('senha');
const btn = document.getElementsByClassName('btn');


	
		btn.onclick = () =>
		{
			if (senha.type === 'password') 
			{
			senha.type = 'text'
			btn.src = {mostrarSenha}
			}
			else
			{
			senha.type = 'password'
			btn.src= {mostrar}
			}
		}
	