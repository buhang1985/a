package iih.pi.reg.pat.s.impt;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
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
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.desc.PatDODesc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.AbstractPersistMgr;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;

/**
 * 老系统患者导入类(非单一性表导入，借用患者DO承载数据)
 * 含患者信息，卡信息，预交金信息
 * 流程：新建患者-->卡入库-->领用-->发放-->充值-->结账
 * 上下文人员:IIH系统管理员,需要领用预交金票据
 * @author ly 2019/02/27
 *
 */
public class PiPatImportWithMoneyServiceImpl extends BaseDataImport<PatDO> implements IDataImport {

	//导入患者标识
	private static final String IMPORTPATFLAG = "import";
	
	//单次处理数据条数
	private static final Integer PAGE_SIZE = 10000;
	
	private FDateTime now = null;
	
	private Map<String,PiPatCaDO> patcaMap;//患者分类
	
	private PiPatCardTpDO patCardTpDO;//患者卡类型
	
	private BlIncIssDO blIncIssDO;//预交金票据信息
	
	Map<String,String> uniquePatMap1 = new HashMap<String,String>();//身份证唯一map
	Map<String,String> uniquePatMap2 = new HashMap<String,String>();//姓名，出生日期，手机号唯一map
	
	@Override
	public boolean checkBusiness() throws BizException {
		return true;
	}
	
	@Override
	public boolean checkNotNull() throws BizException {
		
		PatDO[] dos = getDOsFromImportDB(new PatDO(), "(name is null or def2 is null)", false);
		if (!ArrayUtil.isEmpty(dos)) {
			String msg = null;
			if(StringUtil.isEmpty(dos[0].getName())){
				msg = "患者信息中的名称不允许为空。";
			}else if(StringUtil.isEmpty(dos[0].getDef2())){
				msg = "患者信息中的金额不能为空，列:DEF2。";
			}
			throw new BizException(msg);
		}
		
		return true;
	}

	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		
		String subSql = "(select id_pat from pi_pat where def1 = '" + IMPORTPATFLAG + "')";
		String subSql2 = "(select id_card from pi_pat_card where id_pat in " + subSql + " )";
		
		/*daFacade.execUpdate("delete from pi_pat_acc_act where id_patacc in (select id_patacc from pi_pat_acc where id_pat in "
				+ subSql + " ) ");*/// 删除患者账户操作明细
		daFacade.execUpdate("delete from pi_pat_acc where id_pat in " + subSql);// 删除患者账户
		daFacade.execUpdate("delete from bl_prepay_pat where id_pat in " + subSql);//删除患者预交金
		daFacade.execUpdate("delete from bl_prepay_pat_rcpt where id_pat in " + subSql);//删除患者预交金票据
		
		daFacade.execUpdate("delete from pi_card where where id_card in " + subSql2 + " ");//删除卡数据
		
