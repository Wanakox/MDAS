#!/bin/bash

# Cambiar al directorio del proyecto
cd "$(dirname "$0")"

# Variables
SRC_DIR="./src"
OUT_DIR="./out"
MAIN_CLASS="main.app.Main"

# Crear el directorio de salida si no existe
if [ ! -d "$OUT_DIR" ]; then
    mkdir "$OUT_DIR"
fi

# Compilar el proyecto
javac -d "$OUT_DIR" $(find "$SRC_DIR" -name "*.java")
if [ $? -ne 0 ]; then
    echo "Error durante la compilación."
    exit 1
fi

# Ejecutar el proyecto
java -cp "$OUT_DIR" "$MAIN_CLASS"
if [ $? -ne 0 ]; then
    echo "Error durante la ejecución."
    exit 1
fi
