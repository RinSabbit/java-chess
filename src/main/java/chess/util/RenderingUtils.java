package chess.util;

import chess.domain.Board;
import chess.domain.Column;
import chess.domain.Position;
import chess.domain.Row;
import chess.domain.piece.Piece;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RenderingUtils {

    public static String renderBoard(Board board) {
        return Stream.of(Row.values())
                .map(index -> renderRow(board, index))
                .collect(Collectors.joining("\n"));
    }

    private static String renderRow(Board board, Row row) {
        return Stream.of(Column.values())
                .map(column -> Position.of(column, row))
                .map(position -> renderPosition(board, position))
                .collect(Collectors.joining());
    }

    private static String renderPosition(Board board, Position position) {
        return board.findPieceBy(position)
                .map(Piece::getName)
                .orElse(".")
                ;
    }
}
