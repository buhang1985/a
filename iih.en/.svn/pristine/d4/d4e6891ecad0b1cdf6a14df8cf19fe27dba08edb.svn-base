package iih.en.er.bp.stayregist;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.DeptEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.util.EnVisitTimesUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.en.pv.pativisit.i.IEntcontRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPiPatContDORService;
import iih.sc.apt.aptip.d.AptIpDO;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.util.AgeCalcUtil;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * UrgStayRegistryDTO处理
 * 
 * @author liubin
 *
 */
public class UrgStayRegistryDtoHandle {
	/**
	 * 处理自定义档案信息
	 * 
	 * @param urgStayRegistrys
	 * @throws BizException
	 */
	public void udidocHandle(UrgStayRegistryDTO[] urgStayRegistrys)
			throws BizException {
		Set<String> set = new HashSet<>();
		for (UrgStayRegistryDTO urgStayRegistry : urgStayRegistrys) {
			addSet(set, urgStayRegistry, new String[] { "Id_sex", "Id_idtp",
					"Id_marry", "Id_nation", "Id_occu", "Id_level_diseadm" });
		}
		if (set.isEmpty())
			return;
		Map<String, UdidocDO> map = EnFMapUtils.getMap(UdidocDO.ID_UDIDOC,
				new UdiDocEP().getUdiDocByIds(set.toArray(new String[0])));
		if (EnValidator.isEmpty(map))
			return;
		for (UrgStayRegistryDTO urgStayRegistry : urgStayRegistrys) {
			setAttrVal(urgStayRegistry, map, "Id_sex", new MappingNode[] {
					new MappingNode(UdidocDO.CODE, "Sd_sex"),
					new MappingNode(UdidocDO.NAME, "Name_sex") });
			setAttrVal(urgStayRegistry, map, "Id_idtp", new MappingNode[] {
					new MappingNode(UdidocDO.CODE, "Sd_idtp"),
					new MappingNode(UdidocDO.NAME, "Name_idtp") });
			setAttrVal(urgStayRegistry, map, "Id_marry", new MappingNode[] {
					new MappingNode(UdidocDO.CODE, "Sd_marry"),
					new MappingNode(UdidocDO.NAME, "Name_marry") });
			setAttrVal(urgStayRegistry, map, "Id_nation", new MappingNode[] {
					new MappingNode(UdidocDO.CODE, "Sd_nation"),
					new MappingNode(UdidocDO.NAME, "Name_nation") });
			setAttrVal(urgStayRegistry, map, "Id_occu", new MappingNode[] {
					new MappingNode(UdidocDO.CODE, "Sd_occu"),
					new MappingNode(UdidocDO.NAME, "Name_occu") });
			setAttrVal(urgStayRegistry, map, "Id_level_diseadm", new MappingNode[] {
					new MappingNode(UdidocDO.CODE, "Sd_level_diseadm"),
					new MappingNode(UdidocDO.NAME, "Name_level_diseadm") });
		}
	}

