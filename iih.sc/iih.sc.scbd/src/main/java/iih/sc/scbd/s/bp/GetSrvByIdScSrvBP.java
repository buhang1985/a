package iih.sc.scbd.s.bp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import iih.sc.scbd.dto.d.ScBdSrvDTO;
import iih.sc.scbd.i.IScBdCmdService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据查询条件(id_scSrv)查询ScBdSrvDTO
 * @author ltf
 *
 */
public class GetSrvByIdScSrvBP {
	/**
	 * 主流程
	 * @param qryDO
	 * @param pg 
	 * @return
	 * @throws BizException 
	 */
	public PagingRtnData<ScBdSrvDTO> exec(ScheduleSrvDO qryDO, PaginationInfo pg) throws BizException {
		// 1、判空
		if(qryDO == null){
			return null;
		}
		
		// 2、获取数据
		PagingRtnData<ScBdSrvDTO> result = this.getSrvData(qryDO.getId_scsrv(), pg);
		// 3、数据处理
	    this.handleData(result);
		// 4、返回数据
		return result;
	}
	
	/**
	 * 获取数据
	 * @param id_scsrv 
	 * @param id_scsrv
	 * @param pg 
	 * @return
	 * @throws BizException 
	 */
	private PagingRtnData<ScBdSrvDTO> getSrvData(String id_scsrv, PaginationInfo pg) throws BizException {
		StringBuilder str = new StringBuilder();
		str.append(" select bdsrv.name name_srv,");// 医疗服务
		str.append(" rel.id_scsrvrel,");//排班服务对照ID
		str.append(" rel.id_scsrv,");// 排班服务
		str.append(" rel.id_mdsrv id_srv,");// 医疗服务
		str.append(" bdsrv.pri pri");// 参考价格
		str.append(" from sc_srv_rel rel");
		str.append(" inner join bd_srv bdsrv on rel.id_mdsrv = bdsrv.id_srv");
		str.append(" inner join sc_srv scsrv on rel.id_scsrv = scsrv.id_scsrv");
		str.append(" inner join sc_bdsrv scbdsrv on scbdsrv.id_srv = bdsrv.id_srv");
		str.append(" where rel.id_scsrv = ? and scbdsrv.id_scca = scsrv.id_scca");
		// 获取参数
		SqlParam param = new SqlParam();
		param.addParam(id_scsrv);
		// 获取数据
		PagingServiceImpl<ScBdSrvDTO> pageQryService = new PagingServiceImpl<ScBdSrvDTO>();
		return pageQryService.findByPageInfo(new ScBdSrvDTO(), pg, str.toString(), null, param);
	}
	
	/**
	 * 数据处理
	 * @param datas
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private void handleData(PagingRtnData<ScBdSrvDTO> pageData) throws BizException {
		// 校验
		if(pageData == null || pageData.getPageData() == null || pageData.getPageData().size() == 0){
			return;
		}
		FArrayList lists = pageData.getPageData();
		// 获取idScSrvRel集合
		@SuppressWarnings("rawtypes")
		HashSet ids = new HashSet();
		for (Object obj : lists) {
			ScBdSrvDTO srvDto = (ScBdSrvDTO)obj;
			ids.add(srvDto.getId_scsrvrel());
		}
		// 获取排班资源对照数据:时长和明细  
		IScBdCmdService iScBdCmdService = ServiceFinder.find(IScBdCmdService.class);
		ScheduleSrvRelDO[] reldos = iScBdCmdService.getScSrvRelArr((String[])ids.toArray(new String[ids.size()]));
		if(ArrayUtil.isEmpty(reldos)){
			return;
		}
		Map<String, ScheduleSrvRelDO> map = new HashMap<String, ScheduleSrvRelDO>();
		for (int i = 0; i < reldos.length; i++) {
			map.put(reldos[i].getId_scsrvrel(), reldos[i]);
		}
		// 组装数据
		this.assemSrvDto(pageData,lists, map);
	}
	
	/**
	 * 组装服务数据: 时长、明细
	 * @param datas
	 * @param srv 
	 * @param srv
	 */
	private void assemSrvDto(PagingRtnData<ScBdSrvDTO> pageData,FArrayList datas, Map<String, ScheduleSrvRelDO> srv) {
		for (Object obj : datas) {
			ScBdSrvDTO srvDto = (ScBdSrvDTO)obj;
			if(srv.containsKey(srvDto.getId_scsrvrel())){
				ScheduleSrvRelDO relDo = srv.get(srvDto.getId_scsrvrel());
				// 时长
				srvDto.setSrvslot(relDo.getSrvslot());
				// 明细
				srvDto.setName_scsrvkinditem(relDo.getName_kinditm());
			}
		}
		pageData.setPageData(datas);
	}
}
