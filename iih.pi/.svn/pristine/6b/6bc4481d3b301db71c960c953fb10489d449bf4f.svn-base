package iih.pi.overview.s.bp;

import iih.pi.overview.dto.d.PatAlDTO;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.s.PiPatAlDOCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 删除患者过敏史数据
 * @author ly 2017/03/07
 *
 */
public class PiDeletePatAlBp {

	/**
	 * 删除患者过敏史数据
	 * @param dto 过敏dto
	 * @throws BizException
	 */
	public void exec(PatAlDTO dto) throws BizException {
		
		this.validate(dto);
		
		PiPatAlDOCrudServiceImpl service = new PiPatAlDOCrudServiceImpl();
		
		String whereSql = "id_pat = '" + dto.getId_pat() + "' "
				+ "and dt_act = '" + dto.getDt_act().toString() + "' ";
		
		if(!StringUtil.isEmpty(dto.getId_mm())){
			whereSql += "and id_mm = '" + dto.getId_mm() + "'";
		}
		
		if(!StringUtil.isEmpty(dto.getId_srv())){
			whereSql += "and id_srv = '" + dto.getId_srv() + "'";
		}
		
		//同日同物品
		PiPatAlDO[] alDos = service.find(whereSql, "", FBoolean.FALSE);
		if(!ArrayUtil.isEmpty(alDos))
			return;
		
		for (PiPatAlDO piPatAlDO : alDos) {
			piPatAlDO.setStatus(DOStatus.DELETED);
		}
		
		service.delete(alDos);
	}
	
	/**
	 * 简单校验
	 * @param dto
	 * @throws BizException
	 */
	private void validate(PatAlDTO dto) throws BizException {
		
		if(StringUtil.isEmpty(dto.getId_pat())){
			throw new BizException("患者id不能为空");
		}
		
		if(dto.getDt_act() == null){
			throw new BizException("发生日期不能为空");
		}else{
			//去掉时分秒
			FDateTime newTime = new FDateTime(
					dto.getDt_act().getDate().toString() + " 00:00:00");
			dto.setDt_act(newTime);
		}
	}
}
