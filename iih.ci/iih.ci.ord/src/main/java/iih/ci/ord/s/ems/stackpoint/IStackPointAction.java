package iih.ci.ord.s.ems.stackpoint;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.b.BaseCiDTO;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import xap.mw.core.data.FMap2;

/**
 * 断点执行器基类
 * @author wangqingzhu
 *
 */
public abstract class IStackPointAction extends BaseCiDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 扩展信息
	 * @return String
	 */
	public String getCacheKey() {
		return ((String) getAttrVal("CacheKey"));
	}
	/**
	 * 扩展信息
	 * @param Extension
	 */
	public void setCacheKey(String CacheKey) {
		setAttrVal("CacheKey", CacheKey);
	}
	
	/**
	 * 参数
	 * @return String
	 */
	public FMap2 getParameter() {
		return ((FMap2) getAttrVal("Parameter"));
	}
	
	/**
	 * 参数
	 * @param Extension
	 */
	public void setCacheKey(FMap2 Parameter) {
		setAttrVal("Parameter", Parameter);
	}
	
	/**
	 * 执行器方法
	 * @param ctx
	 * @param pInfo
	 * @param objData
	 * @return
	 */
	public abstract boolean OnCallBackAction(CiEnContextDTO ctx, OrderPackageInfo pInfo);

}
