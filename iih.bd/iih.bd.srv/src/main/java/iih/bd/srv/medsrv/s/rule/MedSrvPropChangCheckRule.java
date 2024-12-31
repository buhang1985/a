package iih.bd.srv.medsrv.s.rule;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.s.rule.bp.DrugSrvPropChangCheckBp;
import iih.bd.srv.medsrv.s.rule.bp.MedSrvPropChangCheckBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 医疗服务属性变更检查规则
 * 
 * @author hao_wu
 *
 */
@SuppressWarnings("rawtypes")
public class MedSrvPropChangCheckRule implements ICompareRule {

	@Override
	public void process(Object[] oldDataArray, Object[] newDataArray) throws BizException {
		if (oldDataArray == null || oldDataArray.length <= 0) {
			return;
		}

		if (oldDataArray[0] instanceof MedsrvAggDO) {
			medSrvPropChangCheck((MedsrvAggDO[]) oldDataArray, (MedsrvAggDO[]) newDataArray);
		} else if (oldDataArray[0] instanceof MedSrvDO) {
			medSrvPropChangCheck((MedSrvDO[]) oldDataArray, (MedSrvDO[]) newDataArray);
		}
	}

	/**
	 * 医疗服务属性变更检查
	 * 
	 * @param oldMedSrvAggArray
	 * @param newMedSrvAggArray
	 * @throws BizException
	 */
	private void medSrvPropChangCheck(MedsrvAggDO[] oldMedSrvAggArray, MedsrvAggDO[] newMedSrvAggArray)
			throws BizException {
		int lenght = oldMedSrvAggArray.length;
		MedSrvDO[] oldMedSrvArray = new MedSrvDO[lenght];
		MedSrvDO[] newMedSrvArray = new MedSrvDO[lenght];
		for (int i = 0; i < lenght; i++) {
			oldMedSrvArray[i] = oldMedSrvAggArray[i].getParentDO();
			newMedSrvArray[i] = newMedSrvAggArray[i].getParentDO();
		}

		medSrvPropChangCheck(oldMedSrvArray, newMedSrvArray);
	}

	/**
	 * 医疗服务属性变更检查
	 * 
	 * @param oldMedSrvArray
	 * @param newMedSrvArray
	 * @throws BizException
	 */
	private void medSrvPropChangCheck(MedSrvDO[] oldMedSrvArray, MedSrvDO[] newMedSrvArray) throws BizException {
		int lenght = oldMedSrvArray.length;
		for (int i = 0; i < lenght; i++) {
			MedSrvDO oldMedSrv = oldMedSrvArray[i];
			MedSrvDO newMedSrv = newMedSrvArray[i];
			medSrvPropChangCheck(oldMedSrv, newMedSrv);
			drugSrvPropChangCheck(oldMedSrv, newMedSrv);
		}
	}

	/**
	 * 医疗服务属性变更检查
	 * 
	 * @param oldMedSrv
	 * @param newMedSrv
	 * @throws BizException
	 */
	private void medSrvPropChangCheck(MedSrvDO oldMedSrv, MedSrvDO newMedSrv) throws BizException {
		MedSrvPropChangCheckBp bp = new MedSrvPropChangCheckBp();
		bp.exec(oldMedSrv, newMedSrv);
	}

	/**
	 * 医疗服务属性变更检查
	 * 
	 * @param oldMedSrv
	 * @param newMedSrv
	 * @throws BizException
	 */
	private void drugSrvPropChangCheck(MedSrvDO oldMedSrv, MedSrvDO newMedSrv) throws BizException {
		DrugSrvPropChangCheckBp bp = new DrugSrvPropChangCheckBp();
		bp.exec(oldMedSrv, newMedSrv);
	}
}
