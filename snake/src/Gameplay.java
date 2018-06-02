import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener
{
    private int[] snake_x_length = new int[782];
    private int[] snake_y_lenght = new int[782];

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
    private int score = 0;
    private Timer timer;
    private int delay = 100;
    private ImageIcon snake_image;

    private int [] enemy_x_pos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400,
            425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800,
            825, 850};

    private int [] enemy_y_pos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400,
            425, 450, 475, 500, 525, 550, 575, 600, 625};

    private Random random = new Random();

    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);
    private ImageIcon titleImage;
    private ImageIcon apple_point;

    public Gameplay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay, this);
        timer.start();

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

        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Scores: " + score, 780, 30);

        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Length: " + length_of_snake, 780, 50);


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
                left_mouth = new ImageIcon("head_left1.png");
                left_mouth.paintIcon(this, g, snake_x_length[i], snake_y_lenght[i]);
            }
            if (i == 0 && down)
            {
                down_mouth = new ImageIcon("head_down1.png");
                down_mouth.paintIcon(this, g, snake_x_length[i], snake_y_lenght[i]);
            }
            if (i == 0 && up)
            {
                up_mouth = new ImageIcon("head_up1.png");
                up_mouth.paintIcon(this, g, snake_x_length[i], snake_y_lenght[i]);
            }

            if (i != 0)
            {
                snake_image = new ImageIcon("torso1.png");
                snake_image.paintIcon(this, g, snake_x_length[i], snake_y_lenght[i]);

            }
        }

        apple_point = new ImageIcon("apple1.png");

        if (enemy_x_pos[xpos] == snake_x_length[0] && enemy_y_pos[ypos] == snake_y_lenght[0])
        {
            score++;
            length_of_snake++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);
        }
        apple_point.paintIcon(this, g, enemy_x_pos[xpos], enemy_y_pos[ypos]);

        for (int i = 1; i < length_of_snake; i++)
        {
            if (snake_x_length[i] == snake_x_length[0] && snake_y_lenght[i] == snake_y_lenght[0])
            {
                right = false;
                left = false;
                up = false;
                down = false;

                g.setColor(Color.white);
                g.setFont(new Font("arial", Font.BOLD, 50));
                g.drawString("Game Over", 300, 300);

                g.setFont(new Font("arial", Font.BOLD, 20));
                g.drawString("Space to restart", 350, 340);
            }
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        timer.start();
        if (right)
        {
            for (int i = length_of_snake - 1; i >= 0; i--)
            {
                snake_y_lenght[i + 1] = snake_y_lenght[i];
            }
            for (int i = length_of_snake; i >= 0; i--)
            {
                if (i == 0)
                {
                    snake_x_length[i] = snake_x_length[i] + 25;
                }
                else
                {
                    snake_x_length[i] = snake_x_length[i - 1];
                }
                if (snake_x_length[i] > 850)
                {
                    snake_x_length[i] = 25;
                }

            }
           repaint();
        }
        if (left)
        {
            for (int i = length_of_snake - 1; i >= 0; i--)
            {
                snake_y_lenght[i + 1] = snake_y_lenght[i];
            }
            for (int i = length_of_snake; i >= 0; i--)
            {
                if (i == 0)
                {
                    snake_x_length[i] = snake_x_length[i] - 25;
                } else
                {
                    snake_x_length[i] = snake_x_length[i - 1];
                }
                if (snake_x_length[i] < 25)
                {
                    snake_x_length[i] = 850;
                }

            }
           repaint();
        }
        if (up)
        {
            for (int i = length_of_snake - 1; i >= 0; i--)
            {
                snake_x_length[i + 1] = snake_x_length[i];
            }
            for (int i = length_of_snake; i >= 0; i--)
            {
                if (i == 0)
                {
                    snake_y_lenght[i] = snake_y_lenght[i] - 25;
                } else
                {
                    snake_y_lenght[i] = snake_y_lenght[i - 1];
                }
                if (snake_y_lenght[i] < 75)
                {
                    snake_y_lenght[i] = 625;
                }

            }
            repaint();
        }
        if (down)
        {
            for (int i = length_of_snake - 1; i >= 0; i--)
            {
                snake_x_length[i + 1] = snake_x_length[i];
            }
            for (int i = length_of_snake; i >= 0; i--)
            {
                if (i == 0)
                {
                    snake_y_lenght[i] = snake_y_lenght[i] + 25;
                } else
                {
                    snake_y_lenght[i] = snake_y_lenght[i - 1];
                }
                if (snake_y_lenght[i] > 625)
                {
                    snake_y_lenght[i] = 75;
                }

            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            moves = 0;
            score = 0;
            length_of_snake = 3;
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            moves++;
            //right = true;
            if (!left)
            {
                right = true;
            }
            else
            {
                right = false;
                left = true;
            }

            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            moves++;
          //  left = true;
            if (!right)
            {
                left = true;
            }
            else
            {
                right = true;
                left = false;
            }

            up = false;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            moves++;
            //up = true;
            if (!down)
            {
                up = true;
            }
            else
            {
                up = false;
                down = true;
            }

            right = false;
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            moves++;
            //down = true;
            if (!up)
            {
                down = true;
            }
            else
            {
                up = true;
                down = false;
            }

            right = false;
            left = false;
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}
