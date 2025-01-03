package iih.mp.dg.i;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.mp.dg.dto.backdrugdisp.d.MpPrepDispCondDTO;
import iih.mp.dg.dto.backdrugdisp.d.MpPrepPresListDTO;
import iih.mp.dg.dto.druginfudto.d.ActionMesDTO;
import iih.mp.dg.dto.druginfudto.d.OpInfuCondDTO;
import iih.mp.dg.dto.druginfudto.d.OpInfuOrDetailDTO;
import iih.mp.dg.dto.druginfudto.d.OpInfuPatOr2DTO;
import iih.mp.dg.dto.druginfudto.d.OpInfuPatOrDTO;
import iih.mp.dg.dto.druginfudto.d.OpMmOrDetailDTO;
import iih.mp.dg.dto.druguseqry.d.MpDrugUseDetailDTO;
import iih.mp.dg.dto.druguseqry.d.MpDrugUseQryCondDTO;
import iih.mp.dg.dto.druguseqry.d.MpDrugUseSumDTO;
import iih.mp.dg.dto.herbaldelivery.d.HerbalDeliveryDTO;
import iih.mp.dg.dto.ipcheck.d.StockCheckDTO;
import iih.mp.dg.dto.ipdgrecordcond.d.IpDgRecordCondDTO;
import iih.mp.dg.dto.ipdgrecordcond.d.IpDgSpecialRetHdDTO;
import iih.mp.dg.dto.ipdrugmp.d.IpDgConditionDTO;
import iih.mp.dg.dto.ipdrugmp.d.IpDgDispHdDTO;
import iih.mp.dg.dto.ipdrugmp.d.IpDgDtDTO;
import iih.mp.dg.dto.ipdrugmp.d.IpDgRepalceDTO;
import iih.mp.dg.dto.mpdgquesite.d.MpDgQuesiteDTO;
import iih.mp.dg.dto.opboilherb.d.OpBoilHerbCondDTO;
import iih.mp.dg.dto.opboilherb.d.OpBoilHerbPresDTO;
import iih.mp.dg.dto.opdgdisp.d.BoilFeePresDTO;
import iih.mp.dg.dto.opdgdisp.d.DrugsDTO;
import iih.mp.dg.dto.opdgdisp.d.OpDrugDispenseCondDTO;
import iih.mp.dg.dto.opdgdisp.d.OutpatientTimesDTO;
import iih.mp.dg.dto.opdgdisp.d.PatInfoDTO;
import iih.mp.dg.dto.opdgdisp.d.PresDTO;
import iih.mp.dg.dto.opdgdisp.d.PresDispPrintCondDTO;
import iih.mp.dg.dto.opdgdisp.d.PresDrugsDTO;
import iih.mp.dg.dto.opdgdisp.d.PresDrugsFeeDTO;
import iih.mp.dg.dto.opdgdisp.d.RelatedPersonDTO;
import iih.mp.dg.dto.opinfuadr.d.OpInfuAdrInfoDTO;
import iih.mp.dg.dto.opinfuadr.d.OpInfuRegistDTO;
import iih.mp.dg.dto.opsearch.d.SearchCondDTO;
import iih.mp.dg.dto.opsearch.d.SearchDrugDTO;
import iih.mp.dg.dto.opsearch.d.SearchPresDTO;
import iih.mp.dg.ipshetp.d.IpSheetTypeDO;
import iih.mp.dg.ipshetpauto.d.IpShetpAutoDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 执行域药品服务
 * 
 * @author LY
 *
 */
public interface IMpDgQryService {

	/******************** 门诊药品方法 ********************/

	/**
	 * 门急诊退药记录查询 处方信息
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<SearchPresDTO> getOpRtnPresPaging(QryRootNodeDTO qryRootNodeDTO, PaginationInfo pg)
			throws BizException;

	/**
	 * 门急诊查询退药明细数据
	 * 
	 * @param opdgid 药品执行id
	 * @return
	 * @throws BizException
	 */
	public abstract SearchDrugDTO[] getOpRtnDrugsInfo(String opdgid) throws BizException;

	/******************** 门诊输液方法 ********************/

