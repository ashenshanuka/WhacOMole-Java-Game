import java.awt.*;
import javax.swing.*;

 
public class WhacAMole {
    int boardWidth = 600;
    int boardHeight = 650;
    
    JFrame frame=new JFrame("Mario : Whac a Mole");
    JLabel textLabel =new JLabel();
    JPanel textPanel= new JPanel();
    JPanel boardPanel= new JPanel();

    WhacAMole() {
        frame.setVisible(true);
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


    }

    
}
