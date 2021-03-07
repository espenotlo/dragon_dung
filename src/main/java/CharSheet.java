import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CharSheet {
    public static void main(String[] args) {
        character.Character character = new character.Character();

        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenuItem newCharacter = new JMenuItem("New Character");
        newCharacter.addActionListener(e -> new CharacterCreator());


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

        JLabel nameLabel = new JLabel("Here goes the character's name");
        nameLabel.setFont(new Font("nameFont", Font.PLAIN, 20));
        nameLabel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Name:</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));

        JLabel classLabel = new JLabel("Beastmaster");
        classLabel.setFont(new Font("nameFont", Font.PLAIN, 20));
        classLabel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Class:</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));

        JLabel raceLabel = new JLabel("Human");
        raceLabel.setFont(new Font("nameFont", Font.PLAIN, 20));
        raceLabel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Race:</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));

        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 0;
        characterInfoPanel.add(nameLabel, c);
        characterInfoPanel.add(classLabel, c);
        characterInfoPanel.add(raceLabel, c);

        //Attributes:
        JPanel attributesPanel = new JPanel();
        attributesPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Attributes</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));
        attributesPanel.setLayout(new GridLayout(0,1));

        JPanel strengthPanel = new JPanel();
        strengthPanel.setLayout(new GridBagLayout());
        strengthPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel strengthLabel = new JLabel("Strength");
        JLabel strengthScoreLabel = new JLabel("18");
        strengthScoreLabel.setFont(new Font("font", Font.BOLD, 20));
        JButton strengthModButton = new JButton("  +4  ");

        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        strengthPanel.add(strengthLabel, c);
        strengthPanel.add(strengthScoreLabel, c);
        strengthPanel.add(strengthModButton, c);

        JPanel dexterityPanel = new JPanel();
        dexterityPanel.setLayout(new GridBagLayout());
        dexterityPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel dexterityLabel = new JLabel("Dexterity");
        JLabel dexterityScoreLabel = new JLabel("18");
        dexterityScoreLabel.setFont(new Font("font", Font.BOLD, 20));
        JButton dexterityModButton = new JButton("  +4  ");

        dexterityPanel.add(dexterityLabel, c);
        dexterityPanel.add(dexterityScoreLabel, c);
        dexterityPanel.add(dexterityModButton, c);

        JPanel constitutionPanel = new JPanel();
        constitutionPanel.setLayout(new GridBagLayout());
        constitutionPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel constitutionLabel = new JLabel("Constitution");
        JLabel constitutionScoreLabel = new JLabel("18");
        constitutionScoreLabel.setFont(new Font("font", Font.BOLD, 20));
        JButton constitutionModButton = new JButton("  +4  ");

        constitutionPanel.add(constitutionLabel, c);
        constitutionPanel.add(constitutionScoreLabel, c);
        constitutionPanel.add(constitutionModButton, c);

        JPanel intelligencePanel = new JPanel();
        intelligencePanel.setLayout(new GridBagLayout());
        intelligencePanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel intelligenceLabel = new JLabel("Intelligence");
        JLabel intelligenceScoreLabel = new JLabel("18");
        intelligenceScoreLabel.setFont(new Font("font", Font.BOLD, 20));
        JButton intelligenceModButton = new JButton("  +4  ");

        intelligencePanel.add(intelligenceLabel, c);
        intelligencePanel.add(intelligenceScoreLabel, c);
        intelligencePanel.add(intelligenceModButton, c);

        JPanel wisdomPanel = new JPanel();
        wisdomPanel.setLayout(new GridBagLayout());
        wisdomPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel wisdomLabel = new JLabel("Wisdom");
        JLabel wisdomScoreLabel = new JLabel("18");
        wisdomScoreLabel.setFont(new Font("font", Font.BOLD, 20));
        JButton wisdomModButton = new JButton("  +4  ");

        wisdomPanel.add(wisdomLabel, c);
        wisdomPanel.add(wisdomScoreLabel, c);
        wisdomPanel.add(wisdomModButton, c);

        JPanel charismaPanel = new JPanel();
        charismaPanel.setLayout(new GridBagLayout());
        charismaPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel charismaLabel = new JLabel("Charisma");
        JLabel charismaScoreLabel = new JLabel("18");
        charismaScoreLabel.setFont(new Font("font", Font.BOLD, 20));
        JButton charismaModButton = new JButton("  +4  ");

        charismaPanel.add(charismaLabel, c);
        charismaPanel.add(charismaScoreLabel, c);
        charismaPanel.add(charismaModButton, c);

        attributesPanel.add(strengthPanel);
        attributesPanel.add(dexterityPanel);
        attributesPanel.add(intelligencePanel);
        attributesPanel.add(constitutionPanel);
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

        JButton strengthSaveButton = new JButton("+4");
        JButton dexteritySaveButton = new JButton("+4");
        JButton constitutionSaveButton = new JButton("+4");
        JButton intelligenceSaveButton = new JButton("+4");
        JButton wisdomSaveButton = new JButton("+4");
        JButton charismaSaveButton = new JButton("+4");

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
        JLabel animalHandlingLabel = new JLabel("Animal Handling");
        JLabel arcanaLabel = new JLabel("Arcana");
        JLabel athleticsLabel = new JLabel("Athletics");
        JLabel deceptionLabel = new JLabel("Deception");
        JLabel historyLabel = new JLabel("History");
        JLabel insightLabel = new JLabel("Insight");
        JLabel intimidationLabel = new JLabel("Intimidation");
        JLabel investigationLabel = new JLabel("Investigation");
        JLabel medicineLabel = new JLabel("Medicine");
        JLabel natureLabel = new JLabel("Nature");
        JLabel perceptionLabel = new JLabel("Perception");
        JLabel performanceLabel = new JLabel("Performance");
        JLabel persuasionLabel = new JLabel("Persuasion");
        JLabel religionLabel = new JLabel("Religion");
        JLabel sleightOfHandLabel = new JLabel("Sleight of hand");
        JLabel stealthLabel = new JLabel("Stealth");
        JLabel survivalLabel = new JLabel("Survival");

        JButton acrobaticsButton = new JButton("+4");
        JButton animalHandlingButton = new JButton("+4");
        JButton arcanaButton = new JButton("+4");
        JButton athleticsButton = new JButton("+4");
        JButton deceptionButton = new JButton("+4");
        JButton historyButton = new JButton("+4");
        JButton insightButton = new JButton("+4");
        JButton intimidationButton = new JButton("+4");
        JButton investigationButton = new JButton("+4");
        JButton medicineButton = new JButton("+4");
        JButton natureButton = new JButton("+4");
        JButton perceptionButton = new JButton("+4");
        JButton performanceButton = new JButton("+4");
        JButton persuasionButton = new JButton("+4");
        JButton religionButton = new JButton("+4");
        JButton sleightOfHandButton = new JButton("+4");
        JButton stealthButton = new JButton("+4");
        JButton survivalButton = new JButton("+4");

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
        hitPointsPanel.setLayout(new GridBagLayout());
        hitPointsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel hitPointsNameLabel = new JLabel("<html><u>Hit points:</u></html>");
        JLabel hitPointsLabel = new JLabel("<html><big>10/10</big></html>");

        JPanel temporaryHitPointsPanel = new JPanel();
        temporaryHitPointsPanel.setLayout(new GridBagLayout());
        temporaryHitPointsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel temporaryHitPointsNameLabel = new JLabel("<html><u>Temp HP:</u></html>");
        JLabel temporaryHitPointsLabel = new JLabel("<html><big>0</big></html>");

        c.gridx = 0;
        hitPointsPanel.add(hitPointsNameLabel, c);
        hitPointsPanel.add(hitPointsLabel, c);

        temporaryHitPointsPanel.add(temporaryHitPointsNameLabel, c);
        temporaryHitPointsPanel.add(temporaryHitPointsLabel, c);

        JPanel hitDicePanel = new JPanel();
        hitDicePanel.setLayout(new GridBagLayout());
        hitDicePanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JLabel hitDiceNameLabel = new JLabel("<html><u>Hit Dice: </u></html>");
        JLabel hitDiceLabel = new JLabel("3d8");
        JButton spendHitDieButton = new JButton("Use hit die");

        c.gridx = 0;
        c.weightx = 1;
        hitDicePanel.add(hitDiceNameLabel, c);
        hitDicePanel.add(hitDiceLabel, c);
        c.gridx = 1;
        c.gridheight = 2;
        hitDicePanel.add(spendHitDieButton, c);

        c.gridheight = 1;
        c.weightx = 0;
        c.gridx = GridBagConstraints.RELATIVE;
        c.gridy = 0;
        healthPanel.add(hitPointsPanel, c);
        healthPanel.add(temporaryHitPointsPanel, c);
        c.gridy = 1;
        c.gridwidth = 2;
        healthPanel.add(hitDicePanel, c);

        JPanel deathSavePanel = new JPanel();
        deathSavePanel.setLayout(new GridBagLayout());
        deathSavePanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "<html><u>Death Saves:</u></html>", TitledBorder.CENTER, TitledBorder.BELOW_TOP));

        JLabel successLabel = new JLabel("Successes: ");
        JLabel failureLabel = new JLabel("Failures: ");
        JCheckBox firstSuccess = new JCheckBox();
        JCheckBox secondSuccess = new JCheckBox();
        JCheckBox thirdSuccess = new JCheckBox();
        JCheckBox firstFailure = new JCheckBox();
        JCheckBox secondFailure = new JCheckBox();
        JCheckBox thirdFailure = new JCheckBox();
        JButton resetDeathSavesButton = new JButton("Reset saves");

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
        c.gridwidth = GridBagConstraints.REMAINDER;
        deathSavePanel.add(resetDeathSavesButton, c);
        c.gridwidth = 1;

        JPanel miscPanel = new JPanel();
        miscPanel.setLayout(new GridBagLayout());
        miscPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        JPanel armorClassPanel = new JPanel();
        armorClassPanel.setLayout(new GridBagLayout());
        armorClassPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel armorClassNameLabel = new JLabel("<html><u>AC:</u><html>");

        JLabel armorClassLabel = new JLabel("18");


        JPanel initiativePanel = new JPanel();
        initiativePanel.setLayout(new GridBagLayout());
        initiativePanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel initiativeNameLabel = new JLabel("<html><u>Init:</u><html>");
        JLabel initiativeLabel = new JLabel("4");


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

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        c.gridwidth = GridBagConstraints.REMAINDER;
        mainPanel.add(characterInfoPanel, c);
        c.fill = GridBagConstraints.NONE;
        c.weightx = 1;
        c.gridwidth = 1;
        c.gridheight = 5;
        c.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(attributesPanel, c);
        c.fill = GridBagConstraints.NONE;
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



        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
        frame.setVisible(true);
    }
}
