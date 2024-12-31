package iih.en.pv.i;

import java.lang.reflect.InvocationTargetException;

import iih.en.pv.custom.d.EnHpPatCaInParamsDTO;
import iih.en.pv.dto.d.DeptCountInfoDTO;
import iih.en.pv.dto.d.DischargeDTO;
import iih.en.pv.dto.d.EnAuthListDTO;
import iih.en.pv.dto.d.EnAuthQryDTO;
import iih.en.pv.dto.d.EnDepDTO;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.dto.d.EntInfo4RentDTO;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.dto.d.HosRecallDTO;
import iih.en.pv.dto.d.HosRecallQryDTO;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.dto.d.IpInfoDTO;
import iih.en.pv.dto.d.LvHosAppDTO;
import iih.en.pv.dto.d.MainStateDTO;
import iih.en.pv.dto.d.MsgInfoCardDTO;
import iih.en.pv.dto.d.OutpatientQryDTO;
import iih.en.pv.dto.d.PativisitensonDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.enfee.d.EnFixedFeeItemDO;
import iih.en.pv.enfee.d.EntAccActDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.enfee.dto.d.EnAccDTO;
import iih.en.pv.enfee.dto.d.PatiFixedFeeLeftDTO;
import iih.en.pv.enres.d.EnBedDO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.hpdto.d.IpHpRegistDTO;
import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.d.EnPeCmpyItmDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.BedCardDetailDTO;
import iih.en.pv.inpatient.dto.d.BedQryModDTO;
import iih.en.pv.inpatient.dto.d.DepEntStateDTO;
import iih.en.pv.inpatient.dto.d.EnHosDTO;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.inpatient.dto.d.EnIppreTransHosDTO;
import iih.en.pv.inpatient.dto.d.EnPeCmpyDTO;
import iih.en.pv.inpatient.dto.d.EnPePatInfoDTO;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.inpatient.dto.d.IpRegQrySchmDTO;
import iih.en.pv.inpatient.dto.d.IppreQryConditionsDTO;
import iih.en.pv.inpatient.dto.d.NewbornDTO;
import iih.en.pv.shiftturnover.d.ShiftturnoverAggDO;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.BedQrySchmDTO;
import iih.sc.scbd.dto.d.PrtQry4EnDTO;
import iih.sc.scbd.dto.d.ScPrtTmplDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 住院查询服务
 * @author yank
 * @author renying
 * @author liubin
 *
 */
public interface IEnIpQryService {
	/**
	 * 获取banner信息
	 * 
	 * @param sqlStr 查询语句
	 * @param whereStr 查询条件
	 * @param svName 服务名称，多个逗号隔开
	 * @return
	 * @throws BizException
	 */
	Ent4BannerDTO[] getEntInfo4Banner(String sqlStr, String whereStr, String svName)
			throws BizException;

	/***
	 * 通过床位id查询床位费用
	 * @param bedId
	 * @return
	 * @throws BizException
	 */
	BedQrySchmDTO getPricByBedId(String bedId) throws BizException;
	
