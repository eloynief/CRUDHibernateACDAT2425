package ejercicio.views;

import com.diogonunes.jcolor.*;

public class TextoColores{
    public static void main(String[] args) {
        System.out.println(Ansi.colorize("Texto en rojo", Attribute.RED_TEXT()));
        System.out.println(Ansi.colorize("Texto en verde", Attribute.GREEN_TEXT()));
        System.out.println(Ansi.colorize("Texto en azul", Attribute.BLUE_TEXT()));
    }
}