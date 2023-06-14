import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class Todo extends JFrame {
    private JPanel panel1;
    private JButton addButton;
    private JTable table1;
    private JScrollPane scroll;
    private JLabel label;
    private JTextArea descriptions;
    private JPanel addTodo;
    private JPanel showTodo;
    private JButton addButton1;
    private JButton cancelButton;
    private JTextField inputTitle;
    private String[][] data;
    private  String[] header = {"title","Descriptions"};
    DataModel dataModel;
    public Todo(JFrame frame){

     dataModel =   new  DataModel();
     data = dataModel.getData();

        frame.setVisible(false);
        JFrame jFrame = new JFrame();
        jFrame.setSize(800,800);
        jFrame.add(panel1);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Todos");
        jFrame.setVisible(true);
        setTableDesign(table1,data);
        addTodo.setVisible(false);
        this.addButton.addActionListener(e->{
            showTodo.setVisible(false);
            addTodo.setVisible(true);
        });

        this.addButton1.addActionListener(e->{
           data = dataModel.addData(inputTitle.getText(),descriptions.getText());
            setTableDesign(table1,data);
            showTodo.setVisible(true);
            addTodo.setVisible(false);
        });

        this.cancelButton.addActionListener(e->{
            showTodo.setVisible(true);
            addTodo.setVisible(false);
        });

    }




    private void setTableDesign(JTable table,String[][]data){


        table.setModel( new DefaultTableModel( data,header));
        TableColumnModel column = table.getColumnModel();
        column.getColumn(1).setMinWidth(350);
        table.setRowHeight(60);
        table.getTableHeader().setPreferredSize(new Dimension(250,40));
        table.getTableHeader().setFont(new Font("Chilanka",Font.BOLD,18));
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        column.getColumn(0).setCellRenderer(cellRenderer);

    }

}
