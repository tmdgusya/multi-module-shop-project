package com.example.service

import com.example.entity.CustomDataSourceConfigure
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource

@Configuration
@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration::class])
@ComponentScan("com.example.entity", "com.example.service")
class ServiceBeanConfigure() {

  @Primary
  @Bean(name = ["dataSource"])
  fun dataSource(): DataSource {
    return CustomDataSourceConfigure().dataSource()
  }

}