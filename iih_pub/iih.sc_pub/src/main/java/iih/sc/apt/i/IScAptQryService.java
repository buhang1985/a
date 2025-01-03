package iih.sc.apt.i;

import iih.bd.res.bed.d.BedAttrDTO;
import iih.bd.res.bed.d.BedDTO;
import iih.sc.apt.aptoptemp.d.ScAptOptEmpDO;
import iih.sc.apt.dto.d.AptDto;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.AptIpQrySchmDTO;
import iih.sc.apt.dto.d.AptMtListDto;
import iih.sc.apt.dto.d.AptOralDTO;
import iih.sc.apt.dto.d.BedQrySchmDTO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.dto.d.MtaptcfmDTO;
import iih.sc.apt.dto.d.OpAptDetailDTO;
import iih.sc.apt.dto.d.OpAptQryDTO;
import iih.sc.apt.dto.d.OralAptMgrDTO;
import iih.sc.apt.dto.d.OtAppDTO;
import iih.sc.apt.dto.d.ScAptMtDto;
import iih.sc.apt.opt.d.OptAptApplDTO;
import iih.sc.apt.scaptmgr.d.ScaptmgrDTO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.devcfg.paramset.d.ParamSetDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 预约服务接口
 * 
 * @author yank
 *
 */
public interface IScAptQryService {
	// ===================住院====================================//
	/***
	 * 获取人员所属业务组管理病区
	 * @author fanlq 
	 * @return
	 * @throws BizException
	 */
	String[] getIpEmpMngNur() throws BizException;
	/**
	 * 根据业务线，查询病区的科室集合 业务线暂时没有，临时放在这里，后续迁移
	 * 
	 * @param depId 科室或病区id
	 * @return
	 * @throws BizException
	 */
	DeptDO[] getDepListByDepl(String depId, String deplrole) throws BizException;
	/**
	 * 获取住院预约申请单列表
	 * 
	 * @param qrySchmDTO 查询模板
	 * @return 住院预约DTO集合
	 * @throws BizException
	 */
	PagingRtnData<AptIpDTO> getIpAptListBySchm(AptIpQrySchmDTO qrySchmDTO,PaginationInfo pg) throws BizException;
	/**
	 * 获取住院预约申请单列表-(不分页)
	 * 
	 * @param qrySchmDTO 查询模板
	 * @return 住院预约DTO集合
	 * @throws BizException
	 */
	AptIpDTO[] getIpAptListBySchmNoPag(AptIpQrySchmDTO qrySchmDTO) throws BizException;
	/**
	 * 查询住院预约申请单总数
	 * 
	 * @param qrySchmDTO 查询模板
	 * @return 数量总数
	 * @throws BizException
	 */
	Integer getIpAptCountBySchm(AptIpQrySchmDTO qrySchmDTO) throws BizException;

	/**
	 * 查询床位信息 需要床位信息、就诊、预约信息，所以将服务放这里
	 * 
	 * @param qrySchmDTO 查询模板
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<BedDTO> findByPageInfo(BedQrySchmDTO qrySchmDTO, PaginationInfo pageInfo, String id_dep)
			throws BizException;

	/**
	 * 查询床位信息 需要床位信息、就诊、预约信息
	 * 
	 * @param pg
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BedDTO> getBedInfoByWherePart(PaginationInfo pg, BedQrySchmDTO qrySchmDTO) throws BizException;

	/**
	 * 获取床位的特征集合
	 * 
	 * @param bedId 床位id
	 * @return
	 * @throws BizException
	 */
	BedAttrDTO[] getBedsAttrList(String bedId) throws BizException;

	// ===================门诊医技====================================//

