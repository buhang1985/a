package iih.pi.reg.s.wsstd.bp.patreg;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import iih.bl.pay.i.IBlPayCmdService;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.i.ICardRService;
import iih.pi.card.i.IPiCardMaintainService;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.dic.cardtype.i.ICardtypeRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.params.PiParams;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.pat.i.IPiPatCardDOCudService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import iih.pi.reg.pat.i.IPiPatContDORService;
import iih.pi.reg.s.bp.util.PiGetDefaultDataUtil;
import iih.pi.reg.s.wsstd.bp.PiItfBaseBP;
import iih.pi.reg.s.wsstd.bp.validator.WsParamPatRegAndDistCardValidator;
import iih.pi.reg.wsstd.bean.input.patreg.WsParamPatRegAndDistCard;
import iih.pi.reg.wsstd.bean.input.patreg.sub.WsParamPatRegAndDistCardInfo;
import iih.pi.reg.wsstd.bean.output.WsResultMsg;
import iih.pi.reg.wsstd.bean.output.patreg.WsResultPatRegAndDistCard;
import iih.pi.reg.wsstd.bean.output.patreg.sub.WsResultPatRegAndDistCardInfo;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.lock.PKLock;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidocRService;
import xap.sys.xbd.udi.i.IUdidoclistRService;

/**
 * 患者注册发卡或患者注册
 * 
 * @author shaokx 2019/1/30
 *
 */
public class PatRegAndDistrCardBP extends PiItfBaseBP<WsParamPatRegAndDistCard> {

	private static final String LOCK_KEY = "patreg_lock_";
	
	PiPatCardDO[] _patCardDO;

	@Override
	protected String getBusiness() {
		// TODO Auto-generated method stub
		return "患者注册发卡或患者注册";
	}

	@Override
	protected void checkParam(WsParamPatRegAndDistCard param) throws BizException {
		WsParamPatRegAndDistCardValidator validator = new WsParamPatRegAndDistCardValidator();
		validator.validate(param);
	}

	@Override
	protected String doWork(WsParamPatRegAndDistCard param) throws BizException {
		WsParamPatRegAndDistCardInfo patRegAndDistrInfo = param.get_patRegAndDistrInfo();

		if(!"02".equals(patRegAndDistrInfo.getDoType())){
			//加锁（患者姓名，电话号码，生日）
			String lockKey = LOCK_KEY + patRegAndDistrInfo.getPatName() + patRegAndDistrInfo.getPhoneCode() + patRegAndDistrInfo.getPatBorthday();
			boolean lock = PKLock.getInstance().addDynamicLock(lockKey);
			if(!lock){
				throw new BizException("当前患者正在注册，请刷新重试");
			}
		}
	
		// 设置人员上下文 ly
		if (!StringUtil.isEmpty(patRegAndDistrInfo.getOperaCode())) {
			IPsndocMDORService rService = ServiceFinder.find(IPsndocMDORService.class);
			PsnDocDO[] dos = rService.findByAttrValString(PsnDocDO.CODE, patRegAndDistrInfo.getOperaCode());

			if (!ArrayUtil.isEmpty(dos)) {
				Context.get().setStuffId(dos[0].getId_psndoc());
			}
		}
		
		//可非实名制建档
		if("05".equals(patRegAndDistrInfo.getDoType()) || "06".equals(patRegAndDistrInfo.getDoType())){
			PatiAggDO patAggDO = this.nonRealNameReg(patRegAndDistrInfo);
			return this.setOutparam(patAggDO);
		}
		
		//实名建档
		if ("04".equals(patRegAndDistrInfo.getDoType())) {
			// 患者注册
			PatiAggDO patAggDO = patRegister(patRegAndDistrInfo);
			return this.setOutparam(patAggDO);
		}
		// 绑卡
		if ("02".equals(patRegAndDistrInfo.getDoType())) {

			PatiAggDO patAggDO = patBingCard(patRegAndDistrInfo);

			return this.setOutparam(patAggDO);
		}

		// 患者注册
		PatiAggDO patAggDO = patRegister(patRegAndDistrInfo);
		
		if(!"05".equals(patRegAndDistrInfo.getCardType())){
			// 发卡
			distrCard(patRegAndDistrInfo.getCardCode(), patAggDO.getParentDO());
		}
		
		if (!StringUtil.isEmpty(patRegAndDistrInfo.getPayMoney())
				&& !StringUtil.isEmpty(patRegAndDistrInfo.getPaymentMethod())) {
			// 充值
			recharge(patAggDO, patRegAndDistrInfo);
		}

		return this.setOutparam(patAggDO);
	}

	/**
	 * 非实名制建档
	 * @return
	 * @throws BizException 
	 */
	private PatiAggDO nonRealNameReg(WsParamPatRegAndDistCardInfo paramBeanInfo) throws BizException{
		IPatiCudService patiCudService = ServiceFinder.find(IPatiCudService.class);
		PatiAggDO aggdo = getNonRealPatInfo(paramBeanInfo);
		PatiAggDO[] aggDOs = patiCudService.save(new PatiAggDO[] { aggdo });
		return aggDOs[0];
	}
	
