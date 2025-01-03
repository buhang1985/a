package iih.sc.apt.s.bp.op;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.i.IEnOutQryService;
import iih.sc.apt.dto.d.OpApt4EsDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.AptOpEP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.s.event.OpAptCancEvent;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.comm.IScMsgConst;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消门诊预约
 * 
 * @author yank
 *
 */
public class CancAptOpBP {
	/**
	 * 取消预约
	 * 
	 * @param aptDTO 预约dto,(必输项：aptId,entId,id_tick,Sd_pttp)
	 * @throws BizException
	 */
	public void exec(OpAptDTO aptDTO) throws BizException {
		// 1、获取预约信息
		AptEP aptEP = new AptEP();
		ScAptDO scAptDO = aptEP.getById(aptDTO.getId_apt());// 获取预约数据
		this.validateApt(scAptDO);// 验证预约信息

		// 2、处理票号
		IScschMDORService service = ServiceFinder.find(IScschMDORService.class);
		ScSchDO scSchDO = service.findById(scAptDO.getId_sch());
		if(scSchDO.getFg_transed().booleanValue()){
			throw new BizException("相关号位数据转移到sc_tickb表中，无法进行退号处理");
		}
		if (FBoolean.TRUE.equals(scAptDO.getFg_payment())) {
			// 如果已经结算，直接走退号逻辑,需退钱
			IEnOutCmdService entService = ServiceFinder.find(IEnOutCmdService.class);
			entService.cancEnt(aptDTO);
		} else {
			// 判断是否需要补号
			IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
			String supplyTicketType = qryService.getSupplyTicketType(null, aptDTO.getId_apt());

			IScSchOutCmdService schService = ServiceFinder.find(IScSchOutCmdService.class);
			// schService.drawbackTick(scAptDO.getId_tick());// 退号
			schService.revokeTick(scAptDO.getId_tick(), supplyTicketType);
			// 2.取消预约
			aptEP.cancApt(null,scAptDO);
		}
		// 3、查询排班信息
		ScSchDO schDO = new OralAptEP().getSch(scAptDO.getId_sch());
		// 4、查询排班计划
		ScPlanDO planDO = new OralAptEP().getScPlan(schDO.getId_scpl());
		// 3、触发取消预约事件 changed by zhengcm 2018-01-29 增加参数控制
		ScAptOpDO opAptDO = new AptOpEP().getAptOpByAptId(scAptDO.getId_apt());
		this.invokeCancOpAptEvent(scAptDO, aptDTO, planDO);
	}

	/**
	 * 触发取消事件
	 * 
	 * @param scAptDO
	 * @param aptDTO
	 * @throws BizException
	 */
	private void invokeCancOpAptEvent(ScAptDO scAptDO, OpAptDTO aptDTO,ScPlanDO planDO) throws BizException {
		OpApt4EsDTO apt4EsDTO = new OpApt4EsDTO();
		apt4EsDTO.setId_apt(scAptDO.getId_apt());
		apt4EsDTO.setId_dep_pl(planDO.getId_dep());
		apt4EsDTO.setType_msg(aptDTO.getType_msg());
		apt4EsDTO.setOperate_source(IScDictCodeConst.SC_CANC_APT_OPERATE);
		try {
			new OpAptCancEvent().invoke(apt4EsDTO);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 验证预约信息
	 * 
	 * @param scAptDO
	 * @throws BizException
	 */
	private void validateApt(ScAptDO scAptDO) throws BizException {
		if (scAptDO == null) {
			throw new BizException(IScMsgConst.SC_APT_NOT_EXIST);
		}

		// 校验预约状态
		if (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(scAptDO.getSd_status())) {
			throw new BizException(IScMsgConst.SC_APT_OP_HAS_TAKEN);
		} else if (IScDictCodeConst.SD_APTSTATUS_CANCEL.equals(scAptDO.getSd_status())) {
			throw new BizException(IScMsgConst.SC_APT_OP_HAS_CANCELED);
		}
	}
}
