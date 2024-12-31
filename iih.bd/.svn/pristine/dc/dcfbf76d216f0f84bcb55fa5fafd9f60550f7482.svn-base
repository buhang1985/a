package iih.bd.srv.medsrv.s.rule;

import java.util.ArrayList;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.s.rule.bp.DelIncCaItmRelBeforeDelMedSrvMDOBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 删除医疗服务前删除票据分类项目对照规则
 * 
 * @author hao_wu
 *
 */
public class DelIncCaItmRelBeforeDelMedSrvRule implements IRule<MedsrvAggDO> {

	@Override
	public void process(MedsrvAggDO... arg0) throws BizException {
		MedSrvDO[] delMedSrvMdoArray = GetDelMedSrvMdoArray(arg0);
		if (delMedSrvMdoArray == null || delMedSrvMdoArray.length <= 0) {
			return;
		}
		if (delMedSrvMdoArray != null && delMedSrvMdoArray.length > 0) {
			DelIncCaItmRelBeforeDelMedSrvMDOBp bp = new DelIncCaItmRelBeforeDelMedSrvMDOBp();
			bp.exec(delMedSrvMdoArray);
		}
	}

	/**
	 * 从Agg数组中获取要删除的主DO数组
	 * 
	 * @param arg0
	 * @return
	 */
	private MedSrvDO[] GetDelMedSrvMdoArray(MedsrvAggDO[] arg0) {
		if (arg0 == null || arg0.length <= 0) {
			return null;
		}
		ArrayList<MedSrvDO> medSrvMdoList = new ArrayList<MedSrvDO>();
		for (MedsrvAggDO medsrvAggDO : arg0) {
			if (medsrvAggDO != null) {
				MedSrvDO parentData = medsrvAggDO.getParentDO();
				if (parentData != null
						&& (parentData.getFg_bl() == null || parentData.getFg_bl().booleanValue() == false)) {
					// 费用标识为true时不删除
					medSrvMdoList.add(parentData);
				}
			}
		}
		return medSrvMdoList.toArray(new MedSrvDO[0]);
	}

}
