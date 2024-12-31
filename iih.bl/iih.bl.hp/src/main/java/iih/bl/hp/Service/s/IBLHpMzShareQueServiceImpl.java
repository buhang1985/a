package iih.bl.hp.Service.s;

import iih.bl.hp.Service.s.Bp.GetMzYpShareDatasBP;
import iih.bl.hp.dto.MzYpShareDataDTO;
import iih.bl.hp.service.i.IBLHpMzShareQueService;
import xap.mw.core.data.BizException;

/**
 * 给CHIS提供本院近50天的药品类医嘱信息（IIH+CHIS)
 * @author tcy
 * @since 2017-5-12
 *
 */
public class IBLHpMzShareQueServiceImpl  implements IBLHpMzShareQueService {

	/**
	 * 根据病人ID获得该病人在本院近50天的药品类医嘱信息（IIH+CHIS)，已翻译成CHIS格式，CHIS可直接使用
	 * @param patientId 患者ID
	 * @param queryDays 查询病人从今日往前的天数
	 * @param target_sys 查询目标系统(0:全部  1:chis 2:iih)
	 * @return 该病人在本院近queryDays天的药品类医嘱信息
	 * @throws BizException
	 */
	@Override
	public MzYpShareDataDTO[]  getMzYpShareDatas(String patientId,int queryDays,String target_sys)
			throws BizException {
		GetMzYpShareDatasBP bp=new GetMzYpShareDatasBP();
		return bp.exec(patientId, queryDays, target_sys);
		
	}

}
