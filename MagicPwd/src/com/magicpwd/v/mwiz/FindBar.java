/*
 *  Copyright (C) 2010 Administrator
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
package com.magicpwd.v.mwiz;

import com.magicpwd._comp.BtnLabel;
import com.magicpwd._cons.ConsEnv;

/**
 *
 * @author Administrator
 */
public class FindBar extends javax.swing.JPanel
{

    private NormPtn normPtn;
    private String lastMeta = "";

    public FindBar(NormPtn normPtn)
    {
        this.normPtn = normPtn;
    }

    public void initView()
    {
        tf_MetaText = new javax.swing.JTextField();
        tf_MetaText.setOpaque(false);
        tf_MetaText.setBorder(null);

        bt_MetaText = new BtnLabel();
        bt_MetaText.setIcon(normPtn.readFavIcon("file-close", false));
        bt_MetaText.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                bt_MetaTextActionPerformed(e);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        javax.swing.GroupLayout.SequentialGroup hsg = layout.createSequentialGroup();
        hsg.addGap(10);
        hsg.addComponent(tf_MetaText, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE);
        hsg.addGap(0, 2, 4);
        hsg.addComponent(bt_MetaText, 20, 20, 20);
        hsg.addGap(6);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hsg));

        javax.swing.GroupLayout.ParallelGroup vpg = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        vpg.addComponent(tf_MetaText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE);
        vpg.addComponent(bt_MetaText, 20, 20, 20);
        javax.swing.GroupLayout.SequentialGroup vsg = layout.createSequentialGroup();
        vsg.addGap(5);
        vsg.addGroup(vpg);
        vsg.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(vsg));
    }

    public void initLang()
    {
    }

    public void initData()
    {
        bgImage = normPtn.getUserMdl().readImage(ConsEnv.FEEL_PATH + "findbar.png");
        tf_MetaText.addKeyListener(new java.awt.event.KeyAdapter()
        {

            @Override
            public void keyReleased(java.awt.event.KeyEvent e)
            {
                tf_MetaText_KeyReleased(e);
            }
        });
    }

    @Override
    public void requestFocus()
    {
        tf_MetaText.requestFocus();
    }

    @Override
    protected void paintComponent(java.awt.Graphics g)
    {
        super.paintComponent(g);
        if (bgImage != null)
        {
            g.drawImage(bgImage, 0, 0, bgImage.getWidth(), bgImage.getHeight(), this);
        }
    }

    @Override
    public java.awt.Dimension getPreferredSize()
    {
        return new java.awt.Dimension(bgImage.getWidth(), bgImage.getHeight());
    }

    public String getKeyMeta()
    {
        return tf_MetaText.getText();
    }

    public void setKeyMeta(String meta)
    {
        lastMeta = meta;
        tf_MetaText.setText(meta);
    }

    private void bt_MetaTextActionPerformed(java.awt.event.ActionEvent e)
    {
        normPtn.setFindVisible(false);
        javax.swing.AbstractButton button = normPtn.getMenuPtn().getButton("find");
        if (button != null)
        {
            button.setSelected(false);
        }
    }

    private void tf_MetaText_KeyReleased(java.awt.event.KeyEvent e)
    {
        String meta = tf_MetaText.getText();
        if (lastMeta.equals(meta))
        {
            return;
        }
        lastMeta = meta;

        normPtn.findKeys(meta);
    }
    private BtnLabel bt_MetaText;
    private javax.swing.JTextField tf_MetaText;
    private java.awt.image.BufferedImage bgImage;
}