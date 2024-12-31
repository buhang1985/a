package iih.mi.bd.i;

import iih.mi.bd.d.DeptBaseInfoDTO;
import iih.mi.bd.d.DosageBaseInfoDTO;
import iih.mi.bd.d.EnTpBaseInfoDTO;
import iih.mi.bd.d.FreqBaseInfoDTO;
import iih.mi.bd.d.HpDTO;
import iih.mi.bd.d.HpDocDTO;
import iih.mi.bd.d.InsurKindBaseInfoDTO;
import iih.mi.bd.d.MedPayTpBaseInfoDTO;
import iih.mi.bd.d.MiudidocDTO;
import iih.mi.bd.d.PatCaBaseInfoDTO;
import iih.mi.bd.d.PresTpBaseInfoDTO;
import iih.mi.bd.d.ReferralStatusBaseInfoDTO;
import iih.mi.bd.d.RegionBaseInfoDTO;
import iih.mi.mibd.d.AdmStatusBaseInfoDTO;
import iih.mi.mibd.d.FeecaInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 医保平台基础数据查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IMiBdQryService {

	/**
	 * 查询所有医保产品集合
	 * 
	 * @return HpDTO[] 医保产品集合
	 * @throws BizException
	 */
	public abstract HpDTO[] findAllHps() throws BizException;

	/**
	 * 获取医保产品实体参数值
	 * 
	 * @return
	 * @throws BizException
	 * @author yangyang
	 */
	public abstract FMap2 findHpParams(String hpId, String[] strParamCodeArr) throws BizException;

	/**
	 * 根据医保产品主键集合查询医保产品集合
	 * 
	 * @param hpIds
	 *            医保产品主键集合
	 * @return HpDTO[] 医保产品集合
	 * @throws BizException
	 */
	public abstract HpDTO[] findHpsByIds(String[] hpIds) throws BizException;

	/**
	 * 根据医保产品主键查询医保产品
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @return HpDTO 医保产品
	 * @throws BizException
	 */
	public abstract HpDTO findHpById(String hpId) throws BizException;

	/**
	 * 根据险种编码集合查询险种基础信息集合
	 * 
	 * @param hpId
	 * @param insurKindCodes
	 * @return InsurKindBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract InsurKindBaseInfoDTO[] findInsurKindsByCodes(String hpId, String[] insurKindCodes)
			throws BizException;

	/**
	 * 根据患者身份编码集合查询患者身份基础信息集合
	 * 
	 * @param hpId
	 * @param patCaCodes
	 * @return PatCaBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract PatCaBaseInfoDTO[] findPatsCaByCodes(String hpId, String[] patCaCodes) throws BizException;

	/**
	 * 根据HIS科室主键集合查询科室基础信息集合
	 * 
	 * @param hpId
	 * @param hisDeptIds
	 * @return DeptBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract DeptBaseInfoDTO[] findDeptsByHisDeptIds(String hpId, String[] hisDeptIds) throws BizException;

	/**
	 * 根据科室编码集合查询科室基础信息集合
	 * 
	 * @param hpId
	 * @param deptCodes
	 * @return DeptBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract DeptBaseInfoDTO[] findDeptsByCodes(String hpId, String[] deptCodes) throws BizException;

	/**
	 * 根据HIS频次主键集合查询频次基础信息集合
	 * 
	 * @param hpId
	 * @param hisFreqIds
	 * @return FreqBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract FreqBaseInfoDTO[] findFreqsByHisFreqIds(String hpId, String[] hisFreqIds) throws BizException;

	/**
	 * 根据频次编码集合查询频次基础信息集合
	 * 
	 * @param hpId
	 * @param freqCodes
	 * @return FreqBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract FreqBaseInfoDTO[] findFreqsByCodes(String hpId, String[] freqCodes) throws BizException;

	/**
	 * 根据HIS剂型主键集合查询剂型基础信息集合
	 * 
	 * @param hpId
	 * @param hisDosageIds
	 * @return DosageBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract DosageBaseInfoDTO[] findDosagesByHisDosageIds(String hpId, String[] hisDosageIds)
			throws BizException;

	/**
	 * 根据剂型编码集合查询剂型基础信息集合
	 * 
	 * @param hpId
	 * @param dosageCodes
	 * @return DosageBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract DosageBaseInfoDTO[] findDosagesByCodes(String hpId, String[] dosageCodes) throws BizException;

	/**
	 * 根据HIS处方类型主键集合查询处方类型基础信息集合
	 * 
	 * @param hpId
	 * @param hisPresTpIds
	 * @return PresTpBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract PresTpBaseInfoDTO[] findPresTpsByHisPresTpIds(String hpId, String[] hisPresTpIds)
			throws BizException;

	/**
	 * 根据处方类型编码集合查询处方类型基础信息集合
	 * 
	 * @param hpId
	 * @param presTpCodes
	 * @return PresTpBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract PresTpBaseInfoDTO[] findPresTpsByCodes(String hpId, String[] presTpCodes) throws BizException;

	/**
	 * 根据转诊状态编码集合查询转诊状态基础信息集合
	 * 
	 * @param hpId
	 * @param referralStatusCodes
	 * @return ReferralStatusBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract ReferralStatusBaseInfoDTO[] findReferralStatussByCodes(String hpId, String[] referralStatusCodes)
			throws BizException;

	/**
	 * 根据医疗付款方式编码集合查询医疗付款方式基础信息集合
	 * 
	 * @param hpId
	 * @param medPayTpCodes
	 * @return MedPayTpBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract MedPayTpBaseInfoDTO[] findMedPayTpsByCodes(String hpId, String[] medPayTpCodes) throws BizException;

	/**
	 * 根据就诊类型编码集合查询就诊类型基础信息集合
	 * 
	 * @param hpId
	 * @param enTpCodes
	 * @return EnTpBaseInfo[]
	 * @throws BizException
	 */
	public abstract EnTpBaseInfoDTO[] findEnTpsByCodes(String hpId, String[] enTpCodes) throws BizException;

	/**
	 * 根据入院状态编码集合查询入院状态基础信息集合
	 * 
	 * @param hpId
	 * @param admStatusCodes
	 * @return AdmStatusBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract AdmStatusBaseInfoDTO[] findAdmStatussByCodes(String hpId, String[] admStatusCodes)
			throws BizException;

	/**
	 * 根据费用编码集合查询费用对照基础信息集合
	 * 
	 * @param hpId
	 * @param feecaCodes
	 * @return
	 * @throws BizException
	 */
	public FeecaInfoDTO[] findHpFeecaByCodes(String hpId, String[] feecaCodes) throws BizException;

	/**
	 * 根据地区编码集合查询地区基础信息集合
	 * 
	 * @param hpId
	 * @param regionCodes
	 * @return RegionBaseInfoDTO[]
	 * @throws BizException
	 */
	public abstract RegionBaseInfoDTO[] findRegionsByCodes(String hpId, String[] regionCodes) throws BizException;

	/**
	 * 根据编码查询医保档案数据
	 * (档案编码为空时，返回该档案类型下全部档案数据)
	 * 
	 * @param hpId 医保产品id
	 * @param docTypeCode 档案类型编码
	 * @param docCodes 档案编码
	 * @return 档案数据
	 * @throws BizException
	 * @author ly 2018/09/08
	 */
	public abstract HpDocDTO[] findHpDocByCodes(String hpId, String docTypeCode, String[] docCodes) throws BizException;

	/**
	 * 根据编码查询医保档案数据
	 * (档案编码为空时，返回该档案类型下全部档案数据)
	 * @param hpId 医保产品id
	 * @param doclistCode 档案类型编码
	 * @param docCodes 档案编码
	 * @return
	 * @throws BizException
	 */
	public abstract MiudidocDTO[] findMiudidocByCodes(String hpId,String doclistCode,String[] docCodes) throws BizException;

}