	/**
	 * 获取非实名患者的信息
	 * 
	 * @param paramBeanInfo
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO getNonRealPatInfo(WsParamPatRegAndDistCardInfo paramBeanInfo) throws BizException {
		//1、校验该患者是否存在
		
		IPatiMDORService patiMDORService = ServiceFinder.find(IPatiMDORService.class);
		// 首先根据身份证号判断是否已存在该患者
		PatDO[] patDOByIdCard = null;
		if(!StringUtil.isEmpty(paramBeanInfo.getSdCode())){
			String Str = String.format("ID_CODE = '%s' AND SD_IDTP = '%s'", paramBeanInfo.getSdCode(),
					IPiDictCodeConst.SD_CARD_TYPE_IDENTITY);
		    patDOByIdCard = patiMDORService.find(Str, "", FBoolean.FALSE);
		}
		
		if(!ArrayUtil.isEmpty(patDOByIdCard)){
			throw new BizException("带有该身份证的患者已存在");
		}
		// 根据患者姓名，生日，电话三要素 判断是否存在该患者
		String whereStr = String.format("MOB = '%s' AND DT_BIRTH = '%s' AND NAME = '%s' AND SD_IDTP != '%s'",
				paramBeanInfo.getPhoneCode(), paramBeanInfo.getPatBorthday(), paramBeanInfo.getPatName(),
				IPiDictCodeConst.SD_CARD_TYPE_IDENTITY);
		PatDO[] patDOByTelBirthAndName = patiMDORService.find(whereStr, "", FBoolean.FALSE);


		if(!ArrayUtil.isEmpty(patDOByTelBirthAndName)){
			throw new BizException("已存在与该患者相同姓名，生日和电话的患者");
		}
		
		//2、给患者信息赋值
		
		PatiAggDO aggdo = new PatiAggDO();

		PatDO patDO = new PatDO();
		patDO.setStatus(DOStatus.NEW);
		patDO.setId_pat(new DBUtil().getOIDs(1)[0]);
		patDO.setId_org(Context.get().getOrgId());
		patDO.setId_grp(Context.get().getGroupId());

		IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
		// 获取患者编码
		String code = billcodeManage.getPreBillCode_RequiresNew(PatDODesc.CLASS_FULLNAME);
		patDO.setCode(code);
		patDO.setName(paramBeanInfo.getPatName());
		patDO.setFg_realname(FBoolean.TRUE);
		// 拼音
		if (!StringUtils.isEmpty((paramBeanInfo.getPatName()))) {
			patDO.setPycode(CnToPy.getPyFirstCode(paramBeanInfo.getPatName()));
			// 助记码
			patDO.setMnecode(patDO.getPycode());
			patDO.setWbcode(CnToWB.getWBCode(paramBeanInfo.getPatName()));
		}
		
		if(StringUtil.isEmpty(paramBeanInfo.getSdCode())){
			patDO.setId_code("1");
			patDO.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
			patDO.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
		}else{
			patDO.setId_code(paramBeanInfo.getSdCode());
			patDO.setSd_idtp(IPiDictCodeConst.SD_IDTP_IDENTITY);
			patDO.setId_idtp(IPiDictCodeConst.ID_IDTP_IDENTITY);
		}
		
		patDO.setId_patsrctp(IPiDictCodeConst.ID_PATSRCTP_SELHPLPMACHINE);
		patDO.setSd_patsrctp(IPiDictCodeConst.SD_PATSRCTP_SELHPLPMACHINE);
		patDO.setId_srcregiontp(IPiDictCodeConst.ID_SRCREGIONTP_LOCAL);
		patDO.setSd_srcregiontp(IPiDictCodeConst.SD_SRCREGIONTP_LOCAL);
		patDO.setId_country("@@@@Z8100000000LIVDL");
		patDO.setSd_country("156");
		patDO.setId_nation("@@@@AA1000000000MNM3");
		patDO.setSd_nation("01");
		patDO.setFg_recordcost(FBoolean.TRUE);
		patDO.setMob(paramBeanInfo.getPhoneCode());
		patDO.setDt_birth(FDate.fromPersisted(paramBeanInfo.getPatBorthday()));
		patDO.setSd_sex(paramBeanInfo.getPatSex());
		// 基础档案必须设置id
		String idsex = getIdsex(paramBeanInfo.getPatSex());
		patDO.setId_sex(idsex);
		patDO.setWorkunit(paramBeanInfo.getWorkUnit());//工作单位赋值
		// 设置默认属性
		setInitValue(patDO);
		
		//3、给患者联系人赋值
		this.setPatCont(aggdo,patDO,paramBeanInfo);
		
		//4、给患者地址赋值
		this.setPatAddr(aggdo, patDO, paramBeanInfo);
		
		aggdo.setParent(patDO);
		
		//5、06为建档并绑卡
		if ("06".equals(paramBeanInfo.getDoType())) {
			setCardDO(aggdo, paramBeanInfo);
			//发卡
			if(!"05".equals(paramBeanInfo.getCardType())){
				distrCard(paramBeanInfo.getCardCode(), aggdo.getParentDO());
			}
		}
		
		return aggdo;
	}
	
	/**
	 * 给患者地址赋值（如果nowDistrict有值，则走它的对应地址，否则走默认地址）
	 * @throws BizException 
	 */
	private void setPatAddr(PatiAggDO aggdo,PatDO patDO,WsParamPatRegAndDistCardInfo paramBeanInfo) throws BizException{
		if(!StringUtil.isEmpty(paramBeanInfo.getNowDistrict())){
			//查询接口入参输入的住址对应的DO
			IAdminareaRService adminAreaService = ServiceFinder.find(IAdminareaRService.class);
			AdminAreaDO[] admAreaArr = adminAreaService.findByAttrValString(AdminAreaDO.CODE, paramBeanInfo.getNowDistrict());
//			if(ArrayUtil.isEmpty(admAreaArr)){
//				throw new BizException("未查询到患者现住址");
//			}
			PatiAddrDO[] patAddrDOs = new PatiAddrDO[1];
			PatiAddrDO patAddrDO = new PatiAddrDO();
			patAddrDO.setId_pat(patDO.getId_pat());
			patAddrDO.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			patAddrDO.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			if(!ArrayUtil.isEmpty(admAreaArr)){
				patAddrDO.setSd_admdiv(admAreaArr[0].getCode());
				patAddrDO.setId_admdiv(admAreaArr[0].getId_adminarea());
			}
			patAddrDO.setStreet(paramBeanInfo.getNowStreet());
			patAddrDO.setZip("~");
			patAddrDO.setTel("~");
			patAddrDO.setSortno(this.getPiPatAddr(patDO.getId_pat()).length + 1);
			patAddrDOs[0] = patAddrDO;
			aggdo.setPatiAddrDO(patAddrDOs);
		}else{
			String piPat0014 = new PiParams().PIPAT0014();//患者默认现住址
			if(!StringUtil.isEmpty(piPat0014)){
				//查询患者默认现住址
				IAdminareaRService adminAreaService = ServiceFinder.find(IAdminareaRService.class);
				AdminAreaDO admArea = adminAreaService.findById(piPat0014);
//				if(admArea == null){
//					throw new BizException("未查询到患者默认现住址");
//				}
				PatiAddrDO[] patAddrDOs = new PatiAddrDO[1];
				PatiAddrDO patAddrDO = new PatiAddrDO();
				patAddrDO.setId_pat(patDO.getId_pat());
				patAddrDO.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
				patAddrDO.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
				if(admArea != null){
					patAddrDO.setSd_admdiv(admArea.getCode());
					patAddrDO.setId_admdiv(admArea.getId_adminarea());
				}
				
				patAddrDO.setStreet(paramBeanInfo.getNowStreet());
				patAddrDO.setZip("~");
				patAddrDO.setTel("~");
				patAddrDO.setSortno(this.getPiPatAddr(patDO.getId_pat()).length + 1);
				patAddrDOs[0] = patAddrDO;
				aggdo.setPatiAddrDO(patAddrDOs);
			}
		}
	}
	
