/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpwd.m;

import com.magicpwd._cons.ConsCfg;
import com.magicpwd._cons.ConsEnv;
import com.magicpwd._util.Bean;
import com.magicpwd._util.Char;
import com.magicpwd._util.Logs;

/**
 *
 * @author Amon
 */
public class UserMdl
{

    private static int runMode = 0;
    private static int appMode = 1;
    private boolean topMost;
    private String userName;
    private java.util.Properties userCfg;
    private TpltMdl tpltMdl;
    private CharMdl charMdl;
    private HintMdl hintMdl;
    SafeKey safeKey;

    public UserMdl()
    {
    }

    /**
     * @return the runMode
     */
    public static int getRunMode()
    {
        return runMode;
    }

    /**
     * @param runMode the runMode to set
     */
    public static void setRunMode(int runMode)
    {
        UserMdl.runMode = runMode;
    }

    /**
     * @return the appMode
     */
    public static int getAppMode()
    {
        return appMode;
    }

    /**
     * @param appMode the appMode to set
     */
    public static void setAppMode(int appMode)
    {
        UserMdl.appMode = appMode;
    }

    public final void loadCfg()
    {
        userCfg = new java.util.Properties();
        java.io.FileInputStream fis = null;
        try
        {
            java.io.File file = new java.io.File(ConsEnv.DIR_DAT, ConsEnv.FILE_DATA + ".config");
            if (file.exists() && file.canRead())
            {
                fis = new java.io.FileInputStream(file);
                userCfg.load(fis);
            }
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
        }
        finally
        {
            Bean.closeStream(fis);
        }

        safeKey = new SafeKey(this);
    }

    public final void loadDef()
    {
        userCfg.setProperty(ConsCfg.CFG_VIEW_TOPS, ConsCfg.DEF_FALSE);
        userCfg.setProperty(ConsCfg.CFG_VIEW_MENU, ConsCfg.DEF_TRUE);
        userCfg.setProperty(ConsCfg.CFG_VIEW_TOOL, ConsCfg.DEF_FALSE);
        userCfg.setProperty(ConsCfg.CFG_VIEW_INFO, ConsCfg.DEF_FALSE);
        userCfg.setProperty(ConsCfg.CFG_VIEW_FIND, ConsCfg.DEF_TRUE);
        userCfg.setProperty(ConsCfg.CFG_VIEW_TOOL_LOC, "North");

        userCfg.setProperty(ConsCfg.CFG_STAY_TIME, ConsCfg.DEF_STAY_TIME);

        userCfg.setProperty(ConsCfg.CFG_PWDS_SIZE, ConsCfg.DEF_PWDS_SIZE);
        userCfg.setProperty(ConsCfg.CFG_PWDS_HASH, ConsCfg.DEF_PWDS_HASH);

        userCfg.setProperty(ConsCfg.CFG_BACK_SIZE, "3");
        userCfg.setProperty(ConsCfg.CFG_BACK_PATH, ConsEnv.DIR_BAK);
    }

    public final void saveCfg()
    {
        java.io.FileOutputStream fos = null;
        try
        {
            fos = new java.io.FileOutputStream(new java.io.File(ConsEnv.DIR_DAT, ConsEnv.FILE_DATA + ".config"));
            userCfg.store(fos, "MagicPwd User Configure File!");
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
        }
        finally
        {
            Bean.closeStream(fos);
        }
    }

    public final String getCfg(String key)
    {
        return getCfg(key, null);
    }

    public final String getCfg(String key, String def)
    {
        if (!Char.isValidate(key))
        {
            return def;
        }
        return userCfg.getProperty(Char.format(key, userName), def);
    }

    public final void setCfg(String key, String value)
    {
        if (Char.isValidate(key))
        {
            userCfg.setProperty(Char.format(key, userName), value);
        }
    }

    /**
     * @return the menuViw
     */
    public final boolean isMenuVisible()
    {
        return ConsCfg.DEF_TRUE.equalsIgnoreCase(userCfg.getProperty(ConsCfg.CFG_VIEW_MENU, ConsCfg.DEF_TRUE));
    }

