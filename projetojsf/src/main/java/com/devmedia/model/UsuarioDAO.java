package com.devmedia.model;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.devmedia.model.HibernateUtil;

public class UsuarioDAO {
	
	HibernateUtil hibernateUtil = new HibernateUtil();
	
	public boolean inserir(Usuario usuario) {
		
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		session.persist(usuario);
		session.getTransaction().commit();
		session.close();
		
		return true;
	}
    public List<Usuario> listar() {
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios = session.createQuery("Select u FROM Usuario u", Usuario.class).getResultList();
        session.close();
        return usuarios;
    }

}
