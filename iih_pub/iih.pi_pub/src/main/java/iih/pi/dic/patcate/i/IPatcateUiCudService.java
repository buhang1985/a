package iih.pi.dic.patcate.i;

import iih.pi.dic.patcate.d.PatCateUIDTO;
import xap.mw.core.data.BizException;

/**
 * 患者分类UIDTO数据维护服务
 */
public interface IPatcateUiCudService {

	/**
	 * 患者分类UIDTO数据保存
	 */
	public abstract PatCateUIDTO savePatCaUIDTOs(PatCateUIDTO patCateUIDTO) throws BizException;

	/**
	 * 患者分类UIDTO数据删除
	 */
	public void deletePatCaUIDTOs(PatCateUIDTO patCateUidto) throws BizException;
}
