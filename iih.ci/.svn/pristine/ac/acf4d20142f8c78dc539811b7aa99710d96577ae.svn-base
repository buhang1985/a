package iih.ci.ord.s.ems.copy.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.copy.i.IOrderCopy;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.s.ems.copy.op.fullcopy.BtCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.BuCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.ConsCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.DietCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.DrugsCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.LisCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.NurseCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.OpsugCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.PathgyCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.RisCopyBP;
import iih.ci.ord.s.ems.copy.op.fullcopy.TreatCopyBP;
import iih.ci.ord.s.ems.itf.bp.IOrderCopyBP;

/**
 * 
 * @author 复制工程基类
 *
 */
public class BaseOrderCopyFactory {
	public static BaseOrderCopyFactory GetOrderCopyFactory(String code_entp,String funcCode)
	{
		//门诊模式
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)||IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)
				||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)){
			if(OrderOperateDTO.FULLCOPY.equals(funcCode)){
				return new OpOrderFullCopyFactory();
			}else{
				
			}
		}else{
			if(OrderOperateDTO.FULLCOPY.equals(funcCode)){
				
			}else{
				
			}
		}
		return null;
	}
	public IOrderCopy getOrderCopyBP(String sd_srvtp) {
		return null;
	}
	/**
	 * 获取类型分组的医嘱ID
	 * 
	 * @param ciors
	 * @return
	 */
	public Map<String, List<CiorderAggDO>> getMapAggs(CiorderAggDO[] aggs) {
		Map<String, List<CiorderAggDO>> mapOrderAggs = new HashMap<String, List<CiorderAggDO>>();
		for (CiorderAggDO ordAgg : aggs) {
			String sd_srvtp = ordAgg.getParentDO().getSd_srvtp();
			if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
					setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG,ordAgg);
				}else{
					setMapAggs(mapOrderAggs,IBdSrvDictCodeConst.SD_SRVTP_DRUG,ordAgg);
				}
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

	/**
	 * 分组
	 * 
	 * @param mapOrderAggs
	 * @param sdsrvtp
	 * @param agg
	 */
	protected void setMapAggs(Map<String, List<CiorderAggDO>> mapOrderAggs, String sdsrvtp, CiorderAggDO agg) {
		if (mapOrderAggs.containsKey(sdsrvtp)) {
			mapOrderAggs.get(sdsrvtp).add(agg);
		} else {
			List<CiorderAggDO> lst = new ArrayList<CiorderAggDO>();
			lst.add(agg);
			mapOrderAggs.put(sdsrvtp, lst);
		}
	}
}
