package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.ep.DeptEP;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.EntDeptEP;
import iih.en.comm.ep.EntDiEP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PsnDocEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.IpDetailDTO;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.desc.UdidocDODesc;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 获取住院详细信息BP
 * 
 * @author zhengcm
 * @date 2016-07-07 11:07:38
 *
 */
public class GetIpDetailInfoBP {
	/**
	 * 获取住院详细信息
	 * 
	 * @param entId
	 *            就诊ID
	 * @return
	 * @throws BizException
	 */
	public IpDetailDTO exec(String entId) throws BizException {
		if (EnValidator.isEmpty(entId)) {
			return null;
		}

		// 1、获取就诊信息
		IpDetailDTO dto = this.getEntInfo(entId);

		if (null == dto) {
			return null;
		}

		// 2、补全医保数据
		this.fillEntHpInfo(dto);

		// 3、补全联系人数据
		this.fillEntContInfo(dto);

		// 4、补全患者信息数据
		this.fillPiPatInfo(dto);

		// 5、补全住院信息数据
		this.fillEntIPInfo(dto);

		// 6、补全来院方式名称
		this.fillNameReferalsrc(dto);

		// 7、补全就诊临床诊断数据
		this.fillEntDIInfo(dto);

		// 8、补全转科科室数据
		this.fillTransDeptInfo(dto);

		// 9、补全出院病区和科室名称
		this.fillOutHospitalDeptInfo(dto);

		// 10、补全人员名称
		this.fillPsnDocInfo(dto);

		// 11、补全主身份标识名称
		this.fillNameIdtp(dto);

		// 12、设置就诊类型信息
		this.setEnttpInfo(dto);

		// 13、计算住院天数
		this.calulateHosDays(dto);

		// 14、补全新生儿体重
		this.fillBabyWeight(dto);
		
		// 15、如果有新生儿，赋值第一个新生儿的一些信息
		this.fillFirstNbInfo(dto);
		
		return dto;
	}

	/**
	 * 获取就诊信息数据
	 *
	 * @param entId
	 *            就诊id
	 * @return 住院详细信息DTO
	 * @throws BizException
	 */
	private IpDetailDTO getEntInfo(String entId) throws BizException {
		if (EnValidator.isEmpty(entId)) {
			return null;
		}
		IpDetailDTO dto = null;
		// 患者就诊信息
		PatiVisitDO entDO = new PvEP().getPvById(entId);
		if (null != entDO) {
			dto = new IpDetailDTO();
			dto.setId_ent(entId);// 就诊id
			dto.setId_pat(entDO.getId_pat());// 患者id
			dto.setCode_ent(entDO.getCode());// 就诊编码
			dto.setDt_end(entDO.getDt_end());// 出院时间
			dto.setFg_ip(entDO.getFg_ip());// 在院标志
			dto.setTel(entDO.getTelno_pat());// 联系电话
			dto.setAddr_pat(entDO.getAddr_pat());// 现住址
			dto.setId_admdiv(entDO.getId_admdiv_addr());// 区县码id
			dto.setSd_admdiv(entDO.getSd_admdiv_addr());// 区县码编码
			dto.setName_admdiv(entDO.getName_addr());// 区县码名称
			dto.setFullname_admdiv(entDO.getFullname_addr());// 区县码全称
			dto.setDt_birth(entDO.getDt_birth_pat());// 出生日期
			dto.setSd_mari_pat(entDO.getSd_mari_pat());// 婚姻状况
			dto.setDt_acpt(entDO.getDt_acpt());// 入院时间
			dto.setId_dep_phy(entDO.getId_dep_phy());// 当前科室id
			dto.setName_dep_phy(entDO.getName_dep_phy());// 当前科室名称
			dto.setSd_dep_phy(entDO.getSd_dep_phy());
			dto.setId_dep_nur(entDO.getId_dep_nur());// 当前病区id
			dto.setName_dep_nur(entDO.getName_dep_nur());// 当前病区名称
			dto.setSd_dep_nur(entDO.getSd_dep_nur());
			dto.setId_emp_phy(entDO.getId_emp_phy());// 主管医生id
			dto.setName_emp_phy(entDO.getName_emp_phy());// 主管医生
			dto.setId_emp_nur(entDO.getId_emp_nur());// 责任护士id
		}
		return dto;
	}

