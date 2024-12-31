package iih.ci.ord.s.bp;

import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 自定义的药品的可选择计量单位
 * @author zhangwq
 *
 */
public class GetFreqForFtmSrvBP {
	public FMap exec(String paramCode) throws BizException{
		FMap map = new FMap();
		String paramValue = ParamsetQryUtil.getParaString(Context.get().getOrgId(), paramCode);
		if(StringUtils.isEmpty(paramValue)){
			return map;
		}
		String whereStr = CiOrdUtils.getSqlInStrsWithOutIn(paramValue);
		IMeasdocRService measdocService = ServiceFinder.find(IMeasdocRService.class);
		MeasDocDO[] measDocs = measdocService.find(" id_measdoc in "+whereStr, " sd_oppdimen ", FBoolean.FALSE);
		if(measDocs!=null&&measDocs.length>0){
			for(int i=0;i<measDocs.length;i++){
				map.put(measDocs[i].getId_measdoc(),measDocs[i].getName());
			}
		}
		return map;
	}
}
