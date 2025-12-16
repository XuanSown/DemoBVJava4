package dao.impl;

import java.util.List;

import dao.UserDAO;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import util.XJPA;

public class UserDAOImpl implements UserDAO {

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			User user = em.find(User.class, id);
			if (user != null) {
				em.remove(user);
			}
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			trans.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		try {
			return em.find(User.class, id);
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		try {
			String jpql = "select u from User u";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			return query.getResultList();
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}

	@Override
	public List<User> findByFullname(String fullname) {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		try {
			String jpql = "select u from User u where u.fullname like :fullname";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("fullname", "%" + fullname + "%");
			return query.getResultList();
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}

}
