// Building is the leaf node for the composite pattern, Square's can have MULTIPLE Buildings
// Buildings cannot have children.
public class Building extends BoardComponent implements IAsteroidImpactObserver {
    private int buildingHealth;
    private boolean protectedByShield;

    public Building() {
        super();
        buildingHealth = 2;
    }

    @Override
    public void Operation() {
        // Buildings just stand there, they don't do anything.
    }

    @Override
    public void Add(BoardComponent child) {
        // Do nothing, I'm a leaf.
    }

    @Override
    public void Remove(BoardComponent child) {
        // Do nothing, I'm a leaf.
    }

    @Override
    public void update() {
        if (!protectedByShield && this.buildingHealth > 0) {
            this.buildingHealth--;
            if (this.buildingHealth == 0) {
                this.parent.Remove(this);
                GameBoard.Instance().DecrementBuildingCount();
            }
        }
    }

    public void setProtectedByShield(boolean value) {
        this.protectedByShield = value;
    }
}