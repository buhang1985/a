package iih.bd.pp.hpsrvorca.s.rule;

import java.util.ArrayList;
import java.util.List;

import iih.bd.pp.hpsrvorca.bp.BuildHpSrvCtlBySrvOrCaBp;
import iih.bd.pp.hpsrvorca.bp.HpSrvorcaDeleteBp;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

public class HpsrvcaUpdateRule implements ICompareRule<HPSrvorcaDO> {

	@Override
	public void process(HPSrvorcaDO[] paramArrayOfT1, HPSrvorcaDO[] paramArrayOfT2) throws BizException {
		int dataCount = paramArrayOfT1.length;
		List<HPSrvorcaDO> hpsrvorcaList = new ArrayList<HPSrvorcaDO>();
		for (int i = 0; i < dataCount; i++) {
			HPSrvorcaDO newData = paramArrayOfT1[i];
			HPSrvorcaDO oldData = paramArrayOfT2[i];
			if (!newData.getCode().equals(oldData.getCode())
					|| !newData.getEu_hpsrvtp().equals(oldData.getEu_hpsrvtp())
					|| !newData.getId_hp().equals(oldData.getId_hp())) {
				hpsrvorcaList.add(oldData);
			}
		}
		//删除旧的数据
		HpSrvorcaDeleteBp hpSrvorcaDeleteBp = new HpSrvorcaDeleteBp();
		//hpSrvorcaDeleteBp.exec(hpsrvorcaList.toArray(new HPSrvorcaDO[hpsrvorcaList.size()]));
		//新增之前删除id_hp+code+eu_hpsrvtp相同的数据
		hpSrvorcaDeleteBp.exec(paramArrayOfT1);
		//新增变更后的
		BuildHpSrvCtlBySrvOrCaBp buildHpSrvCtlBySrvOrCaBp = new BuildHpSrvCtlBySrvOrCaBp();
		buildHpSrvCtlBySrvOrCaBp.exec(paramArrayOfT1);
	}

}
