package iih.pi.reg.s.bp.listener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.params.PiParams;
import iih.pi.reg.dto.d.PiPat4IpDTO;
import iih.pi.reg.dto.d.PiPatBS501CondDTO;
import iih.pi.reg.dto.d.PiPatRepeatDTO;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatBiolDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.s.ws.RepeatPatSearchBP;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 患者信息变动监听
 * 
 * @author hao_wu 2018-8-6 迭代逻辑，确定产品方案(与此逻辑不同的方案，进客开项目)
 * 
 */
public class PiPatEventListener implements IBusinessListener {

	private IUdidocRService udiRSrv = ServiceFinder.find(IUdidocRService.class);
	private ICountryzoneRService countrySrv = ServiceFinder.find(ICountryzoneRService.class);
	private IPsndocMDORService psndocSrv = ServiceFinder.find(IPsndocMDORService.class);
	private IAdminareaRService areaRSrv = ServiceFinder.find(IAdminareaRService.class);
	private IOrgRService orgRService = ServiceFinder.find(IOrgRService.class);
	private UdidocDO udidocDo = null;

	@Override
	public void doAction(IBusinessEvent event) throws BizException {

		BDCommonEvent bdcEvent = (BDCommonEvent) event;
		if (!PatiAggDO.class.getName().equals(bdcEvent.getSourceID())) {
			// 事件源ID不匹配
			return;
		}
		if (StringUtils.isEmpty(bdcEvent.getEventType())) {
			// 事件类型为空
			return;
		}

		PatiAggDO[] newPatAggs = getPatAggs(bdcEvent.getNewObjs());
		PatiAggDO[] oldPatAggs = getPatAggs(bdcEvent.getOldObjs());

		if (ArrayUtil.isEmpty(newPatAggs)) {
			return;
		}

		for (int i = 0; i < newPatAggs.length; i++) {
			PatiAggDO newPatAgg = newPatAggs[i];
			PatiAggDO oldPatAgg = (oldPatAggs != null && oldPatAggs.length > i) ? oldPatAggs[i] : null;
			invokeIEEvent(newPatAgg, oldPatAgg, event);
		}
	}

	/**
	 * 触发IE平台事件
	 * 
	 * @param newPatAgg
	 * @param oldPatAgg
	 * @param event
	 * @throws BizException
	 */
	public void invokeIEEvent(PatiAggDO newPatAgg, PatiAggDO oldPatAgg, IBusinessEvent event) throws BizException {

		PatDO newPatDo = newPatAgg.getParentDO();
		PiParams piParams = new PiParams();
		FBoolean fgEmpi = piParams.PIPAT0005();
		if (FBoolean.FALSE.equals(fgEmpi))
			return;

		if (IPiPatConst.PAT_ORIGIN_EMPI.equals(newPatDo.getOrigin())
				|| IPiPatConst.PAT_ORIGIN_CHIS.equals(newPatDo.getOrigin())) {
			// empi同步来的患者无需再同步回empi
			// chis同步来的患者无需再同步回empi
			return;
		}
		FBoolean PIPAT0033 = piParams.PIPAT0033();
		if (!FBoolean.TRUE.equals(newPatDo.getFg_realname()) && FBoolean.FALSE.equals(PIPAT0033)) {
			// 非实名认证且参数配置不允许不触发empi事件
			return;
		}

		newPatAgg.getParentDO().setDomain(IPiDictCodeConst.DOMAIN_ID_MZ);

		// 获取IE使用的数据DTO
		PiPat4IpDTO pipatmsgDTO = getPiPat4IEDTO(newPatAgg);

		// 获取业务事件对象
		BusinessEvent businessEvent = getOpBusinessEvent(newPatAgg, oldPatAgg, event, pipatmsgDTO);

		// 触发集成平台事件
		invokeIEEvent(businessEvent);

		// 清空chis存在标志
		newPatDo.setFg_chisexist(null);
	}

	/**
	 * 获取门诊业务事件
	 * 
	 * @param newPatAgg
	 * @param oldPatAgg
	 * @param event
	 * @return
	 */
	private BusinessEvent getOpBusinessEvent(PatiAggDO newPatAgg, PatiAggDO oldPatAgg, IBusinessEvent event,
			PiPat4IpDTO pipatmsgDTO) {

		PatDO newPatDo = newPatAgg.getParentDO();

		DomainBusinessUserObj buo = new DomainBusinessUserObj(pipatmsgDTO, BusiType.MZ, "0", "0");

		boolean realNameAction = isRealNameAction(newPatAgg, oldPatAgg, event);

		String businessEventTp = getOpBusinessEventTp(event, pipatmsgDTO, newPatDo, realNameAction);

		BusinessEvent bizEvent = new BusinessEvent(PatiAggDO.class.getName(), businessEventTp, buo);

		return bizEvent;
	}

