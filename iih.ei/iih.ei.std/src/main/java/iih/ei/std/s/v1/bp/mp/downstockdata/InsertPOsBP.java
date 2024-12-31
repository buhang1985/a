package iih.ei.std.s.v1.bp.mp.downstockdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.TransactionStatus;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IMmDictCodeConst;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMMPackageUnitDORService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.supplier.i.ISupplierRService;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseRService;
import iih.ei.std.d.v1.mp.purchasedrug.d.PurchaseDrugInfo;
import iih.ei.std.d.v1.mp.purchasedrug.d.PurchaseDrugMajor;
import iih.mm.po.purchase.d.PurchaseOrderDO;
import iih.mm.po.purchase.i.IPurchaseMDORService;
import iih.mm.st.stockin.d.StockInDO;
import iih.mm.st.stockin.d.StockInItemDO;
import iih.mm.st.stockin.d.StockinAggDO;
import iih.mm.st.stockin.i.IStockinCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @ClassName: InsertPOsBP
 * @Description: 插入采购入库（新建状态）数据
 * @author zhy
 * @date 2019年10月17日
 *
 */

public class InsertPOsBP {

	Map<String, PurchaseOrderDO> purchaseOrderMap = new HashMap<>();// 订单
	Map<String, WarehouseDO> wareHouseMap = new HashMap<>();// 仓库
	Map<String, SupplierDO> supplierMap = new HashMap<>();// 供应商
	Map<String, SupplierDO> mfrsMap = new HashMap<>();// 厂商
	Map<String, MeterialDO> meterialMap = new HashMap<>();// 医疗物品
	Map<String, List<MMPackageUnitDO>> mMPackageUnitMap = new HashMap<>();// 医疗物品单位

	/**
	 * 程序入口
	 * 
	 * @param purchasedruginfo
	 * @param idList
	 * @throws BizException
	 */
	public void exec(FArrayList purchasedrugmajor, List<String> idList) throws BizException {

		// 1.初始化入参数据
		initBaseData(purchasedrugmajor);

		// 2.插入采购入库
		insertPo(purchasedrugmajor, idList);

	}

