package iih.pi.dic.patcate.i;

import iih.pi.dic.patcate.d.PatCateUIDTO;
import xap.mw.core.data.BizException;

/**
* 患者分类UIDTO数据维护服务
*/
public interface IPatcateUiRService {

	/**
	*  根据条件查找患者分类UIDTO数据集合
	*/	
	public abstract PatCateUIDTO[] findPatCaUIDTOsByWherePart(String whereStr,String orderStr) throws BizException;
}
