package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bl.hp.hpentcode.d.HpEntCodeDO;
import iih.bl.hp.hpentcode.i.IHpentcodeCudService;
import iih.bl.hp.hpentcode.i.IHpentcodeRService;
import iih.bl.hp.i.IBlHpOutCmdService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.custom.EnIpCustomServiceUtils;
import iih.en.comm.ep.EnEvtEP;
import iih.en.comm.ep.EnPatTpEP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.custom.d.EnHpPatCaInParamsDTO;
import iih.en.pv.hpdto.d.IpHpRegistDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.out.d.EnEvtDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.i.IPiRegMaintainService;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiRService;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 医保身份修改
 * 
 * @author liubin
 *
 */
public class UpdateIpHpRegistBP {
	/**
	 * 医保身份修改
	 * 
	 * @param ipHpRegist
	 * @throws BizException
	 */
	public void exec(IpHpRegistDTO ipHpRegist) throws BizException {
		if(ipHpRegist == null
				||EnValidator.isEmpty(ipHpRegist.getId_ent()))
			return;
		//修改就诊信息
		this.updateEnt(ipHpRegist);
		//修改住院信息
		this.updateIp(ipHpRegist);
		//修改医保信息
		this.updateHp(ipHpRegist);
		//医保交易表解锁，fanlq-2018-11-05
		this.setBlHpEncode(ipHpRegist);
		//医保患者信息
		this.updatePat(ipHpRegist);
		//设置患者贫困标签
		this.setPoorTag(ipHpRegist);
		//保存就诊低保标签，fanlq-2018-09-25-add
		this.setMinlivingTag(ipHpRegist);
		//保存就诊五保标签，fanlq-2018-09-25-add
		this.setFiveguarTag(ipHpRegist);
		//修改费用信息，fanlq-2018-10-05
		this.setBlInfo(ipHpRegist);
	}
	/**
	 * 修改就诊信息
	 * 
	 * @param ipHpRegist
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private void updateEnt(IpHpRegistDTO ipHpRegist) throws BizException{
		PvEP ep = new PvEP();
		PatiVisitDO patiVisit = ep.getPvByPK(ipHpRegist.getId_ent());
		String oldpiPatCa = patiVisit.getId_patca();//记录修改之前患者分类
		if(patiVisit==null)
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		patiVisit.setStatus(DOStatus.UPDATED);
		patiVisit.setId_patca(ipHpRegist.getId_patca());
		patiVisit.setId_pripat(ipHpRegist.getId_pripat());
		patiVisit.setId_patcret(ipHpRegist.getId_patcret());
		patiVisit.setId_hp(ipHpRegist.getId_hp());
		patiVisit.setCode_hpmedkind(ipHpRegist.getCode_hpmedkind());
		ep.savePv(patiVisit);
		
		//记录就诊变更事件 患者分类事件变更
		if(!oldpiPatCa.equals(ipHpRegist.getId_patca())){
			FDateTime curTime = EnAppUtils.getServerDateTime();
			EnEvtEP evtEP = new EnEvtEP();
			EnEvtDTO enEvtDO = new EnEvtDTO();
			enEvtDO.setStatus(DOStatus.NEW);
			enEvtDO.setId_ent(ipHpRegist.getId_ent());
			enEvtDO.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_PATCACHG);
			enEvtDO.setShort_des("修改患者分类");
			enEvtDO.setDes("患者编码："+ipHpRegist.getCode_pat()+" 患者分类修改前："+oldpiPatCa+" 患者分类修改后："+ipHpRegist.getId_patca()+"");
			enEvtDO.setDt_evt(curTime);
			enEvtDO.setDt_insert(curTime);
			enEvtDO.setId_emp_rec(EnContextUtils.getPsnId());		
			enEvtDO.setVal_old(oldpiPatCa);
			enEvtDO.setVal_new(ipHpRegist.getId_patca());
			evtEP.insertEvt(new  EnEvtDTO[]{enEvtDO});
		}
	}
	/**
	 * 住院信息修改
	 * 
	 * @param ipHpRegist
	 * @throws BizException
	 */
	private void updateIp(IpHpRegistDTO ipHpRegist) throws BizException{
		IpEP ep = new IpEP();
		InpatientDO ipInpatient = ep.getIpByEntId(ipHpRegist.getId_ent());
		if(ipInpatient == null)
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		ipInpatient.setStatus(DOStatus.UPDATED);
		ipInpatient.setId_diag_op(ipHpRegist.getId_diag_op());
		ipInpatient.setDesc_diag_op(ipHpRegist.getDesc_diag_op());
		//根据医保设置医疗付费方式（调用客开方法处理）
		EnHpPatCaInParamsDTO inParam = new EnHpPatCaInParamsDTO();
		inParam.setId_ent(ipHpRegist.getId_ent());
		inParam.setId_pat(ipHpRegist.getId_pat());
		inParam.setId_patca(ipHpRegist.getId_patca());
		inParam.setId_hp(ipHpRegist.getId_hp());
		inParam.setCode_hpkind(ipHpRegist.getCode_hpkind());
		inParam.setCode_hpmedkind(ipHpRegist.getCode_hpmedkind());
		inParam.setCode_hppatca(ipHpRegist.getCode_hppatca());
		inParam.setFg_selfpay(FBoolean.valueOf(EnValidator.isEmpty(ipHpRegist.getId_hp())));
		UdidocDO payMethod = EnIpCustomServiceUtils.getPayMethodByHp(inParam);
		if(payMethod!=null){
			ipInpatient.setSd_pay_mothod(payMethod.getCode());
			ipInpatient.setName_pay_mothod(payMethod.getName());
		}
		ep.save(ipInpatient);
	}
	/**
	 * 医保信息修改
	 * 
	 * @param enHosReg
	 * @throws BizException
	 */
	private void updateHp(IpHpRegistDTO ipHpRegist)throws BizException{
		// 删除已有
		EntHpEP  ep= new EntHpEP();
		ep.deleteByEntId(ipHpRegist.getId_ent());
		// 保存最新
		ep.saveEntHp(ipHpRegist);
	}
	/**
	 * 患者信息修改
	 * 
	 * @param enHosReg
	 * @throws BizException
	 */
	private void updatePat(IpHpRegistDTO ipHpRegist)throws BizException{
		IPatiRService rServ = ServiceFinder.find(IPatiRService.class);
		PatiAggDO agg = rServ.findById(ipHpRegist.getId_pat());
//		this.setPatInfo(agg, ipHpRegist); // 0157814: 【郑州骨伤病医院】【产品版】【刘朝阳】【门诊收费】 患者住院是县级收费 看门诊时 患者费别也是县级价格，门诊患者应该是正常价格  
		this.setPatHpInfo(agg, ipHpRegist);
		IPiRegMaintainService cudServ = ServiceFinder.find(IPiRegMaintainService.class);
		cudServ.savePatForHosReg(agg);
	}
//	/**
//	 * 设置患者信息
//	 * 
//	 * @param agg
//	 * @param enHosReg
//	 * @throws BizException
//	 */
//	private void setPatInfo(PatiAggDO agg, IpHpRegistDTO ipHpRegist)throws BizException {
//		PatDO pat = agg.getParentDO();
//		pat.setStatus(DOStatus.UPDATED);
//		if(!EnValidator.isEmpty(ipHpRegist.getId_patca()))
//			pat.setId_paticate(ipHpRegist.getId_patca());
//		if(!EnValidator.isEmpty(ipHpRegist.getId_pripat()))
//			pat.setId_patpritp(ipHpRegist.getId_pripat());
//		if(!EnValidator.isEmpty(ipHpRegist.getId_patcret()))
//			pat.setId_patcrettp(ipHpRegist.getId_patcret());
//	}
	/**
	 * 设置患者医保信息
	 * 
	 * @param agg
	 * @param enHosReg
	 * @throws BizException
	 */
	private void setPatHpInfo(PatiAggDO agg, IpHpRegistDTO ipHpRegist) throws BizException {
		// 没有主医保，也肯定没有辅医保，辅医保依附主医保存在
		if(EnValidator.isEmpty(ipHpRegist.getId_hp()))
			return;
		PiPatHpDO[] patHps = agg.getPiPatHpDO();
		List<PiPatHpDO> patHpList = new LinkedList<PiPatHpDO>();
		if(!EnValidator.isEmpty(patHps))
			Collections.addAll(patHpList, patHps);
		boolean hasMainHp = false;
		boolean hasDeft = false;
		int sortno = 0;
		for(PiPatHpDO patHp : patHpList){
			if(!hasDeft)
				hasDeft = FBoolean.TRUE.equals(patHp.getFg_deft());
			if (ipHpRegist.getId_hp().equals(patHp.getId_hp())) {
				patHp.setNo_hp(ipHpRegist.getNo_hp());
				patHp.setHp_name(ipHpRegist.getName_hp());
				patHp.setStatus(DOStatus.UPDATED);
				hasMainHp = true;
			}
			if(patHp.getSortno() != null && sortno < patHp.getSortno())
				sortno = patHp.getSortno();
		}
		FDateTime currentTime = EnAppUtils.getServerDateTime();
		
		// 没有找到，则新建主医保
		if (!hasMainHp) {
			PiPatHpDO patHp = new PiPatHpDO();
			patHp.setId_pat(agg.getParentDO().getId_pat());
			patHp.setStatus(DOStatus.NEW);
			patHp.setSortno(++sortno); // 序号
			patHp.setId_hp(ipHpRegist.getId_hp()); // 医保计划
			patHp.setNo_hp(ipHpRegist.getNo_hp()); // 医保号
			patHp.setMode_hp(IPiDictCodeConst.ID_HP_ENABLE);
			// 没有主医保，则此就是主医保
			patHp.setFg_deft(new FBoolean(!hasDeft)); // 默认标志
			patHp.setDt_b(currentTime); // 有效日期开始
			patHp.setFg_act(FBoolean.TRUE); // 启用标志
			patHpList.add(patHp);
		}
		agg.setPiPatHpDO(patHpList.toArray(new PiPatHpDO[0]));
	}
	/**
	 * 设置患者贫困标签
	 * 
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void setPoorTag(IpHpRegistDTO ipHpRegist) throws BizException{
		new EnPatTpEP().setEntPoorTag(ipHpRegist.getId_ent(), ipHpRegist.getFg_poor());
	}
	/**
	 * 设置患者低保标签
	 * 
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void setMinlivingTag(IpHpRegistDTO ipHpRegist) throws BizException{
		new EnPatTpEP().setMinlivingTag(ipHpRegist.getId_ent(), ipHpRegist.getFg_minliving());
	}
	/**
	 * 设置患者五保标签
	 * 
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void setFiveguarTag(IpHpRegistDTO ipHpRegist) throws BizException{
		new EnPatTpEP().setFiveguarTag(ipHpRegist.getId_ent(), ipHpRegist.getFg_fiveguar());
	}
	/****
	 * 修改费用信息，fanlq-2018-10-05
	 * @param ipHpRegist
	 * @throws BizException 
	 */
	private void setBlInfo(IpHpRegistDTO ipHpRegist) throws BizException{
		IBlHpOutCmdService service = ServiceFinder.find(IBlHpOutCmdService.class);
		service.updteAfterChangeHpIdentity(ipHpRegist.getId_ent());
	}
	/***
	 * 医保交易表解锁，fanlq-2018-11-05
	 * 
	 * @param ipHpRegist
	 * @throws BizException
	 */
	private void setBlHpEncode(IpHpRegistDTO ipHpRegist) throws BizException{
		if(EnValidator.isEmpty(ipHpRegist.getId_hp()))
			return;
		IHpentcodeRService rservice = ServiceFinder.find(IHpentcodeRService.class);
		IHpentcodeCudService cudservice = ServiceFinder.find(IHpentcodeCudService.class);
		HpEntCodeDO[] hpEntCodeDOs = rservice.find("Id_ent = '"+ipHpRegist.getId_ent()+"' and Fg_active = 'Y' ", "sv desc", FBoolean.FALSE);
		if(hpEntCodeDOs != null && hpEntCodeDOs.length > 0){
			for(HpEntCodeDO hpEntCodeDO : hpEntCodeDOs){
				hpEntCodeDO.setFg_lock(FBoolean.FALSE);
				hpEntCodeDO.setStatus(DOStatus.UPDATED);
			}
		}
		cudservice.save(hpEntCodeDOs);
	}
}
