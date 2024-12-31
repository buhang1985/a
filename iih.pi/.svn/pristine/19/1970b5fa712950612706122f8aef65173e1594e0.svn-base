package iih.pi.reg.s.customer.guoji;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.res.params.BdResParams;
import iih.pi.common.idcheck.IDChecker;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.d.desc.PiPatCaDODesc;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.reg.dto.patap.d.PiPatChisInfoDTO;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.i.IPiPatLogService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.s.bp.util.GetUdidocDOUtil;
import iih.pi.reg.s.customer.guoji.util.PatNeedSyncUtil;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.log.Log;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.d.desc.AdminAreaDODesc;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 从chis同步患者数据
 * 
 * @author ly 2017/05/15
 *
 */
public class SyncPatiInfoFromChisBP {

	private boolean isIdentity = false;

	/**
	 * 从chis同步患者数据
	 * 
	 * @param codePat
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO exec(String codePat) throws BizException {
		if (StringUtils.isEmpty(codePat)) {
			return null;
		}

		writeBeginLog(codePat);

		getLock(codePat);

		this.isIdentity = IDChecker.checkIDCard(codePat);// 校验入参是否符合身份证格式

		PiPatChisInfoDTO chisDto = null;

		try {
			// 取得chis数据
			chisDto = this.getPatInfoFromOldChis(codePat);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e);
		}

		if (chisDto == null) {
			return null;
		}

		writeLog(chisDto);

		if (chisDto.getPatiAgg() != null) {

			// code不同时
			PatDO pat = chisDto.getPatiAgg().getParentDO();
			if (!chisDto.getPatient_id().equals(pat.getCode())) {

				String msg = "iih中存在身份证一致但患者编码不一致患者，无法进行同步操作,请修改iih中该患者证件类型为其他类型后重试。" + "患者编码:" + pat.getCode();
				throw new BizException(msg);
			}

			// code相同时
			if (PatNeedSyncUtil.needSync(chisDto, chisDto.getPatiAgg())) {

				IPatiCudService cudService = ServiceFinder.find(IPatiCudService.class);
				PatiAggDO[] newAggDos = cudService.update(new PatiAggDO[] { chisDto.getPatiAgg() });

				this.deliverMsg(newAggDos[0], chisDto);
				return newAggDos[0];
			}
			this.deliverMsg(chisDto.getPatiAgg(), chisDto);
			return chisDto.getPatiAgg();
		}

		PatiAggDO aggDo = null;
		// 老chis更新iih
		aggDo = this.updatePat(chisDto);

		if (aggDo != null) {
			this.deliverMsg(aggDo, chisDto);
			return aggDo;
		}

		// 老chis患者插入iih
		aggDo = this.insertPat(chisDto);

		// 清空chis同步标志
		aggDo.getParentDO().setOrigin(null);
		this.deliverMsg(aggDo, chisDto);
		return aggDo;
	}

	/**
	 * 从CHIS查询到患者信息后写日志
	 * 
	 * @param chisDto
	 */
	private void writeLog(PiPatChisInfoDTO chisDto) {
		IPiPatLogService piPatLogService = ServiceFinder.find(IPiPatLogService.class);
		String log = String.format("同步CHIS患者信息:查询到的CHIS患者编码:%s,查询时间:%s。", chisDto.getPatient_id(),
				AppUtils.getServerDateTime());
		piPatLogService.log(log, Level.INFO);
	}

	/**
	 * 写开始日志
	 * 
	 * @param codePat
	 *            患者编码
	 */
	private void writeBeginLog(String codePat) {
		IPiPatLogService piPatLogService = ServiceFinder.find(IPiPatLogService.class);
		String log = String.format("开始同步CHIS患者信息:患者编码:%s,同步时间:%s。", codePat, AppUtils.getServerDateTime());
		piPatLogService.log(log, Level.INFO);
	}

	/**
	 * 获取锁
	 * 
	 * @param codePat
	 * @throws BizException
	 */
	private void getLock(String codePat) throws BizException {
		FDateTime startDateTime = AppUtils.getServerDateTime();

		// 对同步数据操作加锁，锁定时间暂定两分钟
		String lockPk = String.format("SyncPatiInfoFromChis_%s", codePat);
		boolean lock = PKLock.getInstance().addDynamicLock(lockPk, 1000 * 60 * 2);

		if (!lock) {
			throw new BizException("同步CHIS患者信息：从chis同步患者数据加锁失败，请稍候重试。");
		}

		FDateTime getLockDateTime = AppUtils.getServerDateTime();
		long millis = getLockDateTime.getMillisAfter(startDateTime);
		if (millis > 3000) {
			IPiPatLogService piPatLogService = ServiceFinder.find(IPiPatLogService.class);
			String log = String.format("同步CHIS患者信息：获取主键锁时间超长:%s,%s,%s,%s。", codePat, startDateTime, getLockDateTime,
					millis);
			piPatLogService.log(log, Level.INFO);
		}

	}

