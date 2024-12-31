package iih.bd.srv.medsrv.s.rule;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 移除垃圾子数据逻辑</br>
 * 保存前删除不需要保存的子数据</br>
 * 因前台对单子DO均进行了创建，所以在此需要删除
 * 
 * @author hao_wu
 *
 */
public class RemoveGarbageChildDataRule implements IRule<MedsrvAggDO> {

	@Override
	public void process(MedsrvAggDO... arg0) throws BizException {
		if (arg0 == null || arg0.length <= 0) {
			return;
		}

		RemoveGarbageChildData(arg0);
	}

	/**
	 * 移除垃圾子数据
	 * 
	 * @param aggs
	 */
	private void RemoveGarbageChildData(MedsrvAggDO[] aggs) {
		for (MedsrvAggDO medsrvAggDO : aggs) {
			RemoveGarbageChildData(medsrvAggDO);
		}
	}

	/**
	 * 移除垃圾子数据
	 * 
	 * @param medsrvAggDO
	 */
	private void RemoveGarbageChildData(MedsrvAggDO medsrvAggDO) {
		MedSrvDO medSrvDO = medsrvAggDO.getParentDO();
		String sdSrvtp = medSrvDO.getSd_srvtp();
		if (StringUtils.isNotEmpty(sdSrvtp) && !sdSrvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
			// 不是药品类型，清空药品属性
			medsrvAggDO.setMedSrvDrugDO(null);
		}
		if (StringUtils.isNotEmpty(sdSrvtp) && !sdSrvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)
				&& !sdSrvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
			// 不是检验类型且不是病理类型，清空检验属性
			medsrvAggDO.setMedSrvLisDO(null);
		}
		if (StringUtils.isNotEmpty(sdSrvtp) && (!sdSrvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
				|| sdSrvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI))) {
			// 不是检查类型或者是病理类型，清空检查属性
			medsrvAggDO.setMedSrvRisDO(null);
		}
		if (StringUtils.isNotEmpty(sdSrvtp) && !sdSrvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)) {
			// 不是手术类型，清空手术属性
			medsrvAggDO.setMedSrvOpDO(null);
		}
		if ((StringUtils.isNotEmpty(sdSrvtp) && !sdSrvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_NURSE_VS))) {
			// 不是生命体征类型，清空生命体征属性
			medsrvAggDO.setMedSrvVtDO(null);
		}
		if (StringUtils.isNotEmpty(sdSrvtp)
				&& !sdSrvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS)) {
			// 不是会诊类型，清空会诊属性
			medsrvAggDO.setMedSrvConsDO(null);
		}
		if (StringUtils.isNotEmpty(sdSrvtp) && !sdSrvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_SANI)) {
			// 不是卫材类型，清空卫材属性
			medsrvAggDO.setMedSrvSaniDO(null);
		}
	}
}
