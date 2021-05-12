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
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 聊天室域名
     */
      private String domain;


}