	/**
	 * 从老chis获取患者信息
	 * 
	 * @param codePat
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private PiPatChisInfoDTO getPatInfoFromOldChis(String codePat) throws BizException {

		String dataSource = new BdResParams().CHISDB();
		// chis数据源未定义时，不去查询chis数据
		if (StringUtil.isEmpty(dataSource))
			return null;

		DAFacade daf = new DAFacade(dataSource);
		List<PiPatChisInfoDTO> result = null;

		String identityNo = null;
		PiPatChisInfoDTO notIdentityPatChis = null;

		// 非身份证首次查询
		if (!this.isIdentity) {
			PiGetPatInfoFromOldChisQry qry = new PiGetPatInfoFromOldChisQry(codePat, false);
			StringBuffer sqlSb = new StringBuffer(qry.getQrySQLStr());
			SqlParam param = qry.getQryParameter(sqlSb);

			result = (List<PiPatChisInfoDTO>) daf.execQuery(sqlSb.toString(), param,
					new BeanListHandler(PiPatChisInfoDTO.class));

			if (ListUtil.isEmpty(result))
				return null;

			// patient_id和p_bar_code查询数据应该唯一
			notIdentityPatChis = result.get(0);
			// 身份证编码转换(chis的身份证对应编码可能是1或01)
			if ("1".equals(notIdentityPatChis.getBlack_flag())) {
				notIdentityPatChis.setBlack_flag(IPiDictCodeConst.SD_IDTP_IDENTITY);
			}

			// 校验是否为身份证
			if (IDChecker.checkIDCard(notIdentityPatChis.getSocial_no())
					&& IPiDictCodeConst.SD_IDTP_IDENTITY.equals(notIdentityPatChis.getBlack_flag())) {
				identityNo = notIdentityPatChis.getSocial_no();
			} else {
				// 非身份证直接保存
				notIdentityPatChis.setFg_identity(FBoolean.FALSE);
				return notIdentityPatChis;
			}
		} else {
			identityNo = codePat;
		}

		// 用身份证查询
		PiGetPatInfoFromOldChisQry qry = new PiGetPatInfoFromOldChisQry(identityNo, true);
		StringBuffer sqlSb = new StringBuffer(qry.getQrySQLStr());
		SqlParam param = qry.getQryParameter(sqlSb);

		result = (List<PiPatChisInfoDTO>) daf.execQuery(sqlSb.toString(), param,
				new BeanListHandler(PiPatChisInfoDTO.class));

		if (ListUtil.isEmpty(result))
			return null;

		// 身份证编码转换(chis的身份证对应编码可能是1或01)
		for (PiPatChisInfoDTO patChis : result) {
			if ("1".equals(patChis.getBlack_flag())) {
				patChis.setBlack_flag(IPiDictCodeConst.SD_IDTP_IDENTITY);
			}
		}

		// 用身份证在iih中寻找患者
		PatiAggDO patAgg = this.getPatFromLocalByIdentity(identityNo);

		if (result.size() == 1) {
			if (patAgg != null) {
				result.get(0).setPatiAgg(patAgg);
			}
			this.difference(notIdentityPatChis, result.get(0));
			return result.get(0);
		}

		// 多条数据进行筛选,按照就诊次数及最后就诊日期 倒序排序
		for (PiPatChisInfoDTO patChis : result) {
			// p_bar_code有以1开头（医保）
			if (!StringUtil.isEmpty(patChis.getP_bar_code()) && patChis.getP_bar_code().startsWith("1")) {

				patChis.setFg_identity(FBoolean.TRUE);
				if (patAgg != null) {
					patChis.setPatiAgg(patAgg);
				}
				this.difference(notIdentityPatChis, patChis);
				return patChis;
			}
		}

		// 无医保则返回第一条数据
		PiPatChisInfoDTO patChis = result.get(0);
		patChis.setFg_identity(FBoolean.TRUE);
		if (patAgg != null) {
			patChis.setPatiAgg(patAgg);
		}
		this.difference(notIdentityPatChis, patChis);
		return patChis;
	}

	/**
	 * 将老chis患者数据插入iih
	 * 
	 * @param chisDto
	 * @throws BizException
	 */
	private PatiAggDO insertPat(PiPatChisInfoDTO chisDto) throws BizException {

		PatiAggDO aggDo = new PatiAggDO();
		PatDO patDo = new PatDO();
		patDo.setStatus(DOStatus.NEW);
		patDo.setOrigin(IPiPatConst.PAT_ORIGIN_CHIS);
		aggDo.setParentDO(patDo);

		patDo.setId_org(Context.get().getOrgId());
		patDo.setId_grp(Context.get().getGroupId());
		patDo.setCode(chisDto.getPatient_id());// 患者编码
		patDo.setName(chisDto.getName());// 患者姓名
		patDo.setPycode(CnToPy.getPyFirstCode(chisDto.getName()));// 拼音码
		patDo.setWbcode(CnToWB.getWBCode(chisDto.getName()));// 五笔码
		patDo.setBarcode_chis(chisDto.getP_bar_code());// 条码
		patDo.setMnecode(patDo.getCode());// 助记码
		patDo.setDt_birth(chisDto.getBirthday());
		if (IPiPatConst.OLDCHIS_SEX_MAN.equals(chisDto.getSex())) {// 性别
			patDo.setId_sex(IPiDictCodeConst.ID_SEX_MALE);
			patDo.setSd_sex(IPiDictCodeConst.SD_SEX_MALE);
		} else if (IPiPatConst.OLDCHIS_SEX_WOMAN.equals(chisDto.getSex())) {
			patDo.setId_sex(IPiDictCodeConst.ID_SEX_FEMALE);
			patDo.setSd_sex(IPiDictCodeConst.SD_SEX_FEMALE);
		} else {
			patDo.setId_sex(IPiDictCodeConst.ID_SEX_UNEXPLAIN);
			patDo.setSd_sex(IPiDictCodeConst.SD_SEX_UNEXPLAIN);
		}

		if (FBoolean.TRUE.equals(chisDto.getFg_identity())) {
			// patDo.setId_idtp(IPiDictCodeConst.ID_IDTP_IDENTITY);//主身份标识
			// patDo.setSd_idtp(IPiDictCodeConst.SD_IDTP_IDENTITY);
			patDo.setId_code(chisDto.getSocial_no().toUpperCase());// 身份证号 大写
		} else {
			// patDo.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
			// patDo.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
			patDo.setId_code(chisDto.getSocial_no());
		}

		if (!StringUtil.isEmpty(chisDto.getBlack_flag())) {
			UdidocDO doc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_IDTP, chisDto.getBlack_flag());
			if (doc != null) {
				patDo.setId_idtp(doc.getId_udidoc());
				patDo.setSd_idtp(doc.getCode());
				patDo.setIdtp_name(doc.getName());
			}
		} else {
			patDo.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
			patDo.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
		}

