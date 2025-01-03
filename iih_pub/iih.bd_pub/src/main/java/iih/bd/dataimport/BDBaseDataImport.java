package iih.bd.dataimport;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.utils.log.BdImportLogUtils;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.i.IAttrDesc;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * BD数据导入类
 * 
 * @author hao_wu 2018-12-11
 *
 * @param <T>
 */
public abstract class BDBaseDataImport<T extends BaseDO> extends BaseDataImport<T> implements IDataImport {

	// 基础数据信息接口_集团主键
	private final String BdDataInfoItf_GrpId = "id_group";
	// 基础数据信息接口_组织主键
	private final String BdDataInfoItf_OrgId = "id_org";

	/**
	 * 非空属性检查
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean checkNotNull() throws BizException {
		String doClassName = this.getDoInstance().getDOClassName();
		BdImportLogUtils.info("开始非空属性检查，全类名：%s", doClassName);
		try {
			// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
			T[] DOS = getDOsFromImportDB(this.getDoInstance(), "1=1", false);
			if (ArrayUtils.isEmpty(DOS)) {
				throwImportDataNullEx();
			}

			// 检查非空属性
			checkNotNullProp(DOS);
		} catch (Exception e) {
			BdImportLogUtils.logExAndTitle(e, "非空属性检查异常，全类名：%s", doClassName);
			throw e;
		}
		BdImportLogUtils.info("非空属性检查完成，全类名：%s", doClassName);
		return true;
	}

	/**
	 * 业务校验
	 */
	public boolean checkBusiness() throws BizException {
		String doClassName = this.getDoInstance().getDOClassName();
		BdImportLogUtils.info("开始业务校验，全类名：%s", doClassName);
		try {
			// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
			T[] importDatas = getDOsFromImportDB(this.getDoInstance(), "1=1", false);
			if (ArrayUtils.isEmpty(importDatas)) {
				throwImportDataNullEx();
			}

			// 2、数据校验
			checkImportData(importDatas);
		} catch (Exception e) {
			BdImportLogUtils.logExAndTitle(e, "业务校验异常，全类名：%s", doClassName);
			throw e;
		}

		BdImportLogUtils.info("业务校验完成，全类名：%s", doClassName);

		return true;
	}

