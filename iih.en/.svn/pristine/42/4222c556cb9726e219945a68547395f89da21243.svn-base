package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.ChlSchStatsDTO;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取渠道统计信息
 * @author WJY
 *
 */
public class GetChlSchStatsBP {
	/**
	 * 获取渠道统计信息
	 * 
	 * @param deptCode 科室编码
	 * @param deptName 科室姓名（可模糊匹配）
	 * @param beginDate 开始日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param endDate 结束日期,格式：yyyy-MM-dd，如：2016-08-09
	 * @param srvType 号别,01：普通号 02：专家号
	 * @param chlType 渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @return
	 * @throws BizException
	 */
	public ChlSchStatsDTO[] exec(String deptCode, String deptName, String beginDate, String endDate, String srvType,
			String chlType) throws BizException{
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetChlSchStatsBP参数为:deptCode:"+deptCode+";deptName:"+deptName
				+";beginDate:"+beginDate+";endDate:"+endDate+";srvType:"+srvType+";chlType:"+chlType);
		
		//1. 验证必输项
		if(!this.validParam(beginDate, endDate, chlType)) 
			return null;
		
		//2. 获取渠道信息
		SchedulechlDO schedulechlDo = this.getScChlByTp(chlType);
		if(schedulechlDo == null) 
			return null;
		
		//3. 获取排班信息
		ChlSchStatsDTO chlDTO = this.getChlSchStatsInfos(schedulechlDo.getId_scchl(), srvType, beginDate, endDate, deptCode, deptName);
		if(chlDTO == null) 
			return null;
		Integer cancNum = this.getCancNum(schedulechlDo.getId_scchl(), beginDate, endDate);
		chlDTO.setAvailable(chlDTO.getTotal() - chlDTO.getUsed());
		chlDTO.setChlType(chlType);
		chlDTO.setCancNum(cancNum);				
		
