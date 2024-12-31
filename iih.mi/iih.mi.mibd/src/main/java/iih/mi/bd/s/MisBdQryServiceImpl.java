package iih.mi.bd.s;

import iih.mi.bd.d.DeptBaseInfoDTO;
import iih.mi.bd.d.DischargedStatusCompDTO;
import iih.mi.bd.d.DosageBaseInfoDTO;
import iih.mi.bd.d.DosageCompInfoDTO;
import iih.mi.bd.d.EnTpBaseInfoDTO;
import iih.mi.bd.d.FeeCaCompInfoDTO;
import iih.mi.bd.d.FreqBaseInfoDTO;
import iih.mi.bd.d.HpDTO;
import iih.mi.bd.d.HpDocDTO;
import iih.mi.bd.d.InsurKindBaseInfoDTO;
import iih.mi.bd.d.MedPayTpBaseInfoDTO;
import iih.mi.bd.d.MiUdidocCompDTO;
import iih.mi.bd.d.MiudidocDTO;
import iih.mi.bd.d.PatCaBaseInfoDTO;
import iih.mi.bd.d.PresTpBaseInfoDTO;
import iih.mi.bd.d.ReferralStatusBaseInfoDTO;
import iih.mi.bd.d.RegionBaseInfoDTO;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.mi.bd.didefcompinfo.d.DiDefCompInfoDTO;
import iih.mi.bd.i.IMiBdDirCompQryService;
import iih.mi.bd.i.IMiBdQryService;
import iih.mi.bd.s.bp.FindAdmStatusMapByHisIdsBp;
import iih.mi.bd.s.bp.FindAdmStatussByCodesBp;
import iih.mi.bd.s.bp.FindAllHpParamMapBp;
import iih.mi.bd.s.bp.FindAllHpsBp;
import iih.mi.bd.s.bp.FindDeptsByCodesBp;
import iih.mi.bd.s.bp.FindDeptsByHisDeptIdsBp;
import iih.mi.bd.s.bp.FindDiDefCompInfoBp;
import iih.mi.bd.s.bp.FindDischargedStatusCompByHisCodesBp;
import iih.mi.bd.s.bp.FindDischargedStatusCompByHisIdsBp;
import iih.mi.bd.s.bp.FindDischargedStatusCompMapByHisCodesBp;
import iih.mi.bd.s.bp.FindDischargedStatusCompMapByHisIdsBp;
import iih.mi.bd.s.bp.FindDosageCompInfoBP;
import iih.mi.bd.s.bp.FindDosagesByCodesBp;
import iih.mi.bd.s.bp.FindDosagesByHisDosageIdsBp;
import iih.mi.bd.s.bp.FindEnTpMapByHisIdsBp;
import iih.mi.bd.s.bp.FindEnTpsByCodesBp;
import iih.mi.bd.s.bp.FindFeeCaCompInfoBP;
import iih.mi.bd.s.bp.FindFreqsByCodesBp;
import iih.mi.bd.s.bp.FindFreqsByHisFreqIdsBp;
import iih.mi.bd.s.bp.FindHpByIdBp;
import iih.mi.bd.s.bp.FindHpDocByCodesBP;
import iih.mi.bd.s.bp.FindHpDtosByIdsBp;
import iih.mi.bd.s.bp.FindHpFeecaByCodesBp;
import iih.mi.bd.s.bp.FindInsurKindsByCodesBp;
import iih.mi.bd.s.bp.FindMedPayTpsByCodesBp;
import iih.mi.bd.s.bp.FindMiudidocByCodesBP;
import iih.mi.bd.s.bp.FindPatsCaByCodesBp;
import iih.mi.bd.s.bp.FindPresTpsByCodesBp;
import iih.mi.bd.s.bp.FindPresTpsByHisPresTpIdsBp;
import iih.mi.bd.s.bp.FindReferralStatusMapByHisIdsBp;
import iih.mi.bd.s.bp.FindReferralStatussByCodesBp;
import iih.mi.bd.s.bp.FindRegionsByCodesBp;
import iih.mi.bd.s.bp.FindThreeDirCompByHisSrvCodesAndDrugCodesBp;
import iih.mi.bd.s.bp.FindThreeDirCompByHisSrvIdsAndDrugIdsBp;
import iih.mi.bd.s.bp.MiudidocCompInfoBP;
import iih.mi.mibd.d.AdmStatusBaseInfoDTO;
import iih.mi.mibd.d.FeecaInfoDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;

/**
 * 医保平台基础数据查询服务实现类
 * 
 * @author hao_wu
 *
 */
