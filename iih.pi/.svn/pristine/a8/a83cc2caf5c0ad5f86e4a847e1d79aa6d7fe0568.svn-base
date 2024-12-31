package iih.pi.reg.s.task;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlCcPmDO;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.card.card.d.CardSuEnum;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.common.idcheck.IDChecker;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.params.PiParams;
import iih.pi.reg.dto.piimport.d.PiImportFromThirdDBDTO;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.i.IPiPatLogService;
import iih.pi.reg.i.custom.IPiImortService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatContDO;
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
import xap.mw.coreitf.d.FDouble;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.AbstractPersistMgr;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.kernel.exception.DbException;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRServiceExt;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 患者从第三方数据库导入任务
 * 含患者信息，卡信息，预交金信息
 * 流程：新建患者-->(卡入库-->领用-->发放)-->充值-->结账(卡库管理由参数控制)
 * @author ly 2019/07/17
 *
 */
public class PiImportFromThirdDBTask implements IBackgroundWorkPlugin {
	
	private DAFacade thirdDaf = null; 
	
	private DAFacade iihDaf = null; 
	
	private DataCache dataCache = null;
	
	private RepeatValidator validator = null;
	
	private Translator translator = null;
	
	private IPiImortService piCusService;
	
	private IPiPatLogService logService;
	
	private FDateTime now;
	
	private BlIncIssDO blIncIssDO;
	
	@Override
	public PreAlertObject executeTask(BgWorkingContext bdContext) throws BizException {
		
		this.logService = ServiceFinder.find(IPiPatLogService.class);
		this.logService.log("患者导入任务开始-->" + this.getLogNow(), Level.INFO);
		
		this.iihDaf = new DAFacade();
		this.loadContext((String)bdContext.getKeyMap().get(ImportConst.PARAM_PSN));
		
		Map<String, Object> paramMap = bdContext.getKeyMap();
		ImportParam param = new ImportParam();

		param.LoadAnCheckParam(paramMap);
		this.thirdDaf = new DAFacade(param.getDataSource());
		this.logService.log("加载缓存数据开始-->" + this.getLogNow(), Level.INFO);
		this.dataCache = new DataCache();
		this.dataCache.LoadOtherData(param);
		this.logService.log("加载缓存数据结束-->" + this.getLogNow(), Level.INFO);
		this.logService.log("加载重复校验器开始-->" + this.getLogNow(), Level.INFO);
		this.validator = new RepeatValidator(param.getFgcheckexisted(), param.getFgdealamtonly());
		this.logService.log("加载重复校验器结束-->" + this.getLogNow(), Level.INFO);
		
		this.translator = new Translator(param.getFgusetranslate());
		this.piCusService = ServiceFinder.find(IPiImortService.class);
		this.now = new FDateTime();
		
		// 查询患者并导入
		Integer end = param.getEndIndex();
		if (end == 0) {
			end = this.getMaxSortNO(param.getPatView());
		}
		int count = end - param.getBeginIndex() + 1;
		
		int page = count / ImportConst.MAXNUM;
		if(count % ImportConst.MAXNUM != 0){
			page ++;
		}
		
		for (int i = 0; i < page; i++) {
			int b = param.getBeginIndex() + i * ImportConst.MAXNUM;
			int e = b + ImportConst.MAXNUM - 1;
			e = e > end ? end : e;
			
			this.logService.log(String.format("查询第三方患者开始,起始索引%s,终止索引%s-->",b,e) + this.getLogNow(), Level.INFO);
			List<PiImportFromThirdDBDTO> thirdPatList = this.findPatFromThird(param.getPatView(), b, e);
			this.logService.log("查询第三方患者结束-->" + this.getLogNow(), Level.INFO);
			if(!ListUtil.isEmpty(thirdPatList)){
				this.logService.log("导入患者开始-->" + this.getLogNow(), Level.INFO);
				this.insertPat(thirdPatList, param);
				this.logService.log("导入患者结束-->" + this.getLogNow(), Level.INFO);
			}
		}
		
		this.logService.log("患者导入任务结束-->" + this.getLogNow(), Level.INFO);
		return null;
	}

	/**
	 * 加载上下文
	 * @param psnId
	 * @throws BizException
	 */
	private void loadContext(String psnId) throws BizException {
		
		IOrgRServiceExt orgService = ServiceFinder.find(IOrgRServiceExt.class);
		OrgDO[] orgDos =  orgService.queryAllOrgUnitVOs();
		
		if(ArrayUtil.isEmpty(orgDos)){
			throw new BizException("没有定义组织");
		}
		
		Context.get().setGroupId(orgDos[0].getId_grp());
		Context.get().setOrgId(orgDos[0].getId_org());
		Context.get().setGroupNumber(orgDos[0].getGroupno());
		
		String sql = "select id_user,id_psn from sys_user ";
		if (StringUtil.isEmpty(psnId)) {
			sql += "where code = '00000'";
		} else {
			sql += "where id_psn = '" + psnId + "'";
		}
		
		UserDO user = (UserDO)this.iihDaf.execQuery(sql, new BeanHandler(UserDO.class));
		
		if(user == null){
			throw new BizException("未定义导入人员");
		}
		Context.get().setUserId(user.getId_user());
		Context.get().setStuffId(user.getId_psn());
	}
	
