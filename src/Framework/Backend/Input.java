package Framework.Backend;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private boolean[] pressed;

    public Input(){
        pressed = new boolean[255];
    }

    public boolean isPressed(int keyCode){
        return pressed[keyCode];
    }

    @Override
    public void keyTyped(KeyEvent e) {} //dont need for now

    @Override
    public void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
    }

    /*@Override
    public void rightMousePressed */
}
