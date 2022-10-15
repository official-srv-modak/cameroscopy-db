package com.modakdev.cameroscopy.cameroscopydb.configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameroscopyUserRepository extends JpaRepository<CameroscopyUser, Long> {

    CameroscopyUser findByUsername(String username);
}