	/**
	 * 门诊预约查询
	 * 
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<OpAptDetailDTO> getOpAptByQCondAndPageInfo(OpAptQryDTO opAptQryDTO, PaginationInfo pg)
			throws BizException;

	/**
	 * 获取门诊预约所需排班使用情况数据
	 * 
	 * @param beginDate 开始时间
	 * @param endData 结束时间
	 * @param id_dep 部门id
	 * @param id_scsrv 服务id
	 * @param id_scres 资源id
	 * @param sd_sctp 排班类型编码
	 */
	List getAptOpSchData(String sd_sctp, String beginDate, String endData, String id_dep, String id_scsrv,
			String id_scres) throws BizException;

	/**
	 * 验证预约是否存在对应渠道
	 * 
	 * @param sd_scchltp 渠道编码
	 * @throws BizException
	 */
	SchedulechlDO[] valAptHaveChannel(String sd_scchltp) throws BizException;

	/**
	 * 获取门诊和医技预约管理dto
	 * 
	 * @param sql
	 * @param sctp 排班类型编码
	 * @return
	 * @throws BizException
	 */
	ScaptmgrDTO[] getAptOpAndMtMgrDto(AptDto aptDto) throws BizException;

	/**
	 * 获取医技预约所需所有数据
	 * 
	 * @param beginDate 开始时间
	 * @param endData 结束时间
	 * @param id_dep 部门id
	 * @param sd_scchltp 渠道类型编码
	 * @param id_srv 医疗服务id
	 * @return 医技预约排班情况显示数据
	 * @throws BizException
	 */
	List getAptmtSch(String beginDate, String endData, String id_dep, String sd_scchltp, String id_srv)
			throws BizException;

	/**
	 * 获取资源已预约列表数据
	 * 
	 * @param id_sch 排班id
	 * @return
	 * @throws BizException
	 */
	AptMtListDto[] getAptMtResources(String id_sch) throws BizException;

	/**
	 * 获取已预约列表
	 * 
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @param id_dep 部门id
	 * @param sd_entp 就诊类型串
	 * @return
	 * @throws BizException
	 */
	List getAptMtHaveAptList(FDate beginDate, FDate endDate, String id_dep, String sd_entp) throws BizException;

	/**
	 * 获取病人预约安排dto
	 * 
	 * @param id_ent 患者id
	 * @return
	 * @throws BizException
	 */
	ScAptMtDto[] getAptMtPatInfo(String id_ent) throws BizException;

	/**
	 * 验证患者在一个排班有没有预约
	 * 
	 * @param id_pat 患者id
	 * @param id_sch 排班id
	 * @throws BizException
	 */
	void valPatSchHaveApt(String id_pat, String id_sch) throws BizException;

	/**
	 * 校验床位特征
	 * 
	 * @param aptDTO 住院申请DTO
	 * @param bedDTO 床位DTO
	 * @return
	 * @throws BizException
	 */
	Boolean validateBedAttr(AptIpDTO aptDTO, BedDTO bedDTO) throws BizException;

	/**
	 * 查询某科室的业务线病区
	 * 
	 * @param id_dep 科室id
	 * @return 病区
	 * @throws BizException
	 */
	String getDeplNurList(String id_dep) throws BizException;

	/*********************** begin 医技预约（重量级）beigin ***********************/
	/**
	 * 查询医技预约信息
	 * 
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	MtAppDTO[] getMtAppList(MtAppQryDTO qryDTO,String code_sctp) throws BizException;

	/**
	 * 根据申请单 查询患者预约信息
	 * 
	 * @param appNO 申请单号
	 * @return
	 * @throws BizException
	 */
	MtAppDTO getMtApp(String appNO) throws BizException;

	/**
	 * 根据申请单号查询待预约 已预约
	 * 
	 * @param MtAppQryDTO 
	 * @return
	 * @throws BizException
	 */
	MtAppDTO getMtAppByApplyNo(MtAppQryDTO qryDTO) throws BizException;
	/**
	 * 查询医技排班信息
	 * 
	 * @param fdate 日期
	 * @param depId 执行科室
	 * @return
	 * @throws BizException
	 */
	MtResDTO[] getMtResList(MtAppQryDTO qryDTO,String code_sctp) throws BizException;

