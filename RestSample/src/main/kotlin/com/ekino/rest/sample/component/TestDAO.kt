package com.ekino.rest.sample.component

import com.ekino.rest.sample.model.Test
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Repository
@Transactional
class TestDAO {

    @PersistenceContext
    private lateinit var entityManager : EntityManager

    fun create(test: Test){
        entityManager.persist(test)
    }
}