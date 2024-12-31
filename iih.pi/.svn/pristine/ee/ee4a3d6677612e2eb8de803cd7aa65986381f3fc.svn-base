package iih.pi.reg.pat.s.impt;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.init.impt.BaseDataImport;
import xap.sys.init.impt.IDataImport;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 患者信息数据导入服务
 * 
 * @author ly
 *
 */
public class PiPatImportServiceImpl extends BaseDataImport<PatDO> implements IDataImport {

	@Override
	public boolean checkNotNull() throws BizException {
		// //1.取得数据
		// PatDO[] dos = getDOsFromImportDB(new PatDO(),"1=1",false);
		// if (ArrayUtil.isEmpty(dos))
		// throw new BizException("患者信息导入数据为空！");

		// 因数据量较大，改为sql校验
		CheckNullValue();

		// //2.非空校验
		// checkNullValue(Arrays.asList(PatDO.CODE,PatDO.NAME), dos);
		return true;
	}

	/**
	 * 检查空值
	 * 
	 * @throws BizException
	 */
	private void CheckNullValue() throws BizException {
		PatDO[] dos = getDOsFromImportDB(new PatDO(), "(code is null or name is null)", false);
		if (!ArrayUtil.isEmpty(dos)) {
			PatDO patDo = dos[0];
			String msg = null;
			if (StringUtils.isEmpty(patDo.getCode())) {
				msg = "患者信息中的编码不允许为空。";
			} else if (StringUtils.isEmpty(patDo.getName())) {
				msg = "患者信息中的名称不允许为空。";
			}
			if (StringUtils.isNotEmpty(msg)) {
				throw new BizException(msg);
			}
		}
	}

	/**
	 * 导入数据
	 */
	@Override
	public boolean importData() throws BizException {

		// 1.取得数据分页信息
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setPageSize(10000);
		paginationInfo.setPageIndex(0);
		PagingRtnData<PatDO> pageData = getDOsFromImportDBByPageInfo(new PatDO(), paginationInfo, "1=1", true);
		if (pageData.getPageData() == null || pageData.getPageData().size() <= 0)
			throw new BizException("患者信息导入数据为空！");

		for (int i = 0; i < pageData.getPagingInfo().getPageCount(); i++) {

			// 2.获取数据
			paginationInfo.setPageSize(10000);
			paginationInfo.setPageIndex(i);
			pageData = getDOsFromImportDBByPageInfo(new PatDO(), paginationInfo, "1=1", true);
			List<PatDO> patList = new ArrayList<PatDO>();
			for (Object obj : pageData.getPageData()) {

				patList.add((PatDO) obj);
			}

			// 3.设置status
			processDOs(patList.toArray(new PatDO[patList.size()]));

			// 4.数据插入目标库
			ServiceFinder.find(IPatiMDOCudService.class).insert(patList.toArray(new PatDO[patList.size()]));
		}

		return true;
	}

	/**
	 * 清除数据
	 */
	@Override
	public boolean cleanData() throws BizException {
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate("delete from pi_pat");// 删除患者数据
		daFacade.execUpdate("delete from pi_pat_acc");// 删除患者账户
		daFacade.execUpdate("delete from pi_pat_acc_act");// 删除患者账户操作明细
		return true;
	}

	@Override
	public String[] getImportTable() throws BizException {
		return new String[] { "pi_pat" };
	}
}
