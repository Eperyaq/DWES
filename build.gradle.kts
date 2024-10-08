plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.apache.commons:commons-dbcp:2.9.0") // Para BasicDataSource
    implementation ("commons-logging:commons-logging:1.2") // Para el registro
    implementation ("org.apache.commons:commons-pool2:2.11.1") // Para la gestión de conexiones
    implementation ("mysql:mysql-connector-java:8.0.32")  //Dependencia del conector para Mysql

}

tasks.test {
    useJUnitPlatform()
}