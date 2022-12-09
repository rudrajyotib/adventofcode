package aoc.y2022.Day9;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Day9Puzzle extends FileReaderEnabledPuzzleSolver {

    enum Direction {
        Up {
            @Override
            Position toPosition(Position present) {
                return new Position(present.x, present.y + 1);
            }
        },
        Down {
            @Override
            Position toPosition(Position present) {
                return new Position(present.x, present.y - 1);
            }
        },
        Left {
            @Override
            Position toPosition(Position present) {
                return new Position(present.x - 1, present.y);
            }
        },
        Right {
            @Override
            Position toPosition(Position present) {
                return new Position(present.x + 1, present.y);
            }
        },
        UpLeft {
            @Override
            Position toPosition(Position present) {
                return new Position(present.x - 1, present.y + 1);
            }
        },
        UpRight {
            @Override
            Position toPosition(Position present) {
                return new Position(present.x + 1, present.y + 1);
            }
        },
        DownLeft {
            @Override
            Position toPosition(Position present) {
                return new Position(present.x - 1, present.y - 1);
            }
        },
        DownRight {
            @Override
            Position toPosition(Position present) {
                return new Position(present.x + 1, present.y - 1);
            }
        }, Same {
            @Override
            Position toPosition(Position present) {
                return new Position(present.x, present.y);
            }
        };

        abstract Position toPosition(Position present);

    }

    static class Position {
        final int x;
        final int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        Position moveOneStep(Direction direction) {
            return direction.toPosition(this);
        }

        int difference(Position otherPosition) {
            return Math.max(Math.abs(otherPosition.x - this.x), Math.abs(otherPosition.y - this.y));
        }

        Direction findDirection(Position otherPosition) {
            if (this.x == otherPosition.x && this.y == otherPosition.y) {
                return Direction.Same;
            }
            if (otherPosition.x == this.x) {
                if (otherPosition.y > this.y) {
                    return Direction.Up;
                }
                return Direction.Down;
            }
            if (otherPosition.y == this.y) {
                if (otherPosition.x > this.x) {
                    return Direction.Right;
                }
                return Direction.Left;
            }
            if (otherPosition.x > this.x) {
                if (otherPosition.y > this.y) {
                    return Direction.UpRight;
                }
                return Direction.DownRight;
            } else {
                if (otherPosition.y > this.y) {
                    return Direction.UpLeft;
                }
                return Direction.DownLeft;
            }

        }

    }


    static class Rope {

        final List<Position> knots = new ArrayList<>(10);

        Rope() {
            for (int i = 0; i < 10; i++) {
                knots.add(new Position(0, 0));
            }
        }

        void move(Direction direction) {
            knots.set(0, knots.get(0).moveOneStep(direction));
            for (int i = 1; i <= 9; i++) {
                if (knots.get(i).difference(knots.get(i - 1)) > 1) {
                    Direction dir = knots.get(i).findDirection(knots.get(i - 1));
                    knots.set(i, knots.get(i).moveOneStep(dir));
                }
            }
        }

        Position tailPos() {
            return knots.get(9);
        }


    }

    Map<String, Direction> map = new HashMap<>() {{
        put("R", Direction.Right);
        put("L", Direction.Left);
        put("U", Direction.Up);
        put("D", Direction.Down);
    }};

    public Day9Puzzle(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public int solveP1() throws IOException {

        String line;

        Position head = new Position(0, 0);
        Position tail = new Position(0, 0);
        Set<Position> set = new HashSet<>();
        set.add(head);

        while ((line = getBufferedReader().readLine()) != null) {
            String[] split = line.split(" ");
            Direction direction = map.get(split[0]);
            int steps = Integer.parseInt(split[1]);

            for (int i = 1; i <= steps; i++) {
                head = direction.toPosition(head);
                if (head.difference(tail) > 1) {
                    tail = tail.moveOneStep(tail.findDirection(head));
                }
                set.add(tail);
            }
        }
        return set.size();
    }

    public int solveP2() throws IOException {

        String line;
        Rope rope = new Rope();
        Set<Position> set = new HashSet<>();
        set.add(rope.tailPos());

        while ((line = getBufferedReader().readLine()) != null) {
            String[] split = line.split(" ");
            Direction direction = map.get(split[0]);
            int steps = Integer.parseInt(split[1]);

            for (int i = 1; i <= steps; i++) {
                rope.move(direction);
                set.add(rope.tailPos());
            }
        }

        return set.size();
    }
}
