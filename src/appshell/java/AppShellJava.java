package appshell.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ASUS
 */
public class AppShellJava {

    public static void main(String[] args) {

        Scanner escaner = new Scanner(System.in);
        boolean seguir = false;
        Persona per = new Persona();
        do {
            System.out.println("Escoja la opción correspondiente");
            System.out.println("1.Iniciar sesión");
            System.out.println("2.Registrarse ");
            String opRegistro = escaner.nextLine();
            boolean logueado = false;

            if (opRegistro.equalsIgnoreCase("1")) {
                System.out.println("\n\n");
                System.out.println("Desea continuar con el proceso \n digite la opción correspondiente \n 1. si,continuar con el proceso \n 2. no, devolver al menu");
                String respuesta = escaner.nextLine();
                if (respuesta.equalsIgnoreCase("1")) {
                    System.out.println("Ingrese usuario");
                    String user = escaner.nextLine();
                    System.out.println("Ingrese contraseña");
                    String contraseña = escaner.nextLine();
                    try {
                        String query = "https://codeqr-generate.herokuapp.com/api/auth/login";
                        JSONObject obj = new JSONObject();
                        obj.put("username", user);
                        obj.put("password", contraseña);
                        String json = obj.toString();

                        URL url = new URL(query);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setConnectTimeout(5000);
                        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                        conn.setDoOutput(true);
                        conn.setDoInput(true);
                        conn.setRequestMethod("POST");

                        OutputStream os = conn.getOutputStream();
                        os.write(json.getBytes("UTF-8"));
                        os.close();

                        // read the response
                        String respuestaApi = "";
                        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                        for (int i = in.read(); i != -1; i = in.read()) {
                            respuestaApi += (char) i;
                        }
                        System.out.println(respuestaApi);

                        JSONObject guardarUsuario = new JSONObject(respuestaApi);
                        String usuariodata = guardarUsuario.getJSONObject("usuario").toString();
                        JSONObject datos = new JSONObject(usuariodata);

                        String email = datos.getString("email");
                        String name = datos.getString("name");
                        String id = String.valueOf(datos.getInt("id_usuario"));
                        String username = datos.getString("username");

                        System.out.println(email + name + id + username);
                        
                        per.setEmail(email);
                        per.setId_usuario(id);
                        per.setName(name);
                        per.setUsername(username);

                        in.close();
                        conn.disconnect();
                        logueado=true;

                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    if (logueado) {
                        System.out.println("Ha iniciado sesión con exito\n  ");
                        seguir = false;
                        System.out.println("Escoja la opción correspondiente \n 1 Generar codigo QR colocando la url \n 2 Verificar historial de QR generados \n 3 cerrar sesión");
                        String menu2 = escaner.nextLine();
                        if(menu2.equalsIgnoreCase("1")){
                            System.out.println("Ingrese la url que desea convertir en QR");
                            String urlConvertir=escaner.nextLine();
                             try {
                        String query1= "https://codeqr-generate.herokuapp.com/api/code/";
                        JSONObject obj1 = new JSONObject();
                        obj1.put("url",urlConvertir );
                        obj1.put("user",per.getId_usuario());
                        String json = obj1.toString();

                        URL url1 = new URL(query1);
                        HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
                        conn.setConnectTimeout(5000);
                        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                        conn.setDoOutput(true);
                        conn.setDoInput(true);
                        conn.setRequestMethod("POST");

                        OutputStream os = conn.getOutputStream();
                        os.write(json.getBytes("UTF-8"));
                        os.close();

                        // read the response
                        String respuestaApi = "";
                        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                        for (int i = in.read(); i != -1; i = in.read()) {
                            respuestaApi += (char) i;
                        }
                        System.out.println(respuestaApi);

                        JSONObject guardarQr = new JSONObject(respuestaApi);
                        String mensajeApi = guardarQr.getString("msg");
                                 System.out.println("Se ha"+mensajeApi);
                        String guardarcodigoQr=guardarQr.getJSONObject("qr_code").toString();
                        JSONObject datos = new JSONObject(guardarcodigoQr);
                        
                        String gurl=datos.getString("url");
                        String gurl_code=datos.getString("url_code");
                        String guser=datos.getString("user");
                        String gtype=datos.getString("type");
                        String gdate=datos.getString("date");
                        
                        System.out.println(gurl);
                        System.out.println(gurl_code);
                        System.out.println(guser);
                        System.out.println(gtype);
                        System.out.println(gdate);
                        

                        in.close();
                        conn.disconnect();
                        logueado=true;

                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                        }
                        System.out.println("");
                    } else {
                        System.out.println("vertifique sus datos e intentelo nuevamente\n  ");
                         seguir = true;
                    }
                } else {
                    seguir = true;
                }

            } else if (opRegistro.equalsIgnoreCase("2")) {
                System.out.println("Desea continuar con el proceso \n digite la opción correspondiente \n 1. si,continuar con el proceso \n 2. no, devolver al menu");
                String respuesta = escaner.nextLine();
                if (respuesta.equalsIgnoreCase("1")) {
                    System.out.println("Ingrese correo");
                    String correo = escaner.nextLine();
                    System.out.println("Ingrese contraseña");
                    String contraseña = escaner.nextLine();
                    System.out.println("Se ha registrado con exito");
                    seguir = false;
                } else {
                    seguir = true;
                }
            } else {
                System.out.println("Digite una opción valida");
                seguir = true;
            }
        } while (seguir);

    }

}
