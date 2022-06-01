package Transaksi;

public class Main {
    public static void main(String[] args) {
        ViewData view = new ViewData();
        ModelData model = new ModelData();
        ControllerData controller = new ControllerData(model, view);
    }
}