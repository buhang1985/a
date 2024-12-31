package iih.pi.reg.s.ws;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.TransactionStatus;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.pi.common.idcheck.IDChecker;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.params.PiParams;
import iih.pi.reg.dto.ws.PatBasicInfoBean;
import iih.pi.reg.dto.ws.PatCreateRtnBean;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.s.bp.util.GetUdidocDOUtil;
import iih.pi.reg.s.bp.util.PiGetDefaultDataUtil;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.d.desc.AdminAreaDODesc;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;
import xap.sys.permfw.pub.EnvContextUtil;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 患者建档WebService服务类
 * 
 * @author ly 2017/10/14
 *
 */
public class PatCreateWSBP {

	private static final String C_SUCCESS = "1";// 建档成功
	private static final String C_FAILED = "-1";// 建档失败
	private static final String C_HASSAME = "0";// 存在重复患者

	private String[] sexRange = new String[] { IPiDictCodeConst.SD_SEX_UNKNOW, IPiDictCodeConst.SD_SEX_MALE,
			IPiDictCodeConst.SD_SEX_FEMALE, IPiDictCodeConst.SD_SEX_UNEXPLAIN };

	private String[] idTypeRange = new String[] { IPiDictCodeConst.SD_IDTP_IDENTITY, IPiDictCodeConst.SD_IDTP_JMHKB,
			IPiDictCodeConst.SD_IDTP_HZ, IPiDictCodeConst.SD_IDTP_JGZ, IPiDictCodeConst.SD_IDTP_JSZ,
			IPiDictCodeConst.SD_IDTP_GAJMZ, IPiDictCodeConst.SD_IDTP_TWJMZ, IPiDictCodeConst.SD_IDTP_QTFDZ };

	/**
	 * 患者建档
	 * 
	 * @param patInfo
	 *            患者信息
	 * @return 建档信息
	 * @throws BizException
	 */
	public PatCreateRtnBean exec(PatBasicInfoBean patInfo) throws BizException {

		PatCreateRtnBean rtn = new PatCreateRtnBean();

		// 校验
		String msg = this.validateParam(patInfo);
		if (!StringUtil.isEmpty(msg)) {
			rtn.setSuccessFlag(C_FAILED);
			rtn.setErrorMsg(msg);
			return rtn;
		}

		String lockPk = getPkLockStr(patInfo);
		boolean lock = PKLock.getInstance().addDynamicLock(lockPk, 1000 * 60 * 2);
		if (!lock) {
			rtn.setSuccessFlag(C_FAILED);
			rtn.setErrorMsg("患者建档服务:患者建档加锁失败，请稍候重试。");
			return rtn;
		}

		// 查重
		String code = this.getSamePatById(patInfo);
		if (!StringUtil.isEmpty(code)) {
			rtn.setSuccessFlag(C_HASSAME);
			rtn.setPatientId(code);
			return rtn;
		}

		code = this.getSamePatByOther(patInfo);
		if (!StringUtil.isEmpty(code)) {
			rtn.setSuccessFlag(C_HASSAME);
			rtn.setPatientId(code);
			return rtn;
		}

		final PatiAggDO aggDo = this.setPatInfo(patInfo);
		PatiAggDO newAggDo = null;

		try {
			newAggDo = TransactionExecutor.executeNewTransaction(new TransactionalOperation<PatiAggDO>() {
				@Override
				public PatiAggDO doInTransaction(TransactionStatus arg0) {
					try {
						IPatiCudService patCService = ServiceFinder.find(IPatiCudService.class);
						return patCService.insert(new PatiAggDO[] { aggDo })[0];
					} catch (Exception e) {
						throw new BizRuntimeException(e.getMessage());
					}
				}
			});
		} catch (BizRuntimeException ex) {
			ex.printStackTrace();
			rtn.setSuccessFlag(C_FAILED);
			rtn.setErrorMsg(ex.getMessage());
			return rtn;
		}

		rtn.setSuccessFlag(C_SUCCESS);
		rtn.setPatientId(newAggDo.getParentDO().getCode());
		return rtn;
	}

	/**
	 * 获取患者主键锁
	 * 
	 * @param patAggDo
	 * @return
	 */
	private String getPkLockStr(PatBasicInfoBean patInfo) {
		return String.format("PatCreateWS_%s_%s_%s_%s_%s", patInfo.getName(), patInfo.getMob(), patInfo.getBirthDate(),
				patInfo.getIdType(), patInfo.getIdCode());
	}