	/**
	 * 补全医保数据
	 *
	 * @param dto
	 *            住院详细信息DTO
	 * @throws BizException
	 */
	private void fillEntHpInfo(IpDetailDTO dto) throws BizException {
		if (EnValidator.isEmpty(dto.getId_ent())) {
			return;
		}
		if (!EnValidator.isEmpty(dto.getName_hp()) && !EnValidator.isEmpty(dto.getName_hp_as())) {
			return;
		}
		EntHpDO[] hpDOs = new EntHpEP().getEntHpList(dto.getId_ent());
		if (EnValidator.isEmpty(hpDOs)) {
			return;
		}
		for (EntHpDO hpDO : hpDOs) {
			FBoolean fg = hpDO.getFg_maj();
			if (EnValidator.isEmpty(dto.getName_hp()) && fg.booleanValue()) {
				dto.setId_hp(hpDO.getId_hp());// 主医保计划id
				dto.setName_hp(hpDO.getName_hp());// 主医保计划
				dto.setNo_hp(hpDO.getNo_hp());// 主医保卡号
			}
			if (EnValidator.isEmpty(dto.getName_hp_as()) && !fg.booleanValue()) {
				dto.setId_hp_as(hpDO.getId_hp());// 辅医保计划id
				dto.setName_hp_as(hpDO.getName_hp());// 辅医保计划
				dto.setNo_hp_as(hpDO.getNo_hp());// 辅医保卡号
			}
		}
	}

	/**
	 * 补全联系人数据
	 *
	 * @param dto
	 *            住院详细信息DTO
	 * @throws BizException
	 */
	private void fillEntContInfo(IpDetailDTO dto) throws BizException {
		if (EnValidator.isEmpty(dto.getId_ent())) {
			return;
		}
		EntContDO[] entDOs = new EntContEP().getEntContByEntId(dto.getId_ent());
		if (EnValidator.isEmpty(entDOs)) {
			return;
		}
		for (EntContDO entDO : entDOs) {
			int type = entDO.getEu_entconttp();
			// 联系人
			if (EnValidator.isEmpty(dto.getCont_name()) && type == EuEntContTp.CONTACT.intValue()) {
				dto.setCont_name(entDO.getName());// 联系人名称
				dto.setSd_conttp(entDO.getSd_conttp());// 联系人类型编码
				dto.setId_conttp(entDO.getId_conttp());// 联系人类型ID
				dto.setName_conttp(entDO.getName_conttp());// 联系人类型
				dto.setCont_tel(entDO.getConttel());// 联系人电话
				dto.setCont_address(entDO.getContaddr());// 联系人地址
				break;
			}
			// 是新生儿且没有联系人,取母亲的
			if (EnValidator.isEmpty(dto.getCont_name()) && type == EuEntContTp.MOTHER.intValue() && dto.getFg_newborn() != null && dto.getFg_newborn().booleanValue()) {
				dto.setCont_name(entDO.getName());// 联系人名称
				dto.setSd_conttp(entDO.getSd_conttp());// 联系人类型编码
				dto.setId_conttp(entDO.getId_conttp());// 联系人类型ID
				dto.setName_conttp(entDO.getName_conttp());// 联系人类型
				dto.setCont_tel(entDO.getConttel());// 联系人电话
				dto.setCont_address(entDO.getContaddr());// 联系人地址
				break;
			}
		}
	}

