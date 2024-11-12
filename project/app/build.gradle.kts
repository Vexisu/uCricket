plugins { application }

repositories { mavenCentral() }

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.3")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("com.google.guava:guava:32.3.1-jre")

    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")

    testCompileOnly("org.projectlombok:lombok:1.18.34")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.34")
}

java { toolchain { languageVersion.set(JavaLanguageVersion.of(17)) } }

application { mainClass.set("pl.polsl.student.maciwal866.ucricket.Main") }

tasks.named<Test>("test") { useJUnitPlatform() }

tasks.named("build") { dependsOn("buildParser") }

task<Exec>("buildLexer") {
    commandLine(
            "jflex",
            "./src/main/resources/UCricketLexer.l",
            "-d",
            "./src/main/java/pl/polsl/student/maciwal866/ucricket",
            "--nobak"
    )
}

task<Exec>("buildParser") {
    dependsOn("buildLexer")
    commandLine(
            "bison",
            "./src/main/resources/UCricketParser.y",
            "-o",
            "./src/main/java/pl/polsl/student/maciwal866/ucricket/UCricketParser.java"
    )
}
