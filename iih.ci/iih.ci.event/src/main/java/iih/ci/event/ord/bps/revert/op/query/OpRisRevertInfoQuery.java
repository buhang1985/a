package iih.ci.event.ord.bps.revert.op.query;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.ci.event.ord.bps.revert.op.sql.OpRisRevertSql;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 门诊撤回检查BS002
 * @author F
 *
 * @date 2019年9月11日上午11:58:44
 *
 * @classpath iih.ci.event.ord.bps.revert.op.query.OpRisRevertInfoQuery
 */
public class OpRisRevertInfoQuery implements ITransQry{

	private String _id_ors;
	private String str_idor_ris;//普通检查
	private String str_idor_path;//病理检查
	
	public OpRisRevertInfoQuery(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		//TODO 判断两个 id串长度 以此决定放置多少参数
		if (str_idor_path.length()>0 && str_idor_ris.length()>0) {
			
			//两条病理参数
			sqlpram.addParam( ICiDictCodeTypeConst.ID_SU_BL_1 );
			sqlpram.addParam( ICiDictCodeTypeConst.SD_SU_BL );

			//四个检查参数
			sqlpram.addParam( IBdSrvIEEventConst.SD_SRVTP_JCL );
			sqlpram.addParam( IBdSrvIEEventConst.SD_SRVTP_HYL );
			sqlpram.addParam( ICiDictCodeTypeConst.ID_SU_BL_1 );
			sqlpram.addParam( ICiDictCodeTypeConst.SD_SU_BL );
			
		}else if(str_idor_path.length()>0 && str_idor_ris.length()<1){
			sqlpram.addParam( ICiDictCodeTypeConst.ID_SU_BL_1 );
			sqlpram.addParam( ICiDictCodeTypeConst.SD_SU_BL );
		}else{
			sqlpram.addParam( IBdSrvIEEventConst.SD_SRVTP_JCL );
			sqlpram.addParam( IBdSrvIEEventConst.SD_SRVTP_HYL );
			sqlpram.addParam( ICiDictCodeTypeConst.ID_SU_BL_1 );
			sqlpram.addParam( ICiDictCodeTypeConst.SD_SU_BL );
		}
	
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
	 private String getSql() throws BizException{//【IEOpRisOrEnDTO】  【IEOpRisOrDTO】 【IEOpRisIllHisDTO】 【IEOpRisOrItmDTO】
		 String[] idors=_id_ors.split(OrdEventUtil.COMMA_STR);
		  str_idor_ris="";
		  str_idor_path="";
		 for(String idor:idors){
			 String sdtp=OrdEventUtil.GetSrvtpByID(idor);
			 if(sdtp!=null && sdtp!="") {
				 if(sdtp.equals(OrdEventUtil.SD_SRVTP_RIS_BINGLI)) {
					 str_idor_path+=idor+",";
				 }else {
					 str_idor_ris+=idor+",";
				}
			 }
		 }
		 String formatsql="";
		 if(str_idor_path.length()>0){
			 formatsql +=  new OpRisRevertSql().getOpRisWithDrawPathInfoSql(str_idor_path.substring(0, str_idor_path.lastIndexOf(",") ));//病理
		 }
		 if(str_idor_ris.length()>0){
			 if(formatsql.length()>0){
				 
				 formatsql+=" Union All ";
			 }
			 formatsql +=  new OpRisRevertSql().getOpRisWithDrawRisInfoSql( str_idor_ris.substring(0, str_idor_ris.lastIndexOf(",")));//其他普通
		 }
		 return formatsql;
	 }
}