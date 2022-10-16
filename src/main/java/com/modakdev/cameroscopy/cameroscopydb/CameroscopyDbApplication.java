package com.modakdev.cameroscopy.cameroscopydb;

import com.modakdev.cameroscopy.cameroscopydb.api.EncryptionModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CameroscopyDbApplication {

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RoughApplication.class);
	}*/
	public static void main(String[] args) {
		SpringApplication.run(CameroscopyDbApplication.class, args);

		//System.out.println(EncryptionModule.encrypt("abc"));
		//System.out.println(EncryptionModule.decrypt("P+Ml2Cn1NduKuMd7TNMsVquorS3fALLe2CXDsdcML2138dYiYT8sFUv0urBVyBTU/7ba2DnRj1KYvsl9GSQ1pn86fMs+iJ6DXUoNpeponOrYiMpONAUU7nUNib8GseBlVMA0SD1p8xR4r+AYWPJeChCTKNhHuxwvdFisshsZLsJ9WPd+wObBpLIouQOKi1uZgFDcaiUoZoJHuXynkqVwoX1NXZiosc8ondjLb04MA7oiY+GC+m1jDxlW/VrqpTYcQ7VawGYWGOGIVSvkLtEYcgknL15UZ8g45DFJEB0IO1n0rio5c7rc4FL6GlcXX4PfcQka+8sVjk0v+nDfWcPaVw=="));

	}

}
