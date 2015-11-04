package es.danirod.propgen

/**
 * The extension that contains information about the generated files.
 * @author danirod
 */
class PropgenExtension {

    /** The default location for generating properties files. */
    String defaultLocation = "."

    List<PropertiesFile> propertyFiles = [ ]

    /**
     * Function used to generate a new properties file.
     * @param name the bundle for the new generated file.
     * @param closure the closure with information for the file.
     */
    def void file(String name, Closure closure) {
        PropertiesFile propFile = new PropertiesFile(name, defaultLocation)
        propertyFiles << propFile
        closure.delegate = propFile
        closure()
    }

}
