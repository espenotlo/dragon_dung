import backgrounds.BackgroundDataBase;
import backgrounds.Background;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class CharacterCreator {
    public CharacterCreator() {

        BackgroundDataBase backgrounds = new BackgroundDataBase();

        JFrame frame = new JFrame("Character Creator");
        frame.setSize(600, 600);
        frame.setResizable(false);

        JPanel mainPanel = (JPanel) frame.getContentPane();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.lightGray);
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        //A text area that will show a description of the currently selected choice.
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setBackground(Color.lightGray);
        Dimension descriptionAreaDimension = new Dimension(200, 400);
        descriptionArea.setPreferredSize(descriptionAreaDimension);
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);

        String[] races = new String[]{"Select Race", "Elf", "Dwarf", "Human", "Orc"};
        JComboBox<String> raceSelect = new JComboBox<>(races);
        Dimension dd = new Dimension(130, 10);
        raceSelect.setPreferredSize(dd);

        String[] none = new String[]{"N/A"};
        JComboBox<String> subRaceSelect = new JComboBox<>(none);
        subRaceSelect.setPreferredSize(dd);

        raceSelect.addActionListener(event -> {
            JComboBox<String> combo = (JComboBox<String>) event.getSource();
            String selectedRace = (String) combo.getSelectedItem();

            switch (Objects.requireNonNull(selectedRace)) {
                case "Elf" -> {
                    subRaceSelect.removeAllItems();
                    subRaceSelect.addItem("Subrace");
                    subRaceSelect.addItem("High Elf");
                    subRaceSelect.addItem("Wood Elf");
                    descriptionArea.setText("Elf Description");
                }
                case "Dwarf" -> {
                    subRaceSelect.removeAllItems();
                    subRaceSelect.addItem("Subrace");
                    subRaceSelect.addItem("Hill Dwarf");
                    subRaceSelect.addItem("Mountain Dwarf");
                }
                case "Human" -> {
                    subRaceSelect.removeAllItems();
                    subRaceSelect.addItem("Subrace");
                    subRaceSelect.addItem("Human");
                    subRaceSelect.addItem("Variant Human");
                }
                default -> {
                    subRaceSelect.removeAllItems();
                    subRaceSelect.addItem("N/A");
                }
            }
        });

        String[] classes = new String[]{"Select Class", "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
        JComboBox<String> classSelect = new JComboBox<>(classes);
        classSelect.setPreferredSize(dd);

        JComboBox<String> subClassSelect = new JComboBox<>(none);
        subClassSelect.setPreferredSize(dd);

        classSelect.addActionListener(event -> {
            JComboBox<String> combo = (JComboBox<String>) event.getSource();
            String selectedClass = (String) combo.getSelectedItem();

            switch (Objects.requireNonNull(selectedClass)) {
                case "Cleric" -> {
                    subClassSelect.removeAllItems();
                    subClassSelect.addItem("Divine Domain");
                    subClassSelect.addItem("Arcana");
                    subClassSelect.addItem("Death");
                    subClassSelect.addItem("Forge");
                    subClassSelect.addItem("Grave");
                    subClassSelect.addItem("Knowledge");
                    subClassSelect.addItem("Life");
                    subClassSelect.addItem("Light");
                    subClassSelect.addItem("Nature");
                    subClassSelect.addItem("Order");
                    subClassSelect.addItem("Peace");
                    subClassSelect.addItem("Tempest");
                    subClassSelect.addItem("Trickery");
                    subClassSelect.addItem("Twilight");
                    subClassSelect.addItem("War");
                }
                case "Sorcerer" -> {
                    subClassSelect.removeAllItems();
                    subClassSelect.addItem("Sorcerous Origin");
                    subClassSelect.addItem("Aberrant Mind");
                    subClassSelect.addItem("Clockwork Soul");
                    subClassSelect.addItem("Divine Soul");
                    subClassSelect.addItem("Draconic Bloodline");
                    subClassSelect.addItem("Shadow Magic");
                    subClassSelect.addItem("Storm Sorcery");
                    subClassSelect.addItem("Wild Magic");
                }
                case "Warlock" -> {
                    subClassSelect.removeAllItems();
                    subClassSelect.addItem("Otherworldly Patron");
                    subClassSelect.addItem("The Archfey");
                    subClassSelect.addItem("The Celestial");
                    subClassSelect.addItem("The Fathomless");
                    subClassSelect.addItem("The Fiend");
                    subClassSelect.addItem("The Genie");
                    subClassSelect.addItem("The Great Old One");
                    subClassSelect.addItem("The Hexblade");
                    subClassSelect.addItem("The Undead");
                    subClassSelect.addItem("The Undying");
                }
                default -> {
                    subClassSelect.removeAllItems();
                    subClassSelect.addItem("N/A");
                }
            }
        });
        JComboBox<String> backgroundSelect = new JComboBox<>(new String[]{"Select Background"});
        for (Background background : backgrounds.getBackgrounds()) {
            if (!background.getName().equals("Select Background")) {
                backgroundSelect.addItem(background.getName());
            }
        }
        backgroundSelect.setPreferredSize(dd);

        backgroundSelect.addActionListener(event -> {
            JComboBox<String> combo = (JComboBox<String>) event.getSource();
            try {
                String selectedBackground = (String) combo.getSelectedItem();
                descriptionArea.setText(backgrounds.getBackground(selectedBackground).getName() + ":\n" + backgrounds.getBackground(selectedBackground).getDescription() + "\n\n" + backgrounds.getBackground(selectedBackground).getFeature()[0] + ":\n" + backgrounds.getBackground(selectedBackground).getFeature()[1]);
            } catch (NullPointerException e) {
                System.out.println("No background selected.");
            }
        });

        JLabel nameLabel = new JLabel("Name: ");
        JLabel raceLabel = new JLabel("Race:");
        JLabel subRaceLabel = new JLabel("Subrace:");
        JLabel classLabel = new JLabel("Class:");
        JLabel subClassLabel = new JLabel("Subclass:");
        JLabel backgroundLabel = new JLabel("Background:");

        HintTextField nameTextField = new HintTextField("Character Name");
        nameTextField.setPreferredSize(dd);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0,2));
        inputPanel.setBackground(Color.lightGray);

        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(raceLabel);
        inputPanel.add(raceSelect);
        inputPanel.add(subRaceLabel);
        inputPanel.add(subRaceSelect);
        inputPanel.add(classLabel);
        inputPanel.add(classSelect);
        inputPanel.add(subClassLabel);
        inputPanel.add(subClassSelect);
        inputPanel.add(backgroundLabel);
        inputPanel.add(backgroundSelect);

        JPanel secondaryPanel = new JPanel();
        secondaryPanel.setLayout(new GridBagLayout());
        secondaryPanel.setBackground(Color.lightGray);
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        secondaryPanel.add(inputPanel, c);
        c.weightx = 0;
        secondaryPanel.add(Box.createHorizontalStrut(10), c);
        c.weightx = 1;
        secondaryPanel.add(descriptionArea, c);

        JButton nextButton = new JButton("Next");
        JButton backButton = new JButton("Back");

        mainPanel.add(secondaryPanel,BorderLayout.CENTER);
        mainPanel.add(backButton, BorderLayout.PAGE_START);
        mainPanel.add(nextButton, BorderLayout.PAGE_END);



        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2 - frame.getHeight() / 2);
        frame.setVisible(true);
    }
}
