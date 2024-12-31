package iih.mc.common.qry;

import iih.bd.mm.common.MmSQLHelper;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.mc.commom.qry.util.McQryEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPkguInfoByMmcodeQry implements ITransQry{

	private String mmCode_whrStr = null;
	
	public GetPkguInfoByMmcodeQry(String[] mmCodes) {
		
		this.mmCode_whrStr = MmSQLHelper.initInCondition("mm.code", mmCodes);
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		SqlParam param = new SqlParam();
		return param;
	}

	@Override
	public String getQrySQLStr() {

		return _getQrySQLStr();
	}
	
	private String _getQrySQLStr() {
		
		StringBuffer SqlStr = new StringBuffer();
		
		SqlStr.append(" select ");
		SqlStr.append(" mm_pkgu.id_mmpkgu, ");
		SqlStr.append(" mm.id_mm, ");
		SqlStr.append(" mm_pkgu.id_mmpkgutp, ");
		SqlStr.append(" mm_pkgu.id_unit_pkg, ");
		SqlStr.append(" unit.name Unit_pkg_name, ");
		SqlStr.append(" mm_pkgu.factor, ");
		SqlStr.append(" mm_pkgu.Sd_mmpkgupro ");
		SqlStr.append(" from bd_mm mm ");
		SqlStr.append(" left join bd_mm_pkgu mm_pkgu ");
		SqlStr.append(" on mm.id_mm = mm_pkgu.id_mm ");
		SqlStr.append(" left join bd_measdoc unit ");
		SqlStr.append(" on mm_pkgu.id_unit_pkg = unit.id_measdoc ");
		SqlStr.append(" where " + this.mmCode_whrStr);
		SqlStr.append(" and " + McQryEnvContextUtil.getWherePart(new MeterialDO(), "mm"));
		
		return SqlStr.toString();
	}
}
