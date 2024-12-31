package iih.ei.std.s.v1.bp.bd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DoUtils;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.utils.UdidocUtils;
import iih.ei.std.d.v1.bd.sync.psndoc.d.PsnDocDTO;
import iih.ei.std.d.v1.bd.sync.psndoc.d.PsnDocListDTO;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.d.EmpPhyDO;
import xap.sys.bdfw.bbd.d.PsnCateDO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.bdfw.bbd.i.IPsncateRService;
import xap.sys.bdfw.bbd.i.IPsndocCudService;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.ehr.d.JobDO;
import xap.sys.orgfw.ehr.i.IJobRService;
import xap.sys.xbd.udi.d.UdidocDO;

public class SyncPsnDocBp extends IIHServiceBaseBP<PsnDocListDTO, NoParamDTO> {

	public SyncPsnDocBp() {
		this._deptMap = new HashMap<>();
		this._idTypeMap = new HashMap<>();
		this._psnDocAggDoMap = new HashMap<>();
		this._sexMap = new HashMap<>();
		this._nationMap = new HashMap<>();
		this._psntpMap = new HashMap<>();
		this._wkTpMap = new HashMap<>();
		this._titleMap = new HashMap<>();
		this._bloodTypeMap = new HashMap<>();
		this._dutyMap = new HashMap<>();
		this._countryMap = new HashMap<>();
		this._vativePlaceMap = new HashMap<>();
		this._rprCharacterMap = new HashMap<>();
		this._healthMap = new HashMap<>();
		this._maritalMap = new HashMap<>();
		this._polityMap = new HashMap<>();
		this._psnPostMap = new HashMap<>();
		this._inMarkMap = new HashMap<>();
	}

