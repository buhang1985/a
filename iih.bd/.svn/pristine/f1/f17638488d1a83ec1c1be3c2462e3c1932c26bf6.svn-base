package iih.bd.srv.medsrv.s.rule.bp;

import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import xap.mw.core.data.BizException;

/**
 * 医疗服务药品属性插入或更新前规则业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MedSrvDrugInsertOrUpdateBeforeRuleBp {

	public void exec(MedSrvDrugDO[] arg0) throws BizException {
		MedSrvDrugCheckRoutBp bp = new MedSrvDrugCheckRoutBp();
		bp.exec(arg0, null);
	}
}
