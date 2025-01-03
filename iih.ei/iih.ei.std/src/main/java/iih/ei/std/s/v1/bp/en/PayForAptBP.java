package iih.ei.std.s.v1.bp.en;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.itf.std.inner.en.IBlOpChargeForEnInnerService;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPayDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPayRltDTO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.ei.std.d.v1.en.payforapt.d.HpInfoDTO;
import iih.ei.std.d.v1.en.payforapt.d.PayForAptParamDTO;
import iih.ei.std.d.v1.en.payforapt.d.PayForAptResultDTO;
import iih.ei.std.d.v1.utils.EiAppUtils;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.ChlTpEP;
import iih.ei.std.s.v1.bp.common.HpEP;
import iih.ei.std.s.v1.bp.common.PatEP;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientCudService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.i.IScAptOpDOCudService;
import iih.sc.apt.scapt.i.IScAptOpDORService;
import iih.sc.apt.scapt.i.IScaptMDOCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
/***
 * 收取预约费
 * @author fanlq
 * @date: 2019年10月11日 下午4:36:36
 */
public class PayForAptBP extends IIHServiceBaseBP<PayForAptParamDTO, PayForAptResultDTO> {

	@Override
	protected void checkParam(PayForAptParamDTO param) throws BizException {
		if (StringUtils.isNullOrEmpty(param.getId_apt()))
			throw new BizException("预约Id不能为空！");
		if (StringUtils.isNullOrEmpty(param.getCode_paytp()))
			throw new BizException("支付方式不能为空！");
		if (StringUtils.isNullOrEmpty(param.getMoney_pay()))
			throw new BizException("支付金额不能为空！");
		if (StringUtils.isNullOrEmpty(param.getCode_opr()))
			throw new BizException("操作员编码不能为空！");
		if (StringUtils.isNullOrEmpty(param.getId_stoep()))
			throw new BizException("结算id不能为空！");
	}

