package co.edu.unipiloto.ws.testws.services;

import co.edu.unipiloto.ws.testws.model.Person;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/person")
public class Service {

    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("My wonderful Person " + id);
            person.setAge(new Random().nextInt(40) + 1);
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
    public double promedioSalarios() {
        double suma = 0;
        for (Person p : persons.values()) {
            suma += p.getSalario();
        }
        return suma / persons.size();
    }

    @GET
    @Path("/suma")
    @Produces(MediaType.APPLICATION_JSON)
    public double sumaSalarios() {
        double suma = 0;
        for (Person p : persons.values()) {
            suma += p.getSalario();
        }
        return suma;
    }
}
