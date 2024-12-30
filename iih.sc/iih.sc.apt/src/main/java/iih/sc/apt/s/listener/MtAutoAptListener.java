package iih.sc.apt.s.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.bc.event.pub.IScEventConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.i.IScAptQryService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScaptapplAggDO;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.apt.scaptappl.i.IScaptapplRService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.comm.SchPkLockUtil;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.s.ep.ScBdSrvEP;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 医技自动预约--集成平台监听器
 * 
 * @author li.wm
 *
 */
public class MtAutoAptListener implements IBusinessListener {
	/**
	 * 医技预约发消息
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		MtApt4EsDTO eventSourceDTO = (MtApt4EsDTO) bizUserObj.getUserObj();
		//校验申请单是否已经被预约
		List<MtAppDTO> applist = this.getMtApp(eventSourceDTO.getId_aptappl(),eventSourceDTO.getIdors());
		if(ListUtil.isEmpty(applist)) return;
		this.makeAutoApt(applist);
	}
	
	/**
	 * 验证事件
	 * 
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IScEventConst.EVENT_SOURCE_SC_MT_APT.equalsIgnoreCase(event.getSourceID())
				|| !IScEventConst.EVENT_SC_MT_AUTO_APT.equals(event.getEventType())) {
			throw new BizException(IScMsgConst.ERROR_LISTENER_NO_SOURCE);
		}
	}

	/**
	 * 进行自动预约
	 * @param appDTO
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private void makeAutoApt(List<MtAppDTO> applist) throws BizException{
		IScAptCmdService iscaptcmdservice = ServiceFinder.find(IScAptCmdService.class);
		IScAptQryService iscaptqryservice = ServiceFinder.find(IScAptQryService.class);
		IUdidocRService iudidocrservice = ServiceFinder.find(IUdidocRService.class);
		List<String> idsrvlist = new ArrayList<String>();
		for (MtAppDTO appDTO : applist) {
			idsrvlist.add(appDTO.getId_srv());
		}
		Map<String,ScBdsrvDO> scbdsrvMap = this.getScBdSrv(idsrvlist.toArray(new String[0]));
		DAFacade dafacade = new DAFacade();
		SqlParam param = new SqlParam();
		IScAptOutCmdService iscaptoutcmdservice = ServiceFinder.find(IScAptOutCmdService.class);
		if(scbdsrvMap == null) return;
		for (MtAppDTO appDTO : applist) {
			if(!isApted(appDTO.getId_apt_appl())){
				//对申请单加锁
				SchPkLockUtil.lock(appDTO.getId_apt_appl());
				SchedulechlDO[] schedulechldos = null;
				try {
					String id_scchltp= ScParamUtils.getScMtAutoAptChl(appDTO.getId_dep_mp());
					UdidocDO udi = iudidocrservice.findById(id_scchltp);
					if(udi == null) continue;
					String sd_scchltp = udi.getCode();
					schedulechldos = iscaptqryservice.valAptHaveChannel(sd_scchltp);
				} catch (Exception e) {
					continue;
				}
				if(ArrayUtils.isEmpty(schedulechldos)) continue;
				String id_scchl = schedulechldos[0].getId_scchl();
				if(StringUtil.isEmpty(id_scchl)){
					continue;
				}
				//判断该服务是否允许自动预约
				FBoolean value = FBoolean.FALSE;
				value = this.checkAutoapt(appDTO, scbdsrvMap);
				// 判断患者是门诊还是住院的
				if(!value.booleanValue()) continue;
				MtResDTO mtResDTO = new MtResDTO();
				mtResDTO.setFg_autofilter(FBoolean.FALSE);
				mtResDTO.setId_dep(appDTO.getId_dep_mp());
				mtResDTO.setId_scchl(id_scchl);
				mtResDTO.setId_scca(appDTO.getId_scca());
				try {
					MtResDTO resDTO = iscaptcmdservice.saveAutoMtApt(mtResDTO, appDTO);
				} catch (BizException e) {
					ScLogUtil.getInstance().logError("MtAutoAptListener自动预约异常，异常信息:"+e.getMessage()+"，参数id_aptappl:"+appDTO.getId_apt_appl());
				}
			}
		}
	}
	

	/**
	 *  判断患者是否能进行自动预约
	 * @param appDTO
	 * @return
	 * @throws DAException
	 */
	private FBoolean checkAutoapt(MtAppDTO appDTO,Map<String,ScBdsrvDO> scbdsrvMap) throws BizException{
		if(ScValidator.isNullOrEmpty(appDTO)) 
			return FBoolean.FALSE;
		IScaptapplRService service = ServiceFinder.find(IScaptapplRService.class);
		ScaptapplAggDO aptapplDO = service.findById(appDTO.getId_apt_appl());
		if(IEnDictCodeConst.SD_ENTP_OUTPATIENT.equals(aptapplDO.getParentDO().getCode_entp())){
			return scbdsrvMap.get(aptapplDO.getParentDO().getId_srv()).getFg_autoapt_op();
		}else if (IEnDictCodeConst.SD_ENTP_INPATIENT.equals(aptapplDO.getParentDO().getCode_entp())){
			return scbdsrvMap.get(aptapplDO.getParentDO().getId_srv()).getFg_autoapt_ip();
		}else{
			return  FBoolean.FALSE;
		}
	}
	
	
	/**
	 * 获取医技预约申请单数据
	 * @param id_aptappl
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private List<MtAppDTO> getMtApp(String id_aptappl,FArrayList idors) throws DAException{
		if(StringUtil.isEmpty(id_aptappl) && ListUtil.isEmpty(idors)) return null;
		String sql = this.getSql(id_aptappl,idors);
		SqlParam params = new SqlParam();
		if(!StringUtil.isEmpty(id_aptappl)){
			params.addParam(id_aptappl);
		}
		// 查询
		List<MtAppDTO> appDTOList = (List<MtAppDTO>) new DAFacade().execQuery(sql, params,new BeanListHandler(MtAppDTO.class));
		if(ListUtil.isEmpty(appDTOList)) return null;
		return appDTOList;
	}
	/**
	 * 获取医技预约申请单sql
	 * @param condition
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String getSql(String id_aptappl,FArrayList idors){
		 StringBuffer sb = new StringBuffer();
		 sb.append(" select"); 
		 sb.append(" appl.id_aptappl as id_apt_appl, "); 
		 sb.append(" appl.id_or,");
		 sb.append(" appl.id_ent,");
		 sb.append(" appl.id_pi as id_pat,");
		 sb.append(" appl.id_scca,");
		 sb.append(" appl.content_or,");
		 sb.append(" appl.des,");
		 sb.append(" appl.id_srv,");
		 sb.append(" appl.id_dep_appl as id_dep_apply,");
		 sb.append(" appl.id_dep_mp,");
		 sb.append(" appl.id_emp_appl as id_emp_apply,");
		 sb.append(" appl.sd_aptmd,appl.sd_sys_from,");
		 sb.append(" psndoc.name as name_emp_apply,");
		 sb.append(" appl.applyno,");
		 sb.append(" appl.id_entp as id_enttp,"); 
		 sb.append(" appl.dt_effe_or as dt_plan,");
		 sb.append(" appl.dt_effe_or,");
		 sb.append(" appl.name as name_or,");
		 sb.append(" appl.fg_urgent,");
		 sb.append(" appl.fg_hp,");//医保支付标识
		 sb.append(" srv.name as name_srv,");
		 sb.append(" dep.name as name_dep_apply,");  
		 sb.append(" mp_dep.name as name_dep_mp,");
		 sb.append(" pat.name as name_pat,");
		 sb.append(" pat.id_sex,");
		 sb.append(" pat.sd_sex,  ");  
		 sb.append(" pat.dt_birth as dt_birth_pat,");
		 sb.append(" bdsrv.fg_needcfm,");
		 sb.append(" appl.fg_bl,");
		 sb.append(" org.name as name_org,");
		 sb.append(" appl.id_org,");
		 sb.append(" pat.name as name_pat,");
		 sb.append(" pat.barcode_chis as code_pat,");
		 sb.append(" case  when appl.fg_bl='Y' then '已收费' when appl.fg_bl='N' then '未收费'  when  appl.fg_bl is null then '未收费' end  name_bl ");
		 sb.append(" From sc_apt_appl appl ");  
		 sb.append(" inner join bd_srv srv on appl.id_srv = srv.id_srv");
		 sb.append(" left outer join bd_dep dep on dep.id_dep = appl.id_dep_appl");  
		 sb.append(" left outer join bd_dep mp_dep on appl.id_dep_mp = mp_dep.id_dep");
		 sb.append(" left outer join pi_pat pat on pat.id_pat = appl.id_pi");   
		 sb.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = appl.id_emp_appl");  
		 sb.append(" left outer join bd_org org on appl.id_org=org.id_org");
		 sb.append(" left outer join sc_bdsrv bdsrv on appl.id_srv = bdsrv.id_srv");
		 sb.append(" left outer join pi_pat pat on appl.id_pi=pat.id_pat");
		 sb.append(" where appl.fg_comfirm='N' ");
		 sb.append(" and appl.fg_canc = 'N' and appl.fg_reg_arv='N' and appl.fg_canc_exec = 'N' and (appl.code_entp = '00' or  appl.code_entp = '10') ");
		 if(!StringUtil.isEmpty(id_aptappl)){
			 sb.append(" and appl.id_aptappl = ?");
		 }
		 if(!ListUtil.isEmpty(idors)){
			 String cond = ScSqlUtils.getInSqlByIds(" appl.id_or", idors);
			 sb.append(" and ");
			 sb.append(cond);
		 }
		 sb.append(" order by appl.dt_effe_or desc");
        return sb.toString();
	}
	/**
	 * 获取排班医疗项目是否适用门诊自动预约
	 * @param idSrvs
	 * @return
	 * @throws BizException 
	 */
	private Map<String,ScBdsrvDO> getScBdSrv(String[] idSrvs) throws BizException{
		ScBdsrvDO[] scbdsrvs = new ScBdSrvEP().getScBdSrvByIdSrv(idSrvs);
		if(ArrayUtils.isEmpty(scbdsrvs))return null;
		Map<String,ScBdsrvDO> result = new HashMap<String, ScBdsrvDO>();
		for (ScBdsrvDO scBdsrvDO : scbdsrvs) {
			if(!result.containsKey(scBdsrvDO.getId_srv())){
				result.put(scBdsrvDO.getId_srv(), scBdsrvDO);
			}
		}
		return result;
	}
	/**
	 * 获取患者门诊 和住院号
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatInfo(String id_pat,DAFacade dafacade) throws BizException{
		StringBuffer sqlQry = new StringBuffer();
		sqlQry.append("select * from pi_pat where id_pat = ?");
		SqlParam param = new SqlParam();
		param.addParam(id_pat);
		List<PatDO> pats = (List<PatDO>) dafacade.execQuery(sqlQry.toString(), param, new BeanListHandler(PatDO.class));
		if (!ListUtil.isEmpty(pats)) {
			return pats.get(0);
		}
		return null;
	}
	/**
	 * 判断医嘱对应预约申请单是否已经预约 已预约返回true  未预约返回false
	 * @param id_aptappl
	 * @return
	 * @throws BizException
	 */
	private boolean isApted(String id_aptappl) throws BizException{
		IScaptapplMDORService iscaptapplmdorservice = ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO applDO = iscaptapplmdorservice.findById(id_aptappl);
		if(!StringUtil.isEmpty(applDO.getId_scapt())){
			IScaptMDORService iscaptmdorservice = ServiceFinder.find(IScaptMDORService.class);
			ScAptDO[] aptDOs = iscaptmdorservice.find("id_apt = '"+applDO.getId_scapt()+"' and fg_canc = 'N'", null, FBoolean.FALSE);
			if(ArrayUtil.isEmpty(aptDOs)) return false;
			return true;
		}else{
			return false;
		}
	}
}