	/**
	 * 查询入院通知单
	 * @param entId 就诊id 
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	AptIpDTO[] getIpntByEntId(String patId,String entId) throws BizException;
	/**
	 * 根据患者id加载入院登记信息
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	EnHosRegDTO[] getHosRegInfo(String patId) throws BizException;
	/**
	 * 根据就诊id加载入院登记信息
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	EnHosRegDTO getHosRegInfoByEntId(String entId, FBoolean fg_st)throws BizException;
	/**
	 * 入院登记(含注册)患者信息查询
	 * @param cond 模糊查询条件
	 * @return EnHosPatDTO 
	 * @throws BizException
	 */
	EnHosPatDTO getPatInfo(PiPatFuzyyQueryCondDTO cond, String entId, FBoolean isChild, FBoolean fgBb) throws BizException;
	/**
	 * 入院登记(含注册)(新)信息查询
	 * @param cond 模糊查询条件
	 * @return EnHosPatDTO 
	 * @throws BizException
	 */
	EnHosDTO[] getEnHosInfo(PiPatFuzyyQueryCondDTO cond,FBoolean fgBb) throws BizException;
	/**
	 * 获取患者信息
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	EnHosPatDTO getEnHosPatInfo(String patId) throws BizException;

	/**
	 * 根据病区获取病区申请入科列表
	 * @param nurId 当前登录病区
	 * @throws BizException
	 */
	EnDepDTO[] getEnDepList(String nurId) throws BizException;
	/**
	 * 获取待入科病人总数
	 * @param nurId 病区id
	 * @return
	 * @throws BizException
	 */
	Integer getWillEnDepCount(String nurId) throws BizException;
	/**
	 * 获取病区或科室统计信息
	 * @param deptId 病区或科室id
	 * @return
	 * @throws BizException
	 */
	DeptCountInfoDTO getDepStatsInfo(String depId) throws BizException;
	/**
	 * 获取科室就诊状况统计信息
	 * @param depId 病区或科室ID
	 * @return
	 * @throws BizException
	 */
	DepEntStateDTO[] getDepEntStateStats(String depId) throws BizException;
	/**
	 * 获取患者主要就诊状况
	 * （包含病情、护理、营养）
	 * @param entId 就诊ID
	 * @return 主要就诊状况DTO
	 * @throws BizException
	 * @author renying
	 */
	MainStateDTO getMainEntState(String entId) throws BizException;
    /**
     * 获取医护人员
     * @param entId 就诊id
     * @throws BizException
     */
	PativisitensonDTO getMedPsn(String entId) throws BizException;
	/**
	 * 获取住院信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	IpInfoDTO getIpInfo(String entId) throws BizException;
	/**
	 * 获取就诊账户信息
	 * @param entId 就诊id
	 * @return 余额DTO
	 * @throws BizException
	 */
	BalanceDTO getBalanceDTO(String entId) throws BizException;
	/**
	 * 获取就诊账户信息
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	EnAccDTO getEnAcc(String entId) throws BizException;
	 /**
     * 规则引擎：入院登记患者信息规则
     * @author fanlq
     * @param id_pat
     * @return
     */
    ResultDTO ipPatRuleValidate(String id_pat) throws BizException;
    /**
     * 规则引擎：入院登记规则
     * @author zhangpp
     * @param id_pat
     * @return
     * @throws BizException
     */
    ResultDTO validateIpRule(EnHosPatDTO enHosPat, EnHosRegDTO EnHostReg) throws BizException;
    /**
     * 校验合并患者能否入院登记
     * @author zhangpp
     * @param idPat
     * @return
     * @throws BizException
     */
    ResultDTO validateCombine(String idPat) throws BizException;
	/**
	 * 获取可申请转科的病人列表
	 * @param nurId 病区id
	 * @return
	 * @throws BizException 
	 */
	TransDepPatDTO[] getCanTransOutPats(String nurId) throws BizException;
	/**
	 * 转科核查
	 * 
	 * @param transDepPats
	 * @return
	 * @throws BizException
	 */
	TransDepPatDTO[] transOutDepCheck(TransDepPatDTO[] transDepPats) throws BizException;
	/**
	 * 获取转科核查明细
	 * 
	 * @param transDepPat 转科记录
	 * @param enLvDepCheckTps 核查类型：EnLvDepCheckTpEnum
	 * @return
	 */
	FMap getTrausOutCheckDetails(TransDepPatDTO transDepPat, String[] enLvDepCheckTps) throws BizException;
	/**
	 * 获取无转科医嘱患者的转科记录
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	TransDepPatDTO[] getNoOrTransPatsByEnt(String entId) throws BizException;
	/**
	 * 获取可申请转科的病人列表(未校验)
	 * @param nurId
	 * @return
	 * @throws BizException
	 */
	TransDepPatDTO[] getCanTransOutPatsNoCheck(String nurId) throws BizException;
	/**
	 * 获取已转出未转入患者列表（撤销转出）
	 * 
	 * @param idNur
	 * @return
	 * @throws DAException
	 */
	TransDepPatDTO[] getTransOutFinishPats(String idNur) throws BizException;
	/**
	 * 获取已申请转科的病人列表
	 * @param nurId 病区id
	 * @return
	 * @throws BizException 
	 */
	TransDepPatDTO[] getAppliedTransPats(String nurId) throws BizException;
	/**
	 * 获取申请转科转入的患者列表
	 * @param nurId 病区id
	 * @return
	 * @throws BizException 
	 */
	TransDepPatDTO[] getTransDepAppPats(String nurId) throws BizException;
	/**
	 * 获取入科信息
	 * @param entId 就诊id
	 * @return EnDepDTO 入科信息DTO
	 * @throws BizException
	 */
	EnDepDTO getEnDepInfo(String entId) throws BizException;
	/**
	 * 获取转科人员诊断
	 * @param id_ent 就诊id
	 * @return EntDiDO   
	 * @throws BizException
	 */
    EntDiDO getTransDepDi(String entId) throws BizException;    
	/**
	 * 获取转科转出病人总数
	 * @param nurId 病区id
	 * @return
	 * @throws BizException
	 */
	Integer getTransOutCount(String nurId) throws BizException;
	/**
	 * 获取转科转入病人总数
	 * @param nurId 病区id
	 * @return
	 * @throws BizException
	 */
	Integer getTransInCount(String nurId) throws BizException;	
	/**
	 * 获取出院申请列表
	 * @param nurId 病区id
	 * @return
	 * @throws BizException
	 */
	LvHosAppDTO[] getLvHosApps(String nurId) throws BizException;
	/***
	 * 住院处出院 - 获取出院申请列表
	 * @author fanlq 2017年12月21日
	 * @param recallQryDTO 查询方案
	 * @return
	 * @throws BizException
	 */
	LvHosAppDTO[] getLvHosAppsByQryDTO(HosRecallQryDTO recallQryDTO) throws BizException;
    /**
     * 出院核查
     * 
     * @param lvAppsDtos 出院记录
     * @return
     */
    LvHosAppDTO[] lvHosCheck(LvHosAppDTO[] lvAppsDtos) throws BizException;
    /**
     * 获取出院核查明细
     * 
     * @param lvAppsDto 出院记录
     * @param enLvDepCheckTps 核查类型：EnLvDepCheckTpEnum
     * @return
     */
    FMap getLvHosCheckDetails(LvHosAppDTO lvAppsDto, String[] enLvDepCheckTps) throws BizException;
    /**
     * 通过IdEnts获得出院LvHosAppDTO
     * @author lilei
     * @date 2019年12月24日
     */
    LvHosAppDTO[] getLvHosAppAllEnt(String[] idEnts) throws BizException;
	/**
	 * 获取待出院病人总数
	 * @param nurId 病区id
	 * @return
	 * @throws BizException
	 */
	Integer getLvHosAppCount(String nurId) throws BizException;
	/**
	 * 查询出院记录
	 * @param start 开始日期
	 * @param end 结束日期
	 * @param entCode 住院号
	 * @param name 姓名
	 * @return
	 */
	HosRecallDTO[] getLeaveHosDTOs(QryRootNodeDTO querySchema) throws BizException;
	/**
	 * 出院召回（分页查询）-zhangpp 2018.12.6
	 * @param querySchema
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<HosRecallDTO> getPageLeaveHosDTOs(QryRootNodeDTO querySchema, PaginationInfo pageInfo) throws BizException;
	/***
	 * 住院处出召回-通过出院召回DTO查询出院记录
	 * @author fanlq 2017年12月19日
	 * @param recallQryDTO
	 * @return
	 * @throws BizException
	 */
	HosRecallDTO[] getLeaveHosDTOByQryDTOs(HosRecallQryDTO recallQryDTO) throws BizException;
	/**
	 * 获取可退院列表
	 * @param patId 患者id
	 * @throws BizException 异常
	 * @return
	 */
	DischargeDTO[] getDischarge(String patId) throws BizException;
	
