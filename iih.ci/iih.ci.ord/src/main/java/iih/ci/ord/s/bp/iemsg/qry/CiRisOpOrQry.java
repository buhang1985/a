package iih.ci.ord.s.bp.iemsg.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.CiIEMsgRelSqlConst;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊检查查询对象
 *
 */
public class CiRisOpOrQry implements ITransQry {

	private String _id_ors;
	
	public CiRisOpOrQry(String id_ors){
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
   
	/**
	 * 获得查询sql串
	 * @return
	 * @throws BizException 
	 */
	 private String getSql() throws BizException{
		 String[] idors=_id_ors.split(CiOrdUtils.COMMA_STR);
		 String str_idor_ris="";
		 String str_idor_path="";
		 for(String idor:idors){
			 String sdtp=CiOrdUtils.GetSrvtpByID(idor);
			 if(sdtp!=null&&sdtp!="") {
				 if(sdtp.equals(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
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
			 formatsql+=String.format(new CiIEMsgRelSqlConst().CI_IE_APPPATH_OP_ALL_SQL(), "A.id_or"+CiOrdUtils.getSqlInOrEqualStrs(str_idor_path.substring(0, str_idor_path.length()-1)));
		 }
		 if(str_idor_ris.length()>0){
			 if(formatsql.length()>0)
				 formatsql+=" Union All ";
			 //其他普通-收费
			 formatsql+=String.format(new CiIEMsgRelSqlConst().CI_IE_APPRIS_OP_ALL_SQL(), "A.id_or"+CiOrdUtils.getSqlInOrEqualStrs(str_idor_ris.substring(0, str_idor_ris.length()-1)));
		 }
		 
		 return formatsql;
		 
		 
		 
		 
		 
//		 String sdtp=CiOrdUtils.GetSrvtpByID(_id_ors);
//		 String formatsql=sdtp.equals(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)?ICiIEMsgRelSqlConst.CI_IE_APPPATH_OP_ALL_SQL:ICiIEMsgRelSqlConst.CI_IE_APPRIS_OP_ALL_SQL;
//		 String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(_id_ors);
//		 return String.format(formatsql, "A.id_or"+id_or4sql);
	 }

}
