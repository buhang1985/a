package iih.sc.comm;

import java.util.Comparator;

import xap.mw.core.data.BaseDO;

public class SortEntityDos<T extends BaseDO> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		if (o1.getPkVal()!=null&&o2.getPkVal()!=null) {
			return o1.getPkVal().compareTo(o2.getPkVal());
		}
		return 0;
	}

}
