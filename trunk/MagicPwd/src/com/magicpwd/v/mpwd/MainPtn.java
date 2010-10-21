/**
 *
 */
package com.magicpwd.v.mpwd;

import com.magicpwd.__i.IEditBean;
import com.magicpwd.__i.IEditItem;
import com.magicpwd.__i.IFavIcon;
import com.magicpwd.__i.IGridView;
import com.magicpwd._bean.mpwd.AreaBean;
import com.magicpwd._bean.mpwd.DataBean;
import com.magicpwd._bean.mpwd.DateBean;
import com.magicpwd._bean.mpwd.FileBean;
import com.magicpwd._bean.mpwd.GuidBean;
import com.magicpwd._bean.mpwd.LogoBean;
import com.magicpwd._bean.mpwd.InfoBean;
import com.magicpwd._bean.mpwd.LinkBean;
import com.magicpwd._bean.mpwd.MailBean;
import com.magicpwd._bean.mpwd.MetaBean;
import com.magicpwd._bean.mpwd.HintBean;
import com.magicpwd._bean.mpwd.PwdsBean;
import com.magicpwd._bean.mpwd.TextBean;
import com.magicpwd._comn.I1S2;
import com.magicpwd._comn.Keys;
import com.magicpwd._comp.WButtonGroup;
import com.magicpwd._comn.item.GuidItem;
import com.magicpwd._comn.item.LogoItem;
import com.magicpwd._comn.item.MetaItem;
import com.magicpwd._comn.prop.Kind;
import com.magicpwd._cons.ConsCfg;
import com.magicpwd._cons.ConsDat;
import com.magicpwd._cons.ConsEnv;
import com.magicpwd._cons.LangRes;
import com.magicpwd._mail.Connect;
import com.magicpwd._mail.MailDlg;
import com.magicpwd._util.Bean;
import com.magicpwd._util.Card;
import com.magicpwd._util.Desk;
import com.magicpwd._util.Jcsv;
import com.magicpwd._util.Lang;
import com.magicpwd._util.Logs;
import com.magicpwd._util.Util;
import com.magicpwd.d.DBA3000;
import com.magicpwd.m.mpwd.GridMdl;
import com.magicpwd.m.UserCfg;
import com.magicpwd.m.UserMdl;
import com.magicpwd.m.mpwd.ListMdl;
import com.magicpwd.m.mpwd.MpwdMdl;
import com.magicpwd.m.mpwd.TreeMdl;
import com.magicpwd.r.KeysCR;
import com.magicpwd.r.KindTN;
import com.magicpwd.r.TreeCR;
import com.magicpwd.v.MenuPtn;
import com.magicpwd.v.TrayPtn;
import com.magicpwd.x.MdiDialog;

public class MainPtn extends javax.swing.JFrame implements IFavIcon, IGridView
{

    private EditDlg ed_KeysEdit;
    private IEditBean[] editBean;
    private FindBar mainFind;
    private HintBar mainInfo;
    private MailDlg mailDlg;
    private HistDlg histDlg;
    private MdiDialog cfgForm;
    private MenuPtn menuPtn;
    /**
     * 口令列表上次选择索引
     */
    private int ls_LastIndx = -1;
    /**
     * 属性列表上次选择索引
     */
    private int tb_LastIndx = -1;
    /**
     * 用户上一次的操作方式
     */
    private boolean isSearch;
    /**
     * 用户查找字符串
     */
    private String queryKey;
    private UserMdl coreMdl;
    private GridMdl gridMdl;
    private MpwdMdl mpwdMdl;
    private java.util.HashMap<String, javax.swing.Icon> iconMap;

    public MainPtn(UserMdl coreMdl)
    {
        this.coreMdl = coreMdl;
    }

    @Override
    public UserMdl getCoreMdl()
    {
        return coreMdl;
    }

