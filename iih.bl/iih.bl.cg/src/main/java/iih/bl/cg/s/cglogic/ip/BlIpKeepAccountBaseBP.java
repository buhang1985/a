package iih.bl.cg.s.cglogic.ip;

import iih.bd.base.utils.MapUtils;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.s.cglogic.other.BlCgAccDataWarehouse;
import iih.bl.cg.s.cglogic.other.BlCgAccErrorCollector;
import iih.bl.cg.s.cglogic.util.BlCgDataUtil;
import iih.bl.cg.s.cglogic.validator.BlCgAccAbleValidator;
import iih.bl.comm.util.BlPeCmpyUtil;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.d.EnPeCmpyACCDO;
import iih.en.pv.enfee.i.IEnaccountMDOCudService;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import iih.en.pv.enfee.i.IEnpecmpyaccCudService;
import iih.en.pv.inpatient.d.NewbornDO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/**
 * 住院记账base类
 * 记账退记账公用处理
 * @author ly 2018/08/07
 *
 */
public class BlIpKeepAccountBaseBP {

	// 记账数据仓库
	protected BlCgAccDataWarehouse dataWh;

	// 错误信息收集器
	protected BlCgAccErrorCollector errClctor;

	// 就诊id
	protected List<String> enList = new ArrayList<String>();
	
	// 流程是否到了保存-->不抛异常模式下，如果保存发生异常，照样抛异常
	protected boolean saveOper = false; 
	
	/**
	 * 查询就诊关联的数据 用于校验等
	 * @throws BizException
	 */
	protected void queryEnRelatedData() throws BizException {

		// 获取新生儿数据
		this.dataWh.setNbList(BlCgDataUtil.getNbData(this.enList.toArray(new String[0])));

		String[] entArr = null;
		// 母婴合并时，需要查询母亲信息
		if (FBoolean.TRUE.equals(this.dataWh.getFgCombineMomBaby())) {

			if (ListUtil.isEmpty(this.dataWh.getNbList())) {
				entArr = this.enList.toArray(new String[0]);
			} else {
				List<String> newEnList = new ArrayList<String>();
				newEnList.addAll(this.enList);
				for (NewbornDO nbDO : this.dataWh.getNbList()) {
					if (!newEnList.contains(nbDO.getId_ent_mom())) {
						newEnList.add(nbDO.getId_ent_mom());
					}
				}
				entArr = newEnList.toArray(new String[0]);
			}
		} else {
			entArr = this.enList.toArray(new String[0]);
		}

		// 获取就诊,账户数据,费用审核数据
		this.dataWh.setEnList(BlCgDataUtil.getEnData(entArr));
		this.dataWh.setAccList(BlCgDataUtil.getEnAccData(entArr));
		this.dataWh.setBalanceList(BlCgDataUtil.getBalanceData(entArr));
		this.dataWh.setAuditList(BlCgDataUtil.getAuditData(entArr));

		// 处理母婴账户
		this.dataWh.handleMomBabyAcc();

		// 获取团检数据
		Map<String, String> entPeMap = BlPeCmpyUtil.getEntsIsPecmpy(entArr);// 就诊与团检关系
		List<String> peIdList = new ArrayList<String>();
		if (entPeMap != null) {
			for (String key : entPeMap.keySet()) {
				String peId = entPeMap.get(key);
				if (!peIdList.contains(peId)) {
					peIdList.add(peId);
				}
			}
		}

		String[] peIds = peIdList.toArray(new String[0]);
		// 获取团检账户,团检金额数据
		this.dataWh.setPeaccList(BlCgDataUtil.getPecmpyAccData(peIds));
		this.dataWh.setPebalanceList(BlCgDataUtil.getPeBalanceData(peIds));
		this.dataWh.setEntPeMap(entPeMap);
	}

	/**
	 * 可进行费用操作校验
	 * @return
	 * @throws BizException
	 */
	protected boolean checkAccAble() throws BizException {
		
		BlCgAccAbleValidator validator = new BlCgAccAbleValidator();
		for (String entId : this.enList) {
			try {
				validator.validate(this.dataWh.getEnMap().get(entId),
						this.dataWh.getAccMap().get(entId), 
						this.dataWh.getAuditMap().get(entId),
						this.dataWh.getFgCanAccWhenAudit());
			} catch (BizException e) {
				this.errClctor.collect(entId, false, e);
			}
		}

		this.errClctor.filterEnOrPatList(this.enList);
		return this.enList.size() > 0;
	}
	
	/**
	 * 回写账户金额
	 * 
	 * @throws BizException
	 */
	protected void writebackAccount() throws BizException {
		
		// 更新个人账户
		this.updatePersonalAccNew();
		
		// 更新团体账户
		List<EnPeCmpyACCDO> peAccList = new ArrayList<EnPeCmpyACCDO>();
		for (String key : this.dataWh.getGroupConsumeMap().keySet()) {
			
			FDouble amt = this.dataWh.getGroupConsumeMap().get(key);
			EnPeCmpyACCDO acc = this.dataWh.getPeaccMap().get(this.dataWh.getEntPeMap().get(key));
			
			acc.setStatus(DOStatus.UPDATED);
			acc.setAmt_uncg(acc.getAmt_uncg().add(amt));
			if(!peAccList.contains(acc)){
				peAccList.add(acc);
			}
		}
		
		if(peAccList.size() > 0){
			IEnpecmpyaccCudService peaccCrudService = ServiceFinder.
					find(IEnpecmpyaccCudService.class);
			peaccCrudService.update(peAccList.toArray(new EnPeCmpyACCDO[0]));
		}
	}

