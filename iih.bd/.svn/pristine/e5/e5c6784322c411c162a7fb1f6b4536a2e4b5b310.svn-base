package iih.bd.mm.meterial.s.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.common.MmSQLHelper;
import iih.bd.mm.dataimpt.MmDataImptServiceImpl;
import iih.bd.mm.meterial.bp.ChangeStatusBp;
import iih.bd.mm.meterial.bp.McSaniBaseInfoImport;
import iih.bd.mm.meterial.bp.MeterialRefCheckBp;
import iih.bd.mm.meterial.bp.PackageUnitCollectionBp;
import iih.bd.mm.meterial.bp.qry.GetQuickAddMmItemSql;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.mm.meterial.i.IMeterialCudService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.meterial.i.IMeterialRService;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.mm.meterial.s.bp.UpdateMaterialSpecByMaterialsBp;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.mmcategory.i.IMmcategoryRService;
import iih.bd.mm.mmcawareinfo.d.MmcawareinfoDO;
import iih.bd.mm.mmcawareinfo.i.IMmcawareinfoRService;
import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.supplier.i.ISupplierRService;
import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import iih.bd.mm.wahouseunittype.i.IWahouseunittypeRService;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.utils.BdMmParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.custcfg.billcode.d.BillCodeContext;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

public class MeterialServiceImpl implements IMeterialService {

	@Override
	public MeterialDO[] queryMeterials(String categoryId, boolean isRecursive) throws BizException {

		return this.queryMeterials(categoryId, isRecursive, null, null, false);
	}

	private MeterialDO[] queryMeterials(String categoryId, boolean isRecursive, String inWhouseID, String outWhouseID,
			boolean isStockBl) throws BizException {

		IMmcategoryRService mmcaRSrv = ServiceFinder.find(IMmcategoryRService.class);

		MMCategoryDO mmcaDO = mmcaRSrv.findById(categoryId);
		GetQuickAddMmItemSql Sql = new GetQuickAddMmItemSql(categoryId, isRecursive, mmcaDO.getInnercode(), inWhouseID,
				outWhouseID, isStockBl);
		MeterialDO[] queryResult = (MeterialDO[]) AppFwUtil.getDORstWithDao(Sql, MeterialDO.class);

		return queryResult;
	}

	@Override
	public boolean isRefByCustCategory(String[] meterialIds) throws BizException {

		IMeterialMDORService mmRSrv = ServiceFinder.find(IMeterialMDORService.class);
		MeterialDO[] mmDOS = mmRSrv.findByIds(meterialIds, FBoolean.TRUE);

		MeterialRefCheckBp meterialRefCheckBp = new MeterialRefCheckBp();
		return meterialRefCheckBp.isRefByCustCategory(mmDOS);
	}

	@Override
	public boolean isStockExist(String[] meterialIds) throws BizException {

		MeterialRefCheckBp meterialRefCheckBp = new MeterialRefCheckBp();
		return meterialRefCheckBp.isStockExist(meterialIds);
	}

	@Override
	public boolean isStockExistByWh(String whouseID, String meterialId) throws BizException {

		MeterialRefCheckBp meterialRefCheckBp = new MeterialRefCheckBp();
		return meterialRefCheckBp.isStockExistByWh(whouseID, meterialId);
	}

	@Override
	public boolean isStockPerInitExist(String[] meterialIds) throws BizException {

		MeterialRefCheckBp meterialRefCheckBp = new MeterialRefCheckBp();
		return meterialRefCheckBp.isStockPerInitExist(meterialIds);
	}

	@Override
	public boolean isStockIn(String[] meterialIds) throws BizException {

		MeterialRefCheckBp meterialRefCheckBp = new MeterialRefCheckBp();
		return meterialRefCheckBp.isStockIn(meterialIds);
	}

	@Override
	public boolean isSupplierprotocolExist(String[] meterialIds) throws BizException {

		MeterialRefCheckBp meterialRefCheckBp = new MeterialRefCheckBp();
		return meterialRefCheckBp.isSupplierprotocolExist(meterialIds);
	}

	@Override
	public boolean isWarehouseExist(String[] meterialIds) throws BizException {

		MeterialRefCheckBp meterialRefCheckBp = new MeterialRefCheckBp();
		return meterialRefCheckBp.isWarehouseExist(meterialIds);
	}

