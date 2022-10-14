
public class Server
{


	private final int maxConnections = 2; // cannot go beyond 2 connections
	private int numConnections = 0;
	public static void main(String[] args)
	{
		ClientServer clientServer = new ClientServer();
		clientServer.setupServer();

		TicTacToe game = new TicTacToe();
//		int player = 0;
//		game.resetGame();
//		game.setPlayer(player);
//		game.makeMove(1, 1);
//		player = 1;
//		game.setPlayer(player);
//		game.makeMove(0, 0);
//		System.out.print(game);
		
	}

}
