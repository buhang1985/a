package iih.bd.mm.meterial.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.packageunit.d.PackageUnitDO;
import iih.bd.mm.packageunit.i.IPackageunitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

public class PackageUnitCollectionBp {

	/**
	 * 更新医疗物品基本包装单位及零售包装单位.
	 * 
	 * @param meterialAggDO
	 * @return
	 * @throws BizException
	 */
	public MeterialAggDO updateBaseAndSellPackageUnit(MeterialAggDO meterialAggDO) throws BizException {

		MeterialDO meterialDO = meterialAggDO.getParentDO();
		// 基本单位和零售单位对应计量单位
		Map<String, MeasDocDO> measdocMap = this.getMeasdocMap(meterialDO);
		// 包装单位类型获取
		Map<String, PackageUnitDO> unitPkgTpMap = this.getUnitPkgTpMap();

		MMPackageUnitDO[] mmPackageUnitDOs = meterialAggDO.getMMPackageUnitDO();
		if (mmPackageUnitDOs != null) {

			// 更新基本包装单位和零售包装单位信息
			this.resetBaseAndSellPkgInfo(meterialDO, mmPackageUnitDOs, measdocMap);
		} else {

			// 生成基本包装单位和零售包装单位信息
			MMPackageUnitDO[] newPkgUnitDOs = this.initBaseAndSellPkgInfo(meterialDO, measdocMap, unitPkgTpMap);
			meterialAggDO.setMMPackageUnitDO(newPkgUnitDOs);
		}

//		if (DOStatus.NEW == meterialDO.getStatus()) {
//			
//			MMPackageUnitDO[] mmPackageUnitDOs = meterialAggDO.getMMPackageUnitDO();
//			if (mmPackageUnitDOs != null) {
//				
//				//更新基本包装单位和零售包装单位信息
//				this.resetBaseAndSellPkgInfo(meterialDO, mmPackageUnitDOs, measdocMap);
//			} else {
//				
//				//生成基本包装单位和零售包装单位信息
//				MMPackageUnitDO[] newPkgUnitDOs = this.initBaseAndSellPkgInfo(meterialDO, measdocMap, unitPkgTpMap);
//				meterialAggDO.setMMPackageUnitDO(newPkgUnitDOs);
//			}
//			
//		} else if (DOStatus.UPDATED == meterialDO.getStatus()) {
//			
//			MMPackageUnitDO[] mmPackageUnitDOs = meterialAggDO.getMMPackageUnitDO();
//			//更新基本包装单位和零售包装单位信息
//			this.resetBaseAndSellPkgInfo(meterialDO, mmPackageUnitDOs, measdocMap);
//		}

		return meterialAggDO;
	}

	private Map<String, MeasDocDO> getMeasdocMap(MeterialDO meterialDO) throws BizException {

		IMeasdocRService measdocService = ServiceFinder.find(IMeasdocRService.class);

		Map<String, MeasDocDO> result = new HashMap<String, MeasDocDO>();
		String[] unitPkgIDS = new String[] { meterialDO.getId_unit_pkgbase(), meterialDO.getId_unit_pkgsp() };
		MeasDocDO[] measdocDOS = measdocService.findByIds(unitPkgIDS, FBoolean.TRUE);
		for (MeasDocDO measdocDO : measdocDOS) {

			result.put(measdocDO.getId_measdoc(), measdocDO);
		}

		return result;
	}

	private Map<String, PackageUnitDO> getUnitPkgTpMap() throws BizException {

		IPackageunitRService unitpkgSrv = ServiceFinder.find(IPackageunitRService.class);

		Map<String, PackageUnitDO> result = new HashMap<String, PackageUnitDO>();
		String[] code = new String[] { IBdMmDictCodeConst.MM_PKGUNIT_TYPE_BASE,
				IBdMmDictCodeConst.MM_PKGUNIT_TYPE_SELL };
		PackageUnitDO[] unitPkgDOS = unitpkgSrv.findByAttrValStrings(PackageUnitDO.CODE, code);
		for (PackageUnitDO pkgUnitDO : unitPkgDOS) {

			result.put(pkgUnitDO.getCode(), pkgUnitDO);
		}

		return result;
	}

