package iih.sc.scbd.log.s.bp;

import iih.sc.scbd.log.d.EuOperTp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.i.IAgg;
import xap.mw.coreitf.i.IBaseDO;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.sys.appfw.orm.model.utils.AggUtil;
import xap.sys.appfw.orm.utils.DOUtil;

/**
 * 创建AggDO日志BP
 * 
 * @author liubin
 *
 */
public class CreateAggLogBP {
	CreateLogBP createBp;
	
	public CreateAggLogBP(){
		this.createBp = new CreateLogBP();
	}
	
	/**
	 * 创建日志
	 * 
	 * @param entityDOs
	 * @param originDOs
	 * @param operTp
	 * @throws BizException
	 */
	public <T extends BaseAggDO> void exec(T[] newAggs, T[] oldAggs, String operTp, String empId) throws BizException {
		if((newAggs == null && oldAggs == null) || StringUtil.isEmpty(operTp))
			return;
		switch (operTp) {
		case EuOperTp.INSERT:
			this.processNewAgg(empId, newAggs);
			break;
		case EuOperTp.UPDATE:
			this.processUpdateAgg(empId, newAggs, oldAggs);
			break;
		case EuOperTp.DELETE:
			this.processDeleteAgg(empId, newAggs);
			break;
		}
	}
	/**
	 * 处理新增的Agg
	 * 
	 * @param dos
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void processNewAgg(String empId, BaseAggDO... aggs) throws BizException {
		AggUtil helper = new AggUtil((IAgg[]) aggs);
		List<IBaseDO> parentList = helper.getParentList();
		// 处理主DO
		this.createBp.exec((BaseDO[]) (parentList.toArray(new BaseDO[0])), null, EuOperTp.INSERT, empId);

		// 处理子DO
		Map<IDODesc, List<IBaseDO>> itemIndexMap = helper.getItemIndex().toMap();
		for (Object childList : itemIndexMap.values()) {
			this.createBp.exec((BaseDO[]) ((List) childList).toArray(new BaseDO[0]), null, EuOperTp.INSERT, empId);
		}
	}

	/**
	 * 处理删除的agg
	 * 
	 * @param aggs
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void processDeleteAgg(String empId, BaseAggDO... aggs) throws BizException {
		AggUtil helper = new AggUtil((IAgg[]) aggs);
		List<IBaseDO> parentList = helper.getParentList();

		// 处理主DO
		this.createBp.exec(null, (BaseDO[]) (parentList.toArray(new BaseDO[0])), EuOperTp.DELETE, empId);

		// 处理子DO
		Map<IDODesc, List<IBaseDO>> childMap = helper.getItemIndex().toMap();
		for (Object childList : childMap.values()) {
			this.createBp.exec(null, (BaseDO[]) ((List) childList).toArray(new BaseDO[0]),EuOperTp.DELETE, empId);
		}
	}

	/**
	 * 处理更新的agg
	 * 
	 * @param aggs
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void processUpdateAgg(String empId, BaseAggDO[] newAggs, BaseAggDO[] oldAggs) throws BizException {
		AggUtil helper = new AggUtil((IAgg[]) newAggs);
		List<IBaseDO> parentList = helper.getParentList();

		AggUtil origHelper = new AggUtil((IAgg[]) oldAggs);
		List<IBaseDO> origParentList = origHelper.getParentList();

		this.createBp.exec((BaseDO[]) (parentList.toArray(new BaseDO[0])),
				(BaseDO[]) (origParentList.toArray(new BaseDO[0])), EuOperTp.UPDATE, empId);

		Map<IDODesc, List<IBaseDO>> itemIndexMap = helper.getItemIndex().toMap();
		for (Object childList : itemIndexMap.values()) {
			BaseDO[] newDOs = (BaseDO[]) ((List) childList).toArray(new BaseDO[0]);
			Map<IDODesc, List<IBaseDO>> oldItemIndexMap = origHelper.getItemIndex().toMap();
			List children = (List) oldItemIndexMap.get(newDOs[0].getDODesc());
			BaseDO[] oldDOs = (BaseDO[]) (ListUtil.isEmpty(children)? null : children.toArray(new BaseDO[0]));
			this.processChildren(empId, newDOs, oldDOs);
		}
	}
	/**
	 * 处理子DO
	 * 
	 * @param dos
	 */
	@SuppressWarnings("unchecked")
	private <T extends BaseDO> void processChildren(String empId, T[] newDOs, T[] oldDOs) throws BizException {
		Map<String, BaseDO> oldDOMap = DOUtil.createVOMap(oldDOs);
		if(oldDOMap == null || oldDOMap.size() <= 0){
			this.createBp.exec(newDOs, null, EuOperTp.INSERT, empId);
			return;
		}
		
		List<BaseDO> insertDOList = new ArrayList<>();//新增DO
		List<BaseDO> deleteDOList = new ArrayList<>();//删除DO
		List<BaseDO> updateAfterDOList = new ArrayList<>();//修改后DO
		List<BaseDO> updateBeforeDOList = new ArrayList<>();//修改前DO
		for(BaseDO newDO : newDOs){
			if(StringUtil.isEmpty(newDO.getPkVal())){
				insertDOList.add(newDO);
				continue;
			}
			if(oldDOMap.keySet().contains(newDO.getPkVal())){
				updateAfterDOList.add(newDO);
				updateBeforeDOList.add(oldDOMap.remove(newDO.getPkVal()));
			}else{
				insertDOList.add(newDO);
			}
		}
		deleteDOList.addAll(oldDOMap.values());
		// 处理删除DO
		if(!ListUtil.isEmpty(deleteDOList)){
			this.createBp.exec(null, deleteDOList.toArray(new BaseDO[0]), EuOperTp.DELETE, empId);
		}
		// 处理新增DO
		if(!ListUtil.isEmpty(insertDOList)){
			this.createBp.exec(insertDOList.toArray(new BaseDO[0]), null, EuOperTp.INSERT, empId);
		}
		// 处理更新DO
		if(!ListUtil.isEmpty(updateAfterDOList)){
			this.createBp.exec(updateAfterDOList.toArray(new BaseDO[0]), updateBeforeDOList.toArray(new BaseDO[0]), EuOperTp.UPDATE, empId);
		}
	}
}
