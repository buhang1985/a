package iih.bd.srv.listener;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.srv.diagcate.d.DiCateItemDO;
import iih.bd.srv.diagcate.d.DiagcateAggDO;
import iih.bd.srv.diagcate.i.IDiCateItemDORService;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDOCudService;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

public class DiagWBInfoListener implements IBusinessListener {

	private static final String DIAGCATEAGGDO_FULLCLASSNAME = "iih.bd.srv.diagcate.d.DiagcateAggDO";

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 事件源及事件类型判断
		if (!(event.getSourceID().equals(DIAGCATEAGGDO_FULLCLASSNAME)))
			return;
		// 获得诊断分类agg
		BDCommonEvent dbevent = (BDCommonEvent) event;
		Object[] newObjs = dbevent.getNewObjs();
		if (ArrayUtils.isEmpty(newObjs) || newObjs.length == 0)
			return;
		// 获得主键集合
		if (newObjs.length == 0)
			return;
		DiagcateAggDO agg = (DiagcateAggDO) newObjs[0];
		if (event.getEventType().equals(IEventType.TYPE_UPDATE_BEFORE)) {
			Object[] oldObjs = dbevent.getOldObjs();
			if (ArrayUtils.isEmpty(oldObjs) || oldObjs.length == 0)
				return;
			updateCate(agg, (DiagcateAggDO) oldObjs[0]);
			return;
		}
		String[] id_diags = getIds(agg);
		if (ArrayUtils.isEmpty(id_diags) || id_diags.length == 0)
			return;
		// 获得诊断定义
		DiagDefDO[] diagdefs = getDiagDefs(id_diags);
		if (ArrayUtils.isEmpty(diagdefs) || diagdefs.length == 0)
			return;
		// 回写上报标识
		if (event.getEventType().equals(IEventType.TYPE_INSERT_AFTER) && agg.getParentDO().getFg_ur() == FBoolean.TRUE)
			addCate(diagdefs, agg);
		if (event.getEventType().equals(IEventType.TYPE_DELETE_BEFORE))
			delCate(diagdefs);

	}

	private String[] getIds(DiagcateAggDO agg) {
		List<String> ids = new ArrayList<String>();
		if (agg == null || agg.getDiCateItemDO() == null || agg.getDiCateItemDO().length == 0)
			return null;
		for (DiCateItemDO itemDO : agg.getDiCateItemDO()) {
			ids.add(itemDO.getId_didef());
		}
		return ids.toArray(new String[ids.size()]);
	}

	private DiagDefDO[] getDiagDefs(String[] ids) throws BizException {
		IDiagdefMDORService service = ServiceFinder.find(IDiagdefMDORService.class);
		return service.findByBIds(ids, FBoolean.FALSE);
	}

	private void addCate(DiagDefDO[] diagdefs, DiagcateAggDO agg) throws BizException {
		for (DiagDefDO def : diagdefs) {
			def.setStatus(DOStatus.UPDATED);
			def.setFg_ur(FBoolean.TRUE);
			def.setId_infectiontp(agg.getParentDO().getId_infectiontp());
			def.setSd_infectiontp(agg.getParentDO().getSd_infectiontp());
		}
		IDiagdefMDOCudService service = ServiceFinder.find(IDiagdefMDOCudService.class);
		service.update(diagdefs);
	}

	private void delCate(DiagDefDO[] diagdefs) throws BizException {
		IDiCateItemDORService cateitemservice = ServiceFinder.find(IDiCateItemDORService.class);
		// IDiagcateMDORService
		// cateMservice=ServiceFinder.find(IDiagcateMDORService.class);
		// String ids="";
		// if(diagdefs==null || diagdefs.length==0)return;
		// for(DiagDefDO def:diagdefs){
		// ids+="'"+def.getId_didef()+"',";
		// }
		// DiCateItemDO[] items=cateitemservice.find(" bd_dica_itm_rel.id_didef
		// in ("+ids.substring(0,ids.length()-1)+")", null,FBoolean.FALSE);
		// Map<String,String> itemMap=new HashMap<String,String>();
		// for(DiCateItemDO item:items){
		// if(!itemMap.containsKey(item.getId_dica()))
		// itemMap.put(item.getId_dica(), item.getId_didef());
		// }
		for (DiagDefDO def : diagdefs) {
			// List<String> iddefs=new ArrayList<String>();
			// for(String key:itemMap.keySet()){
			// if(itemMap.get(key).equals(def.getId_didef()))
			// iddefs.add(key);
			// }
			// if(itemMap.size()==1){
			def.setStatus(DOStatus.UPDATED);
			def.setFg_ur(FBoolean.FALSE);
			def.setId_infectiontp(null);
			def.setSd_infectiontp(null);
			// }
			// else{
			// String idcas="";
			//
			// DiagCateDO mdo=cateMservice.findById(id)
			// }

		}
		IDiagdefMDOCudService service = ServiceFinder.find(IDiagdefMDOCudService.class);
		service.update(diagdefs);
	}

	private void updateCate(DiagcateAggDO agg, DiagcateAggDO oldagg) throws BizException {
		DiCateItemDO[] items = agg.getDiCateItemDO();
		List<String> addids = new ArrayList<String>();
		List<String> delids = new ArrayList<String>();
		if (items == null || items.length <= 0) {
			return;
		}
		for (DiCateItemDO item : items) {
			if (item.getStatus() == DOStatus.NEW)
				addids.add(item.getId_didef());
			if (item.getStatus() == DOStatus.DELETED)
				delids.add(item.getId_didef());
			if (item.getStatus() == DOStatus.UPDATED) {
				addids.add(item.getId_didef());
				if (oldagg.getDiCateItemDO().length == 0)
					return;
				for (DiCateItemDO old : oldagg.getDiCateItemDO()) {
					if (old.getId_dicaitmrel().equals(item.getId_dicaitmrel())) {
						delids.add(old.getId_didef());
					}
				}
			}
		}

		IDiagdefMDOCudService service = ServiceFinder.find(IDiagdefMDOCudService.class);

		if (addids.size() != 0) {
			DiagDefDO[] addlist = getDiagDefs(addids.toArray(new String[addids.size()]));
			for (DiagDefDO def : addlist) {
				def.setStatus(DOStatus.UPDATED);
				def.setFg_ur(FBoolean.TRUE);
				def.setId_infectiontp(agg.getParentDO().getId_infectiontp());
				def.setSd_infectiontp(agg.getParentDO().getSd_infectiontp());
			}
			service.update(addlist);
		}
		if (delids.size() != 0) {
			DiagDefDO[] dellist = getDiagDefs(delids.toArray(new String[delids.size()]));
			if (dellist != null) {
				for (DiagDefDO def : dellist) {
					def.setStatus(DOStatus.UPDATED);
					def.setFg_ur(FBoolean.FALSE);
					def.setId_infectiontp(null);
					def.setSd_infectiontp(null);
				}
				service.update(dellist);
			}
		}

	}

}
