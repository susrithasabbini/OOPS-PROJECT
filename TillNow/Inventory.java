public class Inventory {
    static String display(int disp[]) {
        char convert[] = new char[disp.length];
        for (int l = 0; l < disp.length; l++) {
            convert[l] = (char) disp[l];
        }
        String str = String.copyValueOf(convert);
        return str;
    }

    public static String decryption(int cipher[]) {
        System.out.print("Encrypted text is:  ");
        System.out.print(display(cipher));
        int temp = 0;
        String key;
        int s[] = new int[256];
        int k[] = new int[256];

        key = "AIMS";

        int decrypt[] = new int[cipher.length];
        char keyc[] = key.toCharArray();
        int keyi[] = new int[key.length()];

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
        for (int l = 0; l < cipher.length; l++) {
            i = (l + 1) % 256;
            j = (j + s[i]) % 256;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            z = s[(s[i] + s[j]) % 256];
            decrypt[l] = z ^ cipher[l];
        }

        String decrypted = display(decrypt);

        return decrypted;
    }
}
