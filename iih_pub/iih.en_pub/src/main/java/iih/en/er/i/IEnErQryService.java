package iih.en.er.i;

import iih.bd.srv.dto.d.PhySignDTO;
import iih.en.er.dto.d.EnErBasic4EditDTO;
import iih.en.er.dto.d.EnErOutPatinQuirDTO;
import iih.en.er.dto.d.EnErPrQueryDTO;
import iih.en.er.dto.d.EnErPreInfoDTO;
import iih.en.er.dto.d.EnErPreTriageDTO;
import iih.en.er.dto.d.EnObsPermitDTO;
import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import iih.en.er.dto.d.UrgMrgQueryDTO;
import iih.en.er.dto.d.UrgNurRightDTO;
import iih.en.er.dto.d.UrgPatInfoDTO;
import iih.en.er.dto.d.UrgPatInfoRecDTO;
import iih.en.er.dto.d.UrgPatInfoSrvDTO;
import iih.en.er.dto.d.UrgStayOutDTO;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.er.pre.d.EnErPreScoreDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.BedQryModDTO;
import iih.en.pv.inpatient.dto.d.DepEntStateDTO;
import iih.sc.scbd.dto.d.PrtQry4EnDTO;
import iih.sc.scbd.dto.d.ScPrtTmplDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 急诊查询服务
 * 
 * @author liubin
 *
 */
