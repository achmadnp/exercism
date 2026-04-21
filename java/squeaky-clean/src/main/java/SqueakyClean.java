class SqueakyClean {
    static String clean(String identifier) {
        String cleanedString = "";
        boolean kebabCaseModifier = false;

        for (char ch: identifier.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                cleanedString += "_";
            } else if (ch == '-') {
                kebabCaseModifier = true;
            } else if (kebabCaseModifier) {
                kebabCaseModifier = false;
                cleanedString += Character.toUpperCase(ch);
            } else if (Character.isDigit(ch)) {
                switch (ch) {
                    case '3':
                        cleanedString += "e";
                        break;
                    case '4':
                        cleanedString += "a";
                        break;
                    case '0':
                        cleanedString += "o";
                        break;
                    case '1':
                        cleanedString += "l";
                        break;
                    case '7':
                        cleanedString += "t";
                        break;
                    default:
                        break;
                }
            } else if (!Character.isDigit(ch) && !Character.isLetter(ch)) {
            } else {
                cleanedString += ch;
            }
        }
        return cleanedString;
    }
}
