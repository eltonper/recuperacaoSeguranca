package cripto;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GerarHash {

	public static String generateSHA256(String input) {
		try {
			// Obtém uma instância de MessageDigest com o algoritmo SHA-256
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			// Converte a string de entrada para bytes usando UTF-8
			byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

			// Converte o array de bytes para uma representação hexadecimal
			StringBuilder hexString = new StringBuilder();
			for (byte b : encodedhash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			// Trate a exceção, se o algoritmo não estiver disponível
			e.printStackTrace();
			return null;
		}
	}
}

