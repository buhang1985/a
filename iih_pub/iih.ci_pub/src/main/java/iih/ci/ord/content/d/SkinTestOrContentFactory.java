package iih.ci.ord.content.d;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.jdbc.facade.DAException;

/**
 * 医嘱内容生成皮试类生成工厂
 */
public class SkinTestOrContentFactory extends BaseCiOrContentFactory implements CiOrContentObjFactory {
	public static final String ID_OR= "Id_or";
@Override
public CiOrContentDO create(CiEmsDTO ems) throws BizException {
	if(ems==null || ems.getEmssrvs()==null || ems.getEmssrvs().size()==0){
		return getNullContent(ems);
	}
	CiOrContentDO contentdo=new CiOrContentDO();
	Object[] params = new Object[]{contentdo,ems,this.getOrdsrvs()};
	BDCommonEvent event = new BDCommonEvent(SourceIdConst.SourceId_TreatSkinTestOrdContent, IEventType.TYPE_UPDATE_AFTER, params);
	EventDispatcher.fireEvent(event);
	return contentdo;
}}
