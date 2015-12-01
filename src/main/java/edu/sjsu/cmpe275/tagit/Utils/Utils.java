package edu.sjsu.cmpe275.tagit.Utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;

public class Utils {

    public static String passwordEncrypter(String password)
    {
        String generatedDigest = null;

        try{
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(password.getBytes());

            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedDigest = sb.toString();
        }catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        return generatedDigest;
    }

    public static String sessionIdGenerator()
    {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println(" time :"+timestamp.toString());
        return timestamp.toString();
    }
}
