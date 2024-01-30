package whitera.xogamenative.contract.enums;

public enum EventEnum {
    GAME_START("gl hf"),
    PLAYER_X_TURN("X player turn."),
    PLAYER_O_TURN("O player turn."),
    CELL_IS_ALREADY_OCCUPIED("Cell is already occupied!"),
    PLAYER_X_WIN("PLAYER X WIN!"),
    PLAYER_O_WIN("PLAYER O WIN!"),
    GAME_END("gg ez");

    final String message;

    EventEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
