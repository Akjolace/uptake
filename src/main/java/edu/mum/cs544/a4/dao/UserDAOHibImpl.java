package edu.mum.cs544.a4.dao;

import edu.mum.cs544.a4.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOHibImpl implements UserDAO{

    // define field for EM entity Manager


    // set up Constructor injection


    @Override
    public List<User> findAll() {
        return null;
    }
}
