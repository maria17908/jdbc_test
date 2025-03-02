package org.example;
import com.mysql.cj.jdbc.JdbcConnection;

import  java.sql.Connection;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
   Connection connection = jdbcUtils.getConnection();
   PersonDao personDao = new PersonDao(connection);
//   Person person = new Person();
//   person.setFirsName("Test firstName");
//   person.setLastName("Test lastName");
//System.out.println(personDao.savePerson(person));
//   personDao.printPersons();
//        System.out.println(personDao.findById(1L));
//        Person person = new Person();
//        person.setId(2L);
//        person.setFirsName("Firstname");
//        person.setLastName("Lsstname");
//        personDao.updatePerson(person);
        personDao.deleteById(2L);
        personDao.printPersons();
    }
}