package iih.bd.srv.srvpricetable.s.bp;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.time.StopWatch;

import com.alibaba.fastjson.JSON;

import iih.bd.utils.log.BdSrvPriceTableUpdateLogUtils;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 刷新基础数据服务价格表基础逻辑
 * 
 * @author hao_wu
 * @date 2020年4月27日
 *
 */
public abstract class BdSrvPriceTableUpdateBaseBp {

	protected DAFacade daFacade = null;

	public BdSrvPriceTableUpdateBaseBp() {
		this.daFacade = new DAFacade();
	}

	public void exec(String condType, String[] condValues) throws BizException {
		String[] allowCondTypes = this.getAllowCondTypes();
		if (ArrayUtils.contains(allowCondTypes, condType)) {
			update(condType, condValues);
		}

		updateNext(condType, condValues);
	}

	public void updateNext(String condType, String[] condValues) throws BizException {
		BdSrvPriceTableUpdateBaseBp nextBp = getNextBp();
		if (nextBp != null) {
			nextBp.exec(condType, condValues);
		}
	}

	public void update(String condType, String[] condValues) throws BizException {
		writeLogOnStartUpdate(condType, condValues);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		delete(condType, condValues);

		insert(condType, condValues);

		stopWatch.stop();
		writeLogOnEndUpdate(condType, condValues, stopWatch.toString());
	}

	public void insert(String condType, String[] condValues) throws BizException {
		writeLogOnStartInsert(condType, condValues);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		ITransQry insertQry = getInsertQry(condType, condValues);
		if (insertQry != null) {
			int rowCount = daFacade.execUpdate(insertQry.getQrySQLStr(), insertQry.getQryParameter(null));
			stopWatch.stop();
			writeLogOnEndInsert(condType, condValues, rowCount, stopWatch.toString());
		}
	}

	public void delete(String condType, String[] condValues) throws BizException {
		writeLogOnStartDelete(condType, condValues);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		ITransQry deleteQry = getDeleteQry(condType, condValues);
		if (deleteQry != null) {
			int rowCount = daFacade.execUpdate(deleteQry.getQrySQLStr(), deleteQry.getQryParameter(null));
			stopWatch.stop();
			writeLogOnEndDelete(condType, condValues, rowCount, stopWatch.toString());
		}
	}

	/**
	 * 开始更新时写日志
	 * 
	 * @param condType
	 * @param condValues
	 */
	private void writeLogOnStartUpdate(String condType, String[] condValues) {
		BdSrvPriceTableUpdateLogUtils.info("开始更新%s,condType:%s,condValues:%s。", this.getUpdateTable(), condType,
				JSON.toJSONString(condValues));
	}

	/**
	 * 更新完成时写日志
	 * 
	 * @param condType
	 * @param condValues
	 */
	private void writeLogOnEndUpdate(String condType, String[] condValues, String time) {
		BdSrvPriceTableUpdateLogUtils.info("更新%s完成,condType:%s,condValues:%s,耗时:%sms。", this.getUpdateTable(), condType,
				JSON.toJSONString(condValues), time);
	}

	/**
	 * 开始生成时写日志
	 * 
	 * @param condType
	 * @param condValues
	 */
	private void writeLogOnStartInsert(String condType, String[] condValues) {
		BdSrvPriceTableUpdateLogUtils.info("开始生成%s,condType:%s,condValues:%s。", this.getUpdateTable(), condType,
				JSON.toJSONString(condValues));

	}

	/**
	 * 生成完成时写日志
	 * 
	 * @param condType
	 * @param condValues
	 * @param rowCount
	 */
	private void writeLogOnEndInsert(String condType, String[] condValues, int rowCount, String time) {
		BdSrvPriceTableUpdateLogUtils.info("生成%s完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", this.getUpdateTable(),
				condType, JSON.toJSONString(condValues), rowCount, time);
	}

	/**
	 * 开始删除时写日志
	 * 
	 * @param condType
	 * @param condValues
	 */
	private void writeLogOnStartDelete(String condType, String[] condValues) {
		BdSrvPriceTableUpdateLogUtils.info("开始删除%s,condType:%s,condValues:%s。", this.getUpdateTable(), condType,
				JSON.toJSONString(condValues));
	}

	/**
	 * 删除完成时写日志
	 * 
	 * @param condType
	 * @param condValues
	 * @param rowCount
	 */
	private void writeLogOnEndDelete(String condType, String[] condValues, int rowCount, String time) {
		BdSrvPriceTableUpdateLogUtils.info("删除%s完成,condType:%s,condValues:%s,条数:%s,耗时:%sms。", this.getUpdateTable(),
				condType, JSON.toJSONString(condValues), rowCount, time);
	}

	/**
	 * 获取更新的表名
	 * 
	 * @return
	 */
	public abstract String getUpdateTable();

	/**
	 * 获取允许处理的条件类型
	 * 
	 * @return
	 */
	public abstract String[] getAllowCondTypes();

	/**
	 * 获取下一个需要更新的BP
	 * 
	 * @return
	 */
	public abstract BdSrvPriceTableUpdateBaseBp getNextBp();

	/**
	 * 获取查询数据的Qry
	 * 
	 * @param condType
	 * @param condValues
	 * @return
	 */
	public abstract ITransQry getInsertQry(String condType, String[] condValues);

	/**
	 * 获取删除数据的Qry
	 * 
	 * @param condType
	 * @param condValues
	 * @return
	 */
	public abstract ITransQry getDeleteQry(String condType, String[] condValues);
}
