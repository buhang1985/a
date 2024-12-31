/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.s.bp.outqc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.ymer.core.xml.StringUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mrqc.cimrqcrandomrule.d.CiMrQcRandomRuleDO;
import iih.ci.mrqc.cimrqcrandomrule.i.ICimrqcrandomruleCudService;
import iih.ci.mrqc.mrqcerrordto.d.MrQcErrorDTO;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordDO;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordItmDO;
import iih.ci.mrqc.randomcheck.d.MrqcrandomcheckAggDO;
import iih.ci.mrqc.randomcheck.i.ICiMrQcRandomRecordItmDOCudService;
import iih.ci.mrqc.randomcheck.i.ICiMrQcRandomRecordItmDORService;
import iih.ci.mrqc.randomcheck.i.IMrqcrandomcheckCudService;
import iih.ci.mrqc.randomqc.d.MrQcRandomItmDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 〈扼要描述〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class OutMrQcSaveBP {
	/**
	 * 门诊部 根据规则设置 产生各个科室的抽查数据
	 * @param ruleDos
	 * @return
	 * @throws BizException
	 */
	public MrQcErrorDTO[] OpdInsertRandomRecordByRule(CiMrQcRandomRuleDO[] ruleDos)
			throws BizException {
		String id_org=Context.get().getOrgId();
		String id_grp=Context.get().getGroupId();
		String id_emp=Context.get().getStuffId();
		String id_dep=Context.get().getDeptId();
		List<MrQcErrorDTO> errorList=new ArrayList<MrQcErrorDTO>();

		IMrqcrandomcheckCudService aggService=ServiceFinder.find(IMrqcrandomcheckCudService.class);
		List<MrqcrandomcheckAggDO> aggDolist =new ArrayList<MrqcrandomcheckAggDO>();
		for (int i = 0; i < ruleDos.length; i++) {
			MrqcrandomcheckAggDO aggDo= new MrqcrandomcheckAggDO();
			CiMrQcRandomRecordDO recordDo=new CiMrQcRandomRecordDO();
			recordDo.setId_grp(id_grp);
			recordDo.setId_org(id_org);
			recordDo.setId_emp_random_record(id_emp);
			recordDo.setId_dep_random_record(id_dep);
			recordDo.setId_by_dep(ruleDos[i].getId_dep_random_rule());
			recordDo.setName_random_record("门诊部-"+new FDate()+"-抽查-"+ruleDos[i].getName_dep_random_rule()+"-"+ruleDos[i].getCount_random_rule()+"份");
			recordDo.setId_type_random(ICiMrDictCodeConst.ID_MR_QC_RANDOM_TYPE_OPD);
			recordDo.setSd_type_random(ICiMrDictCodeConst.SD_MR_QC_RANDOM_TYPE_OPD);
			recordDo.setId_random_status(ICiMrDictCodeConst.ID_MR_QC_RANDOM_MAIN_STATUS_YIFENPEI);
			recordDo.setSd_random_status(ICiMrDictCodeConst.SD_MR_QC_RANDOM_MAIN_STATUS_YIFENPEI);
			recordDo.setDt_random_record(new FDate());
			recordDo.setDt_dead_random(ruleDos[i].getDt_random_rule());
			recordDo.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			recordDo.setTimes_random_record(ruleDos[i].getCount_random_rule());
			recordDo.setIs_outdep_qc(ruleDos[i].getIs_outdep_qc());
			recordDo.setStatus(DOStatus.NEW);
			
			PatiVisitDO[] entDoArr=getPatiRandom(ruleDos[i].getId_dep_random_rule(),ruleDos[i].getDt_begin_random(),ruleDos[i].getDt_end_random(),ruleDos[i].getCount_random_rule(),ruleDos[i].getId_doc());
			//校验数据是否够
			if (entDoArr.length<ruleDos[i].getCount_random_rule()) {
				MrQcErrorDTO errorDto=new MrQcErrorDTO();
				errorDto.setError1(ruleDos[i].getName_dep_random_rule());
				errorDto.setError2(Integer.toString(entDoArr.length));
				errorDto.setError3(Integer.toString(ruleDos[i].getCount_random_rule()));
				errorDto.setError4(Integer.toString(entDoArr.length));
				errorList.add(errorDto);
				if (entDoArr.length>0) {
					recordDo.setName_random_record("门诊部-"+new FDate()+"-抽查-"+ruleDos[i].getName_dep_random_rule()+"-"+entDoArr.length+"份");
					recordDo.setTimes_random_record(entDoArr.length);
				}else{
					recordDo=null;
				}
			}
	        List<CiMrQcRandomRecordItmDO> itmDolist =new ArrayList<CiMrQcRandomRecordItmDO>();
	        for (int k = 0; k < entDoArr.length; k++) {
	            CiMrQcRandomRecordItmDO itmDo = new CiMrQcRandomRecordItmDO();
	            itmDo.setId_grp(id_grp);
	            itmDo.setId_org(id_org);
	            itmDo.setId_ent(entDoArr[k].getId_ent());
	            itmDo.setId_pat(entDoArr[k].getId_pat());
	            itmDo.setId_check_status(ICiMrDictCodeConst.ID_MR_RANDOMQCCHECK_HASCHECK);
	            itmDo.setSd_check_status(ICiMrDictCodeConst.SD_MR_RANDOMQCCHECK_HASCHECK);
	            itmDo.setId_emp_check(id_emp);
	            itmDo.setFg_check(FBoolean.TRUE);
	            itmDo.setDt_check(new FDateTime());
	            itmDo.setStatus(DOStatus.NEW);
	            itmDolist.add(itmDo);
			}
	        aggDo.setCiMrQcRandomRecordItmDO( itmDolist.toArray(new CiMrQcRandomRecordItmDO[0]));
	        if (recordDo!=null) {
		       aggDo.setParentDO(recordDo);
		       aggDolist.add(aggDo);
			}
		}
		aggService.insert( aggDolist.toArray(new MrqcrandomcheckAggDO[aggDolist.size()]));
		//排序
		Collections.sort(errorList, new Comparator<MrQcErrorDTO>() {
			@Override
			public int compare(MrQcErrorDTO error1, MrQcErrorDTO error2) {
				return error2.getError4().compareTo(error1.getError4());
			}
		});
		return errorList.toArray(new MrQcErrorDTO[0]);
	}
	/**
	 * 批量修改门诊部抽查规则
	 * @param ruleDos
	 * @return
	 * @throws BizException
	 */
	public FBoolean MultiChangeRule(CiMrQcRandomRuleDO[] ruleDos, CiMrQcRandomRuleDO changeDo)
			throws BizException {
		ICimrqcrandomruleCudService service=ServiceFinder.find(ICimrqcrandomruleCudService.class);
		for (int i = 0; i < ruleDos.length; i++) {
			if (changeDo.getCount_random_rule()!=null) {
				ruleDos[i].setCount_random_rule(changeDo.getCount_random_rule());
			}
			if (changeDo.getDt_random_rule()!=null) {
				ruleDos[i].setDt_random_rule(changeDo.getDt_random_rule());
			}
			if (changeDo.getDt_begin_random()!=null) {
				ruleDos[i].setDt_begin_random(changeDo.getDt_begin_random());
			}
			if (changeDo.getDt_end_random()!=null) {
				ruleDos[i].setDt_end_random(changeDo.getDt_end_random());
			}
			ruleDos[i].setStatus(DOStatus.UPDATED);
		}
		service.save(ruleDos);
		return FBoolean.TRUE;
	}
	/**
	 * 门诊科室质控完成质控操作
	 * @param score
	 * @param patDto
	 * @return
	 * @throws BizException
	 */
	public FBoolean CompleteDepOutQc(String score, MrQcRandomItmDTO patDto)
			throws BizException {
		ICiamrRService amrService=ServiceFinder.find(ICiamrRService.class);
		ICiamrCudService saveService=ServiceFinder.find(ICiamrCudService.class);
		ICiMrQcRandomRecordItmDORService itmService=ServiceFinder.find(ICiMrQcRandomRecordItmDORService.class);
		ICiMrQcRandomRecordItmDOCudService itmSaveService=ServiceFinder.find(ICiMrQcRandomRecordItmDOCudService.class);
		FDouble dscore=new FDouble(score);
		AMrDO amrDo=amrService.findById(patDto.getId_amr());
		if (amrDo==null) {
			return FBoolean.FALSE;
		} else {
			amrDo.setFg_dept_qa(FBoolean.TRUE);
			amrDo.setScore_dept_qa(dscore);
			amrDo.setStatus(DOStatus.UPDATED);
			saveService.save(new AMrDO[]{amrDo});
			
			CiMrQcRandomRecordItmDO itmDo=itmService.findById(patDto.getId_random_itm());
			if (itmDo==null) {
				return FBoolean.FALSE;
			} else {
				itmDo.setId_check_status(ICiMrDictCodeConst.ID_MR_RANDOMQCCHECK_HASQC);
				itmDo.setSd_check_status(ICiMrDictCodeConst.SD_MR_RANDOMQCCHECK_HASQC);
				itmDo.setFg_qc(FBoolean.TRUE);
				itmDo.setStatus(DOStatus.UPDATED);
				itmSaveService.save(new CiMrQcRandomRecordItmDO[]{itmDo});
				return FBoolean.TRUE;
			}
		}
	}
	/**
	 * 门诊部质控完成质控操作
	 * @param score
	 * @param patDto
	 * @return
	 * @throws BizException
	 */
	public FBoolean CompleteOpdOutQc(String score, MrQcRandomItmDTO patDto)
			throws BizException {
		ICiamrRService amrService=ServiceFinder.find(ICiamrRService.class);
		ICiamrCudService saveService=ServiceFinder.find(ICiamrCudService.class);
		ICiMrQcRandomRecordItmDORService itmService=ServiceFinder.find(ICiMrQcRandomRecordItmDORService.class);
		ICiMrQcRandomRecordItmDOCudService itmSaveService=ServiceFinder.find(ICiMrQcRandomRecordItmDOCudService.class);
		FDouble dscore=new FDouble(score);
		AMrDO amrDo=amrService.findById(patDto.getId_amr());
		if (amrDo==null) {
			return FBoolean.FALSE;
		} else {
			amrDo.setFg_terminal_qa(FBoolean.TRUE);
			amrDo.setScore_terminal_qa(dscore);
			amrDo.setStatus(DOStatus.UPDATED);
			saveService.save(new AMrDO[]{amrDo});
			CiMrQcRandomRecordItmDO itmDo=itmService.findById(patDto.getId_random_itm());
			if (itmDo==null) {
				return FBoolean.FALSE;
			} else {
				itmDo.setId_check_status(ICiMrDictCodeConst.ID_MR_RANDOMQCCHECK_HASQC);
				itmDo.setSd_check_status(ICiMrDictCodeConst.SD_MR_RANDOMQCCHECK_HASQC);
				itmDo.setFg_qc(FBoolean.TRUE);
				itmDo.setStatus(DOStatus.UPDATED);
				itmSaveService.save(new CiMrQcRandomRecordItmDO[]{itmDo});
				return FBoolean.TRUE;
			}
		}
	}
	/**
	 * 获取随机数据
	 * @param id_dep_phy
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws DAException 
	 */
	private PatiVisitDO[] getPatiRandom(String id_dep_phy,FDateTime beginTime,FDateTime endTime,Integer count,String id_doc) throws DAException{
		DAFacade daf = new DAFacade();
    	StringBuilder sql = new StringBuilder();
    	sql.append(" select *  from ");
    	sql.append(" (select distinct *  from ");
    	sql.append(" (SELECT * from en_ent en");
    	sql.append("  WHERE en.id_dep_phy='"+id_dep_phy+"' and en.code_entp='00' ");
    	if(!StringUtils.isEmptyWithTrim(id_doc)){
    		sql.append(" and en.id_emp_phy='"+id_doc+"' ");
    	}
    	sql.append(" AND (EN.DT_ACPT >= '"+beginTime+"' and  EN.DT_ACPT <= '"+endTime+"'))");
    	sql.append(" order by dbms_random.value())");
    	sql.append("  where rownum <= "+count);
    	String sqlStr=sql.toString();
	    @SuppressWarnings("unchecked")
		List<PatiVisitDO> listMr = (List<PatiVisitDO>) daf.execQuery(sqlStr, new BeanListHandler(PatiVisitDO.class));		      
	    return (PatiVisitDO[]) listMr.toArray(new PatiVisitDO[0]);
	}
}
