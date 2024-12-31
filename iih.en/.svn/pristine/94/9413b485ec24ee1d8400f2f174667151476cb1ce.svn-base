package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.inpatient.d.EnMobAdmDO;
import iih.en.pv.inpatient.d.desc.EnMobAdmDODesc;
import iih.en.pv.inpatient.i.IEnmobadmdoCudService;
import iih.en.pv.inpatient.i.IEnmobadmdoRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

/**
 * 记录移动护理入科时间
 * 
 * @author jizb
 *
 */
public class RecordIpAcptDtBP {
	
	private final String ADDNEW = "0";
	private final String MODIFY = "1";

	public String exec(String patCode, String times_ip, String dt_acpt, String operatorCode, String flag) throws BizException {
		//校验入参是否为空
		String valResult = this.validateParam(patCode, times_ip, dt_acpt, operatorCode, flag);
		if (!EnValidator.isEmpty(valResult)) {
			return valResult;
		}
		//查询入院登记信息
		List<EnHosRegDTO> list = this.getIpRegInfo(patCode, times_ip);
		if (EnValidator.isEmpty(list)) {
			return "患者无此就诊记录！";
		}
		if (!IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN.equals(list.get(0).getSd_status())) {
			return "患者就诊状态发生改变，请刷新后重试！";
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		FDateTime dtAcpt;
		try {
			dtAcpt = new FDateTime(formatter.parse(dt_acpt));
		} catch (ParseException e) {
			return "入科时间格式错误！";
		}
		//更新就诊表
		this.updatePativist(list.get(0).getId_ent(), times_ip, dtAcpt);
		if (ADDNEW.equals(flag)) {
			//插入移动护理入科时间记录表
			this.insertRecordIpAcptDt(list.get(0).getId_ent(), patCode, times_ip, dtAcpt, operatorCode, flag);
		}else if (MODIFY.equals(flag)) {
			//更新移动护理入科时间记录表
			return this.updateRecordIpAcptDt(patCode, times_ip, dtAcpt, operatorCode, flag);
		}else {
			return "入参flag不正确";
		}
		return null;
	}
	
	/**
	 * 入参校验
	 * 
	 * @param patCode
	 * @param times_ip
	 * @param dt_acpt
	 * @param operatorCode
	 * @param flag
	 * @return
	 */
	private String validateParam(String patCode, String times_ip, String dt_acpt, String operatorCode, String flag) {
		if (EnValidator.isEmpty(patCode))
			return "参数患者编码为空!";
		if (EnValidator.isEmpty(times_ip))
			return "参数住院次数为空！";
		if (EnValidator.isEmpty(dt_acpt))
			return "参数入科时间为空！";
		if (StringUtil.isContainChinese(operatorCode))
			return "参数操作员编码为空！";
		if (EnValidator.isEmpty(flag))
			return "参数flag为空！";
		return null;
	}
	
	/**
	 * 查询入院登记信息
	 * 
	 * @param patCode
	 * @param times_ip
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<EnHosRegDTO> getIpRegInfo(String patCode, String times_ip) throws BizException {
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append(" select ent.id_ent, ");
		sb.append(" ip.sd_status ");
		sb.append(" from pi_pat pat ");
		sb.append(" inner join en_ent ent on pat.id_pat = ent.id_pat ");
		sb.append(" inner join en_ent_ip ip on ip.id_ent = ent.id_ent ");
		sb.append(" where pat.code = ? ");
		sb.append(" and ip.times_ip = ? ");
		param.addParam(patCode);
		param.addParam(times_ip);
		return (List<EnHosRegDTO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(EnHosRegDTO.class));
	}
	
	/**
	 * 更新就诊表
	 * 
	 * @param idEnt
	 * @param timesIp
	 * @param dtAcpt
	 * @return
	 * @throws BizException
	 */
	private String updatePativist(String idEnt, String timesIp, FDateTime dtAcpt) throws BizException{
		IPativisitRService ipRService = ServiceFinder.find(IPativisitRService.class);
		IPativisitCudService ipCudService = ServiceFinder.find(IPativisitCudService.class);
		PatiVisitDO entDO = ipRService.findById(idEnt);
		entDO.setDt_acpt(dtAcpt);
		entDO.setStatus(DOStatus.UPDATED);
		ipCudService.save(new PatiVisitDO[]{entDO});
		return null;
	}
	
	/**
	 * 更新en_ext_mobile_adm表
	 * 
	 * @param patCode
	 * @param times_ip
	 * @param dt_acpt
	 * @param operatorCode
	 * @param flag
	 * @throws BizException
	 */
	private void insertRecordIpAcptDt(String idEnt, String patCode, String times_ip, FDateTime dt_acpt, String operatorCode, String flag) throws BizException {
		IEnmobadmdoRService rService = ServiceFinder.find(IEnmobadmdoRService.class);
		IEnmobadmdoCudService cudService = ServiceFinder.find(IEnmobadmdoCudService.class);
		List<EnMobAdmDO> list = new ArrayList<EnMobAdmDO>();
		//修改旧记录
		String whereStr = String.format(EnMobAdmDODesc.TABLE_ALIAS_NAME + ".code_pat='%s' and " + EnMobAdmDODesc.TABLE_ALIAS_NAME + ".times_ip='%s' and " + EnMobAdmDODesc.TABLE_ALIAS_NAME + ".fg_valid='%s'", patCode, times_ip, FBoolean.TRUE);
		EnMobAdmDO[] oldDOs = rService.find(whereStr, null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(oldDOs)) {
			oldDOs[0].setFg_valid(FBoolean.FALSE);
			oldDOs[0].setStatus(DOStatus.UPDATED);
			list.add(oldDOs[0]);
		}
		//插入新记录
		EnMobAdmDO newDO = new EnMobAdmDO();
		newDO.setId_ent(idEnt);
		newDO.setCode_pat(patCode);
		newDO.setTimes_ip(Integer.parseInt(times_ip));
		newDO.setDt_acpt(dt_acpt);
		newDO.setId_emp_operator(operatorCode);
		newDO.setFlag(flag);
		newDO.setFg_valid(FBoolean.TRUE);
		newDO.setStatus(DOStatus.NEW);
		this.setGrpValue(newDO);
		list.add(newDO);
		cudService.save(list.toArray(new EnMobAdmDO[]{}));
	}
	
	/**
	 * 更新en_ext_mobile_adm表
	 * 
	 * @param patCode
	 * @param times_ip
	 * @param dt_acpt
	 * @param operatorCode
	 * @param flag
	 * @throws BizException
	 */
	private String updateRecordIpAcptDt(String patCode, String times_ip, FDateTime dt_acpt, String operatorCode, String flag) throws BizException {
		IEnmobadmdoRService rService = ServiceFinder.find(IEnmobadmdoRService.class);
		IEnmobadmdoCudService cudService = ServiceFinder.find(IEnmobadmdoCudService.class);
		List<EnMobAdmDO> list = new ArrayList<EnMobAdmDO>();
		//修改旧记录
		String whereStr = String.format(EnMobAdmDODesc.TABLE_ALIAS_NAME + ".code_pat='%s' and " + EnMobAdmDODesc.TABLE_ALIAS_NAME + ".times_ip='%s' and " + EnMobAdmDODesc.TABLE_ALIAS_NAME + ".fg_valid='%s'", patCode, times_ip, FBoolean.TRUE);
		EnMobAdmDO[] oldDOs = rService.find(whereStr, null, FBoolean.FALSE);
		if (!EnValidator.isEmpty(oldDOs)) {
			oldDOs[0].setFg_valid(FBoolean.TRUE);
			oldDOs[0].setStatus(DOStatus.UPDATED);
			oldDOs[0].setFlag(flag);
			oldDOs[0].setId_emp_operator(operatorCode);
			oldDOs[0].setDt_acpt(dt_acpt);
			cudService.save(oldDOs);
			return null;
		}
		return "未查询到可以修改的数据！";
	}
	
	/**
	 * 设置机构
	 * @throws BizException
	 */
	private void setGrpValue(EnMobAdmDO newDO) throws BizException
	{
		IOrgRService rService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDo = rService.findById(Context.get().getOrgId());
		newDO.setId_org(orgDo.getId_org());
		newDO.setId_grp(orgDo.getId_grp());;	
	}
	
}
