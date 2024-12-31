package iih.mi.mibd.drugdircomp.i;

import iih.mi.mibd.drugdircomp.d.DrugDirCompDTO;
import xap.mw.core.data.BizException;

/**
 * 医保平台_药品对照数据维护服务
 *
 *@author hexx
 */
public interface IDrugdircompExtCudService {
	
	/**
	 * 保存药品对照
	 * 
	 * @param drugdirCompDTOs
	 *            药品对照信息
	 * @throws BizException
	 * @throws ParseException
	 */
	public abstract DrugDirCompDTO[] saveDrugComp(String misId,DrugDirCompDTO[] drugdirCompDTOs) throws BizException;
	
	/**
	 * 药品自动对照
	 * 
	 *
	 *            药品对照信息
	 * @throws BizException
	 * @throws ParseException
	 */
	public void autoComp(String misId) throws BizException;
	
	
	/**
	 * 药品删除对照
	 * 
	 *
	 *            药品对照信息
	 * @throws BizException
	 * @throws ParseException
	 */
	DrugDirCompDTO[] deleteDrugComp(String misId,DrugDirCompDTO[] drugdirCompDTOs)throws BizException; 
}
