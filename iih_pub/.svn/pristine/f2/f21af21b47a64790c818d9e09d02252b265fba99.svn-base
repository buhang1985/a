package iih.bd.mm.meterial.i.ds;

import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 医疗物品自定义服务.
 * 
 * @author wu.junhui
 *
 */
public interface IMeterialService {

	// 单位换算模式_数量
	public static final String TYPE_NUM = "1";
	// 单位换算模式_单价
	public static final String TYPE_PRICE = "2";

	/**
	 * 查询基本分类下的物品
	 * 
	 * @param categoryId  物品基本分类ID
	 * @param isRecursive 是否递归
	 * @return 物品列表
	 * @throws BizException
	 */
	MeterialDO[] queryMeterials(String categoryId, boolean isRecursive) throws BizException;

	/**
	 * 查询基本分类下的物品(转入仓库和转出仓库的并集)
	 * 
	 * @param categoryId  物品基本分类ID
	 * @param isRecursive 是否递归
	 * @return inWhouseID 转入仓库
	 * @return outWhouseID 转出仓库
	 * @return isStockBl 是否过滤结存
	 * @throws BizException
	 */
	MeterialDO[] queryMeterialsByWhRel(String categoryId, boolean isRecursive, String inWhouseID, String outWhouseID,
			boolean isStockBl) throws BizException;

	/**
	 * 根据物品编码获取物品信息.
	 * 
	 * @param orgId
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public MeterialDO getMaterialByCode(String orgId, String code) throws BizException;

	/**
	 * 判断物品是否被自定义分类引用
	 * 
	 * @param meterialId 物品主键ID
	 * @return true 存在引用 false 未引用
	 * @throws BizException
	 */
	boolean isRefByCustCategory(String[] meterialIds) throws BizException;

	/**
	 * 判断物品是否存在库存
	 * 
	 * @param meterialId
	 */
	boolean isStockExist(String[] meterialIds) throws BizException;

	/**
	 * 判断物品是否存在库存(指定仓库)
	 * 
	 * @param meterialId
	 */
	boolean isStockExistByWh(String whouseID, String meterialId) throws BizException;

	/**
	 * 判断物品是否存在期初
	 * 
	 * @param meterialId
	 */
	boolean isStockPerInitExist(String[] meterialIds) throws BizException;

	/**
	 * 判断物品是否存在入库
	 * 
	 * @param meterialId
	 */
	boolean isStockIn(String[] meterialIds) throws BizException;

	/**
	 * 判断物品是否有供应商关系及协议信息
	 * 
	 * @param meterialIds
	 * @return
	 * @throws BizException
	 */
	boolean isSupplierprotocolExist(String[] meterialIds) throws BizException;

	/**
	 * 判断物品是否有仓库关系信息
	 * 
	 * @param meterialIds
	 * @return
	 * @throws BizException
	 */
	boolean isWarehouseExist(String[] meterialIds) throws BizException;

	boolean isDepartmentExist(String[] meterialIds) throws BizException;

	/**
	 * 启用物品
	 */
	MeterialDO[] start(MeterialDO[] meterialDOs) throws BizException;

	/**
	 * 停用物品
	 */
	MeterialDO[] stop(MeterialDO[] meterialDOs) throws BizException;

	/**
	 * 删除物品 验证
	 */
	void deleteCheck(String[] ids) throws BizException;

	/**
	 * 删除物品
	 */
	void delete(String[] ids) throws BizException;

	/**
	 * 获取物品基本包装单位信息。
	 * 
	 * @param meterialId 物品ID
	 */
	MMPackageUnitDO findBasePackageUnit(String meterialId) throws BizException;

	/**
	 * 获取物品零售包装单位信息。
	 * 
	 * @param meterialId
	 * @return
	 * @throws BizException
	 */
	MMPackageUnitDO findSalePackageUnit(String meterialId) throws BizException;

	/**
	 * 通过物品包装单位ID获取物品包装单位信息。
	 * 
	 * @param mmpkguId
	 * @return
	 * @throws BizException
	 */
	MMPackageUnitDO findPackageUnitById(String mmpkguId) throws BizException;

	MMPackageUnitDO findMmPackageUnitById(String meterialId, String mmpkguId) throws BizException;

	/**
	 * 通过物品单位ID获取物品包装单位信息。 (单位ID可能是物品包装单位ID或者计量单位表中的主键)
	 * 
	 * @param unitId
	 * @return
	 * @throws BizException
	 */
	MMPackageUnitDO findPackageUnitByUnitId(String mmId, String unitId) throws BizException;

	/**
	 * 获取物品指定单位的零售单价
	 * 
	 * @param materialId   物品ID
	 * @param actummpkguId 物品包装单位ID
	 * @param priAct       入库价(当物品是加成率模式或者是零差价模式时必须指定)
	 * @return 零售单价
	 * @throws BizException
	 */
	FDouble getMaterialSalePrice(String materialId, String actummpkguId, FDouble priAct) throws BizException;

