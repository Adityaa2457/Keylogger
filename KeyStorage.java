package handlers;

public class KeyStorage {
	
	private int keycode;
	private boolean keypressed;
	private long SystemsTimePressedMillis;
	
	public KeyStorage(int keycode, boolean keypressed, long systemsTimePressedMillis) {
		this.keycode = keycode;
		this.keypressed = keypressed;
		this.SystemsTimePressedMillis = systemsTimePressedMillis;
	}

	public int getKeycode() {
		return keycode;
	}

	public boolean isKeypressed() {
		return keypressed;
	}

	public long getSystemsTimePressedMillis() {
		return SystemsTimePressedMillis;
	}

	@Override
	public String toString() {
		return "KeyStorage [keycode=" + keycode + ", keypressed=" + keypressed + ", SystemsTimePressedMillis="
				+ SystemsTimePressedMillis + "]";
	}
	
	
	
	

}