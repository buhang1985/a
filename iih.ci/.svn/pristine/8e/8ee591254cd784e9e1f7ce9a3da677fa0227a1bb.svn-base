package iih.ci.diag.s;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.core.utils.ObjectUtils;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.i.ICidiagRService;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.diag.i.ICidiagMaintainService;
import iih.ci.diag.s.bp.DeleteCiDiagBP;
import iih.ci.diag.s.bp.SaveCiDiBP;
import iih.ci.diag.s.bp.SaveCiDiDtoBP;
import iih.ci.diag.s.bp.SaveLastDiagInThisRescueBP;
import iih.ci.diag.s.ip.bp.CancelCiDiagBP;
import iih.ci.diag.s.ip.bp.DeleteAndCancelIPCiDiagBP;
import iih.ci.diag.s.ip.bp.SaveIPCIDIagBP;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces={ICidiagMaintainService.class}, binding=Binding.JSONRPC)
public class CidiagMaintainServiceImpl implements ICidiagMaintainService{
	

	/**
	 * 诊断的保存 门诊
	 *
	 */
     @Override
	 public  DIDTO[] SaveCiDiDto(DIDTO[] diDTO,String des,CiEnContextDTO cienContextDTO)throws BizException{
    	 SaveCiDiDtoBP bp = new SaveCiDiDtoBP();
    	 return bp.exec(diDTO,des,cienContextDTO);
	 }
	
 
    
	
   /**
    * 诊断的保存  （包含事件）
    * @param CidiAggDO
    * @return
    * @throws BizException
    */
   @Override
   public  CidiagAggDO SaveCiDi(CidiagAggDO CidiAggDO)throws BizException{
	   SaveCiDiBP bp = new SaveCiDiBP();
	   return bp.exec(CidiAggDO);
   }
   
   /**
    * 删除诊断  门诊
    * @param ciDiagDo
    * @return
    * @throws BizException
    */
   @Override
   public  CidiagAggDO DeleteCiDiag(CiDiagDO ciDiagDo)throws BizException{
	   DeleteCiDiagBP bp = new DeleteCiDiagBP();
	   return bp.DeleteCiDiag(ciDiagDo);
	   
   }
   /**
    * 住院诊断作废
    * @param id_ent
    * @return
    * @throws BizException
    */
   @Override
   public CiDiagDO[]   CancelCiDiagDO(String id_di,String id_emp)throws BizException{
	   CancelCiDiagBP bp = new CancelCiDiagBP();
	   return bp.CancelCiDiagDO(id_di, id_emp);
   }

   /**
    * 住院诊断保存
    * @param diDTO
    * @param des
    * @param cienContextDTO
    * @return
    * @throws BizException
    */
	@Override
	public DIDTO[] SaveIPCiDiDto(DIDTO[] diDTO, String des,
			CiEnContextDTO cienContextDTO) throws BizException {
		SaveIPCIDIagBP bp = new SaveIPCIDIagBP();
		return bp.exec(diDTO, des, cienContextDTO);
	}
	
    /**
     * 删除和作废住院诊断（签署的诊断作废，未签署的删除）
     * @param ciDiagDo
     * @param id_emp
     * @return
     * @throws BizException
     */
	@Override
    public   CiDiagDO[] DeleteAndCancelIPCiDiag(CiDiagDO ciDiagDo,String id_emp)throws BizException{
		DeleteAndCancelIPCiDiagBP bp =new DeleteAndCancelIPCiDiagBP();
		return bp.DeleteAndCancelIPCiDiag(ciDiagDo, id_emp);
	}
	/**
     * 急诊抢救取本次抢救中前一次就诊的当前诊断保存
     * @param id_en
     * @return
     * @throws BizException
     */
	@Override
	public CidiagAggDO[] SaveLastDiagInThisRescue(String id_en, CiEnContextDTO ctx) throws BizException {
		SaveLastDiagInThisRescueBP bp=new SaveLastDiagInThisRescueBP();
		return bp.exec(id_en,ctx);
	}
	
	@Override
	public CiDiagItemDO[] GetCiDiagItemDOs(String id_en) throws BizException {
		CidiagAggDO[] cidiAggdos = ServiceFinder.find(ICidiagRService.class).find("a0.id_en = '" + id_en + "'", "a0.createdtime desc", FBoolean.FALSE);
		if (!ObjectUtils.isEmpty(cidiAggdos)) {
			CiDiagItemDO[] itemDOs = cidiAggdos[0].getCiDiagItemDO();
			if (!ObjectUtils.isEmpty(itemDOs)) {
				SqlParam sqlParam = new SqlParam();
				StringBuilder filters = new StringBuilder();
				for(CiDiagItemDO itemDO : itemDOs) {
					sqlParam.addParam(itemDO.getId_didef());
					filters.append(",?");
				}
				
				StringBuilder sql = new StringBuilder();
				sql.append("select id_didef,fg_active,fg_ur,fg_chronic from bd_di_def")
				.append(String.format(" where id_didef in (%s)", filters.substring(1)));
				List<Map<String, Object>> diMapList = (List<Map<String, Object>>) new DAFacade().execQuery(sql.toString(), sqlParam, new MapListHandler());
				if (diMapList != null && diMapList.size() > 0) {
					Map<String, FBoolean> mapDiActive = new HashMap<String, FBoolean>();
					Map<String, FBoolean> mapDiUr = new HashMap<String, FBoolean>();
					Map<String, FBoolean> mapDiChronic = new HashMap<String, FBoolean>();
					for (Map<String, Object> diMap : diMapList) {
						mapDiActive.put((String) diMap.get("id_didef"), new FBoolean("Y".equals(diMap.get("fg_active"))));
						mapDiUr.put((String) diMap.get("id_didef"), new FBoolean("Y".equals(diMap.get("fg_ur"))));
						mapDiChronic.put((String) diMap.get("id_didef"), new FBoolean("Y".equals(diMap.get("fg_chronic"))));
					}
					for(CiDiagItemDO itemDO : itemDOs) {
						itemDO.setFg_active(ObjectUtils.isEmpty(itemDO.getId_didef()) ? FBoolean.TRUE : mapDiActive.get(itemDO.getId_didef()));
						itemDO.setFg_ur(ObjectUtils.isEmpty(itemDO.getId_didef()) ? FBoolean.TRUE : mapDiUr.get(itemDO.getId_didef()));
						itemDO.setFg_chronic(ObjectUtils.isEmpty(itemDO.getId_didef()) ? FBoolean.TRUE : mapDiChronic.get(itemDO.getId_didef()));
					}
				}
			}
			return itemDOs;
		}
		return null;
	}
}
