package iih.ci.sdk.ems.itf;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.ems.meta.ErrorEmsList;
import xap.mw.core.data.BizException;

/**
 * 医疗单有效性检查
 * @author wangqingzhu
 *
 */
public interface IEmsValidate  extends IEmsBP{

	/**
	 * 检查医疗单有效性，并返回错误信息
	 * @param objEms
	 * @return
	 */
	public abstract ErrorEmsList viewModelValidate(Object[] objEms,CiEnContextDTO ctx) throws BizException;
	/**
	 * 
	 * @param objEms
	 * @return
	 * @throws BizException
	 */
	public abstract ErrorEmsList beforeSaveValidate(Object[] szOrderPackage)throws BizException;
}
