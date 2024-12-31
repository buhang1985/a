package iih.en.pv.out.s;

import iih.en.pv.out.i.IEnOpAptExternal2;
import iih.en.pv.outpatient.dto.d.ArriveResultBean;
import iih.en.pv.outpatient.dto.d.BrokenAptDTO;
import iih.en.pv.outpatient.dto.d.ChlSchStatsDTO;
import iih.en.pv.outpatient.dto.d.EnPatCaInfoDTO;
import iih.en.pv.outpatient.dto.d.EntInfoDTO;
import iih.en.pv.outpatient.dto.d.EntRegInfoDTO;
import iih.en.pv.outpatient.dto.d.OpAptDTO;
import iih.en.pv.outpatient.dto.d.OpEntListDTO;
import iih.en.pv.outpatient.dto.d.OpPatAptDTO;
import iih.en.pv.outpatient.dto.d.OpVisitTimesStatDTO;
import iih.en.pv.outpatient.dto.d.OpWaitQueDTO;
import iih.en.pv.outpatient.dto.d.PatEntInfoDTO;
import iih.en.pv.outpatient.dto.d.PayForAptDTO;
import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.en.pv.outpatient.dto.d.SchInfoDTO;
import iih.en.pv.outpatient.dto.d.SchTickInfoDTO;
import iih.en.pv.s.bp.GetOEPDepListBP;
import iih.en.pv.s.bp.op.GetBrokenAptListBP;
import iih.en.pv.s.bp.op.ws.CancApt4AppNewBP;
import iih.en.pv.s.bp.op.ws.CfmPaidAptNewBP;
import iih.en.pv.s.bp.op.ws.GetAptInfoBP;
import iih.en.pv.s.bp.op.ws.GetChlSchStatsBP;
import iih.en.pv.s.bp.op.ws.GetEnPatCaInfoBP;
import iih.en.pv.s.bp.op.ws.GetEntLisByQuebencodeBP;
import iih.en.pv.s.bp.op.ws.GetEntListByDeptCodeBP;
import iih.en.pv.s.bp.op.ws.GetEntListByPatcodeBP;
import iih.en.pv.s.bp.op.ws.GetOpAptAndEntListBP;
import iih.en.pv.s.bp.op.ws.GetOpAptListBP;
import iih.en.pv.s.bp.op.ws.GetOpAptListByAgentPatCodeBP;
import iih.en.pv.s.bp.op.ws.GetOpEmpDepMatchBP;
import iih.en.pv.s.bp.op.ws.GetOpStopSchListBP;
import iih.en.pv.s.bp.op.ws.GetPatOpAptListBP;
import iih.en.pv.s.bp.op.ws.GetPatOpEntListBP;
import iih.en.pv.s.bp.op.ws.GetPatPaidOpAptBP;
import iih.en.pv.s.bp.op.ws.GetSchIdBP;
import iih.en.pv.s.bp.op.ws.GetSchListBP;
import iih.en.pv.s.bp.op.ws.GetSchTickInfoBP;
import iih.en.pv.s.bp.op.ws.GetVisitTimesStatBP;
import iih.en.pv.s.bp.op.ws.GetWaitQueBP;
import iih.en.pv.s.bp.op.ws.GetWaitQueBySiteBP;
import iih.en.pv.s.bp.op.ws.MakeAptNewBp;
import iih.en.pv.s.bp.op.ws.MakeEntArriveBP;
import iih.en.pv.s.bp.op.ws.PayForAptNewBP;
import iih.en.pv.s.bp.op.ws.Refund4AppNewBP;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.sch.dto.d.DeptWithSchDTO;
import iih.sc.sch.dto.d.OpEmpDepDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;

/**
 * 为APP预约提供对外服务
 * 
 * @author yankan
 *
 */
