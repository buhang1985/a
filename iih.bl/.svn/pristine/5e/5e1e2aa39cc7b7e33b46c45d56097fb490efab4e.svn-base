package iih.bl.cg.s.provide.en;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.dto.en.opaccount.d.BlCgReplaceEntDTO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 替诊时更新费用
 * @author ly 2019/11/18
 *
 */
public class BlCgUpdateCgWhenReplaceEntBP {

	/**
	 * 替诊时更新费用
	 * @param dto
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void exec(BlCgReplaceEntDTO dto) throws BizException{
		
		this.validate(dto);
		
		DAFacade daf = new DAFacade();
		List<BlCgItmOepDO> cgList = (List<BlCgItmOepDO>)daf.findByAttrValString(BlCgItmOepDO.class, BlCgItmOepDO.ID_ENT, dto.getId_ent_old(), null);
		if(ListUtil.isEmpty(cgList))
			return;
		
		Set<String> stIdSet = new HashSet<String>();
		IBlCgItmOepDOCudService cgService = ServiceFinder.find(IBlCgItmOepDOCudService.class);
		for (BlCgItmOepDO blCgItmOepDO : cgList) {
			
			if(!StringUtil.isEmpty(blCgItmOepDO.getId_stoep())){
				stIdSet.add(blCgItmOepDO.getId_stoep());
			}
			
			blCgItmOepDO.setId_ent(dto.getId_ent_new());
			blCgItmOepDO.setStatus(DOStatus.UPDATED);
		}
		
		cgService.update(cgList.toArray(new BlCgItmOepDO[0]));
		
		if(stIdSet.size() == 0)
			return;
		
		List<BlStOepDO> stList = (List<BlStOepDO>)daf.findByPKs(BlStOepDO.class, stIdSet.toArray(new String[0]));
		if(ListUtil.isEmpty(stList))
			return;
		
		for (BlStOepDO blStOepDO : stList) {
			if(!StringUtil.isEmpty(blStOepDO.getId_ent()) && blStOepDO.getId_ent().equals(dto.getId_ent_old())){
				blStOepDO.setId_ent(dto.getId_ent_new());
				blStOepDO.setStatus(DOStatus.UPDATED);
			}
		}
		
		IBlstoepCudService stService = ServiceFinder.find(IBlstoepCudService.class);
		stService.save(stList.toArray(new BlStOepDO[0]));
	}
	
	/**
	 * 校验
	 * @param dto
	 */
	private void validate(BlCgReplaceEntDTO dto) throws BizException{
		
		if(StringUtil.isEmpty(dto.getId_ent_old())){
			throw new ArgumentNullException("替诊时更新费用", "原就诊id");
		}
		
		if(StringUtil.isEmpty(dto.getId_ent_new())){
			throw new ArgumentNullException("替诊时更新费用", "新就诊id");
		}
	}
}
