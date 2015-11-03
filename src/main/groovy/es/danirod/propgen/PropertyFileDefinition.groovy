package es.danirod.propgen

/**
 *
 * @author danirod
 */
class PropertyFileDefinition {

    String name
    String location
    Map<String, String> properties

    PropertyFileDefinition(String name) {
        this.name = name;
        this.location = "."
        this.properties = new HashMap<>()
    }


}
