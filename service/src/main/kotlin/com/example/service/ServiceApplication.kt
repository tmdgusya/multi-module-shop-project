package com.example.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.example.entity"])
class ServiceApplication

fun main(args: Array<String>) {
  runApplication<ServiceApplication>(*args)
}
