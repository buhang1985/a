package iih.en.pv.s.bp.ip;

import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/***
 * 母婴分床、合床
 * @author fanlq
 *
 */
public class UpdateBbSepaBP {
	/***
	 * 母婴分床、合床
	 * 
	 * @param originalBedDTO
	 * @param targetBedDTO
	 * @param fg_sepa
	 * @throws BizException
	 */
	public void exec(BedBigCardDTO originalBedDTO,BedBigCardDTO targetBedDTO,FBoolean fg_sepa) throws BizException{
		if(FBoolean.TRUE.equals(fg_sepa)){
			//母婴分床
			new UpdateMmBbSeparateBP().exec(originalBedDTO, targetBedDTO);
			return;
		}else{
			//母婴合并
			new UpdateMmBbMergeBP().exec(originalBedDTO);
			return;
		}
	}
}
