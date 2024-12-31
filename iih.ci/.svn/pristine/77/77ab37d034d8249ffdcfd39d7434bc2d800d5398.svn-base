package iih.ci.ord.s.external.thirdws.base;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bd.pp.service.i.IPpQueService;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.op.base.OpCommonSaveAction;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.inpatient.i.INewbornRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.overview.overview.d.PiPatDO;
import iih.pi.overview.overview.i.IOverviewMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

public abstract class BaseOrdWsCtxSaveBP extends OpCommonSaveAction{
	
	/**
	 * 就诊信息
	 * @param en_code
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO getPatiVisitByCode(String code_en) throws BizException{
		
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] entdos = service.findByAttrValString(PatiVisitDO.CODE,code_en);
		if(entdos!=null && entdos.length>0){
			PatiVisitDO entdo = entdos[0];
			return entdo;
		}
		return null;
	}
	
	/**
	 * 查询患者信息
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public PiPatDO getPiPatById(String id_pat) throws BizException{
		
		IOverviewMDORService service = ServiceFinder.find(IOverviewMDORService.class);
		PiPatDO pipat = service.findById(id_pat);
		return pipat;
	}
	
	/**
	 * 患者就診住院属性
	 * @param id_ent
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	protected InpatientDO getInpatientByIdEnt(String id_ent,String code_entp) throws BizException{
		
		if(!"10".equals(code_entp)){
			return new InpatientDO();
		}
		IInpatientRService patientRService = (IInpatientRService)ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatients = patientRService.findByAttrValString(InpatientDO.ID_ENT, id_ent);
		return inpatients[0];
	}

	/**
	 * 就诊医保信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	protected EntHpDO getEntHpByIdEnt(String id_ent) throws BizException{
		
		IEnthpRService enthpRService = (IEnthpRService)ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] entHps = enthpRService.findByAttrValString(EntHpDO.ID_ENT,id_ent);
		if(entHps == null ){
			return new EntHpDO();
		}
		return entHps[0];
	}
	
	/**
	 * 查询医保计划
	 * @param id_hp
	 * @return
	 * @throws BizException
	 */
	protected HPDO getHpByIdHp(String id_hp) throws BizException{
		
		if(StringUtils.isEmpty(id_hp)){
			return new HPDO();
		}
		
		IHpMDORService hpRService = (IHpMDORService)ServiceFinder.find(IHpMDORService.class);
		HPDO[] hps = hpRService.findByAttrValString(HPDO.ID_HP,id_hp);
		return hps[0];
	}
	
	/**
	 * 查询默认医保计划
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	protected String getIdHpDefaultByIdEn(String id_en) throws BizException{
		
		IPpQueService ppQueService = (IPpQueService)ServiceFinder.find(IPpQueService.class);
		FMap map = ppQueService.getHpIdForHpCatalog(new String[]{id_en});
		return map.get(id_en).toString();
	}
	
	/**
	 * 获取新生儿信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	protected NewbornDO getNewbornByIdEnt(String id_ent, String code_entp) throws BizException {

		INewbornRService newbornRService = (INewbornRService) ServiceFinder.find(INewbornRService.class);
		NewbornDO[] newborns = newbornRService.findByAttrValString(NewbornDO.ID_ENT_BB, id_ent);
		if(newborns == null || newborns.length ==0){
			return new NewbornDO();
		}
		return newborns[0];
	}
	
	
	/**
	 * 查询床号
	 * @param code
	 * @return
	 * @throws BizException
	 */
	protected Bdbed getBdbedByCode(String code_entp, String code) throws BizException{
		
		if(StringUtils.isEmpty(code)){
			return new Bdbed();
		}
		
		IBedMDORService bedRService = (IBedMDORService)ServiceFinder.find(IBedMDORService.class);
		Bdbed[] bdBeds =  bedRService.findByAttrValString(Bdbed.CODE, code);
		return bdBeds[0];
	}
	
	/**
	 * 获取机构编码获取机构信息
	 * @param bizOrgCode
	 * @return
	 * @throws BizException
	 */
	protected OrgDO getOrgByBizCode(String bizOrgCode) throws BizException {

		IOrgRService orgRService = (IOrgRService)ServiceFinder.find(IOrgRService.class);
		OrgDO[] orgs = orgRService.findByAttrValString(OrgDO.BIZORGCODE, bizOrgCode);
		return orgs[0];
	}
	
