package iih.pi.reg.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.patvspsn.d.PiPatVsPsnDO;
import iih.pi.reg.patvspsn.i.IPatvspsnCudService;
import iih.pi.reg.patvspsn.i.IPatvspsnRService;
import iih.pi.reg.s.bp.util.PiGetDefaultDataUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 
 * 从人员信息同步患者信息逻辑类
 * 
 * @author houll 2019/04/23
 *
 */
public class PiSyncFromPsnBP {

	/**
	 * 插入患者(insert)
	 * 
	 * @param psnDocDos
	 * @throws BizException
	 */
	public void insert(PsnDocDO[] psnDocDos) throws BizException {

		if (ArrayUtil.isEmpty(psnDocDos))
			return;
		HashMap<String, String> patPsnMap = new HashMap<String, String>();
		PatiAggDO[] aggDo = this.setPatInfo(psnDocDos, patPsnMap);
		IPatiCudService patCService = ServiceFinder.find(IPatiCudService.class);
		patCService.insert(aggDo);
		// 新增患者人员关系
		this.addPiPatpsndocs(patPsnMap);

	}

	/**
	 * 更新患者(update)
	 * 
	 * @param psnDocDos
	 * @throws BizException
	 */
	public void update(PsnDocDO[] psnDocDos) throws BizException {
		if (ArrayUtil.isEmpty(psnDocDos))
			return;
		HashMap<String, String> patPsnMap = new HashMap<String, String>();
		PatiAggDO[] patiAggDos = this.getIdPat(psnDocDos);

		if (ArrayUtil.isEmpty(patiAggDos)) {
			this.setPatInfo(psnDocDos, patPsnMap);
		} else {
			PatiAggDO[] aggDo = this.UpPatInfo(psnDocDos, patiAggDos);
			IPatiCudService patCService = ServiceFinder.find(IPatiCudService.class);
			patCService.update(aggDo);
		}
	}

