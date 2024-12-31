package iih.bl.cc.ebs.bp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import iih.bl.cc.ebs.bp.qry.GetChargeIfaceDTOQty;
import iih.bl.cc.ebs.d.HisBatchIfaceDTO;
import iih.bl.cc.ebs.d.HisChargeIfaceDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.devcfg.alert.PreAlertException;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;
import xap.sys.orgfw.org.i.IOrgConst;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * EBS数据导入实现类
 * 
 * @author lu.yang
 * 
 */
public class ExecEBSDBBP {
	//在C:\Users\tcy\.xaptools\configurations\iih_dev-config_1.0-SNAPSHOT\configuration中找到datasource.json文件，打开，
	//设置dataSourceName（不同配置只需要改dataSourceName,user,password)
	// 数据库配置名称
	String EBSDATANAME = "EBS";  

	/**
	 * 默认执行方法无日期获取前一天日期
	 */
	public void exec() throws BizException {

		FDateTime nowDateTime = new FDateTime();
		Calendar ca = Calendar.getInstance();
		ca.setTime(nowDateTime.getDate().toDate());
		// 获取前一天的结算数据
		ca.add(5, -1);

		exec(new FDate(ca.getTime()));
	}

	/**
	 * 执行对应日期导入数据
	 * 
	 * @param 对应日期
	 * @throws BizException
	 */
	public void exec(FDate fdate) throws BizException {

		if (fdate != null) {
			execDB(new FDateTime(fdate.toDate()));
		}
	}

	/**
	 * 执行导入方法
	 * 
	 * @param nowDateTime
	 * @throws BizException
	 */
	private void execDB(FDateTime nowDateTime) throws BizException {
		// 1.执行SQL集合
		List<String> sqlStrList = new ArrayList<String>();
		// 2.执行主表集合
		List<HisBatchIfaceDTO> batchList = new ArrayList<HisBatchIfaceDTO>();
		// 3.执行子表集合
		List<HisChargeIfaceDTO> chargeList = new ArrayList<HisChargeIfaceDTO>();
		// 4.删除已存在的导入数据如不需要注释本行即可
		setDelDataByDate(nowDateTime);
		// 5.获取IIH中定位日期的结算数据并填充到主子表集合中
		setIIHList(sqlStrList, nowDateTime, batchList, chargeList);
		// 6.获取合并数据表中最大值ID
		Integer maxID = getMaxIfaceid("CUX_GL_HIS_BATCH_IFACE") + 1;
		// 7.获取HIS表中集合数据并组装到SQL集合中
		maxID = setIIHListByEBS(sqlStrList, getEBSBatchDTOs(nowDateTime), getEBSChargeDTOs(nowDateTime), maxID);
		// 8.将本系统查出结算数据组装到SQL集合中
		setIIHListByEBS(sqlStrList, batchList, chargeList, maxID);
		saveBatchData(sqlStrList);
	}

	/**
	 * 删除对应日期已导入数据
	 * 
	 * @param sqlStrList
	 * @param nowDateTime
	 * @throws BizException
	 */
	private void setDelDataByDate(FDateTime nowDateTime) throws BizException {
		List<String> sqlStrList = new ArrayList<String>();
		sqlStrList.add("DELETE IIH_GL_HIS_BATCH_IFACE WHERE SYNC_DATE='" + new SimpleDateFormat("yyyy/MM/dd").format(nowDateTime.getDate().toDate()) + "'");
		sqlStrList.add("DELETE IIH_GL_HIS_CHARGE_IFACE WHERE SYNC_DATE='" + new SimpleDateFormat("yyyy/MM/dd").format(nowDateTime.getDate().toDate()) + "'");
		sqlStrList.add("DELETE CUX_GL_HIS_BATCH_IFACE WHERE SYNC_DATE='" + new SimpleDateFormat("yyyy/MM/dd").format(nowDateTime.getDate().toDate()) + "'");
		sqlStrList.add("DELETE CUX_GL_HIS_CHARGE_IFACE WHERE SYNC_DATE='" + new SimpleDateFormat("yyyy/MM/dd").format(nowDateTime.getDate().toDate()) + "'");
		saveBatchData(sqlStrList);
	}

