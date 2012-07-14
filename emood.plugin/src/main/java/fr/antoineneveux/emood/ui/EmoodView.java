package fr.antoineneveux.emood.ui;

import java.text.MessageFormat;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import fr.antoineneveux.emood.Activator;
import fr.antoineneveux.emood.data.DataManager;
import fr.antoineneveux.emood.data.People;
import fr.antoineneveux.emood.data.Team;

public class EmoodView extends ViewPart {

	private ListViewer viewer;

	public EmoodView() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		createActions();
		FillLayout layout = new FillLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);
		createListViewer(parent);
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

	protected void createListViewer(Composite parent) {
		this.viewer = new ListViewer(parent, SWT.BORDER);
		this.viewer.setContentProvider(new EmoodContentProvider());
		this.viewer.setLabelProvider(new EmoodLabelProvider());
		//this.viewer.addSelectionChangedListener(null);
		this.viewer.setInput(DataManager.getInstance().getTeam());
	}

	static class EmoodContentProvider implements IStructuredContentProvider {

		@Override
		public void dispose() {
			// TODO Auto-generated method stub

		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub

		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Team)
				return ((Team) inputElement).getPeople().toArray();
			else
				return null;
		}

	}

	static class EmoodLabelProvider extends LabelProvider {

		@Override
		public Image getImage(Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getText(Object element) {
			if (element instanceof People)
				return ((People) element).getName();
			else
				return null;
		}

	}

}
