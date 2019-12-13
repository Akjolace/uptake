package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Photo;

public interface PhotoService {

    public Photo savePhoto(String path);

    public Photo getPhoto(int photoId);
}
