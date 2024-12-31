package iih.en.er.bp.registercanc;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.custom.EnOpCustomServiceUtils;
import iih.en.comm.ep.EntBedEP;
import iih.en.comm.ep.EntDeptEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.EntOpErEP;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnErUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.pv.enres.d.EnBedDO;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.HashSet;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;

/**
 * 急诊退号处理
 * 
 * @author liubin
 *
 */
public class HandleErCancRegistBP {
	/**
	 * 急诊退号处理
	 * 
	 * @param entId
	 * @throws BizException
	 */
	public void exec(String entId) throws BizException {
		boolean isCustom = EnOpCustomServiceUtils.handleErRegistCanc(entId);
		if(isCustom)
			return;
		//获取本次预检id
		String erPreId = EnErUtils.getPreIdByEntId(entId);
		if(EnValidator.isEmpty(erPreId))
			return;
		String preEntId = EnErUtils.getPreEntId(entId);
		PvEP ep = new PvEP();
		PatiVisitDO[] pvs = ep.getPvsByPKs(new String[]{entId, preEntId});
		PatiVisitDO entPv = null;
		PatiVisitDO prePv = null;
		for(PatiVisitDO pv : pvs){
			if(pv.getId_ent().equals(entId))
				entPv = pv;
			if(pv.getId_ent().equals(preEntId))
				prePv = pv;
		}
		//急诊抢救处理
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(entPv.getCode_entp())){
			if(prePv!=null && !IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(prePv.getCode_entp()))
				prePv = null;
			this.handleErFstaid(entPv, prePv);
		}
		//非急诊抢救，无特殊处理
		//en_erpre表处理
		this.updateErPre(erPreId, entId);
	}
	/**
	 * 急诊抢救退号处理
	 * 
	 * @param entPv
	 * @param prePv
	 * @throws BizException 
	 */
	private void handleErFstaid(PatiVisitDO entPv, PatiVisitDO prePv) throws BizException{
		if(prePv != null){
			String entId = entPv.getId_ent();
			String preEntId = prePv.getId_ent();
			//en_ent表处理
			this.updatePv(entPv, prePv);
			//en_ent_op表处理
			this.updateOp(entId, preEntId);
			//en_ent_op_er表处理
			this.updateOpEr(entId, preEntId);
			//en_ent_dep处理
			this.updateEntDep(entId, preEntId);
			//en_ent_emp处理
			this.updateEntEmp(entId, preEntId);
			//en_ent_bed处理
			this.updateEntBed(entId, preEntId);
		}
	}
	
	/**
	 * en_ent表处理
	 * 
	 * @param entPv
	 * @param prePv
	 * @throws BizException
	 */
	private void updatePv(PatiVisitDO entPv, PatiVisitDO prePv) throws BizException{
		PvEP ep = new PvEP();
		prePv.setStatus(DOStatus.UPDATED);
		prePv.setFg_acptvalid(entPv.getFg_acptvalid());
		prePv.setId_dep_nur(entPv.getId_dep_nur());
		prePv.setDt_end(entPv.getDt_end());
		ep.savePv(prePv);
	}
	/**
	 * en_ent_op表处理
	 * 
	 * @param entId
	 * @param preEntId
	 * @throws BizException
	 */
	private void updateOp(String entId, String preEntId) throws BizException{
		OpEP ep = new OpEP();
		OutpatientDO op = ep.getOpByEntIdWithOutRef(entId);
		ep.updateStatus(preEntId, op.getSd_status());
	}
	/**
	 * en_ent_op_er表处理
	 * 
	 * @param entId
	 * @param preEntId
	 * @throws BizException
	 */
	private void updateOpEr(String entId, String preEntId) throws BizException{
		EntOpErEP ep = new EntOpErEP();
		EnEntOpErDO entEr = ep.getByEntIdWithOutRef(entId);
		EnEntOpErDO preEr = ep.getByEntIdWithOutRef(preEntId);
		preEr.setStatus(DOStatus.UPDATED);
		preEr.setId_bed(entEr.getId_bed());
		preEr.setId_level_nur(entEr.getId_level_nur());
		preEr.setSd_level_nur(entEr.getSd_level_nur());
		ep.save(new EnEntOpErDO[]{preEr});
	}
	/**
	 * en_ent_dep表处理
	 * 
	 * @param entId
	 * @param preEntId
	 * @throws BizException
	 */
	private void updateEntDep(String entId, String preEntId) throws BizException{
		EntDeptEP ep = new EntDeptEP();
		EnDepDO[] deps = ep.getByEntId(entId);
		if(ArrayUtil.isEmpty(deps))
			return;
		Set<EnDepDO> set = new HashSet<>();
		for(EnDepDO dep : deps){
			EnDepDO copyDep = (EnDepDO) dep.clone();
			copyDep.setStatus(DOStatus.NEW);
			copyDep.setId_entdep(null);
			copyDep.setId_ent(preEntId);
			set.add(copyDep);
		}
		ep.save(set.toArray(new EnDepDO[set.size()]));
	}
	/**
	 * en_ent_emp表处理
	 * 
	 * @param entId
	 * @param preEntId
	 * @throws BizException
	 */
	private void updateEntEmp(String entId, String preEntId) throws BizException{
		EntEmpEP ep = new EntEmpEP();
		EnPsnDO[] emps = ep.getByEntId(entId);
		if(ArrayUtil.isEmpty(emps))
			return;
		Set<EnPsnDO> set = new HashSet<>();
		for(EnPsnDO emp : emps){
			EnPsnDO copyEmp = (EnPsnDO) emp.clone();
			copyEmp.setStatus(DOStatus.NEW);
			copyEmp.setId_entemp(null);
			copyEmp.setId_ent(preEntId);
			set.add(copyEmp);
		}
		ep.saveEmps(set.toArray(new EnPsnDO[set.size()]));
	}
	/**
	 * en_ent_bed表处理
	 * 
	 * @param entId
	 * @param preEntId
	 * @throws BizException
	 */
	private void updateEntBed(String entId, String preEntId) throws BizException{
		EntBedEP ep = new EntBedEP();
		EnBedDO[] beds = ep.getByEntId(entId);
		if(ArrayUtil.isEmpty(beds))
			return;
		Set<EnBedDO> set = new HashSet<>();
		for(EnBedDO bed : beds){
			EnBedDO copyBed = (EnBedDO) bed.clone();
			copyBed.setStatus(DOStatus.NEW);
			copyBed.setId_entbed(null);
			copyBed.setId_ent(preEntId);
			set.add(copyBed);
		}
		ep.saveBeds(set.toArray(new EnBedDO[set.size()]));
	}
	/**
	 * en_erpre表处理
	 * 
	 * @param erPreId
	 * @param preEntId
	 * @throws BizException
	 */
	private void updateErPre(String erPreId, String entId) throws BizException{
		ErPreEP ep = new ErPreEP();
		EnErPreDO erPre = ep.findById(erPreId);
		erPre.setStatus(DOStatus.UPDATED);
		String lastId = EnErUtils.getLastEntByPreIdExcEntId(erPreId, entId);
		if(EnValidator.isEmpty(lastId))
			erPre.setSd_status(IEnDictCodeConst.SD_STATUS_ERPRE_CANCEL);
		else
			erPre.setId_ent_last(lastId);
		ep.save(new EnErPreDO[]{erPre});
	}
}
