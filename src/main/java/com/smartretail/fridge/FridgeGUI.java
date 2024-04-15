package com.smartretail.fridge;

import com.smartretail.generated.FridgeProto;
import com.smartretail.generated.FridgeServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class FridgeGUI extends JFrame {
    private final FridgeServiceGrpc.FridgeServiceBlockingStub blockingStub;
    private final FridgeServiceGrpc.FridgeServiceStub asyncStub;

    private JLabel fridgeStatusLabel;
    private JLabel temperatureLabel;
    private JLabel timestampLabel;
    private JButton controlButton;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Timer timer;

    public FridgeGUI(String host, int port) {
        super("Fridge Control Panel");

        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = FridgeServiceGrpc.newBlockingStub(channel);
        asyncStub = FridgeServiceGrpc.newStub(channel);

        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 250));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));

        JPanel fridgeStatusPanel = new JPanel();
        fridgeStatusPanel.setLayout(new FlowLayout());
        JLabel statusLabel = new JLabel("Fridge Status:");
        fridgeStatusPanel.add(statusLabel);
        fridgeStatusLabel = new JLabel();
        fridgeStatusPanel.add(fridgeStatusLabel);
        statusPanel.add(fridgeStatusPanel);

        JPanel temperaturePanel = new JPanel();
        temperaturePanel.setLayout(new FlowLayout());
        JLabel tempLabel = new JLabel("Temperature:");
        temperaturePanel.add(tempLabel);
        temperatureLabel = new JLabel();
        temperaturePanel.add(temperatureLabel);
        statusPanel.add(temperaturePanel);

        JPanel timestampPanel = new JPanel();
        timestampPanel.setLayout(new FlowLayout());
        JLabel tsLabel = new JLabel("Timestamp:");
        timestampPanel.add(tsLabel);
        timestampLabel = new JLabel();
        timestampPanel.add(timestampLabel);
        statusPanel.add(timestampPanel);

        mainPanel.add(statusPanel);

        controlButton = new JButton("Turn On");
        controlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleFridgeControl();
            }
        });
        mainPanel.add(controlButton);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void updateFridgeStatus() {
        FridgeProto.FridgeStatusRequest request = FridgeProto.FridgeStatusRequest.newBuilder().build();
        FridgeProto.FridgeStatusResponse response;

        try {
            response = blockingStub.getFridgeStatus(request);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        if (response != null && !response.equals(FridgeProto.FridgeStatusResponse.getDefaultInstance())) {
            String status = response.getIsFridgeOn() ? "On" : "Off";
            fridgeStatusLabel.setText(status);
            temperatureLabel.setText(String.format("%.1f°C", response.getTemperature()));
            timestampLabel.setText(dateFormat.format(new Date()));
        } else {
            fridgeStatusLabel.setText("N/A");
            temperatureLabel.setText("N/A");
            timestampLabel.setText("N/A");
            stopFridgeStatusUpdater();
        }
    }

    private void controlFridge(boolean turnOn) {
        FridgeProto.FridgeControlRequest request = FridgeProto.FridgeControlRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();
        blockingStub.controlFridge(request);

        if (turnOn) {
            startFridgeStatusUpdater();
        } else {
            stopFridgeStatusUpdater();
        }
    }

    private void toggleFridgeControl() {
        boolean isFridgeOn = controlButton.getText().equals("Turn Off");
        controlButton.setText(isFridgeOn ? "Turn On" : "Turn Off");
        controlFridge(!isFridgeOn);
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
        }, 0, 15000); // Run every 15 seconds
    }

    private void stopFridgeStatusUpdater() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FridgeGUI gui = new FridgeGUI("localhost", 50052);
                gui.setVisible(true);
            }
        });
    }
}
