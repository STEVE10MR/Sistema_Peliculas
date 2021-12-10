/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.cube.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
/**
 * REST Web Service
 *
 * @author USUARIO
 */
@Path("Imagen")
public class ImagenResource {

    @Context
    private UriInfo context;

    public ImagenResource() {
    }

    final String UPLOAD_FILE_SERVER="D:/DFD/Proyecto_Tomcats/web/image-url/";
    
    @GET
    @Path("/download/{imagen}")
    @Produces("image/jpg")
    public Response downloadImageFile(@PathParam("imagen")String imagen) {
        //TODO return proper representation object
        File file=new File(UPLOAD_FILE_SERVER+imagen);
        Response.ResponseBuilder responseBuilder=Response.ok((Object)file);
        responseBuilder.header("Content-Disposition", "attachment:filename-\""+imagen+"\"");
        return responseBuilder.build();
    }

    @POST
    @Path("/subir")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadImageFile(
            @FormDataParam("fichero") InputStream fileInputStream,
            @FormDataParam("fichero") FormDataContentDisposition fileFormDataContentDisposition) {
 
        String fileName = null;
        String uploadFilePath = null;
 
        try {
            fileName = fileFormDataContentDisposition.getFileName();
            uploadFilePath = writeToFileServer(fileInputStream, fileName);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        finally{
        }
        return Response.ok("Fichero subido a " + uploadFilePath).build();
    }
 
    private String writeToFileServer(InputStream inputStream, String fileName) throws IOException {
 
        OutputStream outputStream = null;
        String qualifiedUploadFilePath = UPLOAD_FILE_SERVER + fileName;
 
        try {
            outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally{
            outputStream.close();
        }
        return qualifiedUploadFilePath;
    }

}