	/**
	 * 查询医技排班信息定位到可预约日期
	 * 
	 * @param fdate 日期
	 * @param depId 执行科室
	 * @return
	 * @throws BizException
	 */
	MtResDTO[] getMtResList4AutoLocate(MtAppQryDTO qryDTO,MtAppDTO appDTO,String code_sctp) throws BizException;
	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	MtResDTO[] getMtAptSchDatasByDate(MtAppQryDTO qryDTO,FDate time) throws BizException;
	/**
	 * 获取医技中心预约病人预约安排
	 * 
	 * @param patId
	 * @param deptId
	 * @return
	 * @throws BizException
	 */
	MtAppDTO[] getPatMtApt(String patId, String deptId, String code_sctp) throws BizException;

	/**
	 * 获取资源已预约列表数据
	 * 
	 * @param schId 排班id
	 * @return
	 * @throws BizException
	 */
	MtAppDTO[] getMtAptResources(String schId) throws BizException;

	/**
	 * 获取选号预约时可用号位或号段
	 *
	 * @param id_sch
	 * @param id_srv
	 * @param id_scchl
	 * @param id_enttp
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	FArrayList getMtAptSchTicks(String id_sch, String id_srv, String id_scchl) throws BizException;
	
	/**
	 * 获取选号预约时可用号位或号段
	 * @param id_sch 排班id
	 * @param id_srv 申请单服务id
	 * @param id_scchl 渠道id
	 * @param id_enttp 就诊类型id
	 * @param id_pat 患者id
	 * @param id_ent 就诊id
	 * @param d_sch 排班日期
	 * @param fg_hp 医保支付标识
	 * @return
	 * @throws BizException
	 * @author yzh
	 */
	FArrayList getMtAptSchTicks8Filter(String id_sch, String id_srv, String id_scchl,String id_enttp,String id_pat,String id_ent,FDate d_sch,FBoolean fg_hp) throws BizException;

	/**
	 * 获取口腔预约打印的打印机
	 *
	 * @author fanlq
	 * 
	 * @return
	 * @throws BizException
	 */
	public ParamSetDO getApplyPrinter() throws BizException;
	/*********************** end 医技预约（重量级）end ***********************/

	/*********************** 门诊预约（重量级） ***********************/
	/**
	 * 门诊预约排班信息查询
	 * 
	 * @param opAptQryDto
	 * @return
	 * @throws BizException
	 */
	MtResDTO[] getOpRes(OpAptQryDTO opAptQryDto) throws BizException;

	/**
	 * 查询患者已预约信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	MtAppDTO[] getPatOpApt(String patId) throws BizException;

	/**
	 * 查询预约门诊排班科室
	 *
	 * @param benId 分诊台Id
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	DeptDO[] getOpSchDept(String benId) throws BizException;

	/**
	 * 获取门诊选号预约时可用号位或号段
	 *
	 * @param id_sch
	 * @param sd_tickmd
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	FArrayList getOpAptSchTicks(String id_sch, String id_scchl) throws BizException;

	/**
	 * 预约打印检查
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt
	 * @throws BizException
	 */
	public void checkAptPrint(String id_apt) throws BizException;

	/*********************** end 门诊预约（重量级）end ***********************/

	// ===================口腔====================================//
	/**
	 * 获取患者口腔预约列表
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	AptOralDTO[] getPatsOralAptList(String patId) throws BizException;

	/**
	 * 获取口腔科排班号源，如果已预约，包含预约信息
	 * 
	 * @param deptId 科室ID
	 * @param docIds 医生ID集合
	 * @param roomName 诊间名称
	 * @param beginDate 开始日期
	 * @param endDate 截止日期
	 * @return
	 * @throws BizException
	 */
	FMap getOralSchTick(String deptId, String[] docIds, String roomName, FDate beginDate, FDate endDate,
			String codeChl, FBoolean isShowAddTick) throws BizException;

