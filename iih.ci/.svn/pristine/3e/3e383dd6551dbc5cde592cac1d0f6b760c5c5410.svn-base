package iih.ci.ord.s.bp.ordprn;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 重整医嘱保存BP
 * @author Young
 *
 */
public class OrdPrintDOResetSaveBP {

	public void exec(OrdPrintParamDTO paramDTO, OrdPrintDO[] printDos) throws BizException {
		this.save(paramDTO, printDos);
	}

	/**
	 * 保存重整后的医嘱
	 * @param paramDTO
	 * @param printDos
	 * @return
	 * @throws BizException
	 */
	private String[] save(OrdPrintParamDTO paramDTO, OrdPrintDO[] printDos) throws BizException {
		this.updateSavedOrdPrintDO(paramDTO);
		return new DAFacade().insertDOs(printDos);
	}

	/**
	 * 将已经保存的打印医嘱状态设置为重整状态
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	private int updateSavedOrdPrintDO(OrdPrintParamDTO paramDTO) throws BizException {
		FDateTime serverTime = CiOrdAppUtils.getServerDateTime();
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.TRUE);
		param.addParam(serverTime);
		param.addParam(serverTime);
		param.addParam(serverTime);
		param.addParam(paramDTO.getId_en());
		param.addParam(FBoolean.FALSE);
		String sql = "update ci_or_prn set fg_reformed=?,dt_reform=?,modifiedtime=?,sv=? where ds<1 and id_en=? and fg_reformed=?";

		return new DAFacade().execUpdate(sql, param);

	}
}
