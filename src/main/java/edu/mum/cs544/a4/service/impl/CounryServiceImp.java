package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.Country;
import edu.mum.cs544.a4.repository.CountryRepository;
import edu.mum.cs544.a4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounryServiceImp implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }
}
