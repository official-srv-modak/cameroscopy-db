package com.modakdev.cameroscopy.cameroscopydb.encryption;

import com.modakdev.cameroscopy.cameroscopydb.api.UserOperationsService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Configuration
public class AESEncryption implements AttributeConverter<Object, String> {

    @Value("${aes.encryption.key}")
    private String encryptionKey;
    public static final Logger LOGGER = LoggerFactory.getLogger(AESEncryption.class);

    private final static String encryptionCipher = "AES";

    private static Key key;
    private static Cipher cipher;

    private Key getKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
        if(key == null)
        {
            /*SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 256); // AES-256
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] keyByte = f.generateSecret(spec).getEncoded();
            key = new SecretKeySpec(keyByte, "AES");*/
            key = new SecretKeySpec(encryptionKey.getBytes(), encryptionCipher);
        }
        return key;
    }

    private void initCipher(int encyptionMode) throws GeneralSecurityException {
        getCipher().init(encyptionMode, getKey());
    }

    public static Cipher getCipher() throws GeneralSecurityException {
        if(cipher == null)
            cipher = Cipher.getInstance(encryptionCipher);
        return cipher;
    }

    @Override
    public String convertToDatabaseColumn(Object attribute) {
        if(attribute == null)
            return null;
        try
        {
            initCipher(Cipher.ENCRYPT_MODE);
            byte[] bytes = SerializationUtils.serialize(attribute);
            return Base64.getEncoder().encodeToString(getCipher().doFinal(bytes));
        }
        catch(Exception e)
        {
            LOGGER.error("Exception occurred : "+e);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        if(dbData == null)
            return null;
        try
        {
            initCipher(Cipher.DECRYPT_MODE);
            byte[] bytes = getCipher().doFinal(Base64.getDecoder().decode(dbData));
            return SerializationUtils.deserialize(bytes);
        }
        catch(Exception e)
        {
            LOGGER.error("Exception occurred : "+e);
            e.printStackTrace();
            return null;
        }

    }
}
