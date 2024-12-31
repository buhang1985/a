package iih.ci.ord.s.ems.copy.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.copy.i.IOrderCopy;
import iih.ci.ord.s.ems.copy.op.fullcopy.BtCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.BuCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.ConsCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.DrugsCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.LisCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.NurseCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.OpsugCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.PathgyCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.RisCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.TreatCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.DietCopyBP;

/**
 * 具体复制对象工厂
 * 
 * @author zhangwq
 *
 */
public class OpOrderFullCopyFactory extends BaseOrderCopyFactory {
	public IOrderCopy getOrderCopyBP(String sd_srvtp) {
		IOrderCopy bp = null;
		if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
			bp = new DrugsCopyBP();
		} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
			if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
				bp = new PathgyCopyBP();
			} else {
				bp = new RisCopyBP();
			}
		} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
			bp = new LisCopyBP();
		} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)) {
			bp = new OpsugCopyBP();
		} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)) {
			if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT)) {
				bp = new DietCopyBP();
			} else {
				bp = new TreatCopyBP();
			}
		} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD)) {
			if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)) {
				bp = new BtCopyBP();
			} else {
				bp = new BuCopyBP();
			}
		} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)) {
			bp = new ConsCopyBP();
		} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_NURSE)) {
			bp = new NurseCopyBP();
		} else {
			bp = new TreatCopyBP();
		}

		return bp;
	}

	@Override
	public Map<String, List<CiorderAggDO>> getMapAggs(CiorderAggDO[] aggs) {
		Map<String, List<CiorderAggDO>> mapOrderAggs = new HashMap<String, List<CiorderAggDO>>();
		for (CiorderAggDO ordAgg : aggs) {
			String sd_srvtp = ordAgg.getParentDO().getSd_srvtp();
			if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_DRUG,ordAgg);
			} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
					setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI,ordAgg);
				} else {
					setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_RIS,ordAgg);
				}
			} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
				setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_LIS,ordAgg);
			} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)) {
				setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_OP,ordAgg);
			} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)) {
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT)) {
					setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT,ordAgg);
				} else {
					setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_TREAT,ordAgg);
				}
			} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD)) {
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)) {
					setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE,ordAgg);
				} else {
					setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD,ordAgg);
				}
			} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)) {
				setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS,ordAgg);
			} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_NURSE)) {
				setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_NURSE,ordAgg);
			} else {
				//其他的都放到治疗单中处理
				setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_TREAT,ordAgg);
			}
		}

		return mapOrderAggs;
	}
	
}
