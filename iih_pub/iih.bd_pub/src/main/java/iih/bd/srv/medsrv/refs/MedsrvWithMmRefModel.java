package iih.bd.srv.medsrv.refs;

import java.util.List;

import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 服务及物品参照模型
 * @author ly
 *
 */
public class MedsrvWithMmRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{"Name_srv","Code_srv","Name_mm","Spec"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{"Id_pk","Id_srv","Id_srvtp","Sd_srvtp","Id_srvca","Quan_med",
				"Id_unit_med","Name_unit_med","Fg_mm","Id_mm","Srv_wbcode","Srv_pycode"};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"服务名称","编码","物品名称","规格"};
	}
	
	@Override
	public String getPkFieldCode() {
		//id_srv + id_mm
		return "Id_pk";
	}
	@Override
	public String getRefCodeField() {
		return "Code_srv";
	}
	@Override
	public String getRefNameField() {
		return "Name_srv";
	}

	@Override
	public String getTableName() {
		return "srvmm";
	}
	
	@Override
	public String getRefSql() {
		
		String sql = "select * from (select bd_srv.name as name_srv,"
				+ "bd_srv.code as code_srv,"
				+ "bd_mm.name as name_mm,"
				+ "bd_mm.spec,"
				+ "CONCAT(bd_srv.id_srv,bd_mm.id_mm) as id_pk,"
				+ "bd_srv.id_srv,"
				+ "bd_srv.id_srvtp,"
				+ "bd_srv.sd_srvtp,"
				+ "bd_srv.id_srvca,"
				+ "bd_srv.quan_med,"
				+ "bd_srv.id_unit_med,"
				+ "unitmed.name as name_unit_med,"
				+ "bd_srv.fg_mm,"
				+ "bd_mm.id_mm,"
				+ "bd_srv.wbcode as srv_wbcode,"
				+ "bd_srv.pycode as srv_pycode "
				+ "from bd_srv "
				+ "left join bd_mm "
				+ "on bd_srv.id_srv = bd_mm.id_srv "
				+ "and bd_mm.ds = 0 "
				+ "and bd_mm.fg_active = 'Y' "
				+ "left join bd_measdoc unitmed "
				+ "on bd_srv.id_unit_med = unitmed.id_measdoc "
				+ "where bd_srv.ds = 0 "
				+ "and bd_srv.fg_use_ip= 'Y' "
				+ "and bd_srv.fg_active = 'Y' "
				+ "and bd_srv.fg_set = 'N' "
				+ "and bd_srv.fg_bl = 'Y' "
				+ "and bd_srv.id_org = '" +Context.get().getOrgId()+"' "
				+ "order by bd_srv.code,bd_mm.code) srvmm "
				+ "where 1=1 ";
		
		StringBuilder sb = new StringBuilder(sql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
		
		return sb.toString();
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{"name_srv","code_srv","srv_wbcode","srv_pycode"};
	}
}
