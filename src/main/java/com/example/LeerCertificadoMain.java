package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class LeerCertificadoMain {
	
	
	public static void main(String argv[]) {
	
		try {
			
			CertificateFactory certificate = CertificateFactory.getInstance("X509");
			FileInputStream is = new FileInputStream("C:\\home\\AVALON\\CERTIFICADOS\\CERTIFICADOS_PRUEBAS\\ciudadano_ficticio.cer");
			X509Certificate cert = (X509Certificate) certificate.generateCertificate(is);
			
			System.out.print("CERTIFICADO TO STRING ="+cert.toString());
			System.out.print("CERTIFICADO BYTE ="+cert.getEncoded());
						

		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
