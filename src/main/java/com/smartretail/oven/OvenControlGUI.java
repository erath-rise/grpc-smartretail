package com.smartretail.oven;

import com.smartretail.generated.OvenProto;
import com.smartretail.generated.OvenServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

public class OvenControlGUI extends JFrame {
    private JLabel ovenStatusLabel;
    private JLabel temperatureLabel;
    private JLabel bakingTaskLabel;
    private JLabel runningTimeLabel;
    private JButton controlButton;
    private JTextArea eventLogTextArea;

    private OvenServiceGrpc.OvenServiceBlockingStub blockingStub;
    private Timer timer;

    public OvenControlGUI(OvenServiceGrpc.OvenServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
        initComponents();
    }

    public void initComponents() {
        setTitle("Oven Control");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new FlowLayout());

        JLabel statusLabel = new JLabel("Oven Status:");
        statusPanel.add(statusLabel);

        ovenStatusLabel = new JLabel();
        statusPanel.add(ovenStatusLabel);

        mainPanel.add(statusPanel, BorderLayout.NORTH);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(4, 2));

        JLabel temperatureTextLabel = new JLabel("Temperature:");
        detailsPanel.add(temperatureTextLabel);

        temperatureLabel = new JLabel();
        detailsPanel.add(temperatureLabel);

        JLabel bakingTaskTextLabel = new JLabel("Baking Task:");
        detailsPanel.add(bakingTaskTextLabel);

        bakingTaskLabel = new JLabel();
        detailsPanel.add(bakingTaskLabel);

        JLabel runningTimeTextLabel = new JLabel("Running Time:");
        detailsPanel.add(runningTimeTextLabel);

        runningTimeLabel = new JLabel();
        detailsPanel.add(runningTimeLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(detailsPanel, BorderLayout.NORTH);
        centerPanel.add(new JSeparator(), BorderLayout.SOUTH);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        controlButton = new JButton("Turn On");
        controlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleOvenControl();
            }
        });
        mainPanel.add(controlButton, BorderLayout.SOUTH);

        eventLogTextArea = new JTextArea();
        eventLogTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(eventLogTextArea);
        mainPanel.add(scrollPane, BorderLayout.EAST);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void updateOvenStatus() {
        OvenProto.OvenStatusRequest request = OvenProto.OvenStatusRequest.newBuilder().build();
        OvenProto.OvenStatusResponse response;

        try {
            response = blockingStub.getOvenStatus(request);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        if (response != null && !response.equals(OvenProto.OvenStatusResponse.getDefaultInstance())) {
            String status = response.getIsOvenOn() ? "On" : "Off";
            ovenStatusLabel.setText(status);
            temperatureLabel.setText(String.format("%.1f°C", response.getTemperature()));
            bakingTaskLabel.setText(response.getBakingTask());
            runningTimeLabel.setText(String.format("%d seconds", response.getRemainingTime()));
        } else {
            ovenStatusLabel.setText("N/A");
            temperatureLabel.setText("N/A");
            bakingTaskLabel.setText("N/A");
            runningTimeLabel.setText("N/A");
            stopOvenStatusUpdater();
        }
    }

    private void toggleOvenControl() {
        boolean isOvenOn = controlButton.getText().equals("Turn Off");
        OvenProto.OvenControlRequest request = OvenProto.OvenControlRequest.newBuilder()
                .setTurnOn(!isOvenOn)
                .build();
        blockingStub.controlOven(request);
        controlButton.setText(isOvenOn ? "Turn On" : "Turn Off");
        updateOvenStatus();
        logEvent("Oven turned " + (isOvenOn ? "off" : "on"));

        if (isOvenOn) {
            stopOvenStatusUpdater();
        } else {
            startOvenStatusUpdater();
        }
    }

    private void logEvent(String event) {
        eventLogTextArea.append(event + "\n");
    }

    private void startOvenStatusUpdater() {
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
                        updateOvenStatus();
                    }
                });
            }
        }, 0, 15000); // Run every 15 seconds
    }

    private void stopOvenStatusUpdater() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        OvenServiceGrpc.OvenServiceBlockingStub blockingStub = OvenServiceGrpc.newBlockingStub(channel);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                OvenControlGUI gui = new OvenControlGUI(blockingStub);
                gui.setVisible(true);
            }
        });
    }
}