	/**
	 * 获取病区的护士id集合
	 * @param depId 病区id
	 * @return
	 * @throws BizException
	 */
	String[] getNurseIds(String depId) throws BizException;
	/**
	 * 根据业务线，查询病区的科室集合
	 * 业务线暂时没有，临时放在这里，后续迁移
	 * @param depId 科室或病区id
	 * @return
	 * @throws BizException
	 */
	DeptDO[] getDepListByDepl(String depId,String deplrole) throws BizException;
	/**
	 * 查询床位列表
	 * @param qryMod 查询模板
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	BedBigCardDTO[] getBedList(BedQryModDTO qryMod) throws BizException;
	/**
	 * 获取床位卡详细信息
	 * @param entId 就诊ID
	 * @return 床位卡详细信息
	 * @throws BizException
	 * @author renying
	 */
	BedCardDetailDTO getBedCardDetail(String entId, String idBltpl) throws BizException;
	/**
	 * 获取包床的就诊信息
	 * @param entId 就诊ID
	 * @return 包床信息DTO
	 * @throws BizException
	 */
	EntInfo4RentDTO getEntInfo4Rent(String entId) throws BizException;
	/**
	 * 获取包床列表
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	EnBedDO[] getRentedBedList(String entId) throws BizException;
	/**
	 * 获取床位使用记录
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	EnBedDO[] getUsedBedList(String entId) throws BizException;		
	/**
	 * 我的患者集合
	 * 
	 * @param depId 科室ID
	 * @param empId 医生ID
	 * @return
	 * @throws BizException
	 */
	FMap getIpPatients(FMap map)throws BizException;
	/**
	 * 住院查询--获取住院信息集合（不分页）
	 * @param qryModDTO
	 * @return
	 * @throws BizException
	 */
	OutpatientQryDTO[] getIpList(EntQryModDTO qryModDTO) throws BizException;
	/***
	 * 住院就诊查询-获取住院信息集合-（分页）-fanlq-2018-10-30
	 * @param qryModDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<OutpatientQryDTO> getIpListPage(EntQryModDTO qryModDTO, PaginationInfo pg) throws BizException;
	/**
	 * 获取就诊患者所属类别
	 * @param entId 就诊id
	 * @param depId 科室id
	 * @param empId 医生id
	 * @return 返回枚举值EntPatListTp
	 * @throws BizException
	 */
	String getEntPatTp(String entId,String depId,String empId) throws BizException;
	/**
	 * 获取账户操作明细
	 * @param qryRootNodeDTO 查询方案
	 * @param pg 分页信息
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<EntAccActDO> getEntAccActByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, PaginationInfo pg) throws BizException;
	/**
	 * 获取护士管理的住院患者信息
	 * @param wardId 病区ID
	 * @param nursId 护士ID
	 * @return 住院基本信息
	 * @throws BizException
	 * @author zhengcm
	 */
	IpBasicDTO[] getIpListByNurs(String wardId,String nursId) throws BizException;
	/**
	 * 获取病区住院患者信息
	 * @param wardId 病区ID
	 * @return 住院基本信息
	 * @throws BizException
	 * @author zhengcm
	 */
	IpBasicDTO[] getIpListByWard(String wardId) throws BizException;
	/**
	 * 获取病区科室的住院患者信息
	 * @param wardId 病区ID
	 * @param depId 科室ID
	 * @return 住院基本信息
	 * @throws BizException
	 * @author zhengcm
	 */
	IpBasicDTO[] getIpListByDep(String wardId,String depId) throws BizException;
	/**
	 * 获取病区新入院患者信息
	 * @param wardId 病区ID
	 * @return 住院基本信息
	 * @throws BizException
	 * @author zhengcm
	 */
	IpBasicDTO[] getNewIpList(String wardId) throws BizException;

