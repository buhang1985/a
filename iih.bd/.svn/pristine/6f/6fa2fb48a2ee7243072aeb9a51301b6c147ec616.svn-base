package iih.bd.pp.s.external.provide.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询分页列表SQL
 * 
 * @author hao_wu 2018-6-12
 *
 */
public class FindPageListQry implements ITransQry {

	private ITransQry _qry;
	private Integer _pageSize;
	private Integer _pageIndex;

	/**
	 * 根据搜索文本查询诊疗价格分页列表
	 * 
	 * @param searchText
	 *            搜索文本
	 * @param pageSize
	 *            页大小
	 * @param pageIndex
	 *            页索引：从0开始
	 */
	public FindPageListQry(ITransQry qry, Integer pageSize, Integer pageIndex) {
		this._qry = qry;
		this._pageSize = pageSize;
		this._pageIndex = pageIndex;
	}

	@Override
	public String getQrySQLStr() {
		String sqlStr = this._qry.getQrySQLStr();

		return String.format(
				"select * from ( select row_.*, rownum rownum_ from (%s) row_ where rownum <= ? ) where rownum_ > ?",
				sqlStr);
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = this._qry.getQryParameter(arg0);

		Integer rRowNum = (this._pageIndex + 1) * this._pageSize;
		Integer lRowNum = this._pageIndex * this._pageSize;
		sqlParam.addParam(rRowNum);
		sqlParam.addParam(lRowNum);

		return sqlParam;
	}
}
