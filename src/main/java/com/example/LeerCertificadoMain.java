package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;

public class LeerCertificadoMain {
	
	
	public static void main(String argv[]) {
	
		try {
			
			CertificateFactory certificate = CertificateFactory.getInstance("X509");
			FileInputStream is = new FileInputStream("C:/home/AVALON/CERTIFICADOS/CERTIFICADOS_PRUEBAS/ciudadano_ficticio.cer");
			X509Certificate x509Certificate = (X509Certificate) certificate.generateCertificate(is);
			
		
			System.out.println("================================================================================");
			System.out.println("CERTIFICADO TO STRING ="+x509Certificate.toString());
			System.out.println("");
			
			System.out.println("EMISOR==========================================================================");			
			System.out.println(x509Certificate.getIssuerDN());
			System.out.println("");
			
			System.out.println("SUJETO=========================================================================");
			System.out.println(x509Certificate.getSubjectDN());
			System.out.println("");
			
			System.out.println("LEER DATOS DEL CETIFICADO========================================================");
			X500Name x500Name = new X500Name( x509Certificate.getSubjectX500Principal().getName());
			RDN cn = x500Name.getRDNs(BCStyle.CN)[0];	
			RDN serialNumber = x500Name.getRDNs(BCStyle.SERIALNUMBER)[0];	
			
			System.out.println("CN="+cn.getFirst().getValue());
			System.out.println("SERIALNUMBER="+serialNumber.getFirst().getValue());
			
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
