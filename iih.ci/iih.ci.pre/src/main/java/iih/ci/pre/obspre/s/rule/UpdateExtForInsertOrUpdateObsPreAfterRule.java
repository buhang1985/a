package iih.ci.pre.obspre.s.rule;

import iih.ci.pre.obspre.d.ObsPreSrvDO;
import iih.ci.pre.obspre.d.ObspreAggDO;
import iih.en.pv.enres.d.EnExtDO;
import iih.en.pv.enres.i.IEnextCudService;
import iih.en.pv.enres.i.IEnextRService;
import iih.en.utils.params.EnParamsUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 新增或修改生命体征后
 * 
 * @author liubin
 *
 */
public class UpdateExtForInsertOrUpdateObsPreAfterRule implements IRule<ObspreAggDO>{

	@Override
	public void process(ObspreAggDO... args) throws BizException {
		if(ArrayUtil.isEmpty(args))
			return;
		Set<String> entList = new HashSet<String>();
		for(ObspreAggDO arg : args){
			entList.add(arg.getParentDO().getId_ent());
		}
		if(entList.isEmpty())
			return;
		IEnextRService rServ = ServiceFinder.find(IEnextRService.class);
		EnExtDO[] exts = rServ.findByAttrValStrings(EnExtDO.ID_ENT, entList.toArray(new String[0]));
		Map<String, EnExtDO> map = assemly(exts);
		if(map == null)
			return;
		for(ObspreAggDO arg : args){
			process(arg, map.get(arg.getParentDO().getId_ent()));
		}
		IEnextCudService cudServ = ServiceFinder.find(IEnextCudService.class);
		cudServ.save(map.values().toArray(new EnExtDO[0]));
	}
	/**
	 * 处理
	 * 
	 * @param arg
	 * @param ext
	 * @throws BizException
	 */
	private void process(ObspreAggDO arg, EnExtDO ext) throws BizException {
		if(ArrayUtil.isEmpty(arg.getObsPreSrvDO()))
			return;
		//体重g服务
		String srvIdWeihtG = EnParamsUtil.MPNR0109();
		//体重kg服务
		String srvIdWeihtKG = EnParamsUtil.MPNR0114();
		//身高cm服务
		String srvIdHeight = EnParamsUtil.MPNR0113();
		for(ObsPreSrvDO srv : arg.getObsPreSrvDO()){
			if(StringUtil.isEmptyWithTrim(srv.getId_srv()))
				continue;
			if(!StringUtil.isEmptyWithTrim(srvIdWeihtG) && srv.getId_srv().equals(srvIdWeihtG)){
				ext.setStatus(DOStatus.UPDATED);
				if(srv.getVal0() != null){
					ext.setWeight(new FDouble(srv.getVal0()).div(1000));
				}else{
					ext.setWeight(FDouble.ZERO_DBL);
				}
			}
			if(!StringUtil.isEmptyWithTrim(srvIdWeihtKG) && srv.getId_srv().equals(srvIdWeihtKG)){
				ext.setStatus(DOStatus.UPDATED);
				if(srv.getVal0() != null){
					ext.setWeight(new FDouble(srv.getVal0()));
				}else{
					ext.setWeight(FDouble.ZERO_DBL);
				}
			}
			if(!StringUtil.isEmptyWithTrim(srvIdHeight) && srv.getId_srv().equals(srvIdHeight)){
				ext.setStatus(DOStatus.UPDATED);
				if(srv.getVal0() != null){
					ext.setHeight(new FDouble(srv.getVal0()));
				}else{
					ext.setHeight(FDouble.ZERO_DBL);
				}
			}
		}
	}
	
	/**
	 * 组装字典
	 * 
	 * @param exts
	 * @return
	 */
	private Map<String, EnExtDO> assemly(EnExtDO[] exts){
		if(ArrayUtil.isEmpty(exts))
			return null;
		Map<String, EnExtDO> map = new HashMap<>();
		for(EnExtDO ext : exts){
			map.put(ext.getId_ent(),  ext);
		}
		return map;
	}
}
