package iih.bd.srv.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDOCudService;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.bd.srv.dto.d.BddicaDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 门急诊诊断分类 MS002
 * @author li_zheng
 *
 */
public class BdDiCaListener implements IBusinessListener {
	@Override
	@SuppressWarnings("unchecked")
	public void doAction(IBusinessEvent event) throws BizException {
		
   if(!(event.getSourceID().equals("iih.bd.srv.dto.d.BddicaDTO")))return;
		
		FArrayList2 bizUserObj = (FArrayList2) event.getUserObject();
		
		if(bizUserObj == null || bizUserObj.size() ==0) return;
		BddicaDTO[] list = (BddicaDTO[]) bizUserObj.toArray(new BddicaDTO[]{});
		this.saveBddicaDTOInfo(list);
	}

	/**
	 * 
	 * @param list
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void saveBddicaDTOInfo(BddicaDTO[] list) throws BizException{
		 List<DiagDefDO> listDiagDefDO = new ArrayList<DiagDefDO>();
		 Map<String,BddicaDTO> diagDeleteMap =new HashMap<String,BddicaDTO>();
		 Map<String,BddicaDTO> diagupdateMap =new HashMap<String,BddicaDTO>();
		
		IDiagdefMDORService rService = ServiceFinder.find(IDiagdefMDORService.class);
		IDiagdefMDOCudService CudService = ServiceFinder.find(IDiagdefMDOCudService.class);
		for(BddicaDTO dto : list){
			DiagDefDO diagDefDO = new DiagDefDO();
			if("insert".equals(dto.getAction())){
				diagDefDO.setCode(dto.getCode());
				diagDefDO.setName(dto.getName());
				diagDefDO.setPycode(dto.getPycode());
				diagDefDO.setFg_active(FBoolean.TRUE);
				diagDefDO.setId_grp(Context.get().getOrgId());
				diagDefDO.setId_org(Context.get().getOrgId());
				//diagDefDO.setId_cdsys("0001Z7100000000GFT58");
				//diagDefDO.setSd_cdsys("11");
				diagDefDO.setId_cdsystp(ICiDictCodeConst.ID_CI_DISYS_XYZDTX);
				diagDefDO.setSd_cdsystp(ICiDictCodeConst.SD_CI_DISYS_XYZDTX);
				diagDefDO.setStatus(DOStatus.NEW);
				listDiagDefDO.add(diagDefDO);
			}else if("update".equals(dto.getAction())){
				diagupdateMap.put(dto.getCode(),dto);
			}else if("delete".equals(dto.getAction())){
				diagDeleteMap.put(dto.getCode(),dto);
			} 
		}
		if(listDiagDefDO != null && listDiagDefDO.size() >0){
			CudService.save(listDiagDefDO.toArray(new DiagDefDO[listDiagDefDO.size()]));
		}
		 if(diagupdateMap != null && diagupdateMap.size() >0){
			 handleDiagDefDOUpdate(diagupdateMap,rService,CudService);
		 }
		 if(diagDeleteMap != null && diagDeleteMap.size() >0){
			 handleDiagDefDODelte(diagupdateMap,rService,CudService);
		 }
	}
	
	private void handleDiagDefDODelte(Map<String,BddicaDTO> map,IDiagdefMDORService rService,IDiagdefMDOCudService CudService)throws BizException{
		 String codes = "";
		 Iterator iterator = map.entrySet().iterator();
		 String[] code =map.keySet().toArray(new String[map.keySet().size()]);
		 String codeStr = getCodeStr(code);
		 if(codeStr != null && codeStr !=""){
			 DiagDefDO[] diagDefDO= rService.find(codeStr, "", FBoolean.FALSE);
			 if(diagDefDO != null){
				 for(DiagDefDO defDO:diagDefDO){
					 defDO.setStatus(DOStatus.DELETED);
				 }
				 CudService.save(diagDefDO);
			 } 
		 } 
	}
	

	private void handleDiagDefDOUpdate(Map<String,BddicaDTO> map,IDiagdefMDORService rService,IDiagdefMDOCudService CudService)throws BizException{
		 String codes = "";
		 Iterator iterator = map.entrySet().iterator();
		 String[] code =map.keySet().toArray(new String[map.keySet().size()]);
		 String codeStr = getCodeStr(code);
		 if(codeStr != null && codeStr !=""){
			 DiagDefDO[] diagDefDO= rService.find(codeStr, "", FBoolean.FALSE);
			 if(diagDefDO != null){
				 for(DiagDefDO defDO:diagDefDO){
					 if(map.containsKey(defDO.getCode())){
						 BddicaDTO dto=  map.get(defDO.getCode());
						 defDO.setName(dto.getName());
						 defDO.setStatus(DOStatus.UPDATED);
					 }
					
				 }
				 CudService.save(diagDefDO);
			 } 
		 } 
	}
	
     private String getCodeStr(String[] code){
		String id = "";
		if (code != null && code.length > 0) {
			for (String idpat : code) {
				id += ",'" + idpat + "'";
			}
		}
		if (id != "" && id.length() > 0) {
			return id.substring(1);
		}
		return "";
	}
      
}
