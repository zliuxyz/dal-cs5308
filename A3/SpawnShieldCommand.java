public class SpawnShieldCommand extends Command {
    public SpawnShieldCommand(Object receiver, String[] args) {
        super(receiver, args);
    }

    @Override
    public void Execute() {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        Square square = (Square) receiver;
        square.addTheShield();
        Square shield= new Shield(square, x, y);
        for (BoardComponent boardComponent: square.getChildren()) {
            if (boardComponent instanceof Asteroid) {
                ((Asteroid) boardComponent).addObserver((IAsteroidImpactObserver) shield);
            }
        }
        GameBoard.Instance().GetBoard().get(y).set(x, shield);
        System.out.println("Spawning shield at (" + x + "," +y +")");
    }
}
