package iih.bl.hp.s;

import iih.bl.comm.dto.d.BlCheckResultDTO;
import iih.bl.hp.bp.BatchCheckHasPsdLimitBP;
import iih.bl.hp.bp.CheckDiDependBP;
import iih.bl.hp.bp.CheckHasPsdLimitBP;
import iih.bl.hp.bp.CheckIsHpBlackPatBP;
import iih.bl.hp.bp.CheckIsHpBlackPatByPatIdBP;
import iih.bl.hp.bp.CheckIsPatDiBP;
import iih.bl.hp.dto.chronic.d.BlHpChronicCheck2DTO;
import iih.bl.hp.dto.chronic.d.BlHpChronicCheckDTO;
import iih.bl.hp.dto.d.BlOutDetailedDataDTO;
import iih.bl.hp.dto.d.DiDependDTO;
import iih.bl.hp.i.IBlHpOutQryService;
import iih.bl.hp.insurecard.d.CardPersonInfoDTO;
import iih.bl.hp.s.bp.BlHpCheckChronicOrderBP;
import iih.bl.hp.s.bp.BlHpCheckChronicPresBP;
import iih.bl.hp.s.bp.BlHpIsSpecDiBP;
import iih.bl.hp.s.bp.GetUploadDetailedDataOutBP;
import iih.bl.hp.s.bp.HpJudgeIfFundpayBP;
import iih.bl.hp.s.bp.IpCanChangeHpIdentityBP;
import iih.bl.hp.s.bp.IsAllInHpBP;
import iih.bl.hp.s.bp.IsPoorPatBP;

import java.util.Map;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医保对外查询服务
 * @author yankan
 * @since 2017-08-31
 *
 */
@Service(serviceInterfaces={IBlHpOutQryService.class}, binding=Binding.JSONRPC)
public class BlHpOutQryServiceImpl implements IBlHpOutQryService {
	/**
	 * 检查诊断依赖
	 * 
	 * @param endId 就诊ID
	 * @param diIds 诊断ID集合
	 * @param diIdsAll 剩余全部诊断ID集合
	 * @return 诊断依赖结果
	 * @throws BizException
	 */
	@Override
	public DiDependDTO[] checkDiDepend(String endId,String[] diIds,String[] diIdsAll) throws BizException{
		CheckDiDependBP checkBP = new CheckDiDependBP();
		return checkBP.exec(endId, diIds,diIdsAll);
	}
	/**
	 * 是否存在单方限制
	 * @param hpId 医保计划ID
	 * @param srvId 服务ID
	 * @return FBoolean
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public FBoolean hasPsdLimit(String hpId,String srvId) throws BizException{
		CheckHasPsdLimitBP checkBP = new CheckHasPsdLimitBP();
		return checkBP.exec(hpId, srvId);
	}
	/**
	 * 批量判定是否存在单方限制
	 * @param hpId 医保计划ID
	 * @param srvIds 服务ID集合
	 * @return Map,[key: 服务ID，value:FBoolean]
	 * @throws BizException
	 * @author yankan
	 */
	@Override
	public Map<String,FBoolean> batchCheckHasPsdLimit(String hpId,String[] srvIds) throws BizException{
		BatchCheckHasPsdLimitBP batchCheckBP = new BatchCheckHasPsdLimitBP();
		return batchCheckBP.exec(hpId, srvIds);
	}
	/**
	 * 是否医保黑名单患者
	 * @param hpId 医保计划
	 * @param insurNo 医保卡号
	 * @return FBoolean
	 * @throws BizException
	 */
	@Override
	public FBoolean isHpBlackPat(String hpId,String insurNo) throws BizException{
		CheckIsHpBlackPatBP checkBP = new CheckIsHpBlackPatBP();
		return checkBP.exec(hpId, insurNo);
	}
	/**
	 * 是否医保黑名单患者
	 * @param hpId 医保计划
	 * @param patId 患者ID
	 * @return FBoolean
	 * @throws BizException
	 */
	@Override
	public FBoolean isHpBlackPatByPatId(String hpId,String patId) throws BizException{
		CheckIsHpBlackPatByPatIdBP checkBP = new CheckIsHpBlackPatByPatIdBP();
		return checkBP.exec(hpId, patId);
	}
	
	/**
	 * 判定是否医保特殊病	 
	 * @param hpId 医保计划ID
	 * @param patId 患者ID
	 * @param diDefIds 诊断ID集合
	 * @return fmap,[key:诊断ID,value:FBoolean]
	 * @throws BizException
	 */
	@Override
	public FMap isPatSpecDi(String hpId,String patId,String[] diDefIds) throws BizException{
		CheckIsPatDiBP checkBP = new CheckIsPatDiBP();
		return checkBP.exec(hpId, patId, diDefIds);
	}
	
	/**
	 * 判断是否基金支付
	 * @param dto
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean ifFundpay(CardPersonInfoDTO dto,String codeEntp) throws BizException {
		HpJudgeIfFundpayBP bp = new HpJudgeIfFundpayBP();
		return bp.exec(dto, codeEntp);
	}
	
	/**
	 * 判断是否全保内(副部级)
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean isAllInHp(String entId) throws BizException {
		IsAllInHpBP bp=new IsAllInHpBP();
		return bp.exec(entId);
	}
	
	/**
	 * 是否特殊病患者
	 * @param hpId 医保计划id
	 * @param hpNo 医保号
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean isSpecDi(String hpId,String hpNo) throws BizException{
		BlHpIsSpecDiBP bp = new BlHpIsSpecDiBP();
		return bp.exec(hpId, hpNo);
	}
	
	/**
	 * 是否贫困患者
	 * @param patIds
	 * @return key 患者id value:FBoolean 
	 * @throws BizException
	 * @author ly 2018/07/12
	 */
	@Override
	public FMap isPoorPat(String[] patIds) throws BizException{
		IsPoorPatBP bp = new IsPoorPatBP();
		return bp.exec(patIds);
	}
	
	/**
	 * 是否可进行医保身份转换(住院)
	 * @param entId 就诊id
	 * @return true:可以 false:不可以
	 * @throws BizException
	 * @author ly 2018/10/04
	 */
	@Override
	public BlCheckResultDTO canChangeHpIdentity(String entId) throws BizException{
		IpCanChangeHpIdentityBP bp = new IpCanChangeHpIdentityBP();
		return bp.exec(entId);
	}
	
	/**
	 * 校验慢性病处方
	 * @param presIds
	 * @return 校验结果
	 * @throws BizException
	 * @author ly 2018/10/25
	 */
	@Override
	public BlHpChronicCheckDTO[] checkChronicPres(String[] presIds) throws BizException{
		BlHpCheckChronicPresBP bp = new BlHpCheckChronicPresBP();
		return bp.exec(presIds);
	}
	
	/**
	 * 校验慢性病医嘱
	 * @param orIds
	 * @return
	 * @throws BizException
	 * @author ly 2019/10/21
	 */
	@Override
	public BlHpChronicCheck2DTO[] checkChronicOr(String[] orIds) throws BizException{
		BlHpCheckChronicOrderBP bp = new BlHpCheckChronicOrderBP();
		return bp.exec(orIds);
	}
	
	/**
	 * 获取患者当前已上传明细信息
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlOutDetailedDataDTO getDetailedData(String entId) throws BizException {
		GetUploadDetailedDataOutBP bp=new GetUploadDetailedDataOutBP();
		return bp.exec(entId);
	}
}
