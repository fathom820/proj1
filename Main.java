/**
 * Author: Michael Frank
 */
class Main {
  public static void main(String[] args) {
    ClientServer clientServer = new ClientServer();

    clientServer.setupServer();
    clientServer.setupClient();
  }
}