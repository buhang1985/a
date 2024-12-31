package iih.ci.mr.s.bp.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimr.i.ICiemrRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

public class MrUpdateStateSentMsgTask implements IBackgroundWorkPlugin{

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		// TODO Auto-generated method stub
		String id_org="";
		String dt_begin="";
		String dt_end="";
		String code_entp="";
		Map<String, Object> map = arg0.getKeyMap();
		if (map.containsKey("code_entp")) {
			code_entp=String.valueOf(map.get("code_entp"));
		}
		if (map.containsKey("dt_begin")) {
			dt_begin=String.valueOf(map.get("dt_begin"));
		}
		if (map.containsKey("dt_end")) {
			dt_end=String.valueOf(map.get("dt_end"));
		}
		if (map.containsKey("id_org")) {
			id_org=String.valueOf(map.get("id_org"));
		}
		ICiemrRService qryService =ServiceFinder.find(ICiemrRService.class);
		ICiemrCudService updateService =ServiceFinder.find(ICiemrCudService.class);
		FDateTime begintime = null;
		FDateTime endtime = null;
		if (!"".equals(dt_begin)&&!"".equals(dt_end)&&dt_begin!=null&&dt_end!=null&&!"null".equals(begintime)&&!"null".equals(endtime)) {
			begintime = new FDateTime(dt_begin);
			endtime = new FDateTime(dt_end);
		} else {
			begintime = new FDateTime().getDateTimeBefore(30);
			endtime = new FDateTime();
		}
		
		String qryWhere=" a0.createdtime between '"+begintime+"' and '"+endtime+"'  and a0.sd_su_mr in ('"+ICiMrDictCodeConst.SD_SU_MR_NEW+"','"+ICiMrDictCodeConst.SD_SU_MR_RETRIEVE+"','"+ICiMrDictCodeConst.SD_SU_MR_REJECT+"')";
		if (!"".equals(id_org)&&id_org!=null) {
			qryWhere+=" and a0.id_org='"+id_org+"'";
		}
		if (!"".equals(code_entp)&&code_entp!=null&&!"null".equals(code_entp)) {
			qryWhere+=" and a0.code_entp='"+code_entp+"'";
		}
		PaginationInfo pageInfo =new PaginationInfo();
		pageInfo.setPageSize(100);
		PagingRtnData<CiMrDO> findByPageInfo = qryService.findByPageInfo(pageInfo, qryWhere, "createdtime");

		pageInfo =findByPageInfo.getPagingInfo();
		int pageCount=pageInfo.getPageCount();//每页条数
		int pageSize=pageInfo.getPageSize();//分页总数
		
		for (int i = 0; i < pageCount; i++) {
			PaginationInfo pageInfoIndex =new PaginationInfo();
			pageInfoIndex.setPageSize(pageSize);
			pageInfoIndex.setPageIndex(i);
			PagingRtnData<CiMrDO> pageArr=qryService.findByPageInfo(pageInfoIndex, qryWhere, "createdtime");
			@SuppressWarnings("unchecked")
			CiMrDO[] doArrNew=(CiMrDO[])pageArr.getPageData().toArray(new CiMrDO[0]);
			if (doArrNew.length>0) {
				for (int k = 0; k < doArrNew.length; k++) {
					doArrNew[k].setSd_su_mr(ICiMrDictCodeConst.SD_SU_MR_SUBMIT);
					doArrNew[k].setId_su_mr(ICiMrDictCodeConst.ID_SU_MR_SUBMIT);
					doArrNew[k].setDate_submit(doArrNew[k].getModifiedtime());
					doArrNew[k].setId_emp_submit(doArrNew[k].getModifiedby());
					doArrNew[k].setStatus(DOStatus.UPDATED);
				}
			}
			CiMrDO[] resultDoArr = updateService.update(doArrNew);
			
			List<Object> paramList = new ArrayList<Object>();
			paramList.add(resultDoArr);
			paramList.add("01");
			BDCommonEvent event = new BDCommonEvent(
					IMrEventConst.EVENT_SOURCE_MR_UPLOAD, IEventType.TYPE_UPDATE_AFTER, paramList.toArray());
			EventDispatcher.fireEvent(event);
			

//			for (int j = 0; j < resultDoArr.length; j++) {
//				List<Object> paramList = new ArrayList<Object>();
//				paramList.add(resultDoArr[i]);
//				paramList.add("01");
//				
//				BDCommonEvent event = new BDCommonEvent(
//						IMrEventConst.EVENT_SOURCE_MR_UPLOAD, IEventType.TYPE_UPDATE_AFTER, paramList.toArray());
//				EventDispatcher.fireEvent(event);
//			}
			
		}
		return null;
	}

}
