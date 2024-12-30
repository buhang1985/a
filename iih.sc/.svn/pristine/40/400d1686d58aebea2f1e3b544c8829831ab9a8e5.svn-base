package iih.sc.scbd.bdsrv.s.bp;

import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.d.ScBdsrvKindItm;
import iih.sc.scbd.bdsrv.d.ScbdsrvAggDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvCudService;
import iih.sc.scbd.bdsrv.i.IScbdsrvRService;
import iih.sc.scbd.dto.d.ScBdSrvDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * 
 * @author f
 *
 */
public class SaveScBdSrvBP {

	/**
	 * 
	 * 
	 * @param scBdSrvDTOs
	 * @throws BizException 
	 */
	public void exec(ScBdSrvDTO[] saveDtos, ScBdSrvDTO[] delDtos, String id_org, String id_grp) throws BizException {
		if (!ArrayUtil.isEmpty(saveDtos)) {
			//新增
			List<ScBdSrvDTO> insertList = new ArrayList<ScBdSrvDTO>();
			//修改
			Map<String, ScBdSrvDTO> map = new HashMap<String, ScBdSrvDTO>();
			for (ScBdSrvDTO scBdSrvDTO : saveDtos) {
				switch (scBdSrvDTO.getStatus()) {
				case DOStatus.NEW:
					insertList.add(scBdSrvDTO);
					break;
				case DOStatus.UPDATED:
					map.put(scBdSrvDTO.getId_scbdsrv(), scBdSrvDTO);
					break;
				}
			}
			//更新
			this.updateScBdSrv(map,id_org,id_grp);
			//新增
			this.insertScBdSrv(insertList,id_org,id_grp);
		}
		
		//删除
		if (!ArrayUtil.isEmpty(delDtos)) {
			this.deleteScBdSrv(delDtos);
		}
		
	}

	/**
	 * 更新
	 * 
	 * @param updateList
	 * @throws BizException 
	 */
	private void updateScBdSrv(Map<String, ScBdSrvDTO> map, String id_org, String id_grp) throws BizException {
		if (MapUtils.isEmpty(map)) {
			return;
		}
		String[] id_scBdSrvs = map.keySet().toArray(new String[]{});
		//得到AggDO集合
		IScbdsrvRService rService = ServiceFinder.find(IScbdsrvRService.class);
		ScbdsrvAggDO[] aggDOs = rService.findByBIds(id_scBdSrvs, FBoolean.FALSE);
		for (ScbdsrvAggDO scbdsrvAggDO : aggDOs) {
			ScBdSrvDTO dto = map.get(scbdsrvAggDO.getParentDO().getId_scbdsrv());
			// 更新主DO
			scbdsrvAggDO.getParentDO().setStatus(DOStatus.UPDATED);
			scbdsrvAggDO.getParentDO().setSrvslot(dto.getSrvslot());
			scbdsrvAggDO.getParentDO().setFg_needcfm(dto.getFg_needcfm());//确认标识
			scbdsrvAggDO.getParentDO().setFg_autoapt_op(dto.getFg_autoapt_op());//门诊自动预约
			scbdsrvAggDO.getParentDO().setFg_autoapt_ip(dto.getFg_autoapt_ip());//住院自动预约
			scbdsrvAggDO.getParentDO().setId_grp(id_grp);
			scbdsrvAggDO.getParentDO().setId_org(id_org);
			String[] idItms = new String[]{};
			String[] nameItms = new String[]{};
			//类别不为空时
			if (dto.getId_scsrvkinditem() != null) {
				idItms = dto.getId_scsrvkinditem().split(",");
				nameItms = dto.getName_scsrvkinditem().split(",");
			}
			// 新增/删除子DO
			ScBdsrvKindItm[] childs = scbdsrvAggDO.getScBdsrvKindItm();
			List<ScBdsrvKindItm> insertItms = new ArrayList<ScBdsrvKindItm>();
			//设置要删除的子DO的状态
			for (ScBdsrvKindItm scBdsrvKindItm : childs) {
				Boolean flag = true;
				for (String idItm : idItms) {
					if (scBdsrvKindItm.getId_scsrvkinditm().equals(idItm)) {
						flag = false;
					}
				}
				if (flag) {
					scBdsrvKindItm.setStatus(DOStatus.DELETED);
				}
				insertItms.add(scBdsrvKindItm);
			}
			//新建要新增的子DO
			for (int i = 0; i < idItms.length; i++) {
				Boolean flag = true;
				for (ScBdsrvKindItm scBdsrvKindItm : childs) {
					if (scBdsrvKindItm.getId_scsrvkinditm().equals(idItms[i])) {
						flag = false;
					}
				}
				if (flag) {
					ScBdsrvKindItm newChild = new ScBdsrvKindItm();
					newChild.setStatus(DOStatus.NEW);
					newChild.setId_scbdsrv(dto.getId_scbdsrv());
					newChild.setId_scsrvkinditm(idItms[i]);
					newChild.setName_kinditm(nameItms[i]);
					newChild.setId_grp(id_grp);
					newChild.setId_org(id_org);
					insertItms.add(newChild);
				}
			}
			scbdsrvAggDO.setChildrenDO(insertItms.toArray(new ScBdsrvKindItm[]{}));
		}		
		//保存
		IScbdsrvCudService cudService = ServiceFinder.find(IScbdsrvCudService.class);
		cudService.save(aggDOs);
	}
	
	/**
	 * 删除
	 * 
	 * @param deleteList
	 * @throws BizException
	 */
	private void deleteScBdSrv(ScBdSrvDTO[] saveDtos) throws BizException {
		//得到主DO主键集合
		List<String> id_scBdSrvs = new ArrayList<String>();
		for (ScBdSrvDTO scBdSrvDTO : saveDtos) {
			if (!StringUtil.isEmptyWithTrim(scBdSrvDTO.getId_scbdsrv())) {
				id_scBdSrvs.add(scBdSrvDTO.getId_scbdsrv());
			}
		}
		//得到AggDO集合
		IScbdsrvRService rService = ServiceFinder.find(IScbdsrvRService.class);
		ScbdsrvAggDO[] aggDOs = rService.findByBIds(id_scBdSrvs.toArray(new String[]{}), FBoolean.FALSE);
		//删除
		IScbdsrvCudService cudService = ServiceFinder.find(IScbdsrvCudService.class);
		cudService.delete(aggDOs);
	}
	
	/**
	 * 新增
	 * 
	 * @param insertList
	 * @throws BizException 
	 */
	private void insertScBdSrv(List<ScBdSrvDTO> insertList, String id_org, String id_grp) throws BizException {
		if (ListUtil.isEmpty(insertList)) {
			return;
		}
		//组装AggDo集合
		List<ScbdsrvAggDO> aggDOs = new ArrayList<ScbdsrvAggDO>();
		for (ScBdSrvDTO scBdSrvDTO : insertList) {
			ScbdsrvAggDO aggDO = new ScbdsrvAggDO();
			ScBdsrvDO parentDo = new ScBdsrvDO();
			parentDo.setStatus(DOStatus.NEW);
			parentDo.setId_grp(id_grp);
			parentDo.setId_org(id_org);
			parentDo.setId_srv(scBdSrvDTO.getId_srv());
			parentDo.setId_scca(scBdSrvDTO.getId_scca());
			parentDo.setSrvslot(scBdSrvDTO.getSrvslot());
			parentDo.setFg_needcfm(scBdSrvDTO.getFg_needcfm());//确认标识
			aggDO.setParentDO(parentDo);
			if (!StringUtil.isEmptyWithTrim(scBdSrvDTO.getId_scsrvkinditem())) {
				String[] idItms = scBdSrvDTO.getId_scsrvkinditem().split(",");
				String[] nameItms = scBdSrvDTO.getName_scsrvkinditem().split(",");
				ScBdsrvKindItm[] childs = new ScBdsrvKindItm[idItms.length];
				for (int i = 0; i < childs.length; i++) {
					childs[i] = new ScBdsrvKindItm();
					childs[i].setStatus(DOStatus.NEW);
					childs[i].setId_grp(id_grp);
					childs[i].setId_org(id_org);
					childs[i].setId_scbdsrv(scBdSrvDTO.getId_scbdsrv());
					childs[i].setId_scsrvkinditm(idItms[i]);
					childs[i].setName_kinditm(nameItms[i]);
				}
				aggDO.setChildrenDO(childs);
			}
			aggDOs.add(aggDO);
		}
		//保存
		IScbdsrvCudService cudService = ServiceFinder.find(IScbdsrvCudService.class);
		cudService.insert(aggDOs.toArray(new ScbdsrvAggDO[]{}));
	}
}
