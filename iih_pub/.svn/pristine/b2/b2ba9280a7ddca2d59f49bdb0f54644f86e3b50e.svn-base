package iih.mc.common.bp;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.common.CalOperation;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.mc.bl.stockbl.d.McStockBlDO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class CompareMcBlBp {

	public static String getKeyByWhMm(String id_wh, String id_mm, String onlyCode, String batch, FDate expi,
			FDouble pri_act_base, FDouble pri_sale) throws BizException {

		IMeterialService materialSrv = ServiceFinder.find(IMeterialService.class);

		MeterialDO mmDO = materialSrv.findMaterialByID(id_mm);
		String key = id_wh + " " + id_mm + " ";
		// 进价_基本单位
		pri_act_base = GetStdFormat(pri_act_base);
		key = key + CalOperation.RoundBlPrice(pri_act_base) + " ";
		// 售价_零售单位
		pri_sale = GetStdFormat(pri_sale);
		key = key + CalOperation.RoundBlPrice(pri_sale) + " ";
		// 唯一码
		if (StringUtils.isBlank(onlyCode)) {

			key = key + " ";
		} else {

			key = key + onlyCode + " ";
		}
		// 批次
		if (mmDO.getFg_batch().booleanValue() && !StringUtils.isBlank(batch)) {

			key = key + batch + " ";
		} else {

			key = key + " ";
		}
		// 失效期
		if (mmDO.getFg_batch().booleanValue() && expi != null) {

			key = key + expi + " ";
		} else {

			key = key + " ";
		}

		return key;
	}

	private static FDouble GetStdFormat(FDouble price) {
		if (price == null || price.compareTo(FDouble.ZERO_DBL) == 0) {

			price = FDouble.ZERO_DBL;
		}
		return price;
	}

	public static String getKeyByBaseDO(String id_wh, BaseDO baseDO) throws BizException {

		IMeterialService mmSrv = ServiceFinder.find(IMeterialService.class);

		// 基本包装单位
		MMPackageUnitDO basePkgUnitDO = mmSrv.findBasePackageUnit(baseDO.getAttrVal("Id_mm").toString());
		// 进价(基本包装单位)
		FDouble pri_act_base = mmSrv.packageUnitConversion(IMeterialService.TYPE_PRICE,
				(FDouble) baseDO.getAttrVal("Pri_act"), baseDO.getAttrVal("Id_mmpkgu_actual").toString(),
				basePkgUnitDO.getId_mmpkgu());
		// 零售价(零售包装单位)
		FDouble pri_sale = mmSrv.getMmStockSalePrice(baseDO.getAttrVal("Id_mm").toString(),
				baseDO.getAttrVal("Id_mmpkgu_actual").toString(), (FDouble) baseDO.getAttrVal("Pri_act"));
		// 批次
		String batch = baseDO.getAttrVal("Batch") == null ? null : baseDO.getAttrVal("Batch").toString();
		// 有效期
		FDate date_expi = baseDO.getAttrVal("Date_expi") == null ? null : (FDate) baseDO.getAttrVal("Date_expi");

		return getKeyByWhMm(id_wh, baseDO.getAttrVal("Id_mm").toString(), baseDO.getAttrVal("Id_mm").toString(), batch,
				date_expi, pri_act_base, pri_sale);
	}

	public static void orderBlInfo(String id_mm, List<McStockBlDO> blList) throws BizException {

		IMeterialService meterialService = ServiceFinder.find(IMeterialService.class);

		MeterialDO mmDO = meterialService.findMaterialByID(id_mm);
		if (mmDO.getFg_batch().booleanValue()) {

			if (IBdMmDictCodeConst.SD_OUTMODE_FIFO.equals(mmDO.getSd_outmode())) {

				// 先进先出
				fifoOut(blList);
			} else if (IBdMmDictCodeConst.SD_OUTMODE_PERIOD.equals(mmDO.getSd_outmode())) {

				// 效期优先
				periodOut(blList);
			} else if (IBdMmDictCodeConst.SD_OUTMODE_LILO.equals(mmDO.getSd_outmode())) {

				// 后进先出
				liloOut(blList);
			} else {

				// 默认先进先出
				fifoOut(blList);
			}
		} else {

			// 默认可用数量大的库存优先出库
			maxNumOut(blList);
		}
	}

	private static void fifoOut(List<McStockBlDO> blList) {

		for (int i = 0; i < blList.size(); i++) {

			McStockBlDO blDO_i = blList.get(i);
			for (int j = i + 1; j < blList.size(); j++) {

				McStockBlDO blDO_j = blList.get(j);
				if(blDO_i.getBatch() == null ||blDO_j.getBatch() == null)
					return;
				if (blDO_j.getBatch().compareTo(blDO_i.getBatch()) < 0) {

					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				}
			}
		}
	}

	private static void periodOut(List<McStockBlDO> blList) {

		for (int i = 0; i < blList.size(); i++) {

			McStockBlDO blDO_i = blList.get(i);
			for (int j = i + 1; j < blList.size(); j++) {

				McStockBlDO blDO_j = blList.get(j);
				if (blDO_j.getDate_expi() == null && blDO_i.getDate_expi() == null) {

					continue;
				} else if (blDO_j.getDate_expi() != null && blDO_i.getDate_expi() == null) {

					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				} else if (blDO_j.getDate_expi() == null && blDO_i.getDate_expi() != null) {

					continue;
				} else if (blDO_j.getDate_expi().compareTo(blDO_i.getDate_expi()) < 0) {

					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				}
			}
		}
	}

	private static void liloOut(List<McStockBlDO> blList) {

		for (int i = 0; i < blList.size(); i++) {

			McStockBlDO blDO_i = blList.get(i);
			for (int j = i + 1; j < blList.size(); j++) {

				McStockBlDO blDO_j = blList.get(j);
				if (blDO_j.getBatch().compareTo(blDO_i.getBatch()) > 0) {

					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				}
			}
		}
	}

	private static void maxNumOut(List<McStockBlDO> blList) {

		for (int i = 0; i < blList.size(); i++) {

			McStockBlDO blDO_i = blList.get(i);
			for (int j = i + 1; j < blList.size(); j++) {

				McStockBlDO blDO_j = blList.get(j);
				if (blDO_j.getQuan_usable().compareTo(blDO_i.getQuan_usable()) > 0) {

					blList.set(i, blDO_j);
					blList.set(j, blDO_i);
					blDO_i = blList.get(i);
				}
			}
		}
	}
}
