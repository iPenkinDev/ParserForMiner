import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GetInfo {

    static Map<String, asicData> asicDataByLabel = new HashMap<>();


    public static void checkHealth(String url, String label) throws IOException {
        Gson gson = new Gson();

        try {

            Document doc = Jsoup.connect(url).timeout(5_000).get();
            System.out.println(label);
            String json = doc.firstElementSibling().text();

            Map map = gson.fromJson(json, Map.class);

            Map statsMap = (Map) ((List) map.get("STATS")).get(0);

            double rate5s = (Double) (statsMap.get("rate_5s"));
            System.out.println("rate_5s=" + rate5s);

            List<Map> chainList = (List<Map>) statsMap.get("chain");

            if (chainList.size() != 3) {
                System.out.println("ALERT");
                playAlert(label + "\nNumber of HashPlates");

            }
            if (rate5s < 75000) {
                playAlert(label + "\nRate is too low");
            }

            List<Double> fanList = (List<Double>) (statsMap.get("fan"));



            asicData asicData = asicDataByLabel.get(label);
            asicData.fan0 = fanList.get(0);
            asicData.fan1 = fanList.get(1);
            asicData.fan2 = fanList.get(2);
            asicData.fan3 = fanList.get(3);




            if (asicData.fan0 < 4800) {
                playAlert(label + "\nfan");
            }
            if (asicData.fan1 < 4800) {
                playAlert(label + "\nfan");
            }
            if (asicData.fan2 < 5200) {
                playAlert(label + "\nfan");
            }
            if (asicData.fan3 < 5200) {
                playAlert(label + "\nfan");
            }
            System.out.println("fan " + asicData.fan0 + " " + asicData.fan1 + " " + asicData.fan2 + " " + asicData.fan3);

            for (Map chain : chainList) {
                List<Double> tempChipList = (List<Double>) (chain.get("temp_chip"));

                double tempChip0 = tempChipList.get(2);
                double tempChip1 = tempChipList.get(3);
                if (tempChip0 > 75) {
                    playAlert(label + "\ntemp");
                }
                if (tempChip1 > 75) {
                    playAlert(label + "\ntemp");
                }
                System.out.println("chipTemp " + tempChip0 + " " + tempChip1);
            }


            //throw new RuntimeException();
        } catch (Exception e) {
            System.err.println("Got failure for=" + label);
            e.printStackTrace();
            playAlert(url + "\nunexpected error=" + e);
        }
    }

    private static void playAlert(String errorMessage) {
        new Thread(() -> {
            JOptionPane.showMessageDialog(null, errorMessage);
        })
                .start();
        try {
            File yourFile = new File("./kolokolchik.wav");
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;

            stream = AudioSystem.getAudioInputStream(yourFile);
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // CREATE THREAD
    static Thread run = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {

                    checkHealth("http://192.168.0.100/cgi-bin/stats.cgi", "asic1");
                    checkHealth("http://192.168.0.101/cgi-bin/stats.cgi", "asic2");


                    Thread.sleep(15_000); //1000 - 1 сек


                } catch (Exception ex) {

                    ex.printStackTrace();
                }
            }
        }
    });

}
