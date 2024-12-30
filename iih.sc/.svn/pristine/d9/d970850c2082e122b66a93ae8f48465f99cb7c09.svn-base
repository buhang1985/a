package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.sc.apt.dto.d.OpApt4EsDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.AptOpEP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.s.event.OpAptCancEvent;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊排班停诊：改约时取消预约BP
 * 
 * @author zhengcm
 * @date 2017-11-20 11:41:48
 *
 */
public class CancOpApt4CancSchBP {

	/**
	 * 门诊排班停诊：改约时取消预约
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 11:52:59
	 *
	 * @param aptDTO
	 * @throws BizException
	 */
	public void exec(String oldAptId, OpAptDTO aptDTO, String operate_source) throws BizException {
		// 1、获取预约信息
		AptEP aptEP = new AptEP();
		ScAptDO scAptDO = aptEP.getById(oldAptId);
		this.validateApt(scAptDO);
		
		// 2、已缴费的迁移费用
		if (FBoolean.TRUE.equals(scAptDO.getFg_payment())) {
			// 取消就诊
			this.cancEnt(scAptDO, aptDTO);
		} else {
			IScSchOutCmdService schService = ServiceFinder.find(IScSchOutCmdService.class);
			schService.drawbackTick(scAptDO.getId_tick());// 退号
			// 2.取消预约
			aptEP.cancApt(null,scAptDO);
		}
		// 3、查询排班信息
		ScSchDO schDO = new OralAptEP().getSch(scAptDO.getId_sch());
		// 4、查询排班计划
		ScPlanDO planDO = new OralAptEP().getScPlan(schDO.getId_scpl());
		// 5、触发取消预约事件
		this.invokeCancOpAptEvent(scAptDO,planDO,operate_source);
	}

	/**
	 * 取消门诊就诊
	 * 
	 * @author zhengcm
	 * @date 2017-11-24 10:34:20
	 *
	 * @param oldAptDO
	 * @param newAptDO
	 * @param aptDTO
	 * @throws BizException
	 */
	private void cancEnt(ScAptDO oldAptDO, OpAptDTO aptDTO) throws BizException {
		// 新的预约
		ScAptDO newAptDO = new AptEP().getById(aptDTO.getId_apt());
		// 排班DO
		OralAptEP ep = new OralAptEP();
		ScSchDO schDO = ep.getSch(oldAptDO.getId_sch());
		ScPlanDO planDO = ep.getScPlan(schDO.getId_scpl());
		RegInfoDTO regInfo = this.createRegInfoDTO(oldAptDO, newAptDO, schDO, planDO);
		// 取消就诊
		IEnOutCmdService entService = ServiceFinder.find(IEnOutCmdService.class);
		String id_ent = entService.cancEnt4CancSch(oldAptDO.getId_apt(), aptDTO, regInfo);

		// 回写门诊预约表
		if (!StringUtil.isEmptyWithTrim(id_ent)) {
			AptOpEP opEP = new AptOpEP();
			ScAptOpDO opAptDO = opEP.getAptOpByAptId(newAptDO.getId_apt());
			opAptDO.setStatus(DOStatus.UPDATED);
			opAptDO.setId_en(id_ent);
			opEP.save(opAptDO);
		}
	}

	/**
	 * 触发取消事件
	 * 
	 * @param scAptDO
	 * @throws BizException
	 */
	private void invokeCancOpAptEvent(ScAptDO scAptDO,ScPlanDO planDO, String operate_source) throws BizException {
		OpApt4EsDTO apt4EsDTO = new OpApt4EsDTO();
		apt4EsDTO.setId_apt(scAptDO.getId_apt());
		apt4EsDTO.setId_dep_pl(planDO.getId_dep());
		if(!IScDictCodeConst.SC_CHANGE_APT_OPERATE.equals(operate_source)){
			apt4EsDTO.setOperate_source(IScDictCodeConst.SC_CANC_APT_OPERATE);
		}else{
			apt4EsDTO.setOperate_source(operate_source);
		}
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

	/**
	 * 创建挂号信息DTO
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 19:20:59
	 *
	 * @param aptDO
	 * @param newAptDO
	 * @param schDO
	 * @param planDO
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private RegInfoDTO createRegInfoDTO(ScAptDO aptDO, ScAptDO newAptDO, ScSchDO schDO, ScPlanDO planDO)
			throws BizException {
		RegInfoDTO regInfo = new RegInfoDTO();
		regInfo.setId_tick(newAptDO.getId_tick());
		regInfo.setTickno(newAptDO.getQueno());
		regInfo.setId_dayslot(newAptDO.getId_dateslot());
		RegResDTO resDTO = new RegResDTO();
		resDTO.setId_emp(ScContextUtils.getPsnId());
		resDTO.setId_scres(planDO.getId_scres());
		resDTO.setName_scres(planDO.getName_res());
		resDTO.setId_dep(planDO.getId_dep());
		resDTO.setName_dep(planDO.getName_dep());
		resDTO.setId_scsrv(aptDO.getId_scsrv());
		resDTO.setId_sch(aptDO.getId_sch());
		FArrayList flist = new FArrayList();
		flist.add(resDTO);
		regInfo.setRegresarray(flist);
		return regInfo;
	}
}
