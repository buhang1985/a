package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueQryService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceDetailsDTO;
import iih.bl.st.blstoep.d.EnReFundTpEnum;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.AptPayDTO;
import iih.sc.apt.dto.d.OpApt4EsDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.LogEP;
import iih.sc.apt.s.ep.PatEP;
import iih.sc.apt.s.event.OpAptPayEvent;
import iih.sc.apt.s.event.OpAptTakeEvent;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.FDoubleUtils;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScCollectionUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.List;

import xap.mw.core.data.Context;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 预约取号
 * 
 * @author yank
 *
 */
public class TakeApptNoBP {

	/***
	 * 预约取号换患者取号的情况
	 * 
	 * @author fanlq 2017年11月3日 下午4:01:18
	 * @param oldPatId 换患者之前的患者id
	 * @param newPatId 换患者之后的患者id
	 * @param payDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	public OpAptDTO takeApptNo(OpAptDTO aptDTO, OpAptDTO oldOpAptDTO, AptPayDTO payDTO) throws BizException {
		// 1、验证参数
		this.validateParam(aptDTO, payDTO);
		this.validateParam(oldOpAptDTO, payDTO);
		// 校验是否存在换患者取号的情况
		if (aptDTO.getId_pat() != null && oldOpAptDTO.getId_pat() != null
				&& !aptDTO.getId_pat().equals(oldOpAptDTO.getId_pat())) {
			// 支付退费
			if (oldOpAptDTO.getFg_payment() != null && FBoolean.TRUE.equals(oldOpAptDTO.getFg_payment())) {
				aptDTO = this.takeApptNoForChange(aptDTO, oldOpAptDTO, payDTO);
			}else{
				aptDTO = this.takeApptNo(aptDTO.getId_pat(), aptDTO, payDTO);
			}
			// 记录日志
			LogEP logEP = new LogEP();
			logEP.changePatSaveLog(oldOpAptDTO.getId_pat(), aptDTO.getId_pat(), aptDTO.getId_ent());
			return aptDTO;
		} else {
			return this.takeApptNo(oldOpAptDTO.getId_pat(), oldOpAptDTO, payDTO);
		}
	}
	/**
	 * 预约取号-预付费换患者
	 * 
	 * @param patId 取号患者id
	 * @param regDTO 挂号信息
	 * @param payDTO 支付信息
	 * @throws BizException
	 */
	public OpAptDTO takeApptNoForChange(OpAptDTO aptDTO, OpAptDTO oldOpAptDTO, AptPayDTO payDTO) throws BizException {
		PatEP patEP = new PatEP();
		PatDO patDO = patEP.getPatById(aptDTO.getId_pat());
		Context.get().setAttribute("ReFundTp", EnReFundTpEnum.ENREFUND_FETCH);//预约取号
		// 4、验证队列
		RegResDTO resDTO = (RegResDTO) aptDTO.getRegresarray().get(0);
		this.validateQue(resDTO);
		//1、更换预约DTO信息
		//IScAptOutCmdService aptOutOutService = ServiceFinder.find(IScAptOutCmdService.class);
		//aptOutOutService.changeAptPat(aptDTO.getId_apt(),aptDTO.getId_pat());
		//2、更换就诊信息
		IEnOutCmdService aptToOpService = ServiceFinder.find(IEnOutCmdService.class);
		String returnEntId = aptToOpService.changeAptEnPat(oldOpAptDTO, patDO);
		oldOpAptDTO.setId_ent(returnEntId);
		//、更新门诊do的状态到挂号
		aptToOpService.updateOutPatientDOStatus(aptDTO.getId_ent(), IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
		//退费
		aptToOpService.refund(oldOpAptDTO.getId_ent(), IBlDictCodeConst.SD_PTTP_WINDOW, FBoolean.TRUE);
		AptPayInfoParser payInfoParser = new AptPayInfoParser();
		PayInfoDTO payInfo = payInfoParser.transToEnPayInfo(payDTO);
		//结算
		this.settle(aptDTO, payInfo);
		// 触发付费事件
		this.invokeAptPayEvent(aptDTO.getId_apt(), aptDTO.getId_pat(), returnEntId);
		// 2、获取预约信息
		AptEP aptEP = new AptEP();
		ScAptDO aptDO = aptEP.getById(aptDTO.getId_apt());
		this.validateAptDO(aptDO);// 验证预约信息
		// 6、更新预约数据
		aptDO = aptEP.getById(aptDTO.getId_apt());// 如果是结算的话，结算中会修改该预约信息
		aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_FINISH);
		aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_FINISH);// 状态改为完成
		aptDO.setStatus(DOStatus.UPDATED);
		aptEP.save(aptDO);
		aptDTO.setSd_status(aptDO.getSd_status());
		// 7、触发预约取号事件
		this.invokeAptEvent(aptDO.getId_apt(), aptDO.getId_pat(), aptDTO.getId_ent());
		return aptDTO;
	}
	/**
	 * 预约取号
	 * 
	 * @param patId 取号患者id
	 * @param regDTO 挂号信息
	 * @param payDTO 支付信息
	 * @throws BizException
	 */
	public OpAptDTO takeApptNo(String patId, OpAptDTO aptDTO, AptPayDTO payDTO) throws BizException {
		// 1、验证参数
		this.validateParam(aptDTO, payDTO);
		
		Context.get().setAttribute("ReFundTp", EnReFundTpEnum.ENREFUND_FETCH);//预约取号
		
		AptPayInfoParser payInfoParser = new AptPayInfoParser();
		PayInfoDTO payInfo = payInfoParser.transToEnPayInfo(payDTO);

		// 2、获取预约信息
		AptEP aptEP = new AptEP();
		ScAptDO aptDO = aptEP.getById(aptDTO.getId_apt());
		this.validateAptDO(aptDO);// 验证预约信息

		// 3、获取患者信息
		PatEP patEP = new PatEP();
		PatDO patDO = patEP.getPatById(aptDTO.getId_pat());

		// 4、验证队列
		RegResDTO resDTO = (RegResDTO) aptDTO.getRegresarray().get(0);
		this.validateQue(resDTO);

		if (aptDTO.getFg_payment() == null || FBoolean.FALSE.equals(aptDTO.getFg_payment())) {
			SettleOpAptBP settleBP = new SettleOpAptBP();
			settleBP.exec(aptDTO, payInfoParser.transToAptPay(payInfo), FBoolean.TRUE);
		} else if (FBoolean.TRUE.equals(aptDTO.getFg_payment())) {
			// 已经支付
			// 4、修改就诊信息，暂时不支持换人
			// 5、修改就诊医保信息
			// 6、插入就诊队列
			IEnOutCmdService aptToOpService = ServiceFinder.find(IEnOutCmdService.class);
			String returnEntId = aptToOpService.changeAptEnPat(aptDTO, patDO);
			aptDTO.setId_ent(returnEntId);
			//7、更新门诊do的状态到挂号
			aptToOpService.updateOutPatientDOStatus(aptDTO.getId_ent(), IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
			//是否需要退费重收
			if(isNeedReSettle(payInfo)){
				//8、结算，补缴，多退少补		
				//先退费，后重新结算
				FBoolean isRealPay = new FBoolean(this.isRealPay(payInfo));
				aptToOpService.refund(aptDTO.getId_ent(), IBlDictCodeConst.SD_PTTP_WINDOW, isRealPay);
				//结算
				this.settle(aptDTO, payInfo);

				// 触发付费事件
				this.invokeAptPayEvent(aptDTO.getId_apt(), patId, returnEntId);
			}
		}

		// 6、更新预约数据
		aptDO = aptEP.getById(aptDTO.getId_apt());// 如果是结算的话，结算中会修改该预约信息
		// add by zhengcm 2017-11-17 保存ID
		aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_FINISH);
		aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_FINISH);// 状态改为完成
		aptDO.setStatus(DOStatus.UPDATED);
		aptEP.save(aptDO);

		aptDTO.setSd_status(aptDO.getSd_status());

		// 7、触发预约取号事件
		this.invokeAptEvent(aptDO.getId_apt(), aptDO.getId_pat(), aptDTO.getId_ent());

		return aptDTO;
	}

	/**
	 * 验证参数
	 * 
	 * @param aptDTO 预约信息
	 * @param payDTO 支付信息
	 * @throws BizException
	 */
	private void validateParam(OpAptDTO aptDTO, AptPayDTO payDTO) throws BizException {
		ScValidator.validateParam("预约信息", aptDTO);
		FArrayList regResList = aptDTO.getRegresarray();
		if (regResList == null || regResList.size() <= 0) {
			throw new BizException(IScMsgConst.SC_APT_RES_NOT_EXIST);
		}
		if (payDTO == null || payDTO.getPayinfo() == null || payDTO.getPayinfo().size() <= 0) {
			throw new BizException("支付信息为空");
		}
	}

	/**
	 * 验证预约信息
	 * 
	 * @param aptDO
	 * @throws BizException
	 */
	private void validateAptDO(ScAptDO aptDO) throws BizException {
		if (aptDO == null) {
			throw new BizException(IScMsgConst.SC_APT_NOT_EXIST);
		}
		if (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(aptDO.getSd_status())) {
			throw new BizException(IScMsgConst.SC_APT_OP_CAN_RETAKE);
		}
		if (IScDictCodeConst.SD_APTSTATUS_CANCEL.equals(aptDO.getSd_status())) {
			throw new BizException(IScMsgConst.SC_APT_OP_TAKEN_HAS_CANCELED);
		}
	}

	/**
	 * 验证队列
	 * 
	 * @throws BizException
	 */
	private void validateQue(RegResDTO resDTO) throws BizException {
		String sql = "SELECT SC_PL.* FROM SC_PL SC_PL INNER JOIN SC_SCH SC_SCH ON SC_PL.ID_SCPL = SC_SCH.ID_SCPL WHERE SC_SCH.ID_SCH = '" + resDTO.getId_sch() + "' ";
		List<ScPlanDO> list = (List<ScPlanDO>) new DAFacade().execQuery(sql, new BeanListHandler(ScPlanDO.class));
		if(ListUtil.isEmpty(list))
			throw new BizException(IScMsgConst.SC_APT_TAKE_HAS_NO_QUE);
		IQueQryService queQryService = ServiceFinder.find(IQueQryService.class);
		QueDO queDO = queQryService.getQue(list.get(0).getId_scres(), list.get(0).getId_dep(), list.get(0).getId_queben(), IBdFcDictCodeConst.SD_QUETP_EMP);
		if (queDO == null) {
			throw new BizException(IScMsgConst.SC_APT_TAKE_HAS_NO_QUE);
		}
	}

	/**
	 * 结算
	 * 
	 * @param aptDTO 预约DTO
	 * @param payDTO 支付DTO
	 * @throws BizException
	 */
	private void settle(OpAptDTO aptDTO, PayInfoDTO payInfo) throws BizException {
		IEnOutCmdService opService = ServiceFinder.find(IEnOutCmdService.class);
		BlIncItmVsTypeDTO[] incDTOs = (BlIncItmVsTypeDTO[]) opService.settleApt(aptDTO, payInfo);
		BlInvoiceDetailsDTO invDTO = (BlInvoiceDetailsDTO) incDTOs[0].getBlInvoiceDetailsDTO().get(0);
		aptDTO.setId_cg(invDTO.getId_cgoep());// 结算ID
		FArrayList incList = ScCollectionUtils.arrayToList(incDTOs);
		aptDTO.setInvoiceinfo(incList);
	}

	/**
	 * 触发预约付费事件
	 * 
	 * @param aptId 预约ID
	 * @param patId 患者ID
	 * @param entId 就诊ID
	 * @throws BizException
	 */
	private void invokeAptPayEvent(String aptId, String patId, String entId) throws BizException {
		OpApt4EsDTO apt4EsDTO = new OpApt4EsDTO();
		apt4EsDTO.setId_apt(aptId);
		apt4EsDTO.setId_pat(patId);
		apt4EsDTO.setId_ent(entId);
		try {
			new OpAptPayEvent().invoke(apt4EsDTO);
		} catch (Exception ex) {
			Logger.error("", ex);
		}
	}

	/**
	 * 触发事件
	 * 
	 * @param aptId 预约ID
	 * @param patId 患者ID
	 * @param entId 就诊ID
	 * @throws BizException
	 */
	private void invokeAptEvent(String aptId, String patId, String entId) throws BizException {
		OpApt4EsDTO apt4EsDTO = new OpApt4EsDTO();
		apt4EsDTO.setId_apt(aptId);
		apt4EsDTO.setId_pat(patId);
		apt4EsDTO.setId_ent(entId);
		try {
			new OpAptTakeEvent().invoke(apt4EsDTO);
		} catch (Exception ex) {
			Logger.error("", ex);
		}

	}
	/**
	 * 是否实交易
	 * 
	 * 如果之前支付方式不为空，且与当前支付方式相同 或者只是找零(实际支付金额为0)，则认为是虚交易，新支付方式中需要加入
	 * 
	 * @param payInfoDTO
	 * @return
	 * @throws BizException
	 */
	private boolean isRealPay(PayInfoDTO payInfoDTO) throws BizException {
		if (!StringUtil.isEmpty(payInfoDTO.getPaystyle_originstyle())) {
			if ((payInfoDTO.getPaystyle_originstyle().equals(payInfoDTO.getPaystyle()) 
					&& !FDoubleUtils.isMoreThanZero(payInfoDTO.getAmt_orig_refund()))
					|| FDoubleUtils.isNullOrZero(payInfoDTO.getRelpay())) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 是否需要退费重收
	 * 
	 * @param payInfoDTO
	 * @return
	 * @throws BizException
	 */
	private boolean isNeedReSettle(PayInfoDTO payInfoDTO) throws BizException {
		if (!StringUtil.isEmpty(payInfoDTO.getPaystyle_originstyle())) {
			if (payInfoDTO.getPaystyle_originstyle().equals(payInfoDTO.getPaystyle()) 
					&& !FDoubleUtils.isMoreThanZero(payInfoDTO.getAmt_orig_refund())
					&& FDoubleUtils.isNullOrZero(payInfoDTO.getRelpay())) {
				return false;
			}
		}
		return true;
	}
}