	/**
	 * 补充患者信息数据
	 *
	 * @param dto
	 *            住院详细信息DTO
	 * @throws BizException
	 */
	private void fillPiPatInfo(IpDetailDTO dto) throws BizException {
		if (EnValidator.isEmpty(dto.getId_pat())) {
			return;
		}
		// 患者基本信息
		PatDO patDO = new PatEP().getPatById(dto.getId_pat());
		if (null != patDO) {
			dto.setId_pat(patDO.getId_pat());// 患者ID
			dto.setName_pat(patDO.getName());// 患者姓名
			dto.setId_sex_pat(patDO.getId_sex());// 性别id
			dto.setName_sex_pat(patDO.getName_sex());// 性别
			dto.setSd_sex_pat(patDO.getSd_sex());// 性别编码
			dto.setId_nation(patDO.getId_nation());// 民族id
			dto.setName_nation(patDO.getNation_name());// 民族
			dto.setId_patca(patDO.getId_paticate());// 患者分类id
			dto.setName_patca(patDO.getPaticate_name());// 患者分类名称
			dto.setId_pripat(patDO.getId_patpritp());// 患者价格分类id
			dto.setName_pripat(patDO.getPatpritp_name());// 患者价格分类名称
			dto.setId_patcret(patDO.getId_patcrettp());// 患者信用分类id
			dto.setName_patcret(patDO.getPatcrettp_name());// 患者信用分类名称
			dto.setId_idtp(patDO.getId_idtp());// 主身份标识类型
			dto.setSd_idtp(patDO.getSd_idtp());// 主身份标识类型编码
			dto.setId_code(patDO.getId_code());// 主身份标识号码
		}
	}

	/**
	 * 补全住院属性数据：来院方式、入院病区、入院科室、床位、护理等级、病情等级、营养等级、就诊状态、新生儿标志、出院病区、 出院科室、住院病案号
	 *
	 * @param dto
	 *            住院详细信息DTO
	 * @throws BizException
	 */
	private void fillEntIPInfo(IpDetailDTO dto) throws BizException {
		if (EnValidator.isEmpty(dto.getId_ent())) {
			return;
		}
		InpatientDO[] ipDOs = new IpEP().getIpDOByEntId(dto.getId_ent());
		if (EnValidator.isEmpty(ipDOs)) {
			return;
		}
		InpatientDO ipDO = ipDOs[0];
		dto.setId_referalsrc(ipDO.getId_referalsrc());// 来院方式id
		dto.setSd_referalsrc(ipDO.getSd_referalsrc());// 来院方式编码
		dto.setId_dep_nuradm(ipDO.getId_dep_nuradm());// 入院病区
		dto.setName_dep_nuradm(ipDO.getName_dep_nur());
		dto.setSd_dep_nuradm(ipDO.getSd_dep_nur());
		dto.setId_dep_phyadm(ipDO.getId_dep_phyadm());// 入院科室
		dto.setCode_dep_phyadm(ipDO.getSd_dep_phy());// 入院科室编码
		dto.setName_dep_phyadm(ipDO.getName_dep_phy());// 入院科室名称
		dto.setId_bed(ipDO.getId_bed());// 床位id
		dto.setName_bed(ipDO.getName_bed());// 床位
		dto.setId_level_nur(ipDO.getId_level_nur());// 护理等级id
		dto.setSd_level_nur(ipDO.getSd_level_nur());// 护理等级编码
		dto.setName_level_nur(ipDO.getName_level_nur());// 护理等级
		dto.setId_level_dise(ipDO.getId_level_dise());// 病情等级id
		dto.setSd_level_dise(ipDO.getSd_level_dise());// 病情等级编码
		dto.setName_level_dise(ipDO.getName_level_dise());// 病情等级
		dto.setId_level_nutr(ipDO.getId_level_nutr());// 营养等级id
		dto.setSd_level_nutr(ipDO.getSd_level_nutr());// 营养等级编码
		dto.setName_level_nutr(ipDO.getName_level_nutr());// 营养等级
		dto.setSd_status(ipDO.getSd_status());// 就诊状态
		dto.setFg_newborn(ipDO.getFg_newborn());// 新生儿标志
		dto.setId_dep_nurdisc(ipDO.getId_dep_nurdisc());// 出院病区
		dto.setId_dep_phydisc(ipDO.getId_dep_phydisc());// 出院科室
		dto.setCode_amr_ip(ipDO.getCode_amr_ip());// 住院病案号
		dto.setTimes_ip(ipDO.getTimes_ip());// 住院次数
		dto.setId_di_entry(ipDO.getId_diag_op());// 入院诊断
		dto.setCode_di_entry(ipDO.getSd_diag_op());// 诊断编码
		dto.setName_di_entry(ipDO.getName_diag_op());// 诊断名称
		dto.setSupl_di_entry(ipDO.getDesc_diag_op());// 入院诊断描述
		IUdidocRService uService = ServiceFinder.find(IUdidocRService.class);
		//付款方式
		UdidocDO[] payMethods = uService.find(String.format(UdidocDODesc.TABLE_ALIAS_NAME + ".id_udidoclist='%s' and " + UdidocDODesc.TABLE_ALIAS_NAME
						+ ".code='%s'", "@@@@TL400000000000QF", ipDO.getSd_pay_mothod()), null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(payMethods) && payMethods.length > 0) {
			dto.setId_pay_mothod(payMethods[0].getId_udidoc());
			dto.setName_pay_mothod(payMethods[0].getName());
			dto.setSd_pay_mothod(payMethods[0].getCode());
		}
	}

