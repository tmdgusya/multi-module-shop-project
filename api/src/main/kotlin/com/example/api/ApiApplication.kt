package com.example.api

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.context.TypeExcludeFilter
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType

@SpringBootConfiguration
@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration::class])
@ComponentScan(
  basePackages = ["com.example.api", "com.example.entity", "com.example.service"],
  excludeFilters = [ComponentScan.Filter(
    type = FilterType.CUSTOM,
    classes = [TypeExcludeFilter::class]
  ), ComponentScan.Filter(type = FilterType.CUSTOM, classes = [AutoConfigurationExcludeFilter::class])]
)
class ApiApplication

fun main(args: Array<String>) {
  runApplication<ApiApplication>(*args)
}
