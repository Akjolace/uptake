package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Advertisement;

import java.util.List;

public interface AdsService {
    public void saveAds(Advertisement ads);

    public List<Advertisement> findAll();
}
