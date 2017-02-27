import javax.swing.*;
import java.awt.Font;

/**
 * Frame of the final calculator
 */
public class FinalFrame extends JFrame {
    JTextField[] txt_fields = new JTextField[4];
    JTextField[] txt_term_fields = new JTextField[5];
    String[] choices = {"1", "2", "3", "4", "5"};
    int numberOfTerms = 1;
    JComboBox<String> numOfTrms = null;

    public FinalFrame() {
        // FRAME SETUP -----------------------------------------
        super("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 600);
        setLayout(null);

        setResizable(false);
        //------------------------------------------------------
        numOfTrms = new JComboBox<String>(choices);
        for (int i = 0; i < txt_fields.length; i++) {
            if (i != 2) {
                if (i == 0) {
                    txt_fields[i] = new JTextField("85");
                    txt_fields[i].setBounds(225, (i * 50) + 10, 200, 40);
                    txt_fields[i].setFont(new Font("Times New Roman", Font.PLAIN, 25));
                    add(txt_fields[i]);
                } else if (i == 1) {
                    txt_fields[i] = new JTextField("15");
                    txt_fields[i].setBounds(225, (i * 50) + 10, 200, 40);
                    txt_fields[i].setFont(new Font("Times New Roman", Font.PLAIN, 25));
                    add(txt_fields[i]);
                } else if (i == 3) {
                    txt_fields[i] = new JTextField("90");
                    txt_fields[i].setBounds(225, (i * 50) + 10, 200, 40);
                    txt_fields[i].setFont(new Font("Times New Roman", Font.PLAIN, 25));
                    add(txt_fields[i]);
                }
            }
        }

        for (int i = 0; i < txt_term_fields.length; i++) {
            txt_term_fields[i] = new JTextField("");
            txt_term_fields[i].setBounds(225, (i * 50) + 230, 200, 40);
            txt_term_fields[i].setFont(new Font("Times New Roman", Font.PLAIN, 25));
            add(txt_term_fields[i]);
        }

        for (int i = 5; i > 1; i--) {
            txt_term_fields[i - 1].setEnabled(false);
        }

        numOfTrms.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        numOfTrms.setBounds(225, 110, 200, 40);
        add(numOfTrms);
        setVisible(true);

        numOfTrms.addActionListener(e -> {
            for (int i = 0; i < 5; i++) {
                txt_term_fields[i].setEnabled(false);
            }
            switch (Integer.parseInt(numOfTrms.getSelectedItem().toString())) {
                case 5:
                    txt_term_fields[4].setEnabled(true);
                case 4:
                    txt_term_fields[3].setEnabled(true);
                case 3:
                    txt_term_fields[2].setEnabled(true);
                case 2:
                    txt_term_fields[1].setEnabled(true);
                case 1:
                    txt_term_fields[0].setEnabled(true);

            }
        });
    }
}
