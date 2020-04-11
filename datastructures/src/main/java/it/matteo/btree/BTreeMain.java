package it.matteo.btree;

/**
 *
 * @author matteo.minardi
 */
public class BTreeMain {

    /**
     * Unit tests the {@code BTree} data type.
     *
     */
    public static void main(String[] args) {
        BTree<Integer, String> st = new BTree<>();

        for (int index = 0; index < 100; index++) {
            st.put(index, String.format("Leaf %d", index));
        }

        System.out.println("Size:    " + st.size());
        System.out.println("Height:  " + st.height());
        System.out.println(st);
        System.out.println();
    }

}
