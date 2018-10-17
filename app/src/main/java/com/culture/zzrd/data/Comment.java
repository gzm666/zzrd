package com.culture.zzrd.data;

import java.util.List;

/**
 * Created by guozm on 2018/10/16.
 */

public class Comment {
    private int id;
    private String author_url;
    private String author_name;
    private String comment_content;
    private List<Reply> replys;
    private boolean hasReply;
    private boolean doLike;
    private int num_like;

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

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public List<Reply> getReplys() {
        return replys;
    }

    public void setReplys(List<Reply> replys) {
        this.replys = replys;
    }

    public boolean isHasReply() {
        return hasReply;
    }

    public void setHasReply(boolean hasReply) {
        this.hasReply = hasReply;
    }

    public boolean isDoLike() {
        return doLike;
    }

    public void setDoLike(boolean doLike) {
        this.doLike = doLike;
    }

    public int getNum_like() {
        return num_like;
    }

    public void setNum_like(int num_like) {
        this.num_like = num_like;
    }

    class Reply {
        private int reply_id;
        private String reply_url;
        private String reply_name;
        private String reply_content;
        private boolean reply_like;
        private int reply_numLike;

        public int getReply_id() {
            return reply_id;
        }

        public void setReply_id(int reply_id) {
            this.reply_id = reply_id;
        }

        public String getReply_url() {
            return reply_url;
        }

        public void setReply_url(String reply_url) {
            this.reply_url = reply_url;
        }

        public String getReply_name() {
            return reply_name;
        }

        public void setReply_name(String reply_name) {
            this.reply_name = reply_name;
        }

        public String getReply_content() {
            return reply_content;
        }

        public void setReply_content(String reply_content) {
            this.reply_content = reply_content;
        }

        public boolean isReply_like() {
            return reply_like;
        }

        public void setReply_like(boolean reply_like) {
            this.reply_like = reply_like;
        }

        public int getReply_numLike() {
            return reply_numLike;
        }

        public void setReply_numLike(int reply_numLike) {
            this.reply_numLike = reply_numLike;
        }
    }
}
