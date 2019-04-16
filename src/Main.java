public class Main {

    public static void main(String[] args) {

        // --------------------------------------------------------------------------
        //**************************************************************************

        //TESTARE LSI !!!!!

      /*  LSI lista = new LSI();
        LSI.adaugareInceput(lista, "Creanga","Ion", 1);
        LSI.adaugareInceput(lista, "Eminescu","Mihai", 2);
        LSI.adaugareSfarsit(lista,"Stanescu","Nichita", 3);

        LSI.adaugareInainteNume(lista, "Eminescu", "Cartarescu", "Mircea", 4);
        LSI.adaugareDupaNume(lista, "Cartarescu", "Barbu", "Ion", 5);

        LSI.stergerePrimElement(lista);
        LSI.stergereUltimElement(lista);

        //LSI.adaugareInceput(lista, "Creanga","Ion", 1);

        LSI.stergeDupaNumePrenume(lista, "Eminescu","Mihai");


        //LSI.distrugere(lista);
        LSI.cautaNume(lista, "Creanga");

        LSI.afisareLSI(lista);*/

        //--------------------------------------------------------------------
        //********************************************************************

        //TESTARE LSI CU CARTIERE

        CartierLSI listaCartiere = new CartierLSI();

        CartierLSI.adaugaCartierInceput(listaCartiere, "CART1", null);

        CartierLSI.afisare(listaCartiere);

        LSI lista = new LSI();
        LSI.adaugareInceput(lista, "Creanga","Ion", 1);
        LSI.adaugareInceput(lista, "Eminescu","Mihai", 2);
        LSI.adaugareSfarsit(lista,"Stanescu","Nichita", 3);

        CartierLSI.adaugareListaPersoane(listaCartiere, "CART1", lista);



        LSI.adaugareSfarsit(listaCartiere.inceputCartier.persoane, "Hagi", "Gica", 25);

        CartierLSI.afisare(listaCartiere);


        //--------------------------------------------------------------------
        //********************************************************************


        //TESTARE LDI !!!

       /* LDI lista = new LDI();
        LDI.adaugareInceput(lista, 1);
        LDI.adaugareInceput(lista, 2);
        LDI.adaugareSfarsit(lista, 3);

        LDI.adaugareInainteElem(lista, 4, 3);
        LDI.adaugareDupaElem(lista, 5, 3);

        LDI.stergePrim(lista);
        LDI.stergeUltim(lista);

        LDI.stergeElement(lista, 4);

        LDI.cautareElement(lista, 1);


        LDI.afisareAsc(lista);
        LDI.distrugere(lista);

        LDI.afisareDesc(lista);*/

        //---------------------------------------------------------------------
        //*********************************************************************

        //TESTARE STIVA DINAMICA !!!

   /*     Stack stiva = new Stack();

        Stack.push(stiva, 1);
        Stack.push(stiva,2);
        Stack.push(stiva,3);

        Stack.afisare(stiva);
        Stack.pop(stiva);
        Stack.push(stiva, 5);
        Stack.afisare(stiva);
        Stack.peek(stiva);*/

        //-----------------------------------------------------------
        //**********************************************


        //TESTARE COADA DINAMICA !!!!!!!!!!!!!

     /*   Queue coada = new Queue();

        Queue.enqueue(coada, 1);
        Queue.enqueue(coada, 2);
        Queue.enqueue(coada, 3);

        Queue.afisare(coada);

        Queue.dequeue(coada);
        Queue.afisare(coada);*/


        //---------------------------------------------------
        //***********************************************




    }

//

}
