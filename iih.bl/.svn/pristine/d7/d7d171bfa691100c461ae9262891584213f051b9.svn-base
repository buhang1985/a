package iih.bl.cg.bp.self.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取门诊收费记录处方列表接口
 * @author LIM
 *
 */
public class GetEntPayRecordInfoQry implements ITransQry {
	String code_st;
	String patCode;
	public GetEntPayRecordInfoQry(String patCode,String code_st){
		this.patCode=patCode;
		this.code_st=code_st;	
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();	
		if (!StringUtil.isEmpty(this.code_st)) {
			param.addParam(this.code_st);
		}	
		if (!StringUtil.isEmpty(this.patCode)) {
			param.addParam(this.patCode);
		}	
//		if (!StringUtil.isEmpty(this.patCode)) {
//			param.addParam(this.patCode);
//		}	
//		if (!StringUtil.isEmpty(this.code_st)) {
//			param.addParam(this.code_st);
//		}			
		return param;
	}
	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		sb.append(getPaySql());
//		sb.append(" union all ");
//		sb.append(getHpSql());
		return sb.toString();
	}
	private String getPaySql(){
		StringBuilder sb= new StringBuilder();
		sb.append("select distinct oep.code_applytp as applyTpCode,");
		sb.append(" oep.code_apply as applyCode,");
		sb.append(" pay.amt as amt,");
		sb.append(" pay.sd_pttp as pttpCode,");
		sb.append(" case pay.sd_pttp when '01' then '窗口' when '02' then '自助机' when '03' then '微信' when '04' then '手机APP' end as pttpName,");
		sb.append(" pay.paymodenode as payOrder,");
		sb.append("    case when pri.code ='11' then '1' ");
		sb.append("  when pri.code ='12' then '2' ");
		sb.append("  when pri.code ='02' then '4' ");
		sb.append("   when pri.code ='13' then '6'");
		sb.append("   else '3' end as pmCode,");//支付编码
		sb.append(" pri.name as pmName,");
		sb.append(" pay.id_cc as ccCode,");
		sb.append(" pay.dt_st as settleTime   "); 
		sb.append(" from  BL_CG_ITM_OEP oep ");
		sb.append(" inner join Bl_St_Oep st on oep.id_stoep= st.id_stoep ");
		//防止多个处方多个支付方式 数据翻倍，因此只查询一条支付方式，自助机的支付方式也只显示其中一条，因此这样处理
		sb.append(" inner join (");
		sb.append(" select st.id_stoep,st.dt_st,itm.id_pm,itm.paymodenode, pay.id_cc,pay.sd_pttp,pay.eu_direct*pay.amt as amt ");
		sb.append(" from Bl_St_Oep st ");
		sb.append(" inner join BL_PAY_PAT_OEP pay on st.id_paypatoep=pay.id_paypatoep ");
		sb.append(" inner join BL_PAY_ITM_PAT_OEP itm  on pay.id_paypatoep=itm.id_paypatoep ");
		sb.append(" where code_st=? and rownum<2 and nvl(pay.sd_pttp ,'~')<>'~'  ");
		sb.append(") pay  on oep.id_stoep= pay.id_stoep");
		sb.append(" inner join pi_pat pat on oep.id_pat= pat.id_pat  ");
		sb.append(" inner join bd_pri_pm pri on pay.id_pm=pri.id_pm ");
		sb.append(" where  nvl(oep.code_apply,'~')<>'~' and nvl(pay.sd_pttp ,'~')<>'~' ");
		//不查询已退费信息
		sb.append(" and oep.fg_refund='N' ");
		sb.append(" AND st.eu_direct = '1' ");
		sb.append("	AND st.fg_canc = 'N' ");
		sb.append(" and oep.fg_st = 'Y' ");
		sb.append("	AND nvl(st.id_paypatoep,'~')<>'~' ");
	    sb.append(" and pat.code=?");
		return sb.toString();
	}
	/**
	 * 获取商保或者预交金记账数据
	 * @return
	 */
	private String getHpSql(){
		StringBuilder sb= new StringBuilder();
		sb.append("select distinct oep.code_applytp as applyTpCode,");
		sb.append("oep.code_apply as applyCode,");
		sb.append("(cg.eu_direct*oep.amt_ratio) as amt,");
		sb.append("'01' as pttpCode,");
		sb.append("case when oep.fg_acc='Y' then '05' else '17' end as pmCode,");
		sb.append(" case when oep.fg_acc='Y' then '预交金' else '高端商保' end  as pmName,");
		sb.append("st.id_cc as ccCode,");
		sb.append("st.dt_st as settleTime"); 
		sb.append(" from BL_CG_ITM_OEP oep ");
		sb.append(" inner join bl_cg_oep cg on oep.id_cgoep=cg.id_cgoep");
		sb.append(" inner join Bl_St_Oep st on oep.id_stoep= st.id_stoep ");
		sb.append(" inner join pi_pat pat on oep.id_pat= pat.id_pat  ");
		sb.append(" where (oep.fg_acc='Y' or oep.fg_hpcg='Y') and nvl(id_paypatoep,'~')='~'");
		sb.append(" and pat.code=?  and st.code_st=? ");
		return sb.toString();
	}
}
