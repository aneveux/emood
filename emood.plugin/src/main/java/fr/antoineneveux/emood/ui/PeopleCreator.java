package fr.antoineneveux.emood.ui;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;

public class PeopleCreator {

	private String name;

	private Shell shell;

	public PeopleCreator(Shell parent) {
		this.shell = new Shell(parent);
		InputDialog dialog = new InputDialog(this.shell, "New people",
				"Name : ", "", new PeopleValidator());
		dialog.open();
		this.name = dialog.getValue();
	}

	public String getName() {
		return this.name;
	}

	static class PeopleValidator implements IInputValidator {

		@Override
		public String isValid(String newText) {
			return (newText != null && newText.length() > 0) ? null
					: "Name can't be null...";
		}

	}

}
