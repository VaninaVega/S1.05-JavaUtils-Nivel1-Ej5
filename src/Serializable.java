import java.io.*;

public class Serializable {

    public static void testMethods() {

        Person person = new Person("Pepa", 78);

        serializePerson(person);

        deserializePerson();

    }


    public static void serializePerson(Person persona) {


        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("persona.ser"))) {

            objectOutputStream.writeObject(persona);

            System.out.println("Person object serialized in file: ");


        } catch(IOException e) {

            System.out.println("Error serializing Person object: " + e.getMessage());

        }


    }

    public static void deserializePerson() {

        try (FileInputStream fileInputStream = new FileInputStream("persona.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {

            Person personaEnfichero = (Person) objectInputStream.readObject();

            System.out.println("Person object deserialized from file");
            System.out.println("Person: " + personaEnfichero.getName() + ", has " + personaEnfichero.getAge());


        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error deserializing Person object: " + e.getMessage());

        }


    }
}
