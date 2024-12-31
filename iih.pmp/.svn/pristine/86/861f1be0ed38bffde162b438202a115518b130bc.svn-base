package iih.pmp.wxpay.cmbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * ������������ļ��ļ��غͻ�ȡ
 * @author Administrator
 */
public class Config {


	private static final String propsPath = "config.properties";
//	private static final String cust0001Path = "cust0001.sm2";
//	private static final String cust0001cerPath = "cust0001.cer";
////	private static final String cmbcTestPath = "cmbcTest.sm2";
//	private static final String cmbcTestcerPath = "cmbcTest.cer";
	private static Properties props = new Properties();
	private static boolean initFlag = false;
	private static  PmpPayAppBaseUtils utils=new PmpPayAppBaseUtils();
	/**
	 * ��ʼ�������ļ�
	 */
	private static synchronized void init() {
		if (!initFlag) {
			InputStream in = null;
			InputStream cust0001in = null;
			InputStream cust0001cerin = null;
			InputStream cmbcTestcerin = null;
			try {
				in = Config.class.getClassLoader().getResourceAsStream(propsPath);
				
				String dir=System.getProperties().getProperty("user.home");
				File file = new File(dir+"\\cmbccer");
				if(!file.exists()) {
					file.mkdir();
				}
				props.load(in);
				String cust0001Path=props.getProperty("merchantPrivateKeyName");
				String cust0001cerPath=props.getProperty("merchantPublicKeyName");
				String cmbcTestcerPath=props.getProperty("bankPublicKeyName");
				cust0001in = Config.class.getClassLoader().getResourceAsStream(cust0001Path);
				cust0001cerin = Config.class.getClassLoader().getResourceAsStream(cust0001cerPath);
				cmbcTestcerin = Config.class.getClassLoader().getResourceAsStream(cmbcTestcerPath);
				if(createfile(cust0001in,cust0001Path,dir+"\\cmbccer")) {
					props.put("merchantPrivateKey", dir+"\\cmbccer\\"+cust0001Path);
				}
                if(createfile(cust0001cerin,cust0001cerPath,dir+"\\cmbccer")) {
                	props.put("merchantPublicKey", dir+"\\cmbccer\\"+cust0001cerPath);
				}
                if(createfile(cmbcTestcerin,cmbcTestcerPath,dir+"\\cmbccer")) {
                	props.put("bankPublicKey", dir+"\\cmbccer\\"+cmbcTestcerPath);
				}
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
					}
				}
			}
			initFlag = true;
		}
	}

	/**
	 * ��ȡ��ʼ������
	 * @param propName
	 * @return
	 */
	public static String getProperty(String propName) {
		init();
		return props.getProperty(propName);
	}
	
	private static boolean createfile(InputStream in,String name,String path) {
		byte[] buffer = new byte[1024];
		int length;
		File file=new File(path+"\\"+name);
		
		try {
			 if(file.exists())
				file.delete();
	            file.createNewFile();
			 FileOutputStream out=new FileOutputStream(file);
			while ((length = in.read(buffer)) != -1) {
				 out.write(buffer, 0, length);   
			}
			in.close();
	         out.close();
	         return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	};
	
	public static String getProxyIp() throws BizException {
		return ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(),PmpPayBaseCost.PMP_PROXYIP);
	}
	

	public static int getProxyPort() throws BizException {
		String portstr=ParamsetQryUtil.getParaString(utils.getEnvContext().getOrgId(), PmpPayBaseCost.PMP_PROXYPORT);
		return portstr==null?null:Integer.parseInt(portstr);
	}

}