	/**
	 * 获取患者的新生儿记录
	 * @param momEntId  母亲就诊ID
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	NewbornDTO[] getNbListByMomEnt(String momEntId) throws BizException;	
	/**
	 * 患者是否在院
	 * @param patId 患者ID
	 * @return FBoolean类型
	 * @throws BizException
	 * @author renying
	 */
	FBoolean isPatInHos(String patId) throws BizException;
	
	/**
	 * 根据病区id 查询该病区内所有患者得收费模式信息
	 * 收费模式 sd_dcg_mode=0表示继承科室模式 sdsd_dcg_mode=1表示患者专有模式
	 * @param wardId 患者所在病区id
	 * @return PatiFixedFeeLeftDTO类型
	 * @throws BizException
	 * @author liwq
	 */
	PatiFixedFeeLeftDTO[] getPatiFixedFeeModeInfo(String wardId,String dicKey,String keyValue) throws BizException;
	
	/**
	 * 根据患者就诊Id 和收费模式  查询固定费用信息
	 * 收费模式 sd_dcg_mode=0表示继承科室模式 sdsd_dcg_mode=1表示患者专有模式
	 * @param idEnt 患者就诊id  isMode 收费模式
	 * @return PatiFixedFeeRightDTO类型
	 * @throws BizException
	 * @author liwq
	 */
	EnFixedFeeItemDO[] getFixedFeeInfo(String idEnt, FBoolean isMode,String idDepNur) throws BizException;
	