    /**
     * @param visible
     *            the menuViw to set
     */
    public final void setMenuVisible(boolean visible)
    {
        userCfg.setProperty(ConsCfg.CFG_VIEW_MENU, visible ? ConsCfg.DEF_TRUE : ConsCfg.DEF_FALSE);
    }

    /**
     * @return the toolViw
     */
    public final boolean isToolVisible()
    {
        return ConsCfg.DEF_TRUE.equalsIgnoreCase(userCfg.getProperty(ConsCfg.CFG_VIEW_TOOL));
    }

    /**
     * @param visible
     *            the toolViw to set
     */
    public final void setToolVisible(boolean visible)
    {
        userCfg.setProperty(ConsCfg.CFG_VIEW_TOOL, visible ? ConsCfg.DEF_TRUE : ConsCfg.DEF_FALSE);
    }

    /**
     * @return the infoViw
     */
    public final boolean isInfoVisible()
    {
        return ConsCfg.DEF_TRUE.equalsIgnoreCase(userCfg.getProperty(ConsCfg.CFG_VIEW_INFO, ConsCfg.DEF_TRUE));
    }

    /**
     * @param visible
     *            the infoViw to set
     */
    public final void setInfoVisible(boolean visible)
    {
        userCfg.setProperty(ConsCfg.CFG_VIEW_INFO, visible ? ConsCfg.DEF_TRUE : ConsCfg.DEF_FALSE);
    }

    /**
     * @return the findViw
     */
    public final boolean isFindVisible()
    {
        return ConsCfg.DEF_TRUE.equalsIgnoreCase(userCfg.getProperty(ConsCfg.CFG_VIEW_FIND, ConsCfg.DEF_TRUE));
    }

    /**
     * @param visible
     *            the findViw to set
     */
    public final void setFindVisible(boolean visible)
    {
        userCfg.setProperty(ConsCfg.CFG_VIEW_FIND, visible ? ConsCfg.DEF_TRUE : ConsCfg.DEF_FALSE);
    }

    /**
     * @return the toolLoc
     */
    public final String getToolLoc()
    {
        return userCfg.getProperty(ConsCfg.CFG_VIEW_TOOL_LOC, "North");
    }

    /**
     * @param toolLoc
     *            the toolLoc to set
     */
    public final void setToolLoc(String toolLoc)
    {
        userCfg.setProperty(ConsCfg.CFG_VIEW_TOOL_LOC, toolLoc);
    }

    /**
     * @return the clnClp
     */
    public final int getStayTime()
    {
        return Integer.parseInt(userCfg.getProperty(ConsCfg.CFG_STAY_TIME, ConsCfg.DEF_STAY_TIME));
    }

    /**
     * @param clnClp
     *            the clnClp to set
     */
    public final void setStayTime(int clnClp)
    {
        userCfg.setProperty(ConsCfg.CFG_STAY_TIME, Integer.toString(clnClp));
    }

    /**
     * @return the pwdsLen
     */
    public final String getPwdsLen()
    {
        return userCfg.getProperty(ConsCfg.CFG_PWDS_SIZE, ConsCfg.DEF_PWDS_SIZE);
    }

    /**
     * @param pwdsLen
     *            the pwdsLen to set
     */
    public final void setPwdsLen(int pwdsLen)
    {
        userCfg.setProperty(ConsCfg.CFG_PWDS_SIZE, "" + pwdsLen);
    }

    /**
     * @return the pwdsKey
     */
    public final String getPwdsKey()
    {
        return userCfg.getProperty(ConsCfg.CFG_PWDS_HASH, ConsCfg.DEF_PWDS_HASH);
    }

    /**
     * @param pwdsKey
     *            the pwdsKey to set
     */
    public final void setPwdsKey(String pwdsKey)
    {
        userCfg.setProperty(ConsCfg.CFG_PWDS_HASH, pwdsKey);
    }

    /**
     * @return the bakNum
     */
    public final int getBackNum()
    {
        String txt = userCfg.getProperty(ConsCfg.CFG_BACK_SIZE, "3");
        if (Char.isValidatePositiveInteger(txt))
        {
            return Integer.parseInt(txt);
        }
        return 3;
    }

