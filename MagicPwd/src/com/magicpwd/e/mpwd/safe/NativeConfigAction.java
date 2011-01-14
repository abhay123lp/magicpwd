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
package com.magicpwd.e.mpwd.safe;

import com.magicpwd.__a.mpwd.AMpwdAction;
import com.magicpwd._cons.ConsCfg;
import com.magicpwd._cons.LangRes;
import com.magicpwd._util.Char;
import com.magicpwd._util.Lang;

/**
 * Application: MagicPwd
 * Author     : Amon
 * Encoding   : UTF-8
 * Created    : 2010-12-7 19:37:15
 * Website    : http://magicpwd.com/
 * Project    : http://magicpwd.googlecode.com/
 * Contact    : Amon@magicpwd.com
 * CopyRight  : Winshine.biz
 * Description:
 */
public class NativeConfigAction extends AMpwdAction
{

    public NativeConfigAction()
    {
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        javax.swing.JFileChooser jfc = new javax.swing.JFileChooser();
        jfc.setMultiSelectionEnabled(false);
        jfc.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        String path = mpwdPtn.getUserMdl().getCfg(ConsCfg.CFG_SAFE_BACK_LOC);
        if (Char.isValidate(path))
        {
            jfc.setSelectedFile(new java.io.File(path));
        }

        if (javax.swing.JFileChooser.APPROVE_OPTION != jfc.showOpenDialog(mpwdPtn))
        {
            return;
        }

        java.io.File file = jfc.getSelectedFile();
        if (!file.exists())
        {
            if (Lang.showFirm(mpwdPtn, LangRes.P30F7A51, "您选择的目录不存在，要创建此目录吗？") != javax.swing.JOptionPane.YES_OPTION)
            {
                return;
            }

            file.mkdirs();
        }
        if (!file.isDirectory())
        {
            Lang.showMesg(mpwdPtn, LangRes.P30F7A1C, "请选择一个合适的目录！");
            return;
        }
        if (!file.canWrite())
        {
            Lang.showMesg(mpwdPtn, LangRes.P30F7A1D, "无法保存数据到您选择的目录，请确认您是否有足够的权限！");
            return;
        }

        mpwdPtn.getUserMdl().setCfg(ConsCfg.CFG_SAFE_BACK_LOC, file.getAbsolutePath());
    }

    @Override
    public void doInit(String value)
    {
    }

    @Override
    public void reInit(javax.swing.AbstractButton button)
    {
    }
}
