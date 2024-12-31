package iih.sc.scbd.log.rule;

import iih.bd.bc.event.pub.IScEventConst;
import iih.sc.scbd.dto.d.ScLogEventDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.orm.model.agg.BaseAggDO;

/**
 * AggDO的日志记录规则
 * @author liubin
 *
 * @param <T>
 */
public class ScAggLogRule<T extends BaseAggDO> implements IRule<T> {
	private String operTp;
	private T[] origins;

	/**
	 * 构造函数
	 * 
	 * @param operateTp 操作类型
	 */
	public ScAggLogRule(String operateTp) {
		this.operTp = operateTp;
	}

	/**
	 * 构造函数
	 * 
	 * @param operateTp 操作类型
	 * @param originDOs 原始对象集合
	 */
	public ScAggLogRule(String operateTp, T[] originDOs) {
		this.operTp = operateTp;
		if (!ArrayUtil.isEmpty(originDOs))
			this.origins = originDOs;
	}

	/**
	 * 执行
	 */
	@Override
	public void process(T... dos) throws BizException {
		if (ArrayUtil.isEmpty(dos))
			return;
		if (dos[0] instanceof BaseAggDO) {
			this.processAggDO((BaseAggDO[]) dos);
		}
	}

	/**
	 * 
	 * 
	 * @param aggs
	 * @throws BizException
	 */
	private void processAggDO(BaseAggDO... aggs) throws BizException {
		if (ArrayUtil.isEmpty(aggs) || StringUtil.isEmpty(operTp))
			return;
		this.fireLogEvent(aggs, origins, operTp);
	}
	/**
	 * 发送事件
	 * 
	 * @param newDOs
	 * @param origDOs
	 * @param operTp
	 * @throws BizException
	 */
	private void fireLogEvent(BaseAggDO[] newAggs, BaseAggDO[] origAggs, String operTp) throws BizException{
		ScLogEventDTO eventDTO = new ScLogEventDTO();
		eventDTO.setEuopertp(operTp);
		eventDTO.setNewobjs(doArray2List(newAggs));
		eventDTO.setOldobjs(doArray2List(origAggs));
		eventDTO.setId_psn(Context.get().getStuffId());
		BusinessEvent event = new BusinessEvent(IScEventConst.EVENT_SOURCE_SC_LOG, IScEventConst.EVENT_SC_LOG_AGGDO,
				eventDTO);
		EventDispatcher.fireEvent(event);
	}
	/**
	 * DO集合转FArrayList
	 * 
	 * @param dos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static FArrayList doArray2List(BaseAggDO... aggs) {
		if (aggs == null)
			return null;
		FArrayList list = new FArrayList();
		for (BaseAggDO d : aggs)
			list.add(d);
		return list;
	}
}
