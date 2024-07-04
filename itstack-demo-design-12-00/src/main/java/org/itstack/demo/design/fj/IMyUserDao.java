package org.itstack.demo.design.fj;

import org.itstack.demo.design.agent.Select;
import org.itstack.demo.design.fj.agent.Update;

public interface IMyUserDao {
    @Update("update userName from user where id = #{uId}")
    String updateUserInfo(String uId);
}
