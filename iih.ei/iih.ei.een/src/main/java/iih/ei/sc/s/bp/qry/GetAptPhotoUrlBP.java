package iih.ei.sc.s.bp.qry;

import java.util.List;

import cn.xapss.fastdfs.FastDfsCRUDer;
import fastdfs.client.FastDfsConfig;
import fastdfs.client.NodeConfig;
import fastdfs.client.StorageConfig;
import iih.ei.sc.ws.bean.GetAptPhotoUrlBean;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetAptPhotoUrlBP {
	private static String ip_prefix = "http://";
	/**
	 * 获取医技停诊列表
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return
	 */
	public GetAptPhotoUrlBean[] exec(String id_apt,String codeOr) throws BizException {
		String photoUrl = this.getPhotoUrl(id_apt,codeOr);
		if(StringUtil.isEmpty(photoUrl)){
			throw new BizException("未获取到该申请单对应的预约记录照片!");
		}
		String key = photoUrl.substring(0, photoUrl.indexOf("/"));
		FastDfsCRUDer fds = FastDfsCRUDer.getInstance();
		FastDfsConfig fastDfsConfig = fds.getConfig();
		List<StorageConfig> storageList = fastDfsConfig.getStorages();
		String ip = "";
		for(StorageConfig sc : storageList) {
			if(key.equals(sc.getGroupName())) {
				List<NodeConfig> nodeList = sc.getNodes();
				if(!ListUtil.isEmpty(nodeList)) {
					NodeConfig node = nodeList.get(0);
					ip =node.getDownloadAddr();
				}
			}
		}

		StringBuffer repUrl = new StringBuffer();
		repUrl.append(ip_prefix).append(ip).append("/").append(photoUrl);
		GetAptPhotoUrlBean bean = new GetAptPhotoUrlBean();
		bean.setPhotoUrl(repUrl.toString());
		return new GetAptPhotoUrlBean[]{bean};
	}
	
	/**
	 * 根据申请单号查询预约照片路径
	 * @param applyNo
	 * @return
	 * @throws BizException
	 */
	private String getPhotoUrl(String applyNo,String codeOr) throws BizException{
		if(StringUtil.isEmpty(applyNo) && StringUtil.isEmpty(codeOr)) return null;
		StringBuilder sql = new StringBuilder();
		SqlParam param = new SqlParam();
		sql.append(" select mtapt.url_photo as photourl")
		.append(" from sc_apt_appl appl")
		.append(" left outer join sc_apt_mt mtapt on appl.id_scapt = mtapt.id_apt where  1=1 ");
		if(!StringUtil.isEmpty(applyNo)){
		param.addParam(applyNo);
			sql.append(" and appl.applyno = ?");
		}
		if(!StringUtil.isEmpty(codeOr)){
			param.addParam(codeOr);
			sql.append(" and appl.code_or = ?");
		}
		List<String> result = (List<String>) new DAFacade().execQuery(sql.toString(),param,new ColumnListHandler());
		if(!result.isEmpty()){
			return result.get(0);
		}
		return null;
	}
}
