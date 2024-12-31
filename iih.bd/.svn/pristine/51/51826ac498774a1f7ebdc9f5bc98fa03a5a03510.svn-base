package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getNurMrConTplCaDOListSql implements ITransQry {

	public getNurMrConTplCaDOListSql() {
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam Param = new SqlParam();
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	public String getSqlStr() {
		StringBuffer SqlStr = new StringBuffer();

//		SqlStr.append("( ");
//		SqlStr.append("  select  ");
//		SqlStr.append("  id_mrnurcontplca, ");
//		SqlStr.append("  id_grp,id_org, ");
//		SqlStr.append("  code,  ");
//		SqlStr.append("  concat(concat(name,'('),concat(mrtplcount,')')) as name,  ");
//		SqlStr.append("  wbcode,pycode, ");
//		SqlStr.append("  mnecode,des,id_parent, ");
//		SqlStr.append("  innercode,createdby, ");
//		SqlStr.append("  createdtime, ");
//		SqlStr.append("  modifiedby, ");
//		SqlStr.append("  modifiedtime, ");
//		SqlStr.append("  DS,SV,  ");
//		SqlStr.append("  name as def1  ");
//		SqlStr.append("  from  ");
//		SqlStr.append("  (  ");
//		SqlStr.append("    select   ");
//		SqlStr.append("    mrtplca.*,  ");
//		SqlStr.append("    (  ");
//		SqlStr.append("      select count(*) from bd_mr_nur_con_tpl mrtpl  ");
//		SqlStr.append("      where mrtpl.id_mrnurcontplca=mrtplca.id_mrnurcontplca ");
//		SqlStr.append("    )as mrtplcount    ");
//		SqlStr.append("    from bd_mr_nur_con_tpl_ca mrtplca  ");
//		SqlStr.append("    where nvl(mrtplca.id_parent,'~')<>'~' ");
//		SqlStr.append("    and mrtplca.ds=0 ");
//		SqlStr.append("  ) ");
//		SqlStr.append(")  ");
//		SqlStr.append("union  ");
//		SqlStr.append("(  ");
//		SqlStr.append("  select mrtplca.*,mrtplca.name as def1  ");
//		SqlStr.append("  from bd_mr_nur_con_tpl_ca mrtplca ");
//		SqlStr.append("  where nvl(mrtplca.id_parent,'~')='~'  ");
//		SqlStr.append("  and mrtplca.ds=0  ");
//		SqlStr.append(") ");

		SqlStr.append("  select  ");
		SqlStr.append("  id_mrnurcontplca, ");
		SqlStr.append("  id_grp,id_org, ");
		SqlStr.append("  code,  ");
		SqlStr.append("  concat(concat(name,'('),concat(mrtplcount,')')) as name,  ");
		SqlStr.append("  wbcode,pycode, ");
		SqlStr.append("  mnecode,des,id_parent, ");
		SqlStr.append("  innercode,createdby, ");
		SqlStr.append("  createdtime, ");
		SqlStr.append("  modifiedby, ");
		SqlStr.append("  modifiedtime, ");
		SqlStr.append("  DS,SV,  ");
		SqlStr.append("  name as def1  ");
		SqlStr.append("  from  ");
		SqlStr.append("  (  ");
		SqlStr.append("    select   ");
		SqlStr.append("    mrtplca.*,  ");
		SqlStr.append("    (  ");
		SqlStr.append("      select count(*) from bd_mr_nur_con_tpl mrtpl  ");
		SqlStr.append("      where mrtpl.id_mrnurcontplca=mrtplca.id_mrnurcontplca ");
		SqlStr.append("    )as mrtplcount    ");
		SqlStr.append("    from bd_mr_nur_con_tpl_ca mrtplca  ");
		SqlStr.append("    where mrtplca.ds=0 ");
		SqlStr.append("  ) ");

		
		return SqlStr.toString();

	}
}
