import java.io.*;

class RC {

    static String display(int disp[]) {
        char convert[] = new char[disp.length];
        for (int l = 0; l < disp.length; l++) {
            convert[l] = (char) disp[l];
        }
        String str = String.copyValueOf(convert);
        return str;
    }

    public static String encryption(String ptext) {
        int temp = 0;
        String key;
        int s[] = new int[256];
        int k[] = new int[256];

        key = "AIMS";

        char ptextc[] = ptext.toCharArray();
        char keyc[] = key.toCharArray();
        int cipher[] = new int[ptext.length()];
        int decrypt[] = new int[ptext.length()];
        int ptexti[] = new int[ptext.length()];
        int keyi[] = new int[key.length()];

        for (int i = 0; i < ptext.length(); i++) {
            ptexti[i] = (int) ptextc[i];
        }

        for (int i = 0; i < key.length(); i++) {
            keyi[i] = (int) keyc[i];
        }

        for (int i = 0; i < 255; i++) {
            s[i] = i;
            k[i] = keyi[i % key.length()];
        }

        int j = 0;
        for (int i = 0; i < 255; i++) {
            j = (j + s[i] + k[i]) % 256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        int i = 0;
        j = 0;
        int z = 0;
        for (int l = 0; l < ptext.length(); l++) 
        {
            i = (l + 1) % 256;
            j = (j + s[i]) % 256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            z = s[(s[i] + s[j]) % 256];
            cipher[l] = z ^ ptexti[l];
            decrypt[l] = z ^ cipher[l];
        }

        System.out.print("\n\nENCRYPTED:\t\t");
        String encrypted = display(cipher);

        return encrypted;
    }
    public static void main(String args[]) throws IOException {

        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter text1: ");
        String ptext1 = d.readLine();
        String output1 = encryption(ptext1);
        System.out.println(output1);

        System.out.println("Enter text2: ");
        String ptext2 = d.readLine();
        String output2 = encryption(ptext2);
        System.out.println(output2);

        if(output1.compareTo(output2) == 0) {
            System.out.println("Sign in successful");
        }
        else {
            System.out.println("Incorrect text");
        }

    }
}
