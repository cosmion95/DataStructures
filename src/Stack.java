public class Stack {

    StackNumar radacina;

    static class StackNumar {

        int element;
        StackNumar urmator;

        StackNumar(int numar) {
            this.element = numar;
            urmator = null;
        }

    }

    public static Stack push(Stack stiva, int element) {
        StackNumar stNr = new StackNumar(element);
        //verific daca stiva este goala
        if (isEmpty(stiva)) {
            stiva.radacina = stNr;
        } else {
            //iterez pana la ultimul element
            StackNumar curent = stiva.radacina;
            while (curent.urmator != null) {
                curent = curent.urmator;
            }
            //curent = ultimul element
            curent.urmator = stNr;
        }
        return stiva;
    }

    public static void afisare(Stack stiva) {
        if (!isEmpty(stiva)) {
            StackNumar curent = stiva.radacina;
            System.out.println("---------BAZA---------");
            while (curent != null) {
                System.out.println("          " + curent.element);
                curent = curent.urmator;
            }
        } else {
            System.out.println("Stiva este goala");
        }
    }

    public static Stack pop(Stack stiva) {
        if (isEmpty(stiva)) {
            System.out.println("Stiva este goala");
        } else {
            StackNumar curent = stiva.radacina;
            StackNumar precedent = curent;
            while (curent.urmator != null) {
                precedent = curent;
                curent = curent.urmator;
            }
            System.out.println("Eliminat elementul " + curent.element);
            precedent.urmator = null;
            curent = null;
            System.out.println("Stiva acum:");
            afisare(stiva);
        }
        return stiva;
    }

    public static void clear(Stack stiva){
        if (isEmpty(stiva)){
            System.out.println("Stiva este goala");
        }
        else {
            stiva.radacina = null;
            System.out.println("Stiva dupa clear:");
            afisare(stiva);
        }
    }

    public static boolean isEmpty(Stack stiva){
        return (stiva.radacina == null);
    }

    public static int peek(Stack stiva){
        if (isEmpty(stiva)){
            System.out.println("Stiva este goala");
            return 0;
        }
        else {
            StackNumar curent = stiva.radacina;
            while (curent.urmator != null){
                curent = curent.urmator;
            }
            System.out.println("Elementul din varf este: " + curent.element);
            return curent.element;
        }
    }

}
