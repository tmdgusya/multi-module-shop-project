package com.example.api

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootConfiguration
@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration::class])
@ComponentScan(
  "com.example.api",
  "com.example.entity",
  "com.example.service"
)
class ApiApplication

fun main(args: Array<String>) {
  runApplication<ApiApplication>(*args) {
  }
}
