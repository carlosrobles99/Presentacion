'use strict';

let maximo=700;
let medio ,barra, progreso, reiniciar, retrasar, play, adelantar, silenciar, volumenMenos, volumenMas;

function iniciar(){
medio=document.getElementById('medio');
barra=document.getElementById('barra');
progreso=document.getElementById('progreso');
reiniciar=document.getElementById('reiniciar');
retrasar=document.getElementById('retrasar');
play=document.getElementById('play');
adelantar=document.getElementById('adelantar');
silenciar=document.getElementById('silenciar');
volumenMenos=document.getElementById('volumenMenos');
volumenMas=document.getElementById('volumenMas');

play.addEventListener('click', accionPlay, false);
barra.addEventListener('click', redimensionaBarra, false);
reiniciar.addEventListener('click', reiniciando, false);
retrasar.addEventListener('click', retrasando, false);
adelantar.addEventListener('click', adelanto, false);
silenciar.addEventListener('click', silenciando, false);
volumenMenos.addEventListener('click', menosVolumen, false);
volumenMas.addEventListener('click', masVolumen, false);

}

function masVolumen()
{
	medio.volume = medio.volume + 0.1;
}

function menosVolumen()
{
	medio.volume = medio.volume - 0.1;
}

function silenciando()
{
	medio.muted = true;
}

function reiniciando()
{
	medio.currentTime = 0;
	medio.muted = false;
}

function retrasando()
{
	medio.currentTime = medio.currentTime - 5;
}

function adelanto()
{
	medio.currentTime = medio.currentTime + 5;
}

function accionPlay()
{
if(!medio.paused && !medio.ended)
{
medio.pause();
play.innerHTML = '\u25BA';
window.clearInterval(bucle);
}
else
{
medio.play();
play.innerHTML = '||';
play.setInner
bucle=setInterval(redimensionaBarra, 1000);
}
}

function redimensionaBarra()
{
if(!medio.ended)
{
let total=parseInt(medio.currentTime*maximo / medio.duration);
progreso.style.width=total+'px';
}
else
{
progreso.style.width='0px';
play.value='\u25BA';
window.clearInterval(bucle);
}
}

window.addEventListener('load', iniciar, false);
