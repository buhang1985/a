package iih.bd.pp.hp.s;

import iih.bd.pp.hp.i.IHpPropDoExtService;
import iih.bd.pp.hp.s.bp.PropMaxSortnoBp;

public class HpPropDoExtServiceImpl implements IHpPropDoExtService {

	@Override
	public int getMaxSortno(String id_hp) {
		PropMaxSortnoBp propMaxSortno = new PropMaxSortnoBp();
		return propMaxSortno.exec(id_hp);
	}

}