	@Override
	protected void checkParam(PsnDocListDTO psnDocListDto) throws BizException {
		if (psnDocListDto == null || psnDocListDto.getPsndoc() == null || psnDocListDto.getPsndoc().size() <= 0) {
			throw new BizException("人员档案不允许为空。");
		}

		HashMap<String, PsnDocDTO> psnDocDtoMap = new HashMap<>();
		FArrayList psnDocList = psnDocListDto.getPsndoc();
		for (int i = 0; i < psnDocList.size(); i++) {
			PsnDocDTO psnDocDto = (PsnDocDTO) psnDocList.get(i);
			if (psnDocDto == null) {
				String msg = String.format("第【%s】个人员档案为空。", i + 1);
				throw new BizException(msg);
			}

			if (StringUtils.isBlank(psnDocDto.getCode())) {
				String msg = String.format("第【%s】个人员档案的编码为空。", i + 1);
				throw new BizException(msg);
			}

			if (StringUtils.isBlank(psnDocDto.getName())) {
				String msg = String.format("人员档案的名称为空，编码【%s】。", psnDocDto.getCode());
				throw new BizException(msg);
			}

			if (StringUtils.isBlank(psnDocDto.getSd_idtp())) {
				String msg = String.format("人员档案的证件类型编码为空，编码【%s】。", psnDocDto.getCode());
				throw new BizException(msg);
			}

			if (StringUtils.isBlank(psnDocDto.getNum_id())) {
				String msg = String.format("人员档案的证件号码为空，编码【%s】。", psnDocDto.getCode());
				throw new BizException(msg);
			}

			if (StringUtils.isBlank(psnDocDto.getCode_dep())) {
				String msg = String.format("人员档案的行政所属部门编码为空，编码【%s】。", psnDocDto.getCode());
				throw new BizException(msg);
			}

			if (psnDocDtoMap.containsKey(psnDocDto.getCode())) {
				String msg = String.format("人员档案的编码重复，编码【%s】。", psnDocDto.getCode());
				throw new BizException(msg);
			}

			psnDocDtoMap.put(psnDocDto.getCode(), psnDocDto);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected NoParamDTO process(PsnDocListDTO psnDocListDto) throws BizException {

		FArrayList psnDocDtoList = psnDocListDto.getPsndoc();
		PsnDocDTO[] psnDocDtos = (PsnDocDTO[]) psnDocDtoList.toArray(new PsnDocDTO[0]);

		// 1.初始化数据字典
		initDataMap(psnDocDtos);

		// 2.处理数据
		List<PsndocAggDO> savePsnDocAggList = new ArrayList<>();
		for (PsnDocDTO psnDocDTO : psnDocDtos) {
			String psnCode = psnDocDTO.getCode();
			if (this._psnDocAggDoMap.containsKey(psnCode)) {
				// 更新
				PsndocAggDO psnDocAggDO = this._psnDocAggDoMap.get(psnCode);
				if (isChanged(psnDocAggDO, psnDocDTO)) {
					updatePsnDoc(psnDocAggDO, psnDocDTO);
					savePsnDocAggList.add(psnDocAggDO);
				}
			} else {
				// 新增
				PsndocAggDO psnDocAggDO = this.createNewPsnDoc(psnDocDTO);
				savePsnDocAggList.add(psnDocAggDO);
			}
		}

		if (savePsnDocAggList.size() > 0) {
			// 3.保存数据
			IPsndocCudService psndocCudService = ServiceFinder.find(IPsndocCudService.class);
			psndocCudService.save(savePsnDocAggList.toArray(new PsndocAggDO[0]));
		}

		return null;
	}

	/**
	 * 更新现有人员信息
	 * 
	 * @param psnDocAggDO
	 * @param psnDocDTO
	 * @throws BizException
	 */
	private void updatePsnDoc(PsndocAggDO psnDocAggDO, PsnDocDTO psnDocDTO) throws BizException {
		PsnDocDO psnDocDO = psnDocAggDO.getParentDO();
		this.updatePsnDoc(psnDocDO, psnDocDTO);

		EmpPhyDO[] empPhyDOs = psnDocAggDO.getEmpPhyDO();
		if (ArrayUtils.isEmpty(empPhyDOs)) {
			empPhyDOs = new EmpPhyDO[1];

			EmpPhyDO empPhyDO = new EmpPhyDO();
			empPhyDOs[0] = empPhyDO;
			psnDocAggDO.setEmpPhyDO(empPhyDOs);
		}
		EmpPhyDO empPhyDO = empPhyDOs[0];
		this.updateEmpPhy(empPhyDO, psnDocDTO);
	}

	private void updatePsnDoc(PsnDocDO psnDocDo, PsnDocDTO psnDocDTO) throws BizException {

		psnDocDo.setId_group(Context.get().getGroupId());
		psnDocDo.setId_org(Context.get().getOrgId());

		psnDocDo.setCode(psnDocDTO.getCode());
		psnDocDo.setName(psnDocDTO.getName());

		psnDocDo.setPycode(AppUtils.getPyCode(psnDocDo.getName()));
		psnDocDo.setWbcode(AppUtils.getWbCode(psnDocDo.getName()));

		// 性别
		String sexId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_sex())) {
			UdidocDO sexDo = this.getSexByCode(psnDocDTO.getSd_sex());
			sexId = sexDo.getId_udidoc();
		}
		psnDocDo.setSex(sexId);

		// 民族
		String nationId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_nation())) {
			UdidocDO nationDo = this.getNationByCode(psnDocDTO.getSd_nation());
			nationId = nationDo.getId_udidoc();
		}
		psnDocDo.setNationatily(nationId);

		// 出生日期
		psnDocDo.setBirthday(psnDocDTO.getBirthday());

		// 证件类型
		UdidocDO idTpDo = this.getIdTpByCode(psnDocDTO.getSd_idtp());
		psnDocDo.setIdtype(idTpDo.getId_udidoc());

		// 证件号码
		psnDocDo.setId(psnDocDTO.getNum_id());

		// 手机号
		psnDocDo.setMobile(psnDocDTO.getMobile());

		// 行政所属部门
		DeptDO deptDo = this.getDepByCode(psnDocDTO.getCode_dep());
		psnDocDo.setId_dep(deptDo.getId_dep());

		// 人员类别
		String psnTpId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getCode_psntp())) {
			PsnCateDO psnTpDo = this.getPsnTpByCode(psnDocDTO.getCode_psntp());
			psnTpId = psnTpDo.getId_psncate();
		}
		psnDocDo.setHumantype(psnTpId);

		// 人员工作类型
		String wkTpId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_empwktp())) {
			UdidocDO wkTpDo = this.getWkTpByCode(psnDocDTO.getSd_empwktp());
			wkTpId = wkTpDo.getId_udidoc();
		}
		psnDocDo.setId_empwktp(wkTpId);

		// 人员聘任职称
		String titleId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_emptitle())) {
			UdidocDO titleDo = this.getTitleByCode(psnDocDTO.getSd_emptitle());
			titleId = titleDo.getId_udidoc();
		}
		psnDocDo.setId_emptitle(titleId);

		// 姓名简称
		psnDocDo.setShrotname(psnDocDTO.getShrotname());

		// 曾用名
		psnDocDo.setUsedname(psnDocDTO.getUsedname());

		// 血型
		String bloodtypeId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_bloodtype())) {
			UdidocDO bloodtypeDo = this.getBloodTypeByCode(psnDocDTO.getSd_bloodtype());
			bloodtypeId = bloodtypeDo.getId_udidoc();
		}
		psnDocDo.setBloodtype(bloodtypeId);

		// 办公电话
		psnDocDo.setOfficephone(psnDocDTO.getTel_office());

		// 家庭电话
		psnDocDo.setHomephone(psnDocDTO.getTel_home());

		// 电子邮箱
		psnDocDo.setEmail(psnDocDTO.getEmail());

		// 私人邮箱
		psnDocDo.setSecret_email(psnDocDTO.getEmail_secret());

		// 传真
		psnDocDo.setFax(psnDocDTO.getFax());

		// 归属部门职务
		String dutyId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getCode_empduty())) {
			JobDO dutyDo = this.getDutyByCode(psnDocDTO.getCode_empduty());
			dutyId = dutyDo.getId_job();
		}
		psnDocDo.setId_empduty(dutyId);

		// 国家/地区
		String countryId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getCode_country())) {
			CountryZoneDO countryDo = this.getCountryByCode(psnDocDTO.getCode_country());
			countryId = countryDo.getId_countryzone();
		}
		psnDocDo.setCountry(countryId);

		// 籍贯
		String vativePlaceId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getCode_vativeplace())) {
			AdminAreaDO vativePlaceDo = this.getVativePlaceByCode(psnDocDTO.getCode_vativeplace());
			vativePlaceId = vativePlaceDo.getId_adminarea();
		}
		psnDocDo.setVativeplace(vativePlaceId);

		// 户籍地址
		psnDocDo.setCensusaddr(psnDocDTO.getAddr_census());

		// 户口性质
		String rprCharacterId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_characterrpr())) {
			UdidocDO rprCharacterDo = this.getRprCharacterByCode(psnDocDTO.getSd_characterrpr());
			rprCharacterId = rprCharacterDo.getId_udidoc();
		}
		psnDocDo.setCharacterrpr(rprCharacterId);

		// 户口所在地
		psnDocDo.setPermanreside(psnDocDTO.getAddr_residence());

		// 档案所在地
		psnDocDo.setFileaddress(psnDocDTO.getAddr_file());

		// 健康状况
		String healthId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_health())) {
			UdidocDO healthDo = this.getHealthByCode(psnDocDTO.getSd_health());
			healthId = healthDo.getId_udidoc();
		}
		psnDocDo.setHealth(healthId);

		// 婚姻状况
		String maritalId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_marital())) {
			UdidocDO maritalDo = this.getMaritalByCode(psnDocDTO.getSd_marital());
			maritalId = maritalDo.getId_udidoc();
		}
		psnDocDo.setMarital(maritalId);

		// 结/离婚日期
		psnDocDo.setMarriagedate(psnDocDTO.getDt_marital());

		// 邮政编码
		psnDocDo.setPostalcode(psnDocDTO.getCode_post());

		// 助记码
		psnDocDo.setMnecode(psnDocDTO.getMnecode());

		// 家庭地址
		psnDocDo.setAddr(psnDocDTO.getAddr_home());

		// 政治面貌
		String polityId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_polity())) {
			UdidocDO polityDo = this.getPolityByCode(psnDocDTO.getSd_polity());
			polityId = polityDo.getId_udidoc();
		}
		psnDocDo.setPolity(polityId);

		// 入党(团)日期
		psnDocDo.setJoinpolitydate(psnDocDTO.getDt_joinpolity());

		// 个人身份
		psnDocDo.setPenelauth(psnDocDTO.getPenelauth());

		// 人员职务
		String psnPostId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getCode_psnpost())) {
			UdidocDO psnPostDo = this.getPsnPostByCode(psnDocDTO.getCode_psnpost());
			psnPostId = psnPostDo.getId_udidoc();
		}
		psnDocDo.setId_psnpost(psnPostId);

		// 在岗状态
		String inMarkId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_inmark())) {
			UdidocDO inMarkDo = this.getInMarkByCode(psnDocDTO.getSd_inmark());
			inMarkId = inMarkDo.getId_udidoc();
		}
		psnDocDo.setSd_psn_inmark(inMarkId);

		// 虚拟人员
		psnDocDo.setIsvirtual(psnDocDTO.getFg_virtual());

		// 人员描述
		psnDocDo.setDes(psnDocDTO.getDes());

		// 启用标志
		Integer activeState = this.getActiveStateEnum(psnDocDTO.getFg_active());
		psnDocDo.setActivestate(activeState);

		if (DOStatus.UNCHANGED == psnDocDo.getStatus()) {
			psnDocDo.setStatus(DOStatus.UPDATED);
		}
	}

	private void updateEmpPhy(EmpPhyDO empPhyDo, PsnDocDTO psnDocDTO) {

		// 处方权标志
		empPhyDo.setFg_presrt(psnDocDTO.getFg_presrt());

		// 医师执业证书编码
		empPhyDo.setDrid(psnDocDTO.getDrid());

		// 医生简介
		empPhyDo.setNote_phy(psnDocDTO.getNote_phy());

		if (DOStatus.UNCHANGED == empPhyDo.getStatus()) {
			empPhyDo.setStatus(DOStatus.UPDATED);
		}
	}

	/**
	 * 创建新人员
	 * 
	 * @param psnDocDTO
	 * @return
	 * @throws BizException
	 */
	private PsndocAggDO createNewPsnDoc(PsnDocDTO psnDocDTO) throws BizException {
		PsndocAggDO newPsnAggDo = new PsndocAggDO();

		PsnDocDO psnDocDo = new PsnDocDO();
		psnDocDo.setStatus(DOStatus.NEW);
		newPsnAggDo.setParentDO(psnDocDo);

		this.updatePsnDoc(psnDocDo, psnDocDTO);

		EmpPhyDO empPhyDo = new EmpPhyDO();
		empPhyDo.setStatus(DOStatus.NEW);
		newPsnAggDo.setEmpPhyDO(new EmpPhyDO[] { empPhyDo });

		this.updateEmpPhy(empPhyDo, psnDocDTO);

		return newPsnAggDo;
	}

	/**
	 * 判定数据是否变更
	 * 
	 * @param psnDocAggDO
	 * @param psnDocDTO
	 * @return
	 * @throws BizException
	 */
	private boolean isChanged(PsndocAggDO psnDocAggDO, PsnDocDTO psnDocDTO) throws BizException {
		PsnDocDO psnDocDO = psnDocAggDO.getParentDO();

		// 姓名
		if (isNotEquals(psnDocDO.getName(), psnDocDTO.getName())) {
			return true;
		}

		// 性别
		String sexId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_sex())) {
			UdidocDO sexDo = this.getSexByCode(psnDocDTO.getSd_sex());
			sexId = sexDo.getId_udidoc();
		}
		if (isNotEquals(psnDocDO.getSex(), sexId)) {
			return true;
		}

		// 民族
		String nationId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_nation())) {
			UdidocDO nationDo = this.getNationByCode(psnDocDTO.getSd_nation());
			nationId = nationDo.getId_udidoc();
		}
		if (isNotEquals(psnDocDO.getNationatily(), nationId)) {
			return true;
		}

		// 出生日期
		if (isNotEquals(psnDocDO.getBirthday(), psnDocDTO.getBirthday())) {
			return true;
		}

		// 证件类型
		UdidocDO idTpDo = this.getIdTpByCode(psnDocDTO.getSd_idtp());
		if (isNotEquals(psnDocDO.getIdtype(), idTpDo.getId_udidoc())) {
			return true;
		}

		// 证件号码
		if (isNotEquals(psnDocDO.getId(), psnDocDTO.getNum_id())) {
			return true;
		}

		// 手机号
		if (isNotEquals(psnDocDO.getMobile(), psnDocDTO.getMobile())) {
			return true;
		}

		// 行政所属部门
		DeptDO deptDo = this.getDepByCode(psnDocDTO.getCode_dep());
		if (isNotEquals(psnDocDO.getId_dep(), deptDo.getId_dep())) {
			return true;
		}

		// 人员类别
		String psnTpId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getCode_psntp())) {
			PsnCateDO psnTpDo = this.getPsnTpByCode(psnDocDTO.getCode_psntp());
			psnTpId = psnTpDo.getId_psncate();
		}
		if (isNotEquals(psnDocDO.getHumantype(), psnTpId)) {
			return true;
		}

		// 人员工作类型
		String wkTpId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_empwktp())) {
			UdidocDO wkTpDo = this.getWkTpByCode(psnDocDTO.getSd_empwktp());
			wkTpId = wkTpDo.getId_udidoc();
		}
		if (isNotEquals(psnDocDO.getId_empwktp(), wkTpId)) {
			return true;
		}
		// 人员聘任职称
		String titleId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_emptitle())) {
			UdidocDO titleDo = this.getTitleByCode(psnDocDTO.getSd_emptitle());
			titleId = titleDo.getId_udidoc();
		}
		if (isNotEquals(psnDocDO.getId_emptitle(), titleId)) {
			return true;
		}

		EmpPhyDO[] empPhyDOs = psnDocAggDO.getEmpPhyDO();
		EmpPhyDO empPhyDO = ArrayUtils.isEmpty(empPhyDOs) ? null : empPhyDOs[0];

		// 处方权标志
		if (empPhyDO == null || isNotEquals(empPhyDO.getFg_presrt(), psnDocDTO.getFg_presrt())) {
			return true;
		}

		// 医师执业证书编码
		if (empPhyDO == null || isNotEquals(empPhyDO.getDrid(), psnDocDTO.getDrid())) {
			return true;
		}

		// 医生简介
		if (empPhyDO == null || isNotEquals(empPhyDO.getNote_phy(), psnDocDTO.getNote_phy())) {
			return true;
		}

		// 姓名简称
		if (isNotEquals(psnDocDO.getShrotname(), psnDocDTO.getShrotname())) {
			return true;
		}

		// 曾用名
		if (isNotEquals(psnDocDO.getUsedname(), psnDocDTO.getUsedname())) {
			return true;
		}

		// 血型
		String bloodtypeId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_bloodtype())) {
			UdidocDO bloodtypeDo = this.getBloodTypeByCode(psnDocDTO.getSd_bloodtype());
			bloodtypeId = bloodtypeDo.getId_udidoc();
		}
		if (isNotEquals(psnDocDO.getBloodtype(), bloodtypeId)) {
			return true;
		}

		// 办公电话
		if (isNotEquals(psnDocDO.getOfficephone(), psnDocDTO.getTel_office())) {
			return true;
		}

		// 家庭电话
		if (isNotEquals(psnDocDO.getHomephone(), psnDocDTO.getTel_home())) {
			return true;
		}

		// 电子邮箱
		if (isNotEquals(psnDocDO.getEmail(), psnDocDTO.getEmail())) {
			return true;
		}

		// 私人邮箱
		if (isNotEquals(psnDocDO.getSecret_email(), psnDocDTO.getEmail_secret())) {
			return true;
		}

		// 传真
		if (isNotEquals(psnDocDO.getFax(), psnDocDTO.getFax())) {
			return true;
		}

		// 归属部门职务
		String dutyId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getCode_empduty())) {
			JobDO dutyDo = this.getDutyByCode(psnDocDTO.getCode_empduty());
			dutyId = dutyDo.getId_job();
		}
		if (isNotEquals(psnDocDO.getId_empduty(), dutyId)) {
			return true;
		}

		// 国家/地区
		String countryId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getCode_country())) {
			CountryZoneDO countryDo = this.getCountryByCode(psnDocDTO.getCode_country());
			countryId = countryDo.getId_countryzone();
		}
		if (isNotEquals(psnDocDO.getCountry(), countryId)) {
			return true;
		}

		// 籍贯
		String vativePlaceId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getCode_vativeplace())) {
			AdminAreaDO vativePlaceDo = this.getVativePlaceByCode(psnDocDTO.getCode_vativeplace());
			vativePlaceId = vativePlaceDo.getId_countryzone();
		}
		if (isNotEquals(psnDocDO.getVativeplace(), vativePlaceId)) {
			return true;
		}

		// 户籍地址
		if (isNotEquals(psnDocDO.getCensusaddr(), psnDocDTO.getAddr_census())) {
			return true;
		}

		// 户口性质
		String rprCharacterId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_characterrpr())) {
			UdidocDO rprCharacterDo = this.getRprCharacterByCode(psnDocDTO.getSd_characterrpr());
			rprCharacterId = rprCharacterDo.getId_udidoc();
		}
		if (isNotEquals(psnDocDO.getCharacterrpr(), rprCharacterId)) {
			return true;
		}

		// 户口所在地
		if (isNotEquals(psnDocDO.getPermanreside(), psnDocDTO.getAddr_residence())) {
			return true;
		}

		// 档案所在地
		if (isNotEquals(psnDocDO.getFileaddress(), psnDocDTO.getAddr_file())) {
			return true;
		}

		// 健康状况
		String healthId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_health())) {
			UdidocDO healthDo = this.getHealthByCode(psnDocDTO.getSd_health());
			healthId = healthDo.getId_udidoc();
		}
		if (isNotEquals(psnDocDO.getHealth(), healthId)) {
			return true;
		}

		// 婚姻状况
		String maritalId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_marital())) {
			UdidocDO maritalDo = this.getMaritalByCode(psnDocDTO.getSd_marital());
			maritalId = maritalDo.getId_udidoc();
		}
		if (isNotEquals(psnDocDO.getMarital(), maritalId)) {
			return true;
		}

		// 结/离婚日期
		if (isNotEquals(psnDocDO.getMarriagedate(), psnDocDTO.getDt_marital())) {
			return true;
		}

		// 邮政编码
		if (isNotEquals(psnDocDO.getPostalcode(), psnDocDTO.getCode_post())) {
			return true;
		}

		// 助记码
		if (isNotEquals(psnDocDO.getMnecode(), psnDocDTO.getMnecode())) {
			return true;
		}

		// 家庭地址
		if (isNotEquals(psnDocDO.getAddr(), psnDocDTO.getAddr_home())) {
			return true;
		}

		// 政治面貌
		String polityId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_polity())) {
			UdidocDO polityDo = this.getPolityByCode(psnDocDTO.getSd_polity());
			polityId = polityDo.getId_udidoc();
		}
		if (isNotEquals(psnDocDO.getPolity(), polityId)) {
			return true;
		}

		// 入党(团)日期
		if (isNotEquals(psnDocDO.getJoinpolitydate(), psnDocDTO.getDt_joinpolity())) {
			return true;
		}

		// 个人身份
		if (isNotEquals(psnDocDO.getPenelauth(), psnDocDTO.getPenelauth())) {
			return true;
		}

		// 人员职务
		String psnPostId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getCode_psnpost())) {
			UdidocDO psnPostDo = this.getPsnPostByCode(psnDocDTO.getCode_psnpost());
			psnPostId = psnPostDo.getId_udidoc();
		}
		if (isNotEquals(psnDocDO.getId_psnpost(), psnPostId)) {
			return true;
		}

		// 在岗状态
		String inMarkId = null;
		if (StringUtils.isNotBlank(psnDocDTO.getSd_inmark())) {
			UdidocDO inMarkDo = this.getInMarkByCode(psnDocDTO.getSd_inmark());
			inMarkId = inMarkDo.getId_udidoc();
		}
		if (isNotEquals(psnDocDO.getSd_psn_inmark(), inMarkId)) {
			return true;
		}

		// 虚拟人员
		if (isNotEquals(psnDocDO.getIsvirtual(), psnDocDTO.getFg_virtual())) {
			return true;
		}

		// 人员描述
		if (isNotEquals(psnDocDO.getDes(), psnDocDTO.getDes())) {
			return true;
		}

		// 启用标志
		Integer activeState = this.getActiveStateEnum(psnDocDTO.getFg_active());
		if (isNotEquals(psnDocDO.getActivestate(), activeState)) {
			return true;
		}

		return false;
	}

	/**
	 * 根据启用标志返回启用状态枚举值
	 * 
	 * @param activeFlag
	 * @return
	 */
	private Integer getActiveStateEnum(FBoolean activeFlag) {
		Integer activeState = FBoolean.TRUE.equals(activeFlag) ? ActiveStateEnum.ACTIVE : ActiveStateEnum.STOP;
		return activeState;
	}

	/**
	 * 判定两个对象不相同
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	private boolean isNotEquals(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null) {
			return false;
		}

		if (obj1 == null) {
			return isNotEquals(obj2, obj1);
		}

		return !obj1.equals(obj2);
	}

	private void initDataMap(PsnDocDTO[] psnDocDtos) throws BizException {

		initPsnDocAggMap(psnDocDtos);

		initIdTpMap(psnDocDtos);

		initDepMap(psnDocDtos);

		initSexMap(psnDocDtos);

		initNationMap(psnDocDtos);

		initPsnTpMap(psnDocDtos);

		initWkTpMap(psnDocDtos);

		initTitleMap(psnDocDtos);

		initBloodTypeMap(psnDocDtos);

		initDutyMap(psnDocDtos);

		initCountryMap(psnDocDtos);

		initVativePlaceMap(psnDocDtos);

		initRprCharacterMap(psnDocDtos);

		initHealthMap(psnDocDtos);

		initMaritalMap(psnDocDtos);

		initPolityMap(psnDocDtos);

		initPsnPostMap(psnDocDtos);

		initInMarkMap(psnDocDtos);

	}

	/**
	 * 初始化科室字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initDepMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] depCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Code_dep", String.class);
		if (ArrayUtils.isEmpty(depCodes)) {
			return;
		}
		IDeptRService deptRService = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptDos = deptRService.findByAttrValStrings(DeptDO.CODE, depCodes);
		if (ArrayUtils.isNotEmpty(deptDos)) {
			this.addToDeptMap(deptDos);
		}
	}

	/**
	 * 添加科室集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToDeptMap(DeptDO[] deptDos) {
		if (ArrayUtils.isEmpty(deptDos)) {
			return;
		}

		for (DeptDO deptDO : deptDos) {
			this._deptMap.put(deptDO.getCode(), deptDO);
		}
	}

	/**
	 * 根据科室编码获取科室
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private DeptDO getDepByCode(String code) throws BizException {
		if (this._deptMap.containsKey(code)) {
			return this._deptMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取科室失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化证件类型字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initIdTpMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] idTpCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Sd_idtp", String.class);
		if (ArrayUtils.isEmpty(idTpCodes)) {
			return;
		}
		UdidocDO[] idTpDos = UdidocUtils.getUdidocByCodes(IPiDictCodeTypeConst.SD_IDTP, idTpCodes);
		if (ArrayUtils.isNotEmpty(idTpDos)) {
			this.addToIdTpMap(idTpDos);
		}
	}

	/**
	 * 添加证件类型集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToIdTpMap(UdidocDO[] idTpDos) {
		if (ArrayUtils.isEmpty(idTpDos)) {
			return;
		}

		for (UdidocDO idTpDo : idTpDos) {
			this._idTypeMap.put(idTpDo.getCode(), idTpDo);
		}
	}

	/**
	 * 根据证件类型编码获取证件类型
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getIdTpByCode(String code) throws BizException {
		if (this._idTypeMap.containsKey(code)) {
			return this._idTypeMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取证件类型失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化人员档案字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initPsnDocAggMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] codes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Code", String.class);
		if (ArrayUtils.isEmpty(codes)) {
			return;
		}
		IPsndocRService psndocRService = ServiceFinder.find(IPsndocRService.class);
		PsndocAggDO[] psnDocAggDos = psndocRService.findByAttrValStrings(PsnDocDO.CODE, codes);
		if (ArrayUtils.isNotEmpty(psnDocAggDos)) {
			this.addToPsnDocAggDoMap(psnDocAggDos);
		}
	}

	/**
	 * 添加人员DO集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToPsnDocAggDoMap(PsndocAggDO[] psnDocAggDos) {
		if (ArrayUtils.isEmpty(psnDocAggDos)) {
			return;
		}

		for (PsndocAggDO psnDocAggDO : psnDocAggDos) {
			this._psnDocAggDoMap.put(psnDocAggDO.getParentDO().getCode(), psnDocAggDO);
		}
	}

	/**
	 * 初始化性别字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initSexMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] sexCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Sd_sex", String.class);
		if (ArrayUtils.isEmpty(sexCodes)) {
			return;
		}
		UdidocDO[] sexDos = UdidocUtils.getUdidocByCodes(IPiDictCodeTypeConst.SD_SEX_CODE, sexCodes);
		if (ArrayUtils.isNotEmpty(sexDos)) {
			this.addToSexMap(sexDos);
		}
	}

	/**
	 * 添加性别集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToSexMap(UdidocDO[] sexDos) {
		if (ArrayUtils.isEmpty(sexDos)) {
			return;
		}

		for (UdidocDO sexDo : sexDos) {
			this._sexMap.put(sexDo.getCode(), sexDo);
		}
	}

	/**
	 * 根据性别编码获取性别
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getSexByCode(String code) throws BizException {
		if (this._sexMap.containsKey(code)) {
			return this._sexMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取性别失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化民族字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initNationMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] nationCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Sd_nation", String.class);
		if (ArrayUtils.isEmpty(nationCodes)) {
			return;
		}
		UdidocDO[] nationDos = UdidocUtils.getUdidocByCodes(IPiDictCodeTypeConst.SD_NATION, nationCodes);
		if (ArrayUtils.isNotEmpty(nationDos)) {
			this.addToNationMap(nationDos);
		}
	}

	/**
	 * 添加民族集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToNationMap(UdidocDO[] nationDos) {
		if (ArrayUtils.isEmpty(nationDos)) {
			return;
		}

		for (UdidocDO nationDo : nationDos) {
			this._nationMap.put(nationDo.getCode(), nationDo);
		}
	}

	/**
	 * 根据民族编码获取民族
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getNationByCode(String code) throws BizException {
		if (this._nationMap.containsKey(code)) {
			return this._nationMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取民族失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化人员类别字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initPsnTpMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] psntpCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Code_psntp", String.class);
		if (ArrayUtils.isEmpty(psntpCodes)) {
			return;
		}
		IPsncateRService psncateRService = ServiceFinder.find(IPsncateRService.class);
		PsnCateDO[] psntpDos = psncateRService.findByAttrValStrings(PsnCateDO.CODE, psntpCodes);
		if (ArrayUtils.isNotEmpty(psntpDos)) {
			this.addToPsnTpMap(psntpDos);
		}
	}

	/**
	 * 添加人员类别集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToPsnTpMap(PsnCateDO[] psntpDos) {
		if (ArrayUtils.isEmpty(psntpDos)) {
			return;
		}

		for (PsnCateDO psntpDo : psntpDos) {
			this._psntpMap.put(psntpDo.getCode(), psntpDo);
		}
	}

	/**
	 * 根据人员类别编码获取人员类别
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private PsnCateDO getPsnTpByCode(String code) throws BizException {
		if (this._psntpMap.containsKey(code)) {
			return this._psntpMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取人员类别失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化工作类型字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initWkTpMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] wkTpCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Sd_empwktp", String.class);
		if (ArrayUtils.isEmpty(wkTpCodes)) {
			return;
		}
		UdidocDO[] wkTpDos = UdidocUtils.getUdidocByCodes("0000R", wkTpCodes);
		if (ArrayUtils.isNotEmpty(wkTpDos)) {
			this.addToWkTpMap(wkTpDos);
		}
	}

	/**
	 * 添加工作类型集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToWkTpMap(UdidocDO[] wkTpDos) {
		if (ArrayUtils.isEmpty(wkTpDos)) {
			return;
		}

		for (UdidocDO wkTpDo : wkTpDos) {
			this._wkTpMap.put(wkTpDo.getCode(), wkTpDo);
		}
	}

	/**
	 * 根据工作类型编码获取工作类型
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getWkTpByCode(String code) throws BizException {
		if (this._wkTpMap.containsKey(code)) {
			return this._wkTpMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取工作类型失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化聘任职称字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initTitleMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] titleCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Sd_emptitle", String.class);
		if (ArrayUtils.isEmpty(titleCodes)) {
			return;
		}
		UdidocDO[] titleDos = UdidocUtils.getUdidocByCodes("0000U", titleCodes);
		if (ArrayUtils.isNotEmpty(titleDos)) {
			this.addToTitleMap(titleDos);
		}
	}

	/**
	 * 添加聘任职称集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToTitleMap(UdidocDO[] titleDos) {
		if (ArrayUtils.isEmpty(titleDos)) {
			return;
		}

		for (UdidocDO titleDo : titleDos) {
			this._titleMap.put(titleDo.getCode(), titleDo);
		}
	}

	/**
	 * 根据聘任职称编码获取聘任职称
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getTitleByCode(String code) throws BizException {
		if (this._titleMap.containsKey(code)) {
			return this._titleMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取聘任职称失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化血型字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initBloodTypeMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] bloodTypeCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Sd_bloodtype", String.class);
		if (ArrayUtils.isEmpty(bloodTypeCodes)) {
			return;
		}
		UdidocDO[] bloodTypeDos = UdidocUtils.getUdidocByCodes("PI.PI.1585", bloodTypeCodes);
		if (ArrayUtils.isNotEmpty(bloodTypeDos)) {
			this.addToBloodTypeMap(bloodTypeDos);
		}
	}

	/**
	 * 添加血型集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToBloodTypeMap(UdidocDO[] bloodTypeDos) {
		if (ArrayUtils.isEmpty(bloodTypeDos)) {
			return;
		}

		for (UdidocDO bloodTypeDo : bloodTypeDos) {
			this._bloodTypeMap.put(bloodTypeDo.getCode(), bloodTypeDo);
		}
	}

	/**
	 * 根据血型编码获取血型
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getBloodTypeByCode(String code) throws BizException {
		if (this._bloodTypeMap.containsKey(code)) {
			return this._bloodTypeMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取血型失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化职务字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initDutyMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] dutyCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Code_empduty", String.class);
		if (ArrayUtils.isEmpty(dutyCodes)) {
			return;
		}
		IJobRService jobRService = ServiceFinder.find(IJobRService.class);
		JobDO[] dutyDos = jobRService.findByAttrValStrings(JobDO.CODE, dutyCodes);
		if (ArrayUtils.isNotEmpty(dutyDos)) {
			this.addToDutyMap(dutyDos);
		}
	}

	/**
	 * 添加职务集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToDutyMap(JobDO[] dutyDos) {
		if (ArrayUtils.isEmpty(dutyDos)) {
			return;
		}

		for (JobDO dutyDo : dutyDos) {
			this._dutyMap.put(dutyDo.getCode(), dutyDo);
		}
	}

	/**
	 * 根据职务编码获取职务
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private JobDO getDutyByCode(String code) throws BizException {
		if (this._dutyMap.containsKey(code)) {
			return this._dutyMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取职务失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化国家/地区字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initCountryMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] countryCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Code_country", String.class);
		if (ArrayUtils.isEmpty(countryCodes)) {
			return;
		}
		ICountryzoneRService countryzoneRService = ServiceFinder.find(ICountryzoneRService.class);
		CountryZoneDO[] countryDos = countryzoneRService.findByAttrValStrings(CountryZoneDO.CODE, countryCodes);
		if (ArrayUtils.isNotEmpty(countryDos)) {
			this.addToCountryMap(countryDos);
		}
	}

	/**
	 * 添加国家/地区集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToCountryMap(CountryZoneDO[] countryDos) {
		if (ArrayUtils.isEmpty(countryDos)) {
			return;
		}

		for (CountryZoneDO countryDo : countryDos) {
			this._countryMap.put(countryDo.getCode(), countryDo);
		}
	}

	/**
	 * 根据国家/地区编码获取国家/地区
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private CountryZoneDO getCountryByCode(String code) throws BizException {
		if (this._countryMap.containsKey(code)) {
			return this._countryMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取国家/地区失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化籍贯字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initVativePlaceMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] vativePlaceCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Code_vativeplace", String.class);
		if (ArrayUtils.isEmpty(vativePlaceCodes)) {
			return;
		}
		IAdminareaRService adminareaRService = ServiceFinder.find(IAdminareaRService.class);
		AdminAreaDO[] vativePlaceDos = adminareaRService.findByAttrValStrings(AdminAreaDO.CODE, vativePlaceCodes);
		if (ArrayUtils.isNotEmpty(vativePlaceDos)) {
			this.addToVativePlaceMap(vativePlaceDos);
		}
	}

	/**
	 * 添加籍贯集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToVativePlaceMap(AdminAreaDO[] vativePlaceDos) {
		if (ArrayUtils.isEmpty(vativePlaceDos)) {
			return;
		}

		for (AdminAreaDO vativePlaceDo : vativePlaceDos) {
			this._vativePlaceMap.put(vativePlaceDo.getCode(), vativePlaceDo);
		}
	}

	/**
	 * 根据籍贯编码获取籍贯
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private AdminAreaDO getVativePlaceByCode(String code) throws BizException {
		if (this._vativePlaceMap.containsKey(code)) {
			return this._vativePlaceMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取籍贯失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化户口性质字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initRprCharacterMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] rprCharacterCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Sd_characterrpr", String.class);
		if (ArrayUtils.isEmpty(rprCharacterCodes)) {
			return;
		}
		UdidocDO[] rprCharacterDos = UdidocUtils.getUdidocByCodes("0000V", rprCharacterCodes);
		if (ArrayUtils.isNotEmpty(rprCharacterDos)) {
			this.addToRprCharacterMap(rprCharacterDos);
		}
	}

	/**
	 * 添加户口性质集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToRprCharacterMap(UdidocDO[] rprCharacterDos) {
		if (ArrayUtils.isEmpty(rprCharacterDos)) {
			return;
		}

		for (UdidocDO rprCharacterDo : rprCharacterDos) {
			this._rprCharacterMap.put(rprCharacterDo.getCode(), rprCharacterDo);
		}
	}

	/**
	 * 根据户口性质编码获取户口性质
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getRprCharacterByCode(String code) throws BizException {
		if (this._rprCharacterMap.containsKey(code)) {
			return this._rprCharacterMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取户口性质失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化健康状况字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initHealthMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] healthCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Sd_health", String.class);
		if (ArrayUtils.isEmpty(healthCodes)) {
			return;
		}
		UdidocDO[] healthDos = UdidocUtils.getUdidocByCodes("0000K", healthCodes);
		if (ArrayUtils.isNotEmpty(healthDos)) {
			this.addToHealthMap(healthDos);
		}
	}

	/**
	 * 添加健康状况集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToHealthMap(UdidocDO[] healthDos) {
		if (ArrayUtils.isEmpty(healthDos)) {
			return;
		}

		for (UdidocDO healthDo : healthDos) {
			this._healthMap.put(healthDo.getCode(), healthDo);
		}
	}

	/**
	 * 根据健康状况编码获取健康状况
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getHealthByCode(String code) throws BizException {
		if (this._healthMap.containsKey(code)) {
			return this._healthMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取健康状况失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化婚姻状况字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initMaritalMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] maritalCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Sd_marital", String.class);
		if (ArrayUtils.isEmpty(maritalCodes)) {
			return;
		}
		UdidocDO[] maritalDos = UdidocUtils.getUdidocByCodes("0000L", maritalCodes);
		if (ArrayUtils.isNotEmpty(maritalDos)) {
			this.addToMaritalMap(maritalDos);
		}
	}

	/**
	 * 添加婚姻状况集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToMaritalMap(UdidocDO[] maritalDos) {
		if (ArrayUtils.isEmpty(maritalDos)) {
			return;
		}

		for (UdidocDO maritalDo : maritalDos) {
			this._maritalMap.put(maritalDo.getCode(), maritalDo);
		}
	}

	/**
	 * 根据婚姻状况编码获取婚姻状况
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getMaritalByCode(String code) throws BizException {
		if (this._maritalMap.containsKey(code)) {
			return this._maritalMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取婚姻状况失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化政治面貌字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initPolityMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] polityCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Sd_polity", String.class);
		if (ArrayUtils.isEmpty(polityCodes)) {
			return;
		}
		UdidocDO[] polityDos = UdidocUtils.getUdidocByCodes("0000J", polityCodes);
		if (ArrayUtils.isNotEmpty(polityDos)) {
			this.addToPolityMap(polityDos);
		}
	}

	/**
	 * 添加政治面貌集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToPolityMap(UdidocDO[] polityDos) {
		if (ArrayUtils.isEmpty(polityDos)) {
			return;
		}

		for (UdidocDO polityDo : polityDos) {
			this._polityMap.put(polityDo.getCode(), polityDo);
		}
	}

	/**
	 * 根据政治面貌编码获取政治面貌
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getPolityByCode(String code) throws BizException {
		if (this._polityMap.containsKey(code)) {
			return this._polityMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取政治面貌失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化人员职务字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initPsnPostMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] psnPosCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Code_psnpost", String.class);
		if (ArrayUtils.isEmpty(psnPosCodes)) {
			return;
		}
		UdidocDO[] psnPostDos = UdidocUtils.getUdidocByTpCode("XAP.1001");
		if (ArrayUtils.isNotEmpty(psnPostDos)) {
			this.addToPsnPostMap(psnPostDos);
		}
	}

	/**
	 * 添加人员职务集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToPsnPostMap(UdidocDO[] psnPostDos) {
		if (ArrayUtils.isEmpty(psnPostDos)) {
			return;
		}

		for (UdidocDO psnPostDo : psnPostDos) {
			this._psnPostMap.put(psnPostDo.getCode(), psnPostDo);
		}
	}

	/**
	 * 根据人员职务编码获取人员职务
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getPsnPostByCode(String code) throws BizException {
		if (this._psnPostMap.containsKey(code)) {
			return this._psnPostMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取人员职务失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 初始化在岗状态字典
	 * 
	 * @param psnDocDtos
	 * @throws BizException
	 */
	private void initInMarkMap(PsnDocDTO[] psnDocDtos) throws BizException {
		String[] inMarkCodes = DoUtils.getAttrValArrNotNull(psnDocDtos, "Sd_inmark", String.class);
		if (ArrayUtils.isEmpty(inMarkCodes)) {
			return;
		}
		UdidocDO[] inMarkDos = UdidocUtils.getUdidocByCodes("XAP.1000", inMarkCodes);
		if (ArrayUtils.isNotEmpty(inMarkDos)) {
			this.addToInMarkMap(inMarkDos);
		}
	}

	/**
	 * 添加在岗状态集合到Map中
	 * 
	 * @param psnDocDos
	 */
	private void addToInMarkMap(UdidocDO[] inMarkDos) {
		if (ArrayUtils.isEmpty(inMarkDos)) {
			return;
		}

		for (UdidocDO inMarkDo : inMarkDos) {
			this._inMarkMap.put(inMarkDo.getCode(), inMarkDo);
		}
	}

	/**
	 * 根据在岗状态编码获取在岗状态
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getInMarkByCode(String code) throws BizException {
		if (this._inMarkMap.containsKey(code)) {
			return this._inMarkMap.get(code);
		}
		String msg = String.format("根据编码【%s】获取在岗状态失败。", code);
		throw new BizException(msg);
	}

	/**
	 * 科室字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, DeptDO> _deptMap;
	/**
	 * 证件类型字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _idTypeMap;
	/**
	 * 人员字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, PsndocAggDO> _psnDocAggDoMap;
	/**
	 * 性别字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _sexMap;
	/**
	 * 名族字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _nationMap;
	/**
	 * 人员类别字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, PsnCateDO> _psntpMap;
	/**
	 * 工作类型字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _wkTpMap;
	/**
	 * 聘任职称字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _titleMap;
	/**
	 * 血型字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _bloodTypeMap;
	/**
	 * 职务字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, JobDO> _dutyMap;
	/**
	 * 国家/地区字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, CountryZoneDO> _countryMap;
	/**
	 * 籍贯字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, AdminAreaDO> _vativePlaceMap;
	/**
	 * 户口性质字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _rprCharacterMap;
	/**
	 * 健康状况字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _healthMap;
	/**
	 * 婚姻状况字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _maritalMap;
	/**
	 * 政治面貌字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _polityMap;
	/**
	 * 人员职务字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _psnPostMap;
	/**
	 * 在岗状态字典<br/>
	 * 禁止直接使用，使用具体方法使用字典
	 */
	HashMap<String, UdidocDO> _inMarkMap;
}
