package iih.pi.reg.s.external.provide.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.params.PiParams;
import iih.pi.reg.dto.d.PiPatPeDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.s.bp.util.GetUdidocDOUtil;
import iih.pi.reg.s.bp.util.PiGetDefaultDataUtil;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.d.desc.AdminAreaDODesc;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 患者对接体检接口
 * 
 * @author houll
 *
 */
public class AbutExamPatBP {

	private String[] sexRange = new String[] { IPiDictCodeConst.SD_SEX_UNKNOW, IPiDictCodeConst.SD_SEX_MALE,
			IPiDictCodeConst.SD_SEX_FEMALE, IPiDictCodeConst.SD_SEX_UNEXPLAIN };

	private String[] idTypeRange = new String[] { IPiDictCodeConst.SD_IDTP_IDENTITY, IPiDictCodeConst.SD_IDTP_JMHKB,
			IPiDictCodeConst.SD_IDTP_HZ, IPiDictCodeConst.SD_IDTP_JGZ, IPiDictCodeConst.SD_IDTP_JSZ,
			IPiDictCodeConst.SD_IDTP_GAJMZ, IPiDictCodeConst.SD_IDTP_TWJMZ, IPiDictCodeConst.SD_IDTP_QTFDZ };

	public PatiAggDO[] exec(PiPatPeDTO[] aggDos) throws BizException {

		// 参数校验
		String param = this.validateParam(aggDos);
		if (param != null) {
			throw new BizException(param);
		}
		PatiAggDO[] aggDosById = this.getSamePatById(aggDos);
		if(!ArrayUtil.isEmpty(aggDosById)){
			return aggDosById;
		}
		// 查重
		PatiAggDO[] aggDosByOther = this.getSamePatByOther(aggDos);
		if(!ArrayUtil.isEmpty(aggDosByOther)){
			return aggDosByOther;
		}
//		if (list != null && list.size() > 0) {
//			throw new BizException("患者编码重复！");
//		}
		// 患者信息赋值
	    PatiAggDO[] aggDo = this.setPatInfo(aggDos);
		IPatiCudService patCService = ServiceFinder.find(IPatiCudService.class);
		PatiAggDO[] result = patCService.save(aggDo);

		return result;
	}

	private PatiAggDO[] getSamePatById(PiPatPeDTO[] piPatPeDto) throws BizException {
		PatiAggDO[] aggDos = new PatiAggDO[piPatPeDto.length];
		for (int i = 0; i < piPatPeDto.length; i++) {
			if (IPiDictCodeConst.SD_IDTP_QTFDZ.equals(piPatPeDto[i].getId_idtp()))
				return null;

			String sql = "select code from pi_pat where fg_invd = 'N' ";
			SqlParam param = new SqlParam();

			// 证件类型检索
			sql += "and sd_idtp = ? and id_code = ? ";
			param.addParam(piPatPeDto[i].getId_idtp());
			param.addParam(piPatPeDto[i].getIdcode());

			String orgSql = EnvContextUtil.processEnvContext(null, new PatDO(), false);
			sql += " and " + orgSql;

			DAFacade daf = new DAFacade();
			String code = (String) daf.execQuery(sql, param, new ColumnHandler());
			if(StringUtils.isEmpty(code)){
				return null;
			}
			PatiAggDO aggDo = new PatiAggDO();
			PatDO patDO = aggDo.getParentDO();
			patDO.setCode(code);
			patDO.setName(piPatPeDto[i].getName());
			patDO.setId_idtp(piPatPeDto[i].getId_idtp());
			patDO.setId_code(piPatPeDto[i].getIdcode());
			aggDo.setParentDO(patDO);
			aggDos[i]= aggDo;
		}
		return aggDos;
		
	}

