package iih.ei.std.s.v1.bp.pi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.deptb.i.IDeptbRService;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.ei.std.d.v1.bl.pipatinfodto.d.PiPatInfoParamDTO;
import iih.ei.std.d.v1.bl.pipatinfodto.d.PiPatInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.overview.overview.d.PiPatBTDO;
import iih.pi.overview.overview.d.PiPatCbhDO;
import iih.pi.overview.overview.i.IPiPatBTDORService;
import iih.pi.overview.overview.i.IPiPatCbhDORService;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatBiolDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatContDORService;
import iih.pi.reg.pat.i.IPiPatHpDORService;
import iih.pi.reg.wsstd.bean.output.patinfo.sub.WsResultInfoGetPatInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/***
 * 患者信息查询(门诊+住院)
 * 
 * @author shaokx
 * @date: 2019.10.16
 */
public class GetPiPatInfoBP extends IIHServiceBaseBP<PiPatInfoParamDTO, PiPatInfoResultDTO> {

	@Override
	protected void checkParam(PiPatInfoParamDTO param) throws BizException {
		
		if (param == null) {
			throw new BizException("入参为空");
		}
		
		if (StringUtil.isEmpty(param.getCode_hospital())) {
			throw new BizException("入参医院编码为空");
		}

		if (StringUtil.isEmpty(param.getCode_enttp())) {
			throw new BizException("入参就诊类型为空");
		}
		
		if (!"00".equals(param.getCode_enttp()) && !"10".equals(param.getCode_enttp())) {
			throw new BizException("入参就诊类型值不正确");
		}
		
		if (IBlWsConst.ENTP_OP.equals(param.getCode_enttp())) {
			// 门诊校验
			if (StringUtil.isEmpty(param.getCode_pat()) && StringUtil.isEmpty(param.getCode_card())
					&& StringUtil.isEmpty(param.getCode_idnum())) {
				throw new BizException("入参关键信息全为空:患者编码,就诊卡号,身份证号");
			}
		} else {
			// 住院校验
			if (StringUtil.isEmpty(param.getCode_amr_ip()) && StringUtil.isEmpty(param.getCode_card()) && StringUtil.isEmpty(param.getCode_pat()) && StringUtil.isEmpty(param.getCode_idnum())) {
				throw new BizException("入参关键信息全为空:住院编号,就诊卡号,患者编码,身份证号");
			}
		}
		
	}

	@Override
	protected PiPatInfoResultDTO process(PiPatInfoParamDTO param) throws BizException {

		String patId = this.findPat(param);

		PiPatInfoResultDTO infoRlt = new PiPatInfoResultDTO();// 出参明细
		this.setPatInfo(infoRlt, patId, param);// 给出参明细赋值

		return infoRlt;
	}
	
