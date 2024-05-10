import enigma.core.Enigma;
import java.awt.Color;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import enigma.console.TextAttributes;
import javax.sound.sampled.*;


public class Menu {
    public static enigma.console.Console cn;

    public static void Main() {
        printMenuTitle();
        printMenuItems();
        drawSquare();
        playBackgroundMusic("/Users/sudenurkomur/Downloads/music.wav");
    }

    public static void printMenuTitle() {
        cn = Enigma.getConsole("PERCY'S ADVENTURE" ,120,28,30);
        String tridentEmoji ="🔱";
        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(30,1);
        cn.getTextWindow().output(tridentEmoji + " PERCY'S ADVENTURE " + tridentEmoji,cyan);
        System.out.println();
    }

    public static void printMenuItems() {

        TextAttributes cyan = new TextAttributes(Color.cyan,Color.darkGray);
        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(38,7);
        cn.getTextWindow().output("START" ,cyan);
        System.out.println();

        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(34,15);
        cn.getTextWindow().output("STORY OF PERCY" ,cyan);
        System.out.println();

        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(36,11);
        cn.getTextWindow().output("HIGH SCORE" ,cyan);
        System.out.println();

        cn.getTextWindow().setTitle(String.valueOf("PERCY'S ADVENTURE"));
        cn.getTextWindow().setCursorPosition(39,19);
        cn.getTextWindow().output("QUİT" ,cyan);
        System.out.println();
    }
    public static void drawSquare() {

        int counter=0;
        for(int i=0;i<44;i=i+2){
            TextAttributes cyan = new TextAttributes(Color.WHITE,Color.WHITE);
            cn.getTextWindow().setCursorPosition(19+i,3);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);

        }

        for(int i=0;i<20;i++){
            TextAttributes cyan = new TextAttributes(Color.WHITE,Color.WHITE);
            cn.getTextWindow().setCursorPosition(19,3+i);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);
            counter++;
        }

        for(int i=0;i<42;i++){
            TextAttributes cyan = new TextAttributes(Color.WHITE,Color.WHITE);
            cn.getTextWindow().setCursorPosition(19+i,3+counter);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);

        }

        for(int i=0;i<20;i++){
            TextAttributes cyan = new TextAttributes(Color.WHITE,Color.WHITE);
            cn.getTextWindow().setCursorPosition(61,4+i);
            char tilda = '~';
            cn.getTextWindow().output(tilda +" ",cyan);

        }
    }
    public static void playBackgroundMusic(String musicLocation)
    {

        try
        {
            File musicPath = new File(musicLocation);

            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.addLineListener(event ->
                {
                    if(LineEvent.Type.STOP.equals(event.getType()))
                    {
                        clip.close();
                    }
                });
                //JOptionPane.showMessageDialog(null, "Press OK to stop playing");
            } else
            {
                System.out.println("Can't find file");
            }
        }

        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }



}
