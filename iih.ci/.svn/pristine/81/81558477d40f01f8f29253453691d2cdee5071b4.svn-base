/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.s.bp.medicaldepqc;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.autoitm.d.AutoItmDO;
import iih.bd.srv.autoitm.i.IAutoitmRService;
import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.emrtype.i.IEmrtypeRService;
import iih.bd.srv.qcevent.d.QcEventDO;
import iih.bd.srv.qcevent.i.IQceventRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mrqc.autoqcdto.d.AutoQcDTO;
import iih.ci.mrqc.cimrtaskdto.d.CiMrTaskDTO;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.divide.i.IDivideCudService;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 〈扼要描述〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MedicalDepQcExeBp  extends PagingServiceImpl<CiMrTaskDTO>{
	/**
	 * 科室查看医务要求的书写项
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<CiMrTaskDTO> getDepCheckMedicalQcItmList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		
		execBefore(qryRootNodeDTO);

 		StringBuilder sql = new StringBuilder();
	 		sql.append("SELECT divde.rfm_req as rfm_req,\n");
	 		sql.append("       divde.drp_des as drp_des,\n");
	 		sql.append("       divde.Sbmt_time as Dt_begin,\n");
	 		sql.append("       divde.Deduct_scr_times as dead_hours,\n");
	 		sql.append("       autoconfig.id_mrcactm as id_mrcactm,\n");
	 		sql.append("       autoconfig.id_mr_types as id_mrtp,\n");
	 		sql.append("       ent.name_pat as name_pat,\n");
	 		sql.append("       ent.id_pat as id_pat,\n");
	 		sql.append("       ent.id_ent as id_ent,\n");
	 		sql.append("       dep.name as Name_dep_phy,\n");
	 		sql.append("       psn.name as name_emp_phy\n");
			sql.append("  FROM ci_qa_divide divde\n"); 
			sql.append("  LEFT JOIN ci_qa_itm cqi\n"); 
			sql.append("    ON divde.id_qa_itm = cqi.id_qa_itm\n"); 
			sql.append("  LEFT JOIN en_ent ent\n"); 
			sql.append("    ON ent.id_ent = divde.id_ent \n"); 
			sql.append("  LEFT JOIN bd_qa_auto_itm_config autoconfig\n"); 
			sql.append("    ON autoconfig.id_qa_itm = divde.id_qa_itm\n"); 
			sql.append("  LEFT JOIN bd_psndoc psn\n"); 
			sql.append("    ON psn.id_psndoc = ent.id_emp_phy\n"); 
			sql.append("  LEFT JOIN bd_dep dep\n"); 
			sql.append("    ON dep.id_dep = divde.Id_sbmt_dept\n"); 
			sql.append("  where ent.id_dep_phy ='"+Context.get().getDeptId()+"'"); 
 		String sqlStr=sql.toString();
		PagingRtnData<CiMrTaskDTO> pagingRtnData = super.findByPageInfo(new CiMrTaskDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}
	
	private void execBefore(QryRootNodeDTO qryRootNodeDTO) throws BizException{
		
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
 		String sqlwhere = "1=1";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
		//1.先查询当前科室的所有id_ent
		DAFacade daf = new DAFacade();  	
    	StringBuilder sql = new StringBuilder();
				sql.append("SELECT \n");
				sql.append("  en_ent.id_ent\n");
				sql.append("  FROM en_ent en_ent \n"); 
				sql.append("  where "+sqlwhere +" \n");
				sql.append("  and en_ent.id_dep_phy ='"+Context.get().getDeptId()+"'");
				String sqlStr=sql.toString();
		@SuppressWarnings("unchecked")
       	List<QaPatListDTO> listMr = (List<QaPatListDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaPatListDTO.class));
		
		if (listMr.size()<=0)
			return ;

		
		IQceventRService qceventService=ServiceFinder.find(IQceventRService.class);
		IAutoitmRService autoService =ServiceFinder.find(IAutoitmRService.class);
    	AutoItmDO[] autoItmDOArr= autoService.find(" Fg_performance='Y'", "", new FBoolean(false));
    	if(autoItmDOArr==null||autoItmDOArr.length<=0)
    		return ;
    	DAFacade delDaf=new DAFacade();
    	//String delSqlStr=" delete from ci_qa_divide where "+" Id_qa_ty='"+ICiMrDictCodeConst.ID_EXEC_AUTOMATIC+"' and Sd_qa_ty='0801' and Id_sbmt_dept='"+Context.get().getDeptId()+"' ";
    	delDaf.deleteByWhere(DivideDO.class, " sd_qa_ty='"+ICiMrDictCodeConst.SD_EXEC_AUTOMATIC+"' and Fg_checkself='Y' and Id_sbmt_dept='"+Context.get().getDeptId()+"' ");
    	
    	QaPatListDTO[] entArr=listMr.toArray(new QaPatListDTO[0]);
		for (int i = 0; i < entArr.length; i++) {
	    	for (int j = 0; j < autoItmDOArr.length; j++) {
	    		QcEventDO eventdo= qceventService.findById(autoItmDOArr[j].getEvent_type_code());
	    		//文书有无 
				if(eventdo.getMethod().equals(ICiMrDictCodeConst.ID_MR_AUTOQC_ISHAVEMR)){
					execMedicaQc(entArr[i].getId_ent(),eventdo, autoItmDOArr[j]);
				}
			}
		}
	}
	
	public  void execMedicaQc(String id_ent, QcEventDO eventDo ,AutoItmDO autoDo) throws BizException{
		String whereStr;
		ICiemrRService mrService =ServiceFinder.find(ICiemrRService.class);
		IDivideCudService qafltService=ServiceFinder.find(IDivideCudService.class);
		//IItmRService itmService=ServiceFinder.find(IItmRService.class);
		IPativisitRService enService=ServiceFinder.find(IPativisitRService.class);
		DAFacade daf = new DAFacade();

		String sql = "select "+eventDo.getSql_field()+" from "+eventDo.getSql_table()+" '"+id_ent+"'  ";
		
	   	@SuppressWarnings("unchecked")
	    List<AutoQcDTO> listMrs = (List<AutoQcDTO>) daf.execQuery(sql, new BeanListHandler(AutoQcDTO.class));
	    AutoQcDTO[] autoDtos=listMrs.toArray(new AutoQcDTO[listMrs.size()]);
	    if(autoDtos.length<=0) return;
	    ArrayList<DivideDO> fltlist = new ArrayList<DivideDO>();
	    //取出院时间
	    PatiVisitDO visitDO=enService.findById(id_ent);
	    //判断 是否写了24小时记录
	    if (visitDO.getDt_acpt()!=null&&visitDO.getDt_end()!=null) {
	    	long end=visitDO.getDt_end().getMillis();
	    	long begin=visitDO.getDt_acpt().getMillis();
	    	long hours=end-begin;
	    	double result=(double)hours/(double)60*60*1000;
	    	if (result<24) {
	    		CiMrDO[] mr24Arr=mrService.find(" createdtime between '"+visitDO.getDt_acpt()+"' and '"+visitDO.getDt_end()+"'", "", FBoolean.FALSE);
	    		if (is24HourMrtp(mr24Arr)) {
					return;
				}else {
					//这块可以插入扣分项目 关于24小时记录的
				}
			}
		}
	    
	    for (AutoQcDTO autoQcDTO : autoDtos) {
	    	if(autoQcDTO.getDt_acpt()==null) continue;
	    	int times=1;
	    	if (autoDo.getFg_loop().equals(FBoolean.TRUE)) {
	    		if (visitDO.getDt_end()==null) {
					int hours=xap.mw.coreitf.d.FDateTime.getHoursBetween(autoQcDTO.getDt_acpt(), new FDateTime());
					times =hours/autoDo.getHours_dead();
					if(times<=0) return;
				}else {
					int hours=xap.mw.coreitf.d.FDateTime.getHoursBetween(autoQcDTO.getDt_acpt(), visitDO.getDt_end());
					times =hours/autoDo.getHours_dead();
					if(times<=0) return;
				}
			}
			
	    	for (int i = 0; i < times; i++) {
	    		if(autoDo.getId_mr_types()!=null){
		    		whereStr=" a0.id_ent='"+id_ent+"' and a0.id_mrtp in( '"+autoDo.getId_mr_types().replaceAll(",", "','")+"')  ";
		    			//	+ " and to_date(a0.createdtime,'yyyy-mm-dd hh24:mi:ss') between  (to_date('"+autoQcDTO.getDt_acpt()+"','yyyy-mm-dd hh24:mi:ss')+numtodsinterval("+autoDo.getHours_dead()+"*"+i+",'hour') ) and ( to_date('"+autoQcDTO.getDt_acpt()+"','yyyy-mm-dd hh24:mi:ss')+numtodsinterval("+autoDo.getHours_dead()+"*"+(i+1)+",'hour') )";
		    		if (autoDo.getId_mrtp_change()!=null) {
		    			whereStr="  a0.id_ent='"+id_ent+"' and a0.id_mrtp in( '"+autoDo.getId_mr_types().replaceAll(",", "','")+"') or  a0.id_mrtp in ( '"+autoDo.getId_mrtp_change().replaceAll(",", "','")+"')";
					}
		    		CiMrDO[] mrArr=mrService.find(whereStr, "", FBoolean.FALSE);
		    		if(eventDo==null||autoQcDTO==null) return;
		    		if (mrArr.length<=0) {			
		    			DivideDO divideDo = new DivideDO();
		    			divideDo.setId_ent(id_ent);
						divideDo.setId_qa_itm(autoDo.getId_qa_itm());						
						divideDo.setDrp_des(autoDo.getReq());
						divideDo.setRfm_req("绩效考核项");
						divideDo.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_AUTOMATIC);
						divideDo.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_AUTOMATIC);
						divideDo.setFg_checkself(FBoolean.FALSE);
						divideDo.setId_sbmt_dept(visitDO.getId_dep_phy());
						divideDo.setDeduct_scr_times(autoDo.getHours_dead());//用来存放期限时间
						divideDo.setSbmt_time(autoQcDTO.getDt_acpt());//用来存放入科时间
						divideDo.setStatus(DOStatus.NEW);
						fltlist.add(divideDo);
		    		}
	    		}
			}
		}
	    DivideDO[] fltArray = fltlist.toArray(new DivideDO[fltlist.size()]);
	    qafltService.save(fltArray);
	}
	/**
	 * 判断是否存在24小时入院记录
	 * @return
	 * @throws BizException 
	 */
	private boolean  is24HourMrtp(CiMrDO[] doArr) throws BizException{
		
		if (doArr!=null&&doArr.length>0) {
			IEmrtypeRService mtrpService=ServiceFinder.find(IEmrtypeRService.class);
			for (int i = 0; i < doArr.length; i++) {
				MrTpDO mrtpDo=mtrpService.findById(doArr[i].getId_mrtp());
				if (IMrPubConst.DS_RCY24.equals(mrtpDo.getCd_std())||IMrPubConst.DS_RCY24SW.equals(mrtpDo.getCd_std())) {
					return true;
				}else{
					continue;
				}
			}
		}
		return false;
	}
}