	/**
	 * 根据部门id获取部门
	 * 
	 * @param Id_dep
	 * @return
	 * @throws BizException
	 */
	protected DeptDO getDeptById(String Id_dep) throws BizException {
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		DeptDO dept = service.findById(Id_dep);
		return dept;
	}
	
	/**
	 * 根据编码获取部门
	 * @param code
	 * @return
	 * @throws BizException
	 */
	protected DeptDO getDeptByCode(String code) throws BizException {
		
		if(StringUtils.isEmpty(code)){
			return new DeptDO();
		}
		
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		DeptDO[] depts = service.findByAttrValString(DeptDO.CODE, code);
		
		return depts[0];
	}
	
	/**
	 * 获取人员
	 * @param code
	 * @return
	 * @throws BizException
	 */
	protected PsnDocDO getPsndocByCode(String code) throws BizException {
		IPsndocMDORService service = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psndocs = service.findByAttrValString(PsnDocDO.CODE, code);
		
		return psndocs[0];
	}
	
	/**
	 * 获取登录用户信息
	 * @param code
	 * @return
	 * @throws BizException
	 */
	protected UserDO getUserByIdPsn(String id_psn) throws BizException {
		IUserRService service = ServiceFinder.find(IUserRService.class);
		UserDO[] users = service.findByAttrValString(UserDO.ID_PSN, id_psn);
		
		return users[0];
	}
	
