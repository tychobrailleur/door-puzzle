import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends JFrame {
    private final int tileSize = 120;
    private final State state;
    private final DoorPanel canvas;
    private final List<Pair> moves = new ArrayList<>();

    public GameFrame() {
        state = new State();
        canvas = new DoorPanel(tileSize);
        canvas.setOpaque(true);
        canvas.setState(state);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                int i = p.x/tileSize;
                int j = p.y/tileSize;
                moves.add(new Pair(i, j));

                state.toggle(i, j);
                canvas.setState(state);
                canvas.repaint();
                if (state.isSolved()) {
                    System.out.println(" *** Solved!!");
                    System.out.println(moves);
                }
            }
        });

        setLayout(new BorderLayout());
        setSize(State.SIZE*tileSize+1, State.SIZE*tileSize+38);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(canvas, BorderLayout.CENTER);
    }
}
