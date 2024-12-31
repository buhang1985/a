package iih.bl.cg.task;

import java.util.Map;

import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.PreAlertReturnType;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 用于患者离院未结算的情况下自动结算。 目前仅支持商保记账结算。
 * 
 * @author yankan
 *
 */
public class AutoSettleTask implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 * 
	 * @param ctx 上下文
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		Map<String, Object> map = ctx.getKeyMap();
		Object days = map.get("days");// 执行天数
		String psnId = (String) map.get("psnId");// 执行人员
		if (days != null && !StringUtil.isEmpty(psnId)) {
			int daysInt = Integer.parseInt(days.toString());
			OperatorInfoDTO operDTO = constructOperDTO(psnId);
			if (operDTO != null) {
				IBLCiOrderToBlCgService cgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
				cgService.PriceAndSettlementPayment_hpcg_background(daysInt, operDTO);
			}
		}

		PreAlertObject obj = new PreAlertObject();
//		obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
		return obj;
	}

	/**
	 * 构造操作员DTO
	 * 
	 * @param psnId 人员ID
	 * @return
	 * @throws BizException
	 */
	private OperatorInfoDTO constructOperDTO(String psnId) throws BizException {
		OperatorInfoDTO operDTO = null;
		IPsndocMDORService psnRService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO psnDO = psnRService.findById(psnId);
		if (psnDO != null) {
			operDTO = new OperatorInfoDTO();
			operDTO.setId_dep(psnDO.getId_dep());
			operDTO.setId_emp(psnDO.getId_psndoc());
			operDTO.setId_grp(psnDO.getId_group());
			operDTO.setId_org(psnDO.getId_org());
			operDTO.setId_org_emp(psnDO.getId_org());
		}
		return operDTO;
	}
}