	/**
	 * 导入数据
	 * 
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean importData() throws BizException {

		BaseDO doData = this.getDoInstance();
		String className = doData.getClass().getName();

		BdImportLogUtils.info("数据导入开始。全类名:%s", className);

		Map<String, String> bdDataInfoMap = doData.getDODesc().getIBDDataInfoFldMap();
		String wherePart = "1 = 1";
		if (bdDataInfoMap != null && bdDataInfoMap.containsKey(this.BdDataInfoItf_OrgId)
				&& bdDataInfoMap.containsKey(this.BdDataInfoItf_GrpId)
				&& StringUtils.isNotBlank(bdDataInfoMap.get(this.BdDataInfoItf_OrgId))
				&& StringUtils.isNotBlank(bdDataInfoMap.get(this.BdDataInfoItf_GrpId))) {

			BdImportLogUtils.info("元数据已实现基础数据接口，开始分组导入。全类名：%s", className);

			// 实现基础数据接口，按照集团和组织分组导入数据
			String grpFieldName = bdDataInfoMap.get(this.BdDataInfoItf_GrpId);
			String orgFieldName = bdDataInfoMap.get(this.BdDataInfoItf_OrgId);

			grpFieldName = grpFieldName.toLowerCase();
			orgFieldName = orgFieldName.toLowerCase();

			String tableName = this.getDoInstance().getTableName();
			tableName = String.format("%s_2XAP", tableName);

			String sql = String.format("select %s,%s from %s group by %s,%s", grpFieldName, orgFieldName, tableName,
					grpFieldName, orgFieldName);
			DAFacade daFacade = new DAFacade();
			List<Map<String, Object>> dataList = (List<Map<String, Object>>) daFacade.execQuery(sql,
					new MapListHandler());
			for (Map<String, Object> data : dataList) {
				String grpId = (String) data.get(grpFieldName);
				String orgId = (String) data.get(orgFieldName);
				Context.get().setGroupId(grpId);
				Context.get().setOrgId(orgId);

				BdImportLogUtils.info("开始分组导入。全类名:%s,集团字段名称:%s,组织字段名称:%s,集团主键:%s,组织主键:%s",
						this.getDoInstance().getClass().getName(), grpFieldName, orgFieldName, grpId, orgId);

				wherePart = String.format("%s = '%s' and %s = '%s'", grpFieldName, grpId, orgFieldName, orgId);
				importUpdateData(wherePart);
				importNewData(wherePart);

				BdImportLogUtils.info("分组导入完成。全类名:%s,集团字段名称:%s,组织字段名称:%s,集团主键:%s,组织主键:%s",
						this.getDoInstance().getClass().getName(), grpFieldName, orgFieldName, grpId, orgId);
			}
		} else {
			BdImportLogUtils.info("元数据未实现基础数据接口，开始全部导入。全类名：%s", className);

			importUpdateData(wherePart);
			importNewData(wherePart);
		}

		BdImportLogUtils.info("数据导入完成。全类名:%s", this.getDoInstance().getClass().getName());

		return true;
	}

	/**
	 * 导入更新的数据</br>
	 * 因XAP未提交sdlanling2，所以暂时注释此方法体
	 * 
	 * @throws BizException
	 */
	private void importUpdateData(String wherePart) throws BizException {
		String doClassName = this.getDoInstance().getDOClassName();
		BdImportLogUtils.info("开始导入更新的数据,全类名:%s,条件语句:%s,", doClassName, wherePart);

		// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		T[] importDatas = getDOsFromUpdateDB(getDoInstance(), wherePart);
		if (ArrayUtils.isEmpty(importDatas)) {
			BdImportLogUtils.info("未查询到需要导入更新的数据,全类名:%s,条件语句:%s,", doClassName, wherePart);
			return;
		}

		String msg = String.format("导入更新的数据,全类名:%s,条件语句:%s,获取到需更新数据条数为：%s.", doClassName, wherePart,
				importDatas.length);
		BdImportLogUtils.info(msg);

		// 2、状态改为Update
		processUpdateDOs(importDatas);

		// 3、移除控制字符
		removeControlCharacter(importDatas);

		// 4、更新导入后的数据
		updateImportUpdateData(importDatas);

		msg = String.format("导入更新的数据,全类名:%s,条件语句:%s,更新数据库中的数据条数为：%s.", doClassName, wherePart, importDatas.length);
		BdImportLogUtils.info(msg);

		// 5、调用框架的新增方法(其中包括管控唯一性校验等)更新目标库
		this.updateToDB(importDatas);

		BdImportLogUtils.info("导入更新的数据完成,全类名:%s,条件语句:%s,", doClassName, wherePart);
	}

	/**
	 * 导入新增的数据
	 * 
	 * @param wherePart
	 * @throws BizException
	 */
	private void importNewData(String wherePart) throws BizException {
		String doClassName = this.getDoInstance().getDOClassName();
		BdImportLogUtils.info("开始导入新增的数据,全类名:%s,条件语句:%s,", doClassName, wherePart);

		// 1、导入临时库得到需要导入目标库的数据,此数据是数据源为 import 的库获得
		T[] importDatas = getDOsFromImportDB(getDoInstance(), wherePart, true);
		if (ArrayUtils.isEmpty(importDatas)) {
			BdImportLogUtils.info("未查询到需要导入新增的数据,全类名:%s,条件语句:%s,", doClassName, wherePart);
			return;
		}

		String msg = String.format("导入新增的数据,全类名:%s,条件语句:%s,获取到需导入数据条数为：%s.", doClassName, wherePart,
				importDatas.length);
		BdImportLogUtils.info(msg);

		// 2、状态改为New
		processDOs(importDatas);

		// 3、移除控制字符
		removeControlCharacter(importDatas);

		// 4、更新导入后的数据
		updateImportNewData(importDatas);

		msg = String.format("导入新增的数据,全类名:%s,条件语句:%s,导入数据库中的数据条数为：%s.", doClassName, wherePart, importDatas.length);
		BdImportLogUtils.info(msg);

		// 5、调用框架的新增方法(其中包括管控唯一性校验等)插入目标库
		this.insertToDB(importDatas);

		BdImportLogUtils.info("导入新增的数据完成,全类名:%s,条件语句:%s,", doClassName, wherePart);
	}

	/**
	 * 移除导入数据中的控制字符
	 * 
	 * @param importDatas
	 */
	private void removeControlCharacter(T[] importDatas) {
		BaseDO baseDo = this.getDoInstance();
		String[] attrNames = baseDo.getAttrNames();
		for (String attrName : attrNames) {
			IAttrDesc attrDesc = baseDo.getDODesc().getAttrDesc(attrName);
			FType fType = attrDesc.getJavaType();
			if (!FType.String.equals(fType)) {
				continue;
			}

			removeControlCharacter(importDatas, attrName);
		}
	}

