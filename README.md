## run in terminal:

- gesamte test mit ->  `mvn clean test`


- bestimmter scenario mit -> `mvn clean test -Dgroups="Tag"`
wobei tag ist annotation wie `@login`, die vor einem scenario geschrieben werden kann.

## Hinweise
- __nur__ bei Notwendigkeit [pom.xml](pom.xml) bearbeiten, denn irgendeine falsche oder nicht notwendige "dependency" führt zu nicht ausführbaren Test.
- der Report in  [cucumber-html-reports](report/cucumber-html-reports) wird __nur__ generiert, wenn der Test in Terminal ausgeführt wird.