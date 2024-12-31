package iih.bd.mm.materialnames.s.bp.savebp;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.s.bp.creater.MaterialNamesDOCreater;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.utils.BdSrvParamUtils;
import xap.mw.core.data.BizException;

/**
 * 保存药品通用名业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveMaterialNamesDOBp {

	public MaterialNamesDO[] exec(MaterialNamesDO[] dos) throws BizException {
		BdSrvParamUtils.setCheckRouteFlag(false);
		MedSrvDO[] medSrvDos = saveMedSrvDO(dos);
		BdSrvParamUtils.setCheckRouteFlag(true);
		MedSrvDrugDO[] medSrvDrugDos = saveMedSrvDrugDO(dos);
		MaterialNamesDO[] rtn = MaterialNamesDOCreater.createMaterialNamesDOs(medSrvDos, medSrvDrugDos);
		return rtn;
	}

	/**
	 * 保存医疗服务主数据
	 * 
	 * @param dos
	 * @return
	 * @throws BizException
	 */
	private MedSrvDrugDO[] saveMedSrvDrugDO(MaterialNamesDO[] dos) throws BizException {
		SaveMedSrvDrugDOBp bp = new SaveMedSrvDrugDOBp();
		MedSrvDrugDO[] rtn = bp.exec(dos);
		return rtn;
	}

	/**
	 * 保存医疗服务药品属性
	 * 
	 * @param dos
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] saveMedSrvDO(MaterialNamesDO[] dos) throws BizException {
		SaveMedSrvDOBp bp = new SaveMedSrvDOBp();
		MedSrvDO[] rtn = bp.exec(dos);
		return rtn;
	}

}
