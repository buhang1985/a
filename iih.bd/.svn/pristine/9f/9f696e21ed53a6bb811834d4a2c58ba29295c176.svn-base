package iih.bd.mm.dataimpt;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import iih.bd.mm.mmcategory.i.IMmcategoryCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗物品基本分类数据导入服务实现
 * 
 * @author Administrator
 *
 */
public class MmCaDataImptServiceImpl extends BDBaseDataImport<MMCategoryDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new MMCategoryDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { MMCategoryDO.ID_MMCA, MMCategoryDO.NAME, MMCategoryDO.CODE, MMCategoryDO.ID_MMTP,
				MMCategoryDO.SD_MMTP, MMCategoryDO.FG_BATCH, MMCategoryDO.FG_PAT, MMCategoryDO.FG_PRICE,
				MMCategoryDO.FG_CHARGE };
	}

	@Override
	protected void insertToDB(MMCategoryDO[] importDatas) throws BizException {
		ServiceFinder.find(IMmcategoryCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(MMCategoryDO[] importDatas) throws BizException {
		ServiceFinder.find(IMmcategoryCudService.class).update(importDatas);
	}

	@Override
	protected void checkImportData(MMCategoryDO[] importDatas) throws BizException {
		super.checkImportData(importDatas);
		checkValue(importDatas);
	}

	private void checkValue(MMCategoryDO[] dOS) throws BizException {

		for (MMCategoryDO DO : dOS) {

			if (DO.getFg_batch().booleanValue()) {

				if (StringUtils.isBlank(DO.getId_outmode()) || StringUtils.isBlank(DO.getSd_outmode())) {

					String error = String.format(
							"物品基本分类(bd_mmca)：%s是否批次管理(FG_BATCH)为true，出库方式(ID_OUTMODE、SD_OUTMODE)不能为空", DO.getName());
					throw new BizException(error);
				}
			} else {

				DO.setId_outmode(null);
				DO.setSd_outmode(null);
			}

			if (DO.getFg_price().booleanValue()) {

				if (StringUtils.isBlank(DO.getId_primode()) || StringUtils.isBlank(DO.getSd_primode())) {

					String error = String.format(
							"物品基本分类(bd_mmca)：%s是否售价管理(FG_PRICE)为true，零售价计算方式(Id_primode、Sd_primode)不能为空", DO.getName());
					throw new BizException(error);
				}

				if (!DO.getFg_charge().booleanValue()
						&& !DO.getSd_primode().equals(IBdMmDictCodeConst.SD_PRIMODE_FIX)) {

					String error = String.format("物品基本分类(bd_mmca)：%s收费出库标识(Fg_charge)为false，零售价计算方式(Sd_primode)必须为固定价",
							DO.getName());
					throw new BizException(error);
				}

				if (DO.getSd_primode().equals(IBdMmDictCodeConst.SD_PRIMODE_RATE) && DO.getPap() == null) {

					String error = String.format("物品基本分类(bd_mmca)：%s零售价计算方式(Sd_primode)为加成率，加成率(Pap)不能为空",
							DO.getName());
					throw new BizException(error);
				}
			} else {

				if (DO.getFg_charge().booleanValue()) {

					String error = String.format("物品基本分类(bd_mmca)：%s是否售价管理(FG_PRICE)为false，收费出库标识(FG_CHARGE)不能为true",
							DO.getName());
					throw new BizException(error);
				}

				if (!StringUtils.isBlank(DO.getId_primode()) || !StringUtils.isBlank(DO.getSd_primode())) {

					String error = String.format(
							"物品基本分类(bd_mmca)：%s是否售价管理(FG_PRICE)为false，零售价计算方式(ID_PRIMODE、SD_PRIMODE)不能有值",
							DO.getName());
					throw new BizException(error);
				}

				if (DO.getPap() != null) {

					String error = String.format("物品基本分类(bd_mmca)：%s是否售价管理(FG_PRICE)为false，加成率(PAP)不能有值", DO.getName());
					throw new BizException(error);
				}
			}
		}
	}
}
