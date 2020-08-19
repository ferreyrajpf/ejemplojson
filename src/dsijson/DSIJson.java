/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsijson;

import static dsijson.Json.JSON_MAPPER;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public class DSIJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Persona persona1= new Persona();
        persona1.setApellido("Perez");
        persona1.setNombre("Jose");
        persona1.setDNI("1323266");
        
        Persona persona3= new Persona();
        persona3.setApellido("Fernandez");
        persona3.setNombre("Ana");
        persona3.setDNI("3456789");
        
        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(persona1);
        personas.add(persona3);
       
        JSON_MAPPER.writeValue(new File("/home/juan/Documentos/listadepersonas.json"), personas);
        
        Persona persona2 = JSON_MAPPER.readValue(new File("/home/juan/Documentos/persona1.json"), Persona.class);
        System.out.println(persona2);
        
        ArrayList<Persona> personasdesdejson = JSON_MAPPER.readValue(new File("/home/juan/Documentos/listadepersonas.json"), JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Persona.class));
        System.out.println(personasdesdejson.get(1).getApellido());
        
    }
    
}
