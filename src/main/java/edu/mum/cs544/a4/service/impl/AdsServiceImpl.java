package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.Ads;
import edu.mum.cs544.a4.repository.AdsRepository;
import edu.mum.cs544.a4.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdsServiceImpl implements AdsService {

    private AdsRepository adsRepository;

    @Autowired
    public AdsServiceImpl(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    @Override
    public void saveAds(Ads ads) {
        adsRepository.save(ads);
    }

    @Override
    public List<Ads> findAll() {
        return adsRepository.findAll();
    }

    @Override
    public void deleteAds(Ads ads) {
        adsRepository.delete(ads);
    }

    @Override
    public void deleteAllAds() {
        adsRepository.deleteAll();
    }


}
