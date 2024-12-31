package iih.bd.pp.primd.bp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 本服务定价计算器
 * 
 * @author yankan
 * @since 2015-08-04
 *
 */
public class SrvPriCal implements IPriCal {
	/**
	 * 计算价格
	 * 
	 * @param srvId 服务ID
	 * @return 服务价格
	 */
	public FDouble Calculate(String srvId) {
		if(StringUtils.isBlank(srvId))
			return null;

		Double price = QueryPriceBySrvId(srvId);
		
		return new FDouble(price);
	}
	/**
	 * 查询DO
	 * 过滤当前在有效区间内，按结束时间正序排列，第一行数据
	 * @param srvId 服务ID
	 * @return 价格
	 */
	private double QueryPriceBySrvId(String srvId){		
		double price = 0d;
		Date now = GetNowTime();
		//查询启用的，且在有效时间内的，按结束时间正序排列
		String sql = "select price from BD_PRI_SRV WHERE id_srv=? and fg_active=1 and (dt_b<? and dt_e>?) and rownum<1 order by dt_e asc";
		SqlParam param = new SqlParam();
		param.addParam(srvId);
		param.addParam(now);
		param.addParam(now);
		Object priceObj = null;
		try {
			priceObj= new DAFacade().execQuery(sql,param, new ColumnHandler(0));
		} catch (DAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(priceObj!=null){
			price = Double.parseDouble(priceObj.toString());
		}
		
		return price;
	}
	/**
	 * 获取当前时间
	 * @return
	 */
	private Date GetNowTime(){		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date time=null;
		try {
			time= sdf.parse(sdf.format(new Date()));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;		
	}
}
