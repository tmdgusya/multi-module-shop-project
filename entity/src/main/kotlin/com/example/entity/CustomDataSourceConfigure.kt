package com.example.entity

import com.zaxxer.hikari.HikariDataSource
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource


@Configuration(proxyBeanMethods = false)
@EnableJpaRepositories
@EntityScan("com.example.entity")
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

  companion object {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)
  }

}