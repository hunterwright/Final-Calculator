import javax.swing.*;
import java.awt.Font;

/**
 * Frame of the final calculator
 */
public class FinalFrame extends JFrame {
    JTextField[] txt_fields = new JTextField[4];
    JLabel[] txt_labels = new JLabel[5];
    JTextField[] txt_term_fields = new JTextField[5];
    JLabel[] txt_term_labels = new JLabel[5];

    JButton equal = new JButton("Calculate");
    JButton clear = new JButton("Clear");

    JLabel txt_gradeNeeded = new JLabel("");

    int numberOfTerms = 1;
    double average = 0;

    double gradeWanted = 0;

    double trmWeight = 0;
    double finalWeight = 0;
    double gradeNeeded = 0;

    JComboBox<String> numOfTrms = null;
    String[] choices = {"1", "2", "3", "4", "5"};

    public FinalFrame() {
        // FRAME SETUP -----------------------------------------
        super("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 600);
        setLayout(null);

        setResizable(false);
        //------------------------------------------------------
        numOfTrms = new JComboBox<String>(choices);

        // LABELS & TEXTFIELDS -------------------------------------------------
        for (int i = 0; i < txt_fields.length; i++) {
            if (i != 2) {
                if (i == 0) {
                    txt_fields[i] = new JTextField("85");
                    txt_fields[i].setBounds(225, (i * 50) + 10, 200, 40);
                    txt_fields[i].setFont(new Font("Comic Sans MS", Font.BOLD, 25));
                    add(txt_fields[i]);
                } else if (i == 1) {
                    txt_fields[i] = new JTextField("15");
                    txt_fields[i].setBounds(225, (i * 50) + 10, 200, 40);
                    txt_fields[i].setFont(new Font("Comic Sans MS", Font.BOLD, 25));
                    add(txt_fields[i]);
                } else if (i == 3) {
                    txt_fields[i] = new JTextField("90");
                    txt_fields[i].setBounds(225, (i * 50) + 10, 200, 40);
                    txt_fields[i].setFont(new Font("Comic Sans MS", Font.BOLD, 25));
                    add(txt_fields[i]);
                }
            }
        }
        for (int i = 0; i < txt_labels.length; i++) {
            if (i == 0) {
                txt_labels[i] = new JLabel("Total Term Weight:");
            } else if (i == 1) {
                txt_labels[i] = new JLabel("Final Weight:");
            } else if (i == 2) {
                txt_labels[i] = new JLabel("Number of Terms:");
            } else if (i == 3) {
                txt_labels[i] = new JLabel("Grade Wanted:");
            } else if (i == 4) {
                txt_labels[i] = new JLabel("Calculate Grade Required On Final: ");
                txt_labels[i].setBounds(20, 527, 500, 40);
                txt_labels[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
                add(txt_labels[i]);
            }
            if (i != 4) {
                txt_labels[i].setBounds(20, (i * 50) + 10, 200, 40);
                txt_labels[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
                add(txt_labels[i]);
            }
        } // -------------------------------------------------------------------

        // TERM LABELS & TEXTFIELDS --------------------------------------------

        for (int i = 0; i < txt_term_fields.length; i++) {
            txt_term_fields[i] = new JTextField("");
            txt_term_fields[i].setBounds(225, (i * 50) + 230, 200, 40);
            txt_term_fields[i].setFont(new Font("Comic Sans MS", Font.BOLD, 25));
            add(txt_term_fields[i]);
        }
        for (int i = 0; i < txt_term_labels.length; i++) {
            if (i == 0) {
                txt_term_labels[i] = new JLabel("Term 1 Grade:");
            } else if (i == 1) {
                txt_term_labels[i] = new JLabel("Term 2 Grade:");
            } else if (i == 2) {
                txt_term_labels[i] = new JLabel("Term 3 Grade:");
            } else if (i == 3) {
                txt_term_labels[i] = new JLabel("Term 4 Grade:");
            } else if (i == 4) {
                txt_term_labels[i] = new JLabel("Term 5 Grade:");
            }
            txt_term_labels[i].setBounds(20, (i * 50) + 230, 200, 40);
            txt_term_labels[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
            add(txt_term_labels[i]);
        } // -------------------------------------------------------------------

        for (int i = 5; i > 1; i--) {
            txt_term_fields[i - 1].setEnabled(false);
            txt_term_labels[i - 1].setEnabled(false);
        }

        numOfTrms.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        numOfTrms.setBounds(225, 110, 200, 40);
        add(numOfTrms);

        equal.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        equal.setBounds(20, 480, 190, 40);
        add(equal);

        clear.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        clear.setBounds(230, 480, 190, 40);
        add(clear);

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

            for (int i = 0; i < 5; i++) {
                txt_term_labels[i].setEnabled(false);
            }
            switch (Integer.parseInt(numOfTrms.getSelectedItem().toString())) {
                case 5:
                    txt_term_labels[4].setEnabled(true);
                case 4:
                    txt_term_labels[3].setEnabled(true);
                case 3:
                    txt_term_labels[2].setEnabled(true);
                case 2:
                    txt_term_labels[1].setEnabled(true);
                case 1:
                    txt_term_labels[0].setEnabled(true);
            }

            for (int i = 1; i < 5; i++) {
                if (txt_term_fields[i].isEnabled()) {
                    numberOfTerms++;
                }
            }
        });

        equal.addActionListener(e -> {
            txt_gradeNeeded.setText("");

            trmWeight = Double.parseDouble(txt_fields[0].getText());
            trmWeight /= 100;
            finalWeight = Double.parseDouble(txt_fields[1].getText());
            finalWeight /= 100;
            gradeWanted = Double.parseDouble(txt_fields[3].getText());
            average = 0;
            for (int i = 0; i < numberOfTerms; i++) {
                if (!txt_term_fields[i].getText().equals("")) {
                    average += Double.parseDouble(txt_term_fields[i].getText());
                }
            }
            average /= numberOfTerms;

            gradeNeeded = (-(average * trmWeight) + (gradeWanted)) / finalWeight;

            String s = "" + gradeNeeded + "";
            s = s.format("%.5f", gradeNeeded);

            txt_gradeNeeded.setText(s);
            txt_gradeNeeded.setBounds(300, 527, 150, 40);
            txt_gradeNeeded.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
            add(txt_gradeNeeded);

            repaint();
        });

        clear.addActionListener(e -> clear());
    }

    public void clear() {
        for (int i = 0; i < txt_term_fields.length; i++) {
            txt_term_fields[i].setText("");
        }
    }
}
