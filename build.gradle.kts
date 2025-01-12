plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.1.0")
    testRuntimeOnly("io.rest-assured:rest-assured:4.3.3")
}

//tasks.test {
   // useJUnitPlatform()
//}
