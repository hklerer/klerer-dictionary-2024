package klerer.dictionary;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.List;

public class DictionaryFrame extends JFrame {

    private JTextField wordField;
    private JTextArea definitionArea;
    private EnglishDictionary englishDictionary;

    public DictionaryFrame() {
        englishDictionary = new EnglishDictionary();

        setTitle("Dictionary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        wordField = new JTextField();
        wordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateDefinition();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateDefinition();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateDefinition();
            }
        });

        definitionArea = new JTextArea();
        definitionArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(definitionArea);

        add(wordField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame
    }

    private void updateDefinition() {
        String word = wordField.getText().trim();
        List<String> definitions = englishDictionary.getDefinition(word);
        StringBuilder sb = new StringBuilder();
        for (String definition : definitions) {
            sb.append(definition).append("\n");
        }
        definitionArea.setText(sb.toString());
    }
}