package aoc.y2021.Day2;

public enum Command {

    forward{
        @Override
        public void changePosition(Position position, int movement) {
            position.moveHorizontal(movement);
        }
    },
    down{
        @Override
        public void changePosition(Position position, int movement) {
            position.moveDown(movement);
        }
    },
    up{
        @Override
        public void changePosition(Position position, int movement) {
            position.moveUp(movement);
        }
    };

    public abstract void changePosition(Position position, int movement);


}
