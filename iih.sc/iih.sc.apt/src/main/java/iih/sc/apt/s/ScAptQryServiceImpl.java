package iih.sc.apt.s;

import java.util.List;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.bed.d.BedAttrDTO;
import iih.bd.res.bed.d.BedDTO;
import iih.en.pv.i.IEnOutQryService;
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
import iih.sc.apt.i.IScAptQryService;
import iih.sc.apt.opt.d.OptAptApplDTO;
import iih.sc.apt.s.bp.CancelAptTimeCheckBP;
import iih.sc.apt.s.bp.CheckAptPrintBP;
import iih.sc.apt.s.bp.GetAptChlMaxDateBP;
import iih.sc.apt.s.bp.GetAptMtHaveAptListBp;
import iih.sc.apt.s.bp.GetAptMtPatInfoBp;
import iih.sc.apt.s.bp.GetAptMtResourcesBP;
import iih.sc.apt.s.bp.GetAptOpAndMtMgrDtoBp;
import iih.sc.apt.s.bp.GetAptOpSchListBP;
import iih.sc.apt.s.bp.GetAptSchTicksBP;
import iih.sc.apt.s.bp.GetAptmtSchBp;
import iih.sc.apt.s.bp.GetDepPrintAndPhotoBP;
import iih.sc.apt.s.bp.GetDeplNurBp;
import iih.sc.apt.s.bp.GetMtAptSchDatasByDateBP;
import iih.sc.apt.s.bp.GetMtOtAptByQCondAndPageInfoBP;
import iih.sc.apt.s.bp.GetMtaptPrintReportXmlBP;
import iih.sc.apt.s.bp.GetMtaptcfmInfoBP;
import iih.sc.apt.s.bp.GetOptApplBP;
import iih.sc.apt.s.bp.GetOptApplByPatBP;
import iih.sc.apt.s.bp.GetOptAptOperBP;
import iih.sc.apt.s.bp.GetOptDepAprByPageInfoBP;
import iih.sc.apt.s.bp.GetOtApplByEnaptmdBP;
import iih.sc.apt.s.bp.GetPlanScsrvBP;
import iih.sc.apt.s.bp.SendChangeOptApt4OrBP;
import iih.sc.apt.s.bp.ValAptHaveChannelBp;
import iih.sc.apt.s.bp.ValPatSchHaveAptBp;
import iih.sc.apt.s.bp.ip.AptBedAttrBP;
import iih.sc.apt.s.bp.ip.GetBedInfoByWherePartBP;
import iih.sc.apt.s.bp.ip.GetBedListBP;
import iih.sc.apt.s.bp.ip.GetBedsAttrListBP;
import iih.sc.apt.s.bp.ip.GetIpAptCountBySchmBP;
import iih.sc.apt.s.bp.ip.GetIpAptListBySchmBP;
import iih.sc.apt.s.bp.ip.GetIpEmpMngNurBP;
import iih.sc.apt.s.bp.mt.CheckHasMtAptBP;
import iih.sc.apt.s.bp.mt.GetMtAppBP;
import iih.sc.apt.s.bp.mt.GetMtAppByApplyNoBP;
import iih.sc.apt.s.bp.mt.GetMtAppListBP;
import iih.sc.apt.s.bp.mt.GetMtAptResourcesBP;
import iih.sc.apt.s.bp.mt.GetApplyPrinterBP;
import iih.sc.apt.s.bp.mt.GetCancMtAptTypeBP;
import iih.sc.apt.s.bp.mt.GetPatMtAptBP;
import iih.sc.apt.s.bp.mt.apt.GetAptSchTicksNewBP;
import iih.sc.apt.s.bp.mt.apt.GetMtResList4AutoLocateNewBP;
import iih.sc.apt.s.bp.mt.apt.GetMtResListNewBP;
import iih.sc.apt.s.bp.op.qry.GetOpAptByQCondAndPageInfoBP;
import iih.sc.apt.s.bp.op.qry.GetOpResBP;
import iih.sc.apt.s.bp.op.qry.GetOpSchDeptBP;
import iih.sc.apt.s.bp.op.qry.GetPatOpAptBP;
import iih.sc.apt.s.bp.opt.GetOptAppBP;
import iih.sc.apt.s.bp.opt.GetOptPatAptedBP;
import iih.sc.apt.s.bp.opt.GetOptResAptedBP;
import iih.sc.apt.s.bp.oral.CheckOralAptStatusBP;
import iih.sc.apt.s.bp.oral.GetMtNoticePrinterBP;
import iih.sc.apt.s.bp.oral.GetOralAptBP;
import iih.sc.apt.s.bp.oral.GetOralAptInfoBP;
import iih.sc.apt.s.bp.oral.GetOralAptListBP;
import iih.sc.apt.s.bp.oral.GetOralAptLoadDataBP;
import iih.sc.apt.s.bp.oral.GetOralAptPatTagDatasBP;
import iih.sc.apt.s.bp.oral.GetOralAptPatTagInfoBP;
import iih.sc.apt.s.bp.oral.GetOralAptQuanCanUseBP;
import iih.sc.apt.s.bp.oral.GetOralDefaultPlanBP;
import iih.sc.apt.s.bp.oral.GetOralPatAptBP;
import iih.sc.apt.s.bp.oral.GetOralPrinterBP;
import iih.sc.apt.scaptmgr.d.ScaptmgrDTO;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.lui.message.messageconfig.i.SendMessageService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
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
@Service(serviceInterfaces = { IScAptQryService.class }, binding = Binding.JSONRPC)
public class ScAptQryServiceImpl implements IScAptQryService {
	// ===================住院====================================//
	/***
	 * 获取人员所属业务组管理病区
	 * @author fanlq 
	 * @return
	 * @throws BizException
	 */
	public String[] getIpEmpMngNur() throws BizException{
		GetIpEmpMngNurBP bp = new GetIpEmpMngNurBP();
		return bp.exec();
	}
	/**
	 * 根据业务线，查询病区的科室集合 业务线暂时没有，临时放在这里，后续迁移
	 * fanlq-2018-03-22
	 * @param depId 科室或病区id
	 * @param deplrole 病区或者部门角色
	 * @return
	 * @throws BizException
	 */
	@Override
	public DeptDO[] getDepListByDepl(String depId, String deplrole) throws BizException {
		IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
		return service.getDepListByDepl(depId, deplrole);
	}
	/**
	 * 获取住院预约申请单列表
	 * 
	 * @param qrySchmDTO 查询模板
	 * @return 住院预约DTO集合
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<AptIpDTO> getIpAptListBySchm(AptIpQrySchmDTO qrySchmDTO,PaginationInfo pg) throws BizException {
		GetIpAptListBySchmBP getBP = new GetIpAptListBySchmBP();
		return getBP.exec(qrySchmDTO,pg);
	}
	/**
	 * 获取住院预约申请单列表-(不分页)
	 * 
	 * @param qrySchmDTO 查询模板
	 * @return 住院预约DTO集合
	 * @throws BizException
	 */
	@Override
	public AptIpDTO[] getIpAptListBySchmNoPag(AptIpQrySchmDTO qrySchmDTO) throws BizException{
		GetIpAptListBySchmBP bp = new GetIpAptListBySchmBP();
		return bp.exec(qrySchmDTO);
	}
	/**
	 * 查询住院预约申请单总数
	 * 
	 * @param qrySchmDTO 查询模板
	 * @return 数量总数
	 * @throws BizException
	 */
	@Override
	public Integer getIpAptCountBySchm(AptIpQrySchmDTO qrySchmDTO) throws BizException {
		GetIpAptCountBySchmBP getBP = new GetIpAptCountBySchmBP();
		return getBP.exec(qrySchmDTO);
	}