	/**
	 * 获取患者其他的住址
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PatiAddrDO[] getPiPatAddr(String patId) throws BizException{
		IPatiAddrDORService addrService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] patAddrDOs = addrService.findByAttrValString("Id_pat", patId);
		if (ArrayUtils.isEmpty(patAddrDOs)) {
			// 患者有档案，但没有其他的地址
			return new PatiAddrDO[0];
		}
		// 患者有档案，已有其他的地址，说明该患者有其他的地址
		return patAddrDOs;
	}
	
	/**
	 * 给患者联系人赋值
	 * @throws BizException 
	 */
	private void setPatCont(PatiAggDO aggdo,PatDO patDO,WsParamPatRegAndDistCardInfo paramBeanInfo) throws BizException{
		//只有入参联系人的名字，联系人和患者关系，联系人的电话都有值时才能给患者创建联系人，否则，不予创建
		if(!StringUtil.isEmpty(paramBeanInfo.getRelationName()) && !StringUtil.isEmpty(paramBeanInfo.getRelationCode()) && !StringUtil.isEmpty(paramBeanInfo.getRelationTel())){
			PiPatContDO[] patContDOs = new PiPatContDO[1];
			PiPatContDO patContDO = new PiPatContDO();
			patContDO.setId_pat(patDO.getId_pat());//必填，患者id
			patContDO.setName(paramBeanInfo.getRelationName());//必填，联系人名称
			patContDO.setSd_conttp(paramBeanInfo.getRelationCode());//必填，联系人类型编码
			patContDO.setId_conttp(this.getIdConttp(paramBeanInfo.getRelationCode()));//必填，联系人类型id
			patContDO.setConttel(paramBeanInfo.getRelationTel());//必填，联系人电话
			patContDO.setFg_guardian(FBoolean.FALSE);//非必填，监护人标记，默认为false
			patContDO.setSortno(this.getPiPatCont(patDO.getId_pat()).length + 1);//非必填，序号
			if(!StringUtil.isEmpty(paramBeanInfo.getRoleCode())){
				patContDO.setSd_fmrole(paramBeanInfo.getRoleCode());//非必填，家属身份编码
				patContDO.setId_fmrole(this.getIdFmrole(paramBeanInfo.getRoleCode()));//非必填，家属身份id
			}
			if(!StringUtil.isEmpty(paramBeanInfo.getRelationStreet())){
				patContDO.setContaddr(paramBeanInfo.getRelationStreet());//非必填，联系人地址
			}
			if(!StringUtil.isEmpty(paramBeanInfo.getSdidType())){
				patContDO.setSd_cont(paramBeanInfo.getSdidType());//非必填，联系人证件类型编码
				patContDO.setId_cont(this.getIdTp(paramBeanInfo.getSdidType()));//非必填，联系人证件类型id
			}
			if(!StringUtil.isEmpty(paramBeanInfo.getSocialNo())){
				patContDO.setContid(paramBeanInfo.getSocialNo());//非必填，证件号
			}
			patContDOs[0] = patContDO;
			aggdo.setPiPatContDO(patContDOs);
		}
	}
	
