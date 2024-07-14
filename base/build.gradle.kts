plugins {
    java
}

group = "org.beuwi.mstbots"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val extraLibs by configurations.creating

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    // 다른 클래스에서 해당 프로젝트가 참조하는 json.simple도 접근이 가능하게 함
    extraLibs(fileTree("dir" to "libs", "include" to listOf("*.jar")))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xlint:none")
}

tasks.jar {
    /* manifest {
        attributes("Bundle-SymbolicName" to "org.beuwi.msgbots.base")
    } */
    from(configurations.getByName("extraLibs").map { if (it.isDirectory) it else zipTree(it) })
}