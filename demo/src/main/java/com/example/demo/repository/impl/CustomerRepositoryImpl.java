package com.example.demo.repository.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager em;

    @PersistenceUnit
    private EntityManagerFactory emf;

    public Session getHibernateSession() {
        return em.unwrap(Session.class); // access Hibernate session
    }

    public SessionFactory getHibernateSessionFactory() {
        return emf.unwrap(SessionFactory.class); // access SessionFactory
    }

    @Override
    public List<Customer> selectAll() {
        String jpql = "SELECT c FROM Customer c";
        return em.createQuery(jpql, Customer.class)
                .getResultList();
    }

    @Override
    public Customer selectById(Long id) {
        return em.find(Customer.class, id);
    }

    @Override
    public Customer selectByEmail(String email) {
        String jpql = "SELECT c FROM Customer c WHERE c.email = :email";
        return em.createQuery(jpql, Customer.class)
                .setParameter("email", email)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public void insert(Customer customer) {
        em.persist(customer);
    }

    @Override
    public void update(Customer customer) {
        em.merge(customer);
    }

    @Override
    public void delete(Long id) {
        Customer customer = em.find(Customer.class, id);
        if (Optional.ofNullable(customer).isPresent()) {
            em.remove(customer);
        }
    }
}