public interface IEnErQryService{
	/**
	 * 获取急诊预检模板
	 * 
	 * @return
	 * @throws BizException
	 */
	PhySignDTO[] getErPreTpl() throws BizException;
	/**
	 * 获取患者预检信息
	 * 
	 * @param patId 患者id
	 * @param statusErPre 预检状态
	 * @return
	 * @throws BizException
	 */
	EnErPreTriageDTO[] getPatErPreInfos(String patId, String[] statusErPre) throws BizException;
    /**
     * 获取急诊预检评分
     * 
     * @param erpreId
     * @param scotp
     * @return
     */
    EnErPreScoreDO getEnErPreScore(String erpreId, String scotp) throws BizException;
    /**
     * 获取预检id
     * 
     * @param size
     * @return
     */
    FArrayList createPrimaryKeys(int size) throws BizException;
    /**
     * 获取患者在院抢救预检信息
     * 
     * @param patId
     * @return
     */
    EnErPreDO getErPreOfInHosEtFstaid(String patId) throws BizException;
	/**
	 * 获取急诊患者流转记录
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException 
	 */
	UrgPatInfoRecDTO[] getUrgPatInfoRec(String entId) throws BizException;
	/**
	 * 获取急诊留观许可
	 * 
	 * @return
	 * @throws BizException
	 */
	EnObsPermitDTO getObsPerInfo(String  entId) throws BizException;
    /**
	 * 获取急诊留观许可证信息
	 * 
	 * @return
	 * @throws BizException
	 */
	UrgStayRegistryDTO[] getObsScAptIpInfos(String patId) throws BizException;
    /**
	 * 获取急诊留观登记信息
	 * 
	 * @return
	 * @throws BizException
	 */
	UrgStayRegistryDTO[] getUrgStayRegInfos(String patId) throws BizException;
	/***
	 * 获取床位卡右侧信息
	 * 
	 * @param id_ent 就诊id
	 * @return
	 * @throws BizException
	 */
	 public UrgNurRightDTO getNurRightInfoByIdEnt(String id_ent) throws BizException;
	/**
	 * 获取急诊患者入出转信息
	 * 
	 * @param condition
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<UrgInOutTransMgrDTO> getUrgInOutTransMgrDtosByPageInfo(UrgMrgQueryDTO condition, PaginationInfo pageInfo) throws BizException;
	/**
	 * 获取患者入出转信息
	 * 
	 * @param condition
	 * @return
	 */
	UrgInOutTransMgrDTO[] getUrgInOutTransMgrDtos(UrgMrgQueryDTO condition) throws BizException;
	/**
	 * 获取患者入出转信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	UrgInOutTransMgrDTO getUrgInOutTransMgrDtoByEntId(String entId) throws BizException;
	/**
	 * 获取急诊抢救医生站列表数量
	 * 
	 * @return
	 * @throws BizException
	 */
	FMap getErFstaidPatCounts() throws BizException;
	/**
	 * 急诊抢救医生站banner查询
	 * 
	 * @param selectConditions
	 * @param inputValue
	 * @return
	 * @throws BizException
	 */
	UrgInOutTransMgrDTO[] getUrgInOutTransMgrDtosForFstBanner(String[] selectConditions, String inputValue) throws BizException;
	/**
	 * 获取患者本次所有有效就诊记录
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	EnErPreInfoDTO[] getEnErPreInfosByEntId(String entId) throws BizException;
	/**
	 * 获取出急诊留观信息
	 * 
	 * @return
	 * @throws BizException
	 */
	UrgStayOutDTO getUrgStayOutInfo(String  entId) throws BizException;
	/***
	* 抢救护士站床位浏览获取床位信息
	* 
	* @param qryMod
	* @return
	* @throws BizException
	*/
	BedBigCardDTO[] getRescueBedList(BedQryModDTO qryMod) throws BizException;
	/***
	 * 获取床位卡右侧信息(急诊抢救流程)
	 * 
	 * @param id_ent 就诊id
	 * @return
	 * @throws BizException
	 */
	UrgNurRightDTO getRescueRightInfoByIdEnt(String id_ent) throws BizException;
	/**
	 * 获取急诊预检相关信息
	 * 
	 * @param enErPrQueryDTO
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<EnErPrQueryDTO> getEnErPrQueryDTO(EnErPrQueryDTO enErPrQueryDTO, PaginationInfo pageInfo) throws BizException;
	/***
	 * 通过预检id获取就诊详情，fanlq-2019-06-14
	 * @param id_enpre 预检id
	 * @return
	 * @throws BizException
	 */
	EnErOutPatinQuirDTO[] getErPreEntByIdErPre(String id_enpre) throws BizException;
	/**
	 * 获取急诊病人基本信息
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException 
	 * @date 2018年12月27日
	 */
	EnErBasic4EditDTO getEnErBasic4edit(String entId) throws BizException;
	/***
	 * 通过预检id获取预检信息，fanlq-2019-07-25
	 * @param id_erpre 预检id
	 * @return
	 * @throws BizException
	 */
	EnErBasic4EditDTO getEnErBasicInfo(String id_erpre) throws BizException;	
	/**
	 * 获取急诊患者信息概况
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException 
	 */
	UrgPatInfoDTO getUrgPatInfo(String entId) throws BizException;
	/**
	 * 获取生命体征
	 * @return
	 * @throws BizException 
	 */
	UrgPatInfoSrvDTO getVitalSignInfo(String id_ent) throws BizException;
	/**
	 * 获取病人相关信息
	 * @param codepatca 证件号
	 * @param codepat 患者编码
	 * @param namepat 患者姓名
	 * @param namebed 床位号
	 * @param obspre 预检号
	 * @return
	 */
	PagingRtnData<EnErOutPatinQuirDTO> getEnErOutPatinQuirDtos(EnErOutPatinQuirDTO enErOutPatinQuir, PaginationInfo pageInfo) throws BizException;
	/**
	 * 获取急诊抢救科室就诊状况统计信息
	 * 
	 * @param qryMod
	 * @return
	 * @throws BizException
	 */
	DepEntStateDTO[] getDepRescueEntStateStats(BedQryModDTO qryMod) throws BizException;
	/**
	 * 根据打印模板项目配置信息查询 打印模板
	 * @author lilei
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	ScPrtTmplDTO getRescuePrtTmplDTO(PrtQry4EnDTO qryDTO) throws BizException;
}
