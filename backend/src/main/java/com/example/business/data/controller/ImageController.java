package com.example.business.data.controller;

import com.example.business.data.entities.Image;
import com.example.business.data.services.ImageService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.ArrayUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/image")
@OpenAPIDefinition
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping(path = "/{image_id}")
    @ResponseBody
    public Optional<Image> getImageById(@PathVariable int image_id) {
        return imageService.getEntityByID(image_id);
    }

    @GetMapping(path = "/all")
    public Iterable<Image> getAllImages() {
        return imageService.getAllEntities();
    }

    @PostMapping(path = "/create")
    @ResponseBody
    public ResponseEntity<?> createImage(@RequestBody Image newImage) {
        return imageService.createEntity(newImage, newImage.getImage_id());
    }

    @DeleteMapping(path = "/delete/{image_id}")
    @ResponseBody
    public ResponseEntity<?> deleteImage(@PathVariable int image_id) {
        return imageService.deleteEntityById(image_id);
    }

    @PutMapping(path = "/edit/{image_id}")
    @ResponseBody
    public ResponseEntity<?>  editExpense(@RequestBody Image newImageInfo, @PathVariable int image_id) {
        return imageService.editEntity(newImageInfo, image_id);
    }

    @GetMapping(value = "/display")
    public void showImage(@RequestParam("id") Integer image_id, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {


        Optional<Image> image = imageService.getEntityByID(image_id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");


        Byte[] convert = image.get().getImage();
        byte[] b2 = new byte[convert.length];
        for (int i = 0; i < convert.length; i++)
        {
            b2[i] = convert[i];
        }

        response.getOutputStream().write(b2);
        response.getOutputStream().close();
    }


}