	/**
	 * 获取门诊业务事件类型
	 * 
	 * @param event
	 * @param pipatmsgDTO
	 * @param newPatDo
	 * @param realNameAction
	 * @return
	 */
	private String getOpBusinessEventTp(IBusinessEvent event, PiPat4IpDTO pipatmsgDTO, PatDO newPatDo,
			boolean realNameAction) {

		String opBusinessEventTp;

		switch (event.getEventType()) {
		case IEventType.TYPE_INSERT_AFTER:
			pipatmsgDTO.setMsgtype("insert");
			opBusinessEventTp = IEventType.TYPE_INSERT_AFTER;
			break;
		case IEventType.TYPE_UPDATE_AFTER:
			if (realNameAction) {
				pipatmsgDTO.setMsgtype("insert");
				opBusinessEventTp = IEventType.TYPE_INSERT_AFTER;
			} else {
				pipatmsgDTO.setMsgtype("update");
				opBusinessEventTp = IEventType.TYPE_UPDATE_AFTER;
			}
			break;
		case IEventType.TYPE_DELETE_AFTER:
			pipatmsgDTO.setMsgtype("delete");
			opBusinessEventTp = IEventType.TYPE_DELETE_AFTER;
			break;
		default:
			pipatmsgDTO.setMsgtype("update");
			opBusinessEventTp = IEventType.TYPE_UPDATE_AFTER;
			break;
		}

		return opBusinessEventTp;
	}

	/**
	 * 触发集成平台事件
	 * 
	 * @param businessEvent
	 * @throws BizException
	 */
	private void invokeIEEvent(BusinessEvent businessEvent) throws BizException {
		// 触发集成平台事件
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(businessEvent);
	}

	/**
	 * 判断患者是否是实名认证动作触发更新
	 * 
	 * @param newPatAgg
	 * @param oldPatAgg
	 * @param event
	 * @return
	 */
	private boolean isRealNameAction(PatiAggDO newPatAgg, PatiAggDO oldPatAgg, IBusinessEvent event) {
		PatDO oldPatDo = oldPatAgg == null ? null : oldPatAgg.getParentDO();
		PatDO newPatDo = newPatAgg.getParentDO();

		if (IEventType.TYPE_INSERT_AFTER.equals(event.getEventType())
				&& FBoolean.TRUE.equals(newPatDo.getFg_realname())) {
			// 新注册实名认证患者
			return true;
		}

		if (IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()) && FBoolean.TRUE.equals(newPatDo.getFg_realname())
				&& (oldPatDo == null || !newPatDo.getFg_realname().equals(oldPatDo.getFg_realname()))) {
			// 旧患者实名认证
			return true;
		}