		this.setMobOrTel(patDo, chisDto.getHome_tel());// 电话号码

		PiPatCaDO patCa = this.getDefaultPatCa();
		if (!StringUtil.isEmpty(chisDto.getResponse_type())) {
			String patCaId = this.getPatCaIdPk(chisDto.getResponse_type());
			if (!StringUtil.isEmpty(patCaId)) {
				patDo.setId_paticate(patCaId);// 患者分类
			} else if (patCa != null) {
				patDo.setId_paticate(patCa.getId_patca());// 患者分类
			}

		} else if (patCa != null) {
			patDo.setId_paticate(patCa.getId_patca());// 患者分类
		}
		if (patCa != null) {
			patDo.setId_patpritp(patCa.getId_patpritp());// 价格分类
			patDo.setId_patcrettp(patCa.getId_patcrettp());// 信用分类
		}

		// 实名认证
		if (IPiPatConst.OLDCHIS_FG_REALNAME.equals(chisDto.getIdentify_flag()) || chisDto.getIdentify_flag() == null) {
			patDo.setFg_realname(FBoolean.TRUE);
		} else {
			patDo.setFg_realname(FBoolean.FALSE);
		}

		// 国家
		CountryZoneDO china = this.getChina();
		if (china != null) {
			patDo.setId_country(china.getId_countryzone());
			patDo.setSd_country(china.getCode());
		}

