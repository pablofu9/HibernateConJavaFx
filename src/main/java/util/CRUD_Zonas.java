package util;

import entity.Zona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CRUD_Zonas {

    public static void insertarZona(Zona z){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(z);

        session.getTransaction().commit();
        session.close();


    }
    //Metodo para recorrer la tabla y meter todas las zonas en una lista
    public static List<Zona> llenarTabla(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();
        List<Zona> lista = session.createQuery("from Zona").getResultList();
        return lista;

    }

    //Metodo para modificar
    /*Lo que hacemos es, crear una nueva zona de la zona que encuentre y cambiarle el nombre por lo que haya en el textfield*/
    public static void modificarZona(int id,String nombre){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = HibernateUtil.getSession();
        Zona nuevaZona= (Zona) session.createQuery("FROM Zona  WHERE id_zona ="+id).uniqueResult();
        nuevaZona.setNombre_zona(nombre);
        session.beginTransaction();
        session.update(nuevaZona);
        session.getTransaction().commit();
        session.close();
    }

}
