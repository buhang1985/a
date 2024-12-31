package iih.ci.ord.s.external.obtain;

import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.ci.ord.i.external.obtain.ICiOrdBdRService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.cache.BDFreqInfoCache;
import iih.ci.ord.s.external.obtain.bp.bd.getIdroutes8DosageBP;

@Service(serviceInterfaces = { ICiOrdBdRService.class }, binding = Binding.JSONRPC)
public class CiOrdBdRServiceImpl implements ICiOrdBdRService {

	/**
	 * 根据服务类型、剂型关联用法
	 */
	@Override
	public String getIdroutes8Dosage(String sd_srvtp, String[] id_srvs, FBoolean isControl) 
			throws BizException {
		// TODO Auto-generated method stub
		getIdroutes8DosageBP bp=new getIdroutes8DosageBP();
		return bp.getIdroutes(sd_srvtp, id_srvs, isControl);
	}
	
	/**
	 * 根据用法关联剂型判断服务是否可成组
	 */
	@Override
	public FBoolean checkSrvEnable8Dosage(String id_srv, String id_route)
			throws BizException {
		// TODO Auto-generated method stub
		if (StringUtils.isNullOrEmpty(id_srv) || StringUtils.isNullOrEmpty(id_route))
			return FBoolean.TRUE;
		SqlParam param = new SqlParam();
		param.addParam(id_srv);
		param.addParam(id_route);
		StringBuilder sb = new StringBuilder();
		sb.append("select count(id_srv) as cnt  from bd_srv_drug where id_srv=? ")
		.append("and id_dosage in (select id_dosage from bd_route_dosage_ref where id_route=?)");
		List<Map<String, Object>> sqlRst = CiOrdUtils.getRsMapList(sb.toString(), param);
		Integer cnt = 0;
		if (sqlRst != null && sqlRst.size() > 0) {
			for (int i = 0; i < sqlRst.size(); i++) {
				cnt = (Integer) sqlRst.get(i).get("cnt");
			}
		}
		return new FBoolean(cnt > 0);
	}

	/**
	 * 获取频次信息
	 */
	@Override
	public FreqDefDO getFreqDefDO(String id_freq) throws BizException {
		// TODO Auto-generated method stub
		return BDFreqInfoCache.GetFreqInfo(id_freq);
	}
}