@Service(serviceInterfaces = { IMiBdQryService.class }, binding = Binding.JSONRPC)
public class MisBdQryServiceImpl implements IMiBdQryService, IMiBdDirCompQryService {

	/**
	 * 查询所有医保产品集合
	 * 
	 * @return HpDTO[] 医保产品集合
	 * @throws BizException
	 */
	@Override
	public HpDTO[] findAllHps() throws BizException {
		FindAllHpsBp bp = new FindAllHpsBp();
		HpDTO[] result = bp.exec();
		return result;
	}

	/**
	 * 获取医保产品实体参数值
	 * 
	 * @return
	 * @throws BizException
	 * @author yangyang
	 */
	@Override
	public FMap2 findHpParams(String hpId, String[] strParamCodeArr) throws BizException {
		FindAllHpParamMapBp handlerBp = new FindAllHpParamMapBp();
		return handlerBp.exec(hpId, strParamCodeArr);
	}

	/**
	 * 根据医保产品主键集合查询医保产品集合
	 * 
	 * @param hpIds
	 *            医保产品主键集合
	 * @return HpDTO[] 医保产品集合
	 * @throws BizException
	 */
	@Override
	public HpDTO[] findHpsByIds(String[] hpIds) throws BizException {
		FindHpDtosByIdsBp bp = new FindHpDtosByIdsBp();
		HpDTO[] result = bp.exec(hpIds);
		return result;
	}

	/**
	 * 根据医保产品主键查询医保产品
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @return HpDTO 医保产品
	 * @throws BizException
	 */
	@Override
	public HpDTO findHpById(String hpId) throws BizException {
		FindHpByIdBp bp = new FindHpByIdBp();
		HpDTO result = bp.exec(hpId);
		return result;
	}

	/**
	 * 根据险种编码集合查询险种基础信息集合
	 * 
	 * @param hpId
	 * @param insurKindCodes
	 * @return InsurKindBaseInfoDTO[]
	 * @throws BizException
	 */
	@Override
	public InsurKindBaseInfoDTO[] findInsurKindsByCodes(String hpId, String[] insurKindCodes) throws BizException {
		FindInsurKindsByCodesBp bp = new FindInsurKindsByCodesBp();
		InsurKindBaseInfoDTO[] result = bp.exec(hpId, insurKindCodes);
		return result;
	}

	/**
	 * 根据患者身份编码集合查询患者身份基础信息集合
	 * 
	 * @param hpId
	 * @param patCaCodes
	 * @return PatCaBaseInfoDTO[]
	 * @throws BizException
	 */
	@Override
	public PatCaBaseInfoDTO[] findPatsCaByCodes(String hpId, String[] patCaCodes) throws BizException {
		FindPatsCaByCodesBp bp = new FindPatsCaByCodesBp();
		PatCaBaseInfoDTO[] result = bp.exec(hpId, patCaCodes);
		return result;
	}

	/**
	 * 根据HIS科室主键集合查询科室基础信息集合
	 * 
	 * @param hpId
	 * @param hisDeptIds
	 * @return DeptBaseInfoDTO[]
	 * @throws BizException
	 */
	@Override
	public DeptBaseInfoDTO[] findDeptsByHisDeptIds(String hpId, String[] hisDeptIds) throws BizException {
		FindDeptsByHisDeptIdsBp bp = new FindDeptsByHisDeptIdsBp();
		DeptBaseInfoDTO[] result = bp.exec(hpId, hisDeptIds);
		return result;
	}

	/**
	 * 根据科室编码集合查询科室基础信息集合
	 * 
	 * @param hpId
	 * @param deptCodes
	 * @return DeptBaseInfoDTO[]
	 * @throws BizException
	 */
	@Override
	public DeptBaseInfoDTO[] findDeptsByCodes(String hpId, String[] deptCodes) throws BizException {
		FindDeptsByCodesBp bp = new FindDeptsByCodesBp();
		DeptBaseInfoDTO[] result = bp.exec(hpId, deptCodes);
		return result;
	}

	/**
	 * 根据HIS频次主键集合查询频次基础信息集合
	 * 
	 * @param hpId
	 * @param hisFreqIds
	 * @return FreqBaseInfoDTO[]
	 * @throws BizException
	 * @author hexx
	 */
	@Override
	public FreqBaseInfoDTO[] findFreqsByHisFreqIds(String hpId, String[] hisFreqIds) throws BizException {
		FindFreqsByHisFreqIdsBp bp = new FindFreqsByHisFreqIdsBp();
		FreqBaseInfoDTO[] result = bp.exec(hpId, hisFreqIds);
		return result;
	}

