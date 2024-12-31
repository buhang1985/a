package iih.bd.mm.mmalert.bp;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class FindBlDataBp2 implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		SqlParam Param = new SqlParam();
		//Param.addParam(Context.get().getGroupId());
		//Param.addParam(Context.get().getOrgId());
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		
		return this._getQrySQLStr();
	}
	
	private String _getQrySQLStr() {
		
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append(" select count(mmwh.id_wh) quan_mm,mmwh.wh_name,mmwh.id_wh ");
		SqlStr.append(" from ");
		SqlStr.append(" (select wh.id_wh, mm.id_mm, wh.name wh_name, mm.code mm_code, mm.name mm_name, mm.factor_sb, sum(mm_wh.lowstnum) lownum, mm.name_unit_pkgsp from bd_mm_wh mm_wh ");
		SqlStr.append(" inner join bd_wh wh on mm_wh.id_wh = wh.id_wh ");
		SqlStr.append(" inner join bd_mm mm on mm.id_mm = mm_wh.id_mm ");
		SqlStr.append("  inner join MM_MCST mcst  on mcst.id_wh = mm_wh.id_wh ");
		SqlStr.append(" where wh.fg_active = 'Y' and wh.fg_last = 'Y'  and mcst.sd_mc = '1' and mm_wh.lowstnum is not null ");
		SqlStr.append(" and mm_wh.fg_active = 'Y' and mm_wh.fg_out = 'N' and mm.fg_active = 'Y' and mm.fg_out = 'N' ");
		SqlStr.append(" group by wh.id_wh, wh.name, mm.id_mm, mm.code, mm.name, mm.factor_sb, mm.name_unit_pkgsp) mmwh");
		SqlStr.append(" left join ");
		SqlStr.append(" (select id_wh, id_mm, sum(quan_stock) as quan, sum(quan_usable) as quan_usable from mm_bl where fg_expired = 'N' and fg_stop_chgpri = 'N' and fg_close = 'N' group by id_wh, id_mm) blmm ");
		SqlStr.append(" on mmwh.id_wh = blmm.id_wh and mmwh.id_mm = blmm.id_mm ");
		SqlStr.append(" where nvl(mmwh.lownum,0) <> 0 and (nvl(mmwh.lownum,0) >= nvl(blmm.quan,0) or nvl(mmwh.lownum,0) > = nvl(blmm.quan_usable,0)) ");
		SqlStr.append(" group by mmwh.id_wh,mmwh.wh_name ");
		SqlStr.append(" having count(mmwh.id_wh) > 0 ");
		SqlStr.append(" order by mmwh.id_wh ");
		return SqlStr.toString();
	}

}
