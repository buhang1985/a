package iih.bl.cg.service;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blrecgoepdto.d.BlRecgOepDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.st.blauditip.d.BlAuditIp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;


public interface IBlCgMaintainService {
	
	/**
	 * 住院退/补费
	 * @author 卫佳
	 * */
	public abstract BlCgIpDO[] doBlCgIpInfoMend(String id_ent,BlCgIpDO[] blcgOrArr) throws BizException;
	
	/**
	 * 住院重划价
	 * @param id_ent 就诊ID
	 * @param id_pripat_from 原患者价格分类ID
	 * @param id_pripat_to 新患者价格分类ID
	 * @param OperatorInfoDTO 操作人员基本信息
	 * @return 重划价成功，返回FBoolean.TRUE；失败，返回FBoolean.FALSE
	 * @throws BizException
	 * @author 唐婵懿
	 */
	public abstract FBoolean doIpRePricingCg(String id_ent,String id_pripat_from,String id_pripat_to,OperatorInfoDTO operatorInfo)  throws BizException;
	
	/**
	 * 门诊重划价
	 * @param id_pat 就诊ID
	 * @param id_ent 就诊ID
	 * @param id_pripat_from 原患者价格分类ID
	 * @param id_pripat_to 新患者价格分类ID
	 * @param OperatorInfoDTO 操作人员基本信息
	 * @return 重划价成功，返回FBoolean.TRUE；失败，返回FBoolean.FALSE
	 * @throws BizException
	 * @author 
	 */
	public abstract FBoolean doOepRePricingCg(String id_pat,String id_ent,String id_pripat_from,String id_pripat_to,OperatorInfoDTO operatorInfo) throws BizException;
	
	/**
	 * 根据患者id_pat 查询门诊记账明细表bl_cg_itm_oep 是否 含有挂起的数据
	 * @param id_pat
	 * @author liwq
	 */
	public BlRecgOepDTO[] getBlCgItmOepFgSuspInfo(String id_pat) throws BizException;
	
	/**
	 * 预交金记账
	 * */
	public FBoolean doOrSrvInfoAccount(BlOrderAppendBillParamDTO[] orSrvArr, String code_entp) throws BizException;
}
