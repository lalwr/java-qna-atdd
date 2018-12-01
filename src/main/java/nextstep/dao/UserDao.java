package nextstep.dao;

import java.util.List;

public class UserDao {

    private SqlSession session;

    public void addUser(UserDTO userDTO){
        int count = session.select("dao.user.selectUserCnt", userDTO);
        if(count > 0){
            throw new IllegalArgumentException();
        }
        session.insert("dao.user.addUser", userDTO);
    }

    public void updateUser(UserDTO userDTO){
        UserDTO user = session.select("dao.user.selectUser", userDTO);
        user.isOwner(userDTO.getId());

        UserDTO updateUser = new UserDTO(id, name);
        session.update("dao.user.updateUser", updateUser);
    }

}
