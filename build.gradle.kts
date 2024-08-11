plugins {
    id("java")
}

group = "ru.siobko.testing"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("ru.yandex.qatools.ashot:ashot:1.5.4")

    testImplementation("com.codeborne:selenide:7.4.1")

    testImplementation("io.goodforgod:slf4j-simple-logger:2.0.0")

    testCompileOnly ("org.projectlombok:lombok:1.18.32")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.32")
}

tasks.test {
    useJUnitPlatform()
}