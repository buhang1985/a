package iih.bl.cg.bp.oep;

import java.util.HashMap;
import java.util.Map;

import iih.bl.cg.bp.DrawbackAccDrugBP;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 取消门诊记账
 * 
 * @author
 *
 */
public class CancOepCgBP {
	/**
	 * 取消门诊记账
	 * 
	 * @param refundBills
	 * @throws BizException
	 */
	public void exec(BlStReFundBillDTO[] refundBills) throws BizException {
		if (refundBills == null || refundBills.length == 0) {
			return;
		}
		Map<String, Map<String, FDouble>> entDrug = new HashMap<>();
		// 根据id_ent 进行分组 组装到对应组中的map 中 进行统一调用 销账的接口
		for (BlStReFundBillDTO blStReFundBillDTO : refundBills) {
			String keyStr = blStReFundBillDTO.getId_ent();
			if (entDrug.containsKey(keyStr)) {
				entDrug.get(keyStr).put(blStReFundBillDTO.getId_orsrv(), blStReFundBillDTO.getQuan());
			} else {
				Map<String, FDouble> backDrugMap = new HashMap<String, FDouble>();
				backDrugMap.put(blStReFundBillDTO.getId_orsrv(), blStReFundBillDTO.getQuan());
				entDrug.put(keyStr, backDrugMap);
			}
		}
		DrawbackAccDrugBP bp = new DrawbackAccDrugBP();
		for (Map.Entry<String, Map<String, FDouble>> mapitm : entDrug.entrySet()) {
			bp.exec(mapitm.getKey(), mapitm.getValue());
		}
	}
}
