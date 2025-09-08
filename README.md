# Trabajo_Competencias
# GUIA PARA CONFIGURACION DE ENTORNO

## VS Code, Git, GitHub, Java

### 1. Instalacion VS Code

- Descarga VS Code: **[Download VS Code](https://code.visualstudio.com/download)**

- Instalar con la configuracion predeterminada
- Instalar extensiones:

  - **_C# Dev Kit by Microsoft_**

---

### 2. Instalacion de Git

- Descarga Git: **[Download Git](https://git-scm.com/downloads)**
- Instalar con la configuracion predeterminada
- Prueba de version

---

```bash
git --version
```

---

### 3. Instalacion Java


---

```bash
 dotnet --version
```

---

### 4. Configuracion Git y clave SSH

- Configuracion inicial Git

---

```bash
git config --global user.name "Tu nombre"

git config --global user.email "tu_correo@example.com"
```

---

Usa el mismo correo que tienes en **[GitHub](https://github.com/login)**

---

#### 4.1. Generar y agragar clave SSH a GitHub

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

### 5. Clonar un repositorio de GitHub

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

### 6. Crear y cambiar de rama

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

### 7. Crear y ejecutar un proyecto en C#

- Crear una carpeta que vaya a contener el proyecto
- Abre desde la terminal
- En la terminal:

  - `dotnet new console`

- Para ejecutar:

  - `dotnet run`

### 8. Subir cambios a GitHub

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