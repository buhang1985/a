package iih.bd.mm.meterial.bp.qry;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetQuickAddMmItemSql implements ITransQry {

	private String Id_mmca;
	private boolean IsRecursive;
	private String Innercode;
	private String InWhouseID;
	private String OutWhouseID;
	private boolean IsStockBl;
	
	public GetQuickAddMmItemSql(String id_mmca, boolean isRecursive, String innercode, 
			String inWhouseID, String outWhouseID, boolean isStockBl) throws BizException {
		
		this.Id_mmca = id_mmca;
		this.IsRecursive = isRecursive;
		this.Innercode = innercode;
		this.InWhouseID = inWhouseID;
		this.OutWhouseID = outWhouseID;
		this.IsStockBl = isStockBl;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam Param = new SqlParam();
		if(!StringUtils.isBlank(this.InWhouseID)) {
			
			Param.addParam(this.InWhouseID);
		}
		if(!StringUtils.isBlank(this.OutWhouseID)) {
			
			Param.addParam(this.OutWhouseID);
		}
		if(this.IsStockBl) {
			
			Param.addParam(this.OutWhouseID);
		}
		if(!this.IsRecursive) {
			
			Param.addParam(this.Id_mmca);
		} else {
			
			Param.addParam(this.Innercode + "%");
		}
		return Param;
	}

	@Override
	public String getQrySQLStr() {

		return this._getQrySQLStr();
	}
	
	private String _getQrySQLStr() {
		
		StringBuffer SqlStr = new StringBuffer();
		
		SqlStr.append(" select distinct a.id_mm, a.id_org, f.name org_name, a.id_mmtp, g.name mmtp_name, a.id_mmca, h.name mmca_name, ");
		SqlStr.append(" a.code, a.name, a.spec from bd_mm a ");
		SqlStr.append(" inner join bd_mmca b on a.id_mmca = b.id_mmca ");
		if(!StringUtils.isBlank(this.InWhouseID)) {
			
			SqlStr.append(" inner join bd_mm_wh c on a.id_mm = c.id_mm and c.fg_active = 'Y' and c.id_wh = ? ");
		}
		if(!StringUtils.isBlank(this.OutWhouseID)) {
			
			SqlStr.append(" inner join bd_mm_wh d on a.id_mm = d.id_mm and d.fg_active = 'Y' and d.id_wh = ?  ");
		}
		if(this.IsStockBl) {
			
			SqlStr.append(" inner join mm_bl e on a.id_mm = e.id_mm and e.id_wh = ?  and e.quan_usable > 0 ");
			SqlStr.append(" and e.fg_stop = 'N' and e.fg_expired = 'N' and e.fg_stop_chgpri = 'N' and e.fg_close = 'N' ");
		}
		SqlStr.append(" left join bd_org f on f.id_org = a.id_org ");
		SqlStr.append(" left join bd_udidoc g on g.id_udidoc = a.id_mmtp ");
		SqlStr.append(" left join bd_mmca h on h.id_mmca = a.id_mmca ");
		SqlStr.append(" where a.fg_active = 'Y' ");
		if(!this.IsRecursive) {
			
			SqlStr.append(" and b.id_mmca = ? ");
		} else {
			
			SqlStr.append(" and b.innercode like ? ");
		}
		SqlStr.append(" order by a.code ");
		
		return SqlStr.toString();
	}
}
