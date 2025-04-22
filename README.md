# Simple Java Socket Chat

This is a basic console-based chat application using Java Sockets. It includes a server (`SocketServer.java`) and a single client (`Client.java`). The client can send messages to the server, and the server responds with `"Message Received!"`.

## How to Run

1. **Start the Server:**

   ```bash
   javac SocketServer.java
   java SocketServer
2. Start the Client (in a new terminal):

   ```bash
   javac Client.java
   java Client
3. Start sending messages from the client, and the server will receive them.

## How It Works

- Client connects to the server.
- You can send messages.
- Server replies with "Message Received!"
- Type `exit` to stop the chat.
