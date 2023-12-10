import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;

public class TesteDescriptografar {

    public static void main(String[] args) {
        int textoParaCriptografar = 12345678;
        int chaveParaCriptografar = 22828777;
        String textoParaDescriptografar = "a96I+vuNs0L8wm1hxH5JgA=="
        		+ "";
        int chaveParaDescriptografar = 22828777;

        TesteDescriptografar teste = new TesteDescriptografar();

        try {
            String textoCriptografado = teste.criptografar(textoParaCriptografar, chaveParaCriptografar);
            teste.descriptografar(textoParaDescriptografar, chaveParaDescriptografar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String criptografar(int texto, int chave) throws Exception {
        DESKeySpec keySpec = new DESKeySpec(String.valueOf(chave).getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] textoCriptografado = cipher.doFinal(String.valueOf(texto).getBytes());

        System.out.println("Texto criptografado: " + Base64.getEncoder().encodeToString(textoCriptografado));

        // Não há retorno aqui
        return Base64.getEncoder().encodeToString(textoCriptografado);
    }

    public void descriptografar(String textoCriptografado, int chave) throws Exception {
        DESKeySpec keySpec = new DESKeySpec(String.valueOf(chave).getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] textoDescriptografado = cipher.doFinal(Base64.getDecoder().decode(textoCriptografado));

        System.out.println("Texto descriptografado: " + new String(textoDescriptografado));

        // Não há retorno aqui
    }
}