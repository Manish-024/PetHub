package org.pethub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {
    public static void writePetToCSV(Pet pet, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(pet.getName())
                    .append(",")
                    .append(pet.getSpecies())
                    .append(",")
                    .append(String.valueOf(pet.getAge()))
                    .append(",")
                    .append(pet.getFavoriteFood())
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFoodToCSV(Food food, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(food.getName())
                    .append(",")
                    .append(food.getDescription())
                    .append(",")
                    .append(String.valueOf(food.getNutritionalValue()))
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeItemToCSV(Item item, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(item.getName())
                    .append(",")
                    .append(item.getDescription())
                    .append(",")
                    .append(String.valueOf(item.getPrice()))
                    .append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readDataFromCSV(String filePath) {
        StringBuilder data = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toString();
    }

    public static String[] retrieveRecordFromCSV(String recordName, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] recordData = line.split(",");
                if (recordData[0].equals(recordName)) {
                    return recordData;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void updatePetInCSV(String petName, Pet newPet, String filePath) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] recordData = line.split(",");
                if (recordData[0].equals(petName)) {
                    recordData[0] = newPet.getName();
                    recordData[1] = newPet.getSpecies();
                    recordData[2] = String.valueOf(newPet.getAge());
                    recordData[3] = newPet.getFavoriteFood();
                }
                records.add(recordData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            for (String[] recordData : records) {
                writer.append(String.join(",", recordData)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateFoodInCSV(String foodName, Food newFood, String filePath) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] recordData = line.split(",");
                if (recordData[0].equals(foodName)) {
                    recordData[0] = newFood.getName();
                    recordData[1] = newFood.getDescription();
                    recordData[2] = String.valueOf(newFood.getNutritionalValue());
                }
                records.add(recordData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            for (String[] recordData : records) {
                writer.append(String.join(",", recordData)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateItemInCSV(String itemName, Item newItem, String filePath) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] recordData = line.split(",");
                if (recordData[0].equals(itemName)) {
                    recordData[0] = newItem.getName();
                    recordData[1] = newItem.getDescription();
                    recordData[2] = String.valueOf(newItem.getPrice());
                }
                records.add(recordData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            for (String[] recordData : records) {
                writer.append(String.join(",", recordData)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteRecordFromCSV(String recordName, String filePath) {
        List<String[]> records = new ArrayList<>();
        boolean deleted = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] recordData = line.split(",");
                if (recordData[0].equals(recordName)) {
                    deleted = true;
                    continue;
                }
                records.add(recordData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            for (String[] recordData : records) {
                writer.append(String.join(",", recordData)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return deleted;
    }
}
