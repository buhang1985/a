package iih.ci.ord.content.listener.base;
import xap.mw.core.data.Context;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * @code 插件的工具类
 * @author LiYue
 * @date 2019年12月9日,下午2:32:52
 */
public class ListenerUtils {
	/**
	 * @code 医嘱内容中加急是否红色显示
	 * @author LiYue
	 */
	public Boolean GetXH_CIOR0005() {
		FBoolean redUrgent ;
		try {
			redUrgent = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),ICiOrdCustomSysParamConst.XH_PARAM_RED_URGENT);
		} catch (Exception e) {
			 redUrgent = FBoolean.FALSE;
		}
        return redUrgent.booleanValue();
	}
}
