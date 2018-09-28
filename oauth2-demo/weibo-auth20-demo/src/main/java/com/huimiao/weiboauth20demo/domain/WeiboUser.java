package com.huimiao.weiboauth20demo.domain;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WeiboUser {


    /**
     * id : 2178114927
     * idstr : 2178114927
     * class : 1
     * screen_name : 新琅微波炉
     * name : 新琅微波炉
     * province : 100
     * city : 1000
     * location : 其他
     * description :
     * url :
     * profile_image_url : http://tva4.sinaimg.cn/crop.0.0.180.180.50/81d3656fjw1e8qgp5bmzyj2050050aa8.jpg
     * cover_image_phone : http://ww1.sinaimg.cn/crop.0.0.640.640.640/549d0121tw1egm1kjly3jj20hs0hsq4f.jpg
     * profile_url : u/2178114927
     * domain :
     * weihao :
     * gender : m
     * followers_count : 46
     * friends_count : 98
     * pagefriends_count : 1
     * statuses_count : 25
     * video_status_count : 0
     * favourites_count : 22
     * created_at : Tue Jun 14 10:19:04 +0800 2011
     * following : false
     * allow_all_act_msg : false
     * geo_enabled : true
     * verified : false
     * verified_type : -1
     * remark :
     * insecurity : {"sexual_content":false}
     * status : {"created_at":"Thu Apr 05 09:20:46 +0800 2018","id":4225374495612537,"idstr":"4225374495612537","mid":"4225374495612537","can_edit":false,"text":"转发微博","source_allowclick":0,"source_type":1,"source":"<a href=\"http://app.weibo.com/t/feed/47tA0S\" rel=\"nofollow\">OnePlus 3T<\/a>","favorited":false,"truncated":false,"in_reply_to_status_id":"","in_reply_to_user_id":"","in_reply_to_screen_name":"","pic_urls":[],"geo":null,"is_paid":false,"mblog_vip_type":0,"annotations":[{"client_mblogid":"7f3a480f-962f-466f-afe9-ee5fafc20cfa"},{"mapi_request":true}],"reposts_count":0,"comments_count":0,"attitudes_count":0,"pending_approval_count":0,"isLongText":false,"hide_flag":0,"mlevel":0,"visible":{"type":0,"list_id":0},"biz_feature":0,"hasActionTypeCard":0,"darwin_tags":[],"hot_weibo_tags":[],"text_tag_tips":[],"mblogtype":0,"rid":"0","userType":0,"more_info_type":0,"positive_recom_flag":0,"content_auth":0,"gif_ids":"","is_show_bulletin":2,"comment_manage_info":{"comment_permission_type":-1,"approval_comment_type":0}}
     * ptype : 0
     * allow_all_comment : true
     * avatar_large : http://tva4.sinaimg.cn/crop.0.0.180.180.180/81d3656fjw1e8qgp5bmzyj2050050aa8.jpg
     * avatar_hd : http://tva4.sinaimg.cn/crop.0.0.180.180.1024/81d3656fjw1e8qgp5bmzyj2050050aa8.jpg
     * verified_reason :
     * verified_trade :
     * verified_reason_url :
     * verified_source :
     * verified_source_url :
     * follow_me : false
     * like : false
     * like_me : false
     * online_status : 0
     * bi_followers_count : 5
     * lang : zh-cn
     * star : 0
     * mbtype : 0
     * mbrank : 0
     * block_word : 0
     * block_app : 0
     * credit_score : 80
     * user_ability : 0
     * urank : 24
     * story_read_state : -1
     * vclub_member : 0
     */

    private long id;
    private String idstr;
    private int classX;
    private String screen_name;
    private String name;
    private String province;
    private String city;
    private String location;
    private String description;
    private String url;
    private String profile_image_url;
    private String cover_image_phone;
    private String profile_url;
    private String domain;
    private String weihao;
    private String gender;
    private int followers_count;
    private int friends_count;
    private int pagefriends_count;
    private int statuses_count;
    private int video_status_count;
    private int favourites_count;
    private String created_at;
    private boolean following;
    private boolean allow_all_act_msg;
    private boolean geo_enabled;
    private boolean verified;
    private int verified_type;
    private String remark;
    private InsecurityBean insecurity;
    private StatusBean status;
    private int ptype;
    private boolean allow_all_comment;
    private String avatar_large;
    private String avatar_hd;
    private String verified_reason;
    private String verified_trade;
    private String verified_reason_url;
    private String verified_source;
    private String verified_source_url;
    private boolean follow_me;
    private boolean like;
    private boolean like_me;
    private int online_status;
    private int bi_followers_count;
    private String lang;
    private int star;
    private int mbtype;
    private int mbrank;
    private int block_word;
    private int block_app;
    private int credit_score;
    private int user_ability;
    private int urank;
    private int story_read_state;
    private int vclub_member;

    @NoArgsConstructor
    @Data
    public static class InsecurityBean {

        /**
         * sexual_content : false
         */

        private boolean sexual_content;
    }

    @NoArgsConstructor
    @Data
    public static class StatusBean {

        /**
         * created_at : Thu Apr 05 09:20:46 +0800 2018
         * id : 4225374495612537
         * idstr : 4225374495612537
         * mid : 4225374495612537
         * can_edit : false
         * text : 转发微博
         * source_allowclick : 0
         * source_type : 1
         * source : <a href="http://app.weibo.com/t/feed/47tA0S" rel="nofollow">OnePlus 3T</a>
         * favorited : false
         * truncated : false
         * in_reply_to_status_id :
         * in_reply_to_user_id :
         * in_reply_to_screen_name :
         * pic_urls : []
         * geo : null
         * is_paid : false
         * mblog_vip_type : 0
         * annotations : [{"client_mblogid":"7f3a480f-962f-466f-afe9-ee5fafc20cfa"},{"mapi_request":true}]
         * reposts_count : 0
         * comments_count : 0
         * attitudes_count : 0
         * pending_approval_count : 0
         * isLongText : false
         * hide_flag : 0
         * mlevel : 0
         * visible : {"type":0,"list_id":0}
         * biz_feature : 0
         * hasActionTypeCard : 0
         * darwin_tags : []
         * hot_weibo_tags : []
         * text_tag_tips : []
         * mblogtype : 0
         * rid : 0
         * userType : 0
         * more_info_type : 0
         * positive_recom_flag : 0
         * content_auth : 0
         * gif_ids :
         * is_show_bulletin : 2
         * comment_manage_info : {"comment_permission_type":-1,"approval_comment_type":0}
         */

        private String created_at;
        private long id;
        private String idstr;
        private String mid;
        private boolean can_edit;
        private String text;
        private int source_allowclick;
        private int source_type;
        private String source;
        private boolean favorited;
        private boolean truncated;
        private String in_reply_to_status_id;
        private String in_reply_to_user_id;
        private String in_reply_to_screen_name;
        private Object geo;
        private boolean is_paid;
        private int mblog_vip_type;
        private int reposts_count;
        private int comments_count;
        private int attitudes_count;
        private int pending_approval_count;
        private boolean isLongText;
        private int hide_flag;
        private int mlevel;
        private VisibleBean visible;
        private int biz_feature;
        private int hasActionTypeCard;
        private int mblogtype;
        private String rid;
        private int userType;
        private int more_info_type;
        private int positive_recom_flag;
        private int content_auth;
        private String gif_ids;
        private int is_show_bulletin;
        private CommentManageInfoBean comment_manage_info;
        private List<?> pic_urls;
        private List<AnnotationsBean> annotations;
        private List<?> darwin_tags;
        private List<?> hot_weibo_tags;
        private List<?> text_tag_tips;

        @NoArgsConstructor
        @Data
        public static class VisibleBean {

            /**
             * type : 0
             * list_id : 0
             */

            private int type;
            private int list_id;
        }

        @NoArgsConstructor
        @Data
        public static class CommentManageInfoBean {

            /**
             * comment_permission_type : -1
             * approval_comment_type : 0
             */

            private int comment_permission_type;
            private int approval_comment_type;
        }

        @NoArgsConstructor
        @Data
        public static class AnnotationsBean {

            /**
             * client_mblogid : 7f3a480f-962f-466f-afe9-ee5fafc20cfa
             * mapi_request : true
             */

            private String client_mblogid;
            private boolean mapi_request;
        }
    }
}
