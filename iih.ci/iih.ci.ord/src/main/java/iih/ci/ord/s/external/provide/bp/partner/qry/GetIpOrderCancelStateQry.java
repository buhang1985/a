package iih.ci.ord.s.external.provide.bp.partner.qry;

import iih.ci.ord.i.external.provide.meta.partner.IpOrderCancelStateParamDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 医嘱是否已作废确认
 * @author zhangwq
 *
 */
public class GetIpOrderCancelStateQry implements ITransQry {
	private IpOrderCancelStateParamDTO param;
	public GetIpOrderCancelStateQry(IpOrderCancelStateParamDTO param){
		this.param = param;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this.param.getCode_or());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		return "select fg_chk_canc from ci_order where code_or=?";
	}

}
