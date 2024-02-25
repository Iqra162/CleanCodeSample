pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CleanArchitectureBasics"
include(":app")
include(":features:home")
include(":features:profile")
include(":features:commonui")
include(":features:dashboard")
include(":features:navigation")