	/**
	 * 给出参明细赋值
	 * 
	 * @param infoRlt
	 * @param patId
	 * @param patInfo
	 * @throws BizException
	 */
	private void setPatInfo(PiPatInfoResultDTO infoRlt, String patId, PiPatInfoParamDTO param) throws BizException {
		IPatiMDORService patDoRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDo = patDoRService.findById(patId);// 患者基本信息

		PatiAddrDO birthAdd = this.getPatAddDO(patId, "6");// 出生地地址信息
		if (birthAdd != null && !StringUtil.isEmpty(birthAdd.getId_admdiv())) {
			AdminAreaDO adminAreaDo = this.getAdminAreaDO(birthAdd.getId_admdiv());
			infoRlt.setAddr_birth(adminAreaDo == null ? "" : adminAreaDo.getFullname());
		}
		PatiAddrDO homeAdd = this.getPatAddDO(patId, "3");// 家庭地址信息
		if (homeAdd != null) {
			if (!StringUtil.isEmpty(homeAdd.getId_admdiv())) {
				AdminAreaDO adminAreaDo = this.getAdminAreaDO(homeAdd.getId_admdiv());
				infoRlt.setAddr_family(adminAreaDo == null ? "" : adminAreaDo.getFullname());
			}
			infoRlt.setHomestreet(homeAdd.getStreet());
			infoRlt.setHometel(homeAdd.getTel());
			infoRlt.setHomezip(homeAdd.getZip());
		}
		PatiAddrDO nowAdd = this.getPatAddDO(patId, "9");// 现住址地址信息
		if (nowAdd != null) {
			if (!StringUtil.isEmpty(nowAdd.getId_admdiv())) {
				AdminAreaDO adminAreaDo = this.getAdminAreaDO(nowAdd.getId_admdiv());
				infoRlt.setNowhomedistrict(adminAreaDo.getFullname());
			}
			infoRlt.setAddr_nowhome(nowAdd.getStreet());
			infoRlt.setTel_nowhome(nowAdd.getTel());
			infoRlt.setZip_nowhome(nowAdd.getZip());
		}
		PatiAddrDO hukouAdd = this.getPatAddDO(patId, "1");// 户口地址信息
		if (hukouAdd != null) {
			if (!StringUtil.isEmpty(hukouAdd.getId_admdiv())) {
				AdminAreaDO adminAreaDo = this.getAdminAreaDO(hukouAdd.getId_admdiv());
				infoRlt.setRegdistrict(adminAreaDo.getFullname());
			}
		}
		PatiAddrDO unitAdd = this.getPatAddDO(patId, "2");// 单位地址信息
		if (unitAdd != null) {
			if (!StringUtil.isEmpty(unitAdd.getId_admdiv())) {
				AdminAreaDO unitAreaDo = this.getAdminAreaDO(unitAdd.getId_admdiv());
				infoRlt.setUnitdistrict(unitAreaDo.getFullname());
			}
			infoRlt.setUnittel(unitAdd.getTel());
			infoRlt.setAddr_unitstreet(unitAdd.getStreet());
			infoRlt.setUnitzip(unitAdd.getZip());
		}

		if (!StringUtil.isEmpty(patDo.getId_idtp())) {
			UdidocDO IdtpUdiDocDO = this.getUdidocDO(patDo.getId_idtp(), "证件");// 证件自定义档案
			infoRlt.setName_idtp(IdtpUdiDocDO.getName());
		}
		if (!StringUtil.isEmpty(patDo.getId_sex())) {
			UdidocDO sexUdiDocDO = this.getUdidocDO(patDo.getId_sex(), "性别");// 性别自定义档案
			infoRlt.setName_sex(sexUdiDocDO.getName());
			infoRlt.setSd_sex(sexUdiDocDO.getCode());
		}
		if (!StringUtil.isEmpty(patDo.getId_nation())) {
			UdidocDO nationUdiDocDO = this.getUdidocDO(patDo.getId_nation(), "民族");// 民族自定义档案
			infoRlt.setCode_nation(nationUdiDocDO.getCode());
		}
		if (!StringUtil.isEmpty(patDo.getId_marry())) {
			UdidocDO marryUdiDocDO = this.getUdidocDO(patDo.getId_marry(), "婚姻");// 婚姻自定义档案
			infoRlt.setCode_marry(marryUdiDocDO.getCode());
		}
		if (!StringUtil.isEmpty(patDo.getId_occu())) {
			UdidocDO occuUdiDocDO = this.getUdidocDO(patDo.getId_occu(), "职业");// 职业自定义档案
			infoRlt.setCode_occu(occuUdiDocDO.getCode());
		}

		PiPatBiolDO patBiolDO = this.getPatBiolDO(patId);// 血型信息
		if (patBiolDO != null && !StringUtil.isEmpty(patBiolDO.getId_blood_abo())) {
			UdidocDO biolUdiDocDO = this.getUdidocDO(patBiolDO.getId_blood_abo(), "血型");// 血型自定义档案
			infoRlt.setName_abo(biolUdiDocDO.getName());
		}
		if (patBiolDO != null && !StringUtil.isEmpty(patBiolDO.getId_blood_rh())) {
			UdidocDO rhUdiDocDO = this.getUdidocDO(patBiolDO.getId_blood_rh(), "RH反应");// RH反应自定义档案
			infoRlt.setName_rh(rhUdiDocDO.getName());
		}
		PiPatContDO patCont = this.getPatContDO(patId);// 联系人信息
		if (patCont != null) {
			infoRlt.setName_relation(patCont.getName());
			infoRlt.setCode_relation(patCont.getSd_fmrole());
			infoRlt.setAddr_relation(patCont.getContaddr());
			infoRlt.setTel_relation(patCont.getConttel());
		}

		infoRlt.setCode_idnum(patDo.getId_code());
		infoRlt.setTel(patDo.getMob());
		infoRlt.setId_pat(patId);
		infoRlt.setCode_pat(patDo.getCode());
		infoRlt.setCode_card(this.getCodeCard(patId));
		if(!StringUtil.isEmpty(param.getCode_card())){
			String euCard = this.getEuCard(param.getCode_card());
			if(!StringUtil.isEmpty(euCard)){
				infoRlt.setEu_card(euCard);//就诊卡状态 0空白 1在用 2挂失 3注销
			}
		}
		infoRlt.setName_pat(patDo.getName());
		infoRlt.setDt_birth(patDo.getDt_birth().toString());
		infoRlt.setPat_agestr(AgeCalcUtil.getAge(patDo.getDt_birth()));
		infoRlt.setCode_paticate(patDo.getPaticate_code());// 医保类型
		infoRlt.setName_paticate(patDo.getPaticate_name());// 收费类型（自费、医保等）
		infoRlt.setWorkunit(patDo.getWorkunit());// 单位名称
		infoRlt.setPatbtinfo(this.getPatBtDO(patId));// 既往有输血史 Y是 N否
		String[] patCbhInfo = getPatCbhDO(patId);
		infoRlt.setPatcbhinfo(patCbhInfo[0]);// 既往有妊娠史 Y是 N否
		infoRlt.setCount_patcbh(patCbhInfo[1]);// 育次数 数量表示
		infoRlt.setCount_givebirth(patCbhInfo[2]);// 生产次数 数量表示
		infoRlt.setCode_insur(this.getPatHpDO(patId));// 医保计划编码

		if ("00".equals(param.getCode_enttp())) {
			// 门诊
			PatiVisitDO entDO = this.findEntInfoOp(patId, param.getTimes_en());
			IPatAccServiceExt ipatAccService = ServiceFinder.find(IPatAccServiceExt.class);
			if(entDO != null){
				IOutpatientRService outPatRService = ServiceFinder.find(IOutpatientRService.class);
				OutpatientDO entOpDO = (outPatRService.findByAttrValString("Id_ent", entDO.getId_ent()))[0];// 门诊属性
				
				if(entDO.getFg_ip() != null && entDO.getFg_ip().booleanValue()){
					infoRlt.setStatus_ip("1");//住院状态 1:在院 2:出院
				}else{
					infoRlt.setStatus_ip("2");
				}
				infoRlt.setCode_enttp(entDO.getCode_entp());
				infoRlt.setCode_ent(entDO.getCode());
				infoRlt.setTimes_op(
						StringUtil.isEmpty(param.getTimes_en()) ? this.getTimesOp(patId) : param.getTimes_en());
				if(entDO.getDt_end() != null){
					infoRlt.setDt_op_end(entDO.getDt_end().toString());
				}
				infoRlt.setCode_amr_op(entOpDO.getCode_amr_oep());
			}
			infoRlt.setAmt_opbalance(this.toXmlString(ipatAccService.GetOutpPrepaymentAmount(patId)));// 门诊账户余额
		} else {
			// 住院
			PatiVisitDO entDO = this.findEntInfoIp(patId, param.getTimes_en());
			if(entDO != null){
				IInpatientRService IpPatRService = ServiceFinder.find(IInpatientRService.class);
				InpatientDO entIpDO = (IpPatRService.findByAttrValString("Id_ent", entDO.getId_ent()))[0];// 住院属性
				IEnaccountMDORService entAccRService = ServiceFinder.find(IEnaccountMDORService.class);
				EnAccountDO entAccDO = (entAccRService.findByAttrValString("Id_ent", entDO.getId_ent()))[0];// 住院账户DO

				if(entDO.getFg_ip() != null && entDO.getFg_ip().booleanValue()){
					infoRlt.setStatus_ip("1");//住院状态 1:在院 2:出院
				}else{
					infoRlt.setStatus_ip("2");
				}
				infoRlt.setCode_enttp(entDO.getCode_entp());
				infoRlt.setCode_ent(entDO.getCode());
				infoRlt.setTimes_ip(
						StringUtil.isEmpty(param.getTimes_en()) ? this.getTimesIp(patId) : param.getTimes_en());
				infoRlt.setCode_amr_ip(entIpDO.getCode_amr_ip());
				if (!StringUtil.isEmpty(entDO.getId_dep_nur())) {
					DeptBDO nurDep = getDeptDO(entDO.getId_dep_nur());
					infoRlt.setCode_nur(nurDep.getCode());// 病区编码
					infoRlt.setName_nur(nurDep.getName());// 病区名称
				}
				if (!StringUtil.isEmpty(entDO.getId_dep_phy())) {
					DeptBDO phyDep = getDeptDO(entDO.getId_dep_phy());
					infoRlt.setName_dep(phyDep.getName());// 科室名称
				}
				infoRlt.setName_bed(entIpDO.getName_bed());// 床号
				infoRlt.setAmt_ipprepay(this.toXmlString(new FDouble(entAccDO.getAmt_prepay())));// 当前住院预交金总额
				infoRlt.setAmt_ipbalance(
						this.subUtil(infoRlt.getAmt_ipprepay(), this.toXmlString(new FDouble(entAccDO.getAmt_uncg()))));// 当前住院预交金余额
				if(entDO.getDt_acpt() != null){
					infoRlt.setDt_acpt(entDO.getDt_acpt().toString());
				}

				String[] westMedDi = this.getCiDiInfo(entDO.getId_ent(), "11");// 西医诊断
				if (westMedDi != null) {
					infoRlt.setCode_di(westMedDi[0]);
					infoRlt.setName_di(westMedDi[1]);
				}

				String[] operationDi = this.getCiDiInfo(entDO.getId_ent(), "14");// 手术诊断
				if (operationDi != null) {
					infoRlt.setCode_operatedi(operationDi[0]);// 手术诊断编码
					infoRlt.setName_operatedi(operationDi[1]);// 手术诊断名称
				}
			}
		}
	}