	@Override
	public boolean isDepartmentExist(String[] meterialIds) throws BizException {

		MeterialRefCheckBp meterialRefCheckBp = new MeterialRefCheckBp();
		return meterialRefCheckBp.isDepartmentExist(meterialIds);
	}

	@Override
	public MeterialDO[] start(MeterialDO[] meterialDOs) throws BizException {

		ChangeStatusBp changeStatusBp = new ChangeStatusBp();
		return changeStatusBp.changeStatus(meterialDOs, FBoolean.TRUE);
	}

	@Override
	public MeterialDO[] stop(MeterialDO[] meterialDOs) throws BizException {

		ChangeStatusBp changeStatusBp = new ChangeStatusBp();
		return changeStatusBp.changeStatus(meterialDOs, FBoolean.FALSE);
	}

	@Override
	public MMPackageUnitDO findBasePackageUnit(String meterialId) throws BizException {

		if (StringUtils.isBlank(meterialId)) {

			throw new BizException("传入物品主键为空.");
		}

		MeterialDO mmDO = this.findMaterialByID(meterialId);
		MMPackageUnitDO packageUnitDO = MaterialCache.getInstance().getBasePackageUnit(meterialId);
		if (packageUnitDO == null) {

			throw new BizException(String.format("获取物品【%s】基本包装单位失败。", mmDO.getName()));
		}

		return packageUnitDO;
	}

	@Override
	public MMPackageUnitDO findSalePackageUnit(String meterialId) throws BizException {

		if (StringUtils.isBlank(meterialId)) {

			throw new BizException("传入物品主键为空.");
		}

		MeterialDO mmDO = this.findMaterialByID(meterialId);
		MMPackageUnitDO packageUnitDO = MaterialCache.getInstance().getSalePackageUnit(meterialId);
		if (packageUnitDO == null) {

			throw new BizException(String.format("获取物品【%s】零售包装单位失败。", mmDO.getName()));
		}

		return packageUnitDO;
	}

	@Override
	public MMPackageUnitDO findPackageUnitById(String mmpkguId) throws BizException {

		if (StringUtils.isBlank(mmpkguId)) {

			throw new BizException("传入包装单位主键为空.");
		}

		MMPackageUnitDO packageUnitDO = MaterialCache.getInstance().getPackageUnit(mmpkguId);
		if (packageUnitDO == null) {

			throw new BizException(String.format("获取物品包装单位失败,物品包装单位Id:%s。", mmpkguId));
		}

		return packageUnitDO;
	}

	@Override
	public MMPackageUnitDO findMmPackageUnitById(String meterialId, String mmpkguId) throws BizException {

		if (StringUtils.isBlank(mmpkguId)) {

			throw new BizException("传入包装单位主键为空.");
		}

		MeterialDO mmDO = this.findMaterialByID(meterialId);
		MMPackageUnitDO packageUnitDO = MaterialCache.getInstance().getPackageUnit(mmpkguId);
		if (packageUnitDO == null) {

			throw new BizException(String.format("获取物品【%s】包装单位失败,物品包装单位Id:%s。", mmDO.getName(), mmpkguId));
		}

		return packageUnitDO;
	}

