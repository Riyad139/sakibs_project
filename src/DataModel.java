import java.sql.*;

public class DataModel {

    String [][] data = new String[15][2];
    PreparedStatement pstm;

    Statement statement;
    String query = "SELECT * FROM todoData";
    DataModel(){
        String url = "jdbc:sqlite:src/TodoData.db";
        try {
            String drop = "DROP TABLE todoData";
            String create = "CREATE TABLE todoData(TITLE TEXT, DESCRIPTIONS TEXT)";
            String sql = "INSERT INTO todoData(TITLE, DESCRIPTIONS) VALUES(?,?)";
            Connection connection = DriverManager.getConnection(url);
            if(connection == null){
                System.out.println("wow");
            }

             pstm = connection.prepareStatement(sql);


             statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
             int i = 0;
            while (rs.next()){
                data[i] = new String[]{rs.getString("TITLE"),rs.getString("DESCRIPTIONS")};
                i++;
            }

        }catch (SQLException er){
            System.out.println(er.getErrorCode());
        }
    }

    public String [][] getData(){
        return data;
    }
    public String [][] addData(String title,String descriptions){
       try {
           pstm.setString(1,title);
           pstm.setString(2,descriptions);
           pstm.executeUpdate();

           ResultSet rs = statement.executeQuery(query);
           int i = 0;
           while (rs.next()){
               data[i] = new String[]{rs.getString("TITLE"),rs.getString("DESCRIPTIONS")};
               i++;
           }

       }catch (SQLException e){
           System.out.println(e);
       }
        return data;
    }

}
