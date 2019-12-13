package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.Photo;
import edu.mum.cs544.a4.repository.PhotoRepository;
import edu.mum.cs544.a4.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public Long savePhoto(Photo photo) {
        photoRepository.save(photo);
        return photo.getId();
    }

    @Override
    public Photo getPhoto(int photoId) {
        return null;
    }

}
