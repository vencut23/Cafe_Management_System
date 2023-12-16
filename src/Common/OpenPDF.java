package Common;

import java.io.File;

import javax.swing.JOptionPane;

public class OpenPDF {
    public static void openByid(String id) {
    	try {
    		if((new File("C:\\"+id+".pdf").exists())){
    			Process p=Runtime.getRuntime().exec("rundll32 url.dll.FileProtocolHandler E:\\"+id+".pdf");
    		}else
    			JOptionPane.showMessageDialog(null, "file not Exists");
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    }

	
}
