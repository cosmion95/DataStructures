public class Queue {

    QueueNumar radacina;

    static class QueueNumar{
        int element;

        QueueNumar urmator;

        QueueNumar(int element){
            this.element = element;
            urmator = null;
        }
    }

    public static Queue enqueue(Queue coada, int element){
        QueueNumar nr = new QueueNumar(element);
        if (isEmpty(coada)){
            coada.radacina = nr;
        }
        else {
            QueueNumar curent = coada.radacina;
            while (curent.urmator != null){
                curent = curent.urmator;
            }
            curent.urmator = nr;
        }
        return coada;
    }

    public static Queue dequeue(Queue coada){
        if (isEmpty(coada)){
            System.out.println("Nu-i nimeni la coada");
        }
        else {
            //schimb radacina
            System.out.println("Elementul: " + coada.radacina.element + " iese din coada.");
            coada.radacina = coada.radacina.urmator;
        }
        return coada;
    }

    public static boolean isEmpty(Queue coada){
        return (coada.radacina == null);
    }

    public static void afisare(Queue coada) {
        if (!isEmpty(coada)) {
            QueueNumar curent = coada.radacina;
            System.out.println("---------PRIMUL ELEMENT---------");
            while (curent != null) {
                System.out.println("               " + curent.element);
                curent = curent.urmator;
            }
            System.out.println("---------ULTIMUL ELEMENT---------");
        } else {
            System.out.println("Stiva este goala");
        }
    }

}
