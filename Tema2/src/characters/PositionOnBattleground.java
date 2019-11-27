package characters;

import battleground.Location;

import java.util.Objects;

public class PositionOnBattleground {
    private int row;
    private int column;
    private final Location loc;

    public PositionOnBattleground(final int row, final int column, final Location loc) {
        this.row = row;
        this.column = column;
        this.loc = loc;
    }

    public int getRow () {
        return row;
    }

    public void setRow ( int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn (int column){
        this.column = column;
    }

    public Location getLoc() {
        return loc;
    }

    @Override
    public String toString () {
        return " row: " + this.getRow() +
                " " + "column: " + this.getColumn();
    }

    public boolean equals(PositionOnBattleground o) {
        if (this == o) return true;
        if (o == null) return false;
        return getRow() == o.getRow() &&
                getColumn() == o.getColumn();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getColumn(), getLoc());
    }
}
