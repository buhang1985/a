package iih.bd.pp.hp.i;

public interface IHpSegDoExtService {

	/**
	 * 获取医保计划付款段序号
	 * @param id_hp
	 * @return
	 */
	public abstract int getMaxSortno(String id_hp);
}
