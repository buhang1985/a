package iih.sc.apt.s.bp.mt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.apt.aptoptemp.d.ScAptOptEmpDO;
import iih.sc.apt.aptoptemp.i.IAptoptempCudService;
import iih.sc.apt.aptoptemp.i.IAptoptempRService;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import iih.sc.apt.out.ci.d.ScAddApplInParamDTO;
import iih.sc.apt.out.ci.d.ScAptOptEmpDTO;
import iih.sc.apt.s.event.MakeMtAutoAptEvent;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScAptMtDORService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.apt.scaptappl.d.EuAptmd;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplItmDO;
import iih.sc.apt.scaptappl.d.ScAptApplOptDO;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import iih.sc.apt.scaptappl.i.IScAptApplItmDOCudService;
import iih.sc.apt.scaptappl.i.IScAptApplItmDORService;
import iih.sc.apt.scaptappl.i.IScAptApplOptDOCudService;
import iih.sc.apt.scaptappl.i.IScAptApplOptDORService;
import iih.sc.apt.scaptappl.i.IScaptapplMDOCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import iih.sc.scbd.s.ep.ScBdSrvEP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存手术预约信息
 * 
 * @author maxy
 * @date 2018年7月11日14:29:34
 *
 */
public class AddScAptApplBP {

	/**
	 * 保存手术预约信息
	 * @param scAddApplInParam
	 * @param scAptOptEmps
	 * @throws BizException
	 */
	public void exec(ScAddApplInParamDTO scAddApplInParam) throws BizException {
		
		//1.校验是否存在，存在则抛出异常
		Boolean valid = this.saveValid(scAddApplInParam);
		if(!valid)
		{
			return;
		}
		
		//2.保存 数据   sc_apt_appl
		ScAptApplDO newApplDO = this.saveScAptAppl(scAddApplInParam);
		
		//3.保存数据   sc_apt_opt_emp
		//手术医嘱保存人员
		if(IScDictCodeConst.SD_SCTP_OT.equals(scAddApplInParam.getSd_sctp()))
		{
			this.saveScAptOptEmp(scAddApplInParam.getExtend(),newApplDO);
			//保存sc_apt_appl_opt 麻醉方式等
			this.saveScAptApplOpt(scAddApplInParam, newApplDO.getEu_aptmd(),newApplDO.getId_aptappl());
		}
		
		if(IScDictCodeConst.SD_SCTP_MT.equals(scAddApplInParam.getSd_sctp())){
			
			String[] id_srvs = this.getApplSrvId(newApplDO.getId_aptappl());
			//需确认:查询子表所有数据一个是需确认即认为是需确认
			Map<String,FBoolean> srvMap = this.getScBdSrv(id_srvs);
			FBoolean fg_needcfm = FBoolean.FALSE;
			if(srvMap != null){
				for (String id_srv : id_srvs) {
					if(srvMap.containsKey(id_srv)){
						if(srvMap.get(id_srv).booleanValue()){
							fg_needcfm = FBoolean.TRUE;
							break;
						}
					}
				}
			}
			//自动预约:经与德波确认按照sc_apt_appl表中的id_srv是自动预约则可自动预约,原逻辑不需要变动
			if(!ScParamUtils.getScAptMtChkFee(newApplDO.getId_dep_mp()) || (ScParamUtils.getScAptMtChkFee(newApplDO.getId_dep_mp()) && fg_needcfm.booleanValue())){
					//TODO 触发预约的业务事件
					this.invoke(newApplDO.getId_aptappl());
			}
		}
	}
	
