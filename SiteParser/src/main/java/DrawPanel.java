import javax.swing.*;
import java.awt.*;

public class DrawPanel extends GetInfo implements Drawable {

    @Override
    public void draw() {



        JFrame jFrame = new JFrame("ASIC alerts");
        jFrame.setBounds(750, 500, 500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container contentPane = jFrame.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        //LABEL ASIC1
        JLabel asic1 = new JLabel("ASIC 1");
        layout.putConstraint(SpringLayout.WEST, asic1, 10,
                SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, asic1, 15,
                SpringLayout.NORTH, contentPane);
        contentPane.add(asic1);

        //LABEL ASIC2
        JLabel asic2 = new JLabel("ASIC 2");
        layout.putConstraint(SpringLayout.WEST, asic2, 260,
                SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, asic2, 15,
                SpringLayout.NORTH, contentPane);
        contentPane.add(asic2);



        //LEFT PANEL
        asicData asicData = asicDataByLabel.get("asic1");
        JLabel labelLeftFan1 = new JLabel("FAN 1");
        JTextField fieldLeftFan1 = new JTextField(15);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    fieldLeftFan1.setText(String.valueOf(asicData.fan0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        fieldLeftFan1.setEditable(false);

        contentPane.add(labelLeftFan1);
        contentPane.add(fieldLeftFan1);
        layout.putConstraint(SpringLayout.WEST, labelLeftFan1, 10,
                SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelLeftFan1, 50,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, fieldLeftFan1, 50,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, fieldLeftFan1, 20,
                SpringLayout.EAST, labelLeftFan1);

        JLabel labelLeftFan2 = new JLabel("FAN 2");
        JTextField fieldLeftFan2 = new JTextField(15);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    fieldLeftFan2.setText(String.valueOf(asicData.fan1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        fieldLeftFan2.setEditable(false);

        contentPane.add(labelLeftFan2);
        contentPane.add(fieldLeftFan2);
        layout.putConstraint(SpringLayout.WEST, labelLeftFan2, 10,
                SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelLeftFan2, 75,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, fieldLeftFan2, 75,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, fieldLeftFan2, 20,
                SpringLayout.EAST, labelLeftFan2);

        JLabel labelLeftFan3 = new JLabel("FAN 3");
        JTextField fieldLeftFan3 = new JTextField(15);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    fieldLeftFan3.setText(String.valueOf(asicData.fan2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        fieldLeftFan3.setEditable(false);

        contentPane.add(labelLeftFan3);
        contentPane.add(fieldLeftFan3);
        layout.putConstraint(SpringLayout.WEST, labelLeftFan3, 10,
                SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelLeftFan3, 100,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, fieldLeftFan3, 100,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, fieldLeftFan3, 20,
                SpringLayout.EAST, labelLeftFan3);

        JLabel labelLeftFan4 = new JLabel("FAN 4");
        JTextField fieldLeftFan4 = new JTextField(15);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    fieldLeftFan4.setText(String.valueOf(asicData.fan3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        fieldLeftFan4.setEditable(false);

        contentPane.add(labelLeftFan4);
        contentPane.add(fieldLeftFan4);
        layout.putConstraint(SpringLayout.WEST, labelLeftFan4, 10,
                SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelLeftFan4, 125,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, fieldLeftFan4, 125,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, fieldLeftFan4, 20,
                SpringLayout.EAST, labelLeftFan4);



        //RIGHT PANEL
        asicData asicData1 = asicDataByLabel.get("asic2");
        JLabel labelRightFan1 = new JLabel("FAN 1");
        JTextField fieldRightFan1 = new JTextField(15);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);

                    fieldRightFan1.setText(String.valueOf(asicData1.fan0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        fieldRightFan1.setEditable(false);

        contentPane.add(labelRightFan1);
        contentPane.add(fieldRightFan1);
        layout.putConstraint(SpringLayout.WEST, labelRightFan1, 260,
                SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelRightFan1, 50,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, fieldRightFan1, 50,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, fieldRightFan1, 15,
                SpringLayout.EAST, labelRightFan1);

        JLabel labelRightFan2 = new JLabel("FAN 2");
        JTextField fieldRightFan2 = new JTextField(15);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    fieldRightFan2.setText(String.valueOf(asicData1.fan1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        fieldRightFan2.setEditable(false);

        contentPane.add(labelRightFan2);
        contentPane.add(fieldRightFan2);
        layout.putConstraint(SpringLayout.WEST, labelRightFan2, 260,
                SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelRightFan2, 75,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, fieldRightFan2, 75,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, fieldRightFan2, 15,
                SpringLayout.EAST, labelRightFan2);

        JLabel labelRightFan3 = new JLabel("FAN 3");
        JTextField fieldRightFan3 = new JTextField(15);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    fieldRightFan3.setText(String.valueOf(asicData1.fan2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        fieldRightFan3.setEditable(false);

        contentPane.add(labelRightFan3);
        contentPane.add(fieldRightFan3);
        layout.putConstraint(SpringLayout.WEST, labelRightFan3, 260,
                SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelRightFan3, 100,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, fieldRightFan3, 100,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, fieldRightFan3, 15,
                SpringLayout.EAST, labelRightFan3);

        JLabel labelRightFan4 = new JLabel("FAN 4");
        JTextField fieldRightFan4 = new JTextField(15);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    fieldRightFan4.setText(String.valueOf(asicData1.fan3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        fieldRightFan4.setEditable(false);

        contentPane.add(labelRightFan4);
        contentPane.add(fieldRightFan4);
        layout.putConstraint(SpringLayout.WEST, labelRightFan4, 260,
                SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, labelRightFan4, 125,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, fieldRightFan4, 125,
                SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, fieldRightFan4, 15,
                SpringLayout.EAST, labelRightFan4);

        jFrame.setVisible(true);
        jFrame.revalidate();

    }
}
