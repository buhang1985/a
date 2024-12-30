package iih.sc.sch.s.bp;

import iih.sc.comm.ScValidator;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.appfw.orm.dataaccess.TmpTableFactory;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 批量查询排班号位BP(采用临时表处理大数据)
 * 
 * @author zhengcm
 * @date 2017-06-05 15:00:29
 *
 */
public class BatchGetScTickBP {

	// 临时表查询号位数据存储List
	List<ScSchTickDO> tempTickList = new ArrayList<ScSchTickDO>();

	/**
	 * 批量查询排班号位（采用临时表处理大数据）
	 *
	 * @param tickIds
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public List<ScSchTickDO> exec(final String[] tickIds) throws BizException {
		ScValidator.validateParam("号位ID数组", tickIds);
		tempTickList = new ArrayList<ScSchTickDO>();
		// 单独创建事务，采用临时表查询数据
		TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@SuppressWarnings("unchecked")
			@Override
			public String doInTransaction(TransactionStatus status) {
				try {
					// 创建临时表
					TmpTableFactory define = new TmpTableFactory();
					String tempTable = define.get(tickIds);
					// 关联临时表
					String selectInner = String
							.format("select * from sc_tick tick inner join %s tempTable ", tempTable);
					String sql1 = selectInner + " on tick.id_tick = tempTable.id1 and tick.id_tick_occupier is null ";
					String sql2 = selectInner + " on tick.id_tick_occupier = tempTable.id1 ";
					// 查询非占用号位
					List<ScSchTickDO> tempList = (List<ScSchTickDO>) new DAFacade().execQuery(sql1, null,
							new BeanListHandler(ScSchTickDO.class));
					this.listAddData(tempTickList, tempList);
					// 查询占用号位
					tempList = (List<ScSchTickDO>) new DAFacade().execQuery(sql2, null, new BeanListHandler(
							ScSchTickDO.class));
					this.listAddData(tempTickList, tempList);
				} catch (BizException e) {
					throw new BizRuntimeException(e.getMessage());
				}
				return null;
			}

			/**
			 * 将后面List数据添加到前面List数据中（去重）
			 *
			 * @param returnList
			 * @param dataList
			 * @throws BizException
			 * @author zhengcm
			 */
			private void listAddData(List<ScSchTickDO> returnList, List<ScSchTickDO> dataList) throws BizException {
				if (dataList.isEmpty()) {
					return;
				}
				for (ScSchTickDO tickDO : dataList) {
					if (!returnList.contains(tickDO)) {
						returnList.add(tickDO);
					}
				}
			}
		});
		return tempTickList;
	}
}
