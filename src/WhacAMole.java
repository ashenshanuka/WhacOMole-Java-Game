import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

 
public class WhacAMole {
    int boardWidth = 600;
    int boardHeight = 650;
    
    JFrame frame=new JFrame("Mario : Whac a Mole");
    JLabel textLabel =new JLabel();
    JPanel textPanel= new JPanel();
    JPanel boardPanel= new JPanel();

    JButton[] board = new JButton[9];

    ImageIcon moleIcon;
    ImageIcon plantIcon;
    
    JButton currMoleTile;
    JButton currPlantTile;

    Random random = new Random();
    Timer setMoleTimer;
    Timer setPlantTimer;


    WhacAMole() {
        
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial",Font.PLAIN,50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Score : 0");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel,BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        frame.add(boardPanel);
        boardPanel.setBackground(Color.gray);

        //plantIcon=new ImageIcon(getClass().getResource("./piranha.png"));
       Image plantImg =new ImageIcon(getClass().getResource("./piranha.png")).getImage();
       plantIcon = new ImageIcon(plantImg.getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH));

       Image moleImg =new ImageIcon(getClass().getResource("./monty.png")).getImage();
       moleIcon = new ImageIcon(moleImg.getScaledInstance(150,150,java.awt.Image.SCALE_SMOOTH));

        for (int i=0;i<9;i++){
            JButton tile = new JButton();
            board[i] =tile;
            boardPanel.add(tile);
            tile.setIcon(moleIcon);;
        }

        setMoleTimer = new Timer(1000, new ActionListener() {
           public void actionPerformed(ActionEvent e){
            //remove mole from current line
            if (currMoleTile != null) {
                currMoleTile.setIcon(null);
                currMoleTile=null;
                
            }

            //random select another line
            int num =random.nextInt(9); //0-8
            JButton tile = board[num];

            //set tile to mole
            currMoleTile = tile;
            currMoleTile.setIcon(moleIcon);



           } 
        });

        setMoleTimer.start();
        frame.setVisible(true);


    }

    
}
