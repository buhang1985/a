package iih.sc.apt.s.listener;

import iih.bd.bc.event.pub.IScEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.aptoptemp.d.ScAptOptEmpDO;
import iih.sc.apt.aptoptemp.i.IAptoptempRService;
import iih.sc.apt.dto.d.OptApt4IEDTO;
import iih.sc.apt.dto.d.OptApt4OrmDTO;
import iih.sc.apt.dto.d.OptEmpInfoDTO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import java.util.List;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 手术预约--集成平台监听器
 * BS009信息
 * @author yzh
 * @date 2019年7月25日14:06:01
 */
public class OptApt4IEListener implements IBusinessListener {
	/**
	 * 手术预约发消息
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		List<OptApt4OrmDTO> eventSourceDTO = (List<OptApt4OrmDTO>) bizUserObj.getUserObj();
		OptApt4IEDTO optapt4iedto = this.wrap4Ie(eventSourceDTO.get(0));// 通过OpReg4EsDTO构造Reg4IpDTO
		optapt4iedto.setCreatetime(ScAppUtils.getServerDateTime());
		optapt4iedto.setDomainid("01");
		this.handleOptEmp(optapt4iedto);
		// 进行门诊和住院类型设置
		String en_type = BusiType.MZ;
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(optapt4iedto.getVisittype())) {
			optapt4iedto.setDomainid("02");
			en_type = BusiType.ZY;
			optapt4iedto.setVisittype("03");
		}
		optapt4iedto.setAction("insert");
		// 3、触发医技预约集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(optapt4iedto, en_type, ""/*aptIpDTO.getCode_dept_mp()*/, ""/*aptIpDTO.getSd_iemsgca()*/);
		MsgObj msg = new MsgObj();
		buo.setMsgObj(msg);
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(), event.getEventType(), buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}

	/**
	 * 验证事件
	 * 
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IScEventConst.EVENT_SOURCE_SC_OPT_APT.equalsIgnoreCase(event.getSourceID())
				|| !IScEventConst.EVENT_SC_OPT_APT.equals(event.getEventType())) {
			throw new BizException(IScMsgConst.ERROR_LISTENER_NO_SOURCE);
		}
	}

	/**
	 * 包装为集成平台DTO
	 * 
	 * @param apt4EsDTO
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OptApt4IEDTO wrap4Ie(OptApt4OrmDTO apt4IeDTO) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("")
		.append(" select")
		.append(" appl.id_scapt as idApt,")//预约Id
		.append(" pat.code as patientLid,")//患者id
		.append(" ent.code as visitNo,")//就诊号
		.append(" pat.code_amr_ip as visitOrdNo,")//就诊流水号改为住院号 0172808: BS009手术预约信息服务中所传信息有误
		.append(" appl.times as visitTimes,")//就诊次数
		.append(" ent.code_entp as visitType,")//就诊类别编码
		.append(" entp.name as visitTypeName,")//就诊类别名称
		.append(" depnur.name as wardsName,")//病区名
		.append(" depnur.code as wardsId,")//病区编码
		//房间号 x
		.append(" ip.name_bed as bedNo,")//床号
		//身份证号 x
		//医保号 x
		.append(" pat.name as patientName,")//患者姓名
		.append(" pat.sd_sex as genderCode,")//性别编码
		.append(" udisex.name as genderName,")//性别名称
		.append(" pat.dt_birth_hms as birthday,")//出生日期
		//派生年龄 x
		.append(" depphy.code as deptCode,")//病人科室编码 ?
		.append(" depphy.name as visitDeptName,")//病人科室名称 ?
		.append(" org.code as organizationCode,")//医疗机构代码
		.append(" org.name as organizationName,")//医疗机构名称
		.append(" depmp.code as executeDeptNo,")//执行科室编码
		.append(" depmp.name as executeDeptName,")//执行科室名称
		.append(" appl.applyno as requestNo,")//申请单编号
		.append(" apt.dt_appt as requestDate,")//申请日期
		.append(" srv.code as operationNameCode,")//手术名称编码
		.append(" srv.name as operationName,")//手术名称
		//手术间编号 x
		//手术台次 x
		.append(" ca.code as sccaCode,")//排班分类编码
		.append(" ca.name as sccaName,")//排班分类名称
		.append(" apt.dt_b as dateBegin,")//预约预计开始时间
		.append(" apt.dt_e as dateEnd,")//预约预计结束时间
		.append(" apt.queno as queNo,")//票号
		.append(" chl.code as scchlCode,")//预约渠道编码
		.append(" apt.sd_status as aptStatusCode,")//预约状态编码
		.append(" appl.dt_canc as dateCancel,")//取消预约时间
		.append(" apptemp.code as empApptCode,")//预约操作人员编码
		.append(" apt.sd_sctp as sctpCode,")//排班类型编码
		.append(" cancemp.code as empApplCancCode,")//预约申请取消人编码
		.append(" ci.code_or as codeOr,")//医嘱号
		.append(" appl.content_or  as contentOr,")//医嘱内容
		.append(" udisug1.code as operaPositionCode,")//手术体位代码
		.append(" udisug1.name as operaPositionName,")//手术体位名称
		//手术状态名称 x
		.append(" applopt.sd_anestp,")//麻醉方式编码
		.append(" udianes.name,")//麻醉方式名称
		.append(" udisug2.code as operationLevel,")//手术等级编码
		.append(" udisug2.name as operationLevelName,")//手术等级名称
		.append(" appl.fg_urgent as EmergencyFlag,")//手术紧急标志
		//隔离标志 x
		.append(" applopt.specialreq as specialreq,")//特殊用物
		.append(" applopt.specialdes as specialdes,")//特殊准备
		.append(" applopt.specialinstrument as SpecialEquipment,")//特殊器材
		.append(" applopt.announcements as announcements,")//注意事项
		.append(" applopt.fg_infection as influenceFlag")//是否感染手术
		//手术规模
		//诊断类别编码
		//诊断类别名称
		//疾病编码
		//疾病名称
		//备注   
		.append(" from sc_apt_appl appl")
		.append(" left join sc_apt apt on appl.id_scapt = apt.id_apt")
		.append(" left join sc_chl chl on chl.id_scchl = apt.id_scchl")
		.append(" left join ci_ap_sug sug on appl.id_or = sug.id_or")
		.append(" left join sc_ca ca on apt.id_scca = ca.id_scca")
		.append(" left join ci_order ci on appl.id_or = ci.id_or")
		.append(" left join bd_srv srv on appl.id_srv = srv.id_srv")
		.append(" left join bd_dep depmp on appl.id_dep_mp = depmp.id_dep")
		.append(" left join en_ent ent on appl.id_ent = ent.id_ent")
		.append(" left join pi_pat pat on appl.id_pi = pat.id_pat")
		.append(" left join bd_udidoc udisex on pat.id_sex = udisex.id_udidoc")
		.append(" left join bd_entp entp on ent.id_entp = entp.id_entp")
		.append(" left join en_ent_ip ip on ip.id_ent = ent.id_ent")
		.append(" left join bd_dep depphy on appl.id_dep_appl = depphy.id_dep")
		.append(" left join bd_dep depnur on ip.id_dep_nuradm = depnur.id_dep")
		.append(" left join bd_psndoc apptemp on apt.id_emp_appt = apptemp.id_psndoc")
		.append(" left join bd_psndoc cancemp on appl.id_emp_canc = cancemp.id_psndoc")
		.append(" left join sc_apt_appl_opt applopt on applopt.id_aptappl = appl.id_aptappl")
		.append(" left join bd_udidoc udianes on udianes.id_udidoc = applopt.id_anestp")
		.append(" left join bd_udidoc udisug1 on udisug1.id_udidoc = sug.id_surgical_site")
		.append(" left join bd_org org on appl.id_org = org.id_org")
		.append(" left join bd_udidoc udisug2 on udisug2.id_udidoc = sug.id_lvlsug")
		.append(" where appl.fg_canc = 'N' and appl.sd_sctp = '04' and apt.id_apt = ?");
		
		
		SqlParam param = new SqlParam();
		param.addParam(apt4IeDTO.getId_apt());
		List<OptApt4IEDTO> aptDTOs = (List<OptApt4IEDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(OptApt4IEDTO.class));
		if (ListUtil.isEmpty(aptDTOs)) {
			return null;
		}
		OptApt4IEDTO dto = aptDTOs.get(0);
		return dto;
	}

	/***
	 * 处理手术人员信息
	 * @param optapt4iedto
	 * @throws BizException
	 */
	private void handleOptEmp(OptApt4IEDTO optapt4iedto) throws BizException{
		IAptoptempRService iaptoptemprservice = ServiceFinder.find(IAptoptempRService.class);
		
		ScAptOptEmpDO[] optEmps = iaptoptemprservice.find("id_apt = '"+optapt4iedto.getIdapt()+"'", null, FBoolean.FALSE);
		
		if(!ArrayUtil.isEmpty(optEmps)){
			FArrayList2 operatorList = new FArrayList2();
			FArrayList2 anesthesiadoctorList = new FArrayList2();
			FArrayList2 nurseList = new FArrayList2();
			for (ScAptOptEmpDO emp : optEmps) {
				OptEmpInfoDTO empInfo = new OptEmpInfoDTO();
				if(IScDictCodeConst.ID_OP_ROLE_ZDYS.equals(emp.getId_role()) || IScDictCodeConst.ID_OP_ROLE_DYZS.equals(emp.getId_role()) || IScDictCodeConst.ID_OP_ROLE_DEZS.equals(emp.getId_role())){
					empInfo.setOperatorcode(emp.getCode_emp());
					empInfo.setOperatorname(emp.getName_emp());
					empInfo.setOperatorrole(emp.getName_role());
					operatorList.add(empInfo);
				}
				if(IScDictCodeConst.ID_OP_ROLE_MZYS.equals(emp.getId_role()) || IScDictCodeConst.ID_OP_ROLE_DRMZYS.equals(emp.getId_role())){
					empInfo.setAnesthesiadoctorcode(emp.getCode_emp());
					empInfo.setAnesthesiadoctorname(emp.getName_emp());
					empInfo.setAnesthesiadoctorrole(emp.getName_role());
					anesthesiadoctorList.add(empInfo);
				}
				if(IScDictCodeConst.ID_OP_ROLE_QXHS.equals(emp.getId_role()) || IScDictCodeConst.ID_OP_ROLE_QXHSE.equals(emp.getId_role()) || IScDictCodeConst.ID_OP_ROLE_XHHS.equals(emp.getId_role()) || IScDictCodeConst.ID_OP_ROLE_XHHSE.equals(emp.getId_role())){
					empInfo.setNursecode(emp.getCode_emp());
					empInfo.setNursename(emp.getName_emp());
					empInfo.setNurserole(emp.getName_role());
					nurseList.add(empInfo);
				}
			}
			optapt4iedto.setOperationdoctorinfo(operatorList);
			optapt4iedto.setAnesthesiadoctorinfo(anesthesiadoctorList);
			optapt4iedto.setNurseinfo(nurseList);
		}
		
	}
}
