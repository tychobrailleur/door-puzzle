public class State {

    final static int SIZE = 4;
    private final int[][] state = new int[SIZE][SIZE];


    public State() {
        init();
    }

    private void init() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // 0: closed, 1: open.
                state[i][j] = (int)Math.round(Math.random());
            }
        }
    }

    public int[][] getState() {
        return state;
    }

    public boolean isSolved() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (state[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void toggle(int i, int j) {
        for (int ii = 0; ii < SIZE; ii++) {
            state[ii][j] = (state[ii][j]+1)%2;
        }
        for (int jj = 0; jj < SIZE; jj++) {
            state[i][jj] = (state[i][jj]+1)%2;
        }
        // (i,j) has been toggled twice.
        state[i][j] = (state[i][j]+1)%2;
    }
}
