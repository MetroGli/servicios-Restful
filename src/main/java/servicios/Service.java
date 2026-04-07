package servicios;

import entidad.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author duvan
 */
@Path("service")
public class Service {

    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();
    private static final double SALARIO_MINIMO = 1300000;

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("My wonderfull Person " + id);
            person.setAge(new Random().nextInt(40) + 1);
            person.setSalario(person.getAge() * SALARIO_MINIMO / 3);
            persons.put(id, person);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/{id}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() {
        return new ArrayList<Person>(persons.values());
    }

    @GET
    @Path("/all/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson() {
        return new ArrayList<Person>(persons.values());
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        persons.put(person.getId(), person);
        return person;
    }

    @GET
    @Path("/promedio")
    @Produces(MediaType.APPLICATION_XML)
    public String getPromedioSalario() {

        double suma = 0;

        for (Person p : persons.values()) {
            suma += p.getSalario();
        }

        double promedio = suma / persons.size();

        return "<promedio>" + promedio + "</promedio>";
    }

    @GET
    @Path("/suma")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSumaSalarios() {

        double suma = 0;

        for (Person p : persons.values()) {
            suma += p.getSalario();
        }

        return "{\"suma\":" + suma + "}";
    }
}