public class EnOpAptExternalServiceImpl implements IEnOpAptExternal2 {
	/**
	 * 获取排班信息
	 * 
	 * @param deptCode
	 *            科室编码
	 * @param resName
	 *            资源名称(模糊匹配)
	 * @param beginDate
	 *            开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param srvType
	 *            号别,01：普通号 02：专家号
	 * @param chlType
	 *            渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @return
	 * @throws BizException
	 */
	@Override
	public SchInfoDTO[] getSchList(String deptCode, String resName, String beginDate, String endDate, String srvType,
			String chlType) throws BizException {
		GetSchListBP bp = new GetSchListBP();
		return bp.exec(deptCode, resName, beginDate, endDate, srvType, chlType);
	}

	/**
	 * 获取渠道统计信息
	 * 
	 * @param deptCode
	 *            科室编码
	 * @param deptName
	 *            科室姓名（可模糊匹配）
	 * @param beginDate
	 *            开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param srvType
	 *            号别,01：普通号 02：专家号
	 * @param chlType
	 *            渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @return
	 * @throws BizException
	 */
	@Override
	public ChlSchStatsDTO[] getChlSchStats(String deptCode, String deptName, String beginDate, String endDate,
			String srvType, String chlType) throws BizException {
		GetChlSchStatsBP bp = new GetChlSchStatsBP();
		return bp.exec(deptCode, deptName, beginDate, endDate, srvType, chlType);
	}

	/**
	 * 获取门诊停诊排班信息
	 * 
	 * @param beginDate
	 *            开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @return
	 * @throws BizException
	 */
	@Override
	public SchInfoDTO[] getOpStopSchList(String beginDate, String endDate) throws BizException {
		GetOpStopSchListBP bp = new GetOpStopSchListBP();
		return bp.exec(beginDate, endDate);
	}

	/**
	 * 获取预约信息
	 * 
	 * @param beginDate
	 *            开始日期(非空),格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期(非空),格式：yyyy-MM-dd，如：2016-08-09
	 * @param srvType
	 *            号别,01：普通号 02：专家号
	 * @param chlType
	 *            渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @param status
	 *            状态,取值如： 预约:0，取号:1,退号:7,全部状态：空
	 * @param deptName
	 *            科室名称(模糊匹配)
	 * @param patName
	 *            患者名称(模糊匹配)
	 * @param patCode
	 *            患者编码(模糊匹配)
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpAptDTO[] getOpAptList(String beginDate, String endDate, String srvType, String chlType, String status,
			String deptName, String patName, String patCode) throws BizException {
		GetOpAptListBP bp = new GetOpAptListBP();
		return bp.exec(beginDate, endDate, srvType, chlType, status, deptName, patName, patCode);
	}

	/**
	 * 获取患者爽约记录
	 * 
	 * @param patCode
	 *            患者编码
	 * @return
	 * @throws BizException
	 */
	@Override
	public BrokenAptDTO[] getBrokenAptList(String patCode) throws BizException {
		GetBrokenAptListBP bp = new GetBrokenAptListBP();
		return bp.exec(patCode);
	}

