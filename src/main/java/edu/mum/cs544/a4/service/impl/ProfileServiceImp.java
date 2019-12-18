package edu.mum.cs544.a4.service.impl;

import edu.mum.cs544.a4.entity.Profile;
import edu.mum.cs544.a4.repository.ProfileRepository;
import edu.mum.cs544.a4.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImp implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfileById(long profileId) {
        return profileRepository.findById(profileId);
    }
}