	/**
	 * 查询床位信息
	 * 
	 * @param qrySchmDTO 查询模板
	 * @param pageInfo 页面信息
	 * @return PagingRtnData<BedDTO>
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<BedDTO> findByPageInfo(BedQrySchmDTO qrySchmDTO, PaginationInfo pageInfo, String id_dep)
			throws BizException {
		GetBedListBP bp = new GetBedListBP();
		return bp.exec(qrySchmDTO, pageInfo, id_dep);
	}

	/**
	 * 查询床位信息 需要床位信息、就诊、预约信息
	 * 
	 * @param pg
	 * @param condition
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<BedDTO> getBedInfoByWherePart(PaginationInfo pg, BedQrySchmDTO qrySchmDTO) throws BizException {
		GetBedInfoByWherePartBP bedinfoBP = new GetBedInfoByWherePartBP();
		return bedinfoBP.exec(pg, qrySchmDTO);
	}

	/**
	 * 获取床位的特征集合
	 * 
	 * @param bedId
	 * @return
	 * @throws BizException
	 */
	@Override
	public BedAttrDTO[] getBedsAttrList(String bedId) throws BizException {
		GetBedsAttrListBP getBP = new GetBedsAttrListBP();
		return getBP.exec(bedId);
	}

	// ===================门诊医技====================================//
	/**
	 * 门诊预约查询
	 * 
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<OpAptDetailDTO> getOpAptByQCondAndPageInfo(OpAptQryDTO opAptQryDTO, PaginationInfo pg)
			throws BizException {
		GetOpAptByQCondAndPageInfoBP getInfoBP = new GetOpAptByQCondAndPageInfoBP();
		return getInfoBP.exec(opAptQryDTO, pg);
	}

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
	@Override
	public List getAptOpSchData(String sd_sctp, String beginDate, String endData, String id_dep, String id_scsrv,
			String id_scres) throws BizException {
		GetAptOpSchListBP aptOpSchListBP = new GetAptOpSchListBP();
		List list = aptOpSchListBP.exec(sd_sctp, beginDate, endData, id_dep, id_scsrv, id_scres);
		return list;
	}

	/**
	 * 验证预约是否存在对应渠道
	 * 
	 * @param sd_scchltp 渠道编码
	 * @throws BizException
	 */
	@Override
	public SchedulechlDO[] valAptHaveChannel(String sd_scchltp) throws BizException {
		ValAptHaveChannelBp haveChannelBp = new ValAptHaveChannelBp();
		return haveChannelBp.exec(sd_scchltp);
	}

