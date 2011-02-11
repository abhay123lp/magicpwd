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
import com.magicpwd.__i.IBackCall;
import com.magicpwd._cons.ConsCfg;
import com.magicpwd._cons.LangRes;
import com.magicpwd._util.Char;
import com.magicpwd._util.Lang;
import com.magicpwd._util.Logs;

/**
 * 备份到数据文件
 * @author Amon
 */
public class NativeBackupAction extends AMpwdAction implements IBackCall<String>
{

    public NativeBackupAction()
    {
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        if (!Char.isValidate(mpwdPtn.getUserMdl().getCfg(ConsCfg.CFG_SAFE_BACK_LOC)))
        {
            Lang.showMesg(mpwdPtn, LangRes.P30F7A54, "您还没有配置本地备份目录！");
            return;
        }

        if (javax.swing.JOptionPane.YES_OPTION != Lang.showFirm(mpwdPtn, LangRes.P30F7A52, "确认要执行备份操作吗？"))
        {
            return;
        }

        new Thread()
        {

            @Override
            public void run()
            {
                doBackup();
            }
        }.start();
    }

    @Override
    public void doInit(String value)
    {
    }

    @Override
    public void reInit(javax.swing.AbstractButton button, String value)
    {
    }

    @Override
    public boolean callBack(String options, String object)
    {
        return true;
    }

    private void doBackup()
    {
        mpwdPtn.showProgress();

        try
        {
            boolean b = mpwdPtn.nativeBackup(mpwdPtn.getUserMdl().getCfg(ConsCfg.CFG_SAFE_BACK_LOC), null);
            mpwdPtn.hideProgress();

            if (b)
            {
                Lang.showMesg(mpwdPtn, LangRes.P30F7A3D, "恭喜，数据备份成功！");
            }
            else
            {
                Lang.showMesg(mpwdPtn, LangRes.P30F7A3C, "数据备份失败，请重启软件后重试！");
            }
        }
        catch (Exception exp)
        {
            mpwdPtn.hideProgress();

            Logs.exception(exp);
            Lang.showMesg(mpwdPtn, null, exp.getLocalizedMessage());
        }
    }
}