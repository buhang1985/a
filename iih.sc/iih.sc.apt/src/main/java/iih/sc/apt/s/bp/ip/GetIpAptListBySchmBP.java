package iih.sc.apt.s.bp.ip;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.bed.d.BedAttrDefDO;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.AptIpQrySchmDTO;
import iih.sc.apt.dto.d.EuDateStatus;
import iih.sc.apt.dto.d.EuTimeTp;
import iih.sc.comm.IScConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.pub.ScGroupControlUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院预约申请单列表
 * 
 * @author zhouliming
 * @modifier zhengcm 整理和规范
 * @modifier zhengcm 增加集团管控
 * 
 */
public class GetIpAptListBySchmBP {
	/**
	 * 获取住院预约申请单列表（分页）
	 * 
	 * @param qrySchmDTO 查询模板
	 * @return 住院预约DTO集合
	 * @throws BizException
	 * @throws ParseException
	 */
	public PagingRtnData<AptIpDTO> exec(AptIpQrySchmDTO qrySchmDTO, PaginationInfo pg) throws BizException {
		if (qrySchmDTO == null) {
			return null;
		}
		SqlParam param = new SqlParam();
		String aptIpList = this.sql(qrySchmDTO, param);
		PagingServiceImpl<AptIpDTO> pageQryService = new PagingServiceImpl<AptIpDTO>();
		PagingRtnData<AptIpDTO> datas = pageQryService.findByPageInfo(new AptIpDTO(), pg, aptIpList, null, param);
		FArrayList flResult = datas.getPageData();
		List<AptIpDTO> aptIpDTOList = new ArrayList<AptIpDTO>();
		for (int i = 0; i < flResult.size(); i++) {
			AptIpDTO apt = (AptIpDTO) flResult.get(i);
			aptIpDTOList.add(apt);
		}
		if (!ListUtil.isEmpty(aptIpDTOList)) {
			this.handleEntity(aptIpDTOList.toArray(new AptIpDTO[0]));
		}
		return datas;
	}

	/***
	 * 获取住院预约申请单列表（不分页）
	 * 
	 * @author fanlq
	 * @param qrySchmDTO
	 * @return
	 * @throws BizException
	 */
	public AptIpDTO[] exec(AptIpQrySchmDTO qrySchmDTO) throws BizException {
		if (qrySchmDTO == null) {
			return null;
		}
		SqlParam param = new SqlParam();
		String aptIpList = this.sql(qrySchmDTO, param);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<AptIpDTO> list = (List<AptIpDTO>) new DAFacade().execQuery(aptIpList, param, new BeanListHandler(
				AptIpDTO.class));
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		AptIpDTO[] AptIpDTOs = handleEntity(list.toArray(new AptIpDTO[0]));
		return AptIpDTOs;
	}