	/**
	 * 查询子表中所有医嘱的id_srv
	 * @param id_aptappl
	 * @return
	 * @throws BizException
	 */
	private String[] getApplSrvId(String id_aptappl) throws BizException{
		IScAptApplItmDORService rservice = ServiceFinder.find(IScAptApplItmDORService.class);
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(id_aptappl);
		ScAptApplItmDO[] aptApplItms = rservice.find2("id_aptappl=?", param, null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(aptApplItms)) return new String[]{""};
		List<String> result = new ArrayList<String>();
		for (ScAptApplItmDO itmDO : aptApplItms) {
			result.add(itmDO.getId_srv());
		}
		return result.toArray(new String[]{});
	}
	/**
	 * 1.校验是否存在，存在则抛出异常
	 * @param scAddApplInParam
	 * @return
	 * @throws BizException
	 */
	private Boolean saveValid(ScAddApplInParamDTO scAddApplInParam) throws BizException
	{
		if(scAddApplInParam == null)
		{
			throw new BizException ("医嘱入参是空！");
		}
		if(ScValidator.isNullOrEmpty(scAddApplInParam.getId_or()))
		{
			throw new BizException ("医嘱id_or是空！");
		}
		if(ScValidator.isNullOrEmpty(scAddApplInParam.getId_ent()))
		{
			throw new BizException ("就诊id_ent是空！");
		}
		if(ScValidator.isNullOrEmpty(scAddApplInParam.getId_srv()))
		{
			throw new BizException ("id_srv是空！");
		}
		if(ScValidator.isNullOrEmpty(scAddApplInParam.getId_dep_mp()))
		{
			throw new BizException ("执行科室id_dep_mp是空！");
		}
		if(ScValidator.isNullOrEmpty(scAddApplInParam.getId_dep_appl()))
		{
			throw new BizException ("申请科室Id_dep_appl是空！");
		}
		if(ScValidator.isNullOrEmpty(scAddApplInParam.getId_emp_appl()))
		{
			throw new BizException ("申请人Id_emp_appl是空！");
		}
		if(ScValidator.isNullOrEmpty(scAddApplInParam.getSd_sctp()))
		{
			throw new BizException ("医嘱类型sd_sctp是空！");
		}
		if(!(IScDictCodeConst.SD_SCTP_OT.equals(scAddApplInParam.getSd_sctp()) || IScDictCodeConst.SD_SCTP_MT.equals(scAddApplInParam.getSd_sctp())))
		{
			throw new BizException ("医嘱类型:"+scAddApplInParam.getSd_sctp()+"，非手术或医技医嘱");
		}
//		if(IScDictCodeConst.SD_SCTP_OT.equals(scAddApplInParam.getSd_sctp()))
//		{
//			if(StringUtil.isEmpty(scAddApplInParam.getId_anestp()))
//			{
//				 throw new BizException ("手术类医嘱:Id_anestp 麻醉方式不能为空");
//			}
//		}
		if(IScDictCodeConst.SD_SCTP_MT.equals(scAddApplInParam.getSd_sctp())){
			if(this.getApplNumByIdOr(scAddApplInParam)>0){
				throw new BizException ("未取消医嘱已存在，无法进行操作，医嘱id：" + scAddApplInParam.getId_or());
			}
		}
		return true;
	}
	
	/**
	 * 获取未撤销申请单数量
	 * @param scAddApplInParam 
	 * @return
	 * @throws DAException 
	 * @author ltf
	 */
	private int getApplNumByIdOr(ScAddApplInParamDTO scAddApplInParam) throws DAException {
		StringBuilder sqlSB= new StringBuilder();
		sqlSB.append(" select count(appl.id_aptappl)");
		sqlSB.append(" from sc_apt_appl appl");
		sqlSB.append(" inner join sc_apt_appl_itm itm on appl.id_aptappl = itm.id_aptappl");
		sqlSB.append(" where appl.id_or = ?");
		sqlSB.append(" and appl.fg_canc = 'N'");
		SqlParam param = new SqlParam();
		param.addParam(scAddApplInParam.getId_or());
		int result = (int) new DAFacade().execQuery(sqlSB.toString(), param, new ColumnHandler()); 
		return result;
	}

