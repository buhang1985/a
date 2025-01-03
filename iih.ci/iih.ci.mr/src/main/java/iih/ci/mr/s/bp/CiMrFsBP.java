package iih.ci.mr.s.bp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.cimrfs.i.ICimrfsCudService;
import iih.ci.mr.cimrfs.i.ICimrfsRService;
import iih.ci.mr.s.util.zip4j.core.ZipFile;
import iih.ci.mr.s.util.zip4j.model.FileHeader;
import xap.mw.basic.storage.BusinessStorageService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FBinary;
import xap.mw.core.data.binary.BinaryBuilder;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class CiMrFsBP {

	/**
	 * 获取文书二进制返回
	 * 
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 * @throws IOException
	 */
	public CiMrFsDO GetCiMrFsDO(CiMrDO ciMrDO) throws BizException, IOException {
		// 默认是数据库存储
		String sdstmd = IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML;
		// 如果不为空则复制正常存储
		if (null!=ciMrDO.getSd_mrtplstmd()
				&& !ciMrDO.getSd_mrtplstmd().equals("")) {
			sdstmd = ciMrDO.getSd_mrtplstmd();
		}
		ICimrfsRService iCimrfsRService = ServiceFinder
				.find(ICimrfsRService.class);
		// 查询二进制表数据
		CiMrFsDO[] ciMrFsDOs = iCimrfsRService.find(
				" id_mr = '" + ciMrDO.getId_mr() + "'", "sv desc",
				FBoolean.FALSE);
		// 如果是数据库存储则直接返回查询的结果
		if (IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML.equals(sdstmd)) {
			if (ciMrFsDOs != null && ciMrFsDOs.length > 0) {
				return ciMrFsDOs[0];
			}
		}
		// 如果是文件存储则调用文件系统组装二进制返回结果
		else if (IBdSrvDictCodeConst.SD_MRTPLSTMD_FILE.equals(sdstmd)) {
			if (ciMrFsDOs != null && ciMrFsDOs.length > 0) {
				// 组装二进制返回结果
				BusinessStorageService fileService = ServiceFinder
						.find(BusinessStorageService.class);
				FBinary bin = fileService.read(ciMrDO.getUrl_file());
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				bin.writeBodyToStream(os);
				byte[] bytes = os.toByteArray();
				ciMrFsDOs[0].setEmrfs(bytes);
				os.close();
				return ciMrFsDOs[0];
			}
		}
		return null;
	}

	/**
	 * 获取病历内容
	 * 
	 * @param ciMrDo
	 * @return
	 * @throws BizException
	 * @throws DocumentException
	 * @throws IOException
	 */
	public String GetCiMrFsXml(CiMrDO ciMrDo) throws BizException, DocumentException, IOException {
		ICimrfsRService iCimrfsRService = ServiceFinder.find(ICimrfsRService.class);

		// 默认是数据库存储
		String sdstmd = IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML;
		byte[] bytes = null;
		// 如果不为空则复制正常存储
		if (null != ciMrDo.getSd_mrtplstmd() && !ciMrDo.getSd_mrtplstmd().equals("")) {
			sdstmd = ciMrDo.getSd_mrtplstmd();
		}
		// 如果是数据库存储则保存后直接返回查询的结果
		if (sdstmd.equals(IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML)) {
			CiMrFsDO[] ciMrFsDos = iCimrfsRService.find("id_mr = '" + ciMrDo.getId_mr() + "'", "", FBoolean.FALSE);
			if (ciMrFsDos != null && ciMrFsDos.length > 0) {
				bytes = ciMrFsDos[0].getEmrfs();
			}
		}
		// 如果是文件存储则调用文件系统保存文件并组装二进制返回结果
		else if (sdstmd.equals(IBdSrvDictCodeConst.SD_MRTPLSTMD_FILE)) {
			if (ciMrDo.getUrl_file() != null && !ciMrDo.getUrl_file().equals("")) {
				BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
				FBinary bin = fileService.read(ciMrDo.getUrl_file());
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				bin.writeBodyToStream(os);
				bytes = os.toByteArray();
				os.close();
			}
		}
		
		if(bytes==null||bytes.length<=0)
		{
			return "";
		}
		
		bytes = unZip(bytes,ciMrDo.getId_sex()==null?0:ciMrDo.getId_sex());
		
		if (bytes != null && bytes.length > 0) {
			try {
				SAXReader reader = new SAXReader();
				reader.setEncoding(ICiMrDictCodeConst.EDITOR_DEFAULT);
				Document document = reader.read(new ByteArrayInputStream(bytes));
				return document.asXML();
			} catch (DocumentException e) {
				SAXReader reader = new SAXReader();
				reader.setEncoding(ICiMrDictCodeConst.EDITOR_GB2312);
				Document document = reader.read(new ByteArrayInputStream(bytes));
				return document.asXML();
			}
		}
		return "";
	}
	
	/**
	 * 保存二进制返回
	 * 
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @return
	 * @throws IOException
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FArrayList2 SaveCiMrFsDO(CiMrDO ciMrDO, CiMrFsDO ciMrFsDO)
			throws IOException, BizException {
		FArrayList2 fArrayList2 = new FArrayList2();
		// 默认是数据库存储
		String sdstmd = IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML;
		// 如果不为空则复制正常存储
		if (null!=ciMrDO.getSd_mrtplstmd()
				&& !ciMrDO.getSd_mrtplstmd().equals("")) {
			sdstmd = ciMrDO.getSd_mrtplstmd();
		}
		ICimrfsCudService iCimrfsCudService = ServiceFinder
				.find(ICimrfsCudService.class);
		// 如果是数据库存储则保存后直接返回查询的结果
		if (sdstmd.equals(IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML)) {
			fArrayList2.add(ciMrDO);
			fArrayList2
					.add(iCimrfsCudService.save(new CiMrFsDO[] { ciMrFsDO })[0]);

			return fArrayList2;
		}
		// 如果是文件存储则调用文件系统保存文件并组装二进制返回结果
		else if (sdstmd.equals(IBdSrvDictCodeConst.SD_MRTPLSTMD_FILE)) {
			// 先删除之前文件
			// StorageService fileService =
			// ServiceFinder.find(StorageService.class);
			BusinessStorageService fileService = ServiceFinder
					.find(BusinessStorageService.class);
			
		    Boolean bSave = false;
			
			if (ciMrDO.getUrl_file() == null
					||ciMrDO.getUrl_file().equals("")) {
				bSave = true;
			}
			if(bSave)
			{
			// 记录文件二进制
			byte[] bytes = ciMrFsDO.getEmrfs();
			// 保存文件
			InputStream input = new ByteArrayInputStream(bytes);
			FBinary bin = BinaryBuilder.builder().withBody(input)
					.withSize(bytes.length).build();
			
			String url_file = fileService.write(null, bin);
			input.close();
			ciMrDO.setUrl_file(url_file);
			ICiemrCudService iCiemrCudService = ServiceFinder
					.find(ICiemrCudService.class);
			ciMrDO.setStatus(DOStatus.UPDATED);
			CiMrDO[] ciMrDOs = iCiemrCudService.save(new CiMrDO[] { ciMrDO });
			ciMrFsDO.setEmrfs(null);
			// 保存二进制
			CiMrFsDO result = iCimrfsCudService
					.save(new CiMrFsDO[] { ciMrFsDO })[0];
			// 组装二进制返回结果
			result.setEmrfs(bytes);
			fArrayList2.add(ciMrDOs[0]);
			fArrayList2.add(result);
			}else
			{
				// 记录文件二进制
				byte[] bytes = ciMrFsDO.getEmrfs();
				// 保存文件
				InputStream input = new ByteArrayInputStream(bytes);
				FBinary bin = BinaryBuilder.builder().withBody(input)
						.withSize(bytes.length).build();
				
				fileService.write(ciMrDO.getUrl_file(), bin);
				input.close();
				fArrayList2.add(ciMrDO);
				fArrayList2.add(ciMrFsDO);
			}
			return fArrayList2;
		}
		return null;
	}

	/**
	 * 获取病历内容
	 * 
	 * @param ciMrDo
	 * @return
	 * @throws BizException
	 * @throws DocumentException
	 * @throws IOException
	 */
	public String GetCiMrFsArea(CiMrDO ciMrDo) throws BizException, DocumentException, IOException {
		ICimrfsRService iCimrfsRService = ServiceFinder.find(ICimrfsRService.class);
		// 默认是数据库存储
		String sdstmd = IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML;
		byte[] bytes = null;
		// 如果不为空则复制正常存储
		if (null!=ciMrDo.getSd_mrtplstmd() && !ciMrDo.getSd_mrtplstmd().equals("")) {
			sdstmd = ciMrDo.getSd_mrtplstmd();
		}
		// 如果是数据库存储则保存后直接返回查询的结果
		if (sdstmd.equals(IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML)) {
			CiMrFsDO[] ciMrFsDos = 
					iCimrfsRService.find("id_mr = '" + ciMrDo.getId_mr() + "'", "", FBoolean.FALSE);
			if (ciMrFsDos != null && ciMrFsDos.length > 0) {
				bytes = ciMrFsDos[0].getEmrfs();
			}
		}
		// 如果是文件存储则调用文件系统保存文件并组装二进制返回结果
		else if (sdstmd.equals(IBdSrvDictCodeConst.SD_MRTPLSTMD_FILE)) {
			if (ciMrDo.getUrl_file() != null && !ciMrDo.getUrl_file().equals("")) {
				BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
				// 捕获 文件系统路径查询不到病历信息的异常，返回固定提示信息  - by Vampire
				FBinary bin;
				try {
					bin = fileService.read(ciMrDo.getUrl_file());
				} catch (Exception e) {
					e.printStackTrace();
					return "（文件路径错误，未查询到病历信息...）";
				}
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				bin.writeBodyToStream(os);
				bytes = os.toByteArray();
				os.close();
			}
		}
		bytes = unZip(bytes, ciMrDo.getId_sex() == null ? 0 : ciMrDo.getId_sex());
		if (bytes != null && bytes.length > 0) {
			SAXReader reader = new SAXReader();
			reader.setEncoding(ICiMrDictCodeConst.EDITOR_DEFAULT);
			Document document = reader.read(new ByteArrayInputStream(bytes));
			Node node = document.getRootElement().selectSingleNode("./BodyText");
			return node.getText();
		}
		return "（未查询到病历信息...）";
	}

	/**
	  * 解压
	  * @param data
	  * @return
	  */
	public byte[] unZip(byte[] data, int zipFormat) {
		if (data == null)
			return data;
		if (zipFormat != 1001 && zipFormat != 1002 && zipFormat != 1003)
           zipFormat = 1001;
       if (zipFormat == 1001)
           return data;

	   BufferedOutputStream bos = null;  
       FileOutputStream fos = null; 
       File temp = null;
       try { 
    	   temp = File.createTempFile(String.valueOf(System.currentTimeMillis()) + data.length, ".temp");
			fos = new FileOutputStream(temp);  
    	   bos = new BufferedOutputStream(fos);
    	   bos.write(data);
       } catch (Exception e) {  
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
    	   if (zipFormat == 1003) {
    		   if (zf.isEncrypted())
    			   zf.setPassword("ImIrH");
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
    		   if (is != null)
    			   is.close();
    	   } catch (IOException ioe) {
    	   }
    	   try {
    		   if (saos != null)
    			   saos.close();
    	   } catch (IOException ioe) {
    	   }
    	   if (temp!=null)
    		   temp.delete();
       }
       return result;
	}
		
	/**
	 * 物理删除
	 * @param ciMrDO
	 * @param ciMrFsDO
	 * @throws BizException 
	 */
    public FBoolean DeleteCiMrFsDO(CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException
    {
        //默认是数据库存储
        String sdstmd = IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML;
        //如果不为空则复制正常存储
        if (null != ciMrDO.getSd_mrtplstmd() && !ciMrDO.getSd_mrtplstmd().equals("")) {
			sdstmd = ciMrDO.getSd_mrtplstmd();
		}
        //如果是数据库存储则删除
        if (sdstmd.equals(IBdSrvDictCodeConst.SD_MRTPLSTMD_FILEANDXML))
        {
            try
            {
                if (null != ciMrDO.getUrl_file() && !ciMrDO.getUrl_file().equals(""))
                {
                	BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
                    fileService.delete(ciMrDO.getUrl_file());
                }
            }
            catch (Exception ex)
            {
            	FastdfsMrLogger.error(ex.getMessage() + "\r\n" + ex.getStackTrace());
            }
            ICimrfsCudService iCimrfsCudService = ServiceFinder.find(ICimrfsCudService.class);
            iCimrfsCudService.delete(new CiMrFsDO[] { ciMrFsDO });
        }
        //如果是文件存储则调用文件系统删除文件并删除数据库数据
        else if (sdstmd.equals(IBdSrvDictCodeConst.SD_MRTPLSTMD_FILE))
        {
            //先删除之前文件
        	BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
        	fileService.delete(ciMrDO.getUrl_file());
        	ICimrfsCudService iCimrfsCudService = ServiceFinder.find(ICimrfsCudService.class);
        	iCimrfsCudService.delete(new CiMrFsDO[] { ciMrFsDO });
        }
        return FBoolean.TRUE;
    }
}