	/**
	 * 获取候诊队列
	 * 
	 * @param patCode
	 *            患者编码
	 * @param opTimes
	 *            就诊次数
	 * @param deptCode
	 *            科室编码
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpWaitQueDTO[] getWaitQue(String patCode, Integer opTimes, String deptCode) throws BizException {
		GetWaitQueBP bp = new GetWaitQueBP();
		return bp.exec(patCode, deptCode, opTimes,false);
	}

	/**
	 * 获取患者预约记录
	 * 
	 * @param patCode
	 *            患者编码
	 * @param beginDate
	 *            开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate
	 *            结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpPatAptDTO[] getPatOpAptList(String patCode, String beginDate, String endDate) throws BizException {
		GetPatOpAptListBP bp = new GetPatOpAptListBP();
		return bp.exec(patCode, beginDate, endDate);
	}

	/**
	 * 获取患者挂号记录列表
	 *
	 * @author zhengcm
	 * 
	 * @param patCode
	 *            患者编码
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpEntListDTO[] getPatOpEntList(String patCode, String beginDate, String endDate) throws BizException {
		return new GetPatOpEntListBP().exec(patCode, beginDate, endDate);
	}
	/**
	 * 获取患者预约和挂号记录列表(预约未取消，挂号包含取消)
	 *
	 * @author renying
	 * 
	 * @param patCode
	 *            患者编码
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param agentPatCode
	 *            代办人编码            
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpPatAptDTO[] getPatOpAptAndEntList(String patCode, String beginDate, String endDate,String agentPatCode) throws BizException {
		return new GetOpAptAndEntListBP().exec(patCode, beginDate, endDate, agentPatCode);
	}
	/**
	 * 
	 * 获取代办人预约记录
	 * 
	 * @param agentPatCode
	 *            挂号操作人PID(代办人（非空）
	 * @param beginDate
	 *            开始日期(非空),格式：yyyy-MM-dd，如：2016-09-09
	 * @param endDate
	 *            结束日期(非空),格式：yyyy-MM-dd，如：2016-09-09
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpPatAptDTO[] getOpAptListByAgentPatCode(String agentPatCode, String beginDate, String endDate)
			throws BizException {
		GetOpAptListByAgentPatCodeBP bp = new GetOpAptListByAgentPatCodeBP();
		return bp.exec(agentPatCode, beginDate, endDate);
	}

	/**
	 * 获取预约详细信息
	 * 
	 * @param aptId
	 *            预约ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpPatAptDTO getPaidAptDetail(String aptId) throws BizException {
		GetPatPaidOpAptBP getBP = new GetPatPaidOpAptBP();
		return getBP.exec(aptId);
	}

	/**
	 * 预约
	 * 
	 * @param patCode
	 *            患者编码
	 * @param aptCodeh
	 *            预约号
	 * @param chlType
	 *            渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @param agentCode
	 *            代办人编码
	 * @param schId
	 *            排班ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResultDTO makeApt(String patCode, String aptCode, String chlType, String agentCode, String schId)
			throws BizException {
		MakeAptNewBp bp = new MakeAptNewBp();
	    MakeAptDTO	makeAptDTO = new MakeAptDTO();
	    makeAptDTO.setPatCode(patCode);
	    makeAptDTO.setAptCode(aptCode);
	    makeAptDTO.setChlType(chlType);
	    makeAptDTO.setAgentCode(agentCode);
	    makeAptDTO.setSchId(schId);
		return bp.exec(makeAptDTO);
	}
	/**
	 * 预约
	 * 
	 * @param patCode
	 *            患者编码
	 * @param aptCodeh
	 *            预约号
	 * @param chlType
	 *            渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @param agentCode
	 *            代办人编码
	 * @param schId
	 *            排班ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegResultDTO makeAptNew(MakeAptDTO makeAptDTO)throws BizException {
		MakeAptNewBp bp = new MakeAptNewBp();
		return bp.exec(makeAptDTO);
	}
	
	/**
	 * 付费
	 * 
	 * @param aptId
	 *            预约ID
	 * @param patCode
	 *            患者编码
	 * @param chlType
	 *            渠道类型
	 * @param orderNo
	 *            订单号
	 * @param payType
	 *            1支付宝，2微信, 3预付费, 4银行卡 6-医保账户
	 * @param accNo
	 *            账号
	 * @param patCardNo
	 *            患者卡号(预付费时有值)
	 * @param parCardPwd
	 *            患者卡密码(预付费时有值)
	 * @param money
	 *            金额
	 * @param oprCode
	 *            操作员编码
	 * @param patHpTp
	 *            患者医保类型，(0普通， 1-医保持卡,2-医保不持卡)
	 * @return
	 * @throws BizException
	 */
	@Override
	public ResultBean payForApt(String aptId, String patCode, String chlType, String orderNo, String accNo,
			String payType, String patCardNo, String parCardPwd, String money, String oprCode, String patHpTp,
			String hpPriceData,String patHpNO,String hpPatInfXml)
			throws BizException {
		PayForAptNewBP bp = new PayForAptNewBP();
		return bp.exec(aptId, patCode, chlType, orderNo, payType, accNo, patCardNo, parCardPwd, money, oprCode, patHpTp,hpPriceData,patHpNO,hpPatInfXml,"");
	}
	/**
	 * 付费
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public ResultBean payForAptNew(PayForAptDTO payForAptDTO) throws BizException {
		PayForAptNewBP bp = new PayForAptNewBP();
		return bp.exec(payForAptDTO);
	}
	/**
	 * 取消预约并退费
	 * 
	 * @param aptId
	 *            预约编码
	 * @param money
	 *            金额
	 * @param opTimes
	 *            就诊次数
	 * @param settleTimes
	 *            结算次数
	 * @param flag
	 *            标志
	 * @param oprCode
	 *            操作员编码
	 * @return
	 * @throws BizException
	 */
	@Override
	public ResultBean cancAptAndRefund(String aptId, String money, Integer opTimes, Integer settleTimes, String flag,
			String oprCode) throws BizException {
		Refund4AppNewBP bp = new Refund4AppNewBP();
		return bp.exec(aptId, money, opTimes, settleTimes, flag, oprCode);
	}

