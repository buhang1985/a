package iih.en.ip.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.ip.dto.d.EnHosRegInfoDTO;
import iih.en.pv.inpatient.d.InpatientDO;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 住院登记校验
 * @author Tang.ht
 *
 */
public class ValidateIPDataBP2 {
	/**
	 * 住院登记前校验
	 * @param patDTO
	 * @param enHosRegDTO
	 * @param isReg
	 * @return
	 * @throws BizException
	 */
	public InpatientDO exec(EnHosRegInfoDTO enHosRegInfoDTO,FBoolean isReg) throws BizException{
	
		//1.校验参数是否为空
		this.validateParam(enHosRegInfoDTO);
		if(!isReg.booleanValue()){
		//2.校验患者的id是否为空
			this.validatePatID(enHosRegInfoDTO);
		}
		//3.验证数据状态改变
		IpEP ipep = new IpEP();
		ipep.validateInpatientDOStatus(enHosRegInfoDTO.getId_ent());
		//4.校验患者是否已经在院
		if(!EnParamUtils.isMultIp())
			this.validatorPatInHos(enHosRegInfoDTO);
		//5.校验规则引擎
		/*if(!EnValidator.isEmpty(enHosRegInfoDTO.getId_pat())){
			RegRuleDTO regRule= new RegRuleDTO();
			regRule.setId_pat(enHosRegInfoDTO.getId_pat());
			regRule.setId_dept(enHosRegInfoDTO.getId_ip_phyadm());
			CheckIpRegitsRuleBP checkBp = new CheckIpRegitsRuleBP();
			checkBp.check(regRule);
		}*/
		//6.验证是否入科并且获取住院do
        InpatientDO inpatientDO = this.getInpatientDO(enHosRegInfoDTO);
		//7、校验床位是否发生了变化   床位是否被占用或者预约的床位发生了变化
		/*if (enHosRegInfoDTO.getFg_ip() == null || !enHosRegInfoDTO.getFg_ip().booleanValue()) {
			this.validateBedInfo(inpatientDO, enHosRegInfoDTO, enHosRegInfoDTO.getCode_sex());
		}	
		*/		
		//8.设置住院次数 并校验次数是否重复
		if (enHosRegInfoDTO.getTimes_ip() == null || enHosRegInfoDTO.getTimes_ip() == 0) {	
			enHosRegInfoDTO.setTimes_ip(ipep.setIpTimes(enHosRegInfoDTO.getId_pat()));
		}
		this.validateIPTimes(enHosRegInfoDTO.getId_pat(), enHosRegInfoDTO.getTimes_ip(),inpatientDO ==null ?"":inpatientDO.getId_inpatient());
		//9.校验入院通知单状态
		//this.validateScAptIp(enHosRegInfoDTO);
		return inpatientDO;
	}
	

	/**
	 * 查找住院数据
	 * 
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private InpatientDO getInpatientDO(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {		
		// 入科校验
		InpatientDO inpatientDO = new IpEP().getIpByEntId(enHosRegInfoDTO.getId_ent());
		if(inpatientDO == null)
			return null;
		if ((enHosRegInfoDTO.getFg_ip() == null || !enHosRegInfoDTO.getFg_ip().booleanValue()) && inpatientDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_STATUS_INDEPT);
		}
		if(enHosRegInfoDTO.getFg_ip() != null && enHosRegInfoDTO.getFg_ip().booleanValue()){
			if(!inpatientDO.getId_bed().equals(enHosRegInfoDTO.getId_bed())){
				throw new BizException(IEnMsgConst.ERROR_BED_STATUS_CHANGED2);
			}
		}
		return inpatientDO;
	}
	/**
	 * 新保存的数据校验患者是否已经在院
	 * @param enHosRegInfoDTO
	 * @throws BizException
	 */
	private void validatorPatInHos( EnHosRegInfoDTO enHosRegInfoDTO) throws BizException{
		if(EnValidator.isEmpty(enHosRegInfoDTO.getId_pat())){
			return ;
		}
		//此处只校验就诊id为空的情况，因为有的人有入科后修改数据的权限
		if (EnValidator.isEmpty(enHosRegInfoDTO.getId_ent())) {
			IpEP ipep = new IpEP();
			ipep.validateInpatientDO(enHosRegInfoDTO.getId_pat());
			return;
		}
	}

	/**
	 * 验证参数是否为空
	 * 
	 * @param enHosRegInfoDTO
	 *            入院登记DTO
	 * @throws BizException
	 */
	private void validateParam(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
		if (enHosRegInfoDTO == null) {
			throw new BizException(IEnMsgConst.EOORO_ENHOSREGINFO_NULL);
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
	@SuppressWarnings("unchecked")
	private void validateIPTimes(String patId, Integer times, String patientID) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select   times_ip from en_ent_ip  ip");
		sql.append(" inner join en_ent ent");
		sql.append(" on ent.id_ent = ip.id_ent");
		sql.append(" where id_pat = '");
		sql.append(patId);
		sql.append("'");

		if (!EnValidator.isEmpty(patientID)) {
			sql.append(" and id_inpatient != '" + patientID + "'");
		}
		FArrayList list = AppFwUtil.getMapListWithDao(sql.toString());
		if (!EnValidator.isEmpty(list)) {
			Map<String, Object> map = (Map<String, Object>) list.get(0);
			if ((Integer) map.get("times_ip") != null) {
				Integer oldtimes = (Integer) map.get("times_ip");
				if (times.equals(oldtimes)) {
					throw new BizException(IEnMsgConst.ERROR_HASTIMES);
				}
			}
		}

	}

	/**
	 * 校验患者id
	 * 
	 * @param patID
	 * @throws BizException
	 */
	private void validatePatID(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
		if (EnValidator.isEmpty(enHosRegInfoDTO.getId_pat())) {
			throw new BizException(IEnMsgConst.ERROR_PATID_NOT_EXIST);
		}
	}

	/**
	 * 校验床位信息
	 * 
	 * @param inpatientDO
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	/*private void validateBedInfo(InpatientDO inpatientDO, EnHosRegInfoDTO enHosRegInfoDTO, String sdPatSex) throws BizException {
		BedEP bedBP = new BedEP();
		if(EnValidator.isEmpty(enHosRegInfoDTO.getId_bed())){
			bedBP.getBedbyDep(enHosRegInfoDTO.getId_ip_nuradm(), sdPatSex,false);
			return;
		}
		if (inpatientDO == null || !inpatientDO.getId_bed().equals(enHosRegInfoDTO.getId_bed())) {
			
			bedBP.validateBedInfo(enHosRegInfoDTO.getId_bed(),enHosRegInfoDTO.getId_ent_ipnt());
		}
	} 	
	*/
	/**
	 * 校验入院通知单状态
	 * 
	 * @param enHosRegDTO
	 * @throws BizException 
	 */
	/*private void validateScAptIp(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
		if (enHosRegInfoDTO.getId_ent_ipnt() == null || enHosRegInfoDTO.getStatus() != DOStatus.NEW)
			return;
		IAptipMDORService rService = ServiceFinder.find(IAptipMDORService.class);
		AptIpDO aptIpDO = rService.findById(enHosRegInfoDTO.getId_ent_ipnt());
		if (aptIpDO != null && !aptIpDO.getSd_status().equals(enHosRegInfoDTO.getApt_status())) {
			throw new BizException(IEnMsgConst.ERROR_APTIP_HAS_CHG);
		}
	}*/
}
