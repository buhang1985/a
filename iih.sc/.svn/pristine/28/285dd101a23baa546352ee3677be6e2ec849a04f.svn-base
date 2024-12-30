package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.sc.apt.dto.d.AptPayDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 加号并预约给患者
 * 
 * @author yank
 * @author liubin
 *
 */
public class AddTicketAndAptBP {
	/**
	 * 为患者加号
	 * 
	 * @param patId 患者id
	 * @param regRes 排班资源
	 * @param fgPrePay 是否预付费
	 * @throws BizException
	 */
	public String addTicketAndApt(String patId, RegResDTO regRes, FBoolean fgPrePay) throws BizException {
		ScValidator.validateParam("患者id", patId);
		// 1、诊间加号
		ScSchTickDO tickDO = this.addTick(regRes.getId_sch(), regRes.getPolcn());
		
		// 2、为患者预约
		return this.aptToPat(regRes.getId_sch(), tickDO.getId_tick(), patId, fgPrePay, regRes.getId_scchl());
	}

	/**
	 * 加号
	 * 
	 * @param schId 排班ID
	 * @throws BizException
	 */
	private ScSchTickDO addTick(String schId, Integer polCn) throws BizException {
		IScSchOutCmdService addTicketService = ServiceFinder.find(IScSchOutCmdService.class);
		ScSchTickDO[] scSchTickDOs = addTicketService.addTick(schId, 1, EuAddTickMod.JH, polCn);
		if (ArrayUtil.isEmpty(scSchTickDOs)) {
			throw new BizException(IScMsgConst.SC_APT_OP_ADD_NUM_TO_PAT_FAILED);
		}
		return scSchTickDOs[0];
	}

	/**
	 * 为患者预约
	 * 
	 * @param schId 排班ID
	 * @param tickId 号位ID
	 * @param patId 患者ID
	 * @param fgPrePay 是否预付款
	 * @param chlId 渠道ID
	 * @throws BizException
	 */
	private String aptToPat(String schId, String tickId,String patId, FBoolean fgPrePay, String chlId) throws BizException {
		IScSchOutQryService schQryService = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO regResDTO = schQryService.getAptRes(schId, FBoolean.TRUE, chlId);
		if (regResDTO == null) {
			throw new BizException(IScMsgConst.ERROR_SCH_RES_NOT_EXISTS);
		}
		OpAptDTO aptDTO = createOpAptDTO(tickId,regResDTO, patId);
		AptPayDTO aptPayDTO = this.createPayInfoDTO(regResDTO);
		AptOpInRoomBP aptBP = new AptOpInRoomBP();
		return aptBP.exec(aptDTO, FBoolean.FALSE, fgPrePay, aptPayDTO);
	}

	/**
	 * 根据排班渠道获取号源池
	 * 
	 * @param schId 排班ID
	 * @return 号源池
	 * @throws BizException
	 */
	private ScSchChlDO getSchChl(String schId) throws BizException {
		IScSchOutQryService schQryService = ServiceFinder.find(IScSchOutQryService.class);
		ScSchChlDO scChlDO = schQryService.getSchChl(schId, IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM_DEPT);// 诊间渠道(本科)
		if (scChlDO == null) {
			throw new BizException(IScMsgConst.SC_APT_OP_SCH_CHL_INROOM_DEPT_NOT_EXISTS);
		}
		return scChlDO;
	}

	/**
	 * 构造OpAptDTO
	 * 
	 * @param regRes
	 * @param patId
	 * @return
	 */
	private OpAptDTO createOpAptDTO(String tickId,RegResDTO regRes, String patId) {
		OpAptDTO opApt = new OpAptDTO();
		opApt.setId_sch(regRes.getId_sch());
		opApt.setId_dayslot(regRes.getId_dayslot());
		opApt.setDt_b(new FDateTime(regRes.getD_sch().toDate()));
		opApt.setId_tick(tickId);//号位ID
		opApt.setId_pat(patId);
		opApt.setId_scchl(regRes.getId_scchl());
		opApt.setFg_add(FBoolean.TRUE);
		FArrayList list = new FArrayList();
		list.add(regRes);
		opApt.setRegresarray(list);
		return opApt;
	}

	/**
	 * 构造AptPayDTO
	 * 
	 * @param regResDTO
	 * @return
	 */
	private AptPayDTO createPayInfoDTO(RegResDTO regResDTO) {
		AptPayDTO payInfoDTO = new AptPayDTO();
		payInfoDTO.setAmt_st(regResDTO.getAmt_st());// 标准金额
		payInfoDTO.setAmt_hp(regResDTO.getAmt_hp());// 医保支付
		payInfoDTO.setAmt_pat(regResDTO.getAmt_pat());// 患者自付
		payInfoDTO.setAmt(regResDTO.getAmt());// 应付金额
		payInfoDTO.setPaystyle(IBdPripmCodeConst.CODE_PRI_PM_PAY);// 支付方式,预交金
		payInfoDTO.setFg_print(FBoolean.FALSE);
		payInfoDTO.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		return payInfoDTO;
	}
}
