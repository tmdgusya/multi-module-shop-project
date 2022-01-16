package com.example.entity

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan("com.example.entity")
open class CustomDataSourceConfigure {

  @Primary
  @Bean(name = ["dataSource"])
  @ConfigurationProperties("spring.datasource.hikari")
  fun dataSource(): DataSource {
    return DataSourceBuilder.create()
      .type(HikariDataSource::class.java)
      .build()
  }

}