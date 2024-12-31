package iih.bd.mm.materialnames.s.bp.findbp;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.s.bp.creater.MaterialNamesDOCreater;
import iih.bd.mm.materialnames.s.bp.queryer.MedSrvQueryer;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据数据管控查询药品通用名列表业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindMaterialNamesBp {

	public MaterialNamesDO[] exec(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
		MedSrvDO[] medSrvDOs = MedSrvQueryer.findMedSrv(whereStr, orderStr, isLazy);
		MedSrvDrugDO[] medSrvDrugDOs = MedSrvQueryer.findMedSrvDrugByIds(medSrvDOs);
		MaterialNamesDO[] materialNameDOs = MaterialNamesDOCreater.createMaterialNamesDOs(medSrvDOs, medSrvDrugDOs);
		return materialNameDOs;
	}

}
