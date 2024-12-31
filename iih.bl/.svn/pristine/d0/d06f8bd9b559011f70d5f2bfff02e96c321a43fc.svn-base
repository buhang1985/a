package iih.bl.cg.s.bp.ip;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bl.cg.dto.d.BlIpPatDTO;
import iih.en.pv.i.IEnIpQryService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 查询当前病区的会诊患者
 * 
 * @author liwenqiang 2018.11.01
 *
 */
public class GetNurConPatListInHosBP {

	/**
	 * 查询当前病区的会诊患者
	 * 
	 * @param fuzzyCond
	 * @return
	 * @throws BizException
	 */
	public BlIpPatDTO[] exec(String fuzzyCond) throws BizException {

		// 1.根据业务线，查询病区的科室集合
		IEnIpQryService enIpService = ServiceFinder.find(IEnIpQryService.class);
		DeptDO[] deptArr = enIpService.getDepListByDepl(Context.get()
				.getDeptId(), IBdResDictCodeConst.SD_DEPROlE_NUR);
		if (ArrayUtil.isEmpty(deptArr)) {
			return null;
		}
		
		List<String> depIdList=new ArrayList<String>();
		
		for (DeptDO depDo : deptArr) {
			depIdList.add(depDo.getId_dep());
		}
		

		// 2.查询科室对应的会诊患者列表
		StringBuilder sql = new StringBuilder();
		
		sql.append("	select t.id_ent,                       ");
		sql.append("       b.id_bed,                           ");
		sql.append("       b.name_bed,                         ");
		sql.append("       p.id_pat,                           ");
		sql.append("       p.name        as name_pat,          ");
		sql.append("       b.code_amr_ip,                      ");
		sql.append("       t.dt_acpt,                          ");
		sql.append("       dep1.name     name_dep_nur,         ");
		sql.append("       dep1.id_dep   id_dep_nur,           ");
		sql.append("       dep2.id_dep   id_dep_phy,           ");
		sql.append("       dep2.name     name_dep_phy,          ");
		sql.append(" 'Y' Fg_cons ");
		sql.append("  from en_ent t                            ");
		sql.append("  left join en_ent_ip b                    ");
		sql.append("    on b.id_ent = t.id_ent                 ");
		sql.append("  left join pi_pat p                       ");
		sql.append("    on p.id_pat = t.id_pat                 ");
		sql.append("  left join bd_dep dep1                    ");
		sql.append("    on t.id_dep_nur = dep1.id_dep          ");
		sql.append("  left join bd_dep dep2                    ");
		sql.append("    on t.id_dep_phy = dep2.id_dep          ");
		sql.append(" where t.code_entp = '10'                  ");
		sql.append("   and t.fg_ip = 'Y'                       ");
		sql.append("   and t.fg_st = 'N'                       ");
		sql.append("   and t.id_ent in (                       ");
		sql.append("   select distinct ci.id_en                ");
		sql.append("      from ci_order ci                     ");
		sql.append("     inner join ci_ap_cons ap              ");
		sql.append("        on ci.id_or = ap.id_or             ");
		sql.append("     inner join ci_invite_cons invite      ");
		sql.append("        on ap.id_apcons = invite.id_apcons ");
		sql.append("     where ci.sd_srvtp = '0902'            ");
		sql.append("       and ci.fg_sign = 'Y'                ");
		sql.append("       and ci.fg_canc = 'N'                ");
		sql.append("       and invite.fg_response = 'Y'        ");
		String str = SqlUtils.arrayToStr(depIdList.toArray(new String[0]));
		sql.append("       and invite.id_dep in ("+str+")           ");
		sql.append("       )                                   ");
		String condition = new String();
		condition = "%" + fuzzyCond.toLowerCase() + "%";
		sql.append("and (lower(b.name_bed) like ? ").append("or lower(p.name) like ? ")
				.append("or lower(p.pycode) like ?) ");
		SqlParam sqlParam=new SqlParam();
		sqlParam.addParam(condition);
		sqlParam.addParam(condition);
		sqlParam.addParam(condition);
		sql.append("order by b.name_bed");
		List<BlIpPatDTO> entList = (List<BlIpPatDTO>) new DAFacade().execQuery(sql.toString(), sqlParam,
				new BeanListHandler(BlIpPatDTO.class));
		return entList.toArray(new BlIpPatDTO[] {});
	}
}
