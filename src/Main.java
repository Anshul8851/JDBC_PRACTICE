
import java.io.*;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password  = "Bh@rdw@j90";
//        String image_path = "C:\\Users\\anshul sharma\\Pictures\\Camera Roll\\WIN_20240630_22_56_34_Pro.jpg";

        // query to insert data in database
//        String query = "INSERT INTO image_table(image_url) values(?);";

        //        to save image in folder from database we require folder path
        String folder_path = "C:\\Users\\anshul sharma\\Pictures\\Camera Roll\\";
//        query to select image from database
        String query = "Select image_url from  image_table where image_id = ? ;";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DRIVERS LOADED SUCCESSFULLY");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
//            In this section we will learn how store images in database
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Database Connected Successfully");
//            ---------------------------------------------------------------------------------------------------------------
//            this code is used to insert image in database
//            FileInputStream fis = new FileInputStream(image_path);
//            byte[] imageData = new byte[fis.available()];
//            fis.read(imageData);
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setBytes(1,imageData);
//
//            int affectedrows = ps.executeUpdate();

//            if(affectedrows>0){
//                System.out.println("IMAGE UPLOADED SUCCESSFULLY");
//            }else{
//                System.out.println("IMAGE NOT UPLOADED");
//            }
//            ----------------------------------------------------------------------------------------------------------------
//            this code is used to store img from database to folder
//            ---------------------------------------------------------------------------------------
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,1);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
//                step:1 extract data from database and store it in java datatype
                byte[] image_data = rs.getBytes("image_url");
                String img_path = folder_path+"extractedimg.jpeg";
//                step:2 we have to convert it from bytes to img with the help of outputstream
                OutputStream os = new FileOutputStream(img_path);
                os.write(image_data);
                System.out.println("IMAGE ADDED SUCCESSFULLY!!!!!!");
            }else{
                System.out.println("IMAGE NOT FOUND!!!!!!!!!");
            }

        }
        catch (SQLException e){
            System.err.println("Connection Failed "+ e.getMessage());
        }
        catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }

//        try{
//      //    this code is used to retrieve data
//            Connection connection = DriverManager.getConnection(url,user,password);
//            System.out.println("Database Connected Successfully");
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from employees;");
//            while(rs.next()){
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String job_title = rs.getString("job_title");
//                double salary = rs.getDouble("salary");
//                System.out.println();
//                System.out.println("================================================================");
//                System.out.println("ID: "+id);
//                System.out.println("NAME: "+name);
//                System.out.println("JOB_TITLE: "+job_title);
//                System.out.println("SALARY: "+salary);
//
//            }
//            rs.close();
//            stmt.close();
//            connection.close();
//            System.out.println();
//            System.out.println("connection closed successfully!!!");
//
//        }
//        catch (SQLException e){
//            System.err.println("Connection Failed "+ e.getMessage());
//        }
//        try{
////            this code is used to insert data in database
//            Connection connection = DriverManager.getConnection(url,user,password);
//            System.out.println("Database Connected Successfully");
//            Statement stmt = connection.createStatement();
//
//            int rowsAffect = stmt.executeUpdate("Insert into employees(id,name,job_title,salary) values (4,'ujjwal','react developer',200000.0);");
//
//            if(rowsAffect > 0){
//                System.out.println("DATA INSERT SUCCESSFULLY...");
//            }else{
//                System.out.println("INSERTION FAILED");
//            }
//
//            stmt.close();
//            connection.close();
//            System.out.println();
//            System.out.println("connection closed successfully!!!");
//
//        }
//        catch (SQLException e){
//            System.err.println("Connection Failed "+ e.getMessage());
//        }

//        try{
////            this code is used to delete data from database
//            Connection connection = DriverManager.getConnection(url,user,password);
//            System.out.println("Database Connected Successfully");
//            Statement stmt = connection.createStatement();
//
//            int rowsAffect = stmt.executeUpdate("delete from employees where id = 2;");
//
//            if(rowsAffect > 0){
//                System.out.println("DATA DELETED SUCCESSFULLY...");
//            }else{
//                System.out.println("DELITION FAILED");
//            }
//
//            stmt.close();
//            connection.close();
//            System.out.println();
//            System.out.println("connection closed successfully!!!");
//
//        }
//        catch (SQLException e){
//            System.err.println("Connection Failed "+ e.getMessage());
//        }

//        try{
////            this code is used to update data into database
//            Connection connection = DriverManager.getConnection(url,user,password);
//            System.out.println("Database Connected Successfully");
//            Statement stmt = connection.createStatement();
//
//            int rowsAffect = stmt.executeUpdate("update employees set job_title = 'gamer',salary = 30000 where id = 1;");
//
//            if(rowsAffect > 0){
//                System.out.println("DATA updated SUCCESSFULLY...");
//            }else{
//                System.out.println("updation  FAILED");
//            }
//
//            stmt.close();
//            connection.close();
//            System.out.println();
//            System.out.println("connection closed successfully!!!");
//
//        }
//        catch (SQLException e){
//            System.err.println("Connection Failed "+ e.getMessage());
//        }


    }
}