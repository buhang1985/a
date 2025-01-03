package iih.bd.mm.meterial.s.ds;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMMPackageUnitDORService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import xap.lui.core.cache.XapCacheMgr;
import xap.lui.core.cluster.XapCluster;
import xap.lui.core.mq.MQMessage;
import xap.lui.core.mq.MQSender;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 物品缓存 (提供物品包装单位缓存)
 * 
 * @author hao_wu
 *
 */
public class MaterialCache {

	public static final String BD_MM_KEY = "BD_MM_KEY";
	public static final String BD_MMPKG_KEY = "BD_MMPKG_KEY";
	public static final String GRP_ORG_KEY = "GRP_ORG_KEY";
	
	public static final String UPDATE_BD_MM_KEY = "UPDATE_BD_MM_KEY";
	public static final String CLEAR_BD_MM_KEY = "CLEAR_BD_MM_KEY";
	
	private IMMPackageUnitDORService pkgSrv;
	private IMeterialMDORService mmSrv;
	
	private static MaterialCache instance;
	private static Object lockObject = new Object();

	public static synchronized MaterialCache getInstance() throws BizException {
		if (instance == null) {
			synchronized (lockObject) {
				if (instance == null) {
					// 单例模式必须加锁，防止重复构造
					// 必须进行二次判空，否则也会出现重复构造
					instance = new MaterialCache();
				}
			}
		}
		return instance;
	}

	public MaterialCache() throws BizException {
		this.pkgSrv = ServiceFinder.find(IMMPackageUnitDORService.class);
		this.mmSrv = ServiceFinder.find(IMeterialMDORService.class);
		loadPackageUnitByMaterial(null);
	}

	/**
	 * 获取物品基本包装单位
	 * 
	 * @param MaterialId
	 *            物品ID
	 * @return 基本包装单位
	 * @throws BizException
	 */
	public MMPackageUnitDO getBasePackageUnit(String materialId)
			throws BizException {
		if (StringUtils.isBlank(materialId)) {
			return null;
		}
		String key = getKey_Base(materialId);
		Object basePackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		if (basePackageUnit == null) {
			// 缓存没有找到时，从数据库获取
			loadPackageUnitByMaterial(materialId);
			// 再次尝试获取
			basePackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		}
		return (MMPackageUnitDO) basePackageUnit;
	}

	/**
	 * 获取物品零售包装单位
	 * 
	 * @param MaterialId
	 *            物品ID
	 * @return 基本包装单位
	 * @throws BizException
	 */
	public MMPackageUnitDO getSalePackageUnit(String materialId)
			throws BizException {
		if (StringUtils.isBlank(materialId)) {
			return null;
		}
		String key = getKey_Sale(materialId);
		Object salePackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		if (salePackageUnit == null) {
			// 缓存没有找到时，从数据库获取
			loadPackageUnitByMaterial(materialId);
			// 再次尝试获取
			salePackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		}
		return (MMPackageUnitDO) salePackageUnit;
	}

	/**
	 * 获取物品换算包装单位
	 * 
	 * @param MaterialId
	 *            物品ID
	 * @return 基本包装单位
	 * @throws BizException
	 */
	public MMPackageUnitDO getScalerPackageUnit(String materialId)
			throws BizException {
		if (StringUtils.isBlank(materialId)) {
			return null;
		}
		String key = getKey_Scaler(materialId);
		Object saclerPackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		if (saclerPackageUnit == null) {
			// 缓存没有找到时，从数据库获取
			loadPackageUnitByMaterial(materialId);
			// 再次尝试获取
			saclerPackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		}
		return (MMPackageUnitDO) saclerPackageUnit;
	}

	/**
	 * 获取物品包装单位
	 * 
	 * @param mmPkguId
	 *            物品包装单位ID
	 * @return 物品包装单位
	 * @throws BizException
	 */
	public MMPackageUnitDO getPackageUnit(String mmPkguId) throws BizException {
		if (StringUtils.isBlank(mmPkguId)) {
			return null;
		}
		String key = mmPkguId;
		Object mmPackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		if (mmPackageUnit == null) {
			// 缓存没有找到时，从数据库获取
			loadPackageUnit(mmPkguId);
			// 再次尝试获取
			mmPackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		}
		return (MMPackageUnitDO) mmPackageUnit;
	}
	
