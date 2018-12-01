package nextstep.dao;

import java.util.List;

public class UserDao {

    private SqlSession session;

    // 중복 아이디가 있는지 검사
    public void addUser(UserDTO userDTO){
        int count = session.select("dao.user.selectUserCnt", userDTO);
        if(count > 0){
            throw new IllegalArgumentException();
        }
        session.insert("dao.user.addUser", userDTO);
    }

    //글쓴이인 경우 수정
    public void updateUser(UserDTO userDTO){
        UserDTO user = session.select("dao.user.selectUser", userDTO);
        user.isOwner(userDTO.getId());

        session.update("dao.user.updateUser", userDTO);
    }

}