	/**
	 * 获取门诊和医技预约管理dto
	 * 
	 * @param sql
	 * @param sctp 排班类型编码
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScaptmgrDTO[] getAptOpAndMtMgrDto(AptDto aptDto) throws BizException {
		GetAptOpAndMtMgrDtoBp andMtMgrDtoBp = new GetAptOpAndMtMgrDtoBp();
		ScaptmgrDTO[] scaptmgrDTOs = andMtMgrDtoBp.exec(aptDto);
		return scaptmgrDTOs;
	}

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
	@Override
	public List getAptmtSch(String beginDate, String endData, String id_dep, String sd_scchltp, String id_srv)
			throws BizException {
		GetAptmtSchBp aptmtSchBp = new GetAptmtSchBp();
		List list = aptmtSchBp.exec(beginDate, endData, id_dep, sd_scchltp, id_srv);
		return list;
	}

	/**
	 * 获取资源已预约列表数据
	 * 
	 * @param id_sch 排班id
	 * @return
	 * @throws BizException
	 */
	@Override
	public AptMtListDto[] getAptMtResources(String id_sch) throws BizException {
		GetAptMtResourcesBP aptMtResourcesBP = new GetAptMtResourcesBP();
		AptMtListDto[] aptMtListDtos = aptMtResourcesBP.exec(id_sch);
		return aptMtListDtos;
	}

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
	@Override
	public List getAptMtHaveAptList(FDate beginDate, FDate endDate, String id_dep, String sd_entp) throws BizException {
		GetAptMtHaveAptListBp aptListBp = new GetAptMtHaveAptListBp();
		return aptListBp.exec(beginDate, endDate, id_dep, sd_entp);
	}

	/**
	 * 获取病人预约安排dto
	 * 
	 * @param id_ent 患者id
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScAptMtDto[] getAptMtPatInfo(String id_ent) throws BizException {
		GetAptMtPatInfoBp aptMtPatInfoBp = new GetAptMtPatInfoBp();
		return aptMtPatInfoBp.exec(id_ent);
	}

	/**
	 * 验证患者在一个排班有没有预约
	 * 
	 * @param id_pat 患者id
	 * @param id_sch 排班id
	 * @throws BizException
	 */
	@Override
	public void valPatSchHaveApt(String id_pat, String id_sch) throws BizException {
		ValPatSchHaveAptBp haveAptBp = new ValPatSchHaveAptBp();
		haveAptBp.exec(id_pat, id_sch);
	}

