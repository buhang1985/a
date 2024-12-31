package iih.bl.st.s.bp;

import java.util.List;

import iih.bl.st.dto.d.BlUrgeStPatEntDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetUrgeStPatisBP {

	@SuppressWarnings("unchecked")
	public BlUrgeStPatEntDTO[] exec (QryRootNodeDTO qryNode) throws BizException{
		
		//获得查询方案的String查询条件
	    IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
	    String whereStr = qrySQLGeneratorService.getQueryStringWithoutDesc(qryNode);
	    StringBuilder sqlSb = new StringBuilder();
	    
	    sqlSb.append("select ent.id_ent, ");
	    sqlSb.append("       ent.code as code_ent, ");
	    sqlSb.append("       ent.name_pat, ");
	    sqlSb.append("       pat.code as code_pat, ");
	    sqlSb.append("       ent.id_dep_nur, ");
	    sqlSb.append("       dep1.code as code_dep_nur, ");
	    sqlSb.append("       dep1.name as name_dep_nur, ");
	    sqlSb.append("       ent.id_dep_phy, ");
	    sqlSb.append("       dep2.code as code_dep_phy, ");
	    sqlSb.append("       dep2.name as name_dep_phy, ");
	    sqlSb.append("       ent.id_patca, ");
	    sqlSb.append("       patca.code as code_patca, ");
	    sqlSb.append("       patca.name as name_patca, ");
	    sqlSb.append("       ent.dt_entry, ");
	    sqlSb.append("       ent.dt_acpt, ");
	    sqlSb.append("       ent.dt_end, ");
	    sqlSb.append("       entip.code_amr_ip, ");
	    sqlSb.append("       entip.name_bed as bed_no, ");
	    sqlSb.append("       ent.fg_st, ");
	    sqlSb.append("       ent.fg_ip, ");
	    sqlSb.append("       nvl(acc.amt_prepay, 0) as amt_pay, ");
	    sqlSb.append("       nvl(acc.amt_uncg, 0) as amt_uncg, ");
	    sqlSb.append("       (nvl(acc.amt_prepay, 0) - nvl(acc.amt_uncg, 0)) as amt_balance ");
	    sqlSb.append("  from en_ent ent ");
	    sqlSb.append(" inner join pi_pat pat ");
	    sqlSb.append("    on pat.id_pat = ent.id_pat ");
	    sqlSb.append(" inner join en_ent_acc acc ");
	    sqlSb.append("    on acc.id_ent = ent.id_ent ");
	    sqlSb.append("  left join bd_dep dep1 ");
	    sqlSb.append("    on dep1.id_dep = ent.id_dep_nur ");
	    sqlSb.append("  left join bd_dep dep2 ");
	    sqlSb.append("    on dep2.id_dep = ent.id_dep_phy ");
	    sqlSb.append("  left join pi_pat_ca patca ");
	    sqlSb.append("    on patca.id_patca = ent.id_patca ");
	    sqlSb.append("  left join en_ent_ip entip ");
	    sqlSb.append("    on entip.id_ent = ent.id_ent");
	    sqlSb.append(" where 1=1 ");
	    sqlSb.append(" and ent.fg_st='N' ");
	    sqlSb.append(" and ent.fg_ip='N' ");
	    if(!StringUtil.isEmpty(whereStr)){
	    	sqlSb.append("and").append(whereStr);
	    }
	    sqlSb.append(" order by ent.dt_end  ");

		List<BlUrgeStPatEntDTO> list = (List<BlUrgeStPatEntDTO>) new DAFacade().execQuery(sqlSb.toString(), 
				new BeanListHandler(BlUrgeStPatEntDTO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.toArray(new BlUrgeStPatEntDTO []{});
	}
}
