package iih.bl.hp.i;

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
import iih.bl.hp.rural.dto.d.RuralPersonInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 费用医保查询服务
 * @author yankan
 * @since 2017-06-15
 *
 */
public interface IBlHpQryService {
	/**
	 * 获取可用医保业务周期号
	 * 
	 * @param empId
	 * @return
	 * @throws BizException
	 * @author
	 */
	public abstract String getHpBizCode(String empId) throws BizException;

	/**
	 * 获取操作员签到记录
	 * 
	 * @param pg
	 *            分页对象
	 * @param whereCond
	 *            查询条件
	 * @return 签到记录集合
	 * @throws BizException
	 * @author
	 */
	public abstract PagingRtnData<HpSignInDO> getHpSignList(PaginationInfo pg, String whereCond) throws BizException;

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
	public abstract PagingRtnData<EntBasicInfoDTO> getEntList(QryRootNodeDTO qryNode,PaginationInfo pg) throws BizException;

	/**
	 * 通过某次就诊的就诊号code_ent查询获得其对应的门诊单据信息列表
	 * 
	 * @param code_ent
	 *            就诊号
	 * @return 单据信息集合
	 * @throws BizException
	 * @author li_pengying
	 */
	public abstract BillInfoDTO[] getOepBillInfoByCode(String code_ent) throws BizException;
	
	/**
	 * 通过某次就诊的就诊号code_ent查询获得其对应的住院单据信息列表
	 * 
	 * @param code_ent
	 *            就诊号
	 * @return 单据信息集合
	 * @throws BizException
	 * @author liwq
	 */
	public abstract BillInfoDTO[] getIpBillInfoByCode(String code_ent) throws BizException;
	/**
	 * 门诊医疗费用汇总对账
	 *
	 * @param id_emp
	 * @return
	 * @throws BizException
	 * @author liwq
	 * @since 2017-7-14 14:32:47
	 */
	public HpFeeSumDTO[] getOepFeeSummary(String id_emp) throws BizException;
	
	/**
	 * 住院医疗费用汇总对账
	 *
	 * @param id_emp
	 * @return
	 * @throws BizException
	 * @author liwq
	 * @since 2017-7-14 14:32:47
	 */
	public HpFeeSumDTO[] getIpFeeSummary(String id_emp) throws BizException;

	/**
	 * （东软）医保结算信息查询
	 * 
	 * @return
	 * @throws BizException
	 */
	public HpFeeSumDTO[] getSettledInfos(String whereCond, String code_enttp) throws BizException;

	/**
	 * 查询得到医师信息列表
	 * 
	 * @param qryNode
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DocInfoDTO> getDocsList(QryRootNodeDTO qryNode, PaginationInfo pg) throws BizException;

	/**
	 * @param strIdEnt
	 *            就诊Id主键
	 * @return 结算信息
	 * @throws BizException
	 */
	public abstract AccountCheckDTO[] getEntIpStInfo(String strIdEnt) throws BizException;

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
	public PresDetailsUploadDTO[] getDetailsUploadDTOsToOep(String patid, String entid) throws BizException;

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
	public PresDetailsUploadDTO[] getDetailsUploadDTOsToIp(String patid, String entid) throws BizException;
	
	
	/**
	 * 获取住院记账明细集合
	 * @param strIdEnt 住院就诊主键
	 * @return 住院明细集合
	 * @throws BizException
	 */
	public IpBillItmUploadHpDTO[] getIpBillItmArr(String strIdEnt,String ipStId,FBoolean isUpload) throws BizException;
	
	/**
	 * 获取住院记账明细集合-限定记账id
	 * @param strIdEnt
	 * @param ipStId
	 * @param isUpload
	 * @return
	 * @throws BizException
	 */
	public IpBillItmUploadHpDTO[] getIpBillItmByIdCgIps(String strIdEnt,String ipStId,String[] idCgIps,FBoolean isUpload) throws BizException;
	/**
	 * 获取住院处方明细（分页查询）
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
	public PagingRtnData<IpBillItmUploadHpDTO> getIpBillItmArrPage(QryRootNodeDTO qryRootNodeDto, String strIdEnt, String ipStId,
			FBoolean isUpload, PaginationInfo pg) throws BizException;
	
	/**
	 * 获取住院处方明细（分页查询）
	 * @author zhang.hw >> xy.zhou 
	 * @date 2019年4月29日
	 * @param strIdEnt
	 * @param ipStId
	 * @param isUpload
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<IpBillItmUploadHpDTO> getIpBillItmArrPage2( String strIdEnt, String ipStId,
			FBoolean isUpload, PaginationInfo pg) throws BizException;
	
	/**
	 * 获取住院记账明细集合
	 * @author : hanjq 2019年7月30日 上午11:02:29
	 * @param condition
	 * @param orderBy
	 * @param isUpload
	 * @return
	 * @throws BizException
	 */
	public IpBillItmUploadHpDTO[] getIpBillItmArrByCond(String condition,String orderBy,FBoolean isUpload) throws BizException;
	
	
	/**
	 * 获取住院记账明细集合(分页)
	 * @param strIdEnt 住院就诊主键
	 * @return 住院明细集合
	 * @throws BizException
	 */
	public PagingRtnData<IpBillItmUploadHpDTO> getIpBillItmArrByPage(String strIdEnt,String ipStId,FBoolean isUpload,PaginationInfo pg) throws BizException;
	
	/**
	 * 获取医保出院登记就诊信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author liwq 
	 */
	public OutHospitalRegDTO[] getOutHospReg(String id_ent) throws BizException;

	 
	/**
	 * 获取医保登记表（门诊/住院）
	 * @author yangyang
	 * @review liwq 根据患者id 查询医保登记表中异常数据
	 */
	public HpExceptionInfoDTO[] getTransDetailDtoArr(String strIdPat) throws BizException;
	
	/**
	 * 医保结算交易查询
	 * @author liwq 
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<HpPatiSettledDTO> getHpTransPageInfo(QryRootNodeDTO qryRootNodeDTO, PaginationInfo pg) throws BizException;
	
	/**
	 * 医保结算交易费用明细查询
	 * @param  结算id和就诊类型code组合map
	 * @author liwq 
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<SettledDetailDTO> getSettledDetailInfo(FMap map, PaginationInfo pg) throws BizException;
	
	/** 
	 * 获取导出CSV的患者交易信息
	 * @param  
	 * @author liwq 
	 * @return
	 * @throws BizException
	 */
	public HpPatiSettledDTO[] getHpPatiTransInfo(QryRootNodeDTO qryRootNodeDTO) throws BizException;
	
	/**
	 * 医保患者是否进行过医保的中途结算
	 * @param idEnt
	 * @return
	 * @throws BizException
	 * @author liwq
	 */
	public FBoolean hasHalfSettled(String idEnt) throws BizException;
	
	/**
	 * 获取医保入参交易流水号
	 */
	public String getHpRegisterCode() throws BizException;
	
	/**
	 * 单独进行医保结算撤销(安徽),查询医保结算撤销条件
	 * @author liwq
	 */
	public CostSettlementQueryDTO getHpSettledInputCond(String idStIp) throws BizException;

	/**
	 * 检索是否有明细费用上传至医保中心
	 * @author liwq
	 */
	public FBoolean checkHpFeeStates(String idEnt) throws BizException;
	
	/**
	 * 获取医保结算单信息
	 * @author liwq
	 */
	public HpSettledReportDTO[] getSettledReportInfo(QryRootNodeDTO qryNode) throws BizException;
	
	/**
	 * 查询医保患者在院就诊信息
	 * @author liwq
	 */
	public HpPatiEntDTO[] getInHospHpPatiEntInfo(QryRootNodeDTO qryRootNodeDTO) throws BizException;	

	/**
	 * 医保结算成功HIS失败时，撤销医保交易所用（医保结算撤销节点）
	 * @author liwq
	 */
	public CostSettlementQueryDTO getHpSettledException(String id_ent) throws BizException;
	/**
	 * 获取门诊零挂上传XML
	 * @param entIdMap【key:entId，value: FDateTime】
	 * @param personType 医保患者类型
	 * @return FMap，【key:entId，value: xml字符串】
	 * @throws BizException
	 * @author yang.lu
	 */
	public abstract FMap getOpZeroRegUploadXml(FMap entIdMap, String personType) throws BizException;
	
	/**
	 * 获取就诊信息
	 * @param strIdEnt
	 * @return
	 * @throws BizException
	 */
	public abstract RuralPersonInfoDTO getRuralPersonInfo(String strIdEnt) throws BizException;

	/**
	 * 住院收付款/退费时，异常处理
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author liwq
	 */
	public abstract HpExceptionInfoDTO getHpExceptionInfo(String id_ent) throws BizException;
	/**
	 * 住院/门诊医保交易记录
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract HpIpOepTransDTO[] getHpTransAct(String id_pat) throws BizException;

	/**
	 * 获取医保结算HIS有医保无的数据
	 * @param miInfoList
	 * @param dt_b
	 * @param dt_e
	 * @return
	 * @throws BizException 
	 */
	public abstract BlStBalanceDTO[] getHpStHisExitInfo(BlStBalanceDTO[] miInfoList,String dt_b,String dt_e,String enttp) throws BizException;
	
	/**
	 * 获取医保有HIS无的信息
	 * @return
	 * @throws BizException
	 */
	public abstract BlStBalanceDTO[] getHpExitInfo(BlStBalanceDTO[] miInfoList, String dt_b, String dt_e,String enttp) throws BizException;
	

	/**
	 * 获取住院记账明细集合的就诊患者
	 * @author : hanjq 2019年7月30日 上午11:01:50
	 * @param condition
	 * @param orderBy
	 * @param isUpload
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO [] getHpPatiVisitDOs(String condition,String orderBy,FBoolean isUpload)  throws BizException;
	
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
	public PagingRtnData<IpBillItmUploadHpDTO> getHpIpInHosBillsByPage(FMap2 map, PaginationInfo pg) throws BizException;
	
	/**
	 * 判断患者是否是贫困患者
	 * @param id_code 身份证号码
	 * @return  FBoolean.TRUE：是贫困患者；
	 *          FBoolean.FALSE：不是贫困患者
	 * @throws BizException
	 */
	public abstract FBoolean checkPiPatPoor(String id_code) throws BizException;
	
}