    /**
     * @param bakNum
     *            the bakNum to set
     */
    public final void setBackNum(int backNum)
    {
        userCfg.setProperty(ConsCfg.CFG_BACK_SIZE, "" + backNum);
    }

    public final int getHintInt()
    {
        String txt = userCfg.getProperty(ConsCfg.CFG_HINT_INT, "60");
        if (Char.isValidatePositiveInteger(txt))
        {
            return Integer.parseInt(txt);
        }
        return 60;
    }

    public final void setHintInt(int hintInt)
    {
        userCfg.setProperty(ConsCfg.CFG_HINT_INT, "" + hintInt);
    }

    public final int getHintPre()
    {
        String txt = userCfg.getProperty(ConsCfg.CFG_HINT_PRE, "300");
        if (Char.isValidatePositiveInteger(txt))
        {
            return Integer.parseInt(txt);
        }
        return 300;
    }

    public final void setHintPre(int hintPre)
    {
        userCfg.setProperty(ConsCfg.CFG_HINT_PRE, "" + hintPre);
    }

    /**
     * @return the bakDir
     */
    public final String getBackDir()
    {
        return userCfg.getProperty(ConsCfg.CFG_BACK_PATH, ConsCfg.DEF_BACK_PATH);
    }

    /**
     * @param backDir
     *            the backDir to set
     */
    public final void setBackDir(String backDir)
    {
        userCfg.setProperty(ConsCfg.CFG_BACK_PATH, backDir);
    }

    public final String getDataDir()
    {
        return userCfg.getProperty(ConsCfg.CFG_DATA_PATH, ConsCfg.DEF_DATA_PATH);
    }

    public final void setDataDir(String dataDir)
    {
        userCfg.setProperty(ConsCfg.CFG_BACK_PATH, dataDir);
    }

    /**
     * @return the editViw
     */
    public final boolean isEditVisible()
    {
        return ConsCfg.DEF_TRUE.equalsIgnoreCase(userCfg.getProperty(ConsCfg.CFG_VIEW_EDIT_VIW, ConsCfg.DEF_TRUE));
    }

    /**
     * @param editViw
     *            the editViw to set
     */
    public final void setEditVisible(boolean editViw)
    {
        userCfg.setProperty(ConsCfg.CFG_VIEW_EDIT_VIW, editViw ? ConsCfg.DEF_TRUE : ConsCfg.DEF_FALSE);
    }

    public final boolean isEditIsolate()
    {
        return ConsCfg.DEF_TRUE.equalsIgnoreCase(userCfg.getProperty(ConsCfg.CFG_VIEW_EDIT_WND, ConsCfg.DEF_FALSE));
    }

    /**
     * @param isolate
     *            the editWnd to set
     */
    public final void setEditIsolate(boolean isolate)
    {
        userCfg.setProperty(ConsCfg.CFG_VIEW_EDIT_WND, isolate ? ConsCfg.DEF_TRUE : ConsCfg.DEF_FALSE);
    }

    public final String getPwdsLoop()
    {
        return userCfg.getProperty(ConsCfg.CFG_PWDS_LOOP, ConsCfg.DEF_TRUE);
    }

    /**
     * @return the pwdUpt
     */
    public final boolean isPwdsLoop()
    {
        return ConsCfg.DEF_TRUE.equalsIgnoreCase(getPwdsLoop());
    }

    /**
     * @param pwdsLoop
     *            the pwdsUpt to set
     */
    public final void setPwdsLoop(boolean pwdsLoop)
    {
        userCfg.setProperty(ConsCfg.CFG_PWDS_LOOP, pwdsLoop ? ConsCfg.DEF_TRUE : ConsCfg.DEF_FALSE);
    }

    public String getSkin()
    {
        return "";
    }

    public void setSkin(String skin)
    {
    }

    public String getLook()
    {
        return "";
    }

    public void setLook(String look)
    {
    }

    public String getFeel()
    {
        return "";
    }

