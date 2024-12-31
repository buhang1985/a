package iih.bd.res.bed.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.bdbltpl.d.BdBltplItmDO;
import iih.bd.pp.bdbltpl.d.BdbltplAggDO;
import iih.bd.pp.bdbltpl.i.IBdbltplRService;
import iih.bd.pp.medsrvrealpriceqry.i.IMedSrvRealPriceQryService;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDORService;
import iih.bd.res.bed.s.bp.sql.FindBedPriByBedIdsSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 根据床位主键集合查询床位费字典
 * 
 * @author hao_wu
 *
 */
public class FindBedPriMapByIdsBp {

	public FMap2 exec(String[] bedIds) throws BizException {
		if (bedIds == null || bedIds.length <= 0) {
			return null;
		}

		FMap2 bedPriMap = findBedPriMapByBedIds(bedIds);
		return bedPriMap;
	}

	/**
	 * 根据床位主键集合查询床位价格
	 * 
	 * @param bedIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FMap2 findBedPriMapByBedIds(String[] bedIds) throws BizException {

		FindBedPriByBedIdsSql sql = new FindBedPriByBedIdsSql(bedIds);
		DAFacade daFacade = new DAFacade();
		ArrayList<HashMap<String, Object>> mapList = (ArrayList<HashMap<String, Object>>) daFacade
				.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new MapListHandler());

		FMap2 bedMap = new FMap2();
		for (HashMap<String, Object> hashMap : mapList) {
			FDouble price = ConvertToDouble(hashMap.get("price"));
			bedMap.put(hashMap.get("id_bed").toString(), price);
		}

		return bedMap;

		// FMap2 bedMap = findBedMapByIds(bedIds);
		// if (bedMap == null || bedMap.size() <= 0) {
		// throw new BizException("根据床位主键获取床位信息失败。");
		// }
		// String[] blTplIds = getBlTplIds(bedMap.values().toArray(new
		// Bdbed[0]));
		// FMap2 blTplMap = findBlTplPriMapByIds(blTplIds);
		//
		// FMap2 BedPriMap = new FMap2();
		//
		// for (String bedId : bedIds) {
		// if (bedMap.containsKey(bedId)) {
		// String blTplId = ((Bdbed) bedMap.get(bedId)).getId_bltpl();
		// FDouble blTplPri = null;
		// if (blTplMap.containsKey(blTplId)) {
		// blTplPri = (FDouble) blTplMap.get(blTplId);
		// }
		// BedPriMap.put(bedId, blTplPri);
		// }
		// }
		// return BedPriMap;
	}

	/**
	 * 转换价格类型到FDouble
	 * 
	 * @param valueObj
	 * @return
	 */
	private FDouble ConvertToDouble(Object valueObj) {
		FDouble doubleValue = null;
		if (valueObj instanceof Integer) {
			doubleValue = new FDouble((Integer) valueObj);
		} else if (valueObj instanceof BigDecimal) {
			doubleValue = new FDouble((BigDecimal) valueObj);
		}
		return doubleValue;
	}

	/**
	 * 根据床位主键获取床位字典
	 * 
	 * @param bedIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private FMap2 findBedMapByIds(String[] bedIds) throws BizException {
		IBedMDORService bedMdoRService = ServiceFinder.find(IBedMDORService.class);
		Bdbed[] result = bedMdoRService.findByIds(bedIds, FBoolean.FALSE);

		FMap2 bedMap = new FMap2();
		for (Bdbed bdbed : result) {
			bedMap.put(bdbed.getId_bed(), bdbed);
		}
		return bedMap;
	}

	/**
	 * 获取床位集合中的费用模板主键集合
	 * 
	 * @param beds
	 * @return
	 */
	@SuppressWarnings("unused")
	private String[] getBlTplIds(Bdbed[] beds) {
		ArrayList<String> blTplIds = new ArrayList<String>();

		for (Bdbed bdbed : beds) {
			String blTplId = bdbed.getId_bltpl();
			if (StringUtils.isNotEmpty(blTplId)) {
				blTplIds.add(blTplId);
			}
		}
		return blTplIds.toArray(new String[0]);
	}

