package iih.sc.scp.s;

import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scp.i.IScScpOutCmdService;
import iih.sc.scp.s.bp.UpdatePlanWeekSugestExmintBP;
import iih.sc.scp.s.ep.ScplEp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 排班计划命令服务
 * 
 * @author yank
 *
 */
@Service(serviceInterfaces = { IScScpOutCmdService.class }, binding = Binding.JSONRPC)
public class ScScpOutCmdServiceImpl implements IScScpOutCmdService {

	/**
	 * 修改计划里 最后排班日期
	 * 
	 * @param lastSchDate 最后排班日期
	 * @param id_scpl 计划id
	 * @author ccj
	 * @throws BizException
	 */
	@Override
	public void updateLastSchDate(String lastSchDate, String id_scpl) throws BizException {
		ScplEp scplEp = new ScplEp();
		scplEp.updateLastSchDate(lastSchDate, id_scpl);
	}

	/**
	 * 更新计划周的推荐提前报到时间
	 * 
	 * @author zhengcm
	 * @date 2017-11-29 09:22:20
	 *
	 * @param deptId
	 * @param sugestVal
	 * @throws BizException
	 */
	@Override
	public void updatePlanWeekSugestExmint(ScDeptParamDO paramDO,ScDeptParamDsDO[] newDsDO,ScDeptParamDsDO[] oldDsDO) throws BizException {
		new UpdatePlanWeekSugestExmintBP().exec(paramDO,newDsDO,oldDsDO);
	}
}