	/**
	 * 校验床位特征
	 * 
	 * @param aptDTO 住院申请DTO
	 * @param bedDTO 床位DTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean validateBedAttr(AptIpDTO aptDTO, BedDTO bedDTO) throws BizException {
		AptBedAttrBP bp = new AptBedAttrBP();
		return bp.exec(aptDTO, bedDTO);
	}

	/**
	 * 查询某科室的业务线病区
	 * 
	 * @param id_dep 科室id
	 * @return 病区List
	 * @throws BizException
	 */
	@Override
	public String getDeplNurList(String id_dep) throws BizException {
		GetDeplNurBp bp = new GetDeplNurBp();
		String list = bp.exec(id_dep);
		return list;
	}

	/*********************** begin 医技预约（重量级）beigin ***********************/
	/**
	 * 查询医技预约信息
	 * 
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtAppDTO[] getMtAppList(MtAppQryDTO qryDTO,String code_sctp) throws BizException {
		GetMtAppListBP getMtAppList = new GetMtAppListBP();
		return getMtAppList.exec(qryDTO,code_sctp);
	}

	/**
	 * 根据申请单 查询患者预约信息
	 * 
	 * @param appNo 申请单号
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtAppDTO getMtApp(String appNo) throws BizException {
		GetMtAppBP getMtAppBp = new GetMtAppBP();
		return getMtAppBp.exec(appNo);
	}

	/**
	 * 根据申请单 查询患者预约信息
	 * 
	 * @param appNo 申请单号
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtAppDTO getMtAppByApplyNo(MtAppQryDTO qryDTO) throws BizException {
		GetMtAppByApplyNoBP getMtAppBp = new GetMtAppByApplyNoBP();
		return getMtAppBp.exec(qryDTO);
	}
	
	/**
	 * 获取医技中心预约病人预约安排
	 * 
	 * @param entId
	 * @param deptId
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtAppDTO[] getPatMtApt(String patId, String deptId, String code_sctp) throws BizException {
		GetPatMtAptBP getPatMtApt = new GetPatMtAptBP();
		return getPatMtApt.exec(patId, deptId,code_sctp);
	}

	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtResDTO[] getMtResList(MtAppQryDTO qryDTO, String code_sctp) throws BizException {
		GetMtResListNewBP getMtResBp = new GetMtResListNewBP();
		return getMtResBp.exec(qryDTO,code_sctp);
	}
	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtResDTO[] getMtResList4AutoLocate(MtAppQryDTO qryDTO,MtAppDTO appDTO, String code_sctp) throws BizException {
		GetMtResList4AutoLocateNewBP getMtResBp = new GetMtResList4AutoLocateNewBP();
		return getMtResBp.exec(qryDTO,appDTO,code_sctp);
	}
	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtResDTO[] getMtAptSchDatasByDate(MtAppQryDTO qryDTO,FDate time) throws BizException {
		GetMtAptSchDatasByDateBP getMtResBp = new GetMtAptSchDatasByDateBP();
		return getMtResBp.exec(qryDTO,time);
	}

	/**
	 * 获取资源已预约列表数据
	 * 
	 * @param schId 排班id
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtAppDTO[] getMtAptResources(String schId) throws BizException {
		GetMtAptResourcesBP getAptReBp = new GetMtAptResourcesBP();
		return getAptReBp.exec(schId);
	}

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
	@Override
	public FArrayList getMtAptSchTicks(String id_sch, String id_srv, String id_scchl) throws BizException {
		return new GetAptSchTicksBP().exec(id_sch, id_scchl, id_srv,IScDictCodeConst.SD_SCTP_MT);
	}
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
	@Override
	public FArrayList getMtAptSchTicks8Filter(String id_sch, String id_srv, String id_scchl,String id_enttp,String id_pat,String id_ent,FDate d_sch,FBoolean fg_hp) throws BizException {
		return new GetAptSchTicksNewBP().exec(id_sch, id_scchl, id_srv, id_enttp,IScDictCodeConst.SD_SCTP_MT,id_pat,id_ent, d_sch,fg_hp);
	}
	/**
	 * 获取口腔预约打印的打印机
	 *
	 * @author fanlq
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public ParamSetDO getApplyPrinter() throws BizException{
		return new GetApplyPrinterBP().exec();
	}
	
	/*********************** end 医技预约（重量级）end ***********************/

