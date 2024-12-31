package iih.bl.cc.ebs.erp;

import iih.bl.cc.ebs.dg.MpIFaceBatchDO;
import iih.bl.cc.ebs.dg.MpIFaceMidDO;
import iih.bl.cc.ebs.params.Params;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.sys.devcfg.alert.PreAlertException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ArrayListHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;
/**
 * 
 * EBS(ERP)中间表操作工具类 
 * 
 * @author shaosq
 * @date 2016年10月19日  下午7:32:38
 */
public class MpOperateEbsUtil {
	
	public static String EBSDATASOURCE;

	public static final String SAVE_MIDTABLE_MAINSQL =  "(iface_batch_id,hospital_code,line_num,op_ip_flag,charge_date,"
			+"item_number,item_desc,charge_dept,charge_dept_name,execute_dept_name,"
		 +"ward_sn,ward_sn_name,deliver_qty,deliver_uom_code,group_no,group_name,"
			+"window_no,window_name,retail_price,operating_by,description,sync_date,process_date,process_flag,error_message)";
	
	public static final String SAVE_LOGTABLE_MAINSQL = "(iface_batch_id,hospital_code,batch_type,sync_date,process_flag,description) ";
	
	static {
		String datasource = new Params().EBSDATASOURCE();
		EBSDATASOURCE = datasource;
	}
	
	/**
	 * 临时表数据保存 
	 * @param tempData
	 * @throws BizException
	 */
	public static void saveTempData(List<MpIFaceMidDO> midDatas,String table,String qryTable) throws BizException{
		PersistMgr persist = null;
		PersistSession session = null;
		try
		{
			persist = (PersistMgr)PersistMgr.getInstance(EBSDATASOURCE);
			session = persist.getPersistSession();
			session.setAddTimeStamp(false);
			session.setSQLTranslator(false);
			for (int i =1;i<=midDatas.size();i++)
			{
				MpIFaceMidDO midData = midDatas.get(i-1);
				String sql = getInsertMidSQL(midData,table,i,qryTable);
				session.addBatch(sql);
			}
			session.execBatch();
			
		}
		catch (DbException e)
		{
			Logger.error(e.getMessage(), e);
			throw new PreAlertException(e.getMessage());
		}
		finally
		{
			if (session != null)
				session.closeAll();
			
			if (persist != null)
				persist.release();
		}
	}
	
	/**
	 * 临时表数据保存 
	 * @param tempData
	 * @throws BizException
	 */
	public static void saveBatchData(List<MpIFaceBatchDO> midDatas,String table) throws BizException{
		PersistMgr persist = null;
		PersistSession session = null;
		try
		{
			persist = (PersistMgr)PersistMgr.getInstance(EBSDATASOURCE);
			session = persist.getPersistSession();
			session.setAddTimeStamp(false);
			session.setSQLTranslator(false);
			for (MpIFaceBatchDO midData : midDatas)
			{
				String sql = getInsertLogSQL(midData,table);
				session.addBatch(sql);
			}
			session.execBatch();
			
		}
		catch (DbException e)
		{
			Logger.error(e.getMessage(), e);
			throw new PreAlertException(e.getMessage());
		}
		finally
		{
			if (session != null)
				session.closeAll();
			
			if (persist != null)
				persist.release();
		}
	}
	
	/**
	 * 组装中间表插入SQL
	 * @param index 
	 * @param midData
	 * @return
	 */
	private static String getInsertMidSQL(MpIFaceMidDO ifaceMidDo,String table, int index,String qryTable) throws BizException{
		StringBuffer insertSql =new StringBuffer();
		insertSql.append("insert into "+table);
		insertSql.append(SAVE_MIDTABLE_MAINSQL);
		getInsertMidSql(insertSql,ifaceMidDo,index,table,qryTable);
		return insertSql.toString();
	}

	/**
	 * 组装日志表插入SQL
	 * @param midData
	 * @return
	 */
	private static String getInsertLogSQL(MpIFaceBatchDO ifaceBatchDo,String table)throws BizException {
		StringBuffer insertSql =new StringBuffer();
		insertSql.append("insert into "+table);
		insertSql.append(SAVE_LOGTABLE_MAINSQL);
		getInsertLogSql(insertSql,ifaceBatchDo,table);
		return insertSql.toString();
	}
	
