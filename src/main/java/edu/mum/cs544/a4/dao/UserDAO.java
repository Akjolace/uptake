package edu.mum.cs544.a4.dao;


import edu.mum.cs544.a4.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();
}
