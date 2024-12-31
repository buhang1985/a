package iih.en.pv.out.bp.qry;

import iih.bd.res.bed.d.Bdbed;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.out.mr.d.EnTransDeptFlowDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 获取住院就诊转科流程记录
 * 
 * @author liubin
 *
 */
public class GetTransDeptFlowsBP {
	/**
	 * 获取住院就诊转科流程记录
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnTransDeptFlowDTO[] exec(String entId) throws BizException {
		if(EnValidator.isEmpty(entId))
			return null;
		//1.查询转科记录
		EnTransDeptFlowDTO[] enTransDeptFlows = this.getTranDeptFlows(entId);
		//2.提取所有科室，床位，人员用来查询
		Map<String, DeptDO> depMap = new HashMap<String, DeptDO>();
		Map<String, Bdbed> bedMap = new HashMap<String, Bdbed>();
		Map<String, PsnDocDO> psnMap = new HashMap<String, PsnDocDO>();
		this.assemlyMaps(enTransDeptFlows, depMap, bedMap, psnMap);
		//3.查询科室信息
		this.queryDepts(depMap);
		//4.查询床位信息
		this.queryBeds(bedMap);
		//5.查询接收人员信息
		this.queryPsns(psnMap);
		//6.组装转科详细信息
		this.assemlyTransInfo(enTransDeptFlows, depMap, bedMap, psnMap);
		return enTransDeptFlows;
	}

	/**
	 * 获取患者转科记录
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private EnTransDeptFlowDTO[] getTranDeptFlows(String entId)
			throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append(" SELECT TRANS.ID_ENT AS ID_ENT, ");
		sqlBuilder.append(" TRANS.ID_DEP_FROM AS ID_DEP_FROM, ");
		sqlBuilder.append(" TRANS.ID_DEP_NUR_FROM AS ID_DEP_NUR_FROM, ");
		sqlBuilder.append(" TRANS.ID_BED_FROM AS ID_BED_FROM, ");
		sqlBuilder.append(" TRANS.ID_DEP_TO AS ID_DEP_TO, ");
		sqlBuilder.append(" TRANS.ID_DEP_NUR_TO AS ID_DEP_NUR_TO, ");
		sqlBuilder.append(" TRANS.ID_BED_TO AS ID_BED_TO, ");
		sqlBuilder.append(" TRANS.DT_ACPT AS DT_TRANS, ");
		sqlBuilder.append(" TRANS.ID_EMP_ACPT AS ID_EMP_ACPT ");
		sqlBuilder.append(" FROM EN_DEP_TRANS TRANS ");
		sqlBuilder.append(" WHERE TRANS.EU_TRANS = ? ");
		sqlBuilder.append(" AND TRANS.ID_ENT = ? ");
		sqlBuilder.append(" ORDER BY TRANS.DT_ACPT ");
		param.addParam(EnEuTrans.ACPT);
		param.addParam(entId);
		List<EnTransDeptFlowDTO> list = (List<EnTransDeptFlowDTO>) new DAFacade()
				.execQuery(sqlBuilder.toString(), param, new BeanListHandler(
						EnTransDeptFlowDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new EnTransDeptFlowDTO[0]);
	}
	/**
	 * 提取所有科室，床位，人员用来查询
	 * 
	 * @param enTransDeptFlows
	 * @param depMap
	 * @param bedMap
	 * @param psnMap
	 */
	private void assemlyMaps(EnTransDeptFlowDTO[] enTransDeptFlows, Map<String, DeptDO> depMap,
			Map<String, Bdbed> bedMap, Map<String, PsnDocDO> psnMap){
		if(EnValidator.isEmpty(enTransDeptFlows))
			return;
		for (EnTransDeptFlowDTO enTransDeptFlow : enTransDeptFlows) {
			if (!EnValidator.isEmpty(enTransDeptFlow.getId_dep_from()))
				depMap.put(enTransDeptFlow.getId_dep_from(), null);
			if (!EnValidator.isEmpty(enTransDeptFlow.getId_dep_nur_from()))
				depMap.put(enTransDeptFlow.getId_dep_nur_from(), null);
			if (!EnValidator.isEmpty(enTransDeptFlow.getId_dep_to()))
				depMap.put(enTransDeptFlow.getId_dep_to(), null);
			if (!EnValidator.isEmpty(enTransDeptFlow.getId_dep_nur_to()))
				depMap.put(enTransDeptFlow.getId_dep_nur_to(), null);
			if (!EnValidator.isEmpty(enTransDeptFlow.getId_bed_from()))
				bedMap.put(enTransDeptFlow.getId_bed_from(), null);
			if (!EnValidator.isEmpty(enTransDeptFlow.getId_bed_to()))
				bedMap.put(enTransDeptFlow.getId_bed_to(), null);
			if (!EnValidator.isEmpty(enTransDeptFlow.getId_emp_acpt()))
				psnMap.put(enTransDeptFlow.getId_emp_acpt(), null);
		}
	}
	/**
	 * 查询科室信息
	 * 
	 * @param depMap
	 * @throws BizException
	 */
	private void queryDepts(Map<String, DeptDO> depMap) throws BizException{
		if(depMap.isEmpty())
			return;
		List<DeptDO> list = (List<DeptDO>) new DAFacade().findByPKs(DeptDO.class, depMap.keySet().toArray(new String[0]), 
				new String[] {DeptDO.ID_DEP, DeptDO.CODE, DeptDO.NAME});
		if(EnValidator.isEmpty(list))
			return;
		depMap.clear();
		for(DeptDO dep : list)
			depMap.put(dep.getId_dep(), dep);
	}
	/**
	 * 查询床位信息
	 * 
	 * @param depMap
	 * @throws BizException
	 */
	private void queryBeds(Map<String, Bdbed> bedMap) throws BizException{
		if(bedMap.isEmpty())
			return;
		List<Bdbed> list = (List<Bdbed>) new DAFacade().findByPKs(Bdbed.class, bedMap.keySet().toArray(new String[0]), 
				new String[] {Bdbed.ID_BED, Bdbed.CODE, Bdbed.NAME});
		if(EnValidator.isEmpty(list))
			return;
		bedMap.clear();
		for(Bdbed bed : list)
			bedMap.put(bed.getId_bed(), bed);
	}
	/**
	 * 查询接收人员信息
	 * 
	 * @param depMap
	 * @throws BizException
	 */
	private void queryPsns(Map<String, PsnDocDO> psnMap) throws BizException{
		if(psnMap.isEmpty())
			return;
		List<PsnDocDO> list = (List<PsnDocDO>) new DAFacade().findByPKs(PsnDocDO.class, psnMap.keySet().toArray(new String[0]), 
				new String[] {PsnDocDO.ID_PSNDOC, PsnDocDO.CODE, PsnDocDO.NAME});
		if(EnValidator.isEmpty(list))
			return;
		psnMap.clear();
		for(PsnDocDO psn : list)
			psnMap.put(psn.getId_psndoc(), psn);
	}
	/**
	 * 组装转科详细信息
	 * 
	 * @param enTransDeptFlows
	 * @param depMap
	 * @param bedMap
	 * @param psnMap
	 */
	private void assemlyTransInfo(EnTransDeptFlowDTO[] enTransDeptFlows, Map<String, DeptDO> depMap,
			Map<String, Bdbed> bedMap, Map<String, PsnDocDO> psnMap){
		if(EnValidator.isEmpty(enTransDeptFlows))
			return;
		for (EnTransDeptFlowDTO enTransDeptFlow : enTransDeptFlows) {
			if (depMap.containsKey(enTransDeptFlow.getId_dep_from())){
				DeptDO dept = depMap.get(enTransDeptFlow.getId_dep_from());
				if(dept != null){
					enTransDeptFlow.setCode_dep_from(dept.getCode());
					enTransDeptFlow.setName_dep_from(dept.getName());
				}
			}
			if (depMap.containsKey(enTransDeptFlow.getId_dep_nur_from())){
				DeptDO dept = depMap.get(enTransDeptFlow.getId_dep_nur_from());
				if(dept != null){
					enTransDeptFlow.setCode_dep_nur_from(dept.getCode());
					enTransDeptFlow.setName_dep_nur_from(dept.getName());
				}
			}
			if (depMap.containsKey(enTransDeptFlow.getId_dep_to())){
				DeptDO dept = depMap.get(enTransDeptFlow.getId_dep_to());
				if(dept != null){
					enTransDeptFlow.setCode_dep_to(dept.getCode());
					enTransDeptFlow.setName_dep_to(dept.getName());
				}
			}
			if (depMap.containsKey(enTransDeptFlow.getId_dep_nur_to())){
				DeptDO dept = depMap.get(enTransDeptFlow.getId_dep_nur_to());
				if(dept != null){
					enTransDeptFlow.setCode_dep_nur_to(dept.getCode());
					enTransDeptFlow.setName_dep_nur_to(dept.getName());
				}
			}
			if (bedMap.containsKey(enTransDeptFlow.getId_bed_from())){
				Bdbed bed = bedMap.get(enTransDeptFlow.getId_bed_from());
				if(bed != null){
					enTransDeptFlow.setCode_bed_from(bed.getCode());
					enTransDeptFlow.setName_bed_from(bed.getName());
				}
			}
			if (bedMap.containsKey(enTransDeptFlow.getId_bed_to())){
				Bdbed bed = bedMap.get(enTransDeptFlow.getId_bed_to());
				if(bed != null){
					enTransDeptFlow.setCode_bed_to(bed.getCode());
					enTransDeptFlow.setName_bed_to(bed.getName());
				}
			}
			if (psnMap.containsKey(enTransDeptFlow.getId_emp_acpt())){
				PsnDocDO psn = psnMap.get(enTransDeptFlow.getId_emp_acpt());
				if(psn != null){
					enTransDeptFlow.setCode_emp_acpt(psn.getCode());
					enTransDeptFlow.setName_emp_acpt(psn.getName());
				}
			}
		}
	}
}
