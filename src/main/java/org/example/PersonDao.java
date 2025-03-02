package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    private final Connection connection;

    public PersonDao(Connection connection) {
        this.connection = connection;
    }

    public void printPersons() {
        try {
            List<Person> personList = new ArrayList<>();
            String sql = "select * from persons";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getLong(1));
                person.setFirsName(resultSet.getString(2));
                person.setLastName(resultSet.getString(3));
                person.setAdress(resultSet.getString(4));
                personList.add(person);
//System.out.println("Id : " + resultSet.getLong(1));
//System.out.println("firstName : " + resultSet.getString(2));
//System.out.println("lastName : " + resultSet.getString(3));
//System.out.println("Adress : " + resultSet.getString(4));
            }
            personList.forEach(person1 -> System.out.println(person1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean savePerson(Person person) {
        try {
            String sql = "insert into persons values( null ,? , ? ,? )";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setLong(1 , person.getId());
            preparedStatement.setString(1, person.getFirsName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getAdress());
            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Person findById(Long id) {
        try {
            String sql = "select * from persons where id + ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
           if( resultSet.next()) {
               Person person = new Person();
               person.setId(resultSet.getLong(1));
               person.setFirsName(resultSet.getString(2));
               person.setLastName(resultSet.getString(3));
               person.setAdress(resultSet.getString(4));
               return person;
           }else {
               String message = String.format("Personi me id %s nuk u gjet" , id);
               throw new RuntimeException(message);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Integer updatePerson(Person person){
        try{
            String sql = "update persons set firstName = ? , lastName = ? , adress = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1 , person.getFirsName());
            preparedStatement.setString(2 , person.getLastName());
            preparedStatement.setString(3 , person.getAdress());
            preparedStatement.setLong(4 , person.getId());
           return preparedStatement.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void deleteById(Long Id){
        try{
            String sql = String.format("delete from persons where id = %s ", Id);
            Statement statement = connection.createStatement();;
            statement.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //test

}