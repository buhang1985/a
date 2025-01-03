package iih.en.pv.s;

import iih.bd.srv.dto.d.PhySignDTO;
import iih.en.pv.dto.d.EnOperateLogDTO;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.dto.d.OutpatientQryDTO;
import iih.en.pv.dto.d.PrintRegistedInfoDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.enevtqrydto.d.EnEvtListDTO;
import iih.en.pv.enevtqrydto.d.EnEvtResultDTO;
import iih.en.pv.i.IEnOpQryService;
import iih.en.pv.outpatient.dto.d.ApptQryModDTO;
import iih.en.pv.outpatient.dto.d.OpApptDTO;
import iih.en.pv.outpatient.dto.d.OpBasic4EditDTO;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.OpUnpayAndAccDrugDTO;
import iih.en.pv.outpatient.dto.d.QueryRegInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.outpatient.dto.d.RegListDTO;
import iih.en.pv.outpatient.dto.d.RegQryDTO;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.en.pv.s.bp.EntInfoQryBP;
import iih.en.pv.s.bp.GetAccountDrugInfoBP;
import iih.en.pv.s.bp.GetAllOperateLogListBP;
import iih.en.pv.s.bp.GetEntOrPat4BannerBP;
import iih.en.pv.s.bp.GetOepUnpayDetailBP;
import iih.en.pv.s.bp.GetOperateLogListBP;
import iih.en.pv.s.bp.op.CancOpRegValidateBP;
import iih.en.pv.s.bp.op.ChangePatQry4ApptBP;
import iih.en.pv.s.bp.op.CheckHasRegedBP;
import iih.en.pv.s.bp.op.CheckIsBloodPressureBP;
import iih.en.pv.s.bp.op.CheckIsNeedPreExamBP;
import iih.en.pv.s.bp.op.CheckRegMvelBP;
import iih.en.pv.s.bp.op.EnPrnPrinterBP;
import iih.en.pv.s.bp.op.GetEnEvtQryInfoBP;
import iih.en.pv.s.bp.op.GetFirstWaitNumBP;
import iih.en.pv.s.bp.op.GetOpAgentBP;
import iih.en.pv.s.bp.op.GetOpBasicInfo4EditBP;
import iih.en.pv.s.bp.op.GetOpListBP;
import iih.en.pv.s.bp.op.GetOpRegForBannerBP;
import iih.en.pv.s.bp.op.GetOpRegListByOperBP;
import iih.en.pv.s.bp.op.GetOpRegListByPatBP;
import iih.en.pv.s.bp.op.GetOpRegOrPat4BannerBP;
import iih.en.pv.s.bp.op.GetOpRegPatBP;
import iih.en.pv.s.bp.op.GetPageRegListByOperBP;
import iih.en.pv.s.bp.op.GetPatsRegListBP;
import iih.en.pv.s.bp.op.GetRecordPriceBP;
import iih.en.pv.s.bp.op.GetRegInfoForPrintBP;
import iih.en.pv.s.bp.op.GetRegListByEntBP;
import iih.en.pv.s.bp.op.GetRegListByOperBP;
import iih.en.pv.s.bp.op.GetSetUpVipListBP;
import iih.en.pv.s.bp.op.OpApptQryBP;
import iih.en.pv.s.bp.op.st.LoadCgInfoBP;
import iih.en.pv.s.bp.op.st.LoadResPriceFromCgBP;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 门诊查询服务
 * @author yank
 *
 */
