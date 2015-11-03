package es.danirod.propgen

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

class PropgenPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        PropertiesExtension ext = project.extensions.create('properties', PropertiesExtension)

        project.task("generateProperties") << {
            ext.propertyFiles.each { PropertyFileDefinition pfDef ->
                Properties pInst = new Properties()
                pfDef.properties.each { name, value ->
                    pInst.put("$name".toString(), "$value".toString())
                }

                // Make sure that the folder exists. Create it if it does not exists.
                File locationFolder = new File("$pfDef.location")
                locationFolder.mkdirs()

                // Write the properties.
                File propertiesFile = new File(locationFolder, "${pfDef.name}.properties")
                propertiesFile.withWriter { writer ->
                    pInst.store(writer, null)
                }
            }
        }
    }
}