	/**
	 * 获取物品包装单位
	 * 
	 * @param mmPkguId
	 *            物品包装单位ID
	 * @return 物品包装单位
	 * @throws BizException
	 */
	public MMPackageUnitDO getPackageUnit_Pkgtp(String materialId, String mmPkguType) throws BizException {
		if (StringUtils.isBlank(mmPkguType) || StringUtils.isBlank(materialId)) {
			return null;
		}
		String key = getKey_UnitpkgAndTp(materialId, mmPkguType);
		Object mmPackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		if (mmPackageUnit == null) {
			// 缓存没有找到时，从数据库获取
			loadPackageUnitByPkgtp(materialId, mmPkguType);
			// 再次尝试获取
			mmPackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		}
		return (MMPackageUnitDO) mmPackageUnit;
	}

	/**
	 * 获取物品包装单位
	 * 
	 * @param materialId
	 *            物品Id
	 * @param unitPkgId
	 *            计量单位ID
	 * @return 物品包装单位
	 * @throws BizException
	 */
	public MMPackageUnitDO getPackageUnit_UnitPkgId(String materialId,
			String unitPkgId) throws BizException {
		if (StringUtils.isBlank(materialId) || StringUtils.isBlank(unitPkgId)) {
			return null;
		}
		String key = getKey_UnitpkgAndTp(materialId, unitPkgId);
		Object mmPackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		if (mmPackageUnit == null) {
			// 缓存没有找到时，从数据库获取
			loadPackageUnitByUnitPkg(materialId, unitPkgId);
			// 再次尝试获取
			mmPackageUnit = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(key);
		}
		return (MMPackageUnitDO) mmPackageUnit;
	}
	
