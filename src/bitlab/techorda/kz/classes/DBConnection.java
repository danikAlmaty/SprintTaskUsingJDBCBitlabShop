package bitlab.techorda.kz.classes;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {
    private static Connection connection;

    static {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sprint2",
                    "postgres",
                    "123");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM public.users");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                User user = new User();

                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));

                users.add(user);
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return users;
    }

    public static ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM public.items");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Item item = new Item();

                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));

                items.add(item);
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return items;
    }

    public static User getUser(String email){
        User user = null;

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM public.users " +
                    "WHERE email=?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }


}
