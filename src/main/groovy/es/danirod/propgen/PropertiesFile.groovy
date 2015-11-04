package es.danirod.propgen

/**
 * The properties file structure.
 * @author danirod
 */
class PropertiesFile {

    /** The name of the bundle. */
    def name

    /** The location for the generated properties file. */
    def location

    /** The list of properties inside this properties file. */
    Properties props = new Properties()

    PropertiesFile(String name, String location) {
        this.name = name
        this.location = location
    }

    def void property(String name, String value) {
        props.put(name, value)
    }

    def File getFile() {
        new File(location, "${name}.properties")
    }

    def File saveProperties() {
        File propFile = getFile()
        propFile.parentFile.mkdirs()
        propFile.withOutputStream { os -> props.store(os, null) }
    }

}
