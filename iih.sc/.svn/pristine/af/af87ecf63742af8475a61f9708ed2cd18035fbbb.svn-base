package iih.sc.sch.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.sc.sch.reg.dto.d.RelSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDouble;

/**
 * 批量获取排班服务价格
 * 
 * @author yank
 */
public class BatchGetScSrvPriceBP {
	/**
	 * 获取排班服务价格
	 * 
	 * @param scSrvIds 排班服务ID集合
	 * @return 价格MAP，key:排班服务ID,value:价格
	 * @throws BizException
	 */
	public Map<String, FDouble> exec(String[] scSrvIds) throws BizException {
		// 1、获取关联服务
		BatchGetRelSrvListBP getRelSrvBP = new BatchGetRelSrvListBP();
		RelSrvDTO[] relSrvDTOArray = getRelSrvBP.exec(scSrvIds);
		if (ArrayUtil.isEmpty(relSrvDTOArray))
			return null;

		// 2、加载价格
		LoadSrvStdPriceBP loadPriceBP = new LoadSrvStdPriceBP();
		for (RelSrvDTO relSrvDTO : relSrvDTOArray) {
			loadPriceBP.exec(relSrvDTO);
		}

		// 3、计算排班服务总价格
		Map<String, FDouble> srvMap = new HashMap<String, FDouble>();
		FDouble tempPrice = FDouble.ZERO_DBL;
		for (int i = 0; i < relSrvDTOArray.length; i++) {
			// 3.1 获取排班服务价格
			FDouble price = srvMap.get(relSrvDTOArray[i].getId_scsrv());
			if (price == null) {
				price = FDouble.ZERO_DBL;
			}

			// 3.2 添加关联服务价格
			tempPrice = relSrvDTOArray[i].getAmt_st();
			price = price.add(tempPrice == null ? FDouble.ZERO_DBL : tempPrice);
			srvMap.put(relSrvDTOArray[i].getId_scsrv(), price);
		}
		return srvMap;
	}
}
