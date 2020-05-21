# Java crypto sign
Utility java project for handle and create api signature and crypto operations with various file formats.

The class CryptoUtility also provides the generation of public/private key pairs for generic purposes.


## Formats and methods supported

- ##### Generic files:
    - Verify signature
    - Write signature
- ##### Xml :
    - Check XADES signature
    - Conversion Base64 to Xml format and viceversa
    - ##### Xades
      - Verify XADES (Todo)
      - Write XADES (Todo)
      - Create CA (Todo)
- ##### Pdf (Todo)
- ##### Zip (Todo)
- ##### Other (Todo)

## Installation

Prerequisite: Maven 3.6.2 and Java 13.0.2

## Usage

For try the Check xml signature method:

```
mvn clean install
```
```
cd bin
```
```
java -jar java-crypto-sign.jar {$PATHFILE}
```



 
     
 
 