	/**
	 * 初始化数据
	 * 
	 * @param purchasedruginfo
	 * @throws BizException
	 */
	private void initBaseData(FArrayList purchasedrugmajor) throws BizException {

		IPurchaseMDORService iPurchaseMDORService = ServiceFinder.find(IPurchaseMDORService.class);
		IWarehouseRService iWarehouseRService = ServiceFinder.find(IWarehouseRService.class);
		ISupplierRService iSupplierRService = ServiceFinder.find(ISupplierRService.class);
		IMeterialMDORService mdorService = ServiceFinder.find(IMeterialMDORService.class);
		IMMPackageUnitDORService unitDORService = ServiceFinder.find(IMMPackageUnitDORService.class);

		List<String> wareHouseCodes = new ArrayList<>();
		List<String> supplierCodes = new ArrayList<>();
		List<String> purchaseOrderCodes = new ArrayList<>();
		List<String> meterialCodes = new ArrayList<>();
		List<String> mfrsCodes = new ArrayList<>();

		for (Object object : purchasedrugmajor) {
			PurchaseDrugMajor purchDgMajor = (PurchaseDrugMajor) object;
			if (!wareHouseCodes.contains(purchDgMajor.getCode_wh())) {
				wareHouseCodes.add(purchDgMajor.getCode_wh());
			}
			if (!supplierCodes.contains(purchDgMajor.getCode_sup())) {
				supplierCodes.add(purchDgMajor.getCode_sup());
			}
			if (!purchaseOrderCodes.contains(purchDgMajor.getCode_po())) {
				purchaseOrderCodes.add(purchDgMajor.getCode_po());
			}

			FArrayList purchasedruginfo = purchDgMajor.getPurchasedruginfo();
			if (purchasedruginfo != null && purchasedruginfo.size() > 0) {
				for (Object obj : purchasedruginfo) {
					PurchaseDrugInfo purchaseDgInfo = (PurchaseDrugInfo) obj;
					if (!meterialCodes.contains(purchaseDgInfo.getCode_dg())) {
						meterialCodes.add(purchaseDgInfo.getCode_dg());
					}
					if (!mfrsCodes.contains(purchaseDgInfo.getCode_mfrs())) {
						mfrsCodes.add(purchaseDgInfo.getCode_mfrs());
					}
				}
			}
		}
		PurchaseOrderDO[] purchaseOrderDOs = iPurchaseMDORService.findByAttrValStrings("Code",
				purchaseOrderCodes.toArray(new String[0]));
		WarehouseDO[] warehouseDOs = iWarehouseRService.findByAttrValStrings("Code",
				wareHouseCodes.toArray(new String[0]));
		SupplierDO[] supplierDOs = iSupplierRService.findByAttrValStrings("Code", supplierCodes.toArray(new String[0]));
		SupplierDO[] mfrsDOs = iSupplierRService.findByAttrValStrings("Code", mfrsCodes.toArray(new String[0]));
		MeterialDO[] meterialDOs = mdorService.findByAttrValStrings("Code", meterialCodes.toArray(new String[0]));

		List<String> meterialIds = new ArrayList<>();
		for (MeterialDO meterial : meterialDOs) {
			if (!meterialIds.contains(meterial.getId_mm())) {
				meterialIds.add(meterial.getId_mm());
			}
		}

		MMPackageUnitDO[] packageUnitDOs = unitDORService.findByAttrValStrings("Id_mm",
				meterialIds.toArray(new String[0]));

		if (purchaseOrderDOs != null && purchaseOrderDOs.length > 0) {
			for (PurchaseOrderDO purchaseOrderDO : purchaseOrderDOs) {
				if (!purchaseOrderMap.containsKey(purchaseOrderDO.getCode())) {
					purchaseOrderMap.put(purchaseOrderDO.getCode(), purchaseOrderDO);
				}
			}
		}
		if (warehouseDOs != null && warehouseDOs.length > 0) {
			for (WarehouseDO warehouseDO : warehouseDOs) {
				if (!wareHouseMap.containsKey(warehouseDO.getCode())) {
					wareHouseMap.put(warehouseDO.getCode(), warehouseDO);
				}
			}
		}
		if (supplierDOs != null && supplierDOs.length > 0) {
			for (SupplierDO supplierDO : supplierDOs) {
				if (!supplierMap.containsKey(supplierDO.getCode())) {
					supplierMap.put(supplierDO.getCode(), supplierDO);
				}
			}
		}
		if (mfrsDOs != null && mfrsDOs.length > 0) {
			for (SupplierDO mfrsDO : mfrsDOs) {
				if (!mfrsMap.containsKey(mfrsDO.getCode())) {
					mfrsMap.put(mfrsDO.getCode(), mfrsDO);
				}
			}
		}
		if (meterialDOs != null && meterialDOs.length > 0) {
			for (MeterialDO meterialDO : meterialDOs) {
				if (!meterialMap.containsKey(meterialDO.getCode())) {
					meterialMap.put(meterialDO.getCode(), meterialDO);
				}
			}
		}
		if (packageUnitDOs != null && packageUnitDOs.length > 0) {
			for (MMPackageUnitDO packageUnitDO : packageUnitDOs) {
				if (!mMPackageUnitMap.containsKey(packageUnitDO.getId_mm())) {
					List<MMPackageUnitDO> packList = new ArrayList<>();
					packList.add(packageUnitDO);
					mMPackageUnitMap.put(packageUnitDO.getId_mm(), packList);
				} else {
					List<MMPackageUnitDO> packList = mMPackageUnitMap.get(packageUnitDO.getId_mm());
					packList.add(packageUnitDO);
				}
			}
		}

	}

	/**
	 * 插入采购入库
	 * 
	 * @param whPOMap
	 * @param idList
	 */
	private void insertPo(FArrayList purchasedrugmajor, List<String> idList) {

		for (Object obj : purchasedrugmajor) {
			PurchaseDrugMajor purchDgMajor = (PurchaseDrugMajor) obj;
			FArrayList purchasedruginfos = purchDgMajor.getPurchasedruginfo();
			insertPo(purchDgMajor, purchasedruginfos, idList);

		}
	}

