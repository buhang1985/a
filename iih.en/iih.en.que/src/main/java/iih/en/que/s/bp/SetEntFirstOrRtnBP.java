package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQueQryService;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 设置患者为初诊或回诊
 * 
 * @author liubin
 *
 */
public class SetEntFirstOrRtnBP {
	/**
	 * 设置患者为初诊或回诊
	 * 
	 * @param entId
	 * @param isFirst
	 * @throws BizException
	 */
	public void exec(String entId, FBoolean isFirst)
			throws BizException {
		//修改OP表
		OutpatientDO op = setEntOp(entId, isFirst);
		//修改QUE表
		setEntQue(entId, isFirst, op.getId_sch());
	}
	/**
	 * 修改OP表
	 * 
	 * @param entId
	 * @param isFirst
	 * @throws BizException 
	 */
	private OutpatientDO setEntOp(String entId, FBoolean isFirst) throws BizException{
		OpEP ep = new OpEP();
		OutpatientDO op = ep.getOpByEntIdWithOutRef(entId);
		if(op == null)
			throw new BizException("患者门诊就诊信息为空！");
		op.setStatus(DOStatus.UPDATED);
		if(FBoolean.TRUE.equals(isFirst))
			op.setFg_needrtn(FBoolean.FALSE);
		if(FBoolean.FALSE.equals(isFirst))
			op.setFg_needrtn(FBoolean.TRUE);
		ep.save(op);
		return op;
	}
	/**
	 * 修改QUE表
	 * 
	 * @param entId
	 * @param isFirst
	 * @throws BizException 
	 */
	private void setEntQue(String entId, FBoolean isFirst, String schId) throws BizException{
		if(!FBoolean.TRUE.equals(isFirst))
			return;
		EnQueEP ep = new EnQueEP();
		EnQueueDO[] eqs =ep.getEnQueueByEntId(entId, IBdFcDictCodeConst.SD_QUETP_EMP);
		if(EnValidator.isEmpty(eqs))
			throw new BizException("患者门诊就诊信息为空！");
		EnQueueDO enQueue = eqs[0];
		QueDO que  = getQue(schId);
		if(que != null)
			enQueue.setId_que(que.getId_que());
		enQueue.setId_que_site(null);
		enQueue.setSortno_called(null);
		enQueue.setId_emp_opreg(null);
		enQueue.setStatus(DOStatus.UPDATED);
		ep.save(new EnQueueDO[]{enQueue});
	}
	
	/**
	 * 获取队列
	 * @param scResId
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	private QueDO getQue(String schId) throws BizException{
		String sql = "SELECT SC_PL.* FROM SC_PL SC_PL INNER JOIN SC_SCH SC_SCH ON SC_PL.ID_SCPL = SC_SCH.ID_SCPL WHERE SC_SCH.ID_SCH = ? ";
		 SqlParam param = new SqlParam();
         param.addParam(schId);
		List<ScPlanDO> list = (List<ScPlanDO>) new DAFacade().execQuery(sql,param, new BeanListHandler(ScPlanDO.class));
		if(EnValidator.isEmpty(list))
			return null;
		IQueQryService queQryService = ServiceFinder.find(IQueQryService.class);
		QueDO queDO = queQryService.getQue(list.get(0).getId_scres(), list.get(0).getId_dep(), list.get(0).getId_queben(), IBdFcDictCodeConst.SD_QUETP_EMP);
		return queDO;
	}
}
