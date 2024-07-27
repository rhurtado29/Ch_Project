package com.chconstructora.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "chconstructora-daa8e";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "chconstructora";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "chconstructora-daa8e-firebase-adminsdk-8rqsu-61f6e162b5";
}
