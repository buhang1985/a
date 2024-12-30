package iih.sc.apt.s.bp.mt;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import iih.ci.ord.dto.enappointmentdto.d.EnappointmentDTO;
import iih.ci.ord.i.external.provide.ICiOrdEnService;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 医嘱申请单操作BP(支持【医技】【检验】【治疗】)
 * 
 * @author zhengcm
 * @date 2017-08-11 11:35:45
 *
 */
public class MtAptCiObsOperateBP {

	/**
	 * 根据科室查询待预约医嘱申请单
	 *
	 * @author zhengcm
	 * 
	 * @param id_dep 执行科室ID
	 * @param sd_entps 就诊类型编码数组
	 * @param dt_begin 开始日期
	 * @param dt_end 结束日期
	 * @return 预约申请单DTO数组
	 * @throws BizException
	 */
	public MtAppDTO[] getAppObsByDept(String id_dep, String[] sd_entps, FDateTime dt_begin, FDateTime dt_end,String code_sctp)
			throws BizException {
		// 费用检查参数允许预约的申请单状态
		String[] status = new GetMtAptCheckFeeParamBP().exec(id_dep);
		// 预约医嘱服务类型参数
		String[] srvtpsParams = this.getAptSrvtpParams();
		// 查询参数DTO
		EnappointmentDTO paramDTO = new EnappointmentDTO();
		paramDTO.setId_dept(id_dep);
		paramDTO.setEn_entp(this.getFMapFromArray(sd_entps));
		paramDTO.setDtsignb(dt_begin);
		paramDTO.setDtsigne(dt_end);
		paramDTO.setPayment(this.getFMapFromArray(status));
		paramDTO.setSd_srvtp(this.getFMapFromArray(srvtpsParams));
		// 检验申请
		MtAppDTO[] applist = this.getAppDtoFromScAptApplDo(paramDTO, code_sctp);
		//AppObsDto[] datas = this.getCiEnService().GetAllAppRequisitionByIdDept(paramDTO);
		AppObsDto[] datas = null;
		MtAppDTO[] appDatas =  this.convertObsDTO2AppDTO(datas);
		return (MtAppDTO[]) ArrayUtils.addAll(appDatas, applist);
		//return applist;
	}
	/**
	 * 根据科室和患者查询待预约医嘱申请单
	 *
	 * @author zhengcm
	 * 
	 * @param id_dep 执行科室ID
	 * @param sd_entps 就诊类型编码数组
	 * @param dt_begin 开始日期
	 * @param dt_end 结束日期
	 * @return 预约申请单DTO数组
	 * @throws BizException
	 */
	public MtAppDTO[] getAppObsByDeptAndPat(String id_dep, String[] sd_entps, FDateTime dt_begin, FDateTime dt_end,String[] id_pats,String code_sctp)
			throws BizException {
		ScLogUtil.getInstance().logError("进入方法:MtAptCiObsOperateBP.getAppObsByDeptAndPat()");
		// 费用检查参数允许预约的申请单状态
		String[] status = new GetMtAptCheckFeeParamBP().exec(id_dep);
		// 预约医嘱服务类型参数
		String[] srvtpsParams = this.getAptSrvtpParams();
		// 查询参数DTO
		EnappointmentDTO paramDTO = new EnappointmentDTO();
		paramDTO.setId_dept(id_dep);
		paramDTO.setEn_entp(this.getFMapFromArray(sd_entps));
		paramDTO.setDtsignb(dt_begin);
		paramDTO.setDtsigne(dt_end);
		paramDTO.setPayment(this.getFMapFromArray(status));
		paramDTO.setSd_srvtp(this.getFMapFromArray(srvtpsParams));
		paramDTO.setId_pat(this.getFMapFromArray(id_pats));
		// 检验申请
		MtAppDTO[] applist = this.getAppDtoFromScAptApplDo(paramDTO,code_sctp);
		//AppObsDto[] datas = this.getCiEnService().GetAllAppRequisitionByIdDept(paramDTO);
		AppObsDto[] datas = null;
		MtAppDTO[] appDatas =  this.convertObsDTO2AppDTO(datas);
		ScLogUtil.getInstance().logError("结束方法:MtAptCiObsOperateBP.getAppObsByDeptAndPat()");
		return (MtAppDTO[]) ArrayUtils.addAll(appDatas, applist);
		
	}
	
