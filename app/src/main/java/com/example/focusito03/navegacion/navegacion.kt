package com.example.focusito03.navegacion

import com.example.focusito03.interfaces.estu


sealed class Screen(val route: String
){
    object inicio: Screen("pantallaprincipal")
    object login: Screen("login")
    object registrate: Screen("registrate")
    object roles: Screen("roles")
    object profesor: Screen("profesor")
    object estudiante: Screen("estudiante")
    object puntos: Screen("puntos")
    object actividades: Screen("actividades")
    object fabulasypoemas: Screen("cuentos")
    object fabulas: Screen("fabulas")
    object fabula1: Screen("fabula1")
    object contifabula1: Screen("contifabula1")
    object fabula2: Screen("fabula2")
    object contifabula2: Screen("contiz3")
    object contifabula: Screen("contifabula2")
    object fabula3: Screen("fabula3")
    object contil: Screen("contil")
    object contil2: Screen("contil2")
    object poemas: Screen("poemas")
    object poema1: Screen("poema1")
    object poema2: Screen("poema2")
    object actividadnoregistrada: Screen("actividadnoregistrada")
}