	/**
	 * 新增患者信息
	 * 
	 * @param psnDocDos
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO[] setPatInfo(PsnDocDO[] psnDocDos, HashMap<String, String> patPsnMap) throws BizException {
		if (ArrayUtil.isEmpty(psnDocDos))
			return null;
		IUdidocRService udidocRService = ServiceFinder.find(IUdidocRService.class);
		PatiAggDO[] aggDo = new PatiAggDO[psnDocDos.length];
		for (int i = 0; i < aggDo.length; i++) {

			PatiAggDO PatiAggDO = new PatiAggDO();
			PatDO patDo = new PatDO();
			patDo.setId_org(Context.get().getOrgId());// 组织
			patDo.setId_grp(Context.get().getGroupId());// 集团
			// 患者主键
			String id_pat = new DBUtil().getOIDs(1)[0];
			patDo.setId_pat(id_pat);
			if (!patPsnMap.containsKey(id_pat)) {
				patPsnMap.put(id_pat, psnDocDos[i].getId_psndoc());
			}
			// 编码
			IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
			String code = billcodeManage.getBillCode_RequiresNew(PatDODesc.CLASS_FULLNAME, new PatDO());
			patDo.setCode(code);
			if (psnDocDos[i] == null) {
				throw new BizException("入参为空");
			}

			patDo.setName(psnDocDos[i].getName());// 姓名
			patDo.setId_idtp(psnDocDos[i].getIdtype());// 证件类型
			patDo.setId_code(psnDocDos[i].getId());// 证件号码
			if (!StringUtil.isEmpty(psnDocDos[i].getSex())) {
				UdidocDO udidocDo = udidocRService.findById(psnDocDos[i].getSex());// 性别
				patDo.setCode_sex(udidocDo.getCode());
				patDo.setName_sex(udidocDo.getName());
				patDo.setId_sex(udidocDo.getId_udidoc());
			}
			patDo.setDt_birth(psnDocDos[i].getBirthday());// 出生日期
			patDo.setMob(psnDocDos[i].getMobile());// 移动电话
			patDo.setTel(psnDocDos[i].getHomephone());// 固定电话
			patDo.setId_marry(psnDocDos[i].getMarital());// 婚姻史
			// 婚姻
			if (!StringUtil.isEmpty(psnDocDos[i].getMarital())) {
				UdidocDO udidocDO = udidocRService.findById(psnDocDos[i].getMarital());
				patDo.setMarry_code(udidocDO.getCode());
				patDo.setMarry_name(udidocDO.getName());
				patDo.setId_marry(udidocDO.getId_udidoc());
			}

			// 民族
			if (!StringUtil.isEmpty(psnDocDos[i].getNationatily())) {
				UdidocDO udidocdo = udidocRService.findById(psnDocDos[i].getNationatily());
				patDo.setNation_code(udidocdo.getCode());
				patDo.setNation_name(udidocdo.getName());
				patDo.setId_nation(udidocdo.getId_udidoc());
			}

			// 国家
			if (!StringUtil.isEmpty(psnDocDos[i].getCountry())) {
				ICountryzoneRService rService = ServiceFinder.find(ICountryzoneRService.class);
				CountryZoneDO countryZoneDO = rService.findById(psnDocDos[i].getCountry());
				patDo.setSd_country(countryZoneDO.getCode());
				patDo.setCountry_name(countryZoneDO.getName());
				patDo.setId_country(countryZoneDO.getId_countryzone());
			}

			patDo.setWbcode(psnDocDos[i].getWbcode());// 五笔
			patDo.setPycode(psnDocDos[i].getPycode());// 拼音
			patDo.setMnecode(psnDocDos[i].getMnecode());// 助记码
			patDo.setBarcode_chis(psnDocDos[i].getCode());
			// 是否实名认证
			patDo.setFg_realname(FBoolean.TRUE);

			// 默认价格分类 患者分类
			PiPatCaDO caDo = PiGetDefaultDataUtil.getDefPatCa();
			if (caDo != null) {
				patDo.setId_paticate(caDo.getId_patca());
				patDo.setId_patpritp(caDo.getId_patpritp());
				patDo.setId_patcrettp(caDo.getId_patcrettp());
			}
			// 建档来源
			patDo.setId_patsrctp(IPiDictCodeConst.ID_SRCREGIONTP_HOSPITAL);// 本院
			patDo.setSd_patsrctp(IPiDictCodeConst.SD_SRCREGIONTP_HOSPITAL);
			// 默认中国
			CountryZoneDO china = PiGetDefaultDataUtil.getChina();
			if (china != null) {
				patDo.setId_country(china.getId_countryzone());
				patDo.setSd_country(china.getCode());
			}
			// 失效标志
			patDo.setFg_invd(FBoolean.FALSE);
			patDo.setStatus(DOStatus.NEW);
			aggDo[i] = PatiAggDO;
			aggDo[i].setParentDO(patDo);
		}
		return aggDo;
	}

	/**
	 * 更新患者信息
	 * 
	 * @param psnDocDos
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO[] UpPatInfo(PsnDocDO[] psnDocDos, PatiAggDO[] patiAggDos) throws BizException {
		IUdidocRService udidocRService = ServiceFinder.find(IUdidocRService.class);
		for (int i = 0; i < patiAggDos.length; i++) {

			PatDO patDo = patiAggDos[i].getParentDO();
			patDo.setId_org(Context.get().getOrgId());// 组织
			patDo.setId_grp(Context.get().getGroupId());// 集团
			if (psnDocDos[i] == null) {
				throw new BizException("入参为空");
			}
			patDo.setName(psnDocDos[i].getName());// 姓名
			patDo.setId_idtp(psnDocDos[i].getIdtype());// 证件类型
			patDo.setId_code(psnDocDos[i].getId());// 证件号码

			patDo.setName_sex(psnDocDos[i].getSex_name());
			patDo.setDt_birth(psnDocDos[i].getBirthday());// 出生日期
			patDo.setMob(psnDocDos[i].getMobile());// 移动电话
			patDo.setTel(psnDocDos[i].getHomephone());// 家庭电话
			// 性别
			if (StringUtil.isEmpty(psnDocDos[i].getSex())) {
				patDo.setCode_sex(IPiDictCodeConst.SD_SEX_UNKNOW);
				patDo.setName_sex(IPiDictCodeConst.NAME_SEX_UNEXPLAIN);
				patDo.setId_sex(IPiDictCodeConst.ID_SEX_UNEXPLAIN);
			} else {
				UdidocDO udidocDo = udidocRService.findById(psnDocDos[i].getSex());
				patDo.setCode_sex(udidocDo.getCode());
				patDo.setName_sex(udidocDo.getName());
				patDo.setId_sex(udidocDo.getId_udidoc());
			}
			// 婚姻
			if (StringUtil.isEmpty(psnDocDos[i].getMarital())) {

				patDo.setMarry_code(null);
				patDo.setMarry_name(null);
				patDo.setId_marry(null);
			} else {
				UdidocDO udidocDO = udidocRService.findById(psnDocDos[i].getMarital());
				patDo.setMarry_code(udidocDO.getCode());
				patDo.setMarry_name(udidocDO.getName());
				patDo.setId_marry(udidocDO.getId_udidoc());
			}
			// 民族
			if (StringUtil.isEmpty(psnDocDos[i].getNationatily())) {
				patDo.setNation_code(null);
				patDo.setNation_name(null);
				patDo.setId_nation(null);
			} else {
				UdidocDO udidocdo = udidocRService.findById(psnDocDos[i].getNationatily());
				patDo.setNation_code(udidocdo.getCode());
				patDo.setNation_name(udidocdo.getName());
				patDo.setId_nation(udidocdo.getId_udidoc());
			}
			// 国家
			ICountryzoneRService rService = ServiceFinder.find(ICountryzoneRService.class);
			CountryZoneDO countryZoneDO = rService.findById(psnDocDos[i].getCountry());
			if (StringUtil.isEmpty(psnDocDos[i].getCountry())) {
				patDo.setSd_country(null);
				patDo.setCountry_name(null);
				patDo.setId_country(null);
			} else {
				patDo.setSd_country(countryZoneDO.getCode());
				patDo.setCountry_name(countryZoneDO.getName());
				patDo.setId_country(countryZoneDO.getId_countryzone());
			}

			patDo.setWbcode(psnDocDos[i].getWbcode());// 五笔
			patDo.setPycode(psnDocDos[i].getPycode());// 拼音
			patDo.setMnecode(psnDocDos[i].getMnecode());// 助记码
			patDo.setBarcode_chis(psnDocDos[i].getCode());

			patDo.setStatus(DOStatus.UPDATED);
			patiAggDos[i].setParentDO(patDo);
		}
		return patiAggDos;

	}

	/**
	 * 新增患者人员关系
	 * 
	 * @param aggDo
	 * @param psnDocDos
	 * @throws BizException
	 */
	private void addPiPatpsndocs(HashMap<String, String> patPsnMap) throws BizException {

		if (patPsnMap == null)
			return;
		List<PiPatVsPsnDO> piPatVsPsnDOList = new ArrayList<PiPatVsPsnDO>();
		for (String key : patPsnMap.keySet()) {
			PiPatVsPsnDO piPatVsPsnDO = new PiPatVsPsnDO();
			// 人员id
			piPatVsPsnDO.setId_psndoc(patPsnMap.get(key).toString());
			// 患者id
			piPatVsPsnDO.setId_pat(key);
			piPatVsPsnDO.setStatus(DOStatus.NEW);
			piPatVsPsnDOList.add(piPatVsPsnDO);
		}
		IPatvspsnCudService service = ServiceFinder.find(IPatvspsnCudService.class);
		service.insert(piPatVsPsnDOList.toArray(new PiPatVsPsnDO[] {}));
	}