		// 地址
		if (!StringUtil.isEmpty(chisDto.getTemp_district())) {
			PatiAddrDO addr = this.getAddrDo(chisDto);
			aggDo.setPatiAddrDO(new PatiAddrDO[] { addr });
		}

		patDo.setFg_invd(FBoolean.FALSE);// 失效标志
		patDo.setId_patsrctp(IPiDictCodeConst.ID_PATSRCTP_WINDOW);// 建档来源
		patDo.setSd_patsrctp(IPiDictCodeConst.SD_PATSRCTP_WINDOW);

		if (!StringUtil.isEmpty(chisDto.getHome_district())) {
			UdidocDO srcDo = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_SRCREGIONTP_CODE,
					chisDto.getHome_district());
			if (srcDo != null) {
				patDo.setId_srcregiontp(srcDo.getId_udidoc());
				patDo.setSd_srcregiontp(srcDo.getOrg_code());
			}
		}
		/*
		 * patDo.setId_srcregiontp(IPiDictCodeConst.ID_SRCREGIONTP_HOSPITAL);//
		 * 患者来源地
		 * patDo.setSd_srcregiontp(IPiDictCodeConst.SD_SRCREGIONTP_HOSPITAL);
		 */

		// 医保信息
		if (!StringUtil.isEmpty(chisDto.getAddition_no1())) {
			PiPatHpDO hpDo = new PiPatHpDO();
			hpDo.setStatus(DOStatus.NEW);
			hpDo.setNo_hp(chisDto.getAddition_no1());
			hpDo.setId_hp(IPiPatConst.BJ_ID_HP);
			hpDo.setFg_deft(FBoolean.TRUE);
			hpDo.setMode_hp(IPiDictCodeConst.ID_HP_ENABLE);
			hpDo.setFg_act(FBoolean.TRUE);

			HPDO hpDic = (HPDO) new DAFacade().findByPK(HPDO.class, IPiPatConst.BJ_ID_HP);
			if (hpDic != null) {
				hpDo.setHp_name(hpDic.getName());
			}
			hpDo.setSortno(1);

			aggDo.setPiPatHpDO(new PiPatHpDO[] { hpDo });
		}

		IPatiCudService cudService = ServiceFinder.find(IPatiCudService.class);
		aggDo = cudService.insert(new PatiAggDO[] { aggDo })[0];

		IPatiRService rService = ServiceFinder.find(IPatiRService.class);
		aggDo = rService.findById(aggDo.getParentDO().getId_pat());

		return aggDo;
	}

	/**
	 * chis患者更新
	 * 
	 * @param chisDto
	 * @return
	 */
	private PatiAggDO updatePat(PiPatChisInfoDTO chisDto) throws BizException {

		IPatiRService prService = ServiceFinder.find(IPatiRService.class);
		String whereSql = "a0.code = '" + chisDto.getPatient_id() + "' and a0.Fg_invd = 'N' ";
		PatiAggDO[] pats = prService.find(whereSql, "", FBoolean.FALSE);

		if (ArrayUtil.isEmpty(pats))
			return null;

		PatiAggDO aggDo = pats[0];

		if (PatNeedSyncUtil.needSync(chisDto, aggDo)) {

			IPatiCudService cudService = ServiceFinder.find(IPatiCudService.class);
			PatiAggDO[] newAggDos = cudService.update(new PatiAggDO[] { aggDo });

			return newAggDos[0];
		}

		return aggDo;
	}

	/**
	 * 现住址DO
	 * 
	 * @param chisDto
	 * @return
	 * @throws BizException
	 */
	private PatiAddrDO getAddrDo(PiPatChisInfoDTO chisDto) throws BizException {

		PatiAddrDO addr = new PatiAddrDO();
		addr.setStatus(DOStatus.NEW);
		addr.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
		addr.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		addr.setSd_admdiv(chisDto.getTemp_district());
		addr.setStreet(chisDto.getTemp_street());
		// addr.setTel(chisDto.getHome_tel());
		addr.setZip(chisDto.getTemp_zipcode());
		addr.setSortno(1);

		if (!StringUtil.isEmpty(addr.getSd_admdiv())) {
			// 取得区县码对应的行政区划数据
			IAdminareaRService areaService = ServiceFinder.find(IAdminareaRService.class);
			String whereSql = AdminAreaDODesc.TABLE_ALIAS_NAME + ".code = '" + addr.getSd_admdiv() + "'";
			AdminAreaDO[] areas = areaService.find(whereSql, "", FBoolean.FALSE);

			if (!ArrayUtil.isEmpty(areas)) {
				addr.setId_admdiv(areas[0].getId_adminarea());
			}
		}

		return addr;
	}

	/**
	 * 获得默认患者分类
	 * 
	 * @return
	 * @throws BizException
	 */
	private PiPatCaDO getDefaultPatCa() throws BizException {
		IPatientcategoryRService cateService = ServiceFinder.find(IPatientcategoryRService.class);

		String tn = PiPatCaDODesc.TABLE_ALIAS_NAME;
		String whereSql = tn + ".fg_def = 'Y' ";

		PiPatCaDO[] caDos = cateService.find(whereSql, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(caDos))
			return null;

		return caDos[0];
	}

	/**
	 * 取得患者分类编码对应的主键
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private String getPatCaIdPk(String code) throws BizException {

		DAFacade daf = new DAFacade();
		String sql = "select id_patca from pi_pat_ca where code_chis = ? and ds = 0";
		SqlParam param = new SqlParam();
		param.addParam(code);

		String idPk = (String) daf.execQuery(sql, param, new ColumnHandler());

		return idPk;
	}

	/**
	 * 获取中国
	 * 
	 * @return
	 * @throws BizException
	 */
	private CountryZoneDO getChina() throws BizException {
		ICountryzoneRService countryService = ServiceFinder.find(ICountryzoneRService.class);
		String whereSql = "UPPER(code) = 'CN' ";

		CountryZoneDO[] zones = countryService.find(whereSql, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(zones))
			return null;

		return zones[0];
	}

	/**
	 * 设置电话移动号码或者固话
	 * 
	 * @param patDo
	 * @param telno
	 */
	private void setMobOrTel(PatDO patDo, String telno) {

		if (StringUtil.isEmpty(telno))
			return;

		if (telno.indexOf("1") == 0 && telno.length() == 11) {
			patDo.setMob(telno);
		} else {
			patDo.setTel(telno);
		}
	}

	/**
	 * 用身份证号码查询本地患者
	 * 
	 * @param identityNo
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO getPatFromLocalByIdentity(String identityNo) throws BizException {
		IPatiRService prService = ServiceFinder.find(IPatiRService.class);
		String whereSql = PatDODesc.TABLE_ALIAS_NAME + ".id_code = '" + identityNo + "' and "
				+ PatDODesc.TABLE_ALIAS_NAME + ".sd_idtp = '" + IPiDictCodeConst.SD_IDTP_IDENTITY + "'";

		PatiAggDO[] aggDos = prService.find(whereSql, "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(aggDos)) {
			// 有效性校验
			PatiAggDO aggDo = this.checkInvalid(aggDos);
			// 返回数据
			return aggDo;
		}

		return null;
	}

	/**
	 * 患者有有效性校验
	 * 
	 * @param aggDos
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO checkInvalid(PatiAggDO[] aggDos) throws BizException {

		PatiAggDO rtn = null;
		for (PatiAggDO patiAggDO : aggDos) {
			PatDO pat = patiAggDO.getParentDO();
			if (!FBoolean.TRUE.equals(pat.getFg_invd())) {
				rtn = patiAggDO;
				break;
			}
		}

		return rtn;
	}

	/**
	 * 对比非身份证患者于目前患者
	 * 
	 * @param notIdentityPatChis
	 * @param targetPatChis
	 */
	private void difference(PiPatChisInfoDTO notIdentityPatChis, PiPatChisInfoDTO targetPatChis) {

		if (notIdentityPatChis == null)
			return;

		if (!notIdentityPatChis.getPatient_id().equals(targetPatChis.getPatient_id())) {

			String msg = String.format("根据优先级最终匹配到患者id为%s的患者，原输入值查询到的患者id为%s，请确认二者是否为同一患者，",
					targetPatChis.getPatient_id(), notIdentityPatChis.getPatient_id());
			targetPatChis.setAttrVal("Msg", msg);
		}
	}

	/**
	 * 赋值信息字段
	 * 
	 * @param aggDo
	 * @param patChis
	 */
	private void deliverMsg(PatiAggDO aggDo, PiPatChisInfoDTO patChis) {
		aggDo.getParentDO().setAttrVal("Msg", patChis.getAttrVal("Msg"));
	}
}