	/**
	 * 获取患者其他的联系人
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PiPatContDO[] getPiPatCont(String patId) throws BizException{
		IPiPatContDORService piPatContDORService = ServiceFinder.find(IPiPatContDORService.class);
		PiPatContDO[] patContDOs = piPatContDORService.findByAttrValString("Id_pat", patId);
		if (ArrayUtils.isEmpty(patContDOs)) {
			// 患者有档案，但没有其他的联系人
			return new PiPatContDO[0];
		}
		// 患者有档案，已有其他的联系人，说明该患者有其他的联系人
		return patContDOs;
	}
	
	/**
	 * 获取联系人类型id
	 * 
	 * @param patSex
	 * @throws BizException
	 */
	private String getIdConttp(String patConttp) throws BizException {
		IUdidoclistRService iUdidoclistRService = ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO[] udidoclistDOs = iUdidoclistRService.findByAttrValString("Code",
				IPiDictCodeTypeConst.SD_CONTTP);

		IUdidocRService iUdidocRService = ServiceFinder.find(IUdidocRService.class);
		String sql = String.format("ID_UDIDOCLIST = '%s' AND CODE = '%s'", udidoclistDOs[0].getId_udidoclist(), patConttp);
		UdidocDO[] udidocDOs = iUdidocRService.find(sql, "", FBoolean.FALSE);
		if(StringUtil.isEmpty(udidocDOs[0].getId_udidoc())){
			throw new BizException("未查询到家属关系信息，请检查relationCode的值是否正确");
		}
		return udidocDOs[0].getId_udidoc();
	}
	
	/**
	 * 获取血缘关系id
	 * 
	 * @param patSex
	 * @throws BizException
	 */
	private String getIdFmrole(String patFmrole) throws BizException {
		IUdidoclistRService iUdidoclistRService = ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO[] udidoclistDOs = iUdidoclistRService.findByAttrValString("Code",
				IPiDictCodeTypeConst.SD_FMROLE);

		IUdidocRService iUdidocRService = ServiceFinder.find(IUdidocRService.class);
		String sql = String.format("ID_UDIDOCLIST = '%s' AND CODE = '%s'", udidoclistDOs[0].getId_udidoclist(), patFmrole);
		UdidocDO[] udidocDOs = iUdidocRService.find(sql, "", FBoolean.FALSE);
		if(StringUtil.isEmpty(udidocDOs[0].getId_udidoc())){
			throw new BizException("未查询到家属身份信息，请检查roleCode的值是否正确");
		}
		return udidocDOs[0].getId_udidoc();
	}
	
