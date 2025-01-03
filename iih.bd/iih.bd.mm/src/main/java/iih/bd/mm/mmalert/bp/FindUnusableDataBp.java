package iih.bd.mm.mmalert.bp;

import iih.mm.common.MMParams;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class FindUnusableDataBp implements ITransQry {
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		SqlParam Param = new SqlParam();
		try {
			Param.addParam(MMParams.MMDG0016());
			Param.addParam(MMParams.MMDG0007());
			Param.addParam(MMParams.MMDG0016());
			Param.addParam(MMParams.MMDG0007());
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		
		return this._getQrySQLStr();
	}
	
    private String _getQrySQLStr() {
		
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append(" select * from ( ");
		SqlStr.append(" select ");
		SqlStr.append(" bd_wh.id_wh, ");
		SqlStr.append(" bd_wh.name wh_name, ");
		SqlStr.append(" bd_mm.id_mm, ");
		SqlStr.append(" bd_mm.name mm_name, ");
		SqlStr.append(" bd_mm.code mm_code, ");
		SqlStr.append(" bd_mm.spec mm_spec, ");
		SqlStr.append(" bd_mm.printname, ");
		SqlStr.append(" srv.name as srv_name, ");
		SqlStr.append(" bd_mm.sup_name, ");
		SqlStr.append(" mm_bl.batch, ");
		SqlStr.append(" mm_bl.date_expi, ");
		SqlStr.append(" NVL2(DEFPKG.ID_MMPKGU, DEFPKG.Mmpkguname, SALEPKG.Mmpkguname) as Mmpkguname, ");
		SqlStr.append(" sum(NVL2(DEFPKG.ID_MMPKGU, MM_BL.QUAN_STOCK/DEFPKG.FACTOR, MM_BL.QUAN_STOCK/SALEPKG.FACTOR)) as Quan_stockact, ");
		SqlStr.append(" round(sysdate - to_date(nvl(recent_out_info.dt_st_short, ?), 'yyyy-mm-dd')) unusa_day ");
		SqlStr.append(" from mm_bl ");
		SqlStr.append(" left join bd_mm ");
		SqlStr.append(" on mm_bl.id_mm = bd_mm.id_mm ");
		SqlStr.append(" left join bd_srv srv ");
		SqlStr.append(" on bd_mm.id_srv = srv.id_srv ");
		SqlStr.append(" left join  ");
		SqlStr.append(" ( ");
		SqlStr.append(" select ");
		SqlStr.append(" id_bl ");
		SqlStr.append(" from mm_out_itm itm ");
		SqlStr.append(" left join mm_out on mm_out.id_out = itm.id_out ");
		SqlStr.append(" where mm_out.sd_sttp = '24' ");
		SqlStr.append(" and sysdate - to_date(mm_out.dt_st_short, 'yyyy-mm-dd') <= ? ");
		SqlStr.append(" ) out_info ");
		SqlStr.append(" on mm_bl.id_bl = out_info.id_bl ");
		SqlStr.append(" left join  ");
		SqlStr.append(" ( ");
		SqlStr.append(" select ");
		SqlStr.append(" id_bl, ");
		SqlStr.append(" max(mm_out.dt_st_short) dt_st_short ");
		SqlStr.append(" from mm_out_itm itm ");
		SqlStr.append(" left join mm_out on mm_out.id_out = itm.id_out ");
		SqlStr.append(" where mm_out.sd_sttp = '24' ");
		SqlStr.append(" group by id_bl ");
		SqlStr.append(" ) recent_out_info ");
		SqlStr.append(" on mm_bl.id_bl = recent_out_info.id_bl ");
		SqlStr.append(" left join bd_wh ");
		SqlStr.append(" on mm_bl.id_wh = bd_wh.id_wh ");
		SqlStr.append(" left outer join BD_MM_PKGU SALEPKG ");
		SqlStr.append(" on SALEPKG.ID_MM = BD_MM.ID_MM ");
		SqlStr.append(" and SALEPKG.ID_UNIT_PKG = BD_MM.ID_UNIT_PKGSP ");
		SqlStr.append(" and SALEPKG.SD_MMPKGUPRO = '1' ");
		SqlStr.append(" left outer join BD_WH_PKGUTP ");
		SqlStr.append(" on BD_WH_PKGUTP.ID_WH = MM_BL.ID_WH ");
		SqlStr.append(" and BD_WH_PKGUTP.FG_DEF = 'Y' ");
		SqlStr.append(" and BD_WH_PKGUTP.DS = 0 ");
		SqlStr.append(" left outer join BD_MM_PKGU DEFPKG ");
		SqlStr.append(" on DEFPKG.ID_MM = BD_MM.ID_MM ");
		SqlStr.append(" and DEFPKG.ID_MMPKGUTP = BD_WH_PKGUTP.ID_MMPKGUTP ");
		SqlStr.append(" where mm_bl.quan_stock > 0 ");
		SqlStr.append(" and mm_bl.fg_expired = 'N' ");
		SqlStr.append(" and mm_bl.fg_stop_chgpri = 'N' ");
		SqlStr.append(" and mm_bl.fg_close = 'N' ");
		SqlStr.append(" and nvl(out_info.id_bl, '~') = '~' ");
		SqlStr.append(" and bd_mm.fg_active = 'Y' and bd_mm.fg_out = 'N' ");
		SqlStr.append(" and bd_wh.sd_whtp = '02' ");
		SqlStr.append(" and sysdate - to_date(?, 'yyyy-mm-dd') >= ? ");
		SqlStr.append(" group by bd_wh.id_wh,bd_wh.name,bd_mm.id_mm,bd_mm.name, ");
		SqlStr.append(" bd_mm.code,bd_mm.spec,bd_mm.printname,srv.name,bd_mm.sup_name,NVL2(DEFPKG.ID_MMPKGU, DEFPKG.Mmpkguname, SALEPKG.Mmpkguname), ");
		SqlStr.append(" mm_bl.batch,mm_bl.date_expi,recent_out_info.dt_st_short ");
		SqlStr.append(" ) ");
		SqlStr.append(" where Quan_stockact > 1 ");
		SqlStr.append(" order by wh_name, mm_name, mm_code,Quan_stockact ");
		
		return SqlStr.toString();
    }
}
