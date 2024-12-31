package iih.sc.scbd.log.rule;

import iih.bd.bc.event.pub.IScEventConst;
import iih.sc.scbd.dto.d.ScLogEventDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 日志规则
 * 
 * @author liubin
 *
 * @param <BaseDO>
 */
public class ScLogRule<T extends BaseDO> implements IRule<T> {
	private String operTp;
	private T[] origins;

	/**
	 * 构造函数
	 * 
	 * @param operateTp 操作类型
	 */
	public ScLogRule(String operateTp) {
		this.operTp = operateTp;
	}

	/**
	 * 构造函数
	 * 
	 * @param operateTp 操作类型
	 * @param originDOs 原始对象集合
	 */
	public ScLogRule(String operateTp, T[] originDOs) {
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
		if (dos[0] instanceof BaseDO) {
			this.processDO((BaseDO[])dos);
		}
	}
	/**  
	 * 处理DO
	 * @param dos
	 * @throws BizException
	 */
	private void processDO(BaseDO...dos) throws BizException{
		if (ArrayUtil.isEmpty(dos) || StringUtil.isEmpty(operTp))
			return;
		this.fireLogEvent((BaseDO[])dos, (BaseDO[])this.origins, operTp);
	}
	/**
	 * 发送事件
	 * 
	 * @param newDOs
	 * @param origDOs
	 * @param operTp
	 * @throws BizException
	 */
	private void fireLogEvent(BaseDO[] newDOs, BaseDO[] origDOs, String operTp) throws BizException{
		ScLogEventDTO eventDTO = new ScLogEventDTO();
		eventDTO.setEuopertp(operTp);
		eventDTO.setNewobjs(doArray2List(newDOs));
		eventDTO.setOldobjs(doArray2List(origDOs));
		eventDTO.setId_psn(Context.get().getStuffId());
		BusinessEvent event = new BusinessEvent(IScEventConst.EVENT_SOURCE_SC_LOG, IScEventConst.EVENT_SC_LOG_BASEDO,
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
	private static FArrayList doArray2List(BaseDO... dos) {
		if (dos == null)
			return null;
		FArrayList list = new FArrayList();
		for (BaseDO d : dos)
			list.add(d);
		return list;
	}
}
