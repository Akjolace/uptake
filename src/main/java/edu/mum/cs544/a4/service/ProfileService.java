package edu.mum.cs544.a4.service;

import edu.mum.cs544.a4.entity.Profile;

public interface ProfileService {

    Profile findByProfileName(String profileName);
}
