package com.example.focusito03.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map



// DataStore: guarda los puntos del jugador aunque cierre la app
val Context.dataStore by preferencesDataStore("puntaje_global")

object PuntosManager {
    private val PUNTOS_KEY = intPreferencesKey("puntos")

    // Leer puntos guardados
    fun obtenerPuntos(context: Context): Flow<Int> {
        return context.dataStore.data.map { prefs ->
            prefs[PUNTOS_KEY] ?: 0
        }
    }

    // Guardar puntos específicos
    suspend fun guardarPuntos(context: Context, puntos: Int) {
        context.dataStore.edit { prefs ->
            prefs[PUNTOS_KEY] = puntos
        }
    }

    // Sumar puntos
    suspend fun sumarPuntos(context: Context, cantidad: Int) {
        context.dataStore.edit { prefs ->
            val actual = prefs[PUNTOS_KEY] ?: 0
            prefs[PUNTOS_KEY] = actual + cantidad
        }
    }

    // Restar puntos (sin bajar de 0)
    suspend fun restarPuntos(context: Context, cantidad: Int) {
        context.dataStore.edit { prefs ->
            val actual = prefs[PUNTOS_KEY] ?: 0
            prefs[PUNTOS_KEY] = (actual - cantidad).coerceAtLeast(0)
        }
    }
}


