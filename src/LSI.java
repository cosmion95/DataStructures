import java.util.concurrent.TimeoutException;

public class LSI {

    Persoana inceputLista; //inceputul listei

    static class Persoana {

        String nume;
        String prenume;
        int varsta;

        Persoana nextPers;

        Persoana(String nume, String prenume, int varsta) {
            this.nume = nume;
            this.prenume = prenume;
            this.varsta = varsta;
            nextPers = null;
        }
    }

    private static boolean verificaPersoana(LSI lista, String nume, String prenume){
        //verific sa nu existe persoane cu acelasi nume si prenume in lista
        Persoana persoanaCurenta = lista.inceputLista;
        while (persoanaCurenta != null){
            if (persoanaCurenta.nume.equals(nume) && persoanaCurenta.prenume.equals(prenume)){
                return true;
            }
            persoanaCurenta = persoanaCurenta.nextPers;
        }
        return false;
    }

    public static LSI adaugareInceput(LSI lista, String nume, String prenume, int varsta) {
        //verific daca exista persoana cu acest nume/prenume
        if (verificaPersoana(lista, nume, prenume)){
            System.out.println("EXISTA PERSOANA CU ACEST NUME SI PRENUME");
            return lista;
        }
        //creez initial o noua persoana care nu are referinte catre persoana urmatoare
        Persoana persoana = new Persoana(nume, prenume, varsta);

        //verific daca lista exista
        if (lista.inceputLista == null) {
            lista.inceputLista = persoana;
        } else {
            persoana.nextPers = lista.inceputLista;
            lista.inceputLista = persoana;
        }
        return lista;
    }

    public static LSI adaugareSfarsit(LSI lista, String nume, String prenume, int varsta) {
        //verific daca exista persoana cu acest nume/prenume
        if (verificaPersoana(lista, nume, prenume)){
            System.out.println("EXISTA PERSOANA CU ACEST NUME SI PRENUME");
            return lista;
        }
        //creez persoana
        Persoana persoana = new Persoana(nume, prenume, varsta);

        //merg la finalul listei
        Persoana persoanaCurenta = lista.inceputLista;
        while (persoanaCurenta.nextPers != null) {
            persoanaCurenta = persoanaCurenta.nextPers;
        }
        persoanaCurenta.nextPers = persoana;
        return lista;
    }

    public static LSI adaugareInainteNume(LSI lista, String numeCautat, String nume, String prenume, int varsta) {
        //verific daca exista persoana cu acest nume/prenume
        if (verificaPersoana(lista, nume, prenume)){
            System.out.println("EXISTA PERSOANA CU ACEST NUME SI PRENUME");
            return lista;
        }
        //creez persoana
        Persoana persoana = new Persoana(nume, prenume, varsta);

        //verific daca persoana cautata este capul de lista
        if (lista.inceputLista.nume.equals(numeCautat)) {
            //adaug la inceputul listei
            return adaugareInceput(lista, nume, prenume, varsta);
        }
        //iterez prin toata lista
        else {
            boolean check = false;
            Persoana persoanaCurenta = lista.inceputLista.nextPers;
            Persoana precedenta = lista.inceputLista;
            while (!check && persoanaCurenta != null) {
                //caut dupa nume
                if (persoanaCurenta.nume.equals(numeCautat)) {
                    //gasit
                    check = true;
                    //adaug referinta catre persoana gasita dupa nume
                    persoana.nextPers = persoanaCurenta;
                    //schimb referinta din persoana precedenta catre noua persoana
                    precedenta.nextPers = persoana;
                }
                precedenta = persoanaCurenta;
                persoanaCurenta = persoanaCurenta.nextPers;
            }
            if (!check) {
                System.out.println("Persoana cu numele: " + numeCautat + " nu a fost gasita");
            }
        }
        return lista;
    }

