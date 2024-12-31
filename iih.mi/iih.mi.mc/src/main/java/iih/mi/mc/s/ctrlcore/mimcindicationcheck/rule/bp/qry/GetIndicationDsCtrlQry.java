package iih.mi.mc.s.ctrlcore.mimcindicationcheck.rule.bp.qry;

import iih.bd.base.utils.SqlUtils;

import java.util.List;

import xap.mw.core.utils.ListUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 查询服务对应的病种限制数据
 * @author LIM
 * @since 2019-09-29
 */
public class GetIndicationDsCtrlQry implements ITransQry{

	String idHp;
	List<String> idlist;
	public GetIndicationDsCtrlQry(String idHp,List<String> idlist){
		this.idHp=idHp;
		this.idlist=idlist;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param= new SqlParam();
		param.addParam(this.idHp);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb= new StringBuilder();
		sb.append("select dsctr.id_srv,");
		sb.append("dsctr.id_mm,");
		sb.append("dsctr.id_dsdef,");
		sb.append("ds.code as Dsdef_code,");
		sb.append("ds.name as Dsdef_name ");
		sb.append(" from bd_hp_srvctr_ds dsctr");
		sb.append(" inner join bd_ds_def ds on dsctr.id_dsdef = ds.id_dsdef");
		sb.append("  where dsctr.id_hp = ?");
		if(!ListUtil.isEmpty(idlist)){
			sb.append(SqlUtils.getInSqlByIds(" and dsctr.id_srv || dsctr.id_mm ", idlist));
		}
		return sb.toString();
	}

}
