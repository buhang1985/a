package iih.ci.ord.s.bp.ordprn;

import org.apache.commons.lang.StringUtils;

import iih.bd.utils.ParamUtils;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.s.bp.ordprn.qry.GetOrdData4PrintQry;
import iih.ci.ord.s.bp.ordprn.ref.DefaultOrdPrintContentAssembleBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取已打印的医嘱数据
 * @author Young
 *
 */
public class GetOrdData4PrintBP {
	
	public OrdPrintDataDTO[] exec(OrdPrintParamDTO paramDTO) throws Exception {
		// 校验参数合法性
		if (!validateParam(paramDTO)) {
			throw new BizException("传递医嘱打印参数失败");
		}
		
		GetOrdData4PrintQry qry = new GetOrdData4PrintQry(paramDTO);
		OrdPrintDataDTO[] qryDTOs = (OrdPrintDataDTO[]) AppFwUtil.getDORstWithDao(qry, OrdPrintDataDTO.class);
		if (qryDTOs != null && qryDTOs.length > 0) {
			try{
				String refClass = getRefClass();
				if(StringUtils.isEmpty(refClass)){
					return defaultPrintDataAssemble(paramDTO, qryDTOs);
				}else{
					return (OrdPrintDataDTO[])RefPrnUtils.ReflectMethodInvoke(paramDTO,qryDTOs, refClass, "assemble");
				}
			}catch(Exception ex){
				return defaultPrintDataAssemble(paramDTO, qryDTOs);
			}
			
		}
		return qryDTOs;
	}
	private OrdPrintDataDTO[] defaultPrintDataAssemble(OrdPrintParamDTO paramDTO,OrdPrintDataDTO[] qryDTOs) throws Exception{
		DefaultOrdPrintContentAssembleBP bp = new DefaultOrdPrintContentAssembleBP();
		return bp.assemble(paramDTO, qryDTOs);
	}
	/**
	 * 获得处理打印单内容拼接的插件
	 * @return
	 */
	private String getRefClass(){
		try {
			return ParamUtils.GetOrgParamStringValue(ICiOrdNSysParamConst.SYS_PARAM_ORDPRN_REFINVOKE);
		} catch (BizException e) {
			return null;
		}
	}
	/**
	 * 验证参数是否正确
	 * @param printParam
	 * @return
	 */
	private boolean validateParam(OrdPrintParamDTO printParam) {

		return true;
	}
}
