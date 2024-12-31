package iih.pi.card.util;

import java.util.ArrayList;
import java.util.List;

import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.mp.nr.dto.temporarytable.d.TamTableDataDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FType;
import xap.sys.appfw.orm.dataaccess.TmpTable;

/**
 * 临时表辅助类
 * @author wq.li
 *
 */
public class CreateTemTable {

	/**
	 * 创建基于TamTableColumnDTO列信息,TamTableDataDTO数据源
	 * 
	 * @param columns
	 * @param datas
	 * @return
	 * @throws BizException
	 */
	public String exec(String tableName, TamTableColumnDTO[] columns, TamTableDataDTO[] datas) throws BizException {

		// 1、参数校验
		validation(columns, datas);

		// 2、构建列属性
		List<String> listColumn = new ArrayList<String>();
		List<String> listColumntp = new ArrayList<String>();
		List<FType> listDatatp = new ArrayList<FType>();
		createColumnInfo(columns, listColumn, listColumntp, listDatatp);

		// 3、构建临时表数据
		List<List<Object>> listData = new ArrayList<List<Object>>();
		createRowData(datas, listData, listColumn.size());

		// 4、创建临时表
		createTable(tableName, listColumn, listColumntp, listDatatp, listData);

		return tableName;
	}

	/**
	 * 创建基于TamTableColumnDTO列信息,BaseDO数据源
	 * 
	 * @param tableName
	 * @param columns
	 * @param datas
	 * @return
	 * @throws BizException
	 */
	public String exec(String tableName, TamTableColumnDTO[] columns, BaseDO[] datas) throws BizException {

		// 1、参数校验
		validation(columns, datas);

		// 2、构建列属性
		List<String> listColumn = new ArrayList<String>();
		List<String> listColumntp = new ArrayList<String>();
		List<FType> listDatatp = new ArrayList<FType>();
		createColumnInfo(columns, listColumn, listColumntp, listDatatp);

		// 3、构建临时表数据
		List<List<Object>> listData = new ArrayList<List<Object>>();
		createRowDataByBaseDTO(datas, listData, listColumn);

		// 4、创建临时表
		createTable(tableName, listColumn, listColumntp, listDatatp, listData);

		return tableName;
	}

	/**
	 * 快捷创建20位字符串，基于BaseDO数据源的临时表
	 * 
	 * @param tableName
	 * @param columns
	 * @param datas
	 * @return
	 * @throws BizException
	 */
	public String exec(String tableName, String[] columns, BaseDO[] datas) throws BizException {

		// 1、参数校验
		validation(columns, datas);

		// 2、构建列属性
		List<String> listColumn = new ArrayList<String>();
		List<String> listColumntp = new ArrayList<String>();
		List<FType> listDatatp = new ArrayList<FType>();
		createColumnInfo(columns, listColumn, listColumntp, listDatatp);

		// 3、构建临时表数据
		List<List<Object>> listData = new ArrayList<List<Object>>();
		createRowDataByBaseDTO(datas, listData, listColumn);

		// 4、创建临时表
		createTable(tableName, listColumn, listColumntp, listDatatp, listData);

		return tableName;
	}

	/**
	 * 快捷创建单行单列，20位字符串的临时表
	 * 
	 * @param tableName
	 * @param column
	 * @param datas
	 * @return
	 */
	public String exec(String tableName, String column, Object[] datas) throws BizException {

		// 1、参数校验
		if (StringUtil.isEmptyWithTrim(column)) {
			throw new BizException("创建临时表，列信息空异常！");
		}
		if (datas == null || datas.length < 0) {
			throw new BizException("创建临时表，数据空异常！");
		}

		// 2、构建列属性
		List<String> listColumn = new ArrayList<String>();
		listColumn.add(column);
		List<String> listColumntp = new ArrayList<String>();
		listColumntp.add("VARCHAR2(20)");
		List<FType> listDatatp = new ArrayList<FType>();
		listDatatp.add(FType.String);

		// 3、构建临时表数据
		List<List<Object>> listData = new ArrayList<List<Object>>();
		createRowDataByObject(datas, listData);

		// 4、创建临时表
		createTable(tableName, listColumn, listColumntp, listDatatp, listData);

		return tableName;
	}

	/**
	 * 参数校验
	 * 
	 * @param columns
	 * @param datas
	 * @throws BizException
	 */
	private void validation(TamTableColumnDTO[] columns, BaseDO[] datas) throws BizException {
		if (columns == null || columns.length < 1) {
			throw new BizException("创建临时表，列信息空异常！");
		}
		if (datas == null || datas.length < 1) {
			throw new BizException("创建临时表，数据空异常！");
		}
		for (TamTableColumnDTO column : columns) {
			if (StringUtil.isEmptyWithTrim(column.getColumn())) {
				throw new BizException("创建临时表，列信息【列名】空异常！");
			}
			if (StringUtil.isEmptyWithTrim(column.getColumntp())) {
				throw new BizException("创建临时表，列信息【属性类型】空异常！");
			}
			if (column.getDatatp() == null || column.getDatatp().size() < 1) {
				throw new BizException("创建临时表，列信息【数据类型】空异常！");
			}
		}
	}

