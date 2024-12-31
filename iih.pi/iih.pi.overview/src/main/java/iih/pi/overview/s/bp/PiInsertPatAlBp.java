package iih.pi.overview.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.srv.srvskintestrel.d.SrvSkinTestRelDO;
import iih.pi.overview.dto.d.Degree;
import iih.pi.overview.dto.d.PatAlDTO;
import iih.pi.overview.overview.d.DataAct;
import iih.pi.overview.overview.d.OverviewAggDO;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.i.IOverviewCudService;
import iih.pi.overview.overview.i.IOverviewRService;
import iih.pi.overview.overview.i.IPiPatAlDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 插入患者过敏史数据
 * 
 * @author ly 2016/09/09
 *
 */
public class PiInsertPatAlBp {

	/**
	 * 插入患者过敏史数据
	 * 
	 * @param dto
	 *            过敏dto
	 * @throws BizException
	 */
	public void exec(PatAlDTO[] dtos) throws BizException {

		this.validate(dtos);

		IPiPatAlDORService service = ServiceFinder.find(IPiPatAlDORService.class);

		String whereSql = "id_pat = '" + dtos[0].getId_pat() + "' " + "and dt_act = '" + dtos[0].getDt_act().toString() + "' ";

		String id_mms = arrayToStr(dtos,"Id_mm");
		String id_srvs = arrayToStr(dtos,"Id_srv");

		if (!StringUtil.isEmpty(id_mms)) {
			whereSql += "and id_mm in  (" + id_mms + ")";
		}
		
		if (!StringUtil.isEmpty(id_srvs)) {
			whereSql += "and id_srv in  (" + id_srvs + ")";
		}

		// 同日同物品服务校验
		PiPatAlDO[] alDos = service.find(whereSql, "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(alDos))
			return;

		IOverviewRService orService = ServiceFinder.find(IOverviewRService.class);
		IOverviewCudService ocService = ServiceFinder.find(IOverviewCudService.class);

		OverviewAggDO aggDo = orService.findById(dtos[0].getId_pat());
		PiPatAlDO[] oldAlDos = aggDo.getPiPatAlDO();
		List<PiPatAlDO> alList = new ArrayList<PiPatAlDO>();

		if (!ArrayUtil.isEmpty(oldAlDos)) {
			alList.addAll(Arrays.asList(oldAlDos));
		}

		List<PiPatAlDO> pipatAlList = getAlDoS(dtos);
		alList.addAll(pipatAlList);

		aggDo.setPiPatAlDO(alList.toArray(new PiPatAlDO[alList.size()]));

		aggDo.getParentDO().setStatus(DOStatus.UPDATED);
		ocService.save(new OverviewAggDO[] { aggDo });
		// service.insert(alDo);
	}

	/**
	 * 简单校验
	 * 
	 * @param dto
	 * @throws BizException
	 */
	private void validate(PatAlDTO[] dtos) throws BizException {

		if (dtos == null || dtos.length < 1) {
			throw new BizException("过敏史保存：参数不能为空");
		}

		for (PatAlDTO patAlDTO : dtos) {
			if (StringUtil.isEmpty(patAlDTO.getId_pat())) {
				throw new BizException("患者id不能为空");
			}

			if (patAlDTO.getDt_act() == null) {
				throw new BizException("发生日期不能为空");
			} else {
				// 去掉时分秒
				//FDateTime newTime = new FDateTime(patAlDTO.getDt_act().getDate().toString() + " 00:00:00");
				//patAlDTO.setDt_act(newTime);
			}
		}

		/*
		 * if(StringUtil.isEmpty(dto.getId_mm())){ throw new
		 * BizException("物品id不能为空"); }
		 */
	}

	/**
	 * 数组变为值字符串
	 * 
	 * @param items
	 *            某项多个值
	 * @return
	 */
	public String arrayToStr(PatAlDTO[] dtos,String column) {

		if (ArrayUtil.isEmpty(dtos)) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (PatAlDTO item : dtos) {
			
			String value = (String)item.getAttrVal(column);
			if (StringUtil.isEmpty(value)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", value));
		}
		return builder.toString();
	}

	/**
	 * 创建过敏史实体
	 * @return
	 * @throws BizException 
	 */
	private List<PiPatAlDO> getAlDoS(PatAlDTO[] dtos) throws BizException{
		List<PiPatAlDO> pipatAlList = new ArrayList<PiPatAlDO>();
		
		// 过敏分类获取
		List<String> qrySrv=Lists.newArrayList();
		List<String> qryMm=Lists.newArrayList();
		
		
		for (PatAlDTO dto : dtos) {
			if( StringUtils.isNotEmpty(dto.getId_mm()) && !dto.getId_mm().equals("~"))
				qryMm.add(dto.getId_mm());
			else if( StringUtils.isNotEmpty(dto.getId_srv())) 
				qrySrv.add(dto.getId_srv());
		}
		
		Map<String,String[]> retMap=analysisAltp(qryMm, qrySrv);
		

		
		for (PatAlDTO dto : dtos) {
			PiPatAlDO alDo = this.createAlDo(dto,retMap);
			pipatAlList.add(alDo);
		}
		
		return pipatAlList;
	}
	
	/**
	 * 分析物品过敏类型
	 * 
	 * @param mmId
	 * @throws BizException
	 */
	private Map<String,String[]> analysisAltp(List<String> qryMm,List<String> qrySrv) throws BizException {

		Map<String,String[]> ret=Maps.newHashMap();
		
		DAFacade df=new DAFacade();
		
		List<SrvSkinTestRelDO> l1=null;
		if(qryMm.size()>0){
		  l1=(List<SrvSkinTestRelDO>) df.findByAttrValStrings(SrvSkinTestRelDO.class, 
					SrvSkinTestRelDO.ID_MM, qryMm.toArray(new String[0]), 
					new String[]{SrvSkinTestRelDO.ID_ALTP,SrvSkinTestRelDO.SD_ALTP});
		  
		  if(l1!=null && l1.size()>0){
			  for(SrvSkinTestRelDO do1:l1)
			  ret.put(do1.getId_mm(), new String[]{do1.getId_altp(),do1.getSd_altp()} );
		  }
		}
		
		if(qrySrv.size()>0){
			  l1=null;
			  l1=(List<SrvSkinTestRelDO>) df.findByAttrValStrings(SrvSkinTestRelDO.class, 
						SrvSkinTestRelDO.ID_SRV, qrySrv.toArray(new String[0]), 
						new String[]{SrvSkinTestRelDO.ID_ALTP,SrvSkinTestRelDO.SD_ALTP});
			  
			  if(l1!=null && l1.size()>0){
				  for(SrvSkinTestRelDO do1:l1)
				  ret.put(do1.getId_srv(), new String[]{do1.getId_altp(),do1.getSd_altp()} );
			  }
			}
		
		return ret;
	}
	
	/**
	 * 转换过敏史do
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private PiPatAlDO createAlDo(PatAlDTO dto, Map<String,String[]> altps) throws BizException {
		PiPatAlDO alDo = new PiPatAlDO();
		alDo.setId_pat(dto.getId_pat());
		alDo.setDt_act(dto.getDt_act());
		alDo.setId_ymd_act(DataAct.D);
		// 分析物品过敏分类
		if(!StringUtil.isEmpty(dto.getId_alcla())){
			alDo.setId_alcla(dto.getId_alcla());
			alDo.setSd_alcla(dto.getSd_alcla());
		}else{
			this.analysisAlcla(dto.getId_mm(), alDo);
		}
		
		// 分析 过敏类型
		String cid=null;
		if( StringUtils.isNotEmpty(dto.getId_mm()) && !dto.getId_mm().equals("~"))
		  cid= dto.getId_mm();
		else 
		  cid=dto.getId_srv();
		
		if(cid!=null && altps.containsKey(cid) ){
			String[] arr=altps.get(cid);
			
			if(arr!=null && arr.length>0){
				alDo.setId_altp(arr[0]);
				alDo.setSd_altp(arr[1]);
			}
		}
		
		
		alDo.setId_mm(dto.getId_mm());
		alDo.setId_srv(dto.getId_srv());
		alDo.setDes_alcla(dto.getDes());
		alDo.setId_or(dto.getId_or());

		if (Degree.GENARAL.equals(dto.getDegree())) {
			alDo.setId_aldeg(IPiDictCodeConst.ID_ALDEG_GENARAL);
			alDo.setSd_aldeg(IPiDictCodeConst.SD_ALDEG_GENARAL);
		} else if (Degree.MODERATE.equals(dto.getDegree())) {
			alDo.setId_aldeg(IPiDictCodeConst.ID_ALDEG_MODERATE);
			alDo.setSd_aldeg(IPiDictCodeConst.SD_ALDEG_MODERATE);
		} else if (Degree.SERIOUS.equals(dto.getDegree())) {

			alDo.setId_aldeg(IPiDictCodeConst.ID_ALDEG_SERIOUS);
			alDo.setSd_aldeg(IPiDictCodeConst.SD_ALDEG_SERIOUS);
		}

		alDo.setStatus(DOStatus.NEW);
		return alDo;
	}

	
	/**
	 * 分析物品过敏分类
	 * 
	 * @param mmId
	 * @throws BizException
	 */
	private void analysisAlcla(String mmId, PiPatAlDO alDo) throws BizException {

		// 目前设置默认值，以后有知识库了可以智能分析
		alDo.setId_alcla(IPiDictCodeConst.ID_ALCLA_DEFAULT);
		alDo.setSd_alcla(IPiDictCodeConst.SD_ALCLA_DEFAULT);
		alDo.setName_alcla(IPiDictCodeConst.NAME_ALCLA_DEFAULT);
		
	}
	
	
}
