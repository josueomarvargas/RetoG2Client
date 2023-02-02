/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

import java.security.spec.X509EncodedKeySpec;

import java.util.ResourceBundle;

import javax.crypto.Cipher;

/**
 *
 * @author josue
 */
public class Cifrado {

    private static final String CLAVEPUBLICA = ResourceBundle.getBundle("cifrado.clavePublica").getString("clave");

    //private static final ResourceBundle configFile = ResourceBundle.getBundle("clave.properties");
    private static byte[] salt = "esta es la salt!".getBytes();
    private byte[] iv;
    private static String clave = "abcd1234";

    /**
     * Retorna el contenido de un fichero
     *
     * @return El texto del fichero
     * @throws java.io.IOException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.spec.InvalidKeySpecException
     */
    public static PublicKey leerClavePublica() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] clavePu = hexStringToByteArray(CLAVEPUBLICA);
        X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(clavePu);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(publicSpec);
    }

    /**
     * public static PrivateKey leerClavePrivada() throws IOException,
     * NoSuchAlgorithmException, InvalidKeySpecException { PrivateKey pvKey =
     * null; try { // Obtener los bytes del archivo donde este guardado la llave
     * publica byte[] pvKeyBytes =
     * hexStringToByteArray(configFile.getString("PRIVATEKEY")); //
     * PKCS8EncodedKeySpec encPvKeySpec = new PKCS8EncodedKeySpec(pvKeyBytes);
     * // pvKey = KeyFactory.getInstance("RSA").generatePrivate(encPvKeySpec); }
     * catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
     * Logger.getLogger(Cifrado.class.getName()).log(Level.SEVERE, null, ex); }
     * return pvKey; }
     * @param s
     * @return 
     */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    /**
     * Retorna una concatenaci�n de ambos arrays
     *
     * @param array1
     * @param array2
     * @return Concatenaci�n de ambos arrays
     */
    private byte[] concatArrays(byte[] array1, byte[] array2) {
        byte[] ret = new byte[array1.length + array2.length];
        System.arraycopy(array1, 0, ret, 0, array1.length);
        System.arraycopy(array2, 0, ret, array1.length, array2.length);
        return ret;
    }

    /**
     *
     * @param mensaje
     * @return
     */
    public String cifrarTexto1(String mensaje) {
        byte[] encodedMessage = null;
        try {

            //Generamos una instancia de KeyFactory para el algoritmo RSA
            //Ciframos el mensaje con el algoritmo RSA modo ECB y padding PKCS1Padding
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, leerClavePublica());
            encodedMessage = cipher.doFinal(mensaje.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayToHexString(encodedMessage);
    }

    /**
     *
     * @param bytes
     * @return
     */
    public static String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
