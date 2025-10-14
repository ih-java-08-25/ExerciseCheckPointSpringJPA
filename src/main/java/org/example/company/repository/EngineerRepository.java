package org.example.company.repository;


import org.example.company.model.Engineer;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EngineerRepository extends JpaRepository<Engineer, Long> {
    @Query(value = "SELECT*FROM engineer WHERE spesialty=?1",nativeQuery = true)
    List<Engineer>findBySpecialtyNative(String specialty);

}
