/**
 * This file is part of mycollab-ui.
 *
 * mycollab-ui is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-ui is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-ui.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.vaadin.ui;

import com.vaadin.ui.ComboBox;

/**
 * @author MyCollab Ltd
 * @since 5.1.3
 */
public class StyleComboBox extends ComboBox {
    private String styleName;
    @Override
    protected void setInternalValue(Object newValue) {
        ItemStyleGenerator itemStyleGenerator = this.getItemStyleGenerator();
        if (itemStyleGenerator != null) {
            String style = itemStyleGenerator.getStyle(this, newValue);
            if (styleName != null) {
                this.removeStyleName(styleName);
            }
            styleName = style;
            this.addStyleName(styleName);
        }
        super.setInternalValue(newValue);
    }
}