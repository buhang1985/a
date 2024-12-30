package iih.sc.apt.s.bp.mt;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.apt.aptoptemp.d.ScAptOptEmpDO;
import iih.sc.apt.aptoptemp.i.IAptoptempCudService;
import iih.sc.apt.out.ci.d.ScAddApplInParamDTO;
import iih.sc.apt.out.ci.d.ScAptOptEmpDTO;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplOptDO;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import iih.sc.apt.scaptappl.i.IScAptApplOptDOCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDOCudService;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScValidator;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存手术预约信息
 * 
 * @author maxy
 * @date 2018年7月11日14:29:34
 *
 */
public class AddBatchScAptApplBP {

	/**
	 * 保存手术预约信息
	 * @param scAddApplInParam
	 * @param scAptOptEmps
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void exec(FArrayList scAddApplInParams) throws BizException {
		if(ListUtil.isEmpty(scAddApplInParams)) return;
		List<ScAptOptEmpDO> emp_datas = new ArrayList<ScAptOptEmpDO>();
		List<ScAptApplDO> apt_datas = new ArrayList<ScAptApplDO>();
		List<ScAptApplOptDO> opt_datas = new ArrayList<ScAptApplOptDO>();
		List<String> isAptedOrdList = this.isAptedOrdList(scAddApplInParams);
		for (Object obj : scAddApplInParams) {
			ScAddApplInParamDTO scAddApplInParam = (ScAddApplInParamDTO) obj;
			//1.校验是否存在，存在则抛出异常
			Boolean valid = this.SaveValid(scAddApplInParam,isAptedOrdList);
			if(!valid)
			{
				continue;
			}
			//2.保存 数据   sc_apt_appl
			ScAptApplDO newApplDO = this.getScAptAppl(scAddApplInParam);
			//3.保存数据   sc_apt_opt_emp
			//手术医嘱保存人员
			if(IScDictCodeConst.SD_SCTP_OT.equals(scAddApplInParam.getSd_sctp()))
			{
				List<ScAptOptEmpDO> emplist = this.getScAptOptEmps(scAddApplInParam.getExtend(),newApplDO);
				emp_datas.addAll(emplist);
				//保存sc_apt_appl_opt 麻醉方式等
				ScAptApplOptDO optdo = this.getScAptApplOpt(scAddApplInParam, newApplDO.getId_aptappl());
				opt_datas.add(optdo);
			}
			apt_datas.add(newApplDO);
		}
		this.saveData(apt_datas,emp_datas,opt_datas);
	}
	/**
	 * 批量保存数据
	 * @param apt_datas
	 * @param emp_datas
	 * @param opt_datas
	 * @throws BizException
	 */
	private void saveData(List<ScAptApplDO> apt_datas,List<ScAptOptEmpDO> emp_datas,List<ScAptApplOptDO> opt_datas) throws BizException{
		IScaptapplMDOCudService scaptapplCudService= ServiceFinder.find(IScaptapplMDOCudService.class);
		scaptapplCudService.save(apt_datas.toArray(new ScAptApplDO[0]));
		if(!ListUtil.isEmpty(emp_datas)){
			IAptoptempCudService aptoptempRService = ServiceFinder.find(IAptoptempCudService.class);
			aptoptempRService.save(emp_datas.toArray(new ScAptOptEmpDO[0]));
		}
		if(!ListUtil.isEmpty(opt_datas)){
			IScAptApplOptDOCudService cudService = ServiceFinder.find(IScAptApplOptDOCudService.class);
			cudService.save(opt_datas.toArray(new ScAptApplOptDO[0]));
		}
		
	}
	/**
	 * 1.校验是否存在，存在则抛出异常
	 * @param scAddApplInParam
	 * @param isAptedOrdList
	 * @return
	 * @throws BizException
	 */
	private Boolean SaveValid(ScAddApplInParamDTO scAddApplInParam,List<String> isAptedOrdList) throws BizException{
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
		if(IScDictCodeConst.SD_SCTP_OT.equals(scAddApplInParam.getSd_sctp()))
		{
			if(StringUtil.isEmpty(scAddApplInParam.getId_anestp()))
			{
				 throw new BizException ("手术类医嘱:Id_anestp 麻醉方式不能为空");
			}
		}
		if(!ListUtil.isEmpty(isAptedOrdList)){
			if (isAptedOrdList.contains(scAddApplInParam.getId_or())) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 获取已预约的id_or
	 * @param scAddApplInParams
	 * @return
	 * @throws DAException 
	 */
	private List<String> isAptedOrdList(FArrayList scAddApplInParams) throws DAException{
		List<String> ids = new ArrayList<String>();
		for (Object obj : scAddApplInParams) {
			ScAddApplInParamDTO scAddApplInParam = (ScAddApplInParamDTO) obj;
			ids.add(scAddApplInParam.getId_or());
		}
		StringBuilder sqlSB= new StringBuilder();
		sqlSB.append(" select id_or ");
		sqlSB.append(" from sc_apt_appl");
		sqlSB.append(" where fg_canc = 'N' ");
		sqlSB.append(" and ?");
		SqlParam param = new SqlParam();
		String cond = SqlUtils.getInSqlByIds(ScAptApplDO.ID_OR, ids);
		param.addParam(cond);
		List<String> result = (List<String>) new DAFacade().execQuery(sqlSB.toString(), param, new ColumnListHandler()); 
		return result;
	}
	/**
	 * 组装数据   sc_apt_appl
	 * @param scAddApplInParam
	 * @return
	 * @throws BizException
	 */
	private ScAptApplDO getScAptAppl(ScAddApplInParamDTO scAddApplInParam) throws BizException{
		//查找就诊信息
		IPativisitRService enEntService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO enEntDO = enEntService.findById(scAddApplInParam.getId_ent());
		if(enEntDO ==null)
		{
			throw new BizException ("未找到就诊信息！");
		}
		//查找患者信息
		IPatiMDORService patService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = patService.findById(enEntDO.getId_pat());
		if(patDO == null)
		{
			throw new BizException ("未找到患者信息！");
		}
		ScAptApplDO applDO = new ScAptApplDO();
		applDO.setStatus(DOStatus.NEW);
		if(enEntDO.getCode_entp().equals("10"))
		{
			applDO.setFg_bl(FBoolean.TRUE);
		}
		else
		{
			applDO.setFg_bl(scAddApplInParam.getFg_bl());
		}
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
		applDO.setFg_urgent(scAddApplInParam.getFg_urgent());//紧急标志
		applDO.setEu_aptmd(0);//申请单预约--0
		applDO.setId_srv(scAddApplInParam.getId_srv());
		applDO.setId_org(ScContextUtils.getOrgId());
		applDO.setId_grp(ScContextUtils.getGrpId());
		DBUtil util = new DBUtil();
		applDO.setId_aptappl(util.getOIDs(1)[0]);// 主键
		return applDO;
	}
	/**
	 * 组装数据   sc_apt_opt_emp
	 * @param scAptOptEmps
	 * @param newApplDO
	 * @return
	 */
	private List<ScAptOptEmpDO> getScAptOptEmps(FArrayList scAptOptEmps,ScAptApplDO newApplDO)
	{
		List<ScAptOptEmpDO> list = new ArrayList<ScAptOptEmpDO>();
		if(!ListUtil.isEmpty(scAptOptEmps))
		{
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
			
		}
		return list;
	}
	
	/**
	 * 组装数据   sc_apt_appl_opt
	 * @param scAddApplInParam
	 * @param id_apt_appl
	 * @return
	 * @throws BizException
	 */
	private ScAptApplOptDO getScAptApplOpt(ScAddApplInParamDTO scAddApplInParam,String id_apt_appl) throws BizException
	{
		ScAptApplOptDO optDO = new ScAptApplOptDO();
		optDO.setStatus(DOStatus.NEW);
		optDO.setId_aptappl(id_apt_appl);
		optDO.setId_anestp(scAddApplInParam.getId_anestp());//麻醉方式
		optDO.setSd_anestp(scAddApplInParam.getSd_anestp());
		optDO.setSpecialreq(scAddApplInParam.getSpecialreq());//特殊用物
		optDO.setSpecialinstrument(scAddApplInParam.getSpecialinstrument());//特殊仪器
		optDO.setSpecialdes(scAddApplInParam.getSpecialdes());//特殊准备
		return optDO;
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
		String code = codeManage.getPreBillCode_RequiresNew(doDescFullName);
		return code;
	}
}