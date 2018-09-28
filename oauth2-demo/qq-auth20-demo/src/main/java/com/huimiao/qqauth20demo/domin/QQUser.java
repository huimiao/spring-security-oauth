package com.huimiao.qqauth20demo.domin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QQUser {

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private String gender;

    /**
     * 省份
     */
    private String province;

    /**
     * 出生年
     */
    private String year;
}
