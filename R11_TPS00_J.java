// Incorrect Code
class Helper {
  public void handle(Socket socket) {
    // ...
  }
}
 
final class RequestHandler {
  private final Helper helper = new Helper();
  private final ServerSocket server;
 
  private RequestHandler(int port) throws IOException {
    server = new ServerSocket(port);
  }
 
  public static RequestHandler newInstance() throws IOException {
    return new RequestHandler(0); // Selects next available port
  }
 
  public void handleRequest() {
    new Thread(new Runnable() {
        public void run() {
          try {
            helper.handle(server.accept());
          } catch (IOException e) {
            // Forward to handler
          }
        }
    }).start();
  }
 
}

//Correct Code

// class Helper remains unchanged
 
final class RequestHandler {
  private final Helper helper = new Helper();
  private final ServerSocket server;
  private final ExecutorService exec;
 
  private RequestHandler(int port, int poolSize) throws IOException {  //Pool size is usecd to limit the number of concurrently executed threads
    server = new ServerSocket(port);
    exec = Executors.newFixedThreadPool(poolSize);
  }
 
  public static RequestHandler newInstance(int poolSize)
                                           throws IOException {
    return new RequestHandler(0, poolSize);
  }
 
  public void handleRequest() {
    Future<?> future = exec.submit(new Runnable() {
        @Override public void run() {
          try {
            helper.handle(server.accept());
          } catch (IOException e) {
            // Forward to handler
          }
        }
    });
  }
  // ... Other methods such as shutting down the thread pool
  // and task cancellation ...
}