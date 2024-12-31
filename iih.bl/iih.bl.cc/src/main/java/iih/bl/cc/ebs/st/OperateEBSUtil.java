package iih.bl.cc.ebs.st;



import iih.bd.base.utils.AppUtils;
import iih.bl.cc.ebs.dg.MpIFaceBatchDO;
import iih.bl.cc.ebs.dg.dto.OutpatientincomeDTO;
import iih.bl.cc.ebs.params.Params;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
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

public class OperateEBSUtil {
	public static String EBSDATASOURCE;

	public static final String SAVE_MIDTABLE_MAINSQL =  "(IFACE_BATCH_ID,HOSPITAL_CODE,LINE_NUM,BUSINESS_TYPE,OP_IP_FLAG,CHARGE_DEPT,UNDER_DEPT,EXECUTE_DEPT,"
			+"CHARGE_TYPE,CHARGE_TYPE_NAME, CHARGE_ITEM, CHARGE_ITEM_NAME,AMOUNT, OPERATING_DATE,RECEIVABLE_COMP, "
		 +"RECEIVABLE_COMP_NAME,  CHARGE_DEPT_NAME,UNDER_DEPT_NAME,EXECUTE_DEPT_NAME, "
			+"BILL_NUM, BILL_DATE, SYNC_DATE,PROCESS_FLAG,  PREPAY_FLAG, RECEIVABLE_FLAG,DESCRIPTION )";
	
	public static final String SAVE_LOGTABLE_MAINSQL = "(iface_batch_id,hospital_code,batch_type,sync_date,process_flag) ";
	
	static {
		String datasource = new Params().EBSDATASOURCE();
		EBSDATASOURCE = datasource;
	}
	
	/**
	 * 临时表数据保存 
	 * @param tempData
	 * @throws BizException
	 */
	public static void saveTempData(List<OutpatientincomeDTO> midDatas,String table,String logTable) throws BizException{
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
				OutpatientincomeDTO midData = midDatas.get(i-1);
				String sql = getInsertMidSQL(midData,table,i,logTable);
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
				session.execBatch();
			}
			//session.execBatch();
			
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
	private static String getInsertMidSQL(OutpatientincomeDTO ifaceMidDo,String table, int index,String logTable) throws BizException{
		StringBuffer insertSql =new StringBuffer();
		insertSql.append("insert into "+table);
		insertSql.append(SAVE_MIDTABLE_MAINSQL);
		getInsertMidSql(insertSql,ifaceMidDo,index,logTable);
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
	private static String getInsertMidSql(StringBuffer insertSql,OutpatientincomeDTO midDo, int index, String table) throws BizException {
		 insertSql.append(" values(");
		 insertSql.append("'").append(getMaxBatchId(table,FBoolean.TRUE).toString()).append("',");
//		 insertSql.append(midDo.getIface_batch_id());
		 insertSql.append("'").append(midDo.getAttrVal("Hospital_code")).append("',");
		 insertSql.append("'").append(index+"',");
		 insertSql.append("'").append(midDo.getAttrVal("Business_type")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Op_ip_flag")).append("',");
		 
		 //insertSql.append("'").append(midDo.getCharge_date()==null?"'":formatChargeDate(midDo.getCharge_date())+"',");
		 insertSql.append("'").append(midDo.getAttrVal("Charge_dept")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Under_dept")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Execute_dept")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Charge_type")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Charge_type_name")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Charge_item")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Charge_item_name")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Amount")).append("',");
		 insertSql.append("'").append(midDo.getOperating_date()==null? "',":midDo.getOperating_date()+"',");
		 insertSql.append("'").append(midDo.getAttrVal("Receivable_comp")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Receivable_comp_name")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Charge_dept_name")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Under_dept_name")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Execute_dept_name")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Bill_num")).append("',");
		 insertSql.append(midDo.getBill_date()==null?"null,":"'"+ midDo.getBill_date()+"',");
		// insertSql.append("'").append(midDo.getSync_date()==null?"',":midDo.getSync_date()+"',");
		 insertSql.append("'").append(AppUtils.getServerDateTime()+"',");
		 insertSql.append("'").append(midDo.getAttrVal("Process_flag")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Prepay_flag")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Receivable_flag")).append("',");
		 insertSql.append("'").append(midDo.getAttrVal("Description")).append("')");
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
//		insertSql.append("'").append(iface_batch_id).append("',");
		insertSql.append("'").append(batchDo.getAttrVal("Hospital_code")).append("',");
		insertSql.append("'").append(batchDo.getAttrVal("Batch_type")).append("',");
		insertSql.append("'").append(batchDo.getAttrVal("Sync_date")).append("',");
		insertSql.append("'").append(batchDo.getAttrVal("Process_flag")).append("')");
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
	public static List<OutpatientincomeDTO> searchNotMergedMidData(String tableName,String date,String type) throws DAException {
		String whereSql ="select * from "+tableName + " where OPERATING_DATE>='"+   date+ " 00:00:00' "+
				 " and OPERATING_DATE<='"+date + " 23:59:59' and BUSINESS_TYPE='"+ type +"' ";
		return (List<OutpatientincomeDTO>)new DAFacade(EBSDATASOURCE).execQuery( whereSql, new BeanListHandler(OutpatientincomeDTO.class));
	}
	
	/**
	 * 查询出当天未合并到EBS中间表的日志表数据
	 * @param tableName 
	 * 
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	public static List<MpIFaceBatchDO> searchNotMergedBatchData(String tableName,String date,String batch_type) throws DAException {
		String whereSql ="select * from "+tableName +" where sync_date>= '"+date + " 00:00:00"+
				 "' and sync_date<= '"+date + " 23:59:59' and batch_type in('"+batch_type+ "') ";
		return (List<MpIFaceBatchDO>)new DAFacade(EBSDATASOURCE).execQuery( whereSql, new BeanListHandler(MpIFaceBatchDO.class));
	}
	/**
	 * 更新导入数据的iface_batch_id
	 * @param tableName 作废
	 * 
	 * @return
	 * @throws DAException 
	 */
	public static void updateIface_batch_id(String date)throws BizException{
		String whereSql ="update CUX_GL_HIS_CHARGE_IFACE set iface_batch_id= a.iface_batch_id from CUX_GL_HIS_BATCH_IFACE a " +
						" where a.BATCH_TYPE =CUX_GL_HIS_CHARGE_IFACE.business_type and CONVERT(varchar(100), a.SYNC_DATE, 23) = CONVERT(varchar(100), CUX_GL_HIS_CHARGE_IFACE.OPERATING_DATE, 23)"+ 
						" and CONVERT(varchar(100),CUX_GL_HIS_CHARGE_IFACE.OPERATING_DATE, 23)='"+date+"' ";
		execSql(whereSql);
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
			
			whereSql ="delete from "+ table +" where  CONVERT(varchar(100),OPERATING_DATE, 23)='"+date+"' and  " +sWhere;
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
	 * 获取已有最大自增列
	 * bAdd 是否加1
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private static Integer getMaxBatchId(String tableName,FBoolean bAdd) throws BizException {
		String whereSql ="select  max(iface_batch_id) from  "+tableName;
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
