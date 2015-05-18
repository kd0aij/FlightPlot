package me.drton.flightplot;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by markw on 5/16/15.
 */
public class plotListCellRenderer implements ListCellRenderer {
    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
    protected Border noFocusBorder = new EmptyBorder(15, 1, 1, 1);
    protected Border focusBorder = LineBorder.createBlackLineBorder();

    public Component getListCellRendererComponent(JList paramlist, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(paramlist, value, index,
                isSelected, cellHasFocus);
        renderer.setBorder(cellHasFocus ? focusBorder : noFocusBorder);
        if (((ProcessorPreset) value).isVisible()) {
            renderer.setBackground(Color.pink);
        } else {
            renderer.setBackground(Color.lightGray);
        }
        return renderer;
    }
}
