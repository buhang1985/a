package iih.bd.pp.hpsrvorca.bp;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.ImportDTO;
import iih.bd.pp.hpsrvorca.d.ImportResultEnum;
import xap.mw.core.data.FArrayList;

public class ImportDTOAdapter {

	/**
	 * 导入信息适配ImportDto
	 * 
	 * @param token
	 *            导入信息
	 * @param fg_drug
	 *            物品标识
	 * @param eu_hpmmRelTp
	 *            医保物品对照类型
	 * @param meterialDOArray
	 *            物品列表
	 * @return
	 */
	public ImportDTO GetImportDTO(String token, boolean fg_drug, int eu_hpmmRelTp) {
		ImportDTO importDTO = new ImportDTO();
		importDTO.setImportinfo(token);
		// 默认导入成功
		importDTO.setResult(ImportResultEnum.IMPORTSUCCESS);

		// if (!CheckToken(token, fg_drug)) {
		// importDTO.setResult(ImportResultEnum.IMPORTDATAERROR);
		// return importDTO;
		// }

		// 适配HPSrvorcaDO
		AdapterHPSrvorcaDO(importDTO, fg_drug, eu_hpmmRelTp);
		return importDTO;
	}

	/**
	 * 检查导入数据是否合格
	 * 
	 * @param token
	 * @param fg_drug
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean CheckToken(String token, boolean fg_drug) {
		String[] strItemCataArr = token.split("\\|");
		if (fg_drug && strItemCataArr.length >= 10 && strItemCataArr.length <= 11) {
			return true;
		}
		if (!fg_drug && strItemCataArr.length >= 8 && strItemCataArr.length <= 9) {
			return true;
		}
		return false;
	}

	// /**
	// * 物品编码转换为服务编码
	// *
	// * @param importDTO
	// * @param meterialDOArray
	// */
	// private void MmCodeToSrvCode(ImportDTO importDTO,
	// MeterialDO[] meterialDOArray) {
	// HPSrvorcaDO hpSrvorcaDO = (HPSrvorcaDO) importDTO.getHpsrvorca().get(0);
	// MeterialDO meterialDO = findMeterialDOByCode(meterialDOArray,
	// hpSrvorcaDO.getSrv_code());
	// if (meterialDO == null) {
	// importDTO.setResult(ImportResultEnum.MMNOTFOUND);
	// return;
	// }
	// if (meterialDO.getSrv_code() == null) {
	// importDTO.setResult(ImportResultEnum.SRVNOTFOUND);
	// return;
	// }
	// hpSrvorcaDO.setSrv_code(meterialDO.getSrv_code());
	// }

	/**
	 * 适配HPSrvorcaDO
	 * 
	 * @param importDTO
	 * @param fg_drug
	 */
	@SuppressWarnings("unchecked")
	private void AdapterHPSrvorcaDO(ImportDTO importDTO, boolean fg_drug, int eu_hpmmRelTp) {
		HPSrvorcaDOAdapter hpSrvorcaDOAdapter = new HPSrvorcaDOAdapter();
		HPSrvorcaDO hpSrvorcaDO = hpSrvorcaDOAdapter.GetHPSrvorcaDO(importDTO.getImportinfo(), fg_drug, importDTO);
		if (hpSrvorcaDO == null)
			return;
		FArrayList arrayList = new FArrayList();
		arrayList.add(hpSrvorcaDO);
		importDTO.setHpsrvorca(arrayList);

		// // 如果是药品对照信息导入且按照药品编码导入,用服务编码更换物品编码
		// if (fg_drug && eu_hpmmRelTp == ((int) HpmmreltpEnum.BD_MM_CODE_TYPE))
		// MmCodeToSrvCode(importDTO, meterialDOArray);
	}
}
