package phase1finalprojectVirtualkey;

public class VirtualKeyInstaller {
public static void main(String[] args) {
FileOperations.createFolderIfFolderNotAvailable("VirtualKey");
Menu.printWelcomeScreen(" Virtual key ", "**********");
Options.welcomeInput();
}
}