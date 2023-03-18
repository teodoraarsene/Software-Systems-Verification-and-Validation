package ssvv.example;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import ssvv.example.domain.Student;
import ssvv.example.repository.NotaXMLRepo;
import ssvv.example.repository.StudentXMLRepo;
import ssvv.example.repository.TemaXMLRepo;
import ssvv.example.service.Service;
import ssvv.example.validation.NotaValidator;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.TemaValidator;
import ssvv.example.validation.ValidationException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private Service service;

    @Test
    public void addStudent_validStudentGroup_isAdded() {
        String filenameStudent = "src/test/resources/Studenti.xml";
        String filenameTema = "src/test/resources/Teme.xml";
        String filenameNota = "src/test/resources/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);

        service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student student = new Student("10", "nume", 10, "email@domeniu.com");
        assertNull(service.addStudent(student));
    }

    @Test
    public void addStudent_invalidStudentGroup_notAdded() {
        String filenameStudent = "src/test/resources/Studenti.xml";
        String filenameTema = "src/test/resources/Teme.xml";
        String filenameNota = "src/test/resources/Note.xml";

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);

        StudentValidator studentValidator = new StudentValidator();
        TemaValidator temaValidator = new TemaValidator();
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);

        service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student student = new Student("90", "nume", -10, "email@domeniu.com");
        assertThrows(ValidationException.class, () -> service.addStudent(student));
    }
}