		return false;
	}

	/**
	 * 将Obj数组转换为患者Agg集合
	 * 
	 * @param objs
	 * @return
	 */
	private PatiAggDO[] getPatAggs(Object[] objs) {
		if (objs == null || objs.length <= 0) {
			return null;
		}

		ArrayList<PatiAggDO> patiAggList = new ArrayList<PatiAggDO>();
		for (Object obj : objs) {
			if (obj instanceof PatiAggDO) {
				patiAggList.add((PatiAggDO) obj);
			}
		}
		return patiAggList.toArray(new PatiAggDO[0]);
	}

	/**
	 * 组装IE平台使用DTO
	 * 
	 * @param pataggdo
	 * @return
	 * @throws BizException
	 */
	private PiPat4IpDTO getPiPat4IEDTO(PatiAggDO pataggdo) throws BizException {
		PiPat4IpDTO pipatmsgDTO = new PiPat4IpDTO();

		// 设置患者基本信息
		setPatInfo(pataggdo, pipatmsgDTO);

		// 设置患者联系人信息
		setPatcont(pataggdo, pipatmsgDTO);

		// 设置患者地址信息
		setPlacesInfo(pipatmsgDTO, pataggdo);

		// 设置患者医保信息
		setHpInfo(pipatmsgDTO, pataggdo);

		// 设置患者生物学信息 wqp
		setBloodInfo(pipatmsgDTO, pataggdo);

		// 尝试设置EMPI的EID
		trySetEId(pataggdo.getParentDO(), pipatmsgDTO);

		return pipatmsgDTO;
	}

	/**
	 * 尝试设置EMPI的EID
	 * 
	 * @param patdo
	 * @param pipatmsgDTO
	 * @throws BizException
	 */
	private void trySetEId(PatDO patdo, PiPat4IpDTO pipatmsgDTO) throws BizException {
		// 查询EMPI_id 根据患者code和域id 域id默认"01" shao_yuan
		PiPatBS501CondDTO cond = new PiPatBS501CondDTO();
		cond.setPatient_id(patdo.getCode());
		cond.setDomain_id("01");
		OrgDO OrgDo = orgRService.findById(Context.get().getOrgId());
		cond.setHospital_code(OrgDo.getCode());// 医疗机构编码
		RepeatPatSearchBP bp = new RepeatPatSearchBP();
		PiPatRepeatDTO[] result = bp.searchPatByBS501(cond);
		if (!ArrayUtil.isEmpty(result)) {
			pipatmsgDTO.setEmpi_id(result[0].getEmpi_id());
		}
	}

	/**
	 * 设置患者医保信息
	 * 
	 * @param pipatmsgDTO
	 * @param pataggdo
	 */
	private void setHpInfo(PiPat4IpDTO pipatmsgDTO, PatiAggDO pataggdo) {
		PiPatHpDO[] pathps = pataggdo.getPiPatHpDO();
		if (!ArrayUtil.isEmpty(pathps)) {
			for (PiPatHpDO hpDo : pathps) {
				if (hpDo.getFg_deft() != null && hpDo.getFg_deft() == FBoolean.TRUE) {
					pipatmsgDTO.setCode_hp(hpDo.getNo_hp());
				}
			}
		}
	}

	/**
	 * 设置患者联系人信息
	 * 
	 * @param pataggdo
	 * @param pipatmsgDTO
	 * @throws BizException
	 */
	private void setPatcont(PatiAggDO pataggdo, PiPat4IpDTO pipatmsgDTO) throws BizException {
		// 患者联系人
		PiPatContDO[] conts = pataggdo.getPiPatContDO();
		if (!ArrayUtil.isEmpty(conts)) {
			if (!StringUtils.isEmpty(conts[0].getId_conttp())) {
				udidocDo = udiRSrv.findById(conts[0].getId_conttp());
				if (udidocDo != null) {
					pipatmsgDTO.setRelation_code(udidocDo.getCode_ie());// 联系人关系编码
					pipatmsgDTO.setRelation_code_name(udidocDo.getName());// 联系人关系名称
				}
			}
			pipatmsgDTO.setRelation_street(conts[0].getContaddr());
			pipatmsgDTO.setRelation_address(conts[0].getContaddr());
			pipatmsgDTO.setRelation_district_code("_");
			pipatmsgDTO.setRelation_postcode(conts[0].getZip());
			pipatmsgDTO.setRelationtel(conts[0].getConttel());
			pipatmsgDTO.setRelation_name(conts[0].getName());
		}
	}

	/**
	 * 
	 * 设置患者基本信息
	 * 
	 * @param pataggdo
	 * @param pipatmsgDTO
	 * @return
	 * @throws BizException
	 */
	private void setPatInfo(PatiAggDO pataggdo, PiPat4IpDTO pipatmsgDTO) throws BizException {
		PatDO patdo = pataggdo.getParentDO();
		if (patdo == null)
			throw new BizException("患者基本信息为空!");

		pipatmsgDTO.setId_pat(patdo.getCode());
		if (StringUtils.isNotEmpty(patdo.getDomain())) {
			pipatmsgDTO.setDomainid(patdo.getDomain());
		} else {
			pipatmsgDTO.setDomainid(IPiDictCodeConst.DOMAIN_ID_MZ);
			pipatmsgDTO.setDomain_id_name("门诊");
		}

		pipatmsgDTO.setCode_amr_ip(patdo.getCode_amr_ip());// 住院号
		if (StringUtils.isEmpty(patdo.getBarcode_chis()) || patdo.getBarcode_chis().length() > 18) {
			// 取患者编码
			pipatmsgDTO.setCode_amr_oep(patdo.getCode());// 门诊号
		} else {
			// 取条码号
			pipatmsgDTO.setCode_amr_oep(patdo.getBarcode_chis());// 门诊号
		}

		// 其他号码
		String codetp = patdo.getSd_idtp();
		if (!StringUtils.isEmpty(codetp)) {
			switch (codetp) {
			case "01":
				pipatmsgDTO.setIdcard(patdo.getId_code());// 身份证
				break;
			case "02":
				pipatmsgDTO.setOther_card_no_jmhkb(patdo.getId_code());// 户口本
				break;
			case "03":
				pipatmsgDTO.setOther_card_no_hz(patdo.getId_code());// 护照
				break;
			case "04":
				pipatmsgDTO.setOther_card_no_jgz(patdo.getId_code());// 军官证
				break;
			case "05":
				pipatmsgDTO.setOther_card_no_jsz(patdo.getId_code());// 驾驶证
				break;
			case "06":
				pipatmsgDTO.setOther_card_no_gajm(patdo.getId_code());// 港澳居民来往内地通行
				break;
			case "07":
				pipatmsgDTO.setOther_card_no_twjm(patdo.getId_code());// 台湾居民来往内地通行
				break;
			case "99":
				pipatmsgDTO.setOther_card_no_qtfd(patdo.getId_code());// 其他法定有效证件
				break;
			default:
				pipatmsgDTO.setIdcard(patdo.getId_code());// 身份证
				break;
			}
		}

		// 医保计划信息
		PiPatHpDO[] hpdos = pataggdo.getPiPatHpDO();
		if (!ArrayUtil.isEmpty(hpdos)) {
			pipatmsgDTO.setCode_hp(hpdos[0].getHp_code());// 医保号
		}
		pipatmsgDTO.setMobile(patdo.getMob());
		pipatmsgDTO.setHometel(patdo.getTel());
		pipatmsgDTO.setName_pat(patdo.getName());
		pipatmsgDTO.setSexcode(patdo.getSd_sex());// 性别编码
		// weiqp 2019-06-21
		pipatmsgDTO.setSexname(patdo.getName_sex());
		pipatmsgDTO.setEduname(patdo.getName_educ());

		pipatmsgDTO.setEducode(patdo.getSd_educ());// 学历

		if (patdo.getDt_birth() != null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			pipatmsgDTO.setBirthday(format.format(patdo.getDt_birth().toDate()));
		}

		if (StringUtils.isNotEmpty(patdo.getId_marry())) {// 婚姻
			udidocDo = udiRSrv.findById(patdo.getId_marry());
			if (udidocDo != null) {
				pipatmsgDTO.setMarrycode(udidocDo.getCode_ie());
				pipatmsgDTO.setMarryname(udidocDo.getName());
			}
		}
		if (StringUtils.isNotEmpty(patdo.getId_nation())) {// 民族
			udidocDo = udiRSrv.findById(patdo.getId_nation());
			if (udidocDo != null) {
				pipatmsgDTO.setNation_code_name(udidocDo.getName());
				pipatmsgDTO.setNation_code(udidocDo.getCode_ie());
			}
		}
		if (StringUtils.isNotEmpty(patdo.getId_occu())) {// 职业特征代码
			udidocDo = udiRSrv.findById(patdo.getId_occu());
			if (udidocDo != null) {
				pipatmsgDTO.setOccutypename(udidocDo.getName());
				pipatmsgDTO.setOccutypecode(udidocDo.getCode_ie());
			}
		}

		if (StringUtils.isNotEmpty(patdo.getId_country())) {
			CountryZoneDO czone = countrySrv.findById(patdo.getId_country());
			if (czone != null) {
				pipatmsgDTO.setCountry_code(czone.getCode());// 国家编码
				pipatmsgDTO.setCountry_code_name(czone.getFullname());// 国家名称
				pipatmsgDTO.setDistrict(czone.getName());// 国籍
			}
		}
		pipatmsgDTO.setWorkplace(patdo.getWorkunit());
		PsnDocDO psnDo = psndocSrv.findById(Context.get().getStuffId());
		if (psnDo != null) {
			pipatmsgDTO.setInput_opera(psnDo.getCode());// 操作人Code
			pipatmsgDTO.setInput_opera_name(psnDo.getName());// 操作人名称
		}
		OrgDO orgDo = orgRService.findById(Context.get().getOrgId());
		if (orgDo != null) {
			pipatmsgDTO.setHospitalcode(orgDo.getOrgcode());// 医疗机构编码
			pipatmsgDTO.setHospitalname(orgDo.getName());// 医疗机构名称
		}
	}

	/**
	 * 获取患者生物学信息
	 * 
	 * @param pipatmsgDTO
	 * @param pataggdo
	 * @throws BizException
	 */
	private void setBloodInfo(PiPat4IpDTO pipatmsgDTO, PatiAggDO pataggdo) throws BizException {
		PiPatBiolDO[] biols = pataggdo.getPiPatBiolDO();
		if (!ArrayUtil.isEmpty(biols)) {
			for (PiPatBiolDO piPatBiolDO : biols) {
				if (StringUtils.isNotEmpty(piPatBiolDO.getId_blood_abo())) {
					UdidocDO udidocDO = udiRSrv.findById(piPatBiolDO.getId_blood_abo());
					pipatmsgDTO.setAbo_blood(udidocDO.getCode());
					pipatmsgDTO.setAbo_blood_name(udidocDO.getName());
				}
				if (StringUtils.isNotEmpty(piPatBiolDO.getId_blood_rh())) {
					UdidocDO udidocDO = udiRSrv.findById(piPatBiolDO.getId_blood_rh());
					pipatmsgDTO.setHr_blood(udidocDO.getCode());
					pipatmsgDTO.setHr_blood_name(udidocDO.getName());
				}
			}
		}

	}

	/**
	 * 获取患者地址信息
	 * 
	 * @param pipatmsgDTO
	 * @param pataggdo
	 * @throws BizException
	 */
	private void setPlacesInfo(PiPat4IpDTO pipatmsgDTO, PatiAggDO pataggdo) throws BizException {

		// 患者地址
		PatiAddrDO[] addrs = pataggdo.getPatiAddrDO();
		if (!ArrayUtil.isEmpty(addrs)) {
			for (PatiAddrDO add : addrs) {
				String addrStress = "";
				if (StringUtils.isNotEmpty(add.getId_admdiv())) {
					AdminAreaDO areaDo = areaRSrv.findById(add.getId_admdiv());
					if (areaDo != null)
						addrStress = areaDo.getFullname();
				}
				switch (Integer.parseInt(add.getSd_addrtp())) {
				case 1:// 户籍地址
					pipatmsgDTO.setNative_district_code(add.getSd_admdiv());
					pipatmsgDTO.setNative_street(add.getStreet());
					pipatmsgDTO.setNative_address(addrStress);
					pipatmsgDTO.setNative_postcode(add.getZip());
					break;
				case 2:// 工作地址
					pipatmsgDTO.setWork_district_code(add.getSd_admdiv());// 工作单位地址-区县码
					pipatmsgDTO.setWork_street(add.getStreet());// 工作单位地址-街道
					pipatmsgDTO.setWork_address(addrStress);// 工作单位地址-地址
					pipatmsgDTO.setWork_postcode(add.getZip());// 工作单位地址-邮编
					pipatmsgDTO.setWorktel(add.getTel());// 工作单位电话号码
					break;
				case 3:// 家庭常住地址
					pipatmsgDTO.setHome_district_code(add.getSd_admdiv());
					pipatmsgDTO.setHome_address(addrStress);
					pipatmsgDTO.setHome_street(add.getStreet());
					pipatmsgDTO.setHome_zipcode(add.getZip());
					break;
				case 6:// 出生地址
					pipatmsgDTO.setBornplace(addrStress);
					// pipatmsgDTO.setBornplace(addrStress);
					pipatmsgDTO.setBornplace_zip(add.getZip());
					break;
				case 9:// 现住地址
					pipatmsgDTO.setLive_district_code(add.getSd_admdiv());
					pipatmsgDTO.setLive_street(add.getStreet());
					pipatmsgDTO.setLive_address(addrStress);
					pipatmsgDTO.setLive_postcode(add.getZip());
					break;
				}
			}
			if (StringUtils.isEmpty(pipatmsgDTO.getHome_address())) {
				// 家庭常住地址为空时取现住地址
				pipatmsgDTO.setHome_district_code(pipatmsgDTO.getLive_district_code());
				pipatmsgDTO.setHome_address(pipatmsgDTO.getLive_address());
				pipatmsgDTO.setHome_street(pipatmsgDTO.getLive_street());
				pipatmsgDTO.setHome_zipcode(pipatmsgDTO.getLive_postcode());
			}
		}
	}
}
