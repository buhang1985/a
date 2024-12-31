package iih.bd.srv.medusage.s.rule;

import iih.bd.srv.medusage.d.MedUsageDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.refcheck.i.IReferenceCheck;

/**
 * 医疗用法变更数据检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MedUsageChangDataCheckBp {

	public void exec(MedUsageDO[] newDataArray, MedUsageDO[] oldDataArray) throws BizException {
		int dataCount = newDataArray.length;
		for (int i = 0; i < dataCount; i++) {
			MedUsageDO newData = newDataArray[i];
			MedUsageDO oldData = oldDataArray[i];
			StringBuffer referenceInfo = new StringBuffer();
			if (IsChanged(newData, oldData) && HasReference(oldData, referenceInfo)) {
				String msg = String.format("医疗用法\"%s\"不允许编辑，%s。", newData.getName(), referenceInfo.toString());
				throw new BizException(msg);
			}
		}

	}

	/**
	 * 数据是否变更
	 * 
	 * @param newData
	 * @param oldData
	 * @return
	 */
	private boolean IsChanged(MedUsageDO newData, MedUsageDO oldData) {
		if (newData.getName() == null && oldData.getName() != null) {
			return true;
		}
		if (newData.getName() != null && oldData.getName() == null) {
			return true;
		}
		if (newData.getName() != null && oldData.getName() != null && !newData.getName().equals(oldData.getName())) {
			return true;
		}
		if (newData.getCode() == null && oldData.getCode() != null) {
			return true;
		}
		if (newData.getCode() != null && oldData.getCode() == null) {
			return true;
		}
		if (newData.getCode() != null && oldData.getCode() != null && !newData.getCode().equals(oldData.getCode())) {
			return true;
		}
		return false;
	}

	/**
	 * 是否存在引用
	 * 
	 * @param oldData
	 * @param referenceInfo
	 * @return
	 * @throws BizException
	 */
	private boolean HasReference(MedUsageDO oldData, StringBuffer referenceInfo) throws BizException {
		IReferenceCheck referenceCheck = ServiceFinder.find(IReferenceCheck.class);
		Boolean isReferenced = referenceCheck.isReferenced2(oldData.getTableName(), oldData.getPkVal(), referenceInfo);
		return isReferenced;
	}

}
