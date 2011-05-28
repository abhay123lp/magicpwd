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
package com.magicpwd.x.app;

import com.magicpwd.__a.AMpwdPtn;
import com.magicpwd.__i.IBackCall;
import com.magicpwd._comp.IcoLabel;
import com.magicpwd._comp.LnkLabel;
import com.magicpwd._cons.ConsEnv;
import com.magicpwd._cons.LangRes;
import com.magicpwd._util.Bean;
import com.magicpwd._util.Lang;
import com.magicpwd._util.Logs;
import com.magicpwd._util.Util;
import com.magicpwd.r.AmonFF;

/**
 * 图标管理对话窗口
 * @author Amon
 */
public class IcoDialog extends javax.swing.JDialog
{

    private IcoModel icoModel;
    private java.io.File filePath;
    private java.io.File iconPath;
    private AMpwdPtn formPtn;
    private IBackCall<String, String> backCall;

    public IcoDialog(AMpwdPtn mpwdPtn, IBackCall<String, String> backCall)
    {
        super(mpwdPtn, true);
        this.formPtn = mpwdPtn;
        this.backCall = backCall;
        this.iconPath = Util.icoPath;
    }

    public void initView()
    {
        plCatePane = new javax.swing.JPanel();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(plCatePane);
        plCatePane.setLayout(layout);

        btScrollL = new IcoLabel();
        btScrollR = new IcoLabel();

        plCateList = new javax.swing.JPanel();
        plCateList.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
        spCateList = new javax.swing.JScrollPane(plCateList);
        spCateList.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spCateList.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        spCateList.setBorder(null);

        javax.swing.GroupLayout.SequentialGroup hsg = layout.createSequentialGroup();
        hsg.addComponent(btScrollL, 16, 16, 16);
        hsg.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg.addComponent(spCateList, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE);
        hsg.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg.addComponent(btScrollR, 16, 16, 16);
        layout.setHorizontalGroup(hsg);

        javax.swing.GroupLayout.ParallelGroup vpg = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false);
        vpg.addComponent(btScrollL, 16, 16, 16);
        vpg.addComponent(spCateList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        vpg.addComponent(btScrollR, 16, 16, 16);
        layout.setVerticalGroup(vpg);

        btRemove = new javax.swing.JButton();
        btAppend = new javax.swing.JButton();
        btSelect = new javax.swing.JButton();

        tbIconGrid = new javax.swing.JTable();
        tbIconGrid.setTableHeader(null);
        tbIconGrid.setCellSelectionEnabled(true);
        tbIconGrid.setShowHorizontalLines(false);
        tbIconGrid.setShowVerticalLines(false);
        tbIconGrid.getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        javax.swing.JScrollPane spIconGrid = new javax.swing.JScrollPane();
        spIconGrid.setViewportView(tbIconGrid);

        layout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);

