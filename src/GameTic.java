import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTic implements ActionListener {
    private int countX = 1;
    private int countO = 1;
    private JFrame frame;
    private JLabel label,label2;
    private JPanel panel;
    private JButton [] buttons;
    private JButton reset;
    JLabel winPlayerX = new JLabel("0"); // Initialize with initial count
    JLabel winPlayerO = new JLabel("0");
    private String currentPlayer = "X",
            prevPlayer = "O";


    public GameTic(){

        //Frame settings
        frame = new JFrame("TicTacToe");
        frame.setSize(400,500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //Panel settings
        panel = new JPanel();
        panel.setBounds(0,60,400,300);
        panel.setBackground(Color.CYAN);
        panel.setLayout(new GridLayout(3,3));

        //Buttons
        buttons = new JButton[9];
        for(int i =0;i<9;i++){
            buttons[i] = new JButton();
            buttons[i].setFocusable(false);
            buttons[i].setBackground(Color.lightGray);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        //Reset Button
        reset = new JButton("New Game");
        reset.setFocusable(false);
        reset.setBounds(140,380,120,30);
        reset.setForeground(Color.BLACK);
        reset.setBackground(Color.gray);
        reset.addActionListener(this);

        //Text label for player X
        label = new JLabel("Player X wins: ");
        label.setForeground(Color.RED);
        label.setBounds(0,0,90,20);

        //Win counter for player X
        winPlayerX = new JLabel("0");
        winPlayerX.setForeground(Color.RED);
        winPlayerX.setBounds(85,0,80,20);

        //Text label for player O
        label2 = new JLabel("Player O wins: ");
        label2.setForeground(Color.black);
        label2.setBounds(0,40,90,20);

        //Win counter for player O
        winPlayerO = new JLabel("0");
        winPlayerO.setForeground(Color.black);
        winPlayerO.setBounds(85,40,90,20);

        //Frame add
        frame.add(winPlayerX);
        frame.add(winPlayerO);
        frame.add(reset);
        frame.add(label2);
        frame.add(label);
        frame.add(panel);
        frame.setVisible(true);
    }

    //Button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        for (int i = 0; i < buttons.length;i++) {
            if (source == buttons[i]) {
                buttons[i].setText(currentPlayer);
                prevPlayer = currentPlayer;
                whichPlayer();
                winner();
                break;
            }
        }
        if (e.getSource() == reset){
            newGame();
        }

    }
    //Getting current player
    public void whichPlayer(){
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }
    //Game reset method
    public void newGame(){
        for (int i = 0; i < 9;i++){
            buttons[i].setText("");
        }
    }
    //Winner counter label
    public void winnerLabel(){
        if("X".equals(currentPlayer)){
            winPlayerO.setText((String.valueOf(countX++)));
        }else{
            winPlayerX.setText((String.valueOf(countO++)));
        }
    }
    //Winner method,checking all possibilities
    public void winner(){
        if(buttons[0].getText().equals(buttons[1].getText()) && buttons[0].getText().equals(buttons[2].getText())
                && buttons[0].getText() != "" && buttons[1].getText() != ""	&& buttons[2].getText() != ""){
            winnerLabel();
            JOptionPane.showMessageDialog(null,"player " + prevPlayer +" wins");
            newGame();
        }
        if(buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText())
                && buttons[0].getText() != "" && buttons[4].getText() != ""	&& buttons[8].getText() != "" ){

            winnerLabel();
            JOptionPane.showMessageDialog(null,"player " + prevPlayer +" wins");
            newGame();
        }
        if(buttons[0].getText().equals(buttons[3].getText()) && buttons[0].getText().equals(buttons[6].getText())
                && buttons[0].getText() != "" && buttons[3].getText() != ""	&& buttons[6].getText() != ""){

            winnerLabel();
            JOptionPane.showMessageDialog(null,"player " + prevPlayer +" wins");
            newGame();
        }
        if(buttons[1].getText().equals(buttons[4].getText()) && buttons[1].getText().equals(buttons[7].getText())
                && buttons[1].getText() != "" && buttons[4].getText() != ""	&& buttons[7].getText() != ""){
            winnerLabel();
            JOptionPane.showMessageDialog(null,"player " + prevPlayer +" wins");
            newGame();
        }
        if(buttons[2].getText().equals(buttons[5].getText()) && buttons[2].getText().equals(buttons[8].getText())
                && buttons[2].getText() != "" && buttons[5].getText() != ""	&& buttons[8].getText() != ""){
            winnerLabel();
            JOptionPane.showMessageDialog(null,"player " + prevPlayer +" wins");
            newGame();
        }
        if(buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText())
                && buttons[2].getText() != "" && buttons[4].getText() != ""	&& buttons[6].getText() != ""){
            winnerLabel();
            JOptionPane.showMessageDialog(null,"player " + prevPlayer +" wins");
            newGame();
        }
        if(buttons[3].getText().equals(buttons[4].getText()) && buttons[3].getText().equals(buttons[5].getText())
                && buttons[3].getText() != "" && buttons[4].getText() != ""	&& buttons[5].getText() != ""){
            winnerLabel();
            JOptionPane.showMessageDialog(null,"player " + prevPlayer +" wins");
            newGame();
        }
        if(buttons[6].getText().equals(buttons[7].getText()) && buttons[6].getText().equals(buttons[8].getText())
                && buttons[6].getText() != "" && buttons[7].getText() != ""	&& buttons[8].getText() != ""){
            winnerLabel();
            JOptionPane.showMessageDialog(null,"player " + prevPlayer +" wins");
            newGame();
        }
    }
}
