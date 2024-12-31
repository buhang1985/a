package iih.bd.res.bed.s.rule;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.bc.event.pub.IBdResEventCodeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.BedAggDO;
import iih.bd.utils.log.BdResLogUtils;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

public class BedNameChangedRule<T> implements ICompareRule<T> {

	@Override
	public void process(T[] newDatas, T[] oldDatas) throws BizException {
		if (ArrayUtils.isEmpty(newDatas)) {
			return;
		}

		Bdbed[] newBeds = getBedDos(newDatas);
		Bdbed[] oldBeds = getBedDos(oldDatas);

		for (int i = 0; i < newBeds.length; i++) {
			Bdbed newBed = newBeds[i];
			Bdbed oldBed = oldBeds[i];

			if (StringUtils.isNotEmpty(newBed.getName()) && !newBed.getName().equals(oldBed.getName())) {
				this.fireBedNameChangedEvent(oldBed, newBed);
			}
		}
	}

	/**
	 * 获取床位数组
	 * 
	 * @param datas
	 * @return
	 */
	private Bdbed[] getBedDos(T[] datas) {
		ArrayList<Bdbed> bedList = new ArrayList<Bdbed>();
		for (T data : datas) {
			if (data instanceof Bdbed) {
				bedList.add((Bdbed) data);
			} else if (data instanceof BedAggDO) {
				BedAggDO bedAggDo = (BedAggDO) data;
				bedList.add(bedAggDo.getParentDO());
			}
		}
		return bedList.toArray(new Bdbed[0]);
	}

	/**
	 * 发送床位名称变更事件
	 * 
	 * @param oldBed
	 * @param newBed
	 * @throws BizException
	 */
	private void fireBedNameChangedEvent(Bdbed oldBed, Bdbed newBed) throws BizException {

		BusinessEvent businessEvent = new BusinessEvent(IBdResEventCodeConst.EVENT_BD_BED,
				IBdResEventCodeConst.EVENT_TP_BD_BED_CHANGED_NAME, newBed);
		BdResLogUtils.info("发送床位名称变更事件：%s,%s,%s.", IBdResEventCodeConst.EVENT_BD_BED,
				IBdResEventCodeConst.EVENT_TP_BD_BED_CHANGED_NAME, newBed.toString());
		EventDispatcher.fireEvent(businessEvent);
	}
}
