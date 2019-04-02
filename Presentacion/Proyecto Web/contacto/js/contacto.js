'use strict'
let registro, registroSubmit, password1, password2;

function iniciar()
{

registro=document.getElementById("registro");
registroSubmit=document.getElementById("registroSubmit");

password1=document.getElementById("password1");
password2=document.getElementById("password2");

password1.addEventListener("input", comprobarPas, false);
password2.addEventListener("input", comprobarPas, false);

registroSubmit.addEventListener("click", enviarEnviarFormulario, true);
}

function comprobarPas() {
    if (password1.value != password2.value) {
        password2.setCustomValidity("Las contraseñas no coinciden");
        password1.style.background='#F2F5A9';
        password2.style.background='#F2F5A9';
    }else{
        password1.style.background='#9FF781';
        password2.style.background='#9FF781';
        password2.setCustomValidity("");
   }
}

function enviarEnviarFormulario(){
    if(registro.checkValidity()){
       registro.submit();
    }
}

window.addEventListener("load", iniciar, false);
