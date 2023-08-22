package codejava;

//Abstracción
class Persona {
    // Composición
    private String gen;
    private String nom;
    private int edad;
  
    // Encapsulación
    public void setGen(String gen) {
      this.gen = gen;
    }
    public String getGen() {
      return gen;
    }
  
    public void setNom(String nom) {
      this.nom = nom;
    }
    public String getNom() {
      return nom;
    }
  
    public void setEdad(String edad) {
      this.edad = edad;
    }
    public int getEdad() {
      return edad;
    }
  }
  
  // Herencia
  class Estudiante extends Persona {
    private String carrera;
  
    public void setCarrera(String carrera) {
      this.carrera = carrera;
    }
    public String getCarrera() {
      return carrera;
    }
  }
  
  class Profesor extends Persona {
    private String grado;
  
    public void setGrado(String grado) {
      this.grado = grado;
    }
    public String getGrado() {
      return grado;
    }
  }
  
  class Principal {
    public static void main(String[] arg) {
      
      Persona p = new Persona(); // Instancia
      Estudiante e1 = new Estudiante(); // Ocurrencia del tipo estudiante
      Estudiante e2 = new Estudiante(); // Otra ocurrencia del tipo estudiante
  
      Profesor pr1 = new Profesor(); // Instancia de profesor
  
      // Polimorfismo
      Persona pr2 = new Profesor();
      pr2.getNom(); // Funciona porque es parte de Persona
      //pr2.getGrado(); // NO funciona porque el compilador toma a pr2 como Persona
      ((Profesor)pr2).getGrado(); // Funciona
      ((Profesor)p).getGrado(); // Compila, pero marca error a tiempo de ejecución
    }
  }
  
  // Pilas y colas
  abstract class Lista {
    protected Object head; // Elemento a utilizar
    protected Lista tail; // El resto de la lista
  
    public void setHead(Object head) {
      this.head = head;
    }
    public Object getHead() {
      return head;
    }
  
  }
  
  class Pila extends Lista {
  
    public Pila pull() {
      return pila.tail;
    }
  
    public void push(Pila elem) {
      elem.tail = tail;
      tail = elem;
    }
  }
  
  class Cola extends Lista {
  
    public Cola pull() {
      return pila.tail;
    }
  
    public void push(Pila elem) {
      if(this.tail == null) this.tail = elem;
      else this.tail.push(elem);
    }
  }
  
  abstract class Contenedor {
    public abstract void add(Object elem);
    public abstract Object get();
    public abstract boolean isEmpty();
  }
  
  class ContenedorPila extends Contenedor {
    private Pila pila;
  
    public void add(Object elem) {
      
      Pila auxPila = new Pila();
      auxPila.setHead(elem);
  
      if(pila == null) pila = auxPila;
      else {
        auxPila.push(pila);
        pila = auxPila;
      }
    }
  
    public Object get() {
      Object aux = pila.getHead();
      pila = pila.tail;
  
      return aux;
    }
  
    public boolean isEmpty() {
      if(pila == null) return true;
      else return false;
    }
  }
  
  class ContenedorCola extends Contenedor {
    private Cola cola;
  
    public void add(Object elem) {
      
      Cola auxCola = new Cola();
      auxCola.setHead(elem);
  
      if(cola == null) cola = auxCola;
      else {
        cola.push(auxCola);
      }
    }
  
    public Object get() {
      Object aux = cola.getHead();
      cola = cola.tail;
  
      return aux;
    }
  
    public boolean isEmpty() {
      if(cola == null) return true;
      else return false;
    }
  }
  
  /*
  class EjecucionPila {
  
    public static void main(String[]arg) {
      ContenedorPila pila = new ContenedorPila();
  
      pila.add(5);
      pila.add(55);
      pila.add(54);
      pila.add(56);
  
      while(!pila.isNull()) {
        pila.get();
      }
    }
  }
  
  
  class EjecucionCola {
  
    public static void main(String[]arg) {
      ContenedorCola cola = new ContenedorCola();
  
      cola.add(5);
      cola.add(55);
      cola.add(54);
      cola.add(56);
  
      while(!cola.isNull()) {
        cola.get();
      }
    }
  }
  */
  
  class EjecucionPilaCola {
  
    public static void main(String[]arg) {
      //Contenedor cont = new ContenedorPila(); 
      Contenedor cont = new ContenedorCola();
  
      cont.add(5);
      cont.add(55);
      cont.add(54);
      cont.add(56);
  
      while(!cont.isNull()) {
        System.out.println(cont.get());
      }
    }
  }