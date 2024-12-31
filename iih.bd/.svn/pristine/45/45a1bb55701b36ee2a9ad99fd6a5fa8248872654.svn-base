package iih.bd.mm.materialnames.s.bp.queryer;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.s.bp.creater.MaterialNamesDOCreater;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import xap.mw.core.data.BizException;

/**
 * 药品通用名查询器
 * 
 * @author hao_wu
 *
 */
public class MaterialNamesQueryer {

	public static MaterialNamesDO findMaterialNamesBySrvId(String id) throws BizException {
		MedSrvDO medSrvDO = MedSrvQueryer.findMedSrvById(id);
		MedSrvDrugDO medSrvDrugDO = MedSrvQueryer.findMedSrvDrugBySrvId(id);
		MaterialNamesDO materialNamesDO = MaterialNamesDOCreater.createMaterialNamesDO(medSrvDO, medSrvDrugDO);
		return materialNamesDO;
	}
}
