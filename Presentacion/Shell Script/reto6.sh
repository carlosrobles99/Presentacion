

numeros=( 1 2 3 4 5 6 7 8 9 10 11 12 )
contadoresTotalesCartas=()
cartasJugador=()
cartasMaquina=()
pilaDeCartas=()
palos=( ♥ ♦ ♣ ♠ ) # NO SE USAN
cartas=""
baraja=""
nombre=''
cons='X'
puntosJugador=0
puntosMaquina=0
validar_entrada='^[0-9]+$'
gruposMaquina=()
gruposJugador=()

function iniciaBaraja(){

#Limpiamos la baraja para cuando se llama al método al inicio de cada partida
for (( i = 0; i <48; i++ )); do
		cartas[$i]=""
		baraja[$i]=""
done	

for (( i = 0; i < 4; i++ )); do
	for (( j = 0; j < 12; j++ )); do
		cartas[$k]="${numeros[$j]}${palos[$i]}"
		k=$((k+1))
	done
done

#Desordena (baraja) las cartas
baraja=($(printf "%s\n" "${cartas[@]}" | shuf))
#Reaprovechamos la variable cartas para guardar la baraja en el mismo orden sin el palo (para poder hacer operaciones con ella)
for (( i = 0; i < 48; i++ )); do
	cartas[$i]=${baraja[$i]:0:${#baraja[$i]}-1}
done

contadorABARAJAR=0
while [ $contadorABARAJAR -lt 7 ]; do
	cartasJugador+=("${cartas[$contadorABARAJAR]}")
	contadorABARAJAR=$(($contadorABARAJAR+1))
done
while [ $contadorABARAJAR -lt 14 ]; do
	cartasMaquina+=("${cartas[$contadorABARAJAR]}")
	contadorABARAJAR=$(($contadorABARAJAR+1))
done
while [ $contadorABARAJAR -lt 48 ]; do
	pilaDeCartas+=("${cartas[$contadorABARAJAR]}")
	contadorABARAJAR=$(($contadorABARAJAR+1))
done

#AGRUPACION DE CARTAS EN LA PILA

for (( i = 0; i <= 11; i++ )); do
	contadoresTotalesCartas[i]=0
done

for (( i = 0; i < 32; i++ )); do
	if [[ ${pilaDeCartas[i]} -eq 1 ]]; then
		((contadoresTotalesCartas[0]++))
	fi
	if [[ ${pilaDeCartas[i]} -eq 2  ]]; then
		((contadoresTotalesCartas[1]++))
	fi
	if [[ ${pilaDeCartas[i]} -eq 3  ]]; then
		((contadoresTotalesCartas[2]++))
	fi
	if [[ ${pilaDeCartas[i]} -eq 4  ]]; then
		((contadoresTotalesCartas[3]++))
	fi
	if [[ ${pilaDeCartas[i]} -eq 5  ]]; then
		((contadoresTotalesCartas[4]++))
	fi
	if [[ ${pilaDeCartas[i]} -eq 6  ]]; then
		((contadoresTotalesCartas[5]++))
	fi
	if [[ ${pilaDeCartas[i]} -eq 7  ]]; then
		((contadoresTotalesCartas[6]++))
	fi
	if [[ ${pilaDeCartas[i]} -eq 8  ]]; then
		((contadoresTotalesCartas[7]++))
	fi
	if [[ ${pilaDeCartas[i]} -eq 9  ]]; then
		((contadoresTotalesCartas[8]++))
	fi
	if [[ ${pilaDeCartas[i]} -eq 10  ]]; then
		((contadoresTotalesCartas[9]++))
	fi
	if [[ ${pilaDeCartas[i]} -eq 11  ]]; then
		((contadoresTotalesCartas[10]++))
	fi
	if [[ ${pilaDeCartas[i]} -eq 12  ]]; then
		((contadoresTotalesCartas[11]++))
	fi
done
}

function inicioJuego(){

echo "    _ _     ______________    ____  _____   ____  ____  ____  _____  ____  ____  "
echo "   / / \ /\/  __/  __/  _ \  /  _ \/  __/  /   _\/  _ \/  __\/__ __\/  _ \/ ___\ "
echo "   | | | |||  \ | |  | / \|  | | \||  \    |  /  | / \||  \/|  / \  | / \||    \ "
echo "/\_| | \_/||  /_| |_// \_/|  | |_/||  /_   |  \_ | |-|||    /  | |  | |-||\___ | "
echo "\____|____/\____\____\____/  \____/\____\  \____/\_/ \|\_/\_\  \_/  \_/ \|\____/ "
echo "                                                                                 "                      

echo ""
echo "--------------Empieza el juego--------------"
echo ""
echo "Introduce tu nombre: "
read nombre
if [[ -z $nombre ]]; then
	echo "No has Introducido ningun nombre"
	exit
fi
echo ""
echo "Hola $nombre!"

}

function turnoJugador(){
arrayDeX=()
carta=0
cartaEncontrada=0
cartaPesca=$(shuf -i 1-12 -n 1)

for (( i = 0; i < ${#cartasMaquina[@]}; i++ )); do
	arrayDeX+=( "$cons" )
done

echo ""
echo "Baraja de la maquina: ${arrayDeX[*]}"
echo "Esta es tu baraja: ${cartasJugador[*]}"
echo ""
echo "Que cartas quieres solicitar?"
read carta

if [[ -z $carta ]]; then
	echo "No has introducido ningun valor"
	turnoJugador
fi

if [[ $carta =~ $validar_entrada  ]]; then

	if [[ $carta -lt 1 || $carta -gt 12 ]]; then
		echo ""
		echo "Introduce valores de rango valido [1-12]"
		turnoJugador
	fi

	for (( i = 0; i < ${#cartasMaquina[@]}; i++ )); do
		if [[ ${cartasMaquina[$i]} -eq $carta ]]; then
			cartasJugador+=( "$carta" )
			cartaEncontrada=$(($cartaEncontrada+1))
			unset cartasMaquina[$i]
			echo ""
			echo "Se ha encontrado la carta solicitada"
			break
		fi
	done

	if [[ $cartaEncontrada -eq 0 ]]; then
		echo ""
		echo "A Pescar!"
		echo "Se retirara un $cartaPesca de la siquiente pila:"
		echo ""
		((contadoresTotalesCartas[$cartaPesca-1]--))
		cartasJugador+=( "$cartaPesca" )
		for (( i = 0; i <= 11; i++ )); do
			if [[ ${contadoresTotalesCartas[$i]} -gt 0 ]]; then
				echo "Numero: $(($i+1)); Cartas restantes: ${contadoresTotalesCartas[$i]}"
			fi
		done
	fi
else
	echo ""
	echo "Datos no validos"
	turnoJugador
fi
}

function turnoMaquina(){
cartaMaquina=$(shuf -i 1-12 -n 1)
cartaPesca=$(shuf -i 1-12 -n 1)
cartaEncontrada=0

echo ""
echo "La maquina ha elegido el: $cartaMaquina"
echo ""

	for (( i = 0; i < ${#cartasJugador[@]}; i++ )); do
		if [[ ${cartasJugador[$i]} -eq $cartaMaquina ]]; then
			cartasMaquina+=( "$cartaMaquina" )
			cartaEncontrada=$(($cartaEncontrada+1))
			echo "La mquina te ha robado la carta: $cartaMaquina"
			unset cartasJugador[$i]
			break
		fi
	done

	if [[ $cartaEncontrada -eq 0 ]]; then
		echo "A Pescar!"
		echo "Se retirara una carta de la siquiente pila:"
		echo ""
		((contadoresTotalesCartas[$cartaPesca-1]--))
		cartasMaquina+=( "$cartaPesca" )
		for (( i = 0; i <= 11; i++ )); do
			if [[ ${contadoresTotalesCartas[$i]} -gt 0 ]]; then
				echo "Numero: $(($i+1)); Cartas restantes: ${contadoresTotalesCartas[$i]}"
			fi
		done
	fi
}

function comprobarRondaJugador(){
	indice=0
	declare -a contadorTotalJugador='([0]="0" [1]="0" 
		[2]="0" [3]="0"
		[4]="0" [5]="0"
		[6]="0" [7]="0"
		[8]="0" [9]="0"
		[10]="0" [11]="0")'

	for i in "${cartasJugador[@]}"; do
		if [[ $i -eq 1 ]]; then
			((contadorTotalJugador[0]++))
		fi
		if [[ $i -eq 2  ]]; then
			((contadorTotalJugador[1]++))
		fi
		if [[ $i -eq 3  ]]; then
			((contadorTotalJugador[2]++))
		fi
		if [[ $i -eq 4  ]]; then
			((contadorTotalJugador[3]++))
		fi
		if [[ $i -eq 5  ]]; then
			((contadorTotalJugador[4]++))
		fi
		if [[ $i -eq 6  ]]; then
			((contadorTotalJugador[5]++))
		fi
		if [[ $i -eq 7  ]]; then
			((contadorTotalJugador[6]++))
		fi
		if [[ $i -eq 8  ]]; then
			((contadorTotalJugador[7]++))
		fi
		if [[ $i -eq 9  ]]; then
			((contadorTotalJugador[8]++))
		fi
		if [[ $i -eq 10  ]]; then
			((contadorTotalJugador[9]++))
		fi
		if [[ $i -eq 11  ]]; then
			((contadorTotalJugador[10]++))
		fi
		if [[ $i -eq 12  ]]; then
			((contadorTotalJugador[11]++))
		fi
	done

	for i in "${contadorTotalJugador[@]}"; do
       	if [[ $i -ge 4 ]]; then
				echo "El jugador ha hecho un grupo de $(($indice+1))"
				echo ""
				puntosJugador=$(($puntosJugador+1))
				gruposJugador+=( "$(($indice+1))" )
		fi
		indice=$(($indice+1))
	done
}

function comprobarRondaMaquina(){
	indice=0
	declare -a contadorTotalMaquina='([0]="0" [1]="0" 
		[2]="0" [3]="0"
		[4]="0" [5]="0"
		[6]="0" [7]="0"
		[8]="0" [9]="0"
		[10]="0" [11]="0")'

	for i in "${cartasMaquina[@]}"; do
		if [[ $i -eq 1 ]]; then
			((contadorTotalMaquina[0]++))
		fi
		if [[ $i -eq 2  ]]; then
			((contadorTotalMaquina[1]++))
		fi
		if [[ $i -eq 3  ]]; then
			((contadorTotalMaquina[2]++))
		fi
		if [[ $i -eq 4  ]]; then
			((contadorTotalMaquina[3]++))
		fi
		if [[ $i -eq 5  ]]; then
			((contadorTotalMaquina[4]++))
		fi
		if [[ $i -eq 6  ]]; then
			((contadorTotalMaquina[5]++))
		fi
		if [[ $i -eq 7  ]]; then
			((contadorTotalMaquina[6]++))
		fi
		if [[ $i -eq 8  ]]; then
			((contadorTotalMaquina[7]++))
		fi
		if [[ $i -eq 9  ]]; then
			((contadorTotalMaquina[8]++))
		fi
		if [[ $i -eq 10  ]]; then
			((contadorTotalMaquina[9]++))
		fi
		if [[ $i -eq 11  ]]; then
			((contadorTotalMaquina[10]++))
		fi
		if [[ $i -eq 12  ]]; then
			((contadorTotalMaquina[11]++))
		fi
	done

	for i in "${contadorTotalMaquina[@]}"; do
       	if [[ $i -ge 4 ]]; then
				echo "El maquina ha hecho un grupo de $(($indice+1))"
				echo ""
				puntosMaquina=$(($puntosMaquina+1))
				gruposMaquina+=( "$(($indice+1))" )
		fi
		indice=$(($indice+1))
	done
}

function turnos(){

opcionSalida=''
turnoJugador
turnoMaquina

echo ""
echo "-----ESTADO DE CARTAS-----"
echo ""
echo "Baraja de la maquina: ${arrayDeX[*]}"
echo "Esta es tu baraja: ${cartasJugador[*]}"
echo ""

echo "¿Desea continuar o se rinde? (s/n)"
read opcionSalida

	if [[ "$opcionSalida" = "n" || -z $opcionSalida ]]; then

		echo ""
		echo "Fin del juego"
		echo "Baraja de la maquina: ${cartasMaquina[*]}"
		echo "Esta es tu baraja: ${cartasJugador[*]}"
		echo ""

		comprobarRondaMaquina
		comprobarRondaJugador

		if [[ $((${#gruposJugador[@]}+${#gruposMaquina[@]})) -gt 0 ]]; then
			if [[ ${#gruposJugador[@]} -eq ${#gruposMaquina[@]} ]]; then
				echo "EMPATE"
				echo "Puntos de $nombre: $puntosJugador, grupos de ${gruposJugador[*]}"
				echo "Puntos de la maquina: $puntosMaquina, grupos de: ${gruposMaquina[*]}"
				echo ""
				final
			fi
			if [[ ${#gruposJugador[@]} -gt ${#gruposMaquina[@]} ]]; then
				echo "Gana $nombre, que ha conseguido mas grupos"
				echo "Puntos de $nombre: $puntosJugador, grupos de ${gruposJugador[*]}"
				echo "Puntos de la maquina: $puntosMaquina, grupos de: ${gruposMaquina[*]}"
				echo ""
				final
			fi
			if [[ ${#gruposJugador[@]} -lt ${#gruposMaquina[@]} ]]; then
				echo "Gana la maquina, que ha conseguido mas grupos"
				echo "Puntos de $nombre: $puntosJugador, grupos de ${gruposJugador[*]}"
				echo "Puntos de la maquina: $puntosMaquina, grupos de: ${gruposMaquina[*]}"
				echo ""
				final
			fi
		else
			echo "Empate basico"
			echo "Puntos de $nombre: $puntosJugador, no existen grupos"
			echo "Puntos de la maquina: $puntosMaquina, no existen grupos"
			echo ""
		fi
		exit
	else
		turnos
	fi
}

function final(){
		if [[ ${#gruposJugador[@]} -eq 12 ]]; then
			echo ""
			echo "Gana $nombre, que ha conseguido todos los grupos"
			exit
		fi
		if [[ ${#gruposMaquina[@]} -eq 12 ]]; then
			echo ""
			echo "Gana la maquina, que ha conseguido todos los grupos"
			exit
		fi
		if [[ ${#gruposMaquina[@]} -eq 12 && ${#gruposJugador[@]} -eq 12 ]]; then
			echo ""
			echo "EMPATE DE GRUPOS"
			exit
		fi
}

iniciaBaraja
inicioJuego
turnos












