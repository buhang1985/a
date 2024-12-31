package iih.ci.ord.content.d;

import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 医嘱内容生成西成药、中成药工厂（非草药）
 */
public class DefaultDrugOrContentFactory  extends BaseCiOrContentFactory implements CiOrContentObjFactory {
	public static final String ID_OR= "Id_or";
	@Override
	public CiOrContentDO create(CiEmsDTO ems) throws BizException {
		if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0){
			return getNullContent(ems);
		}
		CiOrContentDO contentdo=new CiOrContentDO();
		Object[] params = new Object[]{contentdo,ems,this.getOrdsrvs()};
		BDCommonEvent event = new BDCommonEvent(SourceIdConst.SourceId_DrugsOrdContent, IEventType.TYPE_UPDATE_AFTER, params);
		EventDispatcher.fireEvent(event);
		return contentdo;
	}
}