	@Override
	protected PayForAptResultDTO process(PayForAptParamDTO param) throws BizException {
		//1.获取患者信息
		PatDO pat = this.getPatByCode(param);
		//2.获取预约信息
		ScAptDO aptDo = this.getAptDo(param.getId_apt());
		//3.组装预约dto信息
		OpAptDTO opAptDTO = this.assemly(param, aptDo);
		//4.设置患者分类及医保信息
		if(!StringUtils.isNullOrEmpty(param.getCode_hp())){
			//医保
			//医保结算校验
			this.validateHpPay(param);
			//获取医保信息
			HPDO hp = this.getHpByCode(param);
			//医保设置患者分类
			this.hpPaySetPatCa(opAptDTO, hp);
			//设置医保信息
			this.setHpInfo(param, opAptDTO, hp);
		}else{
			//自费
			//自费设置患者分类
			this.selfPaySetPatCa(opAptDTO, pat);
		}
		//5.生成就诊记录
		String entId = aptCreateEnt(param, opAptDTO, pat);
		//6.结算
		BlOpRegPayRltDTO blOpRegPayRltDTO = this.hpPaySettle(param, opAptDTO, pat, entId);
		//7.回写预约就诊数据
		this.updateCgStatus(param.getId_apt(), entId,((BlcgoepAggDO)blOpRegPayRltDTO.getCgdetail().get(0)).getParentDO().getId_cgoep());
		//8.取号
		this.takeTickNo(param);
		//9.设置结算信息
		PayForAptResultDTO result = this.setStInfo(blOpRegPayRltDTO);
		return result;
	}
	/**
	 * 获取患者信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatByCode(PayForAptParamDTO param) throws BizException {
		//获取患者信息
		PatDO pat = new PatEP().getPatByCode(param.getCode_pat());
		if(pat == null)
			throw new BizException(String.format("获取患者信息[%s]失败！", param.getCode_pat()));
		return pat;
	}
	/**
	 * 获取预约信息
	 * 
	 * @param aptId
	 * @return
	 * @throws BizException
	 */
	private ScAptDO getAptDo(String aptId) throws BizException {
		IScaptMDORService serv = ServiceFinder.find(IScaptMDORService.class);
		ScAptDO apt = serv.findById(aptId);
		if(apt == null)
			throw new BizException(String.format("未找到[%s]对应预约记录！", aptId));
		// 是否已回收
		if (FBoolean.TRUE.equals(apt.getFg_canc()))
			throw new BizException("该预约已经取消,不允许付费");
		// 是否已支付
		if (IScDictCodeConst.SD_APTSTATUS_PAY.equals(apt.getSd_status()))
			throw new BizException("预约已经支付, 不能重复收费");
		if (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(apt.getSd_status()))
			throw new BizException("预约已经取号, 不能重复收费");
		return apt;
	}
	/**
	 * 组装预约dto信息
	 * 
	 * @param param
	 * @param aptDo
	 * @return
	 * @throws BizException
	 */
	private OpAptDTO assemly(PayForAptParamDTO param, ScAptDO aptDo) throws BizException {
		IScSchOutQryService scSchOutQryServ = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO regRes  = scSchOutQryServ.getRegRes4Apt(aptDo.getId_apt(), FBoolean.TRUE);
		if (regRes == null)
			throw new BizException("加载号源信息异常！");
		OpAptDTO aptDTO = new OpAptDTO();
		aptDTO.setId_apt(aptDo.getId_apt());
		aptDTO.setId_dayslot(aptDo.getId_dateslot());// 日期分组
		aptDTO.setId_pat(aptDo.getId_pat());// 患者id
		aptDTO.setDt_b(aptDo.getDt_b());// 预约日期
		aptDTO.setId_sch(aptDo.getId_sch());// 排班
		aptDTO.setId_ticks(aptDo.getId_ticks());// 号段
		aptDTO.setId_tick(aptDo.getId_tick());// 号位
		aptDTO.setQueno(aptDo.getQueno());// 票号
		aptDTO.setFg_payment(aptDo.getFg_payment());
		aptDTO.setRegresarray(EiAppUtils.doArray2List(regRes));
		return aptDTO;
	}
	/**
	 * 校验参数
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validateHpPay(PayForAptParamDTO param) throws BizException {
		if (StringUtils.isNullOrEmpty(param.getCode_hp()))
			throw new BizException("医保产品编码不能为空！");
	}
	/**
	 * 获取患者信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private HPDO getHpByCode(PayForAptParamDTO param) throws BizException {
		HPDO hp = new HpEP().getHpByCode(param.getCode_hp());
		if(hp == null)
			throw new BizException(String.format("获取医保产品[%s]失败！", param.getCode_hp()));
		return hp;
	}
	/**
	 * 医保设置患者分类
	 * 
	 * @param aptDTO
	 * @throws BizException
	 */
	private void hpPaySetPatCa(OpAptDTO aptDTO, HPDO hp) throws BizException {
		PiPatCaDO patCa = new PatEP().getOpPatCaByHpId(hp.getId_hp());
		if(patCa == null)
			throw new BizException(String.format("获取医保产品[%s]对应患者分类失败！", hp.getCode()));
		aptDTO.setId_patca(patCa.getId_patca());
		aptDTO.setId_pripat(patCa.getId_patpritp());
		aptDTO.setId_patcret(patCa.getId_patcrettp());
	}
	/**
	 * 设置医保信息
	 * 
	 * @param param
	 * @param aptDTO
	 * @param hp
	 * @throws BizException
	 */
	private void setHpInfo(PayForAptParamDTO param, OpAptDTO aptDTO, HPDO hp)throws BizException{
		HpInfoDTO hpInfoDTO = param.getHpinfo();
		if(hpInfoDTO == null) return; 
		aptDTO.setId_hp(hp.getId_hp());
		aptDTO.setNo_hp(hpInfoDTO.getNo_hp());
		aptDTO.setFg_settlebycard(FBoolean.TRUE);
		aptDTO.setFg_hpsettle(FBoolean.TRUE);
		aptDTO.setFg_hp_card(FBoolean.TRUE);
		aptDTO.setCode_hpkind(hpInfoDTO.getCode_hpkind());
		aptDTO.setCode_hppatca(hpInfoDTO.getCode_hppatca());
		aptDTO.setCode_hpmedkind(hpInfoDTO.getCode_hpmedkind());
	}
	/**
	 * 自费设置患者分类
	 * 
	 * @param aptDTO
	 * @throws BizException
	 */
	private void selfPaySetPatCa(OpAptDTO aptDTO, PatDO pat) throws BizException {
		PatEP piPatEP = new PatEP();
		PiPatCaDO patCa = piPatEP.getAptSelfPayPatca(pat);
		if (patCa == null)
			throw new BizException("自费结算获取患者分类失败！");
		aptDTO.setId_patca(patCa.getId_patca());
		aptDTO.setId_pripat(patCa.getId_patpritp());
		aptDTO.setId_patcret(patCa.getId_patcrettp());
	}
	/**
	 * 生成就诊记录
	 * 
	 * @param param
	 * @param aptDTO
	 * @param pat
	 * @return
	 * @throws BizException 
	 */
	private String aptCreateEnt(PayForAptParamDTO param, OpAptDTO aptDTO, PatDO pat) throws BizException{
		HpInfoDTO hpInfo = param.getHpinfo();
		if(hpInfo != null)
			aptDTO.setCode_hppatca(hpInfo.getCode_hparea());
		IEnOutCmdService service = ServiceFinder.find(IEnOutCmdService.class);
		return service.aptCreateEnt(pat, aptDTO, FBoolean.FALSE);
	}
	/**
	 * 医保结算
	 * 
	 * @param param
	 * @param aptDTO
	 * @param pat
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private BlOpRegPayRltDTO hpPaySettle(PayForAptParamDTO param, OpAptDTO aptDTO, PatDO pat, String entId) throws BizException{
		BlOpRegPayDTO payInfo = new BlOpRegPayDTO();
		payInfo.setId_pat(pat.getId_pat());
		payInfo.setId_ent(entId);
		payInfo.setId_hp(aptDTO.getId_hp());
		payInfo.setId_stoep(param.getId_stoep());
		PriPmDO pmDO = getPriPm(param.getCode_paytp());
		payInfo.setSd_pm(pmDO.getCode());
		payInfo.setSd_pttp(this.setPttp(param.getCode_chltp()));
		payInfo.setAmt(new FDouble(param.getMoney_pay()));
		payInfo.setPaymodenode(param.getPaymodenode());
		payInfo.setBankno(param.getBankno());
		if(!StringUtils.isNullOrEmpty(param.getCode_hp())){
			HpInfoDTO hpInfo = param.getHpinfo();
			payInfo.setHpcardinfo(hpInfo.getHpcardinfo());
			payInfo.setHpregisterrtninfo(hpInfo.getHpregisterrtninfo());
			payInfo.setHpdetailuploadrtninfo(hpInfo.getHpdetailuploadrtninfo());
			payInfo.setHpstrtninfo(hpInfo.getHpstrtninfo());
		}
		IBlOpChargeForEnInnerService serv = ServiceFinder.find(IBlOpChargeForEnInnerService.class);
		BlOpRegPayRltDTO blOpRegPayRltDTO = serv.regPay(payInfo);
		if(blOpRegPayRltDTO == null || blOpRegPayRltDTO.getCgdetail() == null)
			throw new BizException("结算失败！");
		return blOpRegPayRltDTO;
	}
	
	private String setPttp(String code_chltp) throws BizException{
		SchedulechlDO schedulechlDO = new ChlTpEP().getScChlByTp(code_chltp);
		return schedulechlDO.getSd_pttp();
	}
	/**
	 * 获取支付方式
	 * 
	 * @param payType
	 * @return
	 * @throws BizException 
	 */
	private PriPmDO getPriPm(String payType) throws BizException{
		PriPmDO pmDo = new PriPmDO();
		PriPmDO[] pmDos = ServiceFinder.find(IPripmRService.class).findByAttrValString(PriPmDO.CODE, payType);
		if(!ArrayUtil.isEmpty(pmDos))
			pmDo = pmDos[0];
		if(pmDo == null)
			throw new BizException("支付方式错误！");
		return pmDo;
	}
	/**
	 * 回写预约状态
	 * 
	 * @param aptId
	 * @param entId
	 * @param cgId
	 * @throws BizException 
	 */
	private void updateCgStatus(String aptId, String entId, String cgId) throws BizException{
		//修改门诊急诊id
		List<OutpatientDO> list = (List<OutpatientDO>) new DAFacade().findByAttrValString(OutpatientDO.class, OutpatientDO.ID_ENT, entId, null);
		if (ListUtil.isEmpty(list))
			throw new BizException("门诊信息不存在！");
		OutpatientDO opDO = list.get(0);
		opDO.setId_cg(cgId);// 记账主键
		opDO.setFg_cg(FBoolean.TRUE);// 已结算标识
		opDO.setStatus(DOStatus.UPDATED);
		IOutpatientCudService opCudService = ServiceFinder.find(IOutpatientCudService.class);
		opCudService.save(new OutpatientDO[] { opDO });
		
		//修改预约门诊--就诊信息
		IScAptOpDORService aptOpRService = ServiceFinder.find(IScAptOpDORService.class);
		ScAptOpDO[] aptOpDOs = aptOpRService.findByAttrValString(ScAptOpDO.ID_APT, aptId);
		aptOpDOs[0].setId_en(entId);// 就诊id
		aptOpDOs[0].setDt_en(EiAppUtils.getServerDateTime());// 就诊时间
		aptOpDOs[0].setFg_en(FBoolean.TRUE);// 就诊标识
		aptOpDOs[0].setStatus(DOStatus.UPDATED);
		IScAptOpDOCudService aptOpCudService = ServiceFinder.find(IScAptOpDOCudService.class);
		aptOpCudService.save(new ScAptOpDO[] { aptOpDOs[0] });

		//修改预约为已结算
		ScAptDO aptDo = this.getAptDo(aptId);
		aptDo.setSd_status(IScDictCodeConst.SD_APTSTATUS_PAY); // 状态
		aptDo.setFg_payment(FBoolean.TRUE); // 已支付
		aptDo.setFg_bill(FBoolean.TRUE); // 已记费标志
		aptDo.setStatus(DOStatus.UPDATED);
		IScaptMDOCudService aptCudService = ServiceFinder.find(IScaptMDOCudService.class);
		aptCudService.save(new ScAptDO[]{aptDo});
	}
	/**
	 * 取号
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void takeTickNo(PayForAptParamDTO param) throws BizException{
		if(!StringUtils.isNullOrEmpty(param.getCode_hp()) 
				|| FBoolean.TRUE.equals(param.getFg_takeaptno())){
			IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
			serv.takeApptNoForAptNew(param.getId_apt(), param.getCode_opr());
		}
	}
	/**
	 * 设置结算信息
	 * 
	 * @param resultDto
	 * @param aptId
	 * @throws BizException
	 */
	private PayForAptResultDTO setStInfo(BlOpRegPayRltDTO blOpRegPayRltDTO) throws BizException{
		PayForAptResultDTO result = new PayForAptResultDTO();
		result.setId_stoep(blOpRegPayRltDTO.getId_stoep());
		result.setDt_st(EiAppUtils.getServerDateTime().toString());
		return result;
	}
}
