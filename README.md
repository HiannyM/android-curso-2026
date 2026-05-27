# android-curso-2026

	PRÁCTICA 1 — CONFIGURACIÓN DEL ENTORNO
	Objetivos :
		• Instalar y configurar Android Studio, JDK 17 y el Android Virtual Device (AVD).
		• Crear y conectar el repositorio GitHub del curso.
		• Ejecutar el primer proyecto Android en el emulador.
		• dentificar los archivos clave de un proyecto Android moderno.
	Cuestionario:
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
