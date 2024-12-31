package iih.bl.hp.i;

import iih.bl.comm.dto.d.BlCheckResultDTO;
import iih.bl.hp.dto.chronic.d.BlHpChronicCheck2DTO;
import iih.bl.hp.dto.chronic.d.BlHpChronicCheckDTO;
import iih.bl.hp.dto.d.BlOutDetailedDataDTO;
import iih.bl.hp.dto.d.DiDependDTO;
import iih.bl.hp.insurecard.d.CardPersonInfoDTO;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医保对外查询服务
 * @author yankan
 * @since 2017-08-31
 *
 */
public interface IBlHpOutQryService {
	/**
	 * 检查诊断依赖
	 * 
	 * @param endId 就诊ID
	 * @param diIds 诊断ID集合
	 * @param diIdsAll 剩余全部诊断ID集合
	 * @return 诊断依赖结果
	 * @throws BizException
	 */
	public abstract DiDependDTO[] checkDiDepend(String endId,String[] diIds,String[] diIdsAll) throws BizException;
	
	/**
	 * 是否存在单方限制
	 * @param hpId 医保计划ID
	 * @param srvId 服务ID
	 * @return FBoolean
	 * @throws BizException
	 * @author yankan
	 */
	public abstract FBoolean hasPsdLimit(String hpId,String srvId) throws BizException;
	/**
	 * 批量判定是否存在单方限制
	 * @param hpId 医保计划ID
	 * @param srvIds 服务ID集合
	 * @return Map,[key: 服务ID，value:FBoolean]
	 * @throws BizException
	 * @author yankan
	 */
	public abstract Map<String,FBoolean> batchCheckHasPsdLimit(String hpId,String[] srvIds) throws BizException;
	/**
	 * 是否医保黑名单患者
	 * @param hpId 医保计划
	 * @param insurNo 医保卡号
	 * @return FBoolean
	 * @throws BizException
	 */
	public abstract FBoolean isHpBlackPat(String hpId,String insurNo) throws BizException;
	/**
	 * 是否医保黑名单患者
	 * @param hpId 医保计划
	 * @param patId 患者ID
	 * @return FBoolean
	 * @throws BizException
	 */
	public abstract FBoolean isHpBlackPatByPatId(String hpId,String patId) throws BizException;
	/**
	 * 判定是否医保特殊病	 
	 * @param hpId 医保计划ID
	 * @param patId 患者ID
	 * @param diDefIds 诊断ID集合
	 * @return fmap,[key:诊断ID,value:FBoolean]
	 * @throws BizException
	 */
	public abstract FMap isPatSpecDi(String hpId,String patId,String[] diDefIds) throws BizException;
	
	/**
	 * 判断是否基金支付
	 * @param dto 医保卡信息
	 * @param codeEntp 就诊编码
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean ifFundpay(CardPersonInfoDTO dto,String codeEntp) throws BizException;
	
	/**
	 * 判断是否全保内(副部级)
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean isAllInHp(String entId) throws BizException;
	
	/**
	 * 是否特殊病患者
	 * @param hpId 医保计划id
	 * @param hpNo 医保号
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean isSpecDi(String hpId,String hpNo) throws BizException;
	
	/**
	 * 是否贫困患者
	 * @param patIds 患者ids
	 * @return key 患者id value:FBoolean 
	 * @throws BizException
	 * @author ly 2018/07/12
	 */
	public abstract FMap isPoorPat(String[] patIds) throws BizException;
	
	/**
	 * 是否可进行医保身份转换(住院)
	 * @param entId 就诊id
	 * @return true:可以 false:不可以
	 * @throws BizException
	 * @author ly 2018/10/04
	 */
	public abstract BlCheckResultDTO canChangeHpIdentity(String entId) throws BizException;
	
	/**
	 * 校验慢性病处方
	 * @param presIds
	 * @return 校验结果
	 * @throws BizException
	 * @author ly 2018/10/25
	 */
	public abstract BlHpChronicCheckDTO[] checkChronicPres(String[] presIds) throws BizException;
	
	/**
	 * 校验慢性病医嘱
	 * @param orIds
	 * @return
	 * @throws BizException
	 * @author ly 2019/10/21
	 */
	public abstract BlHpChronicCheck2DTO[] checkChronicOr(String[] orIds) throws BizException;
	
	/**
	 * 获取患者当前已上传明细信息
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public abstract BlOutDetailedDataDTO getDetailedData(String entId)throws BizException;
}
