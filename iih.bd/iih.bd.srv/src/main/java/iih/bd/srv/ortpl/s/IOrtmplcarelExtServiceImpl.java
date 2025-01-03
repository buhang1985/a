package iih.bd.srv.ortpl.s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.mail.Flags.Flag;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.ortpl.d.OrTmplCaDO;
import iih.bd.srv.ortpl.d.OrTmplCaRelDO;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.d.OrtmplAggDO;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import iih.bd.srv.ortpl.i.IOrTplNItmDORService;
import iih.bd.srv.ortpl.i.IOrtmplCudService;
import iih.bd.srv.ortpl.i.IOrtmplRService;
import iih.bd.srv.ortpl.i.IOrtmplcaCudService;
import iih.bd.srv.ortpl.i.IOrtmplcarelCudService;
import iih.bd.srv.ortpl.i.IOrtmplcarelExtService;
import iih.bd.srv.s.CiOrdAppUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

@Service(serviceInterfaces = { IOrtmplcarelExtService.class }, binding = Binding.JSONRPC)
public class IOrtmplcarelExtServiceImpl implements IOrtmplcarelExtService {

	/**
	 * 模板保存
	 */
	@Override
	public void Save(OrtmplAggDO ortmplAggDO, OrTmplCaRelDO orTmplCaRelDO, OrtmplAggDO[] ortmplAggDOsRef, OrTmplDO[] orTmplDOsRefDel) 
			throws BizException {
		IOrtmplCudService ortmplSaveService = ServiceFinder.find(IOrtmplCudService.class);
		IOrTplNItmDORService itmDORService = ServiceFinder.find(IOrTplNItmDORService.class);
		
		List<OrtmplAggDO> ortmplAggList = new ArrayList<OrtmplAggDO>();
		ortmplAggList.add(ortmplAggDO);
		if (ortmplAggDOsRef != null && ortmplAggDOsRef.length > 0) {
			ortmplAggList.addAll(Arrays.asList(ortmplAggDOsRef));
		}
		
		// 新增或编辑派生基础模板集合
		if (ortmplAggDOsRef != null && ortmplAggDOsRef.length > 0) {
			String[] ids = new DBUtil().getOIDs(ortmplAggDOsRef.length);
			int i = 0;
			for (OrtmplAggDO aggDO : ortmplAggDOsRef) {
				// Sv为空时，派生基础模板时是新增，非空时是编辑
				if (aggDO.getParentDO().getSv() == null) {
					// 派生基础模板（Id_ortmpl）与上一级模板明细项目（Id_srv）的对应关系，新增时赋给新生成的ID字符串，编辑时已经存在
					for (OrTplNItmDO itemDO : ortmplAggDO.getOrTplNItmDO()) {
						if (itemDO.getId_srv().equals(aggDO.getParentDO().getId_ortmpl())) {
							itemDO.setId_srv(ids[i]);
						}
					}
					aggDO.getParentDO().setId_ortmpl(ids[i]);
				} else {
					ArrayList<OrTplNItmDO> lstItmDOs = new ArrayList<OrTplNItmDO>();
					OrTplNItmDO[] itmDOs = itmDORService.find(" Id_ortmpl='" + aggDO.getParentDO().getId_ortmpl() + "'", "", FBoolean.FALSE);
					ArrayList<String> lstIds = new ArrayList<String>();
					
					for (OrTplNItmDO itemDO : aggDO.getOrTplNItmDO()) {
						if (itemDO.getId_ortmplitm()!=null) {
						itemDO.setStatus(DOStatus.UPDATED);
						lstItmDOs.add(itemDO);
							lstIds.add(itemDO.getId_ortmplitm());
						}else{
							itemDO.setStatus(DOStatus.NEW);
							lstItmDOs.add(itemDO);
						}
					}
					for (OrTplNItmDO itemDO : itmDOs) {
						if (!lstIds.contains(itemDO.getId_ortmplitm())){
							itemDO.setStatus(DOStatus.DELETED);
							lstItmDOs.add(itemDO);
						}
					}
					aggDO.setOrTplNItmDO(lstItmDOs.toArray(new OrTplNItmDO[0]));
				}
				i++;
			}
			ortmplSaveService.save(ortmplAggDOsRef);
			//itmDODelService.delete(lstDelItmDOs.toArray(new OrTplNItmDO[] {}));
		}

		// 待删除派生基础模板集合
		if (orTmplDOsRefDel != null && orTmplDOsRefDel.length > 0) {
			ortmplSaveService.deleteByParentDO(orTmplDOsRefDel);
		}

		// 主模板对象保存 DOStatus.UPDATED
		ortmplAggDO.getParent().setStatus(ortmplAggDO.getParentDO().getId_ortmpl() != null ? DOStatus.UPDATED : DOStatus.NEW);
		OrtmplAggDO[] newortmplAggDOs = ortmplSaveService.save(new OrtmplAggDO[] { ortmplAggDO });

		// 模板与分类关系对象，编辑模板时为空，新增模板时非空
		if (orTmplCaRelDO == null)
			return;
		// 关系对象赋给新增模板的Id_ortmpl
		if (orTmplCaRelDO != null && orTmplCaRelDO.getStatus() == DOStatus.NEW) {
			orTmplCaRelDO.setId_ortmpl(newortmplAggDOs[0].getParentDO().getId_ortmpl());
		}
		ServiceFinder.find(IOrtmplcarelCudService.class).save(new OrTmplCaRelDO[] { orTmplCaRelDO });
	}

	@Override
	public void Delete(OrTmplDTO[] orTmplDTOs) throws BizException {
		if (orTmplDTOs != null && orTmplDTOs.length > 0) {
			StringBuilder whereStr = new StringBuilder();
			for (OrTmplDTO itemDO : orTmplDTOs) {
				if (!whereStr.toString().contains(itemDO.getId_ortmpl())) {
					whereStr.append(String.format(",'%s'", itemDO.getId_ortmpl()));
				}
			}
			if (whereStr.length() > 0) {
				IOrtmplRService ortmplQueryService = ServiceFinder
						.find(IOrtmplRService.class);
				OrtmplAggDO[] ortmplAggDOs = ortmplQueryService.find(
						" id_ortmpl in(" + whereStr.substring(1) + ")", "",
						FBoolean.FALSE);
				IOrtmplCudService ortmplSaveService = ServiceFinder
						.find(IOrtmplCudService.class);
				ortmplSaveService.delete(ortmplAggDOs);
				new DAFacade().deleteByWhere(OrTmplCaRelDO.class, " id_ortmpl in(" + whereStr.substring(1) + ")");
				new DAFacade().deleteByWhere(OrTplNItmDO.class, " id_srv in(" + whereStr.substring(1) + ")");
//				OrtmplAggDO[] ortmplAggDOs = ServiceFinder.find(IOrtmplRService.class)
//						.find(" id_ortmpl in(" + whereStr.substring(1) + ")", "", FBoolean.FALSE);
//				OrTmplCaRelDO[] orTmplCaRelDOs = ServiceFinder.find(IOrtmplcarelRService.class)
//						.find(" id_ortmpl in(" + whereStr.substring(1) + ")", "", FBoolean.FALSE);
//				OrTplNItmDO[] orTolNItmDOs = ServiceFinder.find(IOrTplNItmDORService.class)
//						.find(" id_srv in(" + whereStr.substring(1) + ")", "", FBoolean.FALSE);

//				ServiceFinder.find(IOrtmplCudService.class).delete(ortmplAggDOs);
//				ServiceFinder.find(IOrtmplcarelCudService.class).delete(orTmplCaRelDOs);
//				ServiceFinder.find(IOrTplNItmDOCudService.class).delete(orTolNItmDOs);
			}
		}
	}

	@Override
	public OrtmplAggDO[] SaveAs(OrtmplAggDO[] ortmplAggDOs,OrTmplCaRelDO[] orTmplCaRelDOs,OrTmplCaDO orTmplCaDO) 
			throws BizException {
		if (null == ortmplAggDOs || null == orTmplCaRelDOs || 0 == ortmplAggDOs.length || 0 == orTmplCaRelDOs.length)
			return null;
		//医嘱另存为模板，模板明细中的当前剂量，当前剂量单位 换算系数未赋值
		for (OrtmplAggDO ortmplAggDO : ortmplAggDOs) {
			OrTplNItmDO[] orTplNItmDOs = ortmplAggDO.getOrTplNItmDO();
			if (orTplNItmDOs != null) {
				for (OrTplNItmDO orTplNItmDO : orTplNItmDOs) {
					orTplNItmDO.setQuan_medu_cur(orTplNItmDO.getQuan_med());
					orTplNItmDO.setId_medu_cur(orTplNItmDO.getId_unit_med());
					orTplNItmDO.setFactor_cur(new FDouble(1));
					orTplNItmDO.setDes_or(null);
				}
			}
		}

		if (orTmplCaDO != null) {
			orTmplCaDO = ServiceFinder.find(IOrtmplcaCudService.class).save(new OrTmplCaDO[] { orTmplCaDO })[0];
			for (OrTmplCaRelDO relDO : orTmplCaRelDOs) {
				relDO.setId_ortmplca(orTmplCaDO.getId_ortmplca());
			}
		}
		OrtmplAggDO ortmplAggDO = null;
		for (OrtmplAggDO aggDO : ortmplAggDOs) {
			if (0 == aggDO.getParentDO().getId_ortmpl().length()) {
				ortmplAggDO = aggDO;
			}
		}
		
		String[] ids = new DBUtil().getOIDs(ortmplAggDOs.length);
		int i = 0;
		for (OrtmplAggDO aggDO : ortmplAggDOs) {
			for (OrTmplCaRelDO relDO : orTmplCaRelDOs) {
				if (relDO.getId_ortmpl().equals(aggDO.getParentDO().getId_ortmpl())) {
					relDO.setId_ortmpl(ids[i]);
				}
			}
			
			if (aggDO.getParentDO().getId_ortmpl().length() > 0) {
				for (OrTplNItmDO itmDO : ortmplAggDO.getOrTplNItmDO()) {
					if (itmDO.getId_srv().equals(aggDO.getParentDO().getId_ortmpl()))
						itmDO.setId_srv(ids[i]);
				}
			}
			
			aggDO.getParentDO().setId_ortmpl(ids[i]);
			i++;
		}
		
		orTmplCaRelDOs = ServiceFinder.find(IOrtmplcarelCudService.class).save(orTmplCaRelDOs);
		ortmplAggDOs = ServiceFinder.find(IOrtmplCudService.class).save(ortmplAggDOs);
		return ortmplAggDOs;
	}
	
	@Override
	public String getOrTplNItmAvailableVaidate(OrTplNItmDO[] orTplNItms) throws BizException {
		// 拼接用于查询频次的id串
		StringBuffer idFreqBuffer = new StringBuffer();
		// 获取频次周期类型为持续的频次
		for (OrTplNItmDO orTplNItm : orTplNItms) {
			idFreqBuffer.append(String.format(",'%s'", orTplNItm.getId_freq()));
		}
		FreqDefDO[] freqDefs = CiOrdAppUtils.getFreqdefMDORService()
				.find(String.format(" id_freq in (%s) and sd_frequnitct='%s'", idFreqBuffer.substring(1), IBdSrvDictCodeConst.SD_FREQNUNITCT_ALWAYS), null, FBoolean.FALSE);
		if (freqDefs == null || freqDefs.length == 0) {
			return "";
		}
		
		// 频次周期类型为持续的频次id集合
		List<String> idFreqList = new ArrayList<String>();
		for (FreqDefDO freqDef : freqDefs) {
			idFreqList.add(freqDef.getId_freq());
		}
		// 拼接用于查询计量单位id字符串
		StringBuffer idMeduUnitBuffer = new StringBuffer();
		// 获取模板项目中频次周期为持续的计量单位串，查询出对应的记录单位，后续判断是否为时间类型
		for (OrTplNItmDO orTplNItm : orTplNItms) {
			if (idFreqList.contains(orTplNItm.getId_freq())) {
				idMeduUnitBuffer.append(String.format(",'%s'", orTplNItm.getId_unit_med()));
			}
		}
		if (idMeduUnitBuffer.length() == 0) {
			return "";
		}
		
		// 查询计量单位的量纲不是时间类型的单位
		MeasDocDO[] measDocs = CiOrdAppUtils.getMeasdocRService()
				.find(String.format(" id_measdoc in (%s) and sd_oppdimen!='%s'", idMeduUnitBuffer.substring(1), ISysDictCodeConst.SD_OPPDIMEN_T), null, FBoolean.FALSE);
		if (measDocs == null || measDocs.length == 0) {
			return "";
		}
		
		// 计量单位中量纲为非时间类型的 id集合
		List<String> idMeasDoc = new ArrayList<String>();
		for(MeasDocDO measDoc : measDocs){
			idMeasDoc.add(measDoc.getId_measdoc());
		}
		// 返回计量单位量纲为非时间类型，但是频次周期类型是持续的模板明细
		StringBuffer msgBuffer = new StringBuffer();
		for (OrTplNItmDO orTplNItm : orTplNItms) {
			if (idMeasDoc.contains(orTplNItm.getId_unit_med()) && idFreqList.contains(orTplNItm.getId_freq())) {
				msgBuffer.append(String.format(",【%s】", orTplNItm.getOrtplnitm_srv_name()));
			}
		}
		
		return String.format("服务项目 %s 的频次为持续类型，剂量单位必须是时间类型！", msgBuffer.substring(1));
	}	
	
	/**
	 * 根据用法关联剂型判断服务是否可成组
	 * @param id_srv
	 * @param id_route
	 * @return
	 * @throws BizException
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
		sb.append("select count(id_srv) as cnt from bd_srv_drug where id_srv=? ")
		.append("and id_dosage in (select id_dosage from bd_route_dosage_ref where id_route=?)");
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> sqlRst = (List<Map<String, Object>>) (new DAFacade().execQuery(sb.toString(), param, new MapListHandler()));
		Integer cnt = 0;
		if (sqlRst != null && sqlRst.size() > 0) {
			cnt = (Integer) sqlRst.get(0).get("cnt");
		}
		return new FBoolean(cnt > 0);
	}
}