	@Override
	public FDouble getMaterialSalePrice(String materialId, String actummpkguId, FDouble priAct) throws BizException {

		if (StringUtils.isBlank(materialId)) {

			throw new BizException("物品ID不能为空。");
		}

		if (StringUtils.isBlank(actummpkguId)) {

			throw new BizException("包装单位ID不能为空。");
		}

		// 获取物品零售单位的零售单价
		MeterialDO meterialDO = MaterialCache.getInstance().getMaterialInfoByID(materialId);
		if (meterialDO == null) {

			throw new BizException("物品不存在.");
		}

		if (!meterialDO.getFg_price().booleanValue()) {

			return new FDouble(0);
		}

		// 物品零售价计算方式
		String sdPriceMode = meterialDO.getSd_primode();

		if (IBdMmDictCodeConst.SD_PRIMODE_FIX.equals(sdPriceMode)) {

			// 获取物品零售单位的换算系数
			MMPackageUnitDO pkguDO = this.findSalePackageUnit(materialId);
			FDouble saleFactor = pkguDO.getFactor();

			// 获取指定物品包装单位的换算系数
			MMPackageUnitDO mmPackageUnitDO = findPackageUnitById(actummpkguId);
			FDouble specFactor = mmPackageUnitDO.getFactor();

			return meterialDO.getPrice().multiply((specFactor).div(saleFactor, -16), -16);
		} else if (IBdMmDictCodeConst.SD_PRIMODE_RATE.equals(sdPriceMode)) {

			if (priAct == null) {

				throw new BizException(String.format("物品【%s】为加成率计算时，传入价格不能为空。", meterialDO.getName()));
			}

			// 加成率
			FDouble ratePap = meterialDO.getRate_pap();
			return priAct.multiply((new FDouble(1)).add(ratePap.div(new FDouble(100))), -16);
		} else if (IBdMmDictCodeConst.SD_PRIMODE_ZERO.equals(sdPriceMode)) {

			if (priAct == null) {

				throw new BizException(String.format("物品【%s】为零差价时，传入价格不能为空。", meterialDO.getName()));
			}

			return priAct;
		} else {

			throw new BizException(String.format("没有找到物品【%s】对应的售价计算模式。", meterialDO.getName()));
		}
	}

	@Override
	public FDouble packageUnitConversion(String type, FDouble srcNum, String srcPackageUnitId, String desPackageUnitId)
			throws BizException {

		if (srcNum == null || FDouble.ZERO_DBL.compareTo(srcNum) == 0) {

			return FDouble.ZERO_DBL;
		}

		MMPackageUnitDO srcPackageUnitDO = findPackageUnitById(srcPackageUnitId);
		if (srcPackageUnitDO == null) {

			throw new BizException("获取换算单位失败.");
		}
		FDouble srcFactor = srcPackageUnitDO.getFactor();

		MMPackageUnitDO desPackageUnitDO = findPackageUnitById(desPackageUnitId);
		if (desPackageUnitDO == null) {

			throw new BizException("获取目标换算单位失败.");
		}
		FDouble desFactor = desPackageUnitDO.getFactor();

		if (TYPE_NUM.equals(type)) {

			return srcNum.multiply(srcFactor).div(desFactor);
		} else {

			return srcNum.multiply(desFactor.div(srcFactor, -16), -16);
		}
	}

	@Override
	public SupplierDO findSupplierInfo(String materialId) throws BizException {

		ISupplierRService iSupplierRService = ServiceFinder.find(ISupplierRService.class);

		MeterialDO meterialDO = MaterialCache.getInstance().getMaterialInfoByID(materialId);
		if (meterialDO == null) {

			throw new BizException(String.format("物品不存在。(物品ID:%s)", materialId));
		}
		SupplierDO supplierDO = iSupplierRService.findById(meterialDO.getId_sup());
		if (supplierDO == null) {

			throw new BizException(String.format("物品【%s】对应的生产厂商不存在。", meterialDO.getName()));
		}

		return supplierDO;
	}

	@Override
	public MMPackageUnitDO findDefPackageUnit(String materialId, String whId) throws BizException {

		if (StringUtils.isBlank(whId)) {

			return this.findBasePackageUnit(materialId);
		}

		IWahouseunittypeRService whUnitSrv = ServiceFinder.find(IWahouseunittypeRService.class);
		String whrStr = String.format("id_wh = '%s' and fg_def = 'Y'", whId);
		WahouseUnitTypeDO[] wahouseUnitTypeDO = whUnitSrv.find(whrStr, "", new FBoolean(true));
		if (wahouseUnitTypeDO == null || wahouseUnitTypeDO.length <= 0) {

			return this.findSalePackageUnit(materialId);
		}

		String defPakType = wahouseUnitTypeDO[0].getId_mmpkgutp();
		return this.findPackUnitByType(defPakType, materialId);
	}