	/**
	 * 补全转科科室信息
	 * 
	 * @param dto
	 *            住院详细信息DTO
	 * @throws BizException
	 */
	private void fillTransDeptInfo(IpDetailDTO dto) throws BizException {
		if (EnValidator.isEmpty(dto.getId_ent())) {
			return;
		}
		// 转科科室
		EnDepDO transDepDO = new EntDeptEP().getTransDept(dto.getId_ent());
		if (null != transDepDO) {
			dto.setId_dep_trans(transDepDO.getId_dep());// 转科科室id
			dto.setName_dep_trans(transDepDO.getDep_name());// 转科科室名称
		}
	}

	/**
	 * 补全人员信息：责任护士名称
	 *
	 * @param dto
	 *            住院详细信息DTO
	 * @throws BizException
	 */
	private void fillPsnDocInfo(IpDetailDTO dto) throws BizException {
		if (EnValidator.isEmpty(dto.getId_emp_nur())) {
			return;
		}
		PsnDocDO psnDO = new PsnDocEP().getPsnById(dto.getId_emp_nur());
		if (null != psnDO) {
			dto.setName_emp_nur(psnDO.getName());// 责任护士名称
		}
	}

	/**
	 * 获取就诊临床诊断数据
	 *
	 * @param dto
	 *            住院详细信息DTO
	 * @throws BizException
	 */
	private void fillEntDIInfo(IpDetailDTO dto) throws BizException {
		if (EnValidator.isEmpty(dto.getId_ent())) {
			return;
		}
		// 主诊断
		EntDiDO diDO = new EntDiEP().getMainDi(dto.getId_ent());
		if (null != diDO) {
			dto.setId_didef_dis(diDO.getId_didef_dis());// 诊断id
			dto.setCode_didef_dis(diDO.getCode_didef_dis());// 诊断code
			dto.setName_didef_dis(diDO.getName_didef_dis());// 诊断名称
			dto.setSupplement(diDO.getSupplement());// 诊断补充说明
		}
	}

	/**
	 * 补全来院方式名称
	 * 
	 * @param dto
	 *            住院详细信息DTO
	 * @throws BizException
	 */
	private void fillNameReferalsrc(IpDetailDTO dto) throws BizException {
		if (EnValidator.isEmpty(dto.getId_referalsrc())) {
			return;
		}
		UdidocDO doc = new UdiDocEP().getUdiDocById(dto.getId_referalsrc());
		if (null != doc) {
			dto.setName_referalsrc(doc.getName());// 来院方式名称
		}
	}

