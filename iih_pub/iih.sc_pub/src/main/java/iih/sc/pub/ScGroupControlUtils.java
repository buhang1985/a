package iih.sc.pub;

import xap.mw.coreitf.i.IBaseDO;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 集团管控帮助类
 * 
 * @author yankan
 *
 */
public class ScGroupControlUtils {
	/**
	 * 获取集团管控条件
	 * 
	 * @param baseDO 实体类
	 * @param fgUseAlias 是否使用别名
	 * @return
	 */
	public static String getGroupControlFitler(IBaseDO baseDO, boolean fgUseAlias) {
		return EnvContextUtil.processEnvContext("", baseDO, fgUseAlias);
	}
	/**
	 * 获取集团管控条件
	 * 
	 * @param baseDO 实体类
	 * @param tableAliasName 表别名
	 * @return
	 */
	public static String getGroupControlFitler(IBaseDO baseDO, String tableAliasName) {		
		return EnvContextUtil.processEnvContext("", baseDO, tableAliasName);
	}
	/**
	 * 获取集团管控条件
	 * 
	 * @param doDesc DO描述类
	 * @param tableAliasName 表别名
	 * @return
	 */
	public static String getGroupControlFitler(IDODesc doDesc, String tableAliasName) {		
		return EnvContextUtil.processEnvContext("", doDesc, tableAliasName);
	}
}
