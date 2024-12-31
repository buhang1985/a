package iih.ci.ord.printmanage.srv;

import java.util.List;

/**
 * 临床打印报表数据查询服务接口
 * @author Young
 *
 * @param <T>
 * @param <U>
 */
public interface ICiorderPrintService<T,U> {
	
	/**
	 * 执行查询
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	public abstract List<T> exec(String ids) throws Exception;
	
	/**
	 * 执行查询
	 * @param ids
	 * @param blstatetp
	 * @return
	 * @throws Exception
	 */
	public abstract List<T> exec(String ids, String blstatetp) throws Exception;
	
	/**
	 * 主DO查询SQL
	 * @param ids
	 * @return
	 */
	public abstract String getOrdInfoSqlQry(String ids);
	/**
	 * 查询主DO集合
	 * @param dto
	 * @param sqlQry
	 * @return
	 * @throws Exception
	 */
	public abstract List<T> getOrderList(String sqlQry) throws Exception;
	/**
	 * 子DO查询SQL
	 * @param id
	 * @return
	 */
	public abstract String getItmInfoSqlQry(String ids);
	/**
	 * 查询子DO集合
	 * @param sqlQry
	 * @return
	 * @throws Exception
	 */
	public abstract List<U> getItemList(String sqlQry) throws Exception;
	/**
	 * 设置DO信息
	 * @param dtos
	 * @throws Exception
	 */
	public abstract void setOrdInfo(List<T> dtos) throws Exception;
}
