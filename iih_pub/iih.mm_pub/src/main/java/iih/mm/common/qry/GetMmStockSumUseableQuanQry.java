package iih.mm.common.qry;

import iih.mm.bl.stockbl.d.StockBlDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMmStockSumUseableQuanQry implements ITransQry {
	
	private StockBlDO[] stockblList;
	
	public GetMmStockSumUseableQuanQry(StockBlDO[] stockblList) {
		this.stockblList = stockblList;
	}
	
	
	@Override
	public SqlParam getQryParameter(StringBuffer whrStr) {
		SqlParam Param = new SqlParam();
		whrStr.append(" where (1<>1 ");
		for(StockBlDO stockBlDO : stockblList) {
			whrStr.append(String.format(" or (%s.id_wh = ? and %s.id_mm = ?) ", "mm_bl", "mm_bl"));
			Param.addParam(stockBlDO.getId_wh());
			Param.addParam(stockBlDO.getId_mm());
		}
		whrStr.append(" ) ");
		whrStr.append(" and mm_bl.quan_usable >= 1 ");
		whrStr.append(" and nvl(mm_bl.fg_stop_chgpri, 'N') = 'N' ");
		whrStr.append(" and nvl(mm_bl.fg_stop, 'N') = 'N' ");
		whrStr.append(" and nvl(mm_bl.fg_expired, 'N') = 'N' ");
		whrStr.append(" and nvl(mm_bl.fg_close, 'N') = 'N' ");
		whrStr.append(" and mm_bl.ds = 0 ");
		whrStr.append(" group by mm_bl.id_wh, mm_bl.id_mm ");
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		return this._getQrySQLStr();
	}
	
	private String _getQrySQLStr() {
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append(" select ");
		SqlStr.append(" mm_bl.id_wh id_dep, ");
		SqlStr.append(" mm_bl.id_mm, ");
		SqlStr.append(" sum(mm_bl.quan_usable) quan_usable ");
		SqlStr.append(" from mm_bl ");
		SqlStr.append(" inner join bd_wh ");
		SqlStr.append(" on mm_bl.id_wh = bd_wh.id_wh ");
		return SqlStr.toString();
	}
}
