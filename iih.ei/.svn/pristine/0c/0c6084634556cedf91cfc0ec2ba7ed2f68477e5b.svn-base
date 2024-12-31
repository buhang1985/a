package iih.ei.itf.eiitfcateitm.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.utils.BdEnvContextUtil;
import iih.ei.itf.eiitfcateitm.d.ItfCateItmDO;
import iih.ei.itf.eiitfcateitm.d.desc.ItfCateItmDODesc;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询接口分类项目
 * 
 * @author hao_wu 2020-2-10
 *
 */
public class FindItfCateItmQry implements ITransQry {

	private String _itfCateId;
	private String _whereStr;
	private String _orderStr;

	public FindItfCateItmQry(String itfCateId, String whereStr, String orderStr) {
		this._itfCateId = itfCateId;
		this._whereStr = whereStr;
		this._orderStr = orderStr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam sqlParam = new SqlParam();
		if (StringUtils.isNotBlank(this._itfCateId)) {
			sqlParam.addParam(this._itfCateId);
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(this.getBaseSql());
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(this.getWherePart());
		sqlBuilder.append(" ORDER BY ");
		sqlBuilder.append(this.getOrderPart());
		return sqlBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT EI_ITF_CATE_ITM.ID_ITFCATE_ITM,"); // 接口id
		sqlBuilder.append("EI_ITF_CATE_ITM.ID_ITFCATE,"); // 接口id
		sqlBuilder.append("EI_ITF_CATE_ITM.SORTNO,"); // 接口id
		sqlBuilder.append("EI_ITF_CATE_ITM.ID_ITF,"); // 接口id
		sqlBuilder.append("EI_ITF_CATE_ITM.ID_GRP,"); // 所属集团
		sqlBuilder.append("EI_ITF_CATE_ITM.ID_ORG,"); // 所属组织
		sqlBuilder.append("EI_ITF.CODE,"); // 编码
		sqlBuilder.append("EI_ITF.NAME,"); // 名称
		sqlBuilder.append("EI_ITF.SERVICENAME,"); // 服务名
		sqlBuilder.append("EI_ITF.METHODNAME,"); // 方法名
		sqlBuilder.append("EI_ITF.FG_SYS,"); // 系统标识
		sqlBuilder.append("EI_ITF.EU_SERIALIZE,"); // 序列化类型
		sqlBuilder.append("EI_ITF.FG_SERIALIZE,"); // 序列化标识
		sqlBuilder.append("EI_ITF.CALL_RATE,"); // 调用频率
		sqlBuilder.append("EI_ITF.DES,"); // 详细说明
		sqlBuilder.append("EI_ITF.FULLNAME,"); // 服务全路径
		sqlBuilder.append("EI_ITF.PYCODE,"); // 拼音码
		sqlBuilder.append("EI_ITF.WBCODE,"); // 五笔码
		sqlBuilder.append("EI_ITF.MNECODE,"); // 助记码
		sqlBuilder.append("EI_ITF.DEF1,"); // 客户扩展字段1
		sqlBuilder.append("EI_ITF.DEF2,"); // 客户扩展字段2
		sqlBuilder.append("EI_ITF.DEF3,"); // 客户扩展字段3
		sqlBuilder.append("EI_ITF.DEF4,"); // 客户扩展字段4
		sqlBuilder.append("EI_ITF.DEF5,"); // 客户扩展字段5
		sqlBuilder.append("EI_ITF_CATE_ITM.CREATEDBY,"); // 创建人
		sqlBuilder.append("EI_ITF_CATE_ITM.CREATEDTIME,"); // 创建时间
		sqlBuilder.append("EI_ITF_CATE_ITM.MODIFIEDBY,"); // 最后修改人
		sqlBuilder.append("EI_ITF_CATE_ITM.MODIFIEDTIME,"); // 最后修改时间
		sqlBuilder.append("EI_ITF.FG_ACTIVE,"); // 启用标识
		sqlBuilder.append("EI_ITF.FG_PRINTLOG,"); // 是否打印日志
		sqlBuilder.append("EI_ITF.FG_AFFAIRS,"); // 是否启用事务
		sqlBuilder.append("EI_ITF.ID_MODUL,"); // 所属模块
		sqlBuilder.append("DM_MODULE.NAME AS NAME_MODUL,"); // 名称
		sqlBuilder.append("EI_ITF.VERSION "); // 版本号
		sqlBuilder.append("FROM EI_ITF ");
		sqlBuilder.append("INNER JOIN EI_ITF_CATE_ITM ");
		sqlBuilder.append("ON EI_ITF.ID_ITF = EI_ITF_CATE_ITM.ID_ITF ");
		sqlBuilder.append("LEFT JOIN DM_MODULE ");
		sqlBuilder.append("ON EI_ITF.ID_MODUL = DM_MODULE.ID ");
		return sqlBuilder.toString();
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String whereStr = BdEnvContextUtil.processEnvContext(new ItfCateItmDO(), ItfCateItmDODesc.TABLE_NAME);
		if (StringUtils.isNotBlank(whereStr)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(whereStr);
		}

		if (StringUtils.isNotBlank(this._itfCateId)) {
			wherePartBuilder.append(" AND EI_ITF_CATE_ITM.ID_ITFCATE = ?");
		}

		if (StringUtils.isNotBlank(this._whereStr)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._whereStr);
		}
		return wherePartBuilder.toString();
	}

	private String getOrderPart() {
		if (StringUtils.isNotBlank(this._orderStr)) {
			return this._orderStr;
		}
		return "EI_ITF.PYCODE,EI_ITF.ID_ITF";
	}
}
