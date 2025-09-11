# Trabajo de Competencia: Ticktes para banco
**INDICE**

- [Trabajo de Competencia: Ticktes para banco](#trabajo-de-competencia-ticktes-para-banco)
  - [1. Configuracion de entorno](#1-configuracion-de-entorno)
  - [VS Code, Git, GitHub, Java](#vs-code-git-github-java)
    - [1.1 Instalacion VS Code](#11-instalacion-vs-code)
    - [1.2. Instalacion de Git](#12-instalacion-de-git)
    - [1.3. Instalacion Java](#13-instalacion-java)
    - [1.4. Configuracion Git y clave SSH](#14-configuracion-git-y-clave-ssh)
      - [1.4.1. Generar y agregar clave SSH a GitHub](#141-generar-y-agregar-clave-ssh-a-github)
    - [1.5. Clonar un repositorio de GitHub](#15-clonar-un-repositorio-de-github)
    - [1.6. Crear y cambiar de rama](#16-crear-y-cambiar-de-rama)
    - [1.7. Crear y ejecutar un proyecto en C#](#17-crear-y-ejecutar-un-proyecto-en-c)
    - [1.8. Subir cambios a GitHub](#18-subir-cambios-a-github)
  - [2. Desarrollo del proyecto](#2-desarrollo-del-proyecto)
  - [2.1. Estructura y convencion de nombres](#21-estructura-y-convencion-de-nombres)
  - [2.2. Diagrama de clases](#22-diagrama-de-clases)
  - [2.3. Diagrama de flujo](#23-diagrama-de-flujo)

## 1. Configuracion de entorno
## VS Code, Git, GitHub, Java

### 1.1 Instalacion VS Code

- Descarga VS Code: **[Download VS Code](https://code.visualstudio.com/download)**

- Instalar con la configuracion predeterminada
- Instalar extensiones:

  - **_Extension Pack for Java_**

---

### 1.2. Instalacion de Git

- Descarga Git: **[Download Git](https://git-scm.com/downloads)**
- Instalar con la configuracion predeterminada
- Prueba de version

---

```bash
git --version
```

---

### 1.3. Instalacion Java
* Primero verificamos si ya tenemos Java

---

```bash
 java --version
```
En caso de que no este instalado lo descargamos desde Oracle JDK, disponible para Windows, Linux y macOs

- Descarga Java: [Download Java](https://www.oracle.com/java/technologies/downloads/)

---

### 1.4. Configuracion Git y clave SSH

- Configuracion inicial Git

---

```bash
git config --global user.name "Tu nombre"

git config --global user.email "tu_correo@example.com"
```

---

Usa el mismo correo que tienes en **[GitHub](https://github.com/login)**

---

#### 1.4.1. Generar y agregar clave SSH a GitHub

- Generar clave SSH

---

```bash
ssh-keygen -t ed25519 -C "tu_correo_de_github@gmail.com"
```

---

- Levantar al agente SSH y agregar una clave

---

```bash
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_ed25519
```

---

- Copiar la clave publica

---

```bash
cat ~/.ssh/id_ed25519.pub
```

---

**_¡¡¡Copia su contenido!!!_**

---

- Agregar la clave a GitHub

  - Ir a **[GitHub → Settings → SSH and GPG keys](https://github.com/settings/keys)**
  - Click en **New SSH key** y pega el contenido y guardalo

### 1.5. Clonar un repositorio de GitHub

- Crea una carpeta para clonar ahi tu repositorio

---

```bash
mkdir "nombre_de_tu_carpeta"
cd nombre_de_tu_carpeta
```

---

- Clonar un repositorio

---

```bash
git clone git@github.com:usuario/repositorio.git

cd repositorio
```

---

### 1.6. Crear y cambiar de rama

- Crear una rama
  ***

```bash
 git branch nombre_de_la_rama
```

---

- Crear una rama y cambiarte a ella

---

```bash
git checkout -b nombre_rama
```

---

- Cambiarte a la nueva rama

---

```bash
git checkout nombre_rama
```

---

### 1.7. Crear y ejecutar un proyecto en C#

- Crear una carpeta que vaya a contener el proyecto
- Abre desde la terminal
- En la terminal:

  - `dotnet new console`

- Para ejecutar:

  - `dotnet run`

### 1.8. Subir cambios a GitHub

- Ver estado

---

```bash
git status
```

- Agregar todos los cambios

---

```bash
git add .
```

- Crear un commit

---

```bash
git commit -m "mensaje con los cambios realizados"
```

---

- Subir los cambios a GitHub

---

```bash
git push
```

---

## 2. Desarrollo del proyecto
## 2.1. Estructura y convencion de nombres
* Estructura
```bash
Trabajo_Competencias/
│
├── SistemaBanco/            # Proyecto en Java
│   ├── Banco.java              
│   ├── Cliente.java            
│   ├── Estructuras.java          
│   ├── Main.java       
│   └── Nodo.java 
│
└── README.md                 #Documentacion
```
* Convencion de nombre
    * Archivos: PascalCase
    * Clases y Metodos: PascalCase
    * Atributos y Parametros:camelCase
      
## 2.2. Diagrama de clases
```mermaid
classDiagram
direction TB

    class ColaAtencion {
        -frentePref : Nodo
        -finPref : Nodo
        -frenteCorr : Nodo
        -finCorr : Nodo
        +encolar(cliente: Cliente) : void
        +desencolar() : Cliente
        +estaVacia() : boolean
        +mostrarCola() : void
        +mostrarOrdenados() : void
        +aLista() : List<Cliente>
        +ordenarClientes() : List<Cliente>
        -heapSort(lista: List<Cliente>) : void 
        -heapify(lista: List<Cliente>, int n, int i) : void
    }

    class Nodo {
        -cliente : Cliente
        -siguiente : Nodo
    }

    class Cliente {
        -nombre : String
        -preferencial : boolean
        -numero : int
        -contadorTickets : static int
        +getNombre() : String
    }

    class Banco {
        -caja1 : ColaAtencion
        -caja2 : ColaAtencion
        -plataforma : ColaAtencion
        -creditos : ColaAtencion
        -informaciones : ColaAtencion
        +agregarClienteCaja(cliente: Cliente, numCaja:int) : void
        +agregarClientePlataforma(cliente: Cliente) : void
        +agregarClienteCredito(cliente: Cliente) : void
        +agregarClienteInformaciones(cliente: Cliente) : void
        +atenderCaja(numCaja:int) : String
        +atenderPlataforma() : String
        +atenderCredito() : String
        +atenderInformaciones() : String
        +finalizarAtencion(tipoPuesto:String, numeroPuesto:int) : String
        +mostarColas() : void
        +imprimirResumen() : void
        +imprimirResumenRecursivo(nombres:String[], index:int) : void
    }

    class Main {
        +main(args:String[]) : void
    }

    Banco o-- ColaAtencion : tiene
    ColaAtencion *-- Nodo : contiene
    Nodo --> Cliente : contiene
    Main ..> Banco : usa

```
---

## 2.3. Diagrama de flujo 
* Diagrama de flujo general del programa
  
``` mermaid  
flowchart TD
    A([Inicio]) --> B{Seleccionar opción}
    
    %% Opciones del menú
    B -->|1. Agregar cliente a Caja| C[Ingresar nombre y preferencial]
    C --> D["Elegir Caja (1 o 2)"]
    D --> E[Agregar a Cola de Caja]
    E --> B
    
    B -->|2. Agregar cliente a Plataforma| F[Ingresar nombre y preferencial]
    F --> G[Agregar a Cola de Plataforma]
    G --> B
    
    B -->|3. Agregar cliente a Crédito| H[Ingresar nombre y preferencial]
    H --> I[Agregar a Cola de Crédito]
    I --> B
    
    B -->|4. Agregar cliente a Informaciones| J[Ingresar nombre y preferencial]
    J --> K[Agregar a Cola de Informaciones]
    K --> B
    
    %% Atender clientes
    B -->|5. Atender en Caja| L["Seleccionar Caja 1 o 2"]
    L --> M{Cola preferencial vacía?}
    M -->|No| N[Atender cliente preferencial]
    M -->|Sí| O{Cola corriente vacía?}
    O -->|No| P[Atender cliente corriente]
    O -->|Sí| Q[No hay clientes en Caja]
    N --> B
    P --> B
    Q --> B
    
    B -->|6. Atender Plataforma| R{Cola preferencial vacía?}
    R -->|No| S[Atender cliente preferencial]
    R -->|Sí| T{Cola corriente vacía?}
    T -->|No| U[Atender cliente corriente]
    T -->|Sí| V[No hay clientes en Plataforma]
    S --> B
    U --> B
    V --> B
    
    B -->|7. Atender Crédito| W[Proceso similar a Caja]
    W --> B
    
    B -->|8. Atender Informaciones| X[Proceso similar a Caja]
    X --> B
    
    %% Finalizar puesto
    B -->|9. Liberar puesto| Y[Ingresar tipo y número de puesto]
    Y --> Z[Puesto liberado]
    Z --> B
    
    %% Ordenar clientes
    B -->|10. Ordenar clientes por nombre| AA[HeapSort en lista de clientes]
    AA --> AB[Mostrar clientes ordenados]
    AB --> B
    
    %% Mostrar colas
    B -->|11. Mostrar colas| AC[Imprimir colas de cada área]
    AC --> B
    
    %% Resumen del día
    B -->|12. Resumen del día| AD[Imprimir cantidad de clientes atendidos]
    AD --> B
    
    B -->|0. Salir| AE([Fin])
```
---
Se mostrara el diagrama de flujo de dos clases: Banco y ColaAtencion

---
* Clase Banco
  ``` mermaid
  flowchart TD
    A[Inicio] --> B[Agregar cliente]
    B --> C{¿A qué área va?}
    C -->|Caja 1 o Caja 2| D[Encolar en Caja]
    C -->|Plataforma| E[Encolar en Plataforma]
    C -->|Crédito| F[Encolar en Crédito]
    C -->|Informaciones| G[Encolar en Informaciones]

    D --> H[Atender en Caja]
    E --> I[Atender en Plataforma]
    F --> J[Atender en Crédito]
    G --> K[Atender en Informaciones]

    H --> L[Actualizar contadores Caja]
    I --> M[Actualizar contadores Plataforma]
    J --> N[Actualizar contadores Crédito]
    K --> O[Actualizar contadores Informaciones]

    L --> P[Mostrar colas]
    M --> P
    N --> P
    O --> P

    P --> Q[Imprimir Resumen Recursivo]
    Q --> R[Fin]
  ```

---



En este flujo se representa:

  * Se agrega cliente y se decide a qué área va.

  * Se encola en la cola correspondiente.

  * Cuando se atiende, se actualizan contadores.

  * Se pueden mostrar las colas.

  * El final del día, se imprime el resumen usando recursividad.

* Clase ColaAtencion

---

``` mermaid
flowchart TD

A[Inicio] --> B{Operación}
B -->|Encolar| C{Cliente es preferencial?}
C -->|Sí| D[Agregar a finPref]
C -->|No| E[Agregar a finCorr]
D --> F[Cliente en cola]
E --> F[Cliente en cola]

B -->|Desencolar| G{frentePref no es null?}
G -->|Sí| H[Atender cliente preferencial]
G -->|No| I{frenteCorr no es null?}
I -->|Sí| J[Atender cliente corriente]
I -->|No| K[Cola vacía]
H --> L[Actualizar frentePref]
J --> M[Actualizar frenteCorr]
K --> F
L --> F
M --> F

B -->|MostrarCola| N[Recorrer frentePref y frenteCorr con recursividad]
N --> F

B -->|OrdenarClientes| O[Convertir colas a lista con aLista]
O --> P[Aplicar QuickSort en lista]
P --> Q[Lista ordenada]
Q --> F

F --> R[Fin]
```
---
Inicio (A)
El sistema arranca y espera una operación.

Selección de operación (B)
El usuario o el sistema decide qué acción realizar:

  * Encolar (agregar cliente)

    Si se elige Encolar, se evalúa: ¿El cliente es preferencial? (C)

    Sí → se agrega al final de la cola de preferenciales (D).

    No → se agrega al final de la cola de corrientes (E).

  * Desencolar (atender cliente)

    Si se elige Desencolar, se revisa: ¿la cola de preferenciales está vacía? (G)

    Sí hay clientes -> se atiende uno preferencial (H) y se actualiza el puntero frentePref (L).

    No hay clientes preferenciales -> se revisa la cola de corrientes (I).

    Sí hay -> se atiende cliente corriente (J) y se actualiza frenteCorr (M).

    No hay -> la cola está vacía (K).
  * MostrarCola
  
    Recorre la cola de preferenciales y corrientes (N), usando recursividad para listar clientes.
    Luego vuelve al estado de cola (F)

  * OrdenarClientes


    Si se elige OrdenarClientes, primero se convierte la cola a lista (O).

    Luego se aplica HeapSort sobre esa lista (P).

    Se obtiene la lista ordenada (Q).

    Y vuelve el estado de cola (F).