	/**
	 * 获取IIH结算数据
	 * 
	 * @param 执行导入SQL集合
	 * @param 执行日期
	 * @param 主数据集合
	 * @param 自数据集合
	 * @return
	 * @throws BizException
	 */
	private Integer setIIHList(List<String> sqlStrList, FDateTime nowDateTime, List<HisBatchIfaceDTO> batchList, List<HisChargeIfaceDTO> chargeList) throws BizException {
		// 1.获取当前最大数据编号
		Integer maxID = getMaxIfaceid("IIH_GL_HIS_BATCH_IFACE") + 1;
		// 2.获取导入规则BP
		GetBatchIfaceDTOsBP bibp = new GetBatchIfaceDTOsBP();
		// 3.获取导入规则数组集合
		HisBatchIfaceDTO[] hisBatchIfaceDTOs = bibp.exec();
		// 4.循环并通过规则ID 获取对应的子集合
		for (HisBatchIfaceDTO hisBatchIfaceDTO : hisBatchIfaceDTOs) {
			// 5.设置导入日期
			hisBatchIfaceDTO.setSync_date(nowDateTime);
			// 6.设置描述并替换占位符赋值日期
			hisBatchIfaceDTO.setDescription(hisBatchIfaceDTO.getDescription().replace("[NowDate]", new SimpleDateFormat("yyyy/MM/dd").format(nowDateTime.getDate().toDate())));
			// 7.获取对应类别的结算数据
			HisChargeIfaceDTO[] retValue = (HisChargeIfaceDTO[]) AppFwUtil.getDORstWithDao(new GetChargeIfaceDTOQty(hisBatchIfaceDTO.getIface_batch_id(), nowDateTime.getDate(), maxID),
					HisChargeIfaceDTO.class);
			// 8.循环结算数据并填充到结算子集合中
			for (HisChargeIfaceDTO hisChargeIfaceDTO : retValue) {
				hisChargeIfaceDTO.setSync_date(nowDateTime);
				// 9.填充SQL执行集合
				sqlStrList.add(GetChargeInsertSql(hisChargeIfaceDTO, "IIH_GL_HIS_CHARGE_IFACE"));
				// 10.填充结算子集合
				chargeList.add(hisChargeIfaceDTO);
			}
			// 11.重新赋值主表主键值
			hisBatchIfaceDTO.setIface_batch_id(maxID);
			// 12.主键值+1位下一条主键做准备
			maxID++;
			// 13.填充SQL执行集合
			sqlStrList.add(GetBatchInsertSql(hisBatchIfaceDTO, "IIH_GL_HIS_BATCH_IFACE"));
			// 14.填充导入数据主表
			batchList.add(hisBatchIfaceDTO);
		}
		return maxID;
	}

	/**
	 * 将集合数据转化为SQL添加到执行SQL集合中
	 * 
	 * @param SQL集合
	 * @param EBS导入表主表
	 * @param EBS导入表子表
	 * @param maxID
	 * @return
	 * @throws BizException
	 */

	private Integer setIIHListByEBS(List<String> sqlStrList, List<HisBatchIfaceDTO> ebsBatchDtos, List<HisChargeIfaceDTO> ebsChargeDtos, Integer maxID) throws BizException {
		// 1.循环导入主数据集合
		for (HisBatchIfaceDTO hisBatchIfaceDTO : ebsBatchDtos) {
			// 1.1循环导入自数据集合
			for (HisChargeIfaceDTO hisChargeIfaceDTO : ebsChargeDtos) {
				// 1.2 匹配相同主键数据，并替换主键值填充到SQL集合中
				if (hisBatchIfaceDTO.getIface_batch_id().equals(hisChargeIfaceDTO.getIface_batch_id())) {
					hisChargeIfaceDTO.setIface_batch_id(maxID);
					sqlStrList.add(GetChargeInsertSql(hisChargeIfaceDTO, "CUX_GL_HIS_CHARGE_IFACE"));
				}
			}
			// 2.重新赋值主键
			hisBatchIfaceDTO.setIface_batch_id(maxID);
			// 3.添加SQL集合
			sqlStrList.add(GetBatchInsertSql(hisBatchIfaceDTO, "CUX_GL_HIS_BATCH_IFACE"));
			maxID++;
		}

		return maxID;
	}

	/**
	 * 获取HIS 对应日期导入的主表数据
	 * 
	 * @param 对应日期
	 * @return
	 * @throws BizException
	 */

