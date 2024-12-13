# Sistema de Optimización de la Cadena de Suministro

## Descripción
Este proyecto desarrolla un sistema de información para optimizar la cadena de suministro de una empresa de fabricación y distribución de herrajes. El objetivo principal es reducir costos logísticos, minimizar el exceso y la escasez de inventarios, y planificar eficientemente la producción, almacenamiento y distribución.

## Problemas Detectados
- Gestión manual de inventarios y rutas.
- Exceso de inventario en algunas ubicaciones y escasez en otras.
- Altos costos logísticos por almacenamiento, transporte y pérdidas de oportunidades.

## Solución Propuesta
Desarrollo de un sistema basado en programación orientada a objetos (POO) con las siguientes funcionalidades:
1. **Gestión de inventarios**: Cálculo de niveles óptimos de inventario por ubicación.
2. **Asignación de ubicaciones**: Reducción de costos de transporte mediante almacenamiento eficiente.
3. **Enrutamiento de distribución**: Optimización de rutas basadas en capacidad, restricciones de tiempo y ubicaciones.
4. **Interfaz gráfica**: Sistema amigable para la supervisión y ajustes manuales por usuarios.

---

## Funcionalidades del Sistema
1. **Gestión de Productos**:
   - Cada producto tiene atributos como: nombre, número serial, tipo, material, demanda, costos (producción y almacenamiento), precio de venta y bodega asociada.
   - Clasificación de productos:
     - **Herrajes**: Color, material y tipo de elemento (puerta, cajón, etc.).
     - **Eléctricos**: Capacidad de carga y calibre.
     - **Otros**: Descripción breve.

2. **Usuarios del Sistema**:
   - **Administradores**: CRUD completo de todas las entidades y creación de usuarios.
   - **Vendedores**: Visualización de datos y modificación de precios de productos.
   - **Bodegueros**: Gestión de nombres de bodegas y supervisión de productos.
   - **Clientes**: Visualización y ordenamiento de productos.

3. **Validaciones y Restricciones**:
   - No se puede crear un producto si no hay capacidad en la bodega asociada.
   - No se puede eliminar una bodega con productos almacenados.
   - Borrado de productos solo si el stock en bodega es cero.

4. **Arquitectura y Algoritmos**:
   - Implementación basada en el patrón Modelo Vista Controlador (MVC).
   - Algoritmos para búsqueda binaria, ordenamientos (sort, mergesort, quicksort y burbuja) y validaciones.

---

## Detalles de Implementación
### Primera Entrega
- CRUD de todas las clases con validaciones básicas.
- Ordenamiento inicial con `sort`.
- Constructores, método `equals` para duplicados y `toString()` para impresión.
- Modo texto: Menús y operaciones implementados con `switch-case`.

### Segunda Entrega
- Interfaz gráfica para las operaciones CRUD.
- Validaciones más específicas de datos.
- Nuevos métodos de ordenamiento:
  - Quicksort: Por nombre.
  - Mergesort: Por precio de venta.
  - Burbuja: Por marca.
- Consultas específicas y diagrama de clases UML.

### Tercera Entrega
- Pantalla de inicio con autenticación de usuarios y perfiles.
- Persistencia de datos en almacenamiento físico.
- Validaciones avanzadas con expresiones regulares:
  - Correo electrónico, fechas, nombres y contraseñas.
  - Contraseñas encriptadas antes de almacenar.
- Excepciones manejadas sin cierres abruptos.
- Menús gráficos que regresan al menú principal.

---

## Funcionalidad General
1. **Inicio del Programa**:
   - Lanzamiento desde un ícono en el escritorio, independiente del entorno de desarrollo.
   - Sistema robusto que maneja excepciones y permite navegación fluida entre menús.

2. **Conceptos Clave**:
   - Uso de POO: Herencia, polimorfismo, encapsulamiento y sobrecarga.
   - Relaciones entre clases y paquetes organizados.

3. **Soporte de Expresiones Regulares**:
   - Validación de formatos de correo, fechas, nombres y contraseñas.

---

## Cómo Ejecutar el Programa
1. **Requisitos**:
   - Java instalado y configurado.
   - Herramienta gráfica para diseño (e.g., JavaFX, Swing).

2. **Compilación y Ejecución**:
   - Compila las clases del sistema:
     ```bash
     javac *.java
     ```
   - Ejecuta la aplicación desde el terminal o crea un archivo ejecutable (JAR):
     ```bash
     java -jar sistema_suministro.jar
     ```

3. **Acceso Inicial**:
   - Autenticar con un usuario administrador para realizar configuraciones iniciales.

---

## Mejoras Futuras
- Implementar optimización avanzada de rutas con algoritmos heurísticos.
- Integrar análisis de datos históricos para proyecciones de demanda.
- Ampliar soporte para almacenamiento en la nube y conexión a dispositivos IoT.

---

## Recursos y Referencias
- Expresiones regulares: [10 ejemplos útiles](http://web.ontuts.com/snippets/10-expresiones-regulares-imprescindibles-en-desarrollo-web/).
- Validación de contraseñas: [Java Code Geeks](https://examples.javacodegeeks.com/core-java/util/regex/matcher/validate-password-with-java-regular-expression-example/).

---

**Autoría**:  
Este proyecto fue desarrollado como parte del programa de **Administración de Sistemas Informáticos** y presentado a la Docente Ana Lorena Uribe Hurtado.
