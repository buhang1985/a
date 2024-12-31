package iih.bl.cg.s.bp.et;

import java.util.List;

import iih.bl.cg.dto.d.BlIpPatDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
* @ClassName: GetEtPatListInHosBP  
* @Description: 获取急诊留观患者信息
* @author xy.zhou
* @date 2019年3月14日
 */ 
public class GetEtPatListInHosBP {
	
	@SuppressWarnings("unchecked")
	public BlIpPatDTO[] exec(String code_entp,String depId, FBoolean fg_ip,FBoolean fg_st,String fuzzyCond) throws BizException {

		StringBuffer sql = new StringBuffer();
		sql.append("select t.id_ent,t.code as code_ent,t.id_pat,b.id_bed,b.name_bed,"
				+ "t.name_pat,p.id_pat,p.name as name_pat,p.code as code_pat,"
				+ "b.code_amr_ip,t.dt_entry,t.dt_end,b.times_ip,"
				+ "t.fg_ip,dep1.name name_dep_nur,dep1.id_dep id_dep_nur,"
				+ "dep2.id_dep id_dep_phy,dep2.name name_dep_phy from en_ent t ")
			.append("left join en_ent_ip b on b.id_ent = t.id_ent ")
			.append("left join pi_pat p on p.id_pat = t.id_pat ")
			.append(" left join bd_dep dep1 on t.id_dep_nur=dep1.id_dep ")
			.append(" left join bd_dep dep2 on t.id_dep_phy=dep2.id_dep ")
			.append(" where 1=1 ");
		
		SqlParam sqlParam = new SqlParam();
		if(!StringUtil.isEmpty(code_entp)){
			sql.append("and t.code_entp = ?");
			sqlParam.addParam(code_entp);
		}
		if(!StringUtil.isEmpty(depId)){
			sql.append(" and t.id_dep_nur = ? ");
			sqlParam.addParam(depId);
		}
		if(fg_ip!=null){
			sql.append(" and t.fg_ip=? ");
			sqlParam.addParam(fg_ip);
		}
		if(fg_st!=null){
			sql.append(" and t.fg_st=?");
			sqlParam.addParam(fg_st);
		}
		if(!StringUtil.isEmpty(fuzzyCond)){
			fuzzyCond = "%"+fuzzyCond.toLowerCase()+"%";
			sql.append("and (lower(b.name_bed) like ? ")
			    .append("or lower(p.name) like ? ")
			    .append("or lower(p.pycode) like ?")
				.append("or lower(b.code_amr_ip) like ?) ");
			sqlParam.addParam(fuzzyCond);
			sqlParam.addParam(fuzzyCond);
			sqlParam.addParam(fuzzyCond);
			sqlParam.addParam(fuzzyCond);
		}
		
		sql.append("order by b.name_bed");
		List<BlIpPatDTO> entList = (List<BlIpPatDTO>)new DAFacade().execQuery
				(sql.toString(), sqlParam, new BeanListHandler(BlIpPatDTO.class));
		return entList.toArray(new BlIpPatDTO[]{});
		}
}
