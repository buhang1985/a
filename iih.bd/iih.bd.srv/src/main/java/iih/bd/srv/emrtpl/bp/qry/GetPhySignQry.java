package iih.bd.srv.emrtpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询体征数据
 *@author yank 
 *@author liubin
 */
public class GetPhySignQry implements ITransQry{
	private String _mrtplId;
	public GetPhySignQry(String mrtplId){
		this._mrtplId = mrtplId;
	}	
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		whereSQL.append("WHERE  MR.ID_MRTPL = ? ");
		whereSQL.append(" ORDER BY ITM.SORTNO ");
		SqlParam param = new SqlParam();
		param.addParam(this._mrtplId);
		return param;
	}
	
	@Override
	public String getQrySQLStr() {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT SRV.ID_SRV AS ID_SRV,");
		builder.append("SRV.NAME AS NAME_SRV,");
		builder.append("SVT.ID_UNIT AS ID_UNIT,");
		builder.append("SVT.SD_DEDATATP AS SD_DEDATATP,");
		builder.append("SVT.ID_DEDATATP AS ID_DEDATATP,");
		builder.append("SVT.VALCOUNT AS VALCOUNT,");
		builder.append("SVT.DEVALMAX AS DEVALMAX,");
		builder.append("SVT.DEVALMIN AS DEVALMIN,");
		builder.append("UNIT.CODE AS CODE_UNIT,");
		builder.append("UNIT.NAME AS NAME_UNIT ");
		builder.append("FROM BD_MRTPL_VT_ITM ITM ");
		builder.append("INNER JOIN BD_SRV SRV ON ITM.ID_SRV = SRV.ID_SRV AND ITM.DS = 0 AND SRV.DS = 0 ");
		builder.append("INNER JOIN BD_SRV_VT SVT ON SVT.ID_SRV = ITM.ID_SRV AND SVT.DS = 0 ");
		builder.append("INNER JOIN BD_MRTPL_VT MR ON MR.ID_MRTPLVT = ITM.ID_MRTPLVT AND MR.DS = 0 ");
		builder.append("LEFT JOIN BD_MEASDOC UNIT ON SVT.ID_UNIT = UNIT.ID_MEASDOC ");
		return builder.toString();
	}

}
