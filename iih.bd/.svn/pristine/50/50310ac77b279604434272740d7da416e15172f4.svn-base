package iih.bd.mm.meterial.bp;

import java.util.List;

import iih.bd.mm.meterial.d.MMPackageUnitDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class MeterialUnitBp {

	public MMPackageUnitDO getMeterialAndUnit(String id_mm, String id_mmsmc) throws DAException {
		if(id_mm != null && id_mmsmc != null){
			StringBuffer sb = new StringBuffer();
			sb.append(" select pkgu.*, mm.name as mm_name, mm.code as mm_code ");
			sb.append(" from BD_MM_PKGU pkgu, BD_MM mm ");
			sb.append(" where pkgu.ID_MM = mm.ID_MM ");
			sb.append(" and pkgu.ID_MM = '" + id_mm + "' ");
			sb.append(" and pkgu.ID_MMPKGUTP = (SELECT id_mmpkgutp ");
			sb.append("  						FROM BD_WH_PKGUTP ");
			sb.append(" 						WHERE id_wh =(SELECT id_wh ");
			sb.append(" 									  FROM BD_MM_SMC ");
			sb.append(" 								      WHERE id_mmsmc = '" + id_mmsmc + "') ");
			sb.append(" 									  AND fg_def = 'Y') ");
			List<MMPackageUnitDO> list = (List<MMPackageUnitDO>) new DAFacade().execQuery(sb.toString(), new BeanListHandler(MMPackageUnitDO.class));
			if(list != null && list.size() > 0){
				return list.get(0);
			}
		}
		return null;
	}

}
