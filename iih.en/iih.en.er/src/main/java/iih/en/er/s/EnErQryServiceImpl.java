package iih.en.er.s;

import iih.bd.srv.dto.d.PhySignDTO;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCodeUtils;
import iih.en.er.bp.baspat.GetEnErBasic4editBP;
import iih.en.er.bp.enprquery.GetEnErBasicInfoBP;
import iih.en.er.bp.enprquery.GetEnErPrQuery;
import iih.en.er.bp.erfstaiddocstation.GetErFstaidPatCountsBP;
import iih.en.er.bp.erfstaiddocstation.GetUrgInOutTransMgrDtosForFstBannerBP;
import iih.en.er.bp.inouttransmgr.GetInOutTransMgrBaseBP;
import iih.en.er.bp.inouttransmgr.IGetInOutTransMgr;
import iih.en.er.bp.nurstation.GetNurRightInfoByIdEntBP;
import iih.en.er.bp.oupati.GetEnErOutPatinQuirlnfoBP;
import iih.en.er.bp.patinfo.GetUrgPatInfoBP;
import iih.en.er.bp.patinfo.GetUrgPatRecInfoBP;
import iih.en.er.bp.patinfo.GetUrgVitalSignBP;
import iih.en.er.bp.pre.GetErPreOfInHosEtFstaidBP;
import iih.en.er.bp.pre.GetErPreScoreBP;
import iih.en.er.bp.pre.GetErPreTplBP;
import iih.en.er.bp.pre.GetPatErPreInfosBP;
import iih.en.er.bp.qry.GetEnErPreInfosByEntIdBP;
import iih.en.er.bp.qry.GetErPreEntByIdErPreBP;
import iih.en.er.bp.rescue.GetRescueRightInfoByIdEntBP;
import iih.en.er.bp.rescue.qry.GetDepRescueEntStateStatsBP;
import iih.en.er.bp.rescue.qry.GetRescueBedListBP;
import iih.en.er.bp.rescue.qry.GetRescuePrtTmplBp;
import iih.en.er.bp.stay.GetObsPerInfoBP;
import iih.en.er.bp.stayout.GetOutStayInfoBP;
import iih.en.er.bp.stayregist.GetObsScAptIpInfosBP;
import iih.en.er.bp.stayregist.GetUrgStayRegInfosBP;
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
import iih.en.er.i.IEnErQryService;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.er.pre.d.EnErPreScoreDO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.BedQryModDTO;
import iih.en.pv.inpatient.dto.d.DepEntStateDTO;
import iih.sc.scbd.dto.d.PrtQry4EnDTO;
import iih.sc.scbd.dto.d.ScPrtTmplDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.jdbc.facade.DAException;

/**
 * 急诊查询服务
 * 
 * @author liubin
 *
 */
