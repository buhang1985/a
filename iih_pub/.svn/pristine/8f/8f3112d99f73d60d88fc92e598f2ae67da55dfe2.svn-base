package iih.mi.bd.i;

import iih.mi.bd.d.DischargedStatusCompDTO;
import iih.mi.bd.d.DosageCompInfoDTO;
import iih.mi.bd.d.FeeCaCompInfoDTO;
import iih.mi.bd.d.MiUdidocCompDTO;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.mi.bd.didefcompinfo.d.DiDefCompInfoDTO;
import iih.mi.bd.miudidoccomp.d.MiUdidocCompDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 医疗保险基础数据目录对照查询服务
 * 
 * @author hao_wu
 *
 */
public interface IMiBdDirCompQryService {
	/**
	 * 根据HIS医疗服务编码集合和药品编码集合查询三大目录对照信息集合
	 * 
	 * @param hpId
	 * @param hisMedSrvCodes
	 * @param hisDrugCodes
	 * @return ThreeDirCompInfoDTO[]
	 * @throws BizException
	 */
	public abstract ThreeDirCompInfoDTO[] findThreeDirCompByHisSrvCodesAndDrugCodes(String hpId, String[] hisMedSrvCodes,
			String[] hisDrugCodes) throws BizException;
	
	/**
	 * 根据HIS医疗服务主键集合和药品主键集合查询三大目录对照信息集合
	 * 
	 * @param hpId
	 * @param hisMedSrvIds
	 * @param hisDrugIds
	 * @return ThreeDirCompInfoDTO[]
	 * @throws BizException
	 */
	public abstract ThreeDirCompInfoDTO[] findThreeDirCompByHisSrvIdsAndDrugIds(String hpId, String[] hisMedSrvIds,
			String[] hisDrugIds) throws BizException;

	/**
	 * 根据HIS入院状态主键集合查询医保入院状态字典
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @param hisEnTpIds
	 *            HIS入院状态主键集合
	 * @return 医保入院状态字典[HIS入院状态主键, AdmStatusCompInfoDTO]
	 * @throws BizException
	 */
	public FMap2 findAdmStatusMapByHisIds(String hpId, String[] hisAdmStatusIds) throws BizException;

	/**
	 * 根据HIS就诊类型主键集合查询医保就诊类型字典
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @param hisEnTpIds
	 *            HIS就诊类型主键集合
	 * @return 医保就诊类型字典[HIS就诊类型主键,EnTpBaseInfoDTO]
	 * @throws BizException
	 */
	public FMap2 findEnTpMapByHisIds(String hpId, String[] hisEnTpIds) throws BizException;

	/**
	 * 根据HIS转诊状态主键集合查询转诊状态基础信息字典
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @param hisReferrStatusIds
	 *            HIS转诊状态主键集合
	 * @return 转诊状态基础信息字[HIS转诊状态主键,ReferralStatusBaseInfoDTO]
	 * @throws BizException
	 */
	public abstract FMap2 findReferralStatusMapByHisIds(String hpId, String[] hisReferrStatusIds) throws BizException;

	/**
	 * 根据HIS出院状态编码集合查询出院状态对照集合
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @param dischargedStatusCodes
	 *            HIS出院状态编码集合
	 * @return 出院状态对照集合
	 * @throws BizException
	 */
	public abstract DischargedStatusCompDTO[] findDischargedStatusCompByHisCodes(String hpId,
			String[] dischargedStatusCodes) throws BizException;

	/**
	 * 根据HIS出院状态主键集合查询出院状态对照集合
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @param dischargedStatusIds
	 *            HIS出院状态主键集合
	 * @return 出院状态对照集合
	 * @throws BizException
	 */
	public abstract DischargedStatusCompDTO[] findDischargedStatusCompByHisIds(String hpId,
			String[] dischargedStatusIds) throws BizException;

	/**
	 * 根据HIS出院状态编码集合查询出院状态对照字典
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @param dischargedStatusCodes
	 *            HIS出院状态编码集合
	 * @return 出院状态对照字典[HIS出院状态编码,出院状态对照]
	 * @throws BizException
	 */
	public abstract FMap2 findDischargedStatusCompMapByHisCodes(String hpId, String[] dischargedStatusCodes)
			throws BizException;

	/**
	 * 根据HIS出院状态主键集合查询出院状态对照字典
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @param dischargedStatusIds
	 *            HIS出院状态主键集合
	 * @return 出院状态对照字典[HIS出院状态主键,出院状态对照]
	 * @throws BizException
	 */
	public abstract FMap2 findDischargedStatusCompMapByHisIds(String hpId, String[] dischargedStatusIds)
			throws BizException;

	/**
	 * 查询费别对照
	 * @param hpId 医保id
	 * @param inccaId 票据分类id
	 * @param codeInccaItms 票据分类项目编码数组
	 * @return 对照数据
	 * @throws BizException
	 * @author ly 2018/09/13
	 */
	public abstract FeeCaCompInfoDTO[] findFeeCaCompInfo(String hpId, String inccaId, String[] codeInccaItms) throws BizException;
	
	/**
	 * 查询剂型对照
	 * @param hpId 医保id
	 * @param dosageCodes 剂型编码数组
	 * @return 对照数据
	 * @throws BizException
	 * @author ly 2018/09/13
	 */
	public abstract DosageCompInfoDTO[] findDosageCompInfo(String hpId, String[] dosageCodes) throws BizException;

	/**
	 * 查询诊断对照
	 * @param hpId
	 * @param diDefCodes
	 * @return
	 * @throws BizException
	 * @author liwenqing 2018.10.29
	 */
	public abstract DiDefCompInfoDTO[] findDiDefCompInfo(String hpId,String[] diDefCodes) throws BizException;
	/**
	 * 查询医保档案对照
	 * @param hpId
	 * @param doclistCode
	 * @param docCodes
	 */
	public abstract MiUdidocCompDTO[] MiudidocCompInfo(String hpId,String doclistCode,String[] docCodes)throws BizException;
}