	/**
	 * 补全主身份标识名称
	 * 
	 * @param dto
	 *            住院详细信息DTO
	 * @throws BizException
	 */
	private void fillNameIdtp(IpDetailDTO dto) throws BizException {
		if (EnValidator.isEmpty(dto.getId_idtp())) {
			return;
		}
		UdidocDO doc = new UdiDocEP().getUdiDocById(dto.getId_idtp());
		if (null != doc) {
			dto.setName_idtp(doc.getName());// 主身份标识名称
		}
	}

	/**
	 * 补全出院病区和科室名称
	 * 
	 * @param dto
	 *            住院详细信息DTO
	 * @throws BizException
	 */
	private void fillOutHospitalDeptInfo(IpDetailDTO dto) throws BizException {
		List<String> ids = new ArrayList<String>();
		if (!EnValidator.isEmpty(dto.getId_dep_phydisc())) {
			ids.add(dto.getId_dep_phydisc());
		}
		if (!EnValidator.isEmpty(dto.getId_dep_nurdisc())) {
			ids.add(dto.getId_dep_nurdisc());
		}
		if (EnValidator.isEmpty(ids)) {
			return;
		}
		Map<String, DeptDO> map = new DeptEP().getDeptMap(ids);
		if (EnValidator.isEmpty(map)) {
			return;
		}
		if (!EnValidator.isEmpty(dto.getId_dep_phydisc()) && map.containsKey(dto.getId_dep_phydisc())) {
			dto.setName_dep_phydisc(map.get(dto.getId_dep_phydisc()).getName());// 出院科室名称
			dto.setSd_dep_phydisc(map.get(dto.getId_dep_phydisc()).getCode());
		}
		if (!EnValidator.isEmpty(dto.getId_dep_nurdisc()) && map.containsKey(dto.getId_dep_nurdisc())) {
			dto.setName_dep_nurdisc(map.get(dto.getId_dep_nurdisc()).getName());// 出院病区名称
			dto.setSd_dep_nurdisc(map.get(dto.getId_dep_nurdisc()).getCode());
		}
	}

	/**
	 * 设置就诊类型信息
	 * 
	 * @author zhengcm
	 * @param dto
	 *            住院相信嘻嘻DTO
	 * @throws BizException
	 */
	private void setEnttpInfo(IpDetailDTO dto) throws BizException {
		dto.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		dto.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
	}

	/**
	 * 计算住院天数
	 *
	 * @param dto
	 *            住院详细信息DTO
	 * @throws BizException
	 */
	private void calulateHosDays(IpDetailDTO dto) throws BizException {
		CalculateHosDaysBP daysBP = new CalculateHosDaysBP();
		int days = daysBP.calculate(dto.getDt_acpt(), dto.getDt_end(), dto.getFg_ip());
		dto.setHosdays(days);
	}

	/**
	 * 如果患者为新生儿，补全体重
	 *
	 * @param dto
	 * @throws BizException
	 * @author zhengcm
	 */
	private void fillBabyWeight(IpDetailDTO dto) throws BizException {
		NewbornDO nbDO = new NbEP().getNbDO(dto.getId_ent());
		if (nbDO == null) {
			return;
		}
		dto.setFirstnb_weight_reg(nbDO.getWeight_reg());
		dto.setFirstnb_weight(nbDO.getWeight());
		dto.setWeight_nb(nbDO.getWeight());
	}
	
	/**
	 * 根据母亲id_ent取第一个新生儿的信息（病案首页需求）
	 * 
	 * @param dto
	 * @throws BizException 
	 */
	private void fillFirstNbInfo(IpDetailDTO dto) throws BizException{
		NewbornDO[] nbList = new NbEP().getNbListByMomEnt(dto.getId_ent());
		if(EnValidator.isEmpty(nbList)){
			return;
		}
		NewbornDO firstNb = nbList[0];
		dto.setFirstnb_weight_reg(firstNb.getWeight_reg());
		dto.setFirstnb_weight(firstNb.getWeight());
	}
}