	/**
	 * 查询当前患者未签到的有效处方
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PresDrugsDTO[] getOpPatNoWinPresInfo(String id_pat, boolean isHerb) throws BizException;

	/**
	 * 门诊发药取得患者列表 重构版
	 * 
	 * @param cond 条件
	 * @return
	 * @throws BizException
	 */
	public abstract PatInfoDTO[] getOpPatInfoList2(OpDrugDispenseCondDTO cond) throws BizException;
	
	
	/**
	 * 获取患者在其他窗口存在发药处方时窗口
	 * 
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public abstract MpDgQuesiteDTO[] getOtherDispWin(OpDrugDispenseCondDTO cond) throws BizException;

	/**
	 * 门诊发药取得患者未发放处方 重构版
	 * 
	 * @param patid  患者id
	 * @param isHerb 草药标志
	 * @return
	 * @throws BizException
	 */
	public abstract PresDTO[] getOpPatNoDrugPreses2(OpDrugDispenseCondDTO cond, boolean fromBanner) throws BizException;

	/**
	 * 门诊发药取得已经发放的药品重构版
	 * 
	 * @param qrynode 条件
	 * @return
	 * @throws BizException
	 */
	public abstract PresDTO[] getOpDispensedPres2(QryRootNodeDTO qrynode) throws BizException;

	/**
	 * 住院查询直接摆药数据
	 * 
	 * @param cond 条件
	 * @return
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] getIpDirectMedDetail(IpDgConditionDTO cond) throws BizException;

	/******************** 住院药品方法 ********************/
	/**
	 * 住院查询未发送摆药数据
	 * 
	 * @param cond 条件
	 * @return
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] refreshIpTosendMedDetail(IpDgConditionDTO cond) throws BizException;

	/**
	 * 草药&出院带药统领单刷新
	 * 
	 * @param cond 条件
	 * @return
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] refreshDrugAndTakeMedDetail(IpDgConditionDTO cond) throws BizException;

	/**
	 * 重新计算请领量
	 * 
	 * @param dos
	 * @return
	 * @throws BizException
	 */
//	public abstract IpDgDispDtDTO[] recalAppliquan(IpDgDispDtDTO[] dos) throws BizException;

	/**
	 * 住院查询药品请领单数据 只查询请领单，不查询明细
	 * 
	 * @param cond 条件
	 * @return
	 * @throws BizException
	 */
	public abstract IpDgDispHdDTO[] getIpAppliSheets(IpDgConditionDTO cond, Boolean fg_refresh) throws BizException;

	/**
	 * 住院查询药品请领单数据并更新请领单打开状态
	 * 
	 * @param cond 条件
	 * @return
	 * @throws BizException
	 */
	public abstract IpDgDispHdDTO[] openIpAppliSheets(IpDgConditionDTO cond) throws BizException;

	/**
	 * 住院查询药品请领单数据并更新请领单打开状态(含明细)
	 * 
	 * @param cond 条件
	 * @return
	 * @throws BizException
	 */
	public abstract IpDgDispHdDTO[] openIpAppliSheetsWithDetail(IpDgConditionDTO cond) throws BizException;

	/**
	 * 住院查询特殊退药单表头数据
	 * 
	 * @param cond 条件
	 * @return
	 * @throws BizException
	 */
	public abstract IpDgSpecialRetHdDTO[] getIpSpecialRetSheets(IpDgConditionDTO cond) throws BizException;

	/**
	 * 住院退药信息查询
	 * 
	 * @param cond 查询条件
	 * @return 药品信息
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] getIpRetDrugs(IpDgConditionDTO cond) throws BizException;

	/**
	 * 住院发药记录查询（特殊退药单）
	 * 
	 * @param cond 查询条件
	 * @return 药品信息
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] queryIpDispRecords(IpDgRecordCondDTO cond) throws BizException;

	/**
	 * 住院发药草药记录查询（草药特殊退药单）
	 * 
	 * @param cond 查询条件
	 * @return 药品信息
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] queryIpDispHerbRecords(IpDgRecordCondDTO cond) throws BizException;

	/**
	 * 住院直接摆药退药信息查询
	 * 
	 * @param cond 查询条件
	 * @return 药品信息
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] getDirectIpRetDrugs(IpDgConditionDTO cond) throws BizException;

	/**
	 * 校验是否可进行药品替换
	 * 
	 * @param apId
	 * @param drugDatas
	 * @param isAp
	 * @return
	 * @throws BizException
	 */
	public abstract String checkIfCanReplaceDrug(String apId, IpDgRepalceDTO[] drugDatas, FBoolean isAp)
			throws BizException;

