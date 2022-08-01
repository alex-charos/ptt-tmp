/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("gr.charos.apps.ptt.java-library-conventions")
    id("org.springframework.boot") version "2.5.6"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("java")
}

dependencies {
    api(project(":domain"))
    api(project(":repo"))
	api("org.springframework.boot:spring-boot-starter-web")
	api("org.projectlombok:lombok:1.18.22")
    
    
    testCompile("junit:junit:4.12")
    
}
