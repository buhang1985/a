package iih.en.pv.i;

import iih.bd.srv.dto.d.PhySignDTO;
import iih.en.pv.dto.d.EnOperateLogDTO;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.dto.d.OutpatientQryDTO;
import iih.en.pv.dto.d.PrintRegistedInfoDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.enevtqrydto.d.EnEvtListDTO;
import iih.en.pv.enevtqrydto.d.EnEvtResultDTO;
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
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
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
public interface IEnOpQryService {
	/**
	 * 获取门诊挂号患者注册信息
	 * 
	 * @param patId  患者Id
	 * @param isSwingHpCad  是否是刷医保卡
	 * @return
	 * @throws BizException
	 */
	OpRegPatDTO getOpRegPatByPatId(String patId, FBoolean isSwingHpCad)throws BizException;
	/**
	 * 获取病历本价格
	 * @return
	 * @throws BizException
	 */
	FDouble getRecordPrice() throws BizException;	
	/**
	 * 获取打印挂号条信息
	 * @param entId 就在id
	 * @return
	 * @throws BizException
	 */
	PrintRegistedInfoDTO getRegInfoForPrint(String entId) throws BizException;
	/**
	 * 检索操作员当天挂号信息
	 * @param operId
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	RegInfoDTO[] getRegListByOper(String operId) throws BizException;	
	/**
	 * 分页获取挂号员当天挂号信息
	 * @param pg 分页对象
	 * @param operId 挂号员ID
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<RegInfoDTO> getPageRegListByOper(PaginationInfo pg, QueryRegInfoDTO queryDTOO) throws BizException;
	/**
	 * 检索患者挂号信息
	 * @param patId 患者id
	 * @param withPri　包含价格信息
	 * @return
	 * @throws BizException
	 */
	RegInfoDTO[] getRegInfoByPat(String patId,FBoolean withPri) throws BizException;
	
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
    OpRegDTO[] getOpRegListByPat2(String patId, String dayslotId) throws BizException;
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
	RegInfoDTO[] getRegInfoByPatAndDate(String patId,FBoolean withPri, FDate bDate, FDate eDate) throws BizException;
	/****
	 * @Description:检索患者挂号信息(通过就诊id和挂号时间)
	 * @param entId
	 * @param withPri
	 * @param bDate
	 * @param eDate
	 * @return
	 * @throws BizException
	 */
	RegInfoDTO[] getRegInfoByEntAndDate(String[] entIds,FBoolean withPri, FDate bDate, FDate eDate) throws BizException;
	/**
	 * 是否已经挂号
	 * @param patId 患者id
	 * @param schId 排班id
	 * @return
	 * @throws BizException
	 */
	FBoolean hasRegistered(String patId,String schId) throws BizException;
	/**
	 * 加载结算价格信息
	 * @param regInfo 挂号信息
	 */
	RegInfoDTO loadCgPri(RegInfoDTO regInfo) throws BizException;
	/**
	 * 加载资源的结算价格
	 * @param resDTO 挂号资源
	 * @param cgId 结算id
	 * @return
	 * @throws BizException
	 */
	RegResDTO loadResCgPri(RegResDTO resDTO,String cgId) throws BizException;
	/**
	 * 查询门诊预约集合
	 * @param qryMod 查询模板
	 * @return
	 * @throws BizException
	 */
	OpApptDTO[] getOpApptList(ApptQryModDTO querySchema) throws BizException;
	/**
	 * 根据患者id获取门诊就诊信息
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	OpRegDTO[] getRegByPatId(String patId) throws BizException;
	/**
	 * 根据就诊id查询就诊信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	OpRegDTO getRegByEntId(String entId) throws BizException;
	/**
	 * 获取患者挂号信息
	 * 包含队列信息
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	OpRegDTO[] getOpRegListByPat(String patId, String dayslotId, FDate date) throws BizException;
	/**
	 * 获取分诊台管理的患者挂号信息
	 * 
	 * @param patId 患者id
	 * @param benId 分诊台Id
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	OpRegDTO[] getOpRegByBenId(String patId, String benId) throws BizException;
	/**
	 * 分诊台Banner查询患者挂号信息
	 * 
	 * @param sqlStr banner的sql查询语句
	 * @param whereStr Banner的where语句
	 * @param triageInfo 分诊台信息
	 * @param dayslot 日期分组id
	 * @return
	 * @throws BizException
	 */
	OpRegDTO[] getOpReg4Banner(String sqlStr,String whereStr, String[] selectConditions, String inputValue, TriageBenInfoDTO triageInfo) throws BizException;
	/**
	 * 
	 * 门急诊医生站Banner查询就诊或患者信息
	 * 
	 * @param whereStr Banner的where语句
	 * @param selectConditions banner查询条件
	 * @param inputValue Banner输入值
	 * @return
	 * @throws BizException
	 */
	FMap getOpRegOrPat4Banner(String whereStr, String[] selectConditions, String inputValue, EnTrDocSiteInfoDTO enSiteInfo) throws BizException;
	/**
	 * 获取门诊就诊信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	OutpatientQryDTO getOpInfo(String entId) throws BizException;
	
	/**
	 * 是否需要预检
	 * @param entId 就诊id
	 * @param oprId 操作员id
	 * @return FBoolean
	 * @throws BizException
	 * @author liubin
	 */
	FBoolean isNeedPreExam(String entId,String oprId) throws BizException;
	/**
	 * 规则引擎：挂号规则
	 * @param 患者ID
	 * @param schId-排班ID
	 * @param scresId-排班资源ID
	 * @param deptId-科室ID
	 * @param regDate-就诊日期
	 * @param scsrvId-排班服务ID
	 * @return ResultDTO:{flag:true(规则全部验证通过)，false(规则验证不通过);MSG：规则验证不通过的提示信息}
	 * @throws BizException
	 */
	ResultDTO isPermitRegByMvel(RegRuleDTO regRuleDto) throws BizException;
	/**
	 * 规则引擎：只调用医保挂号规则
	 * 
	 * 
	 * @param regRuleDto
	 * @return
	 * @throws BizException
	 */
	ResultDTO isPermitRegHpByMvelWithApt(RegRuleDTO regRuleDto) throws BizException;
	/**
	 * 获取门诊基本信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	OpBasic4EditDTO getOpBasicInfo4Edit(String entId) throws BizException;
	/**
	 * 获取代办人信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	OpBasic4EditDTO getOpAgent(String entId) throws BizException;	
	/**
	 * 获取就诊或者患者信息
	 * 先查就诊信息，如果就诊信息未查到再查患者信息
	 * @param condTypeList 条件类型集合
	 * @param inputValue 输入值
	 * @param wherePart 限定条件部分
	 * @return ent:就诊信息，pat:患者信息
	 * @throws BizException
	 * @author liubin
	 */
	FMap getEntOrPat4Banner(String[] condTypeList,String inputValue,String wherePart) throws BizException;
	/**
	 * 门诊就诊查询
	 * @param qryModDTO
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	PagingRtnData<OutpatientQryDTO> getOpList(EntQryModDTO qryModDTO, PaginationInfo pg) throws BizException;
	/**
	 * 检索门诊挂号信息
	 * 
	 * @param regQry 查询条件
	 * @param pg 分页信息
	 * @return
	 * @throws BizException 
	 * @author liubin
	 */
	PagingRtnData<RegListDTO> getOpRegListByOper(RegQryDTO regQry, PaginationInfo pg) throws BizException;
	
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
	OpRegPatDTO[] getPatListByIdTp(String patId, FBoolean isSwingHpCad) throws BizException;
	/**
	 * 退号校验
	 * 
	 * @param entId
	 * @throws BizException
	 */
	void cancOpRegValidate(String entId) throws BizException;
	/***
	 * 获得本机设置的号条打印机名称
	 * @author fanlq 
	 * @return
	 * @throws BizException
	 */
	String getReportPrinter() throws BizException;
	/***
	 * 查询登录日志
	 * 
	 * @param logQry
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<EnOperateLogDTO> getOperateLogList(PaginationInfo pg, EnOperateLogDTO nodeDTO) throws BizException;
	/***
	 * 查询登录日志数据不分页
	 * 
	 * @param nodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	EnOperateLogDTO[] getAllOperateLogList(EnOperateLogDTO nodeDTO) throws BizException;
	/***
	 * 查询患者门诊待交费数据(调用费用的接口查询) - zhangpp 2019.3.12
	 * @param patId
	 * @param days
	 * @throws BizException
	 */
	OpUnpayAndAccDrugDTO[] getOepUnpayDetail(String patId, Integer days) throws BizException;
	/***
	 * 查询患者门诊已缴费未拿药信息(调用药品的接口查询) - zhangpp 2019.3.18
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	OpUnpayAndAccDrugDTO[] getAccountDrugInfo(String patId) throws BizException;
	/***
	 * 查询就诊事件记录 - li.wm
	 * @param patId
	 * @return
	 * @throws BizException
	 */ 
	PagingRtnData<EnEvtResultDTO> getEnEvtResultInfo(String wherestr,PaginationInfo pg) throws BizException;
	/***
	 * 查询就诊事件列表 - li.wm
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<EnEvtListDTO> getEnEvtListInfo(EnEvtResultDTO param,PaginationInfo pg) throws BizException;
	/**
	 * 获取设置Vip患者信息
	 * 
	 * @param regQry  QryRootNodeDTO
	 * @param pg
	 * @return
	 */
    PagingRtnData<RegListDTO> getSetUpVipList(QryRootNodeDTO regQry, PaginationInfo pg) throws BizException;
    /**
     * 预检弹框关闭规则
     * @author lilei
     * @date 2020年5月28日
     */
    ResultDTO isCheckBloodPressure(String entId, String oprId,PhySignDTO[] phySignDtos) throws BizException;
    /**
	 * 获取候诊出诊人数（点击排班时候）
	 * @param id_sch
	 * @author li.wm
	 * @return
	 */
    String getFirstWaitNum(String id_sch,String code_entp) throws BizException;
	
}