	@Override
	public MMPackageUnitDO findPackUnitByType(String mmPkguType, String meterialId) throws BizException {

		if (StringUtils.isBlank(meterialId) || StringUtils.isBlank(mmPkguType)) {

			throw new BizException("传入参数信息不完整.");
		}

		MeterialDO mmDO = this.findMaterialByID(meterialId);
		MMPackageUnitDO packageUnitDO = MaterialCache.getInstance().getPackageUnit_Pkgtp(meterialId, mmPkguType);
		if (packageUnitDO == null) {

			throw new BizException(String.format("获取物品【%s】包装单位失败,包装单位类型Id:%s。", mmDO.getName(), mmPkguType));
		}

		return packageUnitDO;
	}

	@Override
	public MeterialDO[] queryMeterialsByWhRel(String categoryId, boolean isRecursive, String inWhouseID,
			String outWhouseID, boolean isStockBl) throws BizException {

		return queryMeterials(categoryId, isRecursive, inWhouseID, outWhouseID, isStockBl);
	}

	@Override
	public MeterialDO getMaterialByCode(String orgId, String code) throws BizException {

		IMeterialMDORService mmRSrv = ServiceFinder.find(IMeterialMDORService.class);

		String whrStr = String.format("id_org = '%s' and code = '%s'", orgId, code);
		MeterialDO[] meterialDOs = mmRSrv.find(whrStr, "", FBoolean.TRUE);
		if (meterialDOs != null && meterialDOs.length > 0) {

			return meterialDOs[0];
		}

		return null;
	}

	@Override
	public MMPackageUnitDO findPackageUnitByUnitId(String mmId, String unitId) throws BizException {

		if (StringUtils.isBlank(mmId) || StringUtils.isBlank(unitId)) {

			throw new BizException("传入参数信息不完整。");
		}

		MeterialDO mmDO = this.findMaterialByID(mmId);

		MMPackageUnitDO packageUnitDO = MaterialCache.getInstance().getPackageUnit_UnitPkgId(mmId, unitId);

		if (packageUnitDO == null) {

			packageUnitDO = MaterialCache.getInstance().getPackageUnit(unitId);
			if (packageUnitDO == null) {

				throw new BizException(String.format("获取物品【%s】包装单位失败,物品包装单位Id或计量单位Id:%s。", mmDO.getName(), unitId));
			}
		}

		return packageUnitDO;
	}

	@Override
	public void delete(String[] ids) throws BizException {

		IMeterialRService mmRSrv = ServiceFinder.find(IMeterialRService.class);
		MeterialAggDO[] mmAggDOS = mmRSrv.findByBIds(ids, FBoolean.FALSE);
		if (mmAggDOS != null && mmAggDOS.length > 0) {

			IMeterialCudService mmCudSrv = ServiceFinder.find(IMeterialCudService.class);
			mmCudSrv.delete(mmAggDOS);
		}
	}

	@Override
	public void deleteCheck(String[] ids) throws BizException {

		// 判断物品是否存在期初数据
		if (this.isStockPerInitExist(ids)) {

			throw new BizException("物品存在期初数据，不允许删除。");
		}
		// 判断物品是否存在入库数据
		if (this.isStockIn(ids)) {

			throw new BizException("物品存在入库数据，不允许删除。");
		}
		// 判断物品是否存在结存数据
		if (this.isStockExist(ids)) {

			throw new BizException("物品存在结存数据，不允许删除。");
		}
		// 判断物品是否关联自定义分类
		if (this.isRefByCustCategory(ids)) {

			throw new BizException("物品关联了自定义分类项目，不允许删除。");
		}
	}

	@Override
	public MeterialDO[] getMedSrvInfo(MeterialDO[] mmDOS) throws BizException {

		// 医疗服务数据获取
		Map<String, MedSrvDO> medSrvMap = this.getMedSrvMap(mmDOS);

		// 医疗服务药品属性数据获取
		Map<String, MedSrvDrugDO> srvDrugMap = this.getSrvDrugMap(mmDOS);

		return this.setMmSrvInfo(mmDOS, medSrvMap, srvDrugMap);
	}