		return new ChlSchStatsDTO[]{chlDTO};
	}
	
	/**
	 * 根据渠道类型获取渠道信息
	 * @param chlType 渠道类型
	 * @return
	 * @throws BizException 
	 * @author WJY
	 */
	private SchedulechlDO getScChlByTp(String chlType) throws BizException{
		if(EnValidator.isEmpty(chlType)){
			return null;
		}
		IScBdOutQryService bdQryService = ServiceFinder.find(IScBdOutQryService.class);
		SchedulechlDO[] chlDOs = bdQryService.getChlByTp(chlType);
		if(!EnValidator.isEmpty(chlDOs)){
			return chlDOs[0];
		}else {
			throw new BizException("获取渠道信息失败！");
		}
	}
	
	/**
	 * 获取排班信息（总数、剩余数）
	 * @param chlId 渠道ID
	 * @param srvType 号别类型编码
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @param deptCode 科室编码
	 * @param deptName 科室名称
	 * @author WJY
	 * @throws DAException 
	 */
	private ChlSchStatsDTO getChlSchStatsInfos(String chlId, String srvType, String beginDate, String endDate, String deptCode, String deptName) throws DAException{
		StringBuilder builder =new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append( "select sum(a.total) total,sum(a.used)  used from ( ");
		builder.append("SELECT SCH.ID_SCH, ");
		builder.append("DECODE(CHL.SCPOLCN,0,NVL(SCH.QUAN0_APPT, 0),1,NVL(SCH.QUAN1_APPT, 0),2,NVL(SCH.QUAN2_APPT, 0),3,NVL(SCH.QUAN3_APPT, 0),4,NVL(SCH.QUAN4_APPT, 0),5,NVL(SCH.QUAN5_APPT, 0),6,NVL(SCH.QUAN6_APPT, 0),7,NVL(SCH.QUAN7_APPT, 0),8,NVL(SCH.QUAN8_APPT, 0),9,NVL(SCH.QUAN9_APPT, 0),NVL(QUAN_TOTAL_APPT，0)) TOTAL, ");
		builder.append("DECODE(CHL.SCPOLCN,0,NVL(SCH.QUAN0_USED, 0),1,NVL(SCH.QUAN1_USED, 0),2,NVL(SCH.QUAN2_USED, 0),3,NVL(SCH.QUAN3_USED, 0),4,NVL(SCH.QUAN4_USED, 0),5,NVL(SCH.QUAN5_USED, 0),6,NVL(SCH.QUAN6_USED, 0),7,NVL(SCH.QUAN7_USED, 0),8,NVL(SCH.QUAN8_USED, 0),9,NVL(SCH.QUAN9_USED, 0),NVL(QUAN_TOTAL_USED，0)) USED ");
		builder.append("FROM SC_SCH SCH INNER JOIN SC_PL CPL ON SCH.ID_SCPL = CPL.ID_SCPL ");
		builder.append("INNER JOIN SC_RES RES ON CPL.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN SC_SRV SRV ON CPL.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("INNER JOIN SC_SCH_CHL CHL ON CHL.ID_SCH = SCH.ID_SCH ");
		builder.append("INNER JOIN BD_DEP DEP ON CPL.ID_DEP = DEP.ID_DEP ");
		builder.append("WHERE 1 = 1  ");

		builder.append(" AND SCH.D_SCH >= ? ");
		param.addParam(beginDate);
		builder.append(" AND SCH.D_SCH <= ? ");
		param.addParam(endDate);
		builder.append("AND CHL.ID_SCCHL = ? ");
		param.addParam(chlId);
		
		if(!EnValidator.isEmpty(srvType)){
			String[] srvTps = EnCodeUtils.srvTypeTOIIHSrvTp(srvType);
			if(!EnValidator.isEmpty(srvTps)){
				builder.append("AND " + EnSqlUtils.getInSqlByIds("SRV.SD_SRVTP", srvTps));
			}
		}
		
		if(!EnValidator.isEmpty(deptCode)){
			builder.append("AND DEP.CODE= ? ");
			param.addParam(deptCode);
		}else if(!EnValidator.isEmpty(deptName)){
			builder.append("AND DEP.NAME LIKE '%").append(deptName).append("%'");
		}
		builder.append(" ) a");
		List<ChlSchStatsDTO> chlSchStatsList =(List<ChlSchStatsDTO>) new DAFacade().execQuery(builder.toString(), 
				param,new BeanListHandler(ChlSchStatsDTO.class));	
		if (EnValidator.isEmpty(chlSchStatsList)) return null;
		return chlSchStatsList.get(0);
	}
	/**
	 * 获取取消
	 * 
	 * @param chlId
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws DAException
	 */
	private Integer getCancNum(String chlId, String beginDate, String endDate) throws DAException{
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT sum(a.CANCNUM) CANCNUM FROM( SELECT SC_APT.ID_SCH,COUNT(*) AS CANCNUM ");
		builder.append("FROM SC_APT SC_APT ");
		builder.append("INNER JOIN SC_SCH SC_SCH ON SC_APT.ID_SCH = SC_SCH.ID_SCH ");
		builder.append("WHERE SC_SCH.D_SCH >= ? ");
		builder.append("AND SC_SCH.D_SCH <= ? ");
		builder.append("AND SC_APT.SD_STATUS = ? ");
		builder.append("AND SC_APT.ID_SCCHL = ? ");
		builder.append("GROUP BY SC_APT.ID_SCH ) A");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(beginDate);
		param.addParam(endDate);
		param.addParam(IScDictCodeConst.SD_APTSTATUS_CANCEL);
		param.addParam(chlId);
		List<ChlSchStatsDTO> chlSchStatsList =(List<ChlSchStatsDTO>) new DAFacade().execQuery(sql,  param,new BeanListHandler(ChlSchStatsDTO.class));	
		if (EnValidator.isEmpty(chlSchStatsList)){
			return 0;
		}
		return chlSchStatsList.get(0).getCancNum() ==null? 0:chlSchStatsList.get(0).getCancNum().intValue();
	}
	
	/**
	 * 验证必输项参数
	 * @param beginDate
	 * @param endDate
	 * @param srvType
	 * @param chlType
	 * @return
	 */
	private Boolean validParam(String beginDate, String endDate, String chlType){
		if(EnValidator.isEmpty(beginDate)){
//			Logger.error("开始日期不能为空！");
			return false;
		}
		if(EnValidator.isEmpty(endDate)){
//			Logger.error("结束日期不能为空！");
			return false;
		}
		if(EnValidator.isEmpty(chlType)){
//			Logger.error("渠道编码不能为空！");
			return false;
		}
		return true;
	}
}
