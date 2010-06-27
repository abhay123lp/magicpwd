package com.magicpwd.v;

import com.magicpwd._cons.LangRes;
import com.magicpwd._face.IFormView;
import com.magicpwd._util.Lang;
import com.magicpwd._util.Util;
import com.magicpwd.c.FindEvt;
import com.magicpwd.c.MenuEvt;

/**
 * 正常模式：账簿
 * 
 * @author Amon
 * 
 */
public class NormPtn extends javax.swing.JFrame implements IFormView, MenuEvt, FindEvt
{

    public void initView()
    {
        this.pack();
        this.setIconImage(Util.getLogo(16));
        Util.centerForm(this, null);
    }

    public void initLang()
    {
        setTitle(Lang.getLang(LangRes.P30F5201, "全能搜索"));
    }

    public void initData()
    {
    }

    @Override
    public void setVisible(boolean visible)
    {
        super.setVisible(visible);
    }

    @Override
    public javax.swing.JFrame getForm()
    {
        return this;
    }

    @Override
    public void fileCopyActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void fileApndActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void fileSaveActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void fileOpenActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void fileDeltActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void fileHideActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void fileExitActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void editFindActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void editTextActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void editPwdsActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void editLinkActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void editMailActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void editDateActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void editAreaActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void editFileActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void editPrevActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void editNextActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void keysModeActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void keysNoteActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void listSkeyActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void listSascActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void kindApndActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void kindUpdtActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void kindDeltActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void viewTop1ActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void viewEditActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void viewSideActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void viewFindActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void viewMenuActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void viewToolActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void viewInfoActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void viewPrevActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void viewNextActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void dataImptActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void dataExptActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void dataSyncActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void dataBackActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void dataDocsActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void helpSKeyActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void skinChangeActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void userSwitchActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void userCreateActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void userUpdateActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void userSecretActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void helpHelpActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void helpSiteActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void helpMailActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void helpUpdtActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void helpJavaActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void helpInfoActionPerformed(java.awt.event.ActionEvent evt)
    {
    }

    @Override
    public void findActionPerformed(java.awt.event.ActionEvent evt)
    {
    }
}
