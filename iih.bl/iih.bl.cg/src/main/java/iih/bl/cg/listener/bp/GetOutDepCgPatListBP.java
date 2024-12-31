package iih.bl.cg.listener.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.FBooleanUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据医嘱查询待计费的患者集合
 * @author yankan
 * @since 2017-10-23
 *
 */
public class GetOutDepCgPatListBP {
	/**
	 * 获取持有护理和持续医嘱的患者ID集合
	 * @param ors
	 * @return
	 */
	public List<String> exec(CiOrderDO[] ors) throws BizException{
		if(ArrayUtil.isEmpty(ors)){
			return null;
		}
		List<String> patIdList = new ArrayList<String>();
		List<String> momEntIdList = new ArrayList<String>();
		for(CiOrderDO ciOrd : ors){
			if(!patIdList.contains(ciOrd.getId_pat())){
				patIdList.add(ciOrd.getId_pat());
				if(FBooleanUtils.isNullOrFalse(ciOrd.getFg_bb())){
					momEntIdList.add(ciOrd.getId_en());
				}
			}
		}
		List<String> nbIdList = this.getNbIdList(momEntIdList);
		patIdList.addAll(nbIdList);
		
		return patIdList;
	}
	/**
	 * 获取婴儿的ID集合
	 * @param entIdList
	 * @return
	 */
	private List<String> getNbIdList(List<String> entIdList){
		List<String> nbIdList = new ArrayList<String>();
		if(ListUtil.isEmpty(entIdList)){
			return nbIdList;
		}
		IEnOutQryService enQryService = ServiceFinder.find(IEnOutQryService.class);
		for(String entId : entIdList){
			NewbornDO[] nbDOs =null;
			try {
				nbDOs = enQryService.getNewbornsByMomEntId(entId);
			} catch (BizException e) {
				e.printStackTrace();
			}
			if(ArrayUtil.isEmpty(nbDOs)) 
				continue;
			for(NewbornDO nbDO : nbDOs){
				if(!nbIdList.contains(nbDO.getId_pat_bb())){
					nbIdList.add(nbDO.getId_pat_bb());
				}
			}
		}
		return nbIdList;
	}
}
