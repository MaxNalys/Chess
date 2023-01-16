package utils;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static final Map<Character, Integer> algebraicChessNotationMap;

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

    public static Coordinates parseInput(String move) {
        int x = algebraicChessNotationMap.get(move.charAt(0));
        int y = Character.getNumericValue(move.charAt(1)) - 1;
        return new Coordinates(x, y);
    }
}