@Service(serviceInterfaces={IEnErQryService.class}, binding=Binding.JSONRPC)
public class EnErQryServiceImpl implements IEnErQryService {
	/**
	 * 获取患者预检信息
	 * 
	 * @param patId 患者id
	 * @param statusErPre 预检状态
	 * @return
	 * @throws BizException
	 */
	@Override
	public PhySignDTO[] getErPreTpl() throws BizException {
		GetErPreTplBP bp = new GetErPreTplBP();
		return bp.exec();
	}
	/**
	 * 获取患者预检信息
	 * 
	 * @param patId 患者id
	 * @param statusErPre 预检状态
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnErPreTriageDTO[] getPatErPreInfos(String patId, String[] statusErPre) throws BizException {
		GetPatErPreInfosBP bp = new GetPatErPreInfosBP();
		return bp.exec(patId, statusErPre);
	}
    /**
     * 获取急诊预检评分
     * 
     * @param erpreId
     * @param scotp
     * @return
     */
	@Override
	public EnErPreScoreDO getEnErPreScore(String erpreId, String scotp)
			throws BizException {
		GetErPreScoreBP bp = new GetErPreScoreBP();
		return bp.exec(erpreId, scotp);
	}
    /**
     * 获取预检id
     * 
     * @param size
     * @return
     */
	@Override
	public FArrayList createPrimaryKeys(int size) throws BizException {
		String[] ids = EnCodeUtils.createPrimaryKeys(size);
		return EnAppUtils.objArray2List(ids);
	}
    /**
     * 获取患者在院抢救预检信息
     * 
     * @param patId
     * @return
     */
	@Override
	public EnErPreDO getErPreOfInHosEtFstaid(String patId) throws BizException {
		GetErPreOfInHosEtFstaidBP bp = new GetErPreOfInHosEtFstaidBP();
		return bp.exec(patId);
	}
	/**
	 * 获取急诊患者流转记录
	 * @param entId 就诊ID
	 * @return
	 */
	@Override
	public UrgPatInfoRecDTO[] getUrgPatInfoRec(String entId) throws BizException {
		GetUrgPatRecInfoBP bp = new GetUrgPatRecInfoBP();
		return bp.exec(entId);
	}
	/**
	 *  获取急诊留观许可
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnObsPermitDTO getObsPerInfo(String entId) throws BizException {
		GetObsPerInfoBP bp = new GetObsPerInfoBP();
		return bp.exec(entId);
	}
	/**
	 * 获取急诊留观许可证信息
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public UrgStayRegistryDTO[] getObsScAptIpInfos(String patId) throws BizException {
		GetObsScAptIpInfosBP bp = new GetObsScAptIpInfosBP();
		return bp.exec(patId);
	}
	/**
	 *  获取急诊留观登记信息
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public UrgStayRegistryDTO[] getUrgStayRegInfos(String patId) throws BizException {
		GetUrgStayRegInfosBP bp = new GetUrgStayRegInfosBP();
		UrgStayRegistryDTO urgStayRegistryDTO = bp.execByPatId(patId);
		return urgStayRegistryDTO != null ? new UrgStayRegistryDTO[]{ urgStayRegistryDTO } : null;
	}
	/**
	 * 获取急诊患者入出转信息
	 * 
	 * @param condition
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<UrgInOutTransMgrDTO> getUrgInOutTransMgrDtosByPageInfo(
			UrgMrgQueryDTO condition, PaginationInfo pageInfo)
			throws BizException {
		IGetInOutTransMgr bp = new GetInOutTransMgrBaseBP();
		return bp.exec(condition, pageInfo);
	}
	/**
	 * 获取患者入出转信息
	 * 
	 * @param condition
	 * @return	
	 * @throws BizException 
	 */
	@Override
	public UrgInOutTransMgrDTO[] getUrgInOutTransMgrDtos(UrgMrgQueryDTO condition) throws BizException {
		IGetInOutTransMgr bp = new GetInOutTransMgrBaseBP();
		return bp.exec(condition);
	}
	/**
	 * 获取患者入出转信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public UrgInOutTransMgrDTO getUrgInOutTransMgrDtoByEntId(String entId) throws BizException {
		IGetInOutTransMgr bp = new GetInOutTransMgrBaseBP();
		return bp.exec(entId);
	}
	/***
	 * 获取床位卡右侧信息
	 * 
	 * @param id_ent 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public UrgNurRightDTO getNurRightInfoByIdEnt(String id_ent) throws BizException {
		GetNurRightInfoByIdEntBP bp = new GetNurRightInfoByIdEntBP();
		return bp.exec(id_ent);
	}
	/**
	 * 获取急诊抢救医生站列表数量
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap getErFstaidPatCounts() throws BizException {
		GetErFstaidPatCountsBP bp = new GetErFstaidPatCountsBP();
		return bp.exec();
	}
	/**
	 * 急诊抢救医生站banner查询
	 * 
	 * @param selectConditions
	 * @param inputValue
	 * @return
	 * @throws BizException
	 */
	@Override
	public UrgInOutTransMgrDTO[] getUrgInOutTransMgrDtosForFstBanner(String[] selectConditions, String inputValue) throws BizException {
		GetUrgInOutTransMgrDtosForFstBannerBP bp = new GetUrgInOutTransMgrDtosForFstBannerBP();
		return bp.exec(selectConditions, inputValue);
	}
	/**
	 * 获取患者本次所有有效就诊记录
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnErPreInfoDTO[] getEnErPreInfosByEntId(String entId)
			throws BizException {
		GetEnErPreInfosByEntIdBP bp = new GetEnErPreInfosByEntIdBP();
		return bp.exec(entId);
	}
	/**
	 *  获取出急诊留观信息
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public UrgStayOutDTO getUrgStayOutInfo(String entId) throws BizException {
		GetOutStayInfoBP bp = new GetOutStayInfoBP();
		return bp.exec(entId);
	}
	/***
	* 抢救护士站床位浏览获取床位信息
	* 
	* @param qryMod
	* @return
	* @throws BizException
	*/
	@Override
	public BedBigCardDTO[] getRescueBedList(BedQryModDTO qryMod) throws BizException{
		GetRescueBedListBP bp = new GetRescueBedListBP();
		return bp.exec(qryMod);
	}
	/***
	 * 获取床位卡右侧信息(急诊抢救流程)
	 * 
	 * @param id_ent 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public UrgNurRightDTO getRescueRightInfoByIdEnt(String id_ent) throws BizException{
		GetRescueRightInfoByIdEntBP bp = new GetRescueRightInfoByIdEntBP();
		return bp.exec(id_ent);
	}
	/**
	 * 获取急诊预检相关信息
	 * 
	 * @param enErPrQueryDTO
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<EnErPrQueryDTO> getEnErPrQueryDTO(EnErPrQueryDTO enErPrQueryDTO, PaginationInfo pageInfo)
			throws BizException {
		GetEnErPrQuery bp = new GetEnErPrQuery();
		return bp.exec(enErPrQueryDTO, pageInfo);
	}
	/***
	 * 通过预检id获取就诊详情，fanlq-2019-06-14
	 * @param id_enpre 预检id
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnErOutPatinQuirDTO[] getErPreEntByIdErPre(String id_enpre) throws BizException{
		return new GetErPreEntByIdErPreBP().exec(id_enpre);
	}
	/**
	 * 获取急诊病人基本信息
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException 
	 * @throws DAException 
	 * @date 2018年12月27日
	 */
	@Override
	public EnErBasic4EditDTO getEnErBasic4edit(String entId) throws BizException{
		GetEnErBasic4editBP bp = new GetEnErBasic4editBP();
		return bp.exec(entId);
	}
	/***
	 * 通过预检id获取预检信息，fanlq-2019-07-25
	 * @param id_erpre 预检id
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnErBasic4EditDTO getEnErBasicInfo(String id_erpre) throws BizException{
		return new GetEnErBasicInfoBP().exec(id_erpre);
	}
	/**
	 * 获取急诊患者概况信息
	 * @param entId 就诊ID
	 * @return
	 */
	@Override
	public UrgPatInfoDTO getUrgPatInfo(String entId) throws BizException {
		GetUrgPatInfoBP bp = new GetUrgPatInfoBP();
		return bp.exec(entId);
	}
	/**
	 * 获取生命体征
	 * @return
	 * @throws BizException 
	 */
	@Override
	public UrgPatInfoSrvDTO getVitalSignInfo(String id_ent) throws BizException {
		GetUrgVitalSignBP bp = new GetUrgVitalSignBP();
		return bp.exec(id_ent);
	}
	/**
	 * 查询患者记录
	 * 
	 * @param 查询卡
	 * @return
	 */
	@Override
	public PagingRtnData<EnErOutPatinQuirDTO> getEnErOutPatinQuirDtos(EnErOutPatinQuirDTO enErOutPatinQuir,PaginationInfo pageInfo) throws BizException {
		GetEnErOutPatinQuirlnfoBP bp = new GetEnErOutPatinQuirlnfoBP();
		return bp.exec(enErOutPatinQuir, pageInfo);
	}
	/**
	 * 获取急诊抢救科室就诊状况统计信息
	 * 
	 * @param qryMod
	 * @return
	 * @throws BizException
	 */
	@Override
	public DepEntStateDTO[] getDepRescueEntStateStats(BedQryModDTO qryMod) throws BizException {
		GetDepRescueEntStateStatsBP bp = new GetDepRescueEntStateStatsBP();
		return bp.exec(qryMod);
	}	
	/**
	 * 根据打印模板项目配置信息查询 打印模板
	 * @author lilei
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScPrtTmplDTO getRescuePrtTmplDTO(PrtQry4EnDTO qryDTO) throws BizException{
		GetRescuePrtTmplBp bp = new GetRescuePrtTmplBp();
		return bp.exec(qryDTO);
	}
}