	/**
	 * 获取联系人证件类型id
	 * 
	 * @param patSex
	 * @throws BizException
	 */
	private String getIdTp(String patIdTp) throws BizException {
		IUdidoclistRService iUdidoclistRService = ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO[] udidoclistDOs = iUdidoclistRService.findByAttrValString("Code",
				IPiDictCodeTypeConst.SD_IDTP);

		IUdidocRService iUdidocRService = ServiceFinder.find(IUdidocRService.class);
		String sql = String.format("ID_UDIDOCLIST = '%s' AND CODE = '%s'", udidoclistDOs[0].getId_udidoclist(), patIdTp);
		UdidocDO[] udidocDOs = iUdidocRService.find(sql, "", FBoolean.FALSE);
		if(StringUtil.isEmpty(udidocDOs[0].getId_udidoc())){
			throw new BizException("未查询到联系人证件类型信息，请检查sdidType的值是否正确");
		}
		return udidocDOs[0].getId_udidoc();
	}
	
	
	/**
	 * 患者绑卡
	 * 
	 * @param patRegAndDistrInfo
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO patBingCard(WsParamPatRegAndDistCardInfo patRegAndDistrInfo) throws BizException {
		// 患者信息 基础服务
		IPiPatCardDOCudService CardCud = ServiceFinder.find(IPiPatCardDOCudService.class);
		DAFacade daf = new DAFacade();
		PatiAggDO patAggDO = new PatiAggDO();
		PatDO pat = new PatDO();

		patAggDO.setParentDO(pat);
		// 根据患者编码 查询患者信息
		String sql1 = String.format("select * from pi_pat where code = '%s' ", patRegAndDistrInfo.getPatCode());
		PatDO patDo = (PatDO) daf.execQuery(sql1, new BeanHandler(PatDO.class));

		if (patDo == null || StringUtils.isEmpty(patDo.getId_pat())) {
			throw new BizException("患者注册发卡:未查询患者信息");
		}

		// 查询此卡是否绑定过
		String sql2 = String.format("select * from pi_pat_card where code = '%s' ",
				StringUtils.isEmpty(patRegAndDistrInfo.getBankCode())
						? StringUtils.isEmpty(patRegAndDistrInfo.getHpCode())
								? StringUtils.isEmpty(patRegAndDistrInfo.getCardCode()) ? null
										: patRegAndDistrInfo.getCardCode()
								: patRegAndDistrInfo.getHpCode()
						: patRegAndDistrInfo.getBankCode());
		PiPatCardDO patCardDo = (PiPatCardDO) daf.execQuery(sql2, new BeanHandler(PiPatCardDO.class));
		if (patCardDo != null) {
			throw new BizException("患者绑卡已绑定 重复绑卡");
		}
		String id_pat = patDo.getId_pat();
		// 如果是银行卡
		if (!StringUtils.isEmpty(patRegAndDistrInfo.getBankCode())) {
			// 组装患者卡数据
			PiPatCardDO piPatCardDo = this.assemblePatCardData(patRegAndDistrInfo.getBankCode(),
					IPiDictCodeConst.SD_CARD_TYPE_BANK, id_pat);
			PiPatCardDO[] piPatCardDOs = CardCud.save(new PiPatCardDO[] { piPatCardDo });
			if (!ArrayUtils.isEmpty(piPatCardDOs)) {
				pat.setCode(patDo.getCode());
				pat.setId_pat(piPatCardDo.getId_pat());
				return patAggDO;
			}
		}
		// 如果是医保卡
		if (!StringUtils.isEmpty(patRegAndDistrInfo.getHpCode())) {
			// 组装患者卡数据
			PiPatCardDO piPatCardDo = this.assemblePatCardData(patRegAndDistrInfo.getHpCode(),
					IPiDictCodeConst.SD_CARD_TYPE_MEDICINE, id_pat);
			PiPatCardDO[] piPatCardDOs = CardCud.save(new PiPatCardDO[] { piPatCardDo });
			if (!ArrayUtils.isEmpty(piPatCardDOs)) {
				pat.setCode(patDo.getCode());
				pat.setId_pat(piPatCardDo.getId_pat());
				return patAggDO;
			}
		}
		if (!StringUtils.isEmpty(patRegAndDistrInfo.getCardCode())) {
			// 发卡
			distrCard(patRegAndDistrInfo.getCardCode(), patDo);
		}
		return null;
	}

	/**
	 * 组装患者卡数据
	 * 
	 * @param bankCode
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private PiPatCardDO assemblePatCardData(String CardCode, String CardTypeCode, String id_pat) throws BizException {
		PiPatCardDO patCardDO = new PiPatCardDO();
		DAFacade daf = new DAFacade();
		patCardDO.setId_pat(id_pat);
		// 患者卡类型编码
		patCardDO.setSd_patcardtp(CardTypeCode);
		String sql2 = String.format("select * from pi_pat_cardtp where code = '%s' ",
				IPiDictCodeConst.SD_CARD_TYPE_BANK);
		PiPatCardTpDO patCardTpDO = (PiPatCardTpDO) daf.execQuery(sql2, new BeanHandler(PiPatCardTpDO.class));
		// 患者卡类型id
		patCardDO.setId_patcardtp(patCardTpDO.getId_cardtp());
		patCardDO.setCode(CardCode);
		patCardDO.setFg_def(FBoolean.FALSE);
		patCardDO.setDt_b(new FDateTime());
		patCardDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
		patCardDO.setFg_act(FBoolean.TRUE);
		patCardDO.setStatus(DOStatus.NEW);
		PiPatCardDO[] haveOtherCard = getPiPatCard(id_pat);
		// 已经有的卡数量+1
		patCardDO.setSortno(haveOtherCard.length + 1);

		return patCardDO;
	}

	/**
	 * 转换为内部处理类型 由分转换为元
	 * 
	 * @param amt
	 * @return
	 */
	public static FDouble toFDouble(String amt) {
		Double i = Double.parseDouble(amt);
		return new FDouble(i / 100, 2);
	}

	/**
	 * 转为外部提供类型 由元转换为分
	 * 
	 * @param amt
	 */
	public static String toXmlString(FDouble amt) {

		BigDecimal bg = new BigDecimal(amt.doubleValue() * 100);

		double doubleValue = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

		DecimalFormat decimalFormat = new DecimalFormat("###################.###########");

		return decimalFormat.format(doubleValue);

		// return String.valueOf(doubleValue);//double转成string时，会在末尾加上一个0，如12
		// 会变为12.0
		// 下面这个转换会损失精度，如amt为0.6666会变为67
		// Double d = amt.doubleValue();
		// return Integer.toString((int)Math.ceil(d*100));
	}

	/**
	 * 组装返回值
	 * 
	 * @param patAggDO
	 * @return
	 * @throws BizException
	 */
	private String setOutparam(PatiAggDO patAggDO) throws BizException {
		WsResultPatRegAndDistCard outParam = new WsResultPatRegAndDistCard();
		WsResultMsg resultMsg = new WsResultMsg();
		WsResultPatRegAndDistCardInfo outParamInfo = new WsResultPatRegAndDistCardInfo();

		IPatAccServiceExt piPatCardDORService = ServiceFinder.find(IPatAccServiceExt.class);
		PatRelAmountInfoDTO getPatRelAmountInfo = piPatCardDORService
				.GetPatRelAmountInfo(patAggDO.getParentDO().getId_pat());// 获得患者相关金额信息

		outParamInfo.setPatCode(patAggDO.getParentDO().getCode());// 患者编码
		if (getPatRelAmountInfo.getMoney_canuse() != null) {
			outParamInfo.setBalance(this.toXmlString(getPatRelAmountInfo.getMoney_canuse()));// 可用余额
		}
		resultMsg.setCode(IBlWsConst.RLT_SUCCESS);
		resultMsg.setMessage("成功");
		outParam.setOrBean(outParamInfo);
		outParam.setRltMsg(resultMsg);
		return outParam.serialize();
	}

