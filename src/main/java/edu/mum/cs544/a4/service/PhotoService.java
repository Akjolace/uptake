package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Photo;

public interface PhotoService {
    public Long savePhoto(Photo photo);

    public Photo getPhoto(Long photoId);
}
