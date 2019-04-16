public class LDI {

    Numar inceputLista; //inceputul listei

    static class Numar {
        int numar;

        Numar urmator;
        Numar precedent;

        Numar(int numar) {
            this.numar = numar;
            urmator = null;
            precedent = null;
        }
    }

    public static LDI adaugareInceput(LDI lista, int numar) {
        Numar nr = new Numar(numar);

        if (lista.inceputLista == null) {
            lista.inceputLista = nr;
        } else {
            nr.urmator = lista.inceputLista;
            lista.inceputLista.precedent = nr;
            lista.inceputLista = nr;
        }
        return lista;
    }

    public static LDI adaugareSfarsit(LDI lista, int numar) {
        Numar nr = new Numar(numar);
        //iterez catre finalul listei
        Numar nrCurent = lista.inceputLista;
        while (nrCurent != null) {
            if (nrCurent.urmator == null) {
                //am ajuns la finalul listei
                nr.precedent = nrCurent;
                nrCurent.urmator = nr;
                return lista;
            }
            nrCurent = nrCurent.urmator;
        }
        return lista;
    }

    public static LDI adaugareInainteElem(LDI lista, int numar, int numarCautat) {

        //verific daca elementul cautat e pe prima pozitie
        if (lista.inceputLista.numar == numarCautat) {
            //adaug la inceput
            return adaugareInceput(lista, numar);
        } else {
            Numar nr = new Numar(numar);
            boolean check = false;
            Numar curent = lista.inceputLista.urmator;
            while (curent != null) {
                if (curent.numar == numarCautat) {
                    //am gasit elementul cautat
                    check = true;
                    nr.precedent = curent.precedent;
                    nr.urmator = curent;
                    curent.precedent.urmator = nr;
                    curent.precedent = nr;
                    return lista;
                }
                curent = curent.urmator;
            }
            if (!check) {
                System.out.println("Nu am gasit elementul cautat");
            }
        }
        return lista;
    }

    public static LDI adaugareDupaElem(LDI lista, int numar, int numarCautat) {
        Numar nr = new Numar(numar);
        boolean check = false;
        Numar curent = lista.inceputLista;
        while (curent != null) {
            if (curent.numar == numarCautat) {
                //am gasit elementul cautat
                check = true;
                //verific daca e pe ultima pozitie
                if (curent.urmator == null) {
                    //fac adaugare la final
                    return adaugareSfarsit(lista, numar);
                } else {
                    nr.precedent = curent;
                    nr.urmator = curent.urmator;
                    curent.urmator.precedent = nr;
                    curent.urmator = nr;
                    return lista;
                }
            }
            curent = curent.urmator;
        }
        if (!check) {
            System.out.println("Nu am gasit elementul cautat");
        }
        return lista;
    }

    public static LDI stergePrim(LDI lista) {
        Numar noulInceput = lista.inceputLista.urmator;
        noulInceput.precedent = null;
        lista.inceputLista = noulInceput;
        return lista;
    }

    public static LDI stergeUltim(LDI lista) {
        //iterez pana la capatul listei
        Numar curent = lista.inceputLista;
        while (curent.urmator != null) {
            curent = curent.urmator;
        }
        curent.precedent.urmator = null;
        curent = null;
        return lista;
    }

    public static LDI stergeElement(LDI lista, int element) {
        //verific daca primul element e cel cautat
        if (lista.inceputLista.numar == element) {
            //sterg inceputul listei
            return stergePrim(lista);
        } else {
            boolean check = false;
            Numar curent = lista.inceputLista.urmator;
            while (curent != null) {
                if (curent.numar == element) {
                    //gasit
                    check = true;
                    //verific daca e ultimul element
                    if (curent.urmator == null) {
                        //sterg de la final
                        return stergeUltim(lista);
                    } else {
                        curent.precedent.urmator = curent.urmator;
                        curent.urmator.precedent = curent.precedent;
                        curent = null;
                        return lista;
                    }
                }
                curent = curent.urmator;
            }
            if (!check) {
                System.out.println("Nu am gasit elementul cautat");
            }
        }
        return lista;
    }

    public static void cautareElement(LDI lista, int element) {
        Numar curent = lista.inceputLista;
        boolean check = false;
        while (curent != null) {
            if (curent.numar == element) {
                System.out.println("Am gasit elementul cautat");
                check = true;
            }
            curent = curent.urmator;
        }
        if (!check) {
            System.out.println("Nu am gasit elementul cautat");
        }
    }

    public static void afisareAsc(LDI lista) {
        Numar nr = lista.inceputLista;
        boolean empty = true;
        System.out.println("Afisare ascendenta: ");
        while (nr != null) {
            System.out.println("Numar: " + nr.numar);
            nr = nr.urmator;
            empty = false;
        }
        if (empty) {
            System.out.println("Lista este goala");
        }
    }

    public static void afisareDesc(LDI lista) {
        //verific daca lista e goala
        if (lista.inceputLista == null) {
            System.out.println("Lista este goala!");
        } else {
            Numar curent = lista.inceputLista;
            //merg la capatul listei
            while (curent.urmator != null) {
                curent = curent.urmator;
            }
            //am ajuns la capat, iterez inapoi
            System.out.println("Afisare descendenta: ");
            while (curent != null) {
                System.out.println("Numar:" + curent.numar);
                curent = curent.precedent;
            }
        }
    }

    public static void distrugere(LDI lista) {
        //verific daca lista e goala
        if (lista.inceputLista == null) {
            System.out.println("Lista este goala!");
        } else {
            lista.inceputLista = null;
            System.out.println("Sters");
        }
    }
}
