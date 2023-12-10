package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import orm.modelo.Exame;
import cripto.CriptografarDES;

public class DescriptografaTabelaExame {
    public void DescriptografaTabelaExame(String chaveDescriptografada) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("exames");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("select a from Exame a");

        List<Exame> lista = query.getResultList();

        System.out.printf("TABELA EXAME CRIPTOGRAFADA\n\n%-5s%-20s%-20s%-20s%-20s%n", "Id", "Tipo", "Medico",
                "Paciente", "Resultado");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------");

        for (Exame a : lista) {
            System.out.printf("%-5s%-20s%-20s%-20s%-20s%n", a.getId(), a.getTipoDeExame(), a.getMedico(),
                    a.getPaciente(), a.getResultado());
        }

        Query queryd = manager.createQuery("select a from Exame a");

        List<Exame> listad = queryd.getResultList();

        System.out.printf("\n\n\nTABELA EXAME DESCRIPTOGRAFADA\n\n%-5s%-20s%-20s%-20s%-20s%n", "Id", "Tipo", "Medico",
                "Paciente", "Resultado");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------");

        for (Exame a : listad) {

            System.out.printf("%-5s%-20s%-20s%-20s%-20s%n", a.getId(),
                    CriptografarDES.descriptografar(a.getTipoDeExame(), chaveDescriptografada),
                    CriptografarDES.descriptografar(a.getMedico(), chaveDescriptografada),
                    CriptografarDES.descriptografar(a.getPaciente(), chaveDescriptografada),
                    CriptografarDES.descriptografar(a.getResultado(), chaveDescriptografada));
        }

        manager.close();
        factory.close();
    }
}