package iih.syn.common.utils;

import xap.mw.coreitf.i.IBaseDO;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 管控帮助类
 * 
 * @author xuxing_2018年5月17日18:02:23
 *
 */
public class SynEnvContextUtil {

	/**
	 * 实体和是否使用别名
	 * 
	 * @param baseDO
	 * @param fg_tableAlias
	 * @return
	 */
	public String getWherePart(IBaseDO baseDO, boolean fg_tableAlias) {
		return EnvContextUtil.processEnvContext("", baseDO, fg_tableAlias);
	}

	/**
	 * 实体和自定义别名
	 * 
	 * @param baseDO
	 * @param tableAlias
	 * @return
	 */
	public String getWherePart(IBaseDO baseDO, String tableAlias) {
		return EnvContextUtil.processEnvContext("", baseDO, tableAlias);
	}

	/**
	 * 实体描述和是否使用别名
	 * 
	 * @param desc
	 * @param fg_tableAlias
	 * @return
	 */
	public String getWherePart(IDODesc desc, boolean fg_tableAlias) {
		return EnvContextUtil.processEnvContext("", desc, fg_tableAlias);
	}

	/**
	 * 实体描述和自定义别名
	 * 
	 * @param desc
	 * @param tableAlias
	 * @return
	 */
	public String getWherePart(IDODesc desc, String tableAlias) {
		return EnvContextUtil.processEnvContext("", desc, tableAlias);
	}
}
