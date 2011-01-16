/*
 *  Copyright (C) 2011 Amon
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
package com.magicpwd.x.docs;

import com.magicpwd.__a.ADialog;
import com.magicpwd.__a.AFrame;
import com.magicpwd.__i.IDocsViewer;

/**
 * 源码查看
 * @author Amon
 */
public class SrcViewer extends ADialog implements IDocsViewer
{

    public SrcViewer(AFrame formPtn)
    {
        super(formPtn, true);
    }

    @Override
    public void show(java.io.File file)
    {
    }

    @Override
    protected boolean hideDialog()
    {
        setVisible(false);
        dispose();
        return true;
    }
}