	private Map<String, MedSrvDO> getMedSrvMap(MeterialDO[] mmDOS) throws BizException {

		IMedsrvMDORService medRSrv = ServiceFinder.find(IMedsrvMDORService.class);

		Map<String, MedSrvDO> result = new HashMap<String, MedSrvDO>();
		String[] srvIdList = this.getSrvIdList(mmDOS);
		if (srvIdList == null || srvIdList.length <= 0) {
			return result;
		}
		MedSrvDO[] medSrvDOS = medRSrv.findByIds(srvIdList, FBoolean.TRUE);
		if (medSrvDOS == null || medSrvDOS.length <= 0) {

			return result;
		}

		for (MedSrvDO medSrvDO : medSrvDOS) {

			result.put(medSrvDO.getId_srv(), medSrvDO);
		}

		return result;
	}

	private String[] getSrvIdList(MeterialDO[] mmDOS) throws BizException {

		List<String> srvIdList = new ArrayList<String>();

		for (MeterialDO mmDO : mmDOS) {
			if (!StringUtils.isEmpty(mmDO.getId_srv())) {
				srvIdList.add(mmDO.getId_srv());
			}
		}

		return srvIdList.toArray(new String[0]);
	}

	private Map<String, MedSrvDrugDO> getSrvDrugMap(MeterialDO[] mmDOS) throws BizException {

		IMedSrvDrugDORService drugRSrv = ServiceFinder.find(IMedSrvDrugDORService.class);

		Map<String, MedSrvDrugDO> result = new HashMap<String, MedSrvDrugDO>();
		String[] srvIdList = this.getSrvIdList(mmDOS);
		if (srvIdList == null || srvIdList.length <= 0) {
			return result;
		}
		MedSrvDrugDO[] srvDrugDOS = drugRSrv.findByAttrValStrings(MedSrvDrugDO.ID_SRV, srvIdList);
		if (srvDrugDOS == null || srvDrugDOS.length <= 0) {

			return result;
		}

		for (MedSrvDrugDO srvDrugDO : srvDrugDOS) {

			result.put(srvDrugDO.getId_srv(), srvDrugDO);
		}

		return result;
	}

	private MeterialDO[] setMmSrvInfo(MeterialDO[] mmDOS, Map<String, MedSrvDO> medSrvMap,
			Map<String, MedSrvDrugDO> srvDrugMap) throws BizException {

		String drugMCPropMM = BdMmParamUtils.GetDrugMCPropMM();

		for (MeterialDO mmDO : mmDOS) {
			if (!StringUtils.isEmpty(mmDO.getId_srv())) {
				MedSrvDO medSrvDO = medSrvMap.get(mmDO.getId_srv());
				if (drugMCPropMM.equals(IBdMmParamValueConst.DRUGMCPROPMM_SRV) && medSrvDO != null) {
					if (StringUtils.isEmpty(medSrvDO.getId_unit_med())) {
						throw new BizException("药品服务关联的医学单位不存在。");
					}
					// 医学单位
					mmDO.setId_unit_med(medSrvDO.getId_unit_med());
					// 医学单位名称
					mmDO.setUnit_med_name(medSrvDO.getMed_name());
					// 医学单位编码
					mmDO.setUnit_med_code(medSrvDO.getMed_code());
				}

				MedSrvDrugDO drugDO = srvDrugMap.get(mmDO.getId_srv());
				if (drugDO != null) {

					// 药品剂型名称
					mmDO.setDosage_name(drugDO.getDs_name());
					// 毒麻分类名称
					mmDO.setPois_cname(drugDO.getName_pois());
					// 抗菌药分类名称
					mmDO.setAnti_name(drugDO.getName_anti());
					// // 适应症
					// mmDO.setIndica(drugDO.getIndica());
					// // 用法用量
					// mmDO.setUsage(drugDO.getUsage());
					// // 不良反应
					// mmDO.setReact(drugDO.getReact());
					// // 禁忌症
					// mmDO.setConstr(drugDO.getConstr());
					// // 注意事项
					// mmDO.setPrecaut(drugDO.getPrecaut());
					// // 药品相互作用
					// mmDO.setInteract(drugDO.getInteract());
				}
			} else {
				// 商品名模式时，使用物品的默认剂量单位
				// // 医学单位
				// mmDO.setId_unit_med(null);
				// // 医学单位名称
				// mmDO.setUnit_med_name(null);
				// // 医学单位编码
				// mmDO.setUnit_med_code(null);

				// 药品剂型名称
				mmDO.setDosage_name(null);
				// 毒麻分类名称
				mmDO.setPois_cname(null);
				// 抗菌药分类名称
				mmDO.setAnti_name(null);
			}
		}

		return mmDOS;
	}

