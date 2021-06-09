package by.regular_expression;

public class RegularExpression {

    public static void printSentences() {
        String text = "If the conversion goes the other way, this is called unboxing." +
                "For example, converting an int to an Integer, a double to a Double, and so on." +
                "Autoboxing is the automatic conversion that the Java compiler makes between the primitive types " +
                "and their corresponding object wrapper classes.";
        String[] sentences = text.split("[\\.|\\?|\\!|\\n]");
        for (int i = 0; i < sentences.length; i++) {
            for (int j = i + 1; j < sentences.length; j++) {
                if (sentences[j].trim().split("[\\s*|\\,|\\;|\\:]").length > sentences[i].trim().split("[\\s\\,\\;\\:]").length) {
                    String temp = sentences[i];
                    sentences[i] = sentences[j];
                    sentences[j] = temp;
                }
            }
        }
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
