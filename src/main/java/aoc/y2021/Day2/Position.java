package aoc.y2021.Day2;

public class Position {

    private int horizontal = 0;
    private int vertical = 0;
    private int aim = 0;
    private final boolean aimEnabled;

    public Position(boolean aimEnabled) {
        this.aimEnabled = aimEnabled;
    }

    public void moveHorizontal(int horizontalMove){
        this.horizontal += horizontalMove;
        if (this.aimEnabled){
            this.vertical += this.aim * horizontalMove;
        }
    }

    public void moveUp(int movement){
        if (this.aimEnabled){
            this.aim -= movement;
            return;
        }
        this.vertical -= movement;
    }

    public void moveDown(int movement){
        if (this.aimEnabled){
            this.aim += movement;
            return;
        }
        this.vertical += movement;
    }

    public int result(){
        return this.vertical * this.horizontal;
    }


}