	/**
	 * 根据人员id获取患者id
	 * 
	 * @param psnDocDos
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO[] getIdPat(PsnDocDO[] psnDocDos) throws BizException {

		String[] id_psndoc = new String[psnDocDos.length];
		for (int i = 0; i < psnDocDos.length; i++) {
			id_psndoc[i] = psnDocDos[i].getId_psndoc();
		}
		IPatvspsnRService service = ServiceFinder.find(IPatvspsnRService.class);
		PiPatVsPsnDO[] piPatVsPsnDOs = service.findByAttrValStrings(PiPatVsPsnDO.ID_PSNDOC, id_psndoc);
		List<String> idPatlist = new ArrayList<String>();
		// 中间表为空
		if (ArrayUtil.isEmpty(piPatVsPsnDOs)) {
			HashMap<String, String> patPsnMap = new HashMap<String, String>();
			// 通过人员表查询患者信息
			PatiAggDO[] PatiAggDO = this.getPatInfo(psnDocDos, patPsnMap);
			// 如果患者信息为空
			if (ArrayUtil.isEmpty(PatiAggDO)) {
				PatiAggDO = this.setPatInfo(psnDocDos, patPsnMap);
			}
			// 如果不为空新建人员关系表
			this.addPiPatpsndocs(patPsnMap);
			return PatiAggDO;
		} else {
			for (PiPatVsPsnDO piPatVsPsnDO : piPatVsPsnDOs) {
				if (!StringUtil.isEmpty(piPatVsPsnDO.getId_pat()))
					idPatlist.add(piPatVsPsnDO.getId_pat());
			}
		}
		if (!ListUtil.isEmpty(idPatlist)) {
			IPatiRService patRService = ServiceFinder.find(IPatiRService.class);
			PatiAggDO[] aggDOs = patRService.findByIds(idPatlist.toArray(new String[] {}), FBoolean.FALSE);
			return aggDOs;
		}
		return null;
	}

	/**
	 * 通过人员姓名，性别，出生日期，手机号码查询患者信息
	 * 
	 * @param aggDos
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO[] getPatInfo(PsnDocDO[] psnDocDos, HashMap<String, String> patPsnMap) throws BizException {
		StringBuilder sb = new StringBuilder();
		Map<String, String> psnMap = new HashMap<String, String>();
		for (int i = 0; i < psnDocDos.length; i++) {
			PsnDocDO psnDocDO = psnDocDos[i];
			String strPsn = psnDocDO.getName() + psnDocDO.getSex() + psnDocDO.getBirthday() + psnDocDO.getMobile();
			if (!psnMap.containsKey(strPsn))
				psnMap.put(strPsn, psnDocDO.getId_psndoc());
			// 姓名，性别，出生日期，手机号码组合检索
			if (i != 0) {
				sb.append(" or ");
			}
			sb.append("(name ='" + psnDocDO.getName() + "'");// 名字
			sb.append(" and id_sex ='" + psnDocDO.getSex() + "'");// 身份证号
			sb.append(" and dt_birth ='" + psnDocDO.getBirthday() + "'");// 出生日期
			sb.append(" and mob ='" + psnDocDO.getMobile() + "')");// 手机号
		}
		IPatiRService ser = ServiceFinder.find(IPatiRService.class);
		PatiAggDO[] PatiAggDOArr = ser.find(sb.toString(), "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(PatiAggDOArr)) {
			for (PatiAggDO patiAggDO : PatiAggDOArr) {
				PatDO patDo = patiAggDO.getParentDO();
				String str = patDo.getName() + patDo.getId_sex() + patDo.getDt_birth() + patDo.getMob();
				if (psnMap.containsKey(str)) {
					if (!patPsnMap.containsKey(patDo.getId_pat()))
						patPsnMap.put(patDo.getId_pat(), psnMap.get(str));
				}
			}
			return PatiAggDOArr;
		}
		return null;
	}
}
