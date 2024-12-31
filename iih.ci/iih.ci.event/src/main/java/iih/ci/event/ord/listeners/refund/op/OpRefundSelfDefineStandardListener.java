package iih.ci.event.ord.listeners.refund.op;

import java.util.Hashtable;
import java.util.List;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 门诊退费入口标准版
 * 
 * @author F
 *
 * @date 2019年9月16日下午4:11:49
 *
 * @classpath iih.ci.event.ord.listeners.refund.op.OpRefundSelfDefineStandardListener
 */
public class OpRefundSelfDefineStandardListener extends OpRefundEnterListener {
	
	/**
	 * 门诊、急诊流水、急诊抢救数据筛选
	 */
	@Override
	protected boolean isOpData(BlCgItmOepDO oepDO) {
		if(OrdEventUtil.isEmpty(oepDO.getCode_enttp())||!OrdEventUtil.OP.equals(oepDO.getCode_enttp())) {//门诊退费
			OrdEventLogger.info(this.getClass().getSimpleName(), "门诊退费标准版,筛选门诊退费数据code_entp:"+oepDO.getCode_enttp());
			return false;
		}
		return true;
	}

	@Override
	public void fireMessageByCode_applytp(Hashtable<String, List<OpRefund4IpEsDTO>> hashtable) throws BizException {
		if (OrdEventUtil.isEmpty(hashtable)) {
			return;
		}
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊退费标准版,数据筛选结果:"+hashtable.toString());
		// 门诊处方退费BS302
		// 01 处方(西药+草药)
		OrdEventUtil.fireSelfDefineMessage(OrdEventUtil.CODE_APPLYTP_DRUG_REFUND, hashtable,
				IOrdEventSources.OP_DRUG_REFUND, IEventType.TYPE_UPDATE_AFTER);
		// 门诊检查或者检验退费BS005
		// 检查或者检验
		String types = OrdEventUtil.CODE_APPLYTP_RIS_REFUND + OrdEventUtil.COMMA_STR
				+ OrdEventUtil.CODE_APPLYTP_LIS_REFUND;
		OrdEventUtil.fireSelfDefineMessage(types, hashtable, IOrdEventSources.OP_RIS$LIS_REFUND,
				IEventType.TYPE_UPDATE_AFTER);
		// 门诊诊疗退费BS303
		// 04诊疗 退费用04代表诊疗
		OrdEventUtil.fireSelfDefineMessage(OrdEventUtil.CODE_APPLYTP_TREAT_REFUND, hashtable,
				IOrdEventSources.OP_TREAT_REFUND, IEventType.TYPE_UPDATE_AFTER);
	}

}
