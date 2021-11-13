# SINATRA APP


### Estado del proyecto

El proyecto se encuentra en proceso : _in progress_ <!-- / _complete_ /-->

### Equipo de trabajo

Desarrollado por:

- Maria Jose Jadnat Perez Alba
- Héctor Alexander Martínez
- Ivan Gabriel Ibarra
- Daniel Felipe Ramirez Ferrín 
- Yessid Samir Acosta Guatusmal

## Instalación
Clonar este repositorio y abrirlo desde **Android Studio**
```bash
git clone https://github.com/sinatra-mintic/sinatra-app
```

## Configuración
### Keystores:
Create `app/keystore.gradle` with the following info:
```gradle
ext.key_alias='...'
ext.key_password='...'
ext.store_password='...'
```
And place both keystores under `app/keystores/` directory:
- `playstore.keystore`
- `stage.keystore`


## Generar APK firmado
Seguir los siguientes paso en Android Studio:
1. Ir a ***Build***
2. ***Generate Signed APK...***

## Maintainers
Este proyecto está siendo mantenido por:
* SINATRA

