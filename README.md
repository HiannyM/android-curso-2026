# android-curso-2026
# Mis Prácticas de Desarrollo de Aplicaciones Móviles 📱 (UNICDA 2026)

Este repositorio contiene las soluciones a las prácticas de laboratorio del cuatrimestre.

## 🗂️ Índice de Prácticas de Laboratorio

<details>
<summary><b>📝 Práctica 1: configuración del entorno</b></summary>

**Objetivo:** Configurar el entorno de desarrollo integrado (IDE) Android Studio, comprender la estructura base de un proyecto de Android y familiarizarse con el flujo de compilación y ejecución en Kotlin.

* **Herramientas Utilizadas:** Android Studio, JDK, Git/GitHub para el control de versiones.
* **Resultados:** * Creación exitosa del proyecto base `HolaAndroid`.
    * Implementación de la primera función ejecutable en Kotlin utilizando la función `main`.
    * Sincronización inicial del repositorio local con el entorno remoto en GitHub.

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

#### 📸 Captura de Ejecución
<img width="457" height="883" alt="image" src="https://github.com/user-attachments/assets/7360b78f-7a15-41dc-a9f3-0c6e6da03396" />
</details>

<details>
	<summary><b>📝 Práctica 2: Tipos, Variables y Control de Flujo </b></summary>

### 🎯 Descripción
* Distinguir entre `val` y `var`, y aplicar inferencia de tipos.
* Usar los tipos básicos de Kotlin: `Int`, `Double`, `String`, `Boolean`.
* Aplicar `if/else` como expresión, `when`, `for` y `while`.
* Usar plantillas de cadena (string templates) con `$variable` y `${expresion}`.

#### 📸 Captura de Ejecución
<img width="724" height="482" alt="image" src="https://github.com/user-attachments/assets/265c46ed-42c5-4602-8d2d-fb477d133c6d" />
<img width="753" height="433" alt="image" src="https://github.com/user-attachments/assets/a95259b9-6afc-490d-ae81-686ae912527c" />

</details>

<details>
<summary><b>📝 Práctica 3: Colecciones, Estructuras de Control y Null-Safety</b></summary>

### 🎯 Descripción
Dominio del flujo de control con `when`, manipulación de colecciones (`listOf`, `mutableListOf`) y el sistema de tipos anulables (`Null-Safety`) para evitar errores en tiempo de ejecución.

#### 📸 Captura de Ejecución
<img width="738" height="738" alt="Screenshot 2026-06-10 155307" src="https://github.com/user-attachments/assets/36c49448-d5f9-44e5-8aea-d3d89685e2d6" />
<img width="772" height="608" alt="Screenshot 2026-06-10 155336" src="https://github.com/user-attachments/assets/51df7b7d-46f1-4ff0-b78c-b135fa9e4248" />
</details>

<details>
<summary><b>📝 Práctica 4: Funciones y Expresiones Lambda</b></summary>

### 🎯 Descripción
Implementación de parámetros nombrados, valores por defecto, funciones de extensión sobre clases nativas (`String` y `List`) y uso idiomático de funciones de ámbito (`apply`, `also`, `let`).

#### 📸 Captura de Ejecución
<img width="478" height="754" alt="image" src="https://github.com/user-attachments/assets/c9175d01-2dcd-4c0f-9f0a-a665c1c10bf2" />
<img width="477" height="738" alt="image" src="https://github.com/user-attachments/assets/1eee7b69-cf7b-40c4-8e2e-8512ea68c93a" />
<img width="685" height="207" alt="image" src="https://github.com/user-attachments/assets/1654235a-a409-4c58-93f3-0e2c2a986cce" />

</details>

<details>
<summary><b>📝 Práctica 5: Programación Orientada a Objetos e Interfaces</b></summary>

### 🎯 Descripción
Modelado de un Sistema de Gestión Académica aplicando los pilares de POO (Herencia, Encapsulamiento y Polimorfismo) en Kotlin junto con el uso de Smart Casts.

#### 📸 Captura de Ejecución
<img width="951" height="231" alt="image" src="https://github.com/user-attachments/assets/e719e8dc-9d69-464b-8635-6b3c16ae553d" />

</details>

<details>
<summary><b>📝 Práctica 6: Clases Especiales en Kotlin</b></summary>

### 🎯 Descripción
Implementar diferentes tipos de clases especiales aplicando enum, sealed y data class.

#### 📸 Captura de Ejecución
<img width="1084" height="698" alt="image" src="https://github.com/user-attachments/assets/1dcb921b-1601-44f9-a538-7a8354aae0c0" />


</details>

<details>
<summary><b>📝 Práctica 7: Anatomia Android y Composables Basicos</b></summary>

### 🎯 Descripción
En un nuevo proyecto en Android Studio "PrimerApp" indentificaremos los archivos clave de un proyecto Android, su estrutura , usar funciones fundamentales @Composable, Usar @Preview  y registrar mensajes de depuración con Log y visualizarlos en Logcat.

