import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DoorPanel extends JPanel {
    private static Image open;
    private static Image closed;
    private final int imageSize;

    static {
        try {
            open = ImageIO.read(DoorPanel.class.getResourceAsStream("/crank1.png"));
            closed = ImageIO.read(DoorPanel.class.getResourceAsStream("/crank0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private State state;

    public DoorPanel(int imageSize) {
        this.imageSize = imageSize;
        final Dimension dim = new Dimension(State.SIZE*imageSize+3, State.SIZE*imageSize+3);
        setSize(dim);
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int[][] s = state.getState();
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                if (s[i][j] == 1) {
                    g.drawImage(open, i*imageSize, j*imageSize, imageSize, imageSize,this);
                    g.setColor(Color.BLACK);
                    g.drawRect(i*imageSize, j*imageSize, imageSize, imageSize);
                } else {
                    g.drawImage(closed, i*imageSize, j*imageSize, imageSize, imageSize, this);
                    g.setColor(Color.BLACK);
                    g.drawRect(i*imageSize, j*imageSize, imageSize, imageSize);
                }
            }
        }
    }
}