	/**
	 * 入参校验
	 * 
	 * @param patInfo
	 * @throws BizException
	 */
	private String validateParam(PatBasicInfoBean patInfo) throws BizException {

		if (patInfo == null)
			return "患者建档服务:入参患者基本信息为空";

		// 校验必须数据
		if (StringUtil.isEmpty(patInfo.getName()))
			return "患者建档服务:入参患者姓名为空";

		if (StringUtil.isEmpty(patInfo.getSex()))
			return "患者建档服务:入参性别为空";

		List<String> sexList = Arrays.asList(sexRange);
		if (!sexList.contains(patInfo.getSex()))
			return "患者建档服务:入参性别不在有效范围内";

		if (StringUtil.isEmpty(patInfo.getBirthDate())) {
			return "患者建档服务:入参出生日期为空";
		} else {
			if (patInfo.getBirthDate().length() != 10) {
				return "患者建档服务:出生日期格式不正确,正确格式为yyyy-MM-dd";
			}

			FDate fDate = null;
			try {
				fDate = new FDate(patInfo.getBirthDate());
			} catch (Exception e) {
				return "患者建档服务:出生日期格式不正确,正确格式为yyyy-MM-dd";
			}

			if (fDate.compareTo(new FDate()) > 0) {
				return "患者建档服务:出生日期不能大于当前日期";
			}
		}

		if (StringUtil.isEmpty(patInfo.getMob())) {
			return "患者建档服务:入参手机号码为空";
		} else {
			Pattern ptn = Pattern.compile("^[1]\\d{10}$");
			Matcher matcher = ptn.matcher(patInfo.getMob());
			if (!matcher.find()) {
				return "患者建档服务:手机号码格式不正确";
			}
		}

		if (StringUtil.isEmpty(patInfo.getIdType()))
			return "患者建档服务:入参证件类型为空";
		List<String> idtpList = Arrays.asList(idTypeRange);
		if (!idtpList.contains(patInfo.getIdType()))
			return "患者建档服务:入参证件类型不在有效范围内";

		if (StringUtil.isEmpty(patInfo.getIdCode())) {
			return "患者建档服务:入参证件号码为空";
		} else if (IPiDictCodeConst.SD_CARD_TYPE_IDENTITY.equals(patInfo.getIdType())) {
			// 身份证时
			if (!IDChecker.checkIDCard(patInfo.getIdCode())) {
				return "患者建档服务:身份证号码格式不正确";
			}
		}

		if (StringUtils.isNotEmpty(patInfo.getMedInsCode())) {
			Pattern ptn = Pattern.compile("^\\d{11}[0-9a-zA-Z]$");
			Matcher matcher = ptn.matcher(patInfo.getMedInsCode());
			if (!matcher.find()) {
				return "患者建档服务:医保号格式不正确";
			}
		}

		return null;
	}

	/**
	 * 查询相同患者
	 * 
	 * @param patInfo
	 * @return
	 * @throws BizException
	 */
	private String getSamePatById(PatBasicInfoBean patInfo) throws BizException {

		if (IPiDictCodeConst.SD_IDTP_QTFDZ.equals(patInfo.getIdType()))
			return null;

		String sql = "select code from pi_pat where fg_invd = 'N' ";
		SqlParam param = new SqlParam();

		// 证件类型检索
		sql += "and sd_idtp = ? and id_code = ? ";
		param.addParam(patInfo.getIdType());
		param.addParam(patInfo.getIdCode());

		String orgSql = EnvContextUtil.processEnvContext(null, new PatDO(), false);
		sql += " and " + orgSql;

		DAFacade daf = new DAFacade();
		String code = (String) daf.execQuery(sql, param, new ColumnHandler());
		return code;
	}

	/**
	 * 查询相同患者
	 * 
	 * @param patInfo
	 * @return
	 * @throws BizException
	 */
	private String getSamePatByOther(PatBasicInfoBean patInfo) throws BizException {

		String sql = "select code from pi_pat where fg_invd = 'N' ";
		SqlParam param = new SqlParam();

		// 姓名，性别，出生日期，手机号码组合检索
		sql += "and name = ? and sd_sex = ? and dt_birth = ? and mob = ? ";
		param.addParam(patInfo.getName());
		param.addParam(patInfo.getSex());
		param.addParam(patInfo.getBirthDate());
		param.addParam(patInfo.getMob());

		String orgSql = EnvContextUtil.processEnvContext(null, new PatDO(), false);
		sql += " and " + orgSql;

		DAFacade daf = new DAFacade();
		String code = (String) daf.execQuery(sql, param, new ColumnHandler());
		return code;
	}

