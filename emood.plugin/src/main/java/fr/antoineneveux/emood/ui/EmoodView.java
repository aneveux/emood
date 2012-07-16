package fr.antoineneveux.emood.ui;

import java.text.MessageFormat;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
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

	private TreeViewer viewer;

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
				String name = new PeopleCreator(EmoodView.this.getSite()
						.getShell()).getName();
				DataManager.getInstance().create(name);
				EmoodView.this.viewer.refresh();
			}
		};
		create.setImageDescriptor(Activator.imageDescriptorFromPlugin(
				Activator.PLUGIN_ID,
				MessageFormat.format("/icons/{0}.png", "create")));
		this.getViewSite().getActionBars().getToolBarManager().add(create);
	}

	protected void createListViewer(Composite parent) {
		this.viewer = new TreeViewer(parent, SWT.BORDER);
		this.viewer.setContentProvider(new EmoodContentProvider());
		this.viewer.setLabelProvider(new EmoodLabelProvider());
		// this.viewer.addSelectionChangedListener(null);
		this.viewer.setInput(DataManager.getInstance().getTeam());
	}

	static class EmoodContentProvider implements ITreeContentProvider {

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Team)
				return ((Team) parentElement).getPeople().toArray();
			return null;
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			return (element instanceof Team)
					&& ((Team) element).getPeople().size() > 0;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Team)
				return ((Team) inputElement).getPeople().toArray();
			return null;
		}

	}

	static class EmoodLabelProvider extends LabelProvider {

		@Override
		public Image getImage(Object element) {
			if (element instanceof People)
				return ((People) element).getMood().getImage();
			else
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
