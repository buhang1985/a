package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeTypeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.fc.enstate.i.IEnstateRService;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bl.hp.i.IBlHpOutQryService;
import iih.bl.itf.std.inner.en.IBlOpChargeForEnInnerService;
import iih.en.comm.bp.PatQryBP;
import iih.en.comm.ep.DayslotEP;
import iih.en.comm.ep.EnTagtpEP;
import iih.en.comm.ep.EntDiEP;
import iih.en.comm.ep.EntStateEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.dto.d.PatTagDTO;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.i.IEnIpQryService;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import iih.en.pv.s.bp.SetEntBannerWeightBP;
import iih.en.pv.s.bp.ip.CalculateHosDaysBP;
import iih.en.que.dto.d.TriageEntDTO;
import iih.en.que.i.IEnQueOutQryService;
import iih.mi.mc.i.IMiMcRuleService;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import iih.pi.banner.d.PatientBannerDTO;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.d.PiPatPhyDO;
import iih.pi.overview.overview.i.IPiPatPhyDORService;
import iih.pi.reg.i.IPiRegQryService;
import iih.sc.pub.ScGroupControlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * Banner查询BP
 * 
 * @author yank
 *
 */
public class GetEntInfo4BannerBP {
	
	private static final String SV_GET_ALL_DAIG_NAME = "getalldiagname";// 获取患者全部诊断信息
	private static final String SV_GET_MIMCSPEC = "getmimcspec";// 获取患者特病信息
	private static final String SV_GET_ALLERGYHIS = "getallergyhis";// 获取过敏史
	private static final String SV_GET_PHYSTATE = "getphystate";// 获取生理状态
	private static final String SV_GET_PATADDRESS = "getpataddress";// 获取患者现住址
	private static final String SV_GET_DIAGNOSIS = "getdiagnosis";// 获取诊断
	private static final String SV_GET_ENSTATUS_NAME = "getenstatusname";// 获取就诊状态名称
	private static final String SV_GET_INHOSDAYS = "getinhosdays";// 获取住院天数
	private static final String SV_GET_ISINHPBBR = "getisinhpbbr";// 获取是否在医保黑名单
	private static final String SV_GET_ISGCVIP = "getisgcvip";// 获取是否是绿色通道患者VIP
	private static final String SV_GET_ISHPSPCL = "getishpspcl";// 获取是否医保特种病患者
	private static final String SV_GET_PATACC_BAL = "getpataccbal";//获取患者账户余额
	private static final String SV_GET_ISALLINHP = "getisallinhp";//获取是否全保内(副部级)标识
	private static final String SV_GET_PATWEIGHT = "getpatweight";//获取患者体重
	private static final String SV_GET_PATTAG = "getpattag";//获取患者标签
	private static final String SV_GET_PRINTCHLIDENT = "getchlprintident";//获取预约渠道标识
	private static final String SV_GET_GRAVIDARISK = "getgravidarisk";//获取孕妇风险等级
	private static final String SV_GET_GETENSTATELOGOS = "getenstatelogos";//获取就诊状况图标
	private static final String SV_GET_GETENTOPREGINFO = "getentopreginfo";//获取 分诊台 多个字段服务
	private static final String SV_GET_HPCPAMTMSG = "gethpcpamtmsg";//获取临床路径费用提示信息
	private static final String SV_GET_FG_PAY_REGIST = "getfgpayregist";//获取患者门诊挂号费是否已记账，显示为已扣款/未扣款
	public static final String SYNC_FROM_THIRDPLATFORM = "syncfromthird";//从第三方系统同步患者数据	
	private static final String PAT_ACC_BAL_WARN_FORMATTER ="小于%s元";//TODO 后续转移至banner设计器处理

