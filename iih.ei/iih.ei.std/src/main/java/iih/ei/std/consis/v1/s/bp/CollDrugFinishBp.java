package iih.ei.std.consis.v1.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.utils.WsXmlUtils;
import iih.ei.std.consis.v1.d.CollDrugFinishParam;
import iih.ei.std.consis.v1.d.CollDrugFinishPres;
import iih.ei.std.consis.v1.d.CollDrugFinishResult;
import iih.ei.std.consis.v1.i.ICDMWebService;
import iih.mp.dg.i.IMpDgOpMainService;
import iih.mp.dg.ws.log.utils.WebServiceLog;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 配药完成业务逻辑
 * 
 * @author hao_wu 2018-12-13
 *
 */
public class CollDrugFinishBp {

	/**
	 * 错误返回码
	 */
	protected static String CODE_ERR = "-1";

	/**
	 * 成功返回码
	 */
	protected static String CODE_SUCC = "1";

	public String exec(String paramXml) {

		CollDrugFinishResult resultDto = new CollDrugFinishResult();
		// 第三方要求必须是 1
		resultDto.setVal_rtn("1");

		WebServiceLog log = new WebServiceLog(ICDMWebService.class.getName());
		try {
			log.begin(paramXml);

			CollDrugFinishParam param = WsXmlUtils.deSerializeBaseDO(paramXml, CollDrugFinishParam.class);
			if (StringUtils.isEmpty(param.getCode_emp_colldrug())) {
				throw new BizException("配药药师编号为空。");
			}

			String[] presIds = getPresIds(param);
			String psnId = findPsnIdByCode(param.getCode_emp_colldrug());

			IMpDgOpMainService mpDgOpMainService = ServiceFinder.find(IMpDgOpMainService.class);
			mpDgOpMainService.collDrugFinish(presIds, psnId, AppUtils.getServerDateTime());

			resultDto.setCode_rtn(CollDrugFinishBp.CODE_SUCC);
			String msg = String.format("处方 %s 处方配药状态更新成功", StringUtils.join(presIds, ","));
			resultDto.setMsg(msg);
		} catch (BizException e) {
			resultDto.setCode_rtn(CollDrugFinishBp.CODE_ERR);
			resultDto.setMsg(e.getMessage());
		} catch (Exception e) {
			resultDto.setCode_rtn(CollDrugFinishBp.CODE_ERR);
			resultDto.setMsg(ExceptionUtils.getFullStackTrace(e));
		}

		String resultXml = WsXmlUtils.serialize(resultDto, true);
		log.end(resultXml);
		return resultXml;
	}

	/**
	 * 获取所有处方主键集合
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	protected String[] getPresIds(CollDrugFinishParam param) throws BizException {
		ArrayList<String> presIdList = new ArrayList<String>();

		CollDrugFinishPres[] press = param.getPress();
		if (press == null || press.length <= 0) {
			throw new BizException("处方列表为空。");
		}

		for (CollDrugFinishPres pres : press) {
			if (StringUtils.isNotEmpty(pres.getId_pres())) {
				presIdList.add(pres.getId_pres());
			}
		}

		if (presIdList.size() <= 0) {
			throw new BizException("处方编号列表为空。");
		}

		return presIdList.toArray(new String[0]);
	}

	@SuppressWarnings("unchecked")
	protected String findPsnIdByCode(String code_emp_colldrug) throws BizException {
		DAFacade daFacade = new DAFacade();
		ArrayList<PsnDocDO> psnDocDoList = (ArrayList<PsnDocDO>) daFacade.findByAttrValString(PsnDocDO.class,
				PsnDocDO.CODE, code_emp_colldrug, new String[] { PsnDocDO.ID_PSNDOC });
		if (psnDocDoList == null || psnDocDoList.size() <= 0) {
			String msg = String.format("根据配药药师编号查询配药药师信息失败，配药药师编号：%s。", code_emp_colldrug);
			throw new BizException(msg);
		}
		return psnDocDoList.get(0).getId_psndoc();
	}

}