	/**
	 * 充值
	 * 
	 * @param patDO
	 * @throws BizException
	 */
	private void recharge(PatiAggDO patAggDO, WsParamPatRegAndDistCardInfo patRegAndDistrInfo) throws BizException {
		IBlPayCmdService blPayCmdService = ServiceFinder.find(IBlPayCmdService.class);

		PatDO patDO = patAggDO.getParentDO();

		BlPrepayDTO dto = new BlPrepayDTO();
		dto.setPrepay(StringUtil.isEmpty(patRegAndDistrInfo.getPayMoney()) ? new FDouble().ZERO_DBL
				: this.toFDouble(patRegAndDistrInfo.getPayMoney()));

		dto.setSd_pttp(patRegAndDistrInfo.getTerminalType());
		dto.setId_paymod(this.findPmId(patRegAndDistrInfo.getPaymentMethod()));
		dto.setCode_paymod(patRegAndDistrInfo.getPaymentMethod());
		dto.setNum_bank(patRegAndDistrInfo.getDocumentNumber());
		dto.setPaymodeno(patRegAndDistrInfo.getOrderNumber());
		dto.setId_pat(patDO.getId_pat());

		if (this._patCardDO != null) {
			dto.setId_patcard(_patCardDO[0].getId_patcard());
			dto.setEu_cardcgmd(_patCardDO[0].getEu_cardcgmd());
			dto.setCard_amt(null);// 押金模式需要赋值
		}

		dto.setFg_medrecord(FBoolean.FALSE);
		blPayCmdService.opCollectPrepay(dto);
	}

	/**
	 * 查询付款方式
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private String findPmId(String code) throws BizException {
		IPripmRService pmService = ServiceFinder.find(IPripmRService.class);
		PriPmDO[] dos = pmService.findByAttrValString(PriPmDO.CODE, code);
		if (ArrayUtil.isEmpty(dos)) {
			throw new BizException("患者注册发卡:未查询到支付方式信息");
		}

		return dos[0].getId_pm();
	}

	/**
	 * 发卡
	 * 
	 * @param patDO
	 * @throws BizException
	 */
	private void distrCard(String cardNo, PatDO patDO) throws BizException {
		IPiCardMaintainService piCardMaintainService = ServiceFinder.find(IPiCardMaintainService.class);
		piCardMaintainService.dispCardByNo(cardNo, patDO);
	}

	/**
	 * 患者注册
	 * 
	 * @param paramBeanInfo
	 * @throws BizException
	 */
	private PatiAggDO patRegister(WsParamPatRegAndDistCardInfo paramBeanInfo) throws BizException {
		IPatiCudService patiCudService = ServiceFinder.find(IPatiCudService.class);
		PatiAggDO aggdo = getAggdo(paramBeanInfo);
		PatiAggDO[] aggDOs = patiCudService.save(new PatiAggDO[] { aggdo });
		return aggDOs[0];
	}

	/**
	 * 患者信息
	 * 
	 * @param paramBeanInfo
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO getAggdo(WsParamPatRegAndDistCardInfo paramBeanInfo) throws BizException {
		IPatiRService iPatiRService = ServiceFinder.find(IPatiRService.class);
		String patId = getPatId(paramBeanInfo);
		PatiAggDO aggdo = iPatiRService.findById(patId);
		if (aggdo == null) {
			aggdo = new PatiAggDO();
		}
		setPatDO(aggdo, paramBeanInfo,patId);
		if (!"04".equals(paramBeanInfo.getDoType())) {
			setCardDO(aggdo, paramBeanInfo);
		}

		return aggdo;
	}

	/**
	 * 获取患者id
	 * 
	 * @param paramBeanInfo
	 * @return
	 * @throws BizException
	 */
	private String getPatId(WsParamPatRegAndDistCardInfo paramBeanInfo) throws BizException {

		IPatiMDORService patiMDORService = ServiceFinder.find(IPatiMDORService.class);

		// 首先根据身份证号判断是否已存在该患者
		String Str = String.format("ID_CODE = '%s' AND SD_IDTP = '%s'", paramBeanInfo.getSdCode(),
				IPiDictCodeConst.SD_CARD_TYPE_IDENTITY);
		PatDO[] patDOByIdCard = patiMDORService.find(Str, "", FBoolean.FALSE);

		// 根据患者姓名，生日，电话三要素 判断是否存在该患者
		String whereStr = String.format("MOB = '%s' AND DT_BIRTH = '%s' AND NAME = '%s' AND SD_IDTP != '%s'",
				paramBeanInfo.getPhoneCode(), paramBeanInfo.getPatBorthday(), paramBeanInfo.getPatName(),
				IPiDictCodeConst.SD_CARD_TYPE_IDENTITY);
		PatDO[] patDOByTelBirthAndName = patiMDORService.find(whereStr, "", FBoolean.FALSE);

		// 根据身份证判断不存在该患者前提下，根据三要素判断是否存在该患者(解决患者在窗口先用其他有效证件建档，然后去自助机发卡问题)
		if (ArrayUtils.isNotEmpty(patDOByIdCard) && patDOByIdCard.length > 0) {
			return patDOByIdCard[0].getId_pat();
		} else if (ArrayUtils.isNotEmpty(patDOByTelBirthAndName) && patDOByTelBirthAndName.length > 0) {
			if (!StringUtils.isEmpty(paramBeanInfo.getSdCode())) {
				updatePatIdCard(patDOByTelBirthAndName[0], paramBeanInfo.getSdCode());// 跟新患者档案，实名为身份证
			}
			return patDOByTelBirthAndName[0].getId_pat();
		}
		return null;
	}

