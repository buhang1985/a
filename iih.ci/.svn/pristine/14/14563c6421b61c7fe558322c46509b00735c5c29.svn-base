package iih.ci.event.ord.bps.charge.op.query;

import iih.ci.event.ord.bps.charge.op.sql.OpRisChargeSql;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 门诊 收费 检查 BS002 除了联系人外的所有信息
 * @author F
 *
 * @date 2019年9月11日下午4:36:35
 *
 * @classpath iih.ci.event.ord.bps.charge.op.query.OpRisChargeInfoQuery
 */
public class OpRisChargeInfoQuery implements ITransQry{

	private String _id_ors;
	
	public OpRisChargeInfoQuery(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		try {
			return getSql();
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}
   
	/**
	 * 获得查询sql串
	 * @return
	 * @throws BizException 
	 */
	 private String getSql() throws BizException{//1.【IEOpRisOrEnDTO】+ 【IEOpRisIllHisDTO】 2.【IEOpRisOrDTO】  3.【IEOpRisOrItmDTO】
		 String[] idors=_id_ors.split(OrdEventUtil.COMMA_STR);
		 String str_idor_ris="";
		 String str_idor_path="";
		 for(String idor:idors){
			 String sdtp=OrdEventUtil.GetSrvtpByID(idor);
			 if(sdtp!=null&&sdtp!="") {
				 if(sdtp.equals(OrdEventUtil.SD_SRVTP_RIS_BINGLI)) {
					 str_idor_path+=idor+",";
				 }
				 else {
					 str_idor_ris+=idor+",";
				 }
			 }
		 }
		 String formatsql="";
		 if(str_idor_path.length()>0){
			 //病理-收费
			 formatsql+=String.format(new OpRisChargeSql().getOpRisChargePathInfoSql(), " A.id_or "+OrdEventUtil.getSqlInOrEqualStrs(str_idor_path.substring(0, str_idor_path.length()-1)));
		 }
		 if(str_idor_ris.length()>0){
			 if(formatsql.length()>0)
				 formatsql+=" Union All ";
			 //其他普通-收费
			 formatsql+=String.format(new OpRisChargeSql().getOpRisChargeRisInfoSql(), " A.id_or "+OrdEventUtil.getSqlInOrEqualStrs(str_idor_ris.substring(0, str_idor_ris.length()-1)));
		 }
		 
		 return formatsql;
	 }
}
