import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class Parser extends GetInfo implements Drawable {

    public static void main(String[] args) throws IOException {

        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("****", "****".toCharArray());
            }
        });

        run.start();

        DrawPanel drawPanel = new DrawPanel();
        drawPanel.draw();

    }

    @Override
    public void draw() {
    }
}
