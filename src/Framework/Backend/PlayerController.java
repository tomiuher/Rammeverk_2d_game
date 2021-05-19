package Framework.Backend;

import Framework.Backend.Controller;
import Framework.Backend.Input;

import java.awt.event.KeyEvent;

public class PlayerController implements Controller {

    private Input input;

    public PlayerController(Input input) {
        this.input = input;
    }

    @Override
    public boolean isRequestingUp() {
        return input.isPressed(KeyEvent.VK_W);
    }

    @Override
    public boolean isRequestingDown() {
        return input.isPressed(KeyEvent.VK_S);
    }

    @Override
    public boolean isRequestingLeft() {
        return input.isPressed(KeyEvent.VK_A);
    }

    @Override
    public boolean isRequestingRight() {
        return input.isPressed(KeyEvent.VK_D);
    }

    @Override
    public boolean isRequestingShft() {
       return input.isPressed(KeyEvent.VK_SHIFT);
    }



}