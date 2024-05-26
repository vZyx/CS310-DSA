package Queue.lab;

public class Person {

    private String name;
    private String address;

    public Person(){ this(null,null);}

    public Person(String name, String address)
    {
        this.name=name ;
        this.address=address;
    }//end of constructor

    public String getName() { return name;  }
    public void setName(String name) {  this.name = name;   }

    public String getAddress() {  return address;   }
    public void setAddress(String address) {  this.address = address;  }

    @Override
    public String toString() {
        return "Name: "+name + " Address: " + address +"\n";
    }//end of toString

    @Override
    public boolean equals(Object o) {
        return (this.name==((Person)o).name) && (this.address==((Person)o).address);
    }//end of equals


        public static void main(String[] args) {
            LinkedList<Person> pList = new LinkedList<Person>();

            pList.addFirst(new Person("Hessa","SA"));
            pList.addFirst(new Person("Nora","SA"));
            pList.display();
            pList.addNode(new Person("Farah","SA"),2);
            pList.display();
            System.out.println(pList.ﬁrst().getName());

            pList.removeNode(pList.last());
            pList.display();

    }
}

