package iih.bl.hp.service.i;

import iih.bl.hp.dto.MzYpShareDataDTO;
import xap.mw.core.data.BizException;

public interface IBLHpMzShareQueService {

	/**
	 * 根据病人ID获得该病人在本院近50天的药品类医嘱信息（IIH+CHIS)，已翻译成CHIS格式，CHIS可直接使用
	 * @param patient_id 患者ID
	 * @param query_days 查询病人从今日往前的天数
	 * @param target_sys 查询目标系统(0:全部  1:chis 2:iih)
	 * @return 该病人在本院近query_days天的药品类医嘱信息
	 * @throws BizException
	 */
	public abstract MzYpShareDataDTO[]  getMzYpShareDatas(String patient_id,int query_days,String target_sys)  throws BizException ;
}