	@SuppressWarnings("unchecked")
	private List<HisBatchIfaceDTO> getEBSBatchDTOs(FDateTime nowDateTime) throws BizException {
		List<HisBatchIfaceDTO> ebsBatchDtos = new ArrayList<HisBatchIfaceDTO>();
		PersistMgr persist = null;
		PersistSession session = null;
		try {
			EBSDATANAME=getDataBase();
			persist = (PersistMgr) PersistMgr.getInstance(EBSDATANAME);
			session = persist.getPersistSession();
			// 执行获取数据sql 并转为数据集合
			ebsBatchDtos = (List<HisBatchIfaceDTO>) session.execQuery(
					"SELECT * FROM HIS_GL_HIS_BATCH_IFACE where SYNC_DATE='" + new SimpleDateFormat("yyyy/MM/dd").format(nowDateTime.getDate().toDate()) + "'", new BeanListHandler(
							HisBatchIfaceDTO.class));

		} catch (DbException e) {
			Logger.error(e.getMessage(), e);
			throw new PreAlertException(e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
		return ebsBatchDtos;
	}

	/**
	 * 获取HIS 对应日期导入的子表数据
	 * 
	 * @param 对应日期
	 * @return
	 * @throws BizException
	 */

	@SuppressWarnings("unchecked")
	private List<HisChargeIfaceDTO> getEBSChargeDTOs(FDateTime nowDateTime) throws BizException {
		List<HisChargeIfaceDTO> ebsChargeDtos = new ArrayList<HisChargeIfaceDTO>();
		PersistMgr persist = null;
		PersistSession session = null;
		try {
			EBSDATANAME=getDataBase();
			persist = (PersistMgr) PersistMgr.getInstance(EBSDATANAME);
			session = persist.getPersistSession();
			// 执行获取数据sql 并转为数据集合
			ebsChargeDtos = (List<HisChargeIfaceDTO>) session.execQuery(
					"SELECT * FROM HIS_GL_HIS_CHARGE_IFACE where SYNC_DATE='" + new SimpleDateFormat("yyyy/MM/dd").format(nowDateTime.getDate().toDate()) + "'", new BeanListHandler(
							HisChargeIfaceDTO.class));

		} catch (DbException e) {
			Logger.error(e.getMessage(), e);
			throw new PreAlertException(e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
		return ebsChargeDtos;
	}

	/**
	 * 执行数据操作
	 * 
	 * @param SQL语句集合
	 * @throws BizException
	 */

	private void saveBatchData(List<String> sqlStrList) throws BizException {
		if (sqlStrList != null && sqlStrList.size() != 0) {
			PersistMgr persist = null;
			PersistSession session = null;
			try {
				EBSDATANAME=getDataBase();
				persist = (PersistMgr) PersistMgr.getInstance(EBSDATANAME);
				session = persist.getPersistSession();
				session.setAddTimeStamp(false);
				session.setSQLTranslator(false);
				// 循环添加SQL语句
				for (String insetSql : sqlStrList) {
					session.addBatch(insetSql);
				}
				session.execBatch();

			} catch (DbException e) {
				Logger.error(e.getMessage(), e);
				throw new PreAlertException(e.getMessage());
			} finally {
				if (session != null)
					session.closeAll();

				if (persist != null)
					persist.release();
			}
		}
	}

	/**
	 * 将EBS主表转为INSERT语句
	 * 
	 * @param EBS主表
	 * @param 对应数据库表名称
	 * @return
	 */

	private String GetBatchInsertSql(HisBatchIfaceDTO batch, String tableName) {
		StringBuffer keysb = new StringBuffer();
		StringBuffer valsb = new StringBuffer();
		if (batch.getIface_batch_id() != null) {
			keysb.append(getString(keysb) + "IFACE_BATCH_ID");
			valsb.append(getString(valsb) + "'" + batch.getIface_batch_id() + "'");
		}
		if (batch.getHospital_code() != null) {
			keysb.append(getString(keysb) + "HOSPITAL_CODE");
			valsb.append(getString(valsb) + "'" + batch.getHospital_code() + "'");
		}
		if (batch.getBatch_type() != null) {
			keysb.append(getString(keysb) + "BATCH_TYPE");
			valsb.append(getString(valsb) + "'" + batch.getBatch_type() + "'");
		}
		if (batch.getSync_date() != null) {
			keysb.append(getString(keysb) + "SYNC_DATE");
			valsb.append(getString(valsb) + "'" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(batch.getSync_date().getDate().toDate()) + "'");
		}
		if (batch.getProcess_flag() != null) {
			keysb.append(getString(keysb) + "PROCESS_FLAG");
			valsb.append(getString(valsb) + "'" + batch.getProcess_flag() + "'");
		}
		if (batch.getDescription() != null) {
			keysb.append(getString(keysb) + "DESCRIPTION");
			valsb.append(getString(valsb) + "'" + batch.getDescription() + "'");
		}
		keysb.append(")");
		valsb.append(")");
		return ("INSERT INTO " + tableName + keysb.toString() + " VALUES " + valsb.toString());
	}

	/**
	 * 根据数据值返回对应拼装符号
	 * 
	 * @param sb
	 * @return
	 */

	private String getString(StringBuffer sb) {
		if (sb.toString().length() != 0)
			return ",";
		return "(";
	}

	/**
	 * 将EBS子表转为INSERT语句
	 * 
	 * @param EBS子表
	 * @param 对应数据库表名称
	 * @return
	 */

	private String GetChargeInsertSql(HisChargeIfaceDTO charge, String tableName) {
		StringBuffer keysb = new StringBuffer();
		StringBuffer valsb = new StringBuffer();
		// [IFACE_BATCH_ID]
		if (charge.getIface_batch_id() != null) {
			keysb.append(getString(keysb) + "IFACE_BATCH_ID");
			valsb.append(getString(valsb) + "'" + charge.getIface_batch_id() + "'");
		}
		// ,[LINE_NUM]
		if (charge.getLine_num() != null) {
			keysb.append(getString(keysb) + "LINE_NUM");
			valsb.append(getString(valsb) + "'" + charge.getLine_num() + "'");
		}
		// ,[BUSINESS_TYPE]
		if (charge.getBusiness_type() != null) {
			keysb.append(getString(keysb) + "BUSINESS_TYPE");
			valsb.append(getString(valsb) + "'" + charge.getBusiness_type() + "'");
		}
		// ,[HOSPITAL_CODE]
		if (charge.getHospital_code() != null) {
			keysb.append(getString(keysb) + "HOSPITAL_CODE");
			valsb.append(getString(valsb) + "'" + charge.getHospital_code() + "'");
		}
		// ,[OP_IP_FLAG]
		if (charge.getOp_ip_flag() != null) {
			keysb.append(getString(keysb) + "OP_IP_FLAG");
			valsb.append(getString(valsb) + "'" + charge.getOp_ip_flag() + "'");
		}
		// ,[CHARGE_DEPT]
		if (charge.getCharge_dept() != null) {
			keysb.append(getString(keysb) + "CHARGE_DEPT");
			valsb.append(getString(valsb) + "'" + charge.getCharge_dept() + "'");
		}
		// ,[UNDER_DEPT]
		if (charge.getUnder_dept() != null) {
			keysb.append(getString(keysb) + "UNDER_DEPT");
			valsb.append(getString(valsb) + "'" + charge.getUnder_dept() + "'");
		}
		// ,[CHARGE_ITEM]
		if (charge.getCharge_item() != null) {
			keysb.append(getString(keysb) + "CHARGE_ITEM");
			valsb.append(getString(valsb) + "'" + charge.getCharge_item() + "'");
		}
		// ,[CHARGE_ITEM_NAME]
		if (charge.getCharge_item_name() != null) {
			keysb.append(getString(keysb) + "CHARGE_ITEM_NAME");
			valsb.append(getString(valsb) + "'" + charge.getCharge_item_name() + "'");
		}
		// ,[CHARGE_TYPE]
		if (charge.getCharge_type() != null) {
			keysb.append(getString(keysb) + "CHARGE_TYPE");
			valsb.append(getString(valsb) + "'" + charge.getCharge_type() + "'");
		}
		// ,[CHARGE_TYPE_NAME]
		if (charge.getCharge_type_name() != null) {
			keysb.append(getString(keysb) + "CHARGE_TYPE_NAME");
			valsb.append(getString(valsb) + "'" + charge.getCharge_type_name() + "'");
		}
		// ,[AMOUNT]
		if (charge.getAmount() != null) {
			keysb.append(getString(keysb) + "AMOUNT");
			valsb.append(getString(valsb) + "'" + charge.getAmount() + "'");
		}
		// ,[OPERATING_DATE]
		if (charge.getOperating_date() != null) {
			keysb.append(getString(keysb) + "OPERATING_DATE");
			valsb.append(getString(valsb) + "'" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(charge.getOperating_date().getDate().toDate()) + "'");
		}
		// ,[RECEIVABLE_COMP_NAME]
		if (charge.getReceivable_comp_name() != null) {
			keysb.append(getString(keysb) + "RECEIVABLE_COMP_NAME");
			valsb.append(getString(valsb) + "'" + charge.getReceivable_comp_name() + "'");
		}
		// ,[RECEIVABLE_COMP]
		if (charge.getReceivable_comp() != null) {
			keysb.append(getString(keysb) + "RECEIVABLE_COMP");
			valsb.append(getString(valsb) + "'" + charge.getReceivable_comp() + "'");
		}
		// ,[SYNC_DATE]
		if (charge.getSync_date() != null) {
			keysb.append(getString(keysb) + "SYNC_DATE");
			valsb.append(getString(valsb) + "'" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(charge.getSync_date().getDate().toDate()) + "'");
		}
		// ,[CHARGE_DEPT_NAME]
		if (charge.getCharge_dept_name() != null) {
			keysb.append(getString(keysb) + "CHARGE_DEPT_NAME");
			valsb.append(getString(valsb) + "'" + charge.getCharge_dept_name() + "'");
		}
		// ,[UNDER_DEPT_NAME]
		if (charge.getUnder_dept_name() != null) {
			keysb.append(getString(keysb) + "UNDER_DEPT_NAME");
			valsb.append(getString(valsb) + "'" + charge.getUnder_dept_name() + "'");
		}
		// ,[PROCESS_FLAG]
		if (charge.getProcess_flag() != null) {
			keysb.append(getString(keysb) + "PROCESS_FLAG");
			valsb.append(getString(valsb) + "'" + charge.getProcess_flag() + "'");
		}
		// ,[PREPAY_FLAG]
		if (charge.getPrepay_flag() != null) {
			keysb.append(getString(keysb) + "PREPAY_FLAG");
			valsb.append(getString(valsb) + "'" + charge.getPrepay_flag() + "'");
		}
		// ,[RECEIVABLE_FLAG]
		if (charge.getReceivable_flag() != null) {
			keysb.append(getString(keysb) + "RECEIVABLE_FLAG");
			valsb.append(getString(valsb) + "'" + charge.getReceivable_flag() + "'");
		}
		// ,[DESCRIPTION]
		if (charge.getDescription() != null) {
			keysb.append(getString(keysb) + "DESCRIPTION");
			valsb.append(getString(valsb) + "'" + charge.getDescription() + "'");
		}

		// ,[RECEIVABLE_FLAG]
		if (charge.getExecute_dept() != null) {
			keysb.append(getString(keysb) + "EXECUTE_DEPT");
			valsb.append(getString(valsb) + "'" + charge.getExecute_dept() + "'");
		}
		// ,[DESCRIPTION]
		if (charge.getExecute_dept_name() != null) {
			keysb.append(getString(keysb) + "EXECUTE_DEPT_NAME");
			valsb.append(getString(valsb) + "'" + charge.getExecute_dept_name() + "'");
		}
		keysb.append(")");
		valsb.append(")");
		return ("INSERT INTO " + tableName + keysb.toString() + " VALUES " + valsb.toString());
	}

	/**
	 * 获取当前最大编号
	 * 
	 * @param 表名
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Integer getMaxIfaceid(String tableName) throws BizException {
		Integer retInt = 0;
		PersistMgr persist = null;
		PersistSession session = null;
		try {
			EBSDATANAME=getDataBase();
			persist = (PersistMgr) PersistMgr.getInstance(EBSDATANAME);
			session = persist.getPersistSession();
			Map<String, Object> retVal = (Map<String, Object>) session.execQuery("SELECT MAX(IFACE_BATCH_ID) MAXID FROM " + tableName, new MapHandler());
			if (retVal.get("maxid") != null) {
				retInt = Integer.parseInt(retVal.get("maxid") + "");
			}
		} catch (DbException e) {
			Logger.error(e.getMessage(), e);
			throw new PreAlertException(e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
		return retInt;
	}
	
	/**
	 * 根据参数获取数据库名
	 * 
	 * @param sb
	 * @return
	 */

	private String getDataBase() throws BizException {
		return ParamsetQryUtil.getParaString(IOrgConst.GLOBEORG, "ebsdatasource");
	}
}
