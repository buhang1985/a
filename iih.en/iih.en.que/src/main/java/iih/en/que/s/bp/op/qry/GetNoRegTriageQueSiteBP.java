package iih.en.que.s.bp.op.qry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.sc.scbd.i.IScDaysLotService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取未挂号分诊队列站点信息
 * 
 * @author liubin
 *
 */
public class GetNoRegTriageQueSiteBP {
	/**
	 * 获取未挂号分诊队列站点信息
	 * 
	 * @param benInfo
	 * @return
	 * @throws BizException
	 */
    public TriageQueSiteDTO[] exec(TriageBenInfoDTO benInfo) throws BizException {
		if(benInfo == null || EnValidator.isEmpty(benInfo.getId_queben()))
			return null;
		if(EnValidator.isEmpty(benInfo.getId_dayslot())){
			//1.获取当前日期分组
			DaysLotDO dayslot = this.getCurDayslot();
			benInfo.setId_dayslot(dayslot.getId_dayslot());
			benInfo.setDate(new FDate(dayslot.getDef1()));
		}
		//2.查询队列站点信息
		List<TriageQueSiteDTO> quesiteList = this.getQueSiteInfo(benInfo.getId_queben(), benInfo.getDate(), benInfo.getId_dayslot(),benInfo.getId_dep(),benInfo.getId_emp());
		//3.查询队列的分诊数和候诊数
		// 优化-先查找数据，内存中计算数量 - modified by liu_bin 2020-04-07
		List<TriageQueSiteDTO> siteSumList = this.getSiteNum2(benInfo.getId_queben(), benInfo.getDate(), benInfo.getId_dayslot(),benInfo.getId_dep(),benInfo.getId_emp());
		//4.组装队列信息和分诊候诊人数
		this.assemble(quesiteList, siteSumList);
		return EnValidator.isEmpty(quesiteList) ? null : quesiteList.toArray(new TriageQueSiteDTO[0]);
	}
    /**
     * 获取当前日期分组
     * 
     * @return
     * @throws BizException
     */
	private DaysLotDO getCurDayslot() throws BizException {
		DaysLotDO dayslot = ServiceFinder.find(IScDaysLotService.class)
				.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.TRUE);
		if(dayslot == null)
			throw new BizException("未获取到当前日期分组！");
		return dayslot;
	}
	/**
	 * 获取队列
	 * 
	 * @param benId
	 * @param date
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<TriageQueSiteDTO> getQueSiteInfo(String benId, FDate date, String dayslotId,String dep,String emp) throws BizException {
		List<TriageQueSiteDTO> queList = new ArrayList<>();
		//1.查询有排班的队列
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT BQ.ID_QUE AS ID_QUE,");
		builder.append("BQ.NAME AS NAME_QUE,");
		builder.append("BS.ID_QUESITE AS ID_QUESITE,");
		builder.append("BS.NAME AS NAME_QUESITE,");
		builder.append("BS.ROOM AS ROOM,");
		builder.append("BEN.ID_QUEBEN AS ID_BEN,");
		builder.append("BEN.NAME AS NAME_BEN,");
		builder.append("DEP.ID_DEP AS ID_DEP,");
		builder.append("DEP.NAME AS NAME_DEP,");
		builder.append("RES.ID_SCRES AS ID_SCRES,");
		builder.append("RES.NAME AS NAME_RES,");
		builder.append("RES.SD_SCRESTP AS SD_SCRESTP,");
		builder.append("BS.ID_EMP AS ID_EMP,");
		builder.append("EMP.NAME AS EMP_NAME,");
		builder.append("SCH.ID_SCH AS ID_SCH,");
		builder.append("PLSRV.ID_SCSRV AS ID_SCSRV,");
		builder.append("PLSRV.NAME AS SCSRV_NAME,");
		builder.append("PLSRV.SD_SRVTP AS SD_SRVTP ");
		builder.append("FROM BD_QUE BQ ");
		builder.append("INNER JOIN BD_QUE_BEN BEN ON BQ.ID_QUEBEN = BEN.ID_QUEBEN ");
		builder.append("INNER JOIN BD_QUE_SITE BS ON BQ.ID_QUE = BS.ID_QUE ");
		builder.append("INNER JOIN SC_RES RES ON BQ.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN BD_DEP DEP ON BQ.ID_DEP = DEP.ID_DEP ");
		builder.append("INNER JOIN SC_PL SCPL ON BQ.ID_DEP = SCPL.ID_DEP AND BQ.ID_SCRES = SCPL.ID_SCRES AND BQ.ID_QUEBEN = SCPL.ID_QUEBEN ");
		builder.append("INNER JOIN SC_SCH SCH ON SCPL.ID_SCPL = SCH.ID_SCPL ");
		builder.append("INNER JOIN SC_SRV PLSRV ON SCPL.ID_SCSRV = PLSRV.ID_SCSRV ");
		builder.append("LEFT JOIN BD_PSNDOC EMP ON BS.ID_EMP = EMP.ID_PSNDOC ");
		builder.append("WHERE BQ.ID_QUEBEN = ? ");
		builder.append("AND BQ.FG_ACTIVE = ? ");
		builder.append("AND BQ.SD_QUETP = ? ");
		builder.append("AND SCH.D_SCH = ? ");
		builder.append("AND SCH.ID_DAYSLOT = ? ");
		builder.append("AND BS.SD_QUESITETP = ? ");
		builder.append("AND BS.ID_QUEBEN = ? ");
		builder.append("AND BS.FG_ACTIVE = ? ");
		builder.append("AND BS.EU_PAUSE = ? ");
		if(!StringUtil.isEmpty(dep) && !"%".equals(dep)){
			builder.append("AND DEP.ID_DEP = ? ");
		}
		if(!StringUtil.isEmpty(emp)){
			builder.append("AND BS.ID_EMP = ? ");
		}
		String sql  = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(benId);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(date);
		param.addParam(dayslotId);
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_OP);
		param.addParam(benId);
		param.addParam(FBoolean.TRUE);
		param.addParam(PauseEnum.ONLINE);
		if(!StringUtil.isEmpty(dep) && !"%".equals(dep)){
			param.addParam(dep);
		}
		if(!StringUtil.isEmpty(emp)){
			param.addParam(emp);
		}
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		Set<String> queSet = new HashSet<>();
		if(!EnValidator.isEmpty(list)){
			for(TriageQueSiteDTO queInfo : list)
			{
				queSet.add(queInfo.getId_que());
				queList.add(queInfo);
			}
		}
		//2.查询已登陆站点的队列
		builder = new StringBuilder();
		builder.append("SELECT BQ.ID_QUE AS ID_QUE,");
		builder.append("BQ.NAME AS NAME_QUE,");
		builder.append("BS.ID_QUESITE AS ID_QUESITE,");
		builder.append("BS.NAME AS NAME_QUESITE,");
		builder.append("BS.ROOM AS ROOM,");
		builder.append("BEN.ID_QUEBEN AS ID_BEN,");
		builder.append("BEN.NAME AS NAME_BEN,");
		builder.append("DEP.ID_DEP AS ID_DEP,");
		builder.append("DEP.NAME AS NAME_DEP,");
		builder.append("RES.ID_SCRES AS ID_SCRES,");
		builder.append("RES.NAME AS NAME_RES,");
		builder.append("RES.SD_SCRESTP AS SD_SCRESTP,");
		builder.append("BS.ID_EMP AS ID_EMP,");
		builder.append("EMP.NAME AS EMP_NAME,");
		builder.append("SRV.ID_SCSRV AS ID_SCSRV,");
		builder.append("SRV.NAME AS SCSRV_NAME,");
		builder.append("SRV.SD_SRVTP AS SD_SRVTP ");
		builder.append("FROM BD_QUE BQ ");
		builder.append("INNER JOIN BD_QUE_BEN BEN ON BQ.ID_QUEBEN = BEN.ID_QUEBEN ");
		builder.append("INNER JOIN BD_QUE_SITE BS ON BQ.ID_QUE = BS.ID_QUE ");
		builder.append("INNER JOIN SC_RES RES ON BQ.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN BD_DEP DEP ON BQ.ID_DEP = DEP.ID_DEP ");
		builder.append("INNER JOIN SC_SRV SRV ON BQ.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("LEFT JOIN BD_PSNDOC EMP ON BS.ID_EMP = EMP.ID_PSNDOC ");
		builder.append("WHERE BQ.ID_QUEBEN = ? ");
		builder.append("AND BQ.FG_ACTIVE = ? ");
		builder.append("AND BQ.SD_QUETP = ? ");
		builder.append("AND BS.SD_QUESITETP = ? ");
		builder.append("AND BS.ID_QUEBEN = ? ");
		builder.append("AND BS.FG_ACTIVE = ? ");
		builder.append("AND BS.EU_PAUSE = ? ");
		if(!StringUtil.isEmpty(dep) && !"%".equals(dep)){
			builder.append("AND DEP.ID_DEP = ? ");
		}
		if(!StringUtil.isEmpty(emp)){
			builder.append("AND BS.ID_EMP = ? ");
		}
		if(!queSet.isEmpty()){
			builder.append("AND " + EnSqlUtils.getNotInSqlByIds("BQ.ID_QUE", queSet.toArray(new String[0])));
		}
		sql  = builder.toString();
		param = new SqlParam();
		param.addParam(benId);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_OP);
		param.addParam(benId);
		param.addParam(FBoolean.TRUE);
		param.addParam(PauseEnum.ONLINE);
		if(!StringUtil.isEmpty(dep) && !"%".equals(dep)){
			param.addParam(dep);
		}
		if(!StringUtil.isEmpty(emp)){
			param.addParam(emp);
		}
		list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		if(!EnValidator.isEmpty(list))
			queList.addAll(list);
		return queList;	
	}
	/**
	 * 查找 工作站的分诊数和候诊数
	 * 
	 * @param date
	 * @param dayslotId
	 * @param benId
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	private List<TriageQueSiteDTO> getSiteNum(String benId, FDate date,String dayslotId) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT BS.ID_QUESITE,");
		builder.append("(SELECT COUNT(EQ.ID_ENT_QUE) FROM EN_ENT_QUE EQ WHERE EQ.DT_REGIST = ? AND EQ.ID_DATESLOT = ? AND EQ.SD_STATUS_ACPT <> ? AND EQ.FG_ACTIVE = ? AND EQ.SD_ENTQUE_TP = ? AND EQ.ID_QUE = BS.ID_QUE ");
		builder.append("AND (EQ.ID_QUE_SITE = BS.ID_QUESITE OR (BQ.SD_MODE = ? AND NVL(EQ.ID_QUE_SITE,'~') = '~'))) ");
		builder.append(" AS TRIAGENUM, ");
		param.addParam(date);
		param.addParam(dayslotId);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		builder.append("(SELECT COUNT(EQ.ID_ENT_QUE) FROM EN_ENT_QUE EQ WHERE EQ.DT_REGIST = ? AND EQ.ID_DATESLOT = ? AND EQ.SD_STATUS_ACPT NOT IN (?,?) AND EQ.FG_ACTIVE = ? AND EQ.SD_ENTQUE_TP = ? AND EQ.ID_QUE = BS.ID_QUE ");
		builder.append("AND (EQ.ID_QUE_SITE = BS.ID_QUESITE OR (BQ.SD_MODE = ? AND NVL(EQ.ID_QUE_SITE,'~') = '~'))) ");
		builder.append(" AS WAITNUM ");
		param.addParam(date);
		param.addParam(dayslotId);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		builder.append("FROM BD_QUE_SITE BS ");
		builder.append("INNER JOIN BD_QUE BQ ON BS.ID_QUE = BQ.ID_QUE ");
		builder.append("WHERE BS.ID_QUEBEN = ? ");
		builder.append("AND BS.SD_QUESITETP = ? ");
		builder.append("AND BS.FG_ACTIVE = ? ");
		builder.append("AND BS.EU_PAUSE = ? ");
		param.addParam(benId);
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_OP);
		param.addParam(FBoolean.TRUE);
		param.addParam(PauseEnum.ONLINE);
		String sql = builder.toString();
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(TriageQueSiteDTO.class));
		return list;
	}
	/**
	 * 查找 工作站的分诊数和候诊数
	 * 优化-先查找数据，内存中计算数量 - modified by liu_bin 2020-04-07
	 * 
	 * @param date
	 * @param dayslotId
	 * @param benId
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private List<TriageQueSiteDTO> getSiteNum2(String benId, FDate date,String dayslotId,String dep,String emp) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append(" SELECT BS.ID_QUESITE, ");
		builder.append(" BS.ID_QUE, ");
		builder.append(" BQ.SD_MODE, ");
		builder.append(" EQ.ID_ENT_QUE, ");
		builder.append(" EQ.SD_STATUS_ACPT, ");
		builder.append(" EQ.ID_QUE_SITE AS ID_QUESITE_ENQUE ");
		builder.append(" FROM BD_QUE_SITE BS ");
		builder.append("INNER JOIN BD_QUE BQ ON BQ.ID_QUE = BS.ID_QUE ");
		builder.append("INNER JOIN BD_DEP DEP ON BQ.ID_DEP = DEP.ID_DEP ");
		builder.append(" LEFT JOIN EN_ENT_QUE EQ ON EQ.ID_QUE = BS.ID_QUE AND EQ.DT_REGIST = ? AND EQ.ID_DATESLOT = ? AND EQ.FG_ACTIVE = 'Y' AND EQ.SD_ENTQUE_TP = ? ");
		builder.append(" WHERE BS.ID_QUEBEN = ? ");
		builder.append(" AND BS.SD_QUESITETP = ? ");
		builder.append(" AND BS.FG_ACTIVE = ? ");
		builder.append(" AND BS.EU_PAUSE = ? ");
		if(!StringUtil.isEmpty(dep)){
			builder.append("AND DEP.ID_DEP = ? ");
		}
		if(!StringUtil.isEmpty(emp)){
			builder.append("AND BS.ID_EMP = ? ");
		}
		param.addParam(date);
		param.addParam(dayslotId);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(benId);
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_OP);
		param.addParam(FBoolean.TRUE);
		param.addParam(PauseEnum.ONLINE);
		if(!StringUtil.isEmpty(dep)){
			param.addParam(dep);
		}
		if(!StringUtil.isEmpty(emp)){
			param.addParam(emp);
		}
		String sql = builder.toString();
		List<CalcSiteNumTempBean> tempList = (List<CalcSiteNumTempBean>) new DAFacade().execQuery(sql, param, new BeanListHandler(CalcSiteNumTempBean.class));
		if(EnValidator.isEmpty(tempList))
			return null;
		Map<String, TriageQueSiteDTO> map = new HashMap<>();
		for(CalcSiteNumTempBean temp : tempList){
			TriageQueSiteDTO site;
			if(map.containsKey(temp.getId_quesite()))
				site = map.get(temp.getId_quesite());
			else{
				site = new TriageQueSiteDTO();
				site.setId_quesite(temp.getId_quesite());
				site.setTriagenum(0);
				site.setWaitnum(0);
				map.put(temp.getId_quesite(), site);
			}
			if(EnValidator.isEmpty(temp.getId_ent_que()))
				continue;
			if(temp.getId_quesite().equals(temp.getId_quesite_enque()) 
					|| (IBdFcDictCodeConst.SD_MODEL_OP_EMP.equals(temp.getSd_mode()) && EnValidator.isEmpty(temp.getId_quesite_enque()))){
				if(!IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED.equals(temp.getSd_status_acpt())){
					site.setTriagenum(site.getTriagenum() + 1);
					if(!IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED.equals(temp.getSd_status_acpt())){
						site.setWaitnum(site.getWaitnum() + 1);
					}
				}
			}
		}
		return new ArrayList<TriageQueSiteDTO>(map.values());
	}
	/**
	 * 组装队列信息和分诊候诊人数
	 * 
	 * @param quesiteList
	 * @param siteNumList
	 */
	private void assemble(List<TriageQueSiteDTO> quesiteList, List<TriageQueSiteDTO> siteSumList){
		if(EnValidator.isEmpty(quesiteList) || EnValidator.isEmpty(siteSumList))
			return;
		Map<String, TriageQueSiteDTO> sumMap = new HashMap<>();
		for(TriageQueSiteDTO siteSum : siteSumList)
			sumMap.put(siteSum.getId_quesite(), siteSum);
		for(TriageQueSiteDTO quesite : quesiteList){
			if(sumMap.containsKey(quesite.getId_quesite())){
				TriageQueSiteDTO siteSum = sumMap.get(quesite.getId_quesite());
				quesite.setTriagenum(siteSum.getTriagenum());
				quesite.setWaitnum(siteSum.getWaitnum());
			}else{
				quesite.setTriagenum(0);
				quesite.setWaitnum(0);
			}
		}
	}
}