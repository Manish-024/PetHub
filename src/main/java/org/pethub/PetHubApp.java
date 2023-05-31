package org.pethub;

public class PetHubApp {
    public static void main(String[] args) {
        // Create and start a new thread
        Thread petHubThread = new Thread(() -> {
            PetHubGUI petHubGUI = new PetHubGUI();
            petHubGUI.initialize();
        });
        petHubThread.start();

        // Perform other tasks in the main thread
        System.out.println("Main thread continues its execution.");

        // Wait for the petHubThread to finish its execution
        try {
            petHubThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Continue with other tasks after petHubThread has finished
        System.out.println("Main thread completes.");
    }
}
