public class Main {
    public static void main(String[] args) {
        String string = "Mr John Smith    ";
        char[] charArray = string.toCharArray();
        charArray = urlify(charArray, 13);
        for(int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
        }
    }
    public static char[] urlify(char[] characters, int trueLength) {
        int modified = characters.length - 1;
        char[] urlSpace = {'%', '2', '0'};
        for(int i = trueLength - 1; i >= 0; i--) {
            if(characters[i] != ' ') {
                char temp = characters[i];
                characters[i] = characters[modified];
                characters[modified--] = temp;
            } else {
                for(int j = urlSpace.length - 1; j >= 0; j--) {
                    characters[modified--] = urlSpace[j];
                }
            }
        }
        return characters;
    }
}