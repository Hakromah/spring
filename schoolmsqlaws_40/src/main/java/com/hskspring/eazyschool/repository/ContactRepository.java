package com.hskspring.eazyschool.repository;

import com.hskspring.eazyschool.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer> {
List<Contact> findByStatus(String status);
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public ContactRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    // Save All messages
//    public int saveContactMsg(Contact contact) {
//        String sql = "insert into contact_msg (name,mobile_num,email,subject,message,status," +
//                "created_at,created_by) values (?,?,?,?,?,?,?,?)";
//        return jdbcTemplate.update(sql, contact.getName(), contact.getMobileNum(),
//                contact.getEmail(), contact.getSubject(), contact.getMessage(),
//                contact.getStatus(), contact.getCreatedAt(), contact.getCreatedBy());
//    }
//
//    // Get all messages
//    public List<Contact> findMsgsWithStatus(String status) {
//        String sql = "select * from contact_msg where status = ?";
//        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setString(1, status);
//            }
//        }, new ContactRowMapper());
//    }
//
//    //Update messages
//    public int updateMsgStatus(int contactId, String status, String updatedBy) {
//        String sql = "update contact_msg set status = ?, updated_by = ?, updated_at = ? where contact_id = ?";
//
//        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setString(1, status);
//                preparedStatement.setString(2, updatedBy);
//                preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
//                preparedStatement.setInt(4, contactId);
//            }
//        });
//    }
}
