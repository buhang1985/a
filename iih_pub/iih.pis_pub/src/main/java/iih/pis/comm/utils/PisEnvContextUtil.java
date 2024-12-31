package iih.pis.comm.utils;

import xap.mw.coreitf.i.IBaseDO;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.permfw.pub.EnvContextUtil;

public class PisEnvContextUtil {

	/**
	 * 实体和是否使用别名
	 * 
	 * @param baseDO
	 * @param fg_tableAlias
	 * @return
	 */
	public static String processEnvContext(IBaseDO baseDO, boolean fg_tableAlias) {
		String wherePart = EnvContextUtil.processEnvContext("", baseDO, fg_tableAlias);
		if (wherePart == null || wherePart.equals("") || wherePart.isEmpty()) {
			return " 1 = 2 ";
		}
		return wherePart;
	}

	/**
	 * 实体和自定义别名
	 * 
	 * @param baseDO
	 * @param tableAlias
	 * @return
	 */
	public static String processEnvContext(IBaseDO baseDO, String tableAlias) {
		String wherePart = EnvContextUtil.processEnvContext("", baseDO, tableAlias);
		if (wherePart == null || wherePart.equals("") || wherePart.isEmpty()) {
			return " 1 = 2 ";
		}
		return wherePart;
	}

	/**
	 * 实体描述和是否使用别名
	 * 
	 * @param desc
	 * @param fg_tableAlias
	 * @return
	 */
	public static String processEnvContext(IDODesc desc, boolean fg_tableAlias) {
		String wherePart = EnvContextUtil.processEnvContext("", desc, fg_tableAlias);
		if (wherePart == null || wherePart.equals("") || wherePart.isEmpty()) {
			return " 1 = 2 ";
		}
		return wherePart;
	}

	/**
	 * 实体描述和自定义别名
	 * 
	 * @param desc
	 * @param tableAlias
	 * @return
	 */
	public static String processEnvContext(IDODesc desc, String tableAlias) {
		String wherePart = EnvContextUtil.processEnvContext("", desc, tableAlias);
		if (wherePart == null || wherePart.equals("") || wherePart.isEmpty()) {
			return " 1 = 2 ";
		}
		return wherePart;
	}
}