	/**
	 * 
	 * 组装中间表插入语句
	 * @param insertSql
	 * @param midDo
	 * @param index 
	 * @param table 
	 * @return
	 * @throws BizException 
	 */
	private static String getInsertMidSql(StringBuffer insertSql,MpIFaceMidDO midDo, int index, String table,String qryTable) throws BizException {
		 insertSql.append(" values(");
		 insertSql.append("'").append(getMaxBatchId(qryTable,FBoolean.TRUE).toString()).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Hospital_code")).append("',");
		 insertSql.append("'").append(index+"',");
		 insertSql.append("'").append(midDo.getAttrVal("Op_ip_flag")).append("',");
		 insertSql.append("'").append(midDo.getCharge_date()==null?"',":formatChargeDate(midDo.getCharge_date())+"',");
		 insertSql.append("'").append(midDo.getAttrVal("Item_number")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Item_desc")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Charge_dept")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Charge_dept_name")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Execute_dept_name")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Ward_sn")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Ward_sn_name")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Deliver_qty")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Deliver_uom_code")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Group_no")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Group_name")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Window_no")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Window_name")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Retail_price")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Operating_by")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Description")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Sync_date")).append("',");
		 insertSql.append("null,");
		 insertSql.append("'").append(midDo.getAttrVal("Process_flag")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Error_message")).append("')");
		 return insertSql.toString();
		 
		 
	}

	
	/**
	 * 格式化记账日期
	 * @param chargeTime
	 * @return
	 */
	private static String formatChargeDate(FDateTime chargeTime) {
		return chargeTime.getDate()+" 00:00:00";
	}

	/**
	 * 组装日志表插入语句
	 * @param insertSql
	 * @param batchDo
	 * @return
	 * @throws BizException 
	 */
	private static String getInsertLogSql(StringBuffer insertSql,MpIFaceBatchDO batchDo,String table) throws BizException {
		insertSql.append(" values(");
		insertSql.append("'").append(getMaxBatchId(table,FBoolean.TRUE).toString()).append("',");
		insertSql.append("'").append(batchDo.getAttrVal("Hospital_code")).append("',");
		insertSql.append("'").append(batchDo.getAttrVal("Batch_type")).append("',");
		insertSql.append("'").append(batchDo.getAttrVal("Sync_date")).append("',");
		insertSql.append("'").append(batchDo.getAttrVal("Process_flag")).append("',");
		insertSql.append("'").append(batchDo.getAttrVal("Description")).append("')");
		return insertSql.toString();
	}
	
	/**
	 * 查询出当天未合并到EBS中间表的中间表数据
	 * @param tableName 
	 * 
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	public static List<MpIFaceMidDO> searchNotMergedMidData(String tableName,String selectDate) throws DAException {
		String whereSql="";
		//如果日期为空，则默认查找前一天的数据
		if(StringUtil.isEmpty(selectDate))
		{
		 whereSql ="select * from "+tableName + " where charge_date>='"+ErpSqlCondHelper.getLastDateBegin() + "' "+
				 " and charge_date<='"+ErpSqlCondHelper.getLastDateEnd() + "' ";
		}else{
		 whereSql ="select * from "+tableName + " where charge_date>='"+ selectDate + " 00:00:00" + "' "+
				 " and charge_date<='"+selectDate +  " 23:59:59' ";
		}
		return (List<MpIFaceMidDO>)new DAFacade(EBSDATASOURCE).execQuery( whereSql, new BeanListHandler(MpIFaceMidDO.class));
	}
	
	/**
	 * 查询出当天未合并到EBS中间表的日志表数据
	 * @param tableName 
	 * 
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	public static List<MpIFaceBatchDO> searchNotMergedBatchData(String tableName,String selectDate,String batch_type) throws DAException {
		//String whereSql ="select * from "+tableName +" where sync_date>= '"+new FDate().toString() + " 00:00:00"+
		//		 "' and sync_date<= '"+new FDate().toString() + " 23:59:59'";
		String whereSql ="select * from "+tableName +" where sync_date>= '"+selectDate + " 00:00:00"+
				 "' and sync_date<= '"+ selectDate + " 23:59:59' and batch_type in('"+ batch_type +"')";
		return (List<MpIFaceBatchDO>)new DAFacade(EBSDATASOURCE).execQuery( whereSql, new BeanListHandler(MpIFaceBatchDO.class));
	}
	/**
	 * 删除表中数据
	 * @param tableName 
	 * 
	 * @return
	 * @throws DAException 
	 */
	public static void deleteTableData(String table,String date,String sWhere,boolean isBatch)throws BizException{
		String whereSql="";
		if(sWhere=="")
			sWhere="1=1";
		if(isBatch== true)//是否删除日志表
		{
			whereSql ="delete from "+ table +" where  CONVERT(varchar(100),SYNC_DATE, 23)='"+date+"' and  " +sWhere;
		}else{
			
			whereSql ="delete from "+ table +" where  CONVERT(varchar(100),charge_date, 23)='"+date+"' and  " +sWhere;
		}
		execSql(whereSql);
	}	
	/**
	 * 执行sql语句
	 * @param sql
	 * @throws BizException
	 */
	public static void execSql(String sql) throws BizException{
		PersistMgr persist = null;
		PersistSession session = null;
		try
		{
			persist = (PersistMgr)PersistMgr.getInstance(EBSDATASOURCE);
			session = persist.getPersistSession();
			session.setAddTimeStamp(false);
			session.setSQLTranslator(false);
			session.addBatch(sql);
			session.execBatch();		
		}
		catch (DbException e)
		{
			Logger.error(e.getMessage(), e);
			throw new PreAlertException(e.getMessage());
		}
		finally
		{
			if (session != null)
				session.closeAll();
			
			if (persist != null)
				persist.release();
		}
	}		
	/**
	 * 
	 * 获取已有最大子自增列
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static Integer getMaxBatchId(String tableName,FBoolean bAdd) throws BizException {
		String whereSql ="select  max(iface_batch_id) from "+tableName;
 		List result = (List)new DAFacade(EBSDATASOURCE).execQuery(whereSql, new ArrayListHandler());
		if(ListUtil.isEmpty(result) || result.get(0)==null){
			return 1;
		}
		Object[] res = (Object[])result.get(0);
		if(res[0] == null)
			return 1;
		if((bAdd).equals(FBoolean.TRUE)){
			return Integer.parseInt(res[0].toString())+1;
		}else{
			return Integer.parseInt(res[0].toString());
		}
	}
}
