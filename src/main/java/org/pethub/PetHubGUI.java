package org.pethub;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PetHubGUI {
    private JFrame frame;
    private JButton addPetButton;
    private JButton addFoodButton;
    private JButton addItemButton;
    private JButton retrievePetsButton;
    private JButton retrieveFoodButton;
    private JButton retrieveItemsButton;
    private JButton editPetButton;
    private JButton editFoodButton;
    private JButton editItemButton;
    private JButton deletePetButton;
    private JButton deleteFoodButton;
    private JButton deleteItemButton;

    private static final String PET_FILE_PATH = "pets.csv";
    private static final String FOOD_FILE_PATH = "food.csv";
    private static final String ITEM_FILE_PATH = "items.csv";

    public void initialize() {
        frame = new JFrame("PetHub");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();

        addPetButton = new JButton("Add Pet");
        addFoodButton = new JButton("Add Food");
        addItemButton = new JButton("Add Item");
        retrievePetsButton = new JButton("Retrieve Pets");
        retrieveFoodButton = new JButton("Retrieve Food");
        retrieveItemsButton = new JButton("Retrieve Items");
        editPetButton = new JButton("Edit Pet");
        editFoodButton = new JButton("Edit Food");
        editItemButton = new JButton("Edit Item");
        deletePetButton = new JButton("Delete Pet");
        deleteFoodButton = new JButton("Delete Food");
        deleteItemButton = new JButton("Delete Item");

        panel.add(addPetButton);
        panel.add(addFoodButton);
        panel.add(addItemButton);
        panel.add(retrievePetsButton);
        panel.add(retrieveFoodButton);
        panel.add(retrieveItemsButton);
        panel.add(editPetButton);
        panel.add(editFoodButton);
        panel.add(editItemButton);
        panel.add(deletePetButton);
        panel.add(deleteFoodButton);
        panel.add(deleteItemButton);

        frame.add(panel);
        frame.setVisible(true);

        addPetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter pet name:");
                String species = JOptionPane.showInputDialog(frame, "Enter pet species:");
                int age = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter pet age:"));
                String favoriteFood = JOptionPane.showInputDialog(frame, "Enter pet favorite food:");

                Pet pet = new Pet(name, species, age, favoriteFood);
                CSVHandler.writePetToCSV(pet, PET_FILE_PATH);

                JOptionPane.showMessageDialog(frame, "Pet added successfully!");
            }
        });

        addFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter food name:");
                String description = JOptionPane.showInputDialog(frame, "Enter food description:");
                int nutritionalValue = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter nutritional value:"));

                Food food = new Food(name, description, nutritionalValue);
                CSVHandler.writeFoodToCSV(food, FOOD_FILE_PATH);

                JOptionPane.showMessageDialog(frame, "Food added successfully!");
            }
        });

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter item name:");
                String description = JOptionPane.showInputDialog(frame, "Enter item description:");
                double price = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter item price:"));

                Item item = new Item(name, description, price);
                CSVHandler.writeItemToCSV(item, ITEM_FILE_PATH);

                JOptionPane.showMessageDialog(frame, "Item added successfully!");
            }
        });

        retrievePetsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String petsData = CSVHandler.readDataFromCSV(PET_FILE_PATH);
                JOptionPane.showMessageDialog(frame, petsData, "Pets", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        retrieveFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String foodData = CSVHandler.readDataFromCSV(FOOD_FILE_PATH);
                JOptionPane.showMessageDialog(frame, foodData, "Food", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        retrieveItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemsData = CSVHandler.readDataFromCSV(ITEM_FILE_PATH);
                JOptionPane.showMessageDialog(frame, itemsData, "Items", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        editPetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String petName = JOptionPane.showInputDialog(frame, "Enter the name of the pet to edit:");
                String[] petData = CSVHandler.retrieveRecordFromCSV(petName, PET_FILE_PATH);
                if (petData == null) {
                    JOptionPane.showMessageDialog(frame, "Pet not found!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String name = JOptionPane.showInputDialog(frame, "Enter new pet name:", petData[0]);
                    String species = JOptionPane.showInputDialog(frame, "Enter new pet species:", petData[1]);
                    int age = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter new pet age:", petData[2]));
                    String favoriteFood = JOptionPane.showInputDialog(frame, "Enter new pet favorite food:", petData[3]);

                    Pet pet = new Pet(name, species, age, favoriteFood);
                    CSVHandler.updatePetInCSV(petName, pet, PET_FILE_PATH);

                    JOptionPane.showMessageDialog(frame, "Pet updated successfully!");
                }
            }
        });

        editFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String foodName = JOptionPane.showInputDialog(frame, "Enter the name of the food to edit:");
                String[] foodData = CSVHandler.retrieveRecordFromCSV(foodName, FOOD_FILE_PATH);
                if (foodData == null) {
                    JOptionPane.showMessageDialog(frame, "Food not found!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String name = JOptionPane.showInputDialog(frame, "Enter new food name:", foodData[0]);
                    String description = JOptionPane.showInputDialog(frame, "Enter new food description:", foodData[1]);
                    int nutritionalValue = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter new nutritional value:", foodData[2]));

                    Food food = new Food(name, description, nutritionalValue);
                    CSVHandler.updateFoodInCSV(foodName, food, FOOD_FILE_PATH);

                    JOptionPane.showMessageDialog(frame, "Food updated successfully!");
                }
            }
        });

        editItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = JOptionPane.showInputDialog(frame, "Enter the name of the item to edit:");
                String[] itemData = CSVHandler.retrieveRecordFromCSV(itemName, ITEM_FILE_PATH);
                if (itemData == null) {
                    JOptionPane.showMessageDialog(frame, "Item not found!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String name = JOptionPane.showInputDialog(frame, "Enter new item name:", itemData[0]);
                    String description = JOptionPane.showInputDialog(frame, "Enter new item description:", itemData[1]);
                    double price = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter new item price:", itemData[2]));

                    Item item = new Item(name, description, price);
                    CSVHandler.updateItemInCSV(itemName, item, ITEM_FILE_PATH);

                    JOptionPane.showMessageDialog(frame, "Item updated successfully!");
                }
            }
        });

        deletePetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String petName = JOptionPane.showInputDialog(frame, "Enter the name of the pet to delete:");
                boolean deleted = CSVHandler.deleteRecordFromCSV(petName, PET_FILE_PATH);
                if (deleted) {
                    JOptionPane.showMessageDialog(frame, "Pet deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Pet not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String foodName = JOptionPane.showInputDialog(frame, "Enter the name of the food to delete:");
                boolean deleted = CSVHandler.deleteRecordFromCSV(foodName, FOOD_FILE_PATH);
                if (deleted) {
                    JOptionPane.showMessageDialog(frame, "Food deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Food not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = JOptionPane.showInputDialog(frame, "Enter the name of the item to delete:");
                boolean deleted = CSVHandler.deleteRecordFromCSV(itemName, ITEM_FILE_PATH);
                if (deleted) {
                    JOptionPane.showMessageDialog(frame, "Item deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Item not found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
