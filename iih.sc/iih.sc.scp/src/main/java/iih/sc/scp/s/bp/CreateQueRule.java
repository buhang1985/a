package iih.sc.scp.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.que.i.IQueGenService;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 生成队列规则
 * 
 * @author liubin
 *
 * @param <T>
 */
public class CreateQueRule<T> implements IRule<T> {

	private IQueGenService serv = ServiceFinder.find(IQueGenService.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public void process(T... dos) throws BizException {
		if (ArrayUtil.isEmpty(dos))
			return;
		for(T t : dos){
			if(!(t instanceof ScPlanDO))
				break;
			ScPlanDO pl = (ScPlanDO)t;
			if(IScDictCodeConst.SD_SCTP_OP.equals(pl.getSd_sctp()) || IScDictCodeConst.SD_SCTP_JZ.equals(pl.getSd_sctp())){					
				if(StringUtil.isEmptyWithTrim(pl.getId_queben())){
					throw new BizException("请返回维护计划对应的分诊台！");
				}
			}
			if(IScDictCodeConst.SD_SCTP_OP.equals(pl.getSd_sctp()) 
					|| IScDictCodeConst.SD_SCTP_MT.equals(pl.getSd_sctp())
					|| IScDictCodeConst.SD_SCTP_JZ.equals(pl.getSd_sctp())||IScDictCodeConst.SD_SCTP_OT.equals(pl.getSd_sctp()) ){
				serv.createQueueNew(pl.getId_dep(), pl.getId_scres(), pl.getId_queben(),pl.getSd_sctp());
			}
		}
	}

}
