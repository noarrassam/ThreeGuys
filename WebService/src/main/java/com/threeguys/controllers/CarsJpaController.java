/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threeguys.controllers;

import com.mycompany.threeguyswebservice.resources.exceptions.NonexistentEntityException;
import com.mycompany.threeguyswebservice.resources.exceptions.PreexistingEntityException;
import com.threeguys.entites.Cars;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author noorr
 */
public class CarsJpaController implements Serializable {

    public CarsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cars cars) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cars);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCars(cars.getId()) != null) {
                throw new PreexistingEntityException("Cars " + cars + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cars cars) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cars = em.merge(cars);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cars.getId();
                if (findCars(id) == null) {
                    throw new NonexistentEntityException("The cars with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cars cars;
            try {
                cars = em.getReference(Cars.class, id);
                cars.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cars with id " + id + " no longer exists.", enfe);
            }
            em.remove(cars);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cars> findCarsEntities() {
        return findCarsEntities(true, -1, -1);
    }

    public List<Cars> findCarsEntities(int maxResults, int firstResult) {
        return findCarsEntities(false, maxResults, firstResult);
    }

    private List<Cars> findCarsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cars.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cars findCars(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cars.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cars> rt = cq.from(Cars.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
     public List<Cars> getAllCars(){
     EntityManager em = getEntityManager();
        
     Query query = em.createNamedQuery("Cars.findAll");
     return query.getResultList();
    }
    
}
