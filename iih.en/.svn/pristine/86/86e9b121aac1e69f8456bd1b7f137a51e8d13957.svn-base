package iih.en.er.bp.enprquery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.util.DateTimeUtils;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EnErPrQueryDTO;
import iih.en.er.dto.d.EuUrgInOutTransStatus;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 急诊预检查询卡
 * 
 * @author 黄炎
 *
 */
public class GetEnErPrQuery {

	public PagingRtnData<EnErPrQueryDTO> exec(EnErPrQueryDTO enErPrQueryDTO, PaginationInfo pageInfo)
			throws BizException {
		FDateTime endDateTime = EnAppUtils.getServerDateTime();
		SqlParam sqlParam = new SqlParam();
		// 1.查预检
		String sql = this.getSql(enErPrQueryDTO, sqlParam);
		PagingRtnData<EnErPrQueryDTO> ret = this.getRtnData(pageInfo, sql, sqlParam);
		FArrayList list = ret.getPageData();
		if (list == null || list.size() <= 0)
			return ret;
		EnErPrQueryDTO[] enErPrQueryDTOs = (EnErPrQueryDTO[]) list.toArray(new EnErPrQueryDTO[] {});
		String[] Id_ent_lasts = EnAppUtils.getKeyPropArrayFromDO("Id_ent_last", enErPrQueryDTOs);
		String[] Id_ent_ips = EnAppUtils.getKeyPropArrayFromDO("Id_ent_ip", enErPrQueryDTOs);

		// 2.查住院就诊
		Map<String, EnErPrQueryDTO> ipInfo = getIpInfo(Id_ent_ips, enErPrQueryDTO);
		// 3.查门诊就诊
		Map<String, EnErPrQueryDTO> opInfo = getOpInfo(Id_ent_lasts, enErPrQueryDTO);

		IUdidocServiceExt iUdidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		Map<String, String> triageto = this
				.getUdidocMap(iUdidocServiceExt.findByUdidoclistCode(IEnDictCodeTypeConst.SD_ERPRE_TRIAGETO));
		Map<String, String> goMap = this
				.getUdidocMap(iUdidocServiceExt.findByUdidoclistCode(IEnDictCodeTypeConst.SD_ER_GOWHERE));
		// 4.分诊分级的获取
		ErPreEP erPreEP = new ErPreEP();
		erPreEP.setErScoleName((EnErPrQueryDTO[]) list.toArray(new EnErPrQueryDTO[] {}), "Sd_scale_hm",
				"Name_scale_hm");
		// 5.处理查询结果
		if (ret != null) {
			for (Object obj : enErPrQueryDTOs) {
				EnErPrQueryDTO outDTO = (EnErPrQueryDTO) obj;
				setInfo(outDTO, ipInfo, opInfo);
				// 计算年龄
				this.getPatAge(outDTO);
				// 判断患者身份
				this.getPatstatus(outDTO);
				// 获取滞留时间
				this.getDetDura(outDTO, endDateTime);
				// 判断分诊去向
				this.getNameLevel(outDTO, triageto);
				// 设置就诊状态
				this.setNameStatus(outDTO);
				// 设置预检状态
				this.setNameErpreStatus(outDTO);
				// 设置就诊去向，fanlq-2019-04-08
				this.getNameGoWhere(outDTO, goMap);
			}
		}
		return ret;
	}

