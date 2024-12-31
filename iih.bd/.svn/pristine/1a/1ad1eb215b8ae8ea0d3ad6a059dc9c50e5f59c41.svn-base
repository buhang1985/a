package iih.bd.mm.meterial.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.supplier.d.SupplierDO;
import iih.bd.mm.supplier.i.ISupplierRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.utils.BdMmParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

public class MaterialCuBeforeBp {

	public void exec(MeterialAggDO[] mmAggDOS, MeterialAggDO[] originvos) throws BizException {

		// ■ 参数校验
		this.validaPara(mmAggDOS);

		// ■ 中断逻辑，xuxing_2019年9月24日12:20:51
		if(!isCheck(mmAggDOS))
			return;
		
		// ■ 判断药品数据是否合法
		this.checkCanUpdate(mmAggDOS, originvos);

		// ■ 关联字段内容设置
		this.setupRelProperties(mmAggDOS);
	}

	private void validaPara(MeterialAggDO[] mmAggDOS) throws BizException {

		if (mmAggDOS == null || mmAggDOS.length <= 0) {

			throw new BizException("传入物品基本信息为空。");
		}
	}

	/**
	 * 此逻辑中排除耗材与器械的物品信息
	 * @param mmAggDOS
	 * @return
	 */
	private boolean isCheck(MeterialAggDO[] mmAggDOS) {
		if (mmAggDOS == null || mmAggDOS.length < 1)
			return false;
		for (MeterialAggDO mmAggDO : mmAggDOS) {
			MeterialDO parent = mmAggDO.getParentDO();
			if (StringUtils.isEmpty(parent.getSd_mmtp()))
				continue;
			if (parent.getSd_mmtp().substring(0, 1).equals(IBdMmDictCodeConst.SD_MMTP_WEISHENG))
				return false;
			if (parent.getSd_mmtp().substring(0, 1).equals(IBdMmDictCodeConst.SD_MMTP_QIXIE))
				return false;
		}
		return true;
	}
	
	private void checkCanUpdate(MeterialAggDO[] mmAggDOS, MeterialAggDO[] originvos) throws BizException {

		// 零售单位、基本单位、重量单位和体积单位中是否包含医学单位
		this.checkMedUnit(mmAggDOS);

		// 物品的价格管理信息是否允许修改
		this.checkPriceInfo(mmAggDOS, originvos);
	}

	private void checkMedUnit(MeterialAggDO[] mmAggDOS) throws BizException {

		// 医疗服务获取
		Map<String, MedSrvDO> medSrvMap = this.getMedSrvMap(mmAggDOS);

		// 医疗服务对应医学单位获取
		Map<String, MeasDocDO> measdocMap = this.getMeasdocMap(medSrvMap);

		// 零售单位、基本单位、重量单位和体积单位中是否包含医学单位
		this.checkMedUnit(mmAggDOS, medSrvMap, measdocMap);
	}

	private Map<String, MedSrvDO> getMedSrvMap(MeterialAggDO[] mmAggDOS) throws BizException {

		IMedsrvMDORService medRSrv = ServiceFinder.find(IMedsrvMDORService.class);

		Map<String, MedSrvDO> result = new HashMap<String, MedSrvDO>();
		String[] srvIdList = this.getSrvIdList(mmAggDOS);
		MedSrvDO[] medSrvDOS = medRSrv.findByIds(srvIdList, FBoolean.TRUE);
		if (medSrvDOS == null || medSrvDOS.length <= 0) {

			return result;
		}

		for (MedSrvDO medSrvDO : medSrvDOS) {

			result.put(medSrvDO.getId_srv(), medSrvDO);
		}

		return result;
	}

	private String[] getSrvIdList(MeterialAggDO[] mmAggDOS) throws BizException {

		List<String> srvIdList = new ArrayList<String>();

		for (MeterialAggDO mmAggDO : mmAggDOS) {

			srvIdList.add(mmAggDO.getParentDO().getId_srv());
		}

		return srvIdList.toArray(new String[srvIdList.size()]);
	}

	private Map<String, MeasDocDO> getMeasdocMap(Map<String, MedSrvDO> medSrvMap) throws BizException {

		IMeasdocRService measdocRSrv = ServiceFinder.find(IMeasdocRService.class);

		Map<String, MeasDocDO> result = new HashMap<String, MeasDocDO>();
		String[] unitIdList = this.getUnitIdList(medSrvMap);
		if (unitIdList == null || unitIdList.length <= 0) {

			return result;
		}

		MeasDocDO[] measdocDOS = measdocRSrv.findByIds(unitIdList, FBoolean.TRUE);
		if (measdocDOS == null || measdocDOS.length <= 0) {

			return result;
		}
		for (MeasDocDO measdocDO : measdocDOS) {

			result.put(measdocDO.getId_measdoc(), measdocDO);
		}

		return result;
	}

