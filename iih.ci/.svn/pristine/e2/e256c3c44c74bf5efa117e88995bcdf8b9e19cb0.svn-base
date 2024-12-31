package iih.ci.mr.s.listener;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.s.bp.AmrBP;
import iih.ci.mr.s.bp.common.AgeUtil;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnpsnRService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;

public class MrAmrIpListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {

		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		EnterDept4EsDTO enterDept4EsDTO = (EnterDept4EsDTO) bizUserObj.getUserObj();
		if(enterDept4EsDTO==null)
		{
			return;
		}
		
		EnPsnDO[] enPsnDOs = getEnPsnArray(enterDept4EsDTO.getId_ent());
		
		IPativisitRService iPativisitRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = iPativisitRService.findById(enterDept4EsDTO.getId_ent());
		
		IInpatientRService iInpatientRService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatients = iInpatientRService.findByAttrValString("Id_ent", enterDept4EsDTO.getId_ent());
		
		insertAmr(getEnPsnDO(enPsnDOs,IEnDictCodeConst.SD_EMPROLE_DOCTOR),getEnPsnDO(enPsnDOs,IEnDictCodeConst.SD_EMPROLE_ZZDOC),getEnPsnDO(enPsnDOs,IEnDictCodeConst.SD_EMPROLE_ZRDOC),patiVisitDO,(inpatients==null||inpatients.length<=0)?new InpatientDO(): inpatients[0]);
		
	}


	private void insertAmr(EnPsnDO enPsnDOtreat,EnPsnDO enPsnDOmast,EnPsnDO enPsnDOdir, PatiVisitDO patiVisitDO, InpatientDO inpatient) throws BizException {
		AmrBP amrBp = new AmrBP();
		AMrDO amrdo = amrBp.getAmrDO(patiVisitDO.getId_ent());
		if (amrdo != null) {
			amrdo.setStatus(DOStatus.UPDATED);
		} else {
			amrdo = new AMrDO();
			amrdo.setStatus(DOStatus.NEW);
		}
		amrdo.setId_ent(patiVisitDO.getId_ent());
		amrdo.setId_pat(patiVisitDO.getId_pat());
		amrdo.setId_treat_doctor(enPsnDOtreat.getId_emp());
		amrdo.setId_mast_doctor(enPsnDOmast.getId_emp());
		amrdo.setId_dir_doctor(enPsnDOdir.getId_emp());
		amrdo.setId_emp_nur(patiVisitDO.getId_emp_nur());
		amrdo.setCode_entp(IEnDictCodeConst.SD_EMPROLE_DOCTOR);
		amrdo.setId_dep_nuradm(patiVisitDO.getId_dep_nur());
		amrdo.setId_bed(inpatient.getId_bed());
		amrdo.setId_sex(patiVisitDO.getId_sex_pat());
		amrdo.setPat_age(AgeUtil.getAge(patiVisitDO.getDt_birth_pat(), patiVisitDO.getDt_acpt()));
		amrdo.setId_dep_cur(patiVisitDO.getId_dep_phy());
		amrdo.setId_qa_doctor_part_sta(ICiMrDictCodeConst.ID_MR_WRITING);
		amrdo.setId_qa_nurse_part_sta(ICiMrDictCodeConst.ID_MR_WRITING);
		amrdo.setSd_qa_doctor_part_sta(ICiMrDictCodeConst.SD_MR_WRITING);
		amrdo.setSd_qa_nurse_part_sta(ICiMrDictCodeConst.SD_MR_WRITING);
		amrdo.setCode_amr_ip(inpatient.getCode_amr_ip());
		if (inpatient.getTimes_ip() != null) {
			amrdo.setInhos_times(inpatient.getTimes_ip().toString());
		}
		amrdo.setId_org(Context.get().getOrgId());
		amrdo.setId_grp(Context.get().getGroupId());
		amrdo.setCode_amr_times(inpatient.getCode_amr_ip()+"+"+inpatient.getTimes_ip());
		amrBp.saveAmr(amrdo);
	}
	
	private EnPsnDO[] getEnPsnArray(String entId) throws BizException {
		IEnpsnRService retrieveService = ServiceFinder.find(IEnpsnRService.class);
		String whereStr = String.format("id_ent= '%s'  and (Isnull(dt_e,'~')='~') ", entId);
		EnPsnDO[] oriDOs = retrieveService.find(whereStr, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(oriDOs))
			return null;
		return oriDOs;
	}
	
	private EnPsnDO getEnPsnDO(EnPsnDO[] enpsnDOs, String emproleSd) {
		if (ArrayUtil.isEmpty(enpsnDOs)) {
			return null;
		}
		EnPsnDO enpsndo = null;
		for (EnPsnDO enpsnDo : enpsnDOs) {
			if (enpsnDo.getSd_emprole().equals(emproleSd)) {
				enpsndo = enpsnDo;
			}
		}
		return enpsndo;
	}
	
}
