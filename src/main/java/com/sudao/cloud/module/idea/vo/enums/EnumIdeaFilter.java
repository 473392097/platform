package com.sudao.cloud.module.idea.vo.enums;

import com.sudao.spec.enums.ICodeEnum;
import com.sudao.spec.enums.ILabelCodeEnum;

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
 * @time: 下午10:48
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/10/26 下午10:48
 */
public enum EnumIdeaFilter implements ICodeEnum<EnumIdeaFilter, String> {

    /**
     * 全部类型
     */
    ALL("ALL"),
    /**
     * 我发布的
     */
    PUBLISH("PUBLISH"),
    /**
     * 我收藏的
     */
    FORK("FORK"),
    /**
     * 我参与的
     */
    CONTRIBUTE("CONTRIBUTE");

    private String code;

    EnumIdeaFilter(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public EnumIdeaFilter setCode(String s) {
        this.code = s;
        return this;
    }

    @Override
    public EnumIdeaFilter codeOf(String s) {
        return EnumIdeaFilter.valueOf(s);
    }
    /******* Fields Area *******/

    /******* Construction Area *******/



    /******* GetSet Area ******/

    /******* Method Area *******/


}