        javax.swing.GroupLayout.SequentialGroup hsg1 = layout.createSequentialGroup();
        hsg1.addComponent(btSelect);
        hsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg1.addComponent(btAppend);
        hsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        hsg1.addComponent(btRemove);
        javax.swing.GroupLayout.ParallelGroup hpg1 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING);
        hpg1.addComponent(plCatePane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE);
        hpg1.addComponent(spIconGrid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE);
        hpg1.addGroup(hsg1);
        javax.swing.GroupLayout.SequentialGroup hsg2 = layout.createSequentialGroup();
        hsg2.addContainerGap();
        hsg2.addGroup(hpg1);
        hsg2.addContainerGap();
        layout.setHorizontalGroup(hsg2);

        javax.swing.GroupLayout.ParallelGroup vpg1 = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE);
        vpg1.addComponent(btRemove);
        vpg1.addComponent(btAppend);
        vpg1.addComponent(btSelect);
        javax.swing.GroupLayout.SequentialGroup vsg1 = layout.createSequentialGroup();
        vsg1.addContainerGap();
        vsg1.addComponent(plCatePane, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE);
        vsg1.addComponent(spIconGrid, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE);
        vsg1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg1.addGroup(vpg1);
        vsg1.addContainerGap();
        layout.setVerticalGroup(vsg1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(Bean.getLogo(16));
        setResizable(false);
        pack();
        Bean.centerForm(this, formPtn);
    }

    public void initLang()
    {
        Lang.setWText(btSelect, LangRes.P30FA50C, "选择(@C)");

        Lang.setWText(btAppend, LangRes.P30FA50D, "追加(@A)");

        Lang.setWText(btRemove, LangRes.P30FA50D, "追加(@A)");

        this.setTitle(Lang.getLang(LangRes.P30FA50F, "徽标"));
    }

    public void initData()
    {
        btScrollL.setIcon(new javax.swing.ImageIcon(Bean.getLogo(16)));
        btScrollR.setIcon(new javax.swing.ImageIcon(Bean.getLogo(16)));

        icoModel = new IcoModel();
        tbIconGrid.setModel(icoModel);
        tbIconGrid.setRowHeight(icoModel.getRowHeight());

        javax.swing.table.TableCellRenderer renderer = new javax.swing.table.TableCellRenderer()
        {

            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                if (!(value instanceof javax.swing.JLabel))
                {
                    return null;
                }

                javax.swing.JLabel label = (javax.swing.JLabel) value;
                // 前景及背景颜色设置
                if (isSelected)
                {
                    label.setBackground(table.getSelectionBackground());
                    label.setForeground(table.getSelectionForeground());
                }
                else
                {
                    label.setBackground(table.getBackground());
                    label.setForeground(table.getForeground());
                }

                // 文字属性设置
                label.setFont(table.getFont());
                // 可编辑状态设置
                label.setEnabled(table.isEnabled());
                return label;
            }
        };
        java.util.Enumeration<javax.swing.table.TableColumn> columns = tbIconGrid.getColumnModel().getColumns();
        while (columns.hasMoreElements())
        {
            columns.nextElement().setCellRenderer(renderer);
        }

        btScrollL.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btScrollLActionPerformed(evt);
            }
        });

        btScrollR.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btScrollRActionPerformed(evt);
            }
        });

        btAppend.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btAppendActionPerformed(evt);
            }
        });

        btSelect.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSelectActionPerformed(evt);
            }
        });

        btRemove.addActionListener(new java.awt.event.ActionListener()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btRemoveActionPerformed(evt);
            }
        });
    }

    public void showData(final String lastIcon)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {

            @Override
            public void run()
            {
                initCat(iconPath);
                icoModel.initIcon(iconPath, lastIcon);
                tbIconGrid.setRowSelectionInterval(icoModel.getSelectedRow(), icoModel.getSelectedRow());
                tbIconGrid.setColumnSelectionInterval(icoModel.getSelectedColumn(), icoModel.getSelectedColumn());
            }
        });
    }

    public synchronized void initCat(java.io.File icoPath)
    {
        LnkLabel label;
        for (java.io.File file : icoPath.listFiles(new AmonFF(true, "^\\w{1,40}$")))
        {
            label = new LnkLabel();
            label.setText(file.getName());
            plCateList.add(label);
        }
    }

    private void btScrollLActionPerformed(java.awt.event.ActionEvent evt)
    {
        java.awt.Rectangle rect = spCateList.getVisibleRect();
        rect.x -= 10;
        spCateList.getViewport().scrollRectToVisible(rect);
    }

    private void btScrollRActionPerformed(java.awt.event.ActionEvent evt)
    {
        java.awt.Rectangle rect = spCateList.getVisibleRect();
        rect.x += 10;
        spCateList.getViewport().scrollRectToVisible(rect);
    }

    private void btSelectActionPerformed(java.awt.event.ActionEvent evt)
    {
        if (backCall.callBack(IBackCall.OPTIONS_APPLY, icoModel.getSelectedKey(tbIconGrid.getSelectedRow(), tbIconGrid.getSelectedColumn())))
        {
            this.setVisible(false);
            this.dispose();
        }
    }

    private void btAppendActionPerformed(java.awt.event.ActionEvent evt)
    {
        javax.swing.JFileChooser jfc = new javax.swing.JFileChooser();
        AmonFF ff = new AmonFF("[^\\.]+\\." + ConsEnv.IMAGE_FORMAT + "$", false);
        ff.setIncludeDir(true);
        ff.setDescription('.' + ConsEnv.IMAGE_FORMAT);
        jfc.setFileFilter(ff);
        jfc.setMultiSelectionEnabled(false);
        jfc.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        if (filePath != null)
        {
            jfc.setSelectedFile(filePath);
        }
        if (jfc.showOpenDialog(this) != javax.swing.JFileChooser.APPROVE_OPTION)
        {
            return;
        }
        filePath = jfc.getSelectedFile();
        if (!filePath.exists())
        {
            Lang.showMesg(this, LangRes.P30F7A03, "您选取的文件不存在！");
            return;
        }
        if (!filePath.isFile() || !filePath.canRead())
        {
            Lang.showMesg(this, LangRes.P30F7A05, "无法读取您选择的文件，请确认您是否有足够的权限！");
            return;
        }

        try
        {
            icoModel.appendIcon(filePath, iconPath);
            tbIconGrid.setRowSelectionInterval(icoModel.getSelectedRow(), icoModel.getSelectedRow());
            tbIconGrid.setColumnSelectionInterval(icoModel.getSelectedColumn(), icoModel.getSelectedColumn());
        }
        catch (Exception exp)
        {
            Lang.showMesg(this, null, exp.getLocalizedMessage());
            Logs.exception(exp);
            return;
        }
    }

    private void btRemoveActionPerformed(java.awt.event.ActionEvent evt)
    {
    }
    private javax.swing.JButton btAppend;
    private javax.swing.JButton btSelect;
    private javax.swing.JButton btRemove;
    private IcoLabel btScrollL;
    private IcoLabel btScrollR;
    private javax.swing.JPanel plCatePane;
    private javax.swing.JPanel plCateList;
    private javax.swing.JScrollPane spCateList;
    private javax.swing.JTable tbIconGrid;
}

class IcoModel extends javax.swing.table.AbstractTableModel
{

