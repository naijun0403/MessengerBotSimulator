plugins {
	java
	application
	id("org.openjfx.javafxplugin") version "0.0.10"
	id("org.beryx.jlink") version "2.24.1"
}

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

// gradle version > 6.6.1 error
// group = "org.beuwi.msgbot-simulator"

javafx {
	version = "17"
	modules("javafx.controls", "javafx.fxml", "javafx.web", "javafx.swing")
}

application {
	mainModule.set("org.beuwi.msgbots")
	mainClass.set("org.beuwi.msgbots.Launcher")
}

repositories {
	mavenCentral()
	jcenter()
}

dependencies {
	implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

	// 주석 처리된 의존성들은 그대로 주석으로 유지했습니다.
	// implementation("net.java.dev.jna:jna:5.8.0")
	// implementation("net.java.dev.jna:jna-platform:5.8.0")
	// implementation("org.jsoup:jsoup:1.13.1")
	// implementation("com.jfoenix:jfoenix:9.0.10")
	// implementation("org.mozilla:rhino:1.7.13")
	/* implementation("com.googlecode.json-simple:json-simple:1.1.1") {
        exclude(group = "org.hamcrest", module = "hamcrest-core")
    } */
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
	options.compilerArgs.add("-Xlint:none")
}

tasks.withType<JavaExec> {
	jvmArgs("--add-opens", "javafx.web/javafx.scene.web=org.beuwi.msgbots")
}

jlink {
	options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))

	launcher {
		name = "Simulator"
	}

	mergedModule {
		requires("javafx.graphics")
		requires("javafx.base")
	}

	jpackage {
		imageOptions.add("--icon")
		imageOptions.add("src/main/resources/icon/program.ico")

		/* installerOptions = listOf(
            "--vendor", "beuwi",
            "--app-version", "0.5.0"
        ) */
	}
}

tasks.jar {
	manifest {
		attributes("Main-Class" to "org.beuwi.msgbots.Launcher")
	}

	/* from(configurations.compile.get().map { if (it.isDirectory) it else zipTree(it) }) */
}