	/**
	 * 移除导入数据指定属性中的控制字符
	 * 
	 * @param importDatas
	 * @param attrName
	 */
	private void removeControlCharacter(T[] importDatas, String attrName) {
		for (T importData : importDatas) {
			Object attrValue = importData.getAttrVal(attrName);
			if (attrValue == null) {
				continue;
			}

			String attrStrValue = (String) attrValue;

			attrStrValue = removeControlCharacter(attrStrValue, attrName);
			importData.setAttrVal(attrName, attrStrValue);
		}
	}

	/**
	 * 移除属性值中的控制字符
	 * 
	 * @param attrStrValue
	 * @return
	 */
	private String removeControlCharacter(String attrStrValue, String attrName) {
		if (StringUtils.isBlank(attrStrValue)) {
			return null;
		}

		String doClassName = this.getDoInstance().getDOClassName();

		char[] chs = attrStrValue.toCharArray();
		StringBuilder attrStrValueBuilder = new StringBuilder();
		for (char ch : chs) {
			if ('\r' == ch || '\n' == ch || '\t' == ch) {
				// 换行和制表符，和中间件序列化保持一致
				attrStrValueBuilder.append(ch);
				continue;
			}

			if (ch >= 0 && ch <= 31) {
				String msg = String.format("全类名:%s,包含控制字符，属性名：%s,控制字符ASCII码：%s.", doClassName, attrName, (int) ch);
				BdImportLogUtils.info(msg);
				continue;
			}

			if (ch == 127) {
				String msg = String.format("全类名:%s,包含控制字符，属性名：%s,控制字符ASCII码：%s.", doClassName, attrName, (int) ch);
				BdImportLogUtils.info(msg);
				continue;
			}

			attrStrValueBuilder.append(ch);
		}

		return attrStrValueBuilder.toString();
	}

	/**
	 * 清理数据
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean cleanData() throws BizException {
		String doClassName = this.getDoInstance().getDOClassName();

		BdImportLogUtils.info("开始清理数据。全类名:%s", doClassName);
		String sql = String.format("delete from %s where %s not like '@@@@%%'", this.getDoInstance().getTableName(),
				this.getDoInstance().getPKFieldName());

		DAFacade daFacade = new DAFacade();
		int rowCount = daFacade.execUpdate(sql);

		BdImportLogUtils.info("清理数据完成。全类名:%s,清理行数:%s", doClassName, rowCount);

		return true;
	}

	/**
	 * 获取导入表名
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public String[] getImportTable() throws BizException {
		return new String[] { this.getDoInstance().getTableName() };
	}

	/**
	 * 抛出导入数据为空的异常
	 * 
	 * @throws BizException
	 */
	private void throwImportDataNullEx() throws BizException {
		String msg = String.format("%s导入数据为空！", this.getDoInstance().getDODesc().getLabel());
		throw new BizException(msg);
	}

	/**
	 * 获取DO实例
	 * 
	 * @return
	 */
	protected abstract BaseDO getDoInstance();

	/**
	 * 获取要检查空的属性值
	 * 
	 * @return
	 */
	protected abstract String[] getCheckNullProps();

	/**
	 * 检查非空属性
	 * 
	 * @param importData
	 * @throws BizException
	 */
	protected void checkNotNullProp(T[] importData) throws BizException {
		// 空值校验
		checkNullValue(Arrays.asList(this.getCheckNullProps()), importData);
	}

	/**
	 * 检查导入数据正确性
	 * 
	 * @param importDatas
	 * @throws BizException
	 */
	protected void checkImportData(T[] importDatas) throws BizException {

	}

	/**
	 * 更新导入的新数据
	 * 
	 * @param importDatas
	 */
	protected void updateImportNewData(T[] importDatas) throws BizException {

	}

	/**
	 * 更新导入的更新数据
	 * 
	 * @param importDatas
	 * @throws BizException
	 */
	protected void updateImportUpdateData(T[] importDatas) throws BizException {

	}

	/**
	 * 插入导入的数据到数据库
	 * 
	 * @param importDatas
	 * @throws BizException
	 */
	protected abstract void insertToDB(T[] importDatas) throws BizException;

	/**
	 * 更新导入的数据到数据库
	 * 
	 * @param importDatas
	 * @throws BizException
	 */
	protected abstract void updateToDB(T[] importDatas) throws BizException;
}
