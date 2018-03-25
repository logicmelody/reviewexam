package com.linecorp.reviewexam.rockpaperscissors;

/**
 * A model class which represents one of rock-paper-scissors hands.
 */
public class Hand implements Comparable<Hand> {

    public static final class Result {
        public static final int WIN = 1;
        public static final int LOSE = -1;
        public static final int DRAW = 0;
    }

    public static final Hand ROCK = new Hand(0);
    public static final Hand PAPER = new Hand(1);
    public static final Hand SCISSORS = new Hand(2);

    private static final Hand[] HANDS = {
            ROCK, PAPER, SCISSORS
    };

    public static Hand fromInt(int i) {
        return HANDS[i % HANDS.length];
    }

    private final int handValue;

    private Hand(int handValue) {
        this.handValue = handValue;
    }

    @Override
    public String toString() {
        return this == ROCK ? "ROCK" : (this == PAPER ? "PAPER" : "SCISSORS");
    }

    @Override
    public int compareTo(Hand another) {
        if (handValue == another.handValue) {
            return Result.DRAW;
        }

        if (this == ROCK) {
            return another == SCISSORS ? Result.WIN : Result.LOSE;

        } else if (this == SCISSORS) {
            return another == PAPER ? Result.WIN : Result.LOSE;

        } else {
            return another == ROCK ? Result.WIN : Result.LOSE;
        }
    }
}
