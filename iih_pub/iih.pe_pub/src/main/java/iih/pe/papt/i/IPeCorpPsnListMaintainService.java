package iih.pe.papt.i;

import iih.pe.papt.dto.pecorpexceldto.d.PeCorpExcelDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.xapformula.vo.pub.formulaset.core.ParseException;

public interface IPeCorpPsnListMaintainService {

	/***
	 * 个人预约 用户信息查询
	 * @param pe
	 * @return
	 * @throws BizException
	 * @throws java.text.ParseException 
	 * @throws ParseException 
	 */
	
	//public abstract void selePePsnAptQry(PePsnAptQryDTO pe) throws BizException;
	
	
	public abstract PeCorpExcelDTO[] saveCorpExcelDtos(PeCorpExcelDTO[] dtos, String id_pecorpappt, String id_pecorpbinfo, String id_grp, String id_org, String id_user) throws BizException, ParseException, java.text.ParseException;
	public abstract PeCorpExcelDTO[] savePipat(PeCorpExcelDTO[] dtos, String id_pecorpappt, String id_pecorpbinfo, String id_grp, String id_org, String id_user) throws BizException, ParseException, java.text.ParseException;
}
