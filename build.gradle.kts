plugins {
    java
    id("org.springframework.boot") version "4.0.4-SNAPSHOT"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.netflix.dgs.codegen") version "8.3.0"
}

group = "com.dotest"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/snapshot") }
}

extra["netflixDgsVersion"] = "11.0.0"

var blazeVersion = "1.6.18"    // blaze-persistence版本
var mapStructVersion = "1.6.3" //mapStruct版本
var cosIdVersion="3.0.5"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.netflix.graphql.dgs:graphql-dgs-spring-graphql-starter")
    implementation("com.netflix.graphql.dgs:graphql-dgs-extended-scalars")

    //MapStruct
    implementation("org.mapstruct:mapstruct:$mapStructVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapStructVersion")

    //Blaze核心
    implementation("com.blazebit:blaze-persistence-core-api-jakarta:$blazeVersion")
    implementation("com.blazebit:blaze-persistence-core-impl-jakarta:$blazeVersion")

    //Entity View API
//	implementation("com.blazebit:blaze-persistence-entity-view-api-jakarta:$blazeVersion")
    //Entity View实现
//	runtimeOnly("com.blazebit:blaze-persistence-entity-view-impl-jakarta:$blazeVersion")
    // Entity View Annotation Processor（編譯時期生成）
//	annotationProcessor("com.blazebit:blaze-persistence-entity-view-processor-jakarta:$blazeVersion")

    implementation("com.blazebit:blaze-persistence-integration-hibernate-7.2:$blazeVersion")
    implementation("com.blazebit:blaze-persistence-integration-spring-data-4.0:$blazeVersion")
    implementation("com.blazebit:blaze-persistence-integration-graphql-dgs-7.0:$blazeVersion")
//	implementation("com.netflix.graphql.dgs:graphql-dgs-pagination:11.1.0")

    //CosId
    implementation("me.ahoo.cosid:cosid-spring-boot-starter:${cosIdVersion}")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testImplementation("com.netflix.graphql.dgs:graphql-dgs-spring-graphql-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testAnnotationProcessor("org.mapstruct:mapstruct-processor:$mapStructVersion")
}

dependencyManagement {
    imports {
        mavenBom("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:${property("netflixDgsVersion")}")
    }
}

tasks.generateJava {
    schemaPaths.add("${projectDir}/src/main/resources/schema")
    packageName = "com.dotest.dsg.codegen"
    generateClient = true
    typeMapping = mutableMapOf(
        "DateTime" to "java.time.ZonedDateTime",
        "ID" to "java.lang.Long",
        "BigDecimal" to "java.math.BigDecimal"
    )
}

tasks.withType<Test> {
    useJUnitPlatform()
}
