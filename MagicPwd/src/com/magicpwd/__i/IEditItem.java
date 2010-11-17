/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpwd.__i;

/**
 *
 * @author Amon
 */
public interface IEditItem
{

    int getType();

    void setType(int type);

    String getName();

    void setName(String name);

    String getData();

    boolean setData(String data);
    ///////////////////////////////////////////////////////
    // Spec属性
    ///////////////////////////////////////////////////////
    /**
     * 附加属性索引
     */
    int SPEC_GUID_TPLT = 0;// 口令模板索引
    int SPEC_FILE_NAME = 0;// 附件原文件名
    int SPEC_PWDS_HASH = 0;// 字符空间索引
    int SPEC_PWDS_SIZE = 1;// 生成口令长度
    int SPEC_PWDS_LOOP = 2;// 是否允许重复
    int SPEC_DATE_FORM = 0;// 日期显示格式
    int SPEC_DATA_OPT = 0;//可选输入
    int SPEC_DATA_SET = 1;//数据集
    int SPEC_DATA_DEC = 2;//小数位
    int SPEC_DATA_CHAR = 3;//特殊符号
    int SPEC_DATA_CHAR_OPT = 4;//是否可选
    int SPEC_DATA_CHAR_POS = 5;//符号位置

    /**
     * 
     * @param spec
     */
    void addSpec(String spec);

    String getSpec(int index);

    String getSpec(int index, String defValue);

    void setSpec(int index, String spec);

    String enCodeSpec(String c);

    void deCodeSpec(String text, String c);

    void setDefault();
}
