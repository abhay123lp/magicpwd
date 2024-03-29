/*
 * Copyright (c) 2009 Kathryn Huxtable and Kenneth Orr.
 *
 * This file is part of the SeaGlass Pluggable Look and Feel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * $Id: TabbedPaneTabAreaPainter.java 1267 2010-02-20 22:13:51Z kathryn@kathrynhuxtable.org $
 */
package com.seaglasslookandfeel.painter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

import com.seaglasslookandfeel.painter.AbstractRegionPainter.PaintContext.CacheMode;

/**
 * Sea Glass TabbedPaneTabAreaPainter. Does nothing.
 */
public final class TabbedPaneTabAreaPainter extends AbstractRegionPainter {

    /**
     * DOCUMENT ME!
     *
     * @author  $author$
     * @version $Revision$, $Date$
     */
    public static enum Which {
        BACKGROUND_ENABLED_TOP, BACKGROUND_ENABLED_LEFT, BACKGROUND_ENABLED_BOTTOM, BACKGROUND_ENABLED_RIGHT,

        BACKGROUND_DISABLED_TOP, BACKGROUND_DISABLED_LEFT, BACKGROUND_DISABLED_BOTTOM, BACKGROUND_DISABLED_RIGHT,
    }

    private Color tabbedPaneTabAreaBackLineEnabled = decodeColor("tabbedPaneTabAreaBackLineEnabled");
    private Color tabbedPaneTabAreaLightShadow     = decodeColor("tabbedPaneTabAreaLightShadow");
    private Color tabbedPaneTabAreaDarkShadow      = decodeColor("tabbedPaneTabAreaDarkShadow");

    private Color tabbedPaneTabAreaBackLineDisabled = disable(tabbedPaneTabAreaBackLineEnabled);

    /** DOCUMENT ME! */
    public Which         state;
    private PaintContext ctx;
    private boolean      isDisabled;

    /**
     * Creates a new TabbedPaneTabAreaPainter object.
     *
     * @param state DOCUMENT ME!
     */
    public TabbedPaneTabAreaPainter(Which state) {
        super();
        this.state = state;
        this.ctx   = new PaintContext(CacheMode.NO_CACHING);

        switch (state) {

        case BACKGROUND_DISABLED_TOP:
        case BACKGROUND_DISABLED_LEFT:
        case BACKGROUND_DISABLED_BOTTOM:
        case BACKGROUND_DISABLED_RIGHT:
            isDisabled = true;
            break;

        case BACKGROUND_ENABLED_TOP:
        case BACKGROUND_ENABLED_LEFT:
        case BACKGROUND_ENABLED_BOTTOM:
        case BACKGROUND_ENABLED_RIGHT:
            isDisabled = false;
            break;
        }
    }

    /**
     * @see com.seaglasslookandfeel.painter.AbstractRegionPainter#doPaint(java.awt.Graphics2D,
     *      javax.swing.JComponent, int, int, java.lang.Object[])
     */
    protected void doPaint(Graphics2D g, JComponent c, int width, int height, Object[] extendedCacheKeys) {
        JTabbedPane tabPane     = (JTabbedPane) c;
        int         orientation = tabPane.getTabPlacement();

        if (orientation == JTabbedPane.LEFT || orientation == JTabbedPane.RIGHT) {
            paintVerticalLine(g, c, 0, height / 2, width, height);
        } else {
            paintHorizontalLine(g, c, 0, height / 2, width, height);
        }
    }

    /**
     * @see com.seaglasslookandfeel.painter.AbstractRegionPainter#getPaintContext()
     */
    protected PaintContext getPaintContext() {
        return ctx;
    }

    /**
     * DOCUMENT ME!
     *
     * @param g      DOCUMENT ME!
     * @param c      DOCUMENT ME!
     * @param x      DOCUMENT ME!
     * @param y      DOCUMENT ME!
     * @param width  DOCUMENT ME!
     * @param height DOCUMENT ME!
     */
    private void paintHorizontalLine(Graphics2D g, JComponent c, int x, int y, int width, int height) {
        g.setPaint(getTabbedPaneTabAreaPaint(x, y - 1, width, 4));
        g.fillRect(x, y - 1, width, 4);
        g.setPaint(getTabbedPaneTabAreaBackgroundPaint());
        g.drawLine(x, y, x + width - 1, y);
    }

    /**
     * DOCUMENT ME!
     *
     * @param g      DOCUMENT ME!
     * @param c      DOCUMENT ME!
     * @param x      DOCUMENT ME!
     * @param y      DOCUMENT ME!
     * @param width  DOCUMENT ME!
     * @param height DOCUMENT ME!
     */
    private void paintVerticalLine(Graphics2D g, JComponent c, int x, int y, int width, int height) {
        g.setPaint(getTabbedPaneTabAreaPaint(x, y - 1, width, 3));
        g.fillRect(x, y - 1, width, 3);
        g.setPaint(getTabbedPaneTabAreaBackgroundPaint());
        g.drawLine(x, y, x + width - 1, y);
    }

    /**
     * DOCUMENT ME!
     *
     * @param  x      DOCUMENT ME!
     * @param  y      DOCUMENT ME!
     * @param  width  DOCUMENT ME!
     * @param  height DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Paint getTabbedPaneTabAreaPaint(int x, int y, int width, int height) {
        float midX = x + width / 2;

        return createGradient(midX, y, midX, y + height, new float[] { 0f, 0.5f, 1f },
                              new Color[] { tabbedPaneTabAreaLightShadow, tabbedPaneTabAreaDarkShadow, tabbedPaneTabAreaLightShadow });
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Paint getTabbedPaneTabAreaBackgroundPaint() {
        return isDisabled ? tabbedPaneTabAreaBackLineDisabled : tabbedPaneTabAreaBackLineEnabled;
    }
}
