package com.code.myapp3.dao;

import com.code.myapp3.entity.UserDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(UserDetail theUserDetail) {
        entityManager.persist(theUserDetail);
    }

    @Override
    public UserDetail findById(Object username) {
        return entityManager.find(UserDetail.class, username);    }

    @Override
    public List<UserDetail> findAll() {

        TypedQuery<UserDetail> theQuery = entityManager.createQuery("FROM UserDetail", UserDetail.class);

        return theQuery.getResultList();
    }

    @Transactional
    @Override
    public void update(UserDetail theUserDetail) {
        entityManager.merge(theUserDetail);
    }

}
