package iih.pi.reg.s.bp.help;

import org.apache.commons.lang.ArrayUtils;

import com.alibaba.fastjson.JSONObject;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.utils.UdidocUtils;
import iih.pi.banner.d.PatientBannerDTO;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.overview.overview.d.PiPatDO;
import iih.pi.params.PiParams;
import iih.pi.reg.dto.uniquemanage.d.PiPatUniqueQryCondDTO;
import iih.pi.reg.dto.uniquemanage.d.PiPatUniqueQryRltDTO;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.i.IPiPatLogService;
import iih.pi.reg.i.IPiPatUniqueManageService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import iih.pi.reg.s.bp.GetPatiBannerBP;
import iih.pi.reg.s.bp.qry.PiBannerQry;
import iih.pi.reg.s.bp.util.PiGetDefaultDataUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 从第三方患者唯一管理平台同步患者信息
 * @author ly 2019/02/18
 *
 */
public class GetPatiBannerFromThirdSystemBP {

	/**
	 * 从第三方患者唯一管理平台同步患者信息
	 * @param sqlStr
	 * @param services
	 * @param valueText
	 * @return
	 * @throws BizException
	 */
	public PatientBannerDTO exec(String sqlStr, String[] services, String valueText) throws BizException{
		IPiPatLogService piLog = ServiceFinder.find(IPiPatLogService.class);
		if(!this.ifSyncFromThirdPlatform(services))
			return null;
		
		IPiPatUniqueManageService thirdService = ServiceFinder.find(IPiPatUniqueManageService.class);
		if(thirdService == null)
			return null;
		
		PiPatUniqueQryCondDTO cond = new PiPatUniqueQryCondDTO();
		cond.setCode_third(valueText);
		PiPatUniqueQryRltDTO rltDto = thirdService.queryPatient(cond);
		String patId ="";
		if(rltDto == null || !FBoolean.TRUE.equals(rltDto.getFg_result()))
			return null;
		piLog.log("第三方患者唯一管理平台同步患者信息，rltDto："+JSONObject.toJSONString(rltDto), Level.INFO);
		if(StringUtils.isNotEmpty(rltDto.getId_pat())){
			patId =rltDto.getId_pat();
			// 判断患者是否有绑定健康卡数据 未绑定则创建患者健康卡数据
			this.updPatInfo(rltDto);
		}else {
			//新建患者
			patId = this.syncFromThirdPlatform(rltDto);
		}
		
		String newCond = "and id_pat = '" + patId + "'";
		PiBannerQry qry = new PiBannerQry(null, newCond);
		PatientBannerDTO[] result = (PatientBannerDTO[])AppFwUtil.getDORstWithDao(qry, PatientBannerDTO.class);
		
		if(ArrayUtil.isEmpty(result))
			return null;
		
		return result[0];
	}
	

	
	/**
	 * 是否从第三方患者唯一管理平台同步数据
	 * @param services
	 * @return
	 * @throws BizException
	 */
	private boolean ifSyncFromThirdPlatform(String[] services) throws BizException{
		
		if(ArrayUtil.isEmpty(services))
			return false;
		
		boolean contain = false;
		for (String service : services) {
			if(GetPatiBannerBP.SYNC_FROM_THIRDPLATFORM.equals(service)){
				contain = true;
				break;
			}
		}
		
		if(contain == false)
			return false;
		
		FBoolean syncFromThird = new PiParams().PIPAT0021();
		if (FBoolean.TRUE.equals(syncFromThird))
			return true;
		return false;
	}

