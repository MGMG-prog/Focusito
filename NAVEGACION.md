# Navegación de la Aplicación Focusito

## Flujo de Navegación Implementado

### Pantallas y Navegación:

1. **Pantalla Principal** (`pantallaprincipal.kt`)
   - Botón "CONTINUAR" → Navega a Login

2. **Login** (`login.kt`)
   - Botón "Iniciar sesión" → Navega a Roles
   - Botón "Registrate" → Navega a Registrate

3. **Registrate** (`registrate.kt`)
   - Botón "Crear cuenta" → Navega a Roles
   - Botón "Inicia sesión" → Navega a Login

4. **Roles** (`roles.kt`)
   - Botón de flecha atrás → Regresa a Login

## Archivos Modificados:

### Dependencias:
- `gradle/libs.versions.toml` - Agregada dependencia de navegación
- `app/build.gradle.kts` - Agregada implementación de navigation-compose

### Navegación:
- `app/src/main/java/com/example/focusito03/navigation/Navigation.kt` - Controlador de navegación principal

### Pantallas:
- `pantallaprincipal.kt` - Agregados parámetros de navegación
- `login.kt` - Agregados parámetros de navegación
- `registrate.kt` - Agregados parámetros de navegación
- `roles.kt` - Agregados parámetros de navegación

### MainActivity:
- `MainActivity.kt` - Integrado el sistema de navegación

## Cómo Funciona:

1. La aplicación inicia en la **Pantalla Principal**
2. Al presionar "CONTINUAR" se navega al **Login**
3. Desde el Login se puede:
   - Ir a **Registrate** para crear cuenta
   - Ir a **Roles** si ya tienes cuenta
4. Desde Registrate se puede:
   - Volver al **Login** si ya tienes cuenta
   - Ir a **Roles** después de crear cuenta
5. Desde Roles se puede volver al **Login** con el botón de retroceso

## Tecnologías Utilizadas:

- **Jetpack Compose Navigation** - Para la navegación entre pantallas
- **NavHost** - Contenedor de navegación
- **NavController** - Controlador de navegación
- **Composable** - Para definir las rutas de navegación

La navegación está completamente funcional y permite moverse entre todas las pantallas de manera fluida.
