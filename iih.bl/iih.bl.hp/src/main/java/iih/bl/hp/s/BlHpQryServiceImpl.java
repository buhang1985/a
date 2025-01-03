package iih.bl.hp.s;

import iih.bl.comm.util.BlCodeUtils;
import iih.bl.hp.bp.GetOpZeroRegUploadXmlBP;
import iih.bl.hp.dto.d.AccountCheckDTO;
import iih.bl.hp.dto.d.BillInfoDTO;
import iih.bl.hp.dto.d.BlStBalanceDTO;
import iih.bl.hp.dto.d.CostSettlementQueryDTO;
import iih.bl.hp.dto.d.DocInfoDTO;
import iih.bl.hp.dto.d.EntBasicInfoDTO;
import iih.bl.hp.dto.d.HpFeeSumDTO;
import iih.bl.hp.dto.d.HpIpOepTransDTO;
import iih.bl.hp.dto.d.HpPatiEntDTO;
import iih.bl.hp.dto.d.HpPatiSettledDTO;
import iih.bl.hp.dto.d.HpSettledReportDTO;
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import iih.bl.hp.dto.d.OutHospitalRegDTO;
import iih.bl.hp.dto.d.PresDetailsUploadDTO;
import iih.bl.hp.dto.d.SettledDetailDTO;
import iih.bl.hp.hpexceptioninfodto.d.HpExceptionInfoDTO;
import iih.bl.hp.hpsignin.d.HpSignInDO;
import iih.bl.hp.i.IBlHpQryService;
import iih.bl.hp.rural.dto.d.RuralPersonInfoDTO;
import iih.bl.hp.s.bp.CheckHpFeeStatesBp;
import iih.bl.hp.s.bp.CheckPiPatPoorBP;
import iih.bl.hp.s.bp.GetDetailsUploadDTOsBP;
import iih.bl.hp.s.bp.GetDocsListBp;
import iih.bl.hp.s.bp.GetEntIpFeeBp;
import iih.bl.hp.s.bp.GetEntListBP;
import iih.bl.hp.s.bp.GetHpBizCodeBP;
import iih.bl.hp.s.bp.GetHpExceptionInfoBp;
import iih.bl.hp.s.bp.GetHpExitInfoBp;
import iih.bl.hp.s.bp.GetHpIpInHosBillsByPageBP;
import iih.bl.hp.s.bp.GetHpOutRegInfoBP;
import iih.bl.hp.s.bp.GetHpPatiTransInfoBP;
import iih.bl.hp.s.bp.GetHpPatiVisitBP;
import iih.bl.hp.s.bp.GetHpSettledExceptionBp;
import iih.bl.hp.s.bp.GetHpSettledInputCondBp;
import iih.bl.hp.s.bp.GetHpSettledTransInfoBp;
import iih.bl.hp.s.bp.GetHpSignListBP;
import iih.bl.hp.s.bp.GetHpStHisExitInfoBp;
import iih.bl.hp.s.bp.GetHpTransActBP;
import iih.bl.hp.s.bp.GetHpTransDetailInfoBP;
import iih.bl.hp.s.bp.GetInHospHpPatiEntInfoBp;
import iih.bl.hp.s.bp.GetIpBillInfoDTOsBP;
import iih.bl.hp.s.bp.GetIpBillItemDtosBp;
import iih.bl.hp.s.bp.GetIpBillItemDtosByPageBp;
import iih.bl.hp.s.bp.GetIpBillItemDtosPagBp;
import iih.bl.hp.s.bp.GetIpBillItemDtosUnEntBP;
import iih.bl.hp.s.bp.GetIpFeeSummaryBP;
import iih.bl.hp.s.bp.GetOepBillInfoDTOsBp;
import iih.bl.hp.s.bp.GetOepFeeSummaryBP;
import iih.bl.hp.s.bp.GetRuralEntPersonInfoBp;
import iih.bl.hp.s.bp.GetSettledInfoBP;
import iih.bl.hp.s.bp.GetSettledReportInfoBp;
import iih.bl.hp.s.bp.GetTransDetailBp;
import iih.bl.hp.s.bp.HasHalfSettledBp;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保查询服务
 * 
 * @author yankan
 * @since 2017-06-15
 *
 */
@Service(serviceInterfaces = { IBlHpQryService.class }, binding = Binding.JSONRPC)
public class BlHpQryServiceImpl implements IBlHpQryService {

	/**
	 * 获取可用医保业务周期号
	 * 
	 * @param empId
	 * @return
	 * @throws BizException
	 * @author
	 */
	@Override
	public String getHpBizCode(String empId) throws BizException {
		GetHpBizCodeBP getBizCodeBP = new GetHpBizCodeBP();
		return getBizCodeBP.exec(empId);
	}

	/**
	 * 获取操作员签到记录
	 * 
	 * @param pg
	 *            分页对象
	 * @param empId
	 *            操作员ID
	 * @return 签到记录集合
	 * @throws BizException
	 * @author
	 */
	@Override
	public PagingRtnData<HpSignInDO> getHpSignList(PaginationInfo pg, String whereCond) throws BizException {
		GetHpSignListBP getSignListBP = new GetHpSignListBP();
		return getSignListBP.exec( pg, whereCond);
	}

	/**
	 * 获取患者的就诊记录
	 * 
	 * @param pg
	 *            分页对象
	 * @param qryNode
	 *            查询面板对象
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<EntBasicInfoDTO> getEntList(QryRootNodeDTO qryNode,PaginationInfo pg) throws BizException{
		GetEntListBP getEntListBP = new GetEntListBP();
		return getEntListBP.exec(qryNode,pg);
	}

	/**
	 * 通过某次就诊的就诊号code_ent查询获得其对应的门诊单据信息列表
	 * 
	 * @param code_ent
	 *            就诊号
	 * @return 单据信息集合
	 * @throws BizException
	 * @author li_pengying
	 */
	@Override
	public BillInfoDTO[] getOepBillInfoByCode(String code_ent) throws BizException {
		GetOepBillInfoDTOsBp bp = new GetOepBillInfoDTOsBp();
		return bp.exec(code_ent);
	}

	/**
	 * 通过某次就诊的就诊号code_ent查询获得其对应的住院单据信息列表
	 * 
	 * @param code_ent
	 *            就诊号
	 * @return 单据信息集合
	 * @throws BizException
	 * @author liwq
	 */
	@Override
	public BillInfoDTO[] getIpBillInfoByCode(String code_ent) throws BizException {
		GetIpBillInfoDTOsBP bp = new GetIpBillInfoDTOsBP();
		return bp.exec(code_ent);
	}
	/**
	 * 门诊医疗费用汇总对账
	 *
	 * @param id_emp
	 * @return
	 * @throws BizException
	 * @author liwq
	 * @since 2017-7-14 14:32:47
	 */
	public HpFeeSumDTO[] getOepFeeSummary(String id_emp)  throws BizException {
		GetOepFeeSummaryBP bp = new GetOepFeeSummaryBP();
		return bp.exec(id_emp);
	}
	
	/**
	 * 住院医疗费用汇总对账
	 *
	 * @param id_emp
	 * @return
	 * @throws BizException
	 * @author liwq
	 * @since 2017-7-14 14:32:47
	 */
	public HpFeeSumDTO[] getIpFeeSummary(String id_emp)  throws BizException {
		GetIpFeeSummaryBP bp = new GetIpFeeSummaryBP();
		return bp.exec(id_emp);
	}

	/**
	 * （东软）医保结算信息查询
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public HpFeeSumDTO[] getSettledInfos(String whereCond, String code_enttp) throws BizException {
		GetSettledInfoBP bp = new GetSettledInfoBP();
		return bp.exec(whereCond, code_enttp);
	}

	/**
	 * 查询得到医师信息列表
	 * 
	 * @param qryNode
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<DocInfoDTO> getDocsList(QryRootNodeDTO qryNode, PaginationInfo pg) throws BizException {

		GetDocsListBp getbp = new GetDocsListBp();
		return getbp.exec(qryNode, pg);
	}

	/*
	 * 获取结算信息，为了安徽医保对账用
	 * 
	 * @return 一次就诊的信息
	 */
	@Override
	public AccountCheckDTO[] getEntIpStInfo(String strIdEnt) throws BizException {

		GetEntIpFeeBp handlerBp = new GetEntIpFeeBp();
		return handlerBp.exec(strIdEnt);
	}

	/**
	 * 获取门诊处方明细
	 * 
	 * @param patid
	 *            患者编号
	 * @param entid
	 *            就诊编号
	 * @return
	 * @throws BizException
	 */
	@Override
	public PresDetailsUploadDTO[] getDetailsUploadDTOsToOep(String patid, String entid) throws BizException {
		GetDetailsUploadDTOsBP bp = new GetDetailsUploadDTOsBP();
		return bp.exec(patid, entid, false);
	}

	/**
	 * 获取住院处方明细
	 * 
	 * @param patid
	 *            患者编号
	 * @param entid
	 *            就诊编号
	 * @return
	 * @throws BizException
	 */
	@Override
	public PresDetailsUploadDTO[] getDetailsUploadDTOsToIp(String patid, String entid) throws BizException {
		GetDetailsUploadDTOsBP bp = new GetDetailsUploadDTOsBP();
		return bp.exec(patid, entid, true);
	}
	
	
	/**
	 * 获取住院处方明细

	 * @param strIdEnt
	 *            就诊编号
	 * @return
	 * @throws BizException
	 */
	@Override
	public IpBillItmUploadHpDTO[] getIpBillItmArr(String strIdEnt,String ipStId,FBoolean isUpload) throws BizException {
		GetIpBillItemDtosBp handlerBp=new GetIpBillItemDtosBp();
		return handlerBp.exec(strIdEnt, ipStId,isUpload);
	}
	
	@Override
	public IpBillItmUploadHpDTO[] getIpBillItmByIdCgIps(String strIdEnt,String ipStId,String[] idCgIps, FBoolean isUpload)
			throws BizException {
		GetIpBillItemDtosBp handlerBp=new GetIpBillItemDtosBp();
		return handlerBp.exec2(strIdEnt,ipStId, idCgIps,isUpload);
	}
	
	/**
	 * 获取住院处方明细(分页查询)
	 * @author zhang.hw
	 * @date 2019年4月29日
	 * @param qryRootNodeDto
	 * @param strIdEnt
	 * @param ipStId
	 * @param isUpload
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<IpBillItmUploadHpDTO> getIpBillItmArrPage(QryRootNodeDTO qryRootNodeDto,String strIdEnt,String ipStId,FBoolean isUpload, PaginationInfo pg) throws BizException {
		GetIpBillItemDtosPagBp handlerBp=new GetIpBillItemDtosPagBp();
		return handlerBp.exec(qryRootNodeDto,strIdEnt, ipStId,isUpload,pg);
	}
	
	/**
	 * 获取住院处方明细(分页查询)
	 * @author zhang.hw >>xy.zhou
	 * @date 2019年7月15日
	 * @param strIdEnt
	 * @param ipStId
	 * @param isUpload
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<IpBillItmUploadHpDTO> getIpBillItmArrPage2(String strIdEnt,String ipStId,FBoolean isUpload, PaginationInfo pg) throws BizException {
		GetIpBillItemDtosPagBp handlerBp=new GetIpBillItemDtosPagBp();
		return handlerBp.exec2(strIdEnt, ipStId,isUpload,pg);
	}

	/**
	 * 获取住院处方明细(分页)
	 * @param strIdEnt
	 *            就诊编号
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<IpBillItmUploadHpDTO> getIpBillItmArrByPage(String strIdEnt,String ipStId,FBoolean isUpload,PaginationInfo pg) throws BizException {
		GetIpBillItemDtosByPageBp handlerBp=new GetIpBillItemDtosByPageBp();
		return handlerBp.exec(strIdEnt, ipStId,isUpload,pg);
	}

	/**
	 * 获取医保出院登记就诊信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author liwq 
	 */
	public OutHospitalRegDTO[] getOutHospReg(String id_ent) throws BizException {
		GetHpOutRegInfoBP bp =  new GetHpOutRegInfoBP();
		return bp.exec(id_ent);
	}
	
	/**
	 * 获取医保登记表（门诊/住院）
	 * @author yangyang
	 * @review liwq 根据患者id 查询医保登记表中异常数据
	 */
	@Override
	public HpExceptionInfoDTO[] getTransDetailDtoArr(String strIdPat) throws BizException {
		GetTransDetailBp handlerBp=new GetTransDetailBp();
		return handlerBp.exec(strIdPat);
	}
	
	/**
	 * 医保结算交易查询
	 * @author liwq 
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HpPatiSettledDTO> getHpTransPageInfo(QryRootNodeDTO qryRootNodeDTO, PaginationInfo pg) throws BizException {
		GetHpSettledTransInfoBp bp = new GetHpSettledTransInfoBp();
		return bp.exec(qryRootNodeDTO, pg);
	}
	
	/**
	 * 医保结算交易费用明细查询
	 * @param  结算id和就诊类型code组合map
	 * @author liwq 
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<SettledDetailDTO> getSettledDetailInfo(FMap map, PaginationInfo pg) throws BizException {
		GetHpTransDetailInfoBP bp = new GetHpTransDetailInfoBP();
		return bp.exec(map, pg);
	}
	/**
	 * 医保结算交易费用明细查询
	 * @param  结算id和就诊类型code组合map
	 * @author liwq 
	 * @return
	 * @throws BizException
	 * @author yang.lu
	 */
	public FMap getOpZeroRegUploadXml(FMap entIdMap, String personType)  throws BizException{
		GetOpZeroRegUploadXmlBP getZeroRegXmlBP = new GetOpZeroRegUploadXmlBP();
		return getZeroRegXmlBP.exec(entIdMap,personType);
	}
	/** 
	 * 获取导出CSV的患者交易信息
	 * @param  
	 * @author liwq 
	 * @return
	 * @throws BizException
	 */
	public HpPatiSettledDTO[] getHpPatiTransInfo(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		GetHpPatiTransInfoBP bp = new GetHpPatiTransInfoBP();
		return bp.exec(qryRootNodeDTO);
	}
	/**
	 * 医保患者是否进行过医保的中途结算
	 * @param idEnt
	 * @return
	 * @throws BizException
	 * @author liwq
	 */
	public FBoolean hasHalfSettled(String idEnt) throws BizException {
		HasHalfSettledBp bp = new HasHalfSettledBp();
		return bp.exec(idEnt);
	}
	/**
	 * 单独进行医保结算撤销(安徽),查询医保撤销条件
	 * @author liwq
	 */
	public CostSettlementQueryDTO getHpSettledInputCond(String idStIp) throws BizException {
		GetHpSettledInputCondBp bp = new GetHpSettledInputCondBp();
		return bp.exec(idStIp);
	}
	
	/**
	 * 检索是否有明细费用上传至医保中心
	 * @author liwq
	 */
	public FBoolean checkHpFeeStates(String idEnt) throws BizException {
		CheckHpFeeStatesBp bp = new CheckHpFeeStatesBp();
		return bp.exec(idEnt);
	}

	/**
	 * 获取医保结算单信息
	 * @author liwq
	 */
	public HpSettledReportDTO[] getSettledReportInfo(QryRootNodeDTO qryNode) throws BizException {
		GetSettledReportInfoBp bp = new GetSettledReportInfoBp();
		return bp.exec(qryNode);
	}
	/**
	 * 获取医保入参交易流水号
	 */
	public String getHpRegisterCode() throws BizException{
		return BlCodeUtils.generateHpRegisterCode();
	}
	/**
	 * 查询医保患者在院就诊信息
	 * @author liwq
	 */
	public HpPatiEntDTO[] getInHospHpPatiEntInfo(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		GetInHospHpPatiEntInfoBp bp = new GetInHospHpPatiEntInfoBp();
		return bp.exec(qryRootNodeDTO);
	}

	/**
	 * 医保结算成功HIS失败时，撤销医保交易所用（医保结算撤销节点）
	 * @author liwq
	 */
	public CostSettlementQueryDTO getHpSettledException(String id_ent) throws BizException {
		GetHpSettledExceptionBp bp = new GetHpSettledExceptionBp();
		return bp.exec(id_ent);
	}

	/**
	 * 获取农合就诊信息
	 * @param strIdEnt
	 * @return
	 * @throws BizException
	 */
	@Override
	public RuralPersonInfoDTO getRuralPersonInfo(String strIdEnt) throws BizException {
		GetRuralEntPersonInfoBp handerBp=new GetRuralEntPersonInfoBp();
		return handerBp.exec(strIdEnt);
	} 
	
	/** 住院收付款/退费时，异常处理
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author liwq
	 */
	public HpExceptionInfoDTO getHpExceptionInfo(String id_ent) throws BizException{
		GetHpExceptionInfoBp bp = new GetHpExceptionInfoBp();
		return bp.exec(id_ent);
	}
	/**
	 * 
	 */
	@Override
	public HpIpOepTransDTO[] getHpTransAct(String id_pat) throws BizException {
		GetHpTransActBP bp = new GetHpTransActBP();
		return bp.exec(id_pat);
	}


	/**
	 * 获取医保结算HIS有医保无的数据
	 * @author shaokx
	 * @throws BizException 
	 */
	@Override
	public BlStBalanceDTO[] getHpStHisExitInfo(BlStBalanceDTO[] miInfoList, String dt_b, String dt_e,String enttp) throws BizException {
		GetHpStHisExitInfoBp bp = new GetHpStHisExitInfoBp();
		return bp.exec(miInfoList, dt_b, dt_e,enttp);
	}
	
	/**
	 * 获取医保有HIS无的信息
	 */
	public BlStBalanceDTO[] getHpExitInfo(BlStBalanceDTO[] miInfoList, String dt_b, String dt_e,String enttp) throws BizException{
		GetHpExitInfoBp bp = new GetHpExitInfoBp();
		return bp.exec(miInfoList, dt_b, dt_e,enttp);
	}
	
	/**
	 * 获取住院处方明细
	 * @param condition:查询条件
	 * @return
	 * @throws BizException
	 */
	@Override
	public IpBillItmUploadHpDTO[] getIpBillItmArrByCond(String condition,String orderBy,FBoolean isUpload) throws BizException {
		GetIpBillItemDtosUnEntBP handlerBp=new GetIpBillItemDtosUnEntBP();
		return handlerBp.exec(condition , orderBy, isUpload);
	}
	
	/**
	 * 获取住院记账明细集合的就诊患者
	 * @author : hanjq 2019年7月30日 上午11:04:28
	 * @param condition
	 * @param orderBy
	 * @param isUpload
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatiVisitDO[] getHpPatiVisitDOs(String condition, String orderBy, FBoolean isUpload) throws BizException {
		GetHpPatiVisitBP bp = new GetHpPatiVisitBP();
		return bp.exec(condition,orderBy,isUpload);
	}
	
	/**
	 * 分页获取医保住院记账明细
	 * @author : hanjq 2019年7月30日 下午1:20:45
	 * @param wherePart:查询条件
	 * @param orderBy:排序
	 * @param isUpload:是否已经上传
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<IpBillItmUploadHpDTO> getHpIpInHosBillsByPage(FMap2 map, PaginationInfo pg) throws BizException {
		GetHpIpInHosBillsByPageBP bp = new GetHpIpInHosBillsByPageBP();
		String wherePart = (String) map.get("wherePart");
		String orderBy = (String) map.get("orderBy");		
		FBoolean isUpload = (FBoolean) map.get("isUpload");
		String uploadMode = (String) map.get("uploadMode");
		//FBoolean isUpload = ("N").equals(map.get("isUpload")) ? FBoolean.FALSE : FBoolean.TRUE ;
		return bp.exec(wherePart, orderBy,isUpload,pg,uploadMode);
	}
	/**
	 * 判断患者是否是贫困患者
	 * @param id_code 
	 * @return  FBoolean.TRUE：是贫困患者；
	 *          FBoolean.FALSE：不是贫困患者
	 * @throws BizException
	 */
	
	public FBoolean checkPiPatPoor(String id_code) throws BizException {
		CheckPiPatPoorBP bp = new CheckPiPatPoorBP();
		return bp.exec(id_code);
	}

	

}
