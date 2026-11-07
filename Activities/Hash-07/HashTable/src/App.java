import Hash.Hash;

public class App {
    public static void main(String[] args) throws Exception {
        Hash<String, String> map = new Hash<>(89); // Prime number better

        map.add("aardvark", "An animal");
        map.add("bear", "A big dog");
    }
}
