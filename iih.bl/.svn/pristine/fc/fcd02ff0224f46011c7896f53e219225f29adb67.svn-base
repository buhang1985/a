package iih.bl.hp.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医保身份转换后更新数据
 * @author ly 2018/10/05
 *
 */
public class IpUpdteAfterChangeHpIdentityBP {

	/**
	 * 医保身份转换后更新数据
	 * @param entId 就诊id
	 * @throws BizException
	 */
	public void exec(String entId) throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			throw new ArgumentNullException("医保身份转换后更新数据", "就诊id");
		}
		
		// 查询就诊数据
		IPativisitRService enService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO enDO = enService.findById(entId);
		if(enDO == null){
			throw new BizException("医保身份转换后更新数据:未查询到就诊数据");
		}
		
		//查询未首付款结算数据
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		IBlstipCudService stCudService = ServiceFinder.find(IBlstipCudService.class);

		BlStIpDO[] stDos = stRService.find("a0.id_ent = '" + entId + "'", "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(stDos))
			return;
		
		List<BlStIpDO> stIpList = new ArrayList<BlStIpDO>();
		for (BlStIpDO stDO : stDos) {
			
			if(FBoolean.TRUE.equals(stDO.getFg_pay()))
				continue;
			
			stDO.setId_hp(enDO.getId_hp());
			stDO.setStatus(DOStatus.UPDATED);
			stIpList.add(stDO);
		}
		
		if(stIpList.size() == 0)
			return;
		
		stCudService.update(stIpList.toArray(new BlStIpDO[0]));
	}
}
