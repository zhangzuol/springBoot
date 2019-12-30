package com.example.springBoot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MFirm {

    /** 交易商ID */
    @Id
    private String firmId;

    /** 交易商名称 */
    @Column
    private String name;

    /** 交易商全称 */
    @Column
    private String fullName;

    /** 交易商类型 */
    @Column
    private Integer type;

    /** 联系人 */
    @Column
    private String contactMan;


    /**
     * 交易商代码
     * @return
     */
    public String getFirmId() {
        return firmId;
    }

    /**
     * 交易商代码
     * @param firmId
     */
    public void setFirmId(String firmId) {
        this.firmId = firmId;
    }

    /**
     * 交易商名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 交易商名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 交易商全称
     * @return
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 交易商全称
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 交易商类型
     * @return
     */
    public Integer getType() {
        return type;
    }

    /**
     * 交易商类型
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 联系人
     * @return
     */
    public String getContactMan() {
        return contactMan;
    }

    /**
     * 联系人
     * @param contactMan
     */
    public void setContactMan(String contactMan) {
        this.contactMan = contactMan;
    }

    @Override
    public String toString() {
        return "MFirm{" +
                "firmId='" + firmId + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", type=" + type +
                ", contactMan='" + contactMan + '\'' +
                '}';
    }
}