	/**
	 * 处理自定义档案信息
	 * 
	 * @param urgStayRegistrys
	 * @throws BizException
	 */
	public void deptHandle(UrgStayRegistryDTO[] urgStayRegistrys) throws BizException {
		Set<String> set = new HashSet<>();
		for (UrgStayRegistryDTO urgStayRegistry : urgStayRegistrys) {
			addSet(set, urgStayRegistry, new String[] { "Id_dep_phyadm", "Id_dep_nuradm" });
		}
		if (set.isEmpty())
			return;
		Map<String, DeptDO> map = new DeptEP().getDeptMapSet(set);
		if (EnValidator.isEmpty(map))
			return;
		for (UrgStayRegistryDTO urgStayRegistry : urgStayRegistrys) {
			setAttrVal(urgStayRegistry, map, "Id_dep_phyadm", new MappingNode[] {
					new MappingNode(DeptDO.CODE, "Code_dep_phyadm"),
					new MappingNode(DeptDO.NAME, "Name_dep_phyadm") });
			setAttrVal(urgStayRegistry, map, "Id_dep_nuradm", new MappingNode[] {
					new MappingNode(DeptDO.CODE, "Code_dep_nuradm"),
					new MappingNode(DeptDO.NAME, "Name_dep_nuradm") });
		}
	}
	/**
	 * 患者地址信息
	 * 
	 * @param urgStayRegistrys
	 * @throws BizException
	 */
	public void patAddrHandle(UrgStayRegistryDTO[] urgStayRegistrys) throws BizException {
		String[] patIds = EnAppUtils.getKeyPropArrayFromDO("Id_pat", urgStayRegistrys);
		if(EnValidator.isEmpty(patIds)) 
			return;
		IPatiAddrDORService serv = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] addrs = serv.findByAttrValStrings(PatiAddrDO.ID_PAT, patIds);
		Map<String, List<PatiAddrDO>> map = EnFMapUtils.getMapList(PatiAddrDO.ID_PAT, addrs);
		if(EnValidator.isEmpty(map))
			return;
		for(UrgStayRegistryDTO urgStayRegistry : urgStayRegistrys){
			if(!map.containsKey(urgStayRegistry.getId_pat()))
				continue;
			List<PatiAddrDO> list = map.get(urgStayRegistry.getId_pat());
			for(PatiAddrDO addr : list){
				switch (addr.getSd_addrtp()) {
				case IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN://籍贯
					urgStayRegistry.setId_addr_origin(addr.getId_admdiv());
					urgStayRegistry.setCode_addr_origin(addr.getSd_admdiv());
					urgStayRegistry.setName_addr_origin(addr.getAdmdiv_fullname());
					break;
				case IPiDictCodeConst.SD_ADDR_TYPE_BORN://出生地址
					urgStayRegistry.setId_addr_born(addr.getId_admdiv());
					urgStayRegistry.setCode_addr_born(addr.getSd_admdiv());
					urgStayRegistry.setName_addr_born(addr.getAdmdiv_fullname());
					break;
				case IPiDictCodeConst.SD_ADDR_TYPE_NOW://现住址
					urgStayRegistry.setId_addr_now(addr.getId_admdiv());
					urgStayRegistry.setCode_addr_now(addr.getSd_admdiv());
					urgStayRegistry.setName_addr_now(addr.getAdmdiv_fullname());
					urgStayRegistry.setStreet_addr_now(addr.getStreet());
					urgStayRegistry.setTel_addr_now(addr.getTel());
					urgStayRegistry.setZip_addr_now(addr.getZip());
					break;
				case IPiDictCodeConst.SD_ADDR_TYPE_WORK://工作地址
					urgStayRegistry.setId_addr_work(addr.getId_admdiv());
					urgStayRegistry.setCode_addr_work(addr.getSd_admdiv());
					urgStayRegistry.setName_addr_work(addr.getAdmdiv_fullname());
					urgStayRegistry.setStreet_addr_work(addr.getStreet());
					urgStayRegistry.setTel_addr_work(addr.getTel());
					urgStayRegistry.setZip_addr_work(addr.getZip());
					break;
				case IPiDictCodeConst.SD_ADDR_TYPE_CENCUS://户口地址
					urgStayRegistry.setId_addr_cencus(addr.getId_admdiv());
					urgStayRegistry.setCode_addr_cencus(addr.getSd_admdiv());
					urgStayRegistry.setName_addr_cencus(addr.getAdmdiv_fullname());
					urgStayRegistry.setStreet_addr_cencus(addr.getStreet());
					urgStayRegistry.setZip_addr_cencus(addr.getZip());
					break;
				default:
					break;
				}
			}
		}
	}
	/**
	 * 就诊联系人信息处理
	 * 
	 * @param urgStayRegistrys
	 * @throws BizException
	 */
	public void entContHandle(UrgStayRegistryDTO[] urgStayRegistrys) throws BizException {
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO("Id_ent", urgStayRegistrys);
		if(EnValidator.isEmpty(entIds)) 
			return;
		IEntcontRService serv = ServiceFinder.find(IEntcontRService.class);
		String whereStr = String.format("Eu_entconttp = '%s' and %s", EuEntContTp.CONTACT, EnSqlUtils.getInSqlByIds("Id_ent", entIds));
		EntContDO[] conts = serv.find(whereStr, EntContDO.SORTNO, FBoolean.FALSE);
		Map<String, EntContDO> map = EnFMapUtils.getMap(EntContDO.ID_ENT, conts);
		if(EnValidator.isEmpty(map))
			return;
		for(UrgStayRegistryDTO urgStayRegistry : urgStayRegistrys){
			if(EnValidator.isEmpty(urgStayRegistry.getId_ent()) || !map.containsKey(urgStayRegistry.getId_ent()))
				continue;
			EntContDO cont = map.get(urgStayRegistry.getId_ent());
			if(EnValidator.isEmpty(cont.getId_patcontid()))
				continue;
			urgStayRegistry.setId_patcont(cont.getId_patcontid());
			urgStayRegistry.setName_patcont(cont.getName());
			urgStayRegistry.setId_conttp(cont.getId_conttp());
			urgStayRegistry.setSd_conttp(cont.getSd_conttp());
			urgStayRegistry.setName_conttp(cont.getName_conttp());
			urgStayRegistry.setConttel(cont.getConttel());
			urgStayRegistry.setContaddr(cont.getContaddr());
		}
	}
	/**
	 * 患者联系人信息处理
	 * 
	 * @param urgStayRegistrys
	 * @throws BizException
	 */
	public void patContHandle(UrgStayRegistryDTO[] urgStayRegistrys) throws BizException {
		String[] patContIds = EnAppUtils.getKeyPropArrayFromDO("Id_patcont", urgStayRegistrys);
		if(EnValidator.isEmpty(patContIds)) 
			return;
		IPiPatContDORService serv = ServiceFinder.find(IPiPatContDORService.class);
		PiPatContDO[] conts = serv.findByIds(patContIds, FBoolean.FALSE);
		Map<String, PiPatContDO> map = EnFMapUtils.getMap(PiPatContDO.ID_PATCONT, conts);
		if(EnValidator.isEmpty(map))
			return;
		for(UrgStayRegistryDTO urgStayRegistry : urgStayRegistrys){
			if(EnValidator.isEmpty(urgStayRegistry.getId_patcont()) || !map.containsKey(urgStayRegistry.getId_patcont())){
				urgStayRegistry.setId_patcont(null);
				continue;
			}
			PiPatContDO cont = map.get(urgStayRegistry.getId_patcont());
			urgStayRegistry.setId_patcont(cont.getId_patcont());
			urgStayRegistry.setName_patcont(cont.getName());
			urgStayRegistry.setId_conttp(cont.getId_conttp());
			urgStayRegistry.setSd_conttp(cont.getSd_conttp());
			urgStayRegistry.setName_conttp(cont.getConttp_name());
			urgStayRegistry.setConttel(cont.getConttel());
			urgStayRegistry.setContaddr(cont.getContaddr());
		}
	}
	/**
	 * 申请单处理
	 * 
	 * @param urgStayRegistrys
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void scAptIpHandle(UrgStayRegistryDTO[] urgStayRegistrys) throws BizException {
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO("Id_ent", urgStayRegistrys);
		if(EnValidator.isEmpty(entIds)) 
			return;
		List<UrgStayRegistryDTO> list = (List<UrgStayRegistryDTO>) new DAFacade().findByAttrValStrings(AptIpDO.class, AptIpDO.ID_ENTIP, entIds, null);
		if(EnValidator.isEmpty(list))
			return;
		Map<String, AptIpDO> map = EnFMapUtils.getMap(AptIpDO.ID_ENTIP, list.toArray(new AptIpDO[0]));
		if (EnValidator.isEmpty(map))
			return;
		for (UrgStayRegistryDTO urgStayRegistry : urgStayRegistrys) {
			setAttrVal(urgStayRegistry, map, "Id_ent", new MappingNode[] {
					new MappingNode(AptIpDO.ID_APTIP, "Id_aptip"),
					new MappingNode(AptIpDO.NAME_DEP_OP, "Name_dep_op"),
					new MappingNode(AptIpDO.DT_ADMIT_PLAN, "Dt_admit_plan"),
					new MappingNode(AptIpDO.AMT_DEPOSIT, "Amt_deposit")});
		}
	}
	/**
	 * 其他信息处理
	 * 
	 * @param urgStayRegistrys
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void otherHanler(UrgStayRegistryDTO[] urgStayRegistrys) throws BizException {
		String[] countryIds = EnAppUtils.getKeyPropArrayFromDO("Id_country", urgStayRegistrys);
		Map<String, CountryZoneDO> map = null;
		if(!EnValidator.isEmpty(countryIds)){
			List<CountryZoneDO> list = (List<CountryZoneDO>) new DAFacade().findByPKs(CountryZoneDO.class, countryIds, new String[]{CountryZoneDO.ID_COUNTRYZONE, CountryZoneDO.CODE, CountryZoneDO.NAME});
			if(!EnValidator.isEmpty(list))
				map = EnFMapUtils.getMap(CountryZoneDO.ID_COUNTRYZONE, list.toArray(new CountryZoneDO[0]));
		}
		for (UrgStayRegistryDTO urgStayRegistry : urgStayRegistrys) {
			setAttrVal(urgStayRegistry, map, "Id_country", new MappingNode[] {
					new MappingNode(CountryZoneDO.CODE, "Sd_country"),
					new MappingNode(CountryZoneDO.NAME, "Name_country")});
			urgStayRegistry.setAge(AgeCalcUtil.getAge(urgStayRegistry.getDt_birth()));
			SetNameStatus(urgStayRegistry);
		}
	}
	/**
	 * 患者分类处理
	 * 
	 * @param urgStayRegistrys
	 * @throws BizException
	 */
	public void patCaHandle(UrgStayRegistryDTO[] urgStayRegistrys) throws BizException {
		PiPatCaDO patca = new PatEP().getPatDefaultCate();
		if(patca != null){
			for (UrgStayRegistryDTO urgStayRegistry : urgStayRegistrys) {
				urgStayRegistry.setId_patca(patca.getId_patca());
				urgStayRegistry.setName_patca(patca.getName());
				urgStayRegistry.setId_pripat(patca.getId_patpritp());
				urgStayRegistry.setName_pripat(patca.getPatpritp_name());
				urgStayRegistry.setId_patcret(patca.getId_patcrettp());
				urgStayRegistry.setName_patcret(patca.getPatcrettp_name());
			}
		}
	}
	
	/**
	 * 住院次数
	 * 
	 * @param urgStayRegistrys
	 * @throws BizException
	 */
	public void setTimesIp(UrgStayRegistryDTO[] urgStayRegistrys,String patId) throws BizException {
		int times = EnVisitTimesUtils.calcAdmObsTimes(patId);
		for (UrgStayRegistryDTO urgStayRegistry : urgStayRegistrys) {
			urgStayRegistry.setTimes_ip(times);
		}
	}
	
	/**
	 * 设置就诊状态
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void SetNameStatus(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		if(EnValidator.isEmpty(urgStayRegistry.getSd_status()))
			return;
		switch(urgStayRegistry.getSd_status()){
		case IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN:
			urgStayRegistry.setName_status("登记");
			break;
		case IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN:
			urgStayRegistry.setName_status("入科");
			break;
		}
	}
	/**
	 * 向Set中添加数据
	 * 
	 * @param set
	 * @param value
	 */
	private void addSet(Set<String> set, UrgStayRegistryDTO urgStayRegistry, String[] attrVals) {
		for (String attrVal : attrVals) {
			Object obj = urgStayRegistry.getAttrVal(attrVal);
			if (obj != null)
				set.add((String) obj);
		}
	}

	/**
	 * 根据Map匹配赋值
	 * 
	 * @param <T>
	 * 
	 * @param urgStayRegistry
	 * @param map
	 * @param key
	 * @param codeAttrVal
	 * @param nameAttrVal
	 */
	private <T extends BaseDO> void setAttrVal(
			UrgStayRegistryDTO urgStayRegistry, Map<String, T> map,
			String keyAttrVal, MappingNode[] keyNodes) {
		String key = (String) urgStayRegistry.getAttrVal(keyAttrVal);
		if (EnValidator.isEmpty(key) || EnValidator.isEmpty(map))
			return;
		if (map.containsKey(key)) {
			BaseDO baseDo = map.get(key);
			for (MappingNode keyNode : keyNodes) {
				urgStayRegistry.setAttrVal(keyNode.getTargetKey(),
						baseDo.getAttrVal(keyNode.getSourceKey()));
			}
		}
	}
	/**
	 * DO映射关系
	 * 
	 * @author liubin
	 *
	 */
	private class MappingNode {
		private String sourceKey;
		private String targetKey;

		public MappingNode(String sourceKey, String targetKey) {
			this.setSourceKey(sourceKey);
			this.setTargetKey(targetKey);
		}

		public String getSourceKey() {
			return sourceKey;
		}

		public void setSourceKey(String sourceKey) {
			this.sourceKey = sourceKey;
		}

		public String getTargetKey() {
			return targetKey;
		}

		public void setTargetKey(String targetKey) {
			this.targetKey = targetKey;
		}
	}
}
