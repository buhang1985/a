package iih.ci.mb.utils;

import java.io.File;

import xap.csource.fastdfs.ClientGlobal;
import xap.lui.core.common.LuiParams;
import xap.lui.core.exception.LuiRuntimeException;
import xap.lui.core.exta.ILuiExtPoint;
import xap.lui.core.util.FastDfsUtil;

/**
 * 文件帮助类
 * @author yankan
 * @since 2018-03-20
 *
 */
public class FileUtils {
	/**
	 * 
	 */
	private static final String FDFS_CONFIG_NAME = "fdfs_client.conf";
	/**
	 * 获取文件路径
	 * @param fileId 文件存储id
	 * @return
	 */
	public static String getFileUrl(String fileId){
		if(ClientGlobal.fastDfsConfig==null){
			initFdfsCfg();
		}
		String groupname = ClientGlobal.fastDfsConfig.getBusinessGroup();
		String url=FastDfsUtil.getHttpDownloadUrl(groupname);
		return String.format("%s/%s", url,fileId);
	}
	/**
	 * 初始化文件服务器配置
	 */
	private static void initFdfsCfg(){
		ILuiExtPoint provier = LuiParams.getExtPotint();
		File confP = provier.getLuiConfigFile();
		if(confP !=null){
			String confPath = confP.getPath();
			confPath = confPath.concat(File.separator).concat(FDFS_CONFIG_NAME);
			try {
				ClientGlobal.init(confPath);
			} catch (Throwable e) {
				throw new LuiRuntimeException(e.getMessage());
			}
		}
	}
}
