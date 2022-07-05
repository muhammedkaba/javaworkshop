public class App {
    
    public static Object[][] myList;


    public static void main(String[] args) {
        myList = Model.DATA;
        Table table = new Table();
        table.setVisible(true);
        table.pack();
        table.setLocationRelativeTo(null);
    }
}
