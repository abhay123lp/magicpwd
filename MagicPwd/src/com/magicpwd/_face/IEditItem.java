/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpwd._face;

/**
 *
 * @author Administrator
 */
public interface IEditItem
{

    /**
     * 附加属性索引
     */
    int SPEC_FILE_NAME = 0;// 附件原文件名
    int SPEC_PWDS_HASH = 0;// 字符空间索引
    int SPEC_PWDS_SIZE = 1;// 生成口令长度
    int SPEC_PWDS_NRPT = 2;// 是否允许重复

    int getType();

    void setType(int type);

    String getName();

    void setName(String name);

    String getData();

    boolean setData(String data);

    void addSpec(String spec);

    String getSpec(int index);

    String getSpec(int index, String defValue);

    void setSpec(int index, String spec);

    String enCodeSpec(String c);

    void deCodeSpec(String text, String c);

    void setDefault();
}
