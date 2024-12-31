package iih.en.pv.s.listener.ip;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.s.listener.bp.SetAllergyStateBP;
import iih.pi.overview.overview.d.OverviewAggDO;
import iih.pi.overview.overview.d.PiPatDO;

import java.util.HashSet;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 患者过敏信息改变监听（AggDO）
 * 
 * @author liubin
 *
 */
public class EnPatAggAlSetSateListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent e) throws BizException {
		BDCommonEvent event = (BDCommonEvent) e;
		if(!OverviewAggDO.class.getName().equals(event.getSourceID()))
			return;
		String[] patIds = getPatIds(event);
		SetAllergyStateBP bp = new SetAllergyStateBP();
		bp.exec(patIds);
	}
	/**
	 * 获取患者信息
	 * 
	 * @param event
	 * @return
	 */
	private String[] getPatIds(BDCommonEvent event){
		Set<String> set = new HashSet<>();
		Object[] objs = event.getOldObjs();
		this.setPatIds(set, objs);
		objs = event.getNewObjs();
		this.setPatIds(set, objs);
		return set.isEmpty() ? null : set.toArray(new String[0]);
	}
	/**
	 * 设置患者Id
	 * 
	 * @param set
	 * @param objs
	 */
	private void setPatIds(Set<String> set, Object[] objs){
		if(!EnValidator.isEmpty(objs)){
			for(Object obj : objs){
				OverviewAggDO agg = (OverviewAggDO)obj;
				if(agg == null)
					continue;
				PiPatDO pat = agg.getParentDO();
				if(pat == null)
					continue;
				if(!EnValidator.isEmpty(pat.getId_pat()))
					set.add(pat.getId_pat());
			}
		}
	}
}
