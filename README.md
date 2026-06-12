# android-curso-2026

## 📝Práctica 1 — configuración del entorno
### 🎯Objetivos :
* Instalar y configurar Android Studio, JDK 17 y el Android Virtual Device (AVD).
* Crear y conectar el repositorio GitHub del curso.
* Ejecutar el primer proyecto Android en el emulador.
* Identificar los archivos clave de un proyecto Android moderno.
### 🗒️Cuestionario:
		1. app/src/main/AndroidManifest.xml
			○ ¿Qué contiene? Contiene la configuración de la aplicación. Incluye el nombre de la app, su icono, los permisos que necesita (como usar internet o la cámara) y una lista de todas las pantallas (Activities) y servicios que componen la aplicación. Sin este archivo, Android no sabría cómo arrancar la app.
			○ ¿Qué es el atributo android:name en ? Especifica qué clase de Kotlin (en este caso MainActivity) corresponde a esa pantalla.
		2. app/build.gradle.kts
			○ ¿Cuál es el valor de minSdk? 24.
			○ ¿Y de compileSdk? 36.
		3. libs.versions.toml
			○ ¿Qué versión de Kotlin está configurada? 2.2.10
		4. app/src/main/java/.../MainActivity.kt
			○ ¿Qué función llama para mostrar la UI? Se llama habitualmente HolaAndroidTheme.
<p>Modifica el texto que muestra la app: abre MainActivity.kt y cambia el texto 'Hello Android!' por 'Hola, [Tu Nombre]!'. 
Ejecuta la app en el AVD para verificar el cambio.</p>

### Resultado
<img width="457" height="883" alt="image" src="https://github.com/user-attachments/assets/7360b78f-7a15-41dc-a9f3-0c6e6da03396" />

## 📝 Práctica 2 — Tipos, Variables y Control de Flujo

### 🎯 Objetivos de la Práctica
* Distinguir entre `val` y `var`, y aplicar inferencia de tipos.
* Usar los tipos básicos de Kotlin: `Int`, `Double`, `String`, `Boolean`.
* Aplicar `if/else` como expresión, `when`, `for` y `while`.
* Usar plantillas de cadena (string templates) con `$variable` y `${expresion}`.

### Resultado
<img width="724" height="482" alt="image" src="https://github.com/user-attachments/assets/265c46ed-42c5-4602-8d2d-fb477d133c6d" />
<img width="753" height="433" alt="image" src="https://github.com/user-attachments/assets/a95259b9-6afc-490d-ae81-686ae912527c" />