	/**
	 * 查询是否存在相同身份编码的患者
	 * 
	 * @param aggDos
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO[] getSamePatByOther(PiPatPeDTO[] piPatPeDto) throws BizException {
		PatiAggDO[] aggDos = new PatiAggDO[piPatPeDto.length];
		for (int i = 0; i < piPatPeDto.length; i++) {
			String sql = "select code from pi_pat where fg_invd = 'N' ";
			SqlParam param = new SqlParam();
			// 姓名，性别，出生日期，手机号码组合检索
			sql += "and name = ? and sd_sex = ? and dt_birth = ? and mob = ? ";
			param.addParam(piPatPeDto[i].getName());
			param.addParam(piPatPeDto[i].getSd_sex());
			param.addParam(piPatPeDto[i].getDt_birth());
			param.addParam(piPatPeDto[i].getMob());

			String orgSql = EnvContextUtil.processEnvContext(null, new PatDO(), false);
			sql += " and " + orgSql;
			DAFacade daf = new DAFacade();
			String code = (String) daf.execQuery(sql, param, new ColumnHandler());
			if(StringUtils.isEmpty(code)){
				return null;
			}
			//组装返回结果值
			PatiAggDO aggDo = new PatiAggDO();
			PatDO patDO = aggDo.getParentDO();
			patDO.setCode(code);
			patDO.setName(piPatPeDto[i].getName());
			patDO.setId_idtp(piPatPeDto[i].getId_idtp());
			patDO.setId_code(piPatPeDto[i].getIdcode());
			aggDo.setParentDO(patDO);
			aggDos[i]= aggDo;
		}
		return aggDos;

	}

	/**
	 * 给体检患者信息赋值
	 * 
	 * @param patInfo
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO[] setPatInfo(PiPatPeDTO[] aggDos) throws BizException {
		PatiAggDO[] aggDo = new PatiAggDO[aggDos.length];
		for (int i = 0; i <= aggDos.length - 1; i++) {
			PatiAggDO PatiAggDO = new PatiAggDO();
			aggDo[i] = PatiAggDO;
			PatDO pat = new PatDO();
			aggDo[i].setParentDO(pat);
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

			pat.setName(aggDos[i].getName());
			pat.setPycode(CnToPy.getPyFirstCode(pat.getName()));// 拼音码
			pat.setWbcode(CnToWB.getWBCode(pat.getName()));// 五笔码
			pat.setFg_realname(FBoolean.TRUE);
			
			

			// 证件类型
			UdidocDO idtpDoc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_IDTP, aggDos[i].getSd_idtp());
			if (idtpDoc != null) {
				pat.setId_idtp(idtpDoc.getId_udidoc());
				pat.setSd_idtp(idtpDoc.getCode());
			} else {
				pat.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
				pat.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
			}
			pat.setId_code(aggDos[i].getIdcode());

			UdidocDO sexDoc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_SEX_CODE, aggDos[i].getSd_sex());
			if (sexDoc != null) {
				pat.setId_sex(sexDoc.getId_udidoc());
				pat.setSd_sex(sexDoc.getCode());
			}

			pat.setDt_birth(new FDate(aggDos[i].getDt_birth()));
			pat.setMob(aggDos[i].getMob());

			PiPatCaDO caDo = PiGetDefaultDataUtil.getDefPatCa();
			if (caDo != null) {
				pat.setId_paticate(caDo.getId_patca());
				pat.setId_patpritp(caDo.getId_patpritp());
				pat.setId_patcrettp(caDo.getId_patcrettp());
			}

			pat.setId_patsrctp(IPiDictCodeConst.ID_PATSRCTP_OTHER);
			pat.setSd_patsrctp(IPiDictCodeConst.SD_PATSRCTP_OTHER);
			// pat.setWorkunit(patInfo.getWorkUnit());

			// 默认中国
			CountryZoneDO china = PiGetDefaultDataUtil.getChina();
			if (china != null) {
				pat.setId_country(china.getId_countryzone());
				pat.setSd_country(china.getCode());
			}
			pat.setFg_invd(FBoolean.FALSE);

			// 现在住址
			AdminAreaDO area = this.getAddress(aggDos[i].getLive_street());
			if (area != null) {
				PatiAddrDO addr = new PatiAddrDO();
				addr.setStatus(DOStatus.NEW);
				addr.setSortno(1);
				addr.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
				addr.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
				addr.setId_admdiv(area.getId_adminarea());
				addr.setSd_admdiv(area.getCode());
				addr.setZip(area.getZipcode());
				addr.setStreet(aggDos[i].getLive_street());

				aggDo[i].setPatiAddrDO(new PatiAddrDO[] { addr });
			}

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

	/**
	 * 入参校验
	 * 
	 * @param aggDos
	 * @throws BizException
	 */
	private String validateParam(PiPatPeDTO[] aggDos) throws BizException {
		if (aggDos == null)
			return "体检患者基本信息为空";
		for (PiPatPeDTO piPatPeDTO : aggDos) {
			// 校验必须数据
			if (StringUtil.isEmpty(piPatPeDTO.getName()))
				return "入参患者姓名为空";

			if (StringUtil.isEmpty(piPatPeDTO.getId_sex()))
				return "入参患者性别为空";

			List<String> sexList = Arrays.asList(sexRange);
			if (!sexList.contains(piPatPeDTO.getSd_sex()))
				return "入参性别不在有效范围内";

			if (StringUtil.isEmpty(piPatPeDTO.getMob())) {
				return "入参手机号码为空";
			} else {
				Pattern ptn = Pattern.compile("^(\\d{3}\\d{8}$)|(^\\d{4}\\d{7,8}$)|(^[1]\\d{10})$");
				Matcher matcher = ptn.matcher(piPatPeDTO.getMob());
				if (!matcher.find()) {
					return "手机号码格式不正确";
				}
			}

			if (StringUtil.isEmpty(piPatPeDTO.getDt_birth())) {
				return "入参出生日期为空";
			} else {
				if (piPatPeDTO.getDt_birth().length() != 10) {
					return "出生日期格式不正确,正确格式为yyyy-MM-dd";
				}

				FDate fDate = null;
				try {
					fDate = new FDate(piPatPeDTO.getDt_birth());
				} catch (Exception e) {
					return "出生日期格式不正确,正确格式为yyyy-MM-dd";
				}

				if (fDate.compareTo(new FDate()) > 0) {
					return "出生日期不能大于当前日期";
				}

				if (StringUtil.isEmpty(piPatPeDTO.getId_idtp()))
					return "入参证件类型为空";
				List<String> idtpList = Arrays.asList(idTypeRange);
				if (!idtpList.contains(piPatPeDTO.getSd_idtp()))
					return "入参证件类型不在有效范围内";

				if (StringUtil.isEmpty(piPatPeDTO.getIdcode())) {
					return "入参证件号码为空";
				} else if (IPiDictCodeConst.SD_CARD_TYPE_IDENTITY.equals(piPatPeDTO.getSd_idtp())) {
					// 身份证时
					/*if (!IDChecker.checkIDCard(piPatPeDTO.getIdcode())) {
						return "身份证号码格式不正确";
					}*/
				}
			}
		}
		return null;
	}

}
