package com.bootdemo.lmy.demo.model;

public class Question {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_question.id
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_question.title
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_question.gmt_create
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_question.gmt_modified
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_question.tag
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    private String tag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_question.like_count
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_question.comment_count
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    private Integer commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_question.view_count
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    private Integer viewCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_question.creator
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    private Long creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_question.description
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_question.id
     *
     * @return the value of t_question.id
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_question.id
     *
     * @param id the value for t_question.id
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_question.title
     *
     * @return the value of t_question.title
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_question.title
     *
     * @param title the value for t_question.title
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_question.gmt_create
     *
     * @return the value of t_question.gmt_create
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_question.gmt_create
     *
     * @param gmtCreate the value for t_question.gmt_create
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_question.gmt_modified
     *
     * @return the value of t_question.gmt_modified
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_question.gmt_modified
     *
     * @param gmtModified the value for t_question.gmt_modified
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_question.tag
     *
     * @return the value of t_question.tag
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_question.tag
     *
     * @param tag the value for t_question.tag
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_question.like_count
     *
     * @return the value of t_question.like_count
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_question.like_count
     *
     * @param likeCount the value for t_question.like_count
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_question.comment_count
     *
     * @return the value of t_question.comment_count
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_question.comment_count
     *
     * @param commentCount the value for t_question.comment_count
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_question.view_count
     *
     * @return the value of t_question.view_count
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_question.view_count
     *
     * @param viewCount the value for t_question.view_count
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_question.creator
     *
     * @return the value of t_question.creator
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_question.creator
     *
     * @param creator the value for t_question.creator
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_question.description
     *
     * @return the value of t_question.description
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_question.description
     *
     * @param description the value for t_question.description
     *
     * @mbg.generated Thu Oct 24 21:01:16 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}