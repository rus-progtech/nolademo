/*
 * Copyright 2024 niagarasummit. All Rights Reserved.
 */

import com.tridium.gradle.plugins.module.util.ModulePart.RuntimeProfile.*

plugins {
  // The Niagara Module plugin configures the "moduleManifest" extension and the
  // "jar" and "moduleTestJar" tasks.
  id("com.tridium.niagara-module")

  // The signing plugin configures the correct signing of modules. It requires
  // that the plugin also be applied to the root project.
  id("com.tridium.niagara-signing")

  // The bajadoc plugin configures the generation of Bajadoc for a module.
  id("com.tridium.bajadoc")

  // Configures JaCoCo for the "niagaraTest" task of this module.
  id("com.tridium.niagara-jacoco")

  // The Annotation processors plugin adds default dependencies on "Tridium:nre"
  // for the "annotationProcessor" and "moduleTestAnnotationProcessor"
  // configurations by creating a single "niagaraAnnotationProcessor"
  // configuration they extend from. This value can be overridden by explicitly
  // declaring a dependency for the "niagaraAnnotationProcessor" configuration.
  id("com.tridium.niagara-annotation-processors")

  // The niagara_home repositories convention plugin configures !bin/ext and
  // !modules as flat-file Maven repositories so that projects in this build can
  // depend on already-installed Niagara modules.
  id("com.tridium.convention.niagara-home-repositories")
}

description = "New Orleans Module Migration demo"

moduleManifest {
  moduleName.set("nola")
  runtimeProfile.set(wb)
}

// See documentation at module://docDeveloper/doc/build.html#dependencies for the supported
// dependency types
dependencies {
  // NRE dependencies
  nre("Tridium:nre")

  // Niagara module dependencies
  api("Tridium:alarm-rt")
  api("Tridium:baja")
  api("Tridium:bajaui-wb")
  api("Tridium:bql-rt")
  api("Tridium:control-rt")
  api("Tridium:file-rt")
  api("Tridium:gx-rt")
  api("Tridium:history-rt")
  api("Tridium:workbench-wb")
  api(project(":nola-rt"))


  // Test Niagara module dependencies
  moduleTestImplementation("Tridium:test-wb")

}