	@Override
	public WarehouseInfoDO[] initWareInfoByMmca(MeterialDO meterialDO) throws BizException {

		// 仓库与物品基本分类关系
		MmcawareinfoDO[] mmcaWareList = this.getMmcaWareInfo(meterialDO.getId_mmca());
		if (mmcaWareList == null || mmcaWareList.length <= 0) {

			return null;
		}
		// 仓库
		Map<String, WarehouseDO> whDOMap = this.getWhDOMap(mmcaWareList);
		if (whDOMap == null || whDOMap.size() <= 0) {

			return null;
		}

		List<WarehouseInfoDO> wareInfoList = new ArrayList<WarehouseInfoDO>();
		for (MmcawareinfoDO mmcaWareDO : mmcaWareList) {

			WarehouseDO houseDO = whDOMap.get(mmcaWareDO.getId_wh());
			WarehouseDO srvWhDO = whDOMap.get(mmcaWareDO.getId_wh_srv());
			if (houseDO == null || srvWhDO == null) {

				continue;
			}

			WarehouseInfoDO wareInfoDO = new WarehouseInfoDO();
			// 集团
			wareInfoDO.setId_grp(Context.get().getGroupId());
			// 机构
			wareInfoDO.setId_org(Context.get().getOrgId());
			// 仓库
			wareInfoDO.setId_wh(mmcaWareDO.getId_wh());
			// 仓库名称
			wareInfoDO.setWh_name(houseDO.getName());
			// 是否按货位
			wareInfoDO.setFg_loc(houseDO.getFg_loc());
			// 物品
			wareInfoDO.setId_mm(meterialDO.getId_mm());
			// 物品名称
			wareInfoDO.setMm_name(meterialDO.getName());
			// 物品编码
			wareInfoDO.setMm_code(meterialDO.getCode());
			// 物品规格
			wareInfoDO.setMm_spec(meterialDO.getSpec());
			// 最高库存_界面包装单位
			wareInfoDO.setMaxuinum(mmcaWareDO.getMaxstnum());
			// 最低库存_界面包装单位
			wareInfoDO.setLowuinum(mmcaWareDO.getLowstnum());
			// 界面包装单位
			MMPackageUnitDO pkgUnitDO = this.findPackUnitByType(mmcaWareDO.getId_mmpkgutp(), meterialDO.getId_mm());
			wareInfoDO.setId_mmpkgu_ui(pkgUnitDO.getId_mmpkgu());
			// 界面包装单位名称
			wareInfoDO.setMmpkguname(pkgUnitDO.getMmpkguname());
			// 响应仓库
			wareInfoDO.setId_wh_srv(mmcaWareDO.getId_wh_srv());
			// 响应仓库名称
			wareInfoDO.setSrv_name(srvWhDO.getName());
			// 启用状态
			wareInfoDO.setFg_active(new FBoolean(true));
			// 停发标志
			wareInfoDO.setFg_out(new FBoolean(false));
			// 所属部门
			wareInfoDO.setId_dep(null);
			// 基数药标志
			wareInfoDO.setFg_base(new FBoolean(false));

			wareInfoList.add(wareInfoDO);
		}

		return wareInfoList.toArray(new WarehouseInfoDO[wareInfoList.size()]);
	}

	private MmcawareinfoDO[] getMmcaWareInfo(String id_mmca) throws BizException {

		IMmcategoryRService mmcaRSrv = ServiceFinder.find(IMmcategoryRService.class);
		IMmcawareinfoRService mmcaWhRSrv = ServiceFinder.find(IMmcawareinfoRService.class);
		MMCategoryDO mmCategoryDO = mmcaRSrv.findById(id_mmca);
		if (mmCategoryDO == null) {

			return null;
		}

		String innercode = this.getInnerCode(mmCategoryDO);
		String whrStr = String.format("id_mmca in (select id_mmca from bd_mmca where %s)", innercode);
		return mmcaWhRSrv.find(whrStr, "", FBoolean.TRUE);
	}

