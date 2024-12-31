package iih.bd.base.utils;

import java.io.InputStream;

import org.apache.commons.lang.StringUtils;

import cn.xapss.connector.bucket.FastFileID;
import cn.xapss.fastdfs.FastDfsCRUDer;
import xap.mw.core.data.BizException;

/**
 * 文件服务工具集
 * 
 * @author hao_wu
 *
 */
public class FileServerUtils {

	/**
	 * 下载文件
	 * 
	 * @param fileKey
	 *            文件Key
	 * @param isBizGrp
	 *            是否为业务组
	 * @return
	 */
	public static InputStream Download(String fileKey, boolean isBizGrp) {
		FastDfsCRUDer fastdfs_crud = FastDfsCRUDer.getInstance();
		InputStream inputStream = null;
		FastFileID fast_fid = GetFastFileId(isBizGrp, fileKey);
		inputStream = fastdfs_crud.download(fast_fid);
		return inputStream;
	}

	/**
	 * 下载文件,默认非业务组
	 * 
	 * @param fileKey
	 *            文件Key
	 * @return
	 */
	public static InputStream Download(String fileKey) {
		return Download(fileKey, false);
	}

	/**
	 * 上传文件
	 * 
	 * @param fileKey
	 *            文件Key
	 * @param inputStream
	 *            文件输入流
	 * @param isBizGrp
	 *            是否为业务组
	 * @return
	 * @throws BizException
	 */
	public static String Upload(String fileKey, InputStream inputStream, boolean isBizGrp) throws BizException {
		FastDfsCRUDer fastdfs_crud = FastDfsCRUDer.getInstance();

		int fileSize = GetFileSize(inputStream);

		FastFileID fileId = null;

		if (StringUtils.isEmpty(fileKey)) {
			String grpId = GetGrpId(isBizGrp);
			fileId = fastdfs_crud.upload(inputStream, fileSize, grpId);
		} else {
			FastFileID newFileId = GetFastFileId(isBizGrp, fileKey);
			boolean res = fastdfs_crud.update(newFileId, inputStream, fileSize);
			if (res)
				fileId = newFileId;
		}

		if (null == fileId)
			return null;

		// 业务组文件需要带GrpId
		String newFileKey = fileId.getName();
		if (isBizGrp)
			newFileKey = String.format("%s/%s", fileId.getGroup(), newFileKey);

		return newFileKey;
	}

	/**
	 * 上传文件,默认非业务组
	 * 
	 * @param inputStream
	 *            文件输入流
	 * @return
	 * @throws BizException
	 */
	public static String Upload(InputStream inputStream) throws BizException {
		return Upload(null, inputStream, false);
	}

	/**
	 * 上传文件,默认非业务组
	 * 
	 * @param fileKey
	 *            文件Key
	 * @param inputStream
	 *            文件输入流
	 * @return
	 * @throws BizException
	 */
	public static String Upload(String fileKey, InputStream inputStream) throws BizException {
		return Upload(fileKey, inputStream, false);
	}

	/**
	 * 删除文件
	 * 
	 * @param fileKey
	 *            文件Key
	 * @param isBizGrp
	 *            是否为业务组
	 */
	public static void Delete(String fileKey, boolean isBizGrp) {
		FastFileID fileId = GetFastFileId(isBizGrp, fileKey);
		FastDfsCRUDer fastDfsCRUDer = FastDfsCRUDer.getInstance();
		fastDfsCRUDer.delete(fileId);
	}

	/**
	 * 删除文件,默认非业务组
	 * 
	 * @param fileKey
	 *            文件Key
	 */
	public static void Delete(String fileKey) {
		Delete(fileKey, false);
	}

	/**
	 * 拷贝文件
	 * 
	 * @param fileKey
	 *            文件Key
	 * @param isBizGrp
	 *            是否为业务组
	 * @return
	 */
	public static String Copy(String fileKey, boolean isBizGrp) {
		FastFileID fastFileId = GetFastFileId(isBizGrp, fileKey);

		FastDfsCRUDer fastDfsCRUDer = FastDfsCRUDer.getInstance();
		FastFileID newFileId = fastDfsCRUDer.copy(fastFileId);

		// 业务组文件需要带GrpId
		String newFileKey = newFileId.getName();
		if (isBizGrp)
			newFileKey = String.format("%s/%s", fastFileId.getGroup(), newFileKey);
		return newFileKey;
	}

	/**
	 * 拷贝文件,默认非业务组
	 * 
	 * @param fileKey
	 *            文件Key
	 * @return
	 */
	public static String Copy(String fileKey) {
		return Copy(fileKey, false);
	}

	/**
	 * 获取文件ID
	 * 
	 * @param isBizGrp
	 *            是否为业务组
	 * @param fileKey
	 *            文件Key
	 * @return
	 */
	private static FastFileID GetFastFileId(Boolean isBizGrp, String fileKey) {
		FastFileID fastFileID = null;
		if (isBizGrp) {
			fastFileID = new FastFileID(fileKey);
		} else {
			String grp_id = FastDfsCRUDer.getInstance().getPlatformGroup();
			fastFileID = new FastFileID(grp_id, fileKey);
		}

		return fastFileID;
	}

	/**
	 * 获取分组Id：业务组、平台组
	 * 
	 * @param isBizGrp
	 * @return
	 */
	private static String GetGrpId(boolean isBizGrp) {
		String grp_id = (isBizGrp ? FastDfsCRUDer.getInstance().getBusinessGroup()
				: FastDfsCRUDer.getInstance().getPlatformGroup());

		return grp_id;
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
