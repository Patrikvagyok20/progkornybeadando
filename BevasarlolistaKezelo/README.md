# Bevásárlólista kezelő

## Mit tud a program?
- bevásárlólista létrehozása
- bevásárlólista lekérdezése
- bevásárlólista módosítása
- bevásárlólista törlése
- tétel létrehozása
- tétel lekérdezése
- tétel módosítása
- tétel törlése
- egy lista tételeinek lekérdezése

## Használt technológiák
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 adatbázis
- Maven

## Adatbázistáblák
### 1. BevasarloLista
- azonosito
- nev

### 2. Tetel
- azonosito
- megnevezes
- mennyiseg
- bevasarolt
- lista_azonosito

Kapcsolat: egy bevásárlólistához több tétel tartozhat.

## Indítás
Terminálban a projekt gyökérmappájában:

```bash
mvn spring-boot:run
```

Vagy előbb build:

```bash
mvn clean package
java -jar target/bevasarlolista-kezelo-1.0.0.jar
```

## H2 konzol
- URL: `http://localhost:8080/h2-konzol`
- JDBC URL: `jdbc:h2:mem:bevasarlolistaadatbazis`
- Felhasználónév: `sa`
- Jelszó: üres

## Végpontok
### Bevásárlólisták
- `GET /listak`
- `GET /listak/{azonosito}`
- `POST /listak`
- `PUT /listak/{azonosito}`
- `DELETE /listak/{azonosito}`
- `GET /listak/{azonosito}/tetelek`

### Tételek
- `GET /tetelek`
- `GET /tetelek/{azonosito}`
- `POST /tetelek`
- `PUT /tetelek/{azonosito}`
- `DELETE /tetelek/{azonosito}`

## Példa kérések
### Lista létrehozása
```json
{
  "nev": "Heti bevásárlás"
}
```

### Tétel létrehozása
```json
{
  "megnevezes": "Tej",
  "mennyiseg": 2,
  "bevasarolt": false,
  "listaAzonosito": 1
}
```
