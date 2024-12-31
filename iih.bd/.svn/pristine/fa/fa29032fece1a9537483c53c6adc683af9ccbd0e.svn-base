package iih.bd.fc.que.s.rule;

import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 
 * @author guoyang
 *
 */
public class QueSiteCheckRule implements IRule<QueDO> {

	@Override
	public void process(QueDO... arg0) throws BizException {
		
		String id_que = "";
		
		for(int i = 0; i < arg0.length; i++){
			if(i == 0)
				id_que += "'"+arg0[i].getId_que()+"'";
			else
				id_que += ",'"+arg0[i].getId_que()+"'";
		}
		
		IQuesiteRService  quesiteRService=ServiceFinder.find(IQuesiteRService.class);
		String whereStr = " id_que in ("+id_que+") ";
		QueSiteDO[] result=quesiteRService.find(whereStr, "", FBoolean.FALSE);
		if(result!=null&&result.length>0){		
			for(int i = 0; i < arg0.length; i++){
				if(arg0[i].getId_que().equals(result[0].getId_que()))
					throw new BizException(arg0[i].getName()+"队列下存在站点，不能删除！");
			}
		}
		
	}
}
