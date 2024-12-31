package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.refs.sql.ip.relhp.IpOrderRefMMRelHpDesSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.ip.relhp.IpOrderRefSrvRelHpDesSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefSrvSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.pip.PipOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.pip.PipOrderRefSrvSQLBuilder;

/**
 * 住院参照去掉描述字段去掉bd_srv.des
 * @author LiYueLong
 *
 * 2020年7月27日-下午3:35:47
 */
public class GetMedSrvScBindMMRelHpDesBP extends GetMedSrvScBindMMRelHpBP {


	@Override
	protected OpOrderRefSrvSQLBuilder getOrderRefSrvSQLBuilder(String code_entp) {
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(code_entp)){
			return new PipOrderRefSrvSQLBuilder();
		}
		return new IpOrderRefSrvRelHpDesSQLBuilder();
	}

	@Override
	protected OpOrderRefMMSQLBuilder getOrderRefMMSQLBuilder(String code_entp) {
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(code_entp)){
			return new PipOrderRefMMSQLBuilder();
		}
		return new IpOrderRefMMRelHpDesSQLBuilder();
	}
	
	
}
