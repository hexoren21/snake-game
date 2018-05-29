import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener
{
    private int[] snake_x_length = new int[750];
    private int[] snake_y_lenght = new int[750];

    private int moves = 0;

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon right_mouth;
    private ImageIcon up_mouth;
    private ImageIcon down_mouth;
    private ImageIcon left_mouth;

    private int length_of_snake = 3;

    private Timer timer;
    private int delay = 100;
    private ImageIcon snake_image;

    private ImageIcon titleImage;

    public Gameplay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);

    }

    public void paint(Graphics g)
    {
        if (moves == 0)
        {
            snake_x_length[2] = 50;
            snake_x_length[1] = 75;
            snake_x_length[0] = 100;

            snake_y_lenght[2] = 100;
            snake_y_lenght[1] = 100;
            snake_y_lenght[0] = 100;
        }
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);

        titleImage = new ImageIcon("title.jpg");
        titleImage.paintIcon(this, g,25,11);

        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);

        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);

        right_mouth = new ImageIcon("head_right1.png");
        right_mouth.paintIcon(this, g, snake_x_length[0], snake_y_lenght[0]);

        for (int i = 0; i  < length_of_snake; i++)
        {
            if (i == 0 && right)
            {
                right_mouth = new ImageIcon("head_right1.png");
                right_mouth.paintIcon(this, g, snake_x_length[i], snake_y_lenght[i]);
            }
            if (i == 0 && left)
            {
                left_mouth = new ImageIcon("head_left.png");
                left_mouth.paintIcon(this, g, snake_x_length[i], snake_y_lenght[i]);
            }
            if (i == 0 && down)
            {
                down_mouth = new ImageIcon("head_down.png");
                down_mouth.paintIcon(this, g, snake_x_length[i], snake_y_lenght[i]);
            }
            if (i == 0 && up)
            {
                up_mouth = new ImageIcon("head_up.png");
                up_mouth.paintIcon(this, g, snake_x_length[i], snake_y_lenght[i]);
            }

            if (i != 0)
            {
                snake_image = new ImageIcon("torso1.png");
                snake_image.paintIcon(this, g, snake_x_length[i], snake_y_lenght[i]);

            }
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