	/**
	 * 变更患者实名制信息
	 * 
	 * @param patDO
	 * @param sdCode
	 * @throws BizException
	 */
	private void updatePatIdCard(PatDO patDO, String sdCode) throws BizException {
		IPatiMDOCudService patiMDOCudService = ServiceFinder.find(IPatiMDOCudService.class);
		patDO.setSd_idtp(IPiDictCodeConst.SD_CARD_TYPE_IDENTITY);
		patDO.setId_idtp(IPiDictCodeConst.ID_IDTP_IDENTITY);
		patDO.setId_code(sdCode);
		patiMDOCudService.update(new PatDO[] { patDO });
	}

	/**
	 * 获取患者
	 * 
	 * @param paramBeanInfo
	 * @param patDo
	 * @throws BizException
	 */
	private void setPatDO(PatiAggDO aggdo, WsParamPatRegAndDistCardInfo paramBeanInfo,String patId) throws BizException {
		if (aggdo.getParent() != null) {
			return;
		}
		PatDO patDO = new PatDO();
		patDO.setStatus(DOStatus.NEW);
		if(StringUtil.isEmpty(patId)){
			patDO.setId_pat(new DBUtil().getOIDs(1)[0]);
		}else{
			patDO.setId_pat(patId);
		}
		patDO.setId_org(Context.get().getOrgId());
		patDO.setId_grp(Context.get().getGroupId());

		IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
		// 获取患者编码
		String code = billcodeManage.getPreBillCode_RequiresNew(PatDODesc.CLASS_FULLNAME);
		patDO.setCode(code);
		patDO.setId_code(paramBeanInfo.getSdCode());
		patDO.setName(paramBeanInfo.getPatName());
		// 拼音
		if (!StringUtils.isEmpty((paramBeanInfo.getPatName()))) {
			patDO.setPycode(CnToPy.getPyFirstCode(paramBeanInfo.getPatName()));
			// 助记码
			patDO.setMnecode(patDO.getPycode());
			patDO.setWbcode(CnToWB.getWBCode(paramBeanInfo.getPatName()));
		}
		patDO.setFg_realname(FBoolean.TRUE);
		if(!StringUtil.isEmpty(paramBeanInfo.getSdType())){
			patDO.setSd_idtp(paramBeanInfo.getSdType());
			patDO.setId_idtp(this.getIdType(paramBeanInfo.getSdType()));
		}else{
			patDO.setSd_idtp(IPiDictCodeConst.SD_IDTP_IDENTITY);
			patDO.setId_idtp(IPiDictCodeConst.ID_IDTP_IDENTITY);
		}
		patDO.setId_patsrctp(IPiDictCodeConst.ID_PATSRCTP_SELHPLPMACHINE);
		patDO.setSd_patsrctp(IPiDictCodeConst.SD_PATSRCTP_SELHPLPMACHINE);
		patDO.setId_srcregiontp(IPiDictCodeConst.ID_SRCREGIONTP_LOCAL);
		patDO.setSd_srcregiontp(IPiDictCodeConst.SD_SRCREGIONTP_LOCAL);
		patDO.setId_country("@@@@Z8100000000LIVDL");
		patDO.setSd_country("156");
		patDO.setId_nation("@@@@AA1000000000MNM3");
		patDO.setSd_nation("01");
		patDO.setFg_recordcost(FBoolean.TRUE);
		patDO.setMob(paramBeanInfo.getPhoneCode());
		patDO.setDt_birth(FDate.fromPersisted(paramBeanInfo.getPatBorthday()));
		patDO.setSd_sex(paramBeanInfo.getPatSex());
		// 基础档案必须设置id
		String idsex = getIdsex(paramBeanInfo.getPatSex());
		patDO.setId_sex(idsex);
		patDO.setWorkunit(paramBeanInfo.getWorkUnit());//工作单位赋值
		// 设置默认属性
		setInitValue(patDO);
		
		//给患者联系人赋值
		this.setPatCont(aggdo,patDO,paramBeanInfo);
		
		//4、给患者地址赋值
		this.setPatAddr(aggdo,patDO,paramBeanInfo);
		
		aggdo.setParent(patDO);
	}


	
	/**
	 * 设置患者默认属性
	 * 
	 * @param patDO
	 * @throws BizException
	 */
	private void setInitValue(PatDO patDO) throws BizException {
		// IPatientcategoryRService patientcategoryRService =
		// ServiceFinder.find(IPatientcategoryRService.class);
		// PiParams param = new PiParams();
		// String enop0170 = param.ENOP0170();
		// PiPatCaDO piPatCaDO = patientcategoryRService.findById(enop0170);
		// patDO.setId_paticate(piPatCaDO.getId_patca());
		// patDO.setId_patpritp(piPatCaDO.getId_patpritp());
		// patDO.setId_patcrettp(piPatCaDO.getId_patcrettp());

		PiPatCaDO caDo = PiGetDefaultDataUtil.getDefPatCa();
		if (caDo != null) {
			patDO.setId_paticate(caDo.getId_patca());
			patDO.setId_patpritp(caDo.getId_patpritp());
			patDO.setId_patcrettp(caDo.getId_patcrettp());
		}
	}

	/**
	 * 获取证件类型id
	 * @return
	 * @throws BizException 
	 */
	private String getIdType(String codeType) throws BizException{
		IUdidocRService iUdidocRService = ServiceFinder.find(IUdidocRService.class);
		String sql = String.format("ID_UDIDOCLIST = '%s' AND CODE = '%s'", "@@@@ZZ20000000000020", codeType);
		UdidocDO[] udidocDOs = iUdidocRService.find(sql, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(udidocDOs)){
			throw new BizException("未查询到患者证件类型");
		}
		return udidocDOs[0].getId_udidoc();
	}
	
