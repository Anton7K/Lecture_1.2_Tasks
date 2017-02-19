package ua.nure.kaplun;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import  java.util.Random;
/**
 * Created by Anton on 19.02.2017.
 */
public class DisposableNotepad {
    private static  final String RUSSIAN_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    private static String applyXorToText(String text, String key){
            char[] txtBytes = text.toCharArray();
            char[] keyBytes = key.toCharArray();
            char[] result = new char[txtBytes.length];
            for (int i = 0; i < txtBytes.length; i++) {
                result[i] = (char) (txtBytes[i] ^ keyBytes[i]);
            }
        return String.valueOf(result);
    }
    private static String generateKey(int lenght){
        Random random = new Random();
        StringBuilder keyBuilder = new StringBuilder();
        int positionInAlphabet;
        for(int i=0; i < lenght; i++){
            positionInAlphabet=random.nextInt(RUSSIAN_ALPHABET.length());
            keyBuilder.append(RUSSIAN_ALPHABET.charAt(positionInAlphabet));
        }
        return keyBuilder.toString();
    }

    public static VernamShirograms encrypt(String text){
        String key = generateKey(text.length());
        String encrText = applyXorToText(text, key);

        return new VernamShirograms(key, encrText);
    }

    public static String decrypt(String text, String key){
        return applyXorToText(text, key);
    }
    public static void main(String[] args){

        String textForEncryption="вася";
        VernamShirograms shirograms = encrypt(textForEncryption);
        String encrText = shirograms.getCiphertext();
        String encrKey = shirograms.getKey();
        String decrText=decrypt(encrText, encrKey);

        System.out.println("Encrypt text:");
        System.out.println(textForEncryption);
        System.out.println("Using key: " + encrKey);
        System.out.println("Result of encryption:");
        System.out.println(encrText);
        System.out.println("Result of decryption:");
        System.out.println(decrText);

    }
}
