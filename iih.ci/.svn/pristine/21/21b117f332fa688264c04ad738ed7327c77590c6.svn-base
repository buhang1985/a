package iih.ci.ord.s.bp.orsms.lis.ip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.SqlUtils;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.s.bp.orsms.lis.mergetube.MergeTubeSendToMPBP;
import iih.ci.ord.s.external.thirdws.utils.LogUtils;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.opmergetube.d.SampleOrRelDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 检验合管同步到执行域
 * @author zhangwq
 *
 */
public class IpMergeTubeSendToMPBP extends MergeTubeSendToMPBP {
	public void exec(List<String> id_ors) throws BizException{
		LogUtils.Logger("住院检验签署后调用执行域同步合管数据，CiapplissheetAggDO数量："+id_ors.size()+"----------");
		if(id_ors == null||id_ors.size() == 0){
			return;
		}
		if(FBoolean.TRUE.equals(isSendToMp(Context.get().getOrgId()))){
			LogUtils.Logger("住院检验签署后调用执行域同步合管数据，是否同步到执行域true");
			String sql = "select lisor.id_or as chkidor,lis.code_app,lisor.id_ciapplissheet from ci_app_lis_or lisor inner join ci_app_lis lis on lisor.id_ciapplissheet = lis.id_ciapplissheet where ";
			sql += SqlUtils.getInSqlByIds("lisor.id_or", id_ors);
			DAFacade facade = new DAFacade();
			List<Map<String,Object>> lisMaps = (List<Map<String,Object>>)facade.execQuery(sql, new MapListHandler());
			if(lisMaps != null && lisMaps.size() > 0){
				//一个合单一个dto
				Map<String,SampleOrRelDTO> sampleOrRelMap = new HashMap<String,SampleOrRelDTO>();
				for (Map<String, Object> map : lisMaps) {
					String chkidor = map.get("chkidor").toString();
					LogUtils.Logger("住院检验签署后调用执行域同步合管数据，同步到执行域的医嘱" + chkidor);
					String code_app = map.get("code_app").toString();
					String id_ciapplissheet = map.get("id_ciapplissheet").toString();
					if(sampleOrRelMap.containsKey(id_ciapplissheet)){
						sampleOrRelMap.get(id_ciapplissheet).getListOrs().add(chkidor);
					}else{
						SampleOrRelDTO reldto = new SampleOrRelDTO();
						reldto.setNo_bar(code_app);
						List<String> listOrs = new ArrayList<String>();
						listOrs.add(chkidor);
						reldto.setListOrs(listOrs);
						sampleOrRelMap.put(id_ciapplissheet,reldto);
					}
				}
				if(!sampleOrRelMap.isEmpty()){
					IForeignService servcice = ServiceFinder.find(IForeignService.class);
					servcice.opMergerTube(sampleOrRelMap.values().toArray(new SampleOrRelDTO[0]));
				}
			}
		}
	}
	@Override
	protected FBoolean isSendToMp(String id_org) {
		try{
			return ParamsetQryUtil.getParaBoolean(id_org,
					ICiOrdNSysParamConst.SYS_PARAM_IP_MERGETBUSENDTOMP);
		}catch(Exception ex){
			return FBoolean.FALSE;
		}
	}
	
}
