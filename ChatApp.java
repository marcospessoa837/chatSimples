package chatSimples;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class ChatApp extends JFrame implements ActionListener {

    private JTextField textField;

    private JTextArea textArea;

    private JButton sendButton;

    private String userName;



    public ChatApp(String userName) {

        this.userName = userName;



        setTitle("Chat - " + userName);

        setSize(400, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        textField = new JTextField(30);

        textArea = new JTextArea(10, 30);

        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        sendButton = new JButton("Send");

        sendButton.addActionListener(this);



        JPanel panel = new JPanel();

        panel.add(textField);

        panel.add(sendButton);



        add(scrollPane, BorderLayout.CENTER);

        add(panel, BorderLayout.SOUTH);



        setVisible(true);

    }



    public static void main(String[] args) {

        String userName = JOptionPane.showInputDialog("Enter your username:");

        if (userName != null && !userName.isEmpty()) {

            SwingUtilities.invokeLater(new Runnable() {

                public void run() {

                    new ChatApp(userName);

                }

            });

        } else {

            JOptionPane.showMessageDialog(null, "Username cannot be empty. Exiting...", "Error", JOptionPane.ERROR_MESSAGE);

            System.exit(1);

        }

    }



    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sendButton) {

            String message = textField.getText().trim();

            if (!message.isEmpty()) {

                appendMessage(userName + ": " + message);

                textField.setText("");

            }

        }

    }



    private void appendMessage(String message) {

        textArea.append(message + "\n");

        textArea.setCaretPosition(textArea.getDocument().getLength());

    }

}