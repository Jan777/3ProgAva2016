# Comunicacion Cliente-Servidor

## Esquema de preguntas y respuestas:

## Siempre que se actualice el Mapa, combate o cualquier Estado, esto ocurre para todos los jugadores.

### Cliente → LogIn(Usuario,Pass,Id)
### Servidor → Ejecuta LogIn() y luego MostrarMenu()

### Cliente → CrearPersonaje(Personaje)
### Servidor → Ejecuta CrearPersonaje() y luego ActualizarMapa()  

### Cliente → Moverse(Personaje,PosX,PosY)
### Servidor → Ejecuta Moverse() y luego ActualizarMapa() 

### Aliarse → Aliarse(Personaje1,Personaje2)
### Servidor → Ejecuta Aliarse() luego ActualizarMapa()

### Cliente → Combatir(Personaje1,NPC)
### Servidor → Ejecuta Combatir() luego muestra ArenaPvE()

### Cliente → Combatir(Personaje1,Personaje2)
### Servidor → Ejecuta Combatir() luego muestra ArenaPvP()

### Cliente → Atacar(Personaje1,Ente)
### Servidor → Ejecuta Atacar() luego ActualizaArena()

### Cliente → AtacarConHechizo(Personaje1,Personaje2)
### Servidor → Ejecuta AtacarConHechizo() luego ActualizaArena()

### Cliente → AumentarAtributo(Personaje)
### Servidor → Ejecuta Combatir() luego muestra ArenaPvE()

### Cliente → AumentarAtributo(Personaje)
### Servidor → Ejecuta Combatir() luego muestra ArenaPvE()

### Cliente → DropearItem(Personaje)
### Servidor → Ejecuta DropearItem() luego muestra ActualizarMapa()

### Cliente → SubirDeNivel(Personaje)
### Servidor → Ejecuta SubirDeNivel() luego muestra ActualizarMapa()

### Cliente → CerrarSesion()
### Servidor → Ejecuta CerrarSesion() luego muestra ActualizarMapa()