	/**
	 * 获取物品基本信息
	 * 
	 * @param id_mm
	 *            物品Id
	 * @return 物品基本信息
	 * @throws BizException
	 */
	public MeterialDO getMaterialInfoByID(String id_mm) throws BizException {
		if (StringUtils.isBlank(id_mm)) {
			return null;
		}
		Object result = XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_KEY).get(id_mm);
		if (result == null) {
			// 缓存没有找到时，从数据库获取
			loadMaterialInfoByID(id_mm);
			// 再次尝试获取
			result = XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_KEY).get(id_mm);
		}
		return (MeterialDO)result;
	}
	
	/**
	 * 获取物品基本信息
	 * 
	 * @param code
	 *            物品编码
	 * @return 物品基本信息
	 * @throws BizException
	 */
	public MeterialDO getMaterialInfoByCode(String code) throws BizException {
		if (StringUtils.isBlank(code)) {
			return null;
		}
		String key = this.getKey_code(code);
		Object result = XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_KEY).get(key);
		if (result == null) {
			// 缓存没有找到时，从数据库获取
			loadMaterialInfoByCode(code);
			// 再次尝试获取
			result = XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_KEY).get(key);
		}
		return (MeterialDO)result;
	}

	/**
	 * 获取基本包装单位缓存Key值
	 * 
	 * @param materialId
	 *            物品ID
	 * @return 基本包装单位缓存Key值
	 */
	private String getKey_Base(String materialId) {
		return String.format("base_%s", materialId);
	}

	/**
	 * 获取零售包装单位缓存Key值
	 * 
	 * @param materialId
	 *            物品ID
	 * @return 零售包装单位缓存Key值
	 */
	private String getKey_Sale(String materialId) {
		return String.format("sale_%s", materialId);
	}

	/**
	 * 获取换算包装单位缓存Key值
	 * 
	 * @param materialId
	 *            物品ID
	 * @return 换算包装单位缓存Key值
	 */
	private String getKey_Scaler(String materialId) {
		return String.format("scaler_%s", materialId);
	}
	
	/**
	 * 获取药品编码缓存Key值
	 * 
	 * @param code
	 *            物品编码
	 * @return 换算包装单位缓存Key值
	 */
	private String getKey_code(String code) {
		return String.format("%s%s%s", Context.get().getGroupId(), Context.get().getOrgId(), code);
	}

	/**
	 * 根据计量单位获取物品包装单位时的缓存Key值
	 * 
	 * @param materialId
	 *            物品Id
	 * @param unitPkgId
	 *            计量单位Id
	 * @return 物品包装单位
	 */
	private String getKey_UnitpkgAndTp(String materialId, String unitPkgId) {
		return String.format("%s%s", materialId, unitPkgId);
	}
	
	/**
	 * 集团组织
	 * 
	 * @return 
	 */
	private String getKey_GrpOrg() {
		return String.format("%s%s", Context.get().getGroupId(), Context.get().getOrgId());
	}

	/**
	 * 从数据库加载物品的包装单位信息并放入缓存
	 * 
	 * @param materialId
	 *            物品ID(为null时查询所有表)
	 * @throws BizException
	 */
	private void loadPackageUnitByMaterial(String materialId)
			throws BizException {
		String where;
		MMPackageUnitDO[] result = null;
		MeterialDO[] mmDOList = null;
		if (!StringUtil.isEmptyWithTrim(materialId)) {
			where = String.format("id_mm = '%s'", materialId);
			result = this.pkgSrv.find(where, "", FBoolean.TRUE);
			mmDOList = this.mmSrv.find(where, "", FBoolean.TRUE);
		}
		
		if(XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY) == null || 
				!XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY).containsKey(getKey_GrpOrg())) {
			result = this.getMmPkguInfo();
			mmDOList = this.getMmInfo();
			XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY).put(getKey_GrpOrg(), getKey_GrpOrg());
		}
		
		if (result == null) {
			return;
		}
		for (MMPackageUnitDO mmPackageUnitDO : result) {
			putPackageUnitCache(mmPackageUnitDO);
		}
		
		for(MeterialDO mmdo : mmDOList) {
			
			this.putMaterialCache(mmdo);
		}
	}

	@SuppressWarnings("unchecked")
	private MMPackageUnitDO[] getMmPkguInfo() throws BizException {
		List<MMPackageUnitDO> result = new ArrayList<MMPackageUnitDO>();
		PaginationInfo pageInfo = new PaginationInfo();
		pageInfo.setPageSize(50000);
		pageInfo.setPageIndex(0);
		Integer pageIndex = -1;
		do
		{
			pageIndex = pageIndex + 1;
			pageInfo.setPageIndex(pageIndex);
			PagingRtnData<MMPackageUnitDO> mmPkguDOS = this.pkgSrv.findByPageInfo(pageInfo, "", "");
			if(mmPkguDOS == null || mmPkguDOS.getPageData() == null || mmPkguDOS.getPageData().size() <= 0) {
				break;
			}
			result.addAll(mmPkguDOS.getPageData());
		} while(pageIndex < pageInfo.getPageCount() - 1);
		if(result == null || result.size() <= 0) {
			return null;
		}
		return result.toArray(new MMPackageUnitDO[0]);
	}
	
	@SuppressWarnings("unchecked")
	private MeterialDO[] getMmInfo() throws BizException {
		List<MeterialDO> result = new ArrayList<MeterialDO>();
		PaginationInfo pageInfo = new PaginationInfo();
		pageInfo.setPageSize(50000);
		pageInfo.setPageIndex(0);
		Integer pageIndex = -1;
		do
		{
			pageIndex = pageIndex + 1;
			pageInfo.setPageIndex(pageIndex);
			PagingRtnData<MeterialDO> mmDOS = this.mmSrv.findByPageInfo(pageInfo, "", "");
			if(mmDOS == null || mmDOS.getPageData() == null || mmDOS.getPageData().size() <= 0) {
				break;
			}
			result.addAll(mmDOS.getPageData());
		} while(pageIndex < pageInfo.getPageCount() - 1);
		if(result == null || result.size() <= 0) {
			return null;
		}
		return result.toArray(new MeterialDO[0]);
	}

	/**
	 * 从数据库加载物品基本信息并放入缓存
	 * 
	 * @param mmPkguId
	 *            物品包装单位ID
	 * @throws BizException
	 */
	private void loadMaterialInfoByID(String materialId) throws BizException {
		MeterialDO mmDO = this.mmSrv.findById(materialId);
		if(mmDO == null) {
			return;
		}
		this.putMaterialCache(mmDO);
		if(XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY) == null || 
				!XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY).containsKey(getKey_GrpOrg())) {
			this.loadPackageUnitByMaterial(null);
		}
	}
	
	/**
	 * 从数据库加载物品基本信息并放入缓存
	 * 
	 * @param mmPkguId
	 *            物品包装单位ID
	 * @throws BizException
	 */
	private void loadMaterialInfoByCode(String code) throws BizException {
		MeterialDO[] mmDOS = this.mmSrv.find("code = '" + code + "'", "", FBoolean.TRUE);
		if(mmDOS == null || mmDOS.length <= 0) {
			return;
		}
		this.putMaterialCache(mmDOS[0]);
		if(XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY) == null || 
				!XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY).containsKey(getKey_GrpOrg())) {
			this.loadPackageUnitByMaterial(null);
		}
	}

	/**
	 * 从数据库加载物品包装单位信息并放入缓存
	 * 
	 * @param mmPkguId
	 *            物品包装单位ID
	 * @throws BizException
	 */
	private void loadPackageUnit(String mmPkguId) throws BizException {
		MMPackageUnitDO mmPackageUnitDO = pkgSrv.findById(mmPkguId);
		if (mmPackageUnitDO == null) {
			return;
		}
		putPackageUnitCache(mmPackageUnitDO);
		if(XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY) == null || 
				!XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY).containsKey(getKey_GrpOrg())) {
			this.loadPackageUnitByMaterial(null);
		}
	}
	
	/**
	 * 从数据库加载物品包装单位信息并放入缓存
	 * 
	 * @param materialId
	 *            物品Id
	 * @param unitPkgId
	 *            计量单位Id
	 * @throws BizException
	 */
	private void loadPackageUnitByPkgtp(String materialId, String mmPkguType)
			throws BizException {
		MMPackageUnitDO[] result = pkgSrv.find(String.format(
				"id_mm = '%s' and Id_mmpkgutp = '%s'", materialId,
				mmPkguType), "", FBoolean.FALSE);
		if (result == null) {
			return;
		}
		for (MMPackageUnitDO mmPackageUnitDO : result) {
			putPackageUnitCache(mmPackageUnitDO);
		}
		if(XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY) == null || 
				!XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY).containsKey(getKey_GrpOrg())) {
			this.loadPackageUnitByMaterial(null);
		}
	}

	/**
	 * 从数据库加载物品包装单位信息并放入缓存
	 * 
	 * @param materialId
	 *            物品Id
	 * @param unitPkgId
	 *            计量单位Id
	 * @throws BizException
	 */
	private void loadPackageUnitByUnitPkg(String materialId, String unitPkgId)
			throws BizException {
		MMPackageUnitDO[] result = pkgSrv.find(String.format(
				"id_mm = '%s' and Id_unit_pkg = '%s'", materialId, unitPkgId), "", FBoolean.FALSE);
		if (result == null) {
			return;
		}
		for (MMPackageUnitDO mmPackageUnitDO : result) {
			putPackageUnitCache(mmPackageUnitDO);
		}
		if(XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY) == null || 
				!XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY).containsKey(getKey_GrpOrg())) {
			this.loadPackageUnitByMaterial(null);
		}
	}
	
	/**
	 * 更新物品缓存(物品基本信息)
	 * 
	 * @param code
	 *            物品编码
	 * @return 物品基本信息
	 * @throws BizException
	 */
	public void updateMaterialInfo(MeterialDO[] newInfos) {
		
		if(newInfos == null || newInfos.length <= 0) {
			return;
		}
		
		MQMessage mqMessage=new MQMessage(UPDATE_BD_MM_KEY, newInfos);
		this.clearCache(mqMessage);
	}
	
	/**
	 * 更新物品缓存(包括包装单位和物品基本信息)
	 * 
	 * @param code
	 *            物品编码
	 * @return 物品基本信息
	 * @throws BizException
	 */
	public void updateMaterialAggInfo(MeterialAggDO[] newInfos) {
		if(newInfos == null || newInfos.length <= 0) {
			return;
		}
		
		MQMessage mqMessage=new MQMessage(UPDATE_BD_MM_KEY, newInfos);
		this.clearCache(mqMessage);
	}
	
	/**
	 * 更新物品包装单位缓存
	 * 
	 * @param code
	 *            物品编码
	 * @return 物品基本信息
	 * @throws BizException
	 */
	public void updateMmPkgInfo(MMPackageUnitDO[] mmPkgDOS) {
		
		if(mmPkgDOS == null || mmPkgDOS.length <= 0) {
			return;
		}
		
		MQMessage mqMessage=new MQMessage(UPDATE_BD_MM_KEY, mmPkgDOS);
		this.clearCache(mqMessage);
	}
	
	public void putMaterialCache(MeterialDO mmDO) throws BizException {
		XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_KEY).put(mmDO.getId_mm(), mmDO);
		String key = this.getKey_code(mmDO.getCode());
		XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_KEY).put(key, mmDO);
	}

	/**
	 * 加入物品包装单位到缓存
	 * 
	 * @param mmPackageUnitDO
	 */
	@SuppressWarnings("unchecked")
	public void putPackageUnitCache(MMPackageUnitDO mmPackageUnitDO) {
		if (mmPackageUnitDO == null)
			return;
		String mmId = mmPackageUnitDO.getId_mm();
		List<String> keyList = null;
		Object keys = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(mmId);
		if(keys == null) {
			keyList = new ArrayList<String>();
		} else {
			keyList = (List<String>)keys;
		}
		
		if (IBdMmDictCodeConst.SD_MMPKGUPRO_BASE.equals(mmPackageUnitDO.getSd_mmpkgupro())) {
			// 设置base_物品Id-物品基本包装单位
			XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).put(getKey_Base(mmId), mmPackageUnitDO);
			keyList.add(getKey_Base(mmId));
		} else if (IBdMmDictCodeConst.SD_MMPKGUPRO_SELL.equals(mmPackageUnitDO.getSd_mmpkgupro())) {
			// 设置sale_物品Id-物品零售包装单位
			XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).put(getKey_Sale(mmId), mmPackageUnitDO);
			keyList.add(getKey_Sale(mmId));
		} else if (IBdMmDictCodeConst.SD_MMPKGUPRO_SCALER.equals(mmPackageUnitDO.getSd_mmpkgupro())) {
			// 设置scaler_物品Id-物品换算包装单位
			XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).put(getKey_Scaler(mmId), mmPackageUnitDO);
			keyList.add(getKey_Scaler(mmId));
		}
		// 设置物品包装单位Id-物品包装单位
		XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).put(mmPackageUnitDO.getId_mmpkgu(), mmPackageUnitDO);
		keyList.add(mmPackageUnitDO.getId_mmpkgu());
		// 设置物品包装单位类型-物品包装单位
		XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).put(getKey_UnitpkgAndTp(mmPackageUnitDO.getId_mm(), mmPackageUnitDO.getId_mmpkgutp()), mmPackageUnitDO);
		keyList.add(getKey_UnitpkgAndTp(mmPackageUnitDO.getId_mm(), mmPackageUnitDO.getId_mmpkgutp()));
		// 设置计量单位-物品包装单位
		XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).put(getKey_UnitpkgAndTp(mmPackageUnitDO.getId_mm(), mmPackageUnitDO.getId_unit_pkg()), mmPackageUnitDO);
		keyList.add(getKey_UnitpkgAndTp(mmPackageUnitDO.getId_mm(), mmPackageUnitDO.getId_unit_pkg()));
		// 清空物品包装单位缓存用
		XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).put(mmId, keyList);
	}
	
	public void clearCache(MeterialAggDO[] mmAggDOS) {
		
		MQMessage mqMessage=new MQMessage(CLEAR_BD_MM_KEY, mmAggDOS);
		this.clearCache(mqMessage);
	}
	
	public void clearMaterialCache(MeterialDO[] mmDOS) {
		
		MQMessage mqMessage=new MQMessage(CLEAR_BD_MM_KEY, mmDOS);
		this.clearCache(mqMessage);
	}
	
	public void clearMaterialCache(MeterialDO mmDO) {
		
		XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_KEY).remove(mmDO.getId_mm());
		String key = this.getKey_code(mmDO.getCode());
		XapCacheMgr.getStrongCacheOnlyLocal(BD_MM_KEY).remove(key);
	}
	
	public void clearPackageUnitCache(MMPackageUnitDO[] mmPkgDOS) {
		
		MQMessage mqMessage=new MQMessage(CLEAR_BD_MM_KEY, mmPkgDOS);
		this.clearCache(mqMessage);
	}
	
	@SuppressWarnings("unchecked")
	public void clearPackageUnitCache(String[] id_mms) {
		
		for(String id_mm : id_mms) {
			
			List<String> keyList = null;
			Object keys = XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).get(id_mm);
			if(keys == null) {
				return;
			} else {
				keyList = (List<String>)keys;
			}
			
			for(String key : keyList) {
				XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).remove(key);
			}
			
			//keyList清除
			XapCacheMgr.getStrongCacheOnlyLocal(BD_MMPKG_KEY).remove(id_mm);
		}
	}
	
	private void clearCache(MQMessage mqMessage) {
		mqMessage.setTargetCluster(XapCluster.getIIHClusterName());
		MQSender.sendMsgForAdapter(mqMessage);
		mqMessage.setTargetCluster(XapCluster.getXapClusterName());
		MQSender.sendMsgForAdapter(mqMessage);
	}
	
	public void reloadMmCache() throws BizException {
		Object result = XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY).get(getKey_GrpOrg());
		if(result == null) {
			return;
		}
		XapCacheMgr.getStrongCacheOnlyLocal(GRP_ORG_KEY).remove(getKey_GrpOrg());
		MMPackageUnitDO[] mmpkgList = this.getMmPkguInfo();
		MeterialDO[] mmDOList = this.getMmInfo();
		if(mmpkgList != null && mmpkgList.length > 0) {
			this.clearPackageUnitCache(mmpkgList);
		}
		if(mmDOList != null && mmDOList.length > 0) {
			this.clearMaterialCache(mmDOList);
		}
		loadPackageUnitByMaterial(null);
	}
}
