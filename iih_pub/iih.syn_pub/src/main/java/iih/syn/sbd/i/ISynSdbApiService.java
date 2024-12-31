package iih.syn.sbd.i;

import java.util.HashMap;
import java.util.List;

import iih.syn.sbd.dto.export.d.ExportColumnDTO;
import iih.syn.sbd.dto.expscript.d.ScriptListDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;

public interface ISynSdbApiService {

	/**
	 * 导出方案对应脚本
	 * @return
	 * @throws BizException
	 */
	public abstract String exportConponentScript(String[] id_components) throws BizException;

	/**
	 * 导出实体对应脚本
	 * @return
	 * @throws BizException
	 */
	public abstract String exportEntryScript(String[] id_classs) throws BizException;

	/**
	 * 导出实体对应参照脚本
	 * @return
	 * @throws BizException
	 */
	public abstract String exportRefByEntryScript(String id_class) throws BizException;

	/**
	 * 导出护理文书对应脚本
	 * @return
	 * @throws BizException
	 */
	public abstract String exportNmrScript(String[] id_sets) throws BizException;

	/**
	 * 导出功能菜单对应脚本
	 * @return
	 * @throws BizException
	 */
	public abstract String exportFuncScript(String[] func_codes) throws BizException;

	/**
	 * 综合导出脚本
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract String exportScript(ScriptListDTO[] params) throws BizException;

	/**
	 * 获取表的列信息
	 * @param tableNames
	 * @param dsName
	 * @return
	 * @throws BizException
	 */
	public abstract ExportColumnDTO[] getTableColumnInfo(String[] tableNames, String dsName) throws BizException;

	/**
	 * 获取表数据
	 * @param dsName数据源名称
	 * @param tableName表名
	 * @param attr属性名称
	 * @param vals属性值
	 * @return
	 * @throws BizException
	 */
	public abstract List<HashMap<String, Object>> getTableDatas(String dsName, String tableName, String attr, String[] vals) throws BizException;

	/**
	 * 获取Insert语句
	 * @param table_name表名
	 * @param columns列信息
	 * @param datas数据
	 * @return
	 * @throws BizException
	 */
	public abstract String getInsertSqlWithMap(String table_name, List<ExportColumnDTO> columns, List<HashMap<String, Object>> datas, String endChar) throws BizException;
	
	/**
	 * 获取Insert语句
	 * @param table_name表名
	 * @param columns列信息
	 * @param datas数据
	 * @return
	 * @throws BizException
	 */
	public abstract String getInsertSqlWithDO(String table_name, List<ExportColumnDTO> columns, BaseDO[] datas, String endChar) throws BizException;

	/**
	 * 获取删除语句
	 * @param table_name表名
	 * @param attr属性
	 * @param vals值
	 * @return
	 * @throws BizException
	 */
	public abstract String getDeleteSql(String table_name, String attr, String[] vals, String endChar) throws BizException;
}
