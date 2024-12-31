package iih.pe.listener.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetNormalInfoQry implements ITransQry {

	String id_pepsnappt,peNormalDepCode;
	public GetNormalInfoQry(String id_pepsnappt, String peNormalDepCode){
		this.id_pepsnappt = id_pepsnappt;
		this.peNormalDepCode = peNormalDepCode;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(id_pepsnappt);
		param.addParam(peNormalDepCode);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("select rst.rst as Value,");
		sb.append("    rst.unit as Unit,");
		sb.append("    itm.name as Name,");
		sb.append("	   itm.code as Code,");
		//sb.append("    itm.sortno as Seqno,");//显示序号
		sb.append("    rst.des as Flagname,");//异常描述
		sb.append("	   rst.ref as Referrangestext");//正常参考值(参考范围)
		sb.append("  from pe_wf_perst rst");
		sb.append(" inner join pe_bd_deptset dep");
		sb.append("    on rst.id_pedeptset = dep.id_pedeptset");
		sb.append(" inner join pe_itm_pesrvitem itm");
		sb.append("    on itm.id_pesrvitem = rst.id_pesrvitem");
		sb.append(" where rst.id_pepsnappt = ? ");
		sb.append("   and dep.ID_PEDEPTSET = ? ");
		sb.append("   and itm.sd_rptpart = '01'");//一般检查
		return sb.toString();
	}

}
