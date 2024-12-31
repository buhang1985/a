package iih.pi.reg.s;

import iih.pi.banner.d.PatientBannerDTO;
import iih.pi.reg.d.PiPatAddressDTO;
import iih.pi.reg.dto.adminarea.d.PiAdminAreaQryCondDTO;
import iih.pi.reg.dto.adminarea.d.PiAdminAreaQryRltDTO;
import iih.pi.reg.dto.d.PatiInfoForMrDTO;
import iih.pi.reg.dto.d.PiBabyPatFuzyyQueryCondDTO;
import iih.pi.reg.dto.d.PiPatBS501CondDTO;
import iih.pi.reg.dto.d.PiPatBS520CondDTO;
import iih.pi.reg.dto.d.PiPatBasicInfoDTO;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.dto.d.PiPatRepeatDTO;
import iih.pi.reg.dto.patinfosupplement.d.PatAddDTO;
import iih.pi.reg.dto.patinfosupplement.d.PatBiloDTO;
import iih.pi.reg.dto.patinfosupplement.d.PatConDTO;
import iih.pi.reg.dto.patinfosupplement.d.PatinfoSupplementDTO;
import iih.pi.reg.dto.thirdplatform.d.PiPatThirdPlatCondDTO;
import iih.pi.reg.dto.thirdplatform.d.PiPatThirdPlatDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.s.bp.FindPatValidCardCountByPatIdBp;
import iih.pi.reg.s.bp.FindPiPatBasicInfoByPatIdsBp;
import iih.pi.reg.s.bp.GetPatAddressBP;
import iih.pi.reg.s.bp.GetPatIdBySpecialCondBP;
import iih.pi.reg.s.bp.GetPatIdForApBP;
import iih.pi.reg.s.bp.GetPatInfoForApBP;
import iih.pi.reg.s.bp.GetPatMrInfoBP;
import iih.pi.reg.s.bp.GetPatiBannerBP;
import iih.pi.reg.s.bp.GetPatiInfoByHpNoBP;
import iih.pi.reg.s.bp.GetSupplyPiPatByPatIdBP;
import iih.pi.reg.s.bp.GetThirdPlatformPatBP;
import iih.pi.reg.s.bp.PiBabyPatFuzzyQueryBP;
import iih.pi.reg.s.bp.PiFindAdminAreaBP;
import iih.pi.reg.s.bp.PiPatFuzzyQueryBP;
import iih.pi.reg.s.bp.help.GetPatiBannerFromThirdSystemBP;
import iih.pi.reg.s.ws.RepeatPatSearchBP;
import iih.pi.reg.s.ws.RichRepeatPatData;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;

/**
 * 患者查询类
 * 
 * @author ly
 *
 */
@Service(serviceInterfaces = { IPiRegQryService.class }, binding = Binding.JSONRPC)
public class PiRegQryServiceImpl implements IPiRegQryService {

	/**
	 * 通过特定条件查询患者信息
	 * 
	 * @param condType
	 *            00:自动 01:患者编码 02:就诊卡号 03:证件号码 04：床号
	 * @param condValue
	 *            条件值
	 * @return 患者主键
	 * @throws BizException
	 *             未查询到对应患者
	 */
	@Override
	public String getPatIdBySpecialCond(String condType, String condValue) throws BizException {
		GetPatIdBySpecialCondBP bp = new GetPatIdBySpecialCondBP();
		String[] result = bp.exec(condType, condValue, false);
		if (!ArrayUtil.isEmpty(result)) {
			return result[0];
		}

		return null;
	}

	/**
	 * 通过特定条件查询患者信息(模糊查询)
	 * 
	 * @param condType
	 *            00:自动 01:患者编码 02:就诊卡号 03:证件号码 04：床号
	 * @param condValue
	 *            条件值
	 * @return 患者主键
	 * @throws BizException
	 *             未查询到对应患者
	 */
	@Override
	public String[] getPatIdBySpecialCondFuzzy(String condType, String condValue) throws BizException {
		GetPatIdBySpecialCondBP bp = new GetPatIdBySpecialCondBP();
		return bp.exec(condType, condValue, true);
	}

