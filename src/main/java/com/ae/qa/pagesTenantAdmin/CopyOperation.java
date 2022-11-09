package com.ae.qa.pagesTenantAdmin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyOperation {

	private static void copyFileUsingStream(File source, File dest) throws IOException {
	InputStream is = null;
	OutputStream os = null;
	try {
	is = new FileInputStream("C:\\Users\\kalyanig\\Downloads\\AE_Automation_UploadFiles\\oauth-authorization-server.json");
	os = new FileOutputStream("C:\\Users\\kalyanig\\Downloads\\AE_Automation_UploadFiles\\oauth-authorization-server_paste.txt");
	byte[] buffer = new byte[1024];
	int length;
	while ((length = is.read(buffer)) > 0) {
	os.write(buffer, 0, length); // Vulnerability(stored XSS) is detected at this line.
	
	}
	} finally {
		System.out.println(os);
	is.close();
	os.close();
	}
	}

}