	private void insertPo(final PurchaseDrugMajor purchDgMajor, final FArrayList purchasedruginfos,
			List<String> idList) {

		// 每一个入库单 ， 单独开启一个事务，如果入库失败之后，返回入库单序号给智能工具
		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus arg0) {
					try {
						InsertPOs(purchDgMajor, purchasedruginfos);
					} catch (Exception e) {
						throw new BizRuntimeException(e.getMessage(), e);
					}
					return null;
				}

			});
		} catch (Exception ex) {
			for (Object obj : purchasedruginfos) {
				PurchaseDrugInfo purchaseDgInfo = (PurchaseDrugInfo) obj;
				idList.add(purchaseDgInfo.getId() + ex.getMessage());
			}
		}

	}

	/**
	 * 生成MM_IN,MM_IN_ITM数据
	 * 
	 * @param whCode
	 * @param supCode
	 * @param list
	 */
	private void InsertPOs(PurchaseDrugMajor purchDgMajor, FArrayList purchasedruginfos) throws BizException {
		// 入库单生成
		StockinAggDO stockinAggDO = new StockinAggDO();
		// 出库单主信息设置
		this.setPurchOrderMainInfo(purchDgMajor, stockinAggDO);

		List<StockInItemDO> stockInItemDOs = new ArrayList<>();

		for (Object obj : purchasedruginfos) {
			PurchaseDrugInfo purchaseDgInfo = (PurchaseDrugInfo) obj;
			StockInItemDO stockInItemDO = new StockInItemDO();
			// 出库单明细信息设置
			this.setPurchOrderItemInfo(stockInItemDO, purchaseDgInfo, stockinAggDO);
			stockInItemDOs.add(stockInItemDO);
		}

		stockinAggDO.setStockInItemDO(stockInItemDOs.toArray(new StockInItemDO[0]));
		// 入库单保存
		saveStockOut(stockinAggDO);

	}

	/**
	 * 出库单主信息设置
	 * 
	 * @param whCode
	 * @param supCode
	 * @param dt_orig
	 * @param stockinAggDO
	 * @throws BizException
	 */
	private void setPurchOrderMainInfo(PurchaseDrugMajor purchDgMajor, StockinAggDO stockinAggDO) throws BizException {
		StockInDO stockInDO = new StockInDO();
		stockInDO.setStatus(DOStatus.NEW);
		stockInDO.setId_grp(Context.get().getGroupId());
		stockInDO.setId_org(Context.get().getOrgId());
		stockInDO.setRed_blue(FBoolean.FALSE);
		stockInDO.setSd_sttp(IMmDictCodeConst.SD_STTP_IN_CAIGOU);
		stockInDO.setId_mmstca("@@@@Z7100000000E6W3K");
		if (StringUtils.isEmpty(purchDgMajor.getCode_wh()) || wareHouseMap.get(purchDgMajor.getCode_wh()) == null) {
			throw new BizException("入参仓库为null");
		}
		stockInDO.setId_wh(wareHouseMap.get(purchDgMajor.getCode_wh()).getId_wh());
		if (StringUtils.isEmpty(purchDgMajor.getCode_sup()) || supplierMap.get(purchDgMajor.getCode_sup()) == null) {
			throw new BizException("入参供应商为null");
		}
		stockInDO.setId_sup(supplierMap.get(purchDgMajor.getCode_sup()).getId_sup());
		if (StringUtils.isEmpty(purchDgMajor.getCode_po()) || purchaseOrderMap.get(purchDgMajor.getCode_po()) == null) {
			throw new BizException("入参订单号为null");
		}
		stockInDO.setId_po(purchaseOrderMap.get(purchDgMajor.getCode_po()).getId_po());
		stockInDO.setId_su_st("@@@@AA1000000001I3J6");
		stockInDO.setSd_su_st("0");
		if (StringUtils.isNotEmpty(purchDgMajor.getDt_orig())) {
			stockInDO.setDt_orig(new FDate(purchDgMajor.getDt_orig()));
		}
		stockInDO.setFg_inv(FBoolean.FALSE);
		stockInDO.setFg_pay(FBoolean.FALSE);
		stockInDO.setRate_actual(new FDouble(1));
		stockInDO.setYear_month(AppUtils.getServerDateTime().toString());
		stockInDO.setId_emp_st(Context.get().getStuffId());
		stockInDO.setDt_st(AppUtils.getServerDateTime());
		stockInDO.setDt_st_short(AppUtils.getServerDate());
		stockInDO.setCreatedby(Context.get().getUserId());
		stockInDO.setCreatedtime(AppUtils.getServerDateTime());
		stockinAggDO.setParentDO(stockInDO);

	}

	/**
	 * 出库单明细信息设置
	 * 
	 * @param stockInItemDO
	 * @param purchaseDrug
	 * @param stockinAggDO
	 * @throws BizException
	 */
	private void setPurchOrderItemInfo(StockInItemDO stockInItemDO, PurchaseDrugInfo purchaseDrug,
			StockinAggDO stockinAggDO) throws BizException {
		stockInItemDO.setSortno(new Integer(purchaseDrug.getId()));
		if (StringUtils.isNotEmpty(purchaseDrug.getOrig_code())) {
			stockInItemDO.setOrig_code(purchaseDrug.getOrig_code());
		}
		if (StringUtils.isEmpty(purchaseDrug.getCode_dg()) || meterialMap.get(purchaseDrug.getCode_dg()) == null) {
			throw new BizException("第【" + purchaseDrug.getId() + "】条数据，药品编码为null或者不存在");
		}
		String id_mm = meterialMap.get(purchaseDrug.getCode_dg()).getId_mm();
		stockInItemDO.setId_mm(id_mm);
		List<MMPackageUnitDO> packageUnitDOs = mMPackageUnitMap.get(id_mm);
		if (packageUnitDOs != null && packageUnitDOs.size() > 0) {
			for (MMPackageUnitDO mmPackageUnitDO : packageUnitDOs) {
				if ("0".equals(mmPackageUnitDO.getSd_mmpkgupro())) {
					stockInItemDO.setId_mmpkgu_base(mmPackageUnitDO.getId_mmpkgu());
				}
				if ("1".equals(mmPackageUnitDO.getSd_mmpkgupro())) {
					stockInItemDO.setId_mmpkgu_sp(mmPackageUnitDO.getId_mmpkgu());
				}
			}
		}
		if (StringUtils.isEmpty(purchaseDrug.getCode_pkgu())) {
			throw new BizException("第【" + purchaseDrug.getId() + "】条数据，药品单位为null");
		}
		for (MMPackageUnitDO mmPackageUnitDO : packageUnitDOs) {
			if (-1 != purchaseDrug.getCode_pkgu().indexOf(mmPackageUnitDO.getMmpkguname())
					|| -1 != mmPackageUnitDO.getMmpkguname().indexOf(purchaseDrug.getCode_pkgu())) {
				stockInItemDO.setId_mmpkgu_actual(mmPackageUnitDO.getId_mmpkgu());
			}
		}
		if (StringUtils.isEmpty(purchaseDrug.getQuan_actual())) {
			throw new BizException("第【" + purchaseDrug.getId() + "】条数据，药品数量为null");
		}
		stockInItemDO.setQuan_actual(new FDouble(purchaseDrug.getQuan_actual()));
		if (StringUtils.isEmpty(purchaseDrug.getCode_mfrs()) || mfrsMap.get(purchaseDrug.getCode_mfrs()) == null) {
			throw new BizException("第【" + purchaseDrug.getId() + "】条数据，药品厂商为null或者不存在");
		}
		stockInItemDO.setId_sup(mfrsMap.get(purchaseDrug.getCode_mfrs()).getId_sup());
		if (StringUtils.isEmpty(purchaseDrug.getBatch())) {
			throw new BizException("第【" + purchaseDrug.getId() + "】条数据，药品批次为null");
		}
		stockInItemDO.setBatch(purchaseDrug.getBatch());
		if (StringUtils.isEmpty(purchaseDrug.getDate_expi())) {
			throw new BizException("第【" + purchaseDrug.getId() + "】条数据，药品失效期为null");
		}
		stockInItemDO.setDate_expi(new FDate(purchaseDrug.getDate_expi()));
		if (StringUtils.isNotEmpty(purchaseDrug.getDt_orig())) {
			stockInItemDO.setDt_orig(new FDate(purchaseDrug.getDt_orig()));
		}
		if (StringUtils.isEmpty(purchaseDrug.getPri_act())) {
			stockInItemDO.setPri_po(new FDouble(0));
			stockInItemDO.setPri_act(new FDouble(0));
			stockInItemDO.setPri_sa(new FDouble(0));
		}
		stockInItemDO.setPri_po(new FDouble(purchaseDrug.getPri_act()));
		stockInItemDO.setPri_act(new FDouble(purchaseDrug.getPri_act()));
		stockInItemDO.setPri_sa(new FDouble(purchaseDrug.getPri_act()));
		stockInItemDO.setAmt(stockInItemDO.getPri_act().multiply(stockInItemDO.getQuan_actual()));
		stockInItemDO.setFg_pay(FBoolean.FALSE);
		stockInItemDO.setFg_inv(FBoolean.FALSE);
		stockInItemDO.setRate_actual(new FDouble(1));
		stockInItemDO.setFg_finish(FBoolean.FALSE);
	}

	/**
	 * 保存入库单
	 * 
	 * @param stockinAggDO
	 * @throws BizException
	 */
	private void saveStockOut(StockinAggDO stockinAggDO) throws BizException {
		IStockinCudService iStockinCudService = ServiceFinder.find(IStockinCudService.class);
		StockinAggDO[] stockinAggDOs = iStockinCudService.insert(new StockinAggDO[] { stockinAggDO });
		if (stockinAggDOs == null || stockinAggDOs.length <= 0) {
			throw new BizException("插入采购入库数据失败。");
		}
	}
}
