package es.danirod.propgen

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task


/**
 * A plugin that can be used to generate .properties files from build.gradle.
 * @author danirod
 */
class PropgenPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        PropgenExtension ext = project.extensions.create('propgen', PropgenExtension)

        Task generateProperties = project.task('generateProperties') << {
            ext.propertyFiles.each { PropertiesFile prop ->
                prop.saveProperties()
            }
        }
        generateProperties.description = 'Generate properties file'

        Task cleanProperties = project.task('cleanProperties') << {
            ext.propertyFiles.each { PropertiesFile prop ->
                File propFile = prop.getFile()
                if (propFile.exists()) {
                    propFile.delete()
                }
            }
        }
        cleanProperties.description = 'Remove generated properties file'
    }
}
