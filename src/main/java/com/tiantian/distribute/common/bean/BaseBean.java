package com.tiantian.distribute.common.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 *
 * @author luozejun
 *
 */
public class BaseBean {
    private Integer id;
    private Long status;
	private Date createTime;
	private Date updateTime;
    private String commnets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCommnets() {
        return commnets;
    }

    public void setCommnets(String commnets) {
        this.commnets = commnets;
    }
}
