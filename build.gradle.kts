import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id ("idea")
	//id ("org.jetbrains.kotlin.jvm") version "1.8.10"
	id ("com.github.johnrengelman.shadow") version "7.1.2"
	id("net.minecrell.plugin-yml.bukkit") version "0.5.3"
	kotlin("jvm") version "1.8.20"
}

group = "de.malte"
version = 1.0
description = "Easily replace the default UnknownCommand message."

repositories {  
	maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
	maven("https://oss.sonatype.org/content/repositories/snapshots")
	maven("https://oss.sonatype.org/content/repositories/central")
	mavenCentral()
}

dependencies {
   compileOnly("org.spigotmc:spigot-api:1.8-R0.1-SNAPSHOT")
	implementation(kotlin("stdlib-jdk8"))
}

bukkit {
	name = "UnknownCommand"
	version = project.version.toString()
	description = project.description
	author = "malte843"

	main = "de.malte.unknowncommand.UnknownCommand"
	apiVersion = "1.8"

	commands {
		register("ucreload") {
			permission = "unknowncommand.reload"
			description = "Reloads the Config"
			usage = "/<command> reload"
		}
	}
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
	jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
	jvmTarget = "1.8"
}