@Service(serviceInterfaces={IEnOpQryService.class}, binding=Binding.JSONRPC)
public class EnOpQryServiceImpl implements IEnOpQryService{
	/**
	 * 获取门诊挂号患者注册信息
	 * 
	 * @param patId  患者Id
	 * @param isSwingHpCad  是否是刷医保卡
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpRegPatDTO getOpRegPatByPatId(String patId, FBoolean isSwingHpCad)
			throws BizException {
		GetOpRegPatBP bp = new GetOpRegPatBP();
		return bp.exec(patId, isSwingHpCad);
	}
	/**
	 * 查询门诊预约集合
	 * @param qryMod 查询模板
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpApptDTO[] getOpApptList(ApptQryModDTO querySchema ) throws BizException{
		OpApptQryBP qryBP = new OpApptQryBP();
		return qryBP.getOpApptList(querySchema);
	}
	/**
	 * 根据患者id获取门诊就诊信息
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public OpRegDTO[] getRegByPatId(String patId) throws BizException{
		GetOpRegListByPatBP getBP = new GetOpRegListByPatBP();
		return getBP.getOpRegListByPatId(patId, null);
	}
	/**
	 * 根据就诊id查询就诊信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public OpRegDTO getRegByEntId(String entId) throws BizException{
		GetOpRegListByPatBP getBP = new GetOpRegListByPatBP();
		return getBP.getOpRegByEntId(entId);
	}
	/**
	 * 获取患者挂号信息
	 * 包含队列信息
	 * @param patId 患者id
	 * @param dayslotId 日期分组id
	 * @param date 日期
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public OpRegDTO[] getOpRegListByPat(String patId, String dayslotId, FDate date) throws BizException{
		GetOpRegListByPatBP getBP = new GetOpRegListByPatBP();
		return getBP.getOpRegListByPatId(patId, dayslotId, date, null);
	}
	
	 /** 
	  * 获取患者挂号信息
	 * 包含队列信息
	 * @param patId 患者id
	 * @param dayslotId 日期分组id
	 * @param date 日期
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public OpRegDTO[] getOpRegListByPat2(String patId, String dayslotId) throws BizException{
		GetOpRegListByPatBP getBP = new GetOpRegListByPatBP();
		return getBP.getOpRegListByPatId(patId, dayslotId, null, null);
	}
	/**
	 * 获取分诊台管理的患者挂号信息
	 * 
	 * @param patId 患者id
	 * @param benId 分诊台Id
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	@Override
	public OpRegDTO[] getOpRegByBenId(String patId, String benId) throws BizException {
		GetOpRegListByPatBP getBP = new GetOpRegListByPatBP();
		return getBP.getOpRegByBenId(patId, benId, null);
	}
	/**
	 * 分诊台Banner查询患者挂号信息
	 * 
	 * @param sqlStr banner的sql查询语句
	 * @param whereStr Banner的where语句
	 * @param benId 分诊台id
	 * @param dayslot 日期分组id
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpRegDTO[] getOpReg4Banner(String sqlStr,String whereStr, String[] selectConditions, String inputValue, TriageBenInfoDTO triageInfo) throws BizException{
		GetOpRegForBannerBP bp = new GetOpRegForBannerBP();
		return bp.exec(sqlStr, whereStr, selectConditions, inputValue, triageInfo);
	}
	/**
	 * 
	 * 门急诊医生站Banner查询就诊或患者信息
	 * 
	 * @param whereStr Banner的where语句
	 * @param inputValue Banner输入值
	 * @return
	 * @throws BizException
	 */
	@Override
	public FMap getOpRegOrPat4Banner(String whereStr, String[] selectConditions, String inputValue, EnTrDocSiteInfoDTO enSiteInfo)
			throws BizException {
		GetOpRegOrPat4BannerBP bp = new GetOpRegOrPat4BannerBP();
		return bp.exec(whereStr, selectConditions, inputValue, enSiteInfo);
	}
	/**
	 * 获取病历本价格
	 * @return
	 * @throws BizException
	 */
	@Override
	public FDouble getRecordPrice() throws BizException{
		GetRecordPriceBP getPriceBP = new GetRecordPriceBP();
		return getPriceBP.getRecordPrice();
	}
	/**
	 * 获取打印挂号条信息
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public PrintRegistedInfoDTO getRegInfoForPrint(String entId) throws BizException{
		GetRegInfoForPrintBP getBP =new GetRegInfoForPrintBP();
		return getBP.exec(entId);
	}
	/**
	 * 检索操作员当天挂号信息
	 * @param operId
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO[] getRegListByOper(String operId) throws BizException{
		GetRegListByOperBP getBP =new GetRegListByOperBP();
		return getBP.exec(operId);
	}
	/**
	 * 分页获取挂号员当天挂号信息
	 * @param pg 分页对象
	 * @param operId 挂号员ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<RegInfoDTO> getPageRegListByOper(PaginationInfo pg, QueryRegInfoDTO queryDTO) throws BizException{
		GetPageRegListByOperBP getBP = new GetPageRegListByOperBP();
		return getBP.exec(pg, queryDTO);
	}
	/**
	 * 检索患者挂号信息
	 * @param patId 患者id
	 * @param withPri　包含价格信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO[] getRegInfoByPat(String patId,FBoolean withPri) throws BizException{
		GetPatsRegListBP getBP = new GetPatsRegListBP();
		return getBP.exec(patId, withPri);
	}
	/**
	 * 检索患者挂号信息(通过挂号时间)
	 * 
	 * @param patId 患者id
	 * @param withPri 包含价格信息
	 * @param bDate 挂号开始日期
	 * @param eDate 挂号结束日期
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO[] getRegInfoByPatAndDate(String patId,FBoolean withPri, FDate bDate, FDate eDate) throws BizException{
		GetPatsRegListBP getBP = new GetPatsRegListBP();
		return getBP.exec(patId, withPri, bDate, eDate);
	}
	/**
	 * 检索患者挂号信息(通过就诊id和挂号时间)
	 * 
	 * @param patId 患者id
	 * @param withPri 包含价格信息
	 * @param bDate 挂号开始日期
	 * @param eDate 挂号结束日期
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegInfoDTO[] getRegInfoByEntAndDate(String[] entIds,FBoolean withPri, FDate bDate, FDate eDate) throws BizException{
		GetRegListByEntBP getBP = new GetRegListByEntBP();
		return getBP.exec(entIds, withPri, bDate, eDate);
	}
	/**
	 * 是否已经挂号
	 * @param patId 患者id
	 * @param schId 排班id
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean hasRegistered(String patId,String schId) throws BizException{
		CheckHasRegedBP checkBP = new CheckHasRegedBP();
		return checkBP.exec(patId, schId);
	}
	/**
	 * 加载结算价格信息
	 * @param regInfo 挂号信息
	 */
	@Override
	public RegInfoDTO loadCgPri(RegInfoDTO regInfo) throws BizException{
		LoadCgInfoBP loadCgBP = new LoadCgInfoBP();
		return loadCgBP.exec(regInfo);
	}
	/**
	 * 加载资源的结算价格
	 * @param resDTO 挂号资源
	 * @param cgId 结算id
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResDTO loadResCgPri(RegResDTO resDTO,String cgId) throws BizException{
		LoadResPriceFromCgBP loadPriBP = new LoadResPriceFromCgBP();
		return loadPriBP.exec(resDTO, cgId);
	}
	/**
	 * 门诊就诊信息查询
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public OutpatientQryDTO getOpInfo(String entId) throws BizException {
		return new EntInfoQryBP().getOpInfo(entId);
	}
	
	
	/**
	 * 是否需要预检
	 * @param entId 就诊id
	 * @param oprId 操作员id
	 * @return FBoolean
	 * @throws BizException
	 */
	@Override
	public FBoolean isNeedPreExam(String entId,String oprId) throws BizException{
		CheckIsNeedPreExamBP checkBP = new CheckIsNeedPreExamBP();
		return checkBP.exec(entId, oprId);
	}
	
