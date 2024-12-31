package iih.ci.ord.s.ems.op.order.copy;

import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApDietDO;
import iih.ci.ord.cior.d.desc.OrdApDietDODesc;
import iih.ci.ord.cior.i.ICiorappdietCudService;
import iih.ci.ord.cior.i.ICiorappdietRService;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 膳食医嘱复制
 * @author HUMS
 *
 */
public class OrderTreatNutCopyBP extends OrderBaseCopyBP{
	
	private String Id_or;
	private ICiorappdietRService ciorappdietRService = null;
	private ICiorappdietCudService ciorappdietCudService = null;
	
	public OrderTreatNutCopyBP(){
		ciorappdietRService = (ICiorappdietRService)ServiceFinder.find(ICiorappdietRService.class);
		ciorappdietCudService = (ICiorappdietCudService)ServiceFinder.find(ICiorappdietCudService.class);
		
	}
	
	public String getId_or() {
		return Id_or;
	}

	public void setId_or(String id_or) {
		Id_or = id_or;
	}

	/**
	 * 复制膳食申请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		OrdApDietDO[] ordApDiets = getOrdApDiets(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(ordApDiets))
			return false;
		setOrdApDiets(ordApDiets, mapIdors,dt);
		return saveOrdApDiets(ordApDiets);
	}
	
	/**
	 * 查询OrdApDietDO
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	protected OrdApDietDO[] getOrdApDiets(String[] idors) throws BizException {
		
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		
		return ciorappdietRService.find(OrdApDietDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "",
						FBoolean.FALSE);
	}
	
	/**
	 * 设置OrdApDietDO
	 * @param ordApDiets
	 * @param mapIdors
	 * @throws BizException 
	 */
	private void setOrdApDiets(OrdApDietDO[] ordApDiets, Map<String, String> mapIdors, FDateTime dt) throws BizException{
		if (CiOrdUtils.isEmpty(ordApDiets))
			return;
		for (OrdApDietDO ordApDiet : ordApDiets) {
			ordApDiet.setId_apdiet(null);
			ordApDiet.setId_or(mapIdors.get(ordApDiet.getId_or()));
			this.setId_or(mapIdors.get(ordApDiet.getId_or()));
			//ordApDiet.setNo_applyform(this.getApplyNo(ordApDiet.getId_or()));
			ordApDiet.setNo_applyform(null);
			ordApDiet.setStatus(DOStatus.NEW);
			
		}
	}
	
	/**
	 * 保存OrdApDietDO
	 * @param ordApDiets
	 * @return
	 * @throws BizException
	 */
	private Boolean saveOrdApDiets(OrdApDietDO[] ordApDiets) throws BizException{
		if (CiOrdUtils.isEmpty(ordApDiets))
			return false;
		ordApDiets = ciorappdietCudService.save(ordApDiets);
		return !CiOrdUtils.isEmpty(ordApDiets);
	}

	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT);
	}

	@Override
	protected void setCopyCiEmsDTOInfo(CiEmsDTO ciEmsDTO) throws BizException {
		FMap map = ciEmsDTO.getOrapplysheet();
		if(map!=null){
			OrdApDietDO lab = (OrdApDietDO)map.get(EmsType.DIET.toString());
			if(lab!=null){
				lab.setStatus(DOStatus.NEW);
				lab.setId_apdiet(null);				
				lab.setId_or(null);
				lab.setNo_applyform(null);
			}
		}
	}
	
}
