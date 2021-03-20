package chess.controller;

import chess.domain.Command;
import chess.domain.Game;
import chess.view.InputView;
import chess.view.OutputView;

public class ChessController {

    public void run() {
        try {
            executeGame();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
        }
    }

    private void executeGame() {
        OutputView.printGuideMessage();
        if (Command.isStart(InputView.receiveInput())) {
            playGame();
        }
    }

    private void playGame() {
        Game game = new Game();
        while (game.isPlaying()) {
            OutputView.printBoard(game.getBoard());
            OutputView.printTurn(game.getCurrentColor());
            executeCommand(game);
        }
        OutputView.printFinishedMessage();
    }

    private void executeCommand(Game game) {
        try {
            game.command(InputView.receiveInput());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            executeCommand(game);
        }
    }
}
