package com.modakdev.cameroscopy.cameroscopydb.configuration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CameroscopyClientUserRepository extends JpaRepository<CameroscopyClientUser, Long> {

        CameroscopyClientUser findByEmail(String email);
        Optional<CameroscopyClientUser> findById(Long id);
}
