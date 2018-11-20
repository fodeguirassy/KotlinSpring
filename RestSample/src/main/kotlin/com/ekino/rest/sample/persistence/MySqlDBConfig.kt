package com.ekino.rest.sample.persistence

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
import javax.sql.DataSource


@EnableAutoConfiguration
@EnableTransactionManagement
class MySqlDBConfig {

    @Autowired
    lateinit var env : Environment

    @Autowired
    lateinit var dataSource : DataSource

    @Autowired
    lateinit var entityManagerFactory : LocalContainerEntityManagerFactoryBean

    @Bean
    fun dataSource() : DataSource {

        var dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName(env.getProperty("db.driver"))
        dataSource.url = env.getProperty("db.url")
        dataSource.username = env.getProperty("db.username")
        dataSource.password = env.getProperty("db.password")

        return dataSource
    }

    @Bean
    fun entityManagerFactory () : LocalContainerEntityManagerFactoryBean {

        var entityManagerFactory = LocalContainerEntityManagerFactoryBean()

        entityManagerFactory.dataSource = dataSource()
        entityManagerFactory.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"))

        var hibernateVendorAdapter = HibernateJpaVendorAdapter()
        entityManagerFactory.jpaVendorAdapter = hibernateVendorAdapter


        var additionalProps = Properties().apply {
            put("hibernate.dialect", env.getProperty("hibernate.dialect"))
            put("hibernate.show_sql", env.getProperty("hibernate.show_sql"))
            put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"))
        }
        entityManagerFactory.setJpaProperties(additionalProps)
        return entityManagerFactory
    }

    @Bean
    fun transactionManager() : JpaTransactionManager {
        var transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory().`object`
        return transactionManager
    }

    @Bean
    fun exceptionTranslation() : PersistenceExceptionTranslationPostProcessor {
        return PersistenceExceptionTranslationPostProcessor()
    }

}

