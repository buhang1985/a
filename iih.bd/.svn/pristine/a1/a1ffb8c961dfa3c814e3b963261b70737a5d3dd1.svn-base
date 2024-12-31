package iih.bd.mm.materialnames.s.bp.creater;

import java.util.ArrayList;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.adapter.MaterialNamesDOAdapter;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;

/**
 * 药品通用名创建器
 * 
 * @author hao_wu
 *
 */
public class MaterialNamesDOCreater {

	private static MaterialNamesDOAdapter adapter = new MaterialNamesDOAdapter();

	/**
	 * 创建药品通用名列表
	 * 
	 * @param pageData
	 * @param medSrvDrugDOs
	 * @return
	 */
	public static MaterialNamesDO[] createMaterialNamesDOs(MedSrvDO[] pageData, MedSrvDrugDO[] medSrvDrugDOs) {
		ArrayList<MaterialNamesDO> materialNamesDOList = new ArrayList<MaterialNamesDO>();
		for (MedSrvDO medSrvDO : pageData) {
			MedSrvDrugDO medSrvDrugDO = getMedSrvDrugDOById(medSrvDrugDOs, medSrvDO.getId_srv());
			MaterialNamesDO materialNamesDO = createMaterialNamesDO(medSrvDO, medSrvDrugDO);
			materialNamesDOList.add(materialNamesDO);
		}
		return materialNamesDOList.toArray(new MaterialNamesDO[0]);
	}

	/**
	 * 创建药品通用名主数据
	 * 
	 * @param medSrvDO
	 * @param medSrvDrugDO
	 */
	public static MaterialNamesDO createMaterialNamesDO(MedSrvDO medSrvDO, MedSrvDrugDO medSrvDrugDO) {
		MaterialNamesDO materialNameDO = adapter.getMaterialNamesDO(medSrvDO, medSrvDrugDO);
		return materialNameDO;
	}

	/**
	 * 从列表中查询对应药品属性
	 * 
	 * @param medSrvDrugDOs
	 * @param id_srv
	 * @return
	 */
	private static MedSrvDrugDO getMedSrvDrugDOById(MedSrvDrugDO[] medSrvDrugDOs, String id_srv) {
		if (medSrvDrugDOs == null) {
			return null;
		}
		for (MedSrvDrugDO medSrvDrugDO : medSrvDrugDOs) {
			if (medSrvDrugDO.getId_srv() != null && medSrvDrugDO.getId_srv().equals(id_srv)) {
				return medSrvDrugDO;
			}
		}
		return null;
	}
}