	/**
	 * 校验是否可进行药品替换选择
	 * 
	 * @param srvId
	 * @return
	 * @throws BizException
	 */
	public abstract boolean checkIfCanSelectDrug(String srvId) throws BizException;

	/**
	 * 人工后台摆药查询处方信息
	 * 
	 * @param cond 查询条件
	 * @return 处方列表信息
	 * @throws BizException
	 */
	public abstract MpPrepPresListDTO[] queryPresData(MpPrepDispCondDTO cond) throws BizException;

	/**
	 * 门诊草药代煎处方信息查询
	 * 
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public abstract OpBoilHerbPresDTO[] getBoilHerbalPresInfo(OpBoilHerbCondDTO cond) throws BizException;

	/**
	 * 门诊获得当前窗口信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract MpDgQuesiteDTO getCurrentQueSiteInfo() throws BizException;

	/**
	 * 获取当前的队列站点
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract QueSiteDO getCurrentQueSiteDO() throws BizException;

	/**
	 * 门诊发药获取摆药人员信息
	 * 
	 * @param idpres
	 * @return
	 * @throws BizException
	 */
	public abstract RelatedPersonDTO getDrugPreparingEmployee2(String idpres) throws BizException;

	/**
	 * 通过请领主键查询请领单数据
	 * 
	 * @param apId 请领主键
	 * @return 住院发药详细 DTO数据
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] getApDgDetailByApId(String apId, String deid, String id_pat, Boolean fg_search) throws BizException;

	/**
	 * 通过请领主键查询草药单数据
	 * 
	 * @param apId 请领主键
	 * @return 住院发药详细 DTO数据
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] getApDgHerbDetailByApId(String apId, String deid, String id_pat, Boolean fg_search) throws BizException;

	/**
	 * 通过请领主键查询可摆药数据
	 * 
	 * @param apId 请领主键
	 * @return 住院发药详细 DTO数据
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] getDeDgDetailByApId(String apId) throws BizException;

	/**
	 * 通过请领主键查询可摆药数据(草药单)
	 * 
	 * @param apId 请领主键
	 * @return 住院发药详细 DTO数据
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] getDeDgHerbDetailByApId(String apId, String id_pat, Boolean fg_search) throws BizException;

	/**
	 * 通过摆药主键查询已摆药数据
	 * 
	 * @param apId 请领主键
	 * @return 住院发药详细 DTO数据
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] getDeDgDetailByDeId(String apId, String id_pat, Boolean fg_search) throws BizException;
	
	/**
	 * 通过请领主键查询特殊退药请领单数据
	 * 
	 * @param apId 请领主键
	 * @return 请领明细DTO数据
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] getApDgSpecialRetDetailByApId(String apId) throws BizException;

	/**
	 * 通过请领主键查询草药特殊退药请领单数据
	 * 
	 * @param apId
	 * @return
	 * @throws BizException
	 */
	public abstract IpDgDtDTO[] getApDgSpecialRetHerbDetailByApId(String apId) throws BizException;

	/**
	 * 查询已摆药药单
	 * 
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public abstract IpDgDispHdDTO[] getIpDispSheets(IpDgConditionDTO cond) throws BizException;

	/**
	 * 门诊输液医嘱信息查询2
	 * 
	 * @param cond
	 * @param isRegisterTab
	 * @return
	 * @throws BizException
	 */
	public abstract OpInfuPatOrDTO[] getOpInfuPatOrData(OpInfuCondDTO cond, boolean isRegisterTab) throws BizException;

	/**
	 * 门诊输液登记医嘱明细查询2
	 * 
	 * @param idor
	 * @param isRegisterTab
	 * @return
	 * @throws BizException
	 */
	public abstract OpInfuOrDetailDTO[] getOpInfuOrItemData(String idor) throws BizException;

	/**
	 * 病区统领查询
	 */
	public abstract PagingRtnData<IpDgDtDTO> queryIpDgApItms(PaginationInfo pg, QryRootNodeDTO nodeDTO)
			throws BizException;

	/**
	 * 病区草药查询
	 */
	public abstract PagingRtnData<IpDgDtDTO> queryIpDgHerbItms(PaginationInfo pg, QryRootNodeDTO nodeDTO)
			throws BizException;

