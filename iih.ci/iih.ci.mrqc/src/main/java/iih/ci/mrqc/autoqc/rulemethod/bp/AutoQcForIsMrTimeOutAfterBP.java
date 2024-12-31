package iih.ci.mrqc.autoqc.rulemethod.bp;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.autoitm.d.AutoItmDO;
import iih.bd.srv.itm.d.ItmDO;
import iih.bd.srv.itm.i.IItmRService;
import iih.bd.srv.qcevent.d.QcEventDO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mrqc.autoqcdto.d.AutoQcDTO;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.i.IQafltCudService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.ICalendar;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

/**
 * 自动质控方法处理 
 * 判断文书存在是否超时（向后） 
 * 如入院记录是不是超时完成 前提有入院记录 但是超时了 
 * 02文书存在是否超时（向后）
 * 
 * @author zhq
 *
 */
public class AutoQcForIsMrTimeOutAfterBP {
	public void exec(String id_ent, QcEventDO eventDo, AutoItmDO autoDo, Boolean isDocAutoQcSelf) throws BizException {

		ICiemrRService mrService = ServiceFinder.find(ICiemrRService.class);
		IQafltCudService qafltService = ServiceFinder.find(IQafltCudService.class);
		IPativisitRService enService = ServiceFinder.find(IPativisitRService.class);
		IItmRService itmService=ServiceFinder.find(IItmRService.class);
		List<AutoQcDTO> autoQcDtoLists = new ArrayList<AutoQcDTO>();
		if(eventDo != null && eventDo.getSql_field() != null && eventDo.getSql_table() != null){
			DAFacade daf = new DAFacade();
			String sql = "select " + eventDo.getSql_field() + " from " + eventDo.getSql_table() + " '" + id_ent + "'  ";
			autoQcDtoLists = (List<AutoQcDTO>) daf.execQuery(sql, new BeanListHandler(AutoQcDTO.class));
		}
		if (autoQcDtoLists == null || autoQcDtoLists.size() <= 0)
			return;;
		ArrayList<QaFltDO> fltlist = new ArrayList<QaFltDO>();
		// 取出院时间
		PatiVisitDO visitDO = enService.findById(id_ent);
		for (AutoQcDTO autoQcDTO : autoQcDtoLists) {
			if (autoQcDTO.getDt_acpt() == null)
				continue;
			int times = 1;
			if (FBoolean.TRUE.equals(autoDo.getFg_loop()) && visitDO != null) {
				if (visitDO.getDt_end() == null) {
					times = xap.mw.coreitf.d.FDateTime.getHoursBetween(autoQcDTO.getDt_acpt(), new FDateTime())
							/ autoDo.getHours_dead();
					if (times <= 0)
						continue;
				} else {
					times = xap.mw.coreitf.d.FDateTime.getHoursBetween(autoQcDTO.getDt_acpt(), visitDO.getDt_end())
							/ autoDo.getHours_dead();
					if (times <= 0)
						continue;
				}
			}
			for (int i = 0; i < times; i++) {
				StringBuilder whereStr = new StringBuilder();
				if (autoDo.getId_mr_types() != null) {
					whereStr.append("   a0.id_ent='" + id_ent + "' and a0.id_mrtp in( '"
							+ autoDo.getId_mr_types().replaceAll(",", "','") + "')");
				}
				if (autoDo.getId_mrtp_change() != null) {
					whereStr.append(
							"   or a0.id_mrtp in( '" + autoDo.getId_mrtp_change().replaceAll(",", "','") + "')");
				}
				StringBuilder istimerStr = new StringBuilder();
				istimerStr.append("   a0.id_ent='" + id_ent + "' and a0.id_mrtp in( '"
						+ autoDo.getId_mr_types().replaceAll(",", "','") + "') and a0.date_submit is not null ");
				if (autoDo.getId_mrtp_change() != null) {
					istimerStr.append("   a0.id_ent='" + id_ent + "' and ( a0.id_mrtp in( '"
							+ autoDo.getId_mr_types().replaceAll(",", "','") + "')");
					istimerStr.append("   or  a0.id_mrtp in ( '" + autoDo.getId_mrtp_change().replaceAll(",", "','")
							+ "') ) and a0.date_submit is not null");
				}
				CiMrDO[] mrArr = mrService.find(whereStr.toString(), "", FBoolean.FALSE);
				ItmDO itmDO=itmService.findById(autoDo.getId_qa_itm());
				if (mrArr.length <= 0)
					continue;
				if (mrArr == null || eventDo == null || autoQcDTO == null)
					continue;
				Boolean flag = true;
				for (int j = 0; j < mrArr.length; j++) {
					if (mrArr[j].getDate_submit()
							.after(new FDateTime(autoQcDTO.getDt_acpt().getMillis() + ICalendar.MILLIS_PER_HOUR * (i) * autoDo.getHours_dead())) && mrArr[j].getDate_submit().before(new FDateTime(autoQcDTO.getDt_acpt().getMillis() + ICalendar.MILLIS_PER_HOUR * (i+1) * autoDo.getHours_dead()))){
						flag = false;
					}
				}
				if(flag){
					CiMrDO[] timermrArr = mrService.find(istimerStr.toString(), "", FBoolean.FALSE);
					QaFltDO qaFltDO = new QaFltDO();
					qaFltDO.setId_flt_sta(ICiMrDictCodeConst.ID_REFORM);
					qaFltDO.setSd_flt_sta(ICiMrDictCodeConst.SD_REFORM);
					qaFltDO.setId_ent(id_ent);
					qaFltDO.setId_sbmt_user(Context.get().getUserId());
					qaFltDO.setId_sbmt_dept(Context.get().getDeptId());
					qaFltDO.setId_qa_itm(autoDo.getId_qa_itm());
					qaFltDO.setDrp_des(
							autoDo.getReq() + "(" + eventDo.getName() + " ： 时间：" + autoQcDTO.getDt_acpt() + ")");
					qaFltDO.setRfm_req(autoDo.getReq());
					qaFltDO.setId_qa_ty(ICiMrDictCodeConst.ID_EXEC_AUTOMATIC);
					qaFltDO.setSd_qa_ty(ICiMrDictCodeConst.SD_EXEC_AUTOMATIC);
					qaFltDO.setReal_score(itmDO.getOnce_drp_scr());
					if (timermrArr != null && timermrArr.length > 0) {
						qaFltDO.setId_rfm_user(timermrArr[0].getCreatedby());
						qaFltDO.setId_rfm_dept(timermrArr[0].getId_dep());
						qaFltDO.setId_mr(timermrArr[0].getId_mr());
					} else {
						if (visitDO != null && visitDO.getId_emp_phy() != null) {
							qaFltDO.setId_rfm_user(getIdUser(visitDO.getId_emp_phy()));
							qaFltDO.setId_rfm_dept(visitDO.getId_dep_phy());
						}
						qaFltDO.setId_mr(autoDo.getMr_types_name() + "【缺失】");
					}
					qaFltDO.setDeduct_scr_times(1);
					qaFltDO.setDt_sbmt(new FDateTime());
					if(isDocAutoQcSelf){
						qaFltDO.setId_revision("DOCTORAUTOQCSELF");
					}
					qaFltDO.setStatus(DOStatus.NEW);
					fltlist.add(qaFltDO);
				}
			}
		}
		QaFltDO[] fltArray = fltlist.toArray(new QaFltDO[0]);
		qafltService.save(fltArray);
	}

	// 根据id_psn 获取 患者id_user
	private String getIdUser(String id_psn) throws BizException {
		IUserRService userService = ServiceFinder.find(IUserRService.class);
		UserDO[] userArr = userService.find("a0.id_psn='" + id_psn + "'", "", FBoolean.FALSE);
		if (userArr.length > 0) {
			return userArr[0].getId_user();
		} else {
			return "~";
		}

	}

}