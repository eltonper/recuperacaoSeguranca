package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cripto.CriptografarDES;
import cripto.GerarHash;
import orm.modelo.Senha;
import orm.modelo.Usuario;

public class InserirUsuarioHash {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do usuario: ");
        String nome = scanner.nextLine();
        //String nome="Dio";

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();
        //String senha="87654321";
        
		String hashDaSenha = GerarHash.generateSHA256(senha);

		System.out.println("Senha: " + senha);
		System.out.println("Hash SHA-256: " + hashDaSenha);
		
		String ChaveSecretaCriptografada = CriptografarDES.criptografar("12345678", senha);
	
		scanner.close();

        Usuario usuario1 = new Usuario();
        usuario1.setNomeDoUsuario(nome);
        usuario1.setHashDaSenha(hashDaSenha);
        
        Senha senha1 = new Senha();
        senha1.setNomeDoUsuario(nome);
        senha1.setSenhaCriptografada(ChaveSecretaCriptografada);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("exames");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        
        manager.persist(usuario1);
        manager.persist(senha1);
        
        
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}