	/**
	 * 从第三方平台同步患者
	 * @param rltDto
	 * @return
	 * @throws BizException
	 */
	private String syncFromThirdPlatform(PiPatUniqueQryRltDTO rltDto) throws BizException{
		
		PatiAggDO aggDO = new PatiAggDO();
		
		// 设置患者基本信息
		PatDO patDO = new PatDO();
		aggDO.setParentDO(patDO);
		patDO.setOrigin(IPiPatConst.PAT_THIRD_PLATFORM);
		
		patDO.setId_org(Context.get().getOrgId());
		patDO.setId_grp(Context.get().getGroupId());
		if(StringUtils.isNotEmpty(rltDto.getId_third())){
			patDO.setId_third(rltDto.getId_third());//第三方平台id
		}
		//patDO.setBarcode_chis(rltDto.getCode_third());//第三方平台编码
		
		IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = billcodeManage.getPreBillCode_RequiresNew(PatDODesc.CLASS_FULLNAME);		
		patDO.setCode(code);
		patDO.setMnecode(code);
		patDO.setName(rltDto.getName());
		patDO.setDt_birth(rltDto.getDt_birth());
		
		UdidocDO idtpDoc = UdidocUtils.getUdidocByCodeNoExp(IPiDictCodeTypeConst.SD_IDTP, rltDto.getSd_idtp());
		if(idtpDoc != null){
			patDO.setId_idtp(idtpDoc.getId_udidoc());
		}
		patDO.setSd_idtp(rltDto.getSd_idtp());
		patDO.setId_code(rltDto.getId_code());
		patDO.setMob(rltDto.getMod());
		
		UdidocDO sexDoc = UdidocUtils.getUdidocByCodeNoExp(IPiDictCodeTypeConst.SD_SEX_CODE, rltDto.getSd_sex());
		if(sexDoc != null){
			patDO.setId_sex(sexDoc.getId_udidoc());
		}
		patDO.setSd_sex(rltDto.getSd_sex());
		
		UdidocDO nationDoc = UdidocUtils.getUdidocByCodeNoExp(IPiDictCodeTypeConst.SD_NATION, rltDto.getSd_nation());
		if(nationDoc != null){
			patDO.setId_nation(nationDoc.getId_udidoc());
		}
		patDO.setSd_nation(rltDto.getSd_nation());
		
		//患者分类
		PiPatCaDO caDo = PiGetDefaultDataUtil.getDefPatCa();
		if (caDo != null) {
			patDO.setId_paticate(caDo.getId_patca());
			patDO.setId_patpritp(caDo.getId_patpritp());
			patDO.setId_patcrettp(caDo.getId_patcrettp());
		}
		
		CountryZoneDO china = PiGetDefaultDataUtil.getChina();
		if(china != null){
			patDO.setId_country(china.getId_countryzone());
			patDO.setSd_country(china.getCode());
		}
		
		patDO.setOrigin(IPiPatConst.PAT_THIRD_PLATFORM);
		patDO.setFg_invd(FBoolean.FALSE);
		patDO.setFg_realname(FBoolean.TRUE);
		patDO.setStatus(DOStatus.NEW);
		//患者卡
		PiPatCardDO patCardData = this.assemblePatCardData(patDO,rltDto);
		aggDO.setPiPatCardDO(new PiPatCardDO[]{patCardData});
		IPatiCudService patCudService = ServiceFinder.find(IPatiCudService.class);
		PatiAggDO[] rtnAggDos = patCudService.insert(new PatiAggDO[] { aggDO });
		
		return rtnAggDos[0].getParentDO().getId_pat();
	}
	
