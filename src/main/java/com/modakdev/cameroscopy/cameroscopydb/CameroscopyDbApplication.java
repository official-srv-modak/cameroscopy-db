package com.modakdev.cameroscopy.cameroscopydb;

import com.modakdev.cameroscopy.cameroscopydb.encryption.EncryptionModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
@EnableAutoConfiguration
public class CameroscopyDbApplication {

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RoughApplication.class);
	}*/
	public static void main(String[] args) {
		SpringApplication.run(CameroscopyDbApplication.class, args);

		System.out.println(EncryptionModule.encrypt("srvmodak@gmail.com"));
		System.out.println(EncryptionModule.encrypt("Sourav"));
		System.out.println("))))))))))");
		System.out.println(EncryptionModule.decrypt("HVy6Wz1d9tnSSoJkNuPmhJzd7MbvM76gBJErTOJu7KfA5Jpakvavzl3B6EM6dj4gwyUBEUi15ZsPS3uwJzAPUvKs+rEYVotw5rvrgcnw6h7qXJAY9/Gp1uWMVikxhAG3mTapVChR6kHu6JR6jdtk3VZgd6JiaEydE9ruXyPDYEwKuZXrlL6372jTlgAG0egpDFVMI6Jarbz+b1X9/YO/iaWFMfwdGhJ0JJ711TBMme//Ihc03Tc0Uwrpmh7Nut8eJDUDfB+HHfIzLw+Hs88WveYv+0baz7AxvmDPdI8pMj4wNgiFE+d4/F3bAaKRVKm8EMSeqJ+PDGkfMNsARKm+bw=="));
		System.out.println(EncryptionModule.encrypt("Modak"));
		System.out.println(EncryptionModule.encrypt("USER"));
		System.out.println(EncryptionModule.decrypt("P+Ml2Cn1NduKuMd7TNMsVquorS3fALLe2CXDsdcML2138dYiYT8sFUv0urBVyBTU/7ba2DnRj1KYvsl9GSQ1pn86fMs+iJ6DXUoNpeponOrYiMpONAUU7nUNib8GseBlVMA0SD1p8xR4r+AYWPJeChCTKNhHuxwvdFisshsZLsJ9WPd+wObBpLIouQOKi1uZgFDcaiUoZoJHuXynkqVwoX1NXZiosc8ondjLb04MA7oiY+GC+m1jDxlW/VrqpTYcQ7VawGYWGOGIVSvkLtEYcgknL15UZ8g45DFJEB0IO1n0rio5c7rc4FL6GlcXX4PfcQka+8sVjk0v+nDfWcPaVw=="));

	}

}
