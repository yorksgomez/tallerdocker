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


    }
    private static int getPort() {
        if(System.getenv("PORT") != null)
            return Integer.parseInt(System.getenv("PORT"));
        return 4567;
    }


}
