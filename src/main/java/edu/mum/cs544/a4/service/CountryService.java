package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Country;
import java.util.List;

public interface CountryService {
    List<Country> getAllCountry();

    Country findById(Long id);
}
