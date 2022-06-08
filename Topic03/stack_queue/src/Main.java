public class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 10; i++) {
            st.push(i);
        }
        System.out.println(st.pop());
        System.out.println(st);
        System.out.println(st.size());
        System.out.println("Hà Quốc");
    }
}
