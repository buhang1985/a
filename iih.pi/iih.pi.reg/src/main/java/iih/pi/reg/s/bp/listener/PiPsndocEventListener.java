package iih.pi.reg.s.bp.listener;

import iih.pi.params.PiParams;
import iih.pi.reg.s.bp.PiSyncFromPsnBP;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.d.PsndocAggDO;

/**
 * 
 * 人员信息变化监听
 * (同步人员信息到患者中)
 * @author ly 2019/04/22
 *
 */
public class PiPsndocEventListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
	
		BDCommonEvent bdcEvent = (BDCommonEvent) event;
		
		if (StringUtils.isEmpty(bdcEvent.getEventType())) {
			return;
		}
		
		PsnDocDO[] psnDocDos = null;
		if(PsndocAggDO.class.getName().equals(bdcEvent.getSourceID())){
			
			List<PsnDocDO> psnDocList = new ArrayList<PsnDocDO>();
			PsndocAggDO[] psnAggDos = (PsndocAggDO[])bdcEvent.getNewObjs();
			for (PsndocAggDO psnAggDO : psnAggDos) {
				psnDocList.add(psnAggDO.getParentDO());
			}
			psnDocDos = psnDocList.toArray(new PsnDocDO[0]);
		}else if(PsnDocDO.class.getName().equals(bdcEvent.getSourceID())){
			psnDocDos = (PsnDocDO[])bdcEvent.getNewObjs();
		}
		
		if(ArrayUtil.isEmpty(psnDocDos))
			return;
		
		PiParams piParams = new PiParams();
		FBoolean fgSync = piParams.PIPAT0029();
		if(FBoolean.FALSE.equals(fgSync))
			return;
		
		PiSyncFromPsnBP bp = new PiSyncFromPsnBP();
		
		switch (event.getEventType()) {
		case IEventType.TYPE_INSERT_AFTER:
			bp.insert(psnDocDos);
			break;
		case IEventType.TYPE_UPDATE_AFTER:
			bp.update(psnDocDos);
			break;
		default:
			break;
		}
	}
}
