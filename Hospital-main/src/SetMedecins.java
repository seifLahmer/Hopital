import java.util.*;

interface InterfacePatient {
    void ajouterPatient(Patient p);
    void supprimerPatient(Patient p);
    boolean rechercherPatient(Patient p);
    boolean rechercherPatient(int cin);
    void afficherPatients();
    void trierPatientsParNom();
}

public class SetMedecins {
    private Set<Medecin> setM;

    public SetMedecins() {
        setM = new HashSet<>();
    }

    public void ajouterMedecin(Medecin m) {
        setM.add(m);
    }

    public boolean rechercherMedecin(int cin) {
        return setM.stream().anyMatch(medecin -> medecin.getCin() == cin);
    }

    public void afficherMedecins() {
        setM.forEach(System.out::println);
    }

    public long nombreMedecins() {
        return setM.size();
    }

    public TreeSet<Medecin> trierMedecins() {
        return new TreeSet<>(setM);
    }
}