	/**
	 * 取消预约
	 * 
	 * @param aptId
	 *            预约ID
	 * @param oprCode
	 *            操作员编码
	 * @return
	 * @throws BizException
	 */
	@Override
	public String cancApt(String aptId, String oprCode) throws BizException {
		CancApt4AppNewBP bp = new CancApt4AppNewBP();
		return bp.exec(aptId, oprCode);
	}

	/**
	 * 对已收费预约取号
	 * 
	 * @param aptId
	 * @param oprCode
	 * @return
	 * @throws BizException
	 */
	@Override
	public String cfmPaidApt(String aptId, String oprCode) throws BizException {
		CfmPaidAptNewBP bp = new CfmPaidAptNewBP();
		return bp.exec(aptId, oprCode);
	}
	/**
	 * 获取排班id 
	 */
	@Override
	public String getSchId(String deptCode, String resCode, String date, String ampm, String srvCode)
			throws BizException {
		GetSchIdBP bp = new GetSchIdBP();
		return bp.exec(deptCode, resCode, date, ampm, srvCode);
	}
	
	/**
	 * 根据排班ID获取号位信息
	 * @param schId
	 * @return
	 * @throws BizException 
	 */
	@Override
	public SchTickInfoDTO[] getSchTickInfo(String[] schIds,String chlType,String Ctrl1,String Ctrl2,String Ctrl3,String Ctrl4,String Ctrl5) throws BizException{
		GetSchTickInfoBP bp = new GetSchTickInfoBP();
		return bp.exec(schIds,chlType,null,Ctrl1,Ctrl2,Ctrl3,Ctrl4,Ctrl5);
	}
	  /**
     * 
     * 查询科室某段时间内的就诊记录
     * @param dtBegin  
     * 			开始时间
     * @param dtEnd    
     * 			结束时间
     * @param deptCode 
     * 			科室编码
     * @param entcode   
     * 			就诊编码
     * @param entpCode 
     * 			就诊类型-00 门诊，01 急诊，02 体检：10 住院；空串表示全部
     * @return
     * @throws DAException 
     */
    @Override
    public EntInfoDTO[] getEntListByDeptCode(String dtBegin,String dtEnd,String deptCode,String entcode,String entpCode) throws DAException {
        GetEntListByDeptCodeBP infoBP = new GetEntListByDeptCodeBP();
        return infoBP.exec(dtBegin,dtEnd,deptCode,entcode,entpCode);
    }

