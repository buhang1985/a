package iih.ci.mr.s.bp.createmr;

import java.util.List;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDORService;
import iih.bd.srv.mrtaskrule.d.MrTaskRuleDO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.mrpsndto.d.MrPsnDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class AutoCreateCiMrDoBp {

	public  CiMrDO createMr(String id_ent,MrTaskRuleDO ruleDo,String tmpl,String tmplName) throws BizException{
		IPativisitRService patService= ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = patService.findById(id_ent);	
		IInpatientRService inpatService= ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatientDOs = inpatService.find("id_ent='"+id_ent+"'", "", FBoolean.FALSE);
		IEmrtplMDORService mrtplService=ServiceFinder.find(IEmrtplMDORService.class);
		EmrTplDO emrTplDO = mrtplService.findById(tmpl);
		
		CiMrDO cimrdo=new CiMrDO();
		cimrdo.setId_org(Context.get().getOrgId());
		cimrdo.setId_grp(Context.get().getGroupId());
		cimrdo.setId_ent(id_ent);
		if(inpatientDOs!=null && inpatientDOs.length>0){
			cimrdo.setId_bed(inpatientDOs[0].getId_bed());
			cimrdo.setId_dep_nuradm(inpatientDOs[0].getId_dep_nuradm());
		}	
		if(patiVisitDO!=null){
			cimrdo.setId_pat(patiVisitDO.getId_pat());
			cimrdo.setId_entp(patiVisitDO.getId_entp());
			cimrdo.setCode_entp(patiVisitDO.getCode_entp());
			cimrdo.setPat_age(AgeCalcUtil.getAge(patiVisitDO.getDt_birth_pat()));
			cimrdo.setId_sex(Integer.valueOf(patiVisitDO.getSd_sex_pat()));
		}	
		cimrdo.setId_mrtp(ruleDo.getId_mrtp());
		cimrdo.setId_mrtpl(tmpl);
		cimrdo.setName(tmplName);
		cimrdo.setId_dep(Context.get().getDeptId());
		cimrdo.setId_dep_pat(Context.get().getDeptId());
		cimrdo.setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_NEW);
		cimrdo.setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_NEW);
		cimrdo.setId_mred(emrTplDO.getId_mred());		
		cimrdo.setId_mrtplstmd(emrTplDO.getBase_id_mrtplstmd()); 
		cimrdo.setSd_mrtplstmd(emrTplDO.getBase_sd_mrtplstmd());
		cimrdo.setId_emp(Context.get().getUserId());
		cimrdo.setId_mrcactm(ruleDo.getId_mrcactm());
		FDateTime time=new FDateTime();
		cimrdo.setDt_rd(time);
		MrPsnDTO[] psnDtos=getPsnDtosByIdEnt(id_ent);
		if(psnDtos!=null && psnDtos.length>0){
			for(MrPsnDTO psnDto: psnDtos){
				if("责任医师".equals(psnDto.getPsndocname())){
					cimrdo.setId_treat_doctor(psnDto.getId_user());
				}
				if("主治医师".equals(psnDto.getPsndocname())){
					cimrdo.setId_mast_doctor(psnDto.getId_user());
				}
				if(psnDto.getPsndocname().contains("主任")){
					cimrdo.setId_dir_doctor(psnDto.getId_user());
				}
			}			
		}
		cimrdo.setStatus(DOStatus.NEW);
		return cimrdo;
	}
	
	// 获取医疗组人员
    public MrPsnDTO[] getPsnDtosByIdEnt(String id_ent) throws BizException{
    	DAFacade daf = new DAFacade();
		String strSql ="select b.id_psndoc as id_psn ,b.name,udi.name as psndocname, us.id_user from en_ent_emp emp "
				+" left join sys_user  us on us.id_psn=emp.id_emp "
				+" left join bd_psndoc  b on b.id_psndoc = emp.id_emp "
				+" left join bd_udidoc udi "
				+" on udi.id_udidoclist = '@@@@ZZ2000000000004V' and emp.sd_emprole=udi.code "
				+" where emp.id_ent = '"+id_ent+"' and emp.dt_b is not null and emp.dt_e is null order by emp.dt_b desc ";		
		@SuppressWarnings("unchecked")
		List<MrPsnDTO> listmrpsndtos = (List<MrPsnDTO>) daf.execQuery(strSql, new BeanListHandler(MrPsnDTO.class));
		if(listmrpsndtos==null) return null;
	    return (MrPsnDTO[]) listmrpsndtos.toArray(new MrPsnDTO[listmrpsndtos.size()]);
    }
}
