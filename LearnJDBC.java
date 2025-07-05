import java.util.*;
import java.sql.*;

public class LearnJDBC {

    public static boolean isSufficient(Connection connection, int debit_acc, double amt) {
        double amount = 0;
        try {
            String sufficient_balance_query = "SELECT balance from customers where acc_no = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sufficient_balance_query);

            preparedStatement.setInt(1, debit_acc);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                amount = resultSet.getDouble("balance");

            }
            if (amt > amount) {
                System.out.println("Insufficient Balance.");
                return false;
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    // 3. Variables needed to connect to DB

    private static final String url = "jdbc:mysql://localhost:3306/Bank";
    private static final String username = "root";
    private static final String password = "YOUR_DB_PASSWORD";

    public static void main(String[] args) {

        // 1. Connect IDE to MySQL Database - Connector jar file downloaded and put under External Libraries in this project.

        // 2. Load JDBC Drivers

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        /* ================================= USING STATEMENT ===================================

        // 3. Make the connection to DB - JDBC Boilerplate Code till here
        try {
            Connection connection = DriverManager.getConnection(url, username, password);



            // 4. Create Statement to execute SQL query (to retrieve data)
            Statement statement = connection.createStatement();

            String query = "select * from students";
            // 4. Result of RHS that is the output table will be stored in ResultSet instance
            ResultSet resultSet = statement.executeQuery(query);

            // 4. Print the data in DB row-wise
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Marks: " + marks);
            }

            // 5. Insert into Database
            String insert_query = String.format("INSERT INTO students(name,age,marks) VALUES('%s',%d,%f)", "Rahul", 23, 74.5);
            int rowsAffected = statement.executeUpdate(insert_query);

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Data not inserted successfully.");
            }

            // Update a value in table
            String update_query = String.format("UPDATE students SET marks = %f WHERE id = %d", 89.5, 2);
            int updated_rows = statement.executeUpdate(update_query);
            if (updated_rows > 0) {
                System.out.println("Data updated successfully!");
            } else {
                System.out.println("Data not updated successfully.");
            }

            // Delete a row in table
            String del_query = "DELETE FROM students where id = 2";
            int del_rows = statement.executeUpdate(del_query);
            if (del_rows > 0) {
                System.out.println("Data deleted successfully.");
            } else {
                System.out.println("Data not deleted successfully.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/

        // ====================================== USING PREPARED STATEMENT ===========================================

        try {
            /*
            Connection conn = DriverManager.getConnection(url, username, password);


            // ======================  INSERT INTO DB TABLE  ===========================
            String p_insert_query = "INSERT INTO students(name,age,marks) VALUES(?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(p_insert_query);

            preparedStatement.setString(1,"Ankita");
            preparedStatement.setInt(2,23);
            preparedStatement.setDouble(3,88.0);

            int p_rows_inserted = preparedStatement.executeUpdate();

            if(p_rows_inserted > 0)
            {
                System.out.println("Data inserted successfully.");
            }
            else{
                System.out.println("Data not inserted successfully.");
            }
            // ===========================================================================
            */

            /*
            // ========================= RETRIEVE DATA FROM TABLE ===============================
            String p_retrieve_query = "SELECT marks from students where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(p_retrieve_query);

            preparedStatement.setInt(1,1);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                Double marks = resultSet.getDouble("marks");
                System.out.println("Marks: " + marks);
            }
            else {
                System.out.println("Marks not found!");
            }
            // ==================================================================================
            */

            /*
            // ====================== UPDATE ROW IN DB TABLE ===========================

            String p_update_query = "UPDATE students SET marks = ? WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(p_update_query);

            preparedStatement.setDouble(1, 90.5);
            preparedStatement.setInt(2,3);

            int p_rows_updated = preparedStatement.executeUpdate();
            if(p_rows_updated > 0)
            {
                System.out.println("Data updated successfully.");
            }
            else {
                System.out.println("Data not updated successfully.");
            }
            // =========================================================================
            */

            /*
            // ============================== DELETE DATA FROM DB TABLE ===============================

            String p_del_query = "DELETE FROM students where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(p_del_query);

            preparedStatement.setInt(1,4);

            int p_rows_deleted = preparedStatement.executeUpdate();

            if(p_rows_deleted > 0)
            {
                System.out.println("Data deleted successfully.");
            }else{
                System.out.println("Data not deleted successfully.");
            }

            // ========================================================================================
            */

            /*
            // ======================== BATCH PROCESSING USING STATEMENT ==========================

            Scanner sc = new Scanner(System.in);
            Statement statement = conn.createStatement();

            while(true) {
                System.out.print("\nEnter your name: ");
                String name = sc.next();
                System.out.print("\nEnter age: ");
                int age = sc.nextInt();
                //sc.nextLine();
                System.out.print("\nEnter marks: ");
                double marks = sc.nextDouble();
                //sc.nextLine();
                String b_query = String.format("INSERT INTO students(name,age,marks) VALUES('%s',%d,%f)", name, age, marks);
                statement.addBatch(b_query);
                System.out.print("\nDo you want to add more data (Y/N): ");
                String choice = sc.next();
                if(choice.toUpperCase().equals("N"))
                {
                    break;
                }
            }

            int[] arr = statement.executeBatch();

            for(int i=0;i<arr.length;i++)
            {
                if(arr[i] == 0)
                {
                    System.out.println("Query " + i + " did not execute successfully.");
                }
            }

            // ==============================================================================
             */


            /*
            // =================== BATCH PROCESSING USING PREPARED STATEMENT =====================

            Scanner sc = new Scanner(System.in);
            String p_batch_query = "INSERT INTO students(name,age,marks) VALUES(?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(p_batch_query);

            while(true) {
                System.out.print("\nEnter your name: ");
                String name = sc.next();
                System.out.print("\nEnter age: ");
                int age = sc.nextInt();
                //sc.nextLine();
                System.out.print("\nEnter marks: ");
                double marks = sc.nextDouble();
                //sc.nextLine();

                preparedStatement.setString(1,name);
                preparedStatement.setInt(2, age);
                preparedStatement.setDouble(3,marks);

                preparedStatement.addBatch();
                System.out.print("\nDo you want to add more data (Y/N): ");
                String choice = sc.next();
                if(choice.toUpperCase().equals("N"))
                {
                    break;
                }
            }

            int[] p_arr = preparedStatement.executeBatch();

            for(int i=0;i<p_arr.length;i++)
            {
                if(p_arr[i] == 0)
                {
                    System.out.println("Query " + i + " did not execute successfully.");
                }
            }
            // ==============================================================================
            */

            // ========================= TRANSACTION HANDLING USING PREPARED STATEMENT =======================

            Scanner sc = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(url, username, password); // Bank DB in MySQL
            connection.setAutoCommit(false);
            String debit_query = "UPDATE customers SET balance = balance - ? WHERE acc_no = ?";
            String credit_query = "UPDATE customers SET balance = balance + ? WHERE acc_no = ?";


            System.out.print("Enter the Account Number from where money will be debited: ");
            int debit_acc_no = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter the Account Number where money will be credited: ");
            int credit_acc_no = sc.nextInt();
            sc.nextLine();

            System.out.print("\nEnter the amount to be trasferred: ");
            double amt = sc.nextDouble();
            sc.nextLine();


            if (isSufficient(connection, debit_acc_no, amt)) {
                PreparedStatement debit_preparedStatement = connection.prepareStatement(debit_query);
                PreparedStatement credit_preparedStatement = connection.prepareStatement(credit_query);

                debit_preparedStatement.setDouble(1, amt);
                debit_preparedStatement.setInt(2, debit_acc_no);

                credit_preparedStatement.setDouble(1, amt);
                credit_preparedStatement.setInt(2, credit_acc_no);

                debit_preparedStatement.executeUpdate();
                credit_preparedStatement.executeUpdate();
                connection.commit();
                System.out.println("Transaction Successful!");

                debit_preparedStatement.close();
                credit_preparedStatement.close();
            } else {
                connection.rollback();
                System.out.println("Transaction not successful. Please retry.");
            }

            sc.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // =====================================================================================

    }

}
