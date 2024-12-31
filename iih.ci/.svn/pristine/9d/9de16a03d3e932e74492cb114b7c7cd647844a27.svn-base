package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.refs.sql.ip.relhp.IpOrderRefMMRelHpSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.ip.relhp.IpOrderRefSrvRelHpSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefSrvSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.pip.PipOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.pip.PipOrderRefSrvSQLBuilder;
/**
 * 住院参照框，显示医保备注信息
 * @author zhangwq
 *
 */
public class GetMedSrvScBindMMRelHpBP extends GetMedSrvScBindMMBP{

	@Override
	protected OpOrderRefSrvSQLBuilder getOrderRefSrvSQLBuilder(String code_entp) {
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(code_entp)){
			return new PipOrderRefSrvSQLBuilder();
		}
		return new IpOrderRefSrvRelHpSQLBuilder();
	}

	@Override
	protected OpOrderRefMMSQLBuilder getOrderRefMMSQLBuilder(String code_entp) {
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(code_entp)){
			return new PipOrderRefMMSQLBuilder();
		}
		return new IpOrderRefMMRelHpSQLBuilder();
	}
	
}
