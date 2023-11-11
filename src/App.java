import controller.RawatInapController;
import models.RawatInapModel;

public class App {
    public static void main(String[] args) throws Exception {
        RawatInapModel.dataAdmin();
        RawatInapModel.dataKamar();
        RawatInapController objRawat = new RawatInapController();
        objRawat.menu();
    }
}