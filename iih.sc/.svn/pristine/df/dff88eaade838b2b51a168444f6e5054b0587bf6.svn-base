package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceDetailsDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.AptPayDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.AptOpEP;
import iih.sc.apt.s.ep.PatEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScCollectionUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊预约结算
 * 
 * @author yank
 */
public class SettleOpAptBP {
	/**
	 * 预约结算
	 * 
	 * @param aptDTO 预约信息
	 * @param payDTO 支付信息
	 * @param isTakeAptNo 是否是预约取号
	 * @throws BizException
	 */
	public void exec(OpAptDTO aptDTO, AptPayDTO payDTO, FBoolean isTakeAptNo) throws BizException {
		this.validateParam(aptDTO, payDTO);

		// 1、获取预约信息
		AptEP aptEP = new AptEP();
		ScAptDO aptDO = aptEP.getById(aptDTO.getId_apt());
		this.validateApt(aptDO);

		// 2、预约生成就诊（暂时支付和生成就诊是绑定的，BL无法处理预约的费用）
		String entId = this.aptToEnt(aptDTO, payDTO, isTakeAptNo);
		aptDTO.setId_ent(entId);

		// 3、 修改预约门诊--就诊信息
		AptOpEP aptOpEP = new AptOpEP();
		aptOpEP.setAptToEn(aptDTO.getId_apt(), entId);

		// 4、 修改预约为已结算
		aptEP.settle(aptDO);
	}

	/**
	 * 验证参数
	 * 
	 * @param aptDTO
	 * @param payDTO
	 * @throws BizException
	 */
	private void validateParam(OpAptDTO aptDTO, AptPayDTO payDTO) throws BizException {
		ScValidator.validateParam("预约信息", aptDTO);
		ScValidator.validateParam("预约ID", aptDTO.getId_apt());
		ScValidator.validateParam("支付信息", payDTO);

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
			throw new BizException(IScMsgConst.SC_APT_OP_HAS_CANCELED_CANNOT_SETTLE);
		} else if (IScDictCodeConst.SD_APTSTATUS_PAY.equals(scAptDO.getSd_status())) {
			throw new BizException(IScMsgConst.SC_APT_OP_HAS_PAID);
		}
	}

	/**
	 * 验证预交金额是否足够
	 * 
	 * @param patDO 患者信息
	 * @param amt_pat 排班服务id
	 * @throws BizException
	 */
	private void validatePreAcc(PatDO patDO, FDouble amt_pat) throws BizException {
		// 取得服务对应价格
		IPatAccServiceExt IPatAccServiceExt = ServiceFinder.find(IPatAccServiceExt.class);
		FDouble balance = IPatAccServiceExt.GetOutpPrepaymentAmount(patDO.getId_pat());
		if (amt_pat.doubleValue() > balance.doubleValue()) {
			throw new BizException("预交金余额不足");
		}
	}

	/**
	 * 预约支付生成就诊 暂时逻辑是在一起的，分开费用处理比较复杂
	 * 
	 * @param aptDTO 预约信息
	 * @param payDTO 支付信息
	 * @param isTakeAptNo 是否是预约取号
	 * @return
	 * @throws BizException
	 */
	private String aptToEnt(OpAptDTO aptDTO, AptPayDTO payDTO, FBoolean isTakeAptNo) throws BizException {
		PatEP patEP = new PatEP();
		PatDO patDO = patEP.getPatById(aptDTO.getId_pat());

		// 挂号资源
		RegResDTO regResDTO = (RegResDTO) aptDTO.getRegresarray().get(0);
		// 如果是预交金，则验证预交金账户余额
		if (IBdPripmCodeConst.CODE_PRI_PM_PAY.equals(payDTO.getPaystyle())) {
			this.validatePreAcc(patDO, regResDTO.getAmt_pat());
		}

		// 5.1 生成就诊记录
		IEnOutCmdService ent4AptService = ServiceFinder.find(IEnOutCmdService.class);
		String entId = ent4AptService.aptCreateEnt(patDO, aptDTO, isTakeAptNo);
		aptDTO.setId_ent(entId);

		// 5.2 调用BL结算,//TODO 先可调用EN的，后续调用预约的
		// 5.3 修改ENT的结算标识
		PayInfoDTO payInfo = new AptPayInfoParser().transToEnPayInfo(payDTO);
		BlIncItmVsTypeDTO[] incDTOs = (BlIncItmVsTypeDTO[]) ent4AptService.settleApt(aptDTO, payInfo);
		FArrayList incList = ScCollectionUtils.arrayToList(incDTOs);
		aptDTO.setInvoiceinfo(incList);
		BlInvoiceDetailsDTO invoiceDTO = (BlInvoiceDetailsDTO)incDTOs[0].getBlInvoiceDetailsDTO().get(0);
		String cgId = invoiceDTO.getId_cgoep();	
		aptDTO.setId_cg(cgId);
		// 已结算，更新OP
		ent4AptService.settleEnt(entId, cgId, FBoolean.TRUE);
		// 已结算，更新ent的fg_st结算标识,fanlq-add
		ent4AptService.ubpdateFgst(entId);

		return entId;
	}
}