	protected CiEnContextDTO getWsEnContext(EntWsDTO entWs) throws BizException{
		
		// 就诊
		PatiVisitDO patIvisit = getPatiVisitByCode(entWs.getCode_en());
		// 医保
		EntHpDO entHp = this.getEntHpByIdEnt(patIvisit.getId_ent());
		// 患者
		//PiPatDO piPat = this.getPiPatById(patIvisit.getId_pat());
		OrgDO org = this.getOrgByBizCode(entWs.getCode_org());
		// 住院属性
		InpatientDO inpatient = this.getInpatientByIdEnt(patIvisit.getId_ent(), entWs.getCode_entp());
		// 婴儿信息
		NewbornDO newborn = this.getNewbornByIdEnt(patIvisit.getId_ent(), entWs.getCode_entp());
		
		CiEnContextDTO ctx = new CiEnContextDTO();
		
		
		ctx.setId_grp(org.getId_grp());		
		ctx.setName_grp(org.getGrp_name());
		ctx.setId_org(org.getId_org());
		ctx.setCode_org(org.getOrg_code());
		ctx.setName_org(org.getOrg_name());
		/*ctx.setEmsappmode(emsappmode);*/
		
		ctx.setId_entp(this.getIdEntp(entWs.getCode_entp()));
		ctx.setCode_entp(entWs.getCode_entp());
		
		ctx.setId_pat(patIvisit.getId_pat());
		ctx.setCode_pat(entWs.getCode_pat());
		ctx.setName_pat(patIvisit.getName_pat());
		
		ctx.setName_sex(patIvisit.getName_sex());
		ctx.setDt_birth(patIvisit.getDt_birth_pat().toStdString());
		ctx.setNo_hp(entHp.getNo_hp());
		
		//ctx.setBarcode_chis(piPat.getBarcode_chis());
		ctx.setCode_amr_ip(inpatient.getCode_amr_ip());
		
		ctx.setId_en(patIvisit.getId_ent());
		//ctx.setCode_en(entWs.getCode_en());
		
		HPDO hp = this.getHpByIdHp(patIvisit.getId_hp());
		ctx.setId_hp(patIvisit.getId_hp());
		ctx.setSd_hptp(hp.getSd_hptp());
		ctx.setId_hp_default(patIvisit.getId_hp());
		
		ctx.setId_pripat(patIvisit.getId_pripat());
		
		// 就诊科室
		DeptDO deptPhy = this.getDeptByCode(entWs.getCode_dep_phy());
		ctx.setId_dep_en(deptPhy.getId_dep());
		ctx.setName_dep_en(deptPhy.getName());
		
		// 就诊病区
		DeptDO deptNur = this.getDeptByCode(entWs.getCode_dep_nur());
		ctx.setId_dep_ns(deptNur.getId_dep());
		ctx.setName_dep_ns(deptNur.getName());
		/*
		ctx.setId_dep_or(patIvisit.id_dep_or);
		ctx.setName_dep_or(name_dep_or);
		
		ctx.setId_emp_or(id_emp_or);
		ctx.setCode_emp_or(code_emp_or);
		ctx.setName_emp_or(name_emp_or);
		
		ctx.setTel_dep_or(tel_dep_or);
		ctx.setAddr_dep_or(addr_dep_or);
		ctx.setId_wg_or(id_wg_or);
		*/
		//ctx.setFg_bb("Y".equals(entWs.getFg_bb())?FBoolean.TRUE : FBoolean.FALSE);
		
		ctx.setNo_bb(newborn.getNo_bb());
		
		ctx.setFg_hpspcl(entHp.getFg_hpspcl());
		ctx.setFg_hpfundpay(entHp.getFg_fundpay());
		/*
		ctx.setFg_cp(fg_cp);
		ctx.setEu_inhpbbr(eu_inhpbbr);
		ctx.setEu_hpbeyond(eu_hpbeyond);
		ctx.setBhpjudgerst(bhpjudgerst);
		ctx.setDes_bhpjudgerst(des_bhpjudgerst);
		ctx.setEu_orsrcmdtp(eu_orsrcmdtp);
		*/
		
		//ctx.setFg_weightshow(newborn.getFgfg_weightshow);
		//ctx.setWeight(newborn.getWeight());
		//ctx.setWeightunit(weightunit);
		
		ctx.setId_bed(inpatient.getId_bed());
		ctx.setName_bed(inpatient.getName_bed());
		
		ctx.setFg_newborn(inpatient.getFg_newborn());
		ctx.setFg_gcvip("Y".equals(entWs.getFg_vip())? FBoolean.TRUE: FBoolean.FALSE);
		/*
		ctx.setId_user(id_user);
		ctx.setName_user(name_user);
		ctx.setId_psndoc(id_psndoc);
		ctx.setCode_psndoc(code_psndoc);
		ctx.setName_psndoc(name_psndoc);
		ctx.setDiagitemlist(diagitemlist);
		
		ctx.setAssistant_type(assistant_type);
		*/
		ctx.setId_mob(patIvisit.getTelno_pat());
		
		/*ctx.setId_idtp(piPat.getId_idtp());
		ctx.setSd_idtp(piPat.getSd_idtp());
		ctx.setId_code(piPat.getId_code());*/
		
		ctx.setSd_sex(patIvisit.getSd_sex_pat());
		//ctx.setSd_status(sd_status);
		//ctx.setDt_open(dt_open);
		//ctx.setStationtype(stationtype);
		//ctx.setSd_orsrcfun(sd_orsrcfun);
		//ctx.setId_orsrcfun(id_orsrcfun);
		ctx.setFg_pres_outp(FBoolean.FALSE);

		return ctx;
	}
	
	/**
	 * 重置就诊环境中开立信息
	 * 开立医生，开立科室
	 * @throws BizException 
	 */
	protected abstract void resetCtxInfo(CiEnContextDTO ctx, Object obj) throws BizException;
	
	/**
	 * 获取就诊类型id
	 * @param code_entp
	 * @return
	 * @throws BizException 
	 */
	private String getIdEntp(String code_entp) throws BizException{

		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)){// 门诊
			return IBdFcDictCodeConst.ID_CODE_ENTP_OP;
		}
//		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)){// 急诊
//			return IBdFcDictCodeConst.ID_CODE_ENTP_ET;
//		}
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)){// 急诊流水
			return IBdFcDictCodeConst.ID_CODE_ENTP_ET_FLOW;
		}
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)){// 急诊抢救
			return IBdFcDictCodeConst.ID_CODE_ENTP_ET_FSTAID;
		}
		if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)){// 急诊留观
			return IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS;
		}
		if(IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp)){// 体检
			return IBdFcDictCodeConst.ID_CODE_ENTP_PE;
		}
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)){// 住院
			return IBdFcDictCodeConst.ID_CODE_ENTP_IP;
		}
		if(IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp)){// 家庭病床
			return IBdFcDictCodeConst.ID_CODE_ENTP_FA;
		}
		
		
		throw new BizException("不存在编码为【"+code_entp+"】的就诊类型！");
	}
}
