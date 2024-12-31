package iih.bd.mm.dataimpt;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.i.IMMPackageUnitDOCudService;
import iih.bd.mm.meterial.i.IMMPackageUnitDORService;
import iih.bd.mm.packageunit.d.PackageUnitDO;
import iih.bd.mm.packageunit.i.IPackageunitRService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * 物品包装单位集数据导入服务实现
 * 
 * @author Administrator
 *
 */
public class MmPkguDataImptServiceImpl extends BDBaseDataImport<MMPackageUnitDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MMPackageUnitDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MMPackageUnitDO.ID_MMPKGU, MMPackageUnitDO.ID_MM, MMPackageUnitDO.ID_MMPKGUTP,
				MMPackageUnitDO.ID_UNIT_PKG, MMPackageUnitDO.FACTOR, MMPackageUnitDO.ID_MMPKGUPRO,
				MMPackageUnitDO.SD_MMPKGUPRO };
	}

	@Override
	protected void insertToDB(MMPackageUnitDO[] importDatas) throws BizException {
		ServiceFinder.find(IMMPackageUnitDOCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MMPackageUnitDO[] importDatas) throws BizException {
		ServiceFinder.find(IMMPackageUnitDOCudService.class).update(importDatas);
	}

	@Override
	protected void checkImportData(MMPackageUnitDO[] importDatas) throws BizException {
		super.checkImportData(importDatas);
		checkValue(importDatas);
	}

	private void checkValue(MMPackageUnitDO[] dOS) throws BizException {

		IMeasdocRService measdocService = ServiceFinder.find(IMeasdocRService.class);
		IPackageunitRService packageUnitRService = ServiceFinder.find(IPackageunitRService.class);
		IMMPackageUnitDORService mmpkgSrv = ServiceFinder.find(IMMPackageUnitDORService.class);
		MMPackageUnitDO[] pkgDoList = mmpkgSrv.find(" 1= 1", "", FBoolean.TRUE);

		List<MMPackageUnitDO> result = new ArrayList<MMPackageUnitDO>();
		for (MMPackageUnitDO pkgDO : pkgDoList) {

			result.add(pkgDO);
		}

		for (MMPackageUnitDO DO : dOS) {

			int i = 0;
			for (MMPackageUnitDO dO : dOS) {

				if (DO.getId_mm().equals(dO.getId_mm()) && DO.getId_unit_pkg().equals(dO.getId_unit_pkg())) {

					i = i + 1;
				}
			}

			if (i > 1) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)有重复的包装单位%s(Id_unit_pkg)", DO.getId_mm(),
						DO.getId_unit_pkg());
				throw new BizException(error);
			}

			if (DO.getSd_mmpkgupro().equals(IBdMmDictCodeConst.SD_MMPKGUPRO_BASE)
					|| DO.getSd_mmpkgupro().equals(IBdMmDictCodeConst.SD_MMPKGUPRO_SELL)) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)的包装单位%s(Id_unit_pkg)的包装单位性质(Sd_mmpkgupro)不是换算包装",
						DO.getId_mm(), DO.getId_unit_pkg());
				throw new BizException(error);
			}

			result.add(DO);
		}

		PackageUnitDO[] unitDOList = packageUnitRService.find(" 1=1", "", FBoolean.TRUE);

		for (MMPackageUnitDO DO : result) {

			MeasDocDO UnitPkg = measdocService.findById(DO.getId_unit_pkg());
			DO.setMmpkguname(UnitPkg.getName());

			PackageUnitDO unitDO = null;
			for (PackageUnitDO dO : unitDOList) {

				if (dO.getId_mmpkgutp().equals(DO.getId_mmpkgutp())) {

					unitDO = dO;
					break;
				}
			}

			DO.setEn_erpkgtp(unitDO.getEn_erpkgtp());
			DO.setEn_fmpkgtp(unitDO.getEn_fmpkgtp());
			DO.setEn_ippkgtp(unitDO.getEn_ippkgtp());
			DO.setEn_oppkgtp(unitDO.getEn_oppkgtp());
			DO.setEn_pepkgtp(unitDO.getEn_pepkgtp());
		}

		checkEnpktpValue(result);
	}

	private void checkEnpktpValue(List<MMPackageUnitDO> dOS) throws BizException {

		for (MMPackageUnitDO DO : dOS) {

			Boolean exit_ip = false;
			Boolean exit_op = false;
			Boolean exit_er = false;
			Boolean exit_pe = false;
			Boolean exit_fm = false;

			for (MMPackageUnitDO dO : dOS) {

				if (!DO.getId_mm().equals(dO.getId_mm())) {

					continue;
				}

				if ((DO.getEn_ippkgtp() == null ? 0 : DO.getEn_ippkgtp()) == 1) {

					exit_ip = true;
				}

				if ((DO.getEn_oppkgtp() == null ? 0 : DO.getEn_oppkgtp()) == 1) {

					exit_op = true;
				}

				if ((DO.getEn_erpkgtp() == null ? 0 : DO.getEn_erpkgtp()) == 1) {

					exit_er = true;
				}

				if ((DO.getEn_pepkgtp() == null ? 0 : DO.getEn_pepkgtp()) == 1) {

					exit_pe = true;
				}

				if ((DO.getEn_fmpkgtp() == null ? 0 : DO.getEn_fmpkgtp()) == 1) {

					exit_fm = true;
				}
			}

			if (!exit_ip) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)住院发药包装单位(En_ippkgtp)必须从1开始", DO.getId_mm());
				throw new BizException(error);
			}

			if (!exit_op) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)门诊发药包装单位(En_oppkgtp)必须从1开始", DO.getId_mm());
				throw new BizException(error);
			}

			if (!exit_er) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)急诊发药包装单位(En_erpkgtp)必须从1开始", DO.getId_mm());
				throw new BizException(error);
			}

			if (!exit_pe) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)体检发药包装单位(En_pepkgtp)必须从1开始", DO.getId_mm());
				throw new BizException(error);
			}

			if (!exit_fm) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)家庭发药包装单位(En_fmpkgtp)必须从1开始", DO.getId_mm());
				throw new BizException(error);
			}
		}

		for (MMPackageUnitDO DO : dOS) {

			int i = 0;

			if (DO.getEn_ippkgtp() == null) {

				continue;
			}

			for (MMPackageUnitDO dO : dOS) {

				if (!DO.getId_mm().equals(dO.getId_mm())) {

					continue;
				}

				if (dO.getEn_ippkgtp() == null) {

					continue;
				}

				if (DO.getEn_ippkgtp() == dO.getEn_ippkgtp()) {

					i = i + 1;
				}
			}

			if (i > 1) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)住院发药包装单位(En_ippkgtp)有重复数值%s", DO.getId_mm(),
						String.valueOf(DO.getEn_ippkgtp()));
				throw new BizException(error);
			}
		}

		for (MMPackageUnitDO DO : dOS) {

			int i = 0;

			if (DO.getEn_oppkgtp() == null) {

				continue;
			}

			for (MMPackageUnitDO dO : dOS) {

				if (!DO.getId_mm().equals(dO.getId_mm())) {

					continue;
				}

				if (dO.getEn_oppkgtp() == null) {

					continue;
				}

				if (DO.getEn_oppkgtp() == dO.getEn_oppkgtp()) {

					i = i + 1;
				}
			}

			if (i > 1) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)门诊发药包装单位(En_oppkgtp)有重复数值%s", DO.getId_mm(),
						String.valueOf(DO.getEn_oppkgtp()));
				throw new BizException(error);
			}
		}

		for (MMPackageUnitDO DO : dOS) {

			int i = 0;

			if (DO.getEn_erpkgtp() == null) {

				continue;
			}

			for (MMPackageUnitDO dO : dOS) {

				if (!DO.getId_mm().equals(dO.getId_mm())) {

					continue;
				}

				if (dO.getEn_erpkgtp() == null) {

					continue;
				}

				if (DO.getEn_erpkgtp() == dO.getEn_erpkgtp()) {

					i = i + 1;
				}
			}

			if (i > 1) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)急诊发药包装单位(En_erpkgtp)有重复数值%s", DO.getId_mm(),
						String.valueOf(DO.getEn_erpkgtp()));
				throw new BizException(error);
			}
		}

		for (MMPackageUnitDO DO : dOS) {

			int i = 0;

			if (DO.getEn_pepkgtp() == null) {

				continue;
			}

			for (MMPackageUnitDO dO : dOS) {

				if (!DO.getId_mm().equals(dO.getId_mm())) {

					continue;
				}

				if (dO.getEn_pepkgtp() == null) {

					continue;
				}

				if (DO.getEn_pepkgtp() == dO.getEn_pepkgtp()) {

					i = i + 1;
				}
			}

			if (i > 1) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)体检发药包装单位(En_pepkgtp)有重复数值%s", DO.getId_mm(),
						String.valueOf(DO.getEn_pepkgtp()));
				throw new BizException(error);
			}
		}

		for (MMPackageUnitDO DO : dOS) {

			int i = 0;

			if (DO.getEn_fmpkgtp() == null) {

				continue;
			}

			for (MMPackageUnitDO dO : dOS) {

				if (!DO.getId_mm().equals(dO.getId_mm())) {

					continue;
				}

				if (dO.getEn_fmpkgtp() == null) {

					continue;
				}

				if (DO.getEn_fmpkgtp() == dO.getEn_fmpkgtp()) {

					i = i + 1;
				}
			}

			if (i > 1) {

				String error = String.format("(bd_mm_pkgu)物品%s(id_mm)家庭发药包装单位(En_fmpkgtp)有重复数值%s", DO.getId_mm(),
						String.valueOf(DO.getEn_fmpkgtp()));
				throw new BizException(error);
			}
		}
	}
}
