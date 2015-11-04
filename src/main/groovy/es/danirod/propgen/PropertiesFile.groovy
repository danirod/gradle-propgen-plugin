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
    Map<String, String> props = new HashMap<>()

    PropertiesFile(String name, String location) {
        this.name = name
        this.location = location
    }

    /**
     * Add the given properties to this bundle
     * @param properties properties to add to the bundle
     */
    def void property(Map<String, String> properties) {
        props.putAll(properties)
    }

    def Properties generateProperties() {
        Properties prop = new Properties()
        prop.putAll(props)
        prop
    }

    def File getFile() {
        new File(location, "${name}.properties")
    }

    def File saveProperties() {
        Properties prop = generateProperties()
        File propFile = getFile()
        propFile.parentFile.mkdirs()
        propFile.withOutputStream { os -> prop.store(os, null) }
    }

}
