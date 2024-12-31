package iih.bl.cg.bp.self.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取门诊收费记录明细清单接口
 * @author LIM
 *
 */
public class GetItmOepInfoQry implements ITransQry{
	String patCode;
	String applyCode;
	String timesOp;
	public GetItmOepInfoQry(String patCode, String applyCode,String timesOp){
		this.patCode=patCode;
		this.applyCode=applyCode;
		this.timesOp=timesOp;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
//		if (!StringUtil.isEmpty(this.patCode) ) {
//			param.addParam(this.patCode);
//		}		
//		if (!StringUtil.isEmpty(this.applyCode)) {
//			param.addParam(this.applyCode);
//		}	
//		if ( this.opTimes>0 ) {
//			param.addParam(this.opTimes);
//		}		
		return param;
	}
	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append(getcgdetailQry());
		
		return sb.toString();
	}
	private String getcgdetailQry(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("select ent.id_hp,itm.code_apply as applyCode ,");
		sb.append("itm.code_applytp as applyTpCode,");
		sb.append("itm.code_srv as srvCode,");
		sb.append("nvl(mm.PRINTNAME,itm.name_srv) as srvName,");
		sb.append("measdoc.name as unit ,");
		sb.append("itm.spec as sepcification,");
		sb.append("itm.price_ratio as price,");
		sb.append("(cg.eu_direct*itm.quan) as quan,");
		sb.append("(cg.eu_direct*itm.amt_ratio)as amt,");
		sb.append(" case when itm.sd_hpsrvtp='1' then '甲类' when itm.sd_hpsrvtp='2' then '乙类' else '丙类' end as srvChargeGrade,");//类别
		sb.append(" '1' as quanOrders ");//自助机不显示此字段，但是必须有默认值，不然自助机获取不到返回的数据 
		sb.append(" from bl_cg_itm_oep itm   ");
		sb.append(" inner join BL_CG_OEP cg on cg.id_cgoep=itm.id_cgoep ");
		sb.append(" inner join Bl_St_Oep st on itm.id_stoep= st.id_stoep ");
		sb.append(" inner join pi_pat pat on itm.id_pat= pat.id_pat  ");
		sb.append(" INNER JOIN en_ent ent on ent.id_ent=itm.id_ent ");
		sb.append(" INNER JOIN en_ent_op op on op.id_ent=ent.id_ent ");
		sb.append(" left join bd_measdoc measdoc on itm.srvu= measdoc.id_measdoc ");
		sb.append(" LEFT JOIN bd_mm mm on itm.id_mm =mm.id_mm ");
		sb.append(" where nvl(id_paypatoep,'~')<>'~' ");
		sb.append("	 AND nvl(st.id_paypatoep,'~')<>'~' AND itm.fg_refund='N'  ");
		sb.append("	AND st.eu_direct = '1' ");
		sb.append("	AND st.fg_canc = 'N' ");
		//不查询已退费信息
		//sb.append(" and itm.fg_refund='N' and nvl(itm.id_par,'~')='~' ");
		sb.append(getSqlWhere());
		
		return sb.toString();	
	}
	
	/**
	 * where
	 * @return
	 */
	private String getSqlWhere(){
		StringBuilder sb= new StringBuilder();
		//sb.append(" and ci_order.sd_su_bl='1' ");
		if (!StringUtil.isEmpty(this.patCode) ) {
			sb.append(" and pat.code='"+ this.patCode + "'  ");
		}	
		if (!StringUtil.isEmpty(this.timesOp) ) {
			sb.append(" and op.times_op='"+ this.timesOp + "'  ");
		}			
		if (!StringUtil.isEmpty(this.applyCode)) {
			sb.append(" and itm.code_apply='"+ this.applyCode + "' ");
		}			
		return sb.toString();
	}	
}
