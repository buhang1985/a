package iih.sc.apt.s.listener;

import java.util.List;

import iih.bd.bc.event.pub.IScEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import iih.sc.apt.dto.d.MtApt4IpDTO;
import iih.sc.comm.IScMsgConst;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医技退约--集成平台
 * 
 * @author TFL
 *
 */
public class MtAptCanc4IpListener implements IBusinessListener {
	/**
	 * 医技退约发消息
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		MtApt4EsDTO eventSourceDTO = (MtApt4EsDTO) bizUserObj.getUserObj();
		MtApt4IpDTO aptIpDTO = this.wrap4Ip(eventSourceDTO);// 通过OpReg4EsDTO构造Reg4IpDTO

		// 进行门诊和住院类型设置
		String en_type = BusiType.MZ;
		if (IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(aptIpDTO.getId_entp())) {
			en_type = BusiType.ZY;
		}

		// 3、触发医技预约集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(aptIpDTO, en_type, aptIpDTO.getCode_dept_mp(), aptIpDTO.getSd_iemsgca());
		MsgObj msg = new MsgObj();
		msg.setInteractionCode("cancel");
		buo.setMsgObj(msg);
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(), event.getEventType(), buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);

	}

	/**
	 * 验证事件
	 * 
	 * @param event
	 *            事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IScEventConst.EVENT_SOURCE_SC_MT_APT.equalsIgnoreCase(event.getSourceID())
				|| !IScEventConst.EVENT_SC_MT_CAN_APT.equals(event.getEventType())) {
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
	private MtApt4IpDTO wrap4Ip(MtApt4EsDTO apt4EsDTO) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select apt.id_apt,");// 排版预约id
		sqlBuilder.append("appl.id_entp,");// 就诊类型id
		sqlBuilder.append("apt.code as aptcode,");// 预约号
		sqlBuilder.append("apt.dt_b as dt_apt,");// 预约时间
		sqlBuilder.append("apt.id_emp_appt as id_emp_apt,");//
		sqlBuilder.append("psn.name as name_emp_apt,"); // 预约员姓名
		sqlBuilder.append("mt.id_dep_mp as id_dept_mp,");//
		sqlBuilder.append("dep.name as name_dept_mp,");// 执行科室
		sqlBuilder.append("dep.code as code_dept_mp,");// 执行科室编码
		sqlBuilder.append("psn.code as code_emp_apt,");// 预约员编码
		sqlBuilder.append("res.code as code_res,");// 预约设备编码
		sqlBuilder.append("res.name as name_res,");// 预约设备名称
		sqlBuilder.append("phydep.code as code_dept_pat,");// 患者科室编码
		sqlBuilder.append("phydep.name as name_dept_pat,");// 患者科室名称
		sqlBuilder.append("org.orgcode as code_org,");// 医疗机构编码
		sqlBuilder.append("org.name as name_org,");// 医疗机构名称
		sqlBuilder.append("tick.queno as num_apt,");// 预约排序号
		sqlBuilder.append("(case when appl.times is null then '0' else appl.times end) as times,");// 就诊次数
		sqlBuilder.append("appl.id_or,");// 医嘱id
		sqlBuilder.append("appl.code_or,");// 医嘱号
		sqlBuilder.append("appl.applyno as code_apply,");// 申请单号
		sqlBuilder.append("pat.code as code_pat,");// 患者编码
		sqlBuilder.append("day.id_dayslot,");// 日期分组id
		sqlBuilder.append("udidoc.code_ie as name_dayslot,");// 日期分组名称
		sqlBuilder.append("bdsrv.sd_iemsgca");//医嘱项目分类
		sqlBuilder.append(" from sc_apt apt");
		sqlBuilder.append(" left join sc_apt_mt mt on apt.id_apt = mt.id_apt");
		sqlBuilder.append(" left join sc_apt_appl appl on appl.id_aptappl = mt.id_aptappl");
		sqlBuilder.append(" left join sc_sch sch on sch.id_sch = apt.id_sch");
		sqlBuilder.append(" left join sc_pl pl on pl.id_scpl = sch.id_scpl");
		sqlBuilder.append(" left join sc_tick tick on tick.id_tick = apt.id_tick");
		sqlBuilder.append(" left join sc_res res on res.id_scres = pl.id_scres");
		sqlBuilder.append(" left join en_ent ent on ent.id_ent = appl.id_ent");
		sqlBuilder.append(" left join en_ent_op op on op.id_ent = ent.id_ent");
		sqlBuilder.append(" left join en_ent_ip ip on ip.id_ent = ent.id_ent");
		sqlBuilder.append(" left join bd_dep phydep on phydep.id_dep = ent.id_dep_phy");
		sqlBuilder.append(" left join bd_org org on org.id_org = apt.id_org");
		sqlBuilder.append(" join bd_psndoc psn on apt.id_emp_appt = psn.id_psndoc");
		sqlBuilder.append(" left join bd_dep dep on dep.id_dep = mt.id_dep_mp");
		sqlBuilder.append(" left join pi_pat pat on pat.id_pat = apt.id_pat");
		sqlBuilder.append(" left join bd_dayslot day on day.id_dayslot = sch.id_dayslot");
		sqlBuilder.append(" left join bd_udidoc udidoc on day.id_dayslottp = udidoc.id_udidoc");
		sqlBuilder.append(" left join bd_srv bdsrv on appl.id_srv=bdsrv.id_srv");
		sqlBuilder.append(" where apt.id_apt=?");

		SqlParam param = new SqlParam();
		param.addParam(apt4EsDTO.getId_apt());

		/**	
		 * 异常修正：查询返回的类型：Array -> List(zhengcm)
		 */
		List<MtApt4IpDTO> aptDTOs = (List<MtApt4IpDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(MtApt4IpDTO.class));
		if (ListUtil.isEmpty(aptDTOs)) {
			return null;
		}
		MtApt4IpDTO dto = aptDTOs.get(0);
		dto.setArea("01");
		return dto;
	}
}
