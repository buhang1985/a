/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.s.bp.task;

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
import iih.ci.mr.s.util.MrCommonUtils;
import iih.ci.mrqc.autoqcdto.d.AutoQcDTO;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.divide.i.IDivideCudService;
import iih.ci.mrqc.divide.i.IDivideRService;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 〈扼要描述〉
 * 定时执行自动质控任务 插入数据到扣分表
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MrByMedicalDepExecuteAutoQcItmTask implements IBackgroundWorkPlugin{

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BizException {
		//获取时间
		FDateTime beginTime =null;
		FDateTime endTime=null;
		
		String dt_begin=null;
		String dt_end=null;
		Map<String, Object> map = arg0.getKeyMap();
		if (map.containsKey("dt_begin")) {
			dt_begin=String.valueOf(map.get("dt_begin"));
		}
		if (map.containsKey("dt_end")) {
			dt_end=String.valueOf(map.get("dt_end"));
		}
		if (!MrCommonUtils.isEmpty(dt_begin)&&!MrCommonUtils.isEmpty(dt_end)) {
			beginTime=new FDateTime(dt_begin);
			endTime=new FDateTime(dt_end);
		}
		// TODO Auto-generated method stub
		DAFacade daf = new DAFacade();  	
    	StringBuilder sql = new StringBuilder();
				sql.append("SELECT \n");
				sql.append("  en_ent.id_ent\n");
				sql.append("  FROM en_ent en_ent \n"); 
				sql.append("  where en_ent.fg_ip='Y' \n");
				if(beginTime!=null&&endTime!=null)
				{
					sql.append("  and en_ent.dt_acpt between '"+beginTime+"' and '"+endTime+"'");
				}else
				{
					sql.append("  and en_ent.dt_end is null ");
				}
				String sqlStr=sql.toString();
		@SuppressWarnings("unchecked")
       	List<QaPatListDTO> listEnt = (List<QaPatListDTO>) daf.execQuery(sqlStr, new BeanListHandler(QaPatListDTO.class));
		
		if (listEnt.size()<=0)
			return null;
		
		IQceventRService qceventService=ServiceFinder.find(IQceventRService.class);
		IAutoitmRService autoService =ServiceFinder.find(IAutoitmRService.class);
    	AutoItmDO[] autoItmDOArr= autoService.find(" Fg_performance='Y'", "", new FBoolean(false));
    	if(autoItmDOArr==null||autoItmDOArr.length<=0)
    		return null;
		
    	QaPatListDTO[] entArr=listEnt.toArray(new QaPatListDTO[0]);
		for (int i = 0; i < entArr.length; i++) {
	    	for (int j = 0; j < autoItmDOArr.length; j++) {
	    		QcEventDO eventdo= qceventService.findById(autoItmDOArr[j].getEvent_type_code());
	    		//文书有无 
				if(eventdo.getMethod().equals(ICiMrDictCodeConst.ID_MR_AUTOQC_ISHAVEMR)){
					execMedicaQc(entArr[i].getId_ent(),eventdo, autoItmDOArr[j]);
				}
			}
		}
		return null;
	}
	public  void execMedicaQc(String id_ent, QcEventDO eventDo ,AutoItmDO autoDo) throws BizException{
		String whereStr;
		ICiemrRService mrService =ServiceFinder.find(ICiemrRService.class);
		IDivideCudService qafltService=ServiceFinder.find(IDivideCudService.class);
		IDivideRService divideService = ServiceFinder.find(IDivideRService.class);
		IPativisitRService enService=ServiceFinder.find(IPativisitRService.class);
		DAFacade daf = new DAFacade();

		String sql = "select "+eventDo.getSql_field()+" from "+eventDo.getSql_table()+" '"+id_ent+"'  ";
		
	   	@SuppressWarnings("unchecked")
	    List<AutoQcDTO> listMrs = (List<AutoQcDTO>) daf.execQuery(sql, new BeanListHandler(AutoQcDTO.class));
	    AutoQcDTO[] autoQcDtoArr=listMrs.toArray(new AutoQcDTO[listMrs.size()]);
	    if(autoQcDtoArr.length<=0) return;
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
	    
	    for (AutoQcDTO autoQcDTO : autoQcDtoArr) {
	    	if(autoQcDTO.getDt_acpt()==null) continue;
	    	//int times =autoDo.getTimes_for();
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
	    	
	    	DivideDO[] exist = divideService.find("id_ent = '"+id_ent+"' and id_qa_itm = '"+autoDo.getId_qa_itm()+"' and id_qa_itm_config = '"+autoDo.getId_qa_itm_config()+"'", "", FBoolean.FALSE);
			
	    	for (int i = 0; i < times; i++) {
	    		if(autoDo.getId_mr_types()!=null){
		    		whereStr=" a0.id_ent='"+id_ent+"' and a0.id_mrtp in( '"+autoDo.getId_mr_types().replaceAll(",", "','")+"') and "
		    				+ " to_date(a0.createdtime,'yyyy-mm-dd hh24:mi:ss') between  (to_date('"+autoQcDTO.getDt_acpt()+"','yyyy-mm-dd hh24:mi:ss')+numtodsinterval("+autoDo.getHours_dead()+"*"+i+",'hour') ) and ( to_date('"+autoQcDTO.getDt_acpt()+"','yyyy-mm-dd hh24:mi:ss')+numtodsinterval("+autoDo.getHours_dead()+"*"+(i+1)+",'hour') )";
		    		if (autoDo.getId_mrtp_change()!=null) {
		    			whereStr="  a0.id_ent='"+id_ent+"' and a0.id_mrtp in( '"+autoDo.getId_mr_types().replaceAll(",", "','")+"') or  a0.id_mrtp in ( '"+autoDo.getId_mrtp_change().replaceAll(",", "','")+"') "
		    			+ " and  to_date(a0.createdtime,'yyyy-mm-dd hh24:mi:ss') between  (to_date('"+autoQcDTO.getDt_acpt()+"','yyyy-mm-dd hh24:mi:ss')+numtodsinterval("+autoDo.getHours_dead()+"*"+i+",'hour') ) and ( to_date('"+autoQcDTO.getDt_acpt()+"','yyyy-mm-dd hh24:mi:ss')+numtodsinterval("+autoDo.getHours_dead()+"*"+(i+1)+",'hour') )";
		    		}
		    		
		    		if(autoQcDTO.getDt_acpt().addSeconds(autoDo.getHours_dead()*(i+1)*60*60).after(new FDateTime()))
		    		{
		    			continue;
		    		}
		    		if(exist != null && exist.length>0)
		    		{
		    			FBoolean b = FBoolean.FALSE;
		    			for(DivideDO exi : exist)
		    			{
		    				if(exi.getDrp_des().equals(autoDo.getReq() +"("+autoQcDTO.getDt_acpt()+" ~ "+autoQcDTO.getDt_acpt().addSeconds(autoDo.getHours_dead()*(i+1)*60*60)+")"))
		    				{
		    					b = FBoolean.TRUE;
		    					break;
		    				}
		    			}
		    			if(FBoolean.TRUE.equals(b))
		    			{
		    				continue;
		    			}
		    		}
		    		
		    		CiMrDO[] mrArr=mrService.find(whereStr, "", FBoolean.FALSE);
		    		if(eventDo==null||autoQcDTO==null) continue;
		    		if (mrArr.length<=0) {
		    			DivideDO divideDo = new DivideDO();
		    			divideDo.setId_ent(id_ent);
						divideDo.setId_qa_itm(autoDo.getId_qa_itm());
						divideDo.setId_qa_itm_config(autoDo.getId_qa_itm_config());
						divideDo.setDrp_des(autoDo.getReq() +"("+autoQcDTO.getDt_acpt()+" ~ "+autoQcDTO.getDt_acpt().addSeconds(autoDo.getHours_dead()*(i+1)*60*60)+")");//扣分说明
						divideDo.setRfm_req("绩效考核项");//整改要求
						divideDo.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_AUTOMATIC);
						divideDo.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_AUTOMATIC);
						divideDo.setFg_checkself(FBoolean.FALSE);//区分 是否科室自查  这里是医务的定时任务  不是自查 必须赋值
						divideDo.setId_sbmt_dept("PKUIH_MedicalDep");
						divideDo.setDeduct_scr_times(1);
						divideDo.setSbmt_time(new FDateTime());
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