	/**
	 * 
	 * @param sqlStr 查询语句
	 * @param whereStr 查询条件
	 * @param svName 服务名称，多个逗号隔开
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Ent4BannerDTO[] exec(String sqlStr, String whereStr, String svName, SqlParamDTO sqlParam, String inputValue) throws BizException {
		long bz = System.currentTimeMillis();
		String sql = null;
		SqlParam param = EnAppUtils.convertToSqlParam(sqlParam);
		if(!EnValidator.isEmpty(sqlParam)){
			inputValue = (String) sqlParam.get(0);
		}
		if (EnValidator.isEmpty(sqlStr)) {
			sql = this.getQrySql(whereStr);
		} else {
			sql = sqlStr + 	" and "+ ScGroupControlUtils.getGroupControlFitler(new PatiVisitDODesc(), "enent");//集团管控
			sql = sql + whereStr;
			if(sql.contains("dt_insert"))
				sql = sql + " order by dt_insert desc ";
		}
		
		long e = System.currentTimeMillis();
		EnLogUtil.getInstance().logInfo("          方法GetEntInfo4BannerBP耗时：准备："+(e - bz));	
		long b1 = System.currentTimeMillis();
		List<Ent4BannerDTO> bannerDTOList = (List<Ent4BannerDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(Ent4BannerDTO.class));
		if (bannerDTOList == null || bannerDTOList.size() <= 0) {
			if(!EnValidator.isEmpty(inputValue) && !EnValidator.isEmpty(svName)){
				svName = svName.toLowerCase();
				//从第三方患者唯一管理平台同步患者信息
				if (svName.contains(SYNC_FROM_THIRDPLATFORM)) {
					IPiRegQryService piRegQryService = ServiceFinder.find(IPiRegQryService.class);
					PatientBannerDTO patientBannerDTO = piRegQryService.getPatiBannerFromThirdSystem(inputValue);
					if(!EnValidator.isEmpty(patientBannerDTO)){
						String tsql = this.getQrySql(String.format(" enent.code_pat = '%s' ", inputValue));
						bannerDTOList = (List<Ent4BannerDTO>) new DAFacade().execQuery(tsql, new SqlParam(), new BeanListHandler(Ent4BannerDTO.class));
					}
				}
			}
		}
		if (bannerDTOList == null || bannerDTOList.size() <= 0) {
			return null;
		}
		//查询就诊banner必要字段
		this.handleNecField(bannerDTOList);
		long e1 = System.currentTimeMillis();
		EnLogUtil.getInstance().logInfo("          方法GetEntInfo4BannerBP耗时：查询："+(e1 - b1));
		long b2 = System.currentTimeMillis();
		// 只加载第一个就诊的详细信息，其他用不到		
		Ent4BannerDTO bannerDTO = bannerDTOList.get(0);
		if (EnValidator.isEmpty(sqlStr)) {
			this.loadAllDetail(bannerDTO);
		} else {
			this.loadAllDetailBySv(bannerDTO, svName);
		}
		long e12 = System.currentTimeMillis();
		EnLogUtil.getInstance().logInfo("          方法GetEntInfo4BannerBP耗时：查询2："+(e12 - b2));
		long ez = System.currentTimeMillis();
		EnLogUtil.getInstance().logInfo("          方法GetEntInfo4BannerBP总耗时："+(ez - bz));
		return bannerDTOList.toArray(new Ent4BannerDTO[0]);
	}

	/**
	 * TODO 涉及32张表查询，且不断的变更扩展，设计者，一定要考量方案是否可行 yank 获取查询SQL 于强提供
	 * 
	 * @param condition 查询条件
	 * @return
	 * @author yuqiang
	 */
	private String getQrySql(String condition) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" select  TOP 5  * from ");// 默认取前5条，2016-03-17
		sqlBuilder.append("  (");
		sqlBuilder.append("  select      ");
		sqlBuilder.append("  enent.id_ent,/*诊断记录ID*/");
		sqlBuilder.append("  enent.fg_ip,/*在院记录*/");
		sqlBuilder.append("  entip.code_amr_ip,/*住院号*/");
		sqlBuilder.append("  entip.times_ip,/*住院次数*/");
		sqlBuilder.append("  entip.sd_pe_psntp,/*体检类型*/");
		sqlBuilder.append("  case when entip.sd_pe_psntp = '02' then 'Y' else 'N' end as fg_pe_group,/*团检标志*/");
		sqlBuilder.append("  '【团检】' as pe_group,/*团检*/");
		sqlBuilder.append("  patient.code as code_pat,/*患者Code*/");
		sqlBuilder.append("  patient.id_pat,/*患者id*/");
		sqlBuilder.append("  patient.fg_realname,/*实名认证*/");
		sqlBuilder.append("  patient.barcode_chis,");// 老chis的患者码
		sqlBuilder.append("  /*---------患者信息开始---------*/");
		sqlBuilder.append("  enent.name_pat,/*1姓名*/");
		sqlBuilder.append("  patient.photo as photo_pat,/*患者头像*/");
		sqlBuilder.append("  udisex.name as Name_SEX,/*2性别*/");
		sqlBuilder.append("  patient.SD_SEX AS SD_SEX,/*2性别编码*/");
		sqlBuilder.append("  enent.dt_birth_pat as dt_birth,/*3出生日期*/");
		sqlBuilder.append("  nation.name as nation,/*4民族*/");
		sqlBuilder.append("  patient.sd_occu as ,  /*5职业编码*/ ");
		sqlBuilder.append(" nvl(patient.mob,patient.tel) as phonenum,/*8电话 先 移动电话 固定电话*/");
		sqlBuilder.append(" patient.mob,patient.tel,");
		sqlBuilder.append(" marry.name as  marryhis,/*9婚史*/    ");
		sqlBuilder.append(" (select count(*) from pi_pat_cbh where id_pat=patient.id_pat ) as birthhis,/*育史*/     ");
		sqlBuilder.append(" (select count(*) from pi_pat_DI where id_pat=patient.id_pat ) as sicknesshis,/*疾病史*/");
		sqlBuilder.append(" (select name from BD_HP where BD_HP.id_hp in(select id_hp from PI_PAT_HP where PI_PAT_HP.id_pat=enent.id_pat and fg_deft='Y') and rownum=1) as pipathpname,/*医保 保险计划*/ ");
		sqlBuilder.append(" idtp.code as sd_idtp,/*证件类型编码*/ ");
		sqlBuilder.append(" idtp.name as id_idtp,/*证件类型*/ ");
		sqlBuilder.append("  patient.id_code,/*证件号码*/ ");
		sqlBuilder.append(" /*---------患者信息结束---------*/ ");
		sqlBuilder.append("  enent.CODE as code_ent,/*就诊号*/");
		sqlBuilder.append("  enent.ID_HP,/*医保计划*/");
		sqlBuilder.append("  hp.name as name_hp,/*医保计划名称*/");
		sqlBuilder.append("  hp.sd_hptp,/*医保计划类型*/");
		sqlBuilder.append("  hp.fg_hpcg,/*医保记账标志*/");
		sqlBuilder.append("  enthp.no_hp as no_hp,/*医保卡号*/");
		sqlBuilder.append("  enthp.fg_fundpay as fg_hpfundpay,/*医保基金支付标志*/");
		sqlBuilder.append("  entip.id_bed,/*床位号id*/");
		sqlBuilder.append("  bdbed.name as Name_bed,/*床位号*/");
		sqlBuilder.append("  dept.name as NAME_DEP_PHY,/*科室*/");
		sqlBuilder.append("  enent.ID_DEP_PHY,/*科室id*/");
		sqlBuilder.append("  enent.id_dep_nur,/*病区id*/");
		sqlBuilder.append("  nursingdept.name as Name_dep_nur,/*护理病区*/");
		sqlBuilder.append("  enent.ID_WG_PHY,/*临床组id*/");
		sqlBuilder.append("  bdwg.name as NAME_WG_PHY ,/*临床组*/");
		sqlBuilder.append("  enent.ID_EMP_PHY,/*主治医生id*/");
		sqlBuilder.append("  psndoc.name as NAME_EMP_PHY,/*主治医生*/");
		sqlBuilder.append("  enent.ID_EMP_NUR,/*责任护士id*/ ");
		sqlBuilder.append("  psndocn.name as NAME_EMP_NUR,/*责任护士*/   ");
		sqlBuilder.append("  enent.dt_acpt,/*住院开始时间  住院天数*/   ");
		sqlBuilder.append("  enent.id_pripat,/*价格分类id*/  ");
		sqlBuilder.append("  pripat.name as name_pripat,/*价格分类*/  ");
		sqlBuilder.append("  enent.ID_PATCRET,/*信用分类id*/  ");
		sqlBuilder.append("  patcert.name as name_patcret,/*信用分类*/");
		sqlBuilder.append("  entip.ID_LEVEL_NUR,/*护理等级id*/");
		sqlBuilder.append("  entip.SD_LEVEL_NUR,/*护理等级编码*/");
		sqlBuilder.append("  nursinglevel.name as NAME_LEVEL_NUR,/*护理等级*/");
		sqlBuilder.append("  illnesslevel.name as NAME_LEVEL_DISE,/*病情等级*/");
		sqlBuilder.append("  entip.ID_LEVEL_DISE,/*病情等级id*/");
		sqlBuilder.append("  entip.SD_LEVEL_DISE,/*病情等级编码*/");
		sqlBuilder.append("  entip.FG_BLRECALL,/*费用召回标识*/");
		sqlBuilder.append("  patca.id_patca as patcaid, /*患者分类id*/");
		sqlBuilder.append("  patca.code as patcacode, /*患者分类code*/");
		sqlBuilder.append("  patca.name as patcaname, /*患者分类*/");
