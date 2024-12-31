package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IMpDictCodeTypeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.d.desc.QueDODesc;
import iih.bd.fc.que.i.IQueQryService;
import iih.bd.fc.que.i.IQueRService;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.d.desc.QueSiteDODesc;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.bl.cg.service.IBlcgqueryService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.en.comm.IEnConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.i.IEndepRService;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.en.que.dto.d.EntForMTDTO;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.dto.d.MedTechTriageStatus;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.QueSiteStatus;
import iih.en.que.enqueue.i.IEnqueueCudService;
import iih.en.que.enqueue.s.EnqueueCrudServiceImpl;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.i.IMporInternalService;
//import iih.mp.nr.foreign.i.IMporprExecuteStatusService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDOCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 医技分诊BP
 * 
 * @author licheng，yankan
 *
 */
public class MedTechTriageBP {
	/**
	 * 构造函数
	 */
	public MedTechTriageBP() {

	}

	/**
	 * 获取分诊台的工作站点
	 * 
	 * @param benId
	 * @param status 状态，参照枚举：QueSiteStatus
	 * @return 相应的DTO
	 */
	// TODO 考虑是否可以将号源部分移植到SC中
	public TriageQueSiteDTO[] getQueSite(String benId, String depId, int status, boolean isFilter,
			String id_or) throws BizException {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT QS.ID_QUESITE AS ID_QUESITE,QS.NAME AS NAME_QUESITE,QUE.ID_QUE AS ID_QUE,");
		builder.append("pl.NAME AS NAME_QUE,QUE.ID_QUEBEN AS ID_BEN,QUE.ID_DEP AS ID_DEP,DEP.NAME AS NAME_DEP,");
		builder.append("RES.NAME AS NAME_RES,QUE.ID_SCRES AS ID_SCRES,QUE.ID_SCSRV AS ID_SCSRV,SRV.NAME AS SCSRV_NAME,");
		// builder.append("CASE WHEN (QS.ID_EMP='~' OR QS.ID_EMP IS NULL) THEN '离线' WHEN QS.FG_PAUSE='Y' THEN '离开'  ELSE '在线' END AS SITESTATUS,");
		builder.append("QS.EU_PAUSE AS SITESTATUS,");// 状态
		builder.append("QS.ID_EMP AS ID_EMP,QUE.ID_PARENT AS ID_PARENT, ");
		// 这里相当于挂号，只显示挂号的0号源池的剩余数
		builder.append("  nvl( sch.quan0_used,0)   quan_total_used, ");
		builder.append("  (nvl(sch.quan0_appt,0)  -nvl( sch.quan0_used,0)) quan_left, ");
		builder.append("  sch.id_sch ");
		builder.append("FROM BD_QUE QUE INNER JOIN SC_RES RES ON QUE.ID_SCRES=RES.ID_SCRES ");
		builder.append("INNER JOIN BD_DEP DEP ON QUE.ID_DEP=DEP.ID_DEP ");
		builder.append("LEFT JOIN SC_SRV SRV ON QUE.ID_SCSRV=SRV.ID_SCSRV ");
		builder.append("INNER JOIN BD_QUE_SITE QS ON QUE.ID_QUE=QS.ID_QUE ");

		builder.append("  inner join sc_pl pl ");
		builder.append("  on pl.id_scres =  que.id_scres ");
		// builder.append("  and pl.id_scsrv =   que.id_scsrv  ");
		builder.append("  and pl.id_dep = que.id_dep ");
		builder.append("  and pl.fg_active = ? ");
		builder.append("  and pl.sd_sctp = ? ");
		builder.append(" inner join sc_sch sch  ");
		builder.append(" on sch.id_scpl = pl.id_scpl  ");

		// 过滤
		if (isFilter && !EnValidator.isEmpty(id_or)) {
			String sql = this.getFilterSchSql(id_or);
			builder.append(" and sch.id_sch in(" + sql + ") ");
		}

		builder.append("  WHERE QUE.ID_QUEBEN=? ");
		if (depId != null) {
			builder.append("AND QUE.ID_DEP=? ");
		}
		if (status == QueSiteStatus.Online) {
			// builder.append("AND QS.QS.FG_PAUSE='N' ");
			builder.append("AND QS.EU_PAUSE='1' ");
		} else if (status == QueSiteStatus.Left) {
			// builder.append("AND QS.QS.FG_PAUSE='Y' ");
			builder.append("AND QS.EU_PAUSE='2' ");
		} else if (status == QueSiteStatus.OffLine) {
			// builder.append("AND (QS.ID_EMP='~' OR QS.ID_EMP IS NULL) ");
			builder.append("AND QS.EU_PAUSE = '0' ");
		}

		builder.append(" and sch.d_sch = ?");
		builder.append(" and sch.id_dayslot = ? ");
		builder.append(" ORDER BY QUE.ID_DEP ");

		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam("Y");
		param.addParam(IScDictCodeConst.SD_SCTP_MT);
		param.addParam(benId);
		if (depId != null) {
			param.addParam(depId);
		}
		param.addParam(EnAppUtils.getServerDateTime().getDate());
		IScDaysLotService dayslotQryService = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO daysLotDO = dayslotQryService.getNowDaysLot(IScDictCodeConst.SD_SCTP_MT, FBoolean.TRUE);
		if (daysLotDO == null || daysLotDO.getName() == null)
			throw new BizException("未获取到午别");
		else {
			param.addParam(daysLotDO.getId_dayslot());
		}

		@SuppressWarnings("unchecked")
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param,
				new BeanListHandler(TriageQueSiteDTO.class));
		if (!EnValidator.isEmpty(list)) {
			// 添加统计数据
			// this.getAppointNumber(list.toArray(new TriageQueSiteDTO[0]),
			// benId);//获取预约人数 和剩余人数

			return this
					.triageQueSiteAddNum(list.toArray(new TriageQueSiteDTO[0]), benId, daysLotDO);
		}

