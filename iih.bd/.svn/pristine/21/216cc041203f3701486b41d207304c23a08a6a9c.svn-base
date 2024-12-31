package iih.bd.pp.hpsrvorca.bp;

import java.util.HashMap;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.ImportDTO;
import iih.bd.pp.hpsrvorca.d.ImportResultEnum;
import xap.mw.core.data.FArrayList;
import xap.mw.runtime.utils.MD5Util;

/**
 * 医保目录对照重复数据检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class HpSrvOrCaRepeatDataValidateBp {

	public void exec(HashMap<String, ImportDTO> importDataHashMap, ImportDTO importDTO) {
		if (importDataHashMap == null || importDTO == null) {
			return;
		}

		String hashVal = GetDataHashVal(importDTO);
		if (hashVal == null) {
			return;
		}
		if (importDataHashMap.containsKey(hashVal)) {
			importDTO.setResult(ImportResultEnum.REPEAT);
			return;
		}

		importDataHashMap.put(hashVal, importDTO);
	}

	private String GetDataHashVal(ImportDTO importDTO) {
		if (importDTO == null) {
			return null;
		}
		FArrayList hpsrvorcaList = importDTO.getHpsrvorca();
		if (hpsrvorcaList == null || hpsrvorcaList.size() < 1) {
			return null;
		}
		HPSrvorcaDO hpSrvorcaDO = (HPSrvorcaDO) hpsrvorcaList.get(0);
		if (hpSrvorcaDO == null) {
			return null;
		}

		StringBuilder valStrBuilder = new StringBuilder();
		valStrBuilder.append(hpSrvorcaDO.getHis_code());
		valStrBuilder.append(hpSrvorcaDO.getHis_name());
		valStrBuilder.append(hpSrvorcaDO.getCode());
		valStrBuilder.append(hpSrvorcaDO.getName());
		valStrBuilder.append(hpSrvorcaDO.getCode_dosage());
		valStrBuilder.append(hpSrvorcaDO.getMm_spec());
		valStrBuilder.append(hpSrvorcaDO.getMm_unit_pkgbase());
		valStrBuilder.append(hpSrvorcaDO.getMm_price());
		valStrBuilder.append(hpSrvorcaDO.getSd_hpsrvtp());
		valStrBuilder.append(hpSrvorcaDO.getCode_ca());
		valStrBuilder.append(hpSrvorcaDO.getDes());

		return MD5Util.getMD5String(valStrBuilder.toString());
	}

}
