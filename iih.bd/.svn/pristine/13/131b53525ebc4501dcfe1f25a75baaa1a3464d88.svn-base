package iih.bd.res.bizgrp.s.rule;

import java.util.HashMap;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.res.bizgrp.d.BizGrpEmpsDO;
import iih.bd.res.bizgrp.d.BizgrpAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.appfw.bizrule.IRule;

/**
 * 业务组上级医生检查规则</br>
 * 上级医生必须是该业务组内成员
 * 
 * @author hao_wu 2019-4-1
 *
 */
public class EmpLeaderCheckRule implements IRule<BizgrpAggDO> {

	@Override
	public void process(BizgrpAggDO... bizGrpAggs) throws BizException {
		if (ArrayUtils.isEmpty(bizGrpAggs)) {
			return;
		}

		for (BizgrpAggDO bizgrpAggDO : bizGrpAggs) {
			checkEmpLeader(bizgrpAggDO);
		}
	}

	private void checkEmpLeader(BizgrpAggDO bizgrpAggDO) throws BizException {
		BizGrpEmpsDO[] grpEmpDos = bizgrpAggDO.getBizGrpEmpsDO();
		if (ArrayUtils.isEmpty(grpEmpDos)) {
			return;
		}

		HashMap<String, BizGrpEmpsDO> grpEmpMap = new HashMap<String, BizGrpEmpsDO>();
		for (BizGrpEmpsDO bizGrpEmpsDO : grpEmpDos) {
			if (bizGrpEmpsDO.getStatus() != DOStatus.DELETED && StringUtils.isNotBlank(bizGrpEmpsDO.getId_emp())) {
				grpEmpMap.put(bizGrpEmpsDO.getId_emp(), bizGrpEmpsDO);
			}
		}

		for (BizGrpEmpsDO bizGrpEmpsDO : grpEmpDos) {
			if (bizGrpEmpsDO.getStatus() == DOStatus.DELETED) {
				continue;
			}
			if (StringUtils.isBlank(bizGrpEmpsDO.getId_emp_leader())) {
				continue;
			}

			if (bizGrpEmpsDO.getId_emp_leader().equals(bizGrpEmpsDO.getId_emp())) {
				String msg = String.format("成员\"%s\"的上级医生不允许为自己。", bizGrpEmpsDO.getName_psn());
				throw new BizException(msg);
			}

			if (!grpEmpMap.containsKey(bizGrpEmpsDO.getId_emp_leader())) {
				String msg = String.format("成员\"%s\"的上级医生\"%s\"不在该业务组中。", bizGrpEmpsDO.getName_psn(),
						bizGrpEmpsDO.getName_emp_leader());
				throw new BizException(msg);
			}
		}
	}

}