	/*********************** 门诊预约（重量级） *******************************/

	/**
	 * 门诊预约排班信息查询
	 * 
	 * @param opAptQryDto
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtResDTO[] getOpRes(OpAptQryDTO opAptQryDto) throws BizException {
		GetOpResBP getResBP = new GetOpResBP();
		return getResBP.exec(opAptQryDto);
	}

	/**
	 * 查询患者已预约信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtAppDTO[] getPatOpApt(String patId) throws BizException {
		GetPatOpAptBP getPatOpAptBp = new GetPatOpAptBP();
		return getPatOpAptBp.exec(patId);
	}

	/**
	 * 查询预约门诊排班科室
	 *
	 * @param benId 分诊台ID
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public DeptDO[] getOpSchDept(String benId) throws BizException {
		GetOpSchDeptBP getSchBp = new GetOpSchDeptBP();
		return getSchBp.exec(benId);
	}

	/**
	 * 获取门诊选号预约时可用号位或号段
	 *
	 * @param id_sch
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public FArrayList getOpAptSchTicks(String id_sch, String id_scchl) throws BizException {
		return new GetAptSchTicksBP().exec(id_sch, id_scchl, null,IScDictCodeConst.SD_SCTP_OP);
	}

	/**
	 * 预约打印检查
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt
	 * @throws BizException
	 */
	@Override
	public void checkAptPrint(String id_apt) throws BizException {
		new CheckAptPrintBP().exec(id_apt);
	}
	
	/**
	 * 获取医技预约记录
	 * 
	 * @throws BizException
	 */
    @Override
    public PagingRtnData<MtaptcfmDTO> getMtaptcfmInfo(PaginationInfo pg, QryRootNodeDTO qryDTO) throws BizException {
        GetMtaptcfmInfoBP bp = new GetMtaptcfmInfoBP();
        return bp.exec(pg,qryDTO);
    }

	/*********************** end 门诊预约（重量级）end ***********************/

