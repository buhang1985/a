package iih.bd.mm.materialnames.s.bp.creater;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.MaterialnamesAggDO;
import iih.bd.mm.materialnames.d.MaterialsDO;
import iih.bd.mm.materialnames.d.MnAliasSetDO;
import iih.bd.mm.materialnames.d.MnCodeSetDO;
import iih.bd.srv.medsrv.d.MedSrvAliasDO;
import iih.bd.srv.medsrv.d.MedSrvCodeSetDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;

/**
 * 药品通用名Agg创建器
 * 
 * @author hao_wu
 *
 */
public class MaterialnamesAggDOCreater {
	/**
	 * 创建药品通用名Agg
	 * 
	 * @param medSrvDO
	 * @param medSrvCodeSetDOs
	 * @param medSrvAliasDOs
	 * @param medSrvDrugDO
	 * @param mmaterials
	 * @return
	 */
	public static MaterialnamesAggDO createMaterialnamesAggDO(MedSrvDO medSrvDO, MedSrvCodeSetDO[] medSrvCodeSetDOs,
			MedSrvAliasDO[] medSrvAliasDOs, MedSrvDrugDO medSrvDrugDO, MaterialsDO[] mmaterials) {

		MaterialNamesDO materialNameDO = MaterialNamesDOCreater.createMaterialNamesDO(medSrvDO, medSrvDrugDO);

		MnCodeSetDO[] mnCodeSetDOs = MnCodeSetDOCreater.createMnCodeSetDOs(medSrvCodeSetDOs);
		MnAliasSetDO[] mnAliasSetDOs = MnAliasSetDOCreater.createMnAliasSetDOs(medSrvAliasDOs);

		MaterialnamesAggDO materialnamesAggDO = new MaterialnamesAggDO();
		materialnamesAggDO.setParentDO(materialNameDO);
		materialnamesAggDO.setMnCodeSetDO(mnCodeSetDOs);
		materialnamesAggDO.setMnAliasSetDO(mnAliasSetDOs);
		materialnamesAggDO.setMaterialsDO(mmaterials);

		return materialnamesAggDO;
	}

	/**
	 * 创建药品通用名Agg
	 * 
	 * @param medSrvDO
	 * @param medSrvCodeSetDOs
	 * @param medSrvAliasDOs
	 * @param medSrvDrugDO
	 * @param mmaterials
	 * @return
	 */
	public static MaterialnamesAggDO createMaterialnamesAggDO(MaterialNamesDO materialNamesDO,
			MedSrvCodeSetDO[] medSrvCodeSetDOs, MedSrvAliasDO[] medSrvAliasDOs, MaterialsDO[] mmaterials) {

		MnCodeSetDO[] mnCodeSetDOs = MnCodeSetDOCreater.createMnCodeSetDOs(medSrvCodeSetDOs);
		MnAliasSetDO[] mnAliasSetDOs = MnAliasSetDOCreater.createMnAliasSetDOs(medSrvAliasDOs);

		MaterialnamesAggDO materialnamesAggDO = new MaterialnamesAggDO();
		materialnamesAggDO.setParentDO(materialNamesDO);
		materialnamesAggDO.setMnCodeSetDO(mnCodeSetDOs);
		materialnamesAggDO.setMnAliasSetDO(mnAliasSetDOs);
		materialnamesAggDO.setMaterialsDO(mmaterials);

		return materialnamesAggDO;
	}

	/**
	 * 创建药品通用名Agg
	 * 
	 * @param materialNamesDO
	 * @param mnCodeSetDOs
	 * @param mnAliasSetDOs
	 * @param mmaterials
	 * @return
	 */
	public static MaterialnamesAggDO createMaterialnamesAggDO(MaterialNamesDO materialNamesDO,
			MnCodeSetDO[] mnCodeSetDOs, MnAliasSetDO[] mnAliasSetDOs, MaterialsDO[] mmaterials) {
		MaterialnamesAggDO materialnamesAggDO = new MaterialnamesAggDO();
		materialnamesAggDO.setParentDO(materialNamesDO);
		materialnamesAggDO.setMnCodeSetDO(mnCodeSetDOs);
		materialnamesAggDO.setMnAliasSetDO(mnAliasSetDOs);
		materialnamesAggDO.setMaterialsDO(mmaterials);
		return materialnamesAggDO;
	}
}
