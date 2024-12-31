package iih.en.pv.s.bp.ip;

import iih.en.comm.ep.NbEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.dto.d.NewbornDTO;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
/**
 * 新增新生儿记录 
 * @author yhl
 *
 */
public class InsertNb4weightBP {

	/**
	 * 新增新生儿记录BP
	 * @param nbDTO
	 * @throws BizException 
	 */
	public void exec(NewbornDTO nbDTO) throws BizException{
		if(EnValidator.isEmpty(nbDTO.getId_ent_bb()))
			return;
		NbEP nbEp = new NbEP();
		NewbornDO nbDO = nbEp.getNbChild(nbDTO.getId_ent_bb());
		if(nbDO == null){
			nbDO = new NewbornDO();
			try {
	            BeanUtils.copyProperties(nbDO, nbDTO);
	        } catch (IllegalAccessException | InvocationTargetException e) {
	            throw new BizException("新增新生儿记录失败!");
	        }
			nbEp.insertNbDOs(new NewbornDO[] { nbDO });
		}else{
			nbDO.setStatus(DOStatus.UPDATED);
			nbDO.setWeight(nbDTO.getWeight());
			nbDO.setWeight_reg(nbDTO.getWeight_reg());
			nbDO.setHeight(nbDTO.getHeight());
			nbEp.updateNbDOs(new NewbornDO[] { nbDO });
		}
	}
}
