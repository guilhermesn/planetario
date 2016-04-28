package planetario;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConectaBD {

    Session sessao = null;
    
    public static void conectar(){
        try{
            Session sessao = HibernateUtil.getSessionFactory().openSession();
        }finally{
            if (sessao != null) {
                sessao.close();
            }
        }
    }
}
