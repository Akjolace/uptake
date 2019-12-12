package edu.mum.cs544.a4.repository;

import edu.mum.cs544.a4.entity.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsRepository extends JpaRepository<Advertisement,Long> {


}
