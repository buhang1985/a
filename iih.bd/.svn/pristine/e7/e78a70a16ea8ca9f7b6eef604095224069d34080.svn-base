package iih.bd.fc.s.bp.orpltpconfig;

import java.util.Arrays;

import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltpconfig.d.OrpltpDTO;
import iih.bd.fc.orpltpmtpara.d.OrpltpmtParaDO;
import iih.bd.fc.orpltpmtpara.i.IOrpltpmtparaRService;
import iih.bd.fc.s.bp.qry.GetOrpltpstaLeaveSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取闭环对应的闭环状态和闭环匹配参数信息
 * 
 * @author xuxing_2017年6月21日14:59:16
 *
 */
public class GetOrpltpInfoByIdBp {

	/**
	 * 主入口
	 * 
	 * @param id_orpltp
	 * @return
	 * @throws BizException
	 */
	public OrpltpDTO exec(String id_orpltp) throws BizException {

		// 1、基础校验
		validation(id_orpltp);

		// 2、获取闭环对应的全部闭环状态
		OrpltpStaDO[] staDOS = getOrpltpStaDOS(id_orpltp);

		// 3、获取闭环对应的匹配参数
		OrpltpmtParaDO[] paramDOS = getOrpltpmtParaDOS(id_orpltp);

		// 4、组装返回结果
		OrpltpDTO rtn = packageRtn(id_orpltp, staDOS, paramDOS);

		return rtn;
	}

	/**
	 * 基础校验
	 * 
	 * @param id_orpltp
	 * @throws BizException
	 */
	private void validation(String id_orpltp) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_orpltp)) {
			throw new BizException("参数空异常!");
		}
	}

	/**
	 * 获取闭环对应的全部闭环状态
	 * 
	 * @param id_orpltp
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaDO[] getOrpltpStaDOS(String id_orpltp) throws BizException {
		GetOrpltpstaLeaveSql sql=new GetOrpltpstaLeaveSql(id_orpltp);
		return (OrpltpStaDO[])AppFwUtil.getDORstWithDao(sql, OrpltpStaDO.class);
	}

	/**
	 * 获取闭环对应的匹配参数
	 * 
	 * @param id_orpltp
	 * @return
	 * @throws BizException
	 */
	private OrpltpmtParaDO[] getOrpltpmtParaDOS(String id_orpltp) throws BizException {
		IOrpltpmtparaRService findService = ServiceFinder.find(IOrpltpmtparaRService.class);
		return findService.findByAttrValString(OrpltpmtParaDO.ID_ORPLTP, id_orpltp);
	}

	/**
	 * 组装返回结果
	 * 
	 * @param id_orpltp
	 * @param staDOS
	 * @param paramDOS
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private OrpltpDTO packageRtn(String id_orpltp, OrpltpStaDO[] staDOS, OrpltpmtParaDO[] paramDOS) {

		OrpltpDTO rtn = new OrpltpDTO();
		rtn.setId_orpltp(id_orpltp);

		if (staDOS != null && staDOS.length > 0) {
			FArrayList arraySta = new FArrayList();
			arraySta.addAll(Arrays.asList(staDOS));
			rtn.setArray_sta(arraySta);
		}
		if (paramDOS != null && paramDOS.length > 0) {
			FArrayList arrayParam = new FArrayList();
			arrayParam.addAll(Arrays.asList(paramDOS));
			rtn.setArray_orpltpmt(arrayParam);
		}
		return rtn;
	}
}
