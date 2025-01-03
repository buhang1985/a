package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.s.bp.GetTransBB;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 入科确认列表 获取申请转科转入的患者列表
 * @author renying
 *
 */
public class GetTransInDepBP {

	/**
	 * 入科确认列表 获取申请转科转入的患者列表
	 * 
	 * @param nurId  病区id
	 * @return
	 * @throws DAException
	 */
	public TransDepPatDTO[] exec(String nurId) throws BizException {
		TransDepPatDTO[] transDepPatDTOs = this.getTransDepDTO(nurId);
		if (EnValidator.isEmpty(transDepPatDTOs))
			return null;
		//设置年龄
		EnAgeCalcUtil.setDoAges(transDepPatDTOs, "Id_ent", "Age");
		HashSet<String> idHashSet = this.getDeptSet(transDepPatDTOs);
		DeptDO[] deptdos = this.getDeptInfo(idHashSet);
		HashMap<String, String> deptHashTable = this.getHashMap(deptdos);
		HashMap<String,String> sdHashTable = this.getHashMapSd(deptdos);
		this.setDeptName4DTO(deptHashTable, transDepPatDTOs);
	    this.setDeptSd4DTO(sdHashTable, transDepPatDTOs);
	    
		return transDepPatDTOs;
	}

	/**
	 * 获取DTO数组
	 * @param nurId
	 * @return
	 * @throws DAException
	 */
	private TransDepPatDTO[] getTransDepDTO(String nurId) throws DAException {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select ent.name_pat,");
		sqlStr.append(" ent.dt_birth_pat,");
		sqlStr.append(" ent.id_ent,");
		sqlStr.append(" ent.id_pat,");
		sqlStr.append(" ent.dt_acpt,");
		sqlStr.append(" ent.dt_entry,");
		sqlStr.append(" ent.id_sex_pat as id_sex,");
		sqlStr.append(" ent.sd_sex_pat ,");
		sqlStr.append(" ent.code           ent_code,");
		sqlStr.append(" udidoc.name as gender_pat,");
		sqlStr.append(" trans.dt_apply  dt_entry,");
		sqlStr.append("	ip.name_bed        ,");
		sqlStr.append("	ip.id_bed        ,");
		sqlStr.append("	ip.code_amr_ip        ,");
		sqlStr.append("	ip.fg_ippre        ,");
		sqlStr.append("	trans.id_dep_to       id_dep_phy,");
		sqlStr.append("	trans.id_dep_nur_to   id_dep_nur,");
		sqlStr.append(" trans.id_dep_from     old_dep_phy,");
		sqlStr.append(" trans.id_dep_nur_from  old_dep_nur,");
		sqlStr.append(" trans.id_or,");
		sqlStr.append(" trans.id_dep_trans,");
		sqlStr.append(" ci.content_or     name_or,");
		sqlStr.append(" ci.id_emp_sign,  ");
		sqlStr.append(" ci.code_or as ci_code,  ");
		sqlStr.append(" empdoc.name as name_emp_sign,");
		sqlStr.append(" bed.sd_bedsexlimit as sd_bedsex");
		sqlStr.append("	from   en_dep_trans  trans");
		sqlStr.append("	inner join en_ent ent");
		sqlStr.append(" on trans.id_ent = ent.id_ent");
		sqlStr.append(" inner join en_ent_ip ip");
		sqlStr.append("	on ent.id_ent = ip.id_ent");
		sqlStr.append(" left join ci_order ci on ci.id_or = trans.id_or");
		sqlStr.append(" left join bd_psndoc empdoc");
		sqlStr.append(" on ci.id_emp_sign = empdoc.id_psndoc");
		sqlStr.append(" left join bd_udidoc udidoc");
		sqlStr.append(" on ent.id_sex_pat = udidoc.id_udidoc");
		sqlStr.append(" left join bd_bed bed");
		sqlStr.append(" on bed.id_bed = ip.id_bed");
		sqlStr.append("	where trans.id_dep_nur_to = ?");
		sqlStr.append("	and ent.fg_ip = 'Y'");
		sqlStr.append("	and  trans.eu_trans =?");
		sqlStr.append(" order by ent.dt_entry desc");
		//sqlStr.append("	order by trans.dt_apply,ip.name_bed  ");

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(nurId);
		sqlParam.addParam(EnEuTrans.APPLY);	
		@SuppressWarnings("unchecked")
		List<TransDepPatDTO> result = (List<TransDepPatDTO>) new DAFacade().execQuery(sqlStr.toString(), sqlParam, new BeanListHandler(TransDepPatDTO.class));

		if (EnValidator.isEmpty(result))
			return null;
		GetTransBB  getTransBB = new GetTransBB();
		getTransBB.exec(result);
		return (TransDepPatDTO[]) result.toArray(new TransDepPatDTO[result.size()]);
	}

	
	
