package ohtu;

public class TennisGame {

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String player1;
    private String player2;

    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String player) {
        if (player == "player1") {
            scorePlayer1++;
        } else {
            scorePlayer2++;
        }
    }

    public String getScore() {
        if (scorePlayer1 == scorePlayer2) {
            return getTiedScore();
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            return getWinScore();
        } else {
            return getCurrentScore();
        }
    }

    private String getTiedScore() {
        switch (scorePlayer1) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private String getWinScore() {
        int result = scorePlayer1 - scorePlayer2;
        if (result == 1) {
            return "Advantage player1";
        } else if (result == -1) {
            return "Advantage player2";
        } else if (result >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getCurrentScore() {
        return getPlayerScore(scorePlayer1) + "-" + getPlayerScore(scorePlayer2);
    }
    
    private String getPlayerScore(int playerScore) {
        switch (playerScore) {
                case 0:
                    return "Love";
                case 1:
                    return "Fifteen";
                case 2:
                    return "Thirty";
                case 3:
                    return "Forty";
                default:
                    return "";
            }
    }
}
