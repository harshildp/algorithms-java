public class ShoppingCart {
    public static void main(String[] args) {
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList8 = {{"apple", "orange"}, {"orange", "banana", "orange"}};
        String[] shoppingCart8 = {"apple", "orange", "banana", "orange", "orange", "banana", "orange", "grape"};
        String[][] codeList9= { { "anything", "anything", "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart9 = {"orange", "apple", "banana", "orange", "apple", "orange", "orange", "banana", "apple", "banana"};
        System.out.println(checkCart(codeList1, shoppingCart1));
        System.out.println(checkCart(codeList2, shoppingCart2));
        System.out.println(checkCart(codeList3, shoppingCart3));
        System.out.println(checkCart(codeList4, shoppingCart4));
        System.out.println(checkCart(codeList5, shoppingCart5));
        System.out.println(checkCart(codeList6, shoppingCart6));
        System.out.println(checkCart(codeList7, shoppingCart7));
        System.out.println(checkCart(codeList8, shoppingCart8));
        System.out.println(checkCart(codeList9, shoppingCart9));
    }

    public static int checkCart(String[][] codeList, String[] shoppingCart) {
        int listInd = 0;
        int cartInd = 0;
        int codeInd = 0;
        while (listInd < codeList.length && cartInd < shoppingCart.length) {
            if (codeList[listInd][codeInd].equals("anything")|| codeList[listInd][codeInd].equals(shoppingCart[cartInd])) {
                if (codeInd == codeList[listInd].length - 1) {
                    codeInd = 0;
                    listInd++;
                    cartInd++;
                } else {
                    codeInd++;
                    cartInd++;
                }
            } else {
                if (codeInd == 0) {
                    cartInd++;
                } else {
                    cartInd = cartInd - codeInd + 1;
                }
                codeInd = 0;
            }
            // System.out.println("list " + listInd + " code " + codeInd + " cart " + cartInd);
        }

        if (listInd == codeList.length) {
            return 1;
        } else {
            return 0;
        }
    }
}