package iih.ci.diag.dto.s.bp;

import iih.ci.diag.dto.d.DIDTO;
import iih.ci.diag.dto.s.qry.getMedicalRecordDiagQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 病案首页诊断显示	
 * 传入参数：@id_ent
 * 传出参数：诊断类别、诊断描述、疾病编码
 *  接口说明：
 *  查询CI_DI、CI_DI_ITM表，
 *  且CI_DI.eu_diproctp=‘3入院诊断’  或 ‘4  出院诊断’ 或 ‘5 死亡诊断’
 * @author li_zheng
 *
 */
public class getMedicalRecordDiagBP {
    
	   public DIDTO[] exec(String id_ent)throws BizException{
		   if(id_ent != null && id_ent != ""){
			   getMedicalRecordDiagQry qry = new getMedicalRecordDiagQry(id_ent); 
			   DIDTO[] rtn = (DIDTO[])AppFwUtil.getDORstWithDao(qry, DIDTO.class);
			   return rtn;
		   }
		   return null;
	   }
}
