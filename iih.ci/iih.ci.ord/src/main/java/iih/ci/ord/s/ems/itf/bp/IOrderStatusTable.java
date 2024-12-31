package iih.ci.ord.s.ems.itf.bp;

public interface IOrderStatusTable {

	public abstract String TryHitOrderStatus(String orStatus,String mpStatus,int stop, int refuse,String refusetp);
}