		daFacade.execUpdate("delete from pi_pat_card where id_pat in " + subSql);//删除患者卡信息
		daFacade.execUpdate("delete from pi_pat where id_pat in " + subSql);// 删除患者数据
		
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[]{"pi_pat"};
	}

	@Override
	public boolean importData() throws BizException {
		
		// 1.取得数据分页信息
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setPageSize(PAGE_SIZE);
		paginationInfo.setPageIndex(0);
		PagingRtnData<PatDO> pageData = getDOsFromImportDBByPageInfo(new PatDO(), paginationInfo, "1=1", true);
		if (pageData.getPageData() == null || pageData.getPageData().size() <= 0)
			throw new BizException("患者信息导入数据为空！");

		PiParams piParam = new PiParams();
		String set = piParam.PIPAT9999();
		if(StringUtil.isEmpty(set)){
			throw new BizException("患者信息导入配置为空,请配置参数PIPAT9999");
		}
		
		String[] params = set.split(",");
		if(params.length < 6){
			throw new BizException("患者信息导入配置不正确,请配置参数PIPAT9999");
		}
		
		//设置上下文
		Context.get().setGroupId(params[0]);
		Context.get().setGroupNumber(params[1]);
		Context.get().setOrgId(params[2]);
		Context.get().setUserId(params[3]);
		Context.get().setStuffId(params[4]);
		
		now = new FDateTime();
		
		DAFacade daf = new DAFacade();
		
		//准备患者分类数据
		patcaMap = new HashMap<String, PiPatCaDO>();
		String sql = "select * from pi_pat_ca ";
		@SuppressWarnings("unchecked")
		List<PiPatCaDO> patcaList = (List<PiPatCaDO>)daf.execQuery(sql, new BeanListHandler(PiPatCaDO.class));
		for (PiPatCaDO piPatCaDO : patcaList) {
			patcaMap.put(piPatCaDO.getCode(), piPatCaDO);
		}
		
		//准备患者卡类型数据
		String sql2 = String.format("select * from pi_pat_cardtp where code = '%s' ", params[5]);
		patCardTpDO = (PiPatCardTpDO)daf.execQuery(sql2, new BeanHandler(PiPatCardTpDO.class));
		if(patCardTpDO == null){
			throw new BizException(String.format("没有配置免费的就诊卡类型-->编码%s", params[5]));
		}
		
		for (int i = 0; i < pageData.getPagingInfo().getPageCount(); i++) {

			paginationInfo.setPageSize(PAGE_SIZE);
			paginationInfo.setPageIndex(i);
			pageData = getDOsFromImportDBByPageInfo(new PatDO(), paginationInfo, "1=1", true);
			List<PatDO> patList = new ArrayList<PatDO>();
			for (Object obj : pageData.getPageData()) {

				patList.add((PatDO) obj);
			}

			this.processData(patList);
		}
		
		return true;
	}
	
	/**
	 * 处理数据
	 * @param patList
	 */
	private void processData(List<PatDO> patList) throws BizException{
		
		//主键
		String[] cardKeys = new DBUtil().getOIDs(patList.size());
		String[] patKeys = new DBUtil().getOIDs(patList.size());
		String[] prepayKeys = new DBUtil().getOIDs(patList.size());
		String blccKey = new DBUtil().getOIDs(1)[0];
		
		//患者编码
		IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
		String[] patCodes = billcodeManage.getBatchBillCodes_RequiresNew(PatDODesc.CLASS_FULLNAME, new PatDO(), patList.size());
		//预交金票据号-每次导入时重新获取当前票据数据
		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		blIncIssDO = incService.getCurInvoiceDO(Context.get().getStuffId(), null, IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT);
		if(blIncIssDO == null){
			throw new BizException("门诊预交金票据信息获取失败");
		}
		String[] invoiceNos = incService.getCurInvoiceNoMany(Context.get().getStuffId(), null, IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT, patList.size());
		
		List<PiCardDO> cardList  = new ArrayList<PiCardDO>();//卡数据
		List<PatDO> patNewList = new ArrayList<PatDO>();//患者数据
		List<PiPatCardDO> patcardList = new ArrayList<PiPatCardDO>();//患者卡数据
		List<BlPrePayPatDO> prepayList = new ArrayList<BlPrePayPatDO>();//预交金数据
		List<BlPrepayPatRcptDO> prepayRcptList = new ArrayList<BlPrepayPatRcptDO>();//预交金票据数据
		List<PiPatAccDO> accList = new ArrayList<PiPatAccDO>();//账户数据
		List<String> updateAccSqlList = new ArrayList<String>();//更新账户sql
		
		FDouble prepayAmt = new FDouble(0);
		for (int i = 0; i < patList.size(); i++) {
			
			PatDO data = patList.get(i);
			//卡数据
			PiCardDO cardDO = null;
			if(!StringUtil.isEmpty(data.getDef1())){
				cardDO = this.assembleCardData(data.getDef1());
				cardDO.setId_card(cardKeys[i]);
				cardList.add(cardDO);
			}

			String onlyKey1 = this.analysisUniqueKey1(data);//身份证
			String onlyKey2 = this.analysisUniqueKey2(data);//姓名，出生日期，手机号

			String patId = "";
			boolean ifRepeat = false;
			if(!StringUtil.isEmpty(onlyKey1)){
				String value = this.uniquePatMap1.get(onlyKey1);
				if(!StringUtil.isEmpty(value)){
					ifRepeat = true;
					patId = value;
				}
			} 
			
			if(!ifRepeat && !StringUtil.isEmpty(onlyKey2)){
				String value = this.uniquePatMap2.get(onlyKey2);
				if(!StringUtil.isEmpty(value)){
					ifRepeat = true;
					patId = value;
				}
			}
			
			if(!ifRepeat){
				//患者数据
				PatDO patDO = this.assemblePatData(data, patCodes[i]);
				patDO.setId_pat(patKeys[i]);
				patNewList.add(patDO);
				
				patId = patDO.getId_pat();
				
				if(!StringUtil.isEmpty(onlyKey1)){
					this.uniquePatMap1.put(onlyKey1, patId);
				}
				
				if(!StringUtil.isEmpty(onlyKey2)){
					this.uniquePatMap2.put(onlyKey2, patId);
				}	
			}
			
			//患者卡数据
			if(cardDO != null){
				PiPatCardDO patCardDO = this.assemblePatCardData(patId, cardDO, ifRepeat);
				patcardList.add(patCardDO);
			}
			
			FDouble amt = (FDouble)FTypeManager.convert2FType(FType.FDouble, data.getDef2());
			prepayAmt = prepayAmt.add(amt);
			
			//预交金数据
			BlPrePayPatDO prepayDO = this.assemblePrepayData(patId, amt, invoiceNos[i], blccKey);
			prepayDO.setId_paypat(prepayKeys[i]);
			prepayList.add(prepayDO);
			
			//预交金票据数据
			BlPrepayPatRcptDO prepayRcpt = this.assemblePrepayRcptData(prepayDO);
			prepayRcptList.add(prepayRcpt);
			
			if(ifRepeat){
				String sql = "update pi_pat_acc set prepay = prepay + " + amt.toString() 
						+ " where id_pat = '" + patId + "' and code = 'PRIMARY'";
				updateAccSqlList.add(sql);
			}else{
				//账户数据
				PiPatAccDO accDO = this.assemblePatAccData(patId, amt);
				accList.add(accDO);
			}
		}
		
		//保存导入数据
		DAFacade daf = new DAFacade();
		
		if(patNewList.size() > 0){
			//患者数据
			daf.insertDOArrayWithPK(patNewList.toArray(new PatDO[0]));
		}
		if(patcardList.size() > 0){
			//患者卡数据
			daf.insertDOs(patcardList.toArray(new PiPatCardDO[0]));
		}
		if(cardList.size() > 0){
			//卡数据
			daf.insertDOArrayWithPK(cardList.toArray(new PiCardDO[0]));
		}
		//预交金数据
		daf.insertDOArrayWithPK(prepayList.toArray(new BlPrePayPatDO[0]));
		//预交金票据数据
		daf.insertDOs(prepayRcptList.toArray(new BlPrepayPatRcptDO[0]));
		if(accList.size() > 0){
			//账户数据
			daf.insertDOs(accList.toArray(new PiPatAccDO[0]));
		}
		
		//更新账户金额
		if(updateAccSqlList.size() > 0){
			AbstractPersistMgr manager = null;
			try {
				manager = PersistMgr.getInstance("design");
				PersistSession session = manager.getPersistSession();
				for (String sql : updateAccSqlList) {
					session.addBatch(sql);
				}
				session.execBatch();
			} catch (DbException e) {
				e.printStackTrace();
			}finally{
				if(manager != null){
					manager.release();
				}
			}
		}
	
		//结账数据
		BlCcDO ccDO = this.assembleBlccData(prepayAmt);
		ccDO.setId_cc(blccKey);
		daf.insertDOWithPK(ccDO);
		//结账_付款方式信息
		BlCcPmDO ccPmDO = this.assembleBlccPmData(blccKey, prepayAmt, prepayList.size());
		daf.insertDO(ccPmDO);
		
		//预交金票据号过号
		incService.nextInvoiceNoByNo(blIncIssDO, invoiceNos[invoiceNos.length - 1]);
	}
	
	/**
	 * 组装卡数据
	 * @param code
	 * @return
	 */
	private PiCardDO assembleCardData(String code){
		
		PiCardDO cardDO = new PiCardDO();
		cardDO.setId_grp(Context.get().getGroupId());
		cardDO.setId_org(Context.get().getOrgId());
		cardDO.setId_patcardtp(patCardTpDO.getId_cardtp());
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
	 * 组装患者数据
	 * @param patData
	 * @return
	 */
	private PatDO assemblePatData(PatDO patData,String code){
		
		PatDO patDO = new PatDO();
		patDO.setId_grp(Context.get().getGroupId());
		patDO.setId_org(Context.get().getOrgId());
		patDO.setCode(code);
		patDO.setName(patData.getName());
		patDO.setPycode(CnToPy.getPyFirstCode(patDO.getName(), 100));
		patDO.setWbcode(CnToWB.getWBCode(patDO.getName(), 100));
		 
		if(!StringUtil.isEmpty(patData.getId_code()) && IDChecker.checkIDCard(patData.getId_code())){
			patDO.setId_idtp(IPiDictCodeConst.ID_IDTP_IDENTITY);
			patDO.setSd_idtp(IPiDictCodeConst.SD_IDTP_IDENTITY);
		}else{
			patDO.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
			patDO.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
		}
		
		if(!StringUtil.isEmpty(patData.getId_code())){
			patDO.setId_code(patData.getId_code());
		}else{
			patDO.setId_code("1");
		}
		
		//String caCode = "1".equals(patData.getDef3()) ? "04" : "01";
		PiPatCaDO patCaDO = patcaMap.get(patData.getDef3());
		if(patCaDO != null){
			patDO.setId_paticate(patCaDO.getId_patca());
			patDO.setId_patpritp(patCaDO.getId_patpritp());
			patDO.setId_patcrettp(patCaDO.getId_patcrettp());
		}
		
		switch (patData.getSd_sex()) {
		case "1":
			patDO.setId_sex(IPiDictCodeConst.ID_SEX_MALE);
			patDO.setSd_sex(IPiDictCodeConst.SD_SEX_MALE);
			break;
		case "2":
			patDO.setId_sex(IPiDictCodeConst.ID_SEX_FEMALE);
			patDO.setSd_sex(IPiDictCodeConst.SD_SEX_FEMALE);
			break;
		default:
			patDO.setId_sex(IPiDictCodeConst.ID_SEX_UNKNOW);
			patDO.setSd_sex(IPiDictCodeConst.SD_SEX_UNKNOW);
			break;
		}
		patDO.setDt_birth(patData.getDt_birth());
		if(!StringUtil.isEmpty(patData.getMob()) && patData.getMob().startsWith("1") && patData.getMob().length() == 11){
			patDO.setMob(patData.getMob());
		}else{
			patDO.setTel(patData.getMob());
		}
		
		if("1".equals(patData.getDef3())){
			patDO.setId_srcregiontp(IPiDictCodeConst.ID_SRCREGIONTP_HOSPITAL);
			patDO.setSd_srcregiontp(IPiDictCodeConst.SD_SRCREGIONTP_HOSPITAL);
		}else{
			patDO.setId_srcregiontp(IPiDictCodeConst.ID_SRCREGIONTP_LOCAL);
			patDO.setSd_srcregiontp(IPiDictCodeConst.SD_SRCREGIONTP_LOCAL);
		}
		
		patDO.setWorkunit(patData.getWorkunit());
		patDO.setFg_invd(FBoolean.FALSE);
		if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDO.getSd_idtp())){
			patDO.setFg_realname(FBoolean.TRUE);
		}else{
			patDO.setFg_realname(FBoolean.FALSE);
		}
		patDO.setId_patsrctp(IPiDictCodeConst.ID_PATSRCTP_OTHER);
		patDO.setSd_patsrctp(IPiDictCodeConst.SD_PATSRCTP_OTHER);
		patDO.setBarcode_chis(patData.getCode());
		patDO.setCode_amr_ip(patData.getCode_amr_ip());
		patDO.setLast_times_ip(patData.getLast_times_ip());
		patDO.setId_emp_create(Context.get().getStuffId());
		patDO.setDef1(IMPORTPATFLAG);
		patDO.setCreatedby(Context.get().getUserId());
		patDO.setCreatedtime(now);
		patDO.setStatus(DOStatus.NEW);
		return patDO;
	}

	/**
	 * 组装患者卡数据
	 * @param patId
	 * @param cardDO
	 * @param ifRepeat
	 * @return
	 */
	private PiPatCardDO assemblePatCardData(String patId, PiCardDO cardDO, boolean ifRepeat){
		
		PiPatCardDO patCardDO = new PiPatCardDO();
		patCardDO.setId_pat(patId);
		patCardDO.setId_patcardtp(patCardTpDO.getId_cardtp());
		patCardDO.setSd_patcardtp(patCardTpDO.getCode());
		patCardDO.setCode(cardDO.getCode());
		patCardDO.setFg_def(ifRepeat ? FBoolean.FALSE : FBoolean.TRUE);
		patCardDO.setId_card(cardDO.getId_card());
		patCardDO.setDt_b(now);
		patCardDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
		patCardDO.setFg_act(FBoolean.TRUE);
		patCardDO.setSortno(ifRepeat ? 2 : 1);
		patCardDO.setStatus(DOStatus.NEW);
		return patCardDO;
	}

	/**
	 * 组装预交金数据
	 * @param patId
	 * @param amt
	 * @param codeRep
	 * @poaram blccKey
	 * @return
	 */
	private BlPrePayPatDO assemblePrepayData(String patId, FDouble amt, String codeRep, String blccKey){
		
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
		//prepayDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CASH);
		//prepayDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
		prepayDO.setId_pm("1001LL10000000021ZMQ");//期初导入
		prepayDO.setSd_pm("97");
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
	private PiPatAccDO assemblePatAccData(String patId,FDouble amt){
		
		PiPatAccDO accDO = new PiPatAccDO();
		accDO.setId_org(Context.get().getOrgId());
		accDO.setId_grp(Context.get().getGroupId());
		accDO.setId_pat(patId);
		accDO.setName("主账户");
		accDO.setCode("PRIMARY");
		accDO.setPrepay(amt);
		accDO.setCred(new FDouble(0));
		accDO.setAcc_lock(new FDouble(0));
		accDO.setId_accsta(IPiDictCodeConst.ID_ACCSTA_NORMAL);
		accDO.setSd_accsta(IPiDictCodeConst.SD_ACCSTA_NORMAL);
		accDO.setFg_active(FBoolean.TRUE);
		accDO.setCreatedby(Context.get().getUserId());
		accDO.setCreatedtime(now);
		accDO.setStatus(DOStatus.NEW);
		
		return accDO;
	}
	
	/**
	 * 结账数据
	 * @param prepayAmt
	 * @return
	 */
	private BlCcDO assembleBlccData(FDouble prepayAmt){
		
		FDateTime ccEndTime = now.addSeconds(60);
		
		BlCcDO ccDO = new BlCcDO();
		ccDO.setId_grp(Context.get().getGroupId());
		ccDO.setId_org(Context.get().getOrgId());
		ccDO.setId_cctp(IBlDictCodeConst.SD_CCTP_ID_MZSF);
		ccDO.setSd_cctp(IBlDictCodeConst.SD_CCTP_MZSF);
		ccDO.setId_emp(Context.get().getStuffId());
		ccDO.setDt_b(now);
		ccDO.setDt_e(ccEndTime);
		ccDO.setAmt(prepayAmt);
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
		ccDO.setAmt_entprepay(prepayAmt);
		ccDO.setAmt_entprepay_ret(FDouble.ZERO_DBL);
		ccDO.setInccn_pvprepay(0);
		ccDO.setInccn_pvprepay_ret(0);
		ccDO.setDt_cc(ccEndTime);
		ccDO.setFg_fi(FBoolean.FALSE);
		ccDO.setCreatedby(Context.get().getUserId());
		ccDO.setCreatedtime(ccEndTime);
		
		ccDO.setStatus(DOStatus.NEW);
		return ccDO;
	}
	
	/**
	 * 结账付款方式数据
	 * @param blccKey
	 * @param prepayAmt
	 * @return
	 */
	private BlCcPmDO assembleBlccPmData(String blccKey, FDouble prepayAmt,Integer count){
		
		BlCcPmDO ccpmDO = new BlCcPmDO();
		ccpmDO.setId_grp(Context.get().getGroupId());
		ccpmDO.setId_org(Context.get().getOrgId());
		ccpmDO.setId_cc(blccKey);
		ccpmDO.setId_pm("1001LL10000000021ZMQ");
		ccpmDO.setAmt(prepayAmt);
		ccpmDO.setCn_amt(count);
		ccpmDO.setAmt_return(FDouble.ZERO_DBL);
		ccpmDO.setCn_amtreturn(0);
		ccpmDO.setStatus(DOStatus.NEW);
		return ccpmDO;
	}

	/**
	 * 解析唯一值1
	 * @param data
	 * @return
	 */
	private String analysisUniqueKey1(PatDO data){
		if(!StringUtil.isEmpty(data.getId_code()) && IDChecker.checkIDCard(data.getId_code())){
			return data.getId_code();
		}
		return null;
	}
	
	/**
	 * 解析唯一值2
	 * @param data
	 * @return
	 */
	private String analysisUniqueKey2(PatDO data){
		
		if (!StringUtil.isEmpty(data.getName()) && data.getDt_birth() != null
				&& !StringUtil.isEmpty(data.getMob())) {

			String key = data.getName() + data.getDt_birth().toString() + data.getMob();
			return key;
		}
		return null;
	}
}
