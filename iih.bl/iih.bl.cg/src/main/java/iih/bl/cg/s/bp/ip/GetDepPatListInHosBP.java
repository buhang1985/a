package iih.bl.cg.s.bp.ip;

import java.util.List;

import iih.bl.cg.dto.d.BlIpPatDTO;
import iih.bl.cg.dto.d.EntPatInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询当前科室在院人员列表
 * 
 * @author wq.li
 *
 */
public class GetDepPatListInHosBP {

	/**
	 * 查询当前科室在院人员列表
	 * 
	 * @param fuzzyCond
	 * @return
	 * @throws BizException
	 */
	public BlIpPatDTO[] exec(String fuzzyCond) throws BizException {

		StringBuffer sql = new StringBuffer();
		sql.append("select t.id_ent,b.id_bed,b.name_bed,p.id_pat,p.name as name_pat,b.code_amr_ip,t.dt_acpt,"
				+ "dep1.name name_dep_nur,dep1.id_dep id_dep_nur,dep2.id_dep id_dep_phy,dep2.name name_dep_phy from en_ent t ")
				.append("left join en_ent_ip b on b.id_ent = t.id_ent ")
				.append("left join pi_pat p on p.id_pat = t.id_pat ")
				.append(" left join bd_dep dep1 on t.id_dep_nur=dep1.id_dep ")
				.append(" left join bd_dep dep2 on t.id_dep_phy=dep2.id_dep ").append("where t.code_entp = '10' ")
				.append("and t.fg_ip = 'Y' ").append("and t.fg_st='N' ").append("and t.id_dep_phy = ? ");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addClobParam(Context.get().getDeptId());
		String condition = new String();
		condition = "%" + fuzzyCond.toLowerCase() + "%";
		sql.append("and (lower(b.name_bed) like ? ").append("or lower(p.name) like ? ")
				.append("or lower(p.pycode) like ?) ");
		sqlParam.addParam(condition);
		sqlParam.addParam(condition);
		sqlParam.addParam(condition);

		sql.append("order by b.name_bed");
		List<BlIpPatDTO> entList = (List<BlIpPatDTO>) new DAFacade().execQuery(sql.toString(), sqlParam,
				new BeanListHandler(BlIpPatDTO.class));
		return entList.toArray(new BlIpPatDTO[] {});

	}
}
