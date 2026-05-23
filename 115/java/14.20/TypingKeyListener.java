import java.awt.event.KeyListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class TypingKeyListener implements KeyListener {
    private final TypingTutor app;
    private final VirtualKB kb;
    private final Color highlightColor;
    private final Set<Integer> pressed = new HashSet<>();

    private boolean restarted = false;

    public TypingKeyListener(TypingTutor app, VirtualKB kb, Color highlightColor) {
        this.app = app;
        this.kb = kb;
        this.highlightColor = highlightColor;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (restarted) {
            e.consume();
            restarted = false;
            return;
        }

        if (pressed.contains(KeyEvent.VK_TAB) || pressed.contains(KeyEvent.VK_ENTER)) {
            e.consume();
            return;
        }

        if (e.getKeyChar() != KeyEvent.CHAR_UNDEFINED && e.getKeyChar() != '\b')
            app.checkAcc(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        pressed.add(keyCode);

        if (pressed.contains(KeyEvent.VK_TAB) && pressed.contains(KeyEvent.VK_ENTER)) {
            e.consume();
            restarted = true;
            app.restart();
            return;
        }

        if (keyCode == KeyEvent.VK_SHIFT)
            app.setShiftState(true);

        if (keyCode == KeyEvent.VK_CAPS_LOCK)
            app.toggleCapsState();

        kb.highlightKey(keyCode, highlightColor, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        pressed.remove(keyCode);

        if (pressed.isEmpty()) {
            restarted = false;
        }

        if (keyCode == KeyEvent.VK_SHIFT)
            app.setShiftState(false);

        kb.restoreKeyColor(keyCode);
    }

    public void clearPressedKeys() {
        pressed.clear();
    }
}
