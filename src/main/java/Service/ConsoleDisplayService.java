package Service;

import Domain.Dossier;
import Domain.Enfant;
import Domain.Medecin;
import Domain.RendezVous;
import Repository.DossierRepository;
import Repository.EnfantRepository;
import Repository.RendezVousRepository;
import Repository.jdbc.JdbcBaseDossierRepository;
import Repository.jdbc.JdbcBaseEnfantRepository;
import Repository.jdbc.JdbcBaseRendezVousRepository;

import java.util.Scanner;

public class ConsoleDisplayService implements DisplayService {
    private String rep;
    private Scanner scanner = new Scanner(System.in) ;
    private Enfant enfant;
    private RendezVous rendezVous;
    private Dossier dossier;
    private Medecin medecin;
    @Override
    public void afficherBienvenu() {
        System.out.println("Bienvenue dans la plateforme");
    }

    @Override
    public void afficherMenuPrincipal() {
        System.out.println("A Demande Consultation");
        System.out.println("B Consulter liste Consultation");
        System.out.println("C Demande Rendez-vous");
        System.out.println("D Demande liste Rendez-vous");
        System.out.println("E Dossier Medical");
        System.out.println("F Listes Dossier Medical");
    }



    @Override
    public void afficherChoix(String choix) {
        switch (choix)
        {
            case "a" :
            {
                System.out.println("Demande consultation");
            }
            break ;
            case "b" :
            {
                System.out.println("Consulter liste Consultation");
            }
            break ;
            case "c" :
            {
                System.out.println("Demande Rendez-vous");
            }
            break ;
            case "d" :
            {
                System.out.println(" liste des Rendez-vous");
            }
            break ;
            case "e" :
            {
                System.out.println("DOSSIER Medicale");
            }
            break ;
            case "f" :
        {
            System.out.println("Listes Dossier Medical");
        }
        break ;

            default :
                System.out.println("Choix non disponible");
                break ;
        }
    }

    @Override
    public String choixMenu()
    {

        do {
            System.out.println("Faites votre choix");
            rep = scanner.next().toLowerCase();
            switch (rep)
            {
                case "a" :
                {
                    ajoutConsultation();
                }
                break ;
                case "b" :
                {
                    System.out.println("Consulter liste Consultation");
                }
                break ;
                case "c" :
                {
                    ajoutRendezVous ();
                }
                break ;
                case "d" :
                {
                    System.out.println(" liste des Rendez-vous");
                }
                break ;
                case "e" :
                {
                    ajoutDossier();
                }
                break ;
                case "f" :
                {
                    System.out.println("Listes Dossier Medical");
                }
                break ;
                case "g" :
                {
                    System.out.println("Ajouter un Medecin ");
                }
                break ;
            }

        }while(!rep.equals("a") && !rep.equals("b") && !rep.equals("c") && !rep.equals("d") && !rep.equals("e") &&
                !rep.equals("f") && !rep.equals("q")) ;
        return rep ;

    }

    @Override
    public Enfant saisiEnfant() {
        String nom="";
        String prenom="";
        int age;
        String adresse="";
        String tel="";
        String vaccin="";
        String nomP="";
        do {
            System.out.println("Saisie le nom du patient");
            nom = scanner.next();
        }while(nom.equals(""));
        do {
            System.out.println("Saisie le prenom du patient");
            prenom = scanner.next();
        }while(prenom.equals(""));
        do {
            System.out.println("Saisie l'age du patient");
            age= scanner.nextInt();
        }while(age<=0);
        do {
            System.out.println("Saisie l'adresse du patient");
            adresse = scanner.next();
        }while(adresse.equals(""));
        do {
            System.out.println("Saisie le telephone du patient");
            tel = scanner.next();
        }while(tel.equals(""));
        do {
            System.out.println("Saisie le vaccin du patient");
            vaccin = scanner.next();
        }while(vaccin.equals(""));
        do {
            System.out.println("Saisie le nom du parent");
            nomP = scanner.next();
        }while(nomP.equals(""));
        enfant.setNomE(nom);
        enfant.setPrenomE(prenom);
        enfant.setAge(age);
        enfant.setTelephone(tel);
        enfant.setAdresse(adresse);
        enfant.setNomP(nomP);
        enfant.setVacccin(vaccin);
        return enfant;
    }
    private EnfantRepository enfantRepository;
    private int resu=0;