	/**
	 * 通过特定条件查询患者信息(模糊查询)
	 * 
	 * @param condType
	 *            00:自动 01:患者编码 02:就诊卡号 03:证件号码 04：床号
	 * @param condValue
	 * @return 模糊查询sql
	 * @throws BizException
	 *             条件类型不在值范围内 code:1 未查询到对应患者 code:2
	 */
	@Override
	public String getPatIdBySpecialCondFuzzySql(String condType, String condValue) throws BizException {
		GetPatIdBySpecialCondBP bp = new GetPatIdBySpecialCondBP();
		return bp.getSql(condType, condValue, true);
	}

	/**
	 * 患者banner查询
	 * 
	 * @param sqlStr
	 *            sql(可能为空)
	 * @param whereSql
	 *            where条件
	 * @param serviceNames
	 *            额外的服务名称
	 * @param valueText
	 *            输入的值
	 * @return 患者banner信息
	 * @throws BizException
	 *             nothing
	 */
	@Override
	public PatientBannerDTO[] getPatiBanner(String sqlStr, String condWhere, String serviceNames, String valueText)
			throws BizException {
		GetPatiBannerBP bp = new GetPatiBannerBP();
		return bp.exec(sqlStr, condWhere, serviceNames, valueText);
	}

	/**
	 * 根据患者地址信息查询患者地址 补充区县名称
	 * 
	 * @param addrDto
	 *            患者地址id
	 * @return
	 * @throws DAException
	 */
	@Override
	public PiPatAddressDTO getPatAddress(String patAddrId) throws BizException {
		GetPatAddressBP bp = new GetPatAddressBP();
		return bp.exec(patAddrId);
	}

	/**
	 * 患者模糊查询
	 * 
	 * @param cond
	 *            模糊查询条件
	 * @return 患者aggdo
	 * @throws BizException
	 */
	@Override
	public PatiAggDO[] fuzzyQueryPati(PiPatFuzyyQueryCondDTO cond) throws BizException {
		PiPatFuzzyQueryBP bp = new PiPatFuzzyQueryBP();
		return bp.exec(cond);
	}

	/**
	 * 新生儿模糊查询
	 * 
	 * @param cond
	 *            模糊查询条件
	 * @return 患者aggdo
	 * @throws BizException
	 */
	@Override
	public PatiAggDO[] fuzzyQueryBabyPati(PiBabyPatFuzyyQueryCondDTO cond) throws BizException {
		PiBabyPatFuzzyQueryBP bp = new PiBabyPatFuzzyQueryBP();
		return bp.exec(cond);
	}

	/**
	 * 为病历首页取得患者信息
	 * 
	 * @param patId
	 *            患者id
	 * @return 患者信息
	 * @throws BizException
	 *             患者id不存在,患者失效
	 */
	@Override
	public PatiInfoForMrDTO getPatiInfoForMedicalRecord(String patId) throws BizException {
		GetPatMrInfoBP bp = new GetPatMrInfoBP();
		return bp.exec(patId);
	}

	/**
	 * 通过Empi BS501服务查询患者信息
	 * 
	 * @param cond
	 *            条件
	 * @return 重复的患者信息
	 * @throws BizException
	 */
	@Override
	public PiPatRepeatDTO[] searchPatByBS501(PiPatBS501CondDTO cond) throws BizException {
		RepeatPatSearchBP bp = new RepeatPatSearchBP();
		return bp.searchPatByBS501(cond);
	}

	/**
	 * 通过Empi BS520服务查询患者信息
	 * 
	 * @param cond
	 *            条件
	 * @return 重复的患者信息
	 * @throws BizException
	 */
	@Override
	public PiPatRepeatDTO[] searchPatByBS520(PiPatBS520CondDTO cond) throws BizException {
		RepeatPatSearchBP bp = new RepeatPatSearchBP();
		return bp.searchPatByBS520(cond);
	}

	/**
	 * 测试...封装查询模板取得条件部分
	 * 
	 * @param qryRootNodeDTO
	 * @param baseDO
	 * @return
	 * @throws DAException
	 */
	@Override
	public String getWherePart(QryRootNodeDTO qryRootNodeDTO, String classname) throws BizException {

		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);

		BaseDO base = null;
		try {
			Class<?> clazz = Class.forName(classname);
			base = (BaseDO) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (base == null)
			return null;

		// return "";
		return service.getQueryStringWithDesc(qryRootNodeDTO, base.getDODesc());
	}

