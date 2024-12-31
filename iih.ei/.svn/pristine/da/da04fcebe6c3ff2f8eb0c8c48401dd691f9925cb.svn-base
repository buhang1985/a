package iih.ei.std.s.v1.bp.mr.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import iih.ei.std.s.v1.bp.mr.util.zip4j.core.ZipFile;
import iih.ei.std.s.v1.bp.mr.util.zip4j.model.FileHeader;

/***
 * 解压工具类
 * 
 * @author 病历
 * @date: 2019-11-07
 */
public class UnZipUtil {

	/**
	 * 解压
	 * 
	 * @param data
	 * @return
	 */
	public byte[] unZip(byte[] data, int zipFormat) {
		if (zipFormat != 1001 && zipFormat != 1002 && zipFormat != 1003)
	       {
	           zipFormat = 1001;
	       }
	       if (zipFormat == 1001)
	       {
	           return data;
	       }
			
			
		   BufferedOutputStream bos = null;  
	       FileOutputStream fos = null; 
	       File temp = null;
			try
			{ 
				temp = File.createTempFile(String.valueOf(System.currentTimeMillis())+data.length, ".temp");
				fos = new FileOutputStream(temp);  
				bos = new BufferedOutputStream(fos);  
				bos.write(data);  
			}catch (Exception e) {  
	           e.printStackTrace();  
	       } finally {  
	           if (bos != null) {  
	               try {  
	                   bos.close();  
	               } catch (IOException e1) {  
	                   e1.printStackTrace();  
	               }  
	           }  
	           if (fos != null) {  
	               try {  
	                   fos.close();  
	               } catch (IOException e1) {  
	                   e1.printStackTrace();  
	               }  
	           }  
	       }  
			
			
			
			byte[] result= null;
			int BUFF_SIZE = 4096;
			InputStream is = null;
			ByteArrayOutputStream saos = null;
			ZipFile zf;
			try {
				zf = new ZipFile(temp);
				zf.setFileNameCharset("gbk");
				if (zipFormat == 1003)
	           {
				if (zf.isEncrypted()) {
					zf.setPassword("ImIrH");
				}
	           }

				for (Object obj : zf.getFileHeaders()) {
					FileHeader fileHeader = (FileHeader) obj;
					String destFileStr = "" + "/" + fileHeader.getFileName();
					File destFile=new File(destFileStr);
					if (!destFile.getParentFile().exists()) {
						destFile.getParentFile().mkdirs();// 创建目录
					}
					is = zf.getInputStream(fileHeader);
					saos = new ByteArrayOutputStream();
					int readLen = -1;
					byte[] buff = new byte[BUFF_SIZE];
					while ((readLen = is.read(buff)) != -1) {
						saos.write(buff, 0, readLen);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				result = saos.toByteArray();
				
				// 关闭资源
				try {
					if (is != null) {
						is.close();
					}
				} catch (IOException ioe) {
				}

				try {
					if (saos != null) {
						saos.close();
					}
				} catch (IOException ioe) {
				}
				if(temp!=null)
				{
					temp.delete();
				}
			}
			
			return result;
			

	}

}
