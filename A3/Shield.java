public class Shield extends Square implements IAsteroidImpactObserver {
    private Square decoratedSquare;
    private int health;
    private int x;
    private int y;

    public Shield(Square decoratedSquare, int x, int y) {
        this.decoratedSquare = decoratedSquare;
        this.health = 2;
        this.x = x;
        this.y = y;
    }

    private void removeDecorator() {
        this.decoratedSquare.removeTheShield();
        GameBoard.Instance().GetBoard().get(y).set(x, this.decoratedSquare);
    }

    @Override
    public void update() {
        if (this.health > 0) {
            this.health--;
            if (this.health == 0) {
                removeDecorator();
            }
        }
    }

    @Override
    public void Operation() {
        this.decoratedSquare.Operation();
    }

    @Override
    public void Add(BoardComponent child) {
        if (child instanceof Building) {
            ((Building) child).setProtectedByShield(true);
        }
        this.decoratedSquare.Add(child);
    }

    @Override
    public void Remove(BoardComponent child) {
        this.decoratedSquare.Operation();
    }
}