    public void setFeel(String feel)
    {
    }

    public final String getLang()
    {
        String lang = userCfg.getProperty(ConsCfg.CFG_LANG);
        if (!Char.isValidate(lang))
        {
            lang = System.getProperty("user.language");//Locale.getDefault().getLanguage();
            String country = System.getProperty("user.country");//Locale.getDefault().getCountry();
            if (Char.isValidate(country))
            {
                lang += '_' + country;
            }
        }
        return lang;
    }

    public final void setLang(String lang)
    {
        userCfg.setProperty(ConsCfg.CFG_LANG, lang);
    }

    public String getCode()
    {
        return userCfg.getProperty(ConsCfg.CFG_USER_CODE, "");
    }

    public String getName()
    {
        return userCfg.getProperty(ConsCfg.CFG_USER_NAME, "");
    }

    public javax.swing.ImageIcon readIcon(String path)
    {
        return Bean.readIcon(path.replace(ConsEnv.FEEL_ARGS, getCfg(ConsCfg.CFG_SKIN_FEEL, ConsEnv.SKIN_FEEL_DEFAULT)));
    }

    /**
     * @return the viewTop
     */
    public final boolean isTopMost()
    {
        return topMost;
    }

    /**
     * @param topMost
     *            the viewTop to set
     */
    public final void setTopMost(boolean topMost)
    {
        this.topMost = topMost;
    }

    /**
     * @return the tpltMdl
     */
    public TpltMdl getTpltMdl()
    {
        if (tpltMdl == null)
        {
            tpltMdl = new TpltMdl();
            tpltMdl.initData();
        }
        return tpltMdl;
    }

    /**
     * @return the charMdl
     */
    public CharMdl getCharMdl()
    {
        if (charMdl == null)
        {
            charMdl = new CharMdl();
            charMdl.initData();
        }
        return charMdl;
    }

    /**
     * @return the hintMdl
     */
    public HintMdl getHintMdl()
    {
        if (hintMdl == null)
        {
            hintMdl = new HintMdl(this);
            hintMdl.initData();
        }
        return hintMdl;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * 用户登录
     * @param userName
     * @param userPwds
     * @param userSalt
     * @throws Exception
     */
    public boolean signIn(String userName, String userPwds) throws Exception
    {
        safeKey.setName(userName);
        safeKey.setPwds(userPwds);
        return safeKey.signIn();
    }

    public boolean signPb(String userName, String userPwds) throws Exception
    {
        safeKey.setName(userName);
        safeKey.setPwds(userPwds);
        return safeKey.signPb();
    }

    /**
     * 修改登录口令
     * @param oldPwds
     * @param userPwds
     * @throws Exception
     */
    public boolean signPk(String oldPwds, String newPwds) throws Exception
    {
        if (safeKey == null)
        {
            return false;
        }
        return safeKey.signPk(oldPwds, newPwds);
    }

    /**
     * 口令找回
     *
     * @param secPwds
     * @return
     * @throws Exception
     */
    public boolean signFp(String usrName, StringBuffer secPwds) throws Exception
    {
        if (safeKey == null)
        {
            return false;
        }
        return safeKey.signFp(usrName, secPwds);
    }

    /**
     * 设置安全口令
     * @param secPwds
     * @return
     * @throws java.lang.Exception
     */
    public boolean signSk(String oldPwds, String secPwds) throws Exception
    {
        if (safeKey == null)
        {
            return false;
        }
        return safeKey.signSk(oldPwds, secPwds);
    }

    /**
     * 用户注销
     * @param userName
     * @param userPwds
     * @throws Exception
     */
    public boolean signOx(String userName, String userPwds)
    {
        return safeKey.signOx();
    }

    /**
     * 用户注册
     * @param userName
     * @param userPwds
     * @return
     * @throws Exception
     */
    public boolean signUp(String userName, String userPwds) throws Exception
    {
        safeKey.setName(userName);
        safeKey.setPwds(userPwds);
        return safeKey.signUp();
    }

    public boolean hasSkey()
    {
        return safeKey.hasSkey();
    }
}