	/**
	 * 设置患者数据
	 * 
	 * @param patInfo
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO setPatInfo(PatBasicInfoBean patInfo) throws BizException {

		PatiAggDO aggDo = new PatiAggDO();

		// 患者信息
		PatDO pat = new PatDO();
		aggDo.setParentDO(pat);
		pat.setStatus(DOStatus.NEW);
		pat.setId_org(Context.get().getOrgId());
		pat.setId_grp(Context.get().getGroupId());

		if (FBoolean.FALSE.equals(new PiParams().PIPAT0002())) {
			IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
			String code = billcodeManage.getPreBillCode_RequiresNew(PatDODesc.CLASS_FULLNAME);
			pat.setCode(code);
			pat.setMnecode(code);

			String chisCode = code.length() > 2 ? code.substring(0, code.length() - 2) : code;
			pat.setBarcode_chis(chisCode);
		} else {
			pat.setCode("provide by chis");
			pat.setMnecode("provide by chis");
			pat.setBarcode_chis("provide by chis");
		}

		pat.setName(patInfo.getName());
		pat.setPycode(CnToPy.getPyFirstCode(pat.getName()));// 拼音码
		pat.setWbcode(CnToWB.getWBCode(pat.getName()));// 五笔码
		if(FBoolean.TRUE.equals(new PiParams().PIPAT0016())){
			pat.setFg_realname(FBoolean.TRUE);
		}else{
			pat.setFg_realname(FBoolean.FALSE);
		}

		// 证件类型
		UdidocDO idtpDoc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_IDTP, patInfo.getIdType());
		if (idtpDoc != null) {
			pat.setId_idtp(idtpDoc.getId_udidoc());
			pat.setSd_idtp(idtpDoc.getCode());
		} else {
			pat.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
			pat.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
		}
		pat.setId_code(patInfo.getIdCode());

		UdidocDO sexDoc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_SEX_CODE, patInfo.getSex());
		if (sexDoc != null) {
			pat.setId_sex(sexDoc.getId_udidoc());
			pat.setSd_sex(sexDoc.getCode());
		}

		pat.setDt_birth(new FDate(patInfo.getBirthDate()));
		pat.setMob(patInfo.getMob());

		PiPatCaDO caDo = PiGetDefaultDataUtil.getDefPatCa();
		if (caDo != null) {
			pat.setId_paticate(caDo.getId_patca());
			pat.setId_patpritp(caDo.getId_patpritp());
			pat.setId_patcrettp(caDo.getId_patcrettp());
		}

		pat.setId_patsrctp(IPiDictCodeConst.ID_PATSRCTP_OTHER);
		pat.setSd_patsrctp(IPiDictCodeConst.SD_PATSRCTP_OTHER);
		pat.setWorkunit(patInfo.getWorkUnit());

		// 默认中国
		CountryZoneDO china = PiGetDefaultDataUtil.getChina();
		if (china != null) {
			pat.setId_country(china.getId_countryzone());
			pat.setSd_country(china.getCode());
		}

		// 卡号暂不做处理 TODO

		// 保险编号
		if (!StringUtil.isEmpty(patInfo.getMedInsCode())) {
			PiPatHpDO hp = new PiPatHpDO();
			hp.setStatus(DOStatus.NEW);
			hp.setSortno(1);
			hp.setId_hp(IPiPatConst.BJ_ID_HP);
			hp.setNo_hp(patInfo.getMedInsCode());
			hp.setFg_deft(FBoolean.TRUE);
			hp.setMode_hp(IPiDictCodeConst.ID_HP_MODE_ACTIVE_ENABLE);
			hp.setDt_b(new FDateTime());
			hp.setFg_act(FBoolean.TRUE);

			aggDo.setPiPatHpDO(new PiPatHpDO[] { hp });
		}

		pat.setFg_invd(FBoolean.FALSE);

		// 现在住址
		AdminAreaDO area = this.getAddress(patInfo.getNowDistrict());
		if (area != null) {
			PatiAddrDO addr = new PatiAddrDO();
			addr.setStatus(DOStatus.NEW);
			addr.setSortno(1);
			addr.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			addr.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			addr.setId_admdiv(area.getId_adminarea());
			addr.setSd_admdiv(area.getCode());
			addr.setZip(area.getZipcode());
			addr.setStreet(patInfo.getNowStreet());

			aggDo.setPatiAddrDO(new PatiAddrDO[] { addr });
		}

		return aggDo;
	}

	/**
	 * 取得区县对应的
	 * 
	 * @param regionCode
	 * @return
	 * @throws BizException
	 */
	private AdminAreaDO getAddress(String regionCode) throws BizException {

		IAdminareaRService areaService = ServiceFinder.find(IAdminareaRService.class);
		String whereSql = AdminAreaDODesc.TABLE_ALIAS_NAME + ".code = '" + regionCode + "'";
		AdminAreaDO[] areas = areaService.find(whereSql, "", FBoolean.FALSE);

		if (ArrayUtil.isEmpty(areas))
			return null;

		return areas[0];
	}
}
