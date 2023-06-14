import javax.swing.*;

public class TodoLogIn extends JFrame {
    private JPanel panel;
    private JTextField username;
    private JButton loginButton;
    private JButton cancelButton;
    private JPasswordField password;

    TodoLogIn(){
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginButton.addActionListener(e->{
            if(username.getText().toLowerCase().compareTo("admin") ==0 && password.getText().toLowerCase().compareTo("admin")==0 )
            new Todo(frame);
        });
    }



}