	/**
	 * 通过预约码获取预约Id
	 * 
	 * @param aptCode
	 *            预约编码
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getAptIdByAptCode(String aptCode) throws BizException {
		GetAptInfoBP bp = new GetAptInfoBP();
		return bp.getAptIdByAptCode(aptCode);
	}

	/**
	 * 门急诊出诊科室列表
	 * 
	 * @return
	 */
	@Override
	public DeptWithSchDTO[] getOEPDepList() throws BizException {
		GetOEPDepListBP bp = new GetOEPDepListBP();
		return bp.exec();
	}

	/**
	 * 门急诊医生出诊科室列表
	 * 
	 * @return
	 */
	@Override
	public OpEmpDepDTO[] getOPEmpDepMatch() throws BizException {
		GetOpEmpDepMatchBP bp = new GetOpEmpDepMatchBP();
		return bp.exec();
	}

	/**
	 * 获取患者就诊记录
	 * 
	 * @param patCode
	 *            患者编码
	 * @param dtBegin
	 *            开始时间
	 * @param dtEnd
	 *            结束时间
	 * @param entpCode
	 *            就诊类型
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatEntInfoDTO[] getEntListByPatcode(String patCode, String dtBegin, String dtEnd, String entpCode)
			throws BizException {
		GetEntListByPatcodeBP bp = new GetEntListByPatcodeBP();
		return bp.exec(patCode, dtBegin, dtEnd, entpCode);
	}
	/**
	 * 签到分诊
	 * @param patCode 患者编码
	 * @param opTimes 就诊次数
	 * @param queBenCode 分诊台编码
	 * @param dayslottp 午别
	 * @param oprCode 操作员
	 * @throws BizException
	 */
	@Override
	public ArriveResultBean makeEntArrive(String patCode,Integer opTimes,String queBenCode,String oprCode) 
			throws BizException{
		MakeEntArriveBP bp = new MakeEntArriveBP();
		return bp.exec(patCode, opTimes, queBenCode, oprCode);		
	}
	
	/**
	 * 取患者分诊台可分诊挂号记录
	 * @param patCode
	 * @param queBenCode
	 * @param oprCode
	 * @return
	 * @throws BizException 
	 */	
	@Override
	public EntRegInfoDTO[] getEntLisByQuebencode(String patCode,String queBenCode,String oprCode) throws BizException {
		GetEntLisByQuebencodeBP bp = new GetEntLisByQuebencodeBP();
		return bp.exec(patCode, queBenCode, oprCode);		
	}
	/**
	  * 统计门急诊就诊人次
	  * 
	  * @param date
	 *         统计日期(非空),格式：yyyy-MM-dd，如：2016-09-09
	  * @return
	  * @throws BizException
	  */
	@Override
	public OpVisitTimesStatDTO[] getVisitTimesStat(String date)throws BizException {
		GetVisitTimesStatBP bp = new GetVisitTimesStatBP();
		return bp.exec(date);
	}	
	
	 /**
	  * 获取本次就诊患者分类
	  * @param patCode
	  * @param opTimes
	  * @return
	  * @throws BizException
	  */
	@Override
	 public EnPatCaInfoDTO getEnPatCaInfo(String patCode,Integer opTimes)throws BizException{
		GetEnPatCaInfoBP infoBP = new GetEnPatCaInfoBP();
		return infoBP.exec(patCode, opTimes);		 
	 }
	 /**
	  * 根据站点信息获取医生候诊队列
	  * 
	  * @param siteCode 站点编码
	  * @param oprCode 操作员
	  * @return
	  * @throws BizException
	  */
	@Override
	public OpWaitQueDTO[] getWaitQueBySite(String siteCode, String oprCode) throws BizException {
		GetWaitQueBySiteBP bp = new GetWaitQueBySiteBP();
		return bp.exec(siteCode, oprCode);
	}
	
}
