/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magicpwd.__i;

/**
 *
 * @author Amon
 */
public interface IAction extends javax.swing.Action
{
    void doInit(Object object);

    void reInit(javax.swing.AbstractButton button);

    boolean isVisible();

    boolean isSelected();
}