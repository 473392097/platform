package com.sudao.cloud.module.idea.vo.req.biz;

import org.springframework.context.annotation.Description;

/**
 * platform
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2017/10/26
 * @time: 下午2:29
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/26 下午2:29
 */
public class UserRegistryReq {
    /******* Fields Area *******/

    /**
     * 头像
     */
    private String image;
    /**
     * 邮件
     */
    private String email;
    /**
     * 昵称
     */
    private String nikeName;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别 0保密, 1男, 2女
     */
    private Integer gender;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 职业
     */
    private String profession;

    /******* Construction Area *******/
    public UserRegistryReq() {
    }
    /******* GetSet Area ******/
    public String getImage() {
        return image;
    }

    public UserRegistryReq setImage(String image) {
        this.image = image == null ? null : image.trim();
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistryReq setEmail(String email) {
        this.email = email == null ? null : email.trim();
        return this;
    }

    public String getNikeName() {
        return nikeName;
    }

    public UserRegistryReq setNikeName(String nikeName) {
        this.nikeName = nikeName == null ? null : nikeName.trim();
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistryReq setPassword(String password) {
        this.password = password == null ? null : password.trim();
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserRegistryReq setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public UserRegistryReq setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
        return this;
    }

    public String getProfession() {
        return profession;
    }

    public UserRegistryReq setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
        return this;
    }

    /******* Method Area *******/


}