	/**
	 * 根据频次编码集合查询频次基础信息集合
	 * 
	 * @param hpId
	 * @param freqCodes
	 * @return FreqBaseInfoDTO[]
	 * @throws BizException
	 * @author hexx
	 */
	@Override
	public FreqBaseInfoDTO[] findFreqsByCodes(String hpId, String[] freqCodes) throws BizException {
		FindFreqsByCodesBp bp = new FindFreqsByCodesBp();
		FreqBaseInfoDTO[] result = bp.exec(hpId, freqCodes);
		return result;
	}

	/**
	 * 根据HIS剂型主键集合查询剂型基础信息集合
	 * 
	 * @param hpId
	 * @param hisDosageIds
	 * @return DosageBaseInfoDTO[]
	 * @throws BizException
	 * @author hexx
	 */
	@Override
	public DosageBaseInfoDTO[] findDosagesByHisDosageIds(String hpId, String[] hisDosageIds) throws BizException {
		FindDosagesByHisDosageIdsBp bp = new FindDosagesByHisDosageIdsBp();
		DosageBaseInfoDTO[] result = bp.exec(hpId, hisDosageIds);
		return result;
	}

	/**
	 * 根据剂型编码集合查询剂型基础信息集合
	 * 
	 * @param hpId
	 * @param dosageCodes
	 * @return DosageBaseInfoDTO[]
	 * @throws BizException
	 * @author hexx
	 */
	@Override
	public DosageBaseInfoDTO[] findDosagesByCodes(String hpId, String[] dosageCodes) throws BizException {
		FindDosagesByCodesBp bp = new FindDosagesByCodesBp();
		DosageBaseInfoDTO[] result = bp.exec(hpId, dosageCodes);
		return result;
	}

	/**
	 * 根据HIS处方类型主键集合查询处方类型基础信息集合
	 * 
	 * @param hpId
	 * @param hisPresTpIds
	 * @return PresTpBaseInfoDTO[]
	 * @throws BizException
	 * @author hexx
	 */
	@Override
	public PresTpBaseInfoDTO[] findPresTpsByHisPresTpIds(String hpId, String[] hisPresTpIds) throws BizException {
		FindPresTpsByHisPresTpIdsBp bp = new FindPresTpsByHisPresTpIdsBp();
		PresTpBaseInfoDTO[] result = bp.exec(hpId, hisPresTpIds);
		return result;
	}

	/**
	 * 根据处方类型编码集合查询处方类型基础信息集合
	 * 
	 * @param hpId
	 * @param presTpCodes
	 * @return PresTpBaseInfoDTO[]
	 * @throws BizException
	 * @author hexx
	 */
	@Override
	public PresTpBaseInfoDTO[] findPresTpsByCodes(String hpId, String[] presTpCodes) throws BizException {
		FindPresTpsByCodesBp bp = new FindPresTpsByCodesBp();
		PresTpBaseInfoDTO[] result = bp.exec(hpId, presTpCodes);
		return result;
	}

	/**
	 * 根据转诊状态编码集合查询转诊状态基础信息集合
	 * 
	 * @param hpId
	 * @param referralStatusCodes
	 * @return
	 * @throws BizException
	 * @author hexx
	 */
	@Override
	public ReferralStatusBaseInfoDTO[] findReferralStatussByCodes(String hpId, String[] referralStatusCodes)
			throws BizException {
		FindReferralStatussByCodesBp bp = new FindReferralStatussByCodesBp();
		ReferralStatusBaseInfoDTO[] result = bp.exec(hpId, referralStatusCodes);
		return result;
	}

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
	@Override
	public FMap2 findReferralStatusMapByHisIds(String hpId, String[] hisReferrStatusIds) throws BizException {
		FindReferralStatusMapByHisIdsBp bp = new FindReferralStatusMapByHisIdsBp();
		FMap2 result = bp.exec(hpId, hisReferrStatusIds);
		return result;
	}

	/**
	 * 根据医疗付款方式编码集合查询医疗付款方式基础信息集合
	 * 
	 * @param hpId
	 * @param medPayTpCodes
	 * @return
	 * @throws BizException
	 * @author hexx
	 */
	@Override
	public MedPayTpBaseInfoDTO[] findMedPayTpsByCodes(String hpId, String[] medPayTpCodes) throws BizException {
		FindMedPayTpsByCodesBp bp = new FindMedPayTpsByCodesBp();
		MedPayTpBaseInfoDTO[] result = bp.exec(hpId, medPayTpCodes);
		return result;
	}

