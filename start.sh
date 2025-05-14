javac -d bin -sourcepath src/main $(find src/main -name "*.java")

jar cfm app.jar MANIFEST.mf -C bin .

java -jar app.jar