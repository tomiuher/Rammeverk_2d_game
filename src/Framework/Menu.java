package Framework;

import java.util.ArrayList;

public class Menu {

    private ArrayList<String> menuOptions;
    private int size, posX, posY;

    public Menu(ArrayList<String> menuOptions, int size, int posX, int posY) {
        this.size = size;
        this.posX = posX;
        this.posY = posY;
        this.menuOptions = menuOptions;
    }

    public void setOption(int index /* metode kall*/){}  //vet ikke hvordan man kan kalle en metode sånn

}
