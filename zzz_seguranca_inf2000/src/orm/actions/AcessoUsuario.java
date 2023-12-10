package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import cripto.CriptografarDES;
import cripto.GerarHash;
import orm.modelo.Usuario;

public class AcessoUsuario {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        //String nome = "Dio";

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();
        //String senha = "87654321";

        String hashDaSenha = GerarHash.generateSHA256(senha);

        System.out.println("Senha: " + senha);
        System.out.println("Hash SHA-256: " + hashDaSenha);

        Usuario usuario1 = new Usuario();

        scanner.close();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("exames");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("select u.hashDaSenha from Usuario u where u.nomeDoUsuario = :nomeBuscado");
        query.setParameter("nomeBuscado", nome);
        String hashObtido = (String) query.getSingleResult();
        System.out.println("Hash da Senha: " + hashObtido);
        
        Query query2 = manager.createQuery("select u.senhaCriptografada from Senha u where u.nomeDoUsuario = :nomeBuscado");
        query2.setParameter("nomeBuscado", nome);
        String senhaCriptografadaObtida = (String) query2.getSingleResult();
        System.out.println("Senha criptografada: " + senhaCriptografadaObtida);

        String chaveDescriptografada = CriptografarDES.descriptografar(senhaCriptografadaObtida, senha);
        
        System.out.println("Chave Secreta: " + chaveDescriptografada);

        if (hashObtido.equals(hashDaSenha)) {
            System.out.println("O hash é igual");
            System.out.println("Chave Descriptografada: " + chaveDescriptografada);

            DescriptografaTabelaExame tabelaDescriptografada = new DescriptografaTabelaExame();
            tabelaDescriptografada.DescriptografaTabelaExame(chaveDescriptografada);
        }

        manager.close();
        factory.close();
    }
}