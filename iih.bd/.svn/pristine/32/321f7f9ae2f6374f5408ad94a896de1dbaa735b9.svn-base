package iih.bd.mm.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.mm.packageunit.d.PackageUnitDO;
import iih.bd.mm.packageunit.i.IPackageunitCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 包装单位类型导数据导入服务实现
 * 
 * @author Administrator
 *
 */
public class MmPkgutpDataImptServiceImpl extends BDBaseDataImport<PackageUnitDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new PackageUnitDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { PackageUnitDO.ID_MMPKGUTP, PackageUnitDO.NAME, PackageUnitDO.CODE,
				PackageUnitDO.FLAG_SYS };
	}

	@Override
	protected void insertToDB(PackageUnitDO[] importDatas) throws BizException {
		ServiceFinder.find(IPackageunitCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(PackageUnitDO[] importDatas) throws BizException {
		ServiceFinder.find(IPackageunitCudService.class).update(importDatas);
	}

	@Override
	protected void checkImportData(PackageUnitDO[] importDatas) throws BizException {
		super.checkImportData(importDatas);
		checkValue(importDatas);
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from BD_MM_PKGUTP where id_mmpkgutp not like '@@@@%' and flag_sys <> 'Y'");
		return true;
	}

	private void checkValue(PackageUnitDO[] dOS) throws BizException {

		Boolean exit_ip = false;
		Boolean exit_op = false;
		Boolean exit_er = false;
		Boolean exit_pe = false;
		Boolean exit_fm = false;

		for (PackageUnitDO DO : dOS) {

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

			throw new BizException("(bd_mm_pkgutp)住院发药包装单位(En_ippkgtp)必须从1开始");
		}

		if (!exit_op) {

			throw new BizException("(bd_mm_pkgutp)门诊发药包装单位(En_oppkgtp)必须从1开始");
		}

		if (!exit_er) {

			throw new BizException("(bd_mm_pkgutp)急诊发药包装单位(En_erpkgtp)必须从1开始");
		}

		if (!exit_pe) {

			throw new BizException("(bd_mm_pkgutp)体检发药包装单位(En_pepkgtp)必须从1开始");
		}

		if (!exit_fm) {

			throw new BizException("(bd_mm_pkgutp)家庭发药包装单位(En_fmpkgtp)必须从1开始");
		}

		for (PackageUnitDO DO : dOS) {

			int i = 0;
			if (DO.getEn_ippkgtp() == null) {

				continue;
			}

			for (PackageUnitDO dO : dOS) {

				if (dO.getEn_ippkgtp() == null) {

					continue;
				}

				if (DO.getEn_ippkgtp() == dO.getEn_ippkgtp()) {

					i = i + 1;
				}
			}

			if (i > 1) {

				throw new BizException(
						"(bd_mm_pkgutp)住院发药包装单位(En_ippkgtp)有重复数值%s" + String.valueOf(DO.getEn_ippkgtp()));
			}
		}

		for (PackageUnitDO DO : dOS) {

			int i = 0;
			if (DO.getEn_oppkgtp() == null) {

				continue;
			}

			for (PackageUnitDO dO : dOS) {

				if (dO.getEn_oppkgtp() == null) {

					continue;
				}

				if (DO.getEn_oppkgtp() == dO.getEn_oppkgtp()) {

					i = i + 1;
				}
			}

			if (i > 1) {

				throw new BizException(
						"(bd_mm_pkgutp)门诊发药包装单位(En_oppkgtp)有重复数值%s" + String.valueOf(DO.getEn_oppkgtp()));
			}
		}

		for (PackageUnitDO DO : dOS) {

			int i = 0;
			if (DO.getEn_erpkgtp() == null) {

				continue;
			}

			for (PackageUnitDO dO : dOS) {

				if (dO.getEn_erpkgtp() == null) {

					continue;
				}

				if (DO.getEn_erpkgtp() == dO.getEn_erpkgtp()) {

					i = i + 1;
				}
			}

			if (i > 1) {

				throw new BizException(
						"(bd_mm_pkgutp)急诊发药包装单位(En_erpkgtp)有重复数值%s" + String.valueOf(DO.getEn_erpkgtp()));
			}
		}

		for (PackageUnitDO DO : dOS) {

			int i = 0;
			if (DO.getEn_pepkgtp() == null) {

				continue;
			}

			for (PackageUnitDO dO : dOS) {

				if (dO.getEn_pepkgtp() == null) {

					continue;
				}

				if (DO.getEn_pepkgtp() == dO.getEn_pepkgtp()) {

					i = i + 1;
				}
			}

			if (i > 1) {

				throw new BizException(
						"(bd_mm_pkgutp)体检发药包装单位(En_pepkgtp)有重复数值%s" + String.valueOf(DO.getEn_pepkgtp()));
			}
		}

		for (PackageUnitDO DO : dOS) {

			int i = 0;
			if (DO.getEn_fmpkgtp() == null) {

				continue;
			}

			for (PackageUnitDO dO : dOS) {

				if (dO.getEn_fmpkgtp() == null) {

					continue;
				}

				if (DO.getEn_fmpkgtp() == dO.getEn_fmpkgtp()) {

					i = i + 1;
				}
			}

			if (i > 1) {

				throw new BizException(
						"(bd_mm_pkgutp)家庭发药包装单位(En_fmpkgtp)有重复数值%s" + String.valueOf(DO.getEn_fmpkgtp()));
			}
		}
	}

}
