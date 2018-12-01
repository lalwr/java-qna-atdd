package nextstep.dao;

import nextstep.CannotDeleteException;
import nextstep.UnAuthorizedException;
import nextstep.domain.*;
import support.domain.AbstractEntity;
import support.domain.UrlGeneratable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {

    private String id;

    private String name;

    private String writer;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public UserDTO(String id, String name) {
        if(id.length() > 5 || name.length() < 4){
            throw new IllegalArgumentException();
        }
    }

    public boolean isOwner(String loginUser) {
        return writer.equals(loginUser);
    }


}
