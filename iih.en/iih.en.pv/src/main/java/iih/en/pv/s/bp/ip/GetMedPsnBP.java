package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.pv.dto.d.MedPsnDTO;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.s.bp.GetEnPsnBP;
import xap.mw.core.data.BizException;

/**
 * 获取医护人员BP
 * @author renying
 *
 */
public class GetMedPsnBP {

	/**
	 * 根据就诊id查找医护人员
	 * @param entId 就诊id
	 * @return
	 * @throws BizException 
	 */
	public MedPsnDTO getMedPsn(String entId) throws BizException{
		MedPsnDTO medPsnDTO = new MedPsnDTO();	
		medPsnDTO.setId_ent(entId);
		GetEnPsnBP getEnPsnBP = new GetEnPsnBP();
		EnPsnDO docPsn = getEnPsnBP.exec(entId, IEnDictCodeConst.SD_EMPROLE_DOCTOR);//责任医师
		EnPsnDO zyPsn = getEnPsnBP.exec(entId, IEnDictCodeConst.SD_EMPROLE_ZYDOC);//住院
		EnPsnDO zzPsn = getEnPsnBP.exec(entId, IEnDictCodeConst.SD_EMPROLE_ZZDOC);//主治
		EnPsnDO zrPsn = getEnPsnBP.exec(entId, IEnDictCodeConst.SD_EMPROLE_ZRDOC);//主任
		EnPsnDO nurPsn = getEnPsnBP.exec(entId, IEnDictCodeConst.SD_EMPROLE_NURSE);//护士
				
		if(docPsn!=null)//责任医师
		{
			medPsnDTO.setId_emp_phy(docPsn.getId_emp());
			medPsnDTO.setName_emp_phy(docPsn.getName_psndoc());
			medPsnDTO.setSd_emp_phy(docPsn.getSd_psndoc());
		}
		
		if(zyPsn!=null)//住院医师
		{
			medPsnDTO.setId_zy_doc(zyPsn.getId_emp());
			medPsnDTO.setName_zy_doc(zyPsn.getName_psndoc());
			medPsnDTO.setSd_zy_doc(zyPsn.getSd_psndoc());
		}
		
		if(zzPsn!=null)//主治医师
		{
			medPsnDTO.setId_zz_doc(zzPsn.getId_emp());
			medPsnDTO.setName_zz_doc(zzPsn.getName_psndoc());
			medPsnDTO.setSd_zz_doc(zzPsn.getSd_psndoc());
		}
		
		if(zrPsn!=null)//主任医师
		{
			medPsnDTO.setId_zr_doc(zrPsn.getId_emp());
			medPsnDTO.setName_zr_doc(zrPsn.getName_psndoc());
			medPsnDTO.setSd_zr_doc(zrPsn.getSd_psndoc());
		}
		
		if(nurPsn!=null)//护士
		{
			medPsnDTO.setId_emp_nur(nurPsn.getId_emp());
			medPsnDTO.setName_emp_nur(nurPsn.getName_psndoc());
			medPsnDTO.setSd_emp_nur(nurPsn.getSd_psndoc());
		}
		
		return medPsnDTO;
	}
	
}
