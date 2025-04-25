plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")

    // RestAssured
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    testImplementation("org.hamcrest:hamcrest:2.2")

    // Jackson para serializar POJOs em JSON (necessário para body(order))
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
}

tasks.test {
    useJUnitPlatform()
}
