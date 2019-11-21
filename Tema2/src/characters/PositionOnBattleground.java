package characters;

public class PositionOnBattleground {
    private int row;
    private int column;

    //private char typeOfSquare;
    public PositionOnBattleground(final int row, final int column) {
        this.row = row;
        this.column = column;
        //this.typeOfSquare = typeOfSquare;
    }

        public int getRow () {
            return row;
        }

        public void setRow ( int row){
            this.row = row;
        }

        public int getColumn () {
            return column;
        }

        public void setColumn ( int column){
            this.column = column;
        }

        @Override
        public String toString () {
            return "PositionOfHero{" +
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }

}
