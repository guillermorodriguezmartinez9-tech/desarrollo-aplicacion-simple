# Sistema de Gestión de Videojuegos (POO en Java)

Este proyecto consiste en una aplicación de consola desarrollada en Java para demostrar el dominio práctico de los pilares esenciales de la **Programación Orientada a Objetos (POO)**. La aplicación simula un catálogo interactivo de videojuegos con capacidades de modificación de estado en tiempo real.

## ☑️ Conceptos de POO Implementados
El código fuente ha sido diseñado meticulosamente para cubrir tres requerimientos clave de la actividad formativa:

1. **Creación de Clases y Definición de Atributos:** Construcción de la clase molde `Videojuego` que encapsula propiedades esenciales mediante modificadores de acceso privados (`private`).
2. **Implementación de Métodos y Constructores:** Uso de un constructor parametrizado para la inicialización controlada de datos y métodos dinámicos con lógica de negocio integrada (como la asignación condicional de descuentos).
3. **Instanciación de Objetos:** Creación y gestión de múltiples instancias independientes en memoria dentro del punto de entrada principal (`Main`).

## 📁 Estructura del Código
El programa se integra en una estructura limpia ejecutable directamente desde entornos interactivos o IDEs tradicionales:
* **Clase `Videojuego`:** Contiene los atributos de la entidad (`titulo`, `plataforma`, `precio`), su constructor de inicialización, un método de salida visual (`mostrarInformation`) y un método de procesamiento aritmético (`aplicarDescuento`).
* **Clase `Main`:** Actúa como el controlador del sistema, orquestando la creación de los objetos y la invocación de sus comportamientos.