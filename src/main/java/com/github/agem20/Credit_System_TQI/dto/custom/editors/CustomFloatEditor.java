package com.github.agem20.Credit_System_TQI.dto.custom.editors;

import java.beans.PropertyEditorSupport;

public class CustomFloatEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text){
        text = text.replaceAll("[^\\d,]+", "");
        text = text.replaceAll("[,]+", ".");
        if(!text.isEmpty()){
            Float c = Float.parseFloat(text);
            this.setValue(c);
        }

    }

}