	/**
	 * 查询药单联动业务数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract IpShetpAutoDO[] getIpShetpAutoData() throws BizException;

	/**
	 * 门诊发药查询-处方信息 分页版
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @return
	 */
	public abstract PagingRtnData<SearchPresDTO> getDispSearchPresListPaging(PaginationInfo pg,
			QryRootNodeDTO qryRootNodeDTO) throws BizException;

	/**
	 * 门诊发药查询-药品信息
	 * 
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public abstract SearchDrugDTO[] getDispSearchDrugList(SearchCondDTO cond) throws BizException;

	/**
	 * 查询草药代煎服务信息
	 * 
	 * @param pres
	 * @return
	 * @throws BizException
	 */
	public abstract BoilFeePresDTO getAddBoilFeeData(PresDTO pres) throws BizException;

	/**
	 * 门诊输液执行医嘱信息列表
	 * 
	 * @param pres
	 * @return
	 * @throws BizException
	 */
	public abstract OpInfuPatOrDTO[] getTranInfuOrData(OpInfuCondDTO cond) throws BizException;

	/**
	 * 门诊输液执行信息列表
	 * 
	 * @param pres
	 * @return
	 * @throws BizException
	 */
	public abstract ActionMesDTO[] getActionMesItemData(OpInfuPatOrDTO cond) throws BizException;

	/**
	 * 门诊输液执行信息列表2
	 * 
	 * @param pres
	 * @return
	 * @throws BizException
	 */
	public abstract ActionMesDTO[] getActionMesItemData2(OpInfuPatOr2DTO cond) throws BizException;

	/**
	 * 查询已经登记的输液的信息(单患者) 不良反应记录用
	 * 
	 * @param cond 条件
	 * @throws BizException
	 */
	public abstract OpInfuRegistDTO[] getInfuRegistInfo(OpInfuCondDTO cond) throws BizException;

	/**
	 * 查询输液的详细信息
	 * 
	 * @param dgInfoId 输液登记id
	 * @return 输液详细信息
	 * @throws BizException
	 */
	public abstract OpInfuAdrInfoDTO[] getInfuDetailInfo(String dgInfoId) throws BizException;

	/**
	 * 输液查询(分页)
	 * 
	 * @param pg
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<OpInfuPatOr2DTO> getInfuOrderPaging(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO)
			throws BizException;

	/**
	 * 查询输液药品明细信息
	 * 
	 * @param ActionMesDTO
	 * @return 输液药品明细信息
	 * @throws BizException
	 */
	public abstract OpMmOrDetailDTO[] getOpMmOrDetail(ActionMesDTO mesDto) throws BizException;

	/**
	 * 门诊退药查询，分页版
	 * 
	 * @param
	 * @return 分页信息
	 * @throws BizException
	 */
	public abstract PagingRtnData<PresDTO> getOpDispensedPresByPage(PaginationInfo pg, QryRootNodeDTO wherePart)
			throws BizException;

	/**
	 * 门诊处方费用查询
	 * 
	 * @param pg        分页信息
	 * @param wherePart 查询方案
	 * @param cond      查询条件
	 * @return 分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<PresDrugsFeeDTO> getOpPresFeeInfoByPage(PaginationInfo pg, QryRootNodeDTO wherePart,
			OpDrugDispenseCondDTO cond, Boolean fg_defaultquery) throws BizException;

	/**
	 * 取得门诊最大就诊次数 费用查询用
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public abstract OutpatientTimesDTO getLastestOpEnInfo(String patId) throws BizException;

	/**
	 * 住院用药查询查询药品汇总
	 * 
	 * @param cond 查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpDrugUseSumDTO[] getIpDrugUseTotalInfo(MpDrugUseQryCondDTO cond) throws BizException;

	/**
	 * 住院用药查询查询明细信息
	 * 
	 * @param cond 查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpDrugUseDetailDTO[] getIpDrugUseDetailInfo(MpDrugUseQryCondDTO cond) throws BizException;

	/**
	 * 获取已刷卡未发药的处方(未点发药，漏计费)
	 * 
	 * @param pg
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<PresDTO> getOpDrugUnDispensePres(PaginationInfo pg, QryRootNodeDTO wherePart)
			throws BizException;

	/**
	 * 获取已刷卡未发药处方药品明细(未点发药，漏计费)
	 * 
	 * @param idPres
	 * @return
	 * @throws BizException
	 */
	public abstract DrugsDTO[] getOpDrugUnDispensePresDetail(String idPres) throws BizException;

