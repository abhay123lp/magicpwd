/*
 *  Copyright (C) 2010 Amon
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.magicpwd._cons;

/**
 * @author Amon
 * 
 */
public interface ConsEnv
{

    /**
     * 软件信息：当前版本
     */
    String VERSIONS = "V3.5.4.6";
    /**
     * 软件信息：构建日期
     */
    String BUILDER = "2010-12-10";
    /**
     * 软件信息：软件代码
     */
    String SOFTCODE = "130F0000";
    /**
     * 软件信息：软件名称
     */
    String SOFTNAME = "魔方密码";
    /**
     * 软件信息：软件首页
     */
    String HOMEPAGE = "http://magicpwd.com/";
    String BLOGSITE = "http://magicpwd.com/wlog/";
    String MLOGSITE = "http://t.sina.com.cn/mpwd";
    /**
     * 软件信息：软件版权
     */
    String SOFTCOPY = "© {0} MagicPwd.com";
    String SOFTMAIL = "Amon@magicpwd.com";
    /**
     * 安全信息：摘要算法
     */
    String NAME_DIGEST = "SHA-512";
    /**
     * 安全信息：密码算法
     */
    String NAME_CIPHER = "AES";
    /**
     * 安全信息：文本编码
     */
    String FILE_ENCODING = "UTF-8";
    String FILE_ATTACHMENT = ".ama";
    String FILE_DATA = "amon";
    String FILE_BACK = FILE_DATA + "_{0}.backup";
    String FILE_SYNC = "magicpwd.amb";
    String FILE_DATE = "yyyyMMdd-HHmmss";
    String HINT_DATE = "yyyy-MM-dd HH:mm:ss";
    String IMAGE_FORMAT = "png";
    char PWDS_MASK = '*';
    String DIR_BAK = "bak";
    String DIR_DAT = "dat";
    String DIR_AMA = "ama";
    String DIR_LOG = "log";
    String DIR_ICO = "ico";
    String DIR_EXT = "ext";
    String DIR_MAIL = "mail";
    String DIR_SKIN = "skin";
    String DIR_LOOK = "look";
    String DIR_FEEL = "feel";
    String DIR_LANG = "lang";
    ///////////////////////////////////////////////////////
    // 类别数据显示排序
    ///////////////////////////////////////////////////////
    /**
     * 记录头部预留属性
     */
    int PWDS_HEAD_GUID = 0;
    int PWDS_HEAD_META = PWDS_HEAD_GUID + 1;
    int PWDS_HEAD_LOGO = PWDS_HEAD_META + 1;
    int PWDS_HEAD_HINT = PWDS_HEAD_LOGO + 1;
    int PWDS_HEAD_SIZE = PWDS_HEAD_HINT + 1;
    /**
     * 数据保存时数据块大小
     */
    int PWDS_DATA_SIZE = 8192;
    int BUTN_MINI_WIDH = 24;
    int BUTN_MINI_HIGH = 22;
    int BUTN_NORM_WIDH = 26;
    int BUTN_NORM_HIGH = 24;
    /**
     * 用户登录
     */
    int INT_SIGN_IN = 1;
    String STR_SIGN_IN = "signIn";
    /**
     * 锁定用户屏幕
     */
    int INT_SIGN_LS = INT_SIGN_IN + 1;
    String STR_SIGN_LS = "signLs";
    /**
     * 权限验证
     */
    int INT_SIGN_RS = INT_SIGN_LS + 1;
    String STR_SIGN_RS = "signRs";
    /**
     * 用户注册
     */
    int INT_SIGN_UP = INT_SIGN_RS + 1;
    String STR_SIGN_UP = "signUp";
    /**
     * 口令找回
     */
    int INT_SIGN_FP = INT_SIGN_UP + 1;
    String STR_SIGN_FP = "signFp";
    /**
     * 更改登录口令
     */
    int INT_SIGN_PK = INT_SIGN_FP + 1;
    String STR_SIGN_PK = "signPk";
    /**
     * 更改安全口令
     */
    int INT_SIGN_SK = INT_SIGN_PK + 1;
    String STR_SIGN_SK = "signSk";
    /**
     * 添加附属用户
     */
    int INT_SIGN_SU = INT_SIGN_SK + 1;
    String STR_SIGN_SU = "signSu";
    /**
     * 在线用户登录
     */
    int INT_SIGN_NW = INT_SIGN_SU + 1;
    String STR_SIGN_NW = "signNw";
    /**
     * 设置云存储用户
     */
    int INT_SIGN_CS = INT_SIGN_NW + 1;
    String STR_SIGN_CS = "signCs";
    /////////////////////////////////////////////////////////////////
    String CARD_HTM = "htm";
    String CARD_TXT = "txt";
    String CARD_PNG = "png";
    String CARD_SVG = "svg";
    String CARD_ALL = "*";
    /////////////////////////////////////////////////////////////////
    String BEAN_PROP = "beanprop";
    String BEAN_INFO = BEAN_PROP + ConsDat.INDX_INFO;// "infobean";
    String BEAN_TEXT = BEAN_PROP + ConsDat.INDX_TEXT;// "textbean";
    String BEAN_PWDS = BEAN_PROP + ConsDat.INDX_PWDS;// "pwdsbean";
    String BEAN_LINK = BEAN_PROP + ConsDat.INDX_LINK;// "linkbean";
    String BEAN_MAIL = BEAN_PROP + ConsDat.INDX_MAIL;// "mailbean";
    String BEAN_DATE = BEAN_PROP + ConsDat.INDX_DATE;// "datebean";
    String BEAN_AREA = BEAN_PROP + ConsDat.INDX_AREA;// "areabean";
    String BEAN_FILE = BEAN_PROP + ConsDat.INDX_FILE;// "filebean";
    String BEAN_DATA = BEAN_PROP + ConsDat.INDX_DATA;// "databean";
    String BEAN_LIST = BEAN_PROP + ConsDat.INDX_LIST;// "listbean";
    String BEAN_SIGN = BEAN_PROP + ConsDat.INDX_SIGN;// "linebean";
    String BEAN_GUID = BEAN_PROP + ConsDat.INDX_GUID;// "guidbean";
    String BEAN_META = BEAN_PROP + ConsDat.INDX_META;// "metabean";
    String BEAN_ICON = BEAN_PROP + ConsDat.INDX_LOGO;// "iconbean";
    String BEAN_NOTE = BEAN_PROP + ConsDat.INDX_HINT;// "timebean";
    /**
     * 图标路径
     */
    String ICON_PATH = "/res/icon/";
    String FEEL_ARGS = "%feel%";
    String FEEL_PATH = "skin/feel/" + FEEL_ARGS + "/";
    String PROP_CHAR = "130F_CHAR";
    String PROP_IDIO = "130F_IDIO";
    String PROP_IMPT = "130F_IMPT";
    String PROP_INFO = "130F_INFO";
    String PROP_JAVA = "130F_JAVA";
    String PROP_KIND = "130F_KIND";
    String PROP_TPLT = "130F_TPLT";
    String PROP_USET = "130F_USET";
    String PROP_SKEY = "130F_SKEY";
    int MWIZ_ROWS_MAX = 6;
    int MWIZ_AREA_ROW = 3;
    char[] UPPER_DIGEST =
    {
        'Q', 'A', 'Z', 'W', 'S', 'X', 'E', 'D', 'C', 'R', 'F', 'V', 'T', 'G', 'B', 'Y'
    };
    char[] LOWER_DIGEST =
    {
        'q', 'a', 'z', 'w', 's', 'x', 'e', 'd', 'c', 'r', 'f', 'v', 't', 'g', 'b', 'y'
    };
    char[] UPPER_NUMBER =
    {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    char[] LOWER_NUMBER =
    {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    int RUN_MODE_DEV = -1;
    /**
     * 程序运行模式：独立程序
     */
    int RUN_MODE_APP = 0;
    /**
     * 程序运行模式：网络加载
     */
    int RUN_MODE_WEB = 1;
    /**
     * 程序运行模式：命令模式
     */
    int RUN_MODE_CMD = 2;
    int APP_MODE_MPWD = 0;
    int APP_MODE_MWIZ = 1;
    int APP_MODE_MPAD = 2;
    int APP_MODE_MAOC = 3;
    int APP_MODE_MRUC = 4;
    String CHAR_ALT_KEY = "@";
    String SKIN_FEEL_DEFAULT = "default";
    String SKIN_LOOK_DEFAULT = "default";
    String SKIN_LOOK_SYSTEM = "system";
    String SKIN_LOOK_FILE = "look.aml";
    String SKIN_FEEL_FILE = "feel.amf";
    String[] USER_SALT =
    {
        "Winshine.biz", "Amonsoft.com", "Magicpwd.com", "MyIM.im"
    };
}
