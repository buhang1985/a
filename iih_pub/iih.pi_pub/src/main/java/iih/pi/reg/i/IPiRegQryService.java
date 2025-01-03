package iih.pi.reg.i;

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
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;

/**
 * 患者查询服务
 * 
 * @author ly
 */
public interface IPiRegQryService {

	/**
	 * 通过特定条件查询患者信息
	 * 
	 * @param condType
	 *            00:自动 01:患者编码 02:就诊卡号 03:证件号码 04：床号
	 * @param condValue
	 * @return 患者主键
	 * @throws BizException
	 *             条件类型不在值范围内 code:1 未查询到对应患者 code:2
	 */
	public abstract String getPatIdBySpecialCond(String condType, String condValue) throws BizException;

	/**
	 * 通过特定条件查询患者信息(模糊查询)
	 * 
	 * @param condType
	 *            00:自动 01:患者编码 02:就诊卡号 03:证件号码 04：床号
	 * @param condValue
	 * @return 患者主键
	 * @throws BizException
	 *             条件类型不在值范围内 code:1 未查询到对应患者 code:2
	 */
	public abstract String[] getPatIdBySpecialCondFuzzy(String condType, String condValue) throws BizException;

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
	public abstract String getPatIdBySpecialCondFuzzySql(String condType, String condValue) throws BizException;

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
	public abstract PatientBannerDTO[] getPatiBanner(String sqlStr, String condWhere, String serviceNames,
			String valueText) throws BizException;

	/**
	 * 根据患者地址信息查询患者地址 补充区县名称
	 * 
	 * @param patAddrId
	 *            患者地址id
	 * @return
	 * @throws BizException
	 *             患者地址数据不存在
	 */
	public abstract PiPatAddressDTO getPatAddress(String patAddrId) throws BizException;

	/**
	 * 患者模糊查询
	 * 
	 * @param cond
	 *            模糊查询条件
	 * @return 患者aggdo
	 * @throws BizException
	 */
	public abstract PatiAggDO[] fuzzyQueryPati(PiPatFuzyyQueryCondDTO cond) throws BizException;

	/**
	 * 新生儿模糊查询
	 * 
	 * @param cond
	 *            模糊查询条件
	 * @return 患者aggdo
	 * @throws BizException
	 */
	public abstract PatiAggDO[] fuzzyQueryBabyPati(PiBabyPatFuzyyQueryCondDTO cond) throws BizException;

	/**
	 * 为病历首页取得患者信息
	 * 
	 * @param patId
	 *            患者id
	 * @return 患者信息
	 * @throws BizException
	 *             患者id不存在,患者失效
	 */
	public abstract PatiInfoForMrDTO getPatiInfoForMedicalRecord(String patId) throws BizException;

	/**
	 * 通过Empi BS501服务查询患者信息
	 * 
	 * @param cond
	 *            条件
	 * @return 重复的患者信息
	 * @throws BizException
	 */
	public abstract PiPatRepeatDTO[] searchPatByBS501(PiPatBS501CondDTO cond) throws BizException;

	/**
	 * 通过Empi BS520服务查询患者信息
	 * 
	 * @param cond
	 *            条件
	 * @return 重复的患者信息
	 * @throws BizException
	 */
	public abstract PiPatRepeatDTO[] searchPatByBS520(PiPatBS520CondDTO cond) throws BizException;

	/**
	 * 测试...封装查询模板取得条件部分
	 * 
	 * @param qryRootNodeDTO
	 * @param baseDO
	 * @return
	 * @throws DAException
	 */
	public abstract String getWherePart(QryRootNodeDTO qryRootNodeDTO, String classname) throws BizException;

	/**
	 * 预约挂号取患者信息接口
	 * 
	 * @param codePat
	 *            患者编码
	 * @return 患者信息
	 * @throws BizException
	 */
	public abstract PatiAggDO getPatInfoForAp(String codePat) throws BizException;

	/**
	 * 预约挂号取患者id信息接口
	 * 
	 * @param codePat
	 *            患者编码
	 * @return
	 * @throws BizException
	 */
	public abstract String getPatIdForAp(String codePat) throws BizException;

	/**
	 * 丰富数据内容(主要是id)
	 * 
	 * @param dto
	 *            重复数据
	 * @return
	 * @throws BizException
	 */
	public abstract PiPatRepeatDTO richRepeatData(PiPatRepeatDTO dto) throws BizException;

	/**
	 * 获取患者基本信息
	 * 
	 * @param patIds
	 *            患者主键集合
	 * @return 患者基本信息集合
	 * @throws BizException
	 */
	public abstract PiPatBasicInfoDTO[] findPiPatBasicInfoByPatIds(String[] patIds) throws BizException;

	/**
	 * 根据医保号码查询患者信息
	 * 
	 * @param hpno
	 *            医保卡号
	 * @return
	 * @throws BizException
	 */
	public abstract PatiAggDO findPatiInfoByHpNo(String hpno) throws BizException;

	/**
	 * 判断是否为最后一张就诊卡，是则返回true
	 * 
	 * @param patId
	 *            患者主键
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean FindPatValidCardCountByPatId(String patId) throws BizException;
	
	/**
	 * 查询第三方平台患者信息
	 * @param cond 查询条件
	 * @return 第三方平台患者
	 * @throws BizException
	 * @author ly 2019/02/15
	 */
	public abstract PiPatThirdPlatDTO findThirdPlatformPat(PiPatThirdPlatCondDTO cond) throws BizException;

	/**
	 * 查询区县
	 * @param cond 查询条件
	 * @return 区县DO
	 * @throws BizException
	 * @author ly 2019/05/18
	 */
	public abstract PiAdminAreaQryRltDTO findAdminArea(PiAdminAreaQryCondDTO cond) throws BizException;
	/**
	 * 查询患者基本信息
	 * @param id
	 *            患者主键
	 * @return
	 * @throws BizException
	 */
	public PatinfoSupplementDTO getSupplypatInfo(String id) throws BizException;
	
	/**
	 * 
	 * 查询患者生化信息
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public PatBiloDTO getPatBilo(String id) throws BizException;
	
	/**
	 * 
	 * 查询患者地址信息
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public PatAddDTO[] getPatAdd(String id) throws BizException;
	
	/**
	 * 
	 * 查询联系人信息
	 * @param id
	 * @return
	 * @throws BiException
	 */
	public PatConDTO[] getPatCon(String id) throws BizException;
	
	/**
	 * 从第三方患者唯一管理平台同步患者信息
	 * @author lilei
	 * @date 2020年7月15日
	 */
	public PatientBannerDTO getPatiBannerFromThirdSystem(String valueText) throws BizException;
}
