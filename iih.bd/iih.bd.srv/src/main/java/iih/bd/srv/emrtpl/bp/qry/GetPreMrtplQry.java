package iih.bd.srv.emrtpl.bp.qry;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 查询预检模板
 * @author yankan
 *
 */
public class GetPreMrtplQry implements ITransQry  {
	private String _depId;
	private String _mrtpCode;
	public GetPreMrtplQry(String depId,String mrtpCode){
		this._depId = depId;
		this._mrtpCode = mrtpCode;
	}
	/**
	 * 
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam param = new SqlParam();
		param.addParam(this._depId);
		param.addParam(this._mrtpCode);
		return param;
	}
	/**
	 * 
	 */
	@Override
	public String getQrySQLStr() {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT TPL.ID_MRTPL,TPL.ID_DEPT FROM BD_MRTPL TPL ");
		builder.append("INNER JOIN BD_MRTP TP ON TPL.ID_MRTP = TP.ID_MRTP AND TPL.DS = 0 AND TP.DS = 0 ");
		builder.append("INNER JOIN BD_MRTPL_VT VT ON TPL.ID_MRTPL=VT.ID_MRTPL AND VT.DS = 0 ");
		//全院或指定科室的
		builder.append("WHERE (TPL.SD_OWTP='0' OR (TPL.SD_OWTP='1' AND TPL.ID_DEPT=?)) ");
		builder.append("AND " + EnvContextUtil.processEnvContext("", new EmrTplDO(), "TPL"));
		builder.append(" AND TP.CODE=?");
		return builder.toString();
	}
}
