package iih.bd.pp.hpsrvorca.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 到处医保目录对照_诊疗业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ExportMedicalInfoBp {

	public HPSrvorcaDO[] exec() throws BizException {
		HPSrvorcaDO[] result = ExportMedicalInfo();
		return result;
	}

	/**
	 * 导出诊疗字典
	 */
	@SuppressWarnings("unchecked")
	public HPSrvorcaDO[] ExportMedicalInfo() throws BizException {
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT BD_SRV.ID_SRV, BD_SRV.CODE AS HIS_CODE, BD_SRV.NAME AS HIS_NAME, BD_HP_SRVORCA.CODE ");
		sql.append(" FROM BD_SRV ");
		sql.append(" LEFT JOIN BD_HP_SRVORCA ");
		sql.append(" ON BD_SRV.ID_SRV = BD_HP_SRVORCA.ID_SRV ");
		sql.append(" WHERE BD_SRV.FG_BL = 'Y' ");
		sql.append(String.format(" AND BD_SRV.SD_SRVTP NOT LIKE '%s%%'; ", IBdSrvDictCodeConst.SD_SRVTP_DRUG));
		List<HPSrvorcaDO> list = (List<HPSrvorcaDO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(HPSrvorcaDO.class));
		return list.toArray(new HPSrvorcaDO[] {});
	}

}