	/**
	 * 获取物品零售单位的零售单价
	 * 
	 * @param materialId   物品ID
	 * @param actummpkguId 物品包装单位ID
	 * @param priAct       入库价(当物品是加成率模式或者是零差价模式时必须指定)
	 * @return 零售单价
	 * @throws BizException
	 */
	FDouble getMmStockSalePrice(String materialId, String actummpkguId, FDouble priAct) throws BizException;

	FDouble getMmStockSalePriceByDO(MeterialDO mmDO, String actummpkguId, FDouble priAct) throws BizException;

	/**
	 * 物品数量或者金额从原包装单位换算为新的包装单位.
	 * 
	 * @param materialId
	 * @param srcNum
	 * @param srcPackageUnitId
	 * @param desPackageUnitId
	 * @return
	 * @throws BizException
	 */
	FDouble packageUnitConversion(String type, FDouble srcNum, String srcPackageUnitId, String desPackageUnitId)
			throws BizException;

	/**
	 * 获取物品生产厂商信息.
	 * 
	 * @param materialId
	 * @return
	 * @throws BizException
	 */
	SupplierDO findSupplierInfo(String materialId) throws BizException;

	/**
	 * 获取物品在对应仓库中的默认包装单位.
	 * 
	 * @param materialId
	 * @param whId
	 * @return
	 * @throws BizException
	 */
	MMPackageUnitDO findDefPackageUnit(String materialId, String whId) throws BizException;

	/**
	 * 获取物品指定包装类型的包装单位.
	 * 
	 * @param meterialId
	 * @param mmPkguType
	 * @return
	 * @throws BizException
	 */
	MMPackageUnitDO findPackUnitByType(String mmPkguType, String meterialId) throws BizException;

	/**
	 * 获取物品指定服务项目关联属性.
	 * 
	 * @param meterialId
	 * @param mmPkguType
	 * @return
	 * @throws BizException
	 */
	MeterialDO[] getMedSrvInfo(MeterialDO[] meterialDOS) throws BizException;

	/**
	 * 根据物品基本分类初始化仓库与物品关系
	 * 
	 * @param where
	 * @return 数组
	 * @throws BizException
	 */
	public WarehouseInfoDO[] initWareInfoByMmca(MeterialDO meterialDO) throws BizException;

	/**
	 * 更新医疗物品基本包装单位及零售包装单位.
	 * 
	 * @param meterialAggDO
	 * @return
	 * @throws BizException
	 */
	public MeterialAggDO updateBaseAndSellPackageUnit(MeterialAggDO meterialAggDO) throws BizException;

	/**
	 * 获取指定物品主键的物品基本信息.
	 * 
	 * @param meterialId
	 * @return
	 * @throws BizException
	 */
	public MeterialDO[] findMaterialByIDS(String[] id_mms) throws BizException;

	/**
	 * 获取指定物品主键的物品基本信息.
	 * 
	 * @param meterialId
	 * @return
	 * @throws BizException
	 */
	public MeterialDO findMaterialByID(String id_mm) throws BizException;

	/**
	 * 获取指定物品编码的物品基本信息.
	 * 
	 * @param meterialId
	 * @return
	 * @throws BizException
	 */
	public MeterialDO findMaterialByCode(String mm_code) throws BizException;

	/**
	 * 物品基本信息数据校验
	 */
	public String CheckValidate(Boolean fg_update) throws BizException;

	/**
	 * 获取重复药品（“商品名+规格+生产厂家” 相同）
	 * 
	 * @param meterialDOs
	 * @return
	 * @throws BizException
	 */
	public MeterialDO getRepeatMeterial(MeterialDO meterialDO) throws BizException;

	/**
	 * 更新物品规格
	 * 
	 * @param materials 物品集合
	 * @return 更新规格后的物品集合
	 * @throws BizException
	 */
	public abstract MeterialDO[] updateMaterialSpec(MeterialDO[] materials) throws BizException;
	
	/**
	 *更新药品缓存
	 * 
	 */
	public void updateMaterialCache(MeterialDO meterialDO) throws BizException;
	
	/**
	 * 耗材基本信息数据导入。
	 * @param mmCategoryDOList 导入数据
	 * @return 
	 * @throws BizException
	 */
	public void importMcSaniBaseInfo(MeterialDO[] meterialDOs) throws BizException;
	
	/**
	 * 获取物品编码规则是否是前编码
	 */
	public boolean getIsPreBillCode(String className) throws BizException;
	
	/**
	 * 获取物品编码
	 */
	public String getBillCode(MeterialDO mmDO) throws BizException;
	
	/**
	 * 重新加载药品基本信息缓存
	 */
	public void reloadMmCache() throws BizException;
}
