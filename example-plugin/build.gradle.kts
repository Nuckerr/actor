plugins {
	kotlin("jvm") version "1.7.0"
	id("xyz.jpenilla.run-paper") version "1.0.6"
	id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
	id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "wtf.nucker.actor"
version = "1.0"
description = "Example plugin for the actor library"

repositories {
    mavenCentral()
	maven(url = "https://papermc.io/repo/repository/maven-public/")
}

dependencies {
	implementation("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")
	implementation(project(":core"))
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

	runServer {
		minecraftVersion("1.19.2")
	}
}
bukkit {
	load = net.minecrell.pluginyml.bukkit.BukkitPluginDescription.PluginLoadOrder.STARTUP
	main = "wtf.nucker.actor.example.ExamplePlugin"
	apiVersion = "1.19"

	name = getName()
	description = getDescription()
	version = getVersion().toString()
	authors = listOf("Nucker")
	website = "nucker.me"
	prefix = getName()
}
