package com.huimiao.weiboauth20demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WeiboToken {

    /**
     * access_token : ACCESS_TOKEN
     * expires_in : 1234
     * remind_in : 798114
     * uid : 12341234
     */

    private String access_token;
    private int expires_in;
    private String remind_in;
    private String uid;
}
