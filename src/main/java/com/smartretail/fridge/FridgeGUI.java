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

public class FridgeGUI extends JFrame {
    private final FridgeServiceGrpc.FridgeServiceBlockingStub blockingStub;
    private final FridgeServiceGrpc.FridgeServiceStub asyncStub;

    private JLabel fridgeStatusLabel;
    private JLabel temperatureLabel;
    private JLabel timestampLabel;
    private JButton refreshButton;
    private JButton turnOnButton;
    private JButton turnOffButton;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

        refreshButton = new JButton("Refresh Status");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshStatus();
            }
        });
        mainPanel.add(refreshButton);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        turnOnButton = new JButton("Turn On");
        turnOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlFridge(true);
            }
        });
        controlPanel.add(turnOnButton);

        turnOffButton = new JButton("Turn Off");
        turnOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlFridge(false);
            }
        });
        controlPanel.add(turnOffButton);

        mainPanel.add(controlPanel);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void refreshStatus() {
        FridgeProto.FridgeStatusRequest request = FridgeProto.FridgeStatusRequest.newBuilder().build();
        FridgeProto.FridgeStatusResponse response = blockingStub.getFridgeStatus(request);
        fridgeStatusLabel.setText(response.getIsFridgeOn() ? "On" : "Off");
        temperatureLabel.setText(String.format("%.1f°C", response.getTemperature()));
        timestampLabel.setText(dateFormat.format(new Date()));
    }

    private void controlFridge(boolean turnOn) {
        FridgeProto.FridgeControlRequest request = FridgeProto.FridgeControlRequest.newBuilder()
                .setTurnOn(turnOn)
                .build();
        blockingStub.controlFridge(request);
        refreshStatus();
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