	/**
	 * 日志时间
	 * @return
	 * @throws BizException
	 */
	private String getLogNow() throws BizException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		String formatStr = formatter.format(new Date());
		return formatStr;
	}
	
	/**
	 * 查询最大序号
	 * @return
	 * @throws BizException
	 */
	private Integer getMaxSortNO(String viewName) throws BizException {

		String sql = "select max(sortno) from " + viewName;
		Object obj = (Object) this.thirdDaf.execQuery(sql, new ColumnHandler());

		Integer count = 0;
		if (obj != null) {
			count = Integer.parseInt(obj.toString());
		}

		if (count == null || count <= 0) {
			throw new BizException(String.format("视图%s中未查询到数据", viewName));
		}

		return count;
	}
	
	/**
	 * 查询
	 * @param b
	 * @param e
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<PiImportFromThirdDBDTO> findPatFromThird(String viewName, int b, int e) throws BizException {
		
		String sql = "select * from " + viewName + " where sortno >= ? and sortno <= ? ";
		SqlParam param = new SqlParam();
		param.addParam(b);
		param.addParam(e);
		
		List<PiImportFromThirdDBDTO> thirdPatList = (List<PiImportFromThirdDBDTO>)this.thirdDaf.execQuery(
				sql, param, new BeanListHandler(PiImportFromThirdDBDTO.class));
		
		return thirdPatList;
	}
	
	/**
	 * 插入患者
	 * @param thirdPatList
	 * @param param
	 */
	private void insertPat(List<PiImportFromThirdDBDTO> thirdPatList, ImportParam param) throws BizException {
		
		String[] patKeys = new DBUtil().getOIDs(thirdPatList.size());
		String[] cardKeys = new DBUtil().getOIDs(thirdPatList.size());//就诊卡
		String[] prepayKeys = new DBUtil().getOIDs(thirdPatList.size());
		String blccKey = null;
		if(FBoolean.TRUE.equals(param.getFgcc())){
			blccKey = new DBUtil().getOIDs(1)[0];
		}
		
		List<PatDO> patList = new ArrayList<PatDO>();
		List<PatiAddrDO> patAddrList = new ArrayList<PatiAddrDO>();
		List<PiPatContDO> patContList = new ArrayList<PiPatContDO>();
		List<PiPatCardDO> patCardList = new ArrayList<PiPatCardDO>();
		
		List<PiCardDO> cardList  = new ArrayList<PiCardDO>();//卡数据
		List<BlPrePayPatDO> prepayList = new ArrayList<BlPrePayPatDO>();//预交金数据
		List<BlPrepayPatRcptDO> prepayRcptList = new ArrayList<BlPrepayPatRcptDO>();//预交金票据数据
		List<PiPatAccDO> accList = new ArrayList<PiPatAccDO>();//账户数据
		List<String> updateAccSqlList = new ArrayList<String>();//更新账户sql
	
		//判断是否包含金额
		boolean hasAmt = false;
		for (PiImportFromThirdDBDTO importData : thirdPatList) {
			if(importData.getAmt_prepay() != null && importData.getAmt_prepay().compareTo(FDouble.ZERO_DBL) > 0){
				hasAmt = true;
				break;
			}
		}
		
		String[] invoiceNos = null;
		if(hasAmt){
			IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
			blIncIssDO = incService.getCurInvoiceDO(Context.get().getStuffId(), null, IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT);
			if(blIncIssDO == null){
				throw new BizException("门诊预交金票据信息获取失败");
			}
			invoiceNos = incService.getCurInvoiceNoMany(Context.get().getStuffId(), null, IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT, thirdPatList.size());
		}
		
		int incUse = 0;
		for (int i = 0; i < thirdPatList.size(); i++) {
			PiImportFromThirdDBDTO importData = thirdPatList.get(i);
			
			if(StringUtil.isEmpty(importData.getName()))
				continue;
			
			//只处理金额时，需要找到原患者数据
			if (FBoolean.TRUE.equals(param.getFgdealamtonly())) {
				
				String repeatId = this.validator.getRepeatIdByCode(importData);
				if(!StringUtil.isEmpty(repeatId)){
					
					if(importData.getAmt_prepay() != null && importData.getAmt_prepay().compareTo(FDouble.ZERO_DBL) > 0){
						BlPrePayPatDO prepayDO = this.assemblePrepayData(repeatId, importData.getAmt_prepay(), invoiceNos[incUse], blccKey);
						prepayDO.setId_paypat(prepayKeys[i]);
						prepayList.add(prepayDO);
						
						BlPrepayPatRcptDO prepayRcpt = this.assemblePrepayRcptData(prepayDO);
						prepayRcptList.add(prepayRcpt);
						
						String updateSql = String.format(ImportConst.UPDATEACCSQL, importData.getAmt_prepay().toString(), repeatId);
						updateAccSqlList.add(updateSql);
						
						incUse++;
					}
				}else{
					//show log TODO
				}
			}else{
				
				boolean idRepeat = !StringUtil.isEmpty(this.validator.getRepeatIdByCode(importData));
				
				if(idRepeat){
					continue;
				}
				
				String repeatId = this.validator.getRepeatId(importData, patKeys[i]);
				
				if (StringUtil.isEmpty(repeatId)) {
					PatiAggDO patAggDO = this.assemblePatData(patKeys[i], cardKeys[i], importData, param);

					patList.add(patAggDO.getParentDO());
					if (!ArrayUtil.isEmpty(patAggDO.getPatiAddrDO())) {
						patAddrList.addAll(Arrays.asList(patAggDO.getPatiAddrDO()));
					}
					if (!ArrayUtil.isEmpty(patAggDO.getPiPatContDO())) {
						patContList.addAll(Arrays.asList(patAggDO.getPiPatContDO()));
					}
					if (!ArrayUtil.isEmpty(patAggDO.getPiPatCardDO())) {
						patCardList.addAll(Arrays.asList(patAggDO.getPiPatCardDO()));
					}

					PiPatAccDO accData = this.assemblePatAccData(patKeys[i]);
					accList.add(accData);

					if (!StringUtil.isEmpty(importData.getCardcode()) && FBoolean.TRUE.equals(param.getPIPAT0027())) {
						PiCardDO cardDO = this.assembleCardData(cardKeys[i], importData.getCardcode());
						cardList.add(cardDO);
					}
				} else {

					if (!StringUtil.isEmpty(importData.getCardcode())) {
						PiPatCardDO patCardDO = this.assemblePatCardData(repeatId, patKeys[i], importData.getCardcode(), param);
						patCardList.add(patCardDO);

						if (FBoolean.TRUE.equals(param.getPIPAT0027())) {
							PiCardDO cardDO = this.assembleCardData(cardKeys[i], importData.getCardcode());
							cardList.add(cardDO);
						}
					}
				}
				
				String patId = StringUtil.isEmpty(repeatId) ? patKeys[i] : repeatId;
				
				if (importData.getAmt_prepay() != null && importData.getAmt_prepay().compareTo(FDouble.ZERO_DBL) > 0) {
					BlPrePayPatDO prepayDO = this.assemblePrepayData(patId, importData.getAmt_prepay(), invoiceNos[incUse], blccKey);
					prepayDO.setId_paypat(prepayKeys[i]);
					prepayList.add(prepayDO);

					BlPrepayPatRcptDO prepayRcpt = this.assemblePrepayRcptData(prepayDO);
					prepayRcptList.add(prepayRcpt);

					String updateSql = String.format(ImportConst.UPDATEACCSQL, importData.getAmt_prepay().toString(), patId);
					updateAccSqlList.add(updateSql);

					incUse++;
				}
			}
		}
		
		BlCcDO ccDO = null;
		BlCcPmDO ccPmDO = null;
	
		if(FBoolean.TRUE.equals(param.getFgcc())){
			FDouble amt = FDouble.ZERO_DBL;
			for (BlPrePayPatDO prepayDO : prepayList) {
				amt = amt.add(prepayDO.getAmt());
			}
			
			if(amt.compareTo(FDouble.ZERO_DBL) > 0){
				ccDO = this.assembleBlccData(blccKey,amt);
				ccPmDO = this.assembleBlccPmData(blccKey, amt,prepayList.size());
			}
		}
		
		this.processData(patList, patAddrList, patContList, patCardList, cardList, 
				prepayList, prepayRcptList, accList, updateAccSqlList, 
				incUse, invoiceNos, ccDO, ccPmDO);
	}

	/**
	 * 组装患者数据
	 * @param patId
	 * @param patCardId
	 * @param importData
	 * @param param
	 * @return
	 */
	private PatiAggDO assemblePatData(String patId, String patCardId, PiImportFromThirdDBDTO importData, ImportParam param) throws BizException {
		
		PatiAggDO aggDO = new PatiAggDO();
		
		PatDO patDO = new PatDO();
		patDO.setId_pat(patId);
		patDO.setId_grp(Context.get().getGroupId());
		patDO.setId_org(Context.get().getOrgId());
		patDO.setCode(importData.getPatientid());
		patDO.setName(importData.getName());
		patDO.setMnecode(patDO.getCode());
		patDO.setPycode(CnToPy.getPyFirstCode(patDO.getName(), 100));
		patDO.setWbcode(CnToWB.getWBCode(patDO.getName(), 100));
		
		String impSdIdTp = this.translator.translate(ImportConst.TRANSLATION_IDTP, importData.getSd_idtp());
		if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(impSdIdTp) || IDChecker.checkIDCard(importData.getId_code())){
			patDO.setId_idtp(IPiDictCodeConst.ID_IDTP_IDENTITY);
			patDO.setSd_idtp(IPiDictCodeConst.SD_IDTP_IDENTITY);
		}else{
			UdidocDO idtpUdidoc = this.dataCache.getIdtpUdidoc(impSdIdTp);
			if(idtpUdidoc != null){
				patDO.setId_idtp(idtpUdidoc.getId_udidoc());
				patDO.setSd_idtp(idtpUdidoc.getCode());
			}
		}
		
		patDO.setId_code(importData.getId_code());
		if(StringUtil.isEmpty(patDO.getId_code())){
			patDO.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
			patDO.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
			patDO.setId_code("1");
		}
		
		
		patDO.setId_paticate(this.dataCache.getDftPatCa().getId_patca());
		patDO.setId_patpritp(this.dataCache.getDftPatCa().getId_patpritp());
		patDO.setId_patcrettp(this.dataCache.getDftPatCa().getId_patcrettp());
		
		UdidocDO sexUdidoc = this.dataCache.getSexUdidoc(
				this.translator.translate(ImportConst.TRANSLATION_SEX, importData.getSd_sex()));
		if(sexUdidoc != null){
			patDO.setId_sex(sexUdidoc.getId_udidoc());
			patDO.setSd_sex(sexUdidoc.getCode());
		}
		
		if(importData.getDt_birth() != null){
			patDO.setDt_birth(importData.getDt_birth());
			patDO.setDt_birth_hms(new FDateTime(importData.getDt_birth().toString() + " 00:00:00"));
		}
		patDO.setMob(importData.getMob());
		
		UdidocDO nationUdidoc = this.dataCache.getNationUdidoc(
				this.translator.translate(ImportConst.TRANSLATION_NATION, importData.getSd_nation()));
		if(nationUdidoc != null){
			patDO.setId_nation(nationUdidoc.getId_udidoc());
			patDO.setSd_nation(nationUdidoc.getCode());
		}
		
		CountryZoneDO country = this.dataCache.getCountry(
				this.translator.translate(ImportConst.TRANSLATION_COUNTRY, importData.getSd_country()));
		if (country != null) {
			patDO.setId_country(country.getId_countryzone());
			patDO.setSd_country(country.getCode());
		}
		
		patDO.setId_srcregiontp(IPiDictCodeConst.ID_SRCREGIONTP_LOCAL);
		patDO.setSd_srcregiontp(IPiDictCodeConst.SD_SRCREGIONTP_LOCAL);
		
		UdidocDO marrayUdidoc = this.dataCache.getMarryUdidoc(
				this.translator.translate(ImportConst.TRANSLATION_MARRY, importData.getSd_marry()));
		if(marrayUdidoc != null){
			patDO.setId_marry(marrayUdidoc.getId_udidoc());
			patDO.setSd_marry(marrayUdidoc.getCode());
		}
		
		patDO.setCode_amr_ip(importData.getCode_amr_ip());
		patDO.setFg_invd(FBoolean.FALSE);
		patDO.setFg_realname(FBoolean.TRUE);
		patDO.setId_patsrctp(IPiDictCodeConst.ID_PATSRCTP_OTHER);
		patDO.setSd_patsrctp(IPiDictCodeConst.SD_PATSRCTP_OTHER);
		//patDO.setBarcode_chis(chisInfo.getP_bar_code());
		patDO.setDef1(ImportConst.IMPORT_FLAG);
		patDO.setDef2(importData.getSortno().toString());
		patDO.setId_emp_create(Context.get().getStuffId());
		patDO.setStatus(DOStatus.NEW);
		aggDO.setParentDO(patDO);
		
		List<PatiAddrDO> patAddrList = new ArrayList<PatiAddrDO>();
 		if(!StringUtil.isEmpty(importData.getSd_adminarea_now()) || !StringUtil.isEmpty(importData.getStreet_now())){
			PatiAddrDO addrDO = new PatiAddrDO();
			addrDO.setId_pat(patId);
			addrDO.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			addrDO.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			AdminAreaDO adminArea = this.dataCache.getAdminArea(importData.getSd_adminarea_now(), importData.getStreet_now());
			if(adminArea != null){
				addrDO.setId_admdiv(adminArea.getId_adminarea());
				addrDO.setSd_admdiv(adminArea.getCode());
				addrDO.setZip(adminArea.getZipcode());
				
				String street = null;
				if(!StringUtil.isEmpty(importData.getStreet_now())){
					street = importData.getStreet_now().replaceAll(adminArea.getFullname(), "");
				}
				addrDO.setStreet(street);
				
				if(!StringUtil.isEmpty(param.getLocalcity()) && !StringUtil.isEmpty(adminArea.getFullname())){
					if(adminArea.getFullname().contains(param.getLocalcity())){
						patDO.setId_srcregiontp(IPiDictCodeConst.ID_SRCREGIONTP_LOCAL);
						patDO.setSd_srcregiontp(IPiDictCodeConst.SD_SRCREGIONTP_LOCAL);
					}else{
						patDO.setId_srcregiontp(IPiDictCodeConst.ID_SRCREGIONTP_OUTSIDE);
						patDO.setSd_srcregiontp(IPiDictCodeConst.SD_SRCREGIONTP_OUTSIDE);
					}
				}else{
					patDO.setId_srcregiontp(IPiDictCodeConst.ID_SRCREGIONTP_LOCAL);
					patDO.setSd_srcregiontp(IPiDictCodeConst.SD_SRCREGIONTP_LOCAL);
				}
			}else{
				patDO.setId_srcregiontp(IPiDictCodeConst.ID_SRCREGIONTP_LOCAL);
				patDO.setSd_srcregiontp(IPiDictCodeConst.SD_SRCREGIONTP_LOCAL);
				addrDO.setStreet(importData.getStreet_now());
			}
			
			addrDO.setSortno(patAddrList.size() + 1);
			addrDO.setStatus(DOStatus.NEW);
			patAddrList.add(addrDO);
		}
 		
 		if(!StringUtil.isEmpty(importData.getSd_adminarea_birth()) || !StringUtil.isEmpty(importData.getStreet_birth())){
			PatiAddrDO addrDO = new PatiAddrDO();
			addrDO.setId_pat(patId);
			addrDO.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_BORN);
			addrDO.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_BORN);
			AdminAreaDO adminArea = this.dataCache.getAdminArea(importData.getSd_adminarea_birth(), importData.getStreet_birth());
			if(adminArea != null){
				addrDO.setId_admdiv(adminArea.getId_adminarea());
				addrDO.setSd_admdiv(adminArea.getCode());
				addrDO.setZip(adminArea.getZipcode());
				
				String street = null;
				if(!StringUtil.isEmpty(importData.getStreet_birth())){
					street = importData.getStreet_birth().replaceAll(adminArea.getFullname(), "");
				}
				addrDO.setStreet(street);
			}else{
				addrDO.setStreet(importData.getStreet_birth());
			}
			
			addrDO.setSortno(patAddrList.size() + 1);
			addrDO.setStatus(DOStatus.NEW);
			patAddrList.add(addrDO);
		}
		
 		List<PiPatContDO> patContList = new ArrayList<PiPatContDO>();
		if(!StringUtil.isEmpty(importData.getName_cont())){
			
			PiPatContDO contDO = new PiPatContDO();
			contDO.setId_pat(patId);
			
			UdidocDO contUdidoc = this.dataCache.getContUdidoc(
					this.translator.translate(ImportConst.TRANSLATION_CONTTP, importData.getSd_conttp()));
			if(contUdidoc != null){
				contDO.setId_conttp(contUdidoc.getId_udidoc());
				contDO.setSd_conttp(contUdidoc.getCode());
			}
			
			contDO.setName(importData.getName_cont());
			contDO.setConttel(importData.getConttel());
			contDO.setSortno(1);
			contDO.setStatus(DOStatus.NEW);
			patContList.add(contDO);
		}
		
		List<PiPatCardDO> patCardList = new ArrayList<PiPatCardDO>();
		if(!StringUtil.isEmpty(importData.getCardcode())){
			
			PiPatCardDO patCardDO = new PiPatCardDO();
			patCardDO.setId_pat(patId);
			if(FBoolean.TRUE.equals(param.getPIPAT0027())){
				patCardDO.setId_card(patCardId);
			}
			PiPatCardTpDO cardTpDO = this.dataCache.getEntCardTpDO();
			if(cardTpDO != null){
				patCardDO.setId_patcardtp(cardTpDO.getId_cardtp());
				patCardDO.setSd_patcardtp(cardTpDO.getCode());
			}
			patCardDO.setCode(importData.getCardcode());
			patCardDO.setFg_def(FBoolean.FALSE);
			patCardDO.setDt_b(this.now);
			patCardDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
			patCardDO.setSortno(patCardList.size() + 1);
			patCardDO.setStatus(DOStatus.NEW);
			patCardList.add(patCardDO);
		}
 		
		if(!StringUtil.isEmpty(importData.getHealthno())){
			PiPatCardDO patCardDO = new PiPatCardDO();
			patCardDO.setId_pat(patId);
			PiPatCardTpDO cardTpDO = this.dataCache.getHealthCardTpDO();
			if(cardTpDO != null){
				patCardDO.setId_patcardtp(cardTpDO.getId_cardtp());
				patCardDO.setSd_patcardtp(cardTpDO.getCode());
			}
			patCardDO.setCode(importData.getHealthno());
			patCardDO.setFg_def(FBoolean.FALSE);
			patCardDO.setDt_b(this.now);
			patCardDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
			patCardDO.setSortno(patCardList.size() + 1);
			patCardDO.setStatus(DOStatus.NEW);
			patCardList.add(patCardDO);
		}
		
		aggDO.setParentDO(patDO);
		if(patAddrList.size() > 0){
			aggDO.setPatiAddrDO(patAddrList.toArray(new PatiAddrDO[0]));
		}
		if(patContList.size() > 0){
			aggDO.setPiPatContDO(patContList.toArray(new PiPatContDO[0]));
		}
		if(patCardList.size() > 0){
			aggDO.setPiPatCardDO(patCardList.toArray(new PiPatCardDO[0]));
		}
		
		if(this.piCusService != null){
			this.piCusService.assembleData(aggDO, importData);
		}
		
		return aggDO;
	}

	/**
	 * 组装预交金数据
	 * @param patId
	 * @param amt
	 * @param string
	 * @param blccKey
	 * @return
	 */
	private BlPrePayPatDO assemblePrepayData(String patId, FDouble amt, String codeRep, String blccKey) {
		
		BlPrePayPatDO prepayDO = new BlPrePayPatDO();
		prepayDO.setId_grp(Context.get().getGroupId());
		prepayDO.setId_org(Context.get().getOrgId());
		prepayDO.setId_pat(patId);
		prepayDO.setId_ent(null);
		
		prepayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY);
		prepayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
		prepayDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		prepayDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		prepayDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT);
		prepayDO.setCode_incca(IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT);
		prepayDO.setCode_rep(codeRep);	
		
		prepayDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		prepayDO.setAmt(amt);
		prepayDO.setId_pttp(IBlDictCodeConst.ID_PTTP_SYSTEM);
		prepayDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_SYSTEM);
		prepayDO.setId_pm("@@@@Z810000000021ZMQ");
		prepayDO.setSd_pm("96");
		prepayDO.setId_bank(null);
		prepayDO.setBankno(null);
		prepayDO.setPaymodenode(null);
		prepayDO.setDt_pay(now);
		prepayDO.setId_org_pay(Context.get().getOrgId());
		prepayDO.setId_dep_pay(Context.get().getDeptId());
		prepayDO.setId_emp_pay(Context.get().getStuffId());
		prepayDO.setFg_cc(FBoolean.TRUE);
		prepayDO.setId_cc(blccKey);
		prepayDO.setFg_rep_return(FBoolean.FALSE);
		prepayDO.setFg_canc(FBoolean.FALSE);
		prepayDO.setNote("旧系统导入");
		prepayDO.setCreatedby(Context.get().getUserId());
		prepayDO.setCreatedtime(now);
		prepayDO.setStatus(DOStatus.NEW);
		
		return prepayDO;
	}
	
	/**
	 * 组装预交金票据信息
	 * @param prepayDO
	 * @return
	 */
	private BlPrepayPatRcptDO assemblePrepayRcptData(BlPrePayPatDO prepayDO){
		
		BlPrepayPatRcptDO rcptDO = new BlPrepayPatRcptDO();
		rcptDO.setId_paypat(prepayDO.getId_paypat());
		rcptDO.setId_org(Context.get().getOrgId());
		rcptDO.setId_grp(Context.get().getGroupId());
		rcptDO.setId_pat(prepayDO.getId_pat());
		rcptDO.setId_ent(prepayDO.getId_ent());
		rcptDO.setId_entp(prepayDO.getId_enttp());
		rcptDO.setCode_entp(prepayDO.getCode_enttp());
		rcptDO.setId_incca(prepayDO.getId_incca());
		rcptDO.setCode_incpkg(blIncIssDO.getCode_incpkg());
		rcptDO.setCode_rep(prepayDO.getCode_rep());
		rcptDO.setDt_receipt(now);
		rcptDO.setId_emp_rcpt(Context.get().getStuffId());
		rcptDO.setId_emp_grp(Context.get().getGroupId());
		rcptDO.setId_emp_org(Context.get().getOrgId());
		rcptDO.setPrint_times(1);
		rcptDO.setFg_rep_return(FBoolean.FALSE);
		rcptDO.setFg_cc_rcpt(FBoolean.FALSE);
		rcptDO.setCreatedby(Context.get().getUserId());
		rcptDO.setCreatedtime(now);
		rcptDO.setStatus(DOStatus.NEW);
		return rcptDO;
	}
	
	/**
	 * 组装账户数据
	 * @param patId
	 * @param amt
	 * @return
	 */
	private PiPatAccDO assemblePatAccData(String patId){
		
		PiPatAccDO accDO = new PiPatAccDO();
		accDO.setId_pat(patId);
		accDO.setName("主账户");
		accDO.setCode("PRIMARY");
		accDO.setPrepay(FDouble.ZERO_DBL);
		accDO.setCred(FDouble.ZERO_DBL);
		accDO.setAcc_lock(FDouble.ZERO_DBL);
		accDO.setId_accsta(IPiDictCodeConst.ID_ACCSTA_NORMAL);
		accDO.setSd_accsta(IPiDictCodeConst.SD_ACCSTA_NORMAL);
		accDO.setFg_active(FBoolean.TRUE);
		accDO.setCreatedby(Context.get().getUserId());
		accDO.setCreatedtime(now);
		accDO.setStatus(DOStatus.NEW);
		
		return accDO;
	}
	
	/**
	 * 组装就诊卡数据
	 * @param patId
	 * @param cardId
	 * @param cardCode
	 * @param param
	 * @return
	 */
	private PiPatCardDO assemblePatCardData(String patId, String cardId,String cardCode, ImportParam param){
		PiPatCardDO patCardDO = new PiPatCardDO();
		patCardDO.setId_pat(patId);
		if(FBoolean.TRUE.equals(param.getPIPAT0027())){
			patCardDO.setId_card(cardId);
		}
		PiPatCardTpDO cardTpDO = this.dataCache.getEntCardTpDO();
		if(cardTpDO != null){
			patCardDO.setId_patcardtp(cardTpDO.getId_cardtp());
			patCardDO.setSd_patcardtp(cardTpDO.getCode());
		}
		patCardDO.setCode(cardCode);
		patCardDO.setFg_def(FBoolean.FALSE);
		patCardDO.setDt_b(this.now);
		patCardDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
		patCardDO.setSortno(0);
		patCardDO.setStatus(DOStatus.NEW);

		return patCardDO;
	}
	
	/**
	 * 组装卡数据
	 * @param code
	 * @return
	 */
	private PiCardDO assembleCardData(String cardId,String code){
		
		PiCardDO cardDO = new PiCardDO();
		cardDO.setId_card(cardId);
		cardDO.setId_grp(Context.get().getGroupId());
		cardDO.setId_org(Context.get().getOrgId());
		
		PiPatCardTpDO cardTpDO = this.dataCache.getEntCardTpDO();
		if(cardTpDO != null){
			cardDO.setId_patcardtp(cardTpDO.getId_cardtp());
		}
		cardDO.setCode(StringUtils.full2Half(code));
		cardDO.setEu_cardsu(CardSuEnum.USING);
		cardDO.setId_emp_entry(Context.get().getStuffId());
		cardDO.setDt_entry(now);
		cardDO.setFg_get(FBoolean.TRUE);
		cardDO.setId_emp_get(Context.get().getStuffId());
		cardDO.setDt_get(now);
		cardDO.setFg_canc(FBoolean.FALSE);
		cardDO.setCreatedby(Context.get().getUserId());
		cardDO.setCreatedtime(now);
		cardDO.setStatus(DOStatus.NEW);
		return cardDO;
	}
	
	/**
	 * 组装结账数据
	 * @param blccKey
	 * @param amt
	 * @return
	 */
	private BlCcDO assembleBlccData(String blccKey, FDouble amt) {
		
		BlCcDO ccDO = new BlCcDO();
		ccDO.setId_grp(Context.get().getGroupId());
		ccDO.setId_org(Context.get().getOrgId());
		ccDO.setId_cctp(IBlDictCodeConst.SD_CCTP_ID_MZLC);
		ccDO.setSd_cctp(IBlDictCodeConst.SD_CCTP_MZLC);
		ccDO.setId_emp(Context.get().getStuffId());
		ccDO.setDt_b(now);
		ccDO.setDt_e(now);
		ccDO.setAmt(amt);
		ccDO.setAmt_return(FDouble.ZERO_DBL);
		ccDO.setInccn(0);
		ccDO.setInccn_re(0);
		ccDO.setInccn_canc(0);
		ccDO.setChqcn(0);
		ccDO.setFg_canc(FBoolean.FALSE);
		ccDO.setAmt_st(FDouble.ZERO_DBL);
		ccDO.setAmt_st_ret(FDouble.ZERO_DBL);
		ccDO.setAmt_pvprepay(FDouble.ZERO_DBL);
		ccDO.setAmt_pvprepay_ret(FDouble.ZERO_DBL);
		ccDO.setAmt_entprepay(amt);
		ccDO.setAmt_entprepay_ret(FDouble.ZERO_DBL);
		ccDO.setInccn_pvprepay(0);
		ccDO.setInccn_pvprepay_ret(0);
		ccDO.setDt_cc(now);
		ccDO.setFg_fi(FBoolean.FALSE);
		ccDO.setCreatedby(Context.get().getUserId());
		ccDO.setCreatedtime(now);
		
		ccDO.setStatus(DOStatus.NEW);
		return ccDO;
	}
	
	/**
	 * 组装结账收付款数据
	 * @param blccKey
	 * @param amt
	 * @param size
	 * @return
	 */
	private BlCcPmDO assembleBlccPmData(String blccKey, FDouble amt, int size) {
		
		BlCcPmDO ccpmDO = new BlCcPmDO();
		ccpmDO.setId_grp(Context.get().getGroupId());
		ccpmDO.setId_org(Context.get().getOrgId());
		ccpmDO.setId_cc(blccKey);
		ccpmDO.setId_pm("@@@@Z810000000021ZMQ");
		ccpmDO.setAmt(amt);
		ccpmDO.setCn_amt(size);
		ccpmDO.setAmt_return(FDouble.ZERO_DBL);
		ccpmDO.setCn_amtreturn(0);
		ccpmDO.setStatus(DOStatus.NEW);
		return ccpmDO;
	}
	
	/**
	 * 处理数据
	 * @param patList
	 * @param patAddrList
	 * @param patContList
	 * @param patCardList
	 * @param cardList
	 * @param prepayList
	 * @param prepayRcptList
	 * @param accList
	 * @param updateAccSqlList
	 * @param incUse
	 * @throws BizException
	 */
	private void processData(List<PatDO> patList, List<PatiAddrDO> patAddrList,
			List<PiPatContDO> patContList, List<PiPatCardDO> patCardList, 
			List<PiCardDO> cardList, List<BlPrePayPatDO> prepayList,
			List<BlPrepayPatRcptDO> prepayRcptList, List<PiPatAccDO> accList, 
			List<String> updateAccSqlList, int incUse, String[] invoiceNos,
			BlCcDO ccDO, BlCcPmDO ccPmDO)
			throws BizException {

		final List<PatDO> patListF = patList;
		final List<PatiAddrDO> patAddrListF = patAddrList;
		final List<PiPatContDO> patContListF = patContList;
		final List<PiPatCardDO> patCardListF = patCardList;
		final List<PiCardDO> cardListF = cardList;
		final List<BlPrePayPatDO> prepayListF = prepayList;
		final List<BlPrepayPatRcptDO> prepayRcptListF = prepayRcptList;
		final List<PiPatAccDO> accListF = accList;
		final List<String> updateAccSqlListF = updateAccSqlList;
		final int incUseF = incUse;
		final String[] invoiceNosF = invoiceNos;
		final BlCcDO ccDOF = ccDO;
		final BlCcPmDO ccPmDOF = ccPmDO;
		final BlIncIssDO blIncIssDOF = this.blIncIssDO;
		
		TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@Override
			public String doInTransaction(TransactionStatus arg0) throws InvocationTargetException {
					
					try {
						DAFacade daf = new DAFacade();
						if(patListF.size() > 0){
							daf.insertDOArrayWithPK(patListF.toArray(new PatDO[0]));
						}
						if(patAddrListF.size() > 0){
							daf.insertDOs(patAddrListF.toArray(new PatiAddrDO[0]));
						}
						if(patContListF.size() > 0){
							daf.insertDOs(patContListF.toArray(new PiPatContDO[0]));
						}
						if(patCardListF.size() > 0){
							daf.insertDOs(patCardListF.toArray(new PiPatCardDO[0]));
						}
						if(cardListF.size() > 0){
							daf.insertDOArrayWithPK(cardListF.toArray(new PiCardDO[0]));
						}
						if(prepayListF.size() > 0){
							daf.insertDOArrayWithPK(prepayListF.toArray(new BlPrePayPatDO[0]));
						}
						if(prepayRcptListF.size() > 0){
							daf.insertDOs(prepayRcptListF.toArray(new BlPrepayPatRcptDO[0]));
						}
						if(accListF.size() > 0){
							daf.insertDOs(accListF.toArray(new PiPatAccDO[0]));
						}
						if(updateAccSqlListF.size() > 0){
							
							AbstractPersistMgr manager = null;
							try {
								manager = PersistMgr.getInstance("design");
								PersistSession session = manager.getPersistSession();
								for (String sql : updateAccSqlListF) {
									session.addBatch(sql);
								}
								session.execBatch();
							} catch (DbException e) {
								throw e;
							}finally{
								if(manager != null){
									manager.release();
								}
							}
						}
						if(ccDOF != null){
							daf.insertDOWithPK(ccDOF);
						}
						if(ccPmDOF != null){
							daf.insertDO(ccPmDOF);
						}
						if(incUseF > 0){
							IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
							incService.nextInvoiceNoByNo(blIncIssDOF, invoiceNosF[incUseF - 1]);
						}
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
					return null;
				}
			});
		
	}
	
	/**
	 * 导入类常量
	 */
	private interface ImportConst{
		
		public static final String IMPORT_FLAG = "import";//导入标志
		
		public static final Integer MAXNUM = 10000; //最大单次处理条数
		
		public static final String PARAM_DBSOURCE = "datasource";//第三方数据源
		
		public static final String PARAM_PATVIEW = "patview";//第三方视图名
		
		public static final String PARAM_PSN = "psnid";//导入操作人员
	
		public static final String PARAM_FGCC = "fgcc";//是否自动结账
		
		public static final String PARAM_BEGININDEX = "beginindex";//起始索引号
		
		public static final String PARAM_ENDINDEX = "endindex";//终止索引号
		
		public static final String PARAM_PATCARDID = "patcardid";//导入就诊卡类型id
		
		public static final String PARAM_HEALTHCARDID = "healthcardid";//导入健康卡类型id
		
		public static final String PARAM_FGUSETRANSLATE = "fgusetranslate";//是否使用编码转译
		
		public static final String PARAM_FGCHECKEXISTED = "fgcheckexisted";//校验已经存在的患者
		
		public static final String PARAM_FGDEALAMTONLY = "fgdealamtonly";//是否只处理余额
		
		public static final String PARAM_LOCALCITY = "localcity";//本埠市名
		
		public static final String TRANSLATION_SEX = "01";// 第三方转译性别

		public static final String TRANSLATION_MARRY = "02";// 第三方转译婚姻

		public static final String TRANSLATION_COUNTRY = "03";// 第三方转译国籍

		public static final String TRANSLATION_NATION = "04";// 第三方转译民族

		public static final String TRANSLATION_IDTP = "05";// 第三方转译证件类型
		
		public static final String TRANSLATION_CONTTP = "06";// 第三方转译联系人关系
		
		public static final String  UPDATEACCSQL = "update pi_pat_acc set prepay = prepay + %s where id_pat = '%s' and code = 'PRIMARY'";
	}
	
	/**
	 * 导入参数
	 *
	 */
	private class ImportParam{
		
		private String dataSource;
		
		private String patView;
		
		private FBoolean fgcc;
		
		private Integer beginIndex;
		
		private Integer endIndex;
		
		private String patCardId;
		
		private String healthCardId;
		
		private FBoolean fgusetranslate;
		
		private FBoolean fgcheckexisted;

		private FBoolean fgdealamtonly;
		
		private String localcity;
		
		private FBoolean PIPAT0027;

		public void LoadAnCheckParam(Map<String, Object> paramMap) throws BizException {
			
			String _dataSource = (String)paramMap.get(ImportConst.PARAM_DBSOURCE);
			String _patView = (String)paramMap.get(ImportConst.PARAM_PATVIEW);
			String _fgcc = (String)paramMap.get(ImportConst.PARAM_FGCC);
			String _beginindex = (String)paramMap.get(ImportConst.PARAM_BEGININDEX);
			String _endindex = (String)paramMap.get(ImportConst.PARAM_ENDINDEX);
			String _patcardid = (String)paramMap.get(ImportConst.PARAM_PATCARDID);
			String _healthcardid = (String)paramMap.get(ImportConst.PARAM_HEALTHCARDID);
			String _fgusetranslate = (String)paramMap.get(ImportConst.PARAM_FGUSETRANSLATE);
			String _fgcheckexisted = (String)paramMap.get(ImportConst.PARAM_FGCHECKEXISTED);
			String _fgdealamtonly = (String)paramMap.get(ImportConst.PARAM_FGDEALAMTONLY);
			String _localcity = (String)paramMap.get(ImportConst.PARAM_LOCALCITY);
			
			if(StringUtil.isEmpty(_dataSource) ){
				throw new BizException("未定义导入第三方数据源");
			}
			
			if(StringUtil.isEmpty(_patView) ){
				throw new BizException("未定义导入第三方患者视图");
			}
			
			this.dataSource = _dataSource;
			this.patView = _patView;
			if(StringUtil.isEmpty(_fgcc)){
				this.fgcc = FBoolean.TRUE;
			}else{
				this.fgcc = new FBoolean(_fgcc);
			}
			if(StringUtil.isEmpty(_beginindex)){
				this.beginIndex = 1;
			}else{
				try {
					this.beginIndex = Integer.parseInt(_beginindex);
				} catch (NumberFormatException e) {
					this.beginIndex = 1;
				}
			}
			if(StringUtil.isEmpty(_endindex)){
				this.endIndex = 0;
			}else{
				try {
					this.endIndex = Integer.parseInt(_endindex);
				} catch (NumberFormatException e) {
					this.endIndex = 0;
				}
			}
			this.patCardId = _patcardid;
			this.healthCardId = _healthcardid;
			if(StringUtil.isEmpty(_fgusetranslate)){
				this.fgusetranslate = FBoolean.FALSE;
			}else{
				this.fgusetranslate = new FBoolean(_fgusetranslate);
			}
			if(StringUtil.isEmpty(_fgcheckexisted)){
				this.fgcheckexisted = FBoolean.FALSE;
			}else{
				this.fgcheckexisted = new FBoolean(_fgcheckexisted);
			}
			if(StringUtil.isEmpty(_fgdealamtonly)){
				this.fgdealamtonly = FBoolean.FALSE;
			}else{
				this.fgdealamtonly = new FBoolean(_fgdealamtonly);
			}
			this.localcity = _localcity;
			PiParams piParams = new PiParams();
			this.PIPAT0027 = piParams.PIPAT0027();
		}

		public String getDataSource() {
			return dataSource;
		}

		public String getPatView() {
			return patView;
		}
		
		public FBoolean getFgcc() {
			return fgcc;
		}

		public Integer getBeginIndex() {
			return beginIndex;
		}

		public Integer getEndIndex() {
			return endIndex;
		}

		public String getPatCardId() {
			return patCardId;
		}

		public String getHealthCardId() {
			return healthCardId;
		}
		
		public FBoolean getFgusetranslate() {
			return fgusetranslate;
		}

		public FBoolean getFgcheckexisted() {
			return fgcheckexisted;
		}

		public FBoolean getFgdealamtonly() {
			return fgdealamtonly;
		}
		
		public String getLocalcity() {
			return localcity;
		}
		
		public FBoolean getPIPAT0027() {
			return PIPAT0027;
		}
	}
	
	/**
	 * 数据缓存
	 */
 	private class DataCache{
		
		private PiPatCaDO dftPatCa;
		
		private PiPatCardTpDO[] cardTpDos;
		
		private PiPatCardTpDO entCardTpDO;
		
		private PiPatCardTpDO healthCardTpDO;

		private CountryZoneDO dftCountry;

		private Map<String, CountryZoneDO> countryMap;
		
		private Map<String, UdidocDO> idtpUdidocMap;
		
		private Map<String, UdidocDO> sexUdidocMap;

		private Map<String, UdidocDO> nationUdidocMap;

		private Map<String, UdidocDO> marryUdidocMap;
		
		private Map<String, UdidocDO> contUdidocMap;

		private Map<String, AdminAreaDO> adminAreaMap;
		
		private Map<String, List<AdminAreaDO>> adminAreaGroupMap;//按全程前两位分组-->比如江西

		private IUdidocServiceExt udiService;
		
		public DataCache() throws BizException {
			this.udiService = ServiceFinder.find(IUdidocServiceExt.class);
			this.countryMap = new HashMap<String,CountryZoneDO>();
			this.idtpUdidocMap = new HashMap<String, UdidocDO>();
			this.sexUdidocMap = new HashMap<String, UdidocDO>();
			this.nationUdidocMap = new HashMap<String, UdidocDO>();
			this.marryUdidocMap = new HashMap<String, UdidocDO>();
			this.contUdidocMap = new HashMap<String, UdidocDO>();
			this.adminAreaMap = new HashMap<String, AdminAreaDO>();
			this.adminAreaGroupMap = new HashMap<String, List<AdminAreaDO>>();

			this.loadDtfPatCa();
			this.loadPatCardTp();
			this.loadIdtpDoc();
			this.loadSexDoc();
			this.loadNationDoc();
			this.loadMarryDoc();
			this.loadContDoc();
			this.loadCountry();
			this.loadAdminArea();
		}

		public void LoadOtherData(ImportParam param) throws BizException {
		
			if(!ArrayUtil.isEmpty(cardTpDos)){
				
				for (PiPatCardTpDO piPatCardTpDO : cardTpDos) {
					if(!StringUtil.isEmpty(param.getPatCardId()) && 
							param.getPatCardId().equals(piPatCardTpDO.getId_cardtp())){
						this.entCardTpDO = piPatCardTpDO;
					}
					if(!StringUtil.isEmpty(param.getHealthCardId()) && 
							param.getHealthCardId().equals(piPatCardTpDO.getId_cardtp())){
						this.healthCardTpDO = piPatCardTpDO;
					}
				}
				
				if(this.entCardTpDO == null){
					for (PiPatCardTpDO piPatCardTpDO : cardTpDos) {
						if(IPiDictCodeConst.SD_CARD_TYPE_TREATMENT.equals(piPatCardTpDO.getSd_patcardtp())){
							this.entCardTpDO = piPatCardTpDO;
							break;
						}
					}
				}
				
				if(this.healthCardTpDO == null){
					for (PiPatCardTpDO piPatCardTpDO : cardTpDos) {
						if(IPiDictCodeConst.SD_CARD_TYPE_HEALTH.equals(piPatCardTpDO.getSd_patcardtp())){
							this.healthCardTpDO = piPatCardTpDO;
							break;
						}
					}
				}
			}
		}

		public PiPatCaDO getDftPatCa() {
			return dftPatCa;
		}
		
		public PiPatCardTpDO getEntCardTpDO() {
			return entCardTpDO;
		}

		public PiPatCardTpDO getHealthCardTpDO() {
			return healthCardTpDO;
		}
		
		public CountryZoneDO getCountry(String code) {
			if(StringUtil.isEmpty(code))
				return this.dftCountry;
			
			if(this.countryMap.containsKey(code.toUpperCase())){
				return this.countryMap.get(code.toUpperCase());
			}
			
			return this.dftCountry;
		}

		public UdidocDO getIdtpUdidoc(String code){
			if (StringUtil.isEmpty(code))
				return null;
			return this.idtpUdidocMap.get(code);
		}
		
		public UdidocDO getSexUdidoc(String code) {
			if (StringUtil.isEmpty(code))
				return null;
			return this.sexUdidocMap.get(code);
		}

		public UdidocDO getNationUdidoc(String code) {
			if (StringUtil.isEmpty(code))
				return null;
			return this.nationUdidocMap.get(code);
		}

		public UdidocDO getMarryUdidoc(String code) {
			if (StringUtil.isEmpty(code))
				return null;
			return this.marryUdidocMap.get(code);
		}

		public UdidocDO getContUdidoc(String code) {
			if(StringUtil.isEmpty(code))
				return null;
			
			return this.contUdidocMap.get(code);
		}
		
		public AdminAreaDO getAdminArea(String code, String street){
			if(!StringUtil.isEmpty(code)){
				AdminAreaDO areaDO = this.adminAreaMap.get(code);
				if(areaDO != null){
					return areaDO;
				}
			}
			
			if(!StringUtil.isEmpty(street) && street.length() > 1){
				
				AdminAreaDO hitAreaDO = null;
				String key = street.substring(0, 2);
				List<AdminAreaDO> grpAreaList = this.adminAreaGroupMap.get(key);
				if(!ListUtil.isEmpty(grpAreaList)){
				
					for (AdminAreaDO adminAreaDO : grpAreaList) {
						if(street.startsWith(adminAreaDO.getFullname())){
							
							if(hitAreaDO == null){
								hitAreaDO = adminAreaDO;
							}else if(adminAreaDO.getFullname().length() > hitAreaDO.getFullname().length()){
								hitAreaDO = adminAreaDO;
							}
						}
					}
				}
				
				return hitAreaDO;
			}
			
			return null;
		}

		@SuppressWarnings("unchecked")
		private void loadDtfPatCa() throws BizException {
			DAFacade daf = new DAFacade();
			List<PiPatCaDO> patCaList = (List<PiPatCaDO>) daf.findByCond(PiPatCaDO.class, "fg_def='Y'");
			if (ListUtil.isEmpty(patCaList)) {
				throw new BizException("默认患者分类未维护");
			}
			this.dftPatCa = patCaList.get(0);
		}
		
		@SuppressWarnings("unchecked")
		private void loadPatCardTp() throws BizException {
			DAFacade daf = new DAFacade();
			List<PiPatCardTpDO> patCardTpList = (List<PiPatCardTpDO>)daf.findByCond(PiPatCardTpDO.class, "1=1");
			if(!ListUtil.isEmpty(patCardTpList)){
				cardTpDos = patCardTpList.toArray(new PiPatCardTpDO[0]);
			}
		}
		
		private void loadIdtpDoc() throws BizException {
			UdidocDO[] docDos = udiService.findByUdidoclistCode(IPiDictCodeTypeConst.SD_IDTP);
			if (!ArrayUtil.isEmpty(docDos)) {
				for (UdidocDO udidocDO : docDos) {
					idtpUdidocMap.put(udidocDO.getCode(), udidocDO);
				}
			}
		}
		
		private void loadSexDoc() throws BizException {
			UdidocDO[] docDos = udiService.findByUdidoclistCode(IPiDictCodeTypeConst.SD_SEX_CODE);
			if (!ArrayUtil.isEmpty(docDos)) {
				for (UdidocDO udidocDO : docDos) {
					sexUdidocMap.put(udidocDO.getCode(), udidocDO);
				}
			}
		}

		private void loadNationDoc() throws BizException {
			UdidocDO[] docDos = udiService.findByUdidoclistCode(IPiDictCodeTypeConst.SD_NATION);
			if (!ArrayUtil.isEmpty(docDos)) {
				for (UdidocDO udidocDO : docDos) {
					nationUdidocMap.put(udidocDO.getCode(), udidocDO);
				}
			}
		}

		private void loadMarryDoc() throws BizException {
			UdidocDO[] docDos = udiService.findByUdidoclistCode(IPiDictCodeTypeConst.SD_MARRY);
			if (!ArrayUtil.isEmpty(docDos)) {
				for (UdidocDO udidocDO : docDos) {
					marryUdidocMap.put(udidocDO.getCode(), udidocDO);
				}
			}
		}

		private void loadContDoc() throws BizException {
			UdidocDO[] docDos = udiService.findByUdidoclistCode(IPiDictCodeTypeConst.SD_CONTTP);
			if (!ArrayUtil.isEmpty(docDos)) {
				for (UdidocDO udidocDO : docDos) {
					contUdidocMap.put(udidocDO.getCode(), udidocDO);
				}
			}
		}
		
		private void loadCountry() throws BizException {
			
			ICountryzoneRService countrySrv = ServiceFinder.find(ICountryzoneRService.class);
			CountryZoneDO[] czones = countrySrv.find("1=1", "", FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(czones)){
				for (CountryZoneDO countryZoneDO : czones) {
					this.countryMap.put(countryZoneDO.getCode().toUpperCase(), countryZoneDO);
					if(IPiPatConst.CHINA_CODE.equals(countryZoneDO.getCode().toUpperCase())){
						this.dftCountry = countryZoneDO;
					}
				}
			}
		}
	
		private void loadAdminArea() throws BizException {
			IAdminareaRService adminService = ServiceFinder.find(IAdminareaRService.class);
			AdminAreaDO[] adminDos = adminService.find("activestate=2", null, FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(adminDos)){
				for (AdminAreaDO adminAreaDO : adminDos) {
					this.adminAreaMap.put(adminAreaDO.getCode(), adminAreaDO);
					
					if (StringUtil.isEmpty(adminAreaDO.getFullname()) || adminAreaDO.getFullname().length() < 2)
						continue;
					
					String key = adminAreaDO.getFullname().substring(0, 2);
					List<AdminAreaDO> adminAreaGroupList = null;
					if(this.adminAreaGroupMap.containsKey(key)){
						adminAreaGroupList = this.adminAreaGroupMap.get(key);
					}else{
						adminAreaGroupList = new ArrayList<AdminAreaDO>();
						this.adminAreaGroupMap.put(key, adminAreaGroupList);
					}
					adminAreaGroupList.add(adminAreaDO);
				}
			}
		}
	}

 	/**
 	 * 翻译器
 	 *
 	 */
 	private class Translator{
 		
 		private FBoolean useTrans;
 		
 		public Translator(FBoolean useTrans)throws BizException {
 			this.useTrans = useTrans;
 		}
 		
 		public String translate(String type,String code){
 			
 			if(StringUtil.isEmpty(code) || FBoolean.FALSE.equals(useTrans)){
 				return code;
 			}
 			return code;
 		}
 	}
 	
 	/**
 	 * 重复数据校验器
 	 */
 	private class RepeatValidator{
 		
 		private Map<String, String> uniquePatMap0;//患者编码
 		private Map<String, String> uniquePatMap1;//身份证唯一map
 		private Map<String, String> uniquePatMap2;//姓名，出生日期，手机号唯一map
 		
 		public RepeatValidator(FBoolean fgCheckExist, FBoolean dealAmtOnly) throws BizException{
 			
 			this.uniquePatMap0 = new HashMap<String,String>();
 			this.uniquePatMap1 = new HashMap<String,String>();
 			this.uniquePatMap2 = new HashMap<String,String>();
 	 		
 			if(FBoolean.TRUE.equals(fgCheckExist) || FBoolean.TRUE.equals(dealAmtOnly)){
 				this.loadExistPat();
 			}
 		}
 		
 		public String getRepeatIdByCode(PiImportFromThirdDBDTO data){
 			
 			String patId = null;
 			
 			patId = this.uniquePatMap0.get(data.getPatientid());
 			if(!StringUtil.isEmpty(patId)){
 				return patId;
 			}
 				
 			return patId;
 		}
 		
 		public String getRepeatId(PiImportFromThirdDBDTO data,String patIdNew){
 			
 			String patId = null;
 			
 			patId = this.uniquePatMap0.get(data.getPatientid());
 			if(!StringUtil.isEmpty(patId)){
 				return patId;
 			}
 			
 			if(!StringUtil.isEmpty(data.getId_code()) && IPiDictCodeConst.SD_IDTP_IDENTITY.equals(data.getSd_idtp())){
 				patId = this.uniquePatMap1.get(data.getId_code());
				if(!StringUtil.isEmpty(patId)){
	 				return patId;
	 			}
 			}
 			
 			if (!StringUtil.isEmpty(data.getName()) && data.getDt_birth() != null && !StringUtil.isEmpty(data.getMob())) {
 				String key = data.getName() + data.getDt_birth().toString() + data.getMob();
 				patId = this.uniquePatMap2.get(key);
 				if(!StringUtil.isEmpty(patId)){
 	 				return patId;
 	 			}
 			}
 			
 			this.uniquePatMap0.put(data.getPatientid(), patIdNew);
 			if(!StringUtil.isEmpty(data.getId_code()) && IPiDictCodeConst.SD_IDTP_IDENTITY.equals(data.getSd_idtp())){
 				 this.uniquePatMap1.put(data.getId_code(), patIdNew);
 			}
 			if (!StringUtil.isEmpty(data.getName()) && data.getDt_birth() != null && !StringUtil.isEmpty(data.getMob())) {
 				String key = data.getName() + data.getDt_birth().toString() + data.getMob();
 				this.uniquePatMap2.put(key, patIdNew);
 			}
 			
 			return patId;
 		}
 		
 		@SuppressWarnings("unchecked")
		private void loadExistPat() throws BizException{
 		
 			DAFacade daf = new DAFacade();
 			
 			String baseSql = "select /*+index_desc(pi_pat,(code))*/ id_pat,code,name,sd_idtp,id_code,dt_birth,mob from pi_pat ";
 			
			String countSql = "select count(1) from (" + baseSql + ") pat ";
 			
 			Object countObj = (Object)daf.execQuery(countSql, new ColumnHandler());
 			Integer count = 0;
 			if (countObj != null) {
 				count = Integer.parseInt(countObj.toString());
 			}
			
 			if(count == 0)
 				return;
 			
 			int page = count / ImportConst.MAXNUM;
 			if(count % ImportConst.MAXNUM != 0){
 				page ++;
 			}
 			
 			String qrySql = "select * from (select row_.*, rownum rownum_ from ( " + baseSql + " where code is not null order by code ) row_ where rownum <= ?) where rownum_ >= ?";
 			
 			for (int i = 0; i < page; i++) {
 				int b = 1 + i * ImportConst.MAXNUM;
 				int e = b + ImportConst.MAXNUM - 1;
 				e = e > count ? count : e;
 				
 				SqlParam param = new SqlParam();
 				param.addParam(e);
 				param.addParam(b);
 				List<PatDO> result = (List<PatDO>)daf.execQuery(qrySql, param, new BeanListHandler(PatDO.class));
 				
 				if(!ListUtil.isEmpty(result)){
 					for (PatDO patDO : result) {
 						this.uniquePatMap0.put(patDO.getCode(), patDO.getId_pat());
 			 			if(!StringUtil.isEmpty(patDO.getId_code()) && IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDO.getSd_idtp())){
 			 				this.uniquePatMap1.put(patDO.getId_code(), patDO.getId_pat());
 			 			}
 			 			if (!StringUtil.isEmpty(patDO.getName()) && patDO.getDt_birth() != null && !StringUtil.isEmpty(patDO.getMob())) {
 			 				String key = patDO.getName() + patDO.getDt_birth().toString() + patDO.getMob();
 			 				this.uniquePatMap2.put(key, patDO.getId_pat());
 			 			}
					}
 				}
 			}
 		}
 	}
}