	// ===================口腔====================================//
	/**
	 * 获取患者口腔预约列表
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@Override
	public AptOralDTO[] getPatsOralAptList(String patId) throws BizException {
		return new GetOralPatAptBP().exec(patId);
	}

	/**
	 * 获取口腔科排班号源，如果已预约，包含预约信息
	 * 
	 * @param deptId 科室ID
	 * @param docIds 医生ID集合
	 * @param roomName 诊间名称
	 * @param beginDate 开始日期
	 * @param endDate 截止日期
	 * @param isShowAddTick 是否显示加号
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap getOralSchTick(String deptId, String[] docIds, String roomName, FDate beginDate, FDate endDate,
			String codeChl, FBoolean isShowAddTick) throws BizException {
		return new GetOralAptBP().exec(deptId, docIds, roomName, beginDate, endDate, codeChl, isShowAddTick);
	}

	/**
	 * 获取口腔预约详情
	 * 
	 * @param aptId 预约ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public AptOralDTO getOralAptInfo(String aptId) throws BizException {
		return new GetOralAptInfoBP().exec(aptId);
	}

	/**
	 * 获取口腔科预约加载数据
	 *
	 * @param id_dept 科室id
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public FMap getOralAptLoadDatas(String id_dept, String sd_sctp) throws BizException {
		return new GetOralAptLoadDataBP().exec(id_dept, sd_sctp);
	}

	/**
	 * 获取口腔科预约患者标签信息
	 *
	 * @param patId 患者id
	 * @return 患者标签信息字符串
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public String getOralAptPatTagInfo(String patId) throws BizException {
		return new GetOralAptPatTagInfoBP().exec(patId);
	}

	/**
	 * 获取口腔预约患者标签和不良记录数据
	 *
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public FMap getOralAptPatTagDatas(String patId) throws BizException {
		return new GetOralAptPatTagDatasBP().exec(patId);
	}

	/**
	 * 获取科室默认排班计划
	 *
	 * @param deptId
	 * @param psnId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public ScPlanDO getOralDefaultPlan(String deptId, String psnId) throws BizException {
		return new GetOralDefaultPlanBP().exec(deptId, psnId);
	}

	/**
	 * 根据科室获取科室参数
	 */
	@Override
	public ScdeptparamAggDO[] getDeptParamList(String id_dept, String sd_sctp) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_dept) || StringUtil.isEmptyWithTrim(sd_sctp)) {
			return null;
		}
		IScBdOutQryService qryService = ServiceFinder.find(IScBdOutQryService.class);
		return qryService.getDeptParamList(id_dept, sd_sctp);
	}

	/**
	 * 获取渠道最大可预约日期
	 *
	 * @param sd_scchltp
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public FDate getChlMaxAptDate(String sd_scchltp, String sd_sctp) throws BizException {
		return new GetAptChlMaxDateBP().exec(sd_scchltp, sd_sctp);
	}

	/**
	 * 获取口腔预约列表
	 * 
	 * @param pg 分页对象
	 * @param qryDTO 查询方案
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public PagingRtnData<OralAptMgrDTO> getOralAptList(PaginationInfo pg, QryRootNodeDTO qryDTO) throws BizException {
		GetOralAptListBP bp = new GetOralAptListBP();
		return bp.exec(pg, qryDTO);
	}

	/**
	 * 查询口腔预约号源池剩余数量
	 *
	 * @param oralAptDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public int queryQuanCanUse(AptOralDTO oralAptDTO) throws BizException {
		return new GetOralAptQuanCanUseBP().exec(oralAptDTO);
	}

	/**
	 * 校验口腔预约状态
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt
	 * @throws BizException
	 */
	@Override
	public void checkOralAptStatus(String id_apt) throws BizException {
		new CheckOralAptStatusBP().check(id_apt);
	}

	/**
	 * 检查申请单已经预约
	 * 
	 * @param appCode 申请单号
	 * @return FBoolean
	 * @throws BizException
	 * @author zcm
	 */
	@Override
	public FBoolean hasMtApt(String appCode) throws BizException {
		CheckHasMtAptBP checkBP = new CheckHasMtAptBP();
		return checkBP.exec(appCode);
	}

	/**
	 * 获取口腔预约打印的打印机
	 *
	 * @author zhengcm
	 * 
	 * @return 打印机名称
	 * @throws BizException
	 */
	@Override
	public ParamSetDO GetOralPrinter() throws BizException {
		return new GetOralPrinterBP().exec();
	}

	/**
	 * 获取医技预约告知单打印的打印机
	 *
	 * @author yzh
	 * 
	 * @return 打印机名称
	 * @throws BizException
	 */
	@Override
	public ParamSetDO GetMtNoticePrinter() throws BizException {
		return new GetMtNoticePrinterBP().exec();
	}
	
	/**
	 * 根据取消预约时间检查是否允许退号
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean checkCancOpApt(String id_apt) throws BizException {
		return new CancelAptTimeCheckBP().check(id_apt);
	}

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
	@Override
	public String analysisOralQueryScheme(QryRootNodeDTO queryNode) throws BizException {
		if (null == queryNode) {
			return null;
		}
		IQrySQLGeneratorService serv = ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereSql = serv.getQueryStringWithDOName(queryNode, OralAptMgrDTO.class.getName());
		return whereSql;
	}

	/**
	 * 获取渠道配置是否配置有“短信”
	 * 
	 * @author zhengcm
	 * @date 2017-12-26 14:00:55
	 *
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean getMsgConfigIsOpen() throws BizException {
		SendMessageService msgService = ServiceFinder.find(SendMessageService.class);
		return msgService.getMsgConfigIsOpen();
	}

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
	@Override
	public MtAppDTO[] getOptApp(String id_pat, String id_or) throws BizException {
		return new GetOptAppBP().exec(id_pat, id_or);
	}

	/**
	 * 查询排班计划号别（包括备选）
	 * 
	 * @author zhengcm
	 *
	 * @param id_scpl
	 * @return
	 * @throws BizException
	 */
	@Override
	public FArrayList getPlanScsrv(String id_scpl) throws BizException {
		return new GetPlanScsrvBP().exec(id_scpl);
	}

	/**
	 * 查询手术患者已预约信息
	 * 
	 * @author zhengcm
	 *
	 * @param id_pat 患者
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtAppDTO[] getOptPatApted(String id_pat) throws BizException {
		return new GetOptPatAptedBP().exec(id_pat);
	}

	/**
	 * 查询手术排班资源已预约信息
	 * 
	 * @author zhengcm
	 *
	 * @param id_sch 排班
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtAppDTO[] getOptResApted(String id_sch) throws BizException {
		return new GetOptResAptedBP().exec(id_sch);
	}

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
	@Override
	public FArrayList getOptAptSchTicks(String id_sch, String id_srv, String id_scchl) throws BizException {
		return new GetAptSchTicksBP().exec(id_sch, id_scchl, id_srv,IScDictCodeConst.SD_SCTP_OT);
	}
	
	/**
	 * 获取手术申请单
	 * @param id_dep_mp 执行科室id
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtAppDTO[] getOptAppl(MtAppQryDTO appDTO ,FBoolean undoneApt, FBoolean doneApt) throws BizException {
		return new GetOptApplBP().exec(appDTO, IScDictCodeConst.SD_SCTP_OT,undoneApt,doneApt);
	}
	
	/**
	 * 获取手术申请单   自定义条件
	 * @param id_dep_mp 执行科室id
	 * @return
	 * @throws BizException
	 */
	@Override
	public MtAppDTO[] getOptApplByPat(MtAppQryDTO appDTO, String where) throws BizException
	{
		return new GetOptApplByPatBP().exec(appDTO, IScDictCodeConst.SD_SCTP_OT,where);
	}
	
	/**
	 * 获取手术人员
	 * @param appDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScAptOptEmpDO[] getOptAptOper(MtAppDTO appDTO) throws BizException {
		return new GetOptAptOperBP().exec(appDTO);
	}
	
	/**
	 * 查询医技预约打印模板
	 * @throws DAException 
	 */
	@Override
	public String getMtaptPrintReportXml(MtAppDTO mtAppDTO) throws DAException {
		GetMtaptPrintReportXmlBP  bp = new GetMtaptPrintReportXmlBP();
		return bp.exec(mtAppDTO);
	}
	
	/**
	 * 预约票号修改后发送事件
	 * @throws BizException 
	 */
	@Override
	public void sendChangeOptApt4Or(String ids_scapt) throws BizException {
		new SendChangeOptApt4OrBP().exec(ids_scapt);
	}
	
	/**
     * 预约确认后  是否自动打印和自动拍照
     * @param id_apt
     * @return
     * @throws BizException
     */
	@Override
	public MtResDTO getDepPrintAndPhoto(String id_apt) throws BizException {
		return new GetDepPrintAndPhotoBP().exec(id_apt);
	}
	
	/**
	 * 手术、医技预约查询
	 * 
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<OpAptDetailDTO> getMtOtAptByQCondAndPageInfo(OpAptQryDTO opAptQryDTO, PaginationInfo pg)
			throws BizException {
		GetMtOtAptByQCondAndPageInfoBP getInfoBP = new GetMtOtAptByQCondAndPageInfoBP();
		return getInfoBP.exec(opAptQryDTO, pg);
	}
	
	/**
	 * 手术预约   查询手工预约记录
	 * @param id_pi  患者id
	 * @return
	 */
	@Override
	public  PagingRtnData<OtAppDTO> getOtApplByEnaptmd(String id_pi, PaginationInfo pg) throws BizException
	{
		return new GetOtApplByEnaptmdBP().exec(id_pi, pg);
	}
	
	/**
	 * 科室手术审批
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<OptAptApplDTO> getOptDepApr(OptAptApplDTO qryDTO, PaginationInfo pg) throws BizException {
		return new GetOptDepAprByPageInfoBP().exec(qryDTO,pg);
	}
	/**
	 * 根据排班分类和执行科室医技预约记录开始时间判断当前属于正常退约 or 限制时间退约 or 爽约
	 * @param id_scca
	 * @param id_dep_mp
	 * @param id_apt
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getCancMtAptType(String id_scca, String id_dep_mp, String id_apt) throws BizException {
		return new GetCancMtAptTypeBP().exec(id_scca, id_dep_mp, id_apt);
	}
}