	/**
	 * 2.保存 数据   sc_apt_appl
	 * @param scAddApplInParam
	 * @return
	 * @throws BizException
	 */
	private ScAptApplDO saveScAptAppl(ScAddApplInParamDTO scAddApplInParam) throws BizException
	{
		//查找就诊信息
		IPativisitRService enEntService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO enEntDO = enEntService.findById(scAddApplInParam.getId_ent());
		if(enEntDO ==null)
		{
			throw new BizException ("未找到就诊信息！");
		}
		//查询患者就诊次数
		String times = this.getEnTimes(scAddApplInParam.getId_ent());
		//查找患者信息
		IPatiMDORService patService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = patService.findById(enEntDO.getId_pat());
		if(patDO == null)
		{
			throw new BizException ("未找到患者信息！");
		}
		IScaptapplMDORService iscaptapplmdorservice = ServiceFinder.find(IScaptapplMDORService.class);
		// 判断是否合单
		ScAptApplItmDO[] aptApplItms = null;
		if(!StringUtil.isEmpty(scAddApplInParam.getMultor_apply_no())){
			IScAptApplItmDORService rservice = ServiceFinder.find(IScAptApplItmDORService.class);
			SqlParamDTO param = new SqlParamDTO();
			param.addParam(scAddApplInParam.getMultor_apply_no());
			aptApplItms = rservice.find2("applyno_or=?",param, null, FBoolean.FALSE);
		}
		//已存在合单数据
		if(!ArrayUtil.isEmpty(aptApplItms)){
			ScAptApplDO applDO = iscaptapplmdorservice.findById(aptApplItms[0].getId_aptappl());
			applDO.setFg_multor(FBoolean.TRUE);
			// 合单: 申请单明细
			this.saveScAptApplItm(scAddApplInParam,applDO,enEntDO.getCode_entp(),true);
			return applDO;
		}else{
			// 查询医嘱对应的申请单
		ScAptApplDO[] scAptAppls = iscaptapplmdorservice.find("id_or ='"+scAddApplInParam.getId_or()+"'", null, FBoolean.FALSE);
		ScAptApplDO applDO = null;
		if(!ArrayUtil.isEmpty(scAptAppls)){
			applDO = scAptAppls[0];
			applDO.setStatus(DOStatus.UPDATED);
		}else{
			applDO = new ScAptApplDO();
		applDO.setStatus(DOStatus.NEW);
		}
		IScbdsrvMDORService iscbdsrvmdorservice = ServiceFinder.find(IScbdsrvMDORService.class);
		ScBdsrvDO[] scbdsrvdos = iscbdsrvmdorservice.find("id_srv ='"+scAddApplInParam.getId_srv()+"'", null, FBoolean.FALSE);
		
		if (!ArrayUtil.isEmpty(scbdsrvdos)) {
		ScBdsrvDO scbdsrvdo = scbdsrvdos[0];
		applDO.setId_scca(scbdsrvdo.getId_scca());
		}
		applDO.setTimes(times);
		//来源 
		applDO.setSd_aptmd(scAddApplInParam.getSd_aptmd());//0:有iih申请单 1:无iih申请单
		applDO.setSd_sys_from(scAddApplInParam.getSd_sys_from());//0:iih 1:chis 2:其他
		applDO.setId_entp(scAddApplInParam.getId_entp());
		applDO.setCode_entp(scAddApplInParam.getCode_entp());
		applDO.setCode_or(scAddApplInParam.getCode_or());
		// 增加手术部位
		applDO.setId_surgical_site(scAddApplInParam.getId_surgical_site());
		applDO.setSd_surgical_site(scAddApplInParam.getSd_surgical_site());
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(enEntDO.getCode_entp()) || IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(enEntDO.getCode_entp()))
		{
			applDO.setFg_bl(FBoolean.TRUE);
		}
		else
		{
			applDO.setFg_bl(scAddApplInParam.getFg_bl());
		}
		//如果科研标志为true则直接标记费用状态为已记账
		if(scAddApplInParam.getFg_research() != null && scAddApplInParam.getFg_research().booleanValue()){
			applDO.setFg_bl(FBoolean.TRUE);
		}
		//医保支付标识
		applDO.setFg_hp(scAddApplInParam.getFg_hp());
		applDO.setDt_effe_or(scAddApplInParam.getDt_effe_or());
		applDO.setId_org(ScContextUtils.getOrgId());
		applDO.setSd_sctp(scAddApplInParam.getSd_sctp());//排班类型--手术:IScDictCodeConst.SD_SCTP_OT   医技:IScDictCodeConst.SD_SCTP_MT
		applDO.setCode(this.createScAptApplCode(scAddApplInParam.getSd_sctp()));//预约申请编码
		applDO.setName(scAddApplInParam.getName_or());//预约申请名称
		applDO.setApplyno(scAddApplInParam.getApplyno());//申请号
		applDO.setDes(scAddApplInParam.getDes_or());//预约申请描述
		applDO.setId_pi(patDO.getId_pat());//患者id--pi_pat
		applDO.setPiname(patDO.getName());//患者姓名--pi_pat
		applDO.setId_sex(patDO.getId_sex());//性别id--pi_pat
		applDO.setSd_sex(patDO.getSd_sex());//性别--pi_pat
		applDO.setD_pi(patDO.getDt_birth());//出生日期--pi_pat
		applDO.setPimobile(patDO.getMob());//手机号--pi_pat
		applDO.setCode_entp(enEntDO.getCode_entp());//就诊类型--en_ent
		applDO.setId_entp(enEntDO.getId_entp());//就诊类型ID
		applDO.setId_ent(enEntDO.getId_ent());//就诊id--en_ent
		applDO.setId_or(scAddApplInParam.getId_or());//医嘱
		applDO.setContent_or(scAddApplInParam.getContent_or());//医嘱内容
		applDO.setPriority(0);//优先级
		applDO.setD_b(scAddApplInParam.getD_begin());//预约申请开始日期
		applDO.setId_dep_appl(scAddApplInParam.getId_dep_appl());//预约申请部门
		applDO.setId_emp_appl(scAddApplInParam.getId_emp_appl());//预约申请人员
		applDO.setId_dep_mp(scAddApplInParam.getId_dep_mp());//执行科室
		applDO.setDt_appl(scAddApplInParam.getDt_appl());//预约申请操作日期
		applDO.setFg_comfirm(FBoolean.FALSE);//预约完成标志
		applDO.setFg_canc(FBoolean.FALSE);//取消标志
			applDO.setFg_multor(FBoolean.FALSE);// 合单标志
		applDO.setFg_urgent(scAddApplInParam.getFg_urgent());//紧急标志
		applDO.setEu_aptmd(0);//申请单预约--0
		applDO.setId_srv(scAddApplInParam.getId_srv());
		applDO.setId_org(ScContextUtils.getOrgId());
		applDO.setId_grp(ScContextUtils.getGrpId());
		IScaptapplMDOCudService scaptapplCudService= ServiceFinder.find(IScaptapplMDOCudService.class);
		ScAptApplDO newApplDO = new ScAptApplDO();
			// 手术
			if(IScDictCodeConst.SD_SCTP_OT.equals(scAddApplInParam.getSd_sctp())){
		newApplDO = scaptapplCudService.save(new ScAptApplDO[]{applDO})[0];
		return newApplDO;
	}
			// 非合单：申请单 + 申请单明细
			newApplDO = scaptapplCudService.save(new ScAptApplDO[]{applDO})[0];
			this.saveScAptApplItm(scAddApplInParam, newApplDO,enEntDO.getCode_entp(),false);
			return newApplDO;
		}
	}
	
	/**
	 * 申请单明细表
	 * @param scAddApplInParam ci入参
	 * @param applDO 申请单数据
	 * @param code_entp 就诊编码
	 * @param isMultor 是否已存在合单数据
	 * @throws BizException 
	 * @author ltf
	 */
	private void saveScAptApplItm(ScAddApplInParamDTO applInParam, ScAptApplDO applDO,String code_entp,boolean isMultor) throws BizException {
		ScAptApplItmDO applItmDO = new ScAptApplItmDO();
		// 判断 新增/修改
		IScAptApplItmDORService rservice = ServiceFinder.find(IScAptApplItmDORService.class);
		ScAptApplItmDO[] aptApplItms = rservice.find("id_or='" + applInParam.getId_or()+"'", null, FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(aptApplItms)){
			applItmDO = aptApplItms[0];
			applItmDO.setStatus(DOStatus.UPDATED);
		}else{
			applItmDO.setStatus(DOStatus.NEW);
		}
		// 申请单Id
		applItmDO.setId_aptappl(applDO.getId_aptappl());
		applItmDO.setApplyno_or(applInParam.getMultor_apply_no());// 合单号
		applItmDO.setApplyno(applInParam.getApplyno());// 医嘱申请号
		applItmDO.setDes(applInParam.getDes_or());
		applItmDO.setId_or(applInParam.getId_or());
		applItmDO.setCode_or(applInParam.getCode_or());
		applItmDO.setContent_or(applInParam.getContent_or());
		applItmDO.setId_srv(applInParam.getId_srv());
		applItmDO.setFg_urgent(applInParam.getFg_urgent());
		applItmDO.setFg_bl(applInParam.getFg_bl());
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp) || IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)){
			applItmDO.setFg_bl(FBoolean.TRUE);
		}
		//如果科研标志为true则直接标记费用状态为已记账
		if(applInParam.getFg_research() != null && applInParam.getFg_research().booleanValue()){
			applItmDO.setFg_bl(FBoolean.TRUE);
		}
		applItmDO.setDt_effe_or(applInParam.getDt_effe_or());
		applItmDO.setFg_hp(applInParam.getFg_bl());
		IScAptApplItmDOCudService scaptapplCudService= ServiceFinder.find(IScAptApplItmDOCudService.class);
		scaptapplCudService.save(new ScAptApplItmDO[]{applItmDO});
		if(!FBoolean.TRUE.equals(applDO.getFg_multor())){
			return;
		}
		if(isMultor){
			IScaptapplMDOCudService applCudService= ServiceFinder.find(IScaptapplMDOCudService.class);
			applDO.setStatus(DOStatus.UPDATED);
			applDO.setFg_multor(FBoolean.TRUE);
			FBoolean fg_bl = FBoolean.FALSE;
			if(FBoolean.TRUE.equals(applItmDO.getFg_bl()) && FBoolean.TRUE.equals(applDO.getFg_bl())){
				fg_bl = FBoolean.TRUE;
			}
			applDO.setFg_bl(fg_bl);
			applDO.setContent_or(applDO.getContent_or() +"|"+ applItmDO.getContent_or());
			applCudService.save(new ScAptApplDO[]{applDO});
		}
	}

	/**
	 * 3.保存数据   sc_apt_opt_emp
	 * @param scAptOptEmps
	 * @param newApplDO
	 * @throws BizException
	 */
	private void saveScAptOptEmp(FArrayList scAptOptEmps,ScAptApplDO newApplDO)throws BizException
	{
		IAptoptempRService rService = ServiceFinder.find(IAptoptempRService.class);
		ScAptOptEmpDO[] aptOptEmps = rService.find(String.format(" id_aptappl = '%s' ", newApplDO.getId_aptappl()), "", FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(aptOptEmps))
		{
			return;
		}
		
		if(!ListUtil.isEmpty(scAptOptEmps))
		{
			List<ScAptOptEmpDO> list = new ArrayList<ScAptOptEmpDO>();
			for(Object obj : scAptOptEmps)
			{
				ScAptOptEmpDTO emp = (ScAptOptEmpDTO) obj;
				ScAptOptEmpDO scDO = new ScAptOptEmpDO();
				scDO.setStatus(DOStatus.NEW);
				scDO.setSd_role(emp.getSd_role());//角色编码
				scDO.setId_role(emp.getId_role());
				scDO.setId_emp(emp.getId_emp());//人员id
				scDO.setId_aptappl(newApplDO.getId_aptappl());
				list.add(scDO);
			}
			IAptoptempCudService aptoptempRService = ServiceFinder.find(IAptoptempCudService.class);
			aptoptempRService.save(list.toArray(new ScAptOptEmpDO[0]));
		}
	}
	
	/**
	 * 4.保存数据   sc_apt_appl_opt
	 * @param scAddApplInParam
	 * @param id_apt_appl
	 * @throws BizException
	 */
	private void saveScAptApplOpt(ScAddApplInParamDTO scAddApplInParam,int eu_aptmd,String id_apt_appl) throws BizException
	{
		IScAptApplOptDORService rService = ServiceFinder.find(IScAptApplOptDORService.class);
		ScAptApplOptDO[] applOpts = rService.find(String.format(" id_aptappl = '%s'", id_apt_appl), "", FBoolean.FALSE);
		
		ScAptApplOptDO optDO = null;
		if(!ArrayUtil.isEmpty(applOpts)){
			optDO = applOpts[0];
			optDO.setStatus(DOStatus.UPDATED);
		}else{
			optDO = new ScAptApplOptDO();
			optDO.setStatus(DOStatus.NEW);
		}
		optDO.setFg_need_confirm(FBoolean.FALSE);
		if(ScParamUtils.getScOptDepApprove() && eu_aptmd == EuAptmd.APPL && IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(scAddApplInParam.getCode_entp())){
			optDO.setFg_need_confirm(FBoolean.TRUE);
		}
		optDO.setAnnouncements(scAddApplInParam.getAnnouncements());//注意事项
		optDO.setSug_require(scAddApplInParam.getSug_require());//手术要求
		optDO.setId_aptappl(id_apt_appl);
		optDO.setId_anestp(scAddApplInParam.getId_anestp());//麻醉方式
		optDO.setSd_anestp(scAddApplInParam.getSd_anestp());
		optDO.setSpecialreq(scAddApplInParam.getSpecialreq());//特殊用物
		optDO.setSpecialinstrument(scAddApplInParam.getSpecialinstrument());//特殊仪器
		optDO.setSpecialdes(scAddApplInParam.getSpecialdes());//特殊准备
		optDO.setName_di(scAddApplInParam.getName_di());
		optDO.setCode_di(scAddApplInParam.getCode_di());
		optDO.setFg_infection(scAddApplInParam.getFg_infection());//是否感染手术
		IScAptApplOptDOCudService cudService = ServiceFinder.find(IScAptApplOptDOCudService.class);
		cudService.save(new ScAptApplOptDO[]{optDO});
	}
	
	/**
	 * 创建预约申请编码
	 *
	 * @author zhengcm
	 * 
	 * @param sd_entp 就诊类型编码
	 * @return 编码
	 * @throws BizException
	 */
	private String createScAptApplCode(String sd_entp) throws BizException {
		String code = this.createCode(ScAptApplDODesc.CLASS_FULLNAME);
		if (!StringUtil.isEmptyWithTrim(sd_entp)) {
			code = code.substring(0, 3) + sd_entp + code.substring(3);
		}
		return code;
	}
	/**
	 * 生成编码
	 * 
	 * @param doDescFullName 实体元数据类全名
	 * @return 根据编码规则生成编码
	 * @throws BizException
	 */
	private String createCode(String doDescFullName) throws BizException {
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		//ScAptApplDO applDO = new ScAptApplDO();
		//applDO.setId_dep_appl(ScContextUtils.getDeptId());
		//String code = codeManage.getBillCode_RequiresNew(doDescFullName,applDO);
		String code = codeManage.getPreBillCode_RequiresNew(doDescFullName);
		return code;
	}
	/**
	 * 获取患者就诊次数
	 * @param id_ent
	 * @return
	 * @throws DAException
	 */
	private String getEnTimes(String id_ent) throws DAException{
		DAFacade dafacade = new DAFacade();
		StringBuilder qry = new StringBuilder();
		qry.append(" select (case when ip.Times_Ip is null then 0 else ip.Times_Ip end) +  (case when op.Times_Op is null then 0 else op.Times_Op end) from en_ent ent")
		.append(" left outer join en_ent_ip ip ON ent.Id_Ent=ip.Id_Ent")
		.append(" left outer join en_ent_op op ON ent.Id_Ent=op.Id_Ent")
		.append(" where ent.id_ent = ?");
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		List<String> list = (List<String>) dafacade.execQuery(qry.toString(),param, new ColumnListHandler());
		if (list != null && list.size() > 0) {
			Object times = list.get(0);
			return times.toString();
		}
		return "0";
	}
	
	/**
	 * 触发医技自动预约事件
	 * @param id_aptappl
	 */
	private void invoke(String id_aptappl){
		MtApt4EsDTO apt4EsDTO = new MtApt4EsDTO();
		apt4EsDTO.setId_aptappl(id_aptappl);
		//捕捉异常避免异常抛出导致CI医嘱签署错误
		try {
			new MakeMtAutoAptEvent().invoke(apt4EsDTO);
		} catch (BizException e) {
			ScLogUtil.getInstance().logError(e.getMessage());
		}
	}
	/**
	 * 获取排班医疗项目是否需确认
	 * @param idSrvs
	 * @return
	 * @throws BizException 
	 */
	private Map<String,FBoolean> getScBdSrv(String[] idSrvs) throws BizException{
		ScBdsrvDO[] scbdsrvs = new ScBdSrvEP().getScBdSrvByIdSrv(idSrvs);
		if(ArrayUtil.isEmpty(scbdsrvs))return null;
		Map<String,FBoolean> result = new HashMap<String, FBoolean>();
		for (ScBdsrvDO scBdsrvDO : scbdsrvs) {
			if(!result.containsKey(scBdsrvDO.getId_srv())){
				result.put(scBdsrvDO.getId_srv(), scBdsrvDO.getFg_needcfm());
			}
		}
		return result;
	}
}
