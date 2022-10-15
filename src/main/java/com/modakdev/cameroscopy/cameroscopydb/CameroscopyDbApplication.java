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
		//SpringApplication.run(CameroscopyDbApplication.class, args);
		System.out.println(EncryptionModule.decrypt("jub4kgWxGmcaGB31KASpHRxSftbwjGAJqm7qxTEEgk+hDEhNTe4foaWDaKUb/uSoZlb9vRA+sxp0hAX/Z3NrIsNAQPz9LIubSNUxysCngF5+2gp1jtkLLmki64J2LPdajP6snK+cQ/MCO2mQf7JvppIf8DVbBKe7N6etuwuNlMIyKRL5L7B5EnEvt9fSsJrUdoVuXCwkAPZ+WNocP85VaB8OIV5+KlGwUdJUj0ETQY61pkjZY92yDoKHzKuf0Zmnx59kzEf5u0NuZQLT5qOSzuTT1FO609ftCPeUhRg0NUj3Kghc79Cfr8bKgQYpLMyXloFO8Tu4wGJkItWN2YtRTA=="));

	}

}
