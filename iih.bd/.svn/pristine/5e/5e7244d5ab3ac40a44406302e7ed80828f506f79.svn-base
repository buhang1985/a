package iih.bd.srv.freqdef.s.rule.bp;

import java.util.ArrayList;

import iih.bd.srv.freqdef.d.FreqDefDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 频次字段值变更检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FreqdefFiledValueChangCheckBp {

	public void exec(FreqDefDO newParentData, FreqDefDO oldParentData) throws BizException {
		if (newParentData != null && oldParentData != null && FBoolean.TRUE.equals(newParentData.getFg_active())
				&& FBoolean.TRUE.equals(oldParentData.getFg_active())) {
			// 新旧数据都是启用时，检查字段变更

			ArrayList<String> checkFiledNameList = getCheckFiledNameList();
			String[] attrNames = newParentData.getAttrNames();

			for (int i = 0; i < attrNames.length; i++) {
				String attrName = attrNames[i];
				if (checkFiledNameList.contains(attrName)) {
					filedValueChangCheck(newParentData, oldParentData, attrName);
				}
			}
		}
	}

	/**
	 * 获取需要检查的属性名称列表
	 * 
	 * @return 需要检查的属性名称列表
	 */
	private ArrayList<String> getCheckFiledNameList() {
		ArrayList<String> checkFiledNameList = new ArrayList<String>();
		checkFiledNameList.add(FreqDefDO.CODE);
		checkFiledNameList.add(FreqDefDO.NAME);
		checkFiledNameList.add(FreqDefDO.ID_FREQUNITCT);
		checkFiledNameList.add(FreqDefDO.FREQUNITCT);
		checkFiledNameList.add(FreqDefDO.FREQCT);
		checkFiledNameList.add(FreqDefDO.FG_PRNOR);
		checkFiledNameList.add(FreqDefDO.FG_LONG);
		checkFiledNameList.add(FreqDefDO.FG_LONG_EDIT);
		checkFiledNameList.add(FreqDefDO.FG_USE_OP);
		checkFiledNameList.add(FreqDefDO.FG_USE_IP);
		checkFiledNameList.add(FreqDefDO.FG_USE_ER);
		checkFiledNameList.add(FreqDefDO.FG_USE_PE);
		checkFiledNameList.add(FreqDefDO.FG_USE_FM);
		checkFiledNameList.add(FreqDefDO.FG_INTERVAL);
		return checkFiledNameList;
	}

	/**
	 * 属性值变更检查
	 * 
	 * @param newParentData 新数据
	 * @param oldParentData 旧数据
	 * @param attrName      属性名
	 * @throws BizException
	 */
	private void filedValueChangCheck(FreqDefDO newParentData, FreqDefDO oldParentData, String attrName)
			throws BizException {

		Object newValue = newParentData.getAttrVal(attrName);
		Object oldValue = oldParentData.getAttrVal(attrName);

		if (newValue == null && oldValue == null) {
			return;
		}

		if (newValue != null && oldValue != null && newValue.equals(oldValue)) {
			return;
		}

		String attrDisplayName = newParentData.getDODesc().getAttrDesc(attrName).toString();
		String msg = String.format("\"%s\"不允许修改。", attrDisplayName);
		throw new BizException(msg);
	}

}
