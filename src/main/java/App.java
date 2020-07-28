import javax.swing.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame f = new GameFrame();
            f.setVisible(true);
        });
    }
}