	/**
	 * 获取口腔预约详情
	 * 
	 * @param aptId 预约ID
	 * @return
	 * @throws BizException
	 */
	AptOralDTO getOralAptInfo(String aptId) throws BizException;

	/**
	 * 获取口腔科预约加载数据
	 *
	 * @param id_dept 科室id
	 * @param sd_sctp 排班类型编码
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	FMap getOralAptLoadDatas(String id_dept, String sd_sctp) throws BizException;

	/**
	 * 获取口腔科预约患者标签信息
	 *
	 * @param patId 患者id
	 * @return 患者标签信息字符串
	 * @throws BizException
	 * @author zhengcm
	 */
	String getOralAptPatTagInfo(String patId) throws BizException;

	/**
	 * 获取口腔预约患者标签和不良记录数据
	 *
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	FMap getOralAptPatTagDatas(String patId) throws BizException;

	/**
	 * 获取科室默认排班计划
	 *
	 * @param deptId
	 * @param psnId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	ScPlanDO getOralDefaultPlan(String deptId, String psnId) throws BizException;

	/**
	 * 根据科室获取科室参数
	 *
	 * @param id_dept
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	ScdeptparamAggDO[] getDeptParamList(String id_dept, String sd_sctp) throws BizException;

	/**
	 * 获取渠道最大可预约日期
	 *
	 * @param sd_scchltp
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	FDate getChlMaxAptDate(String sd_scchltp, String sd_sctp) throws BizException;

	/**
	 * 获取口腔预约列表
	 * 
	 * @param pg 分页对象
	 * @param qryDTO 查询方案
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<OralAptMgrDTO> getOralAptList(PaginationInfo pg, QryRootNodeDTO qryDTO) throws BizException;

	/**
	 * 查询口腔预约号源池剩余数量
	 *
	 * @param oralAptDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	int queryQuanCanUse(AptOralDTO oralAptDTO) throws BizException;

	/**
	 * 校验口腔预约状态
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt
	 * @throws BizException
	 */
	public void checkOralAptStatus(String id_apt) throws BizException;

	/**
	 * 检查申请单已经预约
	 * 
	 * @param appCode 申请单号
	 * @return FBoolean
	 * @throws BizException
	 * @author zcm
	 */
	FBoolean hasMtApt(String appCode) throws BizException;

	/**
	 * 获取口腔预约打印的打印机
	 *
	 * @author zhengcm
	 * 
	 * @return
	 * @throws BizException
	 */
	public ParamSetDO GetOralPrinter() throws BizException;

	/**
	 * 获取医技预约告知单打印的打印机
	 *
	 * @author yzh
	 * 
	 * @return
	 * @throws BizException
	 */
	public ParamSetDO GetMtNoticePrinter() throws BizException;
	
	/**
	 * 根据取消预约时间检查是否允许退号
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt
	 * @return
	 * @throws BizException
	 */
	public FBoolean checkCancOpApt(String id_apt) throws BizException;

	/**
	 * 解析口腔预约查询方案
	 * 
	 * @author zhengcm
	 * @date 2017-12-05 12:02:00
	 *
	 * @param queryNode
	 * @return
	 * @throws BizException
	 */
	public String analysisOralQueryScheme(QryRootNodeDTO queryNode) throws BizException;

	/**
	 * 获取渠道配置是否配置有“短信”
	 * 
	 * @author zhengcm
	 * @date 2017-12-26 14:00:55
	 *
	 * @return
	 * @throws BizException
	 */
	public Boolean getMsgConfigIsOpen() throws BizException;

	/**
	 * 查询排班计划号别（包括备选）
	 * 
	 * @author zhengcm
	 *
	 * @param id_scpl
	 * @return
	 * @throws BizException
	 */
	public FArrayList getPlanScsrv(String id_scpl) throws BizException;

