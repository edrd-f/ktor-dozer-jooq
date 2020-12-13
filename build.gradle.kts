import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  application
  kotlin("jvm") version "1.4.21"
  id("nu.studer.jooq") version "5.2"
  id("com.github.johnrengelman.shadow") version "6.1.0"
}

repositories {
  jcenter()
}

val junitVersion: String by project

dependencies {
  implementation("io.ktor:ktor-server-netty:1.4.3")
  implementation("io.ktor:ktor-jackson:1.4.3")
  implementation("org.jooq:jooq:3.14.4")
  implementation("org.postgresql:postgresql:42.2.18")
  implementation("com.github.dozermapper:dozer-core:6.5.0")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.0")

  runtimeOnly("ch.qos.logback:logback-classic:1.2.3")

  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

  jooqGenerator("org.postgresql:postgresql:42.2.14")
}

@Suppress("Deprecation") // shadowJar still uses this format
application.mainClassName = "edrd.explore.MainKt"

tasks.withType<KotlinCompile> {
  kotlinOptions {
    jvmTarget = "1.8"
    freeCompilerArgs = listOf("-Xjsr305=strict")
  }
}

tasks.withType<Test> {
  useJUnitPlatform {
    testLogging {
      events("passed", "skipped", "failed")
    }
  }

  reports {
    junitXml.isEnabled = false
  }

  systemProperty("junit.jupiter.execution.parallel.enabled", "true")
  systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")

  maxParallelForks = Runtime.getRuntime().availableProcessors()
}

jooq {
  configurations {
    create("main") {
      generateSchemaSourceOnCompilation.set(false)
      jooqConfiguration.apply {
        jdbc.apply {
          driver = "org.postgresql.Driver"
          url = "jdbc:postgresql://localhost:5432/postgres"
          user = "postgres"
          password = "postgrespassword"
        }
        generator.database.inputSchema = "public"
      }
    }
  }
}
