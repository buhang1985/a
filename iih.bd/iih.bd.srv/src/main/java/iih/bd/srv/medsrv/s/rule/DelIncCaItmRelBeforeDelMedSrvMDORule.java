package iih.bd.srv.medsrv.s.rule;

import java.util.ArrayList;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.s.rule.bp.DelIncCaItmRelBeforeDelMedSrvMDOBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 删除医疗服务前删除票据分类项目对照规则
 * 
 * @author hao_wu
 *
 */
public class DelIncCaItmRelBeforeDelMedSrvMDORule implements IRule<MedSrvDO> {

	@Override
	public void process(MedSrvDO... arg0) throws BizException {
		MedSrvDO[] delMedSrvMdoArray = GetDelMedSrvMdoArray(arg0);
		if (delMedSrvMdoArray == null || delMedSrvMdoArray.length <= 0) {
			return;
		}
		DelIncCaItmRelBeforeDelMedSrvMDOBp bp = new DelIncCaItmRelBeforeDelMedSrvMDOBp();
		bp.exec(delMedSrvMdoArray);
	}

	/**
	 * 从MedSrvDO数组中获取要删除的数据数组
	 * 
	 * @param arg0
	 * @return
	 */
	private MedSrvDO[] GetDelMedSrvMdoArray(MedSrvDO[] arg0) {
		if (arg0 == null || arg0.length <= 0) {
			return null;
		}
		ArrayList<MedSrvDO> medSrvMdoList = new ArrayList<MedSrvDO>();
		for (MedSrvDO medsrvDO : arg0) {
			if (medsrvDO != null && (medsrvDO.getFg_bl() == null || medsrvDO.getFg_bl().booleanValue() == false)) {
				// 费用标识为true时不删除
				medSrvMdoList.add(medsrvDO);
			}
		}
		return medSrvMdoList.toArray(new MedSrvDO[0]);
	}

}
