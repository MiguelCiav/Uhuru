# Uhuru
Aplicación de Escritorio para gestión y práctica de exámenes de certificación.


## Integrantes
+ Cao Carlos
+ Carios César
+ Ciavato Miguel
+ Homsany Jhonatan
+ Reis Erimar

#Enlaces
1. [ Modelos de Dominio. ](#modelo_dominio)
2. [ Modelos de Casos de Uso](#use_case)
4. [ Protipos de interfaz ](#prototipos)
5. [ Modelos de Análisis](#modelo_analisis)
6. [ Modelos de Diseño](#modelo_diseño)
7. [ Librerías](#lib)
8. [ Como usar](#guia)

<a name="modelo_dominio"></a>
## Modelo del dominio
### Diagrama de clases

<p align="center">
  <img style="width:40%; heigth:300px" src="docs\scenariosView\domainModel\ClassDiagram.png">
</p>

### Diagrama de estado
<p align="center">
  <img style="width:60%; heigth:300px" src="docs\scenariosView\domainModel\StateDiagram.png">
</p>

<a name="use_case"></a>
## Modelo de Casos de Uso
## Diagrama de Casos de Uso
<p align="center">
  <img style="width:40%; heigth:300px" src="docs\scenariosView\useCaseModel\usecaseDiagram.png">
</p>

### Diagrama de Estados de los casos de uso
<p align="center">
  <img style="width:60%; heigth:300px" src="docs\scenariosView\useCaseModel\usecaseStateDiagram.png">
</p>

### Especificaciones de los casos de uso
<p align="center">
  <img style="width:60%; heigth:300px" src="docs\scenariosView\useCaseModel\CU1CrearExamen.png">
  <img style="width:60%; heigth:300px" src="docs\scenariosView\useCaseModel\CU2ResponderExamen.png">
  <img style="width:60%; heigth:300px" src="docs\scenariosView\useCaseModel\CU3ObtenerCertificado.png">
</p>

<a name="prototipos"></a>
## Prototipo de pantallas
### Flujo de Usuario
![Prototipos de Pantallas : Flujo Usuario](docs/prototype/Flujo-Usuario.png)
### Flujo de Administrador
![Prototipos de Pantallas : Flujo Usuario](docs/prototype/Flujo-Admin.png)      
### Enlaces 
- [Prototipo Interactivo en Figma](https://www.figma.com/file/dzXOa9yDAVZmEWpZJqrHQO/Prototipo-De-Interfaz?type=design&node-id=0%3A1&mode=design&t=nIYMdCu8Bfcdtu5P-1)
- [Pantallas](docs/prototype/INTERFACE.md)

<a name="modelo_analisis"></a>
## Modelo de Análisis
### Diagrama de clases de analisis
<p align="center">
  <img style="width:60%; heigth:300px" src="/docs/logicalView/analisysView/classAnalisys/analysisClassDiagram.png">
</p>

### Diagrama de clases de análisis y de colaboración de casos de uso prioritarios 

#### UC1 - Crear Examen
<p align="center">
  <img style="width:40%; heigth:300px" src="docs/logicalView/analisysView/usecaseAnalisys/analysisClassDiagramUC1.png">
  <img style="width:80%; heigth:300px" src="docs/logicalView/analisysView/usecaseAnalisys/collaborationDiagramUC1.png">
</p>

#### UC2 - Responder Examen
<p align="center">
  <img style="width:40%; heigth:300px" src="docs/logicalView/analisysView/usecaseAnalisys/analysisClassDiagramUC2.png">
  <img style="width:80%; heigth:300px" src="docs/logicalView/analisysView/usecaseAnalisys/collaborationDiagramUC2.png">
</p>

#### UC3 - Obtener Certificado
<p align="center">
  <img style="width:40%; heigth:300px" src="docs/logicalView/analisysView/usecaseAnalisys/analysisClassDiagramUC3.png">
  <img style="width:80%; heigth:300px" src="docs/logicalView/analisysView/usecaseAnalisys/collaborationDiagramUC3.png">
</p>

### Diagrama de paquetes de análisis
<p align="center">
  <img style="width:80%; heigth:300px" src="docs/logicalView/analisysView/packageAnalisys/packageDiagram.png">
</p>

<a name="modelo_diseño"></a>
## Modelo de Diseño
### Diagrama de clases
<p align="center">
  <img style="width:100%; heigth:300px" src="docs\logicalView\designView\usecaseDesign\designClasses.png">
</p>

### Diagrama de secuencia
<p align="center">
  <img style="width:60%; heigth:300px" src="docs\logicalView\designView\classDesing\sequenceDiagram.png">
</p>

### Diagrama de Traza
<p align="center">
  <img style="width:100%" src="docs\logicalView\designView\packageDesign\traceDiagram.png">
</p>

## Modelo de Despliegue
<p align="center">
  <img src="docs\physicalView\DeploymentDiagram.png">
</p>

<a name="lib"></a>
##Librerías


<a name="Uhuru"></a>
##Como usar Uhuru