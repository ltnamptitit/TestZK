package com;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class registration extends SelectorComposer<Window>{
	@Wire
	Textbox textboxName;
	@Wire
	Datebox dateboxBirthday;
	@Wire
	Radiogroup selectGender;
	@Wire
	Checkbox termCheck;
	@Wire
	Button clearFormButton;
	@Wire
	Button submitFormButton;
	
	@Listen("onCheck=#termCheck")
	public void onCheckTermOfUser () {
		if(termCheck.isChecked()) {
			submitFormButton.setDisabled(false);
		}
		else {
			submitFormButton.setDisabled(true);
		}
	}
	
	@Listen("onClick=#clearFormButton")
	public void clearRegistrationForm() {
		submitFormButton.setDisabled(true);
		textboxName.setValue(" ");
		dateboxBirthday.setValue(null);
		selectGender.setSelectedIndex(2);
		termCheck.setChecked(false);
	}
}
