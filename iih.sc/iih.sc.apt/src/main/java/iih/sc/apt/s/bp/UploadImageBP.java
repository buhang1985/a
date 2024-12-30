package iih.sc.apt.s.bp;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.UUID;
import cn.xapss.connector.bucket.FastFileID;
import cn.xapss.fastdfs.FastDfsCRUDer;
import xap.mw.core.data.BizException;

public class UploadImageBP {

	/**
	 * 上传医技预约图片
	 * @param imageBytes
	 * @return
	 * @throws BizException
	 */
	public String exec(byte[] imageBytes) throws BizException {
		InputStream ins = new ByteArrayInputStream(imageBytes); 
		int fileSize = this.GetFileSize(ins);
		String platformId = FastDfsCRUDer.getInstance().getPlatformGroup();
		String fileName = UUID.randomUUID().toString()+".jpeg";
		FastFileID fileId = FastDfsCRUDer.getInstance().upload(ins, fileSize, platformId, fileName); 
		String filePath = platformId+"/"+fileId.getName();
		return filePath;
	}
	/**
	 * 获取文件大小
	 * 
	 * @param inputStream
	 * @return
	 * @throws BizException
	 */
	private static int GetFileSize(InputStream inputStream) throws BizException {
		try {
			int fileSize = inputStream.available();
			return fileSize;
		} catch (Exception e) {
			throw new BizException(e);
		}
	}
}
