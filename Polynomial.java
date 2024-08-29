import java.util.*;

public class Polynomial implements Iterable<Polynomial.LL.Node>, Comparable<Polynomial>{

    private String expression;

    @Override
    public Iterator<LL.Node> iterator() {

        return new StringIterator(this.expression);

    }

    //Constructor
    public Polynomial(String expression) throws InvalidPolynomialSyntax{

        this.expression = expression;

        if (expression == null || expression.isEmpty()){
            throw new InvalidPolynomialSyntax("Input is empty");
        }

        String[] input = expression.split(" ");

        for(int i = 0; i < input.length ; i++){
            if(!input[i].matches("\\d+")){
                throw new InvalidPolynomialSyntax("Only numbers are allowed");
            }
        }

    }

    @Override
    public int compareTo(Polynomial second) {

       StringIterator ItOne = (StringIterator) this.iterator();
       StringIterator ItTwo = (StringIterator) second.iterator();

       while(ItOne.hasNext() && ItTwo.hasNext()) {

           Polynomial.LL.Node nodeOne = ItOne.next();
           Polynomial.LL.Node nodeTwo = ItTwo.next();

           if (nodeOne.coeff < nodeTwo.coeff) {
               return -1;
           } else if (nodeOne.coeff > nodeTwo.coeff) {
               return 1;
           }

           if (nodeOne.expo < nodeTwo.expo) {
               return -1;
           } else if (nodeOne.expo > nodeTwo.expo) {
               return 1;
           }
       }

       if(ItOne.hasNext()){
           return 1;
       } else if (ItTwo.hasNext()){
           return -1;
       }

       return 0;
    }


    public static class StringIterator implements Iterator<LL.Node> {

        int counter;
        private LL linkedL = new LL();

        public StringIterator(String expression){

            this.counter = 0;

            String[] t = expression.split(" ");

            for(int i = 0; i < t.length; i += 2){
                double a = Double.parseDouble(t[i]);
                double b = Double.parseDouble(t[i + 1]);

                linkedL.addNode(a, b);
            }

        }

        @Override
        public boolean hasNext() {
            return counter < linkedL.getSize();
        }

        @Override
        public LL.Node next() {

            if (!hasNext()){
                throw new NoSuchElementException();
            }

            LL.Node curNode = linkedL.getNode(counter);
            counter++;

            return curNode;

        }

    }

    //Creating the linked list
    public static class LL {

        private Node head;
        private Node tail;
        private int length;

        static class Node {

            double coeff;
            double expo;
            Node next;

            public Node(double coeff, double expo){

                this.coeff = coeff;
                this.expo = expo;
                next = null;

            }

            @Override
            public String toString(){
                return this.coeff + " " + this.expo;
            }
        }

        public LL(){

            head = null;
            tail = null;
            length = 0;
        }

        public void addNode(double coeff, double expo){

            Node newNode = new Node(coeff, expo);

            if(length == 0){
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            length++;
        }

        public int getSize(){
            int count = 0;
            LL.Node  current = head;
            while(current != null){
                count++;
                current = current.next;
            }
            return count;
        }

        public LL.Node getNode(int i){
            if (i < 0 || i >= getSize()){
                throw new IndexOutOfBoundsException("Invalid index: " + i);
            }

            LL.Node c = head;
            int count = 0;

            while (count < i){
                c = c.next;
                count++;
            }

            return c;
        }

    }


    @Override
    public String toString(){
        return this.expression;
    }

}
