import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class select extends JFrame {

       static final String DB_URL="jdbc:mysql://localhost/INSTITUCION";

    static final String USER="root";
    static final String PASS="root_bas3";
    static final String QUERY= "SELECT* from ESTUDIANTES";
    private JPanel root;
    private JTextField cedula;
    private JTextField ciudad;
    private JTextField edad;
    private JTextField id;
    private JTextField nombre;
    private JButton QUERYButton;


    public select() {
        QUERYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("select");
        frame.setContentPane(new select().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        try (
                Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement stmt= conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);
                ){
            while(rs.next()){
                System.out.println("id:"+rs.getInt("id"));
                System.out.println("nombre:"+rs.getString("nombre"));
                System.out.println("edad:"+rs.getInt("edad"));
                System.out.println("ciudad:"+rs.getString("ciudad"));
                System.out.println("cedula:"+rs.getInt("cedula"));

                System.out.println("   ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