	/**
	 * 预约挂号取患者信息接口
	 * 
	 * @param codePat
	 *            患者编码
	 * @return 患者信息
	 * @throws BizException
	 */
	@Override
	public PatiAggDO getPatInfoForAp(String codePat) throws BizException {
		GetPatInfoForApBP bp = new GetPatInfoForApBP();
		return bp.exec(codePat);
	}

	/**
	 * 预约挂号取患者id接口
	 * 
	 * @param codePat
	 *            患者编码
	 * @return
	 * @throws BizException
	 */
	public String getPatIdForAp(String codePat) throws BizException {
		GetPatIdForApBP bp = new GetPatIdForApBP();
		return bp.exec(codePat);
	}

	/**
	 * 丰富数据内容(主要是id)
	 * 
	 * @param dto
	 *            重复数据
	 * @return
	 * @throws BizException
	 */
	@Override
	public PiPatRepeatDTO richRepeatData(PiPatRepeatDTO dto) throws BizException {
		RichRepeatPatData bp = new RichRepeatPatData();
		return bp.exec(dto);
	}

	/**
	 * 获取患者基本信息
	 * 
	 * @param patIds
	 *            患者主键集合
	 * @return 患者基本信息集合
	 * @throws BizException
	 */
	@Override
	public PiPatBasicInfoDTO[] findPiPatBasicInfoByPatIds(String[] patIds) throws BizException {
		FindPiPatBasicInfoByPatIdsBp bp = new FindPiPatBasicInfoByPatIdsBp();
		PiPatBasicInfoDTO[] result = bp.exec(patIds);
		return result;
	}

	/**
	 * 根据医保号码查询患者信息
	 * 
	 * @param hpno
	 *            医保卡号
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatiAggDO findPatiInfoByHpNo(String hpno) throws BizException {
		GetPatiInfoByHpNoBP bp = new GetPatiInfoByHpNoBP();
		return bp.exec(hpno);
	}

	/**
	 * 判断是否为最后一张就诊卡，是则返回true
	 * 
	 * @param patId
	 *            患者主键
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean FindPatValidCardCountByPatId(String patId) throws BizException {
		FindPatValidCardCountByPatIdBp bp = new FindPatValidCardCountByPatIdBp();
		return bp.exec(patId);
	}
	
	/**
	 * 查询第三方平台患者信息
	 * @param cond 查询条件
	 * @return 第三方平台患者
	 * @throws BizException
	 * @author ly 2019/02/15
	 */
	@Override
	public PiPatThirdPlatDTO findThirdPlatformPat(PiPatThirdPlatCondDTO cond) throws BizException{
		GetThirdPlatformPatBP bp = new GetThirdPlatformPatBP();
		return bp.exec(cond);
	}

	/**
	 * 查询区县
	 * @param cond 查询条件
	 * @return 区县DO
	 * @throws BizException
	 * @author ly 2019/05/18
	 */
	@Override
	public PiAdminAreaQryRltDTO findAdminArea(PiAdminAreaQryCondDTO cond) throws BizException{
		PiFindAdminAreaBP bp = new PiFindAdminAreaBP();
		return bp.exec(cond);
	}
	/**
	 * 查询患者基本信息
	 * @param id
	 *            编码值
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatinfoSupplementDTO getSupplypatInfo(String id) throws BizException {
		GetSupplyPiPatByPatIdBP bp = new GetSupplyPiPatByPatIdBP();
		return bp.exec(id);
	}

	@Override
	public PatBiloDTO getPatBilo(String id) throws BizException {
		GetPatBiloBP bp = new GetPatBiloBP();
		return bp.exec(id);
	}

	@Override
	public PatAddDTO[] getPatAdd(String id) throws BizException {
		GetPatAddrBP bp = new GetPatAddrBP();
		return bp.exec(id);
	}

	@Override
	public PatConDTO[] getPatCon(String id) throws BizException {
		GetPatConByIdBP bp = new GetPatConByIdBP();
		return bp.exec(id);
	}

	@Override
	public PatientBannerDTO getPatiBannerFromThirdSystem(String valueText) throws BizException {
		//第三方患者唯一管理平台
		GetPatiBannerFromThirdSystemBP thirdBP = new GetPatiBannerFromThirdSystemBP();
		return thirdBP.exec(null, new String[]{GetPatiBannerBP.SYNC_FROM_THIRDPLATFORM}, valueText);
	}
}