	/**
	 * 预检弹框关闭规则
	 * @param entId 就诊id
	 * @param oprId 操作员id
	 * @return FBoolean
	 * @throws BizException
	 */
	@Override
	public ResultDTO isCheckBloodPressure(String entId,String oprId,PhySignDTO[] phySignDtos) throws BizException{
		CheckIsBloodPressureBP checkBP = new CheckIsBloodPressureBP();
		return checkBP.exec(entId, oprId,phySignDtos);
	}
	
	/**
	 * 规则引擎：挂号规则
	 * @param regRuleDto
	 * @return ResultDTO:{flag:true(规则全部验证通过)，false(规则验证不通过);MSG：规则验证不通过的提示信息}
	 */
	@Override
	public ResultDTO isPermitRegByMvel(RegRuleDTO regRuleDto) throws BizException{
		CheckRegMvelBP checkBP = new CheckRegMvelBP();
		return checkBP.exec(regRuleDto);
	}
	/**
	 * 规则引擎：只调用医保挂号规则
	 *
	 * 
	 * @param regRuleDto
	 * @return
	 * @throws BizException
	 */
	public ResultDTO isPermitRegHpByMvelWithApt(RegRuleDTO regRuleDto) throws BizException {
		CheckRegMvelBP bp = new CheckRegMvelBP();
		return bp.execHp(regRuleDto);
	}
	
