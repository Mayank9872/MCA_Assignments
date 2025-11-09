import java.util.ArrayList;

class Patient {
    String name;
    ArrayList<Doctor> doctors;

    Patient(String name) {
        this.name = name;
        doctors = new ArrayList<>();
    }

    void addDoctor(Doctor d) {
        doctors.add(d);
    }

    void showDoctors() {
        System.out.println("Patient: " + name + " consulted with:");
        for (Doctor d : doctors) {
            System.out.println(" - " + d.name);
        }
        System.out.println();
    }
}

class Doctor {
    String name;
    ArrayList<Patient> patients;

    Doctor(String name) {
        this.name = name;
        patients = new ArrayList<>();
    }

    void consult(Patient p) {
        System.out.println("Dr. " + name + " is consulting patient " + p.name);
        patients.add(p);
        p.addDoctor(this);
    }

    void showPatients() {
        System.out.println("Dr. " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println(" - " + p.name);
        }
        System.out.println();
    }
}

class Hospital {
    String hospitalName;
    ArrayList<Doctor> doctors;
    ArrayList<Patient> patients;

    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    void addDoctor(Doctor d) {
        doctors.add(d);
    }

    void addPatient(Patient p) {
        patients.add(p);
    }

    void showHospital() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println(" - " + d.name);
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println(" - " + p.name);
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Hospital h = new Hospital("City Hospital");

        Doctor d1 = new Doctor("Smith");
        Doctor d2 = new Doctor("Johnson");

        Patient p1 = new Patient("Alice");
        Patient p2 = new Patient("Bob");

        h.addDoctor(d1);
        h.addDoctor(d2);
        h.addPatient(p1);
        h.addPatient(p2);

        h.showHospital();

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        d1.showPatients();
        d2.showPatients();

        p1.showDoctors();
        p2.showDoctors();
    }
}
