import java.util.Scanner;

class Program {

    /**
     * Print the menu options
     */
    static void printMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Get");
        System.out.println("2. Put");
        System.out.println("3. Begin Transaction");
        System.out.println("4. Commit");
        System.out.println("5. Rollback");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        System.out.println("Welcome!");

        KeyValDatabase db = new KeyValDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int option = Integer.parseInt(scanner.nextLine());

            try {
                if (option == 1) {
                    System.out.print("Enter key: ");
                    String key = scanner.nextLine();
                    System.out.println("Value: " + db.get(key));
                } else if (option == 2) {
                    System.out.print("Enter key: ");
                    String putKey = scanner.nextLine();
                    System.out.print("Enter value: ");
                    int putValue = Integer.parseInt(scanner.nextLine());
                    db.put(putKey, putValue);
                    System.out.println("Put successful");
                } else if (option == 3) {
                    db.begin_transaction();
                    System.out.println("Transaction started");
                } else if (option == 4) {
                    db.commit();
                    System.out.println("Transaction committed");
                } else if (option == 5) {
                    db.rollback();
                    System.out.println("Transaction rolled back");
                } else if (option == 6) {
                    break;
                } else {
                    System.out.println("Invalid option");
                }
            } catch (IllegalStateException e) {
                System.err.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input");
            } catch (Exception e) {
                System.err.println("An error occurred");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
