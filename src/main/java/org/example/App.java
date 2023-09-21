package org.example;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        port(getPort());

        get("/sin", (req, res) -> {
            return Math.sin(Double.valueOf(req.queryParams("q")));
        });

        get("/cos", (req, res) -> {
            return Math.cos(Double.valueOf(req.queryParams("q")));
        });

        get("/palindrome", (req, res) -> {
            String q = req.queryParams("q");
            boolean pal = true;

            for(int i = 0; i < q.length() / 2; i++) {

                if(q.charAt(i) != q.charAt(q.length() - 1))
                    pal = false;

            }

            return pal ? 1 : 0;
        });

        get("/length", (req, res) -> {
            Double a = Double.valueOf(req.queryParams("a"));
            Double b = Double.valueOf(req.queryParams("b"));

            return Math.sqrt(a*a + b*b);
        });

        get("/", (req, res) -> {
           res.type("text/html");
           return client();
        });


    }

    private static String client() {
        return "<html>\n" +
                "<head>\n" +
                "\t<title>Cliente web</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\t<br><br><br>\n" +
                "\t<form id=\"cos\">\n" +
                "\t\tCoseno: <input name=\"val\"> = <input disabled name=\"result\"> <input type='submit' value='calcular'>\n" +
                "\t</form>\n" +
                "\t<br><br><br>\n" +
                "\t\n" +
                "\t<form id=\"sin\">\n" +
                "\t\tSeno: <input name=\"val\"> = <input disabled name=\"result\"> <input type='submit' value='calcular'>\n" +
                "\t</form>\n" +
                "\t<br><br><br>\n" +
                "\t\n" +
                "\t<form id=\"palindrome\">\n" +
                "\t\tPalindromo: <input name=\"val\"> = <input disabled name=\"result\"> <input type='submit' value='calcular'>\n" +
                "\t</form>\n" +
                "\t<br><br><br>\n" +
                "\t\n" +
                "\t<form id=\"length\">\n" +
                "\t\tLongitud real: <input name=\"val1\" placeholder=\"n\" > | <input name=\"val2\" placeholder=\"m\" > = <input disabled name=\"result\"> <input type='submit' value='calcular'>\n" +
                "\t</form>\n" +
                "\t<br><br><br>\n" +
                "\t\n" +
                "\t<script>\n" +
                "\t\tdocument.querySelector(\"#cos\").addEventListener('submit', (ev) => {\n" +
                "\t\t\tev.preventDefault();\n" +
                "\t\t\tlet f = ev.target;\n" +
                "\t\t\t\n" +
                "\t\t\tfetch('cos?q=' + f.elements.val.value).then(res => res.text()).then(t => {\n" +
                "\t\t\t\tf.elements.result.value = t;\n" +
                "\t\t\t});\n" +
                "\t\t});\n" +
                "\t\t\n" +
                "\t\tdocument.querySelector(\"#sin\").addEventListener('submit', (ev) => {\n" +
                "\t\t\tev.preventDefault();\n" +
                "\t\t\tlet f = ev.target;\n" +
                "\t\t\t\n" +
                "\t\t\tfetch('sin?q=' + f.elements.val.value).then(res => res.text()).then(t => {\n" +
                "\t\t\t\tf.elements.result.value = t;\n" +
                "\t\t\t});\n" +
                "\t\t});\n" +
                "\t\t\n" +
                "\t\tdocument.querySelector(\"#palindrome\").addEventListener('submit', (ev) => {\n" +
                "\t\t\tev.preventDefault();\n" +
                "\t\t\tlet f = ev.target;\n" +
                "\t\t\t\n" +
                "\t\t\tfetch('palindrome?q=' + f.elements.val.value).then(res => res.text()).then(t => {\n" +
                "\t\t\t\tf.elements.result.value = t == 0 ? 'NO' : 'SI';\n" +
                "\t\t\t});\n" +
                "\t\t});\n" +
                "\t\t\n" +
                "\t\tdocument.querySelector(\"#length\").addEventListener('submit', (ev) => {\n" +
                "\t\t\tev.preventDefault();\n" +
                "\t\t\tlet f = ev.target;\n" +
                "\t\t\t\n" +
                "\t\t\tfetch('length?a=' + f.elements.val1.value + '&b=' + f.elements.val2.value).then(res => res.text()).then(t => {\n" +
                "\t\t\t\tf.elements.result.value = t;\n" +
                "\t\t\t});\n" +
                "\t\t});\n" +
                "\t</script>\n" +
                "</body>\n" +
                "</html>";
    }
    private static int getPort() {
        if(System.getenv("PORT") != null)
            return Integer.parseInt(System.getenv("PORT"));
        return 4567;
    }


}
