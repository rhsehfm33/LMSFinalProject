package kr.co.fastcampus.web.entity;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Member {
    private int id;
    @NonNull private String username;
    @NonNull private String password;

    public Member(ResultSet resultSet) {
        try{
            this.id = resultSet.getInt("id");
            this.username = resultSet.getString("username");
            this.password = resultSet.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
