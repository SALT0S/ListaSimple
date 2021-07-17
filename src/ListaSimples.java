public class ListaSimples {
    public static void main(String[] args) throws Exception {
        ListaObjetos lista = new ListaObjetos();
        lista.insertar(new Celulares("Samsung S21 Ultra", 1.607));
        lista.insertar(new Celulares("iPhone 12 pro", 1.509));
        lista.insertar(new Celulares("Huawei P40 Pro", 1.099));
        lista.insertar(new Celulares("Xiaomi Mi 10 Ultra", 1.098));
        lista.insertar(new Celulares("LG K41S        ", 679.00));

        System.out.println("\tLISTA DE TELEFONOS:");
        lista.mostrar();
        System.out.println("\n\n\tLISTA DE TELEFONOS CON UN ELEMETO ELIMINADO");
        lista.removerPorPosicion(3);
        lista.mostrar();
    }

    static class ListaObjetos {
        private Nodo inicio;
        private Nodo fin;
        private int tamanio;

        public class Nodo {
            private Celulares dato;
            private Nodo siguiente;

            public Nodo(Celulares dato, Nodo siguiente) {
                this.dato = dato;
                this.siguiente = siguiente;
            }

            public Celulares getDato() {
                return dato;
            }

            public void setDato(Celulares dato) {
                this.dato = dato;
            }

            public Nodo getSiguiente() {
                return siguiente;
            }

            public void setSiguiente(Nodo siguiente) {
                this.siguiente = siguiente;
            }

        }

        public ListaObjetos() {
            this.inicio = null;
            this.tamanio = 0;
        }

        public int getTamanio() {
            return tamanio;
        }

        public void setTamanio(int tamanio) {
            this.tamanio = tamanio;
        }

        public boolean esVacia() {
            if (inicio == null) {
                return true;
            } else {
                return false;
            }
        }

        public void insertar(Celulares m) {
            Nodo nuevo;
            if (esVacia()) {
                nuevo = new Nodo(m, null);
                inicio = nuevo;
                fin = nuevo;
            } else {
                nuevo = new Nodo(m, null);
                fin.setSiguiente(nuevo);
                fin = nuevo;
                tamanio++;
            }

        }

        public void mostrar() {
            if (!esVacia()) {
                Nodo aux = inicio;
                int i = 0;
                while (aux != null) {
                    System.out.print("\n" + i + ".[ " + aux.getDato().toString() + " ]");
                    aux = aux.getSiguiente();
                    i++;
                }
            } else {
                System.out.println("La lista está vacía.");
            }
        }

        public void removerPorPosicion(int posicion) {
            if (posicion >= 0 && posicion < tamanio) {
                if (posicion == 0) {
                    inicio = inicio.getSiguiente();
                } else {
                    Nodo aux = inicio;
                    for (int i = 0; i < posicion - 1; i++) {
                        aux = aux.getSiguiente();
                    }
                    Nodo siguiente = aux.getSiguiente();
                    aux.setSiguiente(siguiente.getSiguiente());
                }
                tamanio--;
            }
        }
    }

    static class Celulares {
        private String modelo;
        private double precio;

        public Celulares(String modelo, double precio) {
            this.modelo = modelo;
            this.precio = precio;
        }

        public String getmodelo() {
            return modelo;
        }

        public void setmodelo(String modelo) {
            this.modelo = modelo;
        }

        public double getprecio() {
            return precio;
        }

        public void setprecio(double precio) {
            this.precio = precio;
        }

        @Override
        public String toString() {
            return "Modelo: " + modelo + "\t Precio: " + precio;
        }
    }
}
