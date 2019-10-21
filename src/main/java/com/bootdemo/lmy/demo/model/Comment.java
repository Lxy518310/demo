package com.bootdemo.lmy.demo.model;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.id
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.parent_id
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.content
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.gmt_create
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.gmt_modified
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.type
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.like_count
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.commentator
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    private String commentator;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.id
     *
     * @return the value of t_comment.id
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.id
     *
     * @param id the value for t_comment.id
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.parent_id
     *
     * @return the value of t_comment.parent_id
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.parent_id
     *
     * @param parentId the value for t_comment.parent_id
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.content
     *
     * @return the value of t_comment.content
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.content
     *
     * @param content the value for t_comment.content
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.gmt_create
     *
     * @return the value of t_comment.gmt_create
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.gmt_create
     *
     * @param gmtCreate the value for t_comment.gmt_create
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.gmt_modified
     *
     * @return the value of t_comment.gmt_modified
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.gmt_modified
     *
     * @param gmtModified the value for t_comment.gmt_modified
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.type
     *
     * @return the value of t_comment.type
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.type
     *
     * @param type the value for t_comment.type
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.like_count
     *
     * @return the value of t_comment.like_count
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.like_count
     *
     * @param likeCount the value for t_comment.like_count
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.commentator
     *
     * @return the value of t_comment.commentator
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public String getCommentator() {
        return commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.commentator
     *
     * @param commentator the value for t_comment.commentator
     *
     * @mbg.generated Mon Oct 21 23:16:49 CST 2019
     */
    public void setCommentator(String commentator) {
        this.commentator = commentator == null ? null : commentator.trim();
    }
}