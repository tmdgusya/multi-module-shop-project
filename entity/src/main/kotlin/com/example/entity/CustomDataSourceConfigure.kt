package com.example.entity

import com.zaxxer.hikari.HikariDataSource
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan("com.example.entity")
class CustomDataSourceConfigure {

  @Primary
  @Bean(name = ["dataSource"])
  @ConfigurationProperties("spring.datasource.hikari")
  fun dataSource(): DataSource {
    return DataSourceBuilder.create()
      .type(HikariDataSource::class.java)
      .build()
  }

  @Primary
  @Bean(name = ["entityManagerFactory"])
  @ConfigurationProperties("spring.jpa.properties.hibernate")
  fun entityManagerFactory(
    @Qualifier("dataSource") dataSource: DataSource,
  ): LocalContainerEntityManagerFactoryBean {
    val em = LocalContainerEntityManagerFactoryBean()
    val vendorAdapter = HibernateJpaVendorAdapter()

    val jpaProps = mutableMapOf<String, Any>(
      "hibernate.format_sql" to true
    )

    vendorAdapter.setShowSql(true)
    vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect")

    em.dataSource = dataSource
    em.setPackagesToScan("com.example.entity")
    em.jpaVendorAdapter = vendorAdapter
    em.setJpaPropertyMap(jpaProps)
    return em
  }

  @Primary
  @Bean
  fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
    val tm = JpaTransactionManager()
    tm.entityManagerFactory = entityManagerFactory
    return tm
  }

  companion object {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)
  }

}