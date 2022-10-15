package com.modakdev.cameroscopy.cameroscopydb.configuration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CameroscopyClientUserRepository extends JpaRepository<CameroscopyClientUser, Long> {

        CameroscopyClientUser findByEmail(String email);
}