	/**
	 * 根据费用模板主键集获取费用模板价格字典
	 * 
	 * @param blTplIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private FMap2 findBlTplPriMapByIds(String[] blTplIds) throws BizException {
		FMap2 blTplPriMap = new FMap2();
		if (blTplIds == null || blTplIds.length <= 0) {
			return blTplPriMap;
		}

		BdbltplAggDO[] blTplAggs = findBlTplByIds(blTplIds);
		if (blTplAggs == null || blTplAggs.length <= 0) {
			throw new BizException("根据自定义费用模板主键集合获取自定义费用模板失败。");
		}

		String[] medSrvIds = getBlTplSrvIds(blTplAggs);
		FMap2 medSrvPriMap = findMedSrvRealPriMapByIds(medSrvIds);

		for (BdbltplAggDO bdbltplAggDO : blTplAggs) {
			FDouble price = calcuTplPri(bdbltplAggDO, medSrvPriMap);
			blTplPriMap.put(bdbltplAggDO.getParentDO().getPkVal(), price);
		}

		return blTplPriMap;
	}

	/**
	 * 根据费用模板主键集合查询费用模板集合
	 * 
	 * @param blTplIds
	 * @return
	 * @throws BizException
	 */
	private BdbltplAggDO[] findBlTplByIds(String[] blTplIds) throws BizException {
		IBdbltplRService bdbltplRService = ServiceFinder.find(IBdbltplRService.class);
		BdbltplAggDO[] result = bdbltplRService.findByIds(blTplIds, FBoolean.FALSE);
		return result;
	}

	/**
	 * 获取费用模板中医疗服务主键集合
	 * 
	 * @param blTplAggs
	 * @return
	 */
	private String[] getBlTplSrvIds(BdbltplAggDO[] blTplAggs) {
		ArrayList<String> blTplSrvIdList = new ArrayList<String>();

		for (BdbltplAggDO bdbltplAggDO : blTplAggs) {
			BdBltplItmDO[] items = bdbltplAggDO.getBdBltplItmDO();
			for (BdBltplItmDO bdBltplItmDO : items) {
				blTplSrvIdList.add(bdBltplItmDO.getId_srv());
			}
		}
		return blTplSrvIdList.toArray(new String[0]);
	}

	/**
	 * 根据医疗服务主键查询医疗服务真实价格
	 * 
	 * @param medSrvIds
	 *            医疗服务主键集合
	 * @return
	 * @throws BizException
	 */
	private FMap2 findMedSrvRealPriMapByIds(String[] medSrvIds) throws BizException {
		if (medSrvIds == null || medSrvIds.length <= 0) {
			return new FMap2();
		}
		IMedSrvRealPriceQryService medSrvRealPriceQryService = ServiceFinder.find(IMedSrvRealPriceQryService.class);
		FMap2 medSrvRealPriMap = medSrvRealPriceQryService.FindMedSrvRealPriMapByIds(medSrvIds);
		return medSrvRealPriMap;
	}

	/**
	 * 计算费用模板价格
	 * 
	 * @param bdbltplAggDO
	 *            费用模板
	 * @param medSrvPriMap
	 *            价格字典
	 * @return
	 * @throws BizException
	 */
	private FDouble calcuTplPri(BdbltplAggDO bdbltplAggDO, FMap2 medSrvPriMap) throws BizException {
		BdBltplItmDO[] items = bdbltplAggDO.getBdBltplItmDO();
		FDouble price = new FDouble(0);
		if (items == null || items.length <= 0) {
			return price;
		}
		for (BdBltplItmDO bdBltplItmDO : items) {
			String srvId = bdBltplItmDO.getId_srv();
			if (!medSrvPriMap.containsKey(srvId)) {
				String msg = String.format("医疗服务价格获取失败，医疗服务主键:%s。", srvId);
				throw new BizException(msg);
			}
			price = price.add(((FDouble) medSrvPriMap.get(srvId)).multiply(bdBltplItmDO.getQuan_medu()));
		}
		return price;
	}
}
