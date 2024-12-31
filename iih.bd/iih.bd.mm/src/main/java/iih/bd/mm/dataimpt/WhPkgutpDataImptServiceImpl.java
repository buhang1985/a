package iih.bd.mm.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import iih.bd.mm.wahouseunittype.i.IWahouseunittypeCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 仓库单位类型数据导入服务实现
 * 
 * @author Administrator
 *
 */
public class WhPkgutpDataImptServiceImpl extends BDBaseDataImport<WahouseUnitTypeDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new WahouseUnitTypeDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { WahouseUnitTypeDO.ID_WHPKGUTP, WahouseUnitTypeDO.ID_WH, WahouseUnitTypeDO.ID_MMPKGUTP,
				WahouseUnitTypeDO.FG_DEF };
	}

	@Override
	protected void insertToDB(WahouseUnitTypeDO[] importDatas) throws BizException {
		ServiceFinder.find(IWahouseunittypeCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(WahouseUnitTypeDO[] importDatas) throws BizException {
		ServiceFinder.find(IWahouseunittypeCudService.class).update(importDatas);
	}

	@Override
	protected void checkImportData(WahouseUnitTypeDO[] importDatas) throws BizException {
		super.checkImportData(importDatas);
		checkValue(importDatas);
	}

	private void checkValue(WahouseUnitTypeDO[] dOS) throws BizException {

		for (WahouseUnitTypeDO DO : dOS) {

			int i = 0;
			for (WahouseUnitTypeDO dO : dOS) {

				if (DO.getId_wh().equals(dO.getId_wh()) && DO.getId_mmpkgutp().equals(dO.getId_mmpkgutp())) {

					i = i + 1;
				}
			}

			if (i > 1) {

				String error = String.format("(bd_wh_pkgutp)仓库(id_wh)%s有重复的包装单位类型(ID_MMPKGUTP)%s", DO.getId_wh(),
						DO.getId_mmpkgutp());
				throw new BizException(error);
			}

			i = 0;
			for (WahouseUnitTypeDO dO : dOS) {

				if (DO.getId_wh().equals(dO.getId_wh()) && dO.getFg_def().booleanValue()) {

					i = i + 1;
				}
			}

			if (i > 1) {

				String error = String.format("(bd_wh_pkgutp)仓库(id_wh)%s设置了多个默认包装单位类型(FG_DEF为true的值有多个)", DO.getId_wh());
				throw new BizException(error);
			}
		}
	}
}
