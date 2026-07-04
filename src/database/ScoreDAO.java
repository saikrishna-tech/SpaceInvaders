package database;

import model.PlayerScore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ScoreDAO {

    public void saveScore(PlayerScore playerScore) throws SQLException {

        String sql =
                "INSERT INTO player_scores (player_name, score) VALUES (?, ?)";

        try (
                Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, playerScore.getPlayerName());
            statement.setInt(2, playerScore.getScore());

            int rowsAffected = statement.executeUpdate();

            System.out.println(rowsAffected + " row inserted successfully.");

        }
    }
}