	/**
	 * 所有id_dep放到一个set集合中
	 * 
	 * @param transDept
	 * @return
	 */
	private HashSet<String> getDeptSet(TransDepPatDTO[] transDept) {
		HashSet<String> depSet = new HashSet<String>();
		for (TransDepPatDTO transDepPatDTO : transDept) {
			if (!depSet.contains(transDepPatDTO.getId_dep_nur())) {
				depSet.add(transDepPatDTO.getId_dep_nur());
			}
			if (!depSet.contains(transDepPatDTO.getId_dep_phy())) {
				depSet.add(transDepPatDTO.getId_dep_phy());
			}
			if (!depSet.contains(transDepPatDTO.getOld_dep_nur())) {
				depSet.add(transDepPatDTO.getOld_dep_nur());
			}
			if (!depSet.contains(transDepPatDTO.getOld_dep_phy())) {
				depSet.add(transDepPatDTO.getOld_dep_phy());
			}
		}
		return depSet;
	}

	
	/**
	 * 将id和name 拼成hashMap
	 * 
	 * @param deptDOs
	 * @return
	 */
	private HashMap<String, String> getHashMapSd(DeptDO[] deptDOs) {
		HashMap<String, String> deptHashTable = new HashMap<String, String>();
		for (DeptDO deptdo : deptDOs) {
			deptHashTable.put(deptdo.getId_dep(), deptdo.getCode());
		}
		return deptHashTable;
	}


	/**
	 * 查找所有的do
	 * 
	 * @param depSet
	 * @return
	 * @throws BizException
	 */
	private DeptDO[] getDeptInfo(HashSet<String> depSet) throws BizException {
		IDeptRService rService = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptDOs = rService.findByIds(depSet.toArray(new String[] {}), FBoolean.FALSE);
		return deptDOs;
	}

	/**
	 * 将id和name 拼成hashMap
	 * 
	 * @param deptDOs
	 * @return
	 */
	private HashMap<String, String> getHashMap(DeptDO[] deptDOs) {
		HashMap<String, String> deptHashTable = new HashMap<String, String>();
		for (DeptDO deptdo : deptDOs) {
			deptHashTable.put(deptdo.getId_dep(), deptdo.getName());
		}
		return deptHashTable;
	}

	/**
	 * 利用hashMap赋值name
	 * 
	 * @param deptHashTable
	 * @param transDepDTOs
	 */
	private void setDeptName4DTO(HashMap<String, String> deptHashTable, TransDepPatDTO[] transDepDTOs) {
		for (TransDepPatDTO transDepDTO : transDepDTOs) {
			if (!EnValidator.isEmpty(transDepDTO.getId_dep_nur())) {
				transDepDTO.setName_dep_nur(deptHashTable.get(transDepDTO.getId_dep_nur()));				
			}
			if (!EnValidator.isEmpty(transDepDTO.getId_dep_phy())) {
				transDepDTO.setName_dep_phy(deptHashTable.get(transDepDTO.getId_dep_phy()));
			}
			if (!EnValidator.isEmpty(transDepDTO.getOld_dep_nur())) {
				transDepDTO.setOld_dep_nur_name(deptHashTable.get(transDepDTO.getOld_dep_nur()));
			}
			if (!EnValidator.isEmpty(transDepDTO.getOld_dep_phy())) {
				transDepDTO.setOld_dep_phy_name(deptHashTable.get(transDepDTO.getOld_dep_phy()));
			}
		}
	}
	
	/**
	 * 利用hashMap赋值sd
	 * 
	 * @param deptHashTable
	 * @param transDepDTOs
	 */
	private void setDeptSd4DTO(HashMap<String, String> sdHashTable, TransDepPatDTO[] transDepDTOs) {
		for (TransDepPatDTO transDepDTO : transDepDTOs) {
			if (!EnValidator.isEmpty(transDepDTO.getId_dep_nur())) {
				transDepDTO.setSd_dep_nur(sdHashTable.get(transDepDTO.getId_dep_nur()));				
			}
			if (!EnValidator.isEmpty(transDepDTO.getId_dep_phy())) {
				transDepDTO.setSd_dep_phy(sdHashTable.get(transDepDTO.getId_dep_phy()));
			}
			if (!EnValidator.isEmpty(transDepDTO.getOld_dep_nur())) {
				transDepDTO.setOld_sd_dep_nur(sdHashTable.get(transDepDTO.getOld_dep_nur()));
			}
			if (!EnValidator.isEmpty(transDepDTO.getOld_dep_phy())) {
				transDepDTO.setOld_sd_dep_phy(sdHashTable.get(transDepDTO.getOld_dep_phy()));
			}
		}
	}

}