	/**
	 * 获取门诊基本信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpBasic4EditDTO getOpBasicInfo4Edit(String entId) throws BizException{
		GetOpBasicInfo4EditBP getBP = new GetOpBasicInfo4EditBP();
		return getBP.exec(entId);
	}		
	/**
	 * 获取代办人信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpBasic4EditDTO getOpAgent(String entId) throws BizException{
		GetOpAgentBP getBP = new GetOpAgentBP();
		return getBP.exec(entId);
	}
	/**
	 * 获取就诊或者患者信息
	 * 先查就诊信息，如果就诊信息未查到再查患者信息
	 * @param condTypeList 条件类型集合
	 * @param inputValue 输入值
	 * @param wherePart 限定条件部分
	 * @return ent:就诊信息，pat:患者信息
	 * @throws BizException
	 */
	@Override
	public FMap getEntOrPat4Banner(String[] condTypeList,String inputValue,String wherePart) throws BizException{
		GetEntOrPat4BannerBP bp = new GetEntOrPat4BannerBP();
		return bp.getEntOrPat4Banner(condTypeList, inputValue, wherePart);
	}
	/**
	 * 门诊就诊查询
	 * @param qryModDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<OutpatientQryDTO> getOpList(EntQryModDTO qryModDTO, PaginationInfo pg) throws BizException {
		GetOpListBP bp = new GetOpListBP();
		return bp.exec(qryModDTO, pg);
	}
	/**
	 * 检索门诊挂号信息
	 * 
	 * @param regQry 查询条件
	 * @param pg 分页信息
	 * @return
	 * @throws BizException 
	 * @author liubin
	 */
	@Override
	public PagingRtnData<RegListDTO> getOpRegListByOper(RegQryDTO regQry, PaginationInfo pg) throws BizException {
		GetOpRegListByOperBP bp = new GetOpRegListByOperBP();
		return bp.exec(regQry, pg);
	}
	/**
	 * 根据患者id查询患者信息 - 用于换患者弹框显示
	 * 
	 * @author fanlq 2017年11月6日 下午7:34:41
	 * @param patId
	 *            -患者ID
	 * @param isSwingHpCad
	 *            -是否是刷医保卡
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpRegPatDTO[] getPatListByIdTp(String patId, FBoolean isSwingHpCad) throws BizException {
		ChangePatQry4ApptBP bp = new ChangePatQry4ApptBP();
		return bp.exec(patId, isSwingHpCad);
	}
	/**
	 * 退号校验
	 * 
	 * @param entId
	 * @throws BizException
	 */
	@Override
	public void cancOpRegValidate(String entId) throws BizException {
		CancOpRegValidateBP bp = new CancOpRegValidateBP();
		bp.exec(entId);
	}
	/**
	 * 获得本机设置的号条打印机名称
	 * 
	 * @return
	 */
	@Override
	public String getReportPrinter() throws BizException {
		EnPrnPrinterBP bp = new EnPrnPrinterBP();
		return bp.GetReportPrinter();
	}
	/***
	 * 查询登录日志
	 * 
	 * @param logQry
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<EnOperateLogDTO> getOperateLogList(PaginationInfo pg, EnOperateLogDTO nodeDTO) throws BizException{
		GetOperateLogListBP bp = new GetOperateLogListBP();
		return bp.exec(pg,nodeDTO);
	}
	/***
	 * 查询登录日志数据
	 * 
	 * @param nodeDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnOperateLogDTO[] getAllOperateLogList( EnOperateLogDTO nodeDTO) throws BizException{
		GetAllOperateLogListBP bp = new GetAllOperateLogListBP();
		return bp.exec(nodeDTO);
	}
	/***
	 * 查询患者门诊待交费数据(调用费用的接口查询) - zhangpp 2019.3.12
	 * @param patId
	 * @param days
	 * @throws BizException
	 */
	@Override
	public OpUnpayAndAccDrugDTO[] getOepUnpayDetail(String patId, Integer days) throws BizException{
		GetOepUnpayDetailBP bp = new GetOepUnpayDetailBP();
		return bp.exec(patId, days);
	}
	/***
	 * 查询患者门诊已缴费未拿药信息(调用药品的接口查询) - zhangpp 2019.3.18
	 * @param patId
	 * @throws BizException
	 */
	@Override
	public OpUnpayAndAccDrugDTO[] getAccountDrugInfo(String patId) throws BizException{
		GetAccountDrugInfoBP bp = new GetAccountDrugInfoBP();
		return bp.exec(patId);
	}
	/***
	 * 查询就诊事件记录 - li.wm
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<EnEvtResultDTO> getEnEvtResultInfo(String wherestr,PaginationInfo pg) throws BizException{
		GetEnEvtQryInfoBP bp = new GetEnEvtQryInfoBP();
		return bp.exec(pg, wherestr);
	}
	/***
	 * 查询就诊事件列表 - li.wm
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<EnEvtListDTO> getEnEvtListInfo(EnEvtResultDTO param,PaginationInfo pg) throws BizException{
		GetEnEvtQryInfoBP bp = new GetEnEvtQryInfoBP();
		return bp.exec(pg, param);
	}
	/**
	 * 获取设置Vip患者信息
	 * 
	 * @param regQry
	 * @param pg
	 * @return
	 */
	@Override
	public PagingRtnData<RegListDTO> getSetUpVipList(QryRootNodeDTO regQry, PaginationInfo pg) throws BizException {
		GetSetUpVipListBP bp = new GetSetUpVipListBP();
		PagingRtnData<RegListDTO> exec = bp.exec(regQry, pg);
		return exec;
	}
	/**
	 * 获取候诊出诊人数（点击排班时候）
	 * @param id_sch
	 * @author li.wm
	 * @return
	 */
	@Override
	public String getFirstWaitNum(String id_sch,String code_entp) throws BizException {
		GetFirstWaitNumBP getFirstWaitNumBP = new GetFirstWaitNumBP();
		return getFirstWaitNumBP.exec(id_sch,code_entp);
	}
}