	/**
	 * 根据就诊类型编码集合查询就诊类型基础信息集合
	 * 
	 * @param hpId
	 * @param enTpCodes
	 * @return EnTpBaseInfo[]
	 * @throws BizException
	 */
	@Override
	public EnTpBaseInfoDTO[] findEnTpsByCodes(String hpId, String[] enTpCodes) throws BizException {
		FindEnTpsByCodesBp bp = new FindEnTpsByCodesBp();
		EnTpBaseInfoDTO[] result = bp.exec(hpId, enTpCodes);
		return result;
	}

	/**
	 * 根据HIS就诊类型主键集合查询医保就诊类型字典
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @param hisEnTpIds
	 *            HIS就诊类型主键集合
	 * @return 医保就诊类型字典[HIS就诊类型主键,医保就诊类型基础信息DTO]
	 * @throws BizException
	 */
	@Override
	public FMap2 findEnTpMapByHisIds(String hpId, String[] hisEnTpIds) throws BizException {
		FindEnTpMapByHisIdsBp bp = new FindEnTpMapByHisIdsBp();
		FMap2 result = bp.exec(hpId, hisEnTpIds);
		return result;
	}

	/**
	 * 根据入院状态编码集合查询入院状态基础信息集合
	 * 
	 * @param hpId
	 * @param admStatusCodes
	 * @return AdmStatusBaseInfoDTO[]
	 * @throws BizException
	 */
	@Override
	public AdmStatusBaseInfoDTO[] findAdmStatussByCodes(String hpId, String[] admStatusCodes) throws BizException {
		FindAdmStatussByCodesBp bp = new FindAdmStatussByCodesBp();
		AdmStatusBaseInfoDTO[] result = bp.exec(hpId, admStatusCodes);
		return result;
	}

	/**
	 * 根据费用编码集合查询费用对照基础信息集合
	 * 
	 * @param hpId
	 * @param admStatusCodes
	 * @return AdmStatusBaseInfoDTO[]
	 * @throws BizException
	 */
	@Override
	public FeecaInfoDTO[] findHpFeecaByCodes(String hpId, String[] feecaCodes) throws BizException {
		FindHpFeecaByCodesBp bp = new FindHpFeecaByCodesBp();
		FeecaInfoDTO[] result = bp.exec(hpId, feecaCodes);
		return result;
	}

	/**
	 * 根据HIS医疗服务主键集合和药品主键集合查询三大目录对照信息集合
	 * 
	 * @param hpId
	 * @param hisMedSrvIds
	 * @param hisDrugIds
	 * @return ThreeDirCompInfoDTO[]
	 * @throws BizException
	 */
	@Override
	public ThreeDirCompInfoDTO[] findThreeDirCompByHisSrvIdsAndDrugIds(String hpId, String[] hisMedSrvCodes,
			String[] hisDrugCodes) throws BizException {
		FindThreeDirCompByHisSrvIdsAndDrugIdsBp bp = new FindThreeDirCompByHisSrvIdsAndDrugIdsBp();
		ThreeDirCompInfoDTO[] result = bp.exec(hpId, hisMedSrvCodes, hisDrugCodes);
		return result;
	}
	
	/**
	 * 根据HIS医疗服务编码集合和药品编码集合查询三大目录对照信息集合
	 * 
	 * @param hpId
	 * @param hisMedSrvCodes
	 * @param hisDrugCodes
	 * @return ThreeDirCompInfoDTO[]
	 * @throws BizException
	 */
	@Override
	public ThreeDirCompInfoDTO[] findThreeDirCompByHisSrvCodesAndDrugCodes(String hpId, String[] hisMedSrvCodes,
			String[] hisDrugCodes) throws BizException {
		FindThreeDirCompByHisSrvCodesAndDrugCodesBp bp = new FindThreeDirCompByHisSrvCodesAndDrugCodesBp();
		ThreeDirCompInfoDTO[] result = bp.exec(hpId, hisMedSrvCodes, hisDrugCodes);
		return result;
	}