    public static LSI adaugareDupaNume(LSI lista, String numeCautat, String nume, String prenume, int varsta) {
        //verific daca exista persoana cu acest nume/prenume
        if (verificaPersoana(lista, nume, prenume)){
            System.out.println("EXISTA PERSOANA CU ACEST NUME SI PRENUME");
            return lista;
        }
        //creez persoana
        Persoana persoana = new Persoana(nume, prenume, varsta);

        boolean check = false;
        Persoana persoanaCurenta = lista.inceputLista;
        while (!check && persoanaCurenta != null) {
            //caut dupa nume
            if (persoanaCurenta.nume.equals(numeCautat)) {
                //gasit
                check = true;
                //adaug referinta catre persoana urmatoare in noua persoana
                persoana.nextPers = persoanaCurenta.nextPers;
                //schimb referinta din persoana precedenta catre noua persoana
                persoanaCurenta.nextPers = persoana;
            }
            persoanaCurenta = persoanaCurenta.nextPers;
        }
        if (!check) {
            System.out.println("Persoana cu numele: " + numeCautat + " nu a fost gasita");
        }
        return lista;
    }

    public static LSI stergerePrimElement(LSI lista) {
        Persoana noulInceput = lista.inceputLista.nextPers;
        lista.inceputLista = noulInceput;
        return lista;
    }

    public static LSI stergereUltimElement(LSI lista) {
        //iterez pana la capatul listei
        Persoana persoanaCurenta = lista.inceputLista;
        Persoana precedenta = persoanaCurenta;
        do {
            precedenta = persoanaCurenta;
            persoanaCurenta = persoanaCurenta.nextPers;
        }
        while (persoanaCurenta.nextPers != null);
        persoanaCurenta = null;
        precedenta.nextPers = null;
        return lista;
    }

    public static LSI stergeDupaNumePrenume(LSI lista, String nume, String prenume){
        //verific daca persoana cautata este cap de lista
        if (lista.inceputLista.nume.equals(nume) && lista.inceputLista.prenume.equals(prenume)){
            //fac stergere de prim element
            return stergerePrimElement(lista);
        }
        else {
            boolean found = false;
            Persoana persoanaCurenta = lista.inceputLista.nextPers;
            Persoana precedenta = lista.inceputLista;
            do {
                if (persoanaCurenta.nume.equals(nume) && persoanaCurenta.prenume.equals(prenume)) {
                    found = true;
                    //verific daca trebuie sa fac stergere de la final
                    if (persoanaCurenta.nextPers == null) {
                        return stergereUltimElement(lista);
                    } else {
                        precedenta.nextPers = persoanaCurenta.nextPers;
                        persoanaCurenta = null;
                        return lista;
                    }
                }
                precedenta = persoanaCurenta;
                persoanaCurenta = persoanaCurenta.nextPers;
            }
            while (persoanaCurenta.nextPers != null);
            if (!found) {
                System.out.println("Nu am gasit persoana cautata");
            }
        }
        return lista;
    }

    public static void cautaNume(LSI lista, String nume){
        Persoana persoanaCurenta = lista.inceputLista;
        while (persoanaCurenta != null){
            if (persoanaCurenta.nume.equals(nume)){
                System.out.println("L-am gasit pe " + nume);
            }
            persoanaCurenta = persoanaCurenta.nextPers;
        }
    }

    public static void afisare(LSI lista) {
        Persoana persoanaCurenta = lista.inceputLista;
        boolean empty = true;
        while (persoanaCurenta != null) {
            System.out.println("Nume: " + persoanaCurenta.nume);
            System.out.println("Prenume: " + persoanaCurenta.prenume);
            System.out.println("Varsta: " + persoanaCurenta.varsta);
            persoanaCurenta = persoanaCurenta.nextPers;
            empty = false;
        }
        if (empty){
            System.out.println("Lista este goala");
        }
    }

    public static LSI distrugere(LSI lista){
/*        Persoana persoanaCurenta = lista.inceputLista;
        while (persoanaCurenta.nextPers != null){
            Persoana temp = persoanaCurenta.nextPers;
            persoanaCurenta.nextPers = null;
            persoanaCurenta = temp;
        }*/
        lista.inceputLista = null;
        System.out.println("Sters!");
        return lista;
    }
}