    @Override
    public void ajoutConsultation() {
        enfantRepository = new JdbcBaseEnfantRepository();
        enfant = new Enfant();
        enfant = saisiEnfant();
        resu=enfantRepository.addEnfant(enfant);
        if (resu==0)
        {
            System.out.println("Donnee non enregistree");
        }
            else{
            System.out.println("Ajout avec succe dans la base");
        }

    }

    @Override
    public RendezVous saisiRendezVous() {
        String nomPatient="";
        String prenomPatient="";
        String dateRendezVous="";
        String commentaire="";
        do {
            System.out.println("Saisie le nom du patient");
            nomPatient = scanner.next();
        }while(nomPatient.equals(""));
        do {
            System.out.println("Saisie le prenom du patient");
            prenomPatient = scanner.next();
        }while(prenomPatient.equals(""));
        do {
            System.out.println("Saisie la date de rendez-vous du patient");
            dateRendezVous = scanner.next();
        }while(dateRendezVous.equals(""));
        do {
            System.out.println("Saisie le nom du patient");
            commentaire = scanner.next();
        }while(commentaire.equals(""));
        rendezVous.setNomPat(nomPatient);
        rendezVous.setPrenomPat(prenomPatient);
        rendezVous.setDateRV(dateRendezVous);
        rendezVous.setCommentaire(commentaire);
        return rendezVous;
    }
    private RendezVousRepository rendezVousRepository;
    private int rsv=0;

    @Override
    public void ajoutRendezVous() {
        rendezVousRepository = new JdbcBaseRendezVousRepository();
        rendezVous = new RendezVous();
        rendezVous = saisiRendezVous();
        rsv=rendezVousRepository.addRendezVous(rendezVous);
        if (rsv==0)
        {
            System.out.println("Donnee non enregistree");
        }
        else{
            System.out.println("Ajout avec succe dans la base");
        }
    }

    @Override
    public Dossier saisieDossier() {
        String nomPa="";
        String prenomPa="";
        String sexe="";
        String adresse="";
        int age=0;
        String telephone ="";
        String allegie="";
        String antecedant="";
        String maladie="";
        do {
            System.out.println("Saisie le nom du patient");
            nomPa = scanner.next();
        }while(nomPa.equals(""));
        do {
            System.out.println("Saisie le nom du patient");
            prenomPa = scanner.next();
        }while(prenomPa.equals(""));
        do {
            System.out.println("Saisie le nom du patient");
            sexe = scanner.next();
        }while(sexe.equals(""));
        do {
            System.out.println("Saisie l'age du patient");
            age= scanner.nextInt();
        }while(age<=0);
        do {
            System.out.println("Saisie le nom du patient");
            adresse = scanner.next();
        }while(adresse.equals(""));
        do {
            System.out.println("Saisie le nom du patient");
            telephone = scanner.next();
        }while(telephone.equals(""));
        do {
            System.out.println("Saisie le nom du patient");
            allegie = scanner.next();
        }while(allegie.equals(""));
        do {
            System.out.println("Saisie le nom du patient");
            antecedant = scanner.next();
        }while(antecedant.equals(""));
        do {
            System.out.println("Saisie le nom du patient");
            maladie = scanner.next();
        }while(maladie.equals(""));
        return dossier;
    }
    private DossierRepository dossierRepository;
    private int rdos=0;
    @Override
    public void ajoutDossier() {
        dossierRepository = new JdbcBaseDossierRepository();
        dossier = new Dossier();
        dossier = saisieDossier();
        rdos=dossierRepository.addDossier(dossier);
        if (rdos==0)
        {
            System.out.println("Donnee non enregistree");
        }
        else{
            System.out.println("Ajout avec succe dans la base");
        }
    }

    @Override
    public Medecin saisiMedecin() {
        return null;
    }
}