	private void resetBaseAndSellPkgInfo(MeterialDO meterialDO, MMPackageUnitDO[] mmPackageUnitDOs,
			Map<String, MeasDocDO> measdocMap) {

		for (MMPackageUnitDO mmPackageUnitDO : mmPackageUnitDOs) {

			if (IBdMmDictCodeConst.SD_MMPKGUPRO_BASE.equals(mmPackageUnitDO.getSd_mmpkgupro())) {

				MeasDocDO baseUnitPkg = measdocMap.get(meterialDO.getId_unit_pkgbase());
				mmPackageUnitDO.setId_unit_pkg(meterialDO.getId_unit_pkgbase());
				mmPackageUnitDO.setMmpkguname(baseUnitPkg.getName());
				mmPackageUnitDO.setUnit_pkg_name(baseUnitPkg.getName());
				if (mmPackageUnitDO.getStatus() == DOStatus.UNCHANGED) {
					mmPackageUnitDO.setStatus(DOStatus.UPDATED);
				}
				continue;
			}

			if (IBdMmDictCodeConst.SD_MMPKGUPRO_SELL.equals(mmPackageUnitDO.getSd_mmpkgupro())) {

				MeasDocDO sellUnitPkg = measdocMap.get(meterialDO.getId_unit_pkgsp());
				mmPackageUnitDO.setId_unit_pkg(meterialDO.getId_unit_pkgsp());
				mmPackageUnitDO.setFactor(meterialDO.getFactor_sb());
				mmPackageUnitDO.setMmpkguname(sellUnitPkg.getName());
				mmPackageUnitDO.setUnit_pkg_name(sellUnitPkg.getName());
				if (mmPackageUnitDO.getStatus() == DOStatus.UNCHANGED) {
					mmPackageUnitDO.setStatus(DOStatus.UPDATED);
				}
				continue;
			}
		}
	}

	private MMPackageUnitDO[] initBaseAndSellPkgInfo(MeterialDO meterialDO, Map<String, MeasDocDO> measdocMap,
			Map<String, PackageUnitDO> unitPkgTpMap) throws BizException {

		List<MMPackageUnitDO> newPkgUnitDOs = new ArrayList<MMPackageUnitDO>();

		MMPackageUnitDO basePkgUnitDO = this.initUnitPkgInfo(meterialDO,
				measdocMap.get(meterialDO.getId_unit_pkgbase()),
				unitPkgTpMap.get(IBdMmDictCodeConst.MM_PKGUNIT_TYPE_BASE), IBdMmDictCodeConst.SD_MMPKGUPRO_BASE);
		MMPackageUnitDO sellPkgUnitDO = this.initUnitPkgInfo(meterialDO, measdocMap.get(meterialDO.getId_unit_pkgsp()),
				unitPkgTpMap.get(IBdMmDictCodeConst.MM_PKGUNIT_TYPE_SELL), IBdMmDictCodeConst.SD_MMPKGUPRO_SELL);
		newPkgUnitDOs.add(basePkgUnitDO);
		newPkgUnitDOs.add(sellPkgUnitDO);

		return newPkgUnitDOs.toArray(new MMPackageUnitDO[newPkgUnitDOs.size()]);
	}

	private MMPackageUnitDO initUnitPkgInfo(MeterialDO meterialDO, MeasDocDO measdocDO, PackageUnitDO unitTypeDO,
			String mmpkgupro) {

		MMPackageUnitDO pkgUnitDO = new MMPackageUnitDO();
		pkgUnitDO.setStatus(DOStatus.NEW);
		pkgUnitDO.setId_mm(meterialDO.getId_mm());
		pkgUnitDO.setId_mmpkgutp(unitTypeDO.getId_mmpkgutp());
		pkgUnitDO.setMmpkgutp_name(unitTypeDO.getName());
		pkgUnitDO.setId_unit_pkg(measdocDO.getId_measdoc());
		pkgUnitDO.setUnit_pkg_name(measdocDO.getName());
		if (IBdMmDictCodeConst.SD_MMPKGUPRO_BASE.equals(mmpkgupro)) {

			pkgUnitDO.setFactor(new FDouble(1));
		} else {

			pkgUnitDO.setFactor(meterialDO.getFactor_sb());
		}
		pkgUnitDO.setSd_mmpkgupro(mmpkgupro);
		pkgUnitDO.setEn_pippkgtp(unitTypeDO.getEn_pippkgtp());
		pkgUnitDO.setEn_ippkgtp(unitTypeDO.getEn_ippkgtp());
		pkgUnitDO.setEn_oppkgtp(unitTypeDO.getEn_oppkgtp());
		pkgUnitDO.setEn_erpkgtp(unitTypeDO.getEn_erpkgtp());
		pkgUnitDO.setEn_pepkgtp(unitTypeDO.getEn_pepkgtp());
		pkgUnitDO.setEn_fmpkgtp(unitTypeDO.getEn_fmpkgtp());
		pkgUnitDO.setEn_er1pkgtp(unitTypeDO.getEn_er1pkgtp());
		pkgUnitDO.setEn_er2pkgtp(unitTypeDO.getEn_er2pkgtp());
		pkgUnitDO.setMmpkguname(measdocDO.getName());
		return pkgUnitDO;
	}
}