	/**
	 * 设置返回值
	 * 
	 * @param dos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected BlCgAccountRltDTO setRtnValue(BlCgIpDO[] dos) throws BizException {

		BlCgAccountRltDTO rltDto = new BlCgAccountRltDTO();
		rltDto.setFg_success(FBoolean.TRUE);

		FArrayList cgList = new FArrayList();
		cgList.addAll(Arrays.asList(dos));
		rltDto.setCglist(cgList);

		FArrayList errList = new FArrayList();
		errList.addAll(this.errClctor.getFailRltList());

		rltDto.setError_entlist(errList);

		return rltDto;
	}

	/**
	 * 发送事件
	 * @param dos
	 * @param charge
	 * @throws BizException
	 */
	protected void invokeEvent(BlCgIpDO[] dos, boolean charge) throws BizException {
		
		String eventType = charge ? IBlEventConst.EVENT_TYPE_IPCG_CHARGE : IBlEventConst.EVENT_TYPE_IPCG_REFUND;
		BusinessEvent event = new BusinessEvent(
				IBlEventConst.EVENT_SOURCE_IPCG, eventType, dos);		
		EventDispatcher.fireEvent(event);
	}
	
	/**
	 * 更新个人账户
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private void updatePersonalAcc() throws BizException {
		
		Set<String> lockKeyList = new HashSet<String>();
		Set<String> accIdList = new HashSet<String>(0);
		for (String key : this.dataWh.getPersonalConsumeMap().keySet()) {
			EnAccountDO acc = this.dataWh.getAccMap().get(key);
			String lockKey = acc.getId_ent() + acc.getId_entacc();
			lockKeyList.add(lockKey);
			accIdList.add(acc.getId_entacc());
		}

		if (accIdList.size() == 0)
			return;
		
		//加锁
		boolean lock = PKLock.getInstance().addBatchDynamicLock(lockKeyList.toArray(new String[0]), 5 * 1000);
		if(!lock){
			throw new BizException("当前EN_ENT_ACC数据正在被他人修改，请刷新重试:" + accIdList.toArray(new String[0])[0]);
		}
		
		//重新检索账户
		IEnaccountMDORService rService = ServiceFinder.find(IEnaccountMDORService.class);
		EnAccountDO[] accDos = rService.findByIds(accIdList.toArray(new String[0]), FBoolean.FALSE);
		Map<String,EnAccountDO> accMap = (Map<String,EnAccountDO>)MapUtils.convertArrayToMap(accDos, EnAccountDO.ID_ENTACC);
		
		List<EnAccountDO> accList = new ArrayList<EnAccountDO>();
		for (String key : this.dataWh.getPersonalConsumeMap().keySet()) {

			FDouble amt = this.dataWh.getPersonalConsumeMap().get(key);
			EnAccountDO oldAcc = this.dataWh.getAccMap().get(key);
			EnAccountDO newAcc = accMap.get(oldAcc.getId_entacc());
			
			newAcc.setStatus(DOStatus.UPDATED);
			newAcc.setAmt_uncg(newAcc.getAmt_uncg().add(amt));

			if (!accList.contains(newAcc)) {
				accList.add(newAcc);
			}
		}
		
		if(accList.size() > 0){
			IEnaccountMDOCudService enaccCrudService = ServiceFinder.find(IEnaccountMDOCudService.class);
			enaccCrudService.update(accList.toArray(new EnAccountDO[0]));
		}
	}

	/**
	 * 更新账户新
	 * @throws BizException
	 */
	private void updatePersonalAccNew() throws BizException {
		
		Set<String> lockKeyList = new HashSet<String>();
		Set<String> accIdList = new HashSet<String>();
		
		for (String key : this.dataWh.getPersonalConsumeMap().keySet()) {
			EnAccountDO acc = this.dataWh.getAccMap().get(key);
			String lockKey = acc.getId_ent() + acc.getId_entacc();
			lockKeyList.add(lockKey);
			accIdList.add(acc.getId_entacc());
		}

		if (accIdList.size() == 0)
			return;
		
		//加锁
		boolean lock = PKLock.getInstance().addBatchDynamicLock(lockKeyList.toArray(new String[0]), 5 * 1000);
		if(!lock){
			throw new BizException("当前EN_ENT_ACC数据正在被他人修改，请刷新重试:" + accIdList.toArray(new String[0])[0]);
		}
		
		String sqlTemp = "update en_ent_acc set amt_uncg = amt_uncg + (?),amt_total = nvl(amt_total,0) + (?) where id_entacc = ? ";
		PersistMgr persist = null;
		PersistSession session = null;
		
		try {
			
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			
			for (String key : this.dataWh.getPersonalConsumeMap().keySet()) {
				FDouble amt = this.dataWh.getPersonalConsumeMap().get(key);
				EnAccountDO acc = this.dataWh.getAccMap().get(key);
				
				SqlParam param = new SqlParam();
				param.addParam(amt);
				param.addParam(amt);
				param.addParam(acc.getId_entacc());
				session.addBatch(sqlTemp, param);
			}
			session.execBatch();
		} catch (Exception e) {
			throw new BizException("更新账户异常，失败原因为："+e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
	}
}