	private MtAppDTO[] getAppDtoFromScAptApplDo(EnappointmentDTO enappointmentDTO,String code_sctp) throws BizException{
		ScLogUtil.getInstance().logError("进入方法MtAptCiObsOperateBP.getAppDtoFromScAptApplDo()");
		 if(enappointmentDTO != null && enappointmentDTO.getSd_srvtp() != null){
		     FMap2 map =  enappointmentDTO.getSd_srvtp();
		     StringBuffer condition = this.getSql(enappointmentDTO,code_sctp);
		     ScLogUtil.getInstance().logError("MtAptCiObsOperateBP.getAppDtoFromScAptApplDo()--->sql条件:"+condition.toString());
		     String qrySql = this.getSql(condition.toString());
		     ScLogUtil.getInstance().logError("MtAptCiObsOperateBP.getAppDtoFromScAptApplDo()--->sql语句:"+qrySql.toString());
		     //检查
		     if(map.containsKey(IBdSrvDictCodeConst.SD_SRVTP_RIS) || map.containsKey(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI) || map.containsKey(IBdSrvDictCodeConst.SD_SRVTP_LIS) || map.containsKey(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){
		    	 List<MtAppDTO> appList = (List<MtAppDTO>) new DAFacade().execQuery(qrySql,new BeanListHandler(MtAppDTO.class));
		    	 map.remove(IBdSrvDictCodeConst.SD_SRVTP_RIS);
		    	 map.remove(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI);
		    	 List<MtAppDTO> result = new ArrayList<MtAppDTO>();
		    	 if(!ListUtil.isEmpty(appList)){
		    		 Map<String,Boolean> checkFeeMap = new HashMap<String,Boolean>();
		    		 for (MtAppDTO mtAppDTO : appList) {
						boolean isCheckFee = false;
						if(checkFeeMap.containsKey(mtAppDTO.getId_dep_mp())){
						 isCheckFee = checkFeeMap.get(mtAppDTO.getId_dep_mp());
						}else{
						 isCheckFee = ScParamUtils.getScAptMtChkFee(mtAppDTO.getId_dep_mp());
						 checkFeeMap.put(mtAppDTO.getId_dep_mp(), isCheckFee);
						}
						if(mtAppDTO.getFg_needcfm() == null) mtAppDTO.setFg_needcfm(FBoolean.FALSE);
						if (isCheckFee) {
							if(mtAppDTO.getFg_needcfm().booleanValue()){
								result.add(mtAppDTO);
							}else if(!mtAppDTO.getFg_needcfm().booleanValue() && mtAppDTO.getFg_bl()!=null && mtAppDTO.getFg_bl().booleanValue()){
								result.add(mtAppDTO);
							}
						}else{
							result.add(mtAppDTO);
						}
						
					}
		    		 ScLogUtil.getInstance().logError("结束方法MtAptCiObsOperateBP.getAppDtoFromScAptApplDo()");
		    		 return (MtAppDTO[]) result.toArray(new MtAppDTO[result.size()]);
		    	 }
		     }
		    
		 }
		 ScLogUtil.getInstance().logError("结束方法MtAptCiObsOperateBP.getAppDtoFromScAptApplDo()");
		 return null;
	}
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	private String getSql(String condition){
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
		 sb.append(" case  when appl.fg_bl='Y' then '已收费' when appl.fg_bl='N' then '未收费'  when  appl.fg_bl is null then '未收费' end  name_bl ");
		 sb.append(" From sc_apt_appl appl ");  
		 sb.append(" inner join bd_srv srv on appl.id_srv = srv.id_srv");
		 sb.append(" left outer join bd_dep dep on dep.id_dep = appl.id_dep_appl");  
		 sb.append(" left outer join bd_dep mp_dep on appl.id_dep_mp = mp_dep.id_dep");
		 sb.append(" left outer join pi_pat pat on pat.id_pat = appl.id_pi");   
		 sb.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = appl.id_emp_appl");  
		 //sb.append(" left outer join en_ent ent on appl.id_ent=ent.id_ent");
		 sb.append(" left outer join sc_bdsrv bdsrv on appl.id_srv = bdsrv.id_srv");
		 sb.append(" where appl.fg_comfirm='N' ");
		 sb.append(" and appl.fg_canc = 'N' and appl.fg_reg_arv='N' and appl.fg_canc_exec = 'N'");
		 if(condition != null){
		 	sb.append(condition);
		 }
		 sb.append(" order by appl.dt_effe_or desc");
        return sb.toString();
	}
	
	/**
	 * 
	 * @param id_dep_exe
	 * @param entps
	 * @param lab_status
	 * @param dtSignB
	 * @param dtSignE
	 * @return
	 */
	private StringBuffer getSql(EnappointmentDTO enappointmentDTO,String code_sctp)throws BizException{
		
		 StringBuffer condition =  new StringBuffer();
 		  if(enappointmentDTO.getId_dept() != null){
	    		  condition.append(" and appl.id_dep_mp ='") ;
	    		  condition.append(enappointmentDTO.getId_dept());
	    		  condition.append("'");
    	  }
    	  if(enappointmentDTO.getEn_entp() != null && enappointmentDTO.getEn_entp().size() >0){
    		  condition.append(" and appl.code_entp in (") ;
    		  condition.append(ScSqlUtils.getMapConveretstr(enappointmentDTO.getEn_entp()));
    		  condition.append(")");
    	  }
    	  if(enappointmentDTO.getId_pat() != null && enappointmentDTO.getId_pat().size() >0){
    		  condition.append(" and appl.id_pi in (") ;
    		  condition.append(ScSqlUtils.getMapConveretstr(enappointmentDTO.getId_pat()));
    		  condition.append(")");
    	  }
    	  if(enappointmentDTO.getDtsignb() != null){
    		  condition.append(" and appl.dt_effe_or >='") ;
    		  condition.append(enappointmentDTO.getDtsignb());
    		  condition.append("'");
    	  }
    	  if(enappointmentDTO.getDtsigne() != null){
    		  condition.append("  and appl.dt_effe_or <='") ;
    		  condition.append(enappointmentDTO.getDtsigne());
    		  condition.append("'");
    	  }
    	  if(code_sctp != null)
    	  {
    		  condition.append("  and appl.sd_sctp ='") ;
    		  condition.append(code_sctp);
    		  condition.append("'");
    	  }
    	  else
    	  {
    		  condition.append("  and appl.sd_sctp ='") ;
    		  condition.append(IScDictCodeConst.SD_SCTP_MT);
    		  condition.append("'");
    	  }
    	  return condition;
	}
	/**
	 * 根据患者查询待预约医嘱申请单
	 *
	 * @author zhengcm
	 * 
	 * @param id_pat 患者ID
	 * @return 预约申请单DTO数组
	 * @throws BizException
	 */
	public MtAppDTO[] getAppObsByPat(String id_pat, String id_dep, String code_sctp,FDateTime d_begin) throws BizException {
		// 费用检查参数允许预约的申请单状态
		String[] status = new GetMtAptCheckFeeParamBP().exec(id_dep);
		// 预约医嘱服务类型参数
		String[] srvtpsParams = this.getAptSrvtpParams();
		// 查询参数DTO
		EnappointmentDTO paramDTO = new EnappointmentDTO();
		paramDTO.setId_pat(this.getFMapFromArray(new String[] { id_pat }));
		paramDTO.setPayment(this.getFMapFromArray(status));
		paramDTO.setSd_srvtp(this.getFMapFromArray(srvtpsParams));
		paramDTO.setDtsignb(d_begin);
		if(d_begin!=null){
			FDateTime d_end = d_begin.getDateTimeAfter(1);
			paramDTO.setDtsigne(d_end);
		}
		// 检验申请
		MtAppDTO[] applist = this.getAppDtoFromScAptApplDo(paramDTO, code_sctp);
		//AppObsDto[] datas = this.getCiEnService(pt(paramDTO);
		AppObsDto[] datas = null;
		MtAppDTO[] appDatas = this.convertObsDTO2AppDTO(datas);
		return (MtAppDTO[]) ArrayUtils.addAll(appDatas, applist);
//		return applist;
	}

	/**
	 * 根据申请单号查询医嘱申请单(需求问题，暂不可用)
	 *
	 * @author zhengcm
	 * 
	 * @param appNo 申请单号
	 * @return 预约申请单DTO数组
	 * @throws BizException
	 */
	public MtAppDTO getAppObsByNo(String appNo) throws BizException {
		AppObsDto obsAppDTO = this.getCiEnService().getRisAppByNO(appNo);
		if (null == obsAppDTO) {
			return null;
		}
		return this.convertObsDTO2AppDTO(new AppObsDto[] { obsAppDTO })[0];
	}

	/**
	 * 回写医嘱申请单状态（预约和取消预约）
	 *
	 * @author zhengcm
	 * 
	 * @param id_or 医嘱ID
	 * @param isApt 是否预约
	 * @throws BizException
	 */
	public void rewriteObsStatus(String id_or, boolean isApt,FDateTime aptTime) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_or)) {
			return;
		}
		this.getCiEnService().updateAppStatus(id_or, isApt,aptTime);
	}

	/**
	 * 获取预约医嘱服务类型参数
	 *
	 * @author zhengcm
	 * 
	 * @return 医嘱服务类型参数字符串数组
	 * @throws BizException
	 */
	private String[] getAptSrvtpParams() throws BizException {
		String paramVal = ScParamUtils.getObsAptSrvtps();
		if (StringUtil.isEmptyWithTrim(paramVal)) {
			throw new BizException(IScMsgConst.SC_APT_MT_OBSAPT_SRVTPS_EMPTY);
		}
		paramVal = paramVal.replaceAll("，", ",");
		return paramVal.split(",");
	}

	/**
	 * 将医嘱申请单DTO转换成医技预约申请单DTO
	 *
	 * @author zhengcm
	 * 
	 * @param obsDTOs 医嘱申请单数组
	 * @return 预约申请单DTO数组
	 * @throws BizException
	 */
	private MtAppDTO[] convertObsDTO2AppDTO(AppObsDto[] obsDTOs) throws BizException {
		if (ArrayUtil.isEmpty(obsDTOs)) {
			return null;
		}
		List<MtAppDTO> list = new ArrayList<MtAppDTO>();
		for (AppObsDto obsDTO : obsDTOs) {
			MtAppDTO appDTO = new MtAppDTO();
			appDTO.setId_ent(obsDTO.getId_en());// 就诊ID
			appDTO.setId_enttp(obsDTO.getId_entp());// 就诊类型编码
			appDTO.setId_pat(obsDTO.getId_pat());// 患者ID
			appDTO.setDt_plan(obsDTO.getDt_effe());// 计划日期
			appDTO.setDt_apply(obsDTO.getDt_effe().getBeginDate());
			appDTO.setId_or(obsDTO.getId_or());// 医嘱ID
			appDTO.setName_or(obsDTO.getName_or());// 医嘱名称
			appDTO.setCode_or(obsDTO.getCode_or());// 医嘱编码
			appDTO.setContent_or(obsDTO.getContent_or());// 医嘱内容
			appDTO.setDesc_or(obsDTO.getDesc_or());// 医嘱描述
			appDTO.setFg_urgent(obsDTO.getFg_urgent());// 紧急标识
			appDTO.setId_orsrv(obsDTO.getId_orsrv());// 医嘱服务ID
			appDTO.setId_srv(obsDTO.getId_srv());// 主服务ID
			appDTO.setName_srv(obsDTO.getName_srv());// 主服务名称
			appDTO.setId_dep_apply(obsDTO.getId_dep_sign());// 申请科室ID
			appDTO.setName_dep_apply(obsDTO.getName_dep_sign());// 申请科室名称
			appDTO.setId_dep_mp(obsDTO.getId_dep_mp());// 执行科室ID
			appDTO.setName_dep_mp(obsDTO.getName_dep_mp());// 执行科室名称
			appDTO.setId_emp_apply(obsDTO.getId_emp_sign());// 申请医生ID
			appDTO.setNo_applyform(obsDTO.getApplyno());// 医嘱申请单号
			list.add(appDTO);
		}
		return list.toArray(new MtAppDTO[0]);
	}
	/**
	 * 将字符串Array转换为FMap
	 *
	 * @author zhengcm
	 * 
	 * @param datas 字符串数组
	 * @return FMap格式
	 * @throws BizException
	 */
	private FMap2 getFMapFromArray(String[] datas) throws BizException {
		if (ArrayUtil.isEmpty(datas)) {
			return null;
		}
		FMap2 fmap = new FMap2();
		for (String str : datas) {
			fmap.put(str, str);
		}
		return fmap;
	}

	/**
	 * 获取医嘱对就诊服务
	 *
	 * @author zhengcm
	 * 
	 * @return 医嘱对就诊服务
	 * @throws BizException
	 */
	private ICiOrdEnService getCiEnService() throws BizException {
		return ServiceFinder.find(ICiOrdEnService.class);
	}

}
