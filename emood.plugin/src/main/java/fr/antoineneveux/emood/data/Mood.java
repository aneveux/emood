package fr.antoineneveux.emood.data;

import java.text.MessageFormat;

import org.eclipse.swt.graphics.Image;

import fr.antoineneveux.emood.Activator;

public enum Mood {

	HAPPY(1), NEUTRAL(0), SAD(-1),

	;

	private long value;

	private Mood(long value) {
		this.value = value;
	}

	public long getValue() {
		return this.value;
	}

	public Image getImage() {
		return Activator.getDefault().getImage(
				MessageFormat.format("/icons/{0}.png", this.getValue()));
	}

	public Image getImage(long value) {
		return Activator.getDefault().getImage(
				MessageFormat.format("/icons/{0}.png", value));
	}

}