    private java.util.List<javax.swing.JLabel> iconList;
    private int columnCount;
    private int rowHeight;
    private int selected;

    IcoModel()
    {
        iconList = new java.util.ArrayList<javax.swing.JLabel>();
        javax.swing.JLabel label = newLabel(0, Bean.getNone(), "0");
        iconList.add(label);
        columnCount = 5;
        rowHeight = label.getPreferredSize().height + 6;
    }

    @Override
    public int getRowCount()
    {
        return iconList.size() / columnCount + 1;
    }

    @Override
    public int getColumnCount()
    {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if (iconList.size() < 1)
        {
            return null;
        }
        int index = rowIndex * columnCount + columnIndex;
        if (index >= iconList.size())
        {
            return null;
        }
        return iconList.get(index);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return javax.swing.JLabel.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }

    public synchronized void initIcon(java.io.File icoPath, String lastIcon)
    {
        if (icoPath == null)
        {
            icoPath = Util.icoPath;
            if (!icoPath.exists())
            {
                icoPath.mkdirs();
            }
        }

        java.io.File[] fileList = icoPath.listFiles(new AmonFF("(AM|AU)\\d{14}_(16|24)\\.PNG", true));
        if (fileList == null || fileList.length < 1)
        {
            return;
        }

        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("(AM|AU)\\d{14}");
        int i = 1;
        for (java.io.File file : fileList)
        {
            if (!file.isFile())
            {
                continue;
            }
            java.util.regex.Matcher matcher = pattern.matcher(file.getName());
            if (!matcher.find())
            {
                continue;
            }

            String key = matcher.group();
            iconList.add(newLabel(i, new javax.swing.ImageIcon(file.getAbsolutePath()), key));
            if (key.equalsIgnoreCase(lastIcon))
            {
                selected = i;
            }
            i += 1;
        }
    }

    private static java.awt.image.BufferedImage scaleImage(java.awt.image.BufferedImage img, int dim)
    {
        int w = img.getWidth();
        int h = img.getHeight();
        if (w != dim || h != dim)
        {
            double dw = 16.0 / w;
            double dh = 16.0 / h;
            double d = dw <= dh ? dw : dh;
            w *= d;
            h *= d;
            java.awt.Image tmp = img.getScaledInstance(w, h, java.awt.Image.SCALE_DEFAULT);
            img = new java.awt.image.BufferedImage(dim, dim, java.awt.image.BufferedImage.TYPE_INT_ARGB);
            img.createGraphics().drawImage(tmp, (dim - w) >> 1, (dim - h) >> 1, w, h, null);
        }
        return img;
    }

    private static void writeImage(java.awt.image.BufferedImage img, String path) throws Exception
    {
        java.io.File pngFile = new java.io.File(path);
        if (!pngFile.exists())
        {
            pngFile.createNewFile();
        }
        java.io.FileOutputStream fos = new java.io.FileOutputStream(pngFile);
        javax.imageio.ImageIO.write(img, ConsEnv.IMAGE_FORMAT, fos);
        fos.flush();
        fos.close();
    }

    public synchronized void appendIcon(java.io.File filePath, java.io.File icoPath) throws Exception
    {
        java.io.FileInputStream fis = new java.io.FileInputStream(filePath);
        java.awt.image.BufferedImage img = javax.imageio.ImageIO.read(fis);
        fis.close();

        String hash = "AU" + new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        writeImage(scaleImage(img, 16), icoPath.getAbsolutePath() + java.io.File.separator + hash + "_16." + ConsEnv.IMAGE_FORMAT);
        writeImage(scaleImage(img, 24), icoPath.getAbsolutePath() + java.io.File.separator + hash + "_24." + ConsEnv.IMAGE_FORMAT);

        int i = iconList.size();
        iconList.add(newLabel(i, new javax.swing.ImageIcon(img), hash));

        selected = i;
        fireTableDataChanged();
    }

    /**
     * @param columnCount the columnCount to set
     */
    public void setColumnCount(int columnCount)
    {
        if (columnCount > 0)
        {
            this.columnCount = columnCount;
        }
    }

    private javax.swing.JLabel newLabel(int num, javax.swing.Icon ico, String key)
    {
        javax.swing.JLabel label = new javax.swing.JLabel();
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        label.putClientProperty("hash", key);
        label.setText(Integer.toString(num));
        label.setOpaque(true);
        label.setIcon(ico);
        return label;
    }

    /**
     * @return the rowHeight
     */
    public int getRowHeight()
    {
        return rowHeight;
    }

    /**
     * @param rowHeight the rowHeight to set
     */
    public void setRowHeight(int rowHeight)
    {
        this.rowHeight = rowHeight;
    }

    public int getSelectedRow()
    {
        return selected / columnCount;
    }

    public int getSelectedColumn()
    {
        return selected % columnCount;
    }

    public String getSelectedKey(int row, int column)
    {
        int index = row * columnCount + column;
        if (index < 0 || index >= iconList.size())
        {
            return "";
        }

        javax.swing.JLabel label = iconList.get(index);
        String hash = (String) label.getClientProperty("hash");
        Bean.setDataIcon(hash, label.getIcon());
        return hash;
    }
}