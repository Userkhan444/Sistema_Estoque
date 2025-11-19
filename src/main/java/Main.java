import controller.SistemaController;

public class Main {
    public static void main(String[] args) {
        // Instancia o controlador e inicia o loop principal
        SistemaController sistema = new SistemaController();
        sistema.iniciar();
    }
}