	private String getInnerCode(MMCategoryDO mmCategoryDO) {

		List<String> innerCode = new ArrayList<String>();
		for (int i = 4; i < mmCategoryDO.getInnercode().length(); i = i + 4) {

			innerCode.add(mmCategoryDO.getInnercode().substring(0, i));
		}

		return MmSQLHelper.initInCondition(MMCategoryDO.INNERCODE, innerCode.toArray(new String[innerCode.size()]));
	}

	private Map<String, WarehouseDO> getWhDOMap(MmcawareinfoDO[] mmcaWareList) throws BizException {

		IWarehouseRService whMmRSrv = ServiceFinder.find(IWarehouseRService.class);

		Map<String, WarehouseDO> result = new HashMap<String, WarehouseDO>();
		String[] whIdList = this.getWhIdList(mmcaWareList);
		WarehouseDO[] whDOS = whMmRSrv.findByIds(whIdList, FBoolean.TRUE);
		if (whDOS == null || whDOS.length <= 0) {

			return result;
		}

		for (WarehouseDO whDO : whDOS) {

			result.put(whDO.getId_wh(), whDO);
		}

		return result;
	}

	private String[] getWhIdList(MmcawareinfoDO[] mmcaWareList) {

		List<String> whIdList = new ArrayList<String>();
		for (MmcawareinfoDO whMmcaDO : mmcaWareList) {

			whIdList.add(whMmcaDO.getId_wh());
			whIdList.add(whMmcaDO.getId_wh_srv());
		}

		return whIdList.toArray(new String[whIdList.size()]);
	}

	@Override
	public MeterialAggDO updateBaseAndSellPackageUnit(MeterialAggDO meterialAggDO) throws BizException {

		PackageUnitCollectionBp packageUnitCollectionBp = new PackageUnitCollectionBp();
		return packageUnitCollectionBp.updateBaseAndSellPackageUnit(meterialAggDO);
	}

	@Override
	public FDouble getMmStockSalePrice(String materialId, String actummpkguId, FDouble priAct) throws BizException {

		if (StringUtils.isBlank(materialId)) {

			throw new BizException("物品ID不能为空。");
		}

		if (StringUtils.isBlank(actummpkguId)) {

			throw new BizException("包装单位ID不能为空。");
		}

		// 获取物品零售单位的零售单价
		MeterialDO meterialDO = MaterialCache.getInstance().getMaterialInfoByID(materialId);

		return this.getMmStockSalePriceByDO(meterialDO, actummpkguId, priAct);
	}

	@Override
	public FDouble getMmStockSalePriceByDO(MeterialDO meterialDO, String actummpkguId, FDouble priAct)
			throws BizException {

		if (meterialDO == null) {

			throw new BizException("物品不存在.");
		}

		if (!meterialDO.getFg_price().booleanValue()) {

			return new FDouble(0);
		}

		// 物品零售价计算方式
		String sdPriceMode = meterialDO.getSd_primode();

		if (IBdMmDictCodeConst.SD_PRIMODE_FIX.equals(sdPriceMode)) {

			return meterialDO.getPrice();
		} else if (IBdMmDictCodeConst.SD_PRIMODE_RATE.equals(sdPriceMode)) {

			if (priAct == null) {

				throw new BizException(String.format("物品【%s】为加成率计算时，传入价格不能为空。", meterialDO.getName()));
			}

			// 获取物品零售单位的换算系数
			MMPackageUnitDO pkguDO = this.findSalePackageUnit(meterialDO.getId_mm());
			FDouble saleFactor = pkguDO.getFactor();

			// 获取指定物品包装单位的换算系数
			MMPackageUnitDO mmPackageUnitDO = findPackageUnitById(actummpkguId);
			FDouble specFactor = mmPackageUnitDO.getFactor();

			// 加成率
			FDouble ratePap = meterialDO.getRate_pap();
			return priAct.multiply((new FDouble(1)).add(ratePap.div(new FDouble(100))))
					.multiply(saleFactor.div(specFactor, -16), -16);
		} else if (IBdMmDictCodeConst.SD_PRIMODE_ZERO.equals(sdPriceMode)) {

			if (priAct == null) {

				throw new BizException(String.format("物品【%s】为零差价时，传入价格不能为空。", meterialDO.getName()));
			}

			// 获取物品零售单位的换算系数
			MMPackageUnitDO pkguDO = this.findSalePackageUnit(meterialDO.getId_mm());
			FDouble saleFactor = pkguDO.getFactor();

			// 获取指定物品包装单位的换算系数
			MMPackageUnitDO mmPackageUnitDO = findPackageUnitById(actummpkguId);
			FDouble specFactor = mmPackageUnitDO.getFactor();

			return priAct.multiply(saleFactor.div(specFactor, -16), -16);
		} else {

			throw new BizException(String.format("没有找到物品【%s】对应的售价计算模式。", meterialDO.getName()));
		}
	}