	/***
	 * 查询住院申请列表SQL
	 * 
	 * @author fanlq
	 * @param qrySchmDTO
	 * @param param
	 * @return
	 */
	public String sql(AptIpQrySchmDTO qrySchmDTO, SqlParam param) {
		// 1、处理过滤条件
		String d_b = null;
		String d_e = null;
		if (qrySchmDTO.getD_b() != null) {
			d_b = qrySchmDTO.getD_b().toString();
		}
		if (qrySchmDTO.getD_e() != null) {
			d_e = qrySchmDTO.getD_e().getDateAfter(1).toString();// 结束时间
			d_e = d_e + " 23:59:59";
		}
		// 2、查询住院申请列表
		StringBuffer sb = new StringBuffer();
		sb.append("select ip.id_aptip as id_scaptip,ip.name_pat,ip.sd_status,");
		sb.append("ent.code as code_ent, pat.code as code_pat,ip.note,ip.fg_vip,");// fanlq
		sb.append("docSex.Name as name_sex_pat,docSex.code as Sd_sex_pat,ip.dt_brith_pat as birth_pat,");
		sb.append("ip.id_dep_phy_ip,dep1.name as name_dep_phy_ip,ip.rsn_refuse,");
		sb.append("ip.id_dep_nur_ip,dep2.name as name_dep_nur_ip,ip.fg_canc,");
		sb.append("ip.name_didef_op,ip.fg_plan,ip.id_bed,bed.name as name_bed,");
		sb.append("ip.sd_level_dise,doc.name as name_level_dise,ip.dt_admit_plan,");
		sb.append("ip.id_patca,patCa.Name as name_patca,");
		sb.append("ip.note_apt as Infofeedback,");
		sb.append("pat.id_pat,");
		sb.append("ip.id_emp_phy_op,ip.name_emp_phy_op,dep3.name as name_appt_nur_ip,");
		sb.append("ip.dt_insert,ip.dt_appt,ip.id_emp_appt,psn1.name as name_emp_appt,");
		sb.append("ip.id_emp_cfm,psn2.name as name_emp_cfm,ip.dt_cfm,");
		sb.append("ent.telno_pat as tel_pat ");
		sb.append("from sc_apt_ip ip ");
		sb.append("left join bd_dep dep1 on dep1.id_dep = ip.id_dep_phy_ip ");
		sb.append("left join bd_dep dep2 on dep2.id_dep = ip.id_dep_nur_ip ");
		sb.append("left join bd_bed bed on bed.id_bed = ip.id_bed ");
		sb.append("left join bd_dep dep3 on dep3.id_dep = bed.id_dep_belong ");
		sb.append("left join en_ent ent on ent.id_ent = ip.id_ent ");
		sb.append("left join bd_psndoc psn1 on psn1.id_psndoc = ip.id_emp_appt ");
		sb.append("left join bd_psndoc psn2 on psn2.id_psndoc = ip.id_emp_cfm ");
		sb.append("left join bd_udidoc doc on doc.id_udidoc = ip.id_level_dise ");
		sb.append("left join bd_udidoc docSex on docSex.Id_Udidoc = ip.id_sex_pat ");
		sb.append("left join pi_pat_ca patCa on patCa.Id_Patca = ip.id_patca ");
		sb.append("left join pi_pat pat on pat.id_pat = ip.id_pat ");
		sb.append("where 1=1 ");

		if (StringUtils.isNotBlank(qrySchmDTO.getId_dep())) {
			sb.append("and ip.id_dep_phy_ip = ? ");
			param.addParam(qrySchmDTO.getId_dep());
		}
		if (StringUtils.isNotBlank(qrySchmDTO.getId_nur())) {
			sb.append("and ip.id_dep_nur_ip = ? ");
			param.addParam(qrySchmDTO.getId_nur());
		}
		if (qrySchmDTO.getFg_rehos() != null && FBoolean.TRUE.equals(qrySchmDTO.getFg_rehos())) {
			sb.append("and ip.fg_plan = ? ");
			param.addParam(qrySchmDTO.getFg_rehos());
		}
		if (StringUtils.isNotBlank(qrySchmDTO.getSd_level_dise())) {
			sb.append("and ip.sd_level_dise = ? ");
			param.addParam(qrySchmDTO.getSd_level_dise());
		}
		if (StringUtils.isNotBlank(qrySchmDTO.getId_patca())) {
			sb.append("and ip.id_patca = ? ");
			param.addParam(qrySchmDTO.getId_patca());
		}
		if (StringUtils.isNotBlank(qrySchmDTO.getTimetp()) && qrySchmDTO.getTimetp().equals(EuTimeTp.APPLY)) {// 申请时间
			if (d_b != null) {
				sb.append("and ip.dt_insert >= ? ");
				param.addParam(d_b);
			}
			if (d_e != null) {
				sb.append("and ip.dt_insert < ? ");
				param.addParam(d_e);
			}
		} else {
			if (d_b != null) {
				sb.append("and ip.dt_admit_plan >= ? ");
				param.addParam(d_b);
			}
			if (d_e != null) {
				sb.append("and ip.dt_admit_plan < ? ");
				param.addParam(d_e);
			}
		}
		if (StringUtils.isNotBlank(qrySchmDTO.getEu_status())) {
			sb.append("and ip.sd_status in ( " + qrySchmDTO.getEu_status() + ")");
		}
		if (StringUtils.isNotBlank(qrySchmDTO.getId_pat())) {
			sb.append(" and ip.id_pat = ? ");
			param.addParam(qrySchmDTO.getId_pat());
		}
		if (qrySchmDTO.getFg_canc() == null) {
			sb.append(" and ISNULL(ip.fg_canc,'N') = 'N' ");
		}

		// 开单医生、vip标识查询，fanlq-2018.03.01
		if (StringUtils.isNotBlank(qrySchmDTO.getName_emp())) {
			sb.append(" and ip.name_emp_phy_op = ? ");
			param.addParam(qrySchmDTO.getName_emp());
		}
		if (qrySchmDTO.getFg_vip() != null && FBoolean.TRUE.equals(qrySchmDTO.getFg_vip())) {
			sb.append(" and ip.fg_vip = ? ");
			param.addParam(qrySchmDTO.getFg_vip());
		}

		// 患者姓名，患者编号，fanlq-2018.03.14
		if (StringUtils.isNotBlank(qrySchmDTO.getName_pat())) {
			sb.append(" and pat.name = ? ");
			param.addParam(qrySchmDTO.getName_pat());
		}
		if (StringUtils.isNotBlank(qrySchmDTO.getCode_pat())) {
			sb.append(" and pat.code = ? ");
			param.addParam(qrySchmDTO.getCode_pat());
		}

		// 根据打开的节点，判断是否需要根据全院预约权限过滤申请单列表，fanlq-2018.03.30
		if (IScConst.SC_IP_PRAVE.equals(qrySchmDTO.getLetparam())) {
			String psnId = ScContextUtils.getPsnId();
			Boolean canApt = ScParamUtils.canApptIpHospital();
			if (!canApt) {
				sb.append("and bed.id_bed in ( ");
				sb.append("select id_bed from bd_wg_bed wgbed ");
				sb.append("inner join bd_emp_wg empwg on wgbed.id_wg = empwg.id_wg ");
				sb.append("inner join bd_wg wg on wg.id_wg = empwg.id_wg ");
				sb.append(" where empwg.id_emp = ? and wg.fg_active = ? ) ");
				param.addParam(psnId);
				param.addParam(FBoolean.TRUE);
			}
		}
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new AptIpDO(), "ip"));
		return sb.toString();
	}

	/**
	 * 计算年龄及获取床位特征
	 * 
	 * @param AptIpDTOs 住院申请列表
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("rawtypes")
	private AptIpDTO[] handleEntity(AptIpDTO[] AptIpDTOs) throws DAException {
		StringBuffer sqlStr = new StringBuffer();
		StringBuffer whereStr = new StringBuffer();
		Integer maxWaitDays = ScParamUtils.canScIpMaxDaysWait();// 最大等待时间
		Integer maxOccpHours = ScParamUtils.canScIpMaxhoursOccpBed();// 获取最大占床时间

		for (AptIpDTO DTO : AptIpDTOs) {
			FDate date_birth = DTO.getBirth_pat();// 出生日期
			String id_aptip = DTO.getId_scaptip();// 申请单id
			FDateTime dt_insert = DTO.getDt_insert();// 申请时间
			FDateTime dt_cfm = DTO.getDt_cfm();// 确认时间
			String sd_status = DTO.getSd_status();// 状态
			// 计算年龄
			String age = ScAppUtils.getAge(date_birth.toString());
			DTO.setAge(age);
			// 计算申请状态下的申请单的剩余等待时间和确认状态下的剩余占床时间
			if (sd_status.equals(IScDictCodeConst.SD_APTIP_STATUS_APPLY)) {// 申请状态
				Integer days = getDaysWaitOrOccpHours(sd_status, dt_insert, maxWaitDays);
				DTO.setLeave_wait_days(days);
				if (days != null && days < 0) {
					DTO.setSort_date_type(EuDateStatus.WAIT);
				} else {
					DTO.setSort_date_type(EuDateStatus.INSERT);
				}
			} else if (sd_status.equals(IScDictCodeConst.SD_APTIP_STATUS_APPROVE)) {// 确认状态
				Integer hours = getDaysWaitOrOccpHours(sd_status, dt_cfm, maxOccpHours);
				DTO.setLeave_occp_bed_hours(hours);
				if (hours != null && hours < 0) {
					DTO.setSort_date_type(EuDateStatus.OCCP);
				} else {
					DTO.setSort_date_type(EuDateStatus.INSERT);
				}
			} else {
				DTO.setSort_date_type(EuDateStatus.INSERT);
			}
			whereStr.append((whereStr.length() == 0 ? "" : ",") + "'" + id_aptip + "'");
		}

		sqlStr.append("select attr.id_aptip, doc.name as attrName, def.name as defName ,attr.sd_bedattr_tp , attr.val ,attr.fg_option ");
		sqlStr.append("from SC_APT_IP_ATTR attr ");
		sqlStr.append("inner join bd_udidoc doc on attr.id_bedattr_tp = doc.id_udidoc ");
		sqlStr.append("inner join bd_bed_attr_def def on def.sd_bedattr_tp = attr.sd_bedattr_tp and def.val = attr.val and def.ds = '0'");
		sqlStr.append("where attr.id_aptip in (" + whereStr + ")");
		// 集团管控
		sqlStr.append(" and " + ScGroupControlUtils.getGroupControlFitler(new BedAttrDefDO(), "def"));
		List list = (List) new DAFacade().execQuery(sqlStr.toString(), new MapListHandler());
		Map<String, String> mapDepAttr = new HashMap<String, String>();// 床位特征名称+特征值名称
		Map<String, String> attrList = new HashMap<String, String>();// 床位特征类型+val
		for (int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(i);
			String id_aptip = (String) map.get("id_aptip");
			String attrName = (String) map.get("attrname");
			String defName = (String) map.get("defname");
			String sd_bedattr_tp = (String) map.get("sd_bedattr_tp");
			String val = (String) map.get("val");
			String fg_option = (String) map.get("fg_option");
			if (fg_option.equals(FBoolean.TRUE)) {
				continue;// 若申请单床位特征值可选状态为true则不需要加入预约床位判断条件里
			}
			String attrDef = attrName + ":" + defName + "  ";
			String attr = sd_bedattr_tp + "," + val + (i == list.size() - 1 ? "" : " ");

			if (mapDepAttr.containsKey(id_aptip)) {
				mapDepAttr.put(id_aptip, mapDepAttr.get(id_aptip) + attrDef);
				attrList.put(id_aptip, attrList.get(id_aptip) + attr);
			} else {
				mapDepAttr.put(id_aptip, attrDef);
				attrList.put(id_aptip, attr);
			}
		}
		List<AptIpDTO> apptList = new ArrayList<AptIpDTO>();
		for (AptIpDTO aptIpDTO : AptIpDTOs) {
			String id_aptip = aptIpDTO.getId_scaptip();
			for (String key : mapDepAttr.keySet()) {
				if (id_aptip.equals(key)) {
					aptIpDTO.setBed_attr(mapDepAttr.get(key));
					aptIpDTO.setBed_attrs_str(attrList.get(key));
				}
			}
			apptList.add(aptIpDTO);
		}
		sortList(apptList);
		return apptList.toArray(new AptIpDTO[apptList.size()]);
	}

	/**
	 * 获取申请状态下的申请单的剩余等待时间和确认状态下的剩余占床时间
	 * 
	 * @param sd_status 申请状态
	 * @param dateTime 申请时间或确认时间
	 * @param maxDays 等待时间或占用时间
	 * @return
	 */
	@SuppressWarnings("static-access")
	public Integer getDaysWaitOrOccpHours(String sd_status, FDateTime dateTime, Integer maxDays) {
		if (sd_status == null || dateTime == null || maxDays == null) {
			return null;
		}
		FDateTime sysDate = ScAppUtils.getServerDateTime();

		if (sd_status.equals(IScDictCodeConst.SD_APTIP_STATUS_APPLY)) {// 申请状态
			Integer days = sysDate.getDaysAfter(dateTime);
			return maxDays - days;
		} else {// 确认状态
			Integer hours = sysDate.getHoursBetween(dateTime, sysDate);
			return maxDays - hours;
		}
	}

	/**
	 * 按床位等待时间预警申请、床位占用时间预警申请、申请时间排序。
	 * 
	 * @param list
	 */
	public void sortList(List<AptIpDTO> list) {
		if (ListUtil.isEmpty(list)) {
			return;
		}
		Collections.sort(list, new Comparator<AptIpDTO>() {
			// 1、排序类型较大者在前。
			// 2、排序类型相同时：
			// a、排序类型为0时返回两者剩余等待时间的差
			// b、排序类型为1时返回两者剩余占床时间的差
			// c、排序类型为2时返回申请时间的比较值
			@Override
			public int compare(AptIpDTO aptIpDTO1, AptIpDTO aptIpDTO2) {
				if (aptIpDTO1.getSort_date_type().compareTo(aptIpDTO2.getSort_date_type()) > 0) {
					return 1;
				} else if (aptIpDTO1.getSort_date_type().compareTo(aptIpDTO2.getSort_date_type()) < 0) {
					return -1;
				} else {
					if (aptIpDTO1.getSort_date_type().equals("0")) {
						return aptIpDTO1.getLeave_wait_days() - aptIpDTO2.getLeave_wait_days();
					} else if (aptIpDTO1.getSort_date_type().equals("1")) {
						if (aptIpDTO1.getLeave_occp_bed_hours() == null || aptIpDTO2.getLeave_occp_bed_hours() == null) {
							return 0;
						}
						return aptIpDTO1.getLeave_occp_bed_hours() - aptIpDTO2.getLeave_occp_bed_hours();
					} else {
						return aptIpDTO1.getDt_insert().compareTo(aptIpDTO2.getDt_insert());
					}
				}
			}
		});

	}
}
