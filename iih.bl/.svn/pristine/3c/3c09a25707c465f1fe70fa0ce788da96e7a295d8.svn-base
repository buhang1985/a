package iih.bl.hp.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.i.IBlOutQryService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @author
 *
 */
public class GetOpZeroRegUploadXmlBP {
	/**
	 * 获取门诊零挂上传XML
	 * 
	 * @param entIdMap
	 *            【key:entId，value: FDateTime】
	 * @param PersonType
	 *            医保患者类型
	 * @return FMap，【key:entId，value: xml字符串】
	 * @throws BizException
	 * @author yang.lu
	 */
	public FMap exec(FMap entIdMap, String PersonType) throws BizException {
		FMap map = new FMap();
		List<String> entidList = new ArrayList<String>();
		for (String idEn : entIdMap.keySet()) {
			entidList.add(idEn);
		}
		// 1.根据就诊编号获取结算挂号的记账数据
		IBlCgItmOepDORService cgitmSer = ServiceFinder.find(IBlCgItmOepDORService.class);
		String whereStr = BlCgItmOepDO.ID_STOEP + " in (SELECT ID_STOEP FROM BL_ST_OEP WHERE " + BlStOepDO.EU_STTP + "='" + StTypeEnum.ST_OEP_REG + "' AND " + SqlUtils.getInSqlByBigIds(BlStOepDO.ID_ENT, entidList.toArray(new String[entidList.size()])) + ")";
		BlCgItmOepDO[] cgitm = cgitmSer.find(whereStr, "", FBoolean.FALSE);

		IBlOutQryService cgService = ServiceFinder.find(IBlOutQryService.class);

		// 2.循环就诊编号 填充map 数据
		for (String idEn : entIdMap.keySet()) {
			// 如果已有就诊的XML跳出循环
			if (map.containsKey(idEn))
				continue;
			List<BlCgItmOepDO> cgList = new ArrayList<BlCgItmOepDO>();
			for (BlCgItmOepDO cg : cgitm) {
				if (idEn.equals(cg.getId_ent())) {
					// 零挂数据设置当前金额都为0
					cg.setPrice_ratio(FDouble.ZERO_DBL);
					cg.setAmt_ratio(FDouble.ZERO_DBL);
					cg.setPrice(FDouble.ZERO_DBL);
					cg.setAmt(FDouble.ZERO_DBL);
					cg.setDt_or(((FDateTime) entIdMap.get(idEn)));
					cgList.add(cg);
				}
			}
			// 如果没有记账数据 跳出循环
			if (cgList.size() == 0)
				continue;
			// 调用获取提交医保组装XML的方法
			String xml = cgService.GetOrderInsurXml(cgList, null, "", "17", PersonType);
			map.put(idEn, xml);
		}

		return map;
	}
}
