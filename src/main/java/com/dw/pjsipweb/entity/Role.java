package com.dw.pjsipweb.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author why
 * @since 2021-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * “主键”
     */
      private Integer id;

    /**
     * “用户名”
     */
    private String name;

    /**
     * 总指挥为0，其他任意
     */
    private Integer type;

    /**
     * 密码
     */
    private String password;

    /**
     * 域名，用来限定聊天室
     */
    private String domain;

    /**
     * 在线状态 0下线，1上线，2通话中
     */
    private Integer state;

    /**
     * 用户在局域网的地址
     */

    private String ip;


}
