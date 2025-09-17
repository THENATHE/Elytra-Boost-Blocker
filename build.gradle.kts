plugins {
    id("fabric-loom") version "1.11.4"
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(21)) } // MC 1.21 requires Java 21
    withSourcesJar()
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
    maven("https://repo.spongepowered.org/maven")
}

dependencies {
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${property("yarn_mappings")}:v2")
    modImplementation("net.fabricmc:fabric-loader:${property("loader_version")}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_api_version")}")
}

loom {
    splitEnvironmentSourceSets()
}

tasks.processResources {
    filesMatching("fabric.mod.json") {
        expand("version" to project.version)
    }
}

tasks.jar {
    from("LICENSE") {
        rename { "LICENSE_${project.name}" }
        into("/")
        onlyIf { file("LICENSE").exists() }
    }
}
