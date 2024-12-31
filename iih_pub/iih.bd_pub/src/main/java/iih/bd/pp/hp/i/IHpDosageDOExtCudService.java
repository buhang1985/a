package iih.bd.pp.hp.i;

import iih.bd.mhi.dto.d.HpDosageCompDTO;
import xap.mw.core.data.BizException;

/**
 * 剂型对照扩展服务
 * 
 * @author dj.zhang
 *
 */
public interface IHpDosageDOExtCudService {

	/**
	 * 保存对照
	 * 
	 * @param hpId
	 * @param hpDosageCompDtos
	 * @return
	 * @throws BizException
	 */
	public HpDosageCompDTO[] saveHpDosageComp(String hpId, HpDosageCompDTO[] hpDosageCompDtos) throws BizException;
	
	/**
	 * 删除对照
	 * 
	 * @param hpId
	 * @param hpDosageCompDtos
	 * @return
	 * @throws BizException
	 */
	public HpDosageCompDTO[] delHpDosageComp(String hpId, HpDosageCompDTO[] hpDosageCompDtos) throws BizException;
}
