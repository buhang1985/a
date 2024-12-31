package iih.bd.pp.hp.s;

import iih.bd.pp.hp.i.IHpSegDoExtService;
import iih.bd.pp.hp.s.bp.SegMaxSortnoBp;

public class HpSegDoExtServiceImpl implements IHpSegDoExtService {

	@Override
	public int getMaxSortno(String id_hp) {
		SegMaxSortnoBp segMaxSortnoBp = new SegMaxSortnoBp();
		return segMaxSortnoBp.exec(id_hp);
	}

}
