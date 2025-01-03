package iih.bl.st.service.i;

import java.util.Map;

import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.prop.blproparip.d.BlproparipAggDO;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.dto.d.BlOpFeeOutDTO;
import iih.bl.st.dto.d.BlOpfeeInfoDTO;
import iih.bl.st.dto.d.BlStIpBadDebtDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.itf.context.InsureContext;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

public interface IBLStMaintainService {

	/**
	 * 出院结算退款
	 * */
	public abstract BlPrePayPatDO doStipRefund(String idEnt, String id_stip, String sd_pttp,FBoolean isSaveRedProp) throws BizException;
	
	/**
	 * 住院结算欠费补交
	 * */
	public abstract FBoolean doArrearsPayMent(OperatorInfoDTO operatorInfoDTO, BlPayPatIpDO blPayPatIpDO, BlPayItmPatIpDO[] blPayItmPatIpDOArr) throws BizException;
	
	/**
	 * 坏账处理
	 * */
	public abstract FBoolean doBadPayMent(BlStIpBadDebtDTO[] blStIpArr) throws BizException;
	
	/**
	 * 读取就诊数据
	 * */
	public abstract BlOpfeeInfoDTO findLoadOutInfo(BlOpFeeOutDTO[] blOpFeeOutArr,OperatorInfoDTO operatorInfo) throws BizException;
	
	/**
	 * 校验患者医保审核状态
	 * */
	public abstract FMap checkPatHpStatus(String id_ent) throws BizException;
}