	@Override
	public MeterialDO[] findMaterialByIDS(String[] id_mms) throws BizException {

		if (id_mms == null || id_mms.length <= 0) {

			throw new BizException("物品ID不能为空。");
		}

		List<MeterialDO> result = new ArrayList<MeterialDO>();
		for (String id_mm : id_mms) {

			MeterialDO mmDO = this.findMaterialByID(id_mm);
			result.add(mmDO);
		}

		return result.toArray(new MeterialDO[result.size()]);
	}

	@Override
	public MeterialDO findMaterialByID(String id_mm) throws BizException {

		if (StringUtils.isBlank(id_mm)) {

			throw new BizException("物品ID不能为空。");
		}

		MeterialDO meterialDO = MaterialCache.getInstance().getMaterialInfoByID(id_mm);
		if (meterialDO == null) {

			throw new BizException(String.format("物品不存在。(物品ID:%s)", id_mm));
		}

		return meterialDO;
	}

	@Override
	public MeterialDO findMaterialByCode(String mm_code) throws BizException {

		if (StringUtils.isBlank(mm_code)) {

			throw new BizException("物品编码不能为空。");
		}

		MeterialDO meterialDO = MaterialCache.getInstance().getMaterialInfoByCode(mm_code);

		return meterialDO;
	}

	@Override
	public String CheckValidate(Boolean fg_update) throws BizException {

		MmDataImptServiceImpl valImpl = new MmDataImptServiceImpl();

		return valImpl.CheckValidate(fg_update);
	}

	@Override
	public MeterialDO getRepeatMeterial(MeterialDO meterialDO) throws BizException {
		IMeterialRService meterialRSrv = ServiceFinder.find(IMeterialRService.class);
		String whereStr = String.format("1=1 and name = '%s' and spec = '%s' and Sup_name = '%s' ",
				meterialDO.getName(), meterialDO.getSpec(), meterialDO.getSup_name());
		MeterialAggDO[] meterialAggDOS = meterialRSrv.find(whereStr, "", FBoolean.FALSE);

		if (meterialAggDOS != null && meterialAggDOS.length > 0) {
			return meterialAggDOS[0].getParentDO();
		} else {
			return null;
		}

	}

	@Override
	public MeterialDO[] updateMaterialSpec(MeterialDO[] materials) throws BizException {
		UpdateMaterialSpecByMaterialsBp bp = new UpdateMaterialSpecByMaterialsBp();
		MeterialDO[] result = bp.exec(materials);
		return result;
	}
	
	@Override
	public void updateMaterialCache(MeterialDO meterialDO) throws BizException {
		MaterialCache.getInstance().updateMaterialInfo(new MeterialDO[] {meterialDO});
	}

	@Override
	public void importMcSaniBaseInfo(MeterialDO[] meterialDOs) throws BizException {
		  
		McSaniBaseInfoImport bp = new McSaniBaseInfoImport();
		bp.exec(meterialDOs);
	}
	
	@Override
	public boolean getIsPreBillCode(String className) throws BizException {
		IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
		BillCodeContext context = billcodeManage.getBillCodeContext(MeterialDODesc.CLASS_FULLNAME);
		return context.isPrecode();
	}

	@Override
	public String getBillCode(MeterialDO mmDO) throws BizException {
		IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
		return billcodeManage.getBillCode_RequiresNew(MeterialDODesc.CLASS_FULLNAME, mmDO);
	}

	/**
	 * 重新加载药品基本信息缓存
	 */
	@Override
	public void reloadMmCache() throws BizException {
		MaterialCache.getInstance().reloadMmCache();
	}
}
