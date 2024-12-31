package iih.pi.reg.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.utils.UdidocUtils;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.reg.dto.thirdplatform.d.PiPatThirdPlatCondDTO;
import iih.pi.reg.dto.thirdplatform.d.PiPatThirdPlatDTO;
import iih.pi.reg.dto.uniquemanage.d.PiPatUniqueQryCondDTO;
import iih.pi.reg.dto.uniquemanage.d.PiPatUniqueQryRltDTO;
import iih.pi.reg.i.IPiPatUniqueManageService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 查询第三方平台患者信息
 * 
 * @author ly 2019/02/15
 *
 */
public class GetThirdPlatformPatBP {
	/**
	 * 查询第三方平台患者信息
	 * 
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public PiPatThirdPlatDTO exec(PiPatThirdPlatCondDTO cond) throws BizException {
		// 调用电子健康卡查询接口
		PiPatThirdPlatDTO platDto = this.queryThirdEle(cond);
		// 调用二维码验证接口获取二维码信息
		return platDto;
	}

	private PiPatThirdPlatDTO queryThirdEle(PiPatThirdPlatCondDTO cond) throws BizException {
		// 组装接口入参
		PiPatUniqueQryCondDTO condDto = new PiPatUniqueQryCondDTO();
		// 证件类型
		condDto.setSd_idtp(IPiDictCodeConst.SD_IDTP_IDENTITY);
		// 身份证号码
		condDto.setId_code(cond.getId_code());
		// 姓名
		condDto.setName(cond.getName_pat());
		condDto.setDt_birth(cond.getDt_birth());
		condDto.setSd_sex(cond.getSd_sex());
		IPiPatUniqueManageService service = ServiceFinder.find(IPiPatUniqueManageService.class);
		if (service == null) {
			throw new BizException("未获取到第三方平台接口实现类");
		}
		PiPatUniqueQryRltDTO piPatUniqueQryRltDTO = service.queryPatient(condDto);
		PiPatThirdPlatDTO pipat = new PiPatThirdPlatDTO();

		if (piPatUniqueQryRltDTO != null && FBoolean.TRUE.equals(piPatUniqueQryRltDTO.getFg_result())) {

			// 姓名
			pipat.setName_pat(piPatUniqueQryRltDTO.getName());
			// 出生日期
			pipat.setDt_birth(piPatUniqueQryRltDTO.getDt_birth());
			// 证件号码
			pipat.setId_code(piPatUniqueQryRltDTO.getId_code());
			// 手机号
			pipat.setMob(piPatUniqueQryRltDTO.getMod());
			// 第三方健康卡id
			pipat.setId_third(piPatUniqueQryRltDTO.getId_third());
			// 二维码
			pipat.setCode_third(piPatUniqueQryRltDTO.getCode_third());
			// 设置empi返回值
			setEmpiValue(pipat, piPatUniqueQryRltDTO);

		} else {
			return null;
		}
		return pipat;
	}

	/**
	 * 设置empi返回值
	 * 
	 * @param pipat
	 * @param piPatUniqueQryRltDTO
	 * @throws BizException
	 */
	private void setEmpiValue(PiPatThirdPlatDTO pipat, PiPatUniqueQryRltDTO piPatUniqueQryRltDTO) throws BizException {

		// 证件类型
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getSd_idtp())) {
			// 证件类型编码
			pipat.setSd_idtp(piPatUniqueQryRltDTO.getSd_idtp());
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode(IPiDictCodeTypeConst.SD_IDTP,
					piPatUniqueQryRltDTO.getSd_idtp());
			// 证件类型名称
			pipat.setName_idtp(udidocDO.getName());
			// 证件类型id
			pipat.setId_idtp(udidocDO.getId_udidoc());
		}
		// 性别
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getSd_sex())) {
			// 性别编码
			pipat.setSd_sex(piPatUniqueQryRltDTO.getSd_sex());
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode(IPiDictCodeTypeConst.SD_SEX_CODE,
					piPatUniqueQryRltDTO.getSd_sex());
			// 性别id
			pipat.setId_sex(udidocDO.getId_udidoc());
			// 性别名称
			pipat.setName_sex(udidocDO.getName());
		}
		// 民族
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getSd_nation())) {
			// 民族
			pipat.setSd_nation(piPatUniqueQryRltDTO.getSd_nation());
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode(IPiDictCodeTypeConst.SD_NATION,
					piPatUniqueQryRltDTO.getSd_nation());
			// 民族id
			pipat.setId_nation(udidocDO.getId_udidoc());
			// 民族名称
			pipat.setName_nation(udidocDO.getName());
		}
		// 国家
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getSd_country())) {
			ICountryzoneRService iCountry = ServiceFinder.find(ICountryzoneRService.class);
			CountryZoneDO[] countryZoneDOs = iCountry.findByAttrValString(CountryZoneDO.CODE,
					piPatUniqueQryRltDTO.getSd_country());
			if (!ArrayUtil.isEmpty(countryZoneDOs)) {
				// 国家
				pipat.setSd_country(piPatUniqueQryRltDTO.getSd_country());
				// 国家id
				pipat.setId_country(countryZoneDOs[0].getId_countryzone());
				// 国家名称
				pipat.setName_country(countryZoneDOs[0].getName());
			}
		}
		// 文化程度
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getSd_educ())) {
			// 文化程度
			pipat.setSd_educ(piPatUniqueQryRltDTO.getSd_educ());
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode(IPiDictCodeTypeConst.SD_EDUC,
					piPatUniqueQryRltDTO.getSd_educ());
			// 文化程度id
			pipat.setId_educ(udidocDO.getId_udidoc());
			// 民族名称
			pipat.setName_educ(udidocDO.getName());
		}
		// 婚姻状况
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getSd_marry())) {
			// 婚姻状况
			pipat.setSd_marry(piPatUniqueQryRltDTO.getSd_marry());
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode(IPiDictCodeTypeConst.SD_MARRY,
					piPatUniqueQryRltDTO.getSd_marry());
			// 婚姻状况id
			pipat.setId_marry(udidocDO.getId_udidoc());
			// 婚姻状况名称
			pipat.setName_marry(udidocDO.getName());
		}
		// 就诊卡号
		FArrayList farrayListCard = new FArrayList();
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getEntcard_code())) {
			PiPatCardDO piPatCardDO = assemblePatEntCardData(piPatUniqueQryRltDTO);
			farrayListCard.add(piPatCardDO);
		}
		// 健康卡
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getCode_third())) {
			PiPatCardDO piPatCardDO = assemblePatEleCardData(piPatUniqueQryRltDTO);
			farrayListCard.add(piPatCardDO);
		}
		pipat.setPatcard(farrayListCard);
		// 医保卡卡号
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getNo_hp())) {
			pipat.setNo_hp(piPatUniqueQryRltDTO.getNo_hp());
		}
		// 工作单位
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getWorkunit())) {
			pipat.setWorkunit(piPatUniqueQryRltDTO.getWorkunit());
		}
		// 职业
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getSd_occu())) {
			pipat.setSd_occu(piPatUniqueQryRltDTO.getSd_occu());
			UdidocDO udidocDO = UdidocUtils.getUdidocByCode(IPiDictCodeTypeConst.SD_OCCU,
					piPatUniqueQryRltDTO.getSd_occu());
			pipat.setId_occu(udidocDO.getId_udidoc());
			pipat.setName_occu(udidocDO.getName());
		}
		// 地址集合组装
		FArrayList farrayList = getAddr(piPatUniqueQryRltDTO);
		pipat.setAddrarray(farrayList);
		// 联系人 姓名 关系 电话
		FArrayList arrayCont = new FArrayList();
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getPatcont_name())
				&& StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getPatcont_mod())
				&& StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getSd_conttp())) {
			PiPatContDO cont = new PiPatContDO();
			cont.setName(piPatUniqueQryRltDTO.getPatcont_name());
			cont.setConttel(piPatUniqueQryRltDTO.getPatcont_mod());
			cont.setSd_conttp(piPatUniqueQryRltDTO.getSd_conttp());
			cont.setId_conttp(
					UdidocUtils.getUdidocByCode(IPiDictCodeTypeConst.SD_CONTTP, piPatUniqueQryRltDTO.getSd_conttp())
							.getId_udidoc());
			cont.setConttp_name(UdidocUtils
					.getUdidocByCode(IPiDictCodeTypeConst.SD_CONTTP, piPatUniqueQryRltDTO.getSd_conttp()).getName());
			if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getPatcontaddr_street())) {
				cont.setContaddr(piPatUniqueQryRltDTO.getPatcontaddr_street());
			}
			if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getPatcontaddr_zip())) {
				cont.setZip(piPatUniqueQryRltDTO.getPatcontaddr_zip());
			}
			arrayCont.add(cont);
		}
		pipat.setPatcont(arrayCont);
	}

	/**
	 * 组装患者卡信息
	 * 
	 * @param rltDto
	 * @return
	 * @throws BizException
	 */
	private PiPatCardDO assemblePatEntCardData(PiPatUniqueQryRltDTO rltDto) throws BizException {
		PiPatCardDO patCardDO = new PiPatCardDO();
		DAFacade daf = new DAFacade();
		// 患者卡类型编码
		patCardDO.setSd_patcardtp(IPiDictCodeConst.SD_CARD_TYPE_TREATMENT);
		String sql2 = String.format("select * from pi_pat_cardtp where sd_patcardtp = '%s' and ds=0 ",
				IPiDictCodeConst.SD_CARD_TYPE_TREATMENT);
		PiPatCardTpDO patCardTpDO = (PiPatCardTpDO) daf.execQuery(sql2, new BeanHandler(PiPatCardTpDO.class));
		// 患者卡类型id
		patCardDO.setId_patcardtp(patCardTpDO.getId_cardtp());
		patCardDO.setPatcardtp_name(patCardTpDO.getName());
		patCardDO.setCode(rltDto.getEntcard_code());
		patCardDO.setFg_def(FBoolean.FALSE);
		patCardDO.setDt_b(new FDateTime());
		patCardDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
		patCardDO.setFg_act(FBoolean.TRUE);
		patCardDO.setStatus(DOStatus.NEW);
		// 已经有的卡数量+1
		patCardDO.setSortno(1);

		return patCardDO;
	}

	/**
	 * 组装患者卡数据
	 * 
	 * @param patDO
	 * @param rltDto
	 * @return
	 * @throws BizException
	 */
	private PiPatCardDO assemblePatEleCardData(PiPatUniqueQryRltDTO rltDto) throws BizException {
		PiPatCardDO patCardDO = new PiPatCardDO();
		DAFacade daf = new DAFacade();
		// 患者卡类型编码
		patCardDO.setSd_patcardtp(IPiDictCodeConst.SD_CARD_TYPE_HEALTH);
		String sql2 = String.format("select * from pi_pat_cardtp where code = '%s' ",
				IPiDictCodeConst.SD_CARD_TYPE_HEALTH);
		PiPatCardTpDO patCardTpDO = (PiPatCardTpDO) daf.execQuery(sql2, new BeanHandler(PiPatCardTpDO.class));
		// 患者卡类型id
		patCardDO.setId_patcardtp(patCardTpDO.getId_cardtp());
		patCardDO.setCode(rltDto.getCode_third());
		patCardDO.setFg_def(FBoolean.FALSE);
		patCardDO.setDt_b(new FDateTime());
		patCardDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
		patCardDO.setFg_act(FBoolean.TRUE);
		patCardDO.setStatus(DOStatus.NEW);
		patCardDO.setPatcardtp_name(patCardTpDO.getName());
		// 已经有的卡数量+1
		if (StringUtils.isNotEmpty(rltDto.getEntcard_code())) {
			patCardDO.setSortno(2);
		} else {
			patCardDO.setSortno(1);
		}
		return patCardDO;
	}

	/**
	 * 获取地址集合
	 * 
	 * @param piPatUniqueQryRltDTO
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getAddr(PiPatUniqueQryRltDTO piPatUniqueQryRltDTO) throws BizException {
		FArrayList farrayList = new FArrayList();
		// 联系地址
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getConadd_sd_admdiv())
				&& StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getConadd_street())) {
			PatiAddrDO adddo = new PatiAddrDO();
			adddo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_COMMUNICATE);
			adddo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_COMMUNICATE);
			adddo.setAddrtp_name(UdidocUtils
					.getUdidocByCode(IPiDictCodeConst.CODE_ADDR_TYPE_DOCLIST, IPiDictCodeConst.SD_ADDR_TYPE_COMMUNICATE)
					.getName());
			adddo.setSd_admdiv(piPatUniqueQryRltDTO.getConadd_sd_admdiv());
			adddo.setStreet(piPatUniqueQryRltDTO.getConadd_street());
			setAdminAreaDoId(adddo, piPatUniqueQryRltDTO.getConadd_sd_admdiv());
			if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getConadd_zip())) {
				// 联系地址邮政编号
				adddo.setZip(piPatUniqueQryRltDTO.getConadd_zip());
			}
			farrayList.add(adddo);
		}
		// 户籍地址
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getCenreg_sd_admdiv())
				&& StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getCenreg_street())) {
			PatiAddrDO adddo = new PatiAddrDO();
			adddo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS);
			adddo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS);
			adddo.setSd_admdiv(piPatUniqueQryRltDTO.getCenreg_sd_admdiv());
			adddo.setAddrtp_name(UdidocUtils
					.getUdidocByCode(IPiDictCodeConst.CODE_ADDR_TYPE_DOCLIST, IPiDictCodeConst.SD_ADDR_TYPE_CENCUS)
					.getName());
			adddo.setStreet(piPatUniqueQryRltDTO.getCenreg_street());
			adddo.setSortno(1);
			setAdminAreaDoId(adddo, piPatUniqueQryRltDTO.getCenreg_sd_admdiv());
			if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getConadd_zip())) {
				// 联系地址邮政编号
				adddo.setZip(piPatUniqueQryRltDTO.getCenreg_zip());
			}
			farrayList.add(adddo);
		}
		// 家庭地址
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getHome_sd_admdiv())
				&& StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getHome_street())) {
			PatiAddrDO adddo = new PatiAddrDO();
			adddo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_FAMILY);
			adddo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_FAMILY);
			adddo.setStreet(piPatUniqueQryRltDTO.getHome_street());
			adddo.setSd_admdiv(piPatUniqueQryRltDTO.getHome_sd_admdiv());
			adddo.setAddrtp_name(UdidocUtils
					.getUdidocByCode(IPiDictCodeConst.CODE_ADDR_TYPE_DOCLIST, IPiDictCodeConst.SD_ADDR_TYPE_FAMILY)
					.getName());
			setAdminAreaDoId(adddo, piPatUniqueQryRltDTO.getHome_sd_admdiv());
			if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getHome_zip())) {
				// 联系地址邮政编号
				adddo.setZip(piPatUniqueQryRltDTO.getHome_zip());
			}
			if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getHome_mod())) {
				adddo.setTel(piPatUniqueQryRltDTO.getHome_mod());
			}
			farrayList.add(adddo);
		}
		// 工作單位
		if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getWorkunit_sd_admdiv())
				&& StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getWorkunit_street())) {
			PatiAddrDO adddo = new PatiAddrDO();
			adddo.setAddrtp_name(UdidocUtils
					.getUdidocByCode(IPiDictCodeConst.CODE_ADDR_TYPE_DOCLIST, IPiDictCodeConst.SD_ADDR_TYPE_WORK)
					.getName());
			adddo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_WORK);
			adddo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_WORK);
			adddo.setStreet(piPatUniqueQryRltDTO.getWorkunit_street());
			adddo.setSd_admdiv(piPatUniqueQryRltDTO.getWorkunit_sd_admdiv());
			setAdminAreaDoId(adddo, piPatUniqueQryRltDTO.getWorkunit_sd_admdiv());
			if (StringUtils.isNotEmpty(piPatUniqueQryRltDTO.getWorkunit_zip())) {
				// 工作單位邮政编号
				adddo.setZip(piPatUniqueQryRltDTO.getWorkunit_zip());
			}
			farrayList.add(adddo);
		}

		return farrayList;
	}

	/**
	 * 设置行政区域id
	 * 
	 * @param adddo
	 * @param code
	 * @throws BizException
	 */
	private void setAdminAreaDoId(PatiAddrDO adddo, String code) throws BizException {
		IAdminareaRService adminareaService = ServiceFinder.find(IAdminareaRService.class);
		AdminAreaDO[] adminAreaDOs = adminareaService.findByAttrValString(AdminAreaDO.CODE, code);
		if (ArrayUtil.isEmpty(adminAreaDOs)) {
			throw new BizException("不存在的行政区划" + code);
		}
		adddo.setId_admdiv(adminAreaDOs[0].getId_adminarea());
		adddo.setAdmdiv_fullname(adminAreaDOs[0].getName());
	}

}
