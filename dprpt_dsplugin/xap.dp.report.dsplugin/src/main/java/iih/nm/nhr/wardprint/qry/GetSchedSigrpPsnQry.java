package iih.nm.nhr.wardprint.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取科室周排班分组人员数据
 * @author 王鹏
 *
 */
public class GetSchedSigrpPsnQry implements ITransQry{

	private String[] nhrSigrpIds;
	
	public GetSchedSigrpPsnQry(String[] nhrSigrpIds) {
		this.nhrSigrpIds = nhrSigrpIds;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		for (String nhrSigrpId : nhrSigrpIds) {
			param.addParam(nhrSigrpId);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer stb = new StringBuffer();
		stb.append("select sigrppsn.id_nur,");
		stb.append("nur.name as name,");
		stb.append("nur.id_psndoc,");
		stb.append("sigrppsn.id_nhr_sigrp,");
		stb.append("sigrppsn.sortno as sortno,");
		stb.append("udi1.name as namelvl,");
		stb.append("udi2.name as duty");
		stb.append(" from NM_NHR_SIGRP_PSN sigrppsn");
		stb.append(" left join nm_nur nur on sigrppsn.id_nur = nur.id_nur");
		stb.append(" left join bd_psndoc psndoc on nur.id_psndoc = psndoc.id_psndoc");
		stb.append(" left join bd_udidoc udi1 on sigrppsn.id_nur_lvl = udi1.id_udidoc");
		stb.append(" left join bd_udidoc udi2 on psndoc.id_emptitle = udi2.id_udidoc");
		stb.append(" where 1 = 1");
		stb.append(" and sigrppsn.id_nhr_sigrp in ( ");
		for (int i = 0; i < nhrSigrpIds.length; i++) {
			stb.append(i == 0 ? " ? " : ",?");
		}
		stb.append(")");
		stb.append(" order by sigrppsn.sortno asc");
		return stb.toString();
	}
}
