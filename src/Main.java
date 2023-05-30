public class Main {
    public static void main(String[] args) {
        String string = "Mr John Smith      ";
        char[] charArray = string.toCharArray();
        charArray = urlify(charArray, 13);
        for(int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
        }
    }
    public static char[] urlify(char[] characters, int trueLength) {
        int numberOfSpaces = countCharacters(characters, 0, trueLength, ' ');
        int stopIndex = characters.length - 1 - (trueLength + numberOfSpaces * 2);
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
        if(stopIndex >= 0) {
            characters[stopIndex] = Character.MIN_VALUE;
        }
        return characters;
    }
    private static int countCharacters(char[] characters, int start, int end, char target) {
        int count = 0;
        for(int i = start; i < end; i++) {
            if (characters[i] == target) {
                count++;
            }
        }
        return count;
    }
}