    public void initView()
    {
        UserCfg cfg = coreMdl.getUserCfg();
        iconMap = new java.util.HashMap<String, javax.swing.Icon>();
//        Bean.readIcon(MainPtn.class.getResourceAsStream(ConsEnv.ICON_PATH + "mpwd.png"), iconMap);
        gridMdl = new GridMdl(coreMdl.getUserCfg());

        try
        {
            java.io.File file = new java.io.File(cfg.getDataDir(), "mpwd.xml");
            menuPtn = new MenuPtn(coreMdl, this);
            menuPtn.loadData(file);
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
        }

        initGuidView();
        initPropView();
        initUserView();
        initBaseView();

        this.getContentPane().add(pl_KeysBase);

        menuBar = menuPtn.getMenuBar("mpwd", getRootPane());
        this.setJMenuBar(menuBar);

        toolBar = menuPtn.getToolBar("mpwd");
        this.getContentPane().add(toolBar, cfg.getToolLoc());

        this.setIconImage(Bean.getLogo(16));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initLang()
    {
        setTitle(Lang.getLang(LangRes.P30F7201, "魔方密码"));

        initGuidLang();
        initPropLang();
        initUserLang();
        initBaseLang();
    }

    public void initData()
    {
        UserCfg cfg = coreMdl.getUserCfg();

        // 菜单栏
        setMenuVisible(cfg.isMenuVisible());

        // 工具栏
        setToolVisible(cfg.isToolVisible());

        // 搜索栏
        mainFind.initData();
        setFindVisible(cfg.isFindVisible());

        // 信息栏
        mainInfo.initData();
        setInfoVisible(cfg.isInfoVisible());

        // 属性编辑组件
        eb_KeysEdit.initData();
        ed_KeysEdit.initData();
        for (IEditBean bean : editBean)
        {
            bean.initData();
        }

        // 列表菜单
        WButtonGroup group = menuPtn.getGroup("order-dir");
        if (group != null)
        {
            group.setSelected(cfg.getCfg(ConsCfg.CFG_VIEW_LIST_ASC, ConsCfg.DEF_FALSE), true);
        }
        group = menuPtn.getGroup("order-key");
        if (group != null)
        {
            group.setSelected(cfg.getCfg(ConsCfg.CFG_VIEW_LIST_KEY, "01"), true);
        }

        pack();
        Util.centerForm(this, null);
    }

    @Override
    public javax.swing.Icon getIcon(String hash)
    {
        javax.swing.Icon icon = iconMap.get(hash);
        if (icon == null)
        {
            icon = Bean.getIcon(hash);
        }
        return icon;
    }

    @Override
    public void setIcon(String hash, javax.swing.Icon icon)
    {
    }

    public boolean newKeys()
    {
        if (!clearGrid())
        {
            return false;
        }
        setEditVisible(true);
        showPropEdit(gridMdl.initGuid(), true);
        return true;
    }

    private static boolean isTaskKind(Kind kind)
    {
        return kind != null && kind.getC2010107() != null && kind.getC2010107().indexOf("task") >= 0;
    }

    public boolean saveKeys()
    {
        // 是否需要保存
        if (gridMdl.getRowCount() < ConsEnv.PWDS_HEAD_SIZE)
        {
            return false;
        }

        // 数据未被修改
        if (!gridMdl.isModified())
        {
            //Lang.showMesg(this, LangRes.P30F7A27, "您未曾修改过数据，不需要保存！");
            return false;
        }

        // 口令类别检测
        GuidItem guid = (GuidItem) gridMdl.getItemAt(ConsEnv.PWDS_HEAD_GUID);
        if (!com.magicpwd._util.Char.isValidate(guid.getData()))
        {
            javax.swing.tree.TreePath path = tr_GuidTree.getSelectionPath();
            if (path == null)
            {
                Lang.showMesg(this, LangRes.P30F7A0D, "请选择口令类别信息！");
                tr_GuidTree.requestFocus();
                return false;
            }

            KindTN node = (KindTN) path.getLastPathComponent();
            Kind kind = (Kind) node.getUserObject();
            if (isTaskKind(kind))
            {
                Lang.showMesg(this, LangRes.P30F7A4A, "不能保存到任务列表中去！");
                tr_GuidTree.requestFocus();
                return false;
            }
            gridMdl.getItemAt(ConsEnv.PWDS_HEAD_GUID).setData(kind.getC2010103());
        }

        // 标题为空检测
        MetaItem metaItem = (MetaItem) gridMdl.getItemAt(ConsEnv.PWDS_HEAD_META);
        if (!com.magicpwd._util.Char.isValidate(metaItem.getName()))
        {
            Lang.showMesg(this, LangRes.P30F7A0C, "请输入口令标题！");
            tb_KeysView.setRowSelectionInterval(1, 1);
            showPropEdit(metaItem, true);
            return false;
        }

        // 徽标
        LogoItem logoItem = (LogoItem) gridMdl.getItemAt(ConsEnv.PWDS_HEAD_LOGO);

        String keysHash = gridMdl.getKeysHash();

        try
        {
            gridMdl.saveData(true, true);
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
            Lang.showMesg(this, LangRes.P30F7A0E, "口令数据保存失败，请重新启动本程序后再次尝试！");
        }

        // 数据新增的情况下，需要重新显示列表信息
        if (com.magicpwd._util.Char.isValidateHash(keysHash))
        {
            mpwdMdl.getListMdl().updtName(keysHash, metaItem.getName(), logoItem.getName());
        }
        else
        {
            if (isSearch)
            {
                mpwdMdl.getListMdl().findName(queryKey);
            }
            else if (com.magicpwd._util.Char.isValidateHash(queryKey))
            {
                mpwdMdl.getListMdl().listName(queryKey);
            }
        }

        showPropInfo();
        mainInfo.initData();

        ls_LastIndx = -1;
        tb_LastIndx = -1;
        return true;
    }

    @Override
    public void setVisible(boolean visible)
    {
        if (!visible)
        {
            if (mailDlg != null && mailDlg.isVisible())
            {
                mailDlg.setVisible(false);
            }
            if (ed_KeysEdit != null && ed_KeysEdit.isVisible())
            {
                ed_KeysEdit.setVisible(false);
            }
            if (cfgForm != null && cfgForm.isVisible())
            {
                cfgForm.setVisible(false);
            }
        }
        super.setVisible(visible);
    }

    public MenuPtn getMenuPtn()
    {
        return menuPtn;
    }

    public void setEditVisible(boolean visible)
    {
        UserCfg cfg = coreMdl.getUserCfg();
        if (cfg.isEditIsolate())
        {
            ed_KeysEdit.setVisible(visible);
        }
        else
        {
            eb_KeysEdit.setVisible(visible);
        }
        cfg.setEditVisible(visible);
    }

    public void setEditIsolate(boolean isolate)
    {
        UserCfg cfg = coreMdl.getUserCfg();
        if (cfg.isEditVisible())
        {
            if (isolate)
            {
                eb_KeysEdit.setVisible(false);
                ed_KeysEdit.setPropView(pl_CardProp);
                ed_KeysEdit.setVisible(true);
            }
            else
            {
                eb_KeysEdit.setPropView(pl_CardProp);
                eb_KeysEdit.setVisible(true);
                ed_KeysEdit.setVisible(false);
            }
            cfg.setEditIsolate(isolate);
        }
    }

    public void setFindVisible(boolean visible)
    {
        mainFind.setVisible(visible);
        coreMdl.getUserCfg().setFindVisible(visible);
    }

    public void setInfoVisible(boolean visible)
    {
        mainInfo.setVisible(visible);
        coreMdl.getUserCfg().setInfoVisible(visible);
    }

    public void setMenuVisible(boolean visible)
    {
        menuBar.setVisible(visible);
        coreMdl.getUserCfg().setMenuVisible(visible);
    }

    public void setToolVisible(boolean visible)
    {
        toolBar.setVisible(visible);
        coreMdl.getUserCfg().setToolVisible(visible);
    }

    public javax.swing.tree.TreePath getSelectedKindValue()
    {
        return tr_GuidTree.getSelectionPath();
    }

    public int getSelectedKindIndex()
    {
        return 0;
    }

    public Object getSelectedListValue()
    {
        return ls_GuidList.getSelectedValue();
    }

    public int getSelectedListIndex()
    {
        return ls_GuidList.getSelectedIndex();
    }

    @Override
    public void selectNext(int step, boolean updt)
    {
        if (updt)
        {
            gridMdl.fireTableDataChanged();
        }
        else if (step == 0)
        {
            return;
        }

        int c = tb_KeysView.getRowCount() - 1;
        int n = tb_LastIndx + step;
        if (n < 0)
        {
            n = 0;
        }
        if (n > c)
        {
            n = c;
        }
        tb_LastIndx = n;
        tb_KeysView.setRowSelectionInterval(tb_LastIndx, tb_LastIndx);
        Util.scrollToVisible(tb_KeysView, tb_LastIndx, 0, true);
        showPropEdit(gridMdl.getItemAt(tb_LastIndx), true);

//        if (updt)
//        {
//            tb_LastIndx += 1;
//            if (tb_LastIndx > c)
//            {
//                tb_LastIndx = c;
//                UserMdl.getGridMdl().fireTableDataChanged();
//            }
//            tb_KeysView.setRowSelectionInterval(tb_LastIndx, tb_LastIndx);
//
//            IEditItem tplt = UserMdl.getGridMdl().getItemAt(tb_LastIndx);
//            showPropEdit(tplt, true);
//        }
//        else
//        {
//            if (tb_LastIndx < 0 || tb_LastIndx > c)
//            {
//                tb_LastIndx = c;
//            }
//            UserMdl.getGridMdl().fireTableDataChanged();
//            tb_KeysView.setRowSelectionInterval(tb_LastIndx, tb_LastIndx);
//            tb_KeysView.requestFocus();
//        }
//
//        Util.scrollToVisible(tb_KeysView, tb_LastIndx, 0, true);
//        showPropEdit(UserMdl.getGridMdl().getItemAt(tb_LastIndx), true);
    }

    public void appendBean(int type)
    {
        if (checkData())
        {
            tb_LastIndx = tb_KeysView.getSelectedRow();
            if (tb_LastIndx < ConsEnv.PWDS_HEAD_SIZE)
            {
                tb_LastIndx = tb_KeysView.getRowCount();
            }
            showPropEdit(gridMdl.wAppend(tb_LastIndx, type), true);
            tb_KeysView.setRowSelectionInterval(tb_LastIndx, tb_LastIndx);
        }
    }

    public void changeBean(int type)
    {
        if (checkData())
        {
            int idx = tb_KeysView.getSelectedRow();
            if (idx >= ConsEnv.PWDS_HEAD_SIZE && idx < tb_KeysView.getRowCount())
            {
                IEditItem tplt = gridMdl.getItemAt(idx);
                if (tplt.getType() != type)
                {
                    tplt.setType(type);
                    showPropEdit(tplt, true);
                    gridMdl.setModified(true);
                }
            }
        }
    }

    public void movePrev()
    {
        int t = tb_LastIndx - 1;
        if (t < ConsEnv.PWDS_HEAD_SIZE)
        {
            return;
        }
        gridMdl.wMoveto(tb_LastIndx, t);
        tb_LastIndx = t;
        Util.scrollToVisible(tb_KeysView, tb_LastIndx, 0, true);
        tb_KeysView.setRowSelectionInterval(tb_LastIndx, tb_LastIndx);
    }

    public void moveNext()
    {
        int t = tb_LastIndx + 1;
        if (t <= ConsEnv.PWDS_HEAD_SIZE || t >= tb_KeysView.getRowCount())
        {
            return;
        }
        gridMdl.wMoveto(tb_LastIndx, t);
        tb_LastIndx = t;
        Util.scrollToVisible(tb_KeysView, tb_LastIndx, 0, true);
        tb_KeysView.setRowSelectionInterval(tb_LastIndx, tb_LastIndx);
    }

    public void showList()
    {
        if (isSearch)
        {
            mpwdMdl.getListMdl().findName(queryKey);
        }
        else if (com.magicpwd._util.Char.isValidateHash(queryKey))
        {
            mpwdMdl.getListMdl().listName(queryKey);
        }
    }

    private void initPropView()
    {
        cl_CardProp = new java.awt.CardLayout();
        pl_CardProp = new javax.swing.JPanel();
        pl_CardProp.setLayout(cl_CardProp);
        editBean = new IEditBean[ConsDat.INDX_SIZE];
        int idx = 0;

        InfoBean beanInfo = new InfoBean(this);
        beanInfo.initView();
        pl_CardProp.add(ConsEnv.BEAN_INFO, beanInfo);
        editBean[idx++] = beanInfo;

        TextBean beanText = new TextBean(this);
        beanText.initView();
        pl_CardProp.add(ConsEnv.BEAN_TEXT, beanText);
        editBean[idx++] = beanText;

        PwdsBean beanPwds = new PwdsBean(this);
        beanPwds.initView();
        pl_CardProp.add(ConsEnv.BEAN_PWDS, beanPwds);
        editBean[idx++] = beanPwds;

        LinkBean beanLink = new LinkBean(this);
        beanLink.initView();
        pl_CardProp.add(ConsEnv.BEAN_LINK, beanLink);
        editBean[idx++] = beanLink;

        MailBean beanMail = new MailBean(this);
        beanMail.initView();
        pl_CardProp.add(ConsEnv.BEAN_MAIL, beanMail);
        editBean[idx++] = beanMail;

        DateBean beanDate = new DateBean(this);
        beanDate.initView();
        pl_CardProp.add(ConsEnv.BEAN_DATE, beanDate);
        editBean[idx++] = beanDate;

        AreaBean beanArea = new AreaBean(this);
        beanArea.initView();
        pl_CardProp.add(ConsEnv.BEAN_AREA, beanArea);
        editBean[idx++] = beanArea;

        FileBean beanFile = new FileBean(this);
        beanFile.initView();
        pl_CardProp.add(ConsEnv.BEAN_FILE, beanFile);
        editBean[idx++] = beanFile;

        DataBean beanData = new DataBean(this);
        beanData.initView();
        pl_CardProp.add(ConsEnv.BEAN_DATA, beanData);
        editBean[idx++] = beanData;

        GuidBean beanGuid = new GuidBean(this);
        beanGuid.initView();
        pl_CardProp.add(ConsEnv.BEAN_GUID, beanGuid);
        editBean[idx++] = beanGuid;

        MetaBean beanMeta = new MetaBean(this);
        beanMeta.initView();
        pl_CardProp.add(ConsEnv.BEAN_META, beanMeta);
        editBean[idx++] = beanMeta;

        LogoBean beanIcon = new LogoBean(this);
        beanIcon.initView();
        pl_CardProp.add(ConsEnv.BEAN_ICON, beanIcon);
        editBean[idx++] = beanIcon;

        HintBean beanNote = new HintBean(this);
        beanNote.initView();
        pl_CardProp.add(ConsEnv.BEAN_NOTE, beanNote);
        editBean[idx++] = beanNote;

        eb_KeysEdit = new EditBar();
        eb_KeysEdit.initView();

        ed_KeysEdit = new EditDlg(this);
        ed_KeysEdit.initView();
    }

    private void initGuidView()
    {
        pl_KeysGuid = new javax.swing.JPanel();

        javax.swing.JSplitPane sp = new javax.swing.JSplitPane();
        sp.setDividerLocation(180);
        sp.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        sp.setOneTouchExpandable(true);

        kindPop = menuPtn.getPopMenu("kind");

        tr_GuidTree = new javax.swing.JTree();
        tr_GuidTree.setComponentPopupMenu(kindPop);
        tr_GuidTree.setCellRenderer(new TreeCR());
        tr_GuidTree.setModel(mpwdMdl.getTreeMdl());
        tr_GuidTree.getSelectionModel().setSelectionMode(javax.swing.tree.TreeSelectionModel.SINGLE_TREE_SELECTION);
        javax.swing.ToolTipManager.sharedInstance().registerComponent(tr_GuidTree);
        tr_GuidTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener()
        {

            @Override
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt)
            {
                tr_GuidTreeValueChanged(evt);
            }
        });

        javax.swing.JScrollPane sp1 = new javax.swing.JScrollPane();
        sp1.setViewportView(tr_GuidTree);
        sp.setTopComponent(sp1);

        listPop = menuPtn.getPopMenu("list");

        ls_GuidList = new javax.swing.JList();
        ls_GuidList.setCellRenderer(new KeysCR(this));
        ls_GuidList.setModel(mpwdMdl.getListMdl());
        ls_GuidList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ls_GuidList.addMouseListener(new java.awt.event.MouseAdapter()
        {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                ls_GuidListMouseClicked(e);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e)
            {
                ls_GuidListMousePressed(e);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e)
            {
                ls_GuidListMouseReleased(e);
            }
        });

        javax.swing.JScrollPane sp2 = new javax.swing.JScrollPane();
        sp2.setViewportView(ls_GuidList);
        sp.setRightComponent(sp2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(pl_KeysGuid);
        pl_KeysGuid.setLayout(layout);

        javax.swing.GroupLayout.SequentialGroup hsg = layout.createSequentialGroup();
        hsg.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE);
        hsg.addGap(3);
        layout.setHorizontalGroup(hsg);

        javax.swing.GroupLayout.SequentialGroup vsg = layout.createSequentialGroup();
        vsg.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE);
        layout.setVerticalGroup(vsg);
    }

    private void initUserView()
    {
        pl_KeysInfo = new javax.swing.JPanel();

        mainFind = new FindBar(this, mpwdMdl.getListMdl());
        mainFind.initView();

        gridPop = menuPtn.getPopMenu("grid");

        tb_KeysView = new javax.swing.JTable();
        tb_KeysView.setModel(gridMdl);
        tb_KeysView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tb_KeysView.getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        javax.swing.AbstractAction action = new javax.swing.AbstractAction()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tr_GuidTree.requestFocus();
            }
        };
        Bean.registerKeyStrokeAction(rootPane, javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK), action, "guid-kind", javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
        action = new javax.swing.AbstractAction()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ls_GuidList.requestFocus();
            }
        };
        Bean.registerKeyStrokeAction(rootPane, javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_MASK), action, "guid-list", javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);
        action = new javax.swing.AbstractAction()
        {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tb_KeysView.requestFocus();
            }
        };
        Bean.registerKeyStrokeAction(rootPane, javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK), action, "guid-grid", javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW);

        tb_KeysView.addMouseListener(new java.awt.event.MouseAdapter()
        {

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                // 右键事件处理
                if (evt.isPopupTrigger())
                {
                    int row = tb_KeysView.rowAtPoint(evt.getPoint());
                    tb_KeysView.setRowSelectionInterval(row, row);
                    gridPop.show(tb_KeysView, evt.getX(), evt.getY());
                }
                else
                {
                    tb_ItemListMouseReleased(evt);
                }
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                // 右键事件处理
                if (evt.isPopupTrigger())
                {
                    int row = tb_KeysView.rowAtPoint(evt.getPoint());
                    tb_KeysView.setRowSelectionInterval(row, row);
                    gridPop.show(tb_KeysView, evt.getX(), evt.getY());
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                // 右键事件处理
                if (evt.isPopupTrigger())
                {
                    int row = tb_KeysView.rowAtPoint(evt.getPoint());
                    tb_KeysView.setRowSelectionInterval(row, row);
                    gridPop.show(tb_KeysView, evt.getX(), evt.getY());
                }
            }
        });
        tb_KeysView.addKeyListener(new java.awt.event.KeyAdapter()
        {

            @Override
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                tb_ItemListKeyReleased(evt);
            }
        });

        int w = tb_KeysView.getFontMetrics(tb_KeysView.getFont()).stringWidth("999999");
        tb_KeysView.getColumnModel().getColumn(0).setPreferredWidth(w);
        tb_KeysView.getColumnModel().getColumn(1).setPreferredWidth(365 - w);
        sp_KeysView = new javax.swing.JScrollPane(tb_KeysView);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(pl_KeysInfo);
        pl_KeysInfo.setLayout(layout);
        javax.swing.GroupLayout.ParallelGroup hpg = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        hpg.addComponent(sp_KeysView, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE);
        hpg.addComponent(eb_KeysEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        hpg.addComponent(mainFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);

        javax.swing.GroupLayout.SequentialGroup hsg = layout.createSequentialGroup();
        hsg.addGap(5);
        hsg.addGroup(hpg);
        layout.setHorizontalGroup(hsg);

        javax.swing.GroupLayout.SequentialGroup vsg = layout.createSequentialGroup();
        vsg.addComponent(mainFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        vsg.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg.addComponent(sp_KeysView, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE);
        vsg.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        vsg.addComponent(eb_KeysEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        layout.setVerticalGroup(vsg);
    }

    private void initBaseView()
    {
        pl_KeysBase = new javax.swing.JPanel();

        mainInfo = new HintBar(this, coreMdl.getHintMdl());
        mainInfo.initView();

        javax.swing.JSplitPane sp = new javax.swing.JSplitPane();
        sp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sp.setDividerLocation(160);
        sp.setOneTouchExpandable(true);
        sp.setLeftComponent(pl_KeysGuid);
        sp.setRightComponent(pl_KeysInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(pl_KeysBase);
        pl_KeysBase.setLayout(layout);
        javax.swing.GroupLayout.SequentialGroup hsg = layout.createSequentialGroup();
        hsg.addContainerGap();
        hsg.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE);
        hsg.addContainerGap();
        javax.swing.GroupLayout.ParallelGroup hpg = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        hpg.addGroup(hsg);
        hpg.addComponent(mainInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 560, Short.MAX_VALUE);
        layout.setHorizontalGroup(hpg);

        javax.swing.GroupLayout.SequentialGroup vsg = layout.createSequentialGroup();
        vsg.addContainerGap();
        vsg.addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE);
        vsg.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 10, 20);
        vsg.addComponent(mainInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE);
        layout.setVerticalGroup(vsg);
    }

    private void initGuidLang()
    {
        Lang.setWTips(tr_GuidTree, LangRes.P30F7B08, "类别列表(Alt + G)");
        Lang.setWTips(ls_GuidList, LangRes.P30F7B09, "口令列表(Alt + K)");
        Lang.setWTips(sp_KeysView, LangRes.P30F7B0A, "属性列表(Alt + T)");
    }

    private void initPropLang()
    {
        eb_KeysEdit.initLang();
        ed_KeysEdit.initLang();

        for (IEditBean bean : editBean)
        {
            bean.initLang();
        }
    }

    private void initUserLang()
    {
    }

    private void initBaseLang()
    {
        mainInfo.initLang();
        mainFind.initLang();
    }

    @Override
    protected void processWindowEvent(java.awt.event.WindowEvent e)
    {
        if (e.getID() == java.awt.event.WindowEvent.WINDOW_CLOSING)
        {
            if (gridMdl.isModified() && javax.swing.JOptionPane.YES_OPTION != Lang.showFirm(this, LangRes.P30F7A42, "您的数据尚未保存，确认要退出吗？"))
            {
                return;
            }
            setVisible(false);
            TrayPtn.endSave();
        }
        else if (e.getID() == java.awt.event.WindowEvent.WINDOW_ICONIFIED)
        {
            setVisible(false);
            TrayPtn.getInstance().showTips(Lang.getLang(LangRes.P30F9A01, "友情提示"), Lang.getLang(LangRes.P30F7A43, "魔方密码仍在运行中，您可以通过双击此处显示主窗口！"));
            endSave();
        }
        super.processWindowEvent(e);
    }

    @Override
    public void requestFocus()
    {
        mainFind.requestFocus();
    }

    private void tr_GuidTreeValueChanged(javax.swing.event.TreeSelectionEvent evt)
    {
        javax.swing.tree.TreePath path = tr_GuidTree.getSelectionPath();
        if (path == null)
        {
            return;
        }

        Object obj = path.getLastPathComponent();
        if (obj instanceof KindTN)
        {
            KindTN item = (KindTN) obj;
            Kind kind = (Kind) item.getUserObject();
            if (isTaskKind(kind))
            {
                listTask(kind);
            }
            else
            {
                queryKey = kind.getC2010103();
                mpwdMdl.getListMdl().listName(queryKey);
            }
        }
        isSearch = false;
    }

    private void listTask(Kind kind)
    {
        String task = kind.getC2010107();
        java.util.Calendar c = java.util.Calendar.getInstance();
        java.util.Date s = c.getTime();
        if ("task".equals(task))
        {
            c.set(java.util.Calendar.HOUR_OF_DAY, 0);
            c.set(java.util.Calendar.MINUTE, 0);
            c.set(java.util.Calendar.SECOND, 0);
            c.set(java.util.Calendar.MILLISECOND, 0);
            c.add(java.util.Calendar.DAY_OF_MONTH, 1);
            mpwdMdl.getListMdl().listTask(s, c.getTime());
            return;
        }
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\d+").matcher(task);
        if (!matcher.find())
        {
            return;
        }
        int time = Integer.parseInt(matcher.group());
        if (task.endsWith("second"))
        {
            c.add(java.util.Calendar.SECOND, time);
            mpwdMdl.getListMdl().listTask(s, c.getTime());
            return;
        }
        if (task.endsWith("minute"))
        {
            c.add(java.util.Calendar.MINUTE, time);
            mpwdMdl.getListMdl().listTask(s, c.getTime());
            return;
        }
        if (task.endsWith("hour"))
        {
            c.add(java.util.Calendar.HOUR_OF_DAY, time);
            mpwdMdl.getListMdl().listTask(s, c.getTime());
            return;
        }
        if (task.endsWith("day"))
        {
            c.add(java.util.Calendar.DAY_OF_MONTH, time);
            mpwdMdl.getListMdl().listTask(s, c.getTime());
            return;
        }
        if (task.endsWith("week"))
        {
            c.add(java.util.Calendar.WEEK_OF_YEAR, time);
            mpwdMdl.getListMdl().listTask(s, c.getTime());
            return;
        }
        if (task.endsWith("month"))
        {
            c.add(java.util.Calendar.MONTH, time);
            mpwdMdl.getListMdl().listTask(s, c.getTime());
            return;
        }
        if (task.endsWith("year"))
        {
            c.add(java.util.Calendar.YEAR, time);
            mpwdMdl.getListMdl().listTask(s, c.getTime());
            return;
        }
    }

    private void ls_GuidListMouseClicked(java.awt.event.MouseEvent e)
    {
        int i = ls_GuidList.getSelectedIndex();
        // 重复事件判断
        if (i == ls_LastIndx)
        {
            return;
        }

        // 记录上次索引
        ls_LastIndx = i;
        if (ls_LastIndx < 0)
        {
            return;
        }

        if (gridMdl.isModified())
        {
            if (Lang.showFirm(this, LangRes.P30F7A09, "记录数据 {0} 已修改，要放弃修改吗？", gridMdl.getItemAt(ConsEnv.PWDS_HEAD_META).getName()) != javax.swing.JOptionPane.YES_OPTION)
            {
                ls_GuidList.setSelectedIndex(ls_LastIndx);
                return;
            }
        }

        Object obj = ls_GuidList.getSelectedValue();
        if (!(obj instanceof Keys))
        {
            return;
        }

        Keys keys = (Keys) obj;

        try
        {
            tb_LastIndx = -1;
            gridMdl.clear();
            gridMdl.loadData(keys.getP30F0104());

            WButtonGroup group = menuPtn.getGroup("label");
            if (group != null)
            {
                group.setSelected(Integer.toString(keys.getP30F0102()), true);
            }
            group = menuPtn.getGroup("major");
            if (group != null)
            {
                group.setSelected(Integer.toString(keys.getP30F0103()), true);
            }
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
        }

        showPropInfo();
    }

    private void ls_GuidListMousePressed(java.awt.event.MouseEvent e)
    {
        if (e.isPopupTrigger())
        {
            int i = ls_GuidList.locationToIndex(e.getPoint());
            if (i > -1)
            {
                if (i != ls_LastIndx)
                {
                    ls_LastIndx = i;
                    ls_GuidList.setSelectedIndex(i);
                }
                listPop.show(ls_GuidList, e.getX(), e.getY());
            }
            return;
        }
    }

    private void ls_GuidListMouseReleased(java.awt.event.MouseEvent e)
    {
        if (e.isPopupTrigger())
        {
            int i = ls_GuidList.locationToIndex(e.getPoint());
            if (i > -1)
            {
                if (i != ls_LastIndx)
                {
                    ls_LastIndx = i;
                    ls_GuidList.setSelectedIndex(i);
                }
                listPop.show(ls_GuidList, e.getX(), e.getY());
            }
            return;
        }
    }

    private void tb_ItemListMouseReleased(java.awt.event.MouseEvent evt)
    {
        // 左键事件处理
        int row = tb_KeysView.getSelectedRow();
        if (row < 0 || row > tb_KeysView.getRowCount() || row == tb_LastIndx)
        {
            return;
        }
        tb_LastIndx = row;
        showPropEdit(gridMdl.getItemAt(row), true);
    }

    private void tb_ItemListKeyReleased(java.awt.event.KeyEvent evt)
    {
        int row = tb_KeysView.getSelectedRow();
        if (row < 0 || row > tb_KeysView.getRowCount() || row == tb_LastIndx)
        {
            return;
        }
        tb_LastIndx = row;
        showPropEdit(gridMdl.getItemAt(row), false);
    }

    public void showPropInfo()
    {
        if (coreMdl.getUserCfg().isEditVisible())
        {
            editBean[ConsDat.INDX_INFO].showData(null);
            cl_CardProp.show(pl_CardProp, ConsEnv.BEAN_INFO);
            editBean[ConsDat.INDX_INFO].requestFocus();
        }
    }

    public void showPropEdit(IEditItem item, boolean focus)
    {
        if (coreMdl.getUserCfg().isEditVisible())
        {
            cl_CardProp.show(pl_CardProp, ConsEnv.BEAN_PROP + item.getType());
            editBean[item.getType()].showData(item);

            if (focus)
            {
                editBean[item.getType()].requestFocus();
            }

            String title = getPropName(item.getType());
            eb_KeysEdit.setTitle(title);
            ed_KeysEdit.setTitle(title);
        }
    }

    private String getPropName(int type)
    {
        switch (type)
        {
            case ConsDat.INDX_INFO:
            {
                return Lang.getLang(LangRes.P30F1101, "提示");
            }
            case ConsDat.INDX_TEXT:
            {
                return Lang.getLang(LangRes.P30F1102, "文本");
            }
            case ConsDat.INDX_PWDS:
            {
                return Lang.getLang(LangRes.P30F1103, "口令");
            }
            case ConsDat.INDX_LINK:
            {
                return Lang.getLang(LangRes.P30F1104, "链接");
            }
            case ConsDat.INDX_MAIL:
            {
                return Lang.getLang(LangRes.P30F1105, "邮件");
            }
            case ConsDat.INDX_DATE:
            {
                return Lang.getLang(LangRes.P30F1106, "日期");
            }
            case ConsDat.INDX_AREA:
            {
                return Lang.getLang(LangRes.P30F1107, "附注");
            }
            case ConsDat.INDX_FILE:
            {
                return Lang.getLang(LangRes.P30F1108, "文件");
            }
            case ConsDat.INDX_GUID:
            {
                return Lang.getLang(LangRes.P30F1109, "向导");
            }
            case ConsDat.INDX_META:
            {
                return Lang.getLang(LangRes.P30F110A, "标题");
            }
            case ConsDat.INDX_LOGO:
            {
                return Lang.getLang(LangRes.P30F1112, "徽标");
            }
            case ConsDat.INDX_HINT:
            {
                return Lang.getLang(LangRes.P30F110B, "提醒");
            }
            default:
            {
                return Lang.getLang(LangRes.P30F110C, "属性");
            }
        }
    }

    private boolean checkData()
    {
        if (tb_KeysView.getRowCount() == 1)
        {
            Lang.showMesg(this, LangRes.P30F7A01, "");
            editBean[ConsDat.INDX_GUID].requestFocus();
            return false;
        }
        if (tb_KeysView.getRowCount() > 1)
        {
            return true;
        }

        if (!coreMdl.getUserCfg().isEditVisible())
        {
            coreMdl.getUserCfg().setEditVisible(true);
            coreMdl.getUserCfg().setEditIsolate(true);
            setEditVisible(true);
        }

        showPropEdit(gridMdl.initGuid(), true);
        return false;
    }

    public void endSave()
    {
        // Save Temperary Data
        if (gridMdl.isModified())
        {
            gridMdl.setInterim(true);
            gridMdl.getItemAt(ConsEnv.PWDS_HEAD_GUID).setData(ConsDat.HASH_ROOT);
            try
            {
                gridMdl.saveData(true, false);
            }
            catch (Exception exp)
            {
                Logs.exception(exp);
            }
        }
    }

    public IEditItem getMeta()
    {
        return gridMdl.getItemAt(ConsEnv.PWDS_HEAD_META);
    }

    public void changeLabel(int mode)
    {
        gridMdl.setKeysLabel(mode);
    }

    public void changeMajor(int note)
    {
        gridMdl.setKeysMajor(note);
    }

    public void changeKind(String hash)
    {
        if (gridMdl.setKeysKind(hash))
        {
            mpwdMdl.getListMdl().wRemove(ls_LastIndx);
        }
    }

    public boolean exportData()
    {
        javax.swing.tree.TreePath path = getSelectedKindValue();
        KindTN node = (KindTN) path.getLastPathComponent();
        Kind kind = (Kind) node.getUserObject();

        javax.swing.JFileChooser jfc = new javax.swing.JFileChooser();
        jfc.setMultiSelectionEnabled(false);
        jfc.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        int status = jfc.showSaveDialog(this);
        if (status != javax.swing.JFileChooser.APPROVE_OPTION)
        {
            return false;
        }
        java.io.File file = jfc.getSelectedFile();
        if (file.exists())
        {
            if (Lang.showFirm(this, LangRes.P30F7A21, "目标文件已存在，确认要覆盖此文件么？") != javax.swing.JOptionPane.YES_OPTION)
            {
                return false;
            }
        }
        else
        {
            try
            {
                file.createNewFile();
            }
            catch (Exception exp)
            {
                Logs.exception(exp);
                Lang.showMesg(this, LangRes.P30F7A22, "数据导出失败，无法在指定文件创建文档！");
                return false;
            }
        }
        if (!file.isFile())
        {
            Lang.showMesg(this, LangRes.P30F7A23, "数据导出失败，您选择的对象不是一个合适的文档！");
            return false;
        }
        if (!file.canWrite())
        {
            Lang.showMesg(this, LangRes.P30F7A24, "数据导出失败，请确认您是否拥有合适的读写权限！");
            return false;
        }

        try
        {
            Jcsv csv = new Jcsv(file);
            java.util.ArrayList<java.util.ArrayList<String>> data = new java.util.ArrayList<java.util.ArrayList<String>>();
            int size = gridMdl.wExport(data, kind.getC2010103());
            csv.saveFile(data);
            Lang.showMesg(this, LangRes.P30F7A25, "成功导出数据个数：{0}", size + "");
        }
        catch (Exception exp)
        {
            Logs.exception(exp);
            Lang.showMesg(this, LangRes.P30F7A26, "数据导出失败，请确认您数据的正确性，然后重新尝试！");
        }
        return true;
    }

    public boolean importData()
    {
        javax.swing.tree.TreePath path = getSelectedKindValue();
        KindTN node = (KindTN) path.getLastPathComponent();
        Kind kind = (Kind) node.getUserObject();
        if (isTaskKind(kind))
        {
            Lang.showMesg(this, LangRes.P30F7A4A, "不能保存到任务列表中去！");
            tr_GuidTree.requestFocus();
            return false;
        }

        javax.swing.JFileChooser jfc = new javax.swing.JFileChooser();
        jfc.setMultiSelectionEnabled(false);
        jfc.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        int status = jfc.showOpenDialog(this);
        if (status != javax.swing.JFileChooser.APPROVE_OPTION)
        {
            return false;
        }
        java.io.File file = jfc.getSelectedFile();
        if (!file.exists())
        {
            Lang.showMesg(this, LangRes.P30F7A03, "");
            return false;
        }
        if (!file.isFile())
        {
            Lang.showMesg(this, LangRes.P30F7A04, "");
            return false;
        }
        if (!file.canRead())
        {
            Lang.showMesg(this, LangRes.P30F7A05, "");
            return false;
        }

        try
        {
            Jcsv csv = new Jcsv(file);
            java.util.ArrayList<java.util.ArrayList<String>> data = csv.readFile();
            int size = gridMdl.wImport(data, kind.getC2010103());
            mpwdMdl.getListMdl().listName(kind.getC2010103());
            Lang.showMesg(this, LangRes.P30F7A07, "成功导入数据个数：{0}", "" + size);

        }
        catch (Exception exp)
        {
            Logs.exception(exp);
            Lang.showMesg(this, LangRes.P30F7A08, "TXT文档格式解析出错，数据导入失败！");
        }
        return true;
    }

    public void backupData() throws Exception
    {
    }

    public void resumeData() throws Exception
    {
    }

    public boolean clearGrid()
    {
        if (gridModified())
        {
            if (Lang.showFirm(TrayPtn.getCurrForm(), LangRes.P30F7A09, "记录数据 {0} 已修改，要放弃修改吗？", getMeta().getName()) != javax.swing.JOptionPane.YES_OPTION)
            {
                return false;
            }
        }

        gridMdl.clear();
        tb_LastIndx = 0;

        return true;
    }

    public boolean gridModified()
    {
        return gridMdl.isModified();
    }

    public void removeSelected()
    {
        gridMdl.wRemove(tb_KeysView.getSelectedRow());
        selectNext(0, true);
    }

    public void updateSelected()
    {
        gridMdl.setModified(true);
        if (gridMdl.getRowCount() < ConsEnv.PWDS_HEAD_SIZE)
        {
            gridMdl.initBody(gridMdl.getItemAt(ConsEnv.PWDS_HEAD_GUID).getSpec(IEditItem.SPEC_GUID_TPLT));
        }
        selectNext(com.magicpwd._util.Char.isValidateHash(gridMdl.getKeysHash()) ? 0 : 1, true);
    }

    public void saveCfg(String key, String text) throws Exception
    {
        DBA3000.saveConfig(key, gridMdl.enCrypt(text));
    }

    public String readCfg(String key) throws Exception
    {
        String text = DBA3000.readConfig(key);
        if (com.magicpwd._util.Char.isValidate(text))
        {
            text = gridMdl.deCrypt(text);
        }
        return text;
    }

    public void enCrypt(java.io.File src, java.io.File dst) throws Exception
    {
        gridMdl.enCrypt(src, dst);
    }

    public void deCrypt(java.io.File src, java.io.File dst) throws Exception
    {
        gridMdl.deCrypt(src, dst);
    }

    public void exportCard(java.io.File srcFile, java.io.File dstFile, String fileExt)
    {
        try
        {
            Card card = new Card(gridMdl);
            if (ConsEnv.CARD_HTM.equals(fileExt))
            {
                dstFile = card.exportHtm(srcFile, dstFile);
            }
            else if (ConsEnv.CARD_TXT.equals(fileExt))
            {
                dstFile = card.exportTxt(srcFile, dstFile);
            }
            else if (ConsEnv.CARD_PNG.equals(fileExt))
            {
                dstFile = card.exportPng(srcFile, dstFile);
            }
            else if (ConsEnv.CARD_SVG.equals(fileExt))
            {
                dstFile = card.exportSvg(srcFile, dstFile);
            }
            else
            {
                dstFile = card.exportAll(srcFile, dstFile);
            }

            if (dstFile == null || !dstFile.exists())
            {
                Lang.showMesg(this, LangRes.P30F7A46, "生成卡片文件失败，请稍后重试！");
            }
            else if (javax.swing.JOptionPane.YES_OPTION == Lang.showFirm(TrayPtn.getCurrForm(), LangRes.P30F7A47, "生成卡片文件成功，要打开卡片文件吗？"))
            {
                if (!Desk.open(dstFile))
                {
                    Lang.showMesg(this, LangRes.P30F1A03, "打开文件错误，请尝试手动方式查看！");
                }
            }
        }
        catch (Exception ex)
        {
            Logs.exception(ex);
            Lang.showMesg(this, null, ex.getLocalizedMessage());
        }
    }

    public void showMailPtn()
    {
        if (mailDlg == null)
        {
            mailDlg = new MailDlg(coreMdl.getUserCfg());
            mailDlg.initView();
            mailDlg.initLang();
            mailDlg.initData();
            Util.centerForm(mailDlg, TrayPtn.getCurrForm());
        }

        MailPtn mailPtn = new MailPtn();
        mailPtn.initView();
        mailPtn.initLang();
        java.util.List<I1S2> mailList = gridMdl.wSelect(ConsDat.INDX_MAIL);
        mailPtn.initMail(mailList);
        if (mailList.size() < 1)
        {
            Lang.showMesg(this, null, "没有可用的邮件类型数据！");
            return;
        }
        java.util.List<I1S2> userList = gridMdl.wSelect(ConsDat.INDX_TEXT);
        mailPtn.initUser(userList);
        if (userList.size() < 1)
        {
            Lang.showMesg(this, null, "没有可用的文本类型数据！");
            return;
        }
        java.util.List<I1S2> pwdsList = gridMdl.wSelect(ConsDat.INDX_PWDS);
        mailPtn.initPwds(pwdsList);
        if (pwdsList.size() < 1)
        {
            Lang.showMesg(this, null, "没有可用的口令类型数据！");
            return;
        }
        if (javax.swing.JOptionPane.OK_OPTION != javax.swing.JOptionPane.showConfirmDialog(TrayPtn.getCurrForm(), mailPtn, "登录确认", javax.swing.JOptionPane.OK_CANCEL_OPTION))
        {
            return;
        }

        String mail = mailList.get(mailPtn.getMail()).getK();
        String user = userList.get(mailPtn.getUser()).getK();
        String pwds = pwdsList.get(mailPtn.getPwds()).getK();

        String host = mail.substring(mail.indexOf('@') + 1);
        if (!com.magicpwd._util.Char.isValidate(host))
        {
            return;
        }

        final Connect connect = new Connect(mail, pwds);
        connect.setUsername(user);
        if (!connect.useDefault())
        {
            Lang.showMesg(this, null, "查找不到对应的服务信息，如有疑问请与作者联系！");
            return;
        }

        mailDlg.setVisible(true);
        new Thread()
        {

            @Override
            public void run()
            {
                mailDlg.append(connect, "");
            }
        }.start();
    }

    public void showHistory()
    {
        if (histDlg == null)
        {
            histDlg = new HistDlg(gridMdl, this);
            histDlg.initView();
            histDlg.initLang();
            Util.centerForm(histDlg, this);
        }
        histDlg.initData();
        histDlg.setVisible(true);
    }

    public TreeMdl getTreeMdl()
    {
        return mpwdMdl.getTreeMdl();
    }

    public ListMdl getListMdl()
    {
        return mpwdMdl.getListMdl();
    }

    public void showOptions(String propName)
    {
        if (cfgForm == null)
        {
            cfgForm = new MdiDialog(coreMdl);
            cfgForm.initView();
            cfgForm.initLang();
            cfgForm.initData();
        }
        cfgForm.showProp(propName, true);
    }
    /**
     * 
     */
    private javax.swing.JPanel pl_KeysBase;
    /**
     * 数据导航面板，用于显示类别、口令列表等信息
     */
    private javax.swing.JPanel pl_KeysGuid;
    /**
     * 用户交互面板，用于显示查找、列表、编辑等信息
     */
    private javax.swing.JPanel pl_KeysInfo;
    /**
     * 属性编辑面板，用于显示边框及相关信息
     */
    private EditBar eb_KeysEdit;
    /**
     * 属性切换面板，用于显示不同属性的面板
     */
    private javax.swing.JPanel pl_CardProp;
    /**
     * 导航列表
     */
    private javax.swing.JList ls_GuidList;
    /**
     * 类别导航
     */
    private javax.swing.JTree tr_GuidTree;
    /**
     * 口令列表
     */
    private javax.swing.JTable tb_KeysView;
    private javax.swing.JScrollPane sp_KeysView;
    private java.awt.CardLayout cl_CardProp;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPopupMenu kindPop;
    private javax.swing.JPopupMenu listPop;
    private javax.swing.JPopupMenu gridPop;
}