	/**
	 * 查询手术申请单（患者ID与医嘱ID互斥）
	 * 
	 * @author zhengcm
	 *
	 * @param id_pat 患者ID
	 * @param id_or 医嘱ID
	 * @return
	 * @throws BizException
	 */
	public MtAppDTO[] getOptApp(String id_pat, String id_or) throws BizException;

	/**
	 * 查询手术患者已预约信息
	 * 
	 * @author zhengcm
	 *
	 * @param id_pat 患者
	 * @return
	 * @throws BizException
	 */
	public MtAppDTO[] getOptPatApted(String id_pat) throws BizException;

	/**
	 * 查询手术排班资源已预约信息
	 * 
	 * @author zhengcm
	 *
	 * @param id_sch 排班
	 * @return
	 * @throws BizException
	 */
	public MtAppDTO[] getOptResApted(String id_sch) throws BizException;

	/**
	 * 获取手术排班号位
	 * 
	 * @author zhengcm
	 *
	 * @param id_sch
	 * @param id_srv
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	public FArrayList getOptAptSchTicks(String id_sch, String id_srv, String id_scchl) throws BizException;
	
	/**
	 * 获取手术申请单
	 * @param id_dep_mp 执行科室id
	 * @return
	 * @throws BizException
	 */
	public MtAppDTO[] getOptAppl(MtAppQryDTO appDTO, FBoolean undoneApt, FBoolean doneApt)throws BizException;
	
	/**
	 * 获取手术申请单   自定义查询条件
	 * @param appDTO
	 * @param where
	 * @return
	 */
	public MtAppDTO[] getOptApplByPat(MtAppQryDTO appDTO, String where) throws BizException;
	
	/**
	 * 科室手术审批
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<OptAptApplDTO> getOptDepApr(OptAptApplDTO qryDTO, PaginationInfo pg) throws BizException;
	
	/**
	 * 获取手术人员
	 * @param appDTO
	 * @return
	 * @throws BizException
	 */
	public ScAptOptEmpDO[] getOptAptOper(MtAppDTO appDTO)throws BizException;
	
	/**
	 * 手术预约   查询手工预约记录
	 * @param id_pi  患者id
	 * @return
	 */
	public PagingRtnData<OtAppDTO> getOtApplByEnaptmd(String id_pi, PaginationInfo pg) throws BizException;
	
	/**
	 *获取医技预约记录 
	 * 
	 * @param pg
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
    PagingRtnData<MtaptcfmDTO> getMtaptcfmInfo(PaginationInfo pg, QryRootNodeDTO qryDTO) throws BizException;
    
    /**
     * 查询医技预约打印模板
     * @param mtAppDTO
     * @return
     */
    String getMtaptPrintReportXml(MtAppDTO mtAppDTO)throws DAException;
    
    /**
     * 预约票号修改后发送事件
     * @param ids_scapt
     * @throws DAException
     */
    void sendChangeOptApt4Or(String ids_scapt)throws BizException;
    
    /**
     * 预约确认后  是否自动打印和自动拍照
     * @param id_apt
     * @return
     * @throws BizException
     */
    MtResDTO getDepPrintAndPhoto(String id_apt)throws BizException;
    
    /**
	 * 手术、医技预约查询
	 * 
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<OpAptDetailDTO> getMtOtAptByQCondAndPageInfo(OpAptQryDTO opAptQryDTO, PaginationInfo pg)
			throws BizException;
	/**
	 * 根据排班分类和执行科室医技预约记录开始时间判断当前属于正常退约 or 限制时间退约 or 爽约
	 * @param id_scca
	 * @param id_dep_mp
	 * @param id_apt
	 * @return
	 * @throws BizException
	 */
	String getCancMtAptType(String id_scca,String id_dep_mp,String id_apt)throws BizException;
}
