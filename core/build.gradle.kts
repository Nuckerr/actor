plugins {
	kotlin("jvm") version "1.7.0"
	id("io.papermc.paperweight.userdev") version "1.3.8"
	id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "wtf.nucker.actor"
version = "1.0"

repositories {
	mavenCentral()
}

dependencies {
	paperDevBundle("1.19-R0.1-SNAPSHOT")
}


tasks {
	build {
		dependsOn(shadowJar)
	}

	compileKotlin {
		kotlinOptions.jvmTarget = "17"
	}
	javadoc {
		options.encoding = Charsets.UTF_8.name()
	}
	processResources {
		filteringCharset = Charsets.UTF_8.name()
	}
}
