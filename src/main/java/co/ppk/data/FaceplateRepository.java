package co.ppk.data;

import co.ppk.domain.Faceplate;
import co.ppk.dto.FaceplateDto;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class FaceplateRepository {

    private final DataSource ds;

    public FaceplateRepository() {

        this.ds = DataSourceSingleton.getInstance();
    }


    public String registerFaceplate(FaceplateDto faceplate) {
        QueryRunner run = new QueryRunner(ds);
//        Timestamp now = Timestamp.from(Instant.now());

        String faceplateId = UUID.randomUUID().toString();
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            try {
                String insert = "INSERT INTO ppk_customers.faceplates" +
                        "(id, " +
                        "faceplate, " +
                        "customerid)  " +
                         "VALUES " +
                        "('" + faceplateId + "', " +
                        "'" + faceplate.getFaceplate() + "', " +
                        "'" + faceplate.getCustomerid() + "');";
                run.insert(conn, insert, new ScalarHandler<>());
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e);
            } finally {
                DbUtils.close(conn);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return faceplateId;
    }

    public Optional<Faceplate> getFaceplateByFaceplate(String faceplateNumber) {
        QueryRunner run = new QueryRunner(ds);
        try {
            String query = "SELECT * FROM ppk_customers.faceplates WHERE faceplate = '" + faceplateNumber + "';";
            Optional<Faceplate> faceplate = run.query(query,
                    rs -> {
                        if (!rs.next()) {
                            Optional<Object> empty = Optional.empty();
                            return Optional.empty();
                        }
                        rs.last();
                        return Optional.ofNullable(new Faceplate.Builder()
                                .setId(rs.getString(1))
                                .setFaceplate(rs.getString(2))
                                .setCustomerid(rs.getString(3))
                                .setCreateDate(rs.getString(4))
                                .setUpdateDate(rs.getString(5))
                                .build());
                    });
            return faceplate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
