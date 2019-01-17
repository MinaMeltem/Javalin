package my_exercise;

import io.javalin.Context;
import io.javalin.Javalin;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(5000);

        app.get("/hello", ctx ->  ctx.result("Hello World"));
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/contact-data", ctx -> sendFileContent(ctx));

        app.post("/contact-data-save", ctx -> {
            ctx.result(


                    "First Name: "    + ctx.req.getParameter("firstname") + "\n"
                    + "Last Name: "   + ctx.req.getParameter("lastname") + "\n"
                    + "Age: "           + ctx.req.getParameter("Age") + "\n"
                    + "Date of Birth: " + ctx.req.getParameter("dob") + "\n"
                    + "Address: "     + ctx.req.getParameter("address") + "\n");

        });
    }

//    METHOD1 : Using BufferRead

//    public static void sendFileContent(Context ctx) throws IOException {
//        String path = "C:\\Users\\MEL\\Desktop\\courses2018Fall\\JavaApplication\\PraveenExercises\\hello\\src\\main\\resources\\collect-data.html";
//        String content = "";
//        try {
//            BufferedReader in = new BufferedReader(new FileReader(path));
//            String str;
//            while ((str = in.readLine()) != null) {
//                content += str;
//            }
//            in.close();
//        } catch (IOException e) {
//        }
//        ctx.html(content);
//    }


    //METHOD2:  Using readAllByte
    public static void sendFileContent(Context ctx) throws IOException {
        String path = "C:\\Users\\MEL\\Desktop\\courses2018Fall\\JavaApplication\\PraveenExercises\\hello\\src\\main\\resources\\collect-data.html";
        byte[] byteString = Files.readAllBytes(Paths.get(path));
        String content = new String(byteString, StandardCharsets.UTF_8);
        ctx.html(content);
    }



}
