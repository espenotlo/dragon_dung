import character.Character;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CharacterSheet {
    private character.Character character = new character.Character();
    private final JLabel nameLabel = new JLabel(character.getName());
    private final JLabel classLabel = new JLabel(character.getBaseClass().getName());
    private final JLabel raceLabel = new JLabel(character.getSubrace().getSubraceName());
    private final JLabel backgroundLabel = new JLabel(character.getBackground().getName());
    private final JLabel strengthScoreLabel = new JLabel();
    private final JButton strengthModButton = new JButton();
    private final JLabel dexterityScoreLabel = new JLabel();
    private final JButton dexterityModButton = new JButton();
    private final JLabel constitutionScoreLabel = new JLabel();
    private final JButton constitutionModButton = new JButton();
    private final JLabel intelligenceScoreLabel = new JLabel();
    private final JButton intelligenceModButton = new JButton();
    private final JLabel wisdomScoreLabel = new JLabel();
    private final JButton wisdomModButton = new JButton();
    private final JLabel charismaScoreLabel = new JLabel();
    private final JButton charismaModButton = new JButton();
    private final JButton strengthSaveButton = new JButton();
    private final JButton dexteritySaveButton = new JButton();
    private final JButton constitutionSaveButton = new JButton();
    private final JButton intelligenceSaveButton = new JButton();
    private final JButton wisdomSaveButton = new JButton();
    private final JButton charismaSaveButton = new JButton();
    private final JButton acrobaticsButton = new JButton();
    private final JButton animalHandlingButton = new JButton();
    private final JButton arcanaButton = new JButton();
    private final JButton athleticsButton = new JButton();
    private final JButton deceptionButton = new JButton();
    private final JButton historyButton = new JButton();
    private final JButton insightButton = new JButton();
    private final JButton intimidationButton = new JButton();
    private final JButton investigationButton = new JButton();
    private final JButton medicineButton = new JButton();
    private final JButton natureButton = new JButton();
    private final JButton perceptionButton = new JButton();
    private final JButton performanceButton = new JButton();
    private final JButton persuasionButton = new JButton();
    private final JButton religionButton = new JButton();
    private final JButton sleightOfHandButton = new JButton();
    private final JButton stealthButton = new JButton();
    private final JButton survivalButton = new JButton();
    private final JLabel hitPointsLabel = new JLabel();
    private final JLabel temporaryHitPointsLabel = new JLabel();
    private final JLabel hitDiceLabel = new JLabel();
    private final JCheckBox firstSuccess = new JCheckBox();
    private final JCheckBox secondSuccess = new JCheckBox();
    private final JCheckBox thirdSuccess = new JCheckBox();
    private final JCheckBox firstFailure = new JCheckBox();
    private final JCheckBox secondFailure = new JCheckBox();
    private final JCheckBox thirdFailure = new JCheckBox();
    private final JLabel armorClassLabel = new JLabel();
    private final JLabel initiativeLabel = new JLabel();

    public CharacterSheet() {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenuItem newCharacter = new JMenuItem("New Character");
        newCharacter.addActionListener(e -> new CharacterCreator(this));

        JMenuItem selectCharacter = new JMenuItem("Select Character..");

        JMenuItem deleteCharacter = new JMenuItem("Delete Character..");

        menuBar.add(newCharacter);
        menuBar.add(selectCharacter);
        menuBar.add(deleteCharacter);

        JPanel mainPanel = (JPanel) frame.getContentPane();
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.lightGray);

        GridBagConstraints c = new GridBagConstraints();

        //character information:
        JPanel characterInfoPanel = new JPanel();
        characterInfoPanel.setBackground(Color.WHITE);
        characterInfoPanel.setLayout(new GridBagLayout());

        nameLabel.setFont(new Font("nameFont", Font.PLAIN, 20));
        nameLabel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Name:</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));

        classLabel.setFont(new Font("nameFont", Font.PLAIN, 20));
        classLabel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Class:</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));

        raceLabel.setFont(new Font("nameFont", Font.PLAIN, 20));
        raceLabel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Race:</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));

        backgroundLabel.setFont(new Font("nameFont", Font.PLAIN, 20));
        backgroundLabel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Background:</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));


        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 0;
        characterInfoPanel.add(nameLabel, c);
        characterInfoPanel.add(classLabel, c);
        characterInfoPanel.add(raceLabel, c);
        characterInfoPanel.add(backgroundLabel, c);

        //Attributes:
        JPanel attributesPanel = new JPanel();
        attributesPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Attributes</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));
        attributesPanel.setLayout(new GridLayout(0,1));

        JPanel strengthPanel = new JPanel();
        strengthPanel.setLayout(new GridBagLayout());
        strengthPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel strengthLabel = new JLabel("Strength");
        strengthScoreLabel.setFont(new Font("font", Font.BOLD, 20));

        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        strengthPanel.add(strengthLabel, c);
        strengthPanel.add(strengthScoreLabel, c);
        strengthPanel.add(strengthModButton, c);

        JPanel dexterityPanel = new JPanel();
        dexterityPanel.setLayout(new GridBagLayout());
        dexterityPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel dexterityLabel = new JLabel("Dexterity");
        dexterityScoreLabel.setFont(new Font("font", Font.BOLD, 20));

        dexterityPanel.add(dexterityLabel, c);
        dexterityPanel.add(dexterityScoreLabel, c);
        dexterityPanel.add(dexterityModButton, c);

        JPanel constitutionPanel = new JPanel();
        constitutionPanel.setLayout(new GridBagLayout());
        constitutionPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel constitutionLabel = new JLabel("Constitution");
        constitutionScoreLabel.setFont(new Font("font", Font.BOLD, 20));

        constitutionPanel.add(constitutionLabel, c);
        constitutionPanel.add(constitutionScoreLabel, c);
        constitutionPanel.add(constitutionModButton, c);

        JPanel intelligencePanel = new JPanel();
        intelligencePanel.setLayout(new GridBagLayout());
        intelligencePanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel intelligenceLabel = new JLabel("Intelligence");
        intelligenceScoreLabel.setFont(new Font("font", Font.BOLD, 20));

        intelligencePanel.add(intelligenceLabel, c);
        intelligencePanel.add(intelligenceScoreLabel, c);
        intelligencePanel.add(intelligenceModButton, c);

        JPanel wisdomPanel = new JPanel();
        wisdomPanel.setLayout(new GridBagLayout());
        wisdomPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel wisdomLabel = new JLabel("Wisdom");
        wisdomScoreLabel.setFont(new Font("font", Font.BOLD, 20));

        wisdomPanel.add(wisdomLabel, c);
        wisdomPanel.add(wisdomScoreLabel, c);
        wisdomPanel.add(wisdomModButton, c);

        JPanel charismaPanel = new JPanel();
        charismaPanel.setLayout(new GridBagLayout());
        charismaPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel charismaLabel = new JLabel("Charisma");
        charismaScoreLabel.setFont(new Font("font", Font.BOLD, 20));

        charismaPanel.add(charismaLabel, c);
        charismaPanel.add(charismaScoreLabel, c);
        charismaPanel.add(charismaModButton, c);

        attributesPanel.add(strengthPanel);
        attributesPanel.add(dexterityPanel);
        attributesPanel.add(constitutionPanel);
        attributesPanel.add(intelligencePanel);
        attributesPanel.add(wisdomPanel);
        attributesPanel.add(charismaPanel);

        //saving throws:
        JPanel savingThrowPanel = new JPanel();
        savingThrowPanel.setLayout(new GridBagLayout());
        savingThrowPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Saving Throws:</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));

        JLabel strengthSaveLabel = new JLabel("Strength");
        JLabel dexteritySaveLabel = new JLabel("Dexterity");
        JLabel constitutionSaveLabel = new JLabel("Constitution");
        JLabel intelligenceSaveLabel = new JLabel("Intelligence");
        JLabel wisdomSaveLabel = new JLabel("Wisdom");
        JLabel charismaSaveLabel = new JLabel("Charisma");

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        savingThrowPanel.add(strengthSaveLabel, c);
        savingThrowPanel.add(dexteritySaveLabel, c);
        savingThrowPanel.add(constitutionSaveLabel, c);
        savingThrowPanel.add(intelligenceSaveLabel, c);
        savingThrowPanel.add(wisdomSaveLabel, c);
        savingThrowPanel.add(charismaSaveLabel, c);
        c.gridx = 1;
        savingThrowPanel.add(strengthSaveButton, c);
        savingThrowPanel.add(dexteritySaveButton, c);
        savingThrowPanel.add(constitutionSaveButton, c);
        savingThrowPanel.add(intelligenceSaveButton, c);
        savingThrowPanel.add(wisdomSaveButton, c);
        savingThrowPanel.add(charismaSaveButton, c);

        JPanel skillsPanel = new JPanel();
        skillsPanel.setLayout(new GridBagLayout());
        skillsPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED),"<html><u>Skills:</u></html>", TitledBorder.CENTER,TitledBorder.BELOW_TOP));

        JLabel acrobaticsLabel = new JLabel("Acrobatics");
        acrobaticsButton.addActionListener(e -> this.character.skillCheck("Acrobatics"));
        JLabel animalHandlingLabel = new JLabel("Animal Handling");
        animalHandlingButton.addActionListener(e -> this.character.skillCheck("Animal Handling"));
        JLabel arcanaLabel = new JLabel("Arcana");
        arcanaButton.addActionListener(e -> this.character.skillCheck("Arcana"));
        JLabel athleticsLabel = new JLabel("Athletics");
        athleticsButton.addActionListener(e -> this.character.skillCheck("Athletics"));
        JLabel deceptionLabel = new JLabel("Deception");
        deceptionButton.addActionListener(e -> this.character.skillCheck("Deception"));
        JLabel historyLabel = new JLabel("History");
        historyButton.addActionListener(e -> this.character.skillCheck("History"));
        JLabel insightLabel = new JLabel("Insight");
        insightButton.addActionListener(e -> this.character.skillCheck("Insight"));
        JLabel intimidationLabel = new JLabel("Intimidation");
        intimidationButton.addActionListener(e -> this.character.skillCheck("Intimidation"));
        JLabel investigationLabel = new JLabel("Investigation");
        acrobaticsButton.addActionListener(e -> this.character.skillCheck("Investigation"));
        JLabel medicineLabel = new JLabel("Medicine");
        medicineButton.addActionListener(e -> this.character.skillCheck("Medicine"));
        JLabel natureLabel = new JLabel("Nature");
        natureButton.addActionListener(e -> this.character.skillCheck("Nature"));
        JLabel perceptionLabel = new JLabel("Perception");
        perceptionButton.addActionListener(e -> this.character.skillCheck("Perception"));
        JLabel performanceLabel = new JLabel("Performance");
        performanceButton.addActionListener(e -> this.character.skillCheck("Performance"));
        JLabel persuasionLabel = new JLabel("Persuasion");
        persuasionButton.addActionListener(e -> this.character.skillCheck("Persuasion"));
        JLabel religionLabel = new JLabel("Religion");
        religionButton.addActionListener(e -> this.character.skillCheck("Religion"));
        JLabel sleightOfHandLabel = new JLabel("Sleight of hand");
        sleightOfHandButton.addActionListener(e -> this.character.skillCheck("Sleight of hand"));
        JLabel stealthLabel = new JLabel("Stealth");
        stealthButton.addActionListener(e -> this.character.skillCheck("Stealth"));
        JLabel survivalLabel = new JLabel("Survival");
        survivalButton.addActionListener(e -> this.character.skillCheck("Survival"));

        c.gridx = 0;
        skillsPanel.add(acrobaticsLabel, c);
        skillsPanel.add(animalHandlingLabel, c);
        skillsPanel.add(arcanaLabel, c);
        skillsPanel.add(athleticsLabel, c);
        skillsPanel.add(deceptionLabel, c);
        skillsPanel.add(historyLabel, c);
        skillsPanel.add(insightLabel, c);
        skillsPanel.add(intimidationLabel, c);
        skillsPanel.add(investigationLabel, c);
        skillsPanel.add(medicineLabel, c);
        skillsPanel.add(natureLabel, c);
        skillsPanel.add(perceptionLabel, c);
        skillsPanel.add(performanceLabel, c);
        skillsPanel.add(persuasionLabel, c);
        skillsPanel.add(religionLabel, c);
        skillsPanel.add(sleightOfHandLabel, c);
        skillsPanel.add(stealthLabel, c);
        skillsPanel.add(survivalLabel, c);
        c.gridx = 1;
        skillsPanel.add(acrobaticsButton, c);
        skillsPanel.add(animalHandlingButton, c);
        skillsPanel.add(arcanaButton, c);
        skillsPanel.add(athleticsButton, c);
        skillsPanel.add(deceptionButton, c);
        skillsPanel.add(historyButton, c);
        skillsPanel.add(insightButton, c);
        skillsPanel.add(intimidationButton, c);
        skillsPanel.add(investigationButton, c);
        skillsPanel.add(medicineButton, c);
        skillsPanel.add(natureButton, c);
        skillsPanel.add(perceptionButton, c);
        skillsPanel.add(performanceButton, c);
        skillsPanel.add(persuasionButton, c);
        skillsPanel.add(religionButton, c);
        skillsPanel.add(sleightOfHandButton, c);
        skillsPanel.add(stealthButton, c);
        skillsPanel.add(survivalButton, c);

        //Health Panel
        JPanel healthPanel = new JPanel();
        healthPanel.setLayout(new GridBagLayout());

        JPanel hitPointsPanel = new JPanel();
        hitPointsPanel.setLayout(new GridLayout(0,2));
        hitPointsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel hitPointsNameLabel = new JLabel("<html><u>Hit points:</u></html>");
        hitPointsLabel.setFont(new Font("f",hitPointsLabel.getFont().getStyle(), 16));

        JPanel temporaryHitPointsPanel = new JPanel();
        temporaryHitPointsPanel.setLayout(new GridBagLayout());
        temporaryHitPointsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel temporaryHitPointsNameLabel = new JLabel("<html><u>Temp HP:</u></html>");
        temporaryHitPointsLabel.setFont(new Font("f",hitPointsLabel.getFont().getStyle(), 16));
        JButton addTempHpButton = new JButton(" Add temp ");

        JButton healButton = new JButton("Heal");
        healButton.addActionListener(e -> {
                int healing = 0;
                while (healing <= 0) {
                    healing = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of healing:"));
                }
                this.character.heal(healing);
                updateSheet();
        });

        JButton damageButton = new JButton("Damage");
        damageButton.addActionListener(e -> {
                int damage = 0;
                while (damage <= 0) {
                    damage = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of damage:"));
                }
                this.character.damage(damage);
                updateSheet();
        });

        hitPointsPanel.add(hitPointsNameLabel);
        hitPointsPanel.add(healButton);
        hitPointsPanel.add(hitPointsLabel);
        hitPointsPanel.add(damageButton);

        c.gridx = 0;
        c.weightx = 1;
        temporaryHitPointsPanel.add(temporaryHitPointsNameLabel, c);
        temporaryHitPointsPanel.add(temporaryHitPointsLabel, c);
        c.gridx = 1;
        c.weightx = 0;
        c.gridheight = 2;
        temporaryHitPointsPanel.add(addTempHpButton, c);

        JPanel hitDicePanel = new JPanel();
        hitDicePanel.setLayout(new GridBagLayout());
        hitDicePanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel hitDiceNameLabel = new JLabel("<html><u>Hit Dice: </u></html>");
       hitDiceLabel.setFont(new Font("f",hitDiceLabel.getFont().getStyle(), 16));
        JButton spendHitDieButton = new JButton("Use hit die");
        spendHitDieButton.addActionListener(e -> {
            if (this.character.getCurrentHitDice() > 0) {
                this.character.spendHitDie();
                updateSheet();
            }
        });

        c.gridx = 0;
        c.weightx = 1;
        c.gridheight = 1;
        hitDicePanel.add(hitDiceNameLabel, c);
        hitDicePanel.add(hitDiceLabel, c);
        c.gridx = 1;
        c.gridheight = 2;
        c.weightx = 0;
        hitDicePanel.add(spendHitDieButton, c);

        c.gridheight = 1;
        c.weightx = 1;
        healthPanel.add(hitPointsPanel, c);
        healthPanel.add(temporaryHitPointsPanel, c);
        healthPanel.add(hitDicePanel, c);

        JPanel deathSavePanel = new JPanel();
        deathSavePanel.setLayout(new GridBagLayout());
        deathSavePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Death Saves:</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));

        JLabel successLabel = new JLabel("Successes: ");
        JLabel failureLabel = new JLabel("Failures: ");

        firstSuccess.setEnabled(false);
        secondSuccess.setEnabled(false);
        thirdSuccess.setEnabled(false);
        firstFailure.setEnabled(false);
        secondFailure.setEnabled(false);
        thirdFailure.setEnabled(false);

        JButton rollDeathSaveButton = new JButton("Roll save");
        rollDeathSaveButton.addActionListener(e -> {
            this.character.deathSave();
            updateSheet();
        });

        JButton resetDeathSavesButton = new JButton("Reset");
        resetDeathSavesButton.addActionListener(e -> {
            this.character.resetDeathSaves();
            updateSheet();
        });


        c.gridy = 0;
        c.gridheight = 1;
        c.gridx = GridBagConstraints.RELATIVE;
        deathSavePanel.add(successLabel, c);
        deathSavePanel.add(firstSuccess, c);
        deathSavePanel.add(secondSuccess, c);
        deathSavePanel.add(thirdSuccess, c);
        c.gridy = 1;
        deathSavePanel.add(failureLabel, c);
        deathSavePanel.add(firstFailure, c);
        deathSavePanel.add(secondFailure, c);
        deathSavePanel.add(thirdFailure, c);
        c.gridy = 2;
        c.gridwidth = GridBagConstraints.RELATIVE;
        deathSavePanel.add(rollDeathSaveButton, c);
        deathSavePanel.add(resetDeathSavesButton, c);
        c.gridwidth = 1;

        JPanel miscPanel = new JPanel();
        miscPanel.setLayout(new GridBagLayout());
        miscPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JPanel armorClassPanel = new JPanel();
        armorClassPanel.setLayout(new GridBagLayout());
        armorClassPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel armorClassNameLabel = new JLabel("<html><u>AC:</u><html>");
        armorClassLabel.setFont(new Font("f",armorClassLabel.getFont().getStyle(), 16));

        JPanel initiativePanel = new JPanel();
        initiativePanel.setLayout(new GridBagLayout());
        initiativePanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel initiativeNameLabel = new JLabel("<html><u>Init:</u><html>");
        initiativeLabel.setFont(new Font("f",initiativeLabel.getFont().getStyle(), 16));

        JPanel inspirationPanel = new JPanel();
        inspirationPanel.setLayout(new GridBagLayout());
        inspirationPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel inspirationNameLabel = new JLabel("<html><u>Insp:</u><html>");
        JCheckBox inspirationCheckBox = new JCheckBox();

        JPanel combatPanel = new JPanel();
        combatPanel.setLayout(new GridBagLayout());

        JPanel actionPanel = new JPanel();
        actionPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Actions:</u><html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));
        actionPanel.setLayout(new GridBagLayout());

        JLabel mainWeaponLabel = new JLabel("Main Weapon");
        JButton mainWeaponAttackButton = new JButton("Attack");

        JLabel hideLabel = new JLabel("Hide");
        JButton hideButton = new JButton("Attempt to hide");

        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 0;
        actionPanel.add(mainWeaponLabel, c);
        actionPanel.add(mainWeaponAttackButton, c);
        c.gridy = 1;
        actionPanel.add(hideLabel, c);
        actionPanel.add(hideButton, c);

        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        armorClassPanel.add(armorClassNameLabel, c);
        armorClassPanel.add(armorClassLabel, c);
        initiativePanel.add(initiativeNameLabel, c);
        initiativePanel.add(initiativeLabel, c);
        inspirationPanel.add(inspirationNameLabel, c);
        inspirationPanel.add(inspirationCheckBox, c);

        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        miscPanel.add(armorClassPanel, c);
        miscPanel.add(initiativePanel, c);
        miscPanel.add(inspirationPanel, c);

        JButton longRestButton = new JButton("Long Rest");
        longRestButton.addActionListener(e -> {
            this.character.longRest();
            updateSheet();
        });

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        c.gridwidth = GridBagConstraints.REMAINDER;
        mainPanel.add(characterInfoPanel, c);
        c.weightx = 1;
        c.gridwidth = 1;
        c.gridheight = 5;
        c.fill = GridBagConstraints.BOTH;
        mainPanel.add(attributesPanel, c);
        c.gridx = 1;
        c.gridheight = GridBagConstraints.RELATIVE;
        mainPanel.add(skillsPanel, c);
        c.gridx = 2;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 1.5;
        mainPanel.add(savingThrowPanel, c);
        mainPanel.add(healthPanel, c);
        mainPanel.add(deathSavePanel, c);
        c.gridwidth = 1;
        mainPanel.add(armorClassPanel, c);
        c.gridx = 3;
        mainPanel.add(initiativePanel, c);
        c.gridx = 4;
        mainPanel.add(inspirationPanel, c);
        c.gridx = 5;
        c.weightx = 1;
        mainPanel.add(actionPanel, c);
        mainPanel.add(longRestButton, c);

        updateSheet();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.pack();
        frame.setResizable(false);
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }
    private void updateSheet() {
        nameLabel.setText(character.getName());

        if (null != character.getBaseClass().getSubClass()) {
            classLabel.setText(character.getBaseClass().getSubClass());
        } else {
            classLabel.setText(character.getBaseClass().getName());
        }

        raceLabel.setText(character.getSubrace().getSubraceName());
        backgroundLabel.setText(character.getBackground().getName());
        strengthScoreLabel.setText("" + character.getAttributes().getValue("Strength"));
        dexterityScoreLabel.setText("" + character.getAttributes().getValue("Dexterity"));
        constitutionScoreLabel.setText("" + character.getAttributes().getValue("Constitution"));
        intelligenceScoreLabel.setText("" + character.getAttributes().getValue("Intelligence"));
        wisdomScoreLabel.setText("" + character.getAttributes().getValue("Wisdom"));
        charismaScoreLabel.setText("" + character.getAttributes().getValue("Charisma"));
        strengthModButton.setText(character.getAttributes().getAttribute("Strength").getModAsString());
        dexterityModButton.setText(character.getAttributes().getAttribute("Dexterity").getModAsString());
        constitutionModButton.setText(character.getAttributes().getAttribute("Constitution").getModAsString());
        intelligenceModButton.setText(character.getAttributes().getAttribute("Intelligence").getModAsString());
        wisdomModButton.setText(character.getAttributes().getAttribute("Wisdom").getModAsString());
        charismaModButton.setText(character.getAttributes().getAttribute("Charisma").getModAsString());
        strengthSaveButton.setText(character.getSavingThrowAsString("Strength"));
        dexteritySaveButton.setText(character.getSavingThrowAsString("Dexterity"));
        constitutionSaveButton.setText(character.getSavingThrowAsString("Constitution"));
        intelligenceSaveButton.setText(character.getSavingThrowAsString("Intelligence"));
        wisdomSaveButton.setText(character.getSavingThrowAsString("Wisdom"));
        charismaSaveButton.setText(character.getSavingThrowAsString("Charisma"));
        acrobaticsButton.setText(character.getSkillModAsString("Acrobatics"));
        animalHandlingButton.setText(character.getSkillModAsString("Animal Handling"));
        arcanaButton.setText(character.getSkillModAsString("Arcana"));
        athleticsButton.setText(character.getSkillModAsString("Athletics"));
        deceptionButton.setText(character.getSkillModAsString("Deception"));
        historyButton.setText(character.getSkillModAsString("History"));
        insightButton.setText(character.getSkillModAsString("Insight"));
        intimidationButton.setText(character.getSkillModAsString("Intimidation"));
        investigationButton.setText(character.getSkillModAsString("Investigation"));
        medicineButton.setText(character.getSkillModAsString("Medicine"));
        natureButton.setText(character.getSkillModAsString("Nature"));
        perceptionButton.setText(character.getSkillModAsString("Perception"));
        performanceButton.setText(character.getSkillModAsString("Performance"));
        persuasionButton.setText(character.getSkillModAsString("Persuasion"));
        religionButton.setText(character.getSkillModAsString("Religion"));
        sleightOfHandButton.setText(character.getSkillModAsString("Sleight of Hand"));
        stealthButton.setText(character.getSkillModAsString("Stealth"));
        survivalButton.setText(character.getSkillModAsString("Survival"));
        hitPointsLabel.setText("" + character.getCurrentHp() + "/" + character.getMaxHp());
        temporaryHitPointsLabel.setText("" + character.getTempHp());
        hitDiceLabel.setText("" + character.getCurrentHitDice() + "d" + character.getBaseClass().getHpDice());
        firstSuccess.setSelected(character.getDeathSaveSuccesses() >= 1);
        secondSuccess.setSelected(character.getDeathSaveSuccesses() >= 2);
        thirdSuccess.setSelected(character.getDeathSaveSuccesses() >= 3);
        firstFailure.setSelected(character.getDeathSaveFailures() >= 1);
        secondFailure.setSelected(character.getDeathSaveFailures() >= 2);
        thirdFailure.setSelected(character.getDeathSaveFailures() >= 3);
        armorClassLabel.setText("" + character.getAc());
        initiativeLabel.setText("" + character.getAttributes().getMod("Dexterity"));
    }

    public void sendCharacterToSheet(Character newCharacter) {
        this.character = newCharacter;
        updateSheet();
    }
}
