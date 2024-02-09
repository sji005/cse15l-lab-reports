
# Lab Report 2
## Part 1
* The main method for the ```ChatServer``` class and ```handleRequests``` for the URL handler
* the main method takes in an ```String[] args``` during compile, and ```handleRequests``` 
takes in the current ```URLhandler```. 
* ```args``` from the main function never change, and the ```url``` changes based on user
* the field I have for this class is ```ArrayList<String> printable``` that stores all the messages, printable adds the current chat message
inputs 
![Image](ss1.png)
* like for the first screen shot, the main methods continues to run
* main takes in ```String[] args``` during compile and ```handleRequests``` fire now when I make a request with my url
* the field ```ArrayList<String> printable``` changes again now that I send a second request, it stores it as another string object
![Image](ss2.png)
This is my code for chatServer
```
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
```
## Part 2
* ``C:\Users\jisiy\.ssh\id_rsa`` is the abosolute path of my private key to log into the system
* ``/home/linux/ieng6/oce/7g/siji/.ssh/authorized_keys`` is the absolute path of my public key to log into the system on the ieng6 side
* There was a problem with ssh and rsa key interaction when login into the ucsd computer, not able to complete, was told that it will be addressed later.

![Image](ss4.png)
![Image](ss5.png)
![image](https://github.com/sji005/cse15l-lab-reports/assets/148498146/486ccc35-6e9f-4263-a923-931d13b7e095)

## Part 3
* I thought how setting up a webserver in java was interesting, since I have only been exposed to webdev in java script before.