	private String[] getUnitIdList(Map<String, MedSrvDO> medSrvMap) {

		List<String> unitIdList = new ArrayList<String>();

		for (MedSrvDO medSrvDO : medSrvMap.values()) {

			if (!StringUtils.isBlank(medSrvDO.getId_unit_med())) {

				unitIdList.add(medSrvDO.getId_unit_med());
			}
		}

		return unitIdList.toArray(new String[unitIdList.size()]);
	}

	private void checkMedUnit(MeterialAggDO[] mmAggDOS, Map<String, MedSrvDO> medSrvMap,
			Map<String, MeasDocDO> measdocMap) throws BizException {

		String drugMCPropMM = BdMmParamUtils.GetDrugMCPropMM();

		for (MeterialAggDO mmAggDO : mmAggDOS) {

			MeterialDO mmDO = mmAggDO.getParentDO();
			if (mmDO.getSd_mmtp().startsWith(IBdMmDictCodeConst.SD_MMTP_WEISHENG) || mmDO.getSd_mmtp().startsWith(IBdMmDictCodeConst.SD_MMTP_QIXIE)) {
				continue;
			}

			String Id_unit_med = GetIdUnitMed(mmDO, medSrvMap, measdocMap);

			if (!Id_unit_med.equals(mmDO.getId_unit_volbase()) && !Id_unit_med.equals(mmDO.getId_unit_weight())
					&& !Id_unit_med.equals(mmDO.getId_unit_pkgbase()) && !Id_unit_med.equals(mmDO.getId_unit_pkgsp())) {
				String msg = String.format("药品【%s】的零售单位、基本单位、重量单位和体积单位中必须包含%s。", mmDO.getName(),
						IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugMCPropMM) ? "默认剂量单位" : "医学单位");
				throw new BizException(msg);
			}
		}
	}

	/**
	 * 根据参数获取药品的默认剂量单位
	 * 
	 * @param mmDO
	 * @param medSrvMap
	 * @param measdocMap
	 * @return
	 * @throws BizException
	 */
	private String GetIdUnitMed(MeterialDO mmDO, Map<String, MedSrvDO> medSrvMap, Map<String, MeasDocDO> measdocMap)
			throws BizException {
		String drugMCPropMM = BdMmParamUtils.GetDrugMCPropMM();
		if (IBdMmParamValueConst.DRUGMCPROPMM_SRV.equals(drugMCPropMM)) {
			MedSrvDO medSrvDO = medSrvMap.get(mmDO.getId_srv());
			if (medSrvDO == null) {

				throw new BizException(String.format("药品【%s】关联的医疗服务不存在。", mmDO.getName()));
			}
			if (StringUtils.isBlank(medSrvDO.getId_unit_med())) {

				throw new BizException(String.format("药品【%s】关联的医疗服务【%s】没有设定医学单位。", mmDO.getName(), mmDO.getSrv_name()));
			}
			if (!measdocMap.containsKey(medSrvDO.getId_unit_med())) {

				throw new BizException(
						String.format("药品【%s】关联的医疗服务【%s】设定的医学单位不存在。", mmDO.getName(), mmDO.getSrv_name()));
			}
			return medSrvDO.getId_unit_med();
		} else if (IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugMCPropMM)) {
			if (StringUtils.isEmpty(mmDO.getId_unit_med())) {
				throw new BizException("药品的默认计量单位为空。");
			}
			return mmDO.getId_unit_med();
		}
		return null;
	}

	private void checkPriceInfo(MeterialAggDO[] mmAggDOS, MeterialAggDO[] originvos) throws BizException {

		if (originvos == null || originvos.length <= 0) {

			return;
		}

		// 更新前DO信息
		Map<String, MeterialAggDO> oriMmAggDOMap = this.getOriMmAggDOMap(originvos);
		for (MeterialAggDO mmAggDO : mmAggDOS) {

			MeterialAggDO oriMmAggDO = oriMmAggDOMap.get(mmAggDO.getParentDO().getId_mm());
			// 物品价格 信息是否发生改变
			Boolean priceInfoChanged = this.comparePriceInfo(mmAggDO, oriMmAggDO);
			if (priceInfoChanged) {

				MeterialDO mmDO = mmAggDO.getParentDO();
				MeterialRefCheckBp refChkBp = new MeterialRefCheckBp();
				// 物品是否有期初数据
				if (refChkBp.isStockPerInitExist(new String[] { mmDO.getId_mm() })) {

					throw new BizException(
							String.format("物品【%s】存在期初数据，不可修改包装单位信息、换算系数、价格信息、价格管理、批次管理和效期管理标志。", mmDO.getName()));
				}
				// 物品是否有入库数据
				if (refChkBp.isStockIn(new String[] { mmDO.getId_mm() })) {

					throw new BizException(
							String.format("物品【%s】存在入库数据，不可修改包装单位信息、换算系数、价格信息、价格管理、批次管理和效期管理标志。", mmDO.getName()));
				}
				// 物品是否有结存数据
				if (refChkBp.isStockExist(new String[] { mmDO.getId_mm() })) {

					throw new BizException(
							String.format("物品【%s】存在结存数据，不可修改包装单位信息、换算系数、价格信息、价格管理、批次管理和效期管理标志。", mmDO.getName()));
				}
			}
		}
	}

	private Map<String, MeterialAggDO> getOriMmAggDOMap(MeterialAggDO[] originvos) {

		Map<String, MeterialAggDO> result = new HashMap<String, MeterialAggDO>();
		for (MeterialAggDO mmAggDO : originvos) {

			result.put(mmAggDO.getParentDO().getId_mm(), mmAggDO);
		}

		return result;
	}

	private Boolean comparePriceInfo(MeterialAggDO mmAggDO, MeterialAggDO oriMmAggDO) throws BizException {

		// 物品基本信息
		MeterialDO mmDO = mmAggDO.getParentDO();
		MeterialDO oriMmDO = oriMmAggDO.getParentDO();
		// 物品包装单位信息
		MMPackageUnitDO[] pkgUnitDOS = mmAggDO.getMMPackageUnitDO();
		MMPackageUnitDO[] oriPkgUnitDOS = oriMmAggDO.getMMPackageUnitDO();
		Map<String, MMPackageUnitDO> oriPkgMap = new HashMap<String, MMPackageUnitDO>();
		for (MMPackageUnitDO mmPkgUnitDO : oriPkgUnitDOS) {

			oriPkgMap.put(mmPkgUnitDO.getId_mmpkgu(), mmPkgUnitDO);
		}

		// 非卫材类物品校验
		if (!(mmDO.getSd_mmtp().startsWith(IBdMmDictCodeConst.SD_MMTP_WEISHENG) || mmDO.getSd_mmtp().startsWith(IBdMmDictCodeConst.SD_MMTP_QIXIE))) {

			// 医基换算系数是否发生改变
			FBoolean canUpdateMedfactor = BdMmParamUtils.GetMedfactorCanUpdate();
			if (!canUpdateMedfactor.booleanValue() && mmDO.getFactor_mb().compareTo(oriMmDO.getFactor_mb()) != 0) {

				return true;
			}
			
			// 售价管理模式是否发生改变
			if (!mmDO.getSd_pap().equals(oriMmDO.getSd_pap())) {

				return true;
			}
			// 售价计算方式是否发生改变
			if (!mmDO.getSd_primode().equals(oriMmDO.getSd_primode())) {

				return true;
			}
			// 零售价是否发生改变(固定价时)
			if (IBdMmDictCodeConst.SD_PRIMODE_FIX.equals(mmDO.getSd_primode())
					&& ((oriMmDO.getPrice() == null && mmDO.getPrice() != null)
							|| mmDO.getPrice().compareTo(oriMmDO.getPrice()) != 0)) {

				return true;
			}
			// 加成率是否发生改变(加成率计算时)
			if (IBdMmDictCodeConst.SD_PRIMODE_RATE.equals(mmDO.getSd_primode())
					&& mmDO.getRate_pap().compareTo(oriMmDO.getRate_pap()) != 0) {

				return true;
			}
			// 包装单位信息是否发生改变
			for (MMPackageUnitDO pkgUnitDO : pkgUnitDOS) {

				if (pkgUnitDO.getStatus() == DOStatus.NEW) {

					continue;
				}
				if (pkgUnitDO.getStatus() == DOStatus.DELETED) {

					return true;
				}
				MMPackageUnitDO oriPkgUnitDO = oriPkgMap.get(pkgUnitDO.getId_mmpkgu());
				if (!pkgUnitDO.getId_unit_pkg().equals(oriPkgUnitDO.getId_unit_pkg())
						|| !pkgUnitDO.getId_mmpkgutp().equals(oriPkgUnitDO.getId_mmpkgutp())
						|| pkgUnitDO.getFactor().compareTo(oriPkgUnitDO.getFactor()) != 0) {

					return true;
				}
			}
		}
		// 批次管理标识是否发生改变
		if (!mmDO.getFg_batch().equals(oriMmDO.getFg_batch())) {

			return true;
		}
		// 效期管理标识是否发生改变
		if(!mmDO.getFg_effective().equals(oriMmDO.getFg_effective())) {
			
			return true;
		}
		// 价格管理标识是否发生改变
		if (!mmDO.getFg_price().equals(oriMmDO.getFg_price())) {

			return true;
		}

		return false;
	}

	private void setupRelProperties(MeterialAggDO[] mmAggDOS) throws BizException {

		// 生产厂商获取
		Map<String, SupplierDO> supDOMap = this.getSupDOMap(mmAggDOS);

		// 包装单位获取
		Map<String, MeasDocDO> measdocMap = this.getMeasdocMap(mmAggDOS);

		for (MeterialAggDO mmAggDO : mmAggDOS) {

			MeterialDO mmDO = mmAggDO.getParentDO();
			// 生产厂家名称
			if (!StringUtils.isBlank(mmDO.getId_sup())) {

				SupplierDO supDO = supDOMap.get(mmDO.getId_sup());
				if (supDO == null) {

					throw new BizException(String.format("物品【%s】对应的生产厂商不存在。", mmDO.getName()));
				}
				mmDO.setSup_name(supDO.getName());
			}
			// 基本包装单位名称
			MeasDocDO baseUnitDO = measdocMap.get(mmDO.getId_unit_pkgbase());
			if (baseUnitDO == null) {

				throw new BizException(String.format("物品【%s】对应的基本包装单位不存在。", mmDO.getName()));
			}
			mmDO.setName_unit_pkgbase(baseUnitDO.getName());
			// 零售包装单位名称
			if (!StringUtils.isBlank(mmDO.getId_unit_pkgsp())) {

				MeasDocDO saleUnitDO = measdocMap.get(mmDO.getId_unit_pkgsp());
				if (saleUnitDO == null) {

					throw new BizException(String.format("物品【%s】对应的零售包装单位不存在。", mmDO.getName()));
				}
				mmDO.setName_unit_pkgsp(saleUnitDO.getName());
			}
		}
	}

	private Map<String, SupplierDO> getSupDOMap(MeterialAggDO[] mmAggDOS) throws BizException {

		ISupplierRService supRSrv = ServiceFinder.find(ISupplierRService.class);

		Map<String, SupplierDO> result = new HashMap<String, SupplierDO>();
		String[] supIdList = this.getSupIdList(mmAggDOS);
		if (supIdList == null || supIdList.length <= 0) {

			return result;
		}
		SupplierDO[] supDOS = supRSrv.findByIds(supIdList, FBoolean.TRUE);
		if (supDOS == null || supDOS.length <= 0) {

			return result;
		}
		for (SupplierDO supDO : supDOS) {

			result.put(supDO.getId_sup(), supDO);
		}

		return result;
	}

	private String[] getSupIdList(MeterialAggDO[] mmAggDOS) {

		List<String> supIdList = new ArrayList<String>();
		for (MeterialAggDO mmAggDO : mmAggDOS) {

			if (StringUtils.isBlank(mmAggDO.getParentDO().getId_sup())) {

				continue;
			}
			supIdList.add(mmAggDO.getParentDO().getId_sup());
		}

		return supIdList.toArray(new String[supIdList.size()]);
	}

	private Map<String, MeasDocDO> getMeasdocMap(MeterialAggDO[] mmAggDOS) throws BizException {

		IMeasdocRService measdocRSrv = ServiceFinder.find(IMeasdocRService.class);

		Map<String, MeasDocDO> result = new HashMap<String, MeasDocDO>();
		String[] unitIdList = this.getUnitIdList(mmAggDOS);
		MeasDocDO[] measdocDOS = measdocRSrv.findByIds(unitIdList, FBoolean.TRUE);
		if (measdocDOS == null || measdocDOS.length <= 0) {

			return result;
		}
		for (MeasDocDO measdocDO : measdocDOS) {

			result.put(measdocDO.getId_measdoc(), measdocDO);
		}

		return result;
	}

	private String[] getUnitIdList(MeterialAggDO[] mmAggDOS) {

		List<String> unitIdList = new ArrayList<String>();
		for (MeterialAggDO mmAggDO : mmAggDOS) {

			unitIdList.add(mmAggDO.getParentDO().getId_unit_pkgbase());
			if (!StringUtils.isBlank(mmAggDO.getParentDO().getId_unit_pkgsp())) {

				unitIdList.add(mmAggDO.getParentDO().getId_unit_pkgsp());
			}
		}

		return unitIdList.toArray(new String[unitIdList.size()]);
	}
}
