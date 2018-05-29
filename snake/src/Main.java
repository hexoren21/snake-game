import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame start = new JFrame();
        Gameplay gameplay = new Gameplay();
        start.setBounds(10, 10, 905, 700);
        start.setBackground(Color.MAGENTA);
        start.setResizable(false);
        start.setVisible(true);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.add(gameplay);
    }
}
