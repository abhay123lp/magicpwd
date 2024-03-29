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
 * $Id: TreeCellPainter.java 1097 2010-02-06 13:31:05Z kathryn@kathrynhuxtable.org $
 */
package com.seaglasslookandfeel.painter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JComponent;

import com.seaglasslookandfeel.painter.AbstractRegionPainter.PaintContext.CacheMode;

public final class TreeCellPainter extends AbstractRegionPainter {
    public enum Which {
        BACKGROUND_ENABLED_FOCUSED, BACKGROUND_ENABLED_SELECTED, BACKGROUND_SELECTED_FOCUSED,
    }

    private Which        state;
    private PaintContext ctx;

    private Color        focusColor      = decodeColor("nimbusFocus", 0.0f, 0.0f, 0.0f, 0);
    private Color        backgroundColor = decodeColor("nimbusSelectionBackground", 0.0f, 0.0f, 0.0f, 0);

    public TreeCellPainter(Which state) {
        super();
        this.state = state;
        this.ctx = new PaintContext(CacheMode.NO_CACHING);
    }

    @Override
    protected void doPaint(Graphics2D g, JComponent c, int width, int height, Object[] extendedCacheKeys) {
        switch (state) {
        case BACKGROUND_ENABLED_FOCUSED:
            paintBackgroundEnabledAndFocused(g, width, height);
            break;
        case BACKGROUND_ENABLED_SELECTED:
            paintBackgroundEnabledAndSelected(g, width, height);
            break;
        case BACKGROUND_SELECTED_FOCUSED:
            paintBackgroundSelectedAndFocused(g, width, height);
            break;
        }
    }

    @Override
    protected final PaintContext getPaintContext() {
        return ctx;
    }

    private void paintBackgroundEnabledAndFocused(Graphics2D g, int width, int height) {
        Shape s = decodeFocus(width, height);
        g.setPaint(focusColor);
        g.fill(s);
    }

    private void paintBackgroundEnabledAndSelected(Graphics2D g, int width, int height) {
        Shape s = decodeBackground(width, height);
        g.setPaint(backgroundColor);
        g.fill(s);
    }

    private void paintBackgroundSelectedAndFocused(Graphics2D g, int width, int height) {
        Shape s = decodeBackground(width, height);
        g.setPaint(backgroundColor);
        g.fill(s);
        s = decodeFocus(width, height);
        g.setPaint(focusColor);
        g.fill(s);
    }

    private Shape decodeFocus(int width, int height) {
        return shapeGenerator.createFillableFocusRectangle(0, 0, width, height);
    }

    private Shape decodeBackground(int width, int height) {
        return shapeGenerator.createRectangle(0, 0, width, height);
    }

}
