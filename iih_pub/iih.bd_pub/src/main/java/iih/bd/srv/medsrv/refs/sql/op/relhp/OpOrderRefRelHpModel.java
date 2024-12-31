package iih.bd.srv.medsrv.refs.sql.op.relhp;

import com.mysql.jdbc.StringUtils;

import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefModel;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefSrvSQLBuilder;
/**
 * 门诊参照显示医保备注
 * @author zhangwq
 *
 */
public class OpOrderRefRelHpModel extends OpOrderRefModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected OpOrderRefSrvSQLBuilder getOrderRefSrvSQLBuilder(String code_entp) {
		if(StringUtils.isNullOrEmpty(code_entp)){
			return new OpOrderRefSrvRelHpSQLBuilder();
		}
		return new OpOrderRefSrvRelHpSQLBuilder();
	}

	@Override
	protected OpOrderRefMMSQLBuilder getOrderRefMMSQLBuilder(String code_entp) {
		if(StringUtils.isNullOrEmpty(code_entp)){
			return new OpOrderRefMMRelHpSQLBuilder();
		}
		return new OpOrderRefMMRelHpSQLBuilder();
	}
	
	
}
