package iih.nm.nom.wardprint.qry;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class FindNmBedwardRecordsQry implements ITransQry {

	private List<String> id_dep_mps;
	private String dt_begin;
	private String dt_end;
	private String is_ward;

	public FindNmBedwardRecordsQry(List<String> id_dep_mps, String dt_begin, String dt_end, String is_ward) {
		this.id_dep_mps = id_dep_mps;
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.is_ward = is_ward;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(this.dt_begin);
		param.addParam(this.dt_end);
		if(!StringUtil.isEmptyWithTrim(this.is_ward))    
		 param.addParam(this.is_ward);
		if(CollectionUtils.isNotEmpty(this.id_dep_mps))
		for (String id_dep_mp : id_dep_mps) {
			param.addParam(id_dep_mp);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuilder sql = new StringBuilder();
		sql.append(" select                                                                                                                          ");  
		sql.append(" bedwards.dt_record ,                                                                                                            ");  
		sql.append(" sum((case when wkitm.name='现有患者数' then itm.count  else 0 end )) as current_psn,                                            ");  
		sql.append(" sum((case when wkitm.name='留置导尿管患者数' and itm.data_status='0' then itm.count else 0 end)) as new_indcater_psn,           ");  
		sql.append(" sum((case when wkitm.name='留置导尿管患者数' and itm.data_status='1' then itm.count else 0 end)) as original_indcater_psn,      ");  
		sql.append(" sum((case when wkitm.name='留置胃(肠)管患者数'and itm.data_status='0'then itm.count else 0 end ))as new_indstch_psn,            ");  
		sql.append(" sum((case when wkitm.name='留置胃(肠)管患者数'and itm.data_status='1'then itm.count else 0 end ))as original_indstch_psn,       ");  
		sql.append(" sum((case when wkitm.name='留置中心静脉导管患者' and itm.data_status='0'then itm.count else 0 end)) as new_indcvcater_psn,      ");  
		sql.append(" sum((case when wkitm.name='留置中心静脉导管患者' and itm.data_status='1'then itm.count else 0 end)) as original_indcvcater_psn, ");  
		sql.append(" sum((case when wkitm.name='气管导管患者数' and itm.data_status='0' then itm.count else 0 end)) as new_tracater_psn,             ");  
		sql.append(" sum((case when wkitm.name='气管导管患者数'and itm.data_status='1' then itm.count else 0 end)) as original_tracater_psn,            ");  
		sql.append(" sum((case when wkitm.name='约束人数' and itm.data_status='0'then itm.count else 0 end)) as new_constraint_psn  ,                ");  
		sql.append(" sum((case when wkitm.name='约束人数' and itm.data_status='1'then itm.count else 0 end)) as original_constraint_psn              ");  
		sql.append(" from nm_nom_bedward_record bedwards                                                                                             ");  
		sql.append(" inner join nm_nom_bedward_itm itm on bedwards.id_bedward_record=itm.id_bedward_record                                           ");  
		sql.append(" inner join nm_nom_wkitm wkitm on itm.id_nom_wkitm=wkitm.id_nom_wkitm                                                            ");  
		sql.append(" where 1=1                                                                                                                        "); 
		sql.append(" and bedwards.dt_record>=?                                                                       ");
		sql.append(" and bedwards.dt_record<=?                                                                      ");
		if(!StringUtil.isEmptyWithTrim(this.is_ward))
		sql.append(" and bedwards.fg_comfirm =?                                                                      ");
		if (CollectionUtils.isNotEmpty(this.id_dep_mps)) {
			String sqlAppend="";
			for (String id_dep_mp : id_dep_mps) {
               sqlAppend+=(StringUtils.isBlank(sqlAppend)?"":",")+"?";
			}
			sql.append(" and bedwards.id_dep_nur in("+sqlAppend+")                                                  ");
		}
		sql.append(" group by bedwards.dt_record  order by   bedwards.dt_record                                      ");
		return sql.toString();
	}

}
