package com.dw.pjsipweb.entity;

import java.time.LocalDateTime;
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
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 音频id
     */
      private Integer id;

    /**
     * 音频文件
     */
    private String filename;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 存储路径
     */
    private String path;

    /**
     * 所在聊天室
     */
    private String domain;


}
