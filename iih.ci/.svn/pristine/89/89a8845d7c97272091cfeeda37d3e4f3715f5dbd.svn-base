package iih.ci.mr.s.listener;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.s.bp.AmrBP;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnpsnRService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.que.dto.d.OpQue4EsDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
/**
 * 接诊后修改或者新增amrDO
 * @author 病历， renying(优化)
 *
 */
public class MrAmrOpListener implements IBusinessListener {

	@Override
	@SuppressWarnings("unchecked")
	public void doAction(IBusinessEvent event) throws BizException {

		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		OpQue4EsDTO opQue4EsDTO =(OpQue4EsDTO) bizUserObj.getUserObj();
		if(opQue4EsDTO==null)
		{
			return;
		}
		//1.获取就诊do
		PatiVisitDO patiVisitDO =  (PatiVisitDO) new DAFacade().findByPK(PatiVisitDO.class, opQue4EsDTO.getId_ent());	
		//2.获取门诊DO
		List<OutpatientDO> outpatientDOs = (List<OutpatientDO>) new DAFacade().findByAttrValString(OutpatientDO.class, OutpatientDO.ID_ENT, opQue4EsDTO.getId_ent(), null);
		//3.查询门诊数据
		String whereStr = String.format("id_ent= '%s'  and (Isnull(dt_e,'~')='~') and Sd_emprole='%s' ",opQue4EsDTO.getId_ent(), IEnDictCodeConst.SD_EMPROLE_OPDOC);
		List<EnPsnDO> enPsnDOs =(List<EnPsnDO>) new DAFacade().findByCond(EnPsnDO.class, whereStr,"dt_b desc" );
		if(ListUtil.isEmpty(outpatientDOs)||ListUtil.isEmpty(outpatientDOs)|| ListUtil.isEmpty(enPsnDOs))
			throw new BizException("获取就诊数据出错");	
	
		this.insertAmr(enPsnDOs.get(0), patiVisitDO, outpatientDOs.get(0));				
	}	
	/**
	 * 插入或者新增amrDO
	 * @param enPsnDO
	 * @param patiVisitDO
	 * @param outpatientDO
	 * @throws BizException
	 */
	private void insertAmr(EnPsnDO enPsnDO,PatiVisitDO patiVisitDO, OutpatientDO outpatientDO) throws BizException {
		AmrBP amrBp = new AmrBP();
		List<AMrDO> amrdoList = (List<AMrDO>) new DAFacade().findByAttrValString(AMrDO.class, AMrDO.ID_ENT, patiVisitDO.getId_ent(), null);
		AMrDO amrdo = null;
		if (!ListUtil.isEmpty(amrdoList)) {
			amrdo =amrdoList.get(0);
			amrdo.setStatus(DOStatus.UPDATED);
		} else {
		    amrdo = new AMrDO();
			amrdo.setStatus(DOStatus.NEW);
		}
		amrdo.setId_ent(patiVisitDO.getId_ent());
		amrdo.setId_pat(patiVisitDO.getId_pat());
		amrdo.setId_user_acpt(enPsnDO.getId_emp());
		amrdo.setId_emp_nur(patiVisitDO.getId_emp_nur());
		amrdo.setCode_entp(IEnDictCodeConst.SD_EMPROLE_OPDOC);
		amrdo.setId_dep_nuradm(patiVisitDO.getId_dep_nur());
		amrdo.setId_sex(patiVisitDO.getId_sex_pat());
		amrdo.setPat_age(AgeCalcUtil.getAge(patiVisitDO.getDt_birth_pat()));
		amrdo.setId_dep_cur(patiVisitDO.getId_dep_phy());
		amrdo.setId_qa_doctor_part_sta(ICiMrDictCodeConst.ID_MR_WRITING);
		amrdo.setId_qa_nurse_part_sta(ICiMrDictCodeConst.ID_MR_WRITING);
		amrdo.setSd_qa_doctor_part_sta(ICiMrDictCodeConst.SD_MR_WRITING);
		amrdo.setSd_qa_nurse_part_sta(ICiMrDictCodeConst.SD_MR_WRITING);
		amrdo.setCode_amr_ip(outpatientDO.getCode_amr_oep());
		if (outpatientDO.getTimes_op() != null) {
			amrdo.setInhos_times(outpatientDO.getTimes_op().toString());
		}
		amrdo.setId_org(Context.get().getOrgId());
		amrdo.setId_grp(Context.get().getGroupId());
		amrBp.saveAmr(amrdo);
	}
	
	
}
