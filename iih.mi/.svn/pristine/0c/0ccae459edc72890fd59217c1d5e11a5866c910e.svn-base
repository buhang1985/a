package iih.mi.verify.bp;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mi.biz.dto.verify.d.VerifyInputDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取智能审核就诊信息-中公网
 * @author hanjq 2019年4月9日
 *
 */
public class GetEntVerifyBP {
	/**
	 * 
	 * @param id_ent
	 * @return
	 * @author hanjq 2019年4月9日
	 * @throws BizException 
	 */
	public VerifyInputDTO exce(String id_ent) throws BizException{
		StringBuffer bf = new StringBuffer("SELECT DISTINCT ");
		bf.append(" ppt.ID_CODE || '-' Hpcard, PPT.ID_CODE Idcard,");
		bf.append(" nvl(hpent.HP_ENT_SERIAL_NO ,ent.code) code_ent ");
		bf.append(" FROM	EN_ENT ent ");
		bf.append(" INNER JOIN PI_PAT ppt ON PPT.id_pat = ENT.ID_pat ");
		bf.append(" LEFT JOIN(SELECT HP_ENT_SERIAL_NO ,ID_ENT FROM BL_HP_ENTCODE WHERE FG_ACTIVE = 'Y' AND ID_ENT = ? ORDER BY SV DESC) ");
		bf.append("  hpent on hpent.id_ent = ENT.ID_ENT ");
		bf.append("  WHERE ENT.ID_ENT = ? ");
		DAFacade daf = new DAFacade();
		SqlParam sp = new SqlParam();
		sp.addParam(id_ent);
		sp.addParam(id_ent);
		List<VerifyInputDTO> verifyInputDtos = (List<VerifyInputDTO>) daf.execQuery(bf.toString(), sp,new BeanListHandler(VerifyInputDTO.class));
		VerifyInputDTO inputDto = verifyInputDtos.get(0);//计算机ip和mac地址从C#获取
		PsnDocDO psn = ServiceFinder.find(IPsndocMDORService.class).findById(Context.get().getStuffId());
		inputDto.setCode_doc(psn.getCode());//当前提交的医师编号
		return inputDto;		
	}
	
	
}
