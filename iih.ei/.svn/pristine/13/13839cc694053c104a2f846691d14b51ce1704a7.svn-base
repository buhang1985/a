package iih.ei.std.s.v1.bp.mp.pathgydata.qry;

import java.util.List;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
* @ClassName: GetPayhgySampInfoSql
* @Description: 查询申请单明细(病理部位)
* @author zhy
* @date 2019年9月27日
*
 */
public class GetPathgySampInfoSql implements ITransQry{
	
	private List<String> no_applyforms; //病理申请单号

	public GetPathgySampInfoSql(List<String> no_applyforms) {
		super();
		this.no_applyforms = no_applyforms;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (no_applyforms != null && no_applyforms.size() != 0) {
			for(String no_applyform : no_applyforms){
				param.addParam(no_applyform);// 病理申请号
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {

		return getWhereString();
	}

	public String getWhereString(){
		
		StringBuffer sql = new StringBuffer();
		sql.append("select  ci_pathgy_samp.dt_sign Req_date_time,");
		sql.append("  ci_pathgy_samp.name_labsamp as bbmc, "); //--标本名称
		sql.append("  ci_ap_pathgy.no_applyform as no_applyform  ");//申请单号
		sql.append("  from  ci_ap_pathgy ci_ap_pathgy ");
		sql.append("  left join ci_pathgy_samp ci_pathgy_samp on ci_ap_pathgy.id_appathgy = ci_pathgy_samp.id_appathgy  ");
		String str = "";
		if (no_applyforms != null && no_applyforms.size() != 0) {
			for(int i = 0; i < no_applyforms.size(); i++){
				str += str.length() == 0?"?":",?";
			}
		}
		sql.append(" where ci_ap_pathgy.no_applyform in ("+str+")");
		
		return sql.toString();  
	}
}
