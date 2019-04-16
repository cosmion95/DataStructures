public class CartierLSI {

    Cartier inceputCartier;

    static class Cartier {

        String nume;
        LSI persoane;

        Cartier nextCartier;

        Cartier(String numeCartier){
            this.nume = numeCartier;
            persoane = null;
            nextCartier = null;
        }

        Cartier(String numeCartier, LSI listaPersoane){
            this.nume = numeCartier;
            this.persoane = listaPersoane;
            nextCartier = null;
        }

    }

    public static CartierLSI adaugaCartierInceput(CartierLSI listaCartier, String numeCartier, LSI listaPersoane){
        //verific daca a fost transmisa o lista de persoane
        Cartier newCartier;
        if (listaPersoane != null){
             newCartier = new Cartier(numeCartier, listaPersoane);
        }
        else {
             newCartier = new Cartier(numeCartier);
        }
        //verific daca exista un cartier adaugat
        Cartier cartierCurent = listaCartier.inceputCartier;
        if (listaCartier.inceputCartier == null){
            listaCartier.inceputCartier = newCartier;
        }
        else {
            newCartier.nextCartier = listaCartier.inceputCartier;
            listaCartier.inceputCartier = newCartier;
        }
        return listaCartier;
    }

    public static CartierLSI adaugaCartierSfarsit(CartierLSI listaCartier, String numeCartier, LSI listaPersoane){
        //verific daca a fost transmisa o lista de persoane
        Cartier newCartier;
        if (listaPersoane != null){
            newCartier = new Cartier(numeCartier, listaPersoane);
        }
        else {
            newCartier = new Cartier(numeCartier);
        }
        //gasesc ultimul cartier adaugat
        Cartier cartierCurent = listaCartier.inceputCartier;
        while (cartierCurent.nextCartier != null){
            cartierCurent = cartierCurent.nextCartier;
        }
        //mai adaug unul la capatul lui
        cartierCurent.nextCartier = newCartier;
        return listaCartier;
    }

    public static void afisare(CartierLSI lista) {
        Cartier cartierCurent = lista.inceputCartier;
        boolean empty = true;
        while (cartierCurent != null) {
            System.out.println("Nume cartier: " + cartierCurent.nume);
            //verific daca are persoane aferente
            if (cartierCurent.persoane != null) {
                System.out.println("Persoane aferente " + cartierCurent.nume + ": ");
                LSI.Persoana persoanaCurenta = cartierCurent.persoane.inceputLista;
                int counter = 1;
                while (persoanaCurenta != null) {
                    System.out.println(counter + ". " + persoanaCurenta.prenume + " " + persoanaCurenta.nume);
                    persoanaCurenta = persoanaCurenta.nextPers;
                    counter++;
                }
            }
            cartierCurent = cartierCurent.nextCartier;
            empty = false;
        }
        if (empty){
            System.out.println("Lista este goala");
        }
    }

    public static CartierLSI adaugareListaPersoane(CartierLSI listaCartier, String numeCartier, LSI listaPersoane){
        //gasesc cartierul cu numele dat, ma uit sa vad daca e cumva pe prima pozitie
        if (listaCartier.inceputCartier.nume.equals(numeCartier)){
            listaCartier.inceputCartier.persoane = listaPersoane;
            System.out.println("Am gasit cartierul " + numeCartier +". Am adaugat lista de persoane.");
        }
        else {
            Cartier cartierCautat = listaCartier.inceputCartier.nextCartier;
            boolean found = false;
            while (cartierCautat.nextCartier != null){
                if (cartierCautat.nume.equals(numeCartier)){
                    //gasit, adaug lista de persoane
                    found = true;
                    cartierCautat.persoane = listaPersoane;
                    System.out.println("Am gasit cartierul " + numeCartier +". Am adaugat lista de persoane.");
                    continue;
                }
                cartierCautat = cartierCautat.nextCartier;
            }
           if (!found){
               System.out.println("Nu am gasit cartierul " + numeCartier);
           }
        }
        return listaCartier;
    }

}