		return null;
	}

	/**
	 * 获取医技检查申请列表
	 * 
	 * @param benId 分诊台id
	 * @param acptStatus 检查状态
	 * @return
	 */
	public MedTechAppDTO[] getMedTechApp(String benId, String[] acptStatus) throws BizException {
		if (EnValidator.isEmpty(benId)) {
			throw new BizException("参数: 分诊台id为空！");
		}
		if (EnValidator.isEmpty(acptStatus)) {
			throw new BizException("参数：接收状态为空！");
		}
		StringBuilder sqlBuilder = getMedSql(null, null);
		sqlBuilder.append(" where eq.id_queben = ? and eq.ds='0' ");
		sqlBuilder.append(" and ").append(EnSqlUtils.getInSqlByIds("eq.sd_status_acpt", acptStatus));
		sqlBuilder.append(" and eq.dt_regist =? and cior.ds =0 ");
		sqlBuilder.append(" order by eq.level_pri desc ,  eq.dt_in desc ");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(benId);
		sqlParam.addParam(EnAppUtils.getServerDateTime().getDate());
		@SuppressWarnings("unchecked")
		List<MedTechAppDTO> result = (List<MedTechAppDTO>) new DAFacade().execQuery(
				sqlBuilder.toString(), sqlParam, new BeanListHandler(MedTechAppDTO.class));
		if (EnValidator.isEmpty(result)) {
			return null;
		}
		// 加载执行科室信息
		this.loadMpDepInfo(result, null);

		return result.toArray(new MedTechAppDTO[0]);
	}

	/**
	 * 检索申请单
	 * 
	 * @param patId 患者id
	 * @param benId 分诊台id
	 * @return
	 * @throws BizException
	 */
	public MedTechAppDTO[] getMedTechAppByPat(String patId, String benId) throws BizException {
		FDate fdate = EnAppUtils.getServerDateTime().getDate();
		StringBuilder sb = this.getAppLsSql();
		sb.append(" where cior.id_pat=?   and cior.ds =0");

		// 添加医嘱和申请单的过滤条件 zhengcm (2017-03-01)
		sb.append(" and (en.code_entp = '10' and cior.sd_su_or in ('"
				+ ICiDictCodeConst.SD_SU_CHECKTHROUGH + "','" + ICiDictCodeConst.SD_SU_CHECKSTOP
				+ "') or (en.code_entp in ('00','01') and cior.sd_su_or in ('"
				+ ICiDictCodeConst.SD_SU_SIGN + "','" + ICiDictCodeConst.SD_SU_CHECKTHROUGH + "','"
				+ ICiDictCodeConst.SD_SU_CHECKSTOP + "'))) ");

		// sb.append(" and cior.sd_su_or in ('" +
		// ICiDictCodeConst.SD_SU_CHECKTHROUGH + "','"
		// + ICiDictCodeConst.SD_SU_CHECKSTOP + "') ");
		sb.append(" and obs.sd_su_obs in ('0','1','2') ");

		sb.append(" and ( obs.dt_plan >= ? or apt.dt_b >=?) ");
		SqlParam sqlPara = new SqlParam();
		sqlPara.addParam(patId);
		sqlPara.addParam(fdate);
		sqlPara.addParam(fdate);
		List<MedTechAppDTO> result = (List<MedTechAppDTO>) new DAFacade().execQuery(sb.toString(),
				sqlPara, new BeanListHandler(MedTechAppDTO.class));

		// 去掉重复的申请单(zhengcm 2017-01-17)
		result = this.filterSameApp(result);

		if (result != null && result.size() != 0) {
			this.getMpDept(result, benId);
		}

		if (!EnValidator.isEmpty(result)) {
			return result.toArray(new MedTechAppDTO[0]);
		}
		return null;
	}

	/**
	 * 根据就诊编号查询申请单
	 * 
	 * @param entCode 就诊编号
	 * @param benId 工作台id
	 * @return
	 */
	public MedTechAppDTO[] getMedTechAppByEntCode(String entCode, String benId) throws BizException {
		FDate fdate = EnAppUtils.getServerDateTime().getDate();
		StringBuilder sb = this.getAppLsSql();
		sb.append(" where  en.code = ?   and cior.ds =0");
		sb.append(" and ( obs.dt_plan >= ? or apt.dt_b >=?) ");
		SqlParam sqlPara = new SqlParam();
		sqlPara.addParam(entCode);
		sqlPara.addParam(fdate);
		sqlPara.addParam(fdate);
		List<MedTechAppDTO> result = (List<MedTechAppDTO>) new DAFacade().execQuery(sb.toString(),
				sqlPara, new BeanListHandler(MedTechAppDTO.class));

		if (result != null && result.size() != 0) {
			this.getMpDept(result, benId);
		}

		if (!EnValidator.isEmpty(result)) {
			return result.toArray(new MedTechAppDTO[0]);
		}
		return null;
	}

	/**
	 * 获取医技检查申请列表
	 * 
	 * @param benId 分诊台id
	 * @param status 检查状态，取值参考：MedTechTriageStatus
	 * @author zhengcm 常量代替硬编码处理
	 * @return
	 */
	public MedTechAppDTO[] getMedTechApp(String benId, int status) throws BizException {
		if (EnValidator.isEmpty(benId)) {
			throw new BizException("参数分诊台id为空！");
		}
		StringBuilder sb = getMedSql(null, null);
		sb.append("where eq.id_queben = ?   and  eq.dt_regist =?  and cior.ds =0");

		if (status == MedTechTriageStatus.ARRIVED) {// 到诊
			sb.append(" and eq.sd_status_acpt= '" + IEnConst.SD_STATUS_ACPT_UNACCEPT
					+ "' and  eq.id_que_site is null");
		}
		if (status == MedTechTriageStatus.TRIGE) { // 已到诊
			sb.append(" and eq.sd_status_acpt='" + IEnConst.SD_STATUS_ACPT_UNACCEPT
					+ "' and  eq.id_que_site is not null");
		}
		if (status == MedTechTriageStatus.INFOMARTION) { // 已通知
			sb.append(" and eq.sd_status_acpt in ('" + IEnConst.SD_STATUS_ACPT_CALL + "','"
					+ IEnConst.SD_STATUS_ACPT_CALLBUTNOTCOME + "') ");
		}
		if (status == MedTechTriageStatus.START_CHECK) { // 开始检查
			sb.append(" and eq.sd_status_acpt='" + IEnConst.SD_STATUS_ACPT_CHECKED + "' ");
		}
		if (status == MedTechTriageStatus.CHECKED) {// 检查完毕
			sb.append(" and eq.sd_status_acpt='" + IEnConst.SD_STATUS_ACPT_FINCHECKED + "' ");
		}
		if (status == MedTechTriageStatus.ALL) {// 全部
			sb.append(" and eq.sd_status_acpt in ('" + IEnConst.SD_STATUS_ACPT_UNACCEPT + "','"
					+ IEnConst.SD_STATUS_ACPT_CALL + "','" + IEnConst.SD_STATUS_ACPT_CALLBUTNOTCOME
					+ "','" + IEnConst.SD_STATUS_ACPT_CHECKED + "','"
					+ IEnConst.SD_STATUS_ACPT_FINCHECKED + "') ");
		}

		sb.append(" order by eq.level_pri desc ,  eq.dt_in desc");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(benId);
		sqlParam.addParam(EnAppUtils.getServerDateTime().getDate());
		@SuppressWarnings("unchecked")
		List<MedTechAppDTO> result = (List<MedTechAppDTO>) new DAFacade().execQuery(sb.toString(),
				sqlParam, new BeanListHandler(MedTechAppDTO.class));

		if (!EnValidator.isEmpty(result)) {
			this.loadMpDepInfo(result, null);
			return result.toArray(new MedTechAppDTO[0]);
		}
		return null;
	}

	/**
	 * 获取站点的医技检查申请列表
	 * 
	 * @param quesiteId
	 * @param acptStatus
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MedTechAppDTO[] getMedTechAppBySite(String quesiteId, String[] acptStatus)
			throws BizException {

		FDateTime datetime = EnAppUtils.getServerDateTime();
		IScDaysLotService dayslotQryService = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO daysLotDO = dayslotQryService.getNowDaysLot(IScDictCodeConst.SD_SCTP_MT, FBoolean.TRUE);
		// 判定是否取到午别
		if (daysLotDO == null) {
			throw new BizException(" 未取到当前午别 ");
		}
		if (acptStatus.length == 0)
			return null;
		StringBuilder sb = this.getMedSql(null, null);
		sb.append("where eq.id_que_site = ? ");
		sb.append("  and ").append(EnSqlUtils.getInSqlByIds("eq.sd_status_acpt", acptStatus));
		sb.append("  and substr(eq.dt_in,0,10) =? ");
		sb.append("  and eq.id_dateslot = ? and cior.ds =0");
		sb.append("  order by eq.level_pri desc,eq.sortno ASC");// order by
																// eq.level_pri
																// desc ,
		// eq.dt_in desc
		// 加上eq.level_pri desc(zhengcm 2016-09-13)
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(quesiteId);
		sqlParam.addParam(datetime.getDate());
		sqlParam.addParam(daysLotDO.getId_dayslot());
		List<MedTechAppDTO> result = null;
		result = (List<MedTechAppDTO>) new DAFacade().execQuery(sb.toString(), sqlParam,
				new BeanListHandler(MedTechAppDTO.class));

		IQuesiteRService quesiteService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO quesiteDO = quesiteService.findById(quesiteId);
		if (quesiteDO != null) {
			for (MedTechAppDTO medDTO : result) {
				medDTO.setQuesite_name(quesiteDO.getName());
			}
		}
		if (!EnValidator.isEmpty(result)) {
			this.getSexName(result);
			this.loadMpDepInfo(result, null);
			return result.toArray(new MedTechAppDTO[0]);
		} else
			return null;

	}

	/**
	 * 分诊到站点
	 * 
	 * @param techDTO 医技DTO
	 * @param siteDTO 工作点DTO
	 */
	public void triageToSite(MedTechAppDTO techDTO, TriageQueSiteDTO siteDTO) throws BizException {

		EnqueueCrudServiceImpl service = new EnqueueCrudServiceImpl();
		EnQueueDO enQueue = service.findById(techDTO.getId_ent_que());
		if (enQueue == null) {
			throw new BizException("分诊时未查到就诊队列");
		}

		// 检查工作点是否离线或暂停 Changed by zhengcm 2017-03-07
		if (siteDTO != null) {
			this.checkQueSite(siteDTO.getId_quesite());
		}

		// 检查申请单中的执行科室和排班科室一致
		this.checkIsSameDep(techDTO, siteDTO);

		// 申请单医嘱对应的服务
		String id_srv = this.getSrvIdByOrder(techDTO);

		// 检查患者是否存在有效期内的互斥项目
		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		schOutQryService.mutexCheck(techDTO.getId_pat(), id_srv);

		if (EnValidator.isEmpty(techDTO.getId_apt())) {// id_apt 是空说明不是预约的
			// 占最小票号
			IScSchOutCmdService schOutCmdService = ServiceFinder.find(IScSchOutCmdService.class);
			// ScSchTickDO tickdo =
			// schOutCmdService.occupyTickBySch(siteDTO.getId_sch(), 0, null);
			ScSchTickDO tickdo = schOutCmdService.occupyTickBySchAndSrv(siteDTO.getId_sch(), 0,
					null, id_srv);

			enQueue.setSortno(tickdo.getQueno());
			enQueue.setTicketno(tickdo.getQueno());
			enQueue.setId_tick(tickdo.getId_tick());
			enQueue.setId_que(siteDTO.getId_que());
			enQueue.setId_que_site(siteDTO.getId_quesite());
			service.update(new EnQueueDO[] { enQueue });

		} else {// 说明是预约申请单
			IScaptMDORService aptRService = ServiceFinder.find(IScaptMDORService.class);
			ScAptDO scapt = aptRService.findById(techDTO.getId_apt());
			if (scapt == null || scapt.getQueno() == null) {
				throw new BizException("未查到预约票号相关的数据");
			}

			// 更新预约申请状态为完成(changed by:zhengcm)
			this.updateScAptFilishedStatus(scapt);

			enQueue.setSortno(scapt.getQueno());
			enQueue.setTicketno(scapt.getQueno());
			if (EnValidator.isEmpty(scapt.getId_sch())) {
				throw new BizException("分诊时未获取到排班ID");
			}

			IQueQryService queRService = ServiceFinder.find(IQueQryService.class);
			// String wheresql =
			// QueDODesc.TABLE_ALIAS_NAME+".Id_dep = '"+scapt.getId_dep_appt()
			// +"' and "+QueDODesc.TABLE_ALIAS_NAME +".id_scres = '"
			// +scapt.getId_scres()+"'";
			QueDO queDos = queRService.getQue(scapt.getId_scres(), scapt.getId_dep_appt(), null, IBdFcDictCodeConst.SD_QUETP_MT);
			if (queDos == null) {
				throw new BizException("分诊时未找到队列");
			}
			IQuesiteRService quesiteRService = ServiceFinder.find(IQuesiteRService.class);

			QueSiteDO[] queSites = quesiteRService.findByAttrValString(QueSiteDO.ID_QUE, queDos.getId_que());

			if (EnValidator.isEmpty(queSites)) {
				throw new BizException("分诊时未找到该已预约的申请单对应站点");
			}

			// 如果是已预约的申请单手动分诊时，需要校验指定的站点和已预约的设备站点是否一致 zhengcm 2017-03-16
			if (null != siteDTO) {
				if (!siteDTO.getId_quesite().equals(queSites[0].getId_quesite())) {
					throw new BizException("该已预约的申请单预约的站点为【" + queSites[0].getName()
							+ "】，不能分诊到该站点！");
				}
			} else {// 自动分诊
				// 检查工作点是否离线或暂停 Changed by zhengcm 2017-03-17
				this.checkQueSite(queSites[0].getId_quesite());
			}

			enQueue.setId_que(queDos.getId_que());
			enQueue.setId_que_site(queSites[0].getId_quesite());

			service.update(new EnQueueDO[] { enQueue });
		}
	}

	/**
	 * 查询站点的申请单
	 * 
	 * @param quesiteId 站点
	 * @param status 检查状态，取值参考：MedTechTriageStatus
	 * @return
	 */
	public MedTechAppDTO[] getMedTechAppBySite(String quesiteId, int status) {
		return null;
	}

	/**
	 * 获取申请单DTO
	 * 
	 * @param no 单号
	 * @param benId 分诊台
	 * @return
	 * @throws BizException
	 */
	public MedTechAppDTO getMedTeckAppByNo(String no, String benId) throws BizException {
		StringBuilder sb = getAppLsSql();
		sb.append("where obs.no_applyform=?   and cior.ds =0");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(no);
		MedTechAppDTO result = (MedTechAppDTO) new DAFacade().execQuery(sb.toString(), sqlParam,
				new BeanHandler(MedTechAppDTO.class));
		if (result != null) {
			result.setId_ben(benId);
			List<MedTechAppDTO> mtAppDTOList = new ArrayList<MedTechAppDTO>();
			mtAppDTOList.add(result);
			this.loadMpDepInfo(mtAppDTOList, benId);
			result = mtAppDTOList.get(0);
		}
		return result;
	}

	/**
	 * 签到
	 * 
	 * @param appDTO 申请单DTO
	 */
	public MedTechAppDTO signIn(MedTechAppDTO appDTO) throws BizException {
		FDateTime datetime = EnAppUtils.getServerDateTime();
		IScDaysLotService dayslotQryService = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO daysLotDO = dayslotQryService.getNowDaysLot(IScDictCodeConst.SD_SCTP_MT, FBoolean.TRUE);

		// 判定是否取到午别
		if (daysLotDO == null) {
			throw new BizException("未取到当前午别 ");
		}
		// 判定执行科室是不是属于该分诊台
		if (!this.IsMpDepBelongToBen(appDTO)) {
			throw new BizException("该执行科室不属于本分诊台");
		}
		// 检查申请单的状态
		if (EnValidator.isEmpty(appDTO.getSd_su())) {
			throw new BizException("申请单状态为空");
		} else {
			checkAppSu(appDTO);
		}

		// 校验医嘱是否已核对 zhengcm 2019-01-19
		if ((!EnValidator.isEmpty(appDTO.getCode_entp()) && appDTO.getCode_entp().equals(
				IEnDictCodeConst.SD_ENTP_INPATIENT))
				&& !appDTO.getFg_chk().booleanValue()) {
			throw new BizException("检查申请医嘱未核对,不能签到处理!");
		}

		// 根据 是否是预约判定预约时间是否和当前时间相符
		if (!EnValidator.isEmpty(appDTO.getId_apt())) {
			this.checkAppTime(appDTO, datetime, daysLotDO);
		}
		if (EnValidator.isEmpty(appDTO.getId_apt())
				&& !(appDTO.getDt_plan().isSameDate(datetime.getDate()))) {
			throw new BizException("检查时间是" + appDTO.getDt_plan());
		}

		// 检查费用情况(zhengcm)
		if (null != appDTO) {
			// 查询门诊属性对应的挂号类型
			String regtp = this.getRegTp(appDTO);
			if ((null == regtp) || (null != regtp && !regtp.equals(EuRegTp.PAYAFTERDI))) {
				// 调用BL接口查询费用情况,通过费用情况来检查医技是否允许分诊
				if (!this.checkOrderFee(appDTO)) {
					throw new BizException("未缴费且可用额度不足，不允许签到！");
				}
			}
		}

		// 添加队列
		if (EnValidator.isEmpty(appDTO.getId_ent_que())) { // 就诊队列为空，插入新的就诊队列记录
			EnQueueDO endo = insertEnQue(appDTO, daysLotDO);
			appDTO.setId_ent_que(endo.getId_ent_que());
		} else {
			// IEnqueueCudService service =
			// ServiceFinder.find(IEnqueueCudService.class);
			if (!datetime.getDate().isSameDate((appDTO.getDt_regist()))) {
				// 如果时间不一致，则先删后曾
				EnQueBP enQueBP = new EnQueBP();
				enQueBP.delete(appDTO.getId_ent_que(), FBoolean.TRUE);
				// 新增
				EnQueueDO endo = insertEnQue(appDTO, daysLotDO);
				appDTO.setId_ent_que(endo.getId_ent_que());
			}
		}

		appDTO.setTriage_status(IEnDictCodeConst.SD_TRIAGE_ARRIVED);// 到诊
		appDTO.setSd_su(ICiDictCodeConst.SD_CI_OBS_YDJ);// 到检
		// 更新ci域 obs Sd_su_obs =2
		updateObsSu(appDTO, ICiDictCodeConst.SD_CI_OBS_YDJ);// 到检
		// 更新 cior Sd_su_mp = 1
		updateCiSu(appDTO);
		// 更新mp域 回写医嘱闭环状态
		this.rewriteOrClosedLoopState(appDTO);
		return appDTO;
	}

	/**
	 * 撤销签到
	 * 
	 * @param appDTO 申请单DTO
	 * @return
	 * @throws BizException
	 */
	public MedTechAppDTO cancelSignIn(MedTechAppDTO appDTO) throws BizException {

		if (!appDTO.getTriage_status().equals(IEnDictCodeConst.SD_TRIAGE_ARRIVED)) {
			throw new BizException("非到诊状态不能取消签到");
		}
		EnQueBP enQueBP = new EnQueBP();
		EnQueueDO enqueDO = enQueBP.getEnQue(appDTO.getId_ent_que());
		if (enqueDO == null) {// zhengcm 增加空值判断 2017-02-16
			throw new BizException("未取到队列");
		}
		if (enqueDO.getFg_apt() == null) {
			throw new BizException("未取到队列fg_acpt 的值");
		}
		if (enqueDO.getFg_apt().booleanValue()) {// 是预约的
			// 更新ci_ap_obs 将 sd_su_obs 设为 已安排
			this.updateObsSu(appDTO, ICiDictCodeConst.SD_CI_OBS_YAP);
		} else { // 不是预约的 设为已申请
			this.updateObsSu(appDTO, ICiDictCodeConst.SD_CI_OBS_SQ);
		}
		// 删除就诊队列
		enQueBP.delete(appDTO.getId_ent_que(), FBoolean.TRUE);

		// 更新医嘱状态
		this.updateCiOr(appDTO.getId_or());

		IForeignService mpUpService = ServiceFinder.find(IForeignService.class);
		mpUpService.OrpltpBack(appDTO.getId_or(), appDTO.getAppointment().toString(),
				IMpDictCodeTypeConst.SD_ORPLTPSTA_CHECK);

		return appDTO;
	}

	/**
	 * 获取就诊信息
	 * 
	 * @param entId 就诊ID
	 * @param entp 就诊类型
	 * @return
	 * @throws BizException
	 */
	public EntForMTDTO getEnt(String entId, String entp) throws BizException {
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(entp)
				|| IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(entp)) {
			IOutpatientRService opService = ServiceFinder.find(IOutpatientRService.class);
			String whereStr = String.format("id_ent='%s'", entId);
			OutpatientDO[] opDOs = opService.find(whereStr, null, FBoolean.TRUE);
			if (EnValidator.isEmpty(opDOs)) {
				return null;
			} else {
				EntForMTDTO entInfo = new EntForMTDTO();
				entInfo.setTicketno(opDOs[0].getTicketno().toString());
			}
		} else if (entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)) {
			List<EntForMTDTO> result = null;
			StringBuilder sb = new StringBuilder();
			sb.append("select ip.id_dep_nuradm as id_dep_nur,ip.id_bed,ip.name_bed,dep.name as name_dep_nur,ip.id_ent ");
			sb.append(" from en_ent_ip ip");
			sb.append(" left join bd_dep dep on ip.id_dep_nuradm = dep.id_dep ");
			sb.append(" where id_ent = ?");
			SqlParam sqlPara = new SqlParam();
			sqlPara.addParam(entId);
			result = (List<EntForMTDTO>) new DAFacade().execQuery(sb.toString(), sqlPara,
					new BeanListHandler(EntForMTDTO.class));
			if (!EnValidator.isEmpty(result)) {
				return result.get(0);
			}
		}
		return null;
	}

	/**
	 * 加上候诊 分诊数
	 * 
	 * @param triageQueSites
	 * @param benId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private TriageQueSiteDTO[] triageQueSiteAddNum(TriageQueSiteDTO[] triageQueSites, String benId,
			DaysLotDO daysLotDO) throws BizException {

		List<String> sb = new ArrayList<String>();
		for (TriageQueSiteDTO triDO : triageQueSites) {
			sb.add(triDO.getId_quesite());
		}
		StringBuilder builder = new StringBuilder();

		builder.append("  select eq.id_que_site id_quesite,  ");
		builder.append("  count(eq.id_ent) triagenum, ");
		builder.append("  sum(case when eq.sd_status_acpt = '7' then 0 when ");
		builder.append("  eq.sd_status_acpt = '8' then 0 else 1 end） waitnum from ");
		builder.append("  en_ent_que eq        ");
		builder.append("  where eq.fg_active='Y' ");
		builder.append("  and eq.dt_regist = ? ");
		builder.append("  and eq.id_dateslot= ?");
		builder.append("  and ").append(EnSqlUtils.getInSqlByIds("eq.id_que_site", sb));
		builder.append("  group by eq.id_que_site   ");

		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(EnAppUtils.getServerDateTime().getDate());
		param.addParam(daysLotDO.getId_dayslot());
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql, param,
				new BeanListHandler(TriageQueSiteDTO.class));
		if (!EnValidator.isEmpty(list)) {
			for (TriageQueSiteDTO site : triageQueSites) {
				if (site.getId_quesite() != null) {
					for (TriageQueSiteDTO site2 : list) {
						if (site.getId_quesite().equals(site2.getId_quesite())) {
							site.setTriagenum(site2.getTriagenum());
							site.setWaitnum(site2.getWaitnum());
							continue;
						}
					}
				}
			}
		}
		return triageQueSites;
	}

	/**
	 * 获取预约人数 这个方法虽然有，但是没用 原因是 上面的站点取不到排班的事件
	 * 
	 * @param triageQueSites
	 * @param benId
	 * @throws BizException
	 * @author ren_ying
	 */
	private void getAppointNumber(TriageQueSiteDTO[] triageQueSites, String benId)
			throws BizException {
		for (TriageQueSiteDTO site : triageQueSites) {
			if (EnValidator.isEmpty(site.getId_scres()))
				throw new BizException("未获取到排班计划资源");
			if (EnValidator.isEmpty(site.getId_scsrv()))
				throw new BizException("未获取到排班计划服务");
			if (EnValidator.isEmpty(site.getId_dep()))
				throw new BizException("未获取到队列部门");

			StringBuilder str = new StringBuilder();
			str.append("  select sch.quan_total_used, sch.id_sch,");
			str.append("  (sch.quan0_appt  - sch.quan0_used ) as quan_left");
			str.append("  from sc_pl pl");
			str.append("  inner join sc_sch sch");
			str.append("  on sch.id_scpl = pl.id_scpl");
			str.append("  where pl.id_scres = ?");
			str.append("  and pl.id_scsrv = ?");
			str.append("  and pl.id_dep = ?");
			str.append("  and pl.fg_active = ?");
			str.append("  and pl.sd_sctp = ?");
			str.append("  and sch.d_sch = ?");
			str.append("  and id_dayslot = ?");
			SqlParam param = new SqlParam();
			param.addParam(site.getId_scres());
			param.addParam(site.getId_scsrv());
			param.addParam(site.getId_dep());
			param.addParam("Y");
			param.addParam(IScDictCodeConst.SD_SCTP_MT);
			param.addParam(EnAppUtils.getServerDateTime().getDate());
			IScDaysLotService dayslotQryService = ServiceFinder.find(IScDaysLotService.class);
			DaysLotDO daysLotDO = dayslotQryService.getNowDaysLot(IScDictCodeConst.SD_SCTP_MT, FBoolean.TRUE);
			if (daysLotDO == null || daysLotDO.getName() == null)
				throw new BizException("未获取到午别");
			else {
				param.addParam(daysLotDO.getId_dayslot());
			}

			@SuppressWarnings("unchecked")
			List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(
					str.toString(), param, new BeanListHandler(TriageQueSiteDTO.class));
			if (!list.isEmpty()) {
				TriageQueSiteDTO triDTO = list.get(0);
				site.setQuan_appt_used(triDTO.getQuan_appt_used());
				site.setQuan_left(triDTO.getQuan_appt_used());
				site.setId_sch(triDTO.getId_sch());
			} else {
				site.setQuan_appt_used("0");
				site.setQuan_left("0");
			}

		}
	}

	/**
	 * 加载执行科室信息
	 * 
	 * @param mtAppDTOList
	 * @param benId 分诊台id
	 * @throws BizException
	 */
	private List<MedTechAppDTO> loadMpDepInfo(List<MedTechAppDTO> mtAppDTOList, String benId)
			throws BizException {
		SqlParam sqlParam = new SqlParam();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select distinct srv.ID_OR, srv.id_dep_mp ");
		sqlBuilder.append(" from ci_or_srv srv "); // 适当换行
		sqlBuilder.append(" where ").append(EnSqlUtils.getInSqlByIds("srv.ID_OR", EnAppUtils.getKeyPropArrayFromDO("Id_or", mtAppDTOList.toArray(new MedTechAppDTO[0]))));
		// if(!EnValidator.isEmpty(benId)){
		// sqlBuilder.append(" and srv.id_dep_mp in (SELECT ID_DEP FROM BD_QUE WHERE ID_QUEBEN =?)  ");
		// sqlParam.addParam(benId);
		// }
		@SuppressWarnings("unchecked")
		List<OrdSrvDO> ordSrvList = (List<OrdSrvDO>) new DAFacade().execQuery(
				sqlBuilder.toString(), sqlParam, new BeanListHandler(OrdSrvDO.class));

		List<String> idlist = new ArrayList<String>();
		for (OrdSrvDO depInfo : ordSrvList) {
			idlist.add(depInfo.getId_dep_mp());
		}
		IDeptRService depService = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptdos = depService.findByIds(idlist.toArray(new String[0]), FBoolean.FALSE);

		for (OrdSrvDO depInfo : ordSrvList) {
			for (DeptDO dep : deptdos) {
				if (depInfo.getId_dep_mp().equals(dep.getId_dep())) {
					depInfo.setDep_mp_name(dep.getName());
				}
			}

		}
		for (OrdSrvDO depInfo : ordSrvList) {
			for (MedTechAppDTO mtDTO : mtAppDTOList) {
				if (mtDTO.getId_or() == depInfo.getId_or()) {
					mtDTO.setId_ben(benId);
					mtDTO.setId_dep_mp(depInfo.getId_dep_mp());
					mtDTO.setDep_mp_name(depInfo.getDep_mp_name());
					break;
				}
			}
		}
		return mtAppDTOList;
	}

	/**
	 * 签到 更新申请单状态 为已到检
	 * 
	 * @param appDTO
	 * @param sdsu
	 * @throws BizException
	 */
	private void updateObsSu(MedTechAppDTO appDTO, String sdsu) throws BizException {
		ICiorapprisRService serR = ServiceFinder.find(ICiorapprisRService.class);
		ICiorapprisCudService service = ServiceFinder.find(ICiorapprisCudService.class);

		OrdApObsDO[] obss = serR.find("no_applyform='" + appDTO.getNo_applyform() + "'", null,
				FBoolean.FALSE);
		OrdApObsDO obs = null;
		if (obss != null && obss.length > 0)
			obs = obss[0];
		if (obs != null) {
			obs.setSd_su_obs(sdsu);
			service.update(new OrdApObsDO[] { obs });
		}
	}

	/**
	 * 签到时更新医嘱
	 * 
	 * @param appDTO
	 * @throws BizException
	 * @author ren_ying
	 */
	private void updateCiSu(MedTechAppDTO appDTO) throws BizException {
		if (EnValidator.isEmpty(appDTO.getId_or())) {
			throw new BizException("签到时未查到医嘱单医嘱");
		}
		ICiorderMDORService orRService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO ciOrDO = orRService.findById(appDTO.getId_or());
		if (ciOrDO != null) { // 医嘱的执行状态为已执行
			ciOrDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_PERFORMED); // 将医嘱的医技执行状态改为已执行
			ICiorderMDOCudService orCudService = ServiceFinder.find(ICiorderMDOCudService.class);
			orCudService.save(new CiOrderDO[] { ciOrDO });
		}
	}

	/**
	 * 预约时间检查
	 * 
	 * @param appDTO
	 * @throws BizException
	 * @author ren_ying
	 */
	private void checkAppTime(MedTechAppDTO appDTO, FDateTime datetime, DaysLotDO daysLotDO)
			throws BizException {
		if (EnValidator.isEmpty(appDTO.getApt_id_dateslot())) {
			throw new BizException(" 未取到预约午别时间 ");
		}
		if (appDTO.getApt_dt_b() == null) {
			throw new BizException(" 未取到预约时间 ");
		}
		if (!appDTO.getApt_id_dateslot().equals(daysLotDO.getId_dayslot())
				|| !(appDTO.getApt_dt_b().getDate().isSameDate(datetime.getDate()))) {
			IDayslotMDORService daysLotRService = ServiceFinder.find(IDayslotMDORService.class);
			DaysLotDO dLotDO = daysLotRService.findById(appDTO.getApt_id_dateslot());
			throw new BizException(" 预约的时间为 " + appDTO.getApt_dt_b().getDate() + "  "
					+ dLotDO.getName() + "，和当前时间不一致，请按预约时间签到! ");
		}
	}

	/**
	 * 检查申请单的状态
	 * 
	 * @param appDTO
	 * @throws BizException
	 */
	private void checkAppSu(MedTechAppDTO appDTO) throws BizException {
		if (appDTO.getSd_su().equals(ICiDictCodeConst.SD_CI_OBS_YJC)) {
			throw new BizException("申请单状态是已检查，不能签到处理");
		}
		if (appDTO.getSd_su().equals(ICiDictCodeConst.SD_CI_OBS_BG)) {
			throw new BizException("申请单状态是已报告，不能签到处理");
		}
		if (appDTO.getSd_su().equals(ICiDictCodeConst.SD_CI_OBS_YQX)) {
			throw new BizException("申请单状态是已取消，不能签到处理");
		}
	}

	/**
	 * 取消签到后，更新医嘱状态
	 * 
	 * @param orId
	 * @throws BizException
	 */
	private void updateCiOr(String orId) throws BizException {
		ICiorderMDORService orRService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO ciOrDO = orRService.findById(orId);
		if (ciOrDO != null && ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(ciOrDO.getSd_su_mp())) { // 医嘱的执行状态为已执行
			ciOrDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
			ICiorderMDOCudService orCudService = ServiceFinder.find(ICiorderMDOCudService.class);
			orCudService.save(new CiOrderDO[] { ciOrDO });
		}
	}

	/**
	 * 插入就诊队列
	 * 
	 * @param idor
	 * @param benId
	 * @return
	 * @throws BizException
	 */
	private EnQueueDO insertEnQue(MedTechAppDTO appDTO, DaysLotDO daysLotDO) throws BizException {
		FDateTime curTime = EnAppUtils.getServerDateTime();
		EnQueueDO enquedo = new EnQueueDO();
		ICiorderMDORService ciorderservice = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO ciorder = ciorderservice.findById(appDTO.getId_or());
		PatiVisitDO pdo = null;
		if (ciorder != null && ciorder.getId_en() != null) {
			IPativisitRService patservice = ServiceFinder.find(IPativisitRService.class);
			pdo = patservice.findById(ciorder.getId_en());
			if (pdo != null) {
				enquedo.setId_ent(pdo.getId_ent());
				enquedo.setId_enttp(pdo.getId_entp());
				enquedo.setCode_entp(pdo.getCode_entp());
				enquedo.setId_pat(pdo.getId_pat());
				enquedo.setName_pat(pdo.getName_pat());
				enquedo.setId_patca(pdo.getId_patca());
			}
		}
		PsnDocDO psnDoc = EnContextUtils.getPsnDoc();
		if (psnDoc != null) {
			enquedo.setId_emp_acpt(psnDoc.getId_psndoc());
			enquedo.setName_emp_acpt(psnDoc.getName());
		}

		if (EnValidator.isEmpty(appDTO.getId_apt())) { // 不是预约
			enquedo.setFg_apt(FBoolean.FALSE);
		} else {
			enquedo.setFg_apt(FBoolean.TRUE);
		}
		enquedo.setId_ord(appDTO.getId_or());
		enquedo.setDt_regist(EnAppUtils.getServerDateTime().getDate());
		enquedo.setFg_active(FBoolean.TRUE);
		enquedo.setDt_in(curTime);
		enquedo.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		enquedo.setDt_acpt(curTime);
		enquedo.setStatus(DOStatus.NEW);
		enquedo.setSd_entque_tp(IBdFcDictCodeConst.SD_QUETP_MT);
		enquedo.setId_entque_tp(IBdFcDictCodeConst.ID_QUETP_MT);
		enquedo.setId_queben(appDTO.getId_ben());
		enquedo.setId_dateslot(daysLotDO.getId_dayslot());
		enquedo.setId_grp(EnContextUtils.getGrpId());
		enquedo.setId_org(EnContextUtils.getOrgId());
		enquedo.setLevel_pri(0);// 优先级别默认为0
		EnQueueDO[] results = null;
		IEnqueueCudService sevice = ServiceFinder.find(IEnqueueCudService.class);

		results = sevice.save(new EnQueueDO[] { enquedo });

		return results[0];
	}

	/**
	 * 查询所有医技申请单SQL
	 * 
	 * @param lest
	 * @param jions
	 * @return
	 */
	private StringBuilder getMedSql(String lest, String jions) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select distinct apt.id_sch, ");
		sb.append(" apt.id_apt, ");
		sb.append(" apt.dt_b as Apt_dt_b, ");
		sb.append(" apt.id_dateslot,");
		sb.append(" en.code_entp,");
		sb.append(" dep.name as  Dep_apply_name,");
		sb.append(" en.id_sex_pat,");
		sb.append(" en.id_pat,");
		sb.append(" en.id_ent,");
		sb.append(" en.sd_sex_pat,");
		sb.append(" en.id_sex_pat,");
		sb.append(" en.name_pat,");
		sb.append(" eq.dt_in,");// --到达日期
		sb.append(" eq.id_que,");
		sb.append(" eq.id_que_site,");// --工作点
		sb.append(" eq.id_ent_que,");
		sb.append(" eq.level_pri,");
		sb.append(" eq.sortno,"); // --顺序
		sb.append(" eq.sd_status_acpt,"); // --- 接受状态 1 未到诊 0 到诊，1-叫号，2. 叫号未到，
											// 3 已接受。
		sb.append(" eq.dt_regist,");// --就诊日期
		sb.append(" eq.code_entp,");// 就诊类型 zhengcm 2017-02-14
		sb.append(" q.name que_name,"); // --队列名称
		sb.append(" cior.id_or,");
		sb.append(" cior.dt_effe appointment,");
		sb.append(" cior.des_or,");
		sb.append(" cior.content_or,");
		sb.append(" cior.id_dep_or id_dep_apply,");
		sb.append(" cior.id_emp_or id_emp_ap,");
		sb.append(" obs.no_applyform,");
		sb.append(" obs.dt_plan,");
		sb.append(" obs.sd_su_obs sd_su,");
		sb.append(" CASE WHEN (eq.sd_status_acpt = '0' and ");
		sb.append(" (eq.id_que_site != '~' or eq.id_que_site is not null)) THEN '1' ");
		sb.append(" WHEN eq.sd_status_acpt = '0' THEN  '0' ");
		sb.append(" WHEN (eq.sd_status_acpt = '1' or eq.sd_status_acpt = '2') THEN '2' ");
		sb.append(" WHEN eq.sd_status_acpt = '7' THEN  '3' ");
		sb.append(" WHEN eq.sd_status_acpt = '8' THEN  '4' ");
		sb.append(" END AS triage_status ");
		sb.append(" from en_ent_que eq ");
		sb.append(" left outer join bd_que q ");
		sb.append(" on eq.id_que = q.id_que ");
		sb.append(" inner join en_ent en ");
		sb.append(" on eq.id_ent = en.id_ent ");
		sb.append(" inner join ci_order cior ");
		sb.append(" on eq.id_ord = cior.id_or ");
		sb.append(" inner join ci_ap_obs obs ");
		sb.append(" on eq.id_ord = obs.id_or ");
		sb.append(" left join sc_apt_appl appl on appl.id_or = obs.id_or ");
		sb.append(" left join sc_apt_mt mt on mt.id_aptappl = appl.id_aptappl ");
		sb.append(" left join sc_apt apt on mt.id_apt = apt.id_apt and apt.fg_canc = 'N' ");
		sb.append(" left join bd_dep dep ");
		sb.append(" on dep.id_dep = cior.id_dep_or ");
		return sb;
	}

	/**
	 * 查申请单的sql 根据患者
	 * 
	 * @return
	 */
	private StringBuilder getAppLsSql() {
		StringBuilder sb = new StringBuilder();
		sb.append("  select distinct apt.id_sch, ");
		sb.append("  apt.id_apt, ");
		sb.append("  apt.dt_b as Apt_dt_b, ");
		sb.append("  apt.id_dateslot,");
		sb.append("  obs.sd_su_obs   sd_su,");
		sb.append("  obs.dt_plan,");
		sb.append("  obs.no_applyform,");
		sb.append("  cior.id_or,");
		sb.append("  cior.dt_effe as appointment,");
		sb.append("  cior.des_or,");
		sb.append("  cior.content_or,");
		sb.append("  cior.id_dep_or as id_dep_apply,");
		sb.append("  cior.id_emp_or as id_emp_ap ,");
		sb.append("  eq.id_queben,");
		sb.append("  eq.id_ent_que,");
		sb.append("  eq.sd_status_acpt,");
		sb.append("  eq.dt_regist,");
		sb.append("  cior.fg_chk,");
		sb.append("  en.id_pat,");
		sb.append("  en.id_ent,");
		sb.append("  en.name_pat,");
		sb.append("  en.id_sex_pat,");
		sb.append("  en.sd_sex_pat,");
		sb.append("  en.code_entp,");
		sb.append("  apt.dt_b as apt_dt_b, ");
		sb.append("  apt.id_dateslot as Apt_id_dateslot,");
		sb.append("  apt.id_apt");
		sb.append("  from ci_ap_obs obs");
		sb.append("  inner join ci_order cior");
		sb.append("    on cior.id_or = obs.id_or");
		sb.append("  inner join en_ent en");
		sb.append("    on cior.id_en = en.id_ent");
		sb.append("  left outer join en_ent_que eq");
		sb.append("   on obs.id_or = eq.id_ord");
		sb.append(" left join sc_apt_appl appl on appl.id_or = obs.id_or ");
		sb.append(" left join sc_apt_mt mt on mt.id_aptappl = appl.id_aptappl ");
		sb.append("  left join sc_apt apt on mt.id_apt = apt.id_apt and apt.fg_canc = 'N' ");// zhengcm
																								// 2017-01-17
																								// 增加预约取消条件
		sb.append(" ");
		return sb;
	}

	/**
	 * 判断执行科室是不是属于该分诊台
	 * 
	 * @param appDTO
	 * @return
	 * @throws BizException
	 * @author Ren_ying
	 */
	private Boolean IsMpDepBelongToBen(MedTechAppDTO appDTO) throws BizException {
		String queben = EnParamUtils.getMedTechBenId(EnContextUtils.getRealPcId());
		if (EnValidator.isEmpty(queben)) {
			throw new BizException("未获取到分诊台");
		}
		Boolean flag = false;
		IQueRService queRService = ServiceFinder.find(IQueRService.class);
		QueDO[] queDOs = queRService.find(QueDODesc.TABLE_ALIAS_NAME + ".id_queben = '" + queben
				+ "'", null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(queDOs)) {
			for (QueDO quedo : queDOs) {
				if (quedo.getId_dep().equals(appDTO.getId_dep_mp()))
					flag = FBoolean.TRUE.booleanValue();
			}
		} else {
			throw new BizException("该分诊台没有对应的科室");
		}

		return flag;
	}

	/**
	 * 获取执行科室
	 * 
	 * @param result
	 * @param benId
	 * @throws BizException
	 */
	private void getMpDept(List<MedTechAppDTO> result, String benId) throws BizException {
		// 加载执行科室信息
		result = this.loadMpDepInfo(result, benId);

		for (MedTechAppDTO medTechApp : result) {
			if (medTechApp.getId_dep_apply() != null || medTechApp.getId_dep_mp() != null) {
				String[] str = new String[] { medTechApp.getId_dep_apply(),
						medTechApp.getId_dep_mp() };
				IDeptRService deptRService = ServiceFinder.find(IDeptRService.class);
				DeptDO[] depts = deptRService.findByBIds(str, FBoolean.FALSE);
				if (!EnValidator.isEmpty(depts)) {
					for (DeptDO dep : depts) {
						if (!EnValidator.isEmpty(medTechApp.getId_dep_apply())
								&& medTechApp.getId_dep_apply().equals(dep.getId_dep())) {
							medTechApp.setDep_apply_name(dep.getName());
						}
						if (!EnValidator.isEmpty(medTechApp.getId_dep_mp())
								&& medTechApp.getId_dep_mp().equals(dep.getId_dep())) {
							medTechApp.setDep_mp_name(dep.getName());
						}
					}
				}
			}
			if (medTechApp.getId_emp_ap() != null) {
				IPsndocMDORService psnRService = ServiceFinder.find(IPsndocMDORService.class);
				PsnDocDO psndoc = psnRService.findById(medTechApp.getId_emp_ap());
				if (psndoc != null) {
					medTechApp.setName_emp_ap(psndoc.getName());
				}
			}
		}
	}

	/**
	 * 根据性别id获取性别名称
	 * 
	 * @param mtAppDTOList
	 * @throws BizException
	 */
	private void getSexName(List<MedTechAppDTO> mtAppDTOList) throws BizException {
		for (MedTechAppDTO medTechAppDTO : mtAppDTOList) {
			if (!EnValidator.isEmpty(medTechAppDTO.getId_sex_pat())) {
				IUdidocRService sexService = ServiceFinder.find(IUdidocRService.class);
				UdidocDO udiSexDO = sexService.findById(medTechAppDTO.getId_sex_pat());
				if (udiSexDO != null && !EnValidator.isEmpty(udiSexDO.getName())) {
					medTechAppDTO.setName_sex(udiSexDO.getName());
				}
			}

		}
	}

	/**
	 * 更新排班预约申请的状态为完成
	 * 
	 * @author zhengcm
	 * @param aptDO 排班预约申请DO
	 * @throws BizException
	 */
	private void updateScAptFilishedStatus(ScAptDO aptDO) throws BizException {
		if (null == aptDO) {
			return;
		}
		IScaptMDOCudService cmdService = ServiceFinder.find(IScaptMDOCudService.class);
		// 修改申请单状态为完成（3）
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO.setSd_status("3");
		cmdService.update(new ScAptDO[] { aptDO });
	}

	/**
	 * 查询当前就诊的门诊属性对应的挂号类型
	 *
	 * @param appDTO 医技检查申请单DTO
	 * @return 挂号类型编码
	 * @throws BizException
	 * @author zhengcm
	 */
	private String getRegTp(MedTechAppDTO appDTO) throws BizException {
		// 门诊属性查询服务
		IOutpatientRService opQryService = ServiceFinder.find(IOutpatientRService.class);
		OutpatientDO[] opDOs = opQryService.find("id_ent = '" + appDTO.getId_ent() + "'", null,
				FBoolean.FALSE);
		if (opDOs != null && opDOs.length > 0) {
			return opDOs[0].getEu_regtp();
		}
		return null;
	}

	/**
	 * 通过费用情况来检查医技是否允许分诊
	 *
	 * @param appDTO 医技检查申请单DTO
	 * @return 是否允许分诊
	 * @author zhengcm
	 */
	public Boolean checkOrderFee(MedTechAppDTO appDTO) throws BizException {
		// 门诊费用查询接口
		IBlcgqueryService blService = ServiceFinder.find(IBlcgqueryService.class);
		FMap map = blService.fSupportTriage_CiOrderFee(new String[] { appDTO.getId_or() });
		if (null != map) {
			if (map.containsKey(appDTO.getId_or())) {
				String result = map.get(appDTO.getId_or()).toString();
				// 0 (已计费) - 允许分诊
				// 1 (未计费，可用额度充足) - 允许分诊
				// 2 (未缴费,可用额度不足) - 不允许分诊
				if (result.equals(IBlCgCodeConst.CODE_CI_NO_PRICING_NO_PAYPAMET)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 校验检查申请单和排班科室是否一致
	 *
	 * @param techDTO 医技检查申请DTO
	 * @param siteDTO 分诊台队列或工作站点DTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private void checkIsSameDep(MedTechAppDTO techDTO, TriageQueSiteDTO siteDTO)
			throws BizException {
		if (null == techDTO || null == techDTO.getId_sch()) {
			return;
		}
		// 查询申请单对应医嘱的执行科室
		CiOrderDO orderDO = ServiceFinder.find(ICiorderMDORService.class).findById(
				techDTO.getId_or());
		if (null == orderDO) {
			return;
		}
		// 查询排班科室（排班对应的排班计划的计划科室）
		ScPlanDO planDO = null;
		ScSchDO schDO = ServiceFinder.find(IScschMDORService.class).findById(techDTO.getId_sch());
		if (null != schDO && null != schDO.getId_scpl()) {
			planDO = ServiceFinder.find(IScplanRService.class).findById(schDO.getId_scpl());
		}
		if (null == planDO || null == planDO.getId_dep()) {
			return;
		}
		// 校验科室是否一致
		if (!orderDO.getId_dep_mp().equals(planDO.getId_dep())) {
			// 查询科室名称
			EnDepDO[] depDOs = ServiceFinder.find(IEndepRService.class).findByBIds(
					new String[] { orderDO.getId_dep_mp(), planDO.getId_dep() }, FBoolean.FALSE);
			if (EnValidator.isEmpty(depDOs)) {
				return;
			}
			Map<String, String> map = new HashMap<String, String>();
			for (EnDepDO depDO : depDOs) {
				map.put(depDO.getId_dep(), depDO.getDep_name());
			}
			throw new BizException("申请的科室是" + map.get(orderDO.getId_dep_mp()) + ", 不可以分诊到"
					+ map.get(planDO.getId_dep()) + " 科室!");
		}
	}

	/**
	 * 获取分诊台过滤SQL
	 *
	 * @param id_or 申请单对应的医嘱服务id
	 * @return 过滤sql
	 * @throws BizException
	 * @author zhengcm
	 */
	private String getFilterSchSql(String id_or) throws BizException {
		if (EnValidator.isEmpty(id_or)) {
			return null;
		}
		String nowDate = EnAppUtils.getServerDateTime().getBeginDate().toString();
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct ");
		sql.append("sch.id_sch ");
		sql.append("from ");
		sql.append("sc_sch sch ");
		sql.append("inner join sc_tick tick on sch.id_sch = tick.id_sch ");
		sql.append("inner join sc_pl scpl on sch.id_scpl = scpl.id_scpl ");
		sql.append("inner join sc_srv_rel rel on rel.id_scsrv = tick.id_scsrv ");
		sql.append("inner join ci_order cior on cior.id_srv = rel.id_mdsrv ");
		sql.append("where ");
		sql.append("scpl.id_dep = cior.id_dep_mp ");
		sql.append("and cior.id_or = '" + id_or + "' ");
		sql.append("and sch.d_sch = '" + nowDate + "'");
		return sql.toString();
	}

	/**
	 * 根据医嘱获取服务ID
	 *
	 * @param techDTO 医技检查申请单DTO
	 * @return 医嘱对应的服务ID
	 * @throws BizException
	 * @author zhengcm
	 */
	private String getSrvIdByOrder(MedTechAppDTO techDTO) throws BizException {
		if (null == techDTO || EnValidator.isEmpty(techDTO.getId_or())) {
			return null;
		}
		ICiorderMDORService ordService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO orderDO = ordService.findById(techDTO.getId_or());
		if (null != orderDO) {
			return orderDO.getId_srv();
		}
		return null;
	}

	/**
	 * 过滤掉重复的申请单
	 *
	 * @param appList
	 * @return
	 * @throws BizException
	 * @author zhengcm 2017-01-17 申请单预约 - 取消预约后会出现重复数据
	 */
	private List<MedTechAppDTO> filterSameApp(List<MedTechAppDTO> appList) throws BizException {
		if (EnValidator.isEmpty(appList)) {
			return appList;
		}
		Map<String, MedTechAppDTO> dataMap = new HashMap<String, MedTechAppDTO>();
		for (MedTechAppDTO dto : appList) {
			String key = dto.getNo_applyform();
			if (dataMap.containsKey(key)) {
				if (!EnValidator.isEmpty(dto.getId_apt())) {
					dataMap.put(key, dto);
				}
			} else {
				dataMap.put(key, dto);
			}
		}
		List<MedTechAppDTO> resultList = new ArrayList<MedTechAppDTO>();
		for (Map.Entry<String, MedTechAppDTO> entry : dataMap.entrySet()) {
			resultList.add(entry.getValue());
		}
		return resultList;
	}

	/**
	 * 分诊时检查工作站点
	 *
	 * @param id_quesite
	 * @throws BizException
	 * @author zhengcm
	 */
	private void checkQueSite(String id_quesite) throws BizException {
		if (EnValidator.isEmpty(id_quesite)) {
			return;
		}
		IQuesiteRService siteRService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO queSiteDO = siteRService.findById(id_quesite);
		if (queSiteDO == null) {
			throw new BizException("工作站点不存在！");
		}
		if (queSiteDO.getEu_pause().equals(PauseEnum.PAUSE)) {
			throw new BizException("工作站点[" + queSiteDO.getName() + "]已暂停，不允许分诊！");
		}
		if (queSiteDO.getEu_pause().equals(PauseEnum.OFFLINE)) {
			throw new BizException("工作站点[" + queSiteDO.getName() + "]已离线，不允许分诊！");
		}
	}

	/**
	 * 检查已预约申请单自动分诊时是否允许
	 *
	 * @param techDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private boolean checkAptAppSite(MedTechAppDTO techDTO) throws BizException {
		IScaptMDORService aptRService = ServiceFinder.find(IScaptMDORService.class);
		ScAptDO scapt = aptRService.findById(techDTO.getId_apt());
		if (scapt == null || scapt.getQueno() == null) {
			return false;
		}
		if (EnValidator.isEmpty(scapt.getId_sch())) {
			return false;
		}
		IQueQryService queRService = ServiceFinder.find(IQueQryService.class);
		QueDO queDos = queRService.getQue(scapt.getId_scres(), scapt.getId_dep_appt(), null, IBdFcDictCodeConst.SD_QUETP_MT);
		if (queDos == null) {
			return false;
		}
		IQuesiteRService quesiteRService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO[] queSites = quesiteRService.find(QueSiteDODesc.TABLE_ALIAS_NAME + ".id_que = '"
				+ queDos.getId_que() + "'", null, FBoolean.FALSE);
		if (EnValidator.isEmpty(queSites)) {
			return false;
		}
		// 检查工作点是否离线或暂停
		return this.checkQueSiteStatus(queSites[0].getId_quesite());
	}

	/**
	 * 检查站点状态
	 *
	 * @param id_quesite
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private boolean checkQueSiteStatus(String id_quesite) throws BizException {
		if (EnValidator.isEmpty(id_quesite)) {
			return false;
		}
		IQuesiteRService siteRService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO queSiteDO = siteRService.findById(id_quesite);
		if (queSiteDO == null) {
			return false;
		}
		if (queSiteDO.getEu_pause().equals(PauseEnum.PAUSE)
				|| queSiteDO.getEu_pause().equals(PauseEnum.OFFLINE)) {
			return false;
		}
		return true;
	}
	
	/***
	 * 根据医技检查申请信息回写医嘱闭环状态
	 * @author yzh
	 * @param MedTechAppDTO appDTO 医技预约申请单
	 * @throws BizException 
	 */
	private void rewriteOrClosedLoopState(MedTechAppDTO appDTO) throws BizException{
		// 拼装回写医嘱闭环状态的入参数据
		OrPlanDTO orPlanDto = new OrPlanDTO();
		orPlanDto.setId_or(appDTO.getId_or());
		orPlanDto.setDt_mp_plan(appDTO.getAppointment());
		orPlanDto.setEu_tp(1);
		orPlanDto.setId_dep(EnContextUtils.getDeptId());
		orPlanDto.setId_emp(EnContextUtils.getPsnId());
		orPlanDto.setDt_exe(EnAppUtils.getServerDateTime());
		// 调用执行域接口回写医嘱闭环状态
		IMporInternalService mporInternalService = ServiceFinder.find(IMporInternalService.class);
		// 44101505=医技辅科室分诊 功能节点编码
		mporInternalService.updateOrpltpByOr(new OrPlanDTO[]{orPlanDto}, "44101505", null);
	}
}
