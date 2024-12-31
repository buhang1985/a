package iih.bd.base.refs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.utils.BdEnvContextUtil;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

/**
 * 基础数据参照表格模型
 * 
 * @author hao_wu
 *
 */
public abstract class BdRefGridModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	private String BDDATAINFOFLDKEY_CODE = "code";
	private String BDDATAINFOFLDKEY_NAME = "name";
	private String BDDATAINFOFLDKEY_PYCODE = "pycode";
	private String BDDATAINFOFLDKEY_WBCODE = "wbcode";
	private String BDDATAINFOFLDKEY_MNECODE = "mnecode";

	@Override
	public String getPkFieldCode() {
		return this.getDo().getPKFieldName();
	}

	@Override
	public String getRefCodeField() {
		Map<String, String> bdDataInfoFldMap = this.getDo().getDODesc().getIBDDataInfoFldMap();
		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_CODE)) {
			return bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_CODE);
		}
		return null;
	}

	@Override
	public String getRefNameField() {
		Map<String, String> bdDataInfoFldMap = this.getDo().getDODesc().getIBDDataInfoFldMap();
		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_NAME)) {
			return bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_NAME);
		}
		return null;
	}

	@Override
	public String getTableName() {
		return this.getDo().getTableName();
	}

	@Override
	public String[] getBlurFields() {

		List<String> fieldList = getBlurFieldList();
		return fieldList.toArray(new String[0]);

	}

	/**
	 * 获取模糊搜索字段集合
	 * 
	 * @return
	 */
	protected List<String> getBlurFieldList() {
		ArrayList<String> list = new ArrayList<String>();

		IBaseDO dataDo = this.getDo();
		String[] blurFields = getBlurFieldsByDo(dataDo);
		if (ArrayUtils.isNotEmpty(blurFields)) {
			for (String field : blurFields) {
				list.add(field);
			}
		}

		return list;
	}

	@Override
	public String getRefSql() {
		String wherePart = buildWherePart();
		String orderPart = buildOrderPart();
		String refSql;
		try {
			if (StringUtils.isNotEmpty(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (StringUtils.isNotEmpty(orderPart)) {
				String[] orderParts = orderPart.split(",");
				for (String str : orderParts) {
					this.getOrderPart().add(str);
				}
			}

			String baseRefSql = getBaseRefSql();

			if (StringUtils.isEmpty(baseRefSql)) {
				refSql = super.getRefSql();
			} else {
				refSql = this.getRefSql(baseRefSql);
			}
		} finally {
			if (StringUtils.isNotEmpty(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (StringUtils.isNotEmpty(orderPart)) {
				String[] orderParts = orderPart.split(",");
				for (String str : orderParts) {
					this.getOrderPart().remove(str);
				}
			}
		}

		return refSql;
	}

	/**
	 * 根据基础参照SQL获取最终参照SQL
	 * 
	 * @param baseRefSql
	 * @return
	 */
	private String getRefSql(String baseRefSql) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(baseRefSql);

		List<String> wherePartList = this.getWherePart();
		if (wherePartList != null && wherePartList.size() > 0) {
			sqlBuilder.append(" WHERE 1 = 1 ");
			for (String wherePart : wherePartList) {
				sqlBuilder.append(" AND ");
				sqlBuilder.append(wherePart);
			}
		}

		List<String> orderPartList = this.getOrderPart();
		if (orderPartList != null && orderPartList.size() > 0) {
			sqlBuilder.append(" ORDER BY ");
			sqlBuilder.append(StringUtils.join(orderPartList, " , "));
		}
		return sqlBuilder.toString();
	}

	/**
	 * 获取基础参照SQL
	 * 
	 * @return
	 */
	protected String getBaseRefSql() {
		return null;
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	protected String buildWherePart() {
		StringBuilder wherePartBuilder = buildWhereParter();
		return wherePartBuilder.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	protected StringBuilder buildWhereParter() {
		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = String.format("%s.DS = 0", this.getTableName());
		wherePartBuilder.append(wherePart);

		String bdModeWherePart = getBdModeWherePart();
		if (StringUtils.isNotEmpty(bdModeWherePart)) {
			wherePartBuilder.append(String.format(" AND %s ", bdModeWherePart));
		}

		wherePart = (String) this.getExtendAttributeValue("wherePart");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder;
	}

	/**
	 * 获取基础数据管控条件语句
	 * 
	 * @return
	 */
	protected String getBdModeWherePart() {
		String bdModeWherePart = BdEnvContextUtil.processEnvContext(getDo(), this.getTableName());
		return bdModeWherePart;
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	protected String buildOrderPart() {
		List<String> orderPartList = getOrderPartList();
		return StringUtils.join(orderPartList, ',');
	}

	/**
	 * 获取排序字段列表
	 * 
	 * @return
	 */
	protected List<String> getOrderPartList() {
		String baseRefSql = this.getBaseRefSql();
		boolean customBaseRefSql = false;
		if (StringUtils.isNotBlank(baseRefSql)) {
			customBaseRefSql = true;
		}
		ArrayList<String> orderPartList = new ArrayList<String>();

		String tableName = getTableName();
		Map<String, String> bdDataInfoFldMap = this.getDo().getDODesc().getIBDDataInfoFldMap();
		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_PYCODE)) {
			String fieldName = bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_PYCODE);
			String orderPart = fieldName;
			if (customBaseRefSql) {
				orderPart = String.format("%s.%s", tableName, fieldName);
			}
			orderPartList.add(orderPart);
		}
		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_CODE)) {
			String fieldName = bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_CODE);
			String orderPart = fieldName;
			if (customBaseRefSql) {
				orderPart = String.format("%s.%s", tableName, fieldName);
			}
			orderPartList.add(orderPart);
		}

		String fieldName = this.getDo().getPKFieldName();
		String orderPart = fieldName;
		if (customBaseRefSql) {
			orderPart = String.format("%s.%s", tableName, fieldName);
		}
		orderPartList.add(orderPart);
		return orderPartList;
	}

	/**
	 * 获取DO
	 * 
	 * @return
	 */
	protected abstract IBaseDO getDo();

	/**
	 * 从包含AS的字段名中获取字段名
	 * 
	 * @param oriField
	 * @return
	 */
	protected String cutOffAs(String oriField) {
		int index = oriField.indexOf(" as ");
		if (index != -1)
			oriField = oriField.substring(0, index);
		return oriField;
	}

	@Override
	public String[] getShowFieldCode() {
		ArrayList<String> showFieldCodeList = new ArrayList<String>();

		Map<String, String> bdDataInfoFldMap = this.getDo().getDODesc().getIBDDataInfoFldMap();

		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_NAME)) {
			String fieldCode = bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_NAME);
			showFieldCodeList.add(fieldCode);
		}
		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_CODE)) {
			String fieldCode = bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_CODE);
			showFieldCodeList.add(fieldCode);
		}
		return showFieldCodeList.toArray(new String[0]);
	}

	@Override
	public String[] getHiddenFieldCode() {
		return getHiddenFieldCodeList().toArray(new String[0]);
	}

	/**
	 * 获取隐藏字段编码集合
	 * 
	 * @return
	 */
	protected List<String> getHiddenFieldCodeList() {
		List<String> codeList = new LinkedList<String>();
		codeList.add(this.getDo().getPKFieldName());
		return codeList;
	}

	@Override
	public String[] getShowFieldName() {
		ArrayList<String> showfieldNameList = new ArrayList<String>();

		Map<String, String> bdDataInfoFldMap = this.getDo().getDODesc().getIBDDataInfoFldMap();

		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_NAME)) {
			String fieldCode = bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_NAME);
			showfieldNameList.add(this.getDo().getDODesc().getAttrDesc(fieldCode).toString());
		}
		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_CODE)) {
			String fieldCode = bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_CODE);
			showfieldNameList.add(this.getDo().getDODesc().getAttrDesc(fieldCode).toString());
		}
		return showfieldNameList.toArray(new String[0]);
	}

	protected String getBlurWherePart(String blurValue) {
		StringBuilder wherePartBuilder = new StringBuilder();

		wherePartBuilder.append("(1 = 2");

		String tableName = this.getTableName();
		String wherePart = getBlurWherePartByDoAndFields(blurValue, tableName, this.getBlurFields());
		if (StringUtils.isNotBlank(wherePart)) {
			wherePartBuilder.append(" or ");
			wherePartBuilder.append(wherePart);
		}

		String aliasTableName = getAliasTableName();
		if (StringUtils.isNotBlank(aliasTableName)) {

			String aliasWherePart = getBlurWherePartByDoAndFields(blurValue, aliasTableName, this.getAliasBlurFields());
			if (StringUtils.isNotBlank(aliasWherePart)) {
				String aliasRefFieldCode = getAliasRefFieldCode();

				String pkFieldCode = getPkFieldCode();
				aliasWherePart = String.format("(%s.%s in (select %s from %s where 1 = 1 and (%s)))", tableName,
						pkFieldCode, aliasRefFieldCode, aliasTableName, aliasWherePart);

				if (StringUtils.isNotBlank(aliasWherePart)) {
					wherePartBuilder.append(" or ");
					wherePartBuilder.append(aliasWherePart);
				}
			}
		}

		wherePartBuilder.append(")");

		return wherePartBuilder.toString();
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		String wherePart = getBlurWherePart(blurValue);

		this.addWherePart(wherePart);
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(wherePart);
		}
	}

	/**
	 * 获取别名DO
	 * 
	 * @return
	 */
	protected IBaseDO getAliasDo() {
		return null;
	}

	/**
	 * 获取别名表名称
	 * 
	 * @return
	 */
	protected String getAliasTableName() {
		IBaseDO aliasDo = this.getAliasDo();
		if (aliasDo == null) {
			return null;
		}
		String tableName = aliasDo.getTableName();
		return tableName;
	}

	/**
	 * 获取别名表模糊搜索字段
	 * 
	 * @return
	 */
	public String[] getAliasBlurFields() {
		IBaseDO aliasDo = this.getAliasDo();
		if (aliasDo == null) {
			return null;
		}
		String[] aliasBlurFields = getBlurFieldsByDo(aliasDo);
		return aliasBlurFields;
	}

	/**
	 * 获取别名关联字段编码
	 * 
	 * @return
	 */
	protected String getAliasRefFieldCode() {
		// 默认别名关联字段等于主表主键
		return getPkFieldCode();
	}

	/**
	 * 获取DO的模糊搜索字段集合
	 * 
	 * @param Do
	 * @return
	 */
	private String[] getBlurFieldsByDo(IBaseDO Do) {
		ArrayList<String> blurFieldList = new ArrayList<String>();

		Map<String, String> bdDataInfoFldMap = Do.getDODesc().getIBDDataInfoFldMap();
		if (bdDataInfoFldMap == null) {
			return null;
		}
		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_PYCODE)) {
			String fieldName = bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_PYCODE);
			blurFieldList.add(fieldName);
		}
		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_NAME)) {
			String fieldName = bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_NAME);
			blurFieldList.add(fieldName);
		}
		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_MNECODE)) {
			String fieldName = bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_MNECODE);
			blurFieldList.add(fieldName);
		}
		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_CODE)) {
			String fieldName = bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_CODE);
			blurFieldList.add(fieldName);
		}
		if (bdDataInfoFldMap.containsKey(this.BDDATAINFOFLDKEY_WBCODE)) {
			String fieldName = bdDataInfoFldMap.get(this.BDDATAINFOFLDKEY_WBCODE);
			blurFieldList.add(fieldName);
		}
		return blurFieldList.toArray(new String[0]);
	}

	/**
	 * 根据DO和字段集合生成模糊查询条件语句
	 * 
	 * @param blurValue
	 * @param dataDo
	 * @param blurFields
	 * @return
	 */
	private String getBlurWherePartByDoAndFields(String blurValue, String tableName, String[] blurFields) {
		if (ArrayUtils.isEmpty(blurFields)) {
			return null;
		}

		ArrayList<String> wherePartList = new ArrayList<String>();
		for (String blurField : blurFields) {
			String wherePart = String.format("lower(%s.%s) like '%%%s%%'", tableName, blurField,
					blurValue.toLowerCase());
			wherePartList.add(wherePart);
		}
		return StringUtils.join(wherePartList, " or ");
	}

	@Override
	public RefResultSet getRefData() {
		RefResultSet refResultSet = super.getRefData();
		this.afterQueryRefData(refResultSet);
		return refResultSet;
	}

	@Override
	public RefResultSet getRefData(PaginationInfo pg) {
		RefResultSet refResultSet = super.getRefData(pg);
		this.afterQueryRefData(refResultSet);
		return refResultSet;
	}

	/**
	 * 查询数据后处理
	 * 
	 * @param refResultSet
	 */
	public void afterQueryRefData(RefResultSet refResultSet) {

	}

	/**
	 * 设置字段值集合
	 * 
	 * @param refResultSet   参照结果集
	 * @param fieldValueMap  字段值字典
	 * @param keyFieldCode   键字段编码
	 * @param valueFieldCode 值字段编码
	 */
	public void setFieldValues(RefResultSet refResultSet, Map<?, ?> fieldValueMap, String keyFieldCode,
			String valueFieldCode) {
		if (StringUtils.isBlank(keyFieldCode) || xap.sie.common.utils.StringUtils.isBlank(valueFieldCode)
				|| refResultSet == null || refResultSet.getData() == null || refResultSet.getData().size() <= 0
				|| fieldValueMap == null || fieldValueMap.size() <= 0) {
			return;
		}

		Integer keyFieldIndex = getFieldIndex(keyFieldCode);
		Integer valueFieldIndex = getFieldIndex(valueFieldCode);
		List<List<Object>> dataList = refResultSet.getData();
		for (List<Object> data : dataList) {
			Object keyValue = data.get(keyFieldIndex);
			if (keyValue != null && fieldValueMap.containsKey(keyValue)) {
				data.set(valueFieldIndex, fieldValueMap.get(keyValue));
			}
		}
	}

	/**
	 * 获取字段值集合
	 * 
	 * @param refResultSet    参照结果集
	 * @param fieldCode       字段编码
	 * @param fieldValueTyped 字段值类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T[] getFieldValues(RefResultSet refResultSet, String fieldCode, Class<T> fieldValueTyped) {
		if (refResultSet == null) {
			return null;
		}

		List<List<Object>> dataList = refResultSet.getData();
		if (dataList == null || dataList.size() <= 0) {
			return null;
		}

		int fieldIndex = getFieldIndex(fieldCode);

		if (fieldIndex == -1) {
			return null;
		}

		List<T> fieldValueList = new ArrayList<T>();
		for (int i = 0; i < dataList.size(); i++) {
			List<Object> data = dataList.get(i);
			T fieldValue = (T) data.get(fieldIndex);
			if (fieldValue != null) {
				fieldValueList.add(fieldValue);
			}
		}
		return fieldValueList.toArray((T[]) Array.newInstance(fieldValueTyped, 0));
	}

	/**
	 * 获取字段编码的索引值
	 */
	@Override
	public int getFieldIndex(String fieldCode) {
		String[] allFields = getAllFields();
		int fieldIndex = -1;
		for (int i = 0; i < allFields.length; i++) {
			if (fieldCode.equals(allFields[i])) {
				fieldIndex = i;
				break;
			}
		}
		return fieldIndex;
	}
}
