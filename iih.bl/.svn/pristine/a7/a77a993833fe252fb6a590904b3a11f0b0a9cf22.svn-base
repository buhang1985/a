package iih.bl.pay.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.comm.IBlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取退结转数据 (住院收付款 后结转金额在收退预交金处进行退预交金操作)
 * @author LIM
 * @since 2019-11-05
 *
 */
public class GetRePreCarryQry implements ITransQry {

	String idSt;
	public GetRePreCarryQry(String idSt){
		this.idSt=idSt;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param= new SqlParam();
		param.addParam(IBlConst.BL_CHARGES);
		param.addParam(IBlDictCodeConst.SD_PAYTP_IPPREPAYSTTRANSFER);
		param.addParam(IBlDictCodeConst.SD_PAYTP_PECMPYPREPAYSTTRANSFER);
		param.addParam(this.idSt);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		sb.append("select pre.id_paypat ");
		sb.append(" from bl_prepay_pat pre ");
		sb.append(" inner join bl_pay_itm_pat_ip itm on pre.id_paypat=itm.id_paypat ");
		sb.append(" inner join bl_pay_pat_ip pay on pay.id_paypatip=itm.id_paypatip ");
		sb.append(" where pre.fg_canc='Y' and pre.eu_direct=? and pre.sd_paytp in(?,?) and  pay.id_stip=? ");
		return sb.toString();
	}

}
