package iih.bl.hp.s.bp;

import iih.bl.hp.dto.d.HpFeeSumDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊医疗费用汇总对账
 * 
 * @param id_emp
 * @return
 * @throws BizException
 * @author liwq
 * @since 2017-7-14 14:32:47
 */
public class GetOepFeeSummaryBP {

	public HpFeeSumDTO[] exec(String id_emp) throws BizException {
	
		//1、先查询当前操作员的业务周期号
		GetHpBizCodeBP qryBusinessCode =  new GetHpBizCodeBP();
		String businessCode = qryBusinessCode.exec(id_emp);
		if(StringUtil.isEmptyWithTrim(businessCode)) {
			throw new BizException("未查询到当前操作员对应的有效业务周期号,请先签到！");
		}
		//2、查询医疗费用汇总信息
		StringBuilder sql = new StringBuilder();
		sql.append(" Select t.code_business,                 "); 
		sql.append("        Sum(t.amt_all) amt_all,                  "); 
		sql.append("        Sum(t.amt_hp) amt_hp,                   "); 
		sql.append("        Sum(t.amt_psnacc) amt_psnacc,               "); 
		sql.append("        Sum(t.amt_cash) amt_cash,                 "); 
		sql.append("        Sum(t.amt_salvage) amt_salvage,              "); 
		sql.append("        Sum(t.amt_civilservice) amt_civilservice,         "); 
		sql.append("        Sum(t.amt_enterprisesupp) amt_enterprisesupp,       "); 
		sql.append("        Sum(t.amt_other)   amt_other              "); 
		sql.append(" From                                    "); 
		sql.append(" (                                       "); 
		sql.append(" select a.code_business,                 "); 
		sql.append("        a.amt_all*a.eu_direct amt_all,                       "); 
		sql.append("        a.amt_hp*a.eu_direct amt_hp,                        "); 
		sql.append("        a.amt_psnacc*a.eu_direct amt_psnacc,                    "); 
		sql.append("        a.amt_cash*a.eu_direct amt_cash,                      "); 
		sql.append("        b.amt_salvage*a.eu_direct amt_salvage,                   "); 
		sql.append("        b.amt_civilservice*a.eu_direct amt_civilservice,              "); 
		sql.append("        b.amt_enterprisesupp*a.eu_direct amt_enterprisesupp,            "); 
		sql.append("        b.amt_other*a.eu_direct   amt_other                   "); 
		sql.append("   from bl_prop_ar_oep a                 "); 
		sql.append("  inner join bl_prop_ar_oep_neusoft b    "); 
		sql.append("  on a.id_proparoep = b.id_proparoep     ");  
		sql.append("  left join bl_prop_oep c                ");
		sql.append("  on a.id_propoep = c.id_propoep  ");  
		sql.append("  left join bl_st_oep st                ");
		sql.append("  on st.id_stoep = c.id_stoep  ");  
		sql.append("  where st.id_emp_st = ? and  a.code_business = ? ");
		sql.append(" ) t                                     "); 
		sql.append(" Group by code_business                  "); 
		
		sql.append(" union");
		sql.append(" Select t.code_business,                 "); 
		sql.append("        Sum(t.amt_all) amt_all,                  "); 
		sql.append("        Sum(t.amt_hp) amt_hp,                   "); 
		sql.append("        Sum(t.amt_psnacc) amt_psnacc,               "); 
		sql.append("        Sum(t.amt_cash) amt_cash,                 "); 
		sql.append("        Sum(t.amt_salvage) amt_salvage,              "); 
		sql.append("        Sum(t.amt_civilservice) amt_civilservice,         "); 
		sql.append("        Sum(t.amt_enterprisesupp) amt_enterprisesupp,       "); 
		sql.append("        Sum(t.amt_other)   amt_other              "); 
		sql.append(" From                                    "); 
		sql.append(" (                                       "); 
		sql.append(" select a.code_business,                 "); 
		sql.append("        a.amt_all*a.eu_direct amt_all,                       "); 
		sql.append("        a.amt_hp*a.eu_direct amt_hp,                        "); 
		sql.append("        a.amt_psnacc*a.eu_direct amt_psnacc,                    "); 
		sql.append("        a.amt_cash*a.eu_direct amt_cash,                      "); 
		sql.append("        b.amt_salvage*a.eu_direct amt_salvage,                   "); 
		sql.append("        b.amt_civilservice*a.eu_direct amt_civilservice,              "); 
		sql.append("        b.amt_enterprisesupp*a.eu_direct amt_enterprisesupp,            "); 
		sql.append("        b.amt_other*a.eu_direct   amt_other                   "); 
		sql.append("   from bl_prop_ar_ip a                 "); 
		sql.append("  inner join bl_prop_ar_ip_neusoft b    "); 
		sql.append("  on a.id_proparip = b.id_proparip     ");  
		sql.append("  left join bl_prop_ip c                ");
		sql.append("  on a.id_propip = c.id_propip  ");  
		sql.append("  left join bl_st_ip st                ");
		sql.append("  on st.id_stip = c.id_stip  ");  
		sql.append("  where st.id_emp_st = ? and  a.code_business = ? ");
		sql.append(" ) t                                     "); 
		sql.append(" Group by code_business                  "); 
		SqlParam param = new SqlParam();
		param.addParam(id_emp);
		param.addParam(businessCode);
		param.addParam(id_emp);
		param.addParam(businessCode);
		
		List<HpFeeSumDTO> sumDtoList  = (List<HpFeeSumDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(HpFeeSumDTO.class));
			
		return sumDtoList.toArray(new HpFeeSumDTO[]{});
	}
}
