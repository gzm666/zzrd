package com.culture.zzrd.data;

/**
 * Created by guozm on 2018/10/9.
 */

public class Essay {
    private int id;// 文章id
    private String author_url;//作者头像
    private int uid;//作者id
    private int user_call;//作者等级
    private boolean isFollow;//是否关注
    private int type;//类型  1：普通 2：广告
    private String adUrl;//广告url
    private int num_like;//点赞数
    private boolean isLike;//是否点赞
    private int num_comment;//评论数
    private boolean isComment;//是否点赞
    private int num_share;//分享数
    private int num_reward;//打赏
    private boolean isShare;//是否分享
    private boolean isReport;//是否举报
    private boolean isCollection;//是否收藏
    private boolean isReward;//是否打赏
    private String content;//内容
    private int show_type;//显示类型

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUser_call() {
        return user_call;
    }

    public void setUser_call(int user_call) {
        this.user_call = user_call;
    }

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public int getNum_like() {
        return num_like;
    }

    public void setNum_like(int num_like) {
        this.num_like = num_like;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public int getNum_comment() {
        return num_comment;
    }

    public void setNum_comment(int num_comment) {
        this.num_comment = num_comment;
    }

    public boolean isComment() {
        return isComment;
    }

    public void setComment(boolean comment) {
        isComment = comment;
    }

    public int getNum_share() {
        return num_share;
    }

    public void setNum_share(int num_share) {
        this.num_share = num_share;
    }

    public boolean isShare() {
        return isShare;
    }

    public void setShare(boolean share) {
        isShare = share;
    }

    public boolean isReport() {
        return isReport;
    }

    public void setReport(boolean report) {
        isReport = report;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public void setCollection(boolean collection) {
        isCollection = collection;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getShow_type() {
        return show_type;
    }

    public void setShow_type(int show_type) {
        this.show_type = show_type;
    }

    public boolean isReward() {
        return isReward;
    }

    public void setReward(boolean reward) {
        isReward = reward;
    }

    public int getNum_reward() {
        return num_reward;
    }

    public void setNum_reward(int num_reward) {
        this.num_reward = num_reward;
    }
}
