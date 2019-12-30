package com.example.springBoot.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 用户信息表
 */
@Data
@Entity
public class UserInfo implements Serializable {
    @Id
    @SequenceGenerator(name="sequenceGenerator",sequenceName="SEQ_USER_INFO")
    @GeneratedValue(generator="sequenceGenerator",strategy=GenerationType.SEQUENCE)
    private Integer usid;
    @Column(unique =true)
    //帐号
    private String username;
    //名称（昵称或者真实姓名，不同系统不同定义）
    private String name;
    //密码;
    private String password;
    //加密密码的盐
    private String salt;
    //用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    private byte state;
    //立即从数据库中进行加载数据;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "usid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;// 一个用户具有多个角色

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
}
