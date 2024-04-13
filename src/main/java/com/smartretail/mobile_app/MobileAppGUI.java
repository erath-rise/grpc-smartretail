package com.smartretail.mobile_app;

import com.smartretail.generated.FridgeProto;
import com.smartretail.generated.MobileAppProto;
import com.smartretail.generated.MobileAppServiceGrpc;
import com.smartretail.generated.OvenProto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

public class MobileAppGUI extends JFrame {
    private JLabel ovenStatusLabel;
    private JLabel ovenTemperatureLabel;
    private JLabel ovenBakingTaskLabel;
    private JLabel ovenRunningTimeLabel;
    private JButton ovenControlButton;

    private JLabel fridgeStatusLabel;
    private JLabel fridgeTemperatureLabel;
    private JButton fridgeControlButton;

    private MobileAppServiceGrpc.MobileAppServiceBlockingStub blockingStub;
    private Timer timer;

    public MobileAppGUI(MobileAppServiceGrpc.MobileAppServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
        initComponents();
    }

    private void initComponents() {
        setTitle("Mobile App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

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

        JPanel ovenStatusPanel = new JPanel();
        ovenStatusPanel.setLayout(new FlowLayout());
        JLabel ovenStatusTextLabel = new JLabel("Status:");
        ovenStatusPanel.add(ovenStatusTextLabel);
        ovenStatusLabel = new JLabel();
        ovenStatusPanel.add(ovenStatusLabel);
        ovenPanel.add(ovenStatusPanel);

        JPanel ovenTemperaturePanel = new JPanel();
        ovenTemperaturePanel.setLayout(new FlowLayout());
        JLabel ovenTemperatureTextLabel = new JLabel("Temperature:");
        ovenTemperaturePanel.add(ovenTemperatureTextLabel);
        ovenTemperatureLabel = new JLabel();
        ovenTemperaturePanel.add(ovenTemperatureLabel);
        ovenPanel.add(ovenTemperaturePanel);

        JPanel ovenBakingTaskPanel = new JPanel();
        ovenBakingTaskPanel.setLayout(new FlowLayout());
        JLabel ovenBakingTaskTextLabel = new JLabel("Baking Task:");
        ovenBakingTaskPanel.add(ovenBakingTaskTextLabel);
        ovenBakingTaskLabel = new JLabel();
        ovenBakingTaskPanel.add(ovenBakingTaskLabel);
        ovenPanel.add(ovenBakingTaskPanel);

        JPanel ovenRunningTimePanel = new JPanel();
        ovenRunningTimePanel.setLayout(new FlowLayout());
        JLabel ovenRunningTimeTextLabel = new JLabel("Running Time:");
        ovenRunningTimePanel.add(ovenRunningTimeTextLabel);
        ovenRunningTimeLabel = new JLabel();
        ovenRunningTimePanel.add(ovenRunningTimeLabel);
        ovenPanel.add(ovenRunningTimePanel);

        ovenControlButton = new JButton("Turn On");
        ovenControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleOvenControl();
            }
        });
        ovenPanel.add(ovenControlButton);

        return ovenPanel;
    }

    private JPanel createFridgePanel() {
        JPanel fridgePanel = new JPanel();
        fridgePanel.setLayout(new BoxLayout(fridgePanel, BoxLayout.Y_AXIS));
        fridgePanel.setBorder(BorderFactory.createTitledBorder("Fridge"));

        JPanel fridgeStatusPanel = new JPanel();
        fridgeStatusPanel.setLayout(new FlowLayout());
        JLabel fridgeStatusTextLabel = new JLabel("Status:");
        fridgeStatusPanel.add(fridgeStatusTextLabel);
        fridgeStatusLabel = new JLabel();
        fridgeStatusPanel.add(fridgeStatusLabel);
        fridgePanel.add(fridgeStatusPanel);

        JPanel fridgeTemperaturePanel = new JPanel();
        fridgeTemperaturePanel.setLayout(new FlowLayout());
        JLabel fridgeTemperatureTextLabel = new JLabel("Temperature:");
        fridgeTemperaturePanel.add(fridgeTemperatureTextLabel);
        fridgeTemperatureLabel = new JLabel();
        fridgeTemperaturePanel.add(fridgeTemperatureLabel);
        fridgePanel.add(fridgeTemperaturePanel);

        fridgeControlButton = new JButton("Turn On");
        fridgeControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleFridgeControl();
            }
        });
        fridgePanel.add(fridgeControlButton);

        return fridgePanel;
    }

    private void toggleOvenControl() {
        boolean isOvenOn = ovenControlButton.getText().equals("Turn Off");
        OvenProto.OvenControlRequest request = OvenProto.OvenControlRequest.newBuilder()
                .setTurnOn(!isOvenOn)
                .build();
        blockingStub.controlOven(request);
        ovenControlButton.setText(isOvenOn ? "Turn On" : "Turn Off");
        updateOvenStatus();

        if (isOvenOn) {
            stopOvenStatusUpdater();
        } else {
            startOvenStatusUpdater();
        }
    }

    private void toggleFridgeControl() {
        boolean isFridgeOn = fridgeControlButton.getText().equals("Turn Off");
        FridgeProto.FridgeControlRequest request = FridgeProto.FridgeControlRequest.newBuilder()
                .setTurnOn(!isFridgeOn)
                .build();
        blockingStub.controlFridge(request);
        fridgeControlButton.setText(isFridgeOn ? "Turn On" : "Turn Off");
        updateFridgeStatus();

        if (isFridgeOn) {
            stopFridgeStatusUpdater();
        } else {
            startFridgeStatusUpdater();
        }
    }

    private void updateOvenStatus() {
        MobileAppProto.OvenMonitorRequest request = MobileAppProto.OvenMonitorRequest.newBuilder().build();
        OvenProto.OvenStatusResponse response;

        try {
            response = blockingStub.monitorOvenStatus(request);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        if (response != null && !response.equals(OvenProto.OvenStatusResponse.getDefaultInstance())) {
            String status = response.getIsOvenOn() ? "On" : "Off";
            ovenStatusLabel.setText(status);
            ovenTemperatureLabel.setText(String.format("%.1f°C", response.getTemperature()));
            ovenBakingTaskLabel.setText(response.getBakingTask());
            ovenRunningTimeLabel.setText(String.format("%d seconds", response.getRemainingTime()));
        } else {
            ovenStatusLabel.setText("N/A");
            ovenTemperatureLabel.setText("N/A");
            ovenBakingTaskLabel.setText("N/A");
            ovenRunningTimeLabel.setText("N/A");
            stopOvenStatusUpdater();
        }
    }

    private void updateFridgeStatus() {
        MobileAppProto.FridgeMonitorRequest request = MobileAppProto.FridgeMonitorRequest.newBuilder().build();
        FridgeProto.FridgeStatusResponse response;

        try {
            response = blockingStub.monitorFridgeStatus(request);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        if (response != null && !response.equals(FridgeProto.FridgeStatusResponse.getDefaultInstance())) {
            String status = response.getIsFridgeOn() ? "On" : "Off";
            fridgeStatusLabel.setText(status);
            fridgeTemperatureLabel.setText(String.format("%.1f°C", response.getTemperature()));
        } else {
            fridgeStatusLabel.setText("N/A");
            fridgeTemperatureLabel.setText("N/A");
            stopFridgeStatusUpdater();
        }
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
        MobileAppServiceGrpc.MobileAppServiceBlockingStub blockingStub = MobileAppServiceGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
        MobileAppGUI mobileAppGUI = new MobileAppGUI(blockingStub);
        mobileAppGUI.setVisible(true);
    }

}
