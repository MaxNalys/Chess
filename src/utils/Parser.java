package utils;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static final Map<Character, Integer> algebraicChessNotationMap;
    public static final Map<Character,Integer>algebraicNumericChessNotationMap;

    static {
        algebraicChessNotationMap = new HashMap<>();
        algebraicChessNotationMap.put('a', 0);
        algebraicChessNotationMap.put('b', 1);
        algebraicChessNotationMap.put('c', 2);
        algebraicChessNotationMap.put('d', 3);
        algebraicChessNotationMap.put('e', 4);
        algebraicChessNotationMap.put('f', 5);
        algebraicChessNotationMap.put('g', 6);
        algebraicChessNotationMap.put('h', 7);
    }
    static {
        algebraicNumericChessNotationMap = new HashMap<>();
        algebraicNumericChessNotationMap.put('8', 0);
        algebraicNumericChessNotationMap.put('7', 1);
        algebraicNumericChessNotationMap.put('6', 2);
        algebraicNumericChessNotationMap.put('5', 3);
        algebraicNumericChessNotationMap.put('4', 4);
        algebraicNumericChessNotationMap.put('3', 5);
        algebraicNumericChessNotationMap.put('2', 6);
        algebraicNumericChessNotationMap.put('1', 7);
    }

    public static Coordinates[] parseInput(String move) {
        Coordinates[] arrayWithCoordinates=new Coordinates[2];
        arrayWithCoordinates[0] = convertFistPartOfMove(move);
        arrayWithCoordinates[1] = convertSecondPartOfMove(move);
        return arrayWithCoordinates;
    }


    public static Coordinates convertFistPartOfMove(String move) {
        int x = algebraicChessNotationMap.get(move.charAt(0));
        int y = algebraicNumericChessNotationMap.get(move.charAt(1));
        return new Coordinates(x, y);
    }

    public static Coordinates convertSecondPartOfMove(String move) {
        int x = algebraicChessNotationMap.get(move.charAt(3));
        int y = algebraicNumericChessNotationMap.get(move.charAt(4));
        return new Coordinates(x, y);
    }
}
