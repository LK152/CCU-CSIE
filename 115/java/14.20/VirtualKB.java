import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class VirtualKB extends JPanel {
    private final Map<Integer, JButton> keyButtonMap = new HashMap<>();
    private final Map<Integer, String[]> shiftMap = new HashMap<>();

    private Color defaultButtonColor;

    public VirtualKB() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        buildVirtualKB();
    }

    private void buildVirtualKB() {
        Object[][] row0 = {
                { KeyEvent.VK_BACK_QUOTE, "~", "`" }, { KeyEvent.VK_1, "1", "!" }, { KeyEvent.VK_2, "2", "@" },
                { KeyEvent.VK_3, "3", "#" }, { KeyEvent.VK_4, "4", "$" }, { KeyEvent.VK_5, "5", "%" },
                { KeyEvent.VK_6, "6", "^" }, { KeyEvent.VK_7, "7", "&" }, { KeyEvent.VK_8, "8", "*" },
                { KeyEvent.VK_9, "9", "(" }, { KeyEvent.VK_0, "0", ")" }, { KeyEvent.VK_MINUS, "-", "_" },
                { KeyEvent.VK_EQUALS, "+", "=" }, { KeyEvent.VK_BACK_SPACE, "Backspace", "Backspace" }
        };

        Object[][] row1 = {
                { KeyEvent.VK_TAB, "Tab", "Tab" }, { KeyEvent.VK_Q, "q", "Q" }, { KeyEvent.VK_W, "w", "W" },
                { KeyEvent.VK_E, "e", "E" }, { KeyEvent.VK_R, "r", "R" }, { KeyEvent.VK_T, "t", "T" },
                { KeyEvent.VK_Y, "y", "Y" }, { KeyEvent.VK_U, "u", "U" }, { KeyEvent.VK_I, "i", "I" },
                { KeyEvent.VK_O, "o", "O" }, { KeyEvent.VK_P, "p", "P" }, { KeyEvent.VK_OPEN_BRACKET, "[", "{" },
                { KeyEvent.VK_CLOSE_BRACKET, "]", "}" }, { KeyEvent.VK_BACK_SLASH, "\\", "|" }
        };

        Object[][] row2 = {
                { KeyEvent.VK_CAPS_LOCK, "Caps", "Caps" }, { KeyEvent.VK_A, "a", "A" }, { KeyEvent.VK_S, "s", "S" },
                { KeyEvent.VK_D, "d", "D" }, { KeyEvent.VK_F, "f", "F" }, { KeyEvent.VK_G, "G", "G" },
                { KeyEvent.VK_H, "h", "H" }, { KeyEvent.VK_J, "j", "J" }, { KeyEvent.VK_K, "k", "K" },
                { KeyEvent.VK_L, "l", "L" }, { KeyEvent.VK_SEMICOLON, ";", ":" }, { KeyEvent.VK_QUOTE, "'", "\"" },
                { KeyEvent.VK_ENTER, "Enter", "Enter" }
        };

        Object[][] row3 = {
                { KeyEvent.VK_SHIFT, "Shift", "Shift" }, { KeyEvent.VK_Z, "z", "Z" }, { KeyEvent.VK_X, "x", "X" },
                { KeyEvent.VK_C, "c", "C" }, { KeyEvent.VK_V, "v", "V" }, { KeyEvent.VK_B, "b", "B" },
                { KeyEvent.VK_N, "n", "N" }, { KeyEvent.VK_M, "m", "M" }, { KeyEvent.VK_COMMA, ",", "<" },
                { KeyEvent.VK_PERIOD, ".", ">" }, { KeyEvent.VK_SLASH, "/", "?" }, { KeyEvent.VK_UP, "^", "^" }
        };

        Object[][] row4 = {
                { KeyEvent.VK_SPACE, "                                              ",
                        "                                              " },
                { KeyEvent.VK_LEFT, "<", "<" }, { KeyEvent.VK_DOWN, "v", "v" }, { KeyEvent.VK_RIGHT, ">", ">" }
        };

        storeShiftData(row0);
        storeShiftData(row1);
        storeShiftData(row2);
        storeShiftData(row3);
        storeShiftData(row4);

        add(createKbRow(row0));
        add(Box.createVerticalStrut(4));
        add(createKbRow(row1));
        add(Box.createVerticalStrut(4));
        add(createKbRow(row2));
        add(Box.createVerticalStrut(4));
        add(createKbRow(row3));
        add(Box.createVerticalStrut(4));
        add(createKbRow(row4));
    }

    private void storeShiftData(Object[][] rowData) {
        for (Object[] data : rowData) {
            shiftMap.put((Integer) data[0], new String[] { (String) data[1], (String) data[2] });
        }
    }

    private JPanel createKbRow(Object[][] keyData) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 0));

        for (Object[] data : keyData) {
            int keyCode = (Integer) data[0];
            String defaultLabel = (String) data[1];

            JButton button = new JButton(defaultLabel);
            button.setFont(new Font("SansSerif", Font.PLAIN, 12));
            button.setFocusable(false);
            button.setEnabled(true);

            if (defaultButtonColor == null)
                defaultButtonColor = button.getBackground();

            keyButtonMap.put(keyCode, button);
            rowPanel.add(button);
        }

        return rowPanel;
    }

    public void highlightKey(int keyCode, Color color, boolean opaque) {
        JButton button = keyButtonMap.get(keyCode);
        if (button != null) {
            button.setBackground(color);
            button.setOpaque(opaque);
        }
    }

    public void restoreKeyColor(int keyCode) {
        JButton button = keyButtonMap.get(keyCode);
        if (button != null) {
            button.setBackground(defaultButtonColor);
        }
    }

    public void toggleLabels(boolean shiftActive, boolean capsActive) {
        for (Map.Entry<Integer, JButton> entry : keyButtonMap.entrySet()) {
            int keyCode = entry.getKey();
            JButton button = entry.getValue();
            String[] labels = shiftMap.get(keyCode);

            if (labels != null) {
                boolean isLetter = (keyCode >= 65 && keyCode <= 90);

                if (isLetter) {
                    boolean shouldBeUppercase = shiftActive ^ capsActive;
                    button.setText(shouldBeUppercase ? labels[1] : labels[0]);
                } else
                    button.setText(shiftActive ? labels[1] : labels[0]);

            }
        }
    }
}
