package com.smartretail.mobile_app;

import com.smartretail.generated.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

public class MobileAppGUI extends JFrame {
    private MobileAppServiceGrpc.MobileAppServiceBlockingStub blockingStub;
    private FridgeServiceGrpc.FridgeServiceBlockingStub fridgeBlockingStub;
    private Timer timer;
    private JLabel ovenStatusLabel;
    private JLabel ovenTemperatureLabel;
    private JLabel ovenBakingTaskLabel;
    private JLabel ovenRemainingTimeLabel;
    private JButton getOvenStatusButton;
    private JButton ovenTurnOffButton;
    private JLabel fridgeStatusLabel;
    private JLabel fridgeTemperatureLabel;
    private JLabel timestampLabel;
    private JTextArea fridgeHistoryTextArea;
    private JButton fridgeTurnOnButton;
    private JButton fridgeTurnOffButton;

    public MobileAppGUI() {
        gRPCConnection();
        initComponents();
    }

    private void initComponents() {
        setTitle("Mobile App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 500));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel ovenPanel = createOvenPanel();
        mainPanel.add(ovenPanel);

        JPanel fridgePanel = createFridgePanel();
        mainPanel.add(fridgePanel);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createOvenPanel() {
        JPanel ovenPanel = new JPanel();
        ovenPanel.setLayout(new BoxLayout(ovenPanel, BoxLayout.Y_AXIS));
        ovenPanel.setBorder(BorderFactory.createTitledBorder("Oven"));

        ovenStatusLabel = new JLabel("Status: ");
        ovenPanel.add(ovenStatusLabel);

        ovenTemperatureLabel = new JLabel("Temperature: ");
        ovenPanel.add(ovenTemperatureLabel);

        ovenBakingTaskLabel = new JLabel("Baking Task: ");
        ovenPanel.add(ovenBakingTaskLabel);

        ovenRemainingTimeLabel = new JLabel("Remaining Time: ");
        ovenPanel.add(ovenRemainingTimeLabel);

        getOvenStatusButton = new JButton("Get Oven Status");
        getOvenStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOvenStatus();
            }
        });
        ovenPanel.add(getOvenStatusButton);

        ovenTurnOffButton = new JButton("Turn Off");
        ovenTurnOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnOffOven();
            }
        });
        ovenPanel.add(ovenTurnOffButton);

        return ovenPanel;
    }

    private JPanel createFridgePanel() {
        JPanel fridgePanel = new JPanel();
        fridgePanel.setLayout(new BoxLayout(fridgePanel, BoxLayout.Y_AXIS));
        fridgePanel.setBorder(BorderFactory.createTitledBorder("Fridge"));

        fridgeStatusLabel = new JLabel("Status: ");
        fridgePanel.add(fridgeStatusLabel);

        fridgeTemperatureLabel = new JLabel("Temperature: ");
        fridgePanel.add(fridgeTemperatureLabel);


        timestampLabel = new JLabel("Timestamp: ");
        fridgePanel.add(timestampLabel);

        fridgeHistoryTextArea = new JTextArea(10, 30);
        fridgeHistoryTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fridgeHistoryTextArea);
        fridgePanel.add(scrollPane);


        fridgeTurnOnButton = new JButton("Get Fridge Status");
        fridgeTurnOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlFridge(true);
                startFridgeStatusUpdater();
            }
        });
        fridgePanel.add(fridgeTurnOnButton);

        fridgeTurnOffButton = new JButton("Turn Off");
        fridgeTurnOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlFridge(false);
                stopFridgeStatusUpdater();
                displayDefaultFridgeStatus();
            }
        });
        fridgePanel.add(fridgeTurnOffButton);

        return fridgePanel;
    }

    private void gRPCConnection() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()
                .build();
        blockingStub = MobileAppServiceGrpc.newBlockingStub(channel);
        fridgeBlockingStub = FridgeServiceGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build());
    }

    private void turnOffOven() {
        OvenProto.OvenControlRequest request = OvenProto.OvenControlRequest.newBuilder()
                .setTurnOn(false)
                .build();
        blockingStub.controlOven(request);
        displayDefaultOvenStatus();
    }

    private void displayDefaultOvenStatus() {
        ovenStatusLabel.setText("Status: N/A");
        ovenTemperatureLabel.setText("Temperature: N/A");
        ovenBakingTaskLabel.setText("Baking Task: N/A");
        ovenRemainingTimeLabel.setText("Remaining Time: N/A");
    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private void updateFridgeStatus() {
        FridgeProto.FridgeStatusRequest request = FridgeProto.FridgeStatusRequest.newBuilder().build();
        FridgeProto.FridgeStatusResponse response;

        try {
            response = fridgeBlockingStub.getFridgeStatus(request);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        if (response != null && !response.equals(FridgeProto.FridgeStatusResponse.getDefaultInstance())) {
            String status = response.getIsFridgeOn() ? "On" : "Off";
            String temperature = response.getTemperature() + "°C";
            String timestamp = dateFormat.format(new Date());
            fridgeStatusLabel.setText("Status: " + status);
            fridgeTemperatureLabel.setText("Temperature: " + temperature);
            timestampLabel.setText("Timestamp: " + timestamp);
            fridgeHistoryTextArea.append("Status: " + status + ", Temperature: " + temperature + ", Timestamp: " + timestamp + "\n");
        } else {
            fridgeStatusLabel.setText("Status: N/A");
            fridgeTemperatureLabel.setText("Temperature: N/A");
            timestampLabel.setText("Timestamp: N/A");
            stopFridgeStatusUpdater();
        }
    }

    private void displayDefaultFridgeStatus() {
        fridgeStatusLabel.setText("Status: N/A");
        fridgeTemperatureLabel.setText("Temperature: N/A");
        timestampLabel.setText("Timestamp: N/A");
    }



    private void controlFridge(boolean turnOn) {
        FridgeProto.FridgeControlRequest request = FridgeProto.FridgeControlRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();
        fridgeBlockingStub.controlFridge(request);
        if (!turnOn) {
            fridgeHistoryTextArea.setText("");
        }
    }


    private void startFridgeStatusUpdater() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        updateFridgeStatus();
                    }
                });
            }
        }, 0, 15000);
    }

    private void stopFridgeStatusUpdater() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }


    private void updateOvenStatus() {
        MobileAppProto.OvenMonitorRequest request = MobileAppProto.OvenMonitorRequest.newBuilder().build();
        OvenProto.OvenStatusResponse response = blockingStub.monitorOvenStatus(request).next();
        ovenStatusLabel.setText("Status: " + (response.getIsOvenOn() ? "On" : "Off"));
        ovenTemperatureLabel.setText("Temperature: " + response.getTemperature() + "°C");
        ovenBakingTaskLabel.setText("Baking Task: " + response.getBakingTask());
        ovenRemainingTimeLabel.setText("Remaining Time: " + response.getRemainingTime() + " seconds");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MobileAppGUI().setVisible(true);
            }
        });
    }

}