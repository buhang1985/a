package iih.pi.dic.external.i;

import iih.pi.dic.external.d.PatCateBaseDTO;
import xap.mw.core.data.BizException;

/**
 * 患者分类数据扩展服务
 * 
 * @author dj.zhang
 *
 */
public interface IPatientcategoryExtService {

	/**
	 * 根据id值查找患者分类数据
	 */
	public abstract PatCateBaseDTO findPatcateById(String patId) throws BizException;
}
