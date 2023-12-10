package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cripto.CriptografarDES;
import orm.modelo.Exame;

public class InserirExame {
    public static void main(String[] args) throws Exception {

        String tipoDeExame="Gama Glutamil Transferase";
        String medico = "Who";
        String paciente = "Joseph";
        String resultado = "30";
        
        tipoDeExame = CriptografarDES.criptografar(tipoDeExame, "12345678");
        medico = CriptografarDES.criptografar(medico, "12345678");
        paciente = CriptografarDES.criptografar(paciente, "12345678");
        resultado = CriptografarDES.criptografar(resultado, "12345678");
        
        System.out.println(tipoDeExame);
        
        Exame exame1 = new Exame();
        exame1.setTipoDeExame(tipoDeExame);
        exame1.setMedico(medico);
        exame1.setPaciente(paciente);
        exame1.setResultado(resultado);
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("exames");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(exame1);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}