package com.magicpwd;

import com.magicpwd._cons.ConsCfg;
import com.magicpwd._cons.ConsEnv;
import com.magicpwd._face.IBackCall;
import com.magicpwd._user.UserSign;
import com.magicpwd._util.Char;
import com.magicpwd._util.Jzip;
import com.magicpwd._util.Lang;
import com.magicpwd._util.Logs;
import com.magicpwd._util.Util;
import com.magicpwd.m.UserCfg;
import com.magicpwd.r.AmonFF;
import com.magicpwd.v.TrayPtn;

/**
 * @author Amon
 * 
 */
public class MagicPwd
{

    private MagicPwd()
    {
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // 界面启动参数读取
//        if (args != null && args.length > 0 && "webstart".equalsIgnoreCase(args[0]))
//        {
//            UserMdl.setRunMode(ConsEnv.MODE_RUN_WEB);
//        }

        // 数据完整性处理
        zipData();

        // 用户配置文件加载
        final UserCfg cfg = new UserCfg();
        cfg.loadCfg();
        //UserMdl.loadUserCfg();

        // 扩展皮肤加载
        loadLnF(cfg);

        // 界面风格设置
        try
        {
            javax.swing.SwingUtilities.invokeLater(new Runnable()
            {

                @Override
                public void run()
                {
                    boolean deco = ConsCfg.DEF_TRUE.equalsIgnoreCase(cfg.getCfg(ConsCfg.CFG_SKIN_DECO, ConsCfg.DEF_FALSE));
                    javax.swing.JFrame.setDefaultLookAndFeelDecorated(deco);
                    javax.swing.JDialog.setDefaultLookAndFeelDecorated(deco);

                    // 用户偏好风格设置
                    try
                    {
                        String lafClass = cfg.getCfg(ConsCfg.CFG_SKIN_NAME, ConsCfg.DEF_SKIN_SYS).trim();
                        if (lafClass.length() > 0 && !ConsCfg.DEF_SKIN_DEF.equals(lafClass))
                        {
                            if (ConsCfg.DEF_SKIN_SYS.equalsIgnoreCase(lafClass))
                            {
                                lafClass = javax.swing.UIManager.getSystemLookAndFeelClassName();
                            }
                            javax.swing.UIManager.setLookAndFeel(lafClass);
                        }
                    }
                    catch (Exception e)
                    {
                        Logs.exception(e);
                    }

                    // 显示登录或注册界面
                    UserSign us = new UserSign(cfg);
                    us.setBackCall(new IBackCall()
                    {

                        @Override
                        public boolean callBack(Object sender, java.util.EventListener event, String... params)
                        {
                            if (params == null || params.length != 1)
                            {
                                return false;
                            }
                            if (ConsEnv.STR_SIGN_IN.equalsIgnoreCase(params[0]) || ConsEnv.STR_SIGN_UP.equalsIgnoreCase(params[0]))
                            {
                                return viewFrm();
                            }
                            return false;
                        }
                    });
                    us.initView(cfg.getCfg(ConsCfg.CFG_USER, "").trim().length() > 0 ? ConsEnv.INT_SIGN_IN : ConsEnv.INT_SIGN_UP);
                    us.initLang();
                    us.initData();
                }
            });
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
        }

        // 启动后台预加载线程
        preLoad();
    }

    private static void zipData()
    {
        try
        {
            Jzip.unZip(MagicPwd.class.getResourceAsStream("/res/dat.zip"), new java.io.File(ConsEnv.DIR_DAT), false);
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
            Lang.showMesg(null, null, exp.getLocalizedMessage());
        }
    }

    private static void loadLnF(UserCfg cfg)
    {
        String type = cfg.getCfg(ConsCfg.CFG_SKIN_TYPE, "java");
        String name = cfg.getCfg(ConsCfg.CFG_SKIN_NAME, ConsCfg.DEF_SKIN_SYS).trim();
        if ("java".equals(type))
        {
            if (name.length() > 0 && !ConsCfg.DEF_SKIN_DEF.equals(name))
            {
                if (ConsCfg.DEF_SKIN_SYS.equalsIgnoreCase(name))
                {
                    name = javax.swing.UIManager.getSystemLookAndFeelClassName();
                }
                try
                {
                    javax.swing.UIManager.setLookAndFeel(name);
                }
                catch (Exception exp)
                {
                    Logs.exception(exp);
                }
            }
            return;
        }
        if ("synth".equals(type))
        {
            return;
        }
        if (!"user".equals(type))
        {
            return;
        }
        if (!Char.isValidate(name))
        {
            return;
        }
        String look = cfg.getCfg(ConsCfg.CFG_SKIN_LOOK, "");
        if (!Char.isValidate(look))
        {
            return;
        }

        java.io.File file = new java.io.File("skin/look", look);
        if (!file.exists() || !file.canRead() || !file.isDirectory())
        {
            return;
        }

        java.io.File jars[] = file.listFiles(new AmonFF(".+\\.jar$", true));
        if (jars == null && jars.length < 1)
        {
            return;
        }

        try
        {
            loadJar(jars);
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
        }
    }

    private static void loadExt()
    {
    }

    private static void loadJar(java.io.File... files) throws Exception
    {
        if (files == null || files.length < 1)
        {
            return;
        }

        Object[] urls = new Object[files.length];
        for (int i = 0, j = files.length; i < j; i += 1)
        {
            urls[i] = files[i].toURI().toURL();
        }

        java.net.URLClassLoader loader = (java.net.URLClassLoader) ClassLoader.getSystemClassLoader();
        java.lang.reflect.Method method = java.net.URLClassLoader.class.getDeclaredMethod("addURL", java.net.URL.class);
        method.setAccessible(true);
        method.invoke(loader, urls);
    }

    private static void preLoad()
    {
        //UserMdl.preLoad();

        try
        {
            Class.forName("org.hsqldb.jdbcDriver");
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
        }

        Util.getIcon(0);
        Util.getNone();
        Util.getLogo(16);

        loadExt();
    }

    private static boolean viewFrm()
    {
        // 设置软件界面风格
        TrayPtn.showMainPtn();
        if (!TrayPtn.getCurrForm().isVisible())
        {
            TrayPtn.getCurrForm().setVisible(true);
        }
        return true;
    }
}