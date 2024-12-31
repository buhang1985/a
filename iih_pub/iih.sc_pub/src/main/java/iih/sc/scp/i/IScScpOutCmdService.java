package iih.sc.scp.i;

import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import xap.mw.core.data.BizException;

/**
 * 排班计划对外服务
 * @author zhouliming
 *
 */
public interface IScScpOutCmdService {
	
	/**
	 * 修改计划里 最后排班日期
	 * @param lastSchDate  最后排班日期
	 * @param id_scpl 计划id
	 * @author ccj
	 * @throws BizException
	 */
	void updateLastSchDate(String lastSchDate,String id_scpl) throws BizException;
	/**
	 * 更新计划周的推荐提前报到时间,停止挂号时间
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 09:22:20
	 *
	 * @param deptId
	 * @param sugestVal
	 * @throws BizException
	 */
	public void updatePlanWeekSugestExmint(ScDeptParamDO paramDO,ScDeptParamDsDO[] newDsDO,ScDeptParamDsDO[] oldDsDO) throws BizException;
}
