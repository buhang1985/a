package iih.bl.hp.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bl.hp.dto.d.HpFeeSumDTO;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医疗费用对账
 * 
 * @param pg 分页对象
 * @param qryNode 查询面板对象
 * @return
 * @throws BizException
 * @author liwq
 * @since 2017-7-14 14:32:47
 */
public class GetFeeSummaryBP {

	public PagingRtnData<HpFeeSumDTO> exec(PaginationInfo pg,QryRootNodeDTO qryNode) throws BizException {
		
		PagingRtnData<HpFeeSumDTO> pageFeeDTO = new PagingRtnData<HpFeeSumDTO>();
		PagingServiceImpl<HpFeeSumDTO> service =new PagingServiceImpl();	
		
		StringBuilder sql = new StringBuilder();
		sql.append(" Select t.code_business,                 "); 
		sql.append("        Sum(t.amt_all),                  "); 
		sql.append("        Sum(t.amt_hp),                   "); 
		sql.append("        Sum(t.amt_psnacc),               "); 
		sql.append("        Sum(t.amt_cash),                 "); 
		sql.append("        Sum(t.amt_salvage),              "); 
		sql.append("        Sum(t.amt_civilservice),         "); 
		sql.append("        Sum(t.amt_enterprisesupp),       "); 
		sql.append("        Sum(t.amt_other)                 "); 
		sql.append(" From                                    "); 
		sql.append(" (                                       "); 
		sql.append(" select a.code_business,                 "); 
		sql.append("        a.amt_all,                       "); 
		sql.append("        a.amt_hp,                        "); 
		sql.append("        a.amt_psnacc,                    "); 
		sql.append("        a.amt_cash,                      "); 
		sql.append("        b.amt_salvage,                   "); 
		sql.append("        b.amt_civilservice,              "); 
		sql.append("        b.amt_enterprisesupp,            "); 
		sql.append("        b.amt_other                      "); 
		sql.append("   from bl_prop_ar_oep a                 "); 
		sql.append("  inner join bl_prop_ar_oep_neusofg b    "); 
		sql.append("  on a.id_proparoep = b.id_proparoep     ");  
		sql.append("  left join bl_prop_oep c                ");
		sql.append("  on a.id_propoep = c.id_propoep  ");  
		sql.append("  left join bl_st_oep st                ");
		sql.append("  on d.id_stoep = c.id_stoep  ");  
		sql.append("  where st.dt_st  and st.id_emp_st ");
		sql.append(" union all                               "); 
		sql.append(" select a.code_business,                 "); 
		sql.append("        a.amt_all,                       "); 
		sql.append("        a.amt_hp,                        "); 
		sql.append("        a.amt_psnacc,                    "); 
		sql.append("        a.amt_cash,                      "); 
		sql.append("        b.amt_salvage,                   "); 
		sql.append("        b.amt_civilservice,              "); 
		sql.append("        b.amt_enterprisesupp,            "); 
		sql.append("        b.amt_other                      "); 
		sql.append("   from bl_prop_ar_ip a                  "); 
		sql.append("  inner join bl_prop_ar_ip_neusofg b    "); 
		sql.append("  on a.id_proparip = b.id_proparip   "); 
		sql.append("  left join bl_prop_ip c                ");
		sql.append("  on a.id_propip = c.id_propip  ");  
		sql.append("  left join bl_st_ip st                ");
		sql.append("  on d.id_stip = c.id_stip  ");  
		sql.append("  where st.dt_st  and st.id_emp_st ");
		sql.append(" ) t                                     "); 
		sql.append(" Group by code_business                  "); 
		
		SqlParam param = new SqlParam();
		
		
		pageFeeDTO = service.findByPageInfo(new HpFeeSumDTO(), pg, sql.toString(), "", param);
			
		return pageFeeDTO;
	}
}