	/**
	 * 基础入参校验
	 * 
	 * @param columns
	 * @param datas
	 * @throws BizException
	 */
	private void validation(String[] columns, BaseDO[] datas) throws BizException {
		if (columns == null || columns.length < 1) {
			throw new BizException("创建临时表，列信息空异常！");
		}
		if (datas == null || datas.length < 1) {
			throw new BizException("创建临时表，数据空异常！");
		}
		for (String column : columns) {
			if (StringUtil.isEmptyWithTrim(column)) {
				throw new BizException("创建临时表，列信息【列名】空异常！");
			}
		}
	}

	/**
	 * 根据列DTO构建列属性
	 * 
	 * @param columns
	 * @param listColumn
	 * @param listColumntp
	 * @param listDatatp
	 */
	private void createColumnInfo(TamTableColumnDTO[] columns, List<String> listColumn, List<String> listColumntp, List<FType> listDatatp) {
		for (TamTableColumnDTO column : columns) {
			listColumn.add(column.getColumn());
			listColumntp.add(column.getColumntp());
			listDatatp.add((FType) column.getDatatp().get(0));
		}
	}

	/**
	 * 根据列名构建列属性：默认的类均为varchar(20)
	 * 
	 * @param columns
	 * @param listColumn
	 * @param listColumntp
	 * @param listDatatp
	 */
	private void createColumnInfo(String[] columns, List<String> listColumn, List<String> listColumntp, List<FType> listDatatp) {
		for (String column : columns) {
			listColumn.add(column);
			listColumntp.add("VARCHAR2(20)");
			listDatatp.add(FType.String);
		}
	}

	/**
	 * 构建临时表数据
	 * 
	 * @param datas
	 * @param listData
	 * @param lenColumn
	 * @throws BizException
	 */
	private void createRowData(TamTableDataDTO[] datas, List<List<Object>> listData, int lenColumn) throws BizException {
		if (new TamTableDataDTO().getAttrNames().length >= lenColumn) {
			for (TamTableDataDTO dataDTO : datas) {
				List<Object> list = new ArrayList<Object>();
				for (int i = 1; i <= lenColumn; i++) {
					Object obj = dataDTO.getAttrVal("Column" + i);
					if (obj == null || StringUtil.isEmptyWithTrim(obj.toString())) {
						break;// 数据集合中，遇见空置的情况立即停止
					}
					list.add(obj);
				}
				listData.add(list);
			}
		} else {
			throw new BizException("创建临时表，临时表列数量大于TamTableDataDTO列数量！");
		}
	}

	/**
	 * 基于BaseDO创建临时表数据
	 * 
	 * @param datas
	 * @param listData
	 * @param listColumn
	 * @throws BizException
	 */
	private void createRowDataByBaseDTO(BaseDO[] datas, List<List<Object>> listData, List<String> listColumn) throws BizException {
		String[] attNames = datas[0].getAttrNames();
		if (attNames.length >= listColumn.size()) {
			for (BaseDO baseDO : datas) {
				List<Object> listRow = new ArrayList<Object>();
				for (String columnName : listColumn) {
					Object obj = baseDO.getAttrVal(columnName);
					if (obj == null || StringUtil.isEmptyWithTrim(obj.toString())) {
						break;// DTO中有对应的列是空值
					}
					listRow.add(obj);
				}
				listData.add(listRow);
			}
		} else {
			throw new BizException("创建临时表，DTO列数量不能小于临时表列的数量！");
		}
	}

	/**
	 * 基于数组创建临时表数据
	 * 
	 * @param datas
	 * @param listData
	 * @param listColumn
	 * @throws BizException
	 */
	private void createRowDataByObject(Object[] datas, List<List<Object>> listData) throws BizException {
		List<Object> listRow = new ArrayList<Object>();
		for (Object obj : datas) {
			listRow.add(obj);
		}
		listData.add(listRow);
	}

	/**
	 * 创建临时表
	 * 
	 * @param tableName
	 * @param listColumn
	 * @param listColumntp
	 * @param listDatatp
	 * @param listData
	 * @return
	 */
	private String createTable(String tableName, List<String> listColumn, List<String> listColumntp, List<FType> listDatatp, List<List<Object>> listData) {
		TmpTable dao = new TmpTable();
		String[] arrayColumn = listColumn.toArray(new String[listColumn.size()]);
		String[] arrayColumntp = listColumntp.toArray(new String[listColumntp.size()]);
		FType[] arrayDatatp = listDatatp.toArray(new FType[listDatatp.size()]);
		String reName = dao.getTempTable(tableName, arrayColumn, arrayColumntp, arrayDatatp, listData);
		return reName;
	}
}
