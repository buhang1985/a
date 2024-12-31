package iih.mp.nr.i;

import iih.mp.nr.dto.d.ParamDTO;
import iih.mp.nr.dto.d.PeStaCountDTO;
import iih.mp.nr.dto.d.PeStaDTO;
import xap.mw.core.data.BizException;

public interface IOrderExecuteStatus {

	/**
	 * 医嘱未执行状态统计查询
	 * 
	 * @param id_ent就诊ID
	 * @param dt_bg开始时间
	 * @param dt_end结束时间
	 * @param DicSrvtpSta医嘱状态明细
	 * @return
	 * @throws BizException
	 */
	public abstract PeStaCountDTO GetPeStaCount(String id_ent, String dt_bg, String dt_end, ParamDTO[] paramDTO, String fg_tech) throws BizException;
	
	
	/**医嘱未执行状态明细查询
	 * @param id_ent就诊ID
	 * @param dt_bg开始时间
	 * @param dt_end结束时间
	 * @param DicSrvtpSta医嘱状态明细
	 * @param fg_tech医技非医技
	 * @return
	 * @throws BizException
	 */
	public abstract PeStaDTO[] GetPeStaList(String id_ent, String dt_bg, String dt_end, ParamDTO[] paramDTO, String fg_tech) throws BizException;

}
