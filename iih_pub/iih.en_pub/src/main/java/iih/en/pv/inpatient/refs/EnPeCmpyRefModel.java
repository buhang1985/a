package iih.en.pv.inpatient.refs;

import iih.en.pv.inpatient.d.EnPeCmpyDO;
import iih.en.pv.inpatient.d.PeStatusEnum;
import iih.en.pv.inpatient.d.desc.EnPeCmpyDODesc;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 团检记录参照模型
 * @author ly 2018/03/26
 *
 */
public class EnPeCmpyRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_cust", "code_cust", "fg_in_str",
				EnPeCmpyDO.DT_B, EnPeCmpyDO.DT_E };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { EnPeCmpyDO.ID_PECMPY, EnPeCmpyDO.ID_CUST_CMPY,
				EnPeCmpyDO.NO_CONTRACT, EnPeCmpyDO.EU_STATUS };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "单位名称", "单位代码", "是否在院", "入院时间", "出院时间" };
	}

	@Override
	public String getPkFieldCode() {
		return EnPeCmpyDO.ID_PECMPY;
	}

	@Override
	public String getRefCodeField() {
		return "code_cust";
	}

	@Override
	public String getRefNameField() {
		return "name_cust";
	}

	@Override
	public String getTableName() {
		return "pecmpy";
	}
	
	@Override
	public String getRefSql() {
		
		StringBuilder sqlSb = new StringBuilder();
		
		sqlSb.append("select * from (");
		sqlSb.append("select bd_cust.name name_cust,");
		sqlSb.append("bd_cust.code code_cust,");
		sqlSb.append("case when en_pe_cmpy.eu_status = '" +PeStatusEnum.STATUS_PE_INHOS+ "' then '是' else '否' end fg_in_str,");
		sqlSb.append("en_pe_cmpy.dt_b,");
		sqlSb.append("en_pe_cmpy.dt_e,");
		sqlSb.append("en_pe_cmpy.id_pecmpy,");
		sqlSb.append("en_pe_cmpy.id_cust_cmpy,");
		sqlSb.append("en_pe_cmpy.no_contract,");
		sqlSb.append("en_pe_cmpy.eu_status,");
		//模糊查询字段
		sqlSb.append("bd_cust.wbcode,");
		sqlSb.append("bd_cust.pycode,");
		sqlSb.append("bd_cust.mnecode ");
		
		sqlSb.append("from en_pe_cmpy ");
		sqlSb.append("left join bd_cust ");
		sqlSb.append("on en_pe_cmpy.id_cust_cmpy = bd_cust.id_cust ");
		sqlSb.append("where en_pe_cmpy.fg_active = 'Y' ");
		
		String orgSql = EnvContextUtil.processEnvContext("", new EnPeCmpyDO(), EnPeCmpyDODesc.TABLE_NAME);
		sqlSb.append( " AND "+orgSql);
		sqlSb.append("order by en_pe_cmpy.dt_b desc ");
		sqlSb.append(") pecmpy where 1=1 ");
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sqlSb.append(" And (").append(where).append(") ");
			}
		}

		return sqlSb.toString();		
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { "name_cust", "code_cust", EnPeCmpyDO.NO_CONTRACT,"wbcode", "pycode", "mnecode" };
	}
}