	/**
	 * 获得就诊卡状态 0空白 1在用 2挂失 3注销
	 * @param cardCode
	 * @return
	 * @throws BizException 
	 */
	private String getEuCard(String cardCode) throws BizException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select eu_cardsu from pi_card ");
		sql.append(" where 1=1 ");
		sql.append(" and code = ? ");

		SqlParam param = new SqlParam();
		param.addParam(cardCode);

		@SuppressWarnings("unchecked")
		Integer en_Card = (Integer) new DAFacade().execQuery(sql.toString(), param,new ColumnHandler());

		if(en_Card == null){
			return null;
		}
		return en_Card.toString();
	}
	/**
	 * 
	 * 两个string类型的减法方法，入参为string,返回结果为String
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	private String subUtil(String num1, String num2) {
		double num11 = new BigDecimal(num1).doubleValue();
		double num22 = new BigDecimal(num2).doubleValue();
		double doubleValue = new BigDecimal(num11 - num22).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
		return decimalFormat.format(doubleValue);
		// return String.valueOf(doubleValue);//double转成string时，会在末尾加上一个0，如12
		// 会变为12.0
	}

	/**
	 * 转为外部提供类型 由元转换为分
	 * 
	 * @param amt
	 */
	public String toXmlString(FDouble amt) {
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
	 * 转换为内部处理类型 由分转换为元
	 * 
	 * @param amt
	 * @return
	 */
	public FDouble toFDouble(String amt) {
		Double i = Double.parseDouble(amt);
		return new FDouble(i / 100, 2);
	}

	/**
	 * 获得患者输血史信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private String getPatBtDO(String patId) throws BizException {
		IPiPatBTDORService patBtRService = ServiceFinder.find(IPiPatBTDORService.class);
		PiPatBTDO[] patBtDOs = patBtRService.findByAttrValString("Id_pat", patId);
		Boolean isBt = false;
		if (!ArrayUtil.isEmpty(patBtDOs)) {
			isBt = true;
		}
		return isBt.toString();
	}

	/**
	 * 获得患者生育史信息(返回值String数组，固定三个元素，第一个为既往有妊娠史，第二个为育次数，第三个为生产次数)
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private String[] getPatCbhDO(String patId) throws BizException {
		IPiPatCbhDORService patChbRService = ServiceFinder.find(IPiPatCbhDORService.class);
		PiPatCbhDO[] patCbhDOs = patChbRService.findByAttrValString("Id_pat", patId);
		String[] patCbhInfo = new String[3];
		Boolean isCbh = false;// 既往有妊娠史

		if (ArrayUtil.isEmpty(patCbhDOs)) {
			patCbhInfo[0] = isCbh.toString();// 既往有妊娠史 Y是 N否
			patCbhInfo[1] = "0";// 育次数 数量表示
			patCbhInfo[2] = "0";// 生产次数 数量表示
			return patCbhInfo;
		}

		isCbh = true;
		patCbhInfo[0] = isCbh.toString();// 既往有妊娠史 Y是 N否
		patCbhInfo[1] = String.valueOf(patCbhDOs.length);// 育次数 数量表示
		Integer proCount = 0;
		for (PiPatCbhDO itm : patCbhDOs) {
			proCount = proCount + (itm.getSoncnt() == null ? 0 : itm.getSoncnt())
					+ (itm.getDaucnt() == null ? 0 : itm.getDaucnt());
		}
		patCbhInfo[2] = String.valueOf(proCount);// 生产次数 数量表示
		return patCbhInfo;
	}

	/**
	 * 获得患者血型信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PiPatBiolDO getPatBiolDO(String patId) throws BizException {
//		IPiPatBiolDORService patBiolRService = ServiceFinder.find(IPiPatBiolDORService.class);
//		PiPatBiolDO[] patBiolDOs = patBiolRService.findByAttrValString("Id_pat", patId);
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" id_pat,id_blood_abo,sd_blood_abo,id_blood_rh,sd_blood_rh ");
		sql.append(" from pi_pat_biol ");
		sql.append(" where 1=1 ");
		sql.append(" and id_pat = ? ");
		
		SqlParam param = new SqlParam();
		param.addParam(patId);

		@SuppressWarnings("unchecked")
		List<PiPatBiolDO> list = (List<PiPatBiolDO>) new DAFacade().execQuery(sql.toString(),
				param, new BeanListHandler(PiPatBiolDO.class));
		
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 获取科室病区信息
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	private DeptBDO getDeptDO(String id_dep) throws BizException {
		IDeptbRService deptRService = ServiceFinder.find(IDeptbRService.class);
		DeptBDO deptDO = deptRService.findById(id_dep);
		if (deptDO == null) {
			throw new BizException("未查询到科室或病区信息");
		}
		return deptDO;
	}

	/**
	 * 获得患者医保计划(获取启用的医保计划)
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private String getPatHpDO(String patId) throws BizException {
		IPiPatHpDORService patHpRSerivce = ServiceFinder.find(IPiPatHpDORService.class);
		PiPatHpDO[] patHpDos = patHpRSerivce.find(" id_pat = '" + patId + "' and fg_act = 'Y' ", "", FBoolean.TRUE);
		if (ArrayUtil.isEmpty(patHpDos)) {
			return null;
		}
		IHpMDORService hpRService = ServiceFinder.find(IHpMDORService.class);
		String hpCode = "";
		for (int i = 0; i < patHpDos.length; i++) {
			if (i == patHpDos.length - 1) {
				HPDO hpDO = hpRService.findById(patHpDos[i].getId_hp());
				hpCode = hpCode + (hpDO == null ? "" : hpDO.getCode());
			} else {
				HPDO hpDO = hpRService.findById(patHpDos[i].getId_hp());
				hpCode = hpCode + (hpDO == null ? "" : hpDO.getCode()) + "|";
			}
		}
		return hpCode;
	}

	/**
	 * 获取监护人信息(优先获取监护人，没有监护人的话随机找一个联系人信息)
	 * 
	 * @return
	 * @throws BizException
	 */
	private PiPatContDO getPatContDO(String patId) throws BizException {
		IPiPatContDORService patContRService = ServiceFinder.find(IPiPatContDORService.class);
		PiPatContDO[] patContDOs = patContRService.find(" id_pat = '" + patId + "' and fg_guardian = 'Y' ", "",
				FBoolean.TRUE);
		if (ArrayUtil.isEmpty(patContDOs)) {
			PiPatContDO[] concPatContDOs = patContRService.findByAttrValString("Id_pat", patId);
			if (ArrayUtil.isEmpty(concPatContDOs)) {
				return null;
			}
			return concPatContDOs[0];
		}
		return patContDOs[0];
	}

	/**
	 * 获得患者地址信息
	 * 
	 * @param patId
	 * @param addCodeType
	 * @return
	 * @throws BizException
	 */
	private PatiAddrDO getPatAddDO(String patId, String addCodeType) throws BizException {
		IPatiAddrDORService patAddRService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] patAddDO = patAddRService.find(" id_pat = '" + patId + "' and sd_addrtp = '" + addCodeType + "' ",
				"", FBoolean.TRUE);
		if (ArrayUtil.isEmpty(patAddDO)) {
			return null;
		}
		return patAddDO[0];
	}

	/**
	 * 获取诊断信息,返回值是有两个元素的String数组，第一个元素是codedi,第二个元素是namedi
	 * 
	 * @param entId
	 * @param diType
	 * @return
	 * @throws BizException
	 */
	private String[] getCiDiInfo(String entId, String diType) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" diitm.id_didef_code code_di, ");
		sql.append(" diitm.id_didef_name name_di ");
		sql.append(" from ci_di di  ");
		sql.append(" left join ci_di_itm diitm on diitm.id_di = di.id_di ");
		sql.append(" where 1=1 ");
		sql.append(" and di.id_en = ? ");
		sql.append(" and diitm.sd_disys = ? ");

		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(diType);

		@SuppressWarnings("unchecked")
		List<WsResultInfoGetPatInfo> list = (List<WsResultInfoGetPatInfo>) new DAFacade().execQuery(sql.toString(),
				param, new BeanListHandler(WsResultInfoGetPatInfo.class));

		if (ListUtil.isEmpty(list)) {
			return null;
		}

		String[] diInfo = new String[2];
		String codeDi = "";
		String nameDi = "";
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				codeDi = codeDi + (list.get(i).getCode_di() == null ? "" : list.get(i).getCode_di());
				nameDi = nameDi + (list.get(i).getName_di() == null ? "" : list.get(i).getName_di());
			} else {
				codeDi = codeDi + (list.get(i).getCode_di() == null ? "" : list.get(i).getCode_di()) + "|";
				nameDi = nameDi + (list.get(i).getName_di() == null ? "" : list.get(i).getName_di()) + "|";
			}
		}

		diInfo[0] = codeDi;
		diInfo[1] = nameDi;
		return diInfo;
	}

	/**
	 * 获得区县信息
	 * 
	 * @param id_admdiv
	 * @return
	 * @throws BizException
	 */
	private AdminAreaDO getAdminAreaDO(String id_admdiv) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select fullname  ");
		sql.append(" from bd_adminarea ");
		sql.append(" where 1=1 ");
		sql.append(" and id_adminarea = ? ");

		SqlParam param = new SqlParam();
		param.addParam(id_admdiv);

		@SuppressWarnings("unchecked")
		List<AdminAreaDO> list = (List<AdminAreaDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(AdminAreaDO.class));

		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 获得患者启用的就诊卡号，如果多个，用|隔开
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private String getCodeCard(String patId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select code from pi_pat_card ");
		sql.append(" where 1=1 ");
		sql.append(" and fg_act = 'Y' ");
		sql.append(" and id_pat = ? ");

		SqlParam param = new SqlParam();
		param.addParam(patId);

		@SuppressWarnings("unchecked")
		List<PiPatCardDO> list = (List<PiPatCardDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(PiPatCardDO.class));

		String code_Card = "";
		if (!ListUtil.isEmpty(list)) {
			for (int i = 0; i < list.size(); i++) {
				if (i == list.size() - 1) {
					code_Card = code_Card + (list.get(i).getCode() == null ? "" : list.get(i).getCode());
				} else {
					code_Card = code_Card + (list.get(i).getCode() == null ? "" : list.get(i).getCode()) + "|";
				}
			}
		}

		return code_Card;
	}

	/**
	 * 获得患者自定义档案
	 * 
	 * @param id_Udidoc
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getUdidocDO(String id_Udidoc, String note) throws BizException {
		if (StringUtil.isEmpty(id_Udidoc)) {
			throw new BizException(" " + note + "自定义档案入参为空 ");
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select name,code,id_udidoclist from bd_udidoc ");
		sql.append(" where 1=1 ");
		sql.append(" and id_udidoc = ? ");

		SqlParam param = new SqlParam();
		param.addParam(id_Udidoc);

		@SuppressWarnings("unchecked")
		List<UdidocDO> list = (List<UdidocDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(UdidocDO.class));

		if (ListUtil.isEmpty(list)) {
			throw new BizException("未查询到" + note + "自定义档案 ");
		}
		return list.get(0);
	}

	/**
	 * 根据人员id和就诊次数查询就诊信息（住院）
	 * 
	 * @param patId
	 * @param enTimes
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO findEntInfoIp(String patId, String enTimes) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ent.* from  ");
		sql.append(" en_ent ent ");
		sql.append(" INNER join en_ent_ip entip on ent.id_ent=entip.id_ent ");
		sql.append(" where ent.id_pat=? ");
		sql.append(" and entip.times_ip=? ");
		SqlParam param = new SqlParam();
		param.addParam(patId);
		if (!StringUtil.isEmpty(enTimes)) {
			param.addParam(enTimes);
		} else {
			// 查询这个患者当前的就诊次数
			String timesIp = this.getTimesIp(patId);
			param.addParam(timesIp);
		}

		@SuppressWarnings("unchecked")
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(PatiVisitDO.class));
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 根据患者id查询到患者当前的就诊次数（住院）
	 * 
	 * @return
	 * @throws DAException
	 */
	private String getTimesIp(String patId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select entip.times_ip ");
		sql.append(" from en_ent ent ");
		sql.append(" inner join en_ent_ip entip ");
		sql.append(" on ent.id_ent = entip.id_ent ");
		sql.append(" where ent.id_pat = ? ");
		sql.append(" order by entip.times_ip desc ");

		SqlParam param = new SqlParam();
		param.addParam(patId);

		@SuppressWarnings("unchecked")
		List<InpatientDO> list = (List<InpatientDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(InpatientDO.class));

		if (list == null || list.size() == 0) {
			return "0";
		}
		return list.get(0).getTimes_ip().toString();
	}

	/**
	 * 根据人员id和就诊次数查询就诊信息（门诊）
	 * 
	 * @param patId
	 * @param enTimes
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO findEntInfoOp(String patId, String enTimes) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ent.* from  ");
		sql.append(" en_ent ent ");
		sql.append(" INNER join en_ent_op entop on ent.id_ent=entop.id_ent ");
		sql.append(" where ent.id_pat=? ");
		sql.append(" and entop.times_op=? ");
		SqlParam param = new SqlParam();
		param.addParam(patId);
		if (!StringUtil.isEmpty(enTimes)) {
			param.addParam(enTimes);
		} else {
			// 查询这个患者当前的就诊次数
			String timesOp = this.getTimesOp(patId);
			param.addParam(timesOp);
		}

		@SuppressWarnings("unchecked")
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(PatiVisitDO.class));
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 根据患者id查询到患者当前的就诊次数(门诊)
	 * 
	 * @return
	 * @throws DAException
	 */
	private String getTimesOp(String patId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select entop.times_op ");
		sql.append(" from en_ent ent ");
		sql.append(" inner join en_ent_op entop ");
		sql.append(" on ent.id_ent = entop.id_ent ");
		sql.append(" where ent.id_pat = ? ");
		sql.append(" order by entop.times_op desc ");

		SqlParam param = new SqlParam();
		param.addParam(patId);

		@SuppressWarnings("unchecked")
		List<OutpatientDO> list = (List<OutpatientDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(OutpatientDO.class));

		if (list == null || list.size() == 0) {
			return "0";
		}
		return list.get(0).getTimes_op().toString();
	}

	/**
	 * 查询患者
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(PiPatInfoParamDTO param) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(param.getCode_pat());
		condDto.setId_code(param.getCode_idnum());
		condDto.setCard_code(param.getCode_card());
		condDto.setCode_amr_ip(param.getCode_amr_ip());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("未查询到患者信息");
		}

		return patiAggs[0].getParentDO().getId_pat();
	}

}