	/**
	 * 获取性别id
	 * 
	 * @param patSex
	 * @throws BizException
	 */
	private String getIdsex(String patSex) throws BizException {
		IUdidoclistRService iUdidoclistRService = ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO[] udidoclistDOs = iUdidoclistRService.findByAttrValString("Code",
				IPiDictCodeTypeConst.SD_SEX_CODE);

		IUdidocRService iUdidocRService = ServiceFinder.find(IUdidocRService.class);
		String sql = String.format("ID_UDIDOCLIST = '%s' AND CODE = '%s'", udidoclistDOs[0].getId_udidoclist(), patSex);
		UdidocDO[] udidocDOs = iUdidocRService.find(sql, "", FBoolean.FALSE);
		return udidocDOs[0].getId_udidoc();
	}

	/**
	 * 获取就诊卡
	 * 
	 * @param paramBeanInfo
	 * @param piPatCardDO
	 * @throws BizException
	 */
	private void setCardDO(PatiAggDO aggdo, WsParamPatRegAndDistCardInfo paramBeanInfo) throws BizException {
		
		if(StringUtil.isEmpty(paramBeanInfo.getCardCode())){
			return;
		}
		
		FBoolean isManyCard = new PiParams().PIPAT0020();//患者注册是否可以绑定多张就诊卡
		if(isManyCard != null && FBoolean.FALSE.equals(isManyCard)){
			//获取患者有多少张已启用的就诊卡
			IPiPatCardDORService piPatCardDORService = ServiceFinder.find(IPiPatCardDORService.class);
			PiPatCardDO[] piPatCardDOs = piPatCardDORService.find(" sd_patcardtp = '20' and fg_act = 'Y' and id_pat = '" + aggdo.getParentDO().getId_pat() + "' ", "", FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(piPatCardDOs)){
				throw new BizException("该患者存在已启用的就诊卡，不允许再发卡");
			}
		}
		
		PiPatCardTpDO piPatCardTpDO = null;
		PiCardDO cardDO = null;
		if(!"05".equals(paramBeanInfo.getCardType())){
			cardDO = getCard(paramBeanInfo.getCardCode());
			
			ICardtypeRService cardtypeRService = ServiceFinder.find(ICardtypeRService.class);
		    piPatCardTpDO = cardtypeRService.findById(cardDO.getId_patcardtp());
		}
		
		PiPatCardDO piCardDO = new PiPatCardDO();
		piCardDO.setStatus(DOStatus.NEW);
		
		//就诊卡code和id(如果没有经过卡库管理，那么默认就诊卡)
		String sql2 = String.format("select * from pi_pat_cardtp where code = '%s' ","20");
		PiPatCardTpDO cardTpDO = (PiPatCardTpDO) new DAFacade().execQuery(sql2, new BeanHandler(PiPatCardTpDO.class));
		
	    piCardDO.setSd_patcardtp(piPatCardTpDO == null ? cardTpDO.getCode(): piPatCardTpDO.getCode());
		piCardDO.setId_patcardtp(piPatCardTpDO == null ? cardTpDO.getId_cardtp() : piPatCardTpDO.getId_cardtp());
		piCardDO.setEu_cardcgmd(piPatCardTpDO == null ? cardTpDO.getEu_cardcgmd() : piPatCardTpDO.getEu_cardcgmd());
		
		piCardDO.setCode(paramBeanInfo.getCardCode());

		piCardDO.setId_card(cardDO == null ? "" : cardDO.getId_card());
		String patId = ((PatDO) aggdo.getParent()).getId_pat();
		PiPatCardDO[] haveOtherCard = getPiPatCard(patId);
		// 已经有的卡数量+1
		piCardDO.setSortno(haveOtherCard.length + 1);
		piCardDO.setFg_def(FBoolean.TRUE);
		// 如果有一张卡了，设置成非默认
		if (haveOtherCard.length > 0)
			piCardDO.setFg_def(FBoolean.FALSE);
		piCardDO.setDt_b(AppUtils.getServerDateTime());
		piCardDO.setDt_e(new FDateTime(new FDate("2099-12-31"), new FTime("23:59:59")));
		piCardDO.setFg_act(FBoolean.TRUE);
		this._patCardDO = new PiPatCardDO[] { piCardDO };
		if (StringUtils.isNotEmpty(patId)) {
			// 患者已经有了档案 直接调用患者卡基础服务保存
			IPiPatCardDOCudService iPiPatCardDOCudService = ServiceFinder.find(IPiPatCardDOCudService.class);
			piCardDO.setId_pat(((PatDO) aggdo.getParent()).getId_pat());
			iPiPatCardDOCudService.insert(new PiPatCardDO[] { piCardDO });
		} else {
			// 第一次调用AGG基础服务，保存患者和卡
			aggdo.setPiPatCardDO(new PiPatCardDO[] { piCardDO });
		}
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
	 * 获取就诊卡
	 * 
	 * @param cardCode
	 * @return
	 * @throws BizException
	 */
	private PiCardDO getCard(String cardCode) throws BizException {
		ICardRService cardRService = ServiceFinder.find(ICardRService.class);
		PiCardDO[] piCardDOs = cardRService.findByAttrValString("Code", cardCode);
		if (piCardDOs != null && piCardDOs.length > 0) {
			return piCardDOs[0];
		} else {
			throw new BizException("卡号为【" + cardCode + "】的就诊卡不存在");
		}
	}

}
