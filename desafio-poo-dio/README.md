# desafio-poo-dio

Projeto Java 11 com modelagem POO do desafio DIO Bootcamp.

## Pacotes e classes

- `br.com.dio.desafio.Main`
- `br.com.dio.desafio.dominio.Conteudo`
- `br.com.dio.desafio.dominio.Curso`
- `br.com.dio.desafio.dominio.Mentoria`
- `br.com.dio.desafio.dominio.Bootcamp`
- `br.com.dio.desafio.dominio.Dev`

## Executar sem Maven

```powershell
Push-Location "C:\Users\c.souza.dos.reis\desafio-dio-POO\desafio-poo-dio"
New-Item -ItemType Directory -Force -Path out | Out-Null
javac --release 11 -d out src\main\java\br\com\dio\desafio\dominio\*.java src\main\java\br\com\dio\desafio\Main.java src\test\java\br\com\dio\desafio\MainSmokeTest.java
java -cp out br.com.dio.desafio.Main
java -cp out br.com.dio.desafio.MainSmokeTest
Pop-Location
```

## Executar com Maven

```powershell
Push-Location "C:\Users\c.souza.dos.reis\desafio-dio-POO\desafio-poo-dio"
mvn clean package
Pop-Location
```