	/**
	 * 根据地区编码集合查询地区基础信息集合
	 * 
	 * @param hpId
	 * @param regionCodes
	 * @return RegionBaseInfoDTO[]
	 * @throws BizException
	 */
	@Override
	public RegionBaseInfoDTO[] findRegionsByCodes(String hpId, String[] regionCodes) throws BizException {
		FindRegionsByCodesBp bp = new FindRegionsByCodesBp();
		RegionBaseInfoDTO[] result = bp.exec(hpId, regionCodes);
		return result;
	}

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
	@Override
	public FMap2 findAdmStatusMapByHisIds(String hpId, String[] hisAdmStatusIds) throws BizException {
		FindAdmStatusMapByHisIdsBp bp = new FindAdmStatusMapByHisIdsBp();
		FMap2 result = bp.exec(hpId, hisAdmStatusIds);
		return result;
	}

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
	@Override
	public DischargedStatusCompDTO[] findDischargedStatusCompByHisCodes(String hpId, String[] dischargedStatusCodes)
			throws BizException {
		FindDischargedStatusCompByHisCodesBp bp = new FindDischargedStatusCompByHisCodesBp();
		DischargedStatusCompDTO[] result = bp.exec(hpId, dischargedStatusCodes);
		return result;
	}

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
	@Override
	public DischargedStatusCompDTO[] findDischargedStatusCompByHisIds(String hpId, String[] dischargedStatusIds)
			throws BizException {
		FindDischargedStatusCompByHisIdsBp bp = new FindDischargedStatusCompByHisIdsBp();
		DischargedStatusCompDTO[] result = bp.exec(hpId, dischargedStatusIds);
		return result;
	}

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
	@Override
	public FMap2 findDischargedStatusCompMapByHisCodes(String hpId, String[] dischargedStatusCodes)
			throws BizException {
		FindDischargedStatusCompMapByHisCodesBp bp = new FindDischargedStatusCompMapByHisCodesBp();
		FMap2 result = bp.exec(hpId, dischargedStatusCodes);
		return result;
	}

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
	@Override
	public FMap2 findDischargedStatusCompMapByHisIds(String hpId, String[] dischargedStatusIds) throws BizException {
		FindDischargedStatusCompMapByHisIdsBp bp = new FindDischargedStatusCompMapByHisIdsBp();
		FMap2 result = bp.exec(hpId, dischargedStatusIds);
		return result;
	}
	
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
	@Override
	public HpDocDTO[] findHpDocByCodes(String hpId, String docTypeCode, String[] docCodes) throws BizException {
		FindHpDocByCodesBP bp = new FindHpDocByCodesBP();
		return bp.exec(hpId, docTypeCode, docCodes);
	}

	/**
	 * 查询费别对照
	 * @param hpId 医保id
	 * @param inccaId 票据分类id
	 * @param codeInccaItms 票据分类项目编码数组
	 * @return 对照数据
	 * @throws BizException
	 * @author ly 2018/09/13
	 */
	@Override
	public FeeCaCompInfoDTO[] findFeeCaCompInfo(String hpId, String inccaId, String[] codeInccaItms) throws BizException{
		FindFeeCaCompInfoBP bp = new FindFeeCaCompInfoBP();
		return bp.exec(hpId, inccaId, codeInccaItms);
	}

	/**
	 * 查询剂型对照
	 * @param hpId 医保id
	 * @param dosageCodes 剂型编码数组
	 * @return 对照数据
	 * @throws BizException
	 * @author ly 2018/09/13
	 */
	@Override
	public DosageCompInfoDTO[] findDosageCompInfo(String hpId, String[] dosageCodes) throws BizException {
		FindDosageCompInfoBP bp = new FindDosageCompInfoBP();
		return bp.exec(hpId, dosageCodes);
	}
	
	/**
	 * 查询诊断对照
	 * @param hpId
	 * @param diDefCodes
	 * @return
	 * @throws BizException
	 * @author liwenqing 2018.10.29
	 */
	public DiDefCompInfoDTO[] findDiDefCompInfo(String hpId,String[] diDefCodes) throws BizException{
		FindDiDefCompInfoBp bp=new FindDiDefCompInfoBp();
		return bp.exec(hpId,diDefCodes);
	}

	/**
	 * 根据编码查询医保档案数据
	 * (档案编码为空时，返回该档案类型下全部档案数据)
	 * @param hpId 医保产品id
	 * @param doclistCode 档案类型编码
	 * @param docCodes 档案编码
	 * @return
	 * @throws BizException
	 */
	public MiudidocDTO[] findMiudidocByCodes(String hpId,String doclistCode,String[] docCodes) throws BizException{
		FindMiudidocByCodesBP bp = new FindMiudidocByCodesBP();
		return bp.exec(hpId, doclistCode, docCodes);
	}

	/**
	 * 查询医保档案对照
	 * @param hpId
	 * @param doclistCode
	 * @param docCodes
	 */
	public MiUdidocCompDTO[] MiudidocCompInfo(String hpId,String doclistCode,String[] docCodes)throws BizException{
		MiudidocCompInfoBP bp=new MiudidocCompInfoBP();
		return bp.exec(hpId, doclistCode, docCodes);
	}

}
