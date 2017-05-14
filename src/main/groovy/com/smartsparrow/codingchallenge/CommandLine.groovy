package com.smartsparrow.codingchallenge

/**
 * Psuedo "View" - CLI entry point for entering commands from a shell
 */
class CommandLine {

    static void main(String[] args) {
        Application instance = new Application()
        System.out.println("Please enter you name: ")
        BufferedReader stdin = System.in.newReader()
        String name = stdin.readLine()
        System.out.println("\nWelcome " + name.capitalize() + " Please enter you selection from below or type 'HELP'\n" +
                "\tbb : Balanced Brackets\n" +
                "\tcp : Csv Parsing\n" +
                "\tan : Anagram Lookup\n" +
                "\tsp : Spiral Matrix\n" +
                "\ttc : Time Confusion\n");

        String input
        String output

        while (true) {
            input = stdin.readLine()

            if (input == null) {
                break
            }

            try {
                output = instance.execute(input)

                if (output) {
                    println(output)
                }
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    break

                } else {
                    println(e.message)
                }
            }
            System.out.println("\nPlease continue, enter your next command to execute")
        }
    }
}
