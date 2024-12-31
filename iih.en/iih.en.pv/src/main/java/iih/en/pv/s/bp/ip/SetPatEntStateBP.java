package iih.en.pv.s.bp.ip;

import iih.en.pv.dto.d.EntStateDTO;
import xap.mw.core.data.BizException;

/**
 * 设置患者就诊状况
 * @author renying
 *
 */
public class SetPatEntStateBP {
	/**
	 * 设置患者就诊状况
	 * @param entId 就诊ID
	 * @param entStateDTOs 就诊状况DTO数组
	 * @throws BizException
	 * @author renying
	 */
	public void exec(String entId,EntStateDTO[] entStateDTOs) throws BizException{
			//这里需要考虑批量处理，一次判定
//		一次保存病情、护理、营养
	}
}