	/**
	 * 创建联系地址DO
	 * @param codeDistrict
	 * @param street
	 * @param zip
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private PatiAddrDO createAddrDO(String addrtpId, String addrtpSd, String codeDistrict, String street, String zip, String tel) throws BizException{
		
		IAdminareaRService areaRSrv = ServiceFinder.find(IAdminareaRService.class);
		AdminAreaDO[] areaDos = areaRSrv.findByAttrValString(AdminAreaDO.CODE, codeDistrict);
		
		PatiAddrDO addrDO = new PatiAddrDO();
		addrDO.setId_addrtp(addrtpId);
		addrDO.setSd_addrtp(addrtpSd);
		if(!ArrayUtil.isEmpty(areaDos)){
			addrDO.setId_admdiv(areaDos[0].getId_adminarea());
			addrDO.setSd_admdiv(areaDos[0].getCode());
		}
		addrDO.setStreet(street);
		addrDO.setZip(zip);
		addrDO.setTel(tel);
		addrDO.setStatus(DOStatus.NEW);
		
		return addrDO;
	}
	/**
	 * 组装患者卡数据
	 * @param patDO
	 * @param rltDto
	 * @return
	 * @throws BizException
	 */
	private PiPatCardDO assemblePatCardData(PatDO patDO, PiPatUniqueQryRltDTO rltDto) throws BizException {
		PiPatCardDO patCardDO = new PiPatCardDO();
		DAFacade daf = new DAFacade();
		patCardDO.setId_pat(patDO.getId_pat());
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
		PiPatCardDO[] haveOtherCard = getPiPatCard(patDO.getId_pat());
		// 已经有的卡数量+1
		patCardDO.setSortno(haveOtherCard.length + 1);

		return patCardDO;
	}
	/**
	 * 校验患者否有其他的卡
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PiPatCardDO[] getPiPatCard(String patId) throws BizException {
		if (patId == null) {
			// 患者无档案
			return new PiPatCardDO[0];
		} else {
			IPiPatCardDORService piPatCardDORService = ServiceFinder.find(IPiPatCardDORService.class);
			PiPatCardDO[] patCardDOs = piPatCardDORService.findByAttrValString("Id_pat", patId);
			if (ArrayUtils.isEmpty(patCardDOs)) {
				// 患者有档案，但没有就诊卡
				return new PiPatCardDO[0];
			}
			// 患者有档案，已有就诊卡，说明该患者有其他卡
			return patCardDOs;
		}
	}
	/**
	 * 查询健康卡类型
	 * @return
	 * @throws BizException
	 */
	private PiPatCardTpDO getHealthCardTp() throws BizException {
		String sql = String.format("select * from pi_pat_cardtp where sd_patcardtp = '%s' and id_org = '%s'",
				IPiDictCodeConst.SD_CARD_TYPE_HEALTH, Context.get().getOrgId());
		PiPatCardTpDO patCardTpDO = (PiPatCardTpDO) new DAFacade().execQuery(sql, new BeanHandler(PiPatCardTpDO.class));
		return patCardTpDO;
	}
	/**
	 * 创建患者健康卡数据
	 * @param rltDto
	 * @throws DAException 
	 */
	private void addPiPatCard(PiPatUniqueQryRltDTO rltDto,PiPatCardTpDO cardTpDO) throws DAException{
		PiPatCardDO patCardDO = new PiPatCardDO();
		
		patCardDO.setId_pat(rltDto.getId_pat());
		patCardDO.setId_patcardtp(cardTpDO.getId_cardtp());
		patCardDO.setSd_patcardtp(cardTpDO.getCode());
		patCardDO.setCode(rltDto.getCode_third());
		patCardDO.setFg_def(FBoolean.FALSE);
		patCardDO.setDt_b(new FDateTime());
		patCardDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
		patCardDO.setFg_act(FBoolean.TRUE);
		patCardDO.setStatus(DOStatus.NEW);
		
		String sql = "select count(1) from pi_pat_card where id_pat = ? ";
		SqlParam param = new SqlParam();
		param.addParam(rltDto.getId_pat());
		
		DAFacade daf = new DAFacade();
		int count = (Integer)daf.execQuery(sql, param, new ColumnHandler());
		
		patCardDO.setSortno(count + 1);

		daf.insertDO(patCardDO);
	}
	/**
	 * 更新患者id_third
	 * @param rltDto
	 * @throws BizException 
	 */
	private void updPatInfo(PiPatUniqueQryRltDTO rltDto) throws BizException{
		DAFacade daf = new DAFacade();
		daf.setAddTimeStamp(false);
		PatDO patDO = (PatDO) daf.findByPK(PatDO.class, rltDto.getId_pat());
		if(patDO != null && !StringUtils.isNotEmpty(patDO.getId_third())){
			patDO.setId_third(rltDto.getId_third());
			patDO.setStatus(DOStatus.UPDATED);
			daf.updateDO(patDO, new String[] { PatDO.ID_THIRD });
			PiPatCardTpDO cardTpDO = this.getHealthCardTp();
			this.addPiPatCard(rltDto, cardTpDO);
		}
	}
}
