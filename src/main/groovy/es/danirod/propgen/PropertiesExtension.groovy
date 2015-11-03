package es.danirod.propgen

/**
 *
 * @author danirod
 */
class PropertiesExtension {

    def propertyFiles = [ ]

    def file(String name, Closure closure) {
        PropertyFileDefinition definition = new PropertyFileDefinition(name)
        propertyFiles << definition
        closure.delegate = definition
        closure()
    }

}
