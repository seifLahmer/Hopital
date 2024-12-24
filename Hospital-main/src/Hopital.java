import java.util.Map;
import java.util.TreeMap;

public class Hopital {
    public Map<Medecin, ListPatients> medecinPatients;

    public Hopital() {
        medecinPatients = new TreeMap<>();
    }

    public void ajouterMedecin(Medecin m) {
        medecinPatients.put(m, new ListPatients());
    }

    public void ajouterPatient(Medecin m, Patient p) {
        if (medecinPatients.containsKey(m)) {
            if (!medecinPatients.get(m).rechercherPatient(p)) {
                medecinPatients.get(m).ajouterPatient(p);
            }
        } else {
            ListPatients patients = new ListPatients();
            patients.ajouterPatient(p);
            medecinPatients.put(m, patients);
        }
    }

    public void afficherMap() {
        medecinPatients.forEach((medecin, patients) -> {
            System.out.println("Medecin: " + medecin);
            patients.afficherPatients();
        });
    }

    public void afficherMedcinPatients(Medecin m) {
        System.out.println("Patients du medecin " + m.getNom() + " : ");
        medecinPatients.get(m).afficherPatients();
    }

    public static void main(String[] args) {
        Hopital hopital = new Hopital();

        Medecin medecin1 = new Medecin(1, "Dr. labyedh", "slimen", 101);
        Medecin medecin2 = new Medecin(1, "Dr. sbou3i", "labyedh ", 102);

        Patient patient1 = new Patient(101, "3allela", "Jane", 1001);
        Patient patient2 = new Patient(102, "oussema", "Bob", 1002);
        Patient patient3 = new Patient(102, "Azer", "Bob", 1002);


        hopital.ajouterMedecin(medecin1);
        hopital.ajouterMedecin(medecin2);

        hopital.ajouterPatient(medecin1, patient1);
        hopital.ajouterPatient(medecin2, patient2);
        hopital.ajouterPatient(medecin2, patient3);


        hopital.afficherMap();
    }
}
