package iih.ci.mr.pub.listener;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeTypeConst;
import iih.ci.mr.cideathcert.d.CideathcertDO;
import iih.ci.mr.cimrdeath.d.CimrdeathDTO;
import iih.ci.mr.cimripbasedto.d.CiMrIPBaseDTO;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.rcm.pub.ReportConst.IReportPubConst;

import java.util.Arrays;
import java.util.List;

import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public class AbstractCideathcertPassListener extends AbstractCideathcertDOUpdateAfterListener {

	@SuppressWarnings("unchecked")
	@Override
	protected void doActionCiMrDOChange(CideathcertDO[] cideathcertDOs) throws BizException {
		// 数据组装
		CideathcertDO cideathcertDO = cideathcertDOs[0];

		if (cideathcertDO == null || cideathcertDO.getCert_status() == null
				|| !IReportPubConst.Id_con_cardsu_ok.contains(cideathcertDO.getCert_status())) {
			return;
		}
		// 服务定义
		IUserRService userService = ServiceFinder.find(IUserRService.class);
		// ICiMrIPService ipservice = ServiceFinder.find(ICiMrIPService.class);

		CimrdeathDTO ciMrDeathDTO = new CimrdeathDTO();
		ciMrDeathDTO.setDoc_version("0");
		ciMrDeathDTO.setId_interface("BS435");
		ciMrDeathDTO.setDoc_title("死亡诊断证明书");
		ciMrDeathDTO.setId_ent(cideathcertDO.getId_ent());
		ciMrDeathDTO.setInhos_no(cideathcertDO.getInhos_no());// 住院号
		ciMrDeathDTO.setRecord_date(cideathcertDO.getCreatedtime());// 填报日期
		ciMrDeathDTO.setId_doc(cideathcertDO.getId_death_cert());// 文档标示ID
		ciMrDeathDTO.setId_nation(cideathcertDO.getId_nation());// 民族
		ciMrDeathDTO.setCode_nation(cideathcertDO.getCode_nation());
		ciMrDeathDTO.setNation_pat(cideathcertDO.getNation_pat());
		ciMrDeathDTO.setId_cardtype(cideathcertDO.getId_cardtype());// 证件类型
		ciMrDeathDTO.setCard_type_code(cideathcertDO.getCard_type_code());
		ciMrDeathDTO.setIdcard_type(cideathcertDO.getIdcard_type());
		ciMrDeathDTO.setIdcard_no(cideathcertDO.getIdcard_no());// 证件号
		ciMrDeathDTO.setId_country(cideathcertDO.getId_country());// 国家
		ciMrDeathDTO.setCode_country(cideathcertDO.getCode_country());
		ciMrDeathDTO.setCountry_pat(cideathcertDO.getCountry_pat());
		ciMrDeathDTO.setId_marry(cideathcertDO.getId_marry());// 婚姻
		ciMrDeathDTO.setMarry_code(cideathcertDO.getMarry_code());
		ciMrDeathDTO.setMarry_status(cideathcertDO.getMarry_status());
		ciMrDeathDTO.setId_sex(cideathcertDO.getId_sex());// 性别
		ciMrDeathDTO.setSex_code(cideathcertDO.getSex_code());
		ciMrDeathDTO.setName_sex(cideathcertDO.getSex_pat());
		ciMrDeathDTO.setId_degree(cideathcertDO.getId_degree());// 文化程度
		ciMrDeathDTO.setDegree_code(cideathcertDO.getDegree_code());
		ciMrDeathDTO.setDegree_pat(cideathcertDO.getDegree_pat());
		ciMrDeathDTO.setId_job(cideathcertDO.getId_job());// 个人身份
		ciMrDeathDTO.setPersonal_identity_code(cideathcertDO.getPersonal_identity_code());
		ciMrDeathDTO.setJob_pat(cideathcertDO.getJob_pat());
		ciMrDeathDTO.setAddress_usual(cideathcertDO.getAddress_usual());// 常住地址
		ciMrDeathDTO.setAddress_usual_code(cideathcertDO.getAddress_usual_code());
		ciMrDeathDTO.setAddress_usual_name(cideathcertDO.getAddress_usual_name());
		ciMrDeathDTO.setAddress_usual_street(cideathcertDO.getAddress_usual_street());
		ciMrDeathDTO.setBirth_place(cideathcertDO.getBirth_place());// 户籍地址
		ciMrDeathDTO.setBirth_place_code(cideathcertDO.getBirth_place_code());
		ciMrDeathDTO.setBirth_place_name(cideathcertDO.getBirth_place_name());
		ciMrDeathDTO.setBirth_place_street(cideathcertDO.getBirth_place_street());
		FDate birth_pat = cideathcertDO.getBirth_pat();// 出生日期
		ciMrDeathDTO.setBirth_date(birth_pat);
		// 患者年龄的填写为纯文本输入，暂定认为输入的年龄格式为 年龄+单位，例：18岁
		String patAge = getPatAge(birth_pat);

		if (patAge.contains("岁")) {
			ciMrDeathDTO.setAge_pat(patAge.replace("岁", ""));
			ciMrDeathDTO.setAge_unit("岁");
		} else if (patAge.contains("月")) {
			ciMrDeathDTO.setAge_pat(patAge.replace("月", ""));
			ciMrDeathDTO.setAge_unit("月");
		} else {
			ciMrDeathDTO.setAge_pat(patAge.replace("天", ""));
			ciMrDeathDTO.setAge_unit("天");
		}
		// 填报医生
		UserDO us1 = userService.findById(cideathcertDO.getCreatedby());
		ciMrDeathDTO.setId_doctor(us1.getCode());
		ciMrDeathDTO.setName_doctor(us1.getName());

		// CiMrPatInfoDTO[] patinfoDTOs =
		// ipservice.getCiMrPatInfoDTO(cideathcertDO.getId_ent());
		CiMrIPBaseDTO[] ciMrIPBaseDTOs = getCiMrIPBaseDTO(cideathcertDO.getId_ent());

		MsgObj msgObj = new MsgObj();
		String bussiType = IMrPubConst.NOCAT;

		// 添加数组是否空
		if (ciMrIPBaseDTOs.length > 0) {
			// 取集合第一条数据，理论上只存在一条数据
			CiMrIPBaseDTO ciMrIPBaseDTO = ciMrIPBaseDTOs[0];

			ciMrDeathDTO.setCode_pat(ciMrIPBaseDTO.getId_pat());
			ciMrDeathDTO.setName_pat(ciMrIPBaseDTO.getName());
			ciMrDeathDTO.setCode_ent_liushui(ciMrIPBaseDTO.getEn_code_liushui());
			ciMrDeathDTO.setId_entp(ciMrIPBaseDTO.getCode_entp());
			ciMrDeathDTO.setName_entp(ciMrIPBaseDTO.getName_entp());
			ciMrDeathDTO.setId_hospital(ciMrIPBaseDTO.getCode_org());
			ciMrDeathDTO.setName_hospital(ciMrIPBaseDTO.getOrg());
			// title字段没有用到，暂时存储组织名称，用于患者死亡医院信息
			cideathcertDO.setTitle(ciMrIPBaseDTO.getOrg());

			msgObj.setEnNO(ciMrIPBaseDTO.getId_ent());
			msgObj.setPatientCode(ciMrIPBaseDTO.getId_pat());

			if (ciMrIPBaseDTO != null) {
				if (ciMrIPBaseDTO.getTimes_op() != null && ciMrIPBaseDTO.getCode_entp().equals("01")) {
					msgObj.setEntimes(Integer.parseInt(ciMrIPBaseDTO.getTimes_op()));
					ciMrDeathDTO.setCount_ent(ciMrIPBaseDTO.getTimes_op());
					bussiType = IMrPubConst.MZ;
				}
				if (ciMrIPBaseDTO.getTimes_ip() != null && ciMrIPBaseDTO.getCode_entp().equals("03")) {
					msgObj.setEntimes(Integer.parseInt(ciMrIPBaseDTO.getTimes_ip()));
					ciMrDeathDTO.setCount_ent(ciMrIPBaseDTO.getTimes_ip());
					bussiType = IMrPubConst.ZY;
				}
			}
		}

		// ciMrDeathDTO.setId_moudle(patinfoDTOs[0].getId_pre());
		// ciMrDeathDTO.setCount_ent(patinfoDTOs[0].getTimes_ip());
		ciMrDeathDTO.setId_moudle("01");// 域ID固定为01

		// 死亡证明信息
		FArrayList list = new FArrayList();
		list.addAll(Arrays.asList(cideathcertDO));
		ciMrDeathDTO.setLs_death_cert(list);

		msgObj.setInteractionCode("0");
		// 消息头中的就诊类型信息

		// 消息发送
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrDeathDTO, bussiType, "", "0");
		buo.setMsgObj(msgObj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_DEATHCERT_PASS,
				IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
	}

	/**
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private CiMrIPBaseDTO[] getCiMrIPBaseDTO(String id_ent) throws BizException {
		if (id_ent == null || "".equals(id_ent))
			return new CiMrIPBaseDTO[] {};

		StringBuilder sql = new StringBuilder();
		sql.append("select case ee.code_entp when '10' then '02' else '01' end id_pre, ");
		sql.append("       pp.code id_pat, ");
		sql.append("       (CASE WHEN ee.code_entp = '10' THEN pp.code_amr_ip ElSE pp.barcode_chis end) as id_ent, ");
		sql.append("       eeo.times_op times_op, ");
		sql.append("       eei.times_ip times_ip, ");
		sql.append("       ee.code en_code_liushui, ");
		sql.append("       (CASE ");
		sql.append("         WHEN ee.code_entp = '00' THEN '01' ");
		sql.append("         WHEN ee.code_entp = '01' THEN '02' ");
		sql.append("         WHEN ee.code_entp = '10' THEN '03' ");
		sql.append("         WHEN ee.code_entp = '02' THEN '04' ");
		sql.append("         ElSE '05' ");
		sql.append("       end) as code_entp, ");
		sql.append("       be.name name_entp, ");
		sql.append("       pp.name name, ");
		sql.append("       pp.sd_sex code_sex, ");
		sql.append("       bu1.name sex, ");
		sql.append("       pp.dt_birth dt_birth, ");
		sql.append("       bu2.code code_nation, ");
		sql.append("       bu2.name nation, ");
		sql.append("       pp.sd_marry code_marry, ");
		sql.append("       bu3.name name_marry, ");
		sql.append("       ppa.street add_born, ");
		sql.append("       bu4.code as work_code, ");
		sql.append("       bu4.name as work, ");
		sql.append("       bd1.code code_dept, ");
		sql.append("       bd1.name dept, ");
		sql.append("       bd2.code code_dep_nuradm, ");
		sql.append("       bd2.name dep_nuradm, ");
		sql.append("       eei.name_bed name_bed, ");
		sql.append("       bo.orgcode code_org, ");
		sql.append("       bo.name org, ");
		sql.append("       ee.dt_end dt_end, ");
		sql.append("       ee.dt_acpt, ");
		sql.append("       decode(ee.dt_end, null, ");
		sql.append("              trunc(sysdate) - trunc(to_date(ee.dt_acpt, 'yyyy-mm-dd hh24:mi:ss')), ");
		sql.append(
				"              trunc(to_date(ee.dt_end, 'yyyy-mm-dd hh24:mi:ss')) - trunc(to_date(ee.dt_acpt, 'yyyy-mm-dd hh24:mi:ss'))) ip_day, ");
		sql.append("       pp.sd_idtp sd_idtp, ");
		sql.append("       pp.id_code id_code, ");
		sql.append("       ee.addr_pat as addr, ");
		sql.append("       pp.workunit as work_unit, ");
		sql.append("       ee.telno_pat as tel_num, ");
		sql.append("       ppc.name as cont_name, ");
		sql.append("       ppc.conttel as cont_tel ");
		sql.append("from en_ent ee ");
		sql.append("left join pi_pat pp on ee.id_pat = pp.id_pat ");
		sql.append("left join en_ent_op eeo on ee.id_ent = eeo.id_ent ");
		sql.append("left join en_ent_ip eei on ee.id_ent = eei.id_ent ");
		sql.append("left join bd_entp be on ee.code_entp = be.code ");
		sql.append("left join bd_udidoc bu1 on bu1.id_udidoclist = '");
		sql.append(ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX);
		sql.append("' and bu1.code = pp.sd_sex ");
		sql.append("left join bd_udidoc bu2 on bu2.id_udidoclist = '");
		sql.append(ICiMrDictCodeTypeConst.ID_UDIDOCLIST_NATION);
		sql.append("' and bu2.id_udidoc = pp.id_nation ");
		sql.append("left join bd_udidoc bu3 on bu3.id_udidoc = pp.id_marry ");
		sql.append("left join bd_udidoc bu4 on bu4.id_udidoc = pp.id_occu ");
		sql.append("left join pi_pat_addr ppa on pp.id_pat = ppa.id_pat and ppa.sd_addrtp = '6' ");
		sql.append("left join bd_dep bd1 on ee.id_dep_phy = bd1.id_dep ");
		sql.append("left join bd_dep bd2 on ee.id_dep_nur = bd2.id_dep ");
		sql.append("left join bd_org bo on ee.id_org = bo.id_org ");
		sql.append("left join pi_pat_cont ppc on pp.id_pat = ppc.id_pat ");
		sql.append("where ee.id_ent = ? ");

		SqlParam sp = new SqlParam();
		sp.addParam(id_ent);

		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiMrIPBaseDTO> lsDto = (List<CiMrIPBaseDTO>) daf.execQuery(sql.toString(), sp,
				new BeanListHandler(CiMrIPBaseDTO.class));
		return lsDto.toArray(new CiMrIPBaseDTO[0]);
	}

	/**
	 * 计算患者年龄 -by Vampire
	 * 
	 * @param dt_birth
	 *            出生日期
	 * @return 年龄
	 * @throws DAException
	 */
	private String getPatAge(FDate dt_birth) throws DAException {
		String age = "";
		if (dt_birth == null)
			return age;
		FDate dt_now = new FDate();
		long age_millis = dt_now.getMillis() - dt_birth.getMillis();
		double age_years = (double) age_millis / (1000.0 * 60.0 * 60.0 * 24.0 * 365.0);

		if (age_years >= 1.0) {
			age = (int) Math.floor(age_years) + "岁";
		} else {
			age_years = age_years * 365.0;

			if (age_years >= 30.0) {
				age = (int) (age_years / 30.0) + "月";
				/*
				 * String month = (int)(age_years / 30.0) + "月"; String day =
				 * (int)(age_years % 30.0) + "天"; age = month + day;
				 */
			} else {
				age = (int) (age_years % 30.0) + "天";
			}
		}
		return age;
	}

}
