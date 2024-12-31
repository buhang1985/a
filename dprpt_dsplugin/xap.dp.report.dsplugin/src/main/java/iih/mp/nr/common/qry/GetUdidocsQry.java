package iih.mp.nr.common.qry;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:档案数据查询Sql
 * @author:zhongcl@founder.com.cn
 * @version:2019年1月9日 下午3:23:08 创建
 */
public class GetUdidocsQry implements ITransQry {

	private String udidoclistCode;

	private String udidocCode;

	private Map<String, Object> fieldValue;

	public GetUdidocsQry(String udidoclistCode) {
		super();
		this.udidoclistCode = udidoclistCode;
	}

	public GetUdidocsQry(Map<String, Object> fieldValue) {
		super();
		this.fieldValue = fieldValue;
	}

	public GetUdidocsQry(String udidoclistCode, String udidocCode) {
		super();
		this.udidoclistCode = udidoclistCode;
		this.udidocCode = udidocCode;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		if (StringUtils.isNotBlank(this.udidoclistCode))
			param.addParam(this.udidoclistCode);
		if (StringUtils.isNotBlank(this.udidocCode))
			param.addParam(this.udidocCode);
		if (MapUtils.isNotEmpty(this.fieldValue)) {
			Collection<Object> fieldValue = this.fieldValue.values();
			for (Object field : fieldValue) {
             param.addParam(field);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuilder sql = new StringBuilder();
		sql.append(" select doc.*  from bd_udidoc doc                                            ");
		sql.append(" inner join bd_udidoclist doclist on doc.id_udidoclist=doclist.id_udidoclist ");
		sql.append(" where 1=1 and doclist.ds='0'                                                ");
		if (StringUtils.isNotBlank(this.udidoclistCode))
			sql.append(" and doclist.code=?                                              ");
		if (StringUtils.isNotBlank(this.udidocCode))
			sql.append(" and doc.code=?                                              ");
		if (MapUtils.isNotEmpty(this.fieldValue)) {
			Set<String> fieldNames = this.fieldValue.keySet();
			for (String filedName : fieldNames) {
				sql.append(" and " + filedName + "=?");
			}
		}
		return sql.toString();
	}
}