	/**
	 * 根据患者就诊id  将科室固定费用改为患者固定费用模式
	 * @param idEnt
	 * @return FBoolean
	 * @author liwq
	 * @throws BizException
	 */
	String changedPatiFixedFee(String idEnt,String idDepNur) throws BizException;
	
	/**
	 * 根据患者就诊id  将科室固定费用改为患者固定费用模式
	 * @param idEnt
	 * @return FBoolean
	 * @author liwq
	 * @throws BizException
	 */
	String changedDepFixedFee(String idEnt) throws BizException;
	
	/**
	 * 根据服务id_srv 判断是否是物品
	 * @param id_srv
	 * @return FBoolean
	 * @author liwq
	 * @throws BizException
	 */
	FBoolean isSrvOrMm(String id_srv) throws BizException;
	
	/**
	 * 返回服务id和单位名称
	 * @param 
	 * @return EnFixedFeeItemDO[]
	 * @author liwq
	 * @throws BizException
	 */
	EnFixedFeeItemDO[] returnSrvUnitMap() throws BizException; 
	/**
	 * 是否是产科
	 * 根据产科业务线判定
	 * @param deptId 科室ID
	 * @return 
	 * @throws BizException
	 */
	FBoolean isObsDept(String deptId) throws BizException;
	/**
	 * 获取匹配的新生儿记录
	 * @param birthDate 出生日期
	 * @param sd_sex 性别
	 * @param momName 母亲姓名
	 * @return
	 * @throws BizException
	 */
	PatiAggDO[] getMatchNb(FDate birthDate,String sd_sex,String momName) throws BizException;
	/**
	 * 查询住院登记信息
	 * @param qrySchm 查询模板
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	PagingRtnData<IpRegInfoDTO> getIpRegList(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo) throws BizException;
	/**
	 * 查询住院出院信息列表信息
	 * @param qrySchm 查询模板
	 * @return
	 * @throws BizException
	 * @author li.wm
	 */
	PagingRtnData<IpRegInfoDTO> getIpLeaveList(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo) throws BizException;
	/**
	 * 查询住院出科列表信息信息
	 * @param qrySchm 查询模板
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	PagingRtnData<IpRegInfoDTO> getIpOutDeptList(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo) throws BizException;
	/**
	 * 住院诊断查询  zhangpp-2018-11-24
	 * @param qrySchm 查询模板
	 * @param pageInfo 分页信息
	 * @return 患者信息列表
	 * @throws BizException
	 */
	PagingRtnData<IpRegInfoDTO> getIpDiQryList(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo) throws BizException;	
	/**
	 * 保存登记前的验证
	 * @param patDTO
	 * @param enHosRegDTO
	 * @param isReg 是否含患者注册功能
	 * @throws BizException
	 */
    void validateHosInfo(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO,FBoolean isReg)throws BizException;
	/**
	 * 取消登记前前校验
	 * @param dischargeDTO
	 * @throws BizException
	 */
	void validateCanRegInfo(EnHosRegDTO enHosRegDTO)throws BizException;
	/**
	 * 退院前校验
	 * @param dischargeDTO
	 */
    void validateDischargeInfo(DischargeDTO dischargeDTO)throws BizException;
    /**
     * 创建新的交班记录
     * 
     * @param depId 科室id
     * @param date 日期
     * @param enumdayslot 白班/夜班
     * @return
     * @throws BizException
     */
    ShiftturnoverAggDO createNewTurnOverInfo(String depId, FDate date, String enumdayslot)throws BizException;
    /**
     * 获取患者住院登记医保信息
     * （医保转换）使用
     * @param entId
     * @return
     * @throws BizException
     */
    IpHpRegistDTO getIpHpRegist(String entId) throws BizException;
    /**
     * 获取患者住院登记医保信息--通过患者id
     * （医保转换异常处理）使用
     * @param patId
     * @return
     * @throws BizException
     */
	IpHpRegistDTO getIpHpRegistByPat(String patId) throws BizException;