### 🗒️Cuestionario:
<h3>Explorar y anotar la estructura </h3>

	1. ¿Qué hace la función setContent {} en MainActivity.kt? 
		- Se utiliza para definir la interfaz de usuario de la aplicación usando Jetpack Compose. Todo el contenido que se coloca dentro de sus llaves será el diseño que se mostrará en la pantalla de la actividad.
	2. ¿Qué significan minSdk, targetSdk y compileSdk en build.gradle.kts? 
		- minSdk: Indica la versión mínima de Android en la que la aplicación puede instalarse y ejecutarse.
		Ejemplo: minSdk = 24 significa que la aplicación funciona desde Android 7.0 (API 24).
		- targetSdk: Es la versión de Android para la que la aplicación está optimizada y probada. Android utiliza este valor para aplicar el comportamiento adecuado de esa versión.
		- compileSdk: Es la versión del SDK utilizada para compilar la aplicación. Permite usar las APIs más recientes durante el desarrollo, aunque la aplicación pueda ejecutarse en versiones anteriores si cumplen con el minSdk.
	3. ¿Para qué sirve el archivo libs.versions.toml? 
		- Sirve para administrar de forma centralizada las versiones de las dependencias y plugins del proyecto.
	4. ¿Qué anotación convierte una función en un componente de UI en Compose? 
		- @Composable

#### 📸 Captura de Ejecución
<img width="552" height="763" alt="image" src="https://github.com/user-attachments/assets/f8046872-ab46-4367-aef9-8bb17f34b35a" />
<img width="1762" height="185" alt="image" src="https://github.com/user-attachments/assets/d7c3a8bc-2cbf-4d66-a51f-a4690bad94f0" />


</details>

## 🗂️ Índice de ejercicios de los examenes parciales

<details>
<summary>
	<b>📝 Ejercicio 15</b>
	<b>Archivo: ExamenEjerc15.kt</b>
</summary>
 https://github.com/HiannyM/android-curso-2026/tree/primerParcialEjer15

### 🎯 Descripción
Adjunte un archivo Practica03.kt que contenga la funcion:

	fun validarUsuario(nombre: String\?, email: String\?): ResultadoValidacion
	donde ResultadoValidacion es una data class con esValido: Boolean y mensaje: String.
	La funcion DEBE usar los TRES operadores de null-safety: safe-call (\?.), Elvis (\?:) y not-null (!!) al menos una vez cada uno (este ultimo de forma justificada). Tambien debe incluir una funcion main() que pruebe los 4 casos del sylabus (nombre null, email null, email sin @, caso valido).
	
#### 📸 Captura de Ejecución
<img width="966" height="342" alt="image" src="https://github.com/user-attachments/assets/0db02289-6db0-47bd-880f-0efb94fc4a63" />

</details>

<details>
<summary>
	<b>📝 Ejercicio 19</b>
	<b>Archivo: Extenciones.kt</b>
</summary>
https://github.com/HiannyM/android-curso-2026/tree/primerParcialEjer19
	
### 🎯 Descripción
Adjunte un archivo Extensiones.kt con al menos CUATRO funciones de extension utiles:

		(1) String.esEmail(): Boolean — verifica que contenga '@' y '.'.
		(2) String.aTitulo(): String — convierte "hola mundo" en "Hola Mundo".
		(3) String.mascararTarjeta(): String — oculta los primeros 12 digitos de un numero de tarjeta de 16 caracteres.
		(4) List.aprobados(): List — retorna las notas mayores o iguales a 70.
		Incluya una funcion main() con casos de prueba claros
	
#### 📸 Captura de Ejecución
<img width="975" height="567" alt="image" src="https://github.com/user-attachments/assets/0512cc5b-7587-4ed7-bf1f-b680930f9893" />

</details>

<details>
<summary>
	<b>📝 Ejercicio 21</b>
	<b>Archivo: ClasificacionNota.kt</b>
</summary>
https://github.com/HiannyM/android-curso-2026/tree/primerParcialEjer21
	
### 🎯 Descripción
Adjunte un archivo Practica02.kt que contenga:

	(a) La funcion clasificarNota(nota: Int): String usando when, que cubra los rangos del sylabus (Sobresaliente >= 90, Muy Bueno >= 80, Bueno >= 70, Aprobado >= 60, Reprobado caso contrario, e Invalida si < 0 o > 100).
	(b) La funcion fizzBuzz() que imprima del 1 al 30 segun las reglas clasicas.
	(c) Una funcion main() que demuestre el uso de ambas con al menos 6 valores de prueba para clasificarNota.
	El codigo debe compilar sin errores.
	
#### 📸 Captura de Ejecución
<img width="1351" height="466" alt="image" src="https://github.com/user-attachments/assets/b13db3a3-8095-4936-8047-96f154585de3" />

</details>

<details>
<summary>
	<b>📝 Ejercicio 28</b>
	<b>Archivo: Pedidos.kt</b>
</summary>
https://github.com/HiannyM/android-curso-2026/tree/primerParcialEjer28
	
### 🎯 Descripción
Adjunte un archivo Pedidos.kt que contenga:

	(a) Una data class Pedido(val id: Int, var producto: String, var precio: Double, var activo: Boolean = true).
	(b) Una funcion de orden superior fun filtrarPedidos(pedidos: List, criterio: (Pedido) -> Boolean): List.
	(c) En main(): crear al menos 4 pedidos usando apply para configurar campos, filtrar pedidos activos y caros (> 5000), y usar let para imprimir de forma segura el pedido mas caro.
	
#### 📸 Captura de Ejecución
<img width="1100" height="294" alt="image" src="https://github.com/user-attachments/assets/2cbf0ad9-55a7-4f96-9d13-6cd2fff4c7d1" />
<img width="864" height="158" alt="image" src="https://github.com/user-attachments/assets/30ed8b27-1599-4db0-a455-8e039f7bfd69" />

</details>
