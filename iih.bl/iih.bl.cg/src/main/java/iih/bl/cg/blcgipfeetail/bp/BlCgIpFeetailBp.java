package iih.bl.cg.blcgipfeetail.bp;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bl.cg.dto.d.EntPatInfoDTO;

/**
 * 一日费用清单
 * @author weijia
 * */
public class BlCgIpFeetailBp {
	
	/**
	 * 查询某科室下的患者就诊信息
	 * @param id_dept 科室标志
	 * @author weijia
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public EntPatInfoDTO[] getEntPatInfoByDept(String id_dept) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select t.id_ent,b.id_bed,b.name_bed,p.id_pat,p.name as name_pat,b.code_amr_ip,t.dt_acpt from en_ent t ")
			.append("left join en_ent_ip b on b.id_ent = t.id_ent ")
			.append("left join pi_pat p on p.id_pat = t.id_pat ")
			.append("where t.code_entp in ('10' , '11')")
			.append("and t.fg_ip = 'Y' ")
			.append("and t.fg_st='N' ")
			.append("and t.id_dep_nur = ? ")
			.append("order by b.name_bed");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_dept);
		List<EntPatInfoDTO> entList = (List<EntPatInfoDTO>)new DAFacade().execQuery(sql.toString(), sqlParam, new BeanListHandler(EntPatInfoDTO.class));
		return entList.toArray(new EntPatInfoDTO[]{});
	}
	
	/**
	 * 查询某科室下的某些患者就诊信息
	 * @param id_dept 科室标志
	 * @param keyCond
	 * @param condition
	 * @author weijia
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public EntPatInfoDTO[] getEntPatInfoByDept(String id_dept, String keyCond, String condition) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select t.id_ent,b.id_bed,b.name_bed,p.id_pat,p.name as name_pat,b.code_amr_ip,t.dt_acpt,"
				+ "dep1.name name_dep_nur,dep1.id_dep id_dep_nur,dep2.id_dep id_dep_phy,dep2.name name_dep_phy from en_ent t ")
			.append("left join en_ent_ip b on b.id_ent = t.id_ent ")
			.append("left join pi_pat p on p.id_pat = t.id_pat ")
			.append(" left join bd_dep dep1 on t.id_dep_nur=dep1.id_dep ")
			.append(" left join bd_dep dep2 on t.id_dep_phy=dep2.id_dep ")
			.append("where t.code_entp in ('10','11') ")
			.append("and t.fg_ip = 'Y' ")
			.append("and t.fg_st='N' ")
			.append("and t.id_dep_nur = ? ");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_dept);
		condition = "%"+condition.toLowerCase()+"%";
		if("0".equals(keyCond)){
			sql.append("and (lower(b.name_bed) like ? ")
			    .append("or lower(p.name) like ? ")
			    .append("or lower(p.pycode) like ?) ");
			sqlParam.addParam(condition);
			sqlParam.addParam(condition);
			sqlParam.addParam(condition);
		}else if("1".equals(keyCond)){
			sql.append(" and lower(b.name_bed) like ? ");
			sqlParam.addParam(condition);
		}else if("2".equals(keyCond)){
			sql.append(" and (lower(p.name) like ? ")
			    .append("or lower(p.pycode) like ?) ");
			sqlParam.addParam(condition);
			sqlParam.addParam(condition);
		}
		sql.append("order by b.name_bed");
		List<EntPatInfoDTO> entList = (List<EntPatInfoDTO>)new DAFacade().execQuery(sql.toString(), sqlParam, new BeanListHandler(EntPatInfoDTO.class));
		return entList.toArray(new EntPatInfoDTO[]{});
	}
}
