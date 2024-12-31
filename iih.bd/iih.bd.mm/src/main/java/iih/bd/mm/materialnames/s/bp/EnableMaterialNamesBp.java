package iih.bd.mm.materialnames.s.bp;

import java.util.ArrayList;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.adapter.MaterialNamesDOAdapter;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.ext.IMedSrvEnableService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 启用药品通用名业务逻辑
 * 
 * @author hao_wu
 *
 */
public class EnableMaterialNamesBp {

	public MaterialNamesDO[] exec(MaterialNamesDO[] materialNamesDOs) throws BizException {
		if (materialNamesDOs == null || materialNamesDOs.length <= 0) {
			return null;
		}

		MaterialNamesDO[] result = EnableMaterialNames(materialNamesDOs);

		return result;
	}

	/**
	 * 启用药品通用名
	 * 
	 * @param materialNamesDOs
	 * @return
	 * @throws BizException
	 */
	private MaterialNamesDO[] EnableMaterialNames(MaterialNamesDO[] materialNamesDOs) throws BizException {
		MedSrvDO[] medSrvDOs = ConvertToMedSrvList(materialNamesDOs);

		MedSrvDO[] result = EnableMedSrv(medSrvDOs);

		MaterialNamesDO[] materialNamesArr = ConvertToMaterialNames(result, materialNamesDOs);
		return materialNamesArr;
	}

	/**
	 * 使用医疗服务和原药品通用名生成新的药品通用名
	 * 
	 * @param result
	 * @param materialNamesDOs
	 * @return
	 */
	private MaterialNamesDO[] ConvertToMaterialNames(MedSrvDO[] result, MaterialNamesDO[] materialNamesDOs) {
		MaterialNamesDOAdapter adapter = new MaterialNamesDOAdapter();

		ArrayList<MaterialNamesDO> materialNamesList = new ArrayList<MaterialNamesDO>();
		int lenght = result.length;
		for (int i = 0; i < lenght; i++) {
			MaterialNamesDO materialNamesDO = materialNamesDOs[i];
			MedSrvDO medSrvDO = result[i];

			MedSrvDrugDO medSrvDrugDO = new MedSrvDrugDO();
			adapter.getMedSrvDrugDO(medSrvDrugDO, materialNamesDO);
			MaterialNamesDO newMaterialNames = adapter.getMaterialNamesDO(medSrvDO, medSrvDrugDO);
			materialNamesList.add(newMaterialNames);
		}

		return materialNamesList.toArray(new MaterialNamesDO[0]);
	}

	/**
	 * 启用医疗服务
	 * 
	 * @param medSrvDOs
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] EnableMedSrv(MedSrvDO[] medSrvDOs) throws BizException {
		IMedSrvEnableService medSrvEnableService = ServiceFinder.find(IMedSrvEnableService.class);
		MedSrvDO[] result = medSrvEnableService.Enable(medSrvDOs);
		return result;
	}

	/**
	 * 药品通用名转换为医疗服务
	 * 
	 * @param materialNamesDOs
	 * @return
	 */
	private MedSrvDO[] ConvertToMedSrvList(MaterialNamesDO[] materialNamesDOs) {
		ArrayList<MedSrvDO> list = new ArrayList<MedSrvDO>();

		MaterialNamesDOAdapter adapter = new MaterialNamesDOAdapter();
		for (MaterialNamesDO materialNamesDO : materialNamesDOs) {
			MedSrvDO medSrvDO = adapter.getMedSrvDO(materialNamesDO);
			list.add(medSrvDO);
		}
		return list.toArray(new MedSrvDO[0]);
	}

}