	/**
	 * 获取已摆药处方分页信息
	 * 
	 * @param pg
	 * @param patId
	 * @return
	 */
	public abstract PagingRtnData<PresDTO> findOpDispDrugPresPagingByPatId(PaginationInfo pg,
			String patId) throws BizException;

	/**
	 * 获取已摆药处方明细
	 * 
	 * @param presId 处方主键
	 * @return
	 */
	public abstract DrugsDTO[] findOpDispDrugPresItmsByPresId(String presId) throws BizException;
	
	/**
	 * 获取pivas缺药信息
	 * 
	 * @return
	 */
	public abstract StockCheckDTO[] findPivasDrugLackInfo() throws BizException;
	
	/**
	 * 获取pivas缺药信息
	 * 
	 * @return
	 */
	public abstract StockCheckDTO[] findPivasDrugLackInfoByDT(IpDgDtDTO[] ipDgDtDtoList) throws BizException;
	
	/**
	 * 获取pivas拒摆明细
	 * @param begin 检索开始时间
	 * @param end 检索结束时间
	 * @return 拒摆明细
	 * @throws BizException
	 * @author ly 2018/10/04
	 */
	public abstract IpDgDtDTO[] getPivasRefusedDetailInfo(FDateTime begin, FDateTime end) throws BizException;
	
	/**
	 * 门急诊退药（新）查询处方信息
	 * @author Administrator
	 *
	 */
	public abstract PagingRtnData<PresDTO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
	/**
	 * 病区统领单西成摆药增加批量获取接口
	 * 
	 * @return
	 */
	public abstract IpDgDtDTO[] getDeDgDetailByBat(IpDgDispHdDTO[] hdDtos) throws BizException;
	
	/**
	 * 是否是医保就诊
	 * 
	 * @return
	 */
	public abstract FBoolean getIsHpEnt(String id_ent) throws BizException;
	
	/**
	 * 是否是毒麻处方
	 * 
	 * @return
	 */
	public abstract String getIsPoisonDrug(String id_pres) throws BizException;
	
	/**
	 * 门诊处方批量打印查询接口
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<PresDTO> findPresByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
	
	/**
	 * 根据处方id查询处方明细
	 * @param idpres
	 * @return
	 * @throws BizException
	 */
	public abstract DrugsDTO[] getPresDetail(String idpres) throws BizException;
	
	/**
	 * 获取pivas药单类型
	 * 
	 * @return
	 */
	public abstract IpSheetTypeDO getPivasShetType() throws BizException;
	
	/**
	 * 获取门诊草药处方（配送）信息
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<HerbalDeliveryDTO> getHerbPresDelvrs(QryRootNodeDTO qryRootNodeDTO, String id_pres, PaginationInfo pg) throws BizException;
	
	/**
	 * 获取门诊草药配送联系住址信息
	 * @param herbal
	 * @return
	 * @throws BizException
	 */
	public abstract HerbalDeliveryDTO[] getHerbDelvrContacts(HerbalDeliveryDTO herbal) throws BizException;

	/**
	 * 获取需要审核的处方信息
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<PresDTO> getNeedVerifyPres(PaginationInfo pg, QryRootNodeDTO wherePart, String id_pat, String orderStr) throws BizException;
	
	/**
	 * 获取可以打印的处方摆药单
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<PresDTO> getOpCanPrintDispPres(PaginationInfo pg, QryRootNodeDTO wherePart, PresDispPrintCondDTO printCondDto) throws BizException;
	
	/**
	 * 获取门诊发药处方(医技批量)
	 * @return
	 * @throws BizException
	 */
    public abstract PresDTO[] getOpOtDispPresInfo(OpDrugDispenseCondDTO condDto) throws BizException;
	
    /**
	 * 获取患者在其他药房的未取药提示信息
	 * @return
	 * @throws BizException
	 */
	public abstract String getOtherWhNoDispInfo(OpDrugDispenseCondDTO cond) throws BizException;
	
    /**
	 * 获取门急诊退药明细
	 * @return
	 * @throws BizException
	 */
	public abstract DrugsDTO[] getOpDrugReturnDetailInfo(String id_pres, FBoolean fg_canceledRecord) throws BizException;
	
    /**
	 * 获取待记账医嘱服务列表
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getTobeAccountOrsrvs(PresDTO pres, FBoolean isHerb) throws BizException;
}
