package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.ValorPadrao;

public class CriarTabelaValorPadrao {
    public static void main(String[] args) throws Exception {

        String tipoDeExame="Gama Glutamil Transferase";
        String valorMinimo = "7";
        String valorMaximo = "60";
         
        ValorPadrao valorPadrao1 = new ValorPadrao();
        
        valorPadrao1.setTipoDeExame(tipoDeExame);
        valorPadrao1.setValorMinimo(valorMinimo);
        valorPadrao1.setValorMaximo(valorMaximo);
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("exames");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(valorPadrao1);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}