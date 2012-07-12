package fr.antoineneveux.emood.ui;

import java.text.MessageFormat;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import fr.antoineneveux.emood.Activator;

public class EmoodView extends ViewPart {

	public EmoodView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		createActions();
		// TODO create GUI here
	}

	@Override
	public void setFocus() {

	}

	protected void createActions() {
		Action refresh = new Action() {
			public void run() {
				// TODO refresh
			}
		};
		refresh.setImageDescriptor(Activator.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID,
				MessageFormat.format("/icons/{0}.png", "refresh")));
		this.getViewSite().getActionBars().getToolBarManager().add(refresh);

		Action create = new Action() {
			public void run() {
				// TODO create
			}
		};
		create.setImageDescriptor(Activator.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID,
				MessageFormat.format("/icons/{0}.png", "create")));
		this.getViewSite().getActionBars().getToolBarManager().add(create);
	}

}
