package ua.nure.kaplun;

/**
 * Created by Anton on 19.02.2017.
 */
public class VernamShirograms {
    private String key;
    private String ciphertext;

    public VernamShirograms(String key, String ciphertext){
        this.key=key;
        this.ciphertext=ciphertext;
    }


    public String getKey() {
        return key;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }
}
