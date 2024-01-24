import java.io.IOException;
import java.net.URI;
import java.util.*;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;
    ArrayList<String> printable = new ArrayList<String>();
    public String handleRequest(URI url) {
        if (url.getPath().contains("/add-message")) {
            String[] parts = url.getQuery().split("&");
            String[] para1 = parts[0].split("=");
            String[] para2 = parts[1].split("=");
                
            if (para1[0].equals("s") && para2[0].equals("user")) {
                printable.add(para2[1] + ": " + para1[1]); 
                String prints = "";
                for(int i = 0; i<printable.size(); i++){
                    prints += printable.get(i) + "\n";
                }
                return prints;
            }
        }
            return "404 Not Found!";
        }
    }

class ChatServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
