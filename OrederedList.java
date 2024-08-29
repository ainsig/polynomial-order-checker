import java.util.List;
import java.util.Comparator;

public class OrederedList {

    List<Polynomial> list;

    public OrederedList(List<Polynomial> list) {
        this.list = list;

    }

    public static int checkSorted(List<Polynomial> list){
//        for(int i = 0; i < list.size(); i++) {
//
//            int coeff_one = list.get(i).iterator().next().coeff;
//            int coeff_two = list.get(i + 1).iterator().next().coeff;
//
//            int c_comparison = Integer.compare(coeff_one, coeff_two);
//
//            int expo_one = list.get(i).iterator().next().expo;
//            int expo_two = list.get(i + 1).iterator().next().expo;
//
//            int e_comparison = Integer.compare(expo_one, expo_two);
//
//            return Integer.compare(c_comparison, e_comparison);
//        }
//
//        return 0;
        CheckSorted sorted = new CheckSorted(null, null);

        Polynomial one = null;
        Polynomial two = null; 

        for(int i = 0; i < list.size() - 1; i++) {
            one = list.get(i); 
            two = list.get(i + 1); 
        }
        
        return sorted.checkSorted(one, two);
    }

//    public static int checkSorted(Polynomial one, Polynomial two){
//
//            int coeff_one = one.iterator().next().coeff;
//            int coeff_two = two.iterator().next().coeff;
//
//            int coeff_comparison = Integer.compare(coeff_one, coeff_two);
//
//            int expo_one = one.iterator().next().expo;
//            int expo_two = two.iterator().next().expo;
//
//            int expo_comparison = Integer.compare(expo_one, expo_two);
//
//            return Integer.compare(coeff_comparison, expo_comparison);
//        }
//    }

//    public int checkSorted(List<Polynomial> list, new CheckSorted(Polynomial o1, Polynomial o2){
//
//        for(int i = 0; i < list.size(); i++){
//
//            Po
//
//            int coefficient = list.get(i).node.coeff;
//            int exponent = node.expo;
//
//            Polynomial.LL.Node second_node = list.get(i + 1).iterator().next();
//
//            int first_nodes_converted = Integer.valueOf(String.valueOf(first_nodes));
//            int second_nodes_converted = Integer.valueOf(String.valueOf(second_node));
//
//            return first_nodes_converted.co
//        }
//
//    }

    public static class CheckSorted implements Comparator<Polynomial> {
        Polynomial one;
        Polynomial two;

        public CheckSorted(Polynomial o1, Polynomial o2) {

            this.one = o1;
            this.two = o2;

        }

        @Override
        public int compare(Polynomial o1, Polynomial o2) {

            return checkSorted(o1, o2);
        }

        public int checkSorted(Polynomial one, Polynomial two) {

            double coeff_one = one.iterator().next().coeff;
            double coeff_two = two.iterator().next().coeff;

            double coeff_comparison = Double.compare(coeff_one, coeff_two);

            double expo_one = one.iterator().next().expo;
            double expo_two = two.iterator().next().expo;

            double expo_comparison = Double.compare(expo_one, expo_two);

            return Double.compare(coeff_comparison, expo_comparison);
        }
    }

}

