import models.RawatInapModel;
import view.Login;

public class App {
    public static void main(String[] args) throws Exception {
        RawatInapModel.dataAdmin();
        RawatInapModel.loadFileKamar();
        
        new Login().setVisible(true);
    }
}