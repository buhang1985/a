package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnPatTpEP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.i.IPiRegMaintainService;
import iih.pi.reg.pat.d.PatDO;
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

/**
 * 住院医保身份修改
 * 
 * @author liubin
 *
 */
public class IpRegHpInfoChgBP {
	/**
	 * 住院医保身份修改
	 * 
	 * @param enHosReg
	 * @throws BizException
	 */
	public void exec(EnHosPatDTO patDTO, EnHosRegDTO enHosReg) throws BizException {
		if(enHosReg==null
				||EnValidator.isEmpty(enHosReg.getId_ent()))
			return;
		//修改就诊信息
		this.updateEnt(patDTO, enHosReg);
		//修改住院信息
		this.updateIp(enHosReg);
		//修改医保信息
		this.updateHp(enHosReg);
		//修改患者信息
		this.updatePat(patDTO, enHosReg);
		//修改贫困标志信息
		this.setPoorTag(enHosReg);
		
		
	}
	/**
	 * 修改就诊信息
	 * 
	 * @param enHosReg
	 * @throws BizException
	 */
	private void updateEnt(EnHosPatDTO patDTO, EnHosRegDTO enHosReg) throws BizException{
		PvEP ep = new PvEP();
		PatiVisitDO patiVisit = ep.getPvByPK(enHosReg.getId_ent());
		if(patiVisit==null)
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		patiVisit.setStatus(DOStatus.UPDATED);
		patiVisit.setCode(enHosReg.getCode_ent());
		patiVisit.setId_patca(enHosReg.getId_paticate());
		patiVisit.setId_pripat(enHosReg.getId_pripat());
		patiVisit.setId_patcret(enHosReg.getId_patcret());
		patiVisit.setId_hp(enHosReg.getPrim_cplan());
		patiVisit.setCode_hpmedkind(enHosReg.getCode_hpmedkind());
		if(!EnValidator.isEmpty(patDTO.getId_sex())){
			patiVisit.setId_sex_pat(patDTO.getId_sex());
			patiVisit.setSd_sex_pat(patDTO.getSd_sex());
		}
		if(patDTO.getDt_birth()!=null)
			patiVisit.setDt_birth_pat(patDTO.getDt_birth());
		ep.savePv(patiVisit);
	}
	/**
	 * 住院信息修改
	 * 
	 * @param enHosReg
	 * @throws BizException
	 */
	private void updateIp(EnHosRegDTO enHosReg) throws BizException{
		IpEP ep = new IpEP();
		InpatientDO ipInpatient = ep.getIpByEntId(enHosReg.getId_ent());
		if(ipInpatient == null)
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		ipInpatient.setStatus(DOStatus.UPDATED);
		ipInpatient.setId_diag_op(enHosReg.getId_diag());
		ipInpatient.setDesc_diag_op(enHosReg.getDesc_diag());
		ep.save(ipInpatient);
	}
	/**
	 * 医保信息修改
	 * 
	 * @param enHosReg
	 * @throws BizException
	 */
	private void updateHp(EnHosRegDTO enHosReg)throws BizException{
		// 删除已有
		EntHpEP  ep= new EntHpEP();
		ep.deleteByEntId(enHosReg.getId_ent());
		// 保存最新
		ep.saveEntHp(enHosReg.getId_ent(), enHosReg);
	}
	/**
	 * 患者信息修改
	 * 
	 * @param enHosReg
	 * @throws BizException
	 */
	private void updatePat(EnHosPatDTO patDTO, EnHosRegDTO enHosReg)throws BizException{
		PatEP ep = new PatEP();
		ep.updateSdCodeTp2Others(enHosReg.getId_pat(), patDTO.getSd_idtp(), patDTO.getId());
		IPatiRService rServ = ServiceFinder.find(IPatiRService.class);
		PatiAggDO agg = rServ.findById(enHosReg.getId_pat());
		this.setPatInfo(agg, patDTO, enHosReg);
		this.setPatHpInfo(agg, enHosReg);
		IPiRegMaintainService cudServ = ServiceFinder.find(IPiRegMaintainService.class);
		cudServ.savePatForHosReg(agg);
	}
	/**
	 * 设置患者信息
	 * 
	 * @param agg
	 * @param enHosReg
	 * @throws BizException
	 */
	private void setPatInfo(PatiAggDO agg, EnHosPatDTO patDTO, EnHosRegDTO enHosReg)throws BizException {
		PatDO pat = agg.getParentDO();
		pat.setStatus(DOStatus.UPDATED);
		if(!EnValidator.isEmpty(enHosReg.getId_paticate()))
			pat.setId_paticate(enHosReg.getId_paticate());
		if(!EnValidator.isEmpty(enHosReg.getId_pripat()))
			pat.setId_patpritp(enHosReg.getId_pripat());
		if(!EnValidator.isEmpty(enHosReg.getId_patcret()))
			pat.setId_patcrettp(enHosReg.getId_patcret());
		if(!EnValidator.isEmpty(patDTO.getId_idtp()))
			pat.setId_idtp(patDTO.getId_idtp());
		if(!EnValidator.isEmpty(patDTO.getSd_idtp()))
			pat.setSd_idtp(patDTO.getSd_idtp());
		if(!EnValidator.isEmpty(patDTO.getId()))
			pat.setId_code(patDTO.getId());
		if(!EnValidator.isEmpty(patDTO.getId_sex())){
			pat.setId_sex(patDTO.getId_sex());
			pat.setSd_sex(patDTO.getSd_sex());
		}
		if(patDTO.getDt_birth()!=null)
			pat.setDt_birth(patDTO.getDt_birth());
		
	}
	/**
	 * 设置患者医保信息
	 * 
	 * @param agg
	 * @param enHosReg
	 * @throws BizException
	 */
	private void setPatHpInfo(PatiAggDO agg, EnHosRegDTO enHosReg) throws BizException {
		// 如果主医保不存在，则不处理。
		// 没有主医保，也肯定没有辅医保，辅医保依附主医保存在
		if(EnValidator.isEmpty(enHosReg.getPrim_cplan()))
			return;
		PiPatHpDO[] patHps = agg.getPiPatHpDO();
		List<PiPatHpDO> patHpList = new LinkedList<PiPatHpDO>();
		if(!EnValidator.isEmpty(patHps))
			Collections.addAll(patHpList, patHps);
		boolean hasMainHp = false;
		boolean hasExtraHp = false;
		boolean hasDeft = false;
		int sortno = 0;
		for(PiPatHpDO patHp : patHpList){
			if(!hasDeft)
				hasDeft = FBoolean.TRUE.equals(patHp.getFg_deft());
			if (enHosReg.getPrim_cplan().equals(patHp.getId_hp())) {
				patHp.setNo_hp(enHosReg.getCode_hp());
				patHp.setHp_name(enHosReg.getPrim_name());
				patHp.setStatus(DOStatus.UPDATED);
				hasMainHp = true;
			}else if (!EnValidator.isEmpty(enHosReg.getAuxi_cplan()) && enHosReg.getAuxi_cplan().equals(patHp.getId_hp())) {
				patHp.setNo_hp(enHosReg.getCode_hp2());
				patHp.setHp_name(enHosReg.getAuxi_name());
				patHp.setStatus(DOStatus.UPDATED);
				hasExtraHp = true;
			}
			if(patHp.getSortno() != null && sortno < patHp.getSortno())
				sortno = patHp.getSortno();
		}
		FDateTime currentTime = EnAppUtils.getServerDateTime();
		
		// 没有找到，则新建主医保
		if (!hasMainHp && !EnValidator.isEmpty(enHosReg.getPrim_cplan())) {
			PiPatHpDO patHp = new PiPatHpDO();
			patHp.setId_pat(agg.getParentDO().getId_pat());
			patHp.setStatus(DOStatus.NEW);
			patHp.setSortno(++sortno); // 序号
			patHp.setId_hp(enHosReg.getPrim_cplan()); // 医保计划
			patHp.setNo_hp(enHosReg.getCode_hp()); // 医保号
			patHp.setMode_hp(IPiDictCodeConst.ID_HP_ENABLE);
			// 没有主医保，则此就是主医保
			patHp.setFg_deft(new FBoolean(!hasDeft)); // 默认标志
			patHp.setDt_b(currentTime); // 有效日期开始
			patHp.setFg_act(FBoolean.TRUE); // 启用标志
			patHpList.add(patHp);
		}

		// 新建辅助医保
		if (!hasExtraHp && !EnValidator.isEmpty(enHosReg.getAuxi_cplan())) {
			PiPatHpDO patHp = new PiPatHpDO();
			patHp.setStatus(DOStatus.NEW);
			patHp.setId_pat(agg.getParentDO().getId_pat());
			patHp.setSortno(++sortno); // 序号
			patHp.setId_hp(enHosReg.getAuxi_cplan()); // 医保计划
			patHp.setNo_hp(enHosReg.getCode_hp2()); // 医保号
			patHp.setFg_deft(FBoolean.FALSE); // 默认标志
			patHp.setDt_b(currentTime); // 有效日期开始
			patHp.setFg_act(FBoolean.TRUE); // 启用标志
			patHp.setMode_hp(IPiDictCodeConst.ID_HP_ENABLE);
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
	private void setPoorTag(EnHosRegDTO enHosRegDTO) throws BizException{
		new EnPatTpEP().setEntPoorTag(enHosRegDTO.getId_ent(), enHosRegDTO.getFg_poor());
	}
}
