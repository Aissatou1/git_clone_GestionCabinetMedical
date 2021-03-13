package Controller;

import Service.ConsoleDisplayService;
import Service.DisplayService;

public class ClientController {
    private DisplayService displayService;
    String q = "" ;
    public ClientController() {
        displayService=new ConsoleDisplayService();
    }

    public void process() {
        displayService.afficherBienvenu();
        do {
            displayService.afficherMenuPrincipal();
            String choix =displayService.choixMenu();
            displayService.afficherChoix(choix);
        }while (!q.equals("q"));

    }
}
