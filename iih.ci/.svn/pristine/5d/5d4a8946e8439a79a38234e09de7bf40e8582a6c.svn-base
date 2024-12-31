package iih.ci.ord.s.ems.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.d.desc.MeasDocDODesc;

/**
 * 基础定义态计量信息
 * @author wangqingzhu
 *
 */
public class BDMeasInfoCache {
	public static String BDMeasInfoCache_Key = "BDMeasInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private static BDMeasInfoCache ins = new BDMeasInfoCache();

	private BDMeasInfoCache() {
	}

	private MeasDocDO[] gets() throws BizException {
		String sql = "select Id_measdoc,Name,Scalefactor,Scale from bd_measdoc a0 where ds<1 and "+EnvContextUtil.processEnvContext("", new MeasDocDO(), MeasDocDODesc.TABLE_ALIAS_NAME);
		List<MeasDocDO> rst = (List<MeasDocDO>)new DAFacade().execQuery(sql, new BeanListHandler(MeasDocDO.class));
		return null != rst?rst.toArray(new MeasDocDO[rst.size()]):null;
	}
	
	private MeasDocDO get(String id_meas) throws BizException {
		String sql = String.format("select Id_measdoc,Name,Scalefactor,Scale from bd_measdoc a0 where id_measdoc = '%s' and ds<1",id_meas);
		List<MeasDocDO> rst = (List<MeasDocDO>)new DAFacade().execQuery(sql, new BeanListHandler(MeasDocDO.class));
		return null != rst && rst.size()> 0?rst.get(0):null;
	}
	
	public static MeasDocDO[] GetBdMeasInfos(CiEnContextDTO ctx) throws BizException{
		MeasDocDO[] szMeasDocDO = ContextCache.Get(BDMeasInfoCache.class.getSimpleName(),ctx.getId_grp(), ctx.getId_org(), BDMeasInfoCache_Key, DefaultContext_ID);
		if (null == szMeasDocDO || szMeasDocDO.length == 0){
			szMeasDocDO = ins.gets();
		}
		return szMeasDocDO;
	}
	
	public static String GetNameOfBdMeasInfo(String id_meas) throws BizException{
		MeasDocDO measInfo = ContextCache.Get(BDMeasInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDMeasInfoCache_Key, id_meas);
		if (null == measInfo){
			measInfo = ins.get(id_meas);
		}
		return measInfo==null?null:measInfo.getName();
	}
	
	public static FDouble GetScaleFactorOfBdMeasInfo(String id_meas) throws BizException{
		MeasDocDO measInfo = ContextCache.Get(BDMeasInfoCache.class.getSimpleName(),DefaultContext_ID, DefaultContext_ID, BDMeasInfoCache_Key, id_meas);
		if (null == measInfo){
			measInfo = ins.get(id_meas);
		}
		return measInfo==null?null:measInfo.getScalefactor();
	}
	
	public static void Clear(){
		ContextCache.Clear(BDMeasInfoCache.class.getSimpleName());
	}
}
