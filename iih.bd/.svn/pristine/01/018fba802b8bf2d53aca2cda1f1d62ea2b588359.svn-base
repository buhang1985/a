package iih.bd.pp.hpsrvorca.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 导出医保目录对照_药品业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ExportDrugsInfoBp {

	public HPSrvorcaDO[] exec() throws BizException {
		HPSrvorcaDO[] result = ExportDrugsInfo();
		return result;
	}

	/**
	 * 导出药品字典
	 */
	@SuppressWarnings("unchecked")
	public HPSrvorcaDO[] ExportDrugsInfo() throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT BD_SRV.ID_SRV, ");
		sql.append(" BD_MM.ID_MM, ");
		sql.append(" BD_MM.CODE AS HIS_CODE, ");
		sql.append(" BD_SRV.NAME AS HIS_NAME, ");
		sql.append(" BD_HP_SRVORCA.CODE, ");
		sql.append(" BD_MM.SPEC AS MM_SPEC, ");
		sql.append(" BD_MEASDOC.NAME AS MM_UNIT_PKGBASE, ");
		sql.append(" nvl((ceil((BD_MM.price *PKGU.factor / BD_MM.factor_sb) * 10000) / 10000),0) AS MM_PRICE, ");
		sql.append(" BD_SRV.SD_SRVTP AS SD_HPSRVTP");
		sql.append(" FROM ");
		sql.append(" BD_MM ");
		sql.append(" LEFT JOIN BD_SRV  ON BD_MM.ID_SRV = BD_SRV.ID_SRV ");
		sql.append(" LEFT JOIN BD_HP_SRVORCA ON BD_MM.ID_MM = BD_HP_SRVORCA.ID_MM ");
		sql.append(" LEFT JOIN BD_MEASDOC ON BD_MEASDOC.ID_MEASDOC = BD_MM.ID_UNIT_PKGBASE ");
		sql.append(" LEFT JOIN BD_MM_PKGU PKGU on BD_MM.id_mm = PKGU.id_mm  ");
		sql.append(" WHERE ");
		sql.append(
				" PKGU.en_oppkgtp = (select min(en_oppkgtp) from bd_mm_pkgu where id_mm = BD_MM.id_mm group by id_mm) ");
		sql.append(" AND BD_MM.ID_SRV IS NOT NULL ");
		sql.append(" AND BD_MM.ID_SRV != '~' ");
		sql.append(" AND BD_SRV.FG_MM = 'Y' ");
		sql.append(String.format(" AND BD_SRV.SD_SRVTP LIKE '%s%%' ", IBdSrvDictCodeConst.SD_SRVTP_DRUG));
		sql.append(" AND BD_SRV.FG_BL = 'Y'; ");
		List<HPSrvorcaDO> list = (List<HPSrvorcaDO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(HPSrvorcaDO.class));
		return list.toArray(new HPSrvorcaDO[] {});
	}

}
