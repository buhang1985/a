package iih.ci.mrqc.autoqc.rulemethod.TerminalAutoQc;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.autoitm.d.AutoItmDO;
import iih.bd.srv.qcevent.d.QcEventDO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.autoqcdto.d.AutoQcDTO;
import iih.ci.mrqc.divide.d.DivideDO;
import iih.ci.mrqc.divide.i.IDivideCudService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class TerminalAutoQcForOneUtil {
	public  DivideDO[] exec(String id_ent, QcEventDO eventDo ,AutoItmDO autoDo) throws BizException{
		String whereStr;
		ICiemrRService mrService =ServiceFinder.find(ICiemrRService.class);
		IDivideCudService qafltService=ServiceFinder.find(IDivideCudService.class);
		//IItmRService itmService=ServiceFinder.find(IItmRService.class);
		IPativisitRService enService=ServiceFinder.find(IPativisitRService.class);
		DAFacade daf = new DAFacade();

		String sql = "select "+eventDo.getSql_field()+" from "+eventDo.getSql_table()+" '"+id_ent+"'  ";
		
	   	@SuppressWarnings("unchecked")
	    List<AutoQcDTO> listMrs = (List<AutoQcDTO>) daf.execQuery(sql, new BeanListHandler(AutoQcDTO.class));
	    AutoQcDTO[] ss=listMrs.toArray(new AutoQcDTO[listMrs.size()]);
	    if(ss.length<=0) return null;
	    ArrayList<DivideDO> fltlist = new ArrayList<DivideDO>();
	    //取出院时间
	    PatiVisitDO visitDO=enService.findById(id_ent);
	    
	    
	    for (AutoQcDTO autoQcDTO : ss) {
	    	if(autoQcDTO.getDt_acpt()==null) continue;
	    	//int times =autoDo.getTimes_for();
	    	int times=1;
	    	if (autoDo.getFg_loop().equals(FBoolean.TRUE)) {
	    		if (visitDO.getDt_end()==null) {
					int hours=xap.mw.coreitf.d.FDateTime.getHoursBetween(autoQcDTO.getDt_acpt(), new FDateTime());
					times =hours/autoDo.getHours_dead();
					if(times<=0) continue;
				}else {
					int hours=xap.mw.coreitf.d.FDateTime.getHoursBetween(autoQcDTO.getDt_acpt(), visitDO.getDt_end());
					times =hours/autoDo.getHours_dead();
					if(times<=0) continue;
				}
			}
	    	
	    	for (int i = 0; i < times; i++) {
	    		if(autoDo.getId_mr_types()!=null){
		    		whereStr=" a0.id_ent='"+id_ent+"' and a0.id_mrtp in( '"+autoDo.getId_mr_types().replaceAll(",", "','")+"') and "
		    				+ " to_date(a0.createdtime,'yyyy-mm-dd hh24:mi:ss') between  (to_date('"+autoQcDTO.getDt_acpt()+"','yyyy-mm-dd hh24:mi:ss')+numtodsinterval("+autoDo.getHours_dead()+"*"+i+",'hour') ) and ( to_date('"+autoQcDTO.getDt_acpt()+"','yyyy-mm-dd hh24:mi:ss')+numtodsinterval("+autoDo.getHours_dead()+"*"+(i+1)+",'hour') )";
		    		if (autoDo.getId_mrtp_change()!=null) {
		    			whereStr="  a0.id_ent='"+id_ent+"' and a0.id_mrtp in( '"+autoDo.getId_mr_types().replaceAll(",", "','")+"') or  a0.id_mrtp in ( '"+autoDo.getId_mrtp_change().replaceAll(",", "','")+"')"
		    				+ " and to_date(a0.createdtime,'yyyy-mm-dd hh24:mi:ss') between  (to_date('"+autoQcDTO.getDt_acpt()+"','yyyy-mm-dd hh24:mi:ss')+numtodsinterval("+autoDo.getHours_dead()+"*"+i+",'hour') ) and ( to_date('"+autoQcDTO.getDt_acpt()+"','yyyy-mm-dd hh24:mi:ss')+numtodsinterval("+autoDo.getHours_dead()+"*"+(i+1)+",'hour') )";
		    		}
		    		CiMrDO[] mrArr=mrService.find(whereStr, "", FBoolean.FALSE);
		    		//ItmDO itmDO=itmService.findById(autoDo.getId_qa_itm());
		    		if(eventDo==null||autoQcDTO==null) continue;
		    		if (mrArr.length<=0) {
						
						DivideDO qaFltDO = new DivideDO();
						qaFltDO.setId_ent(id_ent);
						qaFltDO.setId_qa_itm(autoDo.getId_qa_itm());
						qaFltDO.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_AUTOMATIC);
						qaFltDO.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_AUTOMATIC);
						qaFltDO.setId_sbmt_user(Context.get().getUserId());
						qaFltDO.setId_sbmt_dept(Context.get().getDeptId());
						qaFltDO.setId_qa_itm(autoDo.getId_qa_itm());
//						qaFltDO.setDrp_des(autoDo.getReq()+"("+eventDo.getName()+" ： 时间："+autoQcDTO.getDt_acpt()+")");
//						qaFltDO.setRfm_req(autoDo.getReq()+"("+eventDo.getName()+" ： 时间："+autoQcDTO.getDt_acpt()+")");
						qaFltDO.setDeduct_scr_times(1);
						qaFltDO.setSbmt_time(new FDateTime());
						qaFltDO.setStatus(DOStatus.NEW);
						fltlist.add(qaFltDO);
						
		    		}
	    		}
			}
		}
	    DivideDO[] fltArray = fltlist.toArray(new DivideDO[0]);
	    return qafltService.save(fltArray);
	}
}
