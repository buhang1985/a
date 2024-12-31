package iih.bl.cg.task;

import java.util.Map;

import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
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
public class OpAutoSettleTask implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 * 
	 * @param ctx 上下文
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		Map<String, Object> map = ctx.getKeyMap();
		Object days = map.get("days");// 执行天数
		String psncode = (String) map.get("psncode");// 执行人员编码
		if (days != null && !StringUtil.isEmpty(psncode)) {
			int daysInt = Integer.parseInt(days.toString());
			OperatorInfoDTO operDTO = constructOperDTO(psncode);
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
	 * @param psnCode 人员编码
	 * @return
	 * @throws BizException
	 */
	private OperatorInfoDTO constructOperDTO(String psnCode) throws BizException {
		OperatorInfoDTO operDTO = null;
		IPsndocMDORService psnRService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psnDOs = psnRService.findByAttrValString(PsnDocDO.CODE, psnCode);
		if (!ArrayUtil.isEmpty(psnDOs)) {
			operDTO = new OperatorInfoDTO();
			operDTO.setId_dep(psnDOs[0].getId_dep());
			operDTO.setId_emp(psnDOs[0].getId_psndoc());
			operDTO.setId_grp(psnDOs[0].getId_group());
			operDTO.setId_org(psnDOs[0].getId_org());
			operDTO.setId_org_emp(psnDOs[0].getId_org());
		}
		return operDTO;
	}
}
