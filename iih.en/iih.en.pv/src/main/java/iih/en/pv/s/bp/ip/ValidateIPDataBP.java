package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.en.pv.s.rule.CheckIpRegitsRuleBP;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 住院登记校验
 * @author Sarah
 *
 */
public class ValidateIPDataBP {
	/**
	 * 住院登记前校验
	 * @param patDTO
	 * @param enHosRegDTO
	 * @param isReg
	 * @return
	 * @throws BizException
	 */
	public InpatientDO exec(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO,FBoolean isReg) throws BizException{
		//1.校验参数是否为空
		this.validateParam(enHosRegDTO,patDTO);
		//校验合并患者，如果患者已经被合并，不能入院登记，如果是登记修改，不校验 zhangpp 2019.10.08
		if(enHosRegDTO.getStatus() == DOStatus.NEW){
			this.validatePatCombine(patDTO);
		}
		if(!isReg.booleanValue()){
		//2.校验患者的id是否为空
			this.validatePatID(patDTO,enHosRegDTO);
		}
		//3.验证数据状态改变
		IpEP ipep = new IpEP();
		ipep.validateInpatientDOStatus(enHosRegDTO.getId_ent());
		//4.校验患者是否已经在院
		if(!EnParamUtils.isMultIp())
			this.validatorPatInHos(enHosRegDTO);
		//5.校验规则引擎
		if(!EnValidator.isEmpty(patDTO.getId_pat())){
			RegRuleDTO regRule= new RegRuleDTO();
			regRule.setId_pat(patDTO.getId_pat());
			regRule.setId_dept(enHosRegDTO.getId_dep_phyadm());
			CheckIpRegitsRuleBP checkBp = new CheckIpRegitsRuleBP();
			checkBp.check(regRule,enHosRegDTO);
		}
		//6.验证是否入科并且获取住院do
        InpatientDO inpatientDO = this.getInpatientDO(enHosRegDTO);
		//7、校验床位是否发生了变化   床位是否被占用或者预约的床位发生了变化
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) {
			this.validateBedInfo(inpatientDO, enHosRegDTO, patDTO.getSd_sex());
		}			
		//8.设置住院次数 并校验次数是否重复
		if (enHosRegDTO.getTimes() == null || enHosRegDTO.getTimes() == 0) {	
			enHosRegDTO.setTimes(ipep.setIpTimes(patDTO.getId_pat()));
		}
		this.validateIPTimes(patDTO.getId_pat(), enHosRegDTO.getTimes(),inpatientDO ==null ?"":inpatientDO.getId_inpatient());
		//9.校验入院通知单状态
		this.validateScAptIp(enHosRegDTO);
		return inpatientDO;
	}
	
	/**
	 * 校验合并患者
	 * @param patDto
	 * @throws BizException
	 */
	private void validatePatCombine(EnHosPatDTO patDto) throws BizException{
		if (patDto.getId_pat() == null) {
			return;
		}
		IPatiMDORService iService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = iService.findById(patDto.getId_pat());
		if (patDO == null) {
			return;
		}
		if (FBoolean.FALSE.equals(patDO.getFg_active())) {
			throw new BizException("患者已经被合并，不能进行入院登记！");
		}
	}
	
	/**
	 * 查找住院数据
	 * 
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private InpatientDO getInpatientDO(EnHosRegDTO enHosRegDTO) throws BizException {	
		if (enHosRegDTO.getId_ent() == null) {
			return null;
		}
		// 入科校验
		InpatientDO inpatientDO = new IpEP().getIpByEntId(enHosRegDTO.getId_ent());
		if (inpatientDO == null) {
			return null;
		}
		if ((enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) && inpatientDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_STATUS_INDEPT);
		}
		if(enHosRegDTO.getFg_ip() != null && enHosRegDTO.getFg_ip().booleanValue()){
			if(!inpatientDO.getId_bed().equals(enHosRegDTO.getId_bed())){
				throw new BizException(IEnMsgConst.ERROR_BED_STATUS_CHANGED2);
			}
		}
		return inpatientDO;
	}
	/**
	 * 新保存的数据校验患者是否已经在院
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	private void validatorPatInHos( EnHosRegDTO enHosRegDTO) throws BizException{
		if(EnValidator.isEmpty(enHosRegDTO.getId_pat())){
			return ;
		}
		//此处只校验就诊id为空的情况，因为有的人有入科后修改数据的权限
		if (EnValidator.isEmpty(enHosRegDTO.getId_ent())) {
			IpEP ipep = new IpEP();
			ipep.validateInpatientDO(enHosRegDTO.getId_pat());
			return;
		}
	}

	/**
	 * 验证参数是否为空
	 * 
	 * @param enHosRegDTO
	 *            入院登记DTO
	 * @throws BizException
	 */
	private void validateParam(EnHosRegDTO enHosRegDTO,EnHosPatDTO patDTO) throws BizException {
		if (enHosRegDTO == null) {
			throw new BizException(IEnMsgConst.ERROR_ENHOSREG_NULL);
		}
		if (patDTO == null) {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
	}
	


	/**
	 * 校验住院次数
	 * 
	 * @param patId
	 * @param times
	 * @param patientID
	 * @throws BizException
	 */
	private void validateIPTimes(String patId, Integer times, String patientID) throws BizException {
		SqlParam param = new SqlParam();
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(1) from en_ent_ip ip");
		sql.append(" inner join en_ent ent");
		sql.append(" on ent.id_ent = ip.id_ent");
		sql.append(" where ent.id_pat = ? ");
		sql.append(" and ip.times_ip = ? ");
		param.addParam(patId);
		param.addParam(times);
		if (!EnValidator.isEmpty(patientID)) {
			sql.append(" and id_inpatient <> ? ");
			param.addParam(patientID);
		}
		Integer times_ip =  (Integer)new DAFacade().execQuery(sql.toString(), param, new ColumnHandler());
		if (times_ip != null && times_ip > 0) {
			throw new BizException(IEnMsgConst.ERROR_HASTIMES);
		}
	}

	/**
	 * 校验患者id
	 * 
	 * @param patID
	 * @throws BizException
	 */
	private void validatePatID(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO) throws BizException {
		if (EnValidator.isEmpty(patDTO.getId_pat())) {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}

		if (EnValidator.isEmpty(enHosRegDTO.getId_pat())) {
			throw new BizException(IEnMsgConst.ERROR_ENT_PATID_NOT_EXIST);
		}
	}

	/**
	 * 校验床位信息
	 * 
	 * @param inpatientDO
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	private void validateBedInfo(InpatientDO inpatientDO, EnHosRegDTO enHosRegDTO, String sdPatSex) throws BizException {
		BedEP bedBP = new BedEP();
		if(EnValidator.isEmpty(enHosRegDTO.getId_bed())){
			bedBP.getRegistBedbyDep(enHosRegDTO.getId_dep_nuradm(), sdPatSex);
			return;
		}
		if (inpatientDO == null || !inpatientDO.getId_bed().equals(enHosRegDTO.getId_bed())) {
			
			bedBP.validateBedInfo(enHosRegDTO.getId_bed(),enHosRegDTO.getId_ent_ipnt());
		}
	} 	
	
	/**
	 * 校验入院通知单状态
	 * 
	 * @param enHosRegDTO
	 * @throws BizException 
	 */
	private void validateScAptIp(EnHosRegDTO enHosRegDTO) throws BizException {
		if (enHosRegDTO.getId_ent_ipnt() == null || enHosRegDTO.getStatus() != DOStatus.NEW)
			return;
		IAptipMDORService rService = ServiceFinder.find(IAptipMDORService.class);
		AptIpDO aptIpDO = rService.findById(enHosRegDTO.getId_ent_ipnt());
		if (aptIpDO != null && !aptIpDO.getSd_status().equals(enHosRegDTO.getApt_status())) {
			throw new BizException(IEnMsgConst.ERROR_APTIP_HAS_CHG);
		}
	}
}
