import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath( "org.jetbrains.kotlin:kotlin-noarg:1.3.71")
  }
}

plugins {
  id("org.springframework.boot") version "2.6.2" apply false
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.6.10"
  kotlin("plugin.spring") version "1.6.10"
  kotlin("plugin.jpa") version "1.6.10"
}

allprojects {

  group = "com.example"
  version = "0.0.1-SNAPSHOT"

  repositories {
    mavenCentral()
  }

  apply {
    plugin("kotlin-spring")
    plugin("kotlin-jpa")
    plugin("kotlin")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
    plugin( "kotlin-allopen")
  }

  allOpen {
    annotation("javax.persistence.Entity")
  }


  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "11"
    }
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }

}


