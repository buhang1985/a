/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.s.bp.write;

import java.util.List;
import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.bd.srv.emreditor.i.IEmreditorRService;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDORService;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.srv.mrbasetpl.i.IMrbasetplRService;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtplstream.i.IMrtplstreamRService;
import iih.bd.srv.qcconreject.d.QcconrejectAggDO;
import iih.bd.srv.qcconreject.i.IQcconrejectRService;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.i.ICidiagRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.cimrfs.i.ICimrfsRService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.mr.mrdto.d.MrWriteTplDTO;
import iih.ci.mr.mrlog.d.CiMrLogDO;
import iih.ci.mr.mrlog.i.ICimrlogRService;
import iih.ci.mr.mrlogitm.d.CiMrLogItmDO;
import iih.ci.mr.mrlogitm.i.IMrlogitmRService;
import iih.ci.mr.mrpsndto.d.MrPsnDTO;
import iih.ci.mr.mrsign.d.CiMrSignCaDO;
import iih.ci.mr.mrsign.d.CiMrSignDO;
import iih.ci.mr.mrsign.i.IMrsignMDORService;
import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskRService;
import iih.en.pv.dto.d.EnEmrDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

/**
 * 〈扼要描述〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MrWriteQryBP {
	
    /**
     * 获取模板流
     * @param tplDto
     * @return
     * @throws BizException
     */
	public EmrTplStreamDO GetMrBytesByTpl(MrWriteTplDTO tplDto) throws BizException{
		IMrtplstreamRService tplFsService=ServiceFinder.find(IMrtplstreamRService.class);
		EmrTplStreamDO[] doArr=tplFsService.find("a0.id_mrtpl='"+tplDto.getId_mrtpl()+"'", "", FBoolean.FALSE);
		if (doArr.length>0) {
			return doArr[0];
		}else {
			return new EmrTplStreamDO();
		}
	}
	/**
	 * 获取文书DO
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public CiMrDO GetMrDOById(String id_mr) throws BizException{
		ICiemrRService mrService =ServiceFinder.find(ICiemrRService.class);
		return mrService.findById(id_mr);
	}
	/**
	 * 获取文书liuDO
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public CiMrFsDO GetMrFsDOByIdmr(String id_mr) throws BizException{
		ICimrfsRService mrService =ServiceFinder.find(ICimrfsRService.class);	
		CiMrFsDO[] fsDOs= mrService.find("a0.id_mr='"+id_mr+"'", "", FBoolean.FALSE);
		if (fsDOs.length>0) {
			return fsDOs[0];
		} else {
			return new CiMrFsDO();
		}
	}
	/**
	 * 获取患者的所有引用
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public MrDocRefValueDO[] GetAllReferencesByIdEnt(String id_ent) throws BizException{
		IMrdocrefvalueRService refService =ServiceFinder.find(IMrdocrefvalueRService.class);
		return refService.find("a0.id_ent='"+id_ent+"'", "", FBoolean.FALSE);
	}
	/**
	 * 获取编辑器DO
	 * @param id_mred
	 * @return
	 * @throws BizException
	 */
	public EmrEditorDO GetEmrEditorIdMred(String id_mred) throws BizException{
		IEmreditorRService refService =ServiceFinder.find(IEmreditorRService.class);
		return refService.findById(id_mred);
	}
	/**
	 * 获取内容互斥集合
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	public QcconrejectAggDO[] GetQcContentRejectList(CiMrDO ciMrDO) throws BizException{
		IQcconrejectRService qcService=ServiceFinder.find(IQcconrejectRService.class);
		QcconrejectAggDO[] doArr=qcService.find("a0.id_mrtp='" + ciMrDO.getId_mrtp() + "' or (a0.id_mrcactm='" + ciMrDO.getId_mrcactm() + "' and a0.id_mrtp is null)", "sv asc", FBoolean.FALSE);
		return doArr;
	}
	/**
	 * 获取文书的操作日志
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public CiMrLogDO[] GetMrLogListByIdMr(String id_mr) throws BizException {
		ICimrlogRService logService=ServiceFinder.find(ICimrlogRService.class);
		return logService.find("a0.id_mr='"+id_mr+"'", "sv", FBoolean.FALSE);
	}
	/**
	 * 获取操作明细
	 * @param id_mr_log
	 * @return
	 * @throws BizException
	 */
	public CiMrLogItmDO[] GetMrLogListByIdMrLog(String id_mr_log) throws BizException {
		IMrlogitmRService logService=ServiceFinder.find(IMrlogitmRService.class);
		return logService.find("a0.Id_mr_log='"+id_mr_log+"'", "", FBoolean.FALSE);
	}
	/**
	 * 获取已删除文书
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public CiMrDO[] GetHasDelMrByEnt(String id_ent) throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("select mr.*,su.name as modifiedby_name from ci_mr mr  ");
		sb.append("left join sys_user su  on su.id_user=mr.modifiedby  ");
		sb.append("where mr.ds='1' and mr.id_ent='" + id_ent + "'");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		List<CiMrDO> listMrs = (List<CiMrDO>) daf.execQuery(sql,
				new BeanListHandler(CiMrDO.class));
		return (CiMrDO[]) listMrs.toArray(new CiMrDO[0]);
	}
	/**
	 * 获取诊断
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public CidiagAggDO[] GetPatientDiags2(String id_ent) throws BizException {
		ICidiagRService diagService=ServiceFinder.find(ICidiagRService.class);
		return diagService.find("a0.id_en = '"+id_ent+"' and a0.fg_sign='Y' and a0.fg_cancel='N' ", "dt_di asc", FBoolean.FALSE);
	}
	/**
	 * 新增时候查询相关业务事件
	 * @param id_ent
	 * @param id_mrtp
	 * @return
	 * @throws BizException
	 */
	public MrTaskDO[] getMrTaskDoForAddEvent(String id_ent,String id_mrtp) throws BizException{
		IMrtaskRService mrtaskService=ServiceFinder.find(IMrtaskRService.class);
		return mrtaskService.find("a0.id_ent='"+id_ent+"' and a0.id_mrtp='"+id_mrtp+"'", "sv asc", FBoolean.FALSE);
	}
	/**
	 * 新增时候的上级医生下拉框data
	 * @param enEmrDto
	 * @param searchDto
	 * @return
	 * @throws DAException
	 */
	public MrPsnDTO[] getHigherDcotorForAdd(EnEmrDTO enEmrDto,MrWriteTplDTO searchDto) throws DAException {

		String id_dep=Context.get().getDeptId();
		StringBuilder sb = new StringBuilder();
		sb.append(" select sys_user.id_user,sys_user.id_psn,sys_user.name,bd_udidoc.name as Psndocname");
		sb.append(" from sys_user");
		sb.append(" left join bd_psndoc on bd_psndoc.id_psndoc = sys_user.id_basedoc");
		sb.append(" left join sys_subject_org on sys_subject_org.subjectid = sys_user.id_user");
		sb.append(" left join bd_udidoc on bd_psndoc.id_emptitle = bd_udidoc.id_udidoc and bd_udidoc.id_udidoclist = '@@@@ZZ2000000000003V'");
		sb.append(" where sys_subject_org.id_org = '"+id_dep+"' and bd_psndoc.sd_empwktp='01'");
		
		String strSql=sb.toString();
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<MrPsnDTO> listmrpsndtos = (List<MrPsnDTO>) daf.execQuery(strSql, new BeanListHandler(MrPsnDTO.class));
		if(listmrpsndtos==null)
			return null;
	    return (MrPsnDTO[]) listmrpsndtos.toArray(new MrPsnDTO[listmrpsndtos.size()]);
	}
	/**
	 * 获取当前用户的书写任务
	 * @param id_user
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public MrTaskDO[] getUserWriteTask(String id_user,String id_ent) throws BizException{
		IMrtaskRService taskService=ServiceFinder.find(IMrtaskRService.class);
		MrTaskDO[] doArr= taskService.find(" id_exec_doctor='"+id_user+"' and id_ent='"+id_ent+"'", "sv desc", FBoolean.FALSE);
		return doArr;
	}
    /**
     * 获取第一个文书一级分类（是类型组的，序号最小的）
     * @throws BizException
     */
	public MrWriteTplDTO getFirstMrcactm()throws BizException{
		DAFacade daf = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("select bd_mrca_ctm.id_mrcactm as id_mrcactm,bd_mrca_ctm.name as name_mrcactm from bd_mrca_ctm bd_mrca_ctm  ");
		sb.append("where bd_mrca_ctm.docornur in( 10,30) and bd_mrca_ctm.fg_types='Y' ");
		sb.append("order by  bd_mrca_ctm.sortno asc ");
		String sql = sb.toString();
		@SuppressWarnings("unchecked")
		List<MrWriteTplDTO> listMrs = (List<MrWriteTplDTO>) daf.execQuery(sql,
				new BeanListHandler(MrWriteTplDTO.class));
		if (listMrs!=null&&listMrs.size()>0) {
			return listMrs.toArray(new MrWriteTplDTO[listMrs.size()])[0];
		}else{
			return null;
		}
	}
	/**
	 * 获取基础模板
	 * 
	 * @throws BizException
	 */
	public EmrBaseTplDO getEmrBaseTpl(String id_mrtpl) throws BizException {
		IEmrtplMDORService emrtplMDORService = ServiceFinder.find(IEmrtplMDORService.class);
		EmrTplDO emrTplDO = emrtplMDORService.findById(id_mrtpl);
		if (emrTplDO == null) {
			return null;
		}
		IMrbasetplRService mrbasetplRService = ServiceFinder.find(IMrbasetplRService.class);
		return mrbasetplRService.findById(emrTplDO.getId_basemrtpl());
	}
	
	/**
	 * 组织签名数据
	 * @param id_mr
	 * @return
	 * @throws BizException
	 */
	public FMap2 pickSignData(String id_mr) throws BizException{
		FMap2 map = new FMap2();
		IMrsignMDORService mrsignRService = ServiceFinder.find(IMrsignMDORService.class);
		CiMrSignDO[] ciMrSignDos = mrsignRService.find("id_mr = '"+ id_mr +"'"  , "dt_sign desc", FBoolean.FALSE);
		if(ciMrSignDos == null || ciMrSignDos.length <= 0){
			return null;
		}
		int i = ciMrSignDos.length;
		map.put("SignEleId" , "username" + i);
		map.put("SignTimeEleId", "usertime" + i);
		map.put("SignName", ciMrSignDos[0].getEmp_sign_name());
		map.put("SignTime", ciMrSignDos[0].getDt_sign() != null ? ciMrSignDos[0].getDt_sign().toString() : "");
		map.put("Type", 0);
		map.put("TimeSpan", null);
		return map;
	}
	
	
	/**
	 * 取消签名的数据组装
	 * @param id_mr
	 * @param id_user 为取回的时候传的是id_psndoc 为驳回 的是时候传的是id_user
	 * @param type 1为取回 2位驳回
	 * @return
	 * @throws BizException 
	 */
	public FMap2 cancelSign(String id_mr,String id_user,int type) throws BizException{
		IMrsignMDORService mrsignRService = ServiceFinder.find(IMrsignMDORService.class);
		CiMrSignDO[] ciMrSignDos = mrsignRService.find("id_mr = '"+ id_mr +"'", "dt_sign", FBoolean.FALSE);
		if(ciMrSignDos == null || ciMrSignDos.length <= 0){
			return null;
		}
		FMap2 map = new FMap2();
		if(1 == type){
			for (int i = 0; i < ciMrSignDos.length; i++) {
				if(id_user.equals(ciMrSignDos[i].getId_emp_sign())){
					map.put("SignEleId" , "username" + (i + 1));
					map.put("SignTimeEleId", "usertime" + (i + 1));
				}
			}
			return map;
		}
		if(2 == type){
			IUserRService userRService = ServiceFinder.find(IUserRService.class);
			UserDO userDo = userRService.findById(id_user);
			int g = -1;
			for (int i = 0; i < ciMrSignDos.length; i++) {
				if(userDo.getId_psn().equals(ciMrSignDos[i].getId_emp_sign())){
					g = i + 1;
					break;
				}
			}
			if(g < 0){
				return null;
			}
			else if(g == ciMrSignDos.length){
				map.put("SignEleId" , "username" + g);
				map.put("SignTimeEleId", "usertime" + g);
			}
			else if(g > 0){
				StringBuffer signEleId = new StringBuffer();
				StringBuffer signTimeEleId = new StringBuffer();
				for (int i = g; i < ciMrSignDos.length + 1; i++) {
					if(i == ciMrSignDos.length){
						signEleId.append("username"+ i);
						signTimeEleId.append("usertime"+ i);
					}else{
						signEleId.append("username"+ i + ",");
						signTimeEleId.append("usertime"+ i + ",");
					}
				}
				map.put("SignEleId" , signEleId.toString());
				map.put("SignTimeEleId", signTimeEleId.toString());
			}
			return map;
		}
		return null;
	}
	
	// 组织患者签名数据
	public FMap2 combinePatSignData(String id_mr) throws BizException{
		FMap2 map = new FMap2();	
		DAFacade daf = new DAFacade(); 
		StringBuilder sql = new StringBuilder();
		sql.append("select * from  ci_mr_signca where id_mrsign in ");
		sql.append("  (select id_mrsign from ci_mr_sign where id_mr='");
		sql.append(id_mr); 		
		sql.append("') and ds=0 ");
		sql.append("  order by to_date(plain_sign_time,'yyyy-mm-dd hh24:mi:ss') desc");	
		String sqlStr=sql.toString();
		@SuppressWarnings("unchecked")
		List<CiMrSignCaDO> list = (List<CiMrSignCaDO>) daf.execQuery(sqlStr, new BeanListHandler(CiMrSignCaDO.class));		
		if(list==null || list.size()<=0) return null;
		
		IMrsignMDORService mrsignRService = ServiceFinder.find(IMrsignMDORService.class);
		CiMrSignDO ciMrSignDo = mrsignRService.findById(list.get(0).getId_mrsign());
		int i = list.size();
		map.put("SignEleId" , "patname" + i);
		map.put("SignTimeEleId", "pattime" + i);
		map.put("SignName", ciMrSignDo.getName_pat_sign());
		map.put("SignTime", list.get(0).getPlain_sign_time());
		map.put("Type", 0);
		map.put("TimeSpan", null);
		return map;
	}
	

	// ca认证取消患者签名
	public FMap2 cancelPatSign(String id_mr,String id_psndoc) throws BizException{
		IMrsignMDORService mrsignRService = ServiceFinder.find(IMrsignMDORService.class);
		CiMrSignDO[] ciMrSignDos = mrsignRService.find("id_mr = '"+ id_mr +"' and name_pat_sign is not null ", "dt_sign", FBoolean.FALSE);
		if(ciMrSignDos == null || ciMrSignDos.length <= 0) return null;
		FMap2 map = new FMap2();	
		for (int i = 0; i < ciMrSignDos.length; i++) {
			if(id_psndoc.equals(ciMrSignDos[i].getId_emp_sign())){
				map.put("SignEleId" , "patname" + (i + 1));
				map.put("SignTimeEleId", "pattime" + (i + 1));
				break;
			}
		}
		return map;		
	}
}
