import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;

/**
 * Frame of the final calculator
 */
public class FinalFrame extends JFrame{
    JTextField trmW = new JTextField("");

    public FinalFrame() {
        // FRAME SETUP -----------------------------------------
        super("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 600);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        //------------------------------------------------------

        trmW.setBounds(225,25,200,40);
        trmW.setFont(new Font("Times New Roman",Font.PLAIN,25));
        add(trmW);
    }
}