	 /**
     * 查询团检单位信息
     * @param qryDTO
     * @return
     * @throws BizException
     */
    EnPeCmpyDTO[] getEnPeCmpyInfo(EnPeCmpyDTO qryDTO)throws BizException;
    
    /**
     * 查询团检单位信息 分页
     * @param qryDto
     * @param pageInfo
     * @return
     * @throws BizException
     */
    PagingRtnData<EnPeCmpyDTO> getEnPeCmpyPageInfo(EnPeCmpyDTO qryDto,PaginationInfo pageInfo) throws BizException;
    
    /**
     * 查询团检单位患者信息
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    EnPePatInfoDTO[] getEnPePatInfos(String pecmpyId)throws BizException;
    
    /**
     * 查询团检单位患者信息 分页
     * @param pecmyId
     * @param pageInfo
     * @return
     * @throws BizException
     */
    PagingRtnData<EnPePatInfoDTO> getEnPePatPageInfo(String pecmyId,PaginationInfo pageInfo) throws BizException;
    
    /**
     * 获取就诊记录
     * @return
     */
    EnPeCmpyItmDO[] getEnPeCmpyItmDOS(String Idpecmpy)throws BizException;
    
    /**
     * 未关联团检记录有团检标识的患者
     * 获取就诊记录
     * @param qryDTO
     * @return
     * @throws BizException
     */
    IpBasicDTO[] getIpBasicDTOs(EnPeCmpyDTO qryDTO) throws BizException;
    
    /**
     * 获取住院基本信息
     * 根据团检id查询 团检关联患者
     * @param idpecmpy 团检单位id
     * @return
     * @throws BizException
     */
    IpBasicDTO[] getIpBasicInfos(String idpecmpy) throws BizException;
    
    /**
     * 查询未关联单位患者信息
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    EnPePatInfoDTO[] getNoCmpyPatInfos(String pecmpyId)throws BizException;
    
    /**
     * 根据查询卡条件 
     * 查询出院患者信息
     * @return
     * @throws BizException
     */
    PagingRtnData<IpRegInfoDTO> getIpRegInfos(IpRegInfoDTO qryDto,PaginationInfo pageInfo)throws BizException;
	
    /**
     * 患者授权查询
     * @param qryDto
     * @param pageInfo
     * @return
     * @throws BizException
     */
    PagingRtnData<EnAuthListDTO> getEnAuthList(EnAuthQryDTO qryDto,PaginationInfo pageInfo)throws BizException;
    
    /**
     * 根据人员id查询人员
     * @param id_psndoc
     * @throws BizException
     */
    PsnDocDO getPsnById(String id_psndoc) throws BizException;
    
    /**
     * 根据患者id获取患者真实头像-zhangpp 2019..7.25
     * @param patId
     * @throws BizException
     */
    PatDO getImageByPatId(String patId) throws BizException;
    
