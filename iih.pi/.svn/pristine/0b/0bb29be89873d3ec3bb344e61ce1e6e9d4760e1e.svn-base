package iih.pi.dic.external.s;

import iih.pi.dic.external.d.PatCateBaseDTO;
import iih.pi.dic.external.i.IPatientcategoryExtService;
import iih.pi.dic.external.s.bp.FindPatcateByIdBp;
import xap.mw.core.data.BizException;

/**
 * 患者分类数据扩展服务
 * 
 * @author dj.zhang
 *
 */
public class IPatientcategoryExtServiceImpl implements IPatientcategoryExtService {

	/**
	 * 根据id值查找患者分类数据
	 */
	@Override
	public PatCateBaseDTO findPatcateById(String patId) throws BizException {
		FindPatcateByIdBp bp = new FindPatcateByIdBp();
		return bp.exec(patId);
	}

}
