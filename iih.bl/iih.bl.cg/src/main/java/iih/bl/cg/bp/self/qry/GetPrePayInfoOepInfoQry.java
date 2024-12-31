package iih.bl.cg.bp.self.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取门诊病人预交金交易明细接口
 * @author LIM
 *
 */
public class GetPrePayInfoOepInfoQry implements ITransQry{
	String cardNo;
	String patCode;
	String beginDate;
	String endDate;
	public GetPrePayInfoOepInfoQry(String cardNo, String patCode, String beginDate,
			String endDate){
		this.cardNo=cardNo;
		this.patCode=patCode;
		this.beginDate=beginDate;
		this.endDate=endDate;		
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (this.cardNo != null && this.cardNo != "") {
			param.addParam(this.cardNo);
		}		
		if (this.patCode != null && this.patCode != "") {
			param.addParam(this.patCode);
		}
		if (this.beginDate != null && this.beginDate != "") {
			param.addParam(this.beginDate);
		}
		if (this.endDate != null && this.endDate != "") {
			param.addParam(this.endDate );
		}		
		return param;
	}
	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		sb.append("select  card.code as cardNo,");
		sb.append("entp.code as tradeType,");
		sb.append("pm.code as pmName,");
		sb.append("(pre.eu_direct*pre.amt)  as amt,");
		sb.append(" pre.dt_pay  as tradeTime");
		sb.append(" from bl_prepay_pat pre inner join ");
		sb.append(" pi_pat pat on pre.id_pat=pat.id_pat");
		sb.append(" inner join PI_PAT_CARD patcard on pat.id_pat=patcard.id_pat");
		sb.append(" inner join pi_card card on patcard.id_card=card.id_card");
		sb.append(" inner join bd_pri_pm pm on pre.id_pm=pm.id_pm");
		sb.append(" inner join bd_entp entp on pre.id_enttp=entp.id_entp");
		sb.append(" where card.fg_canc='N' and patcard.fg_act='Y' and pat.ds=0 and pat.fg_invd = 'N'");
		sb.append(" and card.code=? and pat.code=? and  TRUNC(TO_DATE(pre.dt_pay,'yyyy-MM-dd hh24:mi:ss'))>=? and  TRUNC(TO_DATE(pre.dt_pay,'yyyy-MM-dd hh24:mi:ss'))<=?");
		return sb.toString();
	}
}
