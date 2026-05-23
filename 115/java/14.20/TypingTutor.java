import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TypingTutor extends JFrame {
    private static final String[] PANGRAMS = {
            "The quick brown fox jumped over a lazy dog.",
            "Pack my box with five dozen liquor jugs.",
            "Jackdaws love my big sphinx of quartz.",
            "The five boxing wizards jump quickly.",
            "How vexingly quick daft zebras jump!",
            "Sphinx of black quartz, judge my vow.",
            "Two driven jocks help fax my big quiz."
    };
    private String TARGET;

    private final JTextArea inputTextArea;
    private final JTextArea reportTextArea;
    private final JLabel promptLabel;
    private final JLabel statsLabel;
    private final JButton resetButton;
    private final VirtualKB virtualKB;
    private final TypingKeyListener keyListener;

    private final Map<Character, Integer> missedKeysMap = new HashMap<>();

    private boolean isShifted = false;
    private boolean isCaps = false;

    private final Color highlightColor = new Color(135, 206, 250);

    private int correctKeys = 0;
    private int totalKeys = 0;

    public TypingTutor() {
        super("Typing Application");
        setLayout(new BorderLayout(10, 10));

        selectRandom();

        JPanel northPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        northPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        JLabel instructionLabel = new JLabel(
                "<html>Type some text with your keyboard. The keys you press will be highlighted and the text will be displayed.<br>Note: Clicking the buttons with your mouse will not perform any action.<br>By pressing TAB and ENTER simultaneously it restarts.<html>");

        promptLabel = new JLabel("Target: " + TARGET);
        promptLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        promptLabel.setForeground(Color.BLUE);

        JPanel statsRowPanel = new JPanel(new BorderLayout());
        statsLabel = new JLabel("Accuracy: 100% | Correct: 0 | Total: 0");
        statsLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));

        resetButton = new JButton("Restart");
        resetButton.setFont(new Font("SansSerif", Font.BOLD, 11));
        resetButton.setFocusable(false);

        resetButton.addActionListener(e -> restart());

        statsRowPanel.add(statsLabel, BorderLayout.WEST);
        statsRowPanel.add(resetButton, BorderLayout.EAST);

        northPanel.add(instructionLabel);
        northPanel.add(promptLabel);
        northPanel.add(statsLabel);
        northPanel.add(statsRowPanel);
        add(northPanel, BorderLayout.NORTH);

        inputTextArea = new JTextArea(6, 40);
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);
        inputTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        inputTextArea.setFocusTraversalKeysEnabled(false);

        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        inputScrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Your Input"), BorderFactory.createLineBorder(Color.GRAY)));

        reportTextArea = new JTextArea(6, 22);
        reportTextArea.setEditable(false);
        reportTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        reportTextArea.setText("Difficulty Report: \nNo errors recorded.");

        JScrollPane reportScrollPane = new JScrollPane(reportTextArea);
        reportScrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Difficulty Report"), BorderFactory.createLineBorder(Color.GRAY)));

        JPanel centerContainer = new JPanel(new BorderLayout(5, 0));
        centerContainer.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        centerContainer.add(inputScrollPane, BorderLayout.CENTER);
        centerContainer.add(reportScrollPane, BorderLayout.EAST);
        add(centerContainer, BorderLayout.CENTER);

        virtualKB = new VirtualKB();
        add(virtualKB, BorderLayout.SOUTH);

        keyListener = new TypingKeyListener(this, virtualKB, highlightColor);
        inputTextArea.addKeyListener(keyListener);

        try {
            this.isCaps = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
        } catch (UnsupportedOperationException ex) {
            this.isCaps = false;
        }
        virtualKB.toggleLabels(this.isShifted, this.isCaps);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void checkAcc(char typedChar) {
        int index = inputTextArea.getText().length();

        if (index >= TARGET.length())
            return;

        totalKeys++;
        char expectedChar = TARGET.charAt(index);

        if (typedChar == expectedChar)
            correctKeys++;
        else {
            char keyKey = Character.toUpperCase(expectedChar);
            missedKeysMap.put(keyKey, missedKeysMap.getOrDefault(keyKey, 0) + 1);
            updateDiffReport();
        }

        double acc = ((double) correctKeys / totalKeys) * 100;
        statsLabel.setText(String.format("Accuracy: %.1f%% | Correct: %d | Total: %d", acc, correctKeys, totalKeys));
    }

    public void setShiftState(boolean shiftActive) {
        this.isShifted = shiftActive;
        virtualKB.toggleLabels(this.isShifted, this.isCaps);
    }

    public void toggleCapsState() {
        this.isCaps = !this.isCaps;
        virtualKB.toggleLabels(this.isShifted, this.isCaps);
    }

    public void restart() {
        keyListener.clearPressedKeys();

        try {
            this.isCaps = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
        } catch (UnsupportedOperationException ex) {
            this.isCaps = false;
        }

        this.isShifted = false;
        virtualKB.toggleLabels(this.isShifted, this.isCaps);
        selectRandom();
        inputTextArea.setText("");

        promptLabel.setText("Target: " + TARGET);

        correctKeys = 0;
        totalKeys = 0;
        missedKeysMap.clear();

        statsLabel.setText("Accuracy: 100% | Correct: 0 | Total: 0");
        reportTextArea.setText("Difficulty Report: \nNo errors recorded.");

        inputTextArea.requestFocusInWindow();
    }

    private void updateDiffReport() {
        if (missedKeysMap.isEmpty()) {
            reportTextArea.setText("Difficulty Report: \nNo errors recorded.");
            return;
        }

        String report = "Difficulty Report: \nKey missed -> Misses\n-------------------\n" + missedKeysMap.entrySet()
                .stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).map(e -> String
                        .format("' %s '  %d times", e.getKey() == ' ' ? "SPACE" : e.getKey(), e.getValue()))
                .collect(Collectors.joining("\n"));

        reportTextArea.setText(report);
    }

    private void selectRandom() {
        java.util.Random rand = new java.util.Random();
        String next = PANGRAMS[rand.nextInt(PANGRAMS.length)];

        if (PANGRAMS.length > 1 && next.equals(TARGET))
            next = PANGRAMS[(rand.nextInt(PANGRAMS.length - 1) + 1) % PANGRAMS.length];

        TARGET = next;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TypingTutor::new);
    }
}