	public String getSql(EnErPrQueryDTO enErPrQueryDTO, SqlParam sqlParam) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select pat.id_pat, ");// 患者id
		stringBuilder.append("pre.id_erpre, ");// 预检id
		stringBuilder.append("pre.dt_entry as dt_entry, ");// 到院日期
		stringBuilder.append("pre.dt_end as dt_end, ");// 出院日期
		stringBuilder.append("pre.id_ent_ip, ");// 留观id
		stringBuilder.append("pat.code as pat_code, ");// 患者编码
		stringBuilder.append("pat.name as pat_name, ");// 患者姓名
		stringBuilder.append("pat.dt_birth as pat_birth, ");// 患者出生日期
		stringBuilder.append("pre.code as erpre_code, ");// 预检码
		stringBuilder.append("pre.fg_nonperson as fg_nonperson, ");// 三无人员
		stringBuilder.append("pre.sd_scale_hm as sd_scale_hm, ");// 预检分级
		stringBuilder.append("pre.sd_triage_to as sd_triage_to, ");// 分诊去向
		stringBuilder.append("dep.name as name_dep_phy, ");// 去向科室
		stringBuilder.append("pat.id_paticate, ");// 患者分类
		stringBuilder.append("patca.name as name_paticate, ");// 患者分类名称
		stringBuilder.append("pat.id_patpritp, ");// 价格分类
		stringBuilder.append("pripat.name as name_patpritp, ");// 价格分类名称
		stringBuilder.append("pre.sd_status as erpre_status, ");// 预检状态
		stringBuilder.append("pre.id_emp_pre as id_emp_operator, ");// 预检人员id
		stringBuilder.append("psndoc.name as name_emp_operator, ");// 预检人员名称
		stringBuilder.append("pre.id_ent_last ");
		stringBuilder.append("from en_erpre pre ");
		stringBuilder.append("left join pi_pat pat on pat.id_pat = pre.id_pat ");
		stringBuilder.append("left join bd_dep dep on pre.id_dep_to = dep.id_dep ");
		stringBuilder.append("left join bd_psndoc psndoc on pre.id_emp_pre = psndoc.id_psndoc ");
		stringBuilder.append("left join pi_pat_ca patca on patca.id_patca = pat.id_paticate ");
		stringBuilder.append("left join bd_pri_pat pripat on pripat.id_pripat = pat.id_patpritp ");
		stringBuilder.append("where 1 = 1 ");
		/**
		 * 开始时间
		 */
		if (enErPrQueryDTO.getBegin_time() != null) {
			stringBuilder.append(" And pre.dt_entry >= ? ");
			sqlParam.addParam(enErPrQueryDTO.getBegin_time());
		}
		/**
		 * 结束时间
		 */
		if (enErPrQueryDTO.getEnd_time() != null) {
			stringBuilder.append(" And pre.dt_entry < ? ");
			sqlParam.addParam(enErPrQueryDTO.getEnd_time().getDateAfter(1));
		}
		/**
		 * 科室ID
		 */
		if (!EnValidator.isEmpty(enErPrQueryDTO.getId_dep_phy_ref())) {
			stringBuilder.append(" And pre.id_dep_to = ? ");
			sqlParam.addParam(enErPrQueryDTO.getId_dep_phy_ref());
		}
		/**
		 * 预检人员id
		 */
		if (!EnValidator.isEmpty(enErPrQueryDTO.getId_createby_ref())) {
			stringBuilder.append(" And pre.id_emp_pre = ? ");
			sqlParam.addParam(enErPrQueryDTO.getId_createby_ref());
		}
		/**
		 * 分诊去向
		 */
		if (!EnValidator.isEmpty(enErPrQueryDTO.getSd_triage_to_ref())) {
			stringBuilder.append(" And pre.sd_triage_to = ? ");
			sqlParam.addParam(enErPrQueryDTO.getSd_triage_to_ref());
		}
		/**
		 * 预检分级
		 */
		if (!EnValidator.isEmpty(enErPrQueryDTO.getSd_scale_hm_ref())) {
			stringBuilder.append(" And pre.sd_scale_hm = ? ");
			sqlParam.addParam(enErPrQueryDTO.getSd_scale_hm_ref());
		}
		/**
		 * 就诊去向
		 */
		/**
		 * if (!EnValidator.isEmpty(enErPrQueryDTO.getId_gowhere_er_ref())) {
		 * stringBuilder.append(" And er.id_gowhere_er = ? ");
		 * sqlParam.addParam(enErPrQueryDTO.getId_gowhere_er_ref()); }
		 */
		/**
		 * 患者姓名
		 */
		if (!EnValidator.isEmpty(enErPrQueryDTO.getPat_name())) {
			stringBuilder.append(" And pre.name_pat = ? ");
			sqlParam.addParam(enErPrQueryDTO.getPat_name());
		}
		/**
		 * 患者编号
		 */
		if (!EnValidator.isEmpty(enErPrQueryDTO.getPat_code())) {
			stringBuilder.append(" And pat.code = ? ");
			sqlParam.addParam(enErPrQueryDTO.getPat_code());
		}
		/**
		 * 预检状态
		 */
		if (!EnValidator.isEmpty(enErPrQueryDTO.getErpre_status())
				&& !("-1".equals(enErPrQueryDTO.getErpre_status()))) {// "-1"代表查询"全部"
																		// zhang.zl
																		// 2019.5.21
			stringBuilder.append(" And pre.sd_status = ? ");
			sqlParam.addParam(enErPrQueryDTO.getErpre_status());
		}
		/**
		 * 就诊状态
		 */
		/**
		 * if (!EnValidator.isEmpty(enErPrQueryDTO.getSd_status_ref()) &&
		 * !("-1".equals(enErPrQueryDTO.getSd_status_ref()))) {//"-1"代表查询"全部"
		 * stringBuilder.append(" And op.sd_status = ? ");
		 * sqlParam.addParam(enErPrQueryDTO.getSd_status_ref()); }
		 */
		stringBuilder.append(" order by pre.dt_entry ");
		return stringBuilder.toString();
	}

	private PagingRtnData<EnErPrQueryDTO> getRtnData(PaginationInfo pageInfo, String sql, SqlParam param)
			throws BizException {
		PagingServiceImpl<EnErPrQueryDTO> pageQryService = new PagingServiceImpl<EnErPrQueryDTO>();
		return pageQryService.findByPageInfo(new EnErPrQueryDTO(), pageInfo, sql, null, param);
	}

	/**
	 * 查询身份
	 * 
	 * @param depDTO
	 */
	private void getPatstatus(EnErPrQueryDTO depDTO) {
		if (!EnValidator.isEmpty(depDTO.getSd_status_ref()) && depDTO.getFg_acpt_nur() != null) {
			if (IEnDictCodeConst.SD_STATUS_ERPRE_VISIT.equals(depDTO.getSd_status_ref())
					&& depDTO.getFg_acpt_nur().equals(FBoolean.FALSE)) {
				depDTO.setPat_status(EuUrgInOutTransStatus.UNENTRY);// 未入科
			}
			if (IEnDictCodeConst.SD_STATUS_ERPRE_VISIT.equals(depDTO.getSd_status_ref())
					&& depDTO.getFg_acpt_nur().equals(FBoolean.TRUE)) {
				depDTO.setPat_status(EuUrgInOutTransStatus.INDEP);// 已入科
			}
			if (IEnDictCodeConst.SD_STATUS_ERPRE_END.equals(depDTO.getSd_status_ref())) {
				depDTO.setPat_status(EuUrgInOutTransStatus.OUTDEP);// 出科
			}
		}
	}

	/**
	 * 获取患者的滞留时间
	 * 
	 * @param depDTO
	 * @param endDateTime
	 */
	private void getDetDura(EnErPrQueryDTO depDTO, FDateTime endDateTime) {
		if (depDTO.getDt_entry() != null) {
			String result = null;
			if (depDTO.getDt_end() != null) {
				result = DateTimeUtils.getTimeLength(depDTO.getDt_entry(), depDTO.getDt_end());
			} else {
				result = DateTimeUtils.getTimeLength(depDTO.getDt_entry(), endDateTime);
			}
			depDTO.setDet_dura(result);
		}
	}

	/**
	 * 查询年龄
	 * 
	 * @param depDTO
	 */
	private void getPatAge(EnErPrQueryDTO depDTO) {
		depDTO.setPat_age(AgeCalcUtil.getAge(depDTO.getPat_birth()));
	}

	/**
	 * 获得患者分诊去向
	 * 
	 * @param depDTO
	 * @param udidocDOsLevel
	 * @throws BizException
	 */
	private void getNameLevel(EnErPrQueryDTO depDTO, Map<String, String> map) throws BizException {
		if (!EnValidator.isEmpty(depDTO.getSd_triage_to())) {
			depDTO.setName_triage_to(map.get(depDTO.getSd_triage_to()));
		}
	}

	/**
	 * 获得患者就诊去向
	 * 
	 * @param depDTO
	 * @param udidocDOsLevel
	 * @throws BizException
	 */
	private void getNameGoWhere(EnErPrQueryDTO depDTO, Map<String, String> map) throws BizException {
		if (!EnValidator.isEmpty(depDTO.getSd_gowhere_er_ref())) {
			depDTO.setName_gowhere_er_ref(map.get(depDTO.getSd_gowhere_er_ref()));
		}
	}

	/**
	 * 将bd_udidoc数组转换为map
	 */
	private Map<String, String> getUdidocMap(UdidocDO[] udidocDOs) {
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < udidocDOs.length; i++) {
			map.put(udidocDOs[i].getCode(), udidocDOs[i].getName());
		}
		return map;
	}

	/***
	 * 设置就诊状态
	 * 
	 * @param erDTO
	 */
	private void setNameStatus(EnErPrQueryDTO erDTO) {
		if (erDTO != null && !EnValidator.isEmpty(erDTO.getSd_status())) {
			String nameStatus = "未知";
			if (erDTO.getFg_canc() != null && FBoolean.TRUE.equals(erDTO.getFg_canc())) {
				nameStatus = "取消";
				erDTO.setName_status(nameStatus);
				return;
			}
			switch (erDTO.getSd_status()) {
			case IEnDictCodeConst.SD_ENSTATUS_OP_ORDER: // 门诊预约
				nameStatus = "门诊预约";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER: // 门诊挂号
				nameStatus = "挂号";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER: // 门诊就诊
			case IEnDictCodeConst.SD_STATUS_ERPRE_VISIT: // 急诊就诊
				nameStatus = "就诊";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_OP_FINISH: // 门诊诊毕
			case IEnDictCodeConst.SD_STATUS_ERPRE_END: // 急诊结束
				nameStatus = "诊毕";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_OP_CONTINUE: // 门诊续诊
				nameStatus = "续诊";
				break;
			case IEnDictCodeConst.SD_STATUS_ERPRE_NEW: // 急诊预检
				nameStatus = "预检";
				break;
			case IEnDictCodeConst.SD_STATUS_ERPRE_CANCEL: // 急诊取消
				nameStatus = "取消";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_EM_REGISTER: // 急诊登记
				nameStatus = "急诊登记";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_EM_ENCOUNTER: // 急诊接诊
				nameStatus = "急诊接诊";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_EM_FINISH: // 急诊诊毕
				nameStatus = "急诊诊毕";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_EM_REPORT: // 急诊出报告
				nameStatus = "急诊出报告";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_IN_ORDER: // 住院预约
				nameStatus = "住院预约";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN: // 住院入院
				nameStatus = "入院";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN: // 住院入科
				nameStatus = "入科";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT: // 住院出院
				nameStatus = "出院";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT: // 住院退院
				nameStatus = "退院";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_PE_REGISTER: // 体检登记
				nameStatus = "体检登记";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_PE_ENCOUNTER: // 体检接诊
				nameStatus = "体检接诊";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_PE_FINISH: // 体检诊毕
				nameStatus = "体检诊毕";
				break;
			case IEnDictCodeConst.SD_ENSTATUS_PE_REPORT: // 体检出报告
				nameStatus = "体检出报告";
				break;
			}
			erDTO.setName_status(nameStatus);
		}
	}

	/***
	 * 设置预检状态
	 * 
	 * @param erDTO
	 */
	private void setNameErpreStatus(EnErPrQueryDTO erDTO) {
		if (erDTO != null && !EnValidator.isEmpty(erDTO.getErpre_status())) {
			String nameStatus = "未知";
			switch (erDTO.getErpre_status()) {
			case IEnDictCodeConst.SD_STATUS_ERPRE_NEW:
				nameStatus = "预检";
				break;
			case IEnDictCodeConst.SD_STATUS_ERPRE_VISIT:
				nameStatus = "就诊";
				break;
			case IEnDictCodeConst.SD_STATUS_ERPRE_END:
				nameStatus = "诊毕";
				break;
			case IEnDictCodeConst.SD_STATUS_ERPRE_CANCEL:
				nameStatus = "取消";
				break;
			}
			erDTO.setName_erpre_status(nameStatus);
		}
	}

	@SuppressWarnings("unchecked")
	private Map<String, EnErPrQueryDTO> getOpInfo(String[] Id_ent_lasts,EnErPrQueryDTO enErPrQueryDTO) throws DAException {
		if (EnValidator.isEmpty(Id_ent_lasts))
			return null;
		StringBuffer sql = new StringBuffer();
		sql.append("select op.id_ent as id_ent_last, ");
		sql.append("ent.code_entp, ");
		sql.append("entp.name as name_entp, ");
		sql.append("er.sd_scale_triage as sd_scale_hm, ");// 预检分级
		sql.append("gowhere.code as sd_gowhere_er_ref, ");// 就诊去向
		sql.append("op.ticketno, ");// 就诊序号
		sql.append("dayslot.name as name_dayslot, ");// 午别名称
		sql.append("op.sd_status as sd_status, ");// 就诊状态
		sql.append("op.times_op as ent_count, ");// 就诊次数
		sql.append("ent.dt_acpt as dt_pat, ");// 入科日期
		sql.append("ent.id_dep_phy as id_dep_phy, ");// 科室id
		sql.append("ent.fg_canc as fg_canc, ");// 是否取消挂号
		sql.append("ent.fg_acptvalid as fg_acpt_nur ");// 入病区状态
		sql.append("from en_ent ent ");
		sql.append("inner join en_ent_op op on ent.id_ent = op.id_ent ");
		sql.append("left join en_ent_op_er er on er.id_ent =op.id_ent ");
		sql.append("left join bd_dayslot dayslot on dayslot.id_dayslot = op.id_dateslot ");
		sql.append("left join bd_udidoc gowhere on gowhere.id_udidoc = er.id_gowhere_er ");
		sql.append("left join bd_entp entp on entp.id_entp = ent.id_entp ");
		sql.append("where " + SqlUtils.getInSqlByIds("ent.id_ent", Id_ent_lasts));
		SqlParam sqlParam = new SqlParam();
		List<EnErPrQueryDTO> list = (List<EnErPrQueryDTO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(EnErPrQueryDTO.class));
		return MapUtils.convertListToMap(list, "Id_ent_last");
	}

	@SuppressWarnings("unchecked")
	private Map<String, EnErPrQueryDTO> getIpInfo(String[] Id_ent_ips, EnErPrQueryDTO enErPrQueryDTO) throws DAException {
		if (EnValidator.isEmpty(Id_ent_ips))
			return null;
		StringBuffer sql = new StringBuffer();
		sql.append("select ent.id_ent as id_ent_ip, ");
		sql.append("ent.code_entp, ");
		sql.append("entp.name as name_entp, ");
		sql.append("ip.sd_status, ");// 就诊状态
		sql.append("gowhere.code as sd_gowhere_er_ref, ");// 就诊去向
		sql.append("ent.dt_end, ");
		sql.append("ent.dt_acpt as dt_pat, ");// 入科日期
		sql.append("ent.id_dep_phy as id_dep_phy, ");
		sql.append("ip.times_ip as ent_count ");// 就诊次数
		sql.append("from en_ent ent ");
		sql.append("inner join en_ent_ip ip on ip.id_ent = ent.id_ent ");
		sql.append("inner join en_ent_ip_er er on er.id_ent = ent.id_ent ");
		sql.append("left join bd_udidoc gowhere on gowhere.id_udidoc = er.id_gowhere_er ");
		sql.append("left join bd_entp entp on entp.id_entp = ent.id_entp ");
		sql.append("where " + SqlUtils.getInSqlByIds("ent.id_ent", Id_ent_ips));
		SqlParam sqlParam = new SqlParam();
		List<EnErPrQueryDTO> list = (List<EnErPrQueryDTO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(EnErPrQueryDTO.class));
		return MapUtils.convertListToMap(list, "Id_ent_ip");
	}
	
	private void setInfo(EnErPrQueryDTO outDTO, Map<String, EnErPrQueryDTO> ipInfo,
			Map<String, EnErPrQueryDTO> opInfo) {
		if (ipInfo != null && !EnValidator.isEmpty(outDTO.getId_ent_ip())) {
			if (ipInfo.containsKey(outDTO.getId_ent_ip())) {
				EnErPrQueryDTO ipdto = ipInfo.get(outDTO.getId_ent_ip());
				outDTO.setName_entp(ipdto.getName_entp());
				outDTO.setCode_entp(ipdto.getCode_entp());
				outDTO.setSd_status(ipdto.getSd_status());
				outDTO.setSd_gowhere_er_ref(ipdto.getSd_gowhere_er_ref());
				outDTO.setDt_end(ipdto.getDt_end());
				outDTO.setDt_pat(ipdto.getDt_pat());
				outDTO.setId_dep_phy(ipdto.getId_dep_phy());
				outDTO.setEnt_count(ipdto.getEnt_count());
			}
		} else if (opInfo != null && opInfo.containsKey(outDTO.getId_ent_last())) {
			EnErPrQueryDTO opdto = opInfo.get(outDTO.getId_ent_last());
			outDTO.setName_entp(opdto.getName_entp());
			outDTO.setCode_entp(opdto.getCode_entp());
			outDTO.setSd_scale_hm(opdto.getSd_scale_hm());
			outDTO.setSd_gowhere_er_ref(opdto.getSd_gowhere_er_ref());
			outDTO.setTicketno(opdto.getTicketno());
			outDTO.setName_dayslot(opdto.getName_dayslot());
			outDTO.setSd_status(opdto.getSd_status());
			outDTO.setEnt_count(opdto.getEnt_count());
			outDTO.setDt_pat(opdto.getDt_pat());
			outDTO.setId_dep_phy(opdto.getId_dep_phy());
			outDTO.setFg_canc(opdto.getFg_canc());
			outDTO.setFg_acpt_nur(opdto.getFg_acpt_nur());
		}
	}
}
