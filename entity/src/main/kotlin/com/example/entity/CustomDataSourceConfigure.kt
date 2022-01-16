package com.example.entity

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement
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
  fun entityManagerFactory(
    @Qualifier("dataSource") primaryDataSource: DataSource,
  ): LocalContainerEntityManagerFactoryBean {
    val em = LocalContainerEntityManagerFactoryBean()
    val vendorAdapter = HibernateJpaVendorAdapter()
    em.dataSource = primaryDataSource
    em.setPackagesToScan("com.example.entity")
    em.jpaVendorAdapter = vendorAdapter
    return em
  }

}