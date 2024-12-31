package iih.bl.pay.blpaypat.bp;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.sie.common.utils.StringUtils;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

public class BlprepayDetailBp {
	
	@SuppressWarnings("unchecked")
	public BlPrepayDTO[] findPrepayDetail(String id_pat, String code_enttp, String Dt_start, String Dt_end)
			throws BizException {

		StringBuffer sql = new StringBuffer();
		sql = getSql(id_pat, code_enttp, Dt_start, Dt_end);

		SqlParam sp = new SqlParam();
		sp = getParam(id_pat, code_enttp, Dt_start, Dt_end);

		List<BlPrepayDTO> ipdtos = (List<BlPrepayDTO>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(BlPrepayDTO.class));
		return ipdtos.toArray(new BlPrepayDTO[0]);
	}
	
	public PagingRtnData<BlPrepayDTO> findPrepayDetailPageInfoDos(FMap map, PaginationInfo pageInfo) throws BizException {
		PagingRtnData<BlPrepayDTO> pageFeeDTO = new PagingRtnData<BlPrepayDTO>();
		PagingServiceImpl<BlPrepayDTO> service = new PagingServiceImpl<BlPrepayDTO>();
		String id_pat = map.get("id_pat").toString();
		String code_enttp = map.get("code_enttp").toString();
		String Dt_start = map.get("Dt_start").toString();
		String Dt_end = map.get("Dt_end").toString();

		StringBuffer sql = new StringBuffer();
		sql = getSql(id_pat, code_enttp, Dt_start, Dt_end);

		SqlParam param = new SqlParam();
		param = getParam(id_pat, code_enttp, Dt_start, Dt_end);

		pageFeeDTO = service.findByPageInfo(new BlPrepayDTO(), pageInfo,
				sql.toString(), "", param);
		
		return pageFeeDTO;
	}

	private StringBuffer getSql(String id_pat, String code_enttp, String Dt_start, String Dt_end) throws BizException
	{
		if (StringUtils.isEmpty(id_pat)) {
			throw new BizException("患者ID或就诊ID不能为空!");
		}

		if (StringUtils.isEmpty(code_enttp)) {
			throw new BizException("患者类型不能为空!");
		}

		
		StringBuffer sql = new StringBuffer();

		sql.append("select pre.id_paypat, ");
		sql.append("  pre.eu_direct , " );
		sql.append("  case pre.eu_direct when 1 then '收费' when -1 then '退费' else '' end name_eu_direct, ");
		sql.append("  st.code_st code_st, " );
		sql.append("  st.amt, " );
		sql.append("  inctab.incno num_inc, " );
		sql.append("  othertab.node_paydetail Node_paydetail, ");
		sql.append("       pat.name as name_pat, " );
		sql.append("       pat.code as code_pat, " );
		sql.append("       pm.name as name_paymod, " );
		sql.append("       case pre.eu_direct " );
		sql.append("         when -1 then " );
		sql.append("          '' " );
		sql.append("         else " );
		sql.append("          To_Char((pre.eu_direct * pre.amt), '999999999990.99') " );
		sql.append("       end as amt_income, " );
		sql.append("       case pre.eu_direct " );
		sql.append("         when 1 then " );
		sql.append("          '' " );
		sql.append("         else " );
		sql.append("          To_Char((pre.eu_direct * pre.amt), '999999999990.99') " );
		sql.append("       end as amt_pay, " );
		sql.append("       To_Char((acc.amt_acc), '999999999990.99') amt_acc, " );
		sql.append("       psn.name as name_emp, " );
		sql.append("       pre.dt_pay, " );
		sql.append("       case pre.sd_paytp " );
		sql.append("         when '01' then " );
		sql.append("          '结算' " );
		sql.append("         when '02' then " );
		sql.append("          '中途结算' " );
		sql.append("         when '03' then " );
		sql.append("          '结算冲帐' " );
		sql.append("         when '04' then " );
		sql.append("          '欠费补缴' " );
		sql.append("         when '05' then " );
		sql.append("          '取消结算' " );
		sql.append("         when '11' then " );
		sql.append("          '患者预交金' " );
		sql.append("         when '12' then " );
		sql.append("          '住院流程预交金' " );
		sql.append("         when '13' then " );
		sql.append("          '单位团检流程预交金' " );
		sql.append("         when '14' then " );
		sql.append("          '院流程预交金（转入）' " );
		sql.append("         when '15 ' then " );
		sql.append("          '住院流程预交金（结转）' " );
		sql.append("         when '16' then " );
		sql.append("          '单位团检流程预交金（结转）' " );
		sql.append("         when '17' then " );
		sql.append("          '患者预交金转住院预交金' " );
		sql.append("         when '18 ' then " );
		sql.append("          '取消出纳退还押金凭条' " );
		sql.append("         when '19' then " );
		sql.append("          '住院预交金转患者预交金' " );
		sql.append("         when '20' then " );
		sql.append("          '患者预交金（结转）' " );
		sql.append("         when '21' then " );
		sql.append("          '患者预交金消费' " );
		sql.append("         when '22' then " );
		sql.append("          '住院流程预交金收费' " );
		sql.append("         when '23' then " );
		sql.append("          '单位团检住院流程预交金消费' " );
		sql.append("         else " );
		sql.append("          pre.sd_paytp " );
		sql.append("       end sd_paytp, " );
		sql.append("       pre.note, " );
		sql.append("       pre.code_rep " );
		sql.append("  from bl_prepay_pat pre " );
		sql.append("  left join bd_pri_pm pm " );
		sql.append("    on pre.id_pm = pm.id_pm " );
		sql.append("  left join bl_prepay_pat_acc acc " );
		sql.append("    on pre.id_paypat = acc.id_paypat " );
		sql.append("  left join bd_psndoc psn " );
		sql.append("    on pre.id_emp_pay = psn.id_psndoc " );
		sql.append(" inner join pi_pat pat " );
		sql.append("    on pre.id_pat = pat.id_pat ");
		if("00".equals(code_enttp)){
			sql.append(" left join bl_pay_itm_pat_oep payitm on pre.id_paypat = payitm.id_paypat ");
			sql.append(" left join bl_st_oep st on payitm.id_paypatoep = st.id_paypatoep " );			
			sql.append("left join ( ");
			sql.append(" " );
			sql.append("            select inc.id_stoep as id_stoep, " );
			sql.append("                    replace(replace(wm_concat(inc.incno || '|' || ''), " );
			sql.append("                                    '', " );
			sql.append("                                    ';'), " );
			sql.append("                            '|', " );
			sql.append("                            '') as incno " );
			sql.append("              from bl_inc_oep inc " );
			sql.append("             where inc.id_pat = ? " );
			sql.append("             group by inc.id_stoep " );
			sql.append(" " );
			sql.append("            ) inctab " );
			sql.append("   on inctab.id_stoep = st.id_stoep ");

			sql.append(" left join (select otherpay.id_paypatoep as id_paypatoep, replace(replace(wm_concat(otherpm.name || '|' || otherpayitm.amt),',',';'),'|',',') as node_paydetail " );
			sql.append("                   from bl_pay_itm_pat_oep otherpayitm " );
			sql.append("                        inner join bl_pay_pat_oep otherpay on otherpay.id_paypatoep = otherpayitm.id_paypatoep " );
			sql.append("                        inner join bd_pri_pm otherpm on otherpayitm.id_pm = otherpm.id_pm " );
			sql.append("                        where otherpay.id_pat = ? " );
			sql.append("                        group by otherpay.id_paypatoep " );
			sql.append("            ) othertab " );
			sql.append("on othertab.id_paypatoep = st.id_paypatoep ");
		}
		else if("10".equals(code_enttp)){
			sql.append("left join bl_pay_itm_pat_ip payitm on pre.id_paypat = payitm.id_paypat ");
			sql.append("left join bl_pay_pat_ip pay on pay.id_paypatip = payitm.id_paypatip " );
			sql.append("left join bl_st_ip st on st.id_stip = pay.id_stip " );			
			sql.append("left join ( ");
			sql.append(" " );
			sql.append("             select inc.id_stip as id_stip, " );
			sql.append("                     replace(replace(wm_concat(inc.incno || '|' || ''), " );
			sql.append("                                     '', " );
			sql.append("                                     ';'), " );
			sql.append("                             '|', " );
			sql.append("                             '') as incno " );
			sql.append("               from bl_inc_ip inc " );
			sql.append("              where inc.id_ent = ? " );
			sql.append("              group by inc.id_stip " );
			sql.append(" " );
			sql.append("             ) inctab " );
			sql.append("    on inctab.id_stip = st.id_stip ");

			sql.append(" " );
			sql.append("left join (select otherpay.id_stip as id_stip, replace(replace(wm_concat(otherpm.name || '|' || otherpayitm.amt),',',';'),'|',',') as node_paydetail " );
			sql.append("                  from bl_pay_itm_pat_ip otherpayitm " );
			sql.append("                  inner join bl_pay_pat_ip otherpay on otherpay.id_paypatip = otherpayitm.id_paypatip " );
			sql.append("                  inner join bd_pri_pm otherpm on otherpayitm.id_pm = otherpm.id_pm " );
			sql.append("                  where otherpay.id_ent = ? " );
			sql.append("                  group by otherpay.id_stip " );
			sql.append(") othertab " );
			sql.append("on othertab.id_stip = st.id_stip ");

		}
		
		sql.append(" where  1=1 ");
		if("00".equals(code_enttp))
			sql.append(" and pre.id_pat = ? ");
		else if("10".equals(code_enttp))
			sql.append(" and pre.id_ent = ? ");
		sql.append(" and pre.code_enttp = ? ");
		if (!StringUtils.isEmpty(Dt_start))
			sql.append(" and pre.dt_pay >= ? ");
		if (!StringUtils.isEmpty(Dt_end ))
			sql.append(" and pre.dt_pay < ? ");
		sql.append(" order by pre.dt_pay ");
		return sql;
	}

	private SqlParam getParam(String id_pat, String code_enttp, String Dt_start, String Dt_end){
		SqlParam sp = new SqlParam();
		sp.addParam(id_pat);
		sp.addParam(id_pat);
		sp.addParam(id_pat);
		sp.addParam(code_enttp);
		if (!StringUtils.isEmpty(Dt_start))
			sp.addParam(Dt_start);
		if (!StringUtils.isEmpty(Dt_end))
			sp.addParam(Dt_end);
		return sp;
	}
}
