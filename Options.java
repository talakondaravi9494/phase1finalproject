package phase1finalprojectVirtualkey;

import java.util.List;
import java.util.Scanner;
public class Options {
public static void welcomeInput() {
boolean running = true;
Scanner sc = new Scanner(System.in);
do {
try {
Menu.menu();
int option = sc.nextInt();
switch (option) {
case 1:
FileOperations.fileDisplay("VirtualKey");
break;
case 2:
Options.handleFileMenuOptions();
break;
case 3:
System.out.println("Program Exited Successfully.");
running = false;
sc.close();
System.exit(0);
break;
default:
System.out.println("Please select a valid option from above displayed options.");
}
} catch (Exception e) {
System.out.println(e.getClass().getName());
welcomeInput();
} 
} while (running == true);
}
public static void handleFileMenuOptions() {
boolean running = true;
Scanner sc = new Scanner(System.in);
do {
try {
Menu.menuOptions();
FileOperations.createFolderIfFolderNotAvailable("VirtualKey");
int option = sc.nextInt();
switch (option) {
case 1:
// File Add
System.out.println("Enter the name of the file to be added to the \"VirtualKey\" folder");
String fileToAdd = sc.next();
FileOperations.createNewFile(fileToAdd, sc);
break;
case 2:
// File/Folder delete
System.out.println("Enter the name of the file to be deleted from \"VirtualKey\" folder");
String fileToDelete = sc.next();
FileOperations.createFolderIfFolderNotAvailable("proj");
List<String> filesToDelete =
FileOperations.fileLocations(fileToDelete, "proj");
String deletionPrompt = "Select index of which file to delete?"+ "\n(Enter 0 if you want to delete all elements)";
System.out.println(deletionPrompt);
int index = sc.nextInt();
if (index != 0) {
FileOperations.fileDelete(filesToDelete.get(index -
1));
} 
else {
for (String path : filesToDelete) {
FileOperations.fileDelete(path);
}
}
break;
case 3:
// File/Folder Search
System.out.println("Enter the name of the file to search from \"VirtualKey\" folder");
String fileName = sc.next();
FileOperations.createFolderIfFolderNotAvailable("VirtualKey");
FileOperations.fileLocations(fileName, "VirtualKey");
break;
case 4:
// Go to Previous menu
return;
case 5:
// Exit
System.out.println("Program exited successfully.");
running = false;
sc.close();
System.exit(0);
default:
System.out.println("Please select a valid option from the above displayed options..");
}
} catch (Exception e) {
System.out.println(e.getClass().getName());
handleFileMenuOptions();
}
} while (running == true);
}
}

