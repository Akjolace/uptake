package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Ads;

import java.util.List;

public interface AdsService {

    public List<Ads> getAllAds();

    public void saveAds(Ads ads);

    public void deleteAds(Ads ads);

    public void deleteAllAds();
}
