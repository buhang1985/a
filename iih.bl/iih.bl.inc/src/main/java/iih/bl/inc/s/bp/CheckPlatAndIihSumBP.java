package iih.bl.inc.s.bp;

import iih.bl.inc.dto.blelecbillcheckdto.d.CheckTotalDataDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.d.EcIncTotalChkOutDTO;
import iih.ei.bl.ecinc.i.IEcIncManageService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;

/**
 * 核对平台和iih的电子票据的总票数和总金额
 * @author dk.jiang
 *
 */
public class CheckPlatAndIihSumBP {
	public CheckTotalDataDTO exec(QryRootNodeDTO qry) throws BizException{
		
		if (null == CheckElecBillBP.blInc0012 || "".equals(CheckElecBillBP.blInc0012)) {
			throw new BizException("异常：获取不到发票领退管理模式参数BLINC0012值");
		}
		
		//1.查询iih总开票数，总金额数据
		CheckTotalDataDTO iihTotalData = this.getIIhTotalData(qry);
		
		//2.调用客开，查询发票平台的总开票数，总金额
		//EcIncTotalChkOutDTO thridTotalData = this.getThridTotalData();
		EcIncTotalChkOutDTO thridTotalData = new EcIncTotalChkOutDTO();
		
		//3.封装数据返回
		CheckTotalDataDTO result = this.proccessResult(iihTotalData, thridTotalData);
		
		return result;
	}
	
	/**
	 * 调用第三方获取总开票和总金额
	 * @return
	 * @throws BizException
	 */
	private EcIncTotalChkOutDTO getThridTotalData() throws BizException {
		CheckTotalDataDTO dto = new CheckTotalDataDTO();
		dto.setBgbusdate(new FDateTime(CheckElecBillBP.dtIncBegin));
		dto.setEndbusdate(new FDateTime(CheckElecBillBP.dtIncEnd));
		dto.setPlacecode(CheckElecBillBP.point);
		dto.setEudirect(Integer.valueOf(CheckElecBillBP.euDirect));
		IEcIncManageService service = ServiceFinder.find(IEcIncManageService.class);
		EcIncResultDTO<EcIncTotalChkOutDTO> tridTotalData = service.qryTridTotalData(dto);
		if (FBoolean.TRUE.equals(tridTotalData.getFg_success())) {
			return tridTotalData.getData();
		}else {
			return null;
		}
	}

	/**
	 * 结果的处理
	 * @param iihTotalData
	 * @param thridTotalData 
	 * @return 
	 * @throws BizException 
	 */
	private CheckTotalDataDTO proccessResult(CheckTotalDataDTO iihTotalData, EcIncTotalChkOutDTO thridTotalData) throws BizException {
		CheckTotalDataDTO result = new CheckTotalDataDTO();
		String iihPointName = CheckElecBillBP.qryPointName();
		if (null != iihTotalData) {
			/**
			 * IIH系统数据
			 */
			result.setBgbusdate(new FDateTime(CheckElecBillBP.dtIncBegin));
			result.setEndbusdate(new FDateTime(CheckElecBillBP.dtIncEnd));
			result.setTotalnum(iihTotalData.getTotalnum());
			result.setTotalamt(iihTotalData.getTotalamt());
			result.setPlacecname(iihPointName);
		}
		
		if (null != thridTotalData) {
			/**
			 * 电子发票平台数据
			 */
			result.setTrid_bgbusdate(new FDateTime(CheckElecBillBP.dtIncBegin));
			result.setTrid_endbusdate(new FDateTime(CheckElecBillBP.dtIncEnd));
			result.setTrid_totalnum(thridTotalData.getAllTotalNum());
			result.setTrid_totalamt(thridTotalData.getAllTotalAmt());
			result.setTrid_placecname(iihPointName);
			//result.setTrid_placecname(thridTotalData.getTrid_placecname());
		}
		return result;
	}

	/**
	 * 查询iih总金额、总开票数
	 * @param qry 
	 * @return
	 * @throws BizException 
	 */
	private CheckTotalDataDTO getIIhTotalData(QryRootNodeDTO qry) throws BizException {
		
		String whereSql = CheckElecBillBP.processQryRootNode(qry);
		String qryIIhTotalSql = this.getQryIIhTotalSql(whereSql);
		return (CheckTotalDataDTO)new DAFacade().execQuery(qryIIhTotalSql, 
				new BeanHandler(CheckTotalDataDTO.class));
	}

	/**
	 * 计算总金额和总发票数的sql初始化
	 * @param whereSql 
	 * @param sql
	 * @return
	 */
	public String getQryIIhTotalSql(String whereSql){
		//获取参数
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" SUM(AMT_RATIO * EU_DIRECT) AS totalamt, ");
		sb.append(" COUNT(1) AS totalnum ");
		sb.append(" FROM ");
		sb.append(" ( SELECT inc.ID_INCOEP AS ID,  ");
		sb.append(" inc.EU_DIRECT, inc.AMT_RATIO ");
		sb.append(" FROM BL_INC_OEP inc ");
		appendPubSql(sb, whereSql);
		
		sb.append(" UNION ALL ");
		
		sb.append(" SELECT inc.ID_INCIP AS ID, ");
		sb.append(" inc.EU_DIRECT, inc.AMT_RATIO ");
		sb.append(" FROM BL_INC_IP inc ");
		appendPubSql(sb, whereSql);
		sb.append(" ) ");
		
		String resultSql = sb.toString();
		return resultSql;
	}
	
	/**
	 * SQL公共部分
	 * @param sb
	 * @param whereStr
	 */
	private void appendPubSql(StringBuilder sb, String whereStr) {
		sb.append(" left join bd_psndoc ps  ");
		sb.append(" on ps.id_psndoc = inc.id_emp_inc  ");
		sb.append(" left join bd_pc pc  ");
		sb.append(" on pc.id_pc = inc.id_pc ");
		sb.append(" WHERE " + whereStr);
	}
	
}
