package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.Advertisement;
import edu.mum.cs544.a4.repository.AdsRepository;
import edu.mum.cs544.a4.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsServiceImpl implements AdsService {

    @Autowired
    AdsRepository adsRepository;

    @Override
    public void saveAds(Advertisement ads) {
        adsRepository.save(ads);
    }

    @Override
    public List<Advertisement> findAll() {
        return adsRepository.findAll();
    }
}
