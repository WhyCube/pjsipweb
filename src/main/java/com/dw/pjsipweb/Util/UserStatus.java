package com.dw.pjsipweb.Util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * Created by WHY
 * 2021/5/18 10:03
 */
@Getter
public enum UserStatus {
    OFFLine(0),OnLine(1),Busy(2);

    private int code;
    UserStatus(int i) {
        code=i;
    }

    public static UserStatus GetStatus(int i){
        for(UserStatus userStatus:values()){
            if(userStatus.getCode()==i)
                return userStatus;
        }
        return null;
    }
}
