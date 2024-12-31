package iih.bl.inc.s.ep;

import org.springframework.transaction.TransactionStatus;

import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.blecinctrans.d.BlEcIncTransDO;
import iih.bl.inc.blecinctrans.d.EcIncTransStateEnum;
import iih.bl.inc.blecinctrans.i.IBlecinctransCudService;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 电子票据交易记录EP
 * @author ly 2019/12/16
 *
 */
public class BlEcIncTransEP {

	private IBlecinctransCudService cudService = ServiceFinder.find(IBlecinctransCudService.class);
	
	/**
	 * 创建默认交易记录数据
	 * @return
	 * @throws BizException
	 * @author ly 2019/12/16
	 */
	public BlEcIncTransDO createNewTransDO() throws BizException{
		BlEcIncTransDO transDO = new BlEcIncTransDO();
		transDO.setId_grp(Context.get().getGroupId());
		transDO.setId_org(Context.get().getOrgId());
		transDO.setEu_transstatus(EcIncTransStateEnum.FALI);
		transDO.setFg_active(FBoolean.TRUE);
		transDO.setId_emp_oper(Context.get().getStuffId());
		transDO.setId_dep_oper(Context.get().getDeptId());
		transDO.setDt_oper(BlFlowContextUtil.getNowTime());
		transDO.setId_pc(BlParams.getRealPcId(Context.get().getClientHost()));
		transDO.setStatus(DOStatus.NEW);
		return transDO;
	}
	
	/**
	 * 插入新建交易记录
	 * @param incTransDO
	 * @return
	 * @throws BizException
	 */
	public BlEcIncTransDO insertNewTransDO(BlEcIncTransDO incTransDO)  throws BizException{
		
		final IBlecinctransCudService fCudService = cudService;
		final BlEcIncTransDO fTransDO = incTransDO;
		
		BlEcIncTransDO newTransDO = TransactionExecutor.executeNewTransaction(new TransactionalOperation<BlEcIncTransDO>() {
			@Override
			public BlEcIncTransDO doInTransaction(TransactionStatus arg0){
				try {
					return fCudService.insert(new BlEcIncTransDO[]{fTransDO})[0];
				} catch (BizException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		 });
		
		return newTransDO;
	}
	
	/**
	 * 更新成功状态
	 * @param incTransDO
	 * @throws BizException
	 * @author ly 2019/12/16
	 */
	public void updateSuccess(BlEcIncTransDO incTransDO) throws BizException{
		
		final IBlecinctransCudService fCudService = cudService;
		final BlEcIncTransDO fTransDO = incTransDO;
		
		TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@Override
			public String doInTransaction(TransactionStatus arg0) {
				try {
					fTransDO.setEu_transstatus(EcIncTransStateEnum.SUCCESS);
					fTransDO.setStatus(DOStatus.UPDATED);
					fCudService.update(new BlEcIncTransDO[] { fTransDO });
					return null;
				} catch (BizException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		});
	}
	
	/**
	 * 更新失败状态
	 * @param incTransDO
	 * @throws BizException
	 * @author ly 2019/12/16
	 */
	public void updateFail(BlEcIncTransDO incTransDO) throws BizException{
		
		final IBlecinctransCudService fCudService = cudService;
		final BlEcIncTransDO fTransDO = incTransDO;
		
		TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@Override
			public String doInTransaction(TransactionStatus arg0){
				try {
					fTransDO.setEu_transstatus(EcIncTransStateEnum.FALI);
					fTransDO.setStatus(DOStatus.UPDATED);
					fCudService.update(new BlEcIncTransDO[] { fTransDO });
					return null;
				} catch (BizException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		 });
	}
}
