package com.example.business.data.services;

import com.example.business.data.entities.Image;
import com.example.business.data.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService extends AbstractService<Image, Integer> {

    ImageRepository imageRepository;

    //todo
}