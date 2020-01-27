public class sample {

    public static void main(String[] args) {
        String str = "asd sds";
        //boolean 
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '"') {
                // str += str.charAt(i).
                str = str.replaceFirst(Character.toString(str.charAt(i)),"''");
            } 
            System.out.println(str);
            break;
        }
    }
}