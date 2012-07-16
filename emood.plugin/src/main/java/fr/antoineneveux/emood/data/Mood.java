package fr.antoineneveux.emood.data;

import java.text.MessageFormat;

import org.eclipse.swt.graphics.Image;

import fr.antoineneveux.emood.Activator;

public enum Mood {

	ENTHUSIAST(3), HAPPY(2), CONFIDENT(1), SCEPTICAL(0), UNCERTAIN(-1), TIRED(
			-2), WORRIED(-3), BAD(-4), CRYING(-5)

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
				MessageFormat.format("/icons/faces/{0}.png", this.toString()
						.toLowerCase()));
	}

	public Image getImage(long value) throws MoodValueNotFoundException {
		for (Mood m : Mood.values()) {
			if (m.getValue() == value)
				return m.getImage();
		}
		throw new MoodValueNotFoundException();
	}

	@SuppressWarnings("serial")
	static class MoodValueNotFoundException extends Exception {

		public MoodValueNotFoundException() {
			super();
		}

		public MoodValueNotFoundException(String msg) {
			super(msg);
		}

		public MoodValueNotFoundException(Throwable t) {
			super(t);
		}

		public MoodValueNotFoundException(String msg, Throwable t) {
			super(msg, t);
		}

	}

}