    /**
     * 查打印腕带的方式
     * @return
     * @throws BizException
     */
    String getPrintWristCardType(String idEnt, String funCode) throws BizException;
    /**
	 * @Description: 获得护士站下的快捷入口的卡信息
	 * @param nurId
	*/
	public MsgInfoCardDTO[] getMsgInfoCardDTOs(String nurId, String code_entp) throws BizException;
    
    /**
	 * 根据医保获取医疗付费方式
	 * 
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
    UdidocDO getPayMethodByHp(EnHpPatCaInParamsDTO inParam) throws BizException;
  
    /**
	 * 根据打印模板项目配置信息查询 打印模板
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
    ScPrtTmplDTO getScPrtTmplDTO(PrtQry4EnDTO qryDTO) throws BizException;
    
    /**
     * 查询预住院在院患者信息
     * @param str
     * @return
     * @throws BizException
     */
    EnIppreInfoDTO[] getIppreConterList(String str) throws BizException;

    /**
     * 查询预住院转住院患者信息
     * @param entId
     * @return
     * @throws BizException
     */
    EnIppreTransHosDTO getIppreTransHos(String entId) throws BizException;
    
    /**
	 * 根据 预住院状态 查询入院患者列表
	 * @author li.wm
	 * @param sd_status
	 * @throws BizException
	 */
    EnIppreInfoDTO[] getAcceptEnippreList(EnIppreDO enippre) throws BizException;
    
    /**
     * 查询出院患者列表
     * @param id_dep
     * @return
     * @throws BizException
     */
    PagingRtnData<EnIppreInfoDTO> getIpLvHos(String id_dep, PaginationInfo pageInfo) throws BizException;
    /**
     * 查询预住院入院登记患者信息
     * @param entId
     * @return
     * @throws BizException
     */
    PagingRtnData<EnIppreInfoDTO>  getIpPrePatList(String id_dep, PaginationInfo pageInfo) throws BizException;
	/**
     * 查询入科患者列表
     * @param id_dep
     * @return
     * @throws BizException
     */

	PagingRtnData<EnIppreInfoDTO> getIpPreDepEnter(String id_dep, PaginationInfo pageInfo) throws BizException;
	 /**
     * 查询中止住院患者信息
     * @param entId
     * @return
     * @throws BizException
     */
    PagingRtnData<EnIppreInfoDTO>  getSuspendHosPatList(String id_dep, PaginationInfo pageInfo) throws BizException;
    /**
     * 查询患者中止住院患者信息
     * @param entId
     * @return
     * @throws BizException
     */
	EnIppreInfoDTO[] getIpprePatSuspendHosCheckInfo(EnIppreInfoDTO[] ippreDtos) throws BizException;
	/**
     * 查询预住院患者信息(总入口)
     * @param entId
     * @return
     * @throws BizException
     */
	PagingRtnData<EnIppreInfoDTO>  getIpprePatInfoList(FMap map,PaginationInfo pageInfo) throws BizException;
	/**
	 * 根据病区获取预住院病区申请入科列表 
	 * 
	 * @param nurId
	 *            当前登录病区
	 * @return EnDepDTO[] 当前病区待入科的患者列表
	 * @throws BizException
	 */
	public EnDepDTO[] getIppreEnDepList(String nurId,String id_ent) throws BizException ;
	
	
	/**
	 * 查询预住院转住院检查信息
	 */
	public EnIppreInfoDTO getIppreTransHosCheck(EnIppreInfoDTO ippreInfoDto) throws BizException ;
	/**
	 * 预住院查询节点查询患者信息
	 */
	PagingRtnData<EnIppreInfoDTO>  ippreQryPatInfo(IppreQryConditionsDTO qrydto,PaginationInfo pageInfo) throws BizException;
	/**
	 * 校验是否有费用转到门诊
	 * @param idEnt
	 * @param isOep
	 * @return
	 * @throws BizException
	 */
	FBoolean isPreIpTrans(String idEnt, FBoolean isOep) throws BizException;
}