//		sqlBuilder.append("  (patacc.prepay-patacc.acc_lock) as patacc_balance,/*余额*/ "); 用服务加载
		sqlBuilder.append("  enent.id_entp,/*就诊类型id*/");
		sqlBuilder.append("  enent.code_entp,/*就诊类型code*/");
		sqlBuilder.append("  bdentp.name as Name_entp,/*就诊类型name*/");
		sqlBuilder.append("  enent.dt_entry as dt_entry,/*入院时间*/");
		sqlBuilder.append("  enent.fg_st as fg_st,/*就诊结算标识*/");
		sqlBuilder.append("  fg_NEWBORN,/*新生儿标识*/");
		sqlBuilder.append("  case when fg_NEWBORN='N' then '否' else '是' end  as IsNEWBORN, Num_NEWBORN ,/*新生儿*/ ");
		sqlBuilder.append("  case when hpcpapp.cpname is null then ' ' else  hpcpapp.cpname end as Name_CP, /*临床路径名称*/ ");
		sqlBuilder.append("  case when enent.code_entp='10' then entip.sd_status else entop.sd_status end as sd_status,/*就诊状态*/");
		sqlBuilder.append("  entop.times_op,/*门诊就诊次数*/");
		sqlBuilder.append("  entop.fg_needrtn, /*待回诊*/");
		sqlBuilder.append("  entop.fg_first, /*初诊标志*/");
		sqlBuilder.append("  enent.dt_end, /*就诊结束时间*/");
		sqlBuilder.append("  entop.sd_svrtp as sd_srvtp, /*号别编码*/");
		sqlBuilder.append("  entop.dt_valid_b as dt_valid_b, /*挂号有效期开始时间*/");
		sqlBuilder.append("  entop.dt_valid_e as dt_valid_e, /*挂号有效期结束时间*/");
		sqlBuilder.append("  srvtp.name as name_srvtp, /*号别*/");
		sqlBuilder.append("  enentacc.AMT_PREPAY as prepay_amount,/*押金*/");
		sqlBuilder.append("  enentacc.AMT_UNCG as Cp_cost,/*记帐总费用*/");
		sqlBuilder.append("  (enentacc.amt_prepay - enentacc.amt_uncg) as prepay_balance,/*押金余额*/ ");
		sqlBuilder.append("  enent.id_grp,enent.id_org, ");//集团组织
		sqlBuilder.append("  enent.dt_insert, ");//挂号时间
		sqlBuilder.append("  enthp.code_hparea, ");//统筹区域编码
		sqlBuilder.append("  bdhpreg.name as name_hparea, ");
		sqlBuilder.append("  enent.fg_data_transf, ");//归档标识
		sqlBuilder.append("  hpmedkind.name as name_hpmedkind ");//医保医疗类别
		sqlBuilder.append("  from EN_ENT enent");
		sqlBuilder.append("  left join EN_ENT_ACC enentacc on enent.id_ent=enentacc.id_ent ");
		sqlBuilder.append("  left join pi_pat patient on patient.id_pat=enent.id_pat and patient.fg_invd='N'");
		sqlBuilder.append("  left join pi_pat_acc patacc on patient.id_pat=patacc.id_pat");
		sqlBuilder.append("  left join PI_PAT_CA patca on enent.id_patca=patca.id_patca/*患者分类*/");
		sqlBuilder.append("  left join PI_PAT_CRET patcert on enent.id_patcret=patcert.id_patcret/*信用分类*/");
		sqlBuilder.append("  left join BD_PRI_PAT pripat on enent.id_pripat=pripat.id_pripat/*价格分类*/");
		sqlBuilder.append("  left join bd_udidoc marry on patient.id_marry=marry.id_udidoc/*患者婚姻状况*/");
		sqlBuilder.append("  left join bd_udidoc idtp on patient.id_idtp=idtp.id_udidoc/*]证件类型*/");
		sqlBuilder.append("  left join bd_udidoc nation on patient.id_nation=nation.id_udidoc/*民族*/");
		sqlBuilder.append("  left join bd_dep dept on enent.id_dep_phy=dept.id_dep/*科室*/    ");
		sqlBuilder.append("  left join bd_dep nursingdept on  enent.id_dep_nur=nursingdept.id_dep/*护理病区*/  ");
		sqlBuilder.append("  left join bd_wg bdwg on enent.ID_WG_PHY=bdwg.id_wg/*临床组*/");
		sqlBuilder.append("  left join bd_psndoc psndoc on psndoc.id_psndoc=enent.id_emp_phy/*主管医生*/");
		sqlBuilder.append("  left join bd_psndoc  psndocn on psndocn.id_psndoc=enent.id_emp_nur/*责任护士*/");
		sqlBuilder.append("  left join bd_udidoc udisex on udisex.id_udidoc=enent.id_sex_pat        ");
		sqlBuilder.append("  left join EN_ENT_IP entip on enent.id_ent=entip.id_ent and enent.fg_ip='Y' /*住院*/");
		sqlBuilder.append("  left join en_ent_op entop on enent.id_ent=entop.id_ent /*门诊*/");
		sqlBuilder.append("  left join bd_udidoc nursinglevel on entip.id_level_nur=nursinglevel.id_udidoc/*护理等级*/");
		sqlBuilder.append("  left join bd_udidoc illnesslevel on entip.id_level_DISE=illnesslevel.id_udidoc/*病情等级*/  ");
		sqlBuilder.append("  left join BD_BED bdbed on entip.id_bed=bdbed.id_bed/*床位号*/   ");
		sqlBuilder.append("  LEFT JOIN BD_HP HP  ON enent.ID_HP = HP.ID_HP/*医保计划*/ ");
		sqlBuilder.append("  LEFT JOIN bd_entp bdentp  ON enent.id_entp = bdentp.id_entp/*就诊类型*/ ");
		sqlBuilder.append("  LEFT JOIN hp_cp_app hpcpapp on hpcpapp.id_ent=enent.id_ent /*临床路径*/");
		sqlBuilder.append("  LEFT JOIN en_ent_hp enthp on enthp.id_ent=enent.id_ent and fg_maj='Y' /*就诊医保*/");
		sqlBuilder.append("  left join bd_mhi_region bdhpreg on enthp.code_hparea = bdhpreg.code and enthp.id_hp = bdhpreg.id_hp");//医保产品地区目录
		sqlBuilder.append("  LEFT JOIN bd_udidoc srvtp on entop.id_svrtp=srvtp.id_udidoc /*号别*/");
		sqlBuilder.append("  LEFT JOIN bd_hp_med_kind_ah hpmedkind on hpmedkind.code = enent.code_hpmedkind and hpmedkind.id_hp = enent.id_hp /*医保医疗类别*/");
		sqlBuilder.append("  order by enent.dt_insert desc) enent");

		sqlBuilder.append(" where 1=1 ");
		//集团管控
		String grp = Context.get().getGroupId();
		String org = Context.get().getOrgId();
		sqlBuilder.append(" and ").append(ScGroupControlUtils.getGroupControlFitler(new PatiVisitDODesc(), "enent"));

		if (!EnValidator.isEmpty(condition)) {
			sqlBuilder.append(" AND " + condition);
		}
		return sqlBuilder.toString();
	}

	/**
	 * 加载所有详情
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadAllDetail(Ent4BannerDTO bannerDTO) throws BizException {
		this.loadAllergy(bannerDTO);// 加载过敏史
		this.loadDiagnosis(bannerDTO);// 加载诊断
		this.loadPhyState(bannerDTO);// 加载生理状态
		this.loadPatAddress(bannerDTO);// 加载患者地址
		this.loadIpPatTp(bannerDTO);// 加载住院患者分类
		this.loadEnStatusName(bannerDTO);// 加载就诊状态		
		this.loadInHosDays(bannerDTO);// 加载住院天数
		this.loadIsInHpBbr(bannerDTO);// 加载是否在医保黑名单
		this.loadIsGcVip(bannerDTO);// 加载是否绿色通道VIP
		this.loadIsHpSpcl(bannerDTO);//医保特病标志
		this.loadPatAccBal(bannerDTO);//加载患者账户余额
		this.loadIsAllInHp(bannerDTO);//加载是否全保内(副部级)
		this.loadPatWeight(bannerDTO);//加载体重
		this.loadPatTag(bannerDTO);//加载患者标签
		this.loadChlPrintIdent(bannerDTO);//获取预约渠道标识
		this.loadGravidarisk(bannerDTO);//获取孕妇风险等级
		this.loadEnstateLogos(bannerDTO);//加载就诊状况图标
		this.loadEntOpRegInfo(bannerDTO);//获取 分诊台 多个字段服务
		this.loadPatMiMcSpec(bannerDTO);//获取患者特病信息
		this.loadAllDiagName(bannerDTO);//获取患者全部诊断信息
		this.loadFgPayRegist(bannerDTO);//获取患者门诊挂号费是否已记账
	}

	/**
	 * 根据服务加载详情
	 * 
	 * @param bannerDTO
	 * @param svName
	 * @throws BizException
	 */
	private void loadAllDetailBySv(Ent4BannerDTO bannerDTO, String svName) throws BizException {
		this.loadIpPatTp(bannerDTO);// 加载住院患者分类
		if (!EnValidator.isEmpty(svName)) {
			svName = svName.toLowerCase();
			if (svName.contains(SV_GET_ALLERGYHIS)) {
				this.loadAllergy(bannerDTO);// 加载过敏史
			}
			if (svName.contains(SV_GET_PHYSTATE)) {
				this.loadPhyState(bannerDTO);// 加载生理状态
			}
			if (svName.contains(SV_GET_PATADDRESS)) {
				this.loadPatAddress(bannerDTO);// 加载患者地址
			}
			if (svName.contains(SV_GET_DIAGNOSIS)) {
				this.loadDiagnosis(bannerDTO);// 加载诊断
			}
			if (svName.contains(SV_GET_ENSTATUS_NAME)) {
				this.loadEnStatusName(bannerDTO);// 加载就诊状态
			}
			if (svName.contains(SV_GET_INHOSDAYS)) {
				this.loadInHosDays(bannerDTO);// 加载住院天数
			}
			if (svName.contains(SV_GET_ISINHPBBR)) {
				this.loadIsInHpBbr(bannerDTO);// 是否在医保黑名单
			}
			if (svName.contains(SV_GET_ISGCVIP)) {
				this.loadIsGcVip(bannerDTO);// 是否是绿色通道VIP
			}
			if (svName.contains(SV_GET_ISHPSPCL)) {
				this.loadIsHpSpcl(bannerDTO);// 是否医保特殊病
			}
			if(svName.contains(SV_GET_PATACC_BAL)){
				this.loadPatAccBal(bannerDTO);//加载患者账户余额
			}
			if(svName.contains(SV_GET_ISALLINHP)){
				this.loadIsAllInHp(bannerDTO);//加载是否全保内(副部级)
			}
			if(svName.contains(SV_GET_PATWEIGHT)){
				this.loadPatWeight(bannerDTO);//加载体重
			}
			if(svName.contains(SV_GET_PATTAG)){
				this.loadPatTag(bannerDTO);//加载患者标签
			}
			if(svName.contains(SV_GET_PRINTCHLIDENT)){
				this.loadChlPrintIdent(bannerDTO);//获取预约渠道标识
			}
			if(svName.contains(SV_GET_GRAVIDARISK)){
				this.loadGravidarisk(bannerDTO);//获取孕妇风险等级
			}
			if(svName.contains(SV_GET_GETENSTATELOGOS)){
				this.loadEnstateLogos(bannerDTO);//加载就诊状况图标
			}
			if (svName.contains(SV_GET_GETENTOPREGINFO)) {
				this.loadEntOpRegInfo(bannerDTO);//获取 分诊台 多个字段服务
			}
			if(svName.contains(SV_GET_HPCPAMTMSG)){
				this.loadHpCpAmtMsg(bannerDTO);//获取临床路径费用提示信息
			}
			if(svName.contains(SV_GET_MIMCSPEC)){
				this.loadPatMiMcSpec(bannerDTO);//获取患者特病信息
			}
			if(svName.contains(SV_GET_ALL_DAIG_NAME)){
				this.loadAllDiagName(bannerDTO);//获取患者全部诊断信息
			}
			if (svName.contains(SV_GET_FG_PAY_REGIST)) {
				this.loadFgPayRegist(bannerDTO);//获取患者门诊挂号费是否已记账
			}
		}
	}
	/**
	 * 获取临床路径费用提示信息
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadHpCpAmtMsg(Ent4BannerDTO bannerDTO) throws BizException {
		bannerDTO.setMsg_amt("~");
		if(EnValidator.isEmpty(bannerDTO.getName_cp()))
			return;
		if(bannerDTO.getCp_cost() == null || bannerDTO.getCp_avgcost() == null)
			return;
		if(bannerDTO.getCp_cost().compareTo(bannerDTO.getCp_avgcost()) > 0)
			bannerDTO.setMsg_amt("总费用超出临床路径平均费用");
	}
	/**
	 * 处理过敏史
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadAllergy(Ent4BannerDTO bannerDTO) throws BizException {
		if (EnValidator.isEmpty(bannerDTO.getId_pat()))
			return;		
		List<PiPatAlDO>  piPatDlDOList=(List<PiPatAlDO>)new DAFacade().findByCond(PiPatAlDO.class,"id_pat ='"+bannerDTO.getId_pat()+"'");				
		if (EnValidator.isEmpty(piPatDlDOList)) {
			bannerDTO.setAllergyhis("");// 显示为空
			return;
		}

		StringBuilder allergyBuilder = new StringBuilder();
		boolean first = true;
		for (PiPatAlDO piPatAlDO : piPatDlDOList) {
			if (first)
				first = false;
			else {
				allergyBuilder.append(",");
			}
			allergyBuilder.append(piPatAlDO.getName_alcla());
		}
		bannerDTO.setAllergyhis(allergyBuilder.toString());
	}

	/**
	 * 加载住院患者类别
	 * 
	 * @param bannerDTO
	 */
	private void loadIpPatTp(Ent4BannerDTO bannerDTO) throws BizException {
		// 如果是住院，则加载住院患者级别
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(bannerDTO.getCode_entp())) {
			IEnIpQryService ipQryService = ServiceFinder.find(IEnIpQryService.class);
			String patTp = ipQryService.getEntPatTp(bannerDTO.getId_ent(), EnContextUtils.getDeptId(),
					EnContextUtils.getPsnId());
			bannerDTO.setEntpattp(patTp);
		}
	}

	/**
	 * 加载生理状态
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadPhyState(Ent4BannerDTO bannerDTO) throws BizException {	
		IPiPatPhyDORService phyRService = ServiceFinder.find(IPiPatPhyDORService.class);
		String whereStr = String.format("id_pat='%s'", bannerDTO.getId_pat());
		PiPatPhyDO[] phyDOs = phyRService.find(whereStr, null, FBoolean.TRUE);
		int length = phyDOs == null ? 0 : phyDOs.length;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			builder.append(phyDOs[i].getName_phyindopt());
			if (i != length - 1) {
				builder.append(",");
			}
		}
		bannerDTO.setPhystate(builder.toString());
	}

	/**
	 * 加载患者地址
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadPatAddress(Ent4BannerDTO bannerDTO) throws BizException {
		PatQryBP patQryBP = new PatQryBP();
		String address = patQryBP.getPresentAddress(bannerDTO.getId_pat());
		bannerDTO.setAddress(address);
	}

	/**
	 * 加载就诊状态 如果是待回诊，则其装为待回诊，否则取状态自定义档案名称
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadEnStatusName(Ent4BannerDTO bannerDTO) throws BizException {
		if (FBoolean.TRUE.equals(bannerDTO.getFg_needrtn())) {
			bannerDTO.setName_status("待回诊");
		} else {
			IUdidocServiceExt udicService = ServiceFinder.find(IUdidocServiceExt.class);
			UdidocDO udidocDO = udicService.findByCode(IEnDictCodeTypeConst.SD_EN_STATUS, bannerDTO.getSd_status());
			if (udidocDO != null) {
				bannerDTO.setName_status(udidocDO.getName());
			}
		}
	}

	/**
	 * 加载诊断 加载主诊断名称
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadDiagnosis(Ent4BannerDTO bannerDTO) throws BizException {
		EntDiEP entDiEP = new EntDiEP();
		EntDiDO diDO = entDiEP.getMainDi(bannerDTO.getId_ent());
		if (diDO != null) {
			bannerDTO.setDiagnosis(diDO.getName_didef_dis());
		}
	}
	
	/**
	 * 加载全部诊断名称
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadAllDiagName(Ent4BannerDTO bannerDTO) throws BizException {
		EntDiEP entDiEP = new EntDiEP();
		EntDiDO[] diDOs = entDiEP.getAllEntDi(bannerDTO.getId_ent());
		if (!EnValidator.isEmpty(diDOs)) {
			String all_diag_name = "";
			for(EntDiDO diDO : diDOs){
				if(!EnValidator.isEmpty(diDO.getName_didef_dis()) && EnValidator.isEmpty(all_diag_name)){
					all_diag_name = diDO.getName_didef_dis();
				}else if(!EnValidator.isEmpty(diDO.getName_didef_dis()) && !EnValidator.isEmpty(all_diag_name)){
					all_diag_name = all_diag_name + "||" + diDO.getName_didef_dis();
				}else if(!EnValidator.isEmpty(diDO.getSupplement())){
					all_diag_name = all_diag_name + "||" + diDO.getSupplement();
				}
			}
			bannerDTO.setAll_diag_name(all_diag_name);
		}
	}
	
	/**
	 * 加载住院天数
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadInHosDays(Ent4BannerDTO bannerDTO) throws BizException {
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(bannerDTO.getCode_entp())) {
			CalculateHosDaysBP daysBP = new CalculateHosDaysBP();
			int days = daysBP.calculate(bannerDTO.getDt_acpt(), bannerDTO.getDt_end(), bannerDTO.getFg_ip());
			bannerDTO.setDays_inhos(days);
		}
	}

	/**
	 * 是否在医保黑名单
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadIsInHpBbr(Ent4BannerDTO bannerDTO) throws BizException {
		IBlHpOutQryService hpQryService = ServiceFinder.find(IBlHpOutQryService.class);
		FBoolean isInHpBbr = hpQryService.isHpBlackPat(bannerDTO.getId_hp(),bannerDTO.getNo_hp());
		bannerDTO.setFg_inhpbbr(isInHpBbr);
	}

	/**
	 * 是否是绿色通道患者
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadIsGcVip(Ent4BannerDTO bannerDTO) throws BizException {
		CheckIsGcVipBP checkBP = new CheckIsGcVipBP();
		FBoolean isvip = checkBP.exec(bannerDTO.getId_ent());
		bannerDTO.setFg_gcvip(isvip);
	}

	/**
	 * 是否医保特殊病患者
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadIsHpSpcl(Ent4BannerDTO bannerDTO) throws BizException {
		bannerDTO.setFg_hpspcl(FBoolean.FALSE);//默认为false
		if(!EnValidator.isEmpty(bannerDTO.getId_hp()) && !EnValidator.isEmpty(bannerDTO.getNo_hp())){
			IMiMcRuleService serv = ServiceFinder.find(IMiMcRuleService.class);
			FBoolean isSpec = serv.isSpecDiPat(bannerDTO.getId_hp(), bannerDTO.getNo_hp());
			bannerDTO.setFg_hpspcl(isSpec);
		}		
	}
	/**
	 * 加载患者账户余额
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadPatAccBal(Ent4BannerDTO bannerDTO) throws BizException {
		IPatAccServiceExt patAccService = ServiceFinder.find(IPatAccServiceExt.class);		
		PatRelAmountInfoDTO patAccDTO = patAccService.GetPatRelAmountInfo(bannerDTO.getId_pat());
		if(patAccDTO!=null){
			bannerDTO.setPatacc_balance(patAccDTO.getPrepay().sub(patAccDTO.getAcc_lock()));//设置余额
			FDouble balLowLimit = EnParamUtils.getPatAccBalWarn(EnContextUtils.getOrgId());
			if(patAccDTO.getMoney_canuse().compareTo(balLowLimit)<0){
				bannerDTO.setPatacc_balance_warn(String.format(PAT_ACC_BAL_WARN_FORMATTER, balLowLimit));//小于临界值，则显示警告文本
			}else{
				bannerDTO.setPatacc_balance_warn("~");				
			}
		}
	}
	/**
	 * 加载是否全保内(副部级)
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadIsAllInHp(Ent4BannerDTO bannerDTO) throws BizException{
		IBlHpOutQryService serv = ServiceFinder.find(IBlHpOutQryService.class);
		FBoolean isAllInHp = serv.isAllInHp(bannerDTO.getId_ent());
		bannerDTO.setFg_allinhp(isAllInHp);
	}
	/**
	 * 加载体重
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadPatWeight(Ent4BannerDTO bannerDTO) throws BizException{
		SetEntBannerWeightBP bp = new SetEntBannerWeightBP();
		bp.exec(bannerDTO);
	}
	/**
	 * 加载患者标签
	 * 
	 * @author liubin
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadPatTag(Ent4BannerDTO bannerDTO) throws BizException{
		if(EnValidator.isEmpty(bannerDTO.getId_pat()))
			return;
		PatTagDTO[] tags = new EnTagtpEP().getTagTps(new String[]{bannerDTO.getId_ent()});
		if(EnValidator.isEmpty(tags))
			return;
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (PatTagDTO tag : tags) {
			if (!isFirst) {
				sb.append(",");
			} else {
				isFirst = false;
			}
			sb.append(String.format("%s|%s|%s", tag.getShortname_tagtp(),
					EnValidator.isEmpty(tag.getColor_font()) ? "" : tag.getColor_font(),
					EnValidator.isEmpty(tag.getColor_back()) ? "" : tag.getColor_back()));
		}
		bannerDTO.setPattag(sb.toString());
	}
	/**
	 * 获取预约渠道标识
	 * 
	 * @author liubin
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadChlPrintIdent(Ent4BannerDTO bannerDTO) throws BizException{
		bannerDTO.setFg_printident_scchl(FBoolean.TRUE);
		if(EnValidator.isEmpty(bannerDTO.getId_ent()))
			return;
		GetScSchPrintIdentBP bp = new GetScSchPrintIdentBP();
		String printIdent = bp.exec(bannerDTO.getId_ent());
		bannerDTO.setPrintident_scchl(printIdent);
	}
	/**
	 * 获取孕妇风险等级
	 * 
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadGravidarisk(Ent4BannerDTO bannerDTO) throws BizException{
		GetGravidariskBP bp = new GetGravidariskBP();
		EntStateDO state = bp.exec(bannerDTO.getCode_entp(), bannerDTO.getId_ent(), bannerDTO.getId_pat());
		if(state != null){
			bannerDTO.setCode_gravidarisk(state.getVal());
			bannerDTO.setName_gravidarisk(state.getName_val());
		}
	}
	/**
	 * 查询就诊banner必要字段
	 * 
	 * @param list
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void handleNecField(List<Ent4BannerDTO> list) throws BizException{
		if(EnValidator.isEmpty(list))
			return;
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO("Id_ent", list.toArray(new Ent4BannerDTO[list.size()]));
		if(EnValidator.isEmpty(entIds))
			return;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT EN.ID_ENT,EN.DT_ACPT,EN.DT_ENTRY, EN.FG_IP,IP.FG_NEWBORN,PAT.DT_BIRTH_HMS AS DT_BIRTH ");
		sqlBuilder.append(" FROM EN_ENT EN ");
		sqlBuilder.append(" INNER JOIN PI_PAT PAT ON EN.ID_PAT = PAT.ID_PAT ");
		sqlBuilder.append(" LEFT JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(EnSqlUtils.getInSqlByIds(" EN.ID_ENT ", entIds));
		List<Ent4BannerDTO> necList = (List<Ent4BannerDTO>) new DAFacade().execQuery(sqlBuilder.toString(), new BeanListHandler(Ent4BannerDTO.class));
		if(EnValidator.isEmpty(necList))
			return;
		Map<String, Ent4BannerDTO> map = EnFMapUtils.getMap("Id_ent", necList.toArray(new Ent4BannerDTO[necList.size()]));
		for(Ent4BannerDTO entInfo : list){
			if(map == null || EnValidator.isEmpty(entInfo.getId_ent()))
				continue;
			if(map.containsKey(entInfo.getId_ent())){
				Ent4BannerDTO necInfo = map.get(entInfo.getId_ent());
				if(entInfo.getDt_acpt() == null)
					entInfo.setDt_acpt(entInfo.getDt_acpt());
				if(entInfo.getDt_entry() == null)
					entInfo.setDt_entry(necInfo.getDt_entry());
				if(entInfo.getFg_ip() == null)
					entInfo.setFg_ip(necInfo.getFg_ip());
				if(entInfo.getFg_newborn() == null)
					entInfo.setFg_newborn(necInfo.getFg_newborn());
				entInfo.setDt_birth(necInfo.getDt_birth());
			}
		}
	}
	
	
	
	/**
	 * 获取状况图标
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadEnstateLogos(Ent4BannerDTO bannerDTO) throws BizException{
		if(EnValidator.isEmpty(bannerDTO.getId_ent())|| EnValidator.isEmpty(bannerDTO.getId_pat())){
			return;
		}
		//查就诊状况
		EntStateEP entStateEP = new EntStateEP();
		String[] entIds = {bannerDTO.getId_ent()};
		Map<String, Map<String, EntStateDO>> entStateDOMap = entStateEP.getEntStateDOMap(entIds, null);
		if(entStateDOMap == null || entStateDOMap.size() <= 0) return;
		Map<String, EntStateDO> map = entStateDOMap.get(bannerDTO.getId_ent());//查床位卡用的这个方法
		if(map.isEmpty()){
			return;
		}
		List<String> idList = new ArrayList<String>();
		for(EntStateDO stateDO : map.values()){
			if(stateDO == null || EnValidator.isEmpty(stateDO.getId_entstatedef())){
				continue;
			}
			idList.add(stateDO.getId_entstatedef());
		}
		String[] ids = idList.toArray(new String[]{});
		if(EnValidator.isEmpty(ids)){
			return;
		}
		//查 bd_en_state
		IEnstateRService iEnstateRService = ServiceFinder.find(IEnstateRService.class);
		BdEnStateDO[] bdEnStateDOs = iEnstateRService.findByIds(ids, FBoolean.FALSE);
		if(EnValidator.isEmpty(bdEnStateDOs)){
			return;
		}
		IUdidocServiceExt serv = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udidocs = serv.findByUdidoclistCode(IBdFcDictCodeTypeConst.SD_EN_STATUS);
		//拼图标
		StringBuilder stateStr = new StringBuilder();
		boolean first = true;
		for(BdEnStateDO stateDO : bdEnStateDOs){
			if(stateDO != null && !EnValidator.isEmpty(stateDO.getIcon())){
				if(first){
					first = false;
				}else{
					stateStr.append(";");
				}
				stateStr.append(stateDO.getIcon());
				stateStr.append(",");
				for(UdidocDO udidocDO : udidocs){
					if(!EnValidator.isEmpty(udidocDO.getId_udidoc()) && 
							udidocDO.getId_udidoc().equals(stateDO.getId_enstatetp())){
						stateStr.append(udidocDO.getName());
						stateStr.append("(");
						stateStr.append(stateDO.getName());
						stateStr.append(")");
						break;
					}
				}
			}
		}
		bannerDTO.setEnstate_logos(stateStr.toString());
	}
	
	/**
	 * 获取 分诊台 多个字段服务
	 * @param bannerDTO
	 * @throws BizException   
	 */
	private void loadEntOpRegInfo(Ent4BannerDTO bannerDTO) throws BizException{
		if(EnValidator.isEmpty(bannerDTO.getId_ent())|| EnValidator.isEmpty(bannerDTO.getId_pat())){
			return;
		}
		IEnQueOutQryService service = ServiceFinder.find(IEnQueOutQryService.class);
		TriageEntDTO triageEntDTO = service.getTriageEnt(bannerDTO.getId_ent());
		DaysLotDO daysLotDO = new DayslotEP().getDayslotByEntId(bannerDTO.getId_ent());
		if(triageEntDTO != null){
			bannerDTO.setName_dayslot(daysLotDO != null ? daysLotDO.getName() : triageEntDTO.getName_dayslot());
			bannerDTO.setName_scres(triageEntDTO.getRes());
			bannerDTO.setName_scsrv(triageEntDTO.getName_srv());
			bannerDTO.setDt_arrv(triageEntDTO.getDt_in());
			String str = "";
			if(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED.equals(triageEntDTO.getSd_status_acpt())){
				str = "未到诊" ;
			}else{
				switch(triageEntDTO.getSd_status()){
					case IEnDictCodeConst.SD_ENSTATUS_OP_ORDER:
						str= "预约";
						break;
					case IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER:
						str= "挂号";
						break;
					case IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER:
						str= "就诊";
						break;
					case IEnDictCodeConst.SD_ENSTATUS_OP_FINISH:
						str= "诊毕";
						break;
				}
				switch(triageEntDTO.getSd_status_acpt()){
					case IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT:
						str = "到诊";
						if(triageEntDTO.getSortno_called() > 0)
							str = "候诊";
						if(FBoolean.TRUE.equals(triageEntDTO.getFg_needrtn()))
							str = "候诊(回)";
						break;
					case IEnDictCodeConst.SD_STATUS_ACPT_CALL:
						str = "叫号" ;
						break;
					case IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME:
						str = "过号" ;
						break;
				}
			}
	        bannerDTO.setQuestatus(str);
		}
	}
	/***
	 * @Description:加载患者特病信息
	 * @param bannerDTO
	 * @throws BizException 
	 */
	private void loadPatMiMcSpec(Ent4BannerDTO bannerDTO) throws BizException{
		if(!EnValidator.isEmpty(bannerDTO.getId_hp())){
			IMiMcRuleService serv = ServiceFinder.find(IMiMcRuleService.class);
			String specInfo = serv.getSpecInfoPat(bannerDTO.getId_hp(), bannerDTO.getNo_hp(),bannerDTO.getId_pat());
			bannerDTO.setMimcspecinfo(specInfo);
		}
	}
	/**
	 * 获取患者门诊挂号费是否已记账
	 * @param bannerDTO
	 * @throws BizException
	 */
	private void loadFgPayRegist(Ent4BannerDTO bannerDTO) throws BizException{
		if (!EnValidator.isEmail(bannerDTO.getId_ent())) {
			IBlOpChargeForEnInnerService iService = ServiceFinder.find(IBlOpChargeForEnInnerService.class);
			try{
				int status = iService.getRegCgStatus(bannerDTO.getId_ent());
				//0-未记账 ,1-记账未结算 ,2-记账已结算未付款 ,3-记账已付款 ,4-已退费
				switch(status){
					case 0:
						bannerDTO.setFg_pay_regist("未记账");
						break;
					case 1:
						bannerDTO.setFg_pay_regist("记账未结算");
						break;
					case 2:
						bannerDTO.setFg_pay_regist("结算未付款");
						break;
					case 3:
						bannerDTO.setFg_pay_regist("已付款");
						break;
					case 4:
						bannerDTO.setFg_pay_regist("已退费");
						break;
					default:
						bannerDTO.setFg_pay_regist("");
						break;
				}
			}catch(BizException e){
				return;
			}
		}
	}
	
}
