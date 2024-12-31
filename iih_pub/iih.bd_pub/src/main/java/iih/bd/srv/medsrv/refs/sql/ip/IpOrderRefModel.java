package iih.bd.srv.medsrv.refs.sql.ip;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.refs.sql.er.ObsOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.er.ObsOrderRefSrvSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefMMSQLBuilder;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefModel;
import iih.bd.srv.medsrv.refs.sql.op.OpOrderRefSrvSQLBuilder;

public class IpOrderRefModel extends OpOrderRefModel {
	@Override
	protected OpOrderRefSrvSQLBuilder getOrderRefSrvSQLBuilder(String code_entp){
		if(StringUtils.isNullOrEmpty(code_entp)){
			return new IpOrderRefSrvSQLBuilder();
		} else {
			if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {// 住院
				return new IpOrderRefSrvSQLBuilder();
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)) {// 急诊留观
				return new ObsOrderRefSrvSQLBuilder();
			}
		}
		return new IpOrderRefSrvSQLBuilder();
	}
	@Override
	protected OpOrderRefMMSQLBuilder getOrderRefMMSQLBuilder(String code_entp){
		if(StringUtils.isNullOrEmpty(code_entp)){
			return new IpOrderRefMMSQLBuilder();
		} else {
			if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {// 住院
				return new IpOrderRefMMSQLBuilder();
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)) {// 急诊留观
				return new ObsOrderRefMMSQLBuilder();
			}
		}
		return new IpOrderRefMMSQLBuilder();
	}
	@Override
	public String getDrugDisplayMd() {
		return DrugCheckDisplayMd4IP.getInstance().getDrugCheckDisplayMd4